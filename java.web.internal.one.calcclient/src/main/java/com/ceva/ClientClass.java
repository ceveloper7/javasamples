package com.ceva;

import com.ceva.io.Request;
import com.ceva.io.Response;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientClass {
    public static void main(String[] args) {
        try{
            // 1. leemos datos que ingresa el usuario
            Scanner scanner = new Scanner(System.in);
            String oper;
            Double op1, op2 = null;
            oper = scanner.nextLine();
            op1 = Double.parseDouble(scanner.nextLine());
            // 2. dependiendo del operador matematico, leemos el segundo operador.
            switch (oper){
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                    op2 = Double.parseDouble(scanner.nextLine());
                    break;
            }

            // 3. Creamos un Objecto Request con datos
            Request req = new Request(op1, op1, oper);

            // 4. Nos conectamos al CalcServer que escucha el puerto 8350
            Socket socket = new Socket("localhost", 8350);
            System.out.println("Connecting on server");
            // step 5 enviamos el objeto Request
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(req);
            // step 6 Recivimos una respuesta
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Response rep = (Response)in.readObject();
            // step 7 Imprimir el resultado.
            System.out.println(rep);

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
