package CNVP_Lab3_Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendReceive {
    public static void sendData(DatagramPacket receivedPacket, DatagramSocket socket, String received) throws Exception {
        InetAddress address = receivedPacket.getAddress();
        int port = receivedPacket.getPort();
        byte[] dataToSend = DataToSend.getDataToSend(received);
        DatagramPacket sendPacket = new DatagramPacket(dataToSend, dataToSend.length, address, port);
        socket.send(sendPacket);
    }

    public static DatagramPacket receiveData(DatagramSocket socket) throws IOException {
        byte[] dataToReceive = new byte[256];
        DatagramPacket receivePacket = new DatagramPacket(dataToReceive, dataToReceive.length);
        socket.receive(receivePacket);
        return receivePacket;
    }
}
