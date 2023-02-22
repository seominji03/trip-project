import React from 'react';
import { Link } from 'react-router-dom';

function Home() {
  return (
    <div>
      <h1>Home Pages</h1>
      <Link to="/Login">
        <p>Login</p>
      </Link>
      <Link to="/Register">
        <p>Register</p>
      </Link>
    </div>
  );
}

export default Home;
