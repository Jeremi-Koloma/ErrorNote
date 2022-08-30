package com.myCompagny.ErrorNote.ErrorNote.Repositorys;

import com.myCompagny.ErrorNote.ErrorNote.Modeles.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// Cette classe va Etendre de JPA Repository avec <Entity name> Long
public interface RepositoryUsers extends JpaRepository<Users, Long> {
    // Se loger;
    @Query(value = "SELECT * FROM `users` WHERE users.password=? AND users.email=?;",nativeQuery = true)
    Users login(String password, String email);

    // Chercher par Email déja enregistré;
    Users findByEmail(String email);
}
