package entity;

public class User {

    private int id;
    private String fio;
    private String position;
    private Long phone;
    private int age;

    public User() {
    }

    public User(String fio, String position, Long phone, int age) {
        this.fio = fio;
        this.phone = phone;
        this.position = position;
        this.age = age;
    }

    public User(int id, String fio, String position, Long phone, int age) {
        this.id = id;
        this.fio = fio;
        this.position = position;
        this.phone = phone;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("User" +
                        "\n\tid: %s;" +
                        "\n\tfull-name: %s;" +
                        "\n\tposition: %s;" +
                        "\n\tage: %s" +
                        "\n\tphone: %s.\n",
                getId(),
                getFio(),
                getPosition(),
                getAge(),
                getPhone());
    }
}
