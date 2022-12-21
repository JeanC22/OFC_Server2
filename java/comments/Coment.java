/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comments;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import entities.Client;
import entities.Event;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Entity representing comments for users. It contains the following
 * fields: Long id, Date publication_date, Date modification_date,
 * String message, Integer valoration,Boolean privacity, String subject,
 * Client comCli and Event event 
 * @author Jeanpierr Caraballo
 */
@Entity
@Table(name = "coments", schema = "OFC_DB")
 @NamedQueries({
    @NamedQuery(name="coments.findAll",
                query="SELECT c FROM Coment c"),
     
    @NamedQuery(name="coments.findBySubject",
                query="SELECT c FROM Coment c where c.subject = :subject"),   
      
    @NamedQuery(name="coments.OrderByMoreRecent",
                query="SELECT c FROM Coment c ORDER BY c.publication_date DESC"),
  
    @NamedQuery(name="coments.OrderByLastPublicate",
                query="SELECT c FROM Coment c ORDER BY c.publication_date ASC"),
   
    @NamedQuery(name="coments.OrderByMoreRate",
                query="SELECT c FROM Coment c ORDER BY c.valoration DESC"),
    
   @NamedQuery(name="coments.OrderByLessRate",
                query="SELECT c FROM Coment c ORDER BY c.valoration ASC"),
 //searches by specific user    
    @NamedQuery(name="MyComments",
                query="SELECT c FROM Coment c WHERE c.id = :comClie"),
    
    @NamedQuery(name="MyComments.OrderByMoreRecent",
                query="SELECT c FROM Coment c WHERE c.id = :comClie ORDER BY c.publication_date DESC"),
    
    @NamedQuery(name="MyComments.OrderBylastPublication",
                query="SELECT c FROM Coment c  WHERE c.id = :comClie ORDER BY c.publication_date ASC"),
    
    @NamedQuery(name="MyComments.OrderByMoreRate",
                query="SELECT c FROM Coment c WHERE c.id = :comClie ORDER BY c.valoration DESC"),
    
    @NamedQuery(name="MyComments.Private",
                query="SELECT c FROM Coment c WHERE c.id = :comClie and c.privacity=1"),
    
    @NamedQuery(name="MyComments.Public",
                query="SELECT c FROM Coment c WHERE c.id = :comClie and c.privacity=0"),
    
    @NamedQuery(name="MyComments.ByEvent",
                query="SELECT c FROM Coment c WHERE c.id = :comClie ORDER BY c.event")
})
@XmlRootElement
public class Coment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private ComentId comentid;
    
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(as=Date.class)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm")
    private Date publication_date;
    
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(as=Date.class)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm")
    private Date modification_date;
    
    private String message;
    
    private Integer valoration;
    
    private Boolean privacity;

    private String subject;
    @ManyToOne 
    @JoinColumn(name="comClie_id")
    private Client comClie;
    
    @ManyToOne
 @JoinColumn(name="event_id")
    private Event event;

    public ComentId getComentid() {
        return comentid;
    }

    public void setComentid(ComentId comentid) {
        this.comentid = comentid;
    }

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public Date getModification_date() {
        return modification_date;
    }

    public void setModification_date(Date modification_date) {
        this.modification_date = modification_date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getValoration() {
        return valoration;
    }

    public void setValoration(Integer valoration) {
        this.valoration = valoration;
    }

    public Boolean getPrivacity() {
        return privacity;
    }

    public void setPrivacity(Boolean privacity) {
        this.privacity = privacity;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public Client getComClie() {
        return comClie;
    }

    public void setComClie(Client comClie) {
        this.comClie = comClie;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Coment{" + "comentid=" + comentid + ", publication_date=" + publication_date + ", modification_date=" + modification_date + ", message=" + message + ", valoration=" + valoration + ", privacity=" + privacity + ", subject=" + subject + ", comClie=" + comClie + ", event=" + event + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.comentid);
        hash = 71 * hash + Objects.hashCode(this.publication_date);
        hash = 71 * hash + Objects.hashCode(this.modification_date);
        hash = 71 * hash + Objects.hashCode(this.message);
        hash = 71 * hash + Objects.hashCode(this.valoration);
        hash = 71 * hash + Objects.hashCode(this.privacity);
        hash = 71 * hash + Objects.hashCode(this.subject);
        hash = 71 * hash + Objects.hashCode(this.comClie);
        hash = 71 * hash + Objects.hashCode(this.event);
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
        final Coment other = (Coment) obj;
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        if (!Objects.equals(this.comentid, other.comentid)) {
            return false;
        }
        if (!Objects.equals(this.publication_date, other.publication_date)) {
            return false;
        }
        if (!Objects.equals(this.modification_date, other.modification_date)) {
            return false;
        }
        if (!Objects.equals(this.valoration, other.valoration)) {
            return false;
        }
        if (!Objects.equals(this.privacity, other.privacity)) {
            return false;
        }
        if (!Objects.equals(this.comClie, other.comClie)) {
            return false;
        }
        if (!Objects.equals(this.event, other.event)) {
            return false;
        }
        return true;
    }



   
}
      
