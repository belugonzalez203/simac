// sqlite.js
const sqlite3 = require('sqlite3').verbose();
const path = require('path');
require('dotenv').config();

// Configuración: archivo de base de datos (puede venir de env o por defecto)
const DB_PATH =  path.join(__dirname, 'simac.db');

// Crear la conexión a la base de datos SQLite
const db = new sqlite3.Database(DB_PATH, (err) => {
    if (err) {
        console.error('Error al conectar con SQLite:', err.message);
    } else {
        console.log('Conectado a la base de datos SQLite en ${DB_PATH}');
    }
});

module.exports = db;