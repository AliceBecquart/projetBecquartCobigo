--
-- Struture de la table Categorie
-- 

create table `categorie`
(
	`idCategorie` Int(100) NOT NULL AUTO_INCREMENT,
	`libelleCategorie` Varchar(50) NOT NULL,
	PRIMARY KEY (`idCategorie`)
);
--
-- Struture de la table TypeConge
-- 

create table `typeConge`
(
	`idTypeConge` Int(100) NOT NULL AUTO_INCREMENT,
	`libelleTypeConge` Varchar(50) NOT NULL,
	PRIMARY KEY (`idTypeConge`)
);

--
-- Struture de la table Conge
-- 

create table `conge`
(
	`idConge` Int(100) NOT NULL AUTO_INCREMENT,
	`dateDebutConge` Varchar(50) NOT NULL,
	`dateFinConge` Varchar(50) NOT NULL,
	`matin` Boolean NULL,
	`apresMidi` Boolean NULL,
	`numeroSemaineConge` Varchar(3) NULL,
	`dateDemandeConge` Varchar(50) NULL,
	`demandeValide` Boolean NULL,
	`dateValidation` Varchar(50) NULL,
	`idTypeConge` Int(100) NOT NULL,
	PRIMARY KEY (`idConge`),
	FOREIGN KEY (`idTypeConge`) REFERENCES TypeConge(`idTypeConge`)
);

--
-- Struture de la table Employe
-- 

create table `employe`
(
	`idEmploye` Int(100) NOT NULL AUTO_INCREMENT,
	`mdpEmploye` Varchar(50) NULL,
	`dateNaissanceEmploye` Varchar(50) NULL,
	`nomEmploye` Varchar(50) NULL,
	`prenomEmploye` Varchar(50) NULL,
	`telephoneEmploye` Int(10) NULL,
	`mailEmploye` Varchar(50) NULL,
	`interimaire` Boolean NOT NULL,
	`idCategorie` Int(100) NOT NULL,
	`idConge` Int(100),
	PRIMARY KEY (`idEmploye`),
	FOREIGN KEY (`idCategorie`) REFERENCES Categorie(`idCategorie`),
	FOREIGN KEY (`idConge`) REFERENCES Conge(`idConge`)
);

--
-- Struture de la table Disponibilité
-- 

create table `disponibilite`
(
	`idDispo` Int(100) NOT NULL AUTO_INCREMENT,
	`dateDebutDispo` Varchar(50) NOT NULL,
	`dateFinDispo` Varchar(50) NOT NULL,
	`matin` Boolean NULL,
	`apresMidi` Boolean NULL,
	`affecte` Boolean NOT NULL,
	`idEmploye` Int(100) NOT NULL,
	PRIMARY KEY (`idDispo`),
	FOREIGN KEY (`idEmploye`) REFERENCES Employe(`idEmploye`)
);
--
-- Struture de la table Remplacant
-- 

create table `remplacement`
(
	`idRemplacement` Int(100) NOT NULL AUTO_INCREMENT,
	`idEmployeRemplacant` Int(100) NOT NULL,
	`idEmployeRemplace` Int(100) NOT NULL,
	`idDispo` Int(100) NOT NULL,
	PRIMARY KEY (`idRemplacement`),
	FOREIGN KEY (`idEmployeRemplace`) REFERENCES employe(`idEmploye`),
	FOREIGN KEY (`idEmployeRemplacant`) REFERENCES employe(`idEmploye`),
	FOREIGN KEY (`idDispo`) REFERENCES disponibilite(`idDispo`)
);

