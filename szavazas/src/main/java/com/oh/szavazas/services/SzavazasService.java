package com.oh.szavazas.services;

import com.oh.szavazas.dtos.EredmenyekResponseDTO;
import com.oh.szavazas.dtos.SzavazasIdResponseDTO;
import com.oh.szavazas.dtos.SzavazasokResponseDTO;
import com.oh.szavazas.dtos.SzavazatErtekResponseDTO;
import com.oh.szavazas.models.Szavazas;

public interface SzavazasService {
    SzavazasIdResponseDTO saveSzavazas(Szavazas szavazas);
    SzavazatErtekResponseDTO getSzavazat(Long szavazas, String kepviselo);
    EredmenyekResponseDTO getEredmenyek(Long szavazasId);
    SzavazasokResponseDTO getNapiSzavazasok(String adottNap);
}
