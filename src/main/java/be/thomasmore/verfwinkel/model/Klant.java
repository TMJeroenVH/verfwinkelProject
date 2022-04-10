package be.thomasmore.verfwinkel.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Klant {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "klant_generator")
    @SequenceGenerator(name = "klant_generator", sequenceName = "klant_seq", allocationSize = 1)
    @Id
    private Integer id;
    private String naam;
    private String adres;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public Klant() {

    }

    public Klant(String naam, String adres, User user) {
        this.naam = naam;
        adres = adres;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        adres = adres;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
