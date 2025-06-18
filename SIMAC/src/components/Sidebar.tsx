import { useNavigate } from 'react-router-dom';
import { useState } from 'react';
import NewOrderModal from '../views/OrderView/NewOrderModal.tsx';
import  { NavLink } from 'react-router-dom';
import styles from '../styles/Sidebar.module.css';

const Sidebar = () => {
    const [showModal, setShowModal] = useState(false);
    const navigate = useNavigate();

    const handleConfirm = (data: any) => {
        navigate('/order/create', { state: data });
    };

    return (
        <aside className={styles.sidebar}>
            <nav>
                <ul className={styles.navList}>
                    <li>
                        <NavLink
                            to="/order/receivedList"
                            className={({ isActive }) =>
                                isActive ? `${styles.link} ${styles.active}` : styles.link
                            }
                        >
                            Órdenes de Trabajo
                        </NavLink>
                    </li>
                    <li>
                        <button
                            className={`${styles.subLink} ${styles.buttonLink}`}
                            onClick={() => setShowModal(true)}
                        >   <img src="/add.png" alt="addNew" className={styles.img} />
                            Nuevo
                        </button>
                    </li>
                    <li>
                        <NavLink
                            to="/horometros"
                            className={({ isActive }) =>
                                isActive ? `${styles.link} ${styles.active}` : styles.link
                            }
                        >
                            Control de Horómetros
                        </NavLink>
                    </li>
                    <li>
                        <NavLink
                            to="/equipos"
                            className={({ isActive }) =>
                                isActive ? `${styles.link} ${styles.active}` : styles.link
                            }
                        >
                            Equipos
                        </NavLink>
                    </li>
                    <li>
                        <NavLink ///////////////////////////////////////////////////////////////////////////////////////////
                            to="/equipment/create"
                            className={({ isActive }) =>
                                isActive ? `${styles.subLink} ${styles.active}` : styles.subLink
                            }
                        >
                            <img src="/add.png" alt="addNew" className={styles.img} />Nuevo
                        </NavLink>
                    </li>
                    <li>
                        <NavLink
                            to="/repuestos"
                            className={({ isActive }) =>
                                isActive ? `${styles.link} ${styles.active}` : styles.link
                            }
                        >
                            Repuestos
                        </NavLink>
                    </li>
                    <li>
                        <NavLink ///////////////////////////////////////////////////////////////////////////////////////////
                            to="/spareParts/create"
                            className={({ isActive }) =>
                                isActive ? `${styles.subLink} ${styles.active}` : styles.subLink
                            }
                        >
                            <img src="/add.png" alt="addNew" className={styles.img} />Nuevo
                        </NavLink>
                    </li>
                    <li>
                        <NavLink
                            to="/areas"
                            className={({ isActive }) =>
                                isActive ? `${styles.link} ${styles.active}` : styles.link
                            }
                        >
                            Áreas
                        </NavLink>
                    </li>
                    <li>
                        <NavLink ///////////////////////////////////////////////////////////////////////////////////////////
                            to="/area/create"
                            className={({ isActive }) =>
                                isActive ? `${styles.subLink} ${styles.active}` : styles.subLink
                            }
                        >
                            <img src="/add.png" alt="addNew" className={styles.img} />Nuevo
                        </NavLink>
                    </li>
                    <li>
                        <NavLink
                            to="/tecnicos"
                            className={({ isActive }) =>
                                isActive ? `${styles.link} ${styles.active}` : styles.link
                            }
                        >
                            Técnicos
                        </NavLink>
                        <li>
                            <NavLink ///////////////////////////////////////////////////////////////////////////////////////////
                                to="/technician/create"
                                className={({ isActive }) =>
                                    isActive ? `${styles.subLink} ${styles.active}` : styles.subLink
                                }
                            >
                                <img src="/add.png" alt="addNew" className={styles.img} />Nuevo
                            </NavLink>
                        </li>
                    </li>
                </ul>
            </nav>

            <NewOrderModal
                isOpen={showModal}
                onClose={() => setShowModal(false)}
                onConfirm={handleConfirm}
            />
        </aside>
    );
};

export default Sidebar;
