/** 
* Project:         PruebaTS
* Description:     Se realiza modelo para la prueba tenica
* Author:          Yerson Quintana
* DB impact:       YES<br/>
* Commit inside:   YES<br/>
* Rollback inside: NO<br/>
* @headcom
*/
CREATE DATABASE pruebaTS;
USE pruebaTS;
CREATE TABLE Empleado(
IdEmpleado Integer AUTO_INCREMENT NOT NULL,
Nombre VARCHAR(150) NOT NULL,
Apellido VARCHAR (150) NOT NULL,
NumeroIdentificacion VARCHAR (150) NOT NULL,
TipoIdentificacion ENUM('CC','TI','PA', 'TE'),
CONSTRAINT PK_Empleado  PRIMARY KEY(IdEmpleado)
);

CREATE TABLE Actividad(
IdActividad Integer AUTO_INCREMENT NOT NULL,
Nombre VARCHAR(150) NOT NULL,
Descripcion VARCHAR(500) NOT NULL,
Estado ENUM('Registrada','Realizada','Pendiente'),
FechaEjecucion DATETIME NOT NULL,
FechaCreacion DATETIME NOT NULL,
FechaModificacion DATETIME NULL,
CONSTRAINT PK_Actividad  PRIMARY KEY(IdActividad)
);

CREATE TABLE ActividadPorEmpleado(
IdActividadPorEmpleado Integer AUTO_INCREMENT NOT NULL,
IdActividad Integer NOT NULL,
IdEmpleado Integer NOT NULL,
CONSTRAINT PK_ActividadPorEmpleado  PRIMARY KEY(IdActividadPorEmpleado),
CONSTRAINT UN_ActividadPorEmpleado UNIQUE (IdActividad),
CONSTRAINT FK_Actividad FOREIGN KEY (IdActividad) REFERENCES Actividad(IdActividad),
CONSTRAINT FK_Empleado FOREIGN KEY (IdEmpleado) REFERENCES Empleado(IdEmpleado)
);

INSERT INTO Empleado (Nombre,Apellido,NumeroIdentificacion ,TipoIdentificacion)
VALUES
    (
        'Martha',
        'Afanador',
        '10236598',
        'CC'
    ),
    (
        'Hector',
        'Barreto',
        '7925362',
        'TE'
    ),
    (
        'Mauricio',
        'Manzo',
        '78325965',
        'CC'
    );