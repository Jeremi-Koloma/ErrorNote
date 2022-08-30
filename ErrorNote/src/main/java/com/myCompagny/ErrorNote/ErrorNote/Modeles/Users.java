package com.myCompagny.ErrorNote.ErrorNote.Modeles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity // Idenfifier cette classe comme une Entity;
@Table(name = "USERS") // Donner un nom à notre Entity au niveau de la base de donnée;
@Getter // Générer les Getters;
@Setter // Générer les Setters;
@NoArgsConstructor // Générer un constructeur sans arguments;
public class Users {
    @Id // Identifier cet attribue comme notre iduser;
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Générez notre PRIMARY Key - Auto-Incrementation;
    private Long idUsers;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenom;

    @Column(length = 100)
    private String password;

    @Transient // Ignorer cet champs dans la base de donné;
    private String pwdConfirm;

    @Column(unique = true) // émail unique;
    private String email;

    @Column(length = 30)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "idProfil")
    private Profil profil;

}
