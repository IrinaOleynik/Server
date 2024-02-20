import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket clienSocket = new Socket("netology.homework", Server.PORT);
             PrintWriter writer = new PrintWriter(clienSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()))
        ) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(reader.readLine());
            writer.println(scanner.nextLine());
            System.out.println(reader.readLine());
            writer.println(scanner.nextLine());
            System.out.println(reader.readLine());
        } catch (IOException ex) {
            throw new RemoteException();
        }
    }
}
