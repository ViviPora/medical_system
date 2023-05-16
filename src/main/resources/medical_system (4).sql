-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: mai 16, 2023 la 05:36 PM
-- Versiune server: 10.4.27-MariaDB
-- Versiune PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Bază de date: `medical_system`
--

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `country` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `address`
--

INSERT INTO `address` (`id`, `country`, `city`, `street`, `address`) VALUES
(48, 'adresa first', 'city first', 'first streed', 'first 36'),
(51, 'Romania', 'Brasov', 'Cetatii', 'Bloc 3A, apartament 115'),
(52, 'Romania', 'Brasov', 'Padurii', 'nr.1'),
(53, 'Romania', 'Brasov', 'Secundara', 'nr.77'),
(54, 'Romania', 'Brasov', 'Strada 2', 'nr.37'),
(55, 'Romania', 'Brasov', 'Strada 5', 'nr.38'),
(56, 'Romania', 'Mures', 'Steada', 'nr. 125'),
(57, 'Romania', 'Mures', 'Steada', 'nr. 125'),
(58, 'Romania', 'Brasov', 'Strada', '12'),
(59, 'modificaTARA', 'Mures', 'Steada', 'nr. 125'),
(60, 'Romania', 'Brasov', 'Strada 5', 'nr.38'),
(61, 'person firstco', 'person first city', 'personfirststreed', '36'),
(62, 'person firstco', 'person first city', 'personfirststreed', '36'),
(63, 'person firstco', 'person first city', 'personfirststreed', '36'),
(64, 'Country Admin', 'city Admin', 'street Admin', 'admin'),
(65, 'Country Admin', 'city Admin', 'street Admin', 'admin'),
(66, 'Romania', 'Brasov', 'Cetatii', 'Bloc 3A, apartament 115'),
(67, 'Romania', 'Brasov', 'Strada 5', 'nr.38'),
(68, 'Romania', 'Brasov', 'Strada 5', 'nr.38'),
(69, 'Romania', 'Brasov', 'Strada 5', 'nr.38'),
(70, 'Romania', 'Mures', 'Steada', 'nr. 125');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `code` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `admin`
--

INSERT INTO `admin` (`id`, `first_name`, `last_name`, `email`, `code`) VALUES
(8, 'Iulia', 'Datcu', 'vivipora37@gmail.com', '12345551'),
(9, 'Maria', 'Atolin', 'vivipala37@gmail.com', '4788854'),
(10, 'Oana', 'Baca', 'vivipala37@gmail.com', '85482245'),
(11, 'Ilinca', 'Aanei', 'vivipala37@gmail.com', '85868774'),
(13, 'Monica', 'Pavel', 'vivipala37@gmail.com', '85868774');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `appointment`
--

