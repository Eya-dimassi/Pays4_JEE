package dao;

import java.util.List;
import metier.entities.Pays;

public interface IPaysDao {
    public Pays save(Pays p);
    public List<Pays> paysParMC(String mc);  // Ensure this method matches PaysDaoImpl
    public Pays getPays(Long id);
    public Pays updatePays(Pays p);
    public void deletePays(Long id);
}

