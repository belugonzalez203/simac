import styles from '../../styles/ListView.module.css';
import { FaEdit, FaTrashAlt } from 'react-icons/fa';
import {useNavigate} from "react-router-dom";
import { useEffect, useState } from 'react';
import axios from 'axios';

interface Area {
  id_area: string;
  name_area: string;
  in_charge: string;
  contact_number_area: string;
}

function AreaView () {
    const navigate = useNavigate();

    const handleCreateClick = () => {
        navigate('/area/create');
    };

    const [areas, setAreas] = useState<Area[]>([]);

    useEffect(() => {
        axios.get('http://localhost:3002/area/')
            .then(response => {
                console.log('Datos recibidos del backend:', response.data.data);
                setAreas(response.data.data);
            })
            .catch(error => {
                console.error('Error fetching areas:', error);
            });
    }, []);

    return (
        <div className={styles.container}>
            <h2 className={styles.title}>ÁREAS</h2>
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
                        <th>Área</th>
                        <th>Responsable</th>
                        <th>Contacto</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
                    </tr>
                    </thead>
                    <tbody>
                    {areas.map((area) => (
                        <tr key={area.id_area}>
                            <td>{area.id_area}</td>
                            <td>{area.name_area}</td>
                            <td>{area.in_charge}</td>
                            <td>{area.contact_number_area}</td>
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

export default AreaView;
