package Interfaces;

import classes.Passager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author medaimane
 */
public interface PassagersInterface {
    
    public Integer add(Passager p);

    public Integer update(Passager p);

    public Integer delete(Integer code);

    public ArrayList<Passager> select();

    public Passager get(Integer id);
    
    public Passager get(String name);
    
    public ResultSet getResultSet();
}
