package com.myCompagny.ErrorNote.ErrorNote.Modeles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity // Identifier la classe comme Entity;
@Table(name = "ETATPROBLEMES") // Donner un nom à notre Entity;
@Getter // Générer les getters;
@Setter // Générer les Setters;
@NoArgsConstructor // Générer un constructeur sans argument;
public class EtatProblemes {
    @Id // Identifier ça comme notre id;
    @GeneratedValue (strategy = GenerationType.IDENTITY) // PRIMARY Key and Auto-Intcrementation;
    private Long idEtatProblemes;

    @Column(length = 15)
    private String EtatProblemes;
}
