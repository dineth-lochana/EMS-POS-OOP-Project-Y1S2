-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 24, 2023 at 11:01 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oopfinal`
--

-- --------------------------------------------------------

--
-- Table structure for table `employeeorderallocation`
--

CREATE TABLE `employeeorderallocation` (
  `index` int(11) NOT NULL,
  `employeeId` int(11) NOT NULL,
  `orderId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `employeeorderallocation`
--

INSERT INTO `employeeorderallocation` (`index`, `employeeId`, `orderId`) VALUES
(1, 10, 2),
(3, 2, 2),
(4, 2, 2),
(5, 10, 1),
(6, 5, 2),
(7, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `employees_test`
--

CREATE TABLE `employees_test` (
  `EmpID` int(11) NOT NULL,
  `FirstName` varchar(40) NOT NULL,
  `LastName` varchar(40) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `Age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `employees_test`
--

INSERT INTO `employees_test` (`EmpID`, `FirstName`, `LastName`, `Email`, `Age`) VALUES
(1, 'cat', 'boy', 'ctboyyy@gamil.com', 1),
(2, 'john', 'uuioop', 'johnny@gmail.com', 60),
(3, 'jingle', 'cat', 'jing@222outlook.com', 33),
(4, 'edward', 'silva', 'eddd@yahoo.coml.com', 44),
(5, 'blackcat', 'jack', 'blcat@yahoo.com', 23);

-- --------------------------------------------------------

--
-- Table structure for table `inventory_test`
--

CREATE TABLE `inventory_test` (
  `ItemID` int(11) NOT NULL,
  `ItemName` varchar(40) NOT NULL,
  `UnitPrice` double NOT NULL,
  `TotalQty` int(11) NOT NULL,
  `UsedQty` int(11) NOT NULL,
  `RemainingQty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `inventory_test`
--

INSERT INTO `inventory_test` (`ItemID`, `ItemName`, `UnitPrice`, `TotalQty`, `UsedQty`, `RemainingQty`) VALUES
(1, 'paper', 230, 1000, 900, 100),
(2, 'stapler', 200, 20, 3, 17),
(4, 'red', 344, 400, 222, 178),
(5, 'rrrr', 3443, 40, 20, 20),
(6, 'eeeee', 33, 100, 20, 80),
(7, 'wwwww', 333, 500, 100, 400),
(8, 'eewwq', 33, 100, 4, 96),
(9, 'dddd', 122, 800, 555, 245),
(10, 'gertee', 30.96, 980, 80, 900),
(11, 'getfood', 32, 100, 0, 100);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL,
  `item` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `contact` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`orderid`, `item`, `amount`, `contact`, `date`) VALUES
(1, 'paper', 30, 'test@gmail.com', '2022-03-21'),
(2, 'stapler', 30, 'test@123.com', '2022-03-19'),
(3, 'stapler', 10, 'test@123.com', '2023-03-23'),
(4, 'paper', 9, 'test20@123.com', '2023-04-18'),
(5, 'Pencils', 20, 'testtesting@123.com', '2023-05-23');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `SalesID` int(11) NOT NULL,
  `Amount` int(11) NOT NULL,
  `Buyer` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`SalesID`, `Amount`, `Buyer`) VALUES
(2, 3000, 'Jack'),
(10, 10000, 'John');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `SupplierID` int(11) NOT NULL,
  `Suppliername` varchar(100) NOT NULL,
  `Item` varchar(50) NOT NULL,
  `Quantity` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`SupplierID`, `Suppliername`, `Item`, `Quantity`) VALUES
(1, 'John', 'Site Art', '23'),
(2, 'Daisy', 'Site Banners', '5'),
(3, 'Barry', 'Advert Strips', '10'),
(4, 'Iris', 'Logo Design', '10'),
(5, 'Cisco', 'Advetisement Music', '3'),
(6, 'Thawne', 'Logo Art', '40');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `uid` int(11) NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`uid`, `username`, `password`) VALUES
(1, 'admin', 'admin123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employeeorderallocation`
--
ALTER TABLE `employeeorderallocation`
  ADD PRIMARY KEY (`index`);

--
-- Indexes for table `employees_test`
--
ALTER TABLE `employees_test`
  ADD PRIMARY KEY (`EmpID`);

--
-- Indexes for table `inventory_test`
--
ALTER TABLE `inventory_test`
  ADD PRIMARY KEY (`ItemID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderid`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`SalesID`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`SupplierID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employeeorderallocation`
--
ALTER TABLE `employeeorderallocation`
  MODIFY `index` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
