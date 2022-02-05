package service;

import entity.Classroom;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Service class for processing results from database
 * and responding them to console UI
 */
public class Service extends JDBC{

    JDBC jdbc = new JDBC();

    void getClassrooms() throws SQLException {
        ArrayList<Classroom> classrooms = jdbc.getAllClassrooms();
        System.out.println("\nList of classrooms:");
        classrooms.forEach(System.out::println);
    }

    void getUsers() throws SQLException {
        ArrayList<User> users = jdbc.getAllUsers();
        System.out.println("\nList of users:");
        users.forEach(System.out::println);
    }

    void addUser(String fio, String position, int age, Long phone) throws SQLException {
        User user = new User(fio, position, phone, age);
        jdbc.createUser(user);
        System.out.println("User was added");
    }

    void addClassroom(int building, int roomNumber, Double square, int user, String name) throws SQLException {
        Classroom classroom = new Classroom(building, roomNumber, square, user, name);
        jdbc.createClassroom(classroom);
        System.out.println("Classroom was added");
    }

    void deleteUser(int id) throws SQLException {
        jdbc.deleteUserById(id);
        System.out.println("User has been deleted");
    }

    void deleteClassroom(int id) throws SQLException {
        jdbc.deleteClassroomById(id);
        System.out.println("Classroom has been deleted");
    }

    void updateUser(int id, String fio, String position, int age, Long phone) throws SQLException {
        User user = new User(id, fio, position, phone, age);
        jdbc.updateUser(user);
        System.out.println("User hac been updated");
    }

    User getUser(int id) throws SQLException {
        return jdbc.getUserById(id);
    }

    Classroom getClassroom(int id) throws SQLException {
        return jdbc.getClassroomById(id);
    }

    public void updateClassroom(int id, int building, int roomNumber, double square, int user, String field) throws SQLException {
        Classroom classroom = new Classroom(id, building, roomNumber, square, field, user);
        jdbc.updateClassroom(classroom);
        System.out.println("Classroom has been updated");
    }

    public void getYoungUsers(int age) throws SQLException {
        ArrayList<User> youngUsers= jdbc.getUsersOrderedByAge(age);
        System.out.println("Users younger than " + age + ": ");
        youngUsers.forEach(System.out::println);
    }

    public void getBuildings() throws SQLException {
        ArrayList<Integer> buildings = jdbc.getBuildingsByOrder();
        Collections.sort(buildings);
        System.out.print("Buildings of 'classrooms' table: ");
        buildings.forEach(s -> System.out.print(s + " "));
        System.out.println();
    }
}
