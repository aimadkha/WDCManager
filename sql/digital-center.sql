DROP DATABASE IF EXISTS windigitalcenter;
CREATE DATABASE windigitalcenter;
USE windigitalcenter;

CREATE TABLE user(
    id_user int(11) NOT NULL AUTO_INCREMENT,
    nom_user varchar(20),
    prenom_user varchar(20),
    genre_user varchar(10),
    telephone varchar(25),
    email varchar(55),
    password varchar(255),
    state_user boolean ,
    PRIMARY KEY (id_user),
    id_role int
    );

CREATE TABLE role(
    id_role int(11) NOT NULL AUTO_INCREMENT,
    nom_role varchar(11),
    PRIMARY KEY(id_role)
);


CREATE TABLE admin(
    id_admin int (11),
    PRIMARY KEY (id_admin)
);

CREATE TABLE type(
    id_type int(11) NOT NULL AUTO_INCREMENT,
    type_name varchar(11),
    PRIMARY KEY(id_type)
);

CREATE TABLE responsable(
    id_responsable int ,
    domain varchar(64),
    id_type int,
    PRIMARY KEY (id_responsable),
    FOREIGN KEY (id_type) REFERENCES type(id_type)
);



CREATE TABLE participant(
    id_participant int ,
    domain varchar(64),
    structure varchar(64),
    PRIMARY KEY (id_participant)
);

CREATE TABLE exercice(
    id_exercice int(11) NOT NULL AUTO_INCREMENT,
    year DATE,
    startDate DATE,
    endDate DATE,
    state boolean,
    PRIMARY KEY(id_exercice)
);


CREATE TABLE activity(
    id_activity int(11) NOT NULL AUTO_INCREMENT,
    title_activity varchar(11),
    startDate DATE,
    endDate DATE,
    state boolean,
    id_exercice int,
    id_responsable int,
    PRIMARY KEY(id_activity),
    FOREIGN KEY (id_exercice) REFERENCES exercice(id_exercice)
);

CREATE TABLE listparticipant(
    id int(11) NOT NULL AUTO_INCREMENT,
    id_participant int ,
    id_activity int,
    PRIMARY KEY (id),
    FOREIGN KEY (id_participant) REFERENCES participant(id_participant),
    FOREIGN KEY (id_activity) REFERENCES activity(id_activity)
);






ALTER TABLE user add constraint FK_role Foreign key(id_role) references role (id_role);
ALTER TABLE admin add constraint FK_admin_user Foreign key(id_admin) references user  (id_user);
ALTER TABLE responsable add constraint FK_responsable Foreign key(id_responsable) references user (id_user);
ALTER TABLE participant add constraint FK_participant Foreign key(id_participant) references user (id_user);
ALTER TABLE activity add constraint FK_responsableActivity Foreign key(id_responsable ) references responsable (id_responsable);

