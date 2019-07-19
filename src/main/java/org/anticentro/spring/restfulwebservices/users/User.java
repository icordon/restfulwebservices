package org.anticentro.spring.restfulwebservices.users;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {
    private Integer id;

    @Size(min=2, message = "Name should have at least 2 chars")
    private String name;

    @Past
    private Date birthDaty;

    public User(Integer id, String name, Date birthDaty) {
        this.id = id;
        this.name = name;
        this.birthDaty = birthDaty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDaty() {
        return birthDaty;
    }

    public void setBirthDaty(Date birthDaty) {
        this.birthDaty = birthDaty;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDaty=" + birthDaty +
                '}';
    }
}
