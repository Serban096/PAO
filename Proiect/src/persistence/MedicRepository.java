package persistence;

import model.Medic;
import service.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class MedicRepository implements GenericRepository<Medic> {
    static private MedicRepository instance = null;

    public static MedicRepository getInstance() {
        if (instance == null) {
            instance = new MedicRepository();
        }
        return instance;
    }

    public void add(Medic medic) {
        String sql = "INSERT INTO medic (medic_id, nume, varsta, specializare, salariu, numar_telefon) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.getConn().prepareStatement(sql);
            statement.setInt(1, medic.getMedic_id());
            statement.setString(2, medic.getNume());
            statement.setInt(3, medic.getVarsta());
            statement.setString(4, medic.getSpecializare());
            statement.setInt(5, medic.getSalariu());
            statement.setString(6, medic.getNr_telefon());
            statement.executeUpdate();
            System.out.println("A new entry was inserted successfully!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        audit.write("Add Medic");
    }

    public Medic get(int id) {
        Medic medic = null;
        String sql = "SELECT * FROM medic WHERE medic_id = ?";
        try {
            PreparedStatement statement = connection.getConn().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                medic = new Medic(
                        resultSet.getInt("medic_id"),
                        resultSet.getString("nume"),
                        resultSet.getInt("varsta"),
                        resultSet.getString("specializare"),
                        resultSet.getInt("salariu"),
                        resultSet.getString("numar_telefon")
                );
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return medic;
    }

    public ArrayList<Medic> getAll() {
        ArrayList<Medic> medici = new ArrayList<>();
        String sql = "SELECT * FROM medic";
        try {
            PreparedStatement statement = connection.getConn().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Medic medic = new Medic(
                        resultSet.getInt("medic_id"),
                        resultSet.getString("nume"),
                        resultSet.getInt("varsta"),
                        resultSet.getString("specializare"),
                        resultSet.getInt("salariu"),
                        resultSet.getString("numar_telefon")
                );
                medici.add(medic);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        audit.write("Get All Medic");
        return medici;
    }

    public void update(Medic medic) {
        String sql = "UPDATE medic SET nume = ?, varsta = ?, specializare = ?, salariu = ?, numar_telefon = ? " +
                "WHERE medic_id = ?";
        try {
            PreparedStatement statement = connection.getConn().prepareStatement(sql);
            statement.setString(1, medic.getNume());
            statement.setInt(2, medic.getVarsta());
            statement.setString(3, medic.getSpecializare());
            statement.setInt(4, medic.getSalariu());
            statement.setString(5, medic.getNr_telefon());
            statement.setInt(6, medic.getMedic_id());
            statement.executeUpdate();
            System.out.println("Medic updated successfully!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        audit.write("Update Medic");
    }

    public void delete(Medic medic) {
        String sql = "DELETE FROM medic WHERE medic_id = ?";
        try {
            PreparedStatement statement = connection.getConn().prepareStatement(sql);
            statement.setInt(1, medic.getMedic_id());
            statement.executeUpdate();
            System.out.println("Medic deleted successfully!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        audit.write("Delete Medic");
    }
}
