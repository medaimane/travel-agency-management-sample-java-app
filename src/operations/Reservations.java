package operations;

import classes.Reservation;
import java.util.ArrayList;
import Interfaces.ReservationsInterface;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tools.Connected;

/**
 *
 * @author medaimane
 */
public class Reservations implements ReservationsInterface {

    @Override
    public Integer add(Reservation r) {
        Integer b = 0;
        String query = "insert into Reservations values(NULL, ?, ?, ?, ?,?)";
        PreparedStatement pr = null;
        try {
            pr = Connected.connection.prepareStatement(query);
            
            pr.setInt(1, r.getPassager().getId());
            pr.setDate(2, new Date(r.getDateReservation().getTime()));
            pr.setDate(3, new Date(r.getDateValidation().getTime()));
            pr.setBoolean(4, r.getEtatReservation());
            pr.setDouble(5, r.getPrixTotal());

            b = pr.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return b;
    }

    @Override
    public Integer update(Reservation p) {
        Integer b = 0;

        return b;
    }

    @Override
    public Integer delete(Integer id) {
        Integer b = 0;

        return b;
    }

    @Override
    public Reservation get(Integer id) {
        String query = "SELECT * FROM Reservations WHERE idReservation = ?";
        Reservation r = new Reservation();
        
        try {
            PreparedStatement pst = Connected.connection.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
                r.setId(rst.getInt("idReservation"));
                r.setPassager(new Passagers().get(rst.getInt("passagerId")));
                r.setDateReservation(rst.getDate("dateReservation"));
                r.setDateValidation(rst.getDate("dateValidation"));
                r.setEtatReservation(rst.getBoolean("etatReservation"));
                r.setPrixTotal(rst.getDouble("prixTotal"));
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
        }
        
        return r;
    }

    @Override
    public ArrayList<Reservation> select() {
        String query = "SELECT * FROM Reservations";
        ArrayList<Reservation> list = new ArrayList<>();
        try {
            ResultSet rst = Connected.getDB().query(query);
            while (rst.next()) {
                Reservation r = new Reservation();
                r.setId(rst.getInt("idReservation"));
                r.setPassager(new Passagers().get(rst.getInt("passagerId")));
                r.setDateReservation(rst.getDate("dateReservation"));
                r.setDateValidation(rst.getDate("dateValidation"));
                r.setEtatReservation(rst.getBoolean("etatReservation"));
                r.setPrixTotal(rst.getDouble("prixTotal"));

                list.add(r);
            }
            rst.close();
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        } finally {

        }
        return list;
    }
    
    @Override
    public ResultSet getResultSet() {
            String query = "SELECT r.idReservation AS Numero, p.nomPassager AS Passager, r.dateReservation AS DR, r.dateValidation AS DV FROM Reservations r JOIN Passagers p ON r.passagerId = p.idPassager";
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
