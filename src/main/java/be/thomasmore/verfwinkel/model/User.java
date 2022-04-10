package be.thomasmore.verfwinkel.model;

import javax.persistence.*;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "USER_SEQ", allocationSize = 1)
    @Id
    private int id;
    private String username;
    private String password;
    private String role;
    private String adres;

    public User() {

    }

    public User(int id, String username, String password, String role, String adres) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.adres = adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
