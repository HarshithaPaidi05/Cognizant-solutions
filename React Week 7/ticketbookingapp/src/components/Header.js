import React from 'react';
import './Header.css';

export default function Header({ isLoggedIn, onLogin, onLogout }) {
  return (
    <header className="header">
      <h1>Ticket Booking App</h1>
      <div className="auth-controls">
        {isLoggedIn ? (
          <>
            <span className="welcome">Logged in as <strong>user@example.com</strong></span>
            <button onClick={onLogout} className="btn btn-logout">Logout</button>
          </>
        ) : (
          <>
            <span className="welcome">You are browsing as Guest</span>
            <button onClick={onLogin} className="btn btn-login">Login</button>
          </>
        )}
      </div>
    </header>
  );
}
