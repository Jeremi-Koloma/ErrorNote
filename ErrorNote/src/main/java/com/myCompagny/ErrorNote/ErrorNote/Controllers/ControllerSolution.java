package com.myCompagny.ErrorNote.ErrorNote.Controllers;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Problemes;
import com.myCompagny.ErrorNote.ErrorNote.Modeles.Solutions;
import com.myCompagny.ErrorNote.ErrorNote.Services.ServiceProbleme;
import com.myCompagny.ErrorNote.ErrorNote.Services.ServiceSolutions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Api(value = "hello", description = "Les fonctionnalités de mon API de ErroNote ")
@RestController // identifier la classe comme un controller;
@RequestMapping("/solutions")
@AllArgsConstructor // un constructeur avec tous les argument pour l'injection de notre serviceSolution;
public class ControllerSolution {
    // injectons notre serviceSolution;
    private final ServiceSolutions serviceSolutions;
    private final ServiceProbleme serviceProbleme;

    // Controller qui va créer une solution;
    @ApiOperation(value = "Créer une Solution")
    @PostMapping("/create/{idProblemes}")
    public String create(@RequestBody Solutions solutions, @PathVariable Long idProblemes){

        try{
            Problemes problemes = serviceProbleme.trouverProblemeParId(idProblemes);
            Solutions solutions1 = serviceSolutions.donnerSolutionParProbleme(problemes);
            // Vérifier si le probleme exite déja;
            if (problemes != null){
                // Vérifier si la solution n'existe pas, on l'ajoute;
                if (solutions1 == null){
                    solutions.setProblemes(problemes); // On mets le probleme dans solution avant de créer;
                    serviceSolutions.creer(solutions);
                    return "Solution ajoutée avec succes !";
                }else {
                    return "Cette solution existe déjà !";
                }
            }
        } catch (NoSuchElementException e) { // Sinon si le probleme n'existe pas;
            return "Ce problème exite pas !";
        }
        return "erreur";
    }

    // Controller qui va afficher toutes les solutions disponible;
    @ApiOperation(value = "Afficher toutes les Solutions")
    @GetMapping("/read")
    public List<Solutions> read(){
        return serviceSolutions.lire();
    }

    // Controller qui va nous permettre de modifier une solution;
    @ApiOperation(value = "Modifier une Solution")
    @PutMapping("/update/{idSolutions}")
    public Solutions update(@PathVariable Long idSolutions, @RequestBody Solutions solutions){
        return serviceSolutions.modifier(idSolutions, solutions);
    }

    // Controller qui va nous permettre de Supprimer une solution;
    @ApiOperation(value = "Supprimer une Solution")
    @DeleteMapping("/delete/{idSolutions}")
    public String delete(@PathVariable Long idSolutions){
        return serviceSolutions.supprimer(idSolutions);
    }



}
