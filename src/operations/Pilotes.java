package operations;

import Interfaces.PilotesInterface;
import classes.Pilote;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tools.Connected;

/**
 *
 * @author medaimane
 */
public class Pilotes implements PilotesInterface {

    @Override
    public Integer add(Pilote p) {
        Integer b = 0;
        String query = "insert into Pilotes values(NULL, ?, ?)";
        try {
            try (PreparedStatement pr = Connected.connection.prepareStatement(query)) {
                pr.setString(1, p.getNome());
                pr.setString(2, p.getPrenome());

                b = pr.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return b;
    }

    @Override
    public Integer update(Pilote p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pilote> select() {
        String query = "SELECT * FROM Pilotes";
        ArrayList<Pilote> list = new ArrayList<>();
        try {
            try (ResultSet rst = Connected.getDB().query(query)) {
                while (rst.next()) {
                    Pilote p = new Pilote();
                    
                    p.setId(rst.getInt("idPilote"));
                    p.setNome(rst.getString("nomPilote"));
                    p.setPrenome(rst.getString("prenomPilote"));

                    list.add(p);
                }
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return list;
    }

    @Override
    public Pilote get(Integer id) {
        String query = "SELECT * FROM Pilotes WHERE idPilote = ?";
        Pilote p = new Pilote();
        try {
            try (PreparedStatement pst = Connected.connection.prepareStatement(query)) {
                pst.setInt(1, id);
                try (ResultSet rst = pst.executeQuery()) {
                    if (rst.next()) {
                        p.setId(rst.getInt("idPilote"));
                        p.setNome(rst.getString("nomPilote"));
                        p.setPrenome(rst.getString("prenomPilote"));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return p;
    }

    @Override
    public ResultSet getResultSet() {
        String query = "SELECT idPilote AS Numéro, nomPilote AS Nom, prenomPilote AS Prénom FROM Pilotes";
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
