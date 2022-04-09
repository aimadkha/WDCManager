package com.code.windigitalcenter.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer id;

    @Column(name = "nom_user", length = 20)
    private String nomUser;

    @Column(name = "prenom_user", length = 20)
    private String prenomUser;

    @Column(name = "genre_user", length = 10)
    private String genreUser;

    @Column(name = "telephone", length = 25)
    private String telephone;

    @Column(name = "email", length = 55)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "state_user")
    private Boolean stateUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role")
    private Role idRole;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Transient
    private String token;

    public User() {
    }

    public User(Integer id, String nomUser, String prenomUser, String genreUser, String telephone, String email, String password) {
        this.id = id;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.genreUser = genreUser;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
    }

    public User(Integer id, String nomUser, String prenomUser, String genreUser, String telephone, String email, String password, Boolean stateUser, Role idRole) {
        this.id = id;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.genreUser = genreUser;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.stateUser = stateUser;
        this.idRole = idRole;
    }

    public User(String nomUser, String prenomUser, String genreUser, String telephone, String email, String password, Boolean stateUser, Role idRole) {
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.genreUser = genreUser;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.stateUser = stateUser;
        this.idRole = idRole;
    }

    public User(Integer id, String nomUser, String prenomUser, String genreUser, String telephone, String email, String password, Boolean stateUser) {
        this.id = id;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.genreUser = genreUser;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.stateUser = stateUser;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    public Boolean getStateUser() {
        return stateUser;
    }

    public void setStateUser(Boolean stateUser) {
        this.stateUser = stateUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGenreUser() {
        return genreUser;
    }

    public void setGenreUser(String genreUser) {
        this.genreUser = genreUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}