import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket extends Thread {
    private Socket socket;

    public ClientSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            while(true){
                String userInput = input.readLine();
                System.out.println("Client sent: " + userInput);
                if(userInput.equals("exit")){ break; }
                try{
                    Thread.sleep(2000);
                }
                catch (InterruptedException ex){ System.out.println("Session client error."); }
                output.println(userInput);
            }
        }
        catch (IOException ex){
            System.out.println("Error: "+ex.getMessage());
        }finally {
            try{
                socket.close();
            }catch (IOException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
}
