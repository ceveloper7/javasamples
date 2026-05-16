package com.ceva.calcserver;

import com.ceva.io.Request;
import com.ceva.io.Response;

import java.net.ServerSocket;

public class ServerClass {

    public static void main(String[] args) {
        try{
            // 1. creamos server socket y escuchamos el puerto 8350
            ServerSocket serverSocket = new ServerSocket(8350);

            // 2. Mantenemos en ejecucion el server, escuchando conexiones
            while (true){
                // 2.1. aceptamos nuevas conexion al nuevo socket.
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
