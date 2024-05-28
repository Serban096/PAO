package persistence;

import model.Pacient;
import service.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PacientRepository implements GenericRepository<Pacient> {
    static private PacientRepository instance = null;

    public static PacientRepository getInstance() {
        if (instance == null) {
            instance = new PacientRepository();
        }
        return instance;
    }

    public void add(Pacient pacient) {
        String sql = "INSERT INTO pacient (pacient_id, ambulanta_id, nume, varsta, greutate, grupa_sange, cnp) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.getConn().prepareStatement(sql);
            statement.setInt(1, pacient.getPacient_id());
            statement.setInt(2, pacient.getAmbulanta_id());
            statement.setString(3, pacient.getNume());
            statement.setInt(4, pacient.getVarsta());
            statement.setInt(5, pacient.getGreutate());
            statement.setString(6, pacient.getGrupa_sange());
            statement.setLong(7, pacient.getCnp());
            statement.executeUpdate();
            System.out.println("A new patient entry was inserted successfully!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        audit.write("Add Pacient");
    }

    public Pacient get(int id) {
        Pacient pacient = null;
        String sql = "SELECT * FROM pacient WHERE pacient_id = ?";
        try {
            PreparedStatement statement = DBConnection.getConn().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                pacient = new Pacient(
                        resultSet.getInt("pacient_id"),
                        resultSet.getInt("ambulanta_id"),
                        null,
                        resultSet.getString("nume"),
                        resultSet.getInt("varsta"),
                        resultSet.getInt("greutate"),
                        resultSet.getString("grupa_sange"),
                        resultSet.getLong("cnp")
                );
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return pacient;
    }

    public ArrayList<Pacient> getAll() {
        ArrayList<Pacient> pacienti = new ArrayList<>();
        String sql = "SELECT * FROM pacient";
        try {
            PreparedStatement statement = connection.getConn().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Pacient pacient = new Pacient(
                        resultSet.getInt("pacient_id"),
                        resultSet.getInt("ambulanta_id"),
                        null,
                        resultSet.getString("nume"),
                        resultSet.getInt("varsta"),
                        resultSet.getInt("greutate"),
                        resultSet.getString("grupa_sange"),
                        resultSet.getLong("cnp")
                );
                pacienti.add(pacient);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        audit.write("Get All Pacient");
        return pacienti;
    }

    public void update(Pacient pacient) {
        String sql = "UPDATE pacient SET ambulanta_id = ?, nume = ?, varsta = ?, greutate = ?, grupa_sange = ?, cnp = ? " +
                "WHERE pacient_id = ?";
        try {
            PreparedStatement statement = DBConnection.getConn().prepareStatement(sql);
            statement.setInt(1, pacient.getAmbulanta_id());
            statement.setString(2, pacient.getNume());
            statement.setInt(3, pacient.getVarsta());
            statement.setInt(4, pacient.getGreutate());
            statement.setString(5, pacient.getGrupa_sange());
            statement.setLong(6, pacient.getCnp());
            statement.setInt(7, pacient.getPacient_id());
            statement.executeUpdate();
            System.out.println("Patient updated successfully!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        audit.write("Update Pacient");
    }

    public void delete(Pacient pacient) {
        String sql = "DELETE FROM pacient WHERE pacient_id = ?";
        try {
            PreparedStatement statement = DBConnection.getConn().prepareStatement(sql);
            statement.setInt(1, pacient.getPacient_id());
            statement.executeUpdate();
            System.out.println("Patient deleted successfully!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        audit.write("Delete Pacient");
    }
}
