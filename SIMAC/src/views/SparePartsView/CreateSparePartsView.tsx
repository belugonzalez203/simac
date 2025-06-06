import React, { useState } from 'react';
import styles from '../../styles/CreateForm.module.css';
import { useNavigate } from 'react-router-dom';

const CreateSparePartsView = () => {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        codigo: '',
        nombre: '',
        existencia: '',
    });

    const [errors, setErrors] = useState({
        codigo: false,
        nombre: false,
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFormData(prev => ({ ...prev, [name]: value }));
    };

    const validate = () => {
        const newErrors = {
            codigo: formData.codigo.trim() === '',
            nombre: formData.nombre.trim() === '',
        };
        setErrors(newErrors);
        return !Object.values(newErrors).some(Boolean);

    };

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        if (!validate()) return;

        // Enviar los datos al backend aquí
        console.log('Formulario válido:', formData);
    };

    const handleCancel = () => {
        navigate('/repuestos');
    };

    return (
        <div className={styles.container}>
            <h1 className={styles.title}>CREAR REPUESTO</h1>
            <form className={styles.form} onSubmit={handleSubmit}>
                <div className={styles.field}>
                    <label>Código<span>*</span></label>
                    <input type="text" name="codigo" value={formData.codigo} onChange={handleChange} />
                    {errors.codigo && <p className={styles.error}>Este campo es obligatorio</p>}
                </div>

                <div className={styles.field}>
                    <label>Nombre<span>*</span></label>
                    <input type="text" name="nombre" value={formData.nombre} onChange={handleChange} />
                    {errors.nombre && <p className={styles.error}>Este campo es obligatorio</p>}
                </div>

                <div className={styles.field}>
                    <label>Existencia</label>
                    <input type="number" name="existencia" value={formData.existencia} onChange={handleChange} />
                </div>

                <div className={styles.buttonGroup}>
                    <button type="submit" className={styles.saveButton}>GUARDAR</button>
                    <button type="button" className={styles.cancelButton} onClick={handleCancel}>CANCELAR</button>
                </div>
            </form>
        </div>
    );
};

export default CreateSparePartsView;