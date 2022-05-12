package classes.Object;

public class SistersCities {
    private int id;
    private int idCity1;
    private int idCity2;

    public SistersCities(int idCity1, int idCity2) {
        this.idCity1 = idCity1;
        this.idCity2 = idCity2;
    }

    public SistersCities() {

    }

    public void setIdCity1(int idCity1) {
        this.idCity1 = idCity1;
    }

    public void setIdCity2(int idCity2) {
        this.idCity2 = idCity2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCity1() {
        return idCity1;
    }

    public int getIdCity2() {
        return idCity2;
    }

    public int getId() {
        return id;
    }
}
