delimiter $$

CREATE  PROCEDURE `removeMovimiento`(IN idf int)
BEGIN
   DELETE FROM movimientos WHERE id = idf;
END$$


delimiter $$

CREATE  PROCEDURE `modifyMovimiento`(IN tipof varchar(20),importef DECIMAL(20,2),fechaf date,idf int)
BEGIN
   UPDATE movimientos SET tipo = tipof, importe = importef , fecha = fechaf 
	WHERE id = idf;
END$$


delimiter $$

CREATE PROCEDURE `getByUserIdAndCategoryIdMovimientoPag`(IN iduser int, idcategoriaf int, startf int,recordsperpage int)
BEGIN
   SELECT * FROM movimientos WHERE idUsuario = iduser AND idCategoria = idcategoriaf LIMIT startf,recordsperpage;
END$$


delimiter $$

CREATE  PROCEDURE `getByUserIdMovimiento`(IN iduser int)
BEGIN
   SELECT * FROM movimientos WHERE idUsuario = iduser;
END$$


delimiter $$

CREATE  PROCEDURE `getByUserIdAndCategoryIdMovimiento`(IN iduser int, idcategoriaf int)
BEGIN
   SELECT * FROM movimientos WHERE idUsuario = iduser AND idCategoria = idcategoriaf;
END$$


delimiter $$

CREATE  PROCEDURE `getByIdUser`(IN idf int)
BEGIN
   SELECT * FROM usuarios WHERE id = idf;
END$$


delimiter $$

CREATE  PROCEDURE `getByIdMovimiento`(IN idf int)
BEGIN
   SELECT * FROM movimientos WHERE id = idf;
END$$


delimiter $$

CREATE  PROCEDURE `getAllCategorias`()
BEGIN
    SELECT * 
    FROM categorias;
END$$


delimiter $$

CREATE  PROCEDURE `getAllUser`()
BEGIN
    SELECT * 
    FROM usuarios;
END$$


delimiter $$

CREATE PROCEDURE `addUser`(IN nombref varchar(50),passwordf varchar(100), OUT idgenerated int)
BEGIN
   INSERT INTO usuarios (nombre, password) VALUE (nombref, passwordf);
SET idgenerated = LAST_INSERT_ID();
END$$


delimiter $$

CREATE  PROCEDURE `addMovimiento`(IN iduserf int, idcategoriaf int,tipof varchar(20),importef DECIMAL(13,2),fechaf date ,OUT idgenerated int )
BEGIN
   INSERT INTO movimientos (idUsuario,idCategoria,tipo,importe,fecha) VALUE (iduserf,idcategoriaf,tipof,importef,fechaf);
	SET idgenerated = LAST_INSERT_ID();
END$$


