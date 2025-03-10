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
            PreparedStatement ps = conn.prepareStatement("INSERT INTO PAYS(NOM_PAYS, POPULATION, CONTINENT) VALUES(?,?,?)");
            ps.setString(1, p.getNomPays());
            ps.setInt(2, p.getPopulation());
            ps.setString(3, p.getContinent());
            ps.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement("SELECT MAX(ID_PAYS) as MAX_ID FROM PAYS");
            ResultSet rs = ps2.executeQuery();
            if (rs.next()) {
                p.setIdPays(rs.getLong("MAX_ID"));
            }
            ps.close();
            ps2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Pays> paysParMC(String mc) {  // Ensure method name matches IPaysDao
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paysList;
    }

    @Override
    public Pays getPays(Long id) {
        Connection conn = SingletonConnection.getConnection();
        Pays p = new Pays();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM PAYS WHERE ID_PAYS = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p.setIdPays(rs.getLong("ID_PAYS"));
                p.setNomPays(rs.getString("NOM_PAYS"));
                p.setPopulation(rs.getInt("POPULATION"));
                p.setContinent(rs.getString("CONTINENT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public Pays updatePays(Pays p) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE PAYS SET NOM_PAYS=?, POPULATION=?, CONTINENT=? WHERE ID_PAYS=?");
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

