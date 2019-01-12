
package classes;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author medaimane
 * 
 * Vols (Num_Vol, Date_Depart, Ville_Depart, Ville Arrivee, Code_Avion, Num_Pilote,Prix_Vol)
 */
public class Vol implements Serializable {
    
    private static final long serialVersionUID = 9177103522343277451L;
    
    private Integer id;
    private Date dateDepart;
    private String villeDepart;
    private String villeArrivee;
    private Avion avion;
    private Pilote pilote;
    private Double prixVol;

    public Vol() {
    }

    public Vol(Date dateDepart, String villeDepart, String villeArrivee, Avion avion, Pilote pilote, Double prixVol) {
        this.dateDepart = dateDepart;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.avion = avion;
        this.pilote = pilote;
        this.prixVol = prixVol;
    }

    public Vol(Integer id, Date dateDepart, String villeDepart, String villeArrivee, Avion avion, Pilote pilote, Double prixVol) {
        this.id = id;
        this.dateDepart = dateDepart;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.avion = avion;
        this.pilote = pilote;
        this.prixVol = prixVol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Pilote getPilote() {
        return pilote;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }

    public Double getPrixVol() {
        return prixVol;
    }

    public void setPrixVol(Double prixVol) {
        this.prixVol = prixVol;
    }

    @Override
    public String toString() {
        return "Vol{" + "id=" + id + ", dateDepart=" + dateDepart + ", villeDepart=" + villeDepart + ", villeArrivee=" + villeArrivee + ", avion=" + avion + ", pilote=" + pilote + ", prixVol=" + prixVol + '}';
    }
    
    
    
    
}
