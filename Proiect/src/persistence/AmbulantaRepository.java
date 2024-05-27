package persistence;

import model.Ambulanta;
import service.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AmbulantaRepository implements GenericRepository<Ambulanta> {
    static private AmbulantaRepository instance = null;

    public static AmbulantaRepository getInstance() {
        if (instance == null) {
            instance = new AmbulantaRepository();
        }
        return instance;
    }

    public void add(Ambulanta ambulanta) {
        String sql = "INSERT INTO ambulanta (ambulanta_id, numar_inmatriculare, kilometraj, an_achizitie, an_revizie) " +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.getConn().prepareStatement(sql);
            statement.setInt(1, ambulanta.getAmbulanta_id());
            statement.setString(2, ambulanta.getNr_inmatriculare());
            statement.setInt(3, ambulanta.getKilometraj());
            statement.setInt(4, ambulanta.getAn_achizitie());
            statement.setInt(5, ambulanta.getAn_revizie());
            statement.executeUpdate();
            System.out.println("A new ambulance entry was inserted successfully!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        audit.write("Add Ambulance");
    }

    public Ambulanta get(int id) {
        Ambulanta ambulanta = null;
        String sql = "SELECT * FROM ambulanta WHERE ambulanta_id = ?";
        try {
            PreparedStatement statement = connection.getConn().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ambulanta = new Ambulanta(
                        resultSet.getInt("ambulanta_id"),
                        null,
                        null,
                        resultSet.getString("numar_inmatriculare"),
                        resultSet.getInt("kilometraj"),
                        resultSet.getInt("an_achizitie"),
                        resultSet.getInt("an_revizie")
                );
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return ambulanta;

    }

    public ArrayList<Ambulanta> getAll() {
        ArrayList<Ambulanta> ambulante = new ArrayList<>();
        String sql = "SELECT * FROM ambulanta";
        try {
            PreparedStatement statement = connection.getConn().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ambulanta ambulanta = new Ambulanta(
                        resultSet.getInt("ambulanta_id"),
                        null,
                        null,
                        resultSet.getString("numar_inmatriculare"),
                        resultSet.getInt("kilometraj"),
                        resultSet.getInt("an_achizitie"),
                        resultSet.getInt("an_revizie")
                );
                ambulante.add(ambulanta);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        audit.write("Get all Ambulance");
        return ambulante;
    }

    public void update(Ambulanta ambulanta) {
        String sql = "UPDATE ambulanta SET numar_inmatriculare = ?, kilometraj = ?, an_achizitie = ?, an_revizie = ? " +
                "WHERE ambulanta_id = ?";
        try {
            PreparedStatement statement = connection.getConn().prepareStatement(sql);
            statement.setString(1, ambulanta.getNr_inmatriculare());
            statement.setInt(2, ambulanta.getKilometraj());
            statement.setInt(3, ambulanta.getAn_achizitie());
            statement.setInt(4, ambulanta.getAn_revizie());
            statement.setInt(5, ambulanta.getAmbulanta_id());
            statement.executeUpdate();
            System.out.println("Ambulance updated successfully!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        audit.write("Update Ambulance");
    }

    public void delete(Ambulanta ambulanta) {
        String sql = "DELETE FROM ambulanta WHERE ambulanta_id = ?";
        try {
            PreparedStatement statement = connection.getConn().prepareStatement(sql);
            statement.setInt(1, ambulanta.getAmbulanta_id());
            statement.executeUpdate();
            System.out.println("Ambulance deleted successfully!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        audit.write("Delete Ambulance");
    }
}
