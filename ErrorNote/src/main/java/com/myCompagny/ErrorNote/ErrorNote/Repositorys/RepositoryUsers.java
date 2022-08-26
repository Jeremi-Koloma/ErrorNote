package com.myCompagny.ErrorNote.ErrorNote.Repositorys;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Users;
import org.springframework.data.jpa.repository.JpaRepository;

// Cette classe va Etendre de JPA Repository avec <Entity name> Long
public interface RepositoryUsers extends JpaRepository<Users, Long> {

}
