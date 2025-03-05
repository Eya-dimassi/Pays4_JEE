package dao;

public interface IPaysDao {
	public Pays save(Pays p);
    public List<Pays> paysParNom(String nom);
    public Pays getPays(Long id);
    public Pays updatePays(Pays p);
    public void deletePays(Long id);

}
