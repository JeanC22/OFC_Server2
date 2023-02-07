/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import sponsors.Sponsor;
import event.Event;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 2dam
 */
@Entity
@DiscriminatorValue("UA")
@XmlRootElement(name = "users")
public class Admin extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "admin")
    private Set<Event> events;

    @OneToMany(mappedBy = "admin")
    private Set<Sponsor> sponsors;

    @XmlTransient
    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    @XmlTransient
    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsors(Set<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }

}
