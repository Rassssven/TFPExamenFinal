package ro.tfp.m4.backend_app.entity;

import jakarta.persistence.*;

@Entity
public class greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long greetingID;

    private String description;
    private double price;

    @ManyToOne
    @JoinColumn(name = "typeID")
    private type type;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private category category;


    public Long getGreetingID() {
        return greetingID;
    }

    public void setGreetingID(Long greetingID) {
        this.greetingID = greetingID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public type getType() {
        return type;
    }

    public void setType(type type) {
        this.type = type;
    }

    public category getCategory() {
        return category;
    }

    public void setCategory(category category) {
        this.category = category;
    }
}