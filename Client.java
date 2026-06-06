import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter ID: ");
            String id = sc.nextLine();  

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            // send data
            dos.writeUTF(id);
            dos.writeUTF(name);
            dos.writeInt(marks);

            dos.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}