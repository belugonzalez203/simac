const express = require('express');
const router = express.Router();
const db = require('../database');

router.get('/', (req, res) => {
    db.all(
        'SELECT eq.id_equip, eq.code_equip, eq.name_equip, eq.number_plate, eq.brand_equip, eq.model_equip, eq.chassis_equip, areas.name_area FROM equipments AS eq LEFT JOIN areas ON areas.id_area = eq.id_area', [], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});

router.post('/post', (req, res) => {
    const { code_equip, name_equip, number_plate, brand_equip, model_equip, chassis_equip, id_service, id_area } = req.body;
    db.run('INSERT INTO equipments (code_equip, name_equip, number_plate, brand_equip, model_equip, chassis_equip, id_service, id_area) VALUES (?, ?, ?, ?, ?, ?, ?, ?)', [code_equip, name_equip, number_plate, brand_equip, model_equip, chassis_equip, id_service, id_area], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Equipo creado'});
    });
});

router.put('/:id', (req, res) => {
    const { code_equip, name_equip, number_plate, brand_equip, model_equip, chassis_equip, id_service, id_area }  = req.body;
    db.run('UPDATE equipments SET code_equip = ?, name_equip = ?, number_plate = ?, brand_equip = ?, model_equip = ?, chassis_equip = ?, id_service = ?, id_area = ? WHERE id_equip = ?', [code_equip, name_equip, number_plate, brand_equip, model_equip, chassis_equip, id_service, id_area, req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Equipo actualizado'});
    });
});

router.get('/:id_equip', (req, res) => {
    db.all('SELECT * FROM equipments WHERE id_equip = ?', [req.params.id_equip], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});

router.delete('/:id', (req, res) => {
    db.run('DELETE FROM equipments WHERE id_equip = ?', [req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ message: 'Equipo eliminado' });
    });
});

module.exports = router;