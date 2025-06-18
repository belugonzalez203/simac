import styles from '../../styles/ListView.module.css';
import { FaEdit, FaTrashAlt } from 'react-icons/fa';
import {useNavigate} from "react-router-dom";
import { useEffect, useState } from 'react';
import axios from 'axios';

interface Equipment {
  id_equip: number;
  code_equip: string;
  name_equip: string;
  brand_equip: string;
  model_equip: string;
  chassis_equip: string;
  name_area: string;
}
  
function EquipmentListView() {
    const [equipments, setEquipments] = useState<Equipment[]>([]);

    useEffect(() => {
        axios.get('http://localhost:3002/equipment/')
            .then(response => {
                console.log('Datos recibidos del backend:', response.data.data);
                setEquipments(response.data.data);
            })
            .catch(error => {
                console.error('Error fetching areas:', error);
            });
    }, []);

    const navigate = useNavigate();

    const handleCreateClick = () => {
        navigate('/equipment/create');
    };

    return (
        <div className={styles.container}>
            <h2 className={styles.title}>EQUIPOS</h2>
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
                        <th>Marca</th>
                        <th>Modelo</th>
                        <th>Chasis</th>
                        <th>Área</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
                    </tr>
                    </thead>
                    <tbody>
                    {equipments.map((equip) => (
                        <tr key={equip.id_equip}>
                            <td>{equip.code_equip}</td>
                            <td>{equip.name_equip}</td>
                            <td>{equip.brand_equip}</td>
                            <td>{equip.model_equip}</td>
                            <td>{equip.chassis_equip}</td>
                            <td>{equip.name_area}</td>
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

export default EquipmentListView;