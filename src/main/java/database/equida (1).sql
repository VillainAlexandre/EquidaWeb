-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le : mer. 01 oct. 2025 à 09:59
-- Version du serveur : 11.3.2-MariaDB
-- Version de PHP : 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `equida`
--

-- --------------------------------------------------------

--
-- Structure de la table `categvente`
--

DROP TABLE IF EXISTS `categvente`;
CREATE TABLE IF NOT EXISTS `categvente` (
  `code` int(11) NOT NULL,
  `libelle` varchar(500) NOT NULL,
  `idVente` int(11) DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `FK_idVente` (`idVente`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `categvente`
--

INSERT INTO `categvente` (`code`, `libelle`, `idVente`) VALUES
(1, 'Vente Prestige', 2),
(2, 'Vente d\'Été', 1),
(3, 'Vente d\'Automne', 3),
(4, 'Vente de Foals', 1),
(5, 'Vente de Yearlings', 3),
(6, 'Vente d\'Entraînement', 2),
(7, 'Vente d\'Hiver', 3);

-- --------------------------------------------------------

--
-- Structure de la table `cheval`
--

DROP TABLE IF EXISTS `cheval`;
CREATE TABLE IF NOT EXISTS `cheval` (
  `id` int(11) NOT NULL,
  `nom` varchar(150) NOT NULL,
  `date_naissance` date NOT NULL,
  `race_id` int(11) DEFAULT NULL,
  `cheval_mere` int(11) DEFAULT NULL,
  `cheval_pere` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_race` (`race_id`),
  KEY `fk_pere` (`cheval_pere`) USING BTREE,
  KEY `fk_mere` (`cheval_mere`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `cheval`
--

INSERT INTO `cheval` (`id`, `nom`, `date_naissance`, `race_id`, `cheval_mere`, `cheval_pere`) VALUES
(1, 'Eclipse', '2017-03-12', 4, 15, 2),
(2, 'Aztec', '2019-07-04', 4, 4, 15),
(3, 'orion', '2015-05-23', 5, 7, 3),
(4, 'Tempête de Feu', '2017-03-12', 1, 9, 8),
(5, 'Éclair Noir', '2019-07-04', 2, 12, 5),
(6, 'Vent du Nord', '2015-05-23', 3, 13, 14),
(7, 'Comète', '2018-01-01', 4, 16, 4),
(8, 'Silver Snow', '2020-11-17', 5, 6, 1),
(9, 'Caramel', '2016-06-30', 6, 8, 10),
(10, 'Storm', '2021-10-10', 1, 7, 1),
(11, 'Mustang', '2014-08-03', 2, 14, 12),
(12, 'Rising Sun', '2019-04-22', 3, 3, 13),
(13, 'Phantom', '2016-12-05', 4, 9, 2),
(14, 'Pompom', '2025-07-13', 2, 15, 16),
(15, 'Fleur du désert', '2023-06-30', 6, 11, 5),
(16, 'gold ship', '2009-03-06', 1, 11, 4);

-- --------------------------------------------------------

--
-- Structure de la table `cheval_course`
--

DROP TABLE IF EXISTS `cheval_course`;
CREATE TABLE IF NOT EXISTS `cheval_course` (
  `cheval_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `position` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `id` int(11) NOT NULL,
  `nom` varchar(500) NOT NULL,
  `lieu` varchar(500) NOT NULL,
  `date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Structure de la table `enchere`
--

DROP TABLE IF EXISTS `enchere`;
CREATE TABLE IF NOT EXISTS `enchere` (
  `numero` int(11) NOT NULL,
  `montant` int(11) NOT NULL,
  `idLot` int(11) DEFAULT NULL,
  PRIMARY KEY (`numero`),
  KEY `FK_IdLot` (`idLot`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `enchere`
--

INSERT INTO `enchere` (`numero`, `montant`, `idLot`) VALUES
(101, 7000, 103),
(102, 9000, 104),
(103, 13000, 105),
(104, 10000, 101),
(105, 25000, 102),
(106, 18000, 101);

-- --------------------------------------------------------

--
-- Structure de la table `lieu`
--

DROP TABLE IF EXISTS `lieu`;
CREATE TABLE IF NOT EXISTS `lieu` (
  `id` int(11) NOT NULL,
  `ville` varchar(500) NOT NULL,
  `nbBoxes` int(11) NOT NULL,
  `commentaires` varchar(1000) NOT NULL,
  `idVente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Vente` (`idVente`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `lieu`
--

INSERT INTO `lieu` (`id`, `ville`, `nbBoxes`, `commentaires`, `idVente`) VALUES
(1, 'Deauville', 50, 'Grand hippodrome avec infrastructures modernes', 2),
(2, 'Chantilly', 40, 'Lieu historique avec bonne fréquentation', 1),
(3, 'Pau', 35, 'Bon lieu pour les ventes d\'hiver', 3);

-- --------------------------------------------------------

--
-- Structure de la table `lot`
--

DROP TABLE IF EXISTS `lot`;
CREATE TABLE IF NOT EXISTS `lot` (
  `id` int(11) NOT NULL,
  `prixDepart` float NOT NULL,
  `cheval_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cheval` (`cheval_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `lot`
--

INSERT INTO `lot` (`id`, `prixDepart`, `cheval_id`) VALUES
(101, 5000, 2),
(102, 12000, 1),
(103, 8000, 10),
(104, 20000, 16),
(105, 15000, 11);

-- --------------------------------------------------------

--
-- Structure de la table `race`
--

DROP TABLE IF EXISTS `race`;
CREATE TABLE IF NOT EXISTS `race` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `race`
--

INSERT INTO `race` (`id`, `nom`) VALUES
(1, 'Pur-sang anglais'),
(2, 'Quarter Horse'),
(3, 'Frison'),
(4, 'Andalou'),
(5, 'Lipizzan'),
(6, 'Mustang');

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

DROP TABLE IF EXISTS `vente`;
CREATE TABLE IF NOT EXISTS `vente` (
  `id` int(11) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `dateDebutVente` date NOT NULL,
  `idLot` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_idLot` (`idLot`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `vente`
--

INSERT INTO `vente` (`id`, `nom`, `dateDebutVente`, `idLot`) VALUES
(1, 'Vente d\'Été 2025', '2025-07-10', 101),
(2, 'Vente d\'Automne 2025', '2025-10-05', 103),
(3, 'Vente Prestige', '2025-12-01', 104);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `categvente`
--
ALTER TABLE `categvente`
  ADD CONSTRAINT `categvente_ibfk_1` FOREIGN KEY (`idVente`) REFERENCES `vente` (`id`);

--
-- Contraintes pour la table `cheval`
--
ALTER TABLE `cheval`
  ADD CONSTRAINT `cheval_ibfk_2` FOREIGN KEY (`cheval_mere`) REFERENCES `cheval` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `cheval_ibfk_3` FOREIGN KEY (`cheval_pere`) REFERENCES `cheval` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_race` FOREIGN KEY (`race_id`) REFERENCES `race` (`id`);

--
-- Contraintes pour la table `enchere`
--
ALTER TABLE `enchere`
  ADD CONSTRAINT `enchere_ibfk_1` FOREIGN KEY (`idLot`) REFERENCES `lot` (`id`);

--
-- Contraintes pour la table `lieu`
--
ALTER TABLE `lieu`
  ADD CONSTRAINT `lieu_ibfk_1` FOREIGN KEY (`idVente`) REFERENCES `vente` (`id`);

--
-- Contraintes pour la table `lot`
--
ALTER TABLE `lot`
  ADD CONSTRAINT `lot_ibfk_1` FOREIGN KEY (`cheval_id`) REFERENCES `cheval` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `vente`
--
ALTER TABLE `vente`
  ADD CONSTRAINT `vente_ibfk_1` FOREIGN KEY (`idLot`) REFERENCES `lot` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
