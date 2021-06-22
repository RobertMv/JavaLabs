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


    public ArrayList<Classroom> getAllClassrooms() throws SQLException {
        ArrayList<Classroom> classrooms = new ArrayList<>();
        sqlQuery = "SELECT * FROM classrooms";
        ResultSet results = null;
        try {
            results = statement.executeQuery(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        while (results.next()){
            classrooms.add(new Classroom(results.getInt("id"),
                    results.getInt("building"),
                    results.getInt("room_number"),
                    results.getDouble("square"),
                    results.getString("title"),
                    results.getInt("user_id")));
        }
        return classrooms;
    }


    public ArrayList<User> getAllUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        String sqlQuery = "SELECT * FROM users";
        ResultSet results = null;
        try {
            results = statement.executeQuery(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        while (results.next()){
            users.add(new User(results.getInt("id"),
                    results.getString("fio"),
                    results.getString("position"),
                    results.getLong("phone"),
                    results.getInt("age")));
        }
        return users;
    }


    public void createClassroom(Classroom classroom) throws SQLException {
        sqlQuery = "INSERT INTO classrooms " +
                "(building, room_number, square, user_id, title) " +
                "values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        preparedStatement.setInt(1, classroom.getBuilding());
        preparedStatement.setInt(2, classroom.getRoomNumber());
        preparedStatement.setDouble(3, classroom.getSquare());
        preparedStatement.setInt(4, classroom.getUserId());
        preparedStatement.setString(5, classroom.getName());
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void createUser(User user) throws SQLException {
        sqlQuery = "INSERT INTO users " +
                "(fio, position, phone, age) " +
                "values(?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        preparedStatement.setString(1, user.getFio());
        preparedStatement.setString(2, user.getPosition());
        preparedStatement.setLong(3, user.getPhone());
        preparedStatement.setInt(4, user.getAge());
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void deleteUserById(int id) throws SQLException {
        sqlQuery = "DELETE FROM users WHERE id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        preparedStatement.setInt(1, id);
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void deleteClassroomById(int id) throws SQLException {
        sqlQuery = "DELETE FROM classrooms WHERE id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        preparedStatement.setInt(1, id);
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void updateClassroom(Classroom classroom) throws SQLException {
        sqlQuery = "UPDATE classrooms set building=?, " +
                "room_number=?, square=?, user_id=?, title=? " +
                "where id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        preparedStatement.setInt(1, classroom.getBuilding());
        preparedStatement.setInt(2, classroom.getRoomNumber());
        preparedStatement.setDouble(3, classroom.getSquare());
        preparedStatement.setInt(4, classroom.getUserId());
        preparedStatement.setString(5, classroom.getName());
        preparedStatement.setInt(6, classroom.getId());
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void updateUser(User user) throws SQLException {
        sqlQuery = "UPDATE users set fio=?, " +
                "position=?, phone=?, age=? " +
                "where id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        preparedStatement.setString(1, user.getFio());
        preparedStatement.setString(2, user.getPosition());
        preparedStatement.setLong(3, user.getPhone());
        preparedStatement.setInt(4, user.getAge());
        preparedStatement.setInt(5, user.getId());
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public User getUserById(int id) throws SQLException {
        User user = new User();
        sqlQuery = "SELECT * FROM users where id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        preparedStatement.setInt(1, id);
        ResultSet resultSet  = null;
        try {
            resultSet = statement.executeQuery(String.valueOf(preparedStatement));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setFio(resultSet.getString("fio"));
            user.setPosition(resultSet.getString("position"));
            user.setPhone(resultSet.getLong("phone"));
            user.setAge(resultSet.getInt("age"));
        }
        return user;
    }


    public Classroom getClassroomById(int id) throws SQLException {
        Classroom classroom = new Classroom();
        sqlQuery = "SELECT * FROM classrooms where id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        preparedStatement.setInt(1, id);
        ResultSet resultSet  = null;
        try {
            resultSet = statement.executeQuery(String.valueOf(preparedStatement));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (resultSet.next()){
            classroom.setId(resultSet.getInt("id"));
            classroom.setBuilding(resultSet.getInt("building"));
            classroom.setRoomNumber(resultSet.getInt("room_number"));
            classroom.setSquare(resultSet.getDouble("square"));
            classroom.setUserId(resultSet.getInt("user_id"));
            classroom.setName(resultSet.getString("title"));
        }
        return classroom;
    }
}
