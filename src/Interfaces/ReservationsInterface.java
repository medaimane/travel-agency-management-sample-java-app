package Interfaces;

import classes.Reservation;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface ReservationsInterface {

    public Integer add(Reservation p);

    public Integer update(Reservation p);

    public Integer delete(Integer id);

    public Reservation get(Integer id);
    
    public ArrayList<Reservation> select();
    
    public ResultSet getResultSet();
}
