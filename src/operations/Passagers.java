package operations;

import classes.Passager;
import Interfaces.PassagersInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tools.Connected;

/**
 *
 * @author medaimane
 */
public class Passagers implements PassagersInterface {

    @Override
    public Integer add(Passager p) {
        Integer b = 0;
        String query = "insert into Passagers values(NULL, ?, ?, ?, ?, ?)";
        PreparedStatement pr = null;
        try {
            pr = Connected.connection.prepareStatement(query);

            pr.setString(1, p.getNome());
            pr.setString(2, p.getPrenome());
            pr.setString(3, p.getCodeTel());
            pr.setInt(4, p.getCodePassport());
            pr.setString(5, p.getCategory());

            b = pr.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return b;
    }

    @Override
    public Integer update(Passager p) {
        Integer b = 0;
        
        return b;
    }

    @Override
    public Integer delete(Integer id) {
        Integer b = 0;
        
        return b;
    }

    @Override
    public ArrayList<Passager> select() {
        String query = "SELECT * FROM Passagers";
        ArrayList<Passager> list = new ArrayList<>();
        try {
            ResultSet rst = Connected.getDB().query(query);
            while (rst.next()) {
                Passager p = new Passager();
                p.setId(rst.getInt("idPassager"));
                p.setNome(rst.getString("nomPassager"));
                p.setPrenome(rst.getString("prenomPassager"));
                p.setCodeTel(rst.getString("telPassager"));
                p.setCodePassport(rst.getInt("numPassport"));
                p.setCategory(rst.getString("categoriePassager"));

                list.add(p);
            }
            rst.close();
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        } finally {

        }
        return list;
    }

    @Override
    public Passager get(Integer id) {
        String query = "SELECT * FROM Passagers WHERE idPassager = ?";
        Passager p = new Passager();
        try {
            PreparedStatement pst = Connected.connection.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
                p.setId(rst.getInt("idPassager"));
                p.setNome(rst.getString("nomPassager"));
                p.setPrenome(rst.getString("prenomPassager"));
                p.setCodeTel(rst.getString("telPassager"));
                p.setCodePassport(rst.getInt("numPassport"));
                p.setCategory(rst.getString("categoriePassager"));
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
        }
        return p;
    }

    @Override
    public Passager get(String name) {
        String query = "SELECT * FROM Passagers WHERE nomPassager IN (?)";
        Passager p = new Passager();
        try {
            PreparedStatement pst = Connected.connection.prepareStatement(query);
            pst.setString(1, name);
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
                p.setId(rst.getInt("idPassager"));
                p.setNome(rst.getString("nomPassager"));
                p.setPrenome(rst.getString("prenomPassager"));
                p.setCodeTel(rst.getString("telPassager"));
                p.setCodePassport(rst.getInt("numPassport"));
                p.setCategory(rst.getString("categoriePassager"));
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
        }
        return p;
    }

    @Override
    public ResultSet getResultSet() {
        String query = "SELECT p.idPassager AS Numéro, p.nomPassager AS Nom, p.telPassager AS Tél, p.numPassport AS Passport FROM Passagers p";
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
