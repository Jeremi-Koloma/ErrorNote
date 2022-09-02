package com.myCompagny.ErrorNote.ErrorNote.Services;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Problemes;
import com.myCompagny.ErrorNote.ErrorNote.Modeles.Solutions;
import com.myCompagny.ErrorNote.ErrorNote.Modeles.Users;
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
    public Object creer(Solutions solutions,String mail, String mot2passe) { // On retourne repositorySolution.la méthode (save) Pour la persistence des données dans la base de donéé
      Problemes p=new Problemes();
       p= solutions.getProblemes();
        Users u=new Users();
      u= p.getUsers();
      Solutions k=new Solutions();
     k= repositorySolutions.findByProblemes(p);
     if (k==null){
       if (u.getEmail().equals(mail) && u.getPassword().equals(mot2passe)){
        return repositorySolutions.save(solutions);}
       else
           return "mot de passe ou email incorrect";
    }
     else
         return "ce probleme a deja une solution";
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

    @Override // Implementation de la méthode qui permet d'afficher une seule solution, son probleme, ses commentaires;
    public Object solution(Long idPoblemes) {
        //
        Solutions solutions = repositorySolutions.solution(idPoblemes);
        // Vérifions si la Solution est null;
        if (solutions == null){
            return "Pas de solution relative à ce problème !";
        }else { // Sinon si c'est pas null;
            return
                    "Nom : " + solutions.getProblemes().getUsers().getNom()+
                    "\nPrénom : " + solutions.getProblemes().getUsers().getPrenom()+
                    "\nContact : " + solutions.getProblemes().getUsers().getNumero()+
                    "\nTitre du Problème : " + solutions.getProblemes().getTitreProblemes()+
                    "\nDescription du Problème : " + solutions.getProblemes().getDescriptionProblemes()+
                    "\nTechnologie : " + solutions.getProblemes().getTechnologies()+
                    "\nEtat du problème : " + solutions.getProblemes().getEtatProblemes()+
                    "\nSolution du Problème : " + solutions.getSolutions()+
                    "\nDescription du Solution : " + solutions.getDescriptionSolutions()+
                    "\nRessources : " + solutions.getRessources()+
                    "\nMéthodologie de Recherches : " + solutions.getMethodologieRecherche()+
                    "\nTemps passer sur le Problème : " + solutions.getEstimation();
        }
    }


}
