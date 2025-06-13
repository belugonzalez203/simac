import styles from '../../styles/ListView.module.css';
import {useNavigate} from "react-router-dom";

const mockTechnicians = [
    { Orden: '1750', Equipo: 'MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Orden: '1750', Equipo: 'MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Orden: '1750', Equipo: 'MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Orden: '1750', Equipo: 'MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Orden: '1750', Equipo: 'MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Orden: '1750', Equipo: 'MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Orden: '1750', Equipo: 'MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Orden: '1750', Equipo: 'MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Orden: '1750', Equipo: 'MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
    { Orden: '1750', Equipo: 'MC-19', FechaEntrega: '15/06/2025', ClaseMant: 'Correctivo', TipoMant: 'Mecanico', Prioridad: 'Alta' },
];

const OrderReceivedList = () => {
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
                        <th>Orden</th>
                        <th>Equipo</th>
                        <th>Entrega</th>
                        <th>Clase Mant</th>
                        <th>Tipo Mant</th>
                        <th>Prioridad</th>
                        <th>Ver mas</th>
                        <th>Ejecutar</th>
                    </tr>
                    </thead>
                    <tbody>
                    {mockTechnicians.map((tech, index) => (
                        <tr key={index}>
                            <td>{tech.Orden}</td>
                            <td>{tech.Equipo}</td>
                            <td>{tech.FechaEntrega}</td>
                            <td>{tech.ClaseMant}</td>
                            <td>{tech.TipoMant}</td>
                            <td>{tech.Prioridad}</td>
                            <td className={styles.iconCell}>
                                <button
                                    className={`${styles.subLink} ${styles.buttonLink}`}
                                    onClick={() => navigate(`/workorder/${index}`)} // ejemplo para ver más
                                >
                                    <img src="/seeMore.png" alt="seeMore" className={styles.img} />
                                </button>
                            </td>
                            <td className={styles.iconCell}>
                                <button
                                    className={styles.buttonLink}
                                    onClick={() => navigate(`/workorder/${index}/execute`)} // ejemplo para ejecutar orden
                                >
                                    <img src="/notes.png" alt="executeOrder" className={styles.img} />
                                </button>
                            </td>

                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default OrderReceivedList;
