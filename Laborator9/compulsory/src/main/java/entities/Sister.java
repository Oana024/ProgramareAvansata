package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "sisters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sister.findAll", query = "SELECT s FROM Sister s"),
    @NamedQuery(name = "Sister.findById", query = "SELECT s FROM Sister s WHERE s.id = :id"),
    @NamedQuery(name = "Sister.findByIdCity1", query = "SELECT s FROM Sister s WHERE s.idCity1 = :idCity1"),
    @NamedQuery(name = "Sister.findByIdCity2", query = "SELECT s FROM Sister s WHERE s.idCity2 = :idCity2")})
public class Sister implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_city1")
    private Integer idCity1;
    @Column(name = "id_city2")
    private Integer idCity2;

    public Sister() {
    }

    public Sister(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCity1() {
        return idCity1;
    }

    public void setIdCity1(Integer idCity1) {
        this.idCity1 = idCity1;
    }

    public Integer getIdCity2() {
        return idCity2;
    }

    public void setIdCity2(Integer idCity2) {
        this.idCity2 = idCity2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sister)) {
            return false;
        }
        Sister other = (Sister) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab9.laborator9.entities.Sister[ id=" + id + " ]";
    }

}
