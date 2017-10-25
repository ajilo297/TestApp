package ajil.com.testapp.spinner;

/**
 * Created by ajilo on 23-10-2017.
 */

public class DataModel {
    int Id;
    String name;

    public DataModel() {
    }

    public DataModel(int id, String name) {
        Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
