const express = require('express');
const router = express.Router();
const db = require('../database');
router.get('/', (req, res) => {
    db.all('SELECT * FROM technicians', [], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});

router.post('/post', (req, res) => {
    const { id_tech, name_tech, contact_number_tech, id_area, id_user } = req.body;
    db.run('INSERT INTO technicians (id_tech, name_tech, contact_number_tech, id_area, id_user) VALUES (?, ?, ?, ?, ?)', [id_tech, name_tech, contact_number_tech, id_area, id_user], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Tecnico creado'});
    });
});

router.put('/:id', (req, res) => {
    const { name_tech, contact_number_tech, id_area, id_user }  = req.body;
    db.run('UPDATE technicians SET name_tech = ?, contact_number_tech = ?, id_area = ?, id_user = ? WHERE id_tech = ?', [name_tech, contact_number_tech, id_area, id_user, req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Tecnico actualizado'});
    });
});

router.get('/:id_tech', (req, res) => {
    db.all('SELECT * FROM technicians WHERE id_tech = ?', [req.params.id_tech], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});

router.delete('/:id', (req, res) => {
    db.run('DELETE FROM technicians WHERE id_tech = ?', [req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ message: 'Tecnico eliminado' });
    });
});

module.exports = router;