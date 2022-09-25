package org.example.Protocol;

import org.example.models.Bank;
import org.example.models.Transaction;
import org.example.models.User;
import org.example.services.XMLHandlerTransaction;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException, JAXBException {
        Socket server = new Socket("localhost", 50001);
        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        OutputStream out = server.getOutputStream();


        Scanner scanner = new Scanner(System.in);

        // Make transaction:

        System.out.println("connected to the server....");
        Thread.sleep(2100);

        User user = new User();
        System.out.println("name:");
        user.setName(scanner.nextLine());
        System.out.println("passport: ");
        user.setPassport(scanner.nextLine());


        System.out.println("making transaction....");

        Transaction transaction1 = new Transaction();
        System.out.println("bank name: ");
        transaction1.setBankName(scanner.nextLine());
        System.out.println("Sum: ");
        transaction1.setSumm(Integer.parseInt(scanner.nextLine()));
        System.out.println("currency: ");
        transaction1.setCurrency(scanner.nextLine());
        transaction1.setUser(user);

        XMLHandlerTransaction xmlHandlerTransaction = new XMLHandlerTransaction("", transaction1);
        xmlHandlerTransaction.toXML(out);




        // ----------------------------

        /*
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
        Thread receiver = new Thread(new Runnable() {
            String msg;
            @Override
            public void run() {
                    try {
                        msg = in.readLine();
                        while (msg != null){
                            System.out.println("Server says: " + msg);
                            msg= in.readLine();
                        }

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

        });

        receiver.start();



    }
}