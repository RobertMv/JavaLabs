package lab4;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Utils {
    // 10. 0 3 2 3 1 2
    // TCP
    // в клиенте указание адреса и порта сервера из файла настроек
    // указание порта для сервера из файла настроек
    // путь к журналу клиента из файла настроек
    // путь к журналу сервера с консоли ввода приложения

    /*
    Сервер возвращает клиенту результат выражения (допустимые операции «+», «-»).
Операнды и операции передаются за раз по одному (например, выражение «3.4+1.6-
5=» нужно передавать с помощью трёх сообщений: «3.4+», «1.6-» и «5=», где «=» -
признак конца выражения). В случае не возможности разобрать сервером полученную
строку или при переполнении, возникшем при вычислении полученного выражения,
сервер присылает клиенту соответствующее уведомление
    * */

    private static final int PORT = Integer.parseInt(getSettings().get("server-port"));
    private static final String HOST = getSettings().get("server-address");
    private static final String CLIENT_JOURNAL_PATH = getSettings().get("journal-path-client");
    private static final String SERVER_JOURNAL_PATH = getSettings().get("journal-path-server");

    static Map<String, String> getSettings() {
        String settingsFilePath = "lab4settings.txt";
        Path path = FileSystems.getDefault().getPath(settingsFilePath);
        try {
            return Files.lines(path)
                    .filter(s -> s.matches("^\\S+:\\w+"))
                    .collect(Collectors.toMap(k -> k.split(":")[0], v -> v.split(":")[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static String calculate(String task) {
//        ArrayList<String> splattedTask = new ArrayList<>();
//        StringTokenizer stringTokenizer = new StringTokenizer(task, "+-*/=", true);
//        while(stringTokenizer.hasMoreTokens())
//            splattedTask.add(stringTokenizer.nextToken());
//        Stack<Double> stack = new Stack<>();

        String[] operands = task.split("[+\\-*/=]");
        String[] operators = task.split("[0-9]+");

        double result = Double.parseDouble(operands[0]);

        for (int i = 1; i < operands.length; i++){
            switch (operators[i]) {
                case "+" -> result += Double.parseDouble(operands[i]);
                case "-" -> result -= Double.parseDouble(operands[i]);
                case "/" -> result /= Double.parseDouble(operands[i]);
                case "*" -> result *= Double.parseDouble(operands[i]);
            }
        }
        return String.valueOf(result);
    }

    public static int getPORT() {
        return PORT;
    }

    public static String getHOST() {
        return HOST;
    }

    public static String getClientJournalPath() {
        return CLIENT_JOURNAL_PATH;
    }

    public static String getServerJournalPath() {
        return SERVER_JOURNAL_PATH;
    }
}
