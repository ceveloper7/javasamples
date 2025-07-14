package sec4;

/**
 * Graficador de ecuaciones en modo texto
 * 1. Craer un espacio de memoria
 * 2. Generar el dibujo
 * 3. Mostrar el resultado en pantalla
 */
public class AHCharacterMatrixV2 {
    // espacio de memoria
    private char[][] canvas;

    // inicializar el canvas
    public AHCharacterMatrixV2(int cols, int rows){
        canvas = new char[rows][cols];
        clear();
    }

    private void clear(){
        for(int r = 0; r < canvas.length; r++){
            for (int c = 0; c < canvas[r].length; c++){
                canvas[r][c] = ' ';
            }
        }
    }

    public int getWidth(){
        return canvas[0].length;
    }

    public int getHeight(){
        return canvas.length;
    }

    /**
     * Guarda un caracter especifico en canvas de acuerdo a la coordenada deseada
     * @param col -> representa x
     * @param row -> representa y
     * @param value -> valor a ser guardado
     */
    private void setCharAt(int col, int row, char value){
        // validamos qpara evitar dibujar fuera de las dimensiones del canvas
        if((col < 0) || (col >= canvas[0].length) || (row < 0) || (row >= canvas.length))
            return; // do nothing

        canvas[row][col]= value;
    }

    public void rectangle(int x, int y, int width, int height){
        for (int row = y; row < (y + height); row++){
            setCharAt(x, row, '|');
            setCharAt(x+width, row, '|');
        }

        for(int col = x; col < (x + width); col++){
            setCharAt(col, y, '-');
            setCharAt(col, y + height, '-');
        }

        setCharAt(x, y, '+');
        setCharAt(x+width, y, '+');
        setCharAt(x, y+height, '+');
        setCharAt(x+width, y+height, '+');
    }

    // impresion del contenido del canvas
    public void println(){
        for(int row = 0; row < canvas.length; row++){
            System.out.println(canvas[row]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AHCharacterMatrixV2 graph = new AHCharacterMatrixV2(80,25);
        graph.rectangle(0,0, graph.getWidth()-1, graph.getHeight()-1);

        // draw seno function
        for(int i = 0; i < graph.getWidth(); i++){
            double value = Math.sin(Math.toRadians((2*360.0/ graph.getWidth()) * i));
            value = value * ((graph.getHeight()/2) - 2);
            graph.setCharAt(i, (int)(graph.getHeight()/2 - value), 'x');
        }

        //sample
        //graph.rectangle(10,10, 15,10);
        //graph.rectangle(20,5,15,10);
        graph.println();
    }
}
