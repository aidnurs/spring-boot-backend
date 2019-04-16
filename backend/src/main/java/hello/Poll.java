package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String absatz;

    private String label;

    public Poll(){
        this.absatz=null;
        this.label=null;
    }

    public Poll(String absatz){
        this.absatz=absatz;
        this.label=null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbsatz() {
        return absatz;
    }

    public void setAbsatz(String text) {
        this.absatz = absatz;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
