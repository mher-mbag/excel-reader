

CREATE DATABASE city_university;

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`description` longtext,
`first_name` varchar(50) DEFAULT NULL,
`last_name` varchar(50) DEFAULT NULL,
`email` text NOT NULL,
`role` varchar(50) NOT NULL,
`status` varchar(50) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `person_details`;
CREATE TABLE `person_details` (
`person_id` bigint(20) NOT NULL,
`date_of_birth` longtext,
`age` varchar(50) DEFAULT NULL,
`gender` varchar(50) DEFAULT NULL,
`nationality` text NOT NULL,
`current_comm_role` bigint(20) NOT NULL,
`historic_comm_role` bigint(20) NOT NULL,
`last_comp` NUMERIC(15,2),
`liquid_wealth` NUMERIC(15,2),
`total_wealth` NUMERIC(15,2)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `education`;
CREATE TABLE `education` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`person_id` bigint(20) NOT NULL,
`date` datetime,
`institute` longtext,
`qualification` varchar(50) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `achievements`;
CREATE TABLE `achievements` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`person_id` bigint(20) NOT NULL,
`date` datetime,
`organization` varchar(50),
`achievements` longtext,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
