package Interfaces;

import classes.LigneReservation;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author medaimane
 */
public interface LignesReservationsInterface {
    
    public Integer add(LigneReservation lr);

    public Integer update(LigneReservation lr);

    public Integer delete(Integer id);

    public ArrayList<LigneReservation> select();

    public LigneReservation get(Integer id);
    
    public ResultSet getResultSet();
}
