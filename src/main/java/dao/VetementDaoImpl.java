package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Vetement;

public class VetementDaoImpl implements IVetementDao {
    @Override
    public Vetement save(Vetement v) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO VETEMENT (NOM_VET, TAILLE, PRIX) VALUES (?, ?, ?)"
            );
            ps.setString(1, v.getNomVet());
            ps.setString(2, v.getTaille());
            ps.setDouble(3, v.getPrix());
            ps.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement(
                "SELECT MAX(ID_VET) as MAX_ID FROM VETEMENT"
            );
            ResultSet rs = ps2.executeQuery();
            if (rs.next()) {
                v.setIdVet(rs.getLong("MAX_ID"));
            }
            ps.close();
            ps2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }

    @Override
    public List<Vetement> vetementsParMC(String mc) {
        List<Vetement> vetements = new ArrayList<>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM VETEMENT WHERE NOM_VET LIKE ?");
            ps.setString(1, "%" + mc + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vetement v = new Vetement();
                v.setIdVet(rs.getLong("ID_VET"));
                v.setNomVet(rs.getString("NOM_VET"));
                v.setTaille(rs.getString("TAILLE"));
                v.setPrix(rs.getDouble("PRIX"));
                vetements.add(v);
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vetements;
    }



    @Override
    public void deleteVetement(Long id) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM VETEMENT WHERE ID_VET = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


	
    @Override
    public Vetement getVetement(Long id) {
        Connection conn = SingletonConnection.getConnection();
        Vetement v = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM VETEMENT WHERE ID_VET = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                v = new Vetement();
                v.setIdVet(rs.getLong("ID_VET"));
                v.setNomVet(rs.getString("NOM_VET"));
                v.setTaille(rs.getString("TAILLE"));
                v.setPrix(rs.getDouble("PRIX"));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }

	
    @Override
    public Vetement updateVetement(Vetement v) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE VETEMENT SET NOM_VET = ?, TAILLE = ?, PRIX = ? WHERE ID_VET = ?"
            );
            ps.setString(1, v.getNomVet());
            ps.setString(2, v.getTaille());
            ps.setDouble(3, v.getPrix());
            ps.setLong(4, v.getIdVet());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }

}