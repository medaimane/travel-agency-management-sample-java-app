package operations;

import classes.Billet;
import Interfaces.BilletsInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tools.Connected;

/**
 *
 * @author medaimane
 */
public class Billets implements BilletsInterface {

    @Override
    public Integer add(Billet bl) {
        Integer b = 0;
        String query = "insert into Billets values(NULL, ?)";
        try {
            try (PreparedStatement pr = Connected.connection.prepareStatement(query)) {
                pr.setInt(1, bl.getReservation().getId());

                b = pr.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return b;
    }

    @Override
    public Integer update(Billet p) {
        Integer b = 0;

        return b;
    }

    @Override
    public Integer delete(Integer id) {
        Integer b = 0;

        return b;
    }

    @Override
    public ArrayList<Billet> select() {
        String query = "SELECT * FROM Billets";
        ArrayList<Billet> list = new ArrayList<>();
        try {
            try (ResultSet rst = Connected.getDB().query(query)) {
                while (rst.next()) {
                    Billet bl = new Billet();

                    bl.setId(rst.getInt("idBillet"));
                    bl.setReservation(new Reservations().get(rst.getInt("ReservationId")));

                    list.add(bl);
                }
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return list;
    }

    @Override
    public Billet get(Integer id) {
        String query = "SELECT * FROM Billets WHERE idBillet = ?";
        Billet bl = new Billet();
        try {
            try (PreparedStatement pst = Connected.connection.prepareStatement(query)) {
                pst.setInt(1, id);
                try (ResultSet rst = pst.executeQuery()) {
                    if (rst.next()) {
                        bl.setId(rst.getInt("idBillet"));
                        bl.setReservation(new Reservations().get(rst.getInt("ReservationId")));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return bl;
    }

    @Override
    public ResultSet getResultSet() {
        String query = "SELECT b.idBillet AS Numero, r.idReservation AS Reservation, p.nomPassager AS Passager, r.dateReservation AS DR, r.dateValidation AS DV, r.prixTotal AS Total FROM Reservations r JOIN Passagers p JOIN Billets b ON r.passagerId = p.idPassager AND b.ReservationId = r.idReservation";
        ResultSet rst = null;
        try {
            rst = Connected.getDB().query(query);
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return rst;
    }

}
