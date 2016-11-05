package my.app.model;

import org.springframework.data.annotation.Id;


public class Greeting {


    @Id
    private String id;
    private String name;

    public Greeting(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Greeting[id=%s, name='%s']",
                id, name);
    }
}
