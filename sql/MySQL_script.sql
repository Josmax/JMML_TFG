# Faltaria esto para la primera vez: create database usersdb;
use usersdb;

drop table if exists users;
drop table if exists mensajes;
drop table if exists incidencias;
drop table if exists procesos;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `incidencias` (
  `incidencia_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `departamento` varchar(45) NOT NULL,
  `cliente` varchar(45) NOT NULL,
  PRIMARY KEY (`incidencia_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `usersdb`.`incidencias` (`incidencia_id`, `cod`, `descripcion`, `departamento`, `cliente`) VALUES ('1', '001', 'Hay una rata en la papelera', 'Testing', 'Maria heugenia');
INSERT INTO `usersdb`.`incidencias` (`incidencia_id`, `cod`, `descripcion`, `departamento`, `cliente`) VALUES ('2', '002', 'Tengo dudas en que comer hoy', 'Dementes', 'Kratos Marti Santos');
INSERT INTO `usersdb`.`incidencias` (`incidencia_id`, `cod`, `descripcion`, `departamento`, `cliente`) VALUES ('3', '003', 'El raton se acaba de estropear', 'Tecnologico', 'Pepe Ortiz');
INSERT INTO `usersdb`.`incidencias` (`incidencia_id`, `cod`, `descripcion`, `departamento`, `cliente`) VALUES ('4', '004', 'Me aburro y eso me altera', 'Ocio', 'Titi Toto Tatata');
INSERT INTO `usersdb`.`incidencias` (`incidencia_id`, `cod`, `descripcion`, `departamento`, `cliente`) VALUES ('5', '005', 'Fuego en la cocina', 'Campo', 'Lola lolo');

CREATE TABLE `mensajes` (
  `mensaje_id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `contenido` varchar(200) NOT NULL,
  `incidencia` int(11),
  PRIMARY KEY (`mensaje_id`),
  foreign key(incidencia) references incidencias(incidencia_id)
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `usersdb`.`mensajes` (`mensaje_id`, `titulo`, `contenido`, `incidencia`) VALUES ('1', 'Rescate', 'Prueba a ayudar a la rata', '2');
INSERT INTO `usersdb`.`mensajes` (`mensaje_id`, `titulo`, `contenido`, `incidencia`) VALUES ('2', 'Oculta', 'El problema segue.. la rata tiene nociones ', '3');
INSERT INTO `usersdb`.`mensajes` (`mensaje_id`, `titulo`, `contenido`, `incidencia`) VALUES ('3', 'Ver', 'Has mirado si es una rata o es tu compañero', '1');
INSERT INTO `usersdb`.`mensajes` (`mensaje_id`, `titulo`, `contenido`, `incidencia`) VALUES ('4', 'Sorry', 'Madremia! era mi compañero. Dice que ha dormido mal', '2');
INSERT INTO `usersdb`.`mensajes` (`mensaje_id`, `titulo`, `contenido`, `incidencia`) VALUES ('5', 'Tiempo muerto', 'No se que escribir', '3');

CREATE TABLE `procesos` (
  `proceso_id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(45) NOT NULL,
  `hora` varchar(200) NOT NULL,
  PRIMARY KEY (`proceso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;




