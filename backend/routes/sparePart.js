const express = require('express');
const router = express.Router();
const db = require('../database');

router.get('/', (req, res) => {
    db.all('SELECT * FROM spare_parts', [], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});

router.post('/post', (req, res) => {
    const { id_spare_part, name_spare_part, stock_spare_part } = req.body;
    db.run('INSERT INTO spare_parts (id_spare_part, name_spare_part, stock_spare_part) VALUES (?, ?, ?)', [id_spare_part, name_spare_part, stock_spare_part], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Repuesto creado'});
    });
});

router.put('/:id', (req, res) => {
    const { name_spare_part, stock_spare_part }  = req.body;
    db.run('UPDATE spare_parts SET name_spare_part = ?, stock_spare_part = ? WHERE id_spare_part = ?', [name_spare_part, stock_spare_part, req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Repuesto actualizado'});
    });
});

router.get('/:id_spare_part', (req, res) => {
    db.all('SELECT * FROM spare_parts WHERE id_spare_part = ?', [req.params.id_spare_part], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});

router.delete('/:id', (req, res) => {
    db.run('DELETE FROM spare_parts WHERE id_spare_part = ?', [req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ message: 'Repuesto eliminado' });
    });
});

module.exports = router;