package com.myCompagny.ErrorNote.ErrorNote.Controllers;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Solutions;
import com.myCompagny.ErrorNote.ErrorNote.Services.ServiceSolutions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "hello", description = "Les fonctionnalités de mon API de ErroNote ")
@RestController // identifier la classe comme un controller;
@RequestMapping("/solutions")
@AllArgsConstructor // un constructeur avec tous les argument pour l'injection de notre serviceSolution;
public class ControllerSolution {
    // injectons notre serviceSolution;
    private final ServiceSolutions serviceSolutions;

    // Controller qui va créer une solution;
    @ApiOperation(value = "Créer une Solution")
    @PostMapping("/create")
    public Solutions create(@RequestBody Solutions solutions){
        return serviceSolutions.creer(solutions);
    }

    // Controller qui va afficher toutes les solutions disponible;
    @ApiOperation(value = "Afficher toutes les Solutions")
    @GetMapping("/read")
    public List<Solutions> read(){
        return serviceSolutions.lire();
    }
}
