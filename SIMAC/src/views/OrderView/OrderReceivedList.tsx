import styles from '../../styles/ListView.module.css';
import { FaEdit, FaTrashAlt } from 'react-icons/fa';
import {useNavigate} from "react-router-dom";

const mockTechnicians = [
    { Equipo: 'Montacarga MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Equipo: 'Montacarga MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Equipo: 'Montacarga MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Equipo: 'Montacarga MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Equipo: 'Montacarga MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Equipo: 'Montacarga MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Equipo: 'Montacarga MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Equipo: 'Montacarga MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Equipo: 'Montacarga MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Equipo: 'Montacarga MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
];

const TechnicianView = () => {
    const navigate = useNavigate();

    const handleCreateClick = () => {
        navigate('/technician/create');
    };

    return (
        <div className={styles.container}>
            <h2 className={styles.title}>ÓRDENES RECIBIDAS</h2>
            <div className={styles.actions}>
                <button className={styles.createButton} onClick={handleCreateClick}>
                    Crear Nuevo
                </button>
            </div>
            <div className={styles.tableWrapper}>
                <table className={styles.table}>
                    <thead>
                    <tr>
                        <th>Equipo</th>
                        <th>Fecha entrega</th>
                        <th>Clase Mantenimiento</th>
                        <th>Tipo Mantenimiento</th>
                        <th>Prioridad</th>
                        <th>Ver mas</th>
                        <th>Ejecutar orden</th>
                    </tr>
                    </thead>
                    <tbody>
                    {mockTechnicians.map((tech, index) => (
                        <tr key={index}>
                            <td>{tech.Equipo}</td>
                            <td>{tech.FechaEntrega}</td>
                            <td>{tech.ClaseMant}</td>
                            <td>{tech.TipoMant}</td>
                            <td>{tech.Prioridad}</td>
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
