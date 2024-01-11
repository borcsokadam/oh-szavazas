package com.oh.szavazas.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HibaUzenetDTO {
    @JsonProperty("hiba_uzenet")
    private String hibaUzenet;

    public HibaUzenetDTO(String hibaUzenet) {
        this.hibaUzenet = hibaUzenet;
    }

    public String getHibaUzenet() {
        return hibaUzenet;
    }
}