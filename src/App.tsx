import { Routes, Route } from 'react-router-dom';
import Login from './components/Login';

const App = () => (
  <Routes>
    <Route path="/" element={<Login />} />
    <Route path="/dashboard" element={<div>Usuário logado!</div>} />
  </Routes>
);

export default App;