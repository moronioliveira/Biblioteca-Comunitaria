# 📚 Biblioteca Comunitária API

API REST desenvolvida para a gestão de uma biblioteca comunitária, permitindo o cadastro de usuários e o gerenciamento de acervos e empréstimos. Este projeto faz parte do meu portfólio de estudos avançados em **Java** e **Spring Boot**.

---

## 🛠️ Tecnologias Utilizadas

* **Java 21**: Utilizando as últimas features da linguagem.
* **Spring Boot 3**: Framework base para a construção da API.
* **Spring Data JPA**: Para persistência de dados e abstração de consultas.
* **H2 Database**: Banco de dados em memória para testes e agilidade no desenvolvimento.
* **Lombok**: Para redução de código boilerplate (Getters, Setters, Constructors).

---

## 🏗️ Arquitetura e Boas Práticas

O projeto foi estruturado seguindo princípios de **Clean Arch** e separação de responsabilidades, garantindo um código manutenível e escalável:

* **Camada de Infrastructure**: Contendo as entidades de banco de dados e as interfaces de repositório.
* **Camada de Service**: Onde reside a inteligência do negócio, seguindo o protocolo de 6 passos (Entrada, Existência, Regra de Negócio, Mudança, Salvar e Retorno).
* **Camada de Controller**: Exposição dos endpoints REST para comunicação externa.
* **DTO Pattern**: Uso de Data Transfer Objects para segurança e desacoplamento das entidades de banco de dados.



---

## 🚀 Como Executar o Projeto

1. Certifique-se de ter o **JDK 21** instalado.
2. Clone o repositório:
   ```bash
   git clone [https://github.com/moronioliveira/Biblioteca-Comunitaria.git](https://github.com/moronioliveira/Biblioteca-Comunitaria.git)