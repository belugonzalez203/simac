import  { Link } from 'react-router-dom';
import styles from '../styles/Sidebar.module.css';

const Sidebar = () => {
    return (
        <aside className={styles.sidebar}>
            <h2 className={styles.title}></h2>
            <nav className={styles.nav}>
                <ul className={styles.nav}>
                    <li className={styles.nav}><Link to="/ordenes">Órdenes de Trabajo</Link></li>
                    <li><Link to="/equipos">Equipos</Link></li>
                    <li><Link to="/horometros">Control de Horómetros</Link></li>
                    <li><Link to="/areas">Áreas</Link></li>
                    <li><Link to="/tecnicos">Técnicos</Link></li>
                </ul>
            </nav>
        </aside>
    );
};

export default Sidebar;
