package com.myCompagny.ErrorNote.ErrorNote.Repositorys;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Problemes;
import com.myCompagny.ErrorNote.ErrorNote.Modeles.Solutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// On étend de l'interface JPA Repository avec <Entity name, Long>
public interface RepositorySolutions extends JpaRepository<Solutions, Long> {
    // Trouver une Solution à travers un probleme donné;
    Solutions findByProblemes(Problemes problemes);

    // Afficher une seule solution avec son problème et tous les commentaires;
    @Query(value = "SELECT * FROM solutions,problemes,users,commentaires WHERE solutions.id_problemes=:idSolutions AND problemes.id_users=users.id_users AND commentaires.id_solutions=solutions.id_solutions;",nativeQuery = true)
    Solutions solution(Long idSolutions);
}
