/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sponsors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import entities.Admin;
import entities.Event;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elias
 */
@Entity
@Table(name = "sponsors", schema = "ofc_db")
//consultas
@NamedQueries({
    @NamedQuery(name="findAllSponsor", 
        query="SELECT s FROM Sponsor s"
    ),
    @NamedQuery(name ="findSponsorByName", 
        query="SELECT s FROM Sponsor s WHERE s.name = :name"
    ),
    @NamedQuery(name ="findSponsorByDate", 
        query="SELECT s FROM Sponsor s WHERE s.date = :date"
    )
})

@XmlRootElement
public class Sponsor implements Serializable {

  private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer phone;

    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(as=Date.class)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm")
    private Date date;

    private Boolean status;
    
    @ManyToMany
    private Set<Event> events;
    
    @ManyToOne
    private Admin admin;

    @Enumerated(EnumType.ORDINAL)
    private AdType ad;
    
    

    public Sponsor() {
        super();
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setEventos(Set<Event> eventos) {
        this.events = eventos;
    }

    public Set<Event> getEventos() {
        return events;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getNombre() {
        return name;
    }

    public void setTelefono(Integer telefono) {
        this.phone = telefono;
    }

    public Integer getTelefono() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAnuncio(AdType anuncio) {
        this.ad = anuncio;
    }

    public AdType getAnuncio() {
        return ad;
    }

    public void setFecha(Date fecha) {
        this.date = fecha;
    }

    public Date getFecha() {
        return date;
    }

    public void setEstado(Boolean estado) {
        this.status = estado;
    }

    public Boolean getEstado() {
        return status;
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
        if (!(object instanceof Sponsor)) {
            return false;
        }
        Sponsor other = (Sponsor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.User1[ id=" + id + " ]";
    }
    
    
}
