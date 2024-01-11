package com.oh.szavazas.services;

import com.oh.szavazas.dtos.*;
import com.oh.szavazas.models.Szavazas;

import java.text.SimpleDateFormat;

public interface SzavazasService {
    SzavazasIdResponseDTO saveSzavazas(Szavazas szavazas);
    SzavazatErtekResponseDTO getSzavazat(Long szavazas, String kepviselo);
    EredmenyekResponseDTO getEredmenyek(Long szavazasId);
    SzavazasokResponseDTO getNapiSzavazasok(String adottNap);
    AtlagResponseDTO getKepviseloAtlagReszvetel(String idoszakKezdete, String idoszakVege);
}
