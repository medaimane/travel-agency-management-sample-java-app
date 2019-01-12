package Interfaces;

import classes.Pilote;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author medaimane
 */
public interface PilotesInterface {
    
    public Integer add(Pilote p);

    public Integer update(Pilote p);

    public Integer delete(Integer id);

    public ArrayList<Pilote> select();

    public Pilote get(Integer id);
    
    public ResultSet getResultSet();
}
