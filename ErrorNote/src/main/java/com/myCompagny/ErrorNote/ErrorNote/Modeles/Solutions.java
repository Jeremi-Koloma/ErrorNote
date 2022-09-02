package com.myCompagny.ErrorNote.ErrorNote.Modeles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity // Identifier cette classe comme Entity;
@Table(name = "SOLUTIONS") // Donner un nom à notre Entity;
@Getter // Générer les getters;
@Setter // Générer les setters;
@AllArgsConstructor
@NoArgsConstructor // Générer un constructeur sans argument;
public class Solutions {
    @Id // Identifier cet attrubie comme notre id;
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PRIMARY Key and Auto-Incrementation;
    private Long idSolutions;

    private String solutions;

    private String descriptionSolutions;

    private String ressources;

    private String methodologieRecherche;

    private String estimation;

    public Solutions(String solutions, String descriptionSolutions, String ressources, String methodologieRecherche, String estimation, Problemes problemes) {
        this.solutions = solutions;
        this.descriptionSolutions = descriptionSolutions;
        this.ressources = ressources;
        this.methodologieRecherche = methodologieRecherche;
        this.estimation = estimation;
        this.problemes = problemes;
    }

    @OneToOne
    @JoinColumn(name = "idProblemes")
    private Problemes problemes;
}
