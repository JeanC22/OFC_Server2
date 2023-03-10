/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import usuario.Admin;
import usuario.Client;

import comments.Coment;
import sponsors.Sponsor;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * This class is where the Entities and their relationships are declared, 
 * as well as the queries to be performed in the DB.
 * @author Iker
 */
@Entity
@Table(name = "EVENTS", schema = "OFC_DB")
@NamedQueries({
    @NamedQuery(name = "findEvents" , query = "select e from Event e"),
    
    @NamedQuery(name = "findEventByName" ,query = "select e from Event e where e.name = :name"),
    
    @NamedQuery(name = "findEventByActivity", query = "select e from Event e where e.activity Like :activity"),
    
    @NamedQuery(name = "findEventByDate", query = "select e from Event e where e.date = :date")
       
})

@XmlRootElement
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    private String activity;
    
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(as=Date.class)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
    private Date date;
    
    private Integer capacity;
    
    private Float price;
    
    private String place;

    /**
     * @associates <{ofc_uml.User}>
     */
    @ManyToOne(fetch = FetchType.EAGER)//, cascade= MERGE)
    private Admin admin;

    @ManyToMany
    @JoinTable(name = "event_sponsor", schema = "OFC_DB")
    private Set<Sponsor> ads;
   
    @OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE)
    private List<Coment> coments;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="event_client", schema="OFC_DB")
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

   
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @XmlTransient
    public Set<Sponsor> getAds() {
        return ads;
    }

    public void setAds(Set<Sponsor> ads) {
        this.ads = ads;
    }

    @XmlTransient
    public List<Coment> getComents() {
        return coments;
    }

    public void setComents(List<Coment> coments) {
        this.coments = coments;
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
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}
