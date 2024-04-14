package persistence;

import model.tratament.Tratament;
import model.tratament.TratamentChirurgical;
import oracle.jdbc.internal.OraclePreparedStatement;
import service.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class TratamentRepository implements GenericRepository<Tratament>{
    static private TratamentRepository instance = null;

    public static TratamentRepository getInstance() {
        if (instance == null) {
            instance = new TratamentRepository();
        }
        return instance;
    }

    public void add(Tratament t) {
        String sql = "INSERT INTO tratament (tratament_id, nume, durata, pret)"
                + "VALUES (?, ? ,?, ?)";
        try {
            OraclePreparedStatement statement = (OraclePreparedStatement)
                    DBConnection.getConn().prepareStatement(sql);
            statement.setInt(1, t.getTratament_id());
            statement.setString(2, t.getNume());
            statement.setInt(3, t.getDurata());
            statement.setInt(4, t.getPret());
            statement.execute();
            System.out.println("A new entry was inserted successfully!");
        }
        catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    public Tratament get(int id) {
        Tratament t = new Tratament();
        String sql = "SELECT * FROM tratament WHERE tratament_id = ?";
        try {
            OraclePreparedStatement statement = (OraclePreparedStatement)
                    DBConnection.getConn().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                t.setTratament_id(resultSet.getInt("tratament_id"));
                t.setNume(resultSet.getString("nume"));
                t.setDurata(resultSet.getInt("durata"));
                t.setPret(resultSet.getInt("pret"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return t;
    }

    public ArrayList<Tratament> getAll() {
        ArrayList<Tratament> tratamente = new ArrayList<>();
        String sql = "SELECT * FROM tratament";
        try {
            OraclePreparedStatement statement = (OraclePreparedStatement)
                    DBConnection.getConn().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Tratament t = new TratamentChirurgical();
                t.setTratament_id(resultSet.getInt("tratament_id"));
                t.setNume(resultSet.getString("nume"));
                t.setDurata(resultSet.getInt("durata"));
                t.setPret(resultSet.getInt("pret"));
                tratamente.add(t);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return tratamente;
    }

    public void update(Tratament t) {
        String sql = "UPDATE tratament SET nume = ?, durata = ?, pret = ? WHERE tratament_id = ?";
        try {
            OraclePreparedStatement statement = (OraclePreparedStatement)
                    DBConnection.getConn().prepareStatement(sql);
            statement.setString(1, t.getNume());
            statement.setInt(2, t.getDurata());
            statement.setInt(3, t.getPret());
            statement.setInt(4, t.getTratament_id());
            statement.executeUpdate();
            System.out.println("Tratament updated successfully!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void delete(Tratament t) {
        String sql = "DELETE FROM tratament WHERE tratament_id = ?";
        try {
            OraclePreparedStatement statement = (OraclePreparedStatement)
                    DBConnection.getConn().prepareStatement(sql);
            statement.setInt(1, t.getTratament_id());
            statement.executeUpdate();
            System.out.println("Tratament deleted successfully!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
