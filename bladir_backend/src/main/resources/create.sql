DROP SCHEMA IF EXISTS `blood-db`;

CREATE SCHEMA `blood-db`;

use `blood-db`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(45) DEFAULT NULL unique,
    `firstname` varchar(45) DEFAULT NULL,
    `lastname` varchar(45) DEFAULT NULL,
    `password` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    `gender` varchar(45) DEFAULT NULL,
    `role_id` int(11) DEFAULT NULL,
    PRIMARY KEY(`id`), 
    KEY `FK_ROLE_idx` (`role_id`),
    CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`)
    REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `role_name` varchar(45) DEFAULT NULL unique,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
    `record_id` int(11) NOT NULL AUTO_INCREMENT,
   `value_name` varchar(45) DEFAULT NULL,
    `value` NUMERIC(8, 3) DEFAULT NULL,
   `test_id` int(11) DEFAULT NULL,
   `record_comment` varchar(45) DEFAULT 'NO COMMNET',
   PRIMARY KEY ( `record_id`),
    KEY `FK_TEST_idx` (`test_id`),
    CONSTRAINT `FK_TEST` FOREIGN KEY (`test_id`) 
    REFERENCES `test` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
	KEY `FK_standard_idx` (`value_name`),
    CONSTRAINT `FK_standard` FOREIGN KEY (`value_name`) 
    REFERENCES `standard` (`value_name`) ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
   `date` date DEFAULT '2018-07-01',
   `test_comment` varchar(45) DEFAULT 'NO COMMNET',
   `patient_id` int(11) DEFAULT NULL,
   PRIMARY KEY ( `id`),
    KEY `FK_USER_idx` (`patient_id`),
    CONSTRAINT `FK_USER` FOREIGN KEY (`patient_id`) 
    REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `standard` (
   `value_name` varchar(45) NOT NULL,
   `low` NUMERIC(8, 3) DEFAULT NULL,
   `high` NUMERIC(8, 3) DEFAULT NULL,
   PRIMARY KEY (`value_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

Insert into standard (value_name,low,high) values 
('WBC',4.0,10.5);

Insert into standard (value_name,low,high) values 
('RBC',4.1,5.6);

Insert into standard (value_name,low,high) values 
('MCV',4.0,4.9);


Insert into role (role_name) values 
('Doctor');

Insert into role (role_name) values 
('Patient');

Insert into role (role_name) values 
('Analyst');

Insert into user (username, firstname, lastname, password, email, gender, role_id) values
('AriJames', 'Ari', 'James', '12345', 'patient@email.com', 'male', 2);

Insert into user (username, firstname, lastname, password, email, gender, role_id) values
('JeanAlen', 'Jean', 'Alen', '12345', 'doctor@email.com', 'female', 1);

Insert into test (date, test_comment, patient_id) values
(CURRENT_DATE - INTERVAL 1 YEAR, 'You are well',1);

Insert into record (value_name, value, test_id, record_comment) values
('WBC',11.2, 1,'FEI YAN');

Insert into record (value_name, value, test_id, record_comment) values
('RBC',5.2, 1,'NORMAL');

Insert into record (value_name, value, test_id, record_comment) values
('MCV',4.5, 1,'NORMAL');