
package classes;

import java.io.Serializable;

/**
 *
 * @author medaimane
 * 
 * Avions (Code_Avion, Poids_Max, Nom_Compagnie, Nbr_Place)
 */
public class Avion implements Serializable {
 
    private static final long serialVersionUID = 9177103522343277451L;
    
    private Integer codeAvion;
    private Double PoidsMax;
    private Integer nembrePlaces;
    private String nomCompanie;

    public Avion() {
    }

    public Avion(Integer codeAvion, Double PoidsMax, Integer nembrePlaces, String nomCompanie) {
        this.codeAvion = codeAvion;
        this.PoidsMax = PoidsMax;
        this.nembrePlaces = nembrePlaces;
        this.nomCompanie = nomCompanie;
    }

    public Integer getCodeAvion() {
        return codeAvion;
    }

    public void setCodeAvion(Integer codeAvion) {
        this.codeAvion = codeAvion;
    }

    public Double getPoidsMax() {
        return PoidsMax;
    }

    public void setPoidsMax(Double PoidsMax) {
        this.PoidsMax = PoidsMax;
    }

    public Integer getNembrePlaces() {
        return nembrePlaces;
    }

    public void setNembrePlaces(Integer nembrePlaces) {
        this.nembrePlaces = nembrePlaces;
    }

    public String getNomCompanie() {
        return nomCompanie;
    }

    public void setNomCompanie(String nomCompanie) {
        this.nomCompanie = nomCompanie;
    }

    @Override
    public String toString() {
        return "Avion{" + " codeAvion=" + codeAvion + ", PoidsMax=" + PoidsMax + ", nembrePlaces=" + nembrePlaces + ", nomCompanie=" + nomCompanie + '}';
    }
    
    
}
