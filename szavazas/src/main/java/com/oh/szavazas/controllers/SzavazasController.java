package com.oh.szavazas.controllers;

import com.oh.szavazas.dtos.HibaUzenetDTO;
import com.oh.szavazas.models.Szavazas;
import com.oh.szavazas.services.SzavazasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return ResponseEntity.status(HttpStatus.CREATED).body(szavazasService.save(szavazas));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HibaUzenetDTO(e.getMessage()));
        }
    }

    @GetMapping(path = "/szavazat")
    public ResponseEntity<?> getSzavazat(@RequestParam Long szavazas, @RequestParam String kepviselo) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(szavazasService.get(szavazas, kepviselo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HibaUzenetDTO(e.getMessage()));
        }
    }
}
