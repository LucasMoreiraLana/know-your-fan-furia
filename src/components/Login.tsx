import { useState, ChangeEvent, FormEvent } from 'react';
import { useLoginData } from '../hook/useLoginData';
import { Link, useNavigate } from 'react-router-dom';

interface Credentials {
  email: string;
  password: string;
}

const Login = () => {
  const [credentials, setCredentials] = useState<Credentials>({
    email: '',
    password: '',
  });
  const [error, setError] = useState<string>('');
  const navigate = useNavigate();
  const { mutate, isPending } = useLoginData({
    onSuccess: (data) => {
      console.log('Resposta da API:', data);
      if (data.status === 200) {
        localStorage.setItem('isAuthenticated', 'true');
        setError('');
        navigate('/dashboard');
      } else {
        setError(data.message || 'Erro inesperado');
      }
    },
    onError: (err: Error) => {
      console.log('Erro da API:', err.message);
      setError(err.message || 'Erro ao fazer login');
    },
  });

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    setCredentials({
      ...credentials,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    console.log('Enviando credenciais:', credentials);
    setError('');
    mutate(credentials);
  };

  return (
    <div style={styles.container}>
      <img src="/logo-furia.svg" alt="Logo" style={styles.logo} />
      <h2>Login</h2>
      <form onSubmit={handleSubmit} style={styles.form}>
        <div style={styles.inputGroup}>
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            name="email"
            value={credentials.email}
            onChange={handleChange}
            required
            style={styles.input}
          />
        </div>
        <div style={styles.inputGroup}>
          <label htmlFor="password">Senha:</label>
          <input
            type="password"
            id="password"
            name="password"
            value={credentials.password}
            onChange={handleChange}
            required
            style={styles.input}
          />
          <Link to="/register" style={{ color: '#4a90e2', fontSize: '14px', marginTop: '10px', display: 'inline-block' }}>
            Não tem uma conta? Cadastre-se
          </Link>
        </div>
        {error && <p style={styles.error}>{error}</p>}
        <button
          type="submit"
          disabled={isPending}
          style={styles.button}
        >
          {isPending ? 'Entrando...' : 'Entrar'}
        </button>
      </form>
    </div>
  );
};

const styles: { [key: string]: React.CSSProperties } = {
  container: {
    fontFamily: '"Segoe UI", Tahoma, Geneva, Verdana, sans-serif',
    maxWidth: 450,
    margin: '100px auto',
    padding: 30,
    backgroundColor: '#ffffff',
    border: '2px solid #4a90e2',
    borderRadius: 10,
    boxShadow: '0 6px 12px rgba(0, 0, 0, 0.1)',
    textAlign: 'center' as const,
  },
  logo: {
    width: 120,
    height: 120,
    borderRadius: 20,
    boxShadow: '0 4px 8px rgba(0, 0, 0, 0.2)',
    margin: '0 auto 30px',
    display: 'block' as const,
  },
  form: {
    display: 'flex',
    flexDirection: 'column' as const,
    gap: 20,
  },
  inputGroup: {
    display: 'flex',
    flexDirection: 'column' as const,
    textAlign: 'left' as const,
  },
  input: {
    padding: 12,
    fontSize: 16,
    borderRadius: 6,
    border: '1px solid #4a90e2',
    backgroundColor: '#f9f9f9',
    transition: 'border-color 0.3s',
  },
  button: {
    padding: 12,
    backgroundColor: '#4a90e2',
    color: '#fff',
    border: 'none',
    borderRadius: 6,
    cursor: 'pointer' as const,
    fontSize: 16,
    fontWeight: 'bold' as const,
    transition: 'background-color 0.3s',
  },
  error: {
    color: '#e74c3c',
    fontSize: 14,
    marginTop: 10,
  },
};

export default Login;