const express = require('express');
const router = express.Router();
const db = require('../database');
router.get('/', (req, res) => {
    db.all('SELECT eq.id_equip, eq.code_equip, eq.name_equip, eq.number_plate, eq.brand_equip, eq.model_equip, eq.chassis_equip, areas.name_area FROM work_orders AS wo LEFT JOIN users AS u ON u.id_user = wo.id_user LEFT JOIN technicians AS tech ON tech.id_tech = wo.id_tech LEFT JOIN equipment AS eq ON eq.id_equip = wo.id_equip LEFT JOIN type_maintenance AS type ON type.id_type = wo.type LEFT JOIN class_maintenance AS class ON class.id_class = wo.id_class', [], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});

router.post('/post', (req, res) => {
    const { id_order, id_tech, id_equip,  name_tech, contact_number_tech, id_area, id_user } = req.body;
    db.run('INSERT INTO work_orders (id_tech, name_tech, contact_number_tech, id_area, id_user) VALUES (?, ?, ?, ?, ?)', [id_tech, name_tech, contact_number_tech, id_area, id_user], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Tecnico creado'});
    });
});

router.put('/:id', (req, res) => {
    const { name_tech, contact_number_tech, id_area, id_user }  = req.body;
    db.run('UPDATE work_orders SET name_tech = ?, contact_number_tech = ?, id_area = ?, id_user = ? WHERE id_tech = ?', [name_tech, contact_number_tech, id_area, id_user, req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.status(201).json({ message: 'Tecnico actualizado'});
    });
});

router.get('/:id_tech', (req, res) => {
    db.all('SELECT * FROM work_orders WHERE id_tech = ?', [req.params.id_tech], (err, rows) => {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ data: rows });
    });
});

router.delete('/:id', (req, res) => {
    db.run('DELETE FROM work_orders WHERE id_tech = ?', [req.params.id], function (err) {
        if (err) return res.status(500).json({ error: err.message });
        res.json({ message: 'Tecnico eliminado' });
    });
});

module.exports = router;