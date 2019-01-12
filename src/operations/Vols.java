package operations;

import Interfaces.VolsInterface;
import classes.Vol;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tools.Connected;

/**
 *
 * @author medaimane
 */
public class Vols implements VolsInterface {

    @Override
    public Integer add(Vol v) {
        Integer b = 0;
        String query = "insert into Vols values(NULL, ?, ?, ?, ?,?,?)";
        try {
            try (PreparedStatement pr = Connected.connection.prepareStatement(query)) {
                pr.setInt(1, v.getAvion().getCodeAvion());
                pr.setInt(2, v.getPilote().getId());
                pr.setDate(3, new Date(v.getDateDepart().getTime()));
                pr.setString(4, v.getVilleDepart());
                pr.setString(5, v.getVilleArrivee());
                pr.setDouble(6, v.getPrixVol());
                
                b = pr.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return b;
    }

    @Override
    public Integer update(Vol p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Vol> select() {
        String query = "SELECT * FROM Vols";
        ArrayList<Vol> list = new ArrayList<>();
        try {
            try (ResultSet rst = Connected.getDB().query(query)) {
                while (rst.next()) {
                    Vol v = new Vol();

                    v.setId(rst.getInt("idVol"));
                    v.setAvion(new Avions().get(rst.getInt("avionId")));
                    v.setPilote(new Pilotes().get(rst.getInt("piloteId")));
                    v.setDateDepart(rst.getDate("dateDepart"));
                    v.setVilleDepart(rst.getString("villeDepart"));
                    v.setVilleArrivee(rst.getString("villeArrivee"));
                    v.setPrixVol(rst.getDouble("prixVol"));

                    list.add(v);
                }
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return list;
    }

    @Override
    public Vol get(Integer id) {
        String query = "SELECT * FROM Vols WHERE idVol = ?";
        Vol v = new Vol();
        try {
            try (PreparedStatement pst = Connected.connection.prepareStatement(query)) {
                pst.setInt(1, id);
                try (ResultSet rst = pst.executeQuery()) {
                    if (rst.next()) {

                        v.setId(rst.getInt("idVol"));
                        v.setAvion(new Avions().get(rst.getInt("avionId")));
                        v.setPilote(new Pilotes().get(rst.getInt("piloteId")));
                        v.setDateDepart(rst.getDate("dateDepart"));
                        v.setVilleDepart(rst.getString("villeDepart"));
                        v.setVilleArrivee(rst.getString("villeArrivee"));
                        v.setPrixVol(rst.getDouble("prixVol"));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return v;
    }

    @Override
    public ResultSet getResultSet() {
        String query = "SELECT v.idVol AS Numéro, a.idAvion AS Avion, p.idPilote AS Pilote, v.dateDepart AS Date_Depart, v.villeDepart AS Ville_Depart, v.villeArrivee AS Ville_Arrivée FROM Vols v JOIN Pilotes p JOIN Avions a ON a.idAvion = v.avionId AND p.idPilote = v.piloteId";
        ResultSet rst = null;
        try {
            rst = Connected.getDB().query(query);
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return rst;
    }

}
