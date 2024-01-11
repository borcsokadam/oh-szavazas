package com.oh.szavazas.dtos;

import com.oh.szavazas.models.Szavazas;

import java.util.ArrayList;
import java.util.List;

public class SzavazasokResponseDTO {
    private List<SzavazasResponseDTO> szavazasok;

    public SzavazasokResponseDTO() {
        szavazasok = new ArrayList<>();
    }

    public SzavazasokResponseDTO(List<SzavazasResponseDTO> szavazasok) {
        this.szavazasok = szavazasok;
    }

    public List<SzavazasResponseDTO> getSzavazasok() {
        return szavazasok;
    }

    public void setSzavazasok(List<SzavazasResponseDTO> szavazasok) {
        this.szavazasok = szavazasok;
    }

    public void addSzavazas(SzavazasResponseDTO szavazasResponseDTO) {
        this.szavazasok.add(szavazasResponseDTO);
    }
}
