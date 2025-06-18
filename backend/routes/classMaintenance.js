const express = require('express');
const router = express.Router();
const db = require('../database');

router.get('/', (req, res) => {
    db.all('SELECT * FROM class_maintenance', [], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});

router.post('/post', (req, res) => {
    const { name_class } = req.body;
    db.run('INSERT INTO class_maintenance (name_class) VALUES (?)', [name_class], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Tipo mantenimiento creado'});
    });
});

router.put('/:id', (req, res) => {
    const { name_class }  = req.body;
    db.run('UPDATE class_maintenance SET name_class = ? WHERE id_class = ?', [name_class, req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Tipo mantenimiento actualizado'});
    });
});

router.get('/:id_class', (req, res) => {
    db.all('SELECT * FROM class_maintenance WHERE id_class = ?', [req.params.id_class], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});

router.delete('/:id', (req, res) => {
    db.run('DELETE FROM class_maintenance WHERE id_class = ?', [req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ message: 'Tipo mantenimiento eliminado' });
    });
});

module.exports = router;