/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcoms_package;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import sun.rmi.transport.Transport;

/**
 *
 * @author acer
 */
public class SMTP_Text {
    private static DataOutputStream dos;

     public SMTP_Text(String email) throws Exception
     {
          int delay = 1000;
          String user = "tempgarbo@gmail.com";
          String pass = "brandonbutler";
          
          String username = new String(Base64.getEncoder().encode(user.getBytes(StandardCharsets.UTF_8)));
          String password = new String(Base64.getEncoder().encode(pass.getBytes(StandardCharsets.UTF_8)));

          SSLSocket sock = (SSLSocket)((SSLSocketFactory)SSLSocketFactory.getDefault()).createSocket("smtp.gmail.com", 465);
          final BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
          (new Thread(new Runnable()
          {
               public void run()
               {
                    try
                    {
                         String line;
                         while((line = br.readLine()) != null)
                              System.out.println("SERVER: "+line);
                    }
                    catch (IOException e)
                    {
                         e.printStackTrace();
                    }
               }
          })).start();
          dos = new DataOutputStream(sock.getOutputStream());

          send("EHLO smtp.gmail.com\r\n");
          Thread.sleep(delay);
          send("AUTH LOGIN\r\n");
          Thread.sleep(delay);
          send(username + "\r\n");
          Thread.sleep(delay);
          send(password + "\r\n");
          Thread.sleep(delay);
          send("MAIL FROM:<tempgarbo@gmail.com>\r\n");
          //send("\r\n");
          Thread.sleep(delay);
          send("RCPT TO:<"+ email +">\r\n");
          Thread.sleep(delay);
          send("DATA\r\n");
          Thread.sleep(delay);
          send("Subject: Account verification for APU Library\r\n");
          Thread.sleep(delay);
          send("If you see this message, it means you have registered successfully!\r\n");
          Thread.sleep(delay);
          send(".\r\n");
          Thread.sleep(delay);
          send("QUIT\r\n");
     }

     private static void send(String s) throws Exception
     {
          dos.writeBytes(s);
          System.out.println("CLIENT: "+s);
     }
}
