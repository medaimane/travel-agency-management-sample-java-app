
package classes;

import java.io.Serializable;

/**
 *
 * @author medaimane
 * 
 * Billets (Num_Billet, Num_Reservation)
 */
public class Billet implements Serializable {
    
    private static final long serialVersionUID = 9177103522343277451L;
    
    private Integer id;
    private Reservation reservation;

    public Billet() {
    }

    public Billet(Reservation reservation) {
        this.reservation = reservation;
    }

    public Billet(Integer id, Reservation reservation) {
        this.id = id;
        this.reservation = reservation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Billet{" + "id=" + id + ", reservation=" + reservation + '}';
    }
    
    
}
