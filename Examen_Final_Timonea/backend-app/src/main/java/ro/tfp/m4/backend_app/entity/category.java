package ro.tfp.m4.backend_app.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryID;

    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<greeting> greetings;


    public Long getCategoryID() {
        return categoryID;
    }
    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<greeting> getGreetings() {
        return greetings;
    }

    public void setGreetings(List<greeting> greetings) {
        this.greetings = greetings;
    }
}