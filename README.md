# Desafio Técnico - RGC

Este projeto consiste em uma API desenvolvida em Java com Spring Boot, criada como parte do desafio técnico para a RGC Consultoria.  
O objetivo da aplicação é disponibilizar endpoints para consulta de dados de aeroportos em um serviço externo.

---

## Tecnologias Utilizadas

- Java 21  
- Spring Boot 3.3.5  
- Maven  
- JUnit 5  
- Mockito  

---

## Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

- Java 21  
- Maven 3+  
- Uma IDE de sua preferência (IntelliJ, Eclipse, VS Code, etc.)

---

## Instalação e Execução

### Instalação do Java (Ubuntu/Debian)

```bash
sudo apt update
sudo apt install openjdk-21-jdk
```

### Instalação do Maven

```bash
sudo apt install maven
```

### Clone do Repositório

```bash
git clone https://github.com/otaviovoltarelli/desafio-jr-rgc.git
cd rgc
```

### Instalar dependências

```bash
mvn clean install
```

### Executar a aplicação

```bash
mvn spring-boot:run
```

A API estará disponível em:  
**http://localhost:8080**

---
## Endpoints

```bash
GET /api/aeroportos/{codigoIcao}
```

Exemplos de código Icao: KATL, KAVL, KLAX, KSFO

---
## Executando os Testes

O projeto utiliza **JUnit 5** e **Mockito** para testes de integração.

Para executar os testes, utilize:

```bash
mvn test
```

---

## Decisões Técnicas

### Arquitetura em Camadas

A aplicação foi estruturada seguindo o padrão de **arquitetura em camadas**, visando organização, manutenção e separação de responsabilidades:

- **Controller**  
  Responsável por receber as requisições HTTP e expor os endpoints da API.

- **Service**  
  Contém a lógica de negócio da aplicação.

- **Client**  
  Responsável pela comunicação com APIs externas.

- **Model**  
  Representa as entidades e estruturas de dados utilizadas na aplicação.

- **Exceptions**  
  Centraliza o tratamento de erros da aplicação.

### Tratamento de Erros

Para o tratamento de exceções, foi utilizado o `@RestControllerAdvice`, permitindo a padronização das respostas de erro.

Foram criadas exceções específicas, como:

- **AeroportoNaoEncontradoException**  
  Utilizada quando um recurso não é encontrado (HTTP 404).

- **ApiExternaIndisponivelException**  
  Utilizada para falhas de comunicação com serviços externos (HTTP 502).


