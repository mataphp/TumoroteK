-- CONFORMITE_TYPE              
CREATE TABLE CONFORMITE_TYPE (
  	CONFORMITE_TYPE_ID INT(5) NOT NULL,
  	CONFORMITE_TYPE VARCHAR(50) NOT NULL,
  	PRIMARY KEY (CONFORMITE_TYPE_ID)
) ENGINE=InnoDB;

-- NON_CONFORMITE                                        
CREATE TABLE NON_CONFORMITE (
  	NON_CONFORMITE_ID INT(10) NOT NULL,
 	CONFORMITE_TYPE_ID INT(5) NOT NULL,
	PLATEFORME_ID INT(10) NOT NULL,
  	NOM VARCHAR(50) NOT NULL,
  	PRIMARY KEY (NON_CONFORMITE_ID)
) ENGINE=InnoDB;

-- OBJET_NON_CONFORME
CREATE TABLE OBJET_NON_CONFORME (
  	OBJET_NON_CONFORME_ID INT(10) NOT NULL,
 	NON_CONFORMITE_ID INT(10) NOT NULL,
	OBJET_ID INT(10) NOT NULL,
	ENTITE_ID INT(10) NOT NULL,
  	PRIMARY KEY (OBJET_NON_CONFORME_ID)
) ENGINE=InnoDB;

ALTER TABLE NON_CONFORMITE
  ADD CONSTRAINT FK_NON_CONFORMITE_CONFORMITE_TYPE_ID
      FOREIGN KEY (CONFORMITE_TYPE_ID)
      REFERENCES CONFORMITE_TYPE (CONFORMITE_TYPE_ID);

ALTER TABLE NON_CONFORMITE
  ADD CONSTRAINT FK_NON_CONFORMITE_PLATEFORME_ID
      FOREIGN KEY (PLATEFORME_ID)
      REFERENCES PLATEFORME (PLATEFORME_ID);

ALTER TABLE OBJET_NON_CONFORME
  ADD CONSTRAINT FK_OBJET_NON_CONFORME_NON_CONFORMITE_ID
      FOREIGN KEY (NON_CONFORMITE_ID)
      REFERENCES NON_CONFORMITE (NON_CONFORMITE_ID);

ALTER TABLE OBJET_NON_CONFORME
  ADD CONSTRAINT FK_OBJET_NON_CONFORME_ENTITE_ID
      FOREIGN KEY (ENTITE_ID)
      REFERENCES ENTITE (ENTITE_ID);

-- Suppression des tables
drop table CONFORMITE_PLATEFORME;
drop table CONFORMITE_BANQUE;
drop table OBJET_CONFORME;
drop table CONFORMITE;