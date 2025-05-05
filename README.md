# Know Your Fan - FURIA

## Descrição

**Know Your Fan - FURIA** é uma aplicação web que permite aos fãs da FURIA Esports criarem perfis personalizados, realizarem login e visualizarem um feed com outros fãs, incluindo nome, rede social e história com a organização.

## Tecnologias

- **Backend**: Java 17, Spring Boot, MongoDB, Docker Compose, Lombok  
- **Frontend**: React, TypeScript, Vite, Tailwind CSS, Axios

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- `api/`: pasta que contém o backend da aplicação (API Spring Boot).  
- Frontend (raiz do projeto): aplicação React com Vite e Tailwind.

## Pré-requisitos

- Docker e Docker Compose  
- Node.js (v18+)  
- Java 17 e Maven  
- Git

## Instalação

### 1. Clone o Repositório

```bash
git clone https://github.com/LucasMoreiraLana/know-your-fan-furia.git
cd know-your-fan-furia
```

### 2. Backend (API)

```bash
cd api
docker-compose up -d        # Sobe o container do MongoDB
mvn clean install
mvn spring-boot:run
```

A API estará disponível em: [http://localhost:8080](http://localhost:8080)

### 3. Frontend

```bash
cd ..   # volte para a raiz do projeto, se necessário
npm install
npm run dev
```

O frontend estará disponível em: [http://localhost:5173](http://localhost:5173)

## Uso

### Login

- Acesse [http://localhost:5173](http://localhost:5173)
- Insira seu e-mail e senha, ou clique em **Cadastrar** para criar uma conta.

### Cadastro

- Preencha os campos: e-mail, senha, nome, rede social e descrição.
- O frontend envia um `POST` para `/create` com os dados:

```json
{
  "email": "exemplo@email.com",
  "password": "sua_senha",
  "name": "Seu Nome",
  "social": "@seu_perfil",
  "description": "Minha história com a Furia..."
}
```

### Dashboard

- Após login (via `POST /login`), será exibido o feed com usuários (via `GET /users`).

## Endpoints da API

### POST /create

Cria um novo usuário.

- **Body**:

```json
{
  "email": "exemplo@email.com",
  "password": "sua_senha",
  "name": "Seu Nome",
  "social": "@seu_perfil",
  "description": "Minha história com a Furia..."
}
```

### POST /login

Autentica o usuário.

- **Body**:

```json
{
  "email": "exemplo@email.com",
  "password": "sua_senha"
}
```

### GET /users

Retorna a lista de usuários.

- **Frontend** (exibição):
```json
[
  {
    "name": "Seu Nome",
    "social": "@seu_perfil",
    "description": "Minha história com a Furia..."
  }
]
```

- **Backend** (para testes):
```json
[
  {
    "id": "123e4567-e89b-12d3-a456-426614174000",
    "name": "Seu Nome",
    "social": "@seu_perfil",
    "description": "Minha história com a Furia..."
  }
]
```

## Licença

Este projeto está licenciado sob a Licença MIT.
