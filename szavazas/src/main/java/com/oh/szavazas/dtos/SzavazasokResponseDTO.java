package com.oh.szavazas.dtos;

import com.oh.szavazas.models.Szavazas;

import java.util.List;

public class SzavazasokResponseDTO {
    private List<Szavazas> szavazasok;

    public SzavazasokResponseDTO(List<Szavazas> szavazasok) {
        this.szavazasok = szavazasok;
    }

    public List<Szavazas> getSzavazasok() {
        return szavazasok;
    }

    public void setSzavazasok(List<Szavazas> szavazasok) {
        this.szavazasok = szavazasok;
    }
}
