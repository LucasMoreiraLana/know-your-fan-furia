import { useMutation, UseMutationResult } from '@tanstack/react-query';
import { useNavigate } from 'react-router-dom';
import { login, LoginResponse } from '../services/api';

// Interface para os dados de login
interface LoginData {
  email: string;
  password: string;
}

// Tipagem para as opções do hook
interface UseLoginDataOptions {
  onSuccess?: (data: LoginResponse) => void;
  onError?: (error: Error) => void;
}

export function useLoginData(options: UseLoginDataOptions = {}): UseMutationResult<LoginResponse, Error, LoginData> {
  const navigate = useNavigate();

  return useMutation({
    mutationFn: (loginData: LoginData) => {
      // Padronizar email para lowercase e remover espaços extras
      const normalizedData = {
        email: loginData.email.trim().toLowerCase(),
        password: loginData.password.trim(),
      };
      console.log('Enviando para a API:', normalizedData); // Depuração
      return login(normalizedData);
    },
    onSuccess: (data: LoginResponse) => {
      console.log('Resposta da API:', data); // Depuração
      if (data.status === 200) {
        localStorage.setItem('isAuthenticated', 'true');
        navigate('/dashboard');
      } else {
        console.error('Erro inesperado:', data.message);
      }
      options.onSuccess?.(data);
    },
    onError: (error: Error) => {
      console.log('Erro da API:', error.message); // Depuração
      options.onError?.(error);
    },
  });
}