
package metier.entities;

import java.io.Serializable;

public class Pays implements Serializable {
    private Long idPays;
    private String nomPays;
    private int population;
    private String continent;

   
    public Pays() {}

    public Pays(String nomPays, int population, String continent) {
        this.nomPays = nomPays;
        this.population = population;
        this.continent = continent;
    }


    public Long getIdPays() { return idPays; }
    public void setIdPays(Long idPays) { 
    	this.idPays = idPays; }

    public String getNomPays() { return nomPays; }
    public void setNomPays(String nomPays) { 
    	this.nomPays = nomPays; }

    public int getPopulation() { 
    	return population; }
    public void setPopulation(int population) { 
    	this.population = population; }

    public String getContinent() { 
    	return continent; }
    public void setContinent(String continent) { 
    	this.continent = continent; }
}

