package operations;

import Interfaces.AvionsInterface;
import classes.Avion;
import classes.Billet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tools.Connected;

/**
 *
 * @author medaimane
 */
public class Avions implements AvionsInterface {

    @Override
    public Integer add(Avion a) {
        Integer b = 0;
        String query = "insert into Avions values(NULL, ?, ?, ?)";
        try {
            try (PreparedStatement pr = Connected.connection.prepareStatement(query)) {
                pr.setString(1, a.getNomCompanie());
                pr.setInt(2, a.getNembrePlaces());
                pr.setDouble(3, a.getPoidsMax());

                b = pr.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return b;
    }

    @Override
    public Integer update(Avion p) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Avion> select() {
        String query = "SELECT * FROM Avions";
        ArrayList<Avion> list = new ArrayList<>();
        try {
            try (ResultSet rst = Connected.getDB().query(query)) {
                while (rst.next()) {
                    Avion a = new Avion();
                    
                    a.setCodeAvion(rst.getInt("idAvion"));
                    a.setNomCompanie(rst.getString("nomCompagnie"));
                    a.setNembrePlaces(rst.getInt("nombresPlaces"));
                    a.setPoidsMax(rst.getDouble("poidsMax"));
                    
                    list.add(a);
                }
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return list;
    }

    @Override
    public Avion get(Integer id) {
        String query = "SELECT * FROM Avions WHERE idAvion = ?";
        Avion a = new Avion();
        try {
            try (PreparedStatement pst = Connected.connection.prepareStatement(query)) {
                pst.setInt(1, id);
                try (ResultSet rst = pst.executeQuery()) {
                    if (rst.next()) {
                        a.setCodeAvion(rst.getInt("idAvion"));
                        a.setNomCompanie(rst.getString("nomCompagnie"));
                        a.setNembrePlaces(rst.getInt("nombresPlaces"));
                        a.setPoidsMax(rst.getDouble("poidsMax"));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return a;
    }

    @Override
    public ResultSet getResultSet() {
        String query = "SELECT idAvion AS Numéro, nomCompagnie AS Compagnie, nombresPlaces AS Places, poidsMax AS PoidsMax FROM Avions";
        ResultSet rst = null;
        try {
            rst = Connected.getDB().query(query);
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        } finally {

        }
        return rst;
    }

}
