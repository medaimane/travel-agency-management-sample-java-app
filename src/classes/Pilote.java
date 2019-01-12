
package classes;

import java.io.Serializable;

/**
 *
 * @author medaimane
 * 
 * Pilotes (Num_Pilote, Nom__Pilote, Prenom_Pilote)
 */
public class Pilote implements Serializable {
    
    private static final long serialVersionUID = 9177103522343277451L;
    
    private Integer id;
    private String nome;
    private String prenome;

    public Pilote() {
    }

    public Pilote(String nome, String prenome) {
        this.nome = nome;
        this.prenome = prenome;
    }

    public Pilote(Integer id, String nome, String prenome) {
        this.id = id;
        this.nome = nome;
        this.prenome = prenome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrenome() {
        return prenome;
    }

    public void setPrenome(String prenome) {
        this.prenome = prenome;
    }

    @Override
    public String toString() {
        return "Pilote{" + "id=" + id + ", nome=" + nome + ", prenome=" + prenome + '}';
    }
    
    
    
}
