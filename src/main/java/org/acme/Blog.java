package org.acme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Blog extends  PanacheEntity {

    @Column
    public String name = "rishi";

    @Column
    public String author = "automation";

}
