package com.ceva.calcserver;

import com.ceva.io.Request;
import com.ceva.io.Response;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClass {

    public static void main(String[] args) {
        try{
            // 1. creamos server socket y escuchamos el puerto 8350
            ServerSocket serverSocket = new ServerSocket(8350);

            // 2. Mantenemos en ejecucion el server, escuchando conexiones
            while (true){
                // 2.1. aceptamos nuevas conexion al nuevo socket.
                Socket socket =     serverSocket.accept();
                System.out.println("New Connection!!");
                // 2.2 Leemos datos desde el nuevo socket
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                // Asignamos los datos leidos a un objeto Request
                Request req = (Request) in.readObject();
                System.out.println(req);

                // 2.3 creamos el objeto Response
                Response rep = new Response();

                // 2.4 - Handling data (analizamos operadores y operando)
                switch (req.getOper()){
                    // 2.5 Operadores soportados
                    case "+":
                        rep.setStatus("Ok");
                        rep.setValue(req.getOp1() + req.getOp2());
                        break;
                    case "-":
                        rep.setStatus("Ok");
                        rep.setValue(req.getOp1() - req.getOp2());
                        break;
                    case "*":
                        rep.setStatus("Ok");
                        rep.setValue(req.getOp1() * req.getOp2());
                        break;
                    case "^":
                        rep.setValue(Math.pow(req.getOp1(), req.getOp2()));
                        break;
                    case "sqrt":
                        if (req.getOp1() >= 0){
                            rep.setStatus("Ok");
                            rep.setValue(Math.sqrt(req.getOp1()));
                        }else{
                            rep.setStatus("Invalid operand. Must be equal or greater than 0");
                        }
                        break;
                    case "/":
                        if (req.getOp2() != 0){
                            rep.setStatus("Ok");
                            rep.setValue(req.getOp1() / req.getOp2());
                        }else{
                            rep.setStatus("Operand 2 must be greater than 0");
                        }
                        break;
                    default:
                        rep.setStatus("Invalid operator");
                }

                // 2.6 enviamos la respuesta al objeto sender
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(rep);
                socket.close();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
