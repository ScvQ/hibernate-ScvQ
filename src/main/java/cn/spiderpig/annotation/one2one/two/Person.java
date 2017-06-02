package cn.spiderpig.annotation.one2one.two;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_person")
public class Person {

    private Integer id;

    private String name;

    private Car car;

    @Id
    @Column(name="c_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    
    @Column(name="c_name")
    public String getName() {
        return name;
    }
    
    @OneToOne(cascade=CascadeType.ALL,mappedBy="person")
    public Car getCar() {
        return car;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public void setName(String name) {
        this.name = name;
    }

    

    public void setCar(Car car) {
        this.car = car;
    }

}
