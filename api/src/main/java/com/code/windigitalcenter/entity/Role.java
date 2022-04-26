package com.code.windigitalcenter.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role", nullable = false)
    private Integer id;

    @Column(name = "nom_role", length = 11)
    private String nomRole;

    @OneToMany(mappedBy = "idRole")
    private Set<User> users = new LinkedHashSet<>();

    public Role() {
    }

    public Role(String nomRole) {
        this.nomRole = nomRole;
    }

    public Role(Integer id, String nomRole, Set<User> users) {
        this.id = id;
        this.nomRole = nomRole;
        //this.users = users;
    }

    public Role(Integer id, String nomRole) {
        this.id = id;
        this.nomRole = nomRole;
    }

    //  public Set<User> getUsers() {
    //    return users;
    //}

  //  public void setUsers(Set<User> users) {
    //    this.users = users;
    //}

    public String getNomRole() {
        return nomRole;
    }

    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}