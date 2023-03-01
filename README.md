# bibliotecaSist

No atual repositório está a minha resposta para o teste técnico que me foi enviado. 

## Informações
- Cargo: Analista de Desenvolvimento de Sistemas 
- Senioridade: Júnior
- Linguagem: Java/Typescript 

## Justificativas

- Frameworks: 
  - FrontEnd: Angular, escolhido por já ter tido alguma prática com o mesmo anteriormente. Onde usei Angular-Material para 
  gerar  as informações e validações no front. 
  - BackEnd: Java Spring Boot, também já tinha usado para fazer um pequeno projeto de crud. 
  
## Objetivos e Dificuldades encontradas  
- **Objetivos**: desenvolver um sistema para gerenciamento de uma biblioteca.
  - Contando com 2 perfis, um de ADMIN que pode realizar  todo o crud de livros e os perfis de usuário, os quais poderiam consultar 
    todos os livros presentes  no sistema, cadastrar novos e expluir apenas o que cadastrou. 
  - Conter uma tela de Login. 
  - Conter opções de cadastro, esqueci minha senha e recuperação de acesso. 
  - CRUD de todos os  dados pelo  ADMIN.
  - Operações citadas anteriormente para o usuário. 

- **Dificuldades**: 
  - Aplicar o Spring Security para gerir os privilégios/Sessão de cada grau de usuário, nunca tinha tentado utilizar então acabei 
  não conseguindo adicionalo a aplicação.
  - Como não tinha as sessões definidas o front referente ao usuário não se foi finalizado, deixando apenas o para o ADMIN.
  - Foi implementada a tela de cadastro de novos usuários, porém não consegui implementar a recuperação.
  - Definição de relações entre livros e usuários. 
  - Deveria ter usado DTOS.
  
### Configuração e execução do projeto: 

Atualmente a base de dados e se encontra instalada em docker, então basta usar:  
  ```sh
    docker-compose up 
  ```
Antes de executar o projeto, assim estará disponível a base de dados já com as suas configurações especificadas no compose e no application.properties. 
O código foi desenvolvido usando o Java 11 e spring, infelizmente não consegui adiciona-lo ao Docker também, mas é facilmente  executável usando o Intellij. 

Com o uso da IDE Intellij é posível configurar os dados para a base, usando o menu lateral "Database".
Basta configurar a autenticação para  User e Password e usar os dados incluídos na application.properties. 
```json
 {
  "User": "dbuser",
  "Password": "P@ssw0rd!",
  "Url": "jdbc:mysql://localhost:3306/bibliotecadb"
 }
```

