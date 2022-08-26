package com.myCompagny.ErrorNote.ErrorNote.Repositorys;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Solutions;
import org.springframework.data.jpa.repository.JpaRepository;

// On étend de l'interface JPA Repository avec <Entity name, Long>
public interface RepositorySolutions extends JpaRepository<Solutions, Long> {

}
