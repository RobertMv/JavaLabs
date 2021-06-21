package entity;

public class Classroom {

    private int id;
    private int building;
    private int roomNumber;
    private Double square;
    private String name;
    private int userId;

    public Classroom() {
    }

    public Classroom(int building, int roomNumber, Double square, int userId, String name) {
        this.building = building;
        this.roomNumber = roomNumber;
        this.square = square;
        this.userId = userId;
        this.name = name;
    }

    public Classroom(int id, int building, int roomNumber, Double square, String name, int userId) {
        this.id = id;
        this.building = building;
        this.roomNumber = roomNumber;
        this.square = square;
        this.name = name;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Double getSquare() {
        return square;
    }

    public void setSquare(Double square) {
        this.square = square;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format("Classroom" +
                        "\n\tid: %s;" +
                        "\n\tbuilding-number: %s;" +
                        "\n\troom-number: %s;" +
                        "\n\tsquare: %s;" +
                        "\n\tuser: %s" +
                        "\n\ttitle: %s.\n",
                getId(),
                getBuilding(),
                getRoomNumber(),
                getSquare(),
                getUserId(),
                getName());
    }
}
