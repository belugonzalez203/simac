const express = require('express');
const router = express.Router();
const db = require('../database');
router.get('/', (req, res) => {
    db.all('SELECT * FROM areas', [], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});


router.post('/post', (req, res) => {
    const { id_area, name_area, in_charge, contact_number_area } = req.body;
    db.run('INSERT INTO areas (id_area, name_area, in_charge, contact_number_area) VALUES (?, ?, ?, ?)', [id_area, name_area, in_charge, contact_number_area], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Area creada'});
    });
});

router.put('/:id', (req, res) => {
    const { name_area, in_charge, contact_number_area } = req.body;
    db.run('UPDATE areas SET name_area = ?, in_charge = ?, contact_number_area = ? WHERE id_area = ?', [name_area, in_charge, contact_number_area, req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Area actualizada'});
    });
});

router.patch('/:id', (req, res) => {
    const { name_area, in_charge, contact_number_area } = req.body;
    db.run('UPDATE areas SET name_area = ?, in_charge = ?, contact_number_area = ? WHERE id_area = ?', [name_area, in_charge, contact_number_area, req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Area actualizada'});
    });
});

router.get('/:id_area', (req, res) => {
    db.all('SELECT * FROM areas WHERE id_area = ?', [req.params.id_area], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});

router.delete('/:id', (req, res) => {
    db.run('DELETE FROM areas WHERE id_area = ?', [req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ message: 'Area eliminada' });
    });
});


module.exports = router;