package com.oh.szavazas.dtos;

public class AtlagResponseDTO {
    private Double atlag;

    public AtlagResponseDTO(Double atlag) {
        this.atlag = atlag;
    }

    public Double getAtlag() {
        return atlag;
    }

    public void setAtlag(Double atlag) {
        this.atlag = atlag;
    }
}