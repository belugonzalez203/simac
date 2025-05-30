//import React from "react";
import styles from '../styles/Navbar.module.css';

interface NavbarProps {
    username: string;
}

export const Navbar = ({ username }: NavbarProps) => {
    return (
        <header className={styles.navbar}>
            <div className={styles.marca}>
                <img src="/LogoCoboce.png" alt="Coboce Ltda." className={styles.logo} />
                <h2>SIMAC</h2>
            </div>
            <div>
                <div className={styles.userInfo}>
                    <span>{username}</span>
                    <img src="/user.png" alt="Usuario" className={styles.avatar} />
                </div>
            </div>
        </header>
    );
};
