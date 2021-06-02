package lab4;

import lab3.Util;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    public static final int PORT = Utils.getPORT();
    public static final String HOST = Utils.getHOST();
    public static final String clientJournalPath = Utils.getClientJournalPath();

    public static void main(String[] args) throws IOException {

        while(true){
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


/*
* private String name = null;

    public Client(String s) {
        this.name = s;
    }

    @Override
    public void run(){
        char[] readed = new char[READ_BUFFER_SIZE];
        StringBuffer strBuff = new StringBuffer();
        try{
            Socket socket = new Socket(HOST, PORT);
            InputStream in = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            while(true){
                int count = reader.read(readed, 0, READ_BUFFER_SIZE);
                if(count == -1) break;
                strBuff.append(readed, 0, count);
                Thread.yield();
            }
        } catch (UnknownHostException e) {
            System.err.println("Исключение: " + e.toString());
        } catch (IOException e) {
            System.err.println("Исключение: " + e.toString());
        }
        System.out.println("Клиент " + name + " прочёл: " + strBuff.toString());
    }
    public static void main(String[] args) {
        String name = "имя";
        for(int i = 1; i <= CLIENT_COUNT; i++){
            Client ja = new Client(name+i);
            Thread th = new Thread(ja);
            th.start();
        }
    }
* */