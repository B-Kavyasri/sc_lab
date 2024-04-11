import java.net.*;
import java.io.*;

public class DHClient {
    public static void main(String[] args) {
        try {
            String pstr, gstr, Astr;
            String serverName= "localhost";
            int port = 8088;

            
            int p = 23;
            int g = 9;
            int a = 4;
            double Adash, serverB;

            
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);
            System.out.println("Just connected to " + client.getRemoteSocketAddress());

            
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            pstr = Integer.toString(p);
            out.writeUTF(pstr); 
            gstr = Integer.toString(g);
            out.writeUTF(gstr); 
            double A = (Math.pow(g, a)) % p; 
            Astr = Double.toString(A);
            out.writeUTF(Astr); 

            
            System.out.println("From Client: Private Key = " + a);

            
            DataInputStream in = new DataInputStream(client.getInputStream());

            
            serverB = Double.parseDouble(in.readUTF());
            System.out.println("From Server: Public Key = " + serverB);

            

            Adash = (Math.pow(serverB, a)) % p;
            System.out.println("Secret Key to perform Symmetric Encryption=" + Adash);
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
