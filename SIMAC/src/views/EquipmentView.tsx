import styles from '../styles/TechnicianView.module.css';
import { FaEdit, FaTrashAlt } from 'react-icons/fa';

const mockEquipment = [
    { Código: "MC-10", Nombre: "Montacarga", Marca: "HELI", Modelo: "CPQY25-RC1", Chasis: "AT13H50133" },
    { Código: "MC-18", Nombre: "Montacarga", Marca: "CATERPILLAR", Modelo: "GP35NM5", Chasis: "AT13H50133" },
    { Código: "MC-10", Nombre: "Montacarga", Marca: "HELI", Modelo: "CPQY25-RC1", Chasis: "AT13H50133" },
    { Código: "MC-18", Nombre: "Montacarga", Marca: "CATERPILLAR", Modelo: "GP35NM5", Chasis: "AT13H50133" },
    { Código: "MC-10", Nombre: "Montacarga", Marca: "HELI", Modelo: "CPQY25-RC1", Chasis: "AT13H50133" },
    { Código: "MC-18", Nombre: "Montacarga", Marca: "CATERPILLAR", Modelo: "GP35NM5", Chasis: "AT13H50133" },
    { Código: "MC-10", Nombre: "Montacarga", Marca: "HELI", Modelo: "CPQY25-RC1", Chasis: "AT13H50133" },
    { Código: "MC-18", Nombre: "Montacarga", Marca: "CATERPILLAR", Modelo: "GP35NM5", Chasis: "AT13H50133" },
];

const EquipmentView = () => {
    return (
        <div className={styles.container}>
            <h2 className={styles.title}>Equipos</h2>
            <div className={styles.actions}>
                <button className={styles.createButton}>Crear Nuevo</button>
            </div>
            <div className={styles.tableWrapper}>
                <table className={styles.table}>
                    <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Marca</th>
                        <th>Modelo</th>
                        <th>Chasis</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
                    </tr>
                    </thead>
                    <tbody>
                    {mockEquipment.map((tech, index) => (
                        <tr key={index}>
                            <td>{tech.Código}</td>
                            <td>{tech.Nombre}</td>
                            <td>{tech.Marca}</td>
                            <td>{tech.Modelo}</td>
                            <td>{tech.Chasis}</td>
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

export default EquipmentView;
