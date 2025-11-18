# SkillUp – Plataforma de Upskilling/Reskilling 2030+

Este projeto implementa uma API RESTful em Java com Spring Boot para uma plataforma de **Upskilling** e **Reskilling** voltada ao **futuro do trabalho (2030+)**, permitindo que pessoas se cadastrem na plataforma, acessem trilhas de aprendizagem e se inscrevam em trilhas para desenvolver competências essenciais para o mercado emergente.

---

## 1. Integrantes

- **Léo Kenzo Yamanaka Masago – RM: 557768**
- **Luiz Henrique Silva Ferreira – RM: 555235**
- **Eduardo Tomazela do Nascimento – RM: 556807**

---

## 2. Contexto e Conexão com o Futuro do Trabalho

O avanço de tecnologias como **Inteligência Artificial**, automação, análise de dados e ambientes híbridos está remodelando o trabalho global. Muitas funções serão substituídas por automação, enquanto novas surgem exigindo:

- Educação contínua
- Requalificação (reskilling)
- Aperfeiçoamento de competências (upskilling)

A plataforma **SkillUp** foi criada para apoiar essa transição, oferecendo trilhas de aprendizagem alinhadas ao cenário profissional de 2030+.

### **ODS relacionadas ao projeto:**

- **ODS 4** – Educação de Qualidade
- **ODS 8** – Trabalho Decente e Crescimento Econômico
- **ODS 9** – Indústria, Inovação e Infraestrutura
- **ODS 10** – Redução das Desigualdades

As trilhas podem incluir temas como IA aplicada, pensamento crítico, análise de dados, habilidades digitais e soft skills para ambientes remotos/híbridos.

---

## 3. Visão Geral da Solução

### **3.1 Entidades Principais**

- **Usuário** – pessoa que utiliza a plataforma.
- **Trilha** – trilha de aprendizagem focada em competências do futuro.
- **Inscrição** – vínculo usuário ↔ trilha.

### **3.2 Recursos Principais da API**

- ✔ CRUD completo de **Usuários**
- ✔ CRUD completo de **Trilhas**
- ✔ Inscrição de usuários em trilhas
- ✔ Listagem de inscrições

---

## 4. Stack Tecnológica

- **Linguagem:** Java 24
- **Framework:** Spring Boot 3.5.7
- **Módulos Spring Utilizados:**
  - Spring Web
  - Spring Data JPA
  - Spring Security
  - Bean Validation
  - Springdoc OpenAPI (Swagger)
- **Banco de Dados:** Oracle
- **Build:** Maven

---

## 5. Arquitetura em Camadas

A solução segue fielmente a arquitetura recomendada:

### ✔ Controller
Recebe e responde requisições HTTP.

### ✔ Service
Contém regras de negócio e validações.

### ✔ Repository
Gerencia o acesso ao banco via Spring Data JPA.

---

## 6. Configuração do Banco de Dados

### **application.properties (Oracle)**

```properties
spring.datasource.url=jdbc:oracle:thin:@//HOST:PORTA/NOME_SERVICO
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> O Hibernate criará automaticamente as tabelas a partir das entidades JPA.

---

## 7. Como Executar o Projeto

### **Pré-requisitos**

- Java 24
- Maven
- Banco Oracle acessível

### **Passos para execução**

```bash
git clone <URL_DO_REPOSITORIO>
cd <PASTA_PROJETO>
mvn spring-boot:run
```

A API subirá em:

```
http://localhost:8080
```

Classe principal:

```
br.com.skillup.api.SkillUpApplication
```

---

## 8. Segurança das APIs (Spring Security)

A API usa **HTTP Basic**.

### **Credenciais padrão (em memória):**

- **Usuário:** `admin`
- **Senha:** `admin123`

### Exemplo de chamada autenticada (curl):

```bash
curl -u admin:admin123 http://localhost:8080/usuarios
```

Os endpoints do Swagger são públicos:

- `/swagger-ui/**`
- `/v3/api-docs/**`

Todos os outros exigem autenticação.

---

## 9. Endpoints Principais (com exemplos)

---

### 🟦 **Usuários**

#### Criar usuário
```
POST /usuarios
```

```json
{
  "nome": "João da Silva",
  "email": "joao.silva@skillup.com",
  "senha": "123456"
}
```

#### Outros endpoints:

- `GET /usuarios`
- `GET /usuarios/{id}`
- `PUT /usuarios/{id}`
- `DELETE /usuarios/{id}`

---

### 🟩 **Trilhas**

#### Criar trilha
```
POST /trilhas
```

```json
{
  "titulo": "Trilha de IA Aplicada ao Negócio",
  "descricao": "Introdução à IA aplicada ao mundo corporativo.",
  "focusODS": "ODS 4 - Educação de Qualidade",
  "cargaHorariaEstimada": 40,
  "competencias": "Pensamento crítico, IA, ferramentas digitais"
}
```

#### Outros endpoints:

- `GET /trilhas`
- `GET /trilhas/{id}`
- `PUT /trilhas/{id}`
- `DELETE /trilhas/{id}`

---

### 🟧 **Inscrições**

#### Inscrever usuário em uma trilha
```
POST /inscricoes?idUsuario=1&idTrilha=1
```

#### Listar:

- `GET /inscricoes`
- `GET /inscricoes/usuario/{idUsuario}`

---

## 10. Validações e Tratamento de Erros

A aplicação utiliza **Bean Validation**:

- `@NotBlank`
- `@Email`
- `@Size`
- `@NotNull`
- `@Positive`

E inclui exceções tratadas no backend via `@RestControllerAdvice`, retornando:

- `400` – erros de validação
- `404` – recurso não encontrado
- `409` – conflitos
- `500` – falhas inesperadas

---

## 11. Documentação com Swagger

Swagger gerado automaticamente via springdoc-openapi.

### URLs úteis:

- **Swagger UI:**  
  ```
  http://localhost:8080/swagger-ui/index.html
  ```

- **OpenAPI JSON:**  
  ```
  http://localhost:8080/v3/api-docs
  ```

---

## 12. Testes com Postman

Uma collection Postman foi criada contendo todos os métodos da API:

- CRUD de **Usuários**
- CRUD de **Trilhas**
- **Inscrições**
- Endpoints Swagger

A collection usa auth **Basic** com `admin / admin123`.

---

## 13. Conclusão

O **SkillUp** entrega uma solução alinhada ao desafio Global Solution 2025, aplicando tecnologia para apoiar:

- Requalificação profissional
- Educação contínua
- Inclusão digital
- Desenvolvimento de competências do futuro

Com arquitetura organizada, segurança, documentação completa e aderência às ODS, o projeto atende plenamente ao tema **"O Futuro do Trabalho"** e está pronto para apresentação.

