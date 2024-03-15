import React from 'react';
import { Link } from 'react-router-dom';
import '../Styles/Button.css';

const STYLES = ['btn-primary', 'btn-outline', 'btn-secondary','btn-info'];

const SIZES = ['btn-medium', 'btn-large'];

export const Button = ({ children, type, onClick, buttonStyle, buttonSize, setPage }) => {

    const checkButtonStyle = STYLES.includes(buttonStyle) ? buttonStyle : STYLES[0];

    const checkButtonSize = SIZES.includes(buttonSize) ? buttonSize : SIZES[0];

    console.log("sdvbvsdv " + setPage);
    return (

        <Link to={setPage} className='btn-mobile'>
            <button
                className={`btn ${checkButtonStyle} ${checkButtonSize} mx-1`}
                onClick={onClick}
                type={type}
            >
                {children}
            </button>
        </Link>
    )
};