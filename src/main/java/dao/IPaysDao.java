package dao;

import java.util.List;
import metier.entities.Pays;

public interface IPaysDao {
    public Pays save(Pays p);
    public Pays getPays(Long id);
    public Pays updatePays(Pays p);
    public void deletePays(Long id);
	public List<Pays> paysParNom(String mc);
}