CREATE TABLE `appointment` (
  `id` int(11) NOT NULL,
  `id_doctor` int(11) NOT NULL,
  `id_patient` int(11) NOT NULL,
  `id_nurse` int(11) NOT NULL,
  `id_room` int(11) NOT NULL,
  `start_appointment_time` datetime NOT NULL,
  `end_appointment_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `appointment`
--

INSERT INTO `appointment` (`id`, `id_doctor`, `id_patient`, `id_nurse`, `id_room`, `start_appointment_time`, `end_appointment_time`) VALUES
(15, 2958845, 1950685, 785874, 19, '2023-10-01 10:00:00', '2023-10-01 11:00:00'),
(19, 2958845, 1950685, 785874, 19, '2023-10-01 09:00:00', '2023-10-01 09:59:00'),
(44, 2958845, 1950685, 775874, 21, '2023-12-02 10:00:00', '2023-12-02 10:59:00'),
(45, 885477, 1950685, 775874, 21, '2023-10-02 10:00:00', '2023-10-02 10:59:00'),
(46, 885477, 1950685, 775874, 21, '2023-10-02 11:00:00', '2023-10-02 11:59:00');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `doctor`
--

CREATE TABLE `doctor` (
  `id` int(11) NOT NULL,
  `degree_number` varchar(11) NOT NULL,
  `experience` int(11) NOT NULL,
  `specialization` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `doctor`
--

INSERT INTO `doctor` (`id`, `degree_number`, `experience`, `specialization`) VALUES
(885477, '6698555562', 10, 'Neurolog'),
(2958845, '6698555562', 10, 'Chirurg');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `history`
--

CREATE TABLE `history` (
  `id` int(11) NOT NULL,
  `medical_history` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `history`
--

INSERT INTO `history` (`id`, `medical_history`) VALUES
(4, 'Doc. nr ACLZ78'),
(5, 'Doc. nr ACLZ79'),
(6, 'b67545'),
(7, 'as223'),
(8, 'b67-45');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `history_patient`
--

CREATE TABLE `history_patient` (
  `id_patient` int(11) NOT NULL,
  `id_history` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `history_patient`
--

INSERT INTO `history_patient` (`id_patient`, `id_history`) VALUES
(195045, 5),
(1950685, 4),
(1950685, 7);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `medication`
--

CREATE TABLE `medication` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `medication`
--

INSERT INTO `medication` (`id`, `name`, `brand`, `description`) VALUES
(5, 'clorzoxazona', 'richter', '3/zi'),
(6, 'paramol', 'paramol', '1/zi'),
(7, 'algocalmin', 'algocalmin', '- contra indicat pers sub 18 ani'),
(8, 'medicament', 'medicament', 'recomandat dupa masa');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `nurse`
--

CREATE TABLE `nurse` (
  `id` int(11) NOT NULL,
  `degree_number` varchar(11) NOT NULL,
  `exerience` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `nurse`
--

INSERT INTO `nurse` (`id`, `degree_number`, `exerience`) VALUES
(87855, '5845', 1),
(775874, 'a115', 1),
(785874, 'a6', 1);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `on_call`
--

CREATE TABLE `on_call` (
  `id` int(11) NOT NULL,
  `id_doctor` int(11) NOT NULL,
  `id_nurse` int(11) NOT NULL,
  `start_on_call` datetime NOT NULL,
  `end_on_call` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `patient_procedures`
--

CREATE TABLE `patient_procedures` (
  `id_patient` int(11) NOT NULL,
  `id_procedure` int(11) NOT NULL,
  `id_doctor` int(11) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `patient_procedures`
--

INSERT INTO `patient_procedures` (`id_patient`, `id_procedure`, `id_doctor`, `description`) VALUES
(1950685, 3, 2958845, 'descriere despre aceasta procedura'),
(1950685, 4, 2958845, 'descriere despre aceasta procedura');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `person`
--

CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `birth_date` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `id_adrdress` int(11) NOT NULL,
  `gender` enum('M','F') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `person`
--

INSERT INTO `person` (`id`, `first_name`, `last_name`, `birth_date`, `email`, `phone`, `id_adrdress`, `gender`) VALUES
(8588, 'person first', 'person firstName', '1995-04-27', 'mailpacient@test.com', 'personfirst', 63, 'M'),
(87855, 'Gelu', 'Amariei', '1995-12-12', 'vivipala37@gmail.com', '075488', 69, 'M'),
(195045, 'Alin', 'Iolan', '1990-04-27', 'mail@test.com', '07582', 58, 'M'),
(195778, 'Bogdan', 'Neacsu', '1990-04-27', 'vivipala@gmail.com', '07582', 70, 'M'),
(775874, 'Amelia', 'Barbu', '1995-12-12', 'ami@test.com', '075488', 68, 'F'),
(785874, 'Roxana', 'Panait', '1995-12-12', 'mail23@test.com', '356888', 54, 'F'),
(885477, 'Viviana', 'Pora', '1995-04-27', 'vivipala@gmail.com', '1234555', 66, 'F'),
(1950685, 'Claudiu', 'Zopa', '1990-04-27', 'mail2@test.com', '07582', 59, 'M'),
(2958845, 'Luna', 'Petrescu', '1995-12-12', 'mail23@test.com', '1234555', 51, 'F');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `petient`
--

CREATE TABLE `petient` (
  `id` int(11) NOT NULL,
  `insurance_no` varchar(50) NOT NULL,
  `insurance_company` varchar(50) NOT NULL,
  `enrollment_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `petient`
--

INSERT INTO `petient` (`id`, `insurance_no`, `insurance_company`, `enrollment_date`) VALUES
(195045, '878788', 'Asigurare', '2020-12-12'),
(195778, '89588', 'Asigurare', '2020-12-12'),
(1950685, '87888', 'Asigurare', '2020-12-12');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `prescription`
--

CREATE TABLE `prescription` (
  `id_patient` int(11) NOT NULL,
  `id_medication` int(11) NOT NULL,
  `id_doctor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `prescription`
--

INSERT INTO `prescription` (`id_patient`, `id_medication`, `id_doctor`) VALUES
(195045, 5, 2958845),
(195045, 6, 2958845),
(195045, 7, 2958845);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `procedures`
--

CREATE TABLE `procedures` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `cost` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `procedures`
--

INSERT INTO `procedures` (`id`, `name`, `cost`) VALUES
(3, 'ecografie', 120),
(4, 'consult', 15),
(5, 'Endoscopie', 1200),
(6, 'Endoscopie', 1200),
(7, 'Analiza colesterol', 12);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` enum('ROLE_ADMIN','ROLE_DOCTOR','ROLE_NURSE','ROLE_PATIENT') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_DOCTOR'),
(3, 'ROLE_NURSE'),
(4, 'ROLE_PATIENT');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `roles_user`
--

CREATE TABLE `roles_user` (
  `id_role` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `roles_user`
--

INSERT INTO `roles_user` (`id_role`, `id_user`) VALUES
(1, 18),
(2, 13),
(3, 14),
(4, 19),
(4, 20);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `room`
--

CREATE TABLE `room` (
  `id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `type` enum('SURGICAL','INTENSIVE','MATERNITY','EXAMINATION','EMERGENCY','PHARMACY') NOT NULL,
  `available` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `room`
--

INSERT INTO `room` (`id`, `number`, `type`, `available`) VALUES
(10, 1, 'SURGICAL', 1),
(11, 2, 'MATERNITY', 1),
(16, 3, 'SURGICAL', 1),
(19, 5, 'PHARMACY', 1),
(21, 15, 'MATERNITY', 1),
(22, 101, 'MATERNITY', 1);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `age` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `users`
--

INSERT INTO `users` (`id`, `first_name`, `last_name`, `username`, `password`, `age`, `active`) VALUES
(13, 'Ana', 'Maria', 'anamaria', '$2a$10$LLxDx0WpfcjhRQCSguePe.wY5E5UjZigcfO2JcTmyDZe.5dAd7V8q', 45, 0),
(14, 'Andrei', 'Popa', 'andreipopa', '$2a$10$wc29jmBoD11y5PP.5qGkUehqS.nmDu/h14raQJo9WpHQkYuxVw5tC', 29, 0),
(18, 'Marina', 'Popescu', 'marinapopescu', '$2a$10$HLPzgKEVJo8L1fJi7LMBd.7XXKAfxRq1AScbY0VxdT..cgj8seoke', 25, 0),
(19, 'Dana', 'Lupu', 'danalupu', '$2a$10$bTqutaoIwzHT9wOcq74lSeEbRouzK8c0CWzSbOWeu97T5inwdgOrS', 49, 0),
(20, 'Georgeta', 'Palasan', 'georgetapalasan', '$2a$10$CuKbH2PQ36annZ9R/dvTLOQgkG7wmtABfOYZxIT6yqMy19uBqMcrK', 28, 0);

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_appoiment_room` (`id_room`),
  ADD KEY `FK_appoiment_doctor` (`id_doctor`),
  ADD KEY `FK_appoiment_patient` (`id_patient`),
  ADD KEY `FK_appoiment_nurse` (`id_nurse`);

--
-- Indexuri pentru tabele `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexuri pentru tabele `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `history_patient`
--
ALTER TABLE `history_patient`
  ADD PRIMARY KEY (`id_patient`,`id_history`),
  ADD UNIQUE KEY `id_history` (`id_history`);

--
-- Indexuri pentru tabele `medication`
--
ALTER TABLE `medication`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `nurse`
--
ALTER TABLE `nurse`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `on_call`
--
ALTER TABLE `on_call`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_on_call_doctor` (`id_doctor`),
  ADD KEY `FK_on_call_nurse` (`id_nurse`);

--
-- Indexuri pentru tabele `patient_procedures`
--
ALTER TABLE `patient_procedures`
  ADD PRIMARY KEY (`id_patient`,`id_procedure`,`id_doctor`),
  ADD KEY `fk_patient_procedures_procedures` (`id_procedure`),
  ADD KEY `fk_patient_procedures_doctor` (`id_doctor`);

--
-- Indexuri pentru tabele `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `FK_person_address` (`id_adrdress`);

--
-- Indexuri pentru tabele `petient`
--
ALTER TABLE `petient`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `prescription`
--
ALTER TABLE `prescription`
  ADD PRIMARY KEY (`id_patient`,`id_medication`),
  ADD KEY `fk_prescription_medication` (`id_medication`),
  ADD KEY `fk_prescription_doctor` (`id_doctor`);

--
-- Indexuri pentru tabele `procedures`
--
ALTER TABLE `procedures`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `roles_user`
--
ALTER TABLE `roles_user`
  ADD PRIMARY KEY (`id_role`,`id_user`),
  ADD KEY `fk_user_role_user` (`id_user`);

--
-- Indexuri pentru tabele `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `number` (`number`);

--
-- Indexuri pentru tabele `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pentru tabele eliminate
--

--
-- AUTO_INCREMENT pentru tabele `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- AUTO_INCREMENT pentru tabele `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pentru tabele `appointment`
--
ALTER TABLE `appointment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT pentru tabele `history`
--
ALTER TABLE `history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pentru tabele `medication`
--
ALTER TABLE `medication`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pentru tabele `on_call`
--
ALTER TABLE `on_call`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pentru tabele `procedures`
--
ALTER TABLE `procedures`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pentru tabele `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pentru tabele `room`
--
ALTER TABLE `room`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pentru tabele `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constrângeri pentru tabele eliminate
--

--
-- Constrângeri pentru tabele `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `FK_appoiment_doctor` FOREIGN KEY (`id_doctor`) REFERENCES `doctor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_appoiment_nurse` FOREIGN KEY (`id_nurse`) REFERENCES `nurse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_appoiment_patient` FOREIGN KEY (`id_patient`) REFERENCES `petient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_appoiment_room` FOREIGN KEY (`id_room`) REFERENCES `room` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constrângeri pentru tabele `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `fk_doctor_person` FOREIGN KEY (`id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constrângeri pentru tabele `history_patient`
--
ALTER TABLE `history_patient`
  ADD CONSTRAINT `fk_history_patient_history` FOREIGN KEY (`id_history`) REFERENCES `history` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_history_patient_history_patient` FOREIGN KEY (`id_patient`) REFERENCES `petient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constrângeri pentru tabele `nurse`
--
ALTER TABLE `nurse`
  ADD CONSTRAINT `fk_nurse_person` FOREIGN KEY (`id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constrângeri pentru tabele `on_call`
--
ALTER TABLE `on_call`
  ADD CONSTRAINT `FK_on_call_doctor` FOREIGN KEY (`id_doctor`) REFERENCES `doctor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_on_call_nurse` FOREIGN KEY (`id_nurse`) REFERENCES `nurse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constrângeri pentru tabele `patient_procedures`
--
ALTER TABLE `patient_procedures`
  ADD CONSTRAINT `fk_patient_procedures_doctor` FOREIGN KEY (`id_doctor`) REFERENCES `doctor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_patient_procedures_patient` FOREIGN KEY (`id_patient`) REFERENCES `petient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_patient_procedures_procedures` FOREIGN KEY (`id_procedure`) REFERENCES `procedures` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constrângeri pentru tabele `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `FK_person_address` FOREIGN KEY (`id_adrdress`) REFERENCES `address` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constrângeri pentru tabele `petient`
--
ALTER TABLE `petient`
  ADD CONSTRAINT `fk_patient_person` FOREIGN KEY (`id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constrângeri pentru tabele `prescription`
--
ALTER TABLE `prescription`
  ADD CONSTRAINT `fk_prescription_doctor` FOREIGN KEY (`id_doctor`) REFERENCES `doctor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_prescription_medication` FOREIGN KEY (`id_medication`) REFERENCES `medication` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_prescription_patient` FOREIGN KEY (`id_patient`) REFERENCES `petient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constrângeri pentru tabele `roles_user`
--
ALTER TABLE `roles_user`
  ADD CONSTRAINT `fk_user_role_role` FOREIGN KEY (`id_role`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `fk_user_role_user` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
