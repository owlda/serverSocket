import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(5555))
            {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                while(true){

                    String echo = input.readLine();
                    if(echo.equals("exit")){
                        break;
                    }
                    output.println("Echo from server: "+echo);
                }
            }
        catch (IOException ex){

            System.out.println("Server: "+ex.getMessage());
        }
    }
}
