package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Pays;

public class PaysDaoImpl implements IPaysDao {

    @Override
    public Pays save(Pays p) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO PAYS(NOM_PAYS, POPULATION, CONTINENT) VALUES(?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, p.getNomPays());
            ps.setInt(2, p.getPopulation());
            ps.setString(3, p.getContinent());
            ps.executeUpdate();

            // ✅ Get the generated ID instead of using MAX(ID_PAYS)
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                p.setIdPays(rs.getLong(1));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Pays> paysParMC(String mc) {
        List<Pays> paysList = new ArrayList<>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM PAYS WHERE NOM_PAYS LIKE ?");
            ps.setString(1, "%" + mc + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pays p = new Pays();
                p.setIdPays(rs.getLong("ID_PAYS"));
                p.setNomPays(rs.getString("NOM_PAYS"));
                p.setPopulation(rs.getInt("POPULATION"));
                p.setContinent(rs.getString("CONTINENT"));
                paysList.add(p);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paysList;
    }

    @Override
    public Pays getPays(Long id) {
        Connection conn = SingletonConnection.getConnection();
        Pays p = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM PAYS WHERE ID_PAYS = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Pays();
                p.setIdPays(rs.getLong("ID_PAYS"));
                p.setNomPays(rs.getString("NOM_PAYS"));
                p.setPopulation(rs.getInt("POPULATION"));
                p.setContinent(rs.getString("CONTINENT"));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public Pays updatePays(Pays p) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE PAYS SET NOM_PAYS=?, POPULATION=?, CONTINENT=? WHERE ID_PAYS=?"
            );
            ps.setString(1, p.getNomPays());
            ps.setInt(2, p.getPopulation());
            ps.setString(3, p.getContinent());
            ps.setLong(4, p.getIdPays());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void deletePays(Long id) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM PAYS WHERE ID_PAYS = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


