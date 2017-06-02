package cn.spiderpig.annotation.one2one.one;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="t_car")
public class Car {

    private Integer id;

    private String name;

    private Person person;

    @Id
    @Column(name = "c_id")
    @GenericGenerator(name = "for", strategy = "foreign", parameters = { @Parameter(name = "property", value = "person") })
    @GeneratedValue(generator = "for")
    public Integer getId() {
        return id;
    }

    @Column(name = "c_name")
    public String getName() {
        return name;
    }

    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL)
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
