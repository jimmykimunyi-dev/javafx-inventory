CREATE DATABASE inventory;

USE inventory;

CREATE TABLE Products (
                          id INT PRIMARY KEY AUTOINCREMENT,
                          name VARCHAR(255) NOT NULL,
                          inventory INT NOT NULL,
                          cost INT NOT NULL,
                          max INT NOT NULL,
                          min INT NOT NULL
);

CREATE TABLE Parts (
                       id INT PRIMARY KEY AUTOINCREMENT,
                       name VARCHAR(255) NOT NULL,
                       inventory INT NOT NULL,
                       cost DOUBLE NOT NULL,
                       max INT NOT NULL,
                       min INT NOT NULL,
                       machineId INT NOT NULL,
                       FOREIGN KEY (machineId) REFERENCES Machines(id)
);
