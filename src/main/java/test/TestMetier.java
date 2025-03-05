package test;

import java.util.List;

import metier.entities.Pays;

public class TestMetier {
    public static void main(String[] args) {
        MetierImpl metier = new MetierImpl();
        List<Pays> paysList = metier.getPaysParMotCle("a");
        
        for (Pays p : paysList) {
            System.out.println(p.getNomPays() + " - " + p.getPopulation() + " - " + p.getContinent());
        }
    }
}
