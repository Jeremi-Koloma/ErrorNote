package com.myCompagny.ErrorNote.ErrorNote.Modeles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity // Identifier cette classe comme Entity;
@Table(name = "SOLUTIONS") // Donner un nom à notre Entity;
@Getter // Générer les getters;
@Setter // Générer les setters;
@NoArgsConstructor // Générer un constructeur sans argument;
public class Solutions {
    @Id // Identifier cet attrubie comme notre id;
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PRIMARY Key and Auto-Incrementation;
    private Long idSolutions;

    private String solutions;

    private String descriptionSolutions;

    private String ressources;

    private String estimation;

    // Cardinatlité entre Solutions et Users;
    @ManyToOne
    @JoinColumn(name = "idUsers") // Donner un Nom spécifique à notre Clé Etranger;
    private Users users;

    // Cardinatlité entre Solutions et Problemes;
    @ManyToOne
    @JoinColumn(name = "idProblemes")
    private Problemes problemes;
}
