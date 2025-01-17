package com.ceva.ch08.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.io.InputStream;

public class TestWebClientEasyMock {
    // Mock objects
    private ConnectionFactory factory;
    private InputStream stream;

    // inicializamos los mock objects
    @BeforeEach
    public void setUp() {
        factory = createMock("factory", ConnectionFactory.class);
        stream = createMock("stream", InputStream.class);
    }

    // definimis las expectativas
    @Test
    public void testGetContentOk()
            throws Exception {
        expect(factory.getData()).andReturn(stream);
        expect(stream.read()).andReturn(Integer.valueOf((byte) 'W'));
        expect(stream.read()).andReturn(Integer.valueOf((byte) 'o'));
        expect(stream.read()).andReturn(Integer.valueOf((byte) 'r'));
        expect(stream.read()).andReturn(Integer.valueOf((byte) 'k'));
        expect(stream.read()).andReturn(Integer.valueOf((byte) 's'));
        expect(stream.read()).andReturn(Integer.valueOf((byte) '!'));

        expect(stream.read()).andReturn(-1);
        stream.close();

        /**
         * Pasanos el mock de la fase donde registramos el metodo que esperamos que sea llamado a
         * donde probamos. Inicialmente mock solo registra lo que se supone que debe hacer y no
         * reaccionara si llama pero luego de llamar a replay usara el comportamiento registrado
         * cuando es llamado.
         */
        replay(factory);
        replay(stream);

        WebClient2 client = new WebClient2();

        // invocamos el metodo bajo prueba y afirmamos el resultado esperado
        String workingContent = client.getContent(factory);

        assertEquals("Works!", workingContent);
    }

    @Test
    public void testGetContentInputStreamNull() throws Exception {
        expect(factory.getData()).andReturn(null);

        replay(factory);
        replay(stream);

        WebClient2 client = new WebClient2();

        String workingContent = client.getContent(factory);

        assertNull(workingContent);
    }

    // simulamos una condicion donde no podemos cerrar el InputSteam
    // definimos una expectativa donde se llama al metodo close
    @Test
    public void testGetContentCannotCloseInputStream() throws Exception {
        expect(factory.getData()).andReturn(stream);
        expect(stream.read()).andReturn(-1);
        stream.close();
        // lanzamos una exception si la llamada ocurre
        expectLastCall().andThrow(new IOException("cannot close"));

        replay(factory);
        replay(stream);

        WebClient2 client = new WebClient2();
        String workingContent = client.getContent(factory);

        assertNull(workingContent);
    }



    @AfterEach
    public void tearDown() {
        verify(factory);
        verify(stream);
    }
}
