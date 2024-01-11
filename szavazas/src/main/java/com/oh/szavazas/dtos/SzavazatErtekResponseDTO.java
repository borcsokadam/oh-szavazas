package com.oh.szavazas.dtos;

public class SzavazatErtekResponseDTO {
    private String szavazat;

    public SzavazatErtekResponseDTO(String szavazat) {
        this.szavazat = szavazat;
    }

    public String getSzavazat() {
        return szavazat;
    }

    public void setSzavazat(String szavazat) {
        this.szavazat = szavazat;
    }
}