-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 06 Juillet 2017 à 23:30
-- Version du serveur :  10.1.21-MariaDB
-- Version de PHP :  7.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `agence`
--

-- --------------------------------------------------------

--
-- Structure de la table `avions`
--

CREATE TABLE `avions` (
  `idAvion` int(11) NOT NULL,
  `nomCompagnie` varchar(255) NOT NULL,
  `nombresPlaces` int(11) NOT NULL,
  `poidsMax` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `avions`
--

INSERT INTO `avions` (`idAvion`, `nomCompagnie`, `nombresPlaces`, `poidsMax`) VALUES
(1, 'Voyage', 25, 60),
(2, 'Voyage', 15, 40),
(3, 'UIA', 25, 65),
(4, 'AV UI', 40, 60);

-- --------------------------------------------------------

--
-- Structure de la table `billets`
--

CREATE TABLE `billets` (
  `idBillet` int(11) NOT NULL,
  `ReservationId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `billets`
--

INSERT INTO `billets` (`idBillet`, `ReservationId`) VALUES
(1, 2),
(2, 2),
(5, 2),
(3, 3),
(4, 4),
(6, 6),
(7, 7),
(8, 9);

-- --------------------------------------------------------

--
-- Structure de la table `lignereservation`
--

CREATE TABLE `lignereservation` (
  `idLigne` int(11) NOT NULL,
  `ReservationId` int(11) NOT NULL,
  `VolId` int(11) NOT NULL,
  `OrderId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `passagers`
--

CREATE TABLE `passagers` (
  `idPassager` int(11) NOT NULL,
  `nomPassager` varchar(255) NOT NULL,
  `prenomPassager` varchar(255) NOT NULL,
  `telPassager` varchar(255) NOT NULL,
  `numPassport` int(11) NOT NULL,
  `categoriePassager` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `passagers`
--

INSERT INTO `passagers` (`idPassager`, `nomPassager`, `prenomPassager`, `telPassager`, `numPassport`, `categoriePassager`) VALUES
(1, 'mohamed', 'aimane', '0678253634', 2346152, 'Niveau 3'),
(2, 'mohamed', 'aimane', '0673263524', 24242, 'Niveau 1'),
(3, 'SKHAIRI', 'Aimane', '067853621', 231000, 'Niveau 4'),
(4, 'AOULAD HAJ', 'ADIL', '07867262622', 213251, 'Niveau 3'),
(5, 'Passager2', 'Passager2', '067734635463', 2222222, 'Niveau 3'),
(6, 'Assadi', 'ayman', '05646252', 32323, 'Niveau 3');

-- --------------------------------------------------------

--
-- Structure de la table `pilotes`
--

CREATE TABLE `pilotes` (
  `idPilote` int(11) NOT NULL,
  `nomPilote` varchar(255) NOT NULL,
  `prenomPilote` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `pilotes`
--

INSERT INTO `pilotes` (`idPilote`, `nomPilote`, `prenomPilote`) VALUES
(1, 'Pilote 1', 'Pilote 1');

-- --------------------------------------------------------

--
-- Structure de la table `reservations`
--

CREATE TABLE `reservations` (
  `idReservation` int(11) NOT NULL,
  `passagerId` int(11) NOT NULL,
  `dateReservation` date NOT NULL,
  `dateValidation` date NOT NULL,
  `etatReservation` tinyint(1) NOT NULL DEFAULT '0',
  `prixTotal` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `reservations`
--

INSERT INTO `reservations` (`idReservation`, `passagerId`, `dateReservation`, `dateValidation`, `etatReservation`, `prixTotal`) VALUES
(1, 1, '2017-07-07', '2017-07-15', 1, 207.5),
(2, 1, '2017-07-13', '2017-07-14', 1, 144.5),
(3, 2, '2017-07-11', '2017-07-21', 0, 207.5),
(4, 3, '2017-07-18', '2017-07-29', 1, 774.5),
(5, 2, '2017-07-19', '2017-07-22', 1, 407),
(6, 4, '2017-07-11', '2017-07-21', 1, 134),
(7, 5, '2017-07-07', '2017-07-12', 1, 333.5),
(8, 2, '2017-07-13', '2017-07-21', 1, 92),
(9, 6, '2017-07-25', '2017-07-26', 1, 123.5);

-- --------------------------------------------------------

--
-- Structure de la table `vols`
--

CREATE TABLE `vols` (
  `idVol` int(11) NOT NULL,
  `avionId` int(11) NOT NULL,
  `piloteId` int(11) NOT NULL,
  `dateDepart` date NOT NULL,
  `villeDepart` varchar(255) NOT NULL,
  `villeArrivee` varchar(255) NOT NULL,
  `prixVol` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `vols`
--

INSERT INTO `vols` (`idVol`, `avionId`, `piloteId`, `dateDepart`, `villeDepart`, `villeArrivee`, `prixVol`) VALUES
(1, 1, 1, '2017-07-02', 'Tanger', 'Paris', 4000),
(2, 4, 1, '2017-07-15', 'TETOUAN', 'LONDON', 6000),
(3, 2, 1, '2017-07-09', 'HOSSAIMA', 'TANGER', 6500);

-- --------------------------------------------------------

--
-- Structure de la table `voyages`
--

CREATE TABLE `voyages` (
  `passagerId` int(11) NOT NULL,
  `billetId` int(11) NOT NULL,
  `volId` int(11) NOT NULL,
  `numPlace` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `avions`
--
ALTER TABLE `avions`
  ADD PRIMARY KEY (`idAvion`);

--
-- Index pour la table `billets`
--
ALTER TABLE `billets`
  ADD PRIMARY KEY (`idBillet`),
  ADD KEY `ReservationId` (`ReservationId`);

--
-- Index pour la table `lignereservation`
--
ALTER TABLE `lignereservation`
  ADD PRIMARY KEY (`idLigne`),
  ADD KEY `ReservationId` (`ReservationId`),
  ADD KEY `VolId` (`VolId`);

--
-- Index pour la table `passagers`
--
ALTER TABLE `passagers`
  ADD PRIMARY KEY (`idPassager`);

--
-- Index pour la table `pilotes`
--
ALTER TABLE `pilotes`
  ADD PRIMARY KEY (`idPilote`);

--
-- Index pour la table `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`idReservation`),
  ADD KEY `passagerId` (`passagerId`);

--
-- Index pour la table `vols`
--
ALTER TABLE `vols`
  ADD PRIMARY KEY (`idVol`),
  ADD KEY `avionId` (`avionId`),
  ADD KEY `piloteId` (`piloteId`);

--
-- Index pour la table `voyages`
--
ALTER TABLE `voyages`
  ADD PRIMARY KEY (`passagerId`,`billetId`,`volId`),
  ADD KEY `voyages_billet_key` (`billetId`),
  ADD KEY `voyages_vol_key` (`volId`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `avions`
--
ALTER TABLE `avions`
  MODIFY `idAvion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `billets`
--
ALTER TABLE `billets`
  MODIFY `idBillet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `lignereservation`
--
ALTER TABLE `lignereservation`
  MODIFY `idLigne` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `passagers`
--
ALTER TABLE `passagers`
  MODIFY `idPassager` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `pilotes`
--
ALTER TABLE `pilotes`
  MODIFY `idPilote` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `reservations`
--
ALTER TABLE `reservations`
  MODIFY `idReservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `vols`
--
ALTER TABLE `vols`
  MODIFY `idVol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `billets`
--
ALTER TABLE `billets`
  ADD CONSTRAINT `billets_reservation_key` FOREIGN KEY (`ReservationId`) REFERENCES `reservations` (`idReservation`);

--
-- Contraintes pour la table `lignereservation`
--
ALTER TABLE `lignereservation`
  ADD CONSTRAINT `ligne_reservation_key` FOREIGN KEY (`ReservationId`) REFERENCES `reservations` (`idReservation`),
  ADD CONSTRAINT `ligne_vol_key` FOREIGN KEY (`VolId`) REFERENCES `vols` (`idVol`);

--
-- Contraintes pour la table `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `reservations_passager_key` FOREIGN KEY (`passagerId`) REFERENCES `passagers` (`idPassager`);

--
-- Contraintes pour la table `vols`
--
ALTER TABLE `vols`
  ADD CONSTRAINT `vols_avion_key` FOREIGN KEY (`avionId`) REFERENCES `avions` (`idAvion`),
  ADD CONSTRAINT `vols_pilote_key` FOREIGN KEY (`piloteId`) REFERENCES `pilotes` (`idPilote`);

--
-- Contraintes pour la table `voyages`
--
ALTER TABLE `voyages`
  ADD CONSTRAINT `voyages_billet_key` FOREIGN KEY (`billetId`) REFERENCES `billets` (`idBillet`),
  ADD CONSTRAINT `voyages_passager_key` FOREIGN KEY (`passagerId`) REFERENCES `passagers` (`idPassager`),
  ADD CONSTRAINT `voyages_vol_key` FOREIGN KEY (`volId`) REFERENCES `vols` (`idVol`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
