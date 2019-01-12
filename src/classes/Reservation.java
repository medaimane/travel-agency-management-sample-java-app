
package classes;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author medaimane
 * 
 * Reservations (Num_Reservation, Date_Reservation, Date_Validation, Etat_Reservation, Code_Agence, Code_Passager,
                 Prix_Total)
 */
public class Reservation implements Serializable {
    
    private static final long serialVersionUID = 9177103522343277451L;
    
    private Integer id;
    private Passager passager;
    private Date dateReservation;
    private Date dateValidation;
    private Boolean etatReservation;
    private Double prixTotal;

    public Reservation() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Passager getPassager() {
        return passager;
    }

    public void setPassager(Passager passager) {
        this.passager = passager;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    public Boolean getEtatReservation() {
        return etatReservation;
    }

    public void setEtatReservation(Boolean etatReservation) {
        this.etatReservation = etatReservation;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", passager=" + passager + ", dateReservation=" + dateReservation + ", dateValidation=" + dateValidation + ", etatReservation=" + etatReservation + ", prixTotal=" + prixTotal + '}';
    }
            
}
