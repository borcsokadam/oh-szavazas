package com.oh.szavazas.dtos;

public class SzavazatResponseDTO {
    private String szavazat;

    public SzavazatResponseDTO(String szavazat) {
        this.szavazat = szavazat;
    }

    public String getSzavazat() {
        return szavazat;
    }

    public void setSzavazat(String szavazat) {
        this.szavazat = szavazat;
    }
}
