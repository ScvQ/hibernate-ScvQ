package cn.spiderpig.annotation.one2one.three;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_person_id", unique = true)
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
