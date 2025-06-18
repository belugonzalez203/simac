const express = require('express');
const router = express.Router();
const db = require('../database');

router.get('/', (req, res) => {
    db.all('SELECT * FROM type_maintenance', [], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});

router.post('/post', (req, res) => {
    const { name_type } = req.body;
    db.run('INSERT INTO type_maintenance (name_type) VALUES (?)', [name_type], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Tipo mantenimiento creado'});
    });
});

router.put('/:id', (req, res) => {
    const { name_type }  = req.body;
    db.run('UPDATE type_maintenance SET name_type = ? WHERE id_type = ?', [name_type, req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Tipo mantenimiento actualizado'});
    });
});

router.get('/:id_type', (req, res) => {
    db.all('SELECT * FROM type_maintenance WHERE id_type = ?', [req.params.id_type], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});

router.delete('/:id', (req, res) => {
    db.run('DELETE FROM type_maintenance WHERE id_type = ?', [req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ message: 'Tipo mantenimiento eliminado' });
    });
});

module.exports = router;