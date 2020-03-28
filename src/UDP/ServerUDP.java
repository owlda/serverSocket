package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerUDP {


    public static void main(String[] args) {
         try{
             DatagramSocket socket = new DatagramSocket(5000);
             System.out.println("Server start...");
             while(true){
                 byte[] buffer = new byte[250];
                 DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                 socket.receive(packet);
                 System.out.println("Data: " + new String(buffer));

                 String sendData = "some data";
                 byte[] bufferSend = sendData.getBytes();
                 InetAddress inetAddress = packet.getAddress();
                 int port = packet.getPort();
                 DatagramPacket datagramPacket = new DatagramPacket(buffer, bufferSend.length, inetAddress, port);
                 socket.send(datagramPacket);
             }

         }catch (SocketException ex){
             System.out.println("Socket Exception: "+ ex.getMessage());
         }catch (IOException e){
             System.out.println("IOException: "+ e.getMessage());
         }

    }
}
