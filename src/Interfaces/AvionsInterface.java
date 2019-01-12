package Interfaces;

import classes.Avion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author medaimane
 */
public interface AvionsInterface {
    
    public Integer add(Avion p);

    public Integer update(Avion p);

    public Integer delete(Integer id);

    public ArrayList<Avion> select();

    public Avion get(Integer id);
    
    public ResultSet getResultSet();
}
