package com.oh.szavazas.services;

import com.oh.szavazas.dtos.EredmenyekResponseDTO;
import com.oh.szavazas.dtos.SzavazasResponseDTO;
import com.oh.szavazas.dtos.SzavazatResponseDTO;
import com.oh.szavazas.models.Szavazas;

public interface SzavazasService {
    SzavazasResponseDTO saveSzavazas(Szavazas szavazas);
    SzavazatResponseDTO getSzavazat(Long szavazas, String kepviselo);
    EredmenyekResponseDTO getEredmenyek(Long szavazasId);
}
