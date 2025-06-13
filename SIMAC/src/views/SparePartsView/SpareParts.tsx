import styles from '../../styles/ListView.module.css';
import { FaEdit, FaTrashAlt } from 'react-icons/fa';
import {useNavigate} from "react-router-dom";
import { useEffect, useState } from 'react';
import axios from 'axios';

interface spareParts {
  id_spare_part: string;
  name_spare_part: string;
  stock_spare_part: string;
}

function SparePartsView () {
    const [spareParts, setSpareParts] = useState<spareParts[]>([]);

    const handleCreateClick = () => {
        navigate('/spareParts/create');
    };

    useEffect(() => {
        axios.get('http://localhost:3002/sparePart/')
            .then(response => {
                console.log('Datos recibidos del backend:', response.data.data);
                setSpareParts(response.data.data);
            })
            .catch(error => {
                console.error('Error fetching areas:', error);
            });
    }, []);

    return (
        <div className={styles.container}>
            <h2 className={styles.title}>REPUESTOS</h2>
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
                        <th>Existencia</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
                    </tr>
                    </thead>
                    <tbody>
                    {spareParts.map((sp) => (
                        <tr key={sp.id_spare_part}>
                            <td>{sp.id_spare_part}</td>
                            <td>{sp.name_spare_part}</td>
                            <td>{sp.stock_spare_part}</td>
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

export default SparePartsView;
