package service;

import entity.Classroom;
import entity.User;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Abstract class for representing console user interaction
 */
public class ConsoleUI {
    private Scanner act = new Scanner(System.in);
    private final Service service = new Service();

    public void start() throws SQLException {

        while (true) {
            System.out.println("\t\t\tMenu\n"
                    + "\tChoose a number of action\n"
                    + "1. Read from table\n"
                    + "2. Add to table\n"
                    + "3. Delete from table\n"
                    + "4. Update in table\n"
                    + "5. Exit");

            switch (act.nextInt()) {
                case 1 -> menuActionRead();
                case 2 -> menuActionAdd();
                case 3 -> menuActionDelete();
                case 4 -> menuActionUpdate();
                case 5 -> System.exit(0);
                default -> System.out.println("Choose a number of action from the list above\n");
            }
        }
    }

    private void menuActionUpdate() throws SQLException {
        chooseTable("update in");
        switch (act.nextInt()) {
            case 1 -> {
                int id = getIdMessage();
                Classroom classroom = service.getClassroom(id);
                System.out.println("Classroom you've chosen: " + classroom);
                System.out.println("Input desired values for classroom in the next order: "
                        + "Building-number  Room-number  Square  User-id  Title\n");
                act = new Scanner(System.in);
                String[] fields = act.nextLine().split("  ");
                service.updateClassroom(id,
                        Integer.parseInt(fields[0]),
                        Integer.parseInt(fields[1]),
                        Double.parseDouble(fields[2]),
                        Integer.parseInt(fields[3]),
                        fields[4]);
            }
            case 2 -> {
                int id = getIdMessage();
                User user = service.getUser(id);
                System.out.println("User you've chosen: " + user);
                System.out.println("Input desired values for user in the next order: "
                        + "Full-name  Position  Age  Phone\n");
                act = new Scanner(System.in);
                String[] fields = act.nextLine().split("  ");
                service.updateUser(id,
                        fields[0],
                        fields[1],
                        Integer.parseInt(fields[2]),
                        Long.parseLong(fields[3]));
            }
        }
    }

    private void menuActionDelete() throws SQLException {
        chooseTable("delete from");
        switch (act.nextInt()) {
            case 1 -> service.deleteClassroom(getIdMessage());
            case 2 -> service.deleteUser(getIdMessage());
        }
    }

    private int getIdMessage() {
        System.out.print("Please specify an id of the element: ");
        return act.nextInt();
    }

    private void menuActionAdd() throws SQLException {
        chooseTable("add to");
        switch (act.nextInt()) {
            case 1 -> {
                System.out.println("Input desired values for classroom in the next order: "
                        + "Building-number  Room-number  Square  User-id  Title\n");
                act = new Scanner(System.in);
                String[] fields = act.nextLine().split("  ");
                service.addClassroom(Integer.parseInt(fields[0]),
                        Integer.parseInt(fields[1]),
                        Double.parseDouble(fields[2]),
                        Integer.parseInt(fields[3]),
                        fields[4]);
            }
            case 2 -> {
                System.out.println("Input desired values for user in the next order: "
                        + "Full-name  Position  Age  Phone\n");
                act = new Scanner(System.in);
                String[] fields = act.nextLine().split("  ");
                service.addUser(fields[0],
                        fields[1],
                        Integer.parseInt(fields[2]),
                        Long.parseLong(fields[3]));
            }
        }
    }

    private void menuActionRead() throws SQLException {
        chooseTable("read from");
        switch (act.nextInt()) {
            case 1 -> service.getClassrooms();
            case 2 -> service.getUsers();
        }
    }

    private void chooseTable(String s) {
        System.out.printf("You've chosen to %s table, next - choose table\n"
                + "1. Classrooms table\n"
                + "2. Users table\n", s);
    }
}
