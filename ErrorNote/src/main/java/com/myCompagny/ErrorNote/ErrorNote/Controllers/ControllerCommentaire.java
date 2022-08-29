package com.myCompagny.ErrorNote.ErrorNote.Controllers;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Commentaires;
import com.myCompagny.ErrorNote.ErrorNote.Services.ServiceCommentaire;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "hello", description = "Les fonctionnalités de mon API de ErroNote ")
@RestController
@RequestMapping("/commentaire")
@AllArgsConstructor // un constructeur avec tous les arguments pour l'injections de notre repository;
public class ControllerCommentaire {
    // Injectons notre ServiceCommentaire;
    private final ServiceCommentaire serviceCommentaire;

    // La méthode qui va nous permettre de faire un commentaire;
    @ApiOperation(value = "Ajouter un Commentaire")
    @PostMapping("/create")
    public Commentaires create(@RequestBody Commentaires commentaires){
        return serviceCommentaire.creer(commentaires);
    }

    // Controller pour la méthode qui va afficher tous les commentaires;
    @ApiOperation(value = "Afficher tous les Commentaires")
    @GetMapping("/read")
    public List<Commentaires> read(){
        return serviceCommentaire.lire();
    }
}
