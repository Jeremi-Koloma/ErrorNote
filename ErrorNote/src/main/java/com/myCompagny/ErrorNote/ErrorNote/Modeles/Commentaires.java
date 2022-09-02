package com.myCompagny.ErrorNote.ErrorNote.Modeles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity // Générer notre Entity;
@Table(name = "COMMENTAIRES") // Donner un nom à notre Entity;
@Getter // Générer les getters;
@Setter // Générer les setters;
@NoArgsConstructor // un constructeur sans argument;
public class Commentaires {
    @Id // Générer notre id;
    @GeneratedValue (strategy = GenerationType.IDENTITY) // Générer notre PRIMARY Key and Auto-Increment;
    private Long idCommentaires;

    private String commentaires;

    // Cardinatlité entre User et Commentaires;
    @ManyToOne
    @JoinColumn(name = "idUsers") // Donner un Nom spécifique à notre Clé Etranger;
    private Users users;

    // Cardinatlité entre Commentaires et Solutions;
    @ManyToOne
    @JoinColumn(name = "idSolutions") // Donner un Nom spécifique à notre Clé Etranger;
    private Solutions solutions;

    public Commentaires(String commentaires, Users users, Solutions solutions) {
        this.commentaires = commentaires;
        this.users = users;
        this.solutions = solutions;
    }
}
