package com.simac.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Area")
public class Area {

    @Id
    @Column(name = "id", nullable = false, length = 6)
    private String id;

    @Column(name = "area", nullable = false, length = 30)
    private String area;

    @Column(name = "in_charge", length = 30)
    private String responsable;

    @Column(name = "contact", length = 8)
    private String contacto;

    // Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getInCharge() {
        return in_charge;
    }

    public void setInCharge(String in_charge) {
        this.in_charge = in_charge;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}

