Sistema para gestão de Revendas de veículos.

Configurações do projeto e depêndencias:

Spring boot 3.2.3 (Maven)

Java 17

Spring Data JPA

Spring Security

H2 Database (Banco de dados local)

Lombok (Anotações para facilitação de Getters/Setters e afins. Auxilia na diminuição e repetição de código)

Validation (Validações de Bean)

MapStructure( Mapper). Mapeamento de conversão de classes de forma rápida e pratica.

GSON ( Conversão de JSONs para Classes)

JWT (com.auth0) Depêndencia para utilização de tokens na aplicação.

IMPORTANTE: Para execução da aplicaçã localmente é necessário a instalação do lombok em sua IDE *A Collection com as chamadas REST para testes está no repositório *

Introdução: O projeto consiste na gestão de revenda de veículos utilizando o ecossistema Spring (Spring Boot e Spring Security) além de dependências utilitárias como Lombok e Validation. Tem como objetivo fazer o controle de revendas a partir de acesso de usuários autorizados assim como também a manutenção dos mesmos e seus respectivos perfis e gestão de oportunidades de acordo com usuário da revenda.

Variaveis de ambiente para teste local: DB_PASS=sa DB_URL=jdbc:h2:mem:testdb DB_USER=sa JWT_SECRET=12345

O cadastro de clientes e veículos são feitos a partir da criação de uma oportunidade, porém as 3 entidades são tratadas de formas separadas

Se tratando de um mundo real a utlização de tabelas para Status e Perfis se adequa melhor do que somente utilizaçãod de ENUMS
PONTOS DE MELHORIA FUTURA PARA APLICAÇÃO:

Paginação em todas as buscas listadas. Atualmente só há na de Revenda para demonstração de funcionamento.

Testes unitários.

Separação dos microserviços por entidade. Single Responsability.

Refatoração de códigos duplicados e encapsulamento de métodos.

PONTOS DE MELHORIA: ADICIONAR CRIPTOGRAFIA DE SENHA

PAGINAÇÃO EM OUTRAS TABELA ( SOMENTE EM UMA (REVENDA) PARA EXEMPLIFICAÇÃO DE FUNCIONAMENTO)

SEPARAÇÃO DE MICROSERVIÇOS PARA CADA ENTIDADE