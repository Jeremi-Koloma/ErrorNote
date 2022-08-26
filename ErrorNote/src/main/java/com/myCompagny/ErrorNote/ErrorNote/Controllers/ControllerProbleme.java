package com.myCompagny.ErrorNote.ErrorNote.Controllers;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Problemes;
import com.myCompagny.ErrorNote.ErrorNote.Services.ServiceProbleme;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Identifier la classe comme étant un Controller;
@RequestMapping("/probleme") // le nom de path pour le mapping ou l'URL dans postman;
@AllArgsConstructor // Un constructeur avec tous les arguments pour l'injecton de notre ServiceProblème;
public class ControllerProbleme {
    // Injection notre ServiceProbleme;
    private final ServiceProbleme serviceProbleme;

    // Controllers qui va nous permettre creer un probleme;
    @PostMapping("/create")
    public Problemes create(@RequestBody Problemes problemes){
        return serviceProbleme.creer(problemes);
    }

    // Controllers qui va nous permettre de d'afficher tous les problemes;
    @GetMapping("/read")
    public List<Problemes> read(){
        return serviceProbleme.lire();
    }

    // Controllers qui va nous permettre de d'afficher tous les problemes;
    @GetMapping("/search/{motCle}")
    public Object rechercherProblemes(@PathVariable String motCle){
        System.out.println(motCle);
        return serviceProbleme.search(motCle);
    }
}
