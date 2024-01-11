package com.oh.szavazas.dtos;

import com.oh.szavazas.models.Szavazat;

public class SzavazatResponseDTO {
    private String kepviselo;
    private String szavazat;

    public SzavazatResponseDTO(Szavazat szavazat) {
        this.kepviselo = szavazat.getKepviselo();
        this.szavazat = szavazat.getSzavazat();
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
}
