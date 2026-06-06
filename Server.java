import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is running...");

            HashMap<String, Integer> studentMarks = new HashMap<>();
            ArrayList<String> studentNames = new ArrayList<>();

            while (true) {
                Socket socket = serverSocket.accept();

                DataInputStream dis = new DataInputStream(socket.getInputStream());

                String id = dis.readUTF();  
                String name = dis.readUTF();
                int marks = dis.readInt();

                studentMarks.put(id, marks);
                studentNames.add(name);

                System.out.println("\n--- Student Record ---");
                System.out.println("Name: " + name);
                System.out.println("ID: " + id + " Marks: " + marks);

                dis.close();
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}