package CNVP_Lab3_Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    private DatagramSocket socket;

    public Server() throws SocketException {
        socket = new DatagramSocket(5548);
        System.out.println("socket os running");
    }

    public void run(boolean status) {

        try {
            DatagramPacket receivePacket = SendReceive.receiveData(socket);
            String received = new String(receivePacket.getData(), 0, receivePacket.getLength());
            if (status) {
                SendReceive.sendData(receivePacket, socket, received);
            } else {
                System.out.println("client ends connection");
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {                    //????????????
            socket.close();
        }
    }
}

