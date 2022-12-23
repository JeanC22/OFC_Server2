/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routine;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import entities.Client;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aritz
 */
@Entity
@Table(name = "ROUTINES", schema = "OFC_DB")
@NamedQueries({
    @NamedQuery(name="consultRoutineByName", query="SELECT r FROM Routine r WHERE r.name= :name"),
    
    @NamedQuery(name="consultAllRoutines", query="SELECT r FROM Routine r"),
    //@NamedQuery(name="consultRoutineByExercise", query="SELECT r FROM Routine r WHERE r.id = (SELECT re.ROUTINES_id FROM routine_exercises re WHERE re.ejercicios_id= :id)"),
    
    @NamedQuery(name="consultAllClientRoutines", query="SELECT r FROM Routine r WHERE r.clie= :clie"),
})
@XmlRootElement
public class Routine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(as=Date.class)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm")
    private Date start_date;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(as=Date.class)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm")
    private Date end_date;
    
    private Double kcal;
    
    @ManyToOne
    private Client clie;

    /**
     * @associates <{ofc_uml.Ejercicio}>
     */
    @ManyToMany
    @JoinTable(name="routine_exercises", schema="OFC_DB")
    private List<Exercise> exercises;
    
    private Float time;

     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClie() {
        return clie;
    }

    public void setClie(Client clie) {
        this.clie = clie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Double getKcal() {
        return kcal;
    }

    public void setKcal(Double kcal) {
        this.kcal = kcal;
    }

    @XmlTransient
    public List<Exercise> getEjercicios() {
        return exercises;
    }

    public void setEjercicios(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }


    public Routine() {
        super();
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
        if (!(object instanceof Routine)) {
            return false;
        }
        Routine other = (Routine) object;
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
