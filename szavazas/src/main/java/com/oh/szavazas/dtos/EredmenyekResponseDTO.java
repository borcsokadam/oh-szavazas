package com.oh.szavazas.dtos;

public class EredmenyekResponseDTO {
    private String eredmeny;
    private Integer kepviselokSzama;
    private Integer igenekSzama;
    private Integer nemekSzama;
    private Integer tartozkodasokSzama;

    public String getEredmeny() {
        return eredmeny;
    }

    public void setEredmeny(String eredmeny) {
        this.eredmeny = eredmeny;
    }

    public Integer getKepviselokSzama() {
        return kepviselokSzama;
    }

    public void setKepviselokSzama(Integer kepviselokSzama) {
        this.kepviselokSzama = kepviselokSzama;
    }

    public Integer getIgenekSzama() {
        return igenekSzama;
    }

    public void setIgenekSzama(Integer igenekSzama) {
        this.igenekSzama = igenekSzama;
    }

    public Integer getNemekSzama() {
        return nemekSzama;
    }

    public void setNemekSzama(Integer nemekSzama) {
        this.nemekSzama = nemekSzama;
    }

    public Integer getTartozkodasokSzama() {
        return tartozkodasokSzama;
    }

    public void setTartozkodasokSzama(Integer tartozkodasokSzama) {
        this.tartozkodasokSzama = tartozkodasokSzama;
    }
}
