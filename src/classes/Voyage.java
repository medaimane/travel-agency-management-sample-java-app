
package classes;

import java.io.Serializable;

/**
 *
 * @author medaimane
 * 
 * Voyages(Code_Passager, Num_Billet, Num_Vol, Num_place)
 * 
 */
public class Voyage implements Serializable {
    
    private static final long serialVersionUID = 9177103522343277451L;
    
    private Passager passager;
    private Billet billet;
    private Vol vol;
    private Integer numeroPlace;

    public Voyage() {
    }

    public Voyage(Passager passager, Billet billet, Vol vol, Integer numeroPlace) {
        this.passager = passager;
        this.billet = billet;
        this.vol = vol;
        this.numeroPlace = numeroPlace;
    }

    public Passager getPassager() {
        return passager;
    }

    public void setPassager(Passager passager) {
        this.passager = passager;
    }

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public Integer getNumeroPlace() {
        return numeroPlace;
    }

    public void setNumeroPlace(Integer numeroPlace) {
        this.numeroPlace = numeroPlace;
    }

    @Override
    public String toString() {
        return "Voyage{" + "passager=" + passager + ", billet=" + billet + ", vol=" + vol + ", numeroPlace=" + numeroPlace + '}';
    }
    
    
    
}
