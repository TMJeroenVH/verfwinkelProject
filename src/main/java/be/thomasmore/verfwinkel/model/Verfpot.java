package be.thomasmore.verfwinkel.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Verfpot {
    @Id
    private int id;
    private String naam;
    private String ondergrond;
    private String kleurAanbod;
    private String verpakkingMogelijkheden;
    private double prijs;

    public Verfpot() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOndergrond() {
        return ondergrond;
    }

    public void setOndergrond(String ondergrond) {
        this.ondergrond = ondergrond;
    }

    public String getKleurAanbod() {
        return kleurAanbod;
    }

    public void setKleurAanbod(String kleurAanbod) {
        this.kleurAanbod = kleurAanbod;
    }

    public String getVerpakkingMogelijkheden() {
        return verpakkingMogelijkheden;
    }

    public void setVerpakkingMogelijkheden(String verpakkingMogelijkheden) {
        this.verpakkingMogelijkheden = verpakkingMogelijkheden;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
}


