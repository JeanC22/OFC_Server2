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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
                query="SELECT c FROM coments c"),
    @NamedQuery(name="coments.findAllByMoreRecent",
                query="SELECT c FROM coments c ORDER BY c.publication_date DESC"),
  
    @NamedQuery(name="findAllCommentsOrderByLastPublicate",
                query="SELECT c FROM COMENTS c ORDER BY C.publication_date ASC")
    /*
    @NamedQuery(name="findAllCommentsOrderByMoreRate",
                query="SELECT c FROM COMENTS c ORDER BY C.valoration DESC"),
    
    @NamedQuery(name="findAllCommentsOrderByLessRate",
                query="SELECT c FROM COMENTS c WHERE ORDER BY C.valoration ASC"),    
 //searches by specific user    
    @NamedQuery(name="findAllMyComments",
                query="SELECT c FROM COMENTS c WHERE c.id=:comClie"),
    
    @NamedQuery(name="findMyCommentsOrderByMoreRecent",
                query="SELECT c FROM COMENTS c WHERE c.id=:comClie ORDER BY C.publication_date DESC"),
    
    @NamedQuery(name="findMyCommentsOrderBylastPublication",
                query="SELECT c FROM COMENTS c  WHERE c.id=:comClie ORDER BY C.publication_date ASC"),
    
    @NamedQuery(name="findMyCommentsOrderByMoreRate",
                query="SELECT c FROM COMENTS c WHERE c.id=:comClie ORDER BY C.valoration DESC"),
    
    @NamedQuery(name="findMyCommentsPrivate",
                query="SELECT c FROM COMENTS c WHERE c.id=:comClie ORDER BY C.privacity=1"),
    
    @NamedQuery(name="findMyCommentsPublic",
                query="SELECT c FROM COMENTS c WHERE c.id=:comClie ORDER BY C.privacity=0"),
    
    @NamedQuery(name="findMyCommentsByEvent",
                query="SELECT c FROM COMENTS c WHERE c.id=:comClie ORDER BY C.event")*/
})
@XmlRootElement
public class Coment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
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
    private Client comClie;
    
    @ManyToOne
    private Event event;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Coment{" + "id=" + id + ", message=" + message + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
      
