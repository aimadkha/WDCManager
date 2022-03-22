package com.code.windigitalcenter.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @Column(name = "id_participant", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_participant", nullable = false)
    private User user;

    @Column(name = "domain", length = 64)
    private String domain;

    @Column(name = "structure", length = 64)
    private String structure;

    @OneToMany(mappedBy = "idParticipant")
    private Set<Listparticipant> listparticipants = new LinkedHashSet<>();

    public Set<Listparticipant> getListparticipants() {
        return listparticipants;
    }

    public void setListparticipants(Set<Listparticipant> listparticipants) {
        this.listparticipants = listparticipants;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}