package com.oh.szavazas.dtos;

public class SzavazasIdResponseDTO {
    private Long szavazasId;

    public SzavazasIdResponseDTO(Long szavazasId) {
        this.szavazasId = szavazasId;
    }

    public Long getSzavazasId() {
        return szavazasId;
    }

    public void setSzavazasId(Long szavazasId) {
        this.szavazasId = szavazasId;
    }
}