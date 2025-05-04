Know Your Fan - Furia
API e frontend para fãs da Furia criarem perfis, fazerem login e visualizarem um feed de usuários com nome, rede social e história com a organização. Usa Spring Boot com MongoDB no backend e React com TypeScript, Vite e Tailwind CSS no frontend.
Tecnologias

Backend: Java 17, Spring Boot, MongoDB, Docker Compose, Lombok
Frontend: React, TypeScript, Vite, Tailwind CSS, Axios

Pré-requisitos

Docker e Docker Compose
Node.js (v18+)
Java 17, Maven
Git

Instalação

Clone o repositório:
git clone https://github.com/LucasMoreiraLana/know-your-fan-furia.git
cd know-your-fan-furia

Backend:
cd api
docker-compose up -d
mvn clean install
mvn spring-boot:run

API em http://localhost:8080.

Frontend:
npm install
npm run dev

Frontend em http://localhost:5173.

Uso

Login: Acesse http://localhost:5173, insira email e senha ou clique em "Cadastrar".
Cadastro: Preencha email, senha, nome, rede social e descrição. Envia POST a /create.
Dashboard: Após login (POST /login), veja o feed de usuários (GET /users).

Endpoints

POST /create: Cria usuário. Body: { "email", "password", "name", "social", "description" }. Gera um id (UUID como string).{
"email": "exemplo@email.com",
"password": "sua_senha",
"name": "Seu Nome",
"social": "@seu_perfil",
"description": "Minha história com a Furia..."
}

POST /login: Autentica usuário. Body: { "email", "password" }.{
"email": "exemplo@email.com",
"password": "sua_senha"
}

GET /users: Lista usuários. No frontend, retorna name, social, description. No backend (para testes), inclui id (UUID como string).[
{
"id": "123e4567-e89b-12d3-a456-426614174000", // Apenas no backend
"name": "Seu Nome",
"social": "@seu_perfil",
"description": "Minha história com a Furia..."
},
...
]

Licença
MIT
