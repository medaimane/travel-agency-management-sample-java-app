package Interfaces;

import classes.Billet;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author medaimane
 */
public interface BilletsInterface {
    
    public Integer add(Billet p);

    public Integer update(Billet p);

    public Integer delete(Integer id);

    public ArrayList<Billet> select();

    public Billet get(Integer id);
    
    public ResultSet getResultSet();
}
