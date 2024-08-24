package ro.tfp.m4.backend_app.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeID;
    private String typeName;

    @OneToMany(mappedBy = "type")
    private List<greeting> greetings;

    public Long getTypeID() {
        return typeID;
    }
    public void setTypeID(Long typeID) {
        this.typeID = typeID;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public List<greeting> getGreetings() {
        return greetings;
    }
    public void setGreetings(List<greeting> greetings) {
        this.greetings = greetings;
    }
}