import axios from 'axios';

// Configuração da instância do Axios
const api = axios.create({
  baseURL: 'http://localhost:8080/v1',
  headers: {
    'Content-Type': 'application/json',
  },
});

// Tipagem para as credenciais de login
export interface LoginCredentials {
  email: string;
  password: string;
}

// Tipagem para a resposta da API
export interface LoginResponse {
  status: number;
  message: string;
}

// Função para fazer a requisição de login
export const login = async (
  credentials: LoginCredentials
): Promise<LoginResponse> => {
  try {
    console.log('Requisição para a API:', credentials); // Depuração
    const response = await api.post<LoginResponse>('/login', credentials);
    console.log('Resposta bruta da API:', response.data); // Depuração
    return response.data;
  } catch (error: unknown) {
    if (
      axios.isAxiosError(error) &&
      error.response &&
      typeof error.response.data?.message === 'string'
    ) {
      console.log('Erro capturado da API:', error.response.data); // Depuração
      throw new Error(error.response.data.message);
    }
    console.log('Erro desconhecido:', error); // Depuração
    throw new Error('Erro desconhecido ao conectar com o servidor');
  }
};
