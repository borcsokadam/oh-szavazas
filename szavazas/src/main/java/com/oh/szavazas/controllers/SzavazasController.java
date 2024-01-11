package com.oh.szavazas.controllers;

import com.oh.szavazas.dtos.HibaUzenetDTO;
import com.oh.szavazas.models.Szavazas;
import com.oh.szavazas.services.SzavazasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/szavazasok")
public class SzavazasController {
    private SzavazasService szavazasService;

    @Autowired
    public SzavazasController(SzavazasService szavazasService) {
        this.szavazasService = szavazasService;
    }

    @PostMapping(path = "/szavazas")
    public ResponseEntity<?> saveSzavazas(@RequestBody Szavazas szavazas) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(szavazasService.saveSzavazas(szavazas));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HibaUzenetDTO(e.getMessage()));
        }
    }

    @GetMapping(path = "/szavazat")
    public ResponseEntity<?> getSzavazat(@RequestParam Long szavazas, @RequestParam String kepviselo) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(szavazasService.getSzavazat(szavazas, kepviselo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HibaUzenetDTO(e.getMessage()));
        }
    }

    @GetMapping(path = "/eredmenyek/{szavazasId}")
    public ResponseEntity<?> getEredmenyek(@PathVariable Long szavazasId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(szavazasService.getEredmenyek(szavazasId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HibaUzenetDTO(e.getMessage()));
        }
    }

    @GetMapping(path = "/napi-szavazasok/{adottNap}")
    public ResponseEntity<?> getEredmenyek(@PathVariable String adottNap) {
        return ResponseEntity.status(HttpStatus.OK).body(szavazasService.getNapiSzavazasok(adottNap));
    }

    @GetMapping(path = "/kepviselo-reszvetel-atlag")
    public ResponseEntity<?> getKepviseloAtlagReszvetel(@RequestParam String idoszakKezdete, @RequestParam String idoszakVege) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(szavazasService.getKepviseloAtlagReszvetel(idoszakKezdete, idoszakVege));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HibaUzenetDTO(e.getMessage()));
        }
    }
}
