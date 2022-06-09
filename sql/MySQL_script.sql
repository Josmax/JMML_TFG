# Faltaria esto para la primera vez: create database usersdb;
use usersdb;

drop table if exists users;
drop table if exists mensajes;
drop table if exists procesos;
drop table if exists incidencias;

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

INSERT INTO `usersdb`.`incidencias` (`incidencia_id`, `cod`, `descripcion`, `departamento`, `cliente`) VALUES ('1', '001', 'Se va la luz con mucha frecuencia', 'Testing', 'Maria heugenia');
INSERT INTO `usersdb`.`incidencias` (`incidencia_id`, `cod`, `descripcion`, `departamento`, `cliente`) VALUES ('2', '002', 'El teclado no tiene la ñ', 'Dementes', 'Kratos Marti Santos');
INSERT INTO `usersdb`.`incidencias` (`incidencia_id`, `cod`, `descripcion`, `departamento`, `cliente`) VALUES ('3', '003', 'El monitor parpadea', 'Tecnologico', 'Pepe Ortiz');
INSERT INTO `usersdb`.`incidencias` (`incidencia_id`, `cod`, `descripcion`, `departamento`, `cliente`) VALUES ('4', '004', 'Error en usuario', 'Ocio', 'Titi Toto Tatata');
INSERT INTO `usersdb`.`incidencias` (`incidencia_id`, `cod`, `descripcion`, `departamento`, `cliente`) VALUES ('5', '005', 'Página no disponible', 'Campo', 'Lola lolo');

CREATE TABLE `mensajes` (
  `mensaje_id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `contenido` varchar(200) NOT NULL,
  `incidencia` int(11),
  PRIMARY KEY (`mensaje_id`),
  foreign key(incidencia) references incidencias(incidencia_id)
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `usersdb`.`mensajes` (`mensaje_id`, `titulo`, `contenido`, `incidencia`) VALUES ('1', 'Global', 'No deberias necesitar usar la ñ, deber escribir en Ingles', '2');
INSERT INTO `usersdb`.`mensajes` (`mensaje_id`, `titulo`, `contenido`, `incidencia`) VALUES ('2', 'Oculta', 'Puede que alguna opción este oculta', '3');
INSERT INTO `usersdb`.`mensajes` (`mensaje_id`, `titulo`, `contenido`, `incidencia`) VALUES ('3', 'Ver', 'Creo que es por la tensión', '1');
INSERT INTO `usersdb`.`mensajes` (`mensaje_id`, `titulo`, `contenido`, `incidencia`) VALUES ('4', 'Comprendido', 'Si, totalmente de acuerdo', '2');
INSERT INTO `usersdb`.`mensajes` (`mensaje_id`, `titulo`, `contenido`, `incidencia`) VALUES ('5', 'Tiempo muerto', 'No se que escribir', '3');

CREATE TABLE `procesos` (
  `proceso_id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(45) NOT NULL,
  `hora` varchar(200) NOT NULL,
  `estado` enum ('Resuelta', 'SinSolucion', 'Pendiente', 'Procesando'),                                                                                 
  `incidencia` int(11),
  PRIMARY KEY (`proceso_id`),
  foreign key(incidencia) references incidencias(incidencia_id)
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `usersdb`.`procesos` (`proceso_id`, `fecha`, `hora`, `estado`, `incidencia`) VALUES ('1', '12/05/22', '12:30', 'Pendiente', '1');
INSERT INTO `usersdb`.`procesos` (`proceso_id`, `fecha`, `hora`, `estado`, `incidencia`) VALUES ('2', '17/08/20', '09:00', 'Pendiente', '1');
INSERT INTO `usersdb`.`procesos` (`proceso_id`, `fecha`, `hora`, `estado`, `incidencia`) VALUES ('3', '1/09/1994', '07:78', 'Pendiente', '2');
INSERT INTO `usersdb`.`procesos` (`proceso_id`, `fecha`, `hora`, `estado`, `incidencia`) VALUES ('4', '23/10/2015', '11:45', 'Pendiente', '2');
INSERT INTO `usersdb`.`procesos` (`proceso_id`, `fecha`, `hora`, `estado`, `incidencia`) VALUES ('5', '32/13/0000', '04:32', 'Resuelta', '2');




