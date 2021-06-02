package lab4;

import lab3.Util;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static final String serverJournalPath = Utils.getServerJournalPath();
    public static final int PORT = Utils.getPORT();

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

/*
* public static void main(String[] args) throws IOException {
        Server myServer = new Server();
        myServer.go();
    }

    public Server() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void go() {
        class Listener implements Runnable {
            final Socket socket;

            public Listener(Socket aSocket) {
                socket = aSocket;
            }

            @Override
            public void run() {
                try {
                    System.out.println("Слушатель запущен");
                    int count = 0;
                    OutputStream out = socket.getOutputStream();
                    OutputStreamWriter writer = new OutputStreamWriter(out);
                    PrintWriter printWriter = new PrintWriter(writer);
                    while (count < COUNT_TO_SEND) {
                        count++;
                        printWriter.print(((count > 1) ? "," : "") + "говорит " + count);
                        Thread.sleep(TIME_SEND_SLEEP);
                    }
                    printWriter.close();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Сервер запущен...");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                Listener listener = new Listener(socket);
                Thread thread = new Thread(listener);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
* */