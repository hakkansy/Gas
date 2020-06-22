-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2020 at 09:55 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `noBP` varchar(10) NOT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `tempatLahir` varchar(20) DEFAULT NULL,
  `tglLahir` date DEFAULT NULL,
  `noTelp` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `kdPembayaran` varchar(10) NOT NULL,
  `noBP` varchar(10) NOT NULL,
  `kdProdi` varchar(10) NOT NULL,
  `gol` varchar(10) NOT NULL,
  `semester` varchar(10) NOT NULL,
  `total` double NOT NULL,
  `tglPembayaran` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `prodi`
--

CREATE TABLE `prodi` (
  `kdProdi` varchar(15) NOT NULL,
  `prodi` varchar(60) DEFAULT NULL,
  `jurusan` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prodi`
--

INSERT INTO `prodi` (`kdProdi`, `prodi`, `jurusan`) VALUES
('AB001', 'D-III Administrasi Bisnis	', 'Administrasi Niaga '),
('AB002', 'D-III Usaha Perjalanan Wisata', 'Administrasi Niaga '),
('AK001', 'D-III Akuntansi	', 'Akuntansi'),
('AK002', 'D-IV Akuntansi	', 'Akuntansi'),
('BI001', 'D-III Bahasa Inggris	', 'Bahasa Inggris'),
('TE001', 'D-III Teknik Elektronika	', 'Teknik Elektro'),
('TE002', 'D-III Teknik Listrik', 'Teknik Elektro'),
('TE003', 'D-III Teknik Telekomunikasi', 'Teknik Elektro'),
('TE004', 'D-IV Teknik Elektronika	', 'Teknik Elektro'),
('TE005', 'D-IV Teknik Telekomunikasi', 'Teknik Elektro'),
('TE006', 'D-IV Teknologi Rekayasa Instalasi Listrik', 'Teknik Elektro'),
('TI001', 'D-III Manajemen Informatika', 'Teknologi Informasi'),
('TI002', 'D-III Teknik Komputer	', 'Teknologi Informasi'),
('TI003', 'D-IV Teknologi Rekayasa Perangkat Lunak', 'Teknologi Informasi'),
('TM001', 'D-III Teknik Alat Berat	', 'Teknik Mesin'),
('TM002', 'D-III Teknik Mesin	', 'Teknik Mesin'),
('TM003', 'D-IV Teknik Manufaktur	', 'Teknik Mesin'),
('TS001', 'D-III Teknik Sipil	', 'Teknik Sipil'),
('TS002', 'D-IV Manajemen Rekayasa Konstruksi	', 'Teknik Sipil'),
('TS003', 'D-IV Perencanaan Jalan Dan Jembatan	', 'Teknik Sipil'),
('TS004', 'D-IV Teknik Perencanaan Irigasi Dan Rawa', 'Teknik Sipil');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`noBP`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`kdPembayaran`,`noBP`,`kdProdi`);

--
-- Indexes for table `prodi`
--
ALTER TABLE `prodi`
  ADD PRIMARY KEY (`kdProdi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
