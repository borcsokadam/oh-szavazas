package com.oh.szavazas.dtos;

public class SzavazasResponseDTO {
    private Long szavazasId;

    public SzavazasResponseDTO(Long szavazasId) {
        this.szavazasId = szavazasId;
    }

    public Long getSzavazasId() {
        return szavazasId;
    }

    public void setSzavazasId(Long szavazasId) {
        this.szavazasId = szavazasId;
    }
}
