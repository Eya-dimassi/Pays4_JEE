
package test;

import java.util.List;
import dao.PaysDaoImpl;
import metier.entities.Pays;

public class TestMetier {
    public static void main(String[] args) {
        PaysDaoImpl pdao = new PaysDaoImpl();
        
        // Adding a new country
        Pays pays = pdao.save(new Pays("France", 67000000, "Europe"));
        System.out.println("Saved: " + pays.getNomPays() + " - Population: " + pays.getPopulation() + " - Continent: " + pays.getContinent());
        
        // Searching for countries containing 'a' in their name
        List<Pays> paysList = pdao.paysParMC("a");
        for (Pays p : paysList) {
            System.out.println(p.getNomPays() + " - Population: " + p.getPopulation() + " - Continent: " + p.getContinent());
        }
    }
}
