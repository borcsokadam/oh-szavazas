package com.oh.szavazas.dtos;

import com.oh.szavazas.models.Szavazas;
import com.oh.szavazas.models.Szavazat;

import java.util.ArrayList;
import java.util.List;

public class SzavazasResponseDTO {
    private String idopont;
    private String targy;
    private String tipus;
    private String elnok;
    private String eredmeny;
    private Integer kepviselokSzama;
    private List<SzavazatResponseDTO> szavazatok;

    public SzavazasResponseDTO(Szavazas szavazas, EredmenyekResponseDTO eredmenyekResponseDTO) {
        this.idopont = szavazas.getIdopont();
        this.targy = szavazas.getTargy();
        this.tipus = szavazas.getTipus();
        this.elnok = szavazas.getElnok();
        this.eredmeny = eredmenyekResponseDTO.getEredmeny();
        this.kepviselokSzama = eredmenyekResponseDTO.getKepviselokSzama();
        szavazatok = new ArrayList<>();
        for (Szavazat szavazat : szavazas.getSzavazatok()) {
            SzavazatResponseDTO szavazatResponseDTO = new SzavazatResponseDTO(szavazat);
            szavazatok.add(szavazatResponseDTO);
        }
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

    public List<SzavazatResponseDTO> getSzavazatok() {
        return szavazatok;
    }

    public void setSzavazatok(List<SzavazatResponseDTO> szavazatok) {
        this.szavazatok = szavazatok;
    }

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
}