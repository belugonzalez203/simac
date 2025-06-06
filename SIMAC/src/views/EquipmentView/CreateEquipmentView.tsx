import React, { useState } from 'react';
import styles from '../../styles/CreateForm.module.css';
import { useNavigate } from 'react-router-dom';

const CreateEquipmentView = () => {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        codigo: '',
        nombre: '',
        marca: '',
        modelo: '',
        chasis: '',
    });

    const [errors, setErrors] = useState({
        codigo: false,
        nombre: false,
        marca: false,
        chasis: false,
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFormData(prev => ({ ...prev, [name]: value }));
    };

    const validate = () => {
        const newErrors = {
            codigo: formData.codigo.trim() === '',
            nombre: formData.nombre.trim() === '',
            marca: formData.marca.trim() === '',
            chasis: formData.chasis.trim() === '',
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
        navigate('/equipos');
    };

    return (
        <div className={styles.container}>
            <h1 className={styles.title}>CREAR EQUIPO</h1>
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
                    <label>Marca<span>*</span></label>
                    <input type="text" name="marca" value={formData.marca} onChange={handleChange} />
                    {errors.marca && <p className={styles.error}>Este campo es obligatorio</p>}
                </div>

                <div className={styles.field}>
                    <label>Modelo</label>
                    <input type="text" name="modelo" value={formData.modelo} onChange={handleChange} />
                </div>

                <div className={styles.field}>
                    <label>Chasis<span>*</span></label>
                    <input type="text" name="chasis" value={formData.chasis} onChange={handleChange} />
                    {errors.chasis && <p className={styles.error}>Este campo es obligatorio</p>}
                </div>

                <div className={styles.buttonGroup}>
                    <button type="submit" className={styles.saveButton}>GUARDAR</button>
                    <button type="button" className={styles.cancelButton} onClick={handleCancel}>CANCELAR</button>
                </div>
            </form>
        </div>
    );
};

export default CreateEquipmentView;
