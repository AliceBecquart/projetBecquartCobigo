

INSERT INTO `categorie` (`idCategorie`, `libelleCategorie`)
VALUES (1, 'Agent Administratif'),
(2, 'Agent Administratif'),
(3, 'Agent Entretien'),
(4, 'Assitant(e) d exploitation'),
(5, 'Chef de parc'),
(6, 'Compatibilite clients'),
(7, 'Conducteur(rice) routier(e)'),
(8, 'Directeur(rice) d exploitation'),
(9, 'Exploitant(e)'),
(10, 'Exploitant(e) MD'),
(11, 'Mecanicien(ne) poids lourd'),
(12, 'Responsable HSQE'),
(13, 'Autres')
;

INSERT INTO `typeConge` (`idTypeConge`, `libelleTypeConge`) VALUES
(1, 'RTT'),
(2, 'Maladie'),
(3, 'Maternite/Paternite'),
(4, 'Conges Payes'),
(5, 'Formation')
;

INSERT INTO `conge` (`idConge`, `dateDebutConge`, `dateFinConge`, `matin`, `apresMidi`, `numeroSemaineConge`, 
`dateDemandeConge`, `demandeValide`, `dateValidation`, `idTypeConge`) VALUES 
(1, '12/10/2017', '23/10/2017', NULL, NULL, NULL, '03/04/2017', FALSE, NULL, 4),
(2, '05/06/2017', '10/06/2017', NULL, NULL, NULL, '23/02/2017', FALSE, NULL,5)
;

INSERT INTO `employe` (`idEmploye`, `mdpEmploye`, `dateNaissanceEmploye`, `nomEmploye`,
`prenomEmploye`, `telephoneEmploye`, `mailEmploye`, `interimaire`, `idCategorie`, `idConge`) 
VALUES
(1, 'ced282016fr', '1972-12-12', 'ALLAIN', 'Cedric', 0617502501, 'cedric56.allain@aliceadsl.fr', TRUE,7, NULL),
(2, 'sam202016om', '1977-01-15', 'BARDOR', 'Samuel', 0650219020, 'sam.bard56@gmail.com', FALSE, 7, NULL),
(3, 'kry182016fr', '1973-03-15', 'BRUNET', 'Christophe', 0685221656, 'krystale@orange.fr', FALSE, 7, '1'),
(4, 'dan242016om', '1974-10-03', 'DANTEC', 'Mikael', 0660645852, 'dantec.mikael@cobigo.com', TRUE, 11, '2'),
(5, 'cd252016om', '1973-05-02', 'DAMONNEVILLE', 'Cecile', 0682751112, 'c.damonneville@cobigo.com', FALSE, 9, NULL),
(6, '1fac222016om', '1958-08-06', 'JOHNSTON', 'Ghislaine', 0672343953, 'facturation@cobigo.com', FALSE, 2, NULL),
(7, 'pr202016om', '1971-01-08', 'ROLLAND', 'Patrick', 0614967160, 'p.rolland@cobigo.com', FALSE, 8, NULL)
;

INSERT INTO `disponibilite` (`idDispo`, `dateDebutDispo`, `dateFinDispo`, `matin`, `apresMidi`, `affecte`, `idEmploye`) VALUES
(1,'12/03/2017', '23/03/2017', NULL, NULL, false, 2)
;

INSERT INTO `Remplacement` (`IdRemplacement`, `IdEmployeRemplacant`, `IdEmployeRemplace`, `IdDispo`) VALUES 
(1,1,2,1)
;