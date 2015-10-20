package project.persistence.entities;

import javax.persistence.*;
/**
 * Created by Jakob on 17.10.2015.
 */

// The system generates a table schema based on this class for this entity.
// We'll uncomment the entity and table once we get the dependency going.
//@Entity
//@Table(name = "Surveys") // we specify a table name here
public class Survey {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String questionNumber;


    public Survey(String name, String questionNumber) {
        this.name = name;
        this.questionNumber = questionNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

}
