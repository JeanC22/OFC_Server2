/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 2dam
 */
@Entity
@DiscriminatorValue("UC")
@XmlRootElement
public class Client extends User implements Serializable {

    private static final long serialVersionUID = 1L;
  
    
    @OneToMany(mappedBy = "comClie")
    private Set<Coment> comentarios;
    
    @OneToMany(mappedBy = "clie")
    private Set<Routine> rutinas;
    
    @ManyToMany
    private Set<Event> events;

    @XmlTransient
    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }    
    
    @XmlTransient
    public Set<Coment> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Coment> comentarios) {
        this.comentarios = comentarios;
    }

    @XmlTransient
    public Set<Routine> getRutinas() {
        return rutinas;
    }

    public void setRutinas(Set<Routine> rutinas) {
        this.rutinas = rutinas;
    }

  
    
}
