CREATE DATABASE IF NOT EXISTS `gestion-cartera` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `gestion-cartera`;

CREATE TABLE IF NOT EXISTS `usuarios` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`nombre` varchar(50) NOT NULL,
`password` varchar(100) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE categorias(
    id INT AUTO_INCREMENT PRIMARY KEY,
    url varchar(200) not null,
    nombre varchar(50) not null,
    tipo varchar(50) not null
) ENGINE=INNODB;

CREATE TABLE movimientos(
    id INT AUTO_INCREMENT PRIMARY KEY,
	idUsuario INT,
	idCategoria INT,
    tipo varchar(20) not null,
    importe float(10,2) not null,
	fecha date not null,
    CONSTRAINT fk_usuarios
    FOREIGN KEY (idUsuario) 
        REFERENCES usuarios(id),
	CONSTRAINT fk_categoria
    FOREIGN KEY (idCategoria) 
        REFERENCES categorias(id)
) ENGINE=INNODB;