package service;

import entity.Classroom;
import entity.User;

import java.sql.*;
import java.util.ArrayList;

public class JDBC {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Java9";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "300P@midorov";

    private static Connection connection = null;
    private static ResultSet resultSet = null;
    private static Statement statement = null;
    private static String sqlQuery;

    public JDBC(){
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public ArrayList<Classroom> getClassrooms() throws SQLException {
        ArrayList<Classroom> classrooms = new ArrayList<>();
        sqlQuery = "SELECT * FROM classrooms";
        ResultSet results = statement.executeQuery(sqlQuery);
        connection.commit();
        while (results.next()){
            classrooms.add(new Classroom(results.getInt("building"),
                    results.getInt("room_number"),
                    results.getDouble("square"),
                    results.getInt("user_id"),
                    results.getString("title")));
        }
        return classrooms;
    }


    public ArrayList<User> getUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        String sqlQuery = "SELECT * FROM users";
        ResultSet results = statement.executeQuery(sqlQuery);
        connection.commit();
        while (results.next()){
            users.add(new User(results.getString("fio"),
                    results.getString("position"),
                    results.getLong("phone"),
                    results.getInt("age")));
        }
        return users;
    }


    public void createClassroom(Classroom classroom) throws SQLException {
        sqlQuery = "INSERT INTO classrooms " +
                "(building, room_number, square, user_id) " +
                "values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, classroom.getBuilding());
        preparedStatement.setInt(2, classroom.getRoomNumber());
        preparedStatement.setDouble(3, classroom.getSquare());
        preparedStatement.setInt(4, classroom.getUserId());
        preparedStatement.setString(5, classroom.getName());
        preparedStatement.executeUpdate();
        connection.commit();
    }


    public void createUser(User user) {

    }


    public void deleteUser() {

    }


    public void deleteClassroom() {

    }


    public void updateUser(User user) {

    }


    public void updateClassroom(Classroom classroom) {
    }


    public User getUserById(int id) {
        return new User();
    }


    public Classroom getClassroomById(int id) {
        return new Classroom();
    }
}
