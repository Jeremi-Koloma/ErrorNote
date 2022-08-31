package com.myCompagny.ErrorNote.ErrorNote.Services;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Problemes;
import com.myCompagny.ErrorNote.ErrorNote.Modeles.Solutions;
import com.myCompagny.ErrorNote.ErrorNote.Repositorys.RepositorySolutions;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Cette classe va implémenter l'interface de notre ServiceSolutions;
@Service // indentifier la classe comme étends de service métiers;
@AllArgsConstructor // un constructeur avec tous les arguments pour l'injections de notre RepositorySolutions;
public class ServiceSolutionsImpl implements ServiceSolutions{
    // On implemente les 02 méthodes déjà créer dépuis l'interface ServiceSolutions;

    //injectons notre Repository;
    private final RepositorySolutions repositorySolutions;

    @Override // Implementation de la méthode qui va créer une Solutions;
    public Solutions creer(Solutions solutions) { // On retourne repositorySolution.la méthode (save) Pour la persistence des données dans la base de donéé
        return repositorySolutions.save(solutions);
    }

    @Override // Implementation de la méthode qui va Afficher la liste de toutes les Solutions proposer;
    public List<Solutions> lire() { // on retourne la méthode repository.la méthode(findAll) pour afficher touteqs les solutions;
        return repositorySolutions.findAll();
    }

    @Override // Implementation de la méthode qui va nous permettre de modifier une solution;
    public Solutions modifier(Long idSolutions, Solutions solutions) {
        return repositorySolutions.findById(idSolutions) // Cherchons par id;
                .map(s->{
                    s.setSolutions(solutions.getSolutions());
                    s.setDescriptionSolutions(solutions.getSolutions());
                    s.setRessources(solutions.getRessources());
                    s.setMethodologieRecherche(solutions.getMethodologieRecherche());
                    s.setEstimation(solutions.getEstimation());
                    return repositorySolutions.save(s); // Après les modificiatins, on l'enregistre;
                }).orElseThrow(()-> new RuntimeException("Solution non trouvé !"));
    }

    @Override // Implementation de la méthode qui va nous permettre de supprimer une solution;
    public String supprimer(Long idSolutions) {
        repositorySolutions.findById(idSolutions);
        return "Solution Supprimer !";
    }

    @Override // Implementation de la méthode qui permet de donner une solution par Probleme;
    public Solutions donnerSolutionParProbleme(Problemes problemes) {
        return repositorySolutions.findByProblemes(problemes);
    }

}
