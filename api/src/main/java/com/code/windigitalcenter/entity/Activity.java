package com.code.windigitalcenter.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "activity", indexes = {
        @Index(name = "id_exercice", columnList = "id_exercice")
})
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_activity", nullable = false)
    private Integer id;

    @Column(name = "title_activity", length = 11)
    private String titleActivity;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    @Column(name = "state")
    private Boolean state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_exercice")
    private Exercice idExercice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_responsable")
    private Responsable idResponsable;

    @OneToMany(mappedBy = "idActivity")
    private Set<Listparticipant> listparticipants = new LinkedHashSet<>();

    public Set<Listparticipant> getListparticipants() {
        return listparticipants;
    }

    public void setListparticipants(Set<Listparticipant> listparticipants) {
        this.listparticipants = listparticipants;
    }

    public Responsable getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Responsable idResponsable) {
        this.idResponsable = idResponsable;
    }

    public Exercice getIdExercice() {
        return idExercice;
    }

    public void setIdExercice(Exercice idExercice) {
        this.idExercice = idExercice;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getTitleActivity() {
        return titleActivity;
    }

    public void setTitleActivity(String titleActivity) {
        this.titleActivity = titleActivity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}