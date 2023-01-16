/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;


import comments.Coment;
import event.Event;
import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import routine.Routine;

/**
 *
 * @author 2dam
 */
@Entity
@DiscriminatorValue("UC")
@XmlRootElement
public class Client extends User implements Serializable {

    private static final long serialVersionUID = 1L;
  
    @OneToMany(targetEntity = Coment.class, mappedBy = "comClie")
    private List<Coment> comentarios;
    
    @OneToMany(mappedBy = "clie")
    private List<Routine> rutinas;
    
    @ManyToMany
    private List<Event> events;

    @XmlTransient
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }    
    
    @XmlTransient
    public List<Coment> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Coment> comentarios) {
        this.comentarios = comentarios;
    }

    @XmlTransient
    public List<Routine> getRutinas() {
        return rutinas;
    }

    public void setRutinas(List<Routine> rutinas) {
        this.rutinas = rutinas;
    }

  
    
}
