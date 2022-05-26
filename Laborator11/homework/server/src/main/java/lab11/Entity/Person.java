package lab11.Entity;

public class Person {
    private Integer id;
    private String name;
    private Integer friendsNumber;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
        friendsNumber = 0;
    }

    public void addFriend() {
        friendsNumber++;
    }

    public void removeFriend() {
        friendsNumber--;
    }

    public Integer getFriendsNumber() {
        return friendsNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
