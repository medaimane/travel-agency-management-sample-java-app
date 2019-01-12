
package classes;

import java.io.Serializable;

/**
 *
 * @author medaimane
 
 LigneReservation(Num_Ligne, Num_Order, Num_Vol, Num_Reservation)
 */
public class LigneReservation implements Serializable {
    
    private static final long serialVersionUID = 9177103522343277451L;
    
    private Integer id;
    private Vol vol;
    private Reservation reservation;

    public LigneReservation() {
    }

    public LigneReservation(Vol vol, Reservation reservation) {
        this.vol = vol;
        this.reservation = reservation;
    }

    public LigneReservation(Integer id, Vol vol, Reservation reservation) {
        this.id = id;
        this.vol = vol;
        this.reservation = reservation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Ligne_Reservation{" + "id=" + id + ", vol=" + vol + ", reservation=" + reservation + '}';
    }
    
    
    
}
