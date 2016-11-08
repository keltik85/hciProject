package my.app.model.angular;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Phone {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    String id;
    Integer age;
    String imageUrl;
    String name;
    String snippet;

    public Phone(String id, Integer age, String snippet, String name, String imageUrl) {
        this.id = id;
        this.age = age;
        this.snippet = snippet;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", snippet='" + snippet + '\'' +
                '}';
    }
}
