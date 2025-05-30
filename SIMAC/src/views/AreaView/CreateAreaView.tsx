import React, { useState } from 'react';
import styles from '../../styles/CreateForm.module.css';
import { useNavigate } from 'react-router-dom';

const CreateAreaView = () => {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        codigo: '',
        area: '',
        responsable: '',
        contacto: '',
    });

    const [errors, setErrors] = useState({
        codigo: false,
        area: false,
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFormData(prev => ({ ...prev, [name]: value }));
    };

    const validate = () => {
        const newErrors = {
            codigo: formData.codigo.trim() === '',
            area: formData.area.trim() === '',
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
        navigate('/areas');
    };

    return (
        <div className={styles.container}>
            <h1 className={styles.title}>CREAR ÁREA</h1>
            <form className={styles.form} onSubmit={handleSubmit}>
                <div className={styles.field}>
                    <label>Código<span>*</span></label>
                    <input type="text" name="codigo" value={formData.codigo} onChange={handleChange} />
                    {errors.codigo && <p className={styles.error}>Este campo es obligatorio</p>}
                </div>

                <div className={styles.field}>
                    <label>Área<span>*</span></label>
                    <input type="text" name="area" value={formData.area} onChange={handleChange} />
                    {errors.area && <p className={styles.error}>Este campo es obligatorio</p>}
                </div>

                <div className={styles.field}>
                    <label>Responsable</label>
                    <input type="text" name="responsable" value={formData.responsable} onChange={handleChange} />
                </div>

                <div className={styles.field}>
                    <label>Contacto</label>
                    <input type="text" name="contacto" value={formData.contacto} onChange={handleChange} />
                </div>

                <div className={styles.buttonGroup}>
                    <button type="submit" className={styles.saveButton}>GUARDAR</button>
                    <button type="button" className={styles.cancelButton} onClick={handleCancel}>CANCELAR</button>
                </div>
            </form>
        </div>
    );
};

export default CreateAreaView;