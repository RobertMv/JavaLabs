package service;

import entity.Classroom;
import entity.User;

/**
 * Service class for processing results from database
 * and responding them to console UI
 */
public abstract class Service {

    static void getClassrooms() {

    }

    static void getUsers() {

    }

    static void addUser(String fio, String position, int age) {

    }

    static void addClassroom(int building, int roomNumber, Double square, int user, String name) {

    }

    static void deleteUser(int id) {

    }

    static void deleteClassroom(int id) {

    }

    static void updateUser(int id, String fio, String position, int age) {

    }

    static User getUserById(int id) {
        return new User();
    }

    static Classroom getClassroomById(int id) {
        return new Classroom();
    }

    public static void updateClassroom(int id, int building, int roomNumber, double square, int user, String field) {
    }
}
