import  { NavLink } from 'react-router-dom';
import styles from '../styles/Sidebar.module.css';

const Sidebar = () => {
    return (
        <aside className={styles.sidebar}>
            <nav>
                <ul className={styles.navList}>
                    <li>
                        <NavLink
                            to="/ordenes"
                            className={({ isActive }) =>
                                isActive ? `${styles.link} ${styles.active}` : styles.link
                            }
                        >
                            Órdenes de Trabajo
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
                            to="/areas"
                            className={({ isActive }) =>
                                isActive ? `${styles.link} ${styles.active}` : styles.link
                            }
                        >
                            Áreas
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
                    </li>
                </ul>
            </nav>
        </aside>
    );
};

export default Sidebar;
