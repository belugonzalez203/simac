const express = require('express');
const router = express.Router();
const db = require('../database');

router.get('/', (req, res) => {
    db.all('SELECT * FROM service_status_equipment', [], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});

router.post('/post', (req, res) => {
    const { name_service } = req.body;
    db.run('INSERT INTO service_status_equipment (name_service) VALUES (?)', [name_service], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Tipo mantenimiento creado'});
    });
});

router.put('/:id', (req, res) => {
    const { name_service }  = req.body;
    db.run('UPDATE service_status_equipment SET name_service = ? WHERE id_service = ?', [name_service, req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Tipo mantenimiento actualizado'});
    });
});

router.get('/:id_service', (req, res) => {
    db.all('SELECT * FROM service_status_equipment WHERE id_service = ?', [req.params.id_service], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});

router.delete('/:id', (req, res) => {
    db.run('DELETE FROM service_status_equipment WHERE id_service = ?', [req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ message: 'Tipo mantenimiento eliminado' });
    });
});

module.exports = router;