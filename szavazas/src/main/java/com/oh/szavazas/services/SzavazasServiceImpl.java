package com.oh.szavazas.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import com.oh.szavazas.dtos.SzavazasResponseDTO;
import com.oh.szavazas.dtos.SzavazatResponseDTO;
import com.oh.szavazas.models.Szavazas;
import com.oh.szavazas.models.Szavazat;
import com.oh.szavazas.repositories.SzavazasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SzavazasServiceImpl implements SzavazasService {
    private SzavazasRepository szavazasRepository;

    @Autowired
    public SzavazasServiceImpl(SzavazasRepository szavazasRepository) {
        this.szavazasRepository = szavazasRepository;
    }

    @Override
    public SzavazasResponseDTO save(Szavazas szavazas) {
        jsonEllenorzes(szavazas);
        if (!kepviseloEgySzavazat(szavazas)) {
            throw new RuntimeException("Egy kepviselonek egy szavazata lehet!");
        }
        if (!elnokSzavazat(szavazas)) {
            throw new RuntimeException("Elnoknek nincs szavazata!");
        }
        if (idopontEgySzavazas(szavazas)) {
            throw new RuntimeException("Ebben az idopontban mar tortent szavazas!");
        }
        Szavazas savedSzavazas = szavazasRepository.save(szavazas);
        return new SzavazasResponseDTO(savedSzavazas.getId());
    }

    @Override
    public SzavazatResponseDTO get(Long szavazas, String kepviselo) {
        Optional<Szavazas> aktualisSzavazas = szavazasRepository.findById(szavazas);
        if (aktualisSzavazas.isEmpty()) {
            throw new RuntimeException("Nincs ilyen id-val szavazas!");
        }
        for (Szavazat szavazat : aktualisSzavazas.get().getSzavazatok()) {
            if (szavazat.getKepviselo().equals(kepviselo)) {
                return new SzavazatResponseDTO(szavazat.getSzavazat());
            }
        }
        throw new RuntimeException("Nem szavazott a megadott kepviselo ezen a szavazason!");
    }

    private boolean kepviseloEgySzavazat(Szavazas szavazas) {
        StringBuilder kepviselok = new StringBuilder();
        List<Szavazat> szavazatok = szavazas.getSzavazatok();
        for (Szavazat szavazat : szavazatok) {
            if (kepviselok.toString().contains(szavazat.getKepviselo())) {
                return false;
            }
            kepviselok.append(szavazat.getKepviselo());
        }
        return true;
    }

    private boolean elnokSzavazat(Szavazas szavazas) {
        String elnok = szavazas.getElnok();
        List<Szavazat> szavazatok = szavazas.getSzavazatok();
        for (Szavazat szavazat : szavazatok) {
            if (szavazat.getKepviselo().equals(elnok)) {
                return true;
            }
        }
        return false;
    }

    private boolean idopontEgySzavazas(Szavazas szavazas) {
        return szavazasRepository.findAllByIdopont(szavazas.getIdopont()).isPresent();
    }

    private void jsonEllenorzes(Szavazas szavazas) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaFactory semaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        InputStream semaStream = getClass().getResourceAsStream("/szavazasJsonSema.json");
        JsonSchema sema = semaFactory.getSchema(semaStream);
        JsonNode szavazasJson = null;
        try {
            szavazasJson = objectMapper.readTree(objectMapper.writeValueAsString(szavazas));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Set<ValidationMessage> ellenorzes = sema.validate(szavazasJson);
        if (!ellenorzes.isEmpty()) {
            throw new RuntimeException(ellenorzes.toString());
        }
    }
}