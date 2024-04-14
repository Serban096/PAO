package persistence;

import model.Paramedic;
import service.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParamedicRepository implements GenericRepository<Paramedic> {
    static private ParamedicRepository instance = null;

    public static ParamedicRepository getInstance() {
        if (instance == null) {
            instance = new ParamedicRepository();
        }
        return instance;
    }

    public void add(Paramedic paramedic) {
        String sql = "INSERT INTO paramedic (paramedic_id, ambulanta_id, nume, varsta, salariu) " +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = DBConnection.getConn().prepareStatement(sql);
            statement.setInt(1, paramedic.getParamedic_id());
            statement.setInt(2, paramedic.getAmbulanta_id());
            statement.setString(3, paramedic.getNume());
            statement.setInt(4, paramedic.getVarsta());
            statement.setInt(5, paramedic.getSalariu());
            statement.executeUpdate();
            System.out.println("A new paramedic entry was inserted successfully!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Paramedic get(int id) {
        Paramedic paramedic = null;
        String sql = "SELECT * FROM paramedic WHERE paramedic_id = ?";
        try {
            PreparedStatement statement = DBConnection.getConn().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                paramedic = new Paramedic(
                        resultSet.getInt("paramedic_id"),
                        resultSet.getInt("ambulanta_id"),
                        null,
                        resultSet.getString("nume"),
                        resultSet.getInt("varsta"),
                        resultSet.getInt("salariu")
                );
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return paramedic;
    }

    public ArrayList<Paramedic> getAll() {
        ArrayList<Paramedic> paramedici = new ArrayList<>();
        String sql = "SELECT * FROM paramedic";
        try {
            PreparedStatement statement = DBConnection.getConn().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Paramedic paramedic = new Paramedic(
                        resultSet.getInt("paramedic_id"),
                        resultSet.getInt("ambulanta_id"),
                        null,
                        resultSet.getString("nume"),
                        resultSet.getInt("varsta"),
                        resultSet.getInt("salariu")
                );
                paramedici.add(paramedic);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return paramedici;
    }

    public void update(Paramedic paramedic) {
        String sql = "UPDATE paramedic SET ambulanta_id = ?, nume = ?, varsta = ?, salariu = ? " +
                "WHERE paramedic_id = ?";
        try {
            PreparedStatement statement = DBConnection.getConn().prepareStatement(sql);
            statement.setInt(1, paramedic.getAmbulanta_id());
            statement.setString(2, paramedic.getNume());
            statement.setInt(3, paramedic.getVarsta());
            statement.setInt(4, paramedic.getSalariu());
            statement.setInt(5, paramedic.getParamedic_id());
            statement.executeUpdate();
            System.out.println("Paramedic updated successfully!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void delete(Paramedic paramedic) {
        String sql = "DELETE FROM paramedic WHERE paramedic_id = ?";
        try {
            PreparedStatement statement = DBConnection.getConn().prepareStatement(sql);
            statement.setInt(1, paramedic.getParamedic_id());
            statement.executeUpdate();
            System.out.println("Paramedic deleted successfully!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
