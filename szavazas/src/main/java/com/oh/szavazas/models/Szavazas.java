package com.oh.szavazas.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Szavazas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idopont;
    private String targy;
    private String tipus;
    private String elnok;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, mappedBy = "szavazas", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Szavazat> szavazatok;

    public Szavazas() {
        this.szavazatok = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdopont() {
        return idopont;
    }

    public void setIdopont(String idopont) {
        this.idopont = idopont;
    }

    public String getTargy() {
        return targy;
    }

    public void setTargy(String targy) {
        this.targy = targy;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getElnok() {
        return elnok;
    }

    public void setElnok(String elnok) {
        this.elnok = elnok;
    }

    public List<Szavazat> getSzavazatok() {
        return szavazatok;
    }

    public void addSzavazatok(Szavazat szavazat) {
        this.szavazatok.add(szavazat);
        szavazat.setSzavazas(this);
    }
}