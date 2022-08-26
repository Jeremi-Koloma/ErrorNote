package com.myCompagny.ErrorNote.ErrorNote.Controllers;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Commentaires;
import com.myCompagny.ErrorNote.ErrorNote.Services.ServiceCommentaire;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaire")
@AllArgsConstructor // un constructeur avec tous les arguments pour l'injections de notre repository;
public class ControllerCommentaire {
    // Injectons notre ServiceCommentaire;
    private final ServiceCommentaire serviceCommentaire;

    // La méthode qui va nous permettre de faire un commentaire;
    @PostMapping("/create")
    public Commentaires create(@RequestBody Commentaires commentaires){
        return serviceCommentaire.creer(commentaires);
    }

    // Controller pour la méthode qui va afficher tous les commentaires;
    @GetMapping("/read")
    public List<Commentaires> read(){
        return serviceCommentaire.lire();
    }
}
