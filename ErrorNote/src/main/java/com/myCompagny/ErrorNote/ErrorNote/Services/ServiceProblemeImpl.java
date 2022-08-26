package com.myCompagny.ErrorNote.ErrorNote.Services;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Problemes;
import com.myCompagny.ErrorNote.ErrorNote.Repositorys.RepositoryProblemes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Cette classe va implémenter l'interface de ServiceProbleme;
@Service // Identifier la classe comme Service;
@AllArgsConstructor // Un constructeur avec tous les arguments pour l'injections de notre RepositoryProblemes;
public class ServiceProblemeImpl implements ServiceProbleme{
    // Ici on implemente les 02 méthodes de l'interface Service;

    //Injectons notre RepositoryProbleme;
    private final RepositoryProblemes repositoryProblemes;

    @Override // implementation de la méthode qui va créer un Probleme;
    public Problemes creer(Problemes problemes) { // On retourne repository.la méthode (save) pour la persistance des données dans la base de donnée;
        return repositoryProblemes.save(problemes);
    }

    @Override // Implementation de la méthode qui va Afficher tous les problemes;
    public List<Problemes> lire() { // On retourner repository.la méthode(findAll) pour afficher tous les problemes;
        return repositoryProblemes.findAll();
    }

    @Override // Implemntation de la méthode qui va pour permettre de faire de recherches par mots clé;
    public Object search(String motCle) {
        // Vérifions si le mot clé est different de null;
        if (motCle != null){
            List<Problemes> problemes = repositoryProblemes.findAll(motCle);
            System.out.println(problemes);
            if (problemes.size() !=0 ){
                return problemes;
            }else {
                return "Cet mots n'existe pas ❌!";
            }
        }
        return repositoryProblemes.findAll(); // on retourne repository.la méthode (findAll)
    }
}
