package cn.spiderpig.annotation.one2one.two;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="t_car")
public class Car {

    private Integer id;

    private String name;

    private Person person;

    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @Column(name = "c_name")
    public String getName() {
        return name;
    }

    @JoinColumn(name = "c_person_id")
    @ManyToOne(cascade = CascadeType.ALL)
    public Person getPerson() {
        return person;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
