package CNVP_Lab3_Server;

import java.net.SocketException;

public class Main {
    public static void main (String [] args){
        try {
            boolean status = true;
            while (status){
                Server server = new Server();
                server.run(status);
            }

        } catch (SocketException exception) {
            exception.printStackTrace();
        }
    }
}
