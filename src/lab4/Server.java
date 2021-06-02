package lab4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = Utils.getPORT();
    private static final String serverJournalPath = Utils.getServerJournalPath();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);

        int count = 0;
        while (true) {
            Socket clientSocket = serverSocket.accept();
            String str = "Client accepted " + ++count;
            System.out.println(str);
            log(str);

            OutputStreamWriter writer = new OutputStreamWriter(
                    clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String request = reader.readLine();
            log(request);
            String response = Utils.calculate(request);
            log(response);
            writer.write(response);
            writer.flush();

            writer.close();
            reader.close();
            clientSocket.close();
        }
    }

    public static void log(String str) throws IOException {
        try (FileWriter writer = new FileWriter(serverJournalPath, true); BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(str);
            bw.newLine();
            bw.flush();
        }
    }
}