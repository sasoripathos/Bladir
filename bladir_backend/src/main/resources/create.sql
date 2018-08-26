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
   `record_comment` varchar(255) DEFAULT 'NO COMMNET',
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
   `test_comment` varchar(255) DEFAULT 'NO COMMNET',
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
('2018-06-22', 'WBC is slightly higher than reference upper bound, patient may have some inflammation',1);

Insert into test (date, test_comment, patient_id) values
('2018-06-25','WBC is much higher than reference upper bound. According to the symptoms, patient can be diagnosed as Pneumonia',1);

Insert into test (date, test_comment, patient_id) values
('2018-07-01', 'WBC is still higher than reference upper bound, but it shows that Pneumonia is under control',1);

Insert into test (date, test_comment, patient_id) values
('2018-07-05', 'WBC is slightly higher than reference upper bound. Pneumonia is neally cured. RBC and MCV are less than there reference lower bound, patient has a little anemia',1);

Insert into test (date, test_comment, patient_id) values
('2018-07-10', 'All WBC, RBC and MCV are back to reference interval, pneumonia and anemia are cured',1);

Insert into record (value_name, value, test_id, record_comment) values
('WBC',11.2, 1,'Potential inflammation');

Insert into record (value_name, value, test_id, record_comment) values
('RBC',5.2, 1,'In health state');

Insert into record (value_name, value, test_id, record_comment) values
('MCV',4.5, 1,'In health state');

Insert into record (value_name, value, test_id, record_comment) values
('WBC',13.7, 2,'Can be diagnosed as pneumonia');

Insert into record (value_name, value, test_id, record_comment) values
('RBC',4.7, 2,'In health state');

Insert into record (value_name, value, test_id, record_comment) values
('MCV',4.8, 2,'In health state');

Insert into record (value_name, value, test_id, record_comment) values
('WBC',12.9, 3,'Pneumonia is under control after treatment');

Insert into record (value_name, value, test_id, record_comment) values
('RBC',4.2, 3,'In health state');

Insert into record (value_name, value, test_id, record_comment) values
('MCV',4.5, 3,'In health state');

Insert into record (value_name, value, test_id, record_comment) values
('WBC',10.7, 4,'Pneumonia is nearly cured');

Insert into record (value_name, value, test_id, record_comment) values
('RBC',3.8, 4,'Sightly anemia');

Insert into record (value_name, value, test_id, record_comment) values
('MCV',3.9, 4,'Sightly anemia');

Insert into record (value_name, value, test_id, record_comment) values
('WBC',7.3, 5, 'You have be back to health state');

Insert into record (value_name, value, test_id, record_comment) values
('RBC',4.5, 5,'You have be back to health state');

Insert into record (value_name, value, test_id, record_comment) values
('MCV',4.2, 5,'In health state');