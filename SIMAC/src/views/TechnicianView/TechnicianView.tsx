import styles from '../../styles/ListView.module.css';
import { FaEdit, FaTrashAlt } from 'react-icons/fa';
import {useNavigate} from "react-router-dom";

const mockTechnicians = [
    { Código: 1, Nombre: 'Walter Veizaga', Contacto: '74185236', Área: 'Molienda de esmaltes' },
    { Código: 2, Nombre: 'Damian Flores', Contacto: '74185236', Área: 'Molienda de esmaltes' },
    { Código: 3, Nombre: 'Pedro Jimenez', Contacto: '74185236', Área: 'Producción' },
    { Código: 4, Nombre: 'Walter Veizaga', Contacto: '74185236', Área: 'Producción' },
    { Código: 5, Nombre: 'Pedro Jimenez', Contacto: '74185236', Área: 'Seguridad industrial' },
    { Código: 6, Nombre: 'Damian Flores', Contacto: '74185236', Área: 'Equipos' },
    { Código: 7, Nombre: 'Pedro Jimenez', Contacto: '74185236', Área: 'Barbotina' },
    { Código: 8, Nombre: 'Pedro Jimenez', Contacto: '74185236', Área: 'Barbotina' },
    { Código: 9, Nombre: 'Pedro Jimenez', Contacto: '74185236', Área: 'Comercialización' },
    { Código: 10, Nombre: 'Walter Veizaga', Contacto: '74185236', Área: 'Comercialización' },
];

const TechnicianView = () => {
    const navigate = useNavigate();

    const handleCreateClick = () => {
        navigate('/technician/create');
    };

    return (
        <div className={styles.container}>
            <h2 className={styles.title}>TÉCNICOS</h2>
            <div className={styles.actions}>
                <button className={styles.createButton} onClick={handleCreateClick}>
                    Crear Nuevo
                </button>
            </div>
            <div className={styles.tableWrapper}>
                <table className={styles.table}>
                    <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Contacto</th>
                        <th>Área</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
                    </tr>
                    </thead>
                    <tbody>
                    {mockTechnicians.map((tech, index) => (
                        <tr key={index}>
                            <td>{tech.Código}</td>
                            <td>{tech.Nombre}</td>
                            <td>{tech.Contacto}</td>
                            <td>{tech.Área}</td>
                            <td className={styles.iconCell}>
                                <FaEdit className={styles.editIcon} />
                            </td>
                            <td className={styles.iconCell}>
                                <FaTrashAlt className={styles.deleteIcon} />
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default TechnicianView;
