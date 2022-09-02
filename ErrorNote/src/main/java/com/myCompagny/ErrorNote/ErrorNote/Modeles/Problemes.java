package com.myCompagny.ErrorNote.ErrorNote.Modeles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity // Identifier la classe comme une Entity;
@Table(name = "PROBLEMES") // Donner un nom à notre Entity;
@Getter // Générer les Getters
@Setter // Générer les Setters;
@NoArgsConstructor // Un constructeurs sans arguments;
@AllArgsConstructor
public class Problemes {
    @Id // Identifier cet attribue comme un id;
    @GeneratedValue (strategy = GenerationType.IDENTITY) // PRIMARY Key and Auto-Incrementation;
    private Long idProblemes;

    private String titreProblemes;

    private String descriptionProblemes;

    private String technologies;

    private String etatProblemes;

    // Cardinatlité entre Problemes et Users;
    @ManyToOne
    @JoinColumn(name = "idUsers") // Donner un Nom spécifique à notre Clé Etranger;
    private Users users;

    public Problemes(String titreProblemes, String descriptionProblemes, String technologies, String etatProblemes, Users users) {
        this.titreProblemes = titreProblemes;
        this.descriptionProblemes = descriptionProblemes;
        this.technologies = technologies;
        this.etatProblemes = etatProblemes;
        this.users = users;
    }
}
