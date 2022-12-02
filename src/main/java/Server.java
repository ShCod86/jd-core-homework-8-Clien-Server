import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 8088;
            try(ServerSocket serverSocket = new ServerSocket(port)) {
                while(true) {
                try(Socket socket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())))
                {
                    System.out.printf("New connection accepted. Port %d%n", socket.getPort());
                    final String name = in.readLine();

                    out.println(String.format("Hi %s, your port is %d", name, socket.getPort()));
                }
            }
        }
    }
}
