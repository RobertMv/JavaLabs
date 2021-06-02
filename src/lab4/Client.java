package lab4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static final int PORT = Utils.getPORT();
    public static final String HOST = Utils.getHOST();
    public static final String clientJournalPath = Utils.getClientJournalPath();

    public static void main(String[] args) throws IOException {

        while (true) {
            Socket clientSocket = new Socket(HOST, PORT);

            OutputStreamWriter writer = new OutputStreamWriter(
                    clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            StringBuilder request = new StringBuilder();
            String input;
            Scanner in = new Scanner(System.in);

            do {
                input = in.nextLine();
                request.append(input);
                log(input);
            } while (!input.endsWith("="));

            writer.write(new String(request) + "\n");
            writer.flush();

            String response = reader.readLine();
            System.out.println(response);
            log(response);

            writer.close();
            reader.close();
            clientSocket.close();
        }

    }

    public static void log(String str) throws IOException {
        try (FileWriter writer = new FileWriter(clientJournalPath, true); BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(str);
            bw.newLine();
            bw.flush();
        }
    }
}