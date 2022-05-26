package lab11.Entity;

public class Relationship {
    private Integer id;
    private Person person1;
    private Person person2;

    public Relationship(int id, Person person1, Person person2) {
        this.id = id;
        this.person1 = person1;
        this.person2 = person2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson1() {
        return person1;
    }

    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "id=" + id +
                ", person1=" + person1 +
                ", person2=" + person2 +
                '}';
    }
}
