package com.code.windigitalcenter.entity;

import javax.persistence.*;

@Entity
@Table(name = "listparticipant")
public class Listparticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_activity")
    private Activity idActivity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_participant")
    private Participant idParticipant;

    public Participant getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(Participant idParticipant) {
        this.idParticipant = idParticipant;
    }

    public Activity getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(Activity idActivity) {
        this.idActivity = idActivity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}