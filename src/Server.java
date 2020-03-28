import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(5555))
            {

                while(true){
                    new ClientSocket(serverSocket.accept()).start();
                }
            }
        catch (IOException ex){

            System.out.println("Server: "+ex.getMessage());
        }
    }
}
