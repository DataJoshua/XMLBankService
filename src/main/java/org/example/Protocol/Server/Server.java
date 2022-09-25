package org.example.Protocol.Server;

import org.example.models.Transaction;
import org.example.services.XMLHandlerTransaction;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.jar.JarException;

public class Server {
    public static void main(String[] args) throws IOException, JAXBException {
        ServerSocket serverSocket = new ServerSocket(50001);
        Socket clientSocket = serverSocket.accept();
        System.out.println("client accepted");
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        OutputStream out = clientSocket.getOutputStream();
        String pathXMLAssets = "src/main/java/org/example/xmlAssets/";
        Scanner scanner = new Scanner(System.in);

        Thread receiver = new Thread(new Runnable() {
            String msg;
            @Override
            public void run() {
                try {

                    msg = in.readLine();
                    while (msg != null){
                        System.out.println(msg);
                        msg= in.readLine();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        receiver.start();




        /*

 XMLHandlerTransaction xmlHandlerTransaction = new XMLHandlerTransaction("", new Transaction());
        System.out.println("olaaaaa2");
        Transaction trans = xmlHandlerTransaction.fromXML(clientSocket.getInputStream());
        System.out.println("olaaaaa3");
        System.out.println(trans);


if(in.readLine() != null){
            XMLHandlerTransaction xmlHandlerTransaction = new XMLHandlerTransaction("", new Transaction());
            Transaction trans = xmlHandlerTransaction.fromXML(clientSocket.getInputStream());
            System.out.println(trans.getBankName());
        }




        Thread sender = new Thread(new Runnable() {
            String msg;
            @Override
            public void run() {
                try {
                    while(true){
                        msg = scanner.nextLine();
                        out.write((msg + "\n").getBytes(StandardCharsets.UTF_8));
                    }
                } catch (IOException e) {throw new RuntimeException(e);}
            }

        });

        sender.start();







         */




    }
}
