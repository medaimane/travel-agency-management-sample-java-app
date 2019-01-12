package Interfaces;

import classes.Vol;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author medaimane
 */
public interface VolsInterface {
    
    public Integer add(Vol p);

    public Integer update(Vol p);

    public Integer delete(Integer id);

    public ArrayList<Vol> select();

    public Vol get(Integer id);
    
    public ResultSet getResultSet();
}
