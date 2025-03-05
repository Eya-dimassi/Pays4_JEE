package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Pays;

public class PaysModele {
    private String motCle;
    private List<Pays> paysList = new ArrayList<>();

    // Getter & Setter for motCle
    public String getMotCle() { return motCle; }
    public void setMotCle(String motCle) { this.motCle = motCle; }

    // Getter & Setter for List of Pays
    public List<Pays> getPaysList() { return paysList; }
    public void setPaysList(List<Pays> paysList) { this.paysList = paysList; }
}

