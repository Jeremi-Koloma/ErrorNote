package com.myCompagny.ErrorNote.ErrorNote;

import com.myCompagny.ErrorNote.ErrorNote.Repositorys.RepositoryProfil;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor // constructeur avec tous les arguments pour l'injections de notre repositoryProfil;
@SpringBootApplication
// CommandLineRunner // pour Insertion Automatique des données lors de démarrage de l'App;
public class ErrorNoteAppApplication implements CommandLineRunner {
	private final RepositoryProfil repositoryProfil;
	public static void main(String[] args) {
		SpringApplication.run(ErrorNoteAppApplication.class, args);
	}

	@Override // implementation de CommandLineRunner;
	public void run(String... args) throws Exception {
		// Vérifions si la table profil est vide;
		if(repositoryProfil.findAll().size()==0){
			repositoryProfil.insererProfil();
		}
	}
}
