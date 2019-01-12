
package classes;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author medaimane
 * 
 * Passagers (Code_Passager, Nom_ Passager, Pre_ Passager, Num_Passport, Categorie, Num_Tel)
 */
public class Passager implements Serializable {
    
    private static final long serialVersionUID = 9177103522343277451L;
    
    private Integer id;
    private String nome;
    private String prenome;
    private Integer codePassport;
    private String codeTel;
    private String category;

    public Passager() {
    }

    public Passager(String nome, String prenome, Integer codePassport, String codeTel, String category) {
        this.nome = nome;
        this.prenome = prenome;
        this.codePassport = codePassport;
        this.codeTel = codeTel;
        this.category = category;
    }

    public Passager(Integer id, String nome, String prenome, Integer codePassport, String codeTel, String category) {
        this.id = id;
        this.nome = nome;
        this.prenome = prenome;
        this.codePassport = codePassport;
        this.codeTel = codeTel;
        this.category = category;
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

    public Integer getCodePassport() {
        return codePassport;
    }

    public void setCodePassport(Integer codePassport) {
        this.codePassport = codePassport;
    }

    public String getCodeTel() {
        return codeTel;
    }

    public void setCodeTel(String codeTel) {
        this.codeTel = codeTel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Passager{" + "id=" + id + ", nome=" + nome + ", prenome=" + prenome + ", codePassport=" + codePassport + ", codeTel=" + codeTel + ", category=" + category + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.prenome);
        hash = 53 * hash + Objects.hashCode(this.codePassport);
        hash = 53 * hash + Objects.hashCode(this.codeTel);
        hash = 53 * hash + Objects.hashCode(this.category);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Passager other = (Passager) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.prenome, other.prenome)) {
            return false;
        }
        if (!Objects.equals(this.codePassport, other.codePassport)) {
            return false;
        }
        if (!Objects.equals(this.codeTel, other.codeTel)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
