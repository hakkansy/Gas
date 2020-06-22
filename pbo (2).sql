-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2020 at 03:35 PM
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

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`noBP`, `nama`, `tempatLahir`, `tglLahir`, `noTelp`) VALUES
('1901012001', 'Ali Suryana', 'Padang', '2001-01-01', '089876787655'),
('1901022002', 'Badu Suramadu', 'Padang Panjang', '2001-01-02', '089876710999'),
('1902022001', 'Cinta Luna', 'Pariaman', '2001-02-03', '081276712012'),
('1902022002', 'Damian Lilliana', 'Padang Pariaman', '2001-02-04', '085210002012'),
('1903012001', 'Elang Malik', 'Bukittinggi', '2001-08-16', '085219292292'),
('1904012001', 'Farhandika Akbar', 'Duri', '2001-08-17', '085266778899'),
('1904022002', 'Ghaitsa Kahitna', 'Dumai', '2001-07-10', '085266771209'),
('1904032003', 'Hanifa Rahma', 'Pekanbaru', '2001-02-11', '085289128892'),
('1904042004', 'Indah Marliana', 'Pekanbaru', '2001-02-19', '085212679485'),
('1904052005', 'Jordi Albuqori', 'Duri', '2001-04-10', '085211226876'),
('1904062006', 'Keyla Cahyani', 'Padang', '2001-05-16', '085211221188'),
('1905012001', 'Linda Nisa', 'Padang Panjang', '2001-05-01', '081311229080'),
('1905022002', 'Meggy Mayanda', 'Padang Pariaman', '2001-11-22', '081309092020'),
('1905032003', 'Narenda Wicaksono', 'Jakarta', '2001-10-21', '081309091122'),
('1906012001', 'Omar Harris', 'Duri', '2001-09-22', '081309011120'),
('1906022002', 'Pandit Arrahman', 'Bangkinang', '2001-01-25', '08130901090'),
('1906032003', 'Qanita Nita', 'Payakumbuh', '2001-02-26', '081310203040'),
('1970012001', 'Reza Rahardian', 'Payakumbuh', '2001-03-29', '089867892292'),
('1970022002', 'Shiva Azzahra', 'Padang', '2001-05-01', '089867891101'),
('1970032003', 'Tania Soebondo', 'Padang Panjang', '2001-06-05', '081366778899'),
('1970042004', 'Ukhti Romadhona', 'Duri', '2001-12-01', '081319098902');

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
