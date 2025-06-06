import React, { useState } from 'react';
import styles from '../../styles/CreateForm.module.css';
import { CustomSelect } from '../../components/CustomSelect';
import { useNavigate } from 'react-router-dom';

const mockAreas = [
    { Código: "BARB", Área: "Molienda de barbotina", Responsable: "Julio Suarez", Contacto: "78945612" },
    { Código: "COM", Área: "Comercialización", Responsable: "Mario Perez", Contacto: "78945612" },
    { Código: "PROD", Área: "Producción", Responsable: "Ramiro Veizaga", Contacto: "78945612" },
    { Código: "ESM", Área: "Molienda de esmaltes", Responsable: "Eduardo Ferrer", Contacto: "78945612" },
    { Código: "EQP", Área: "Renovación de equipos", Responsable: "Pedro Molina", Contacto: "78945612"},
    { Código: "PRD-2", Área: "Producción", Responsable: "Lucio Gomez", Contacto: "78945612" },
    { Código: "COM-EX", Área: "Comercialización", Responsable: "Fernando Sejas", Contacto: "78945612" },
    { Código: "ESM-2", Área: "Molienda de esmaltes", Responsable: "Ivar Mamani", Contacto: "78945612" },
];

const optionsAreas = mockAreas.map(a => ({
    value: a.Código,
    label: `${a.Área} (${a.Código})`,
}));

const CreateTechnicianView = () => {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        codigo: '',
        nombre: '',
        contacto: '',
        area: '',
    });

    const [errors, setErrors] = useState({
        codigo: false,
        nombre: false,
    });

    const handleChange: React.ChangeEventHandler<HTMLInputElement | HTMLSelectElement> = (e) => {
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
        navigate('/tecnicos');
    };

    return (
        <div className={styles.container}>
            <h1 className={styles.title}>CREAR TÉCNICO</h1>
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
                    <label>Contacto</label>
                    <input type="text" name="contacto" value={formData.contacto} onChange={handleChange} />
                </div>

                <div className={styles.field}>
                    <label>Área</label>
                    <CustomSelect
                        options={optionsAreas}
                        value={optionsAreas.find(opt => opt.value === formData.area) || null}
                        onChange={opt => setFormData(prev => ({ ...prev, area: opt!.value }))}
                        placeholder="Seleccione un área"
                    />
                </div>

                <div className={styles.buttonGroup}>
                    <button type="submit" className={styles.saveButton}>GUARDAR</button>
                    <button type="button" className={styles.cancelButton} onClick={handleCancel}>CANCELAR</button>
                </div>
            </form>
        </div>
    );
};

export default CreateTechnicianView;