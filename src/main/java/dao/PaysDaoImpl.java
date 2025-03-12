package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Pays;
import util.JPAutil;

public class PaysDaoImpl implements IPaysDao {
    private EntityManager entityManager = JPAutil.getEntityManager("TP5_JEE");

    @Override
    public Pays save(Pays p) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(p);
        tx.commit();
        return p;
    }

    @Override
    public List<Pays> paysParNom(String mc) { 
        return entityManager.createQuery("SELECT p FROM Pays p WHERE p.nomPays LIKE :mc").setParameter("mc", "%" + mc + "%").getResultList();
    }

    @Override
    public Pays getPays(Long id) {
        return entityManager.find(Pays.class, id);
    }

    @Override
    public Pays updatePays(Pays p) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(p);
        tx.commit();
        return p;
    }

    @Override
    public void deletePays(Long id) {
        Pays pays = entityManager.find(Pays.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(pays);
        entityManager.getTransaction().commit();
    }
}



