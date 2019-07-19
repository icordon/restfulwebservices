package org.anticentro.spring.restfulwebservices.users;

import java.util.Date;

public class Post {
    private Integer id;
    private Integer idUser;
    private Date creationDate;
    private String message;

    public Post(Integer id, Integer idUser, Date creationDate, String message) {
        this.id = id;
        this.idUser = idUser;
        this.creationDate = creationDate;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", message='" + message + '\'' +
                '}';
    }
}
