package Interfaces;

import classes.Voyage;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author medaimane
 */
public interface VoyagesInterface {
    
    public Integer add(Voyage v);

    public Integer update(Voyage v);

    public Integer delete(Integer id);

    public ArrayList<Voyage> select();

    public Voyage get(Integer id);
    
    public ResultSet getResultSet();
}
