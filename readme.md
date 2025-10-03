# 🇧🇷 BrasilDevTools: Gerador de dados.

![Java](https://img.shields.io/badge/Java-21-blue?style=for-the-badge&logo=openjdk) ![Spring](https://img.shields.io/badge/Spring_Boot-3.3.x-green?style=for-the-badge&logo=spring) ![Spring WebFlux](https://img.shields.io/badge/Spring_WebFlux-reactive-lightgrey?style=for-the-badge&logo=spring) ![Maven](https://img.shields.io/badge/Maven-3.9+-orange?style=for-the-badge&logo=apachemaven) ![Swagger](https://img.shields.io/badge/SpringDoc_OpenAPI-2.5.x-blue?style=for-the-badge&logo=swagger) ![JUnit](https://img.shields.io/badge/JUnit_5-Testing-red?style=for-the-badge&logo=junit5)

---

## 📑 Visão Geral

BrasilDevTools é um microsserviço RESTful com Java e Spring Boot que centraliza utilitários essenciais para o ecossistema brasileiro.  
Fornece geração, validação e consulta de dados como **CNPJ, Inscrição Estadual, Placas de Veículos**, além de ferramentas gerais como **gerador de senhas seguras**.

O projeto aplica **Clean Code, SOLID** e **Clean Architecture**, priorizando desacoplamento, clareza e testabilidade.

---

## 🏗️ Arquitetura do Sistema

A arquitetura segue camadas claras (**Web, Aplicação, Domínio, Infraestrutura**) com injeção de dependência condicional (`@ConditionalOnExpression`).  
Isso permite alternar dinamicamente entre **APIs reais** e **mocks locais**, facilitando testes e desenvolvimento offline.

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia             | Versão/Tipo | Descrição/Propósito                                               |
|------------------------|-------------|-------------------------------------------------------------------|
| **Java**               | 21          | Linguagem principal da aplicação                                  |
| **Spring Boot**        | 3.3.x       | Framework para microsserviços REST                                |
| **Spring WebFlux**     | -           | WebClient reativo para consumo de APIs externas                   |
| **Maven**              | 3.9+        | Build e gerenciamento de dependências                             |
| **SpringDoc OpenAPI**  | 2.5.x       | Documentação interativa (Swagger UI)                              |
| **JUnit 5 & Mockito**  | -           | Testes unitários                                                  |
| **Código explícito**   | -           | Sem Lombok, priorizando clareza e legibilidade                    |

---

## ⚙️ Como Executar o Projeto Localmente

Siga os passos abaixo para clonar, construir e executar a aplicação em seu ambiente de desenvolvimento.

### 1. Clone o Repositório

Abra seu terminal e execute o comando abaixo para criar uma cópia local do projeto.
```bash
git clone [https://github.com/RoberthFurtadoDev/BrasilDevTools)
```
### 2. Navegue até o Diretório
```bash
cd BrasilDevTools
```
### 3. Execute a Aplicação
Utilize o Maven Wrapper para iniciar o servidor. A primeira execução pode levar alguns minutos para baixar as dependências necessárias.

### No Linux ou macOS:
```bash
./mvnw spring-boot:run
```
### No Windows:
```bash
.\mvnw spring-boot:run
```
#### Após a inicialização ser concluída, a API estará disponível para uso em http://localhost:8080.

---

### 🚀 Endpoints da API
Aqui estão os principais endpoints disponíveis. Você pode testá-los com ferramentas como cURL, Postman ou diretamente no seu navegador.

#### 📍 CNPJ
- Gerar um CNPJ válido e aleatório:
```bash
  curl -X GET http://localhost:8080/api/cnpj/random
 ``` 
- Consultar dados de um CNPJ específico:
```bash
curl -X GET http://localhost:8080/api/cnpj/06990590000123
``` 
### 📍 Veículo
- Consultar dados de um veículo pela placa:
```bash
curl -X GET http://localhost:8080/api/veiculo/EPH000
``` 
### 📍 Inscrição Estadual (IE)
- Gerar uma Inscrição Estadual válida para uma UF:
```bash
curl -X GET "http://localhost:8080/api/inscricao-estadual/random?uf=SP"
``` 
### 📍 Senha
- Gerar uma senha segura e customizável:
```bash
curl -X GET "http://localhost:8080/api/password/generate?length=16&symbols=true"
``` 
### 🔬 Exemplos de Resposta (DTOs)
#### Veja abaixo exemplos dos DTOs (Data Transfer Objects) retornados pela API.
- 🚗 Resposta da Consulta de Veículo
```json
  {
  "preco": "R$ 68.953,00",
  "marca": "Toyota",
  "modelo": "COROLLA XEI 2.0 Flex 16V Aut.",
  "cor": "Prata",
  "ano": "2014",
  "cidade": "SAO PAULO",
  "uf": "SP",
  "placa": "EPH1E52",
  "situacao": "Sem restrição",
  "codigoFipe": "002111-3"
  }
```
- 🏢 Resposta da Consulta de CNPJ
```json
{
  "nome": "NU PAGAMENTOS S.A. - INSTITUICAO DE PAGAMENTO",
  "fantasia": "NUBANK",
  "cnpj": "06990590000123",
  "municipio": "SAO PAULO",
  "uf": "SP",
  "status": "ATIVA",
  "atividadePrincipal": "Outras atividades de serviços prestados principalmente às empresas não especificadas anteriormente"
}
```

---

### ✅ Roadmap (Próximos Passos)
- Este projeto está em constante evolução. Aqui estão os próximos recursos e melhorias planejadas:

- [ ] Inscrição Estadual: Implementar a geração para todos os 27 estados.

- [ ] Novos Endpoints: Adicionar funcionalidades para CPF e CEP.

- [ ] Segurança: Implementar autenticação via API Key ou JWT.

- [ ] Infraestrutura: Containerizar a aplicação com Docker.

- [ ] Qualidade: Adicionar uma suíte de testes de integração.

- [ ] Performance: Implementar cache com Caffeine ou Redis.

#### Documentação: **http://localhost:8080/swagger-ui/index.html**

✍️ Autores: Roberth Furtado & Max Jennyfer. 











