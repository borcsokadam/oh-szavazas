package com.oh.szavazas.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Szavazat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kepviselo;
    private String szavazat;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JsonBackReference
    private Szavazas szavazas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKepviselo() {
        return kepviselo;
    }

    public void setKepviselo(String kepviselo) {
        this.kepviselo = kepviselo;
    }

    public String getSzavazat() {
        return szavazat;
    }

    public void setSzavazat(String szavazat) {
        this.szavazat = szavazat;
    }

    public Szavazas getSzavazas() {
        return szavazas;
    }

    public void setSzavazas(Szavazas szavazas) {
        this.szavazas = szavazas;
    }
}