Sistema para gestão de Revendas de veículos.

Configurações do projeto:
- Spring boot 3.2.3 (Maven)
- Java 17
- Spring Data JPA
- Spring Security
- H2 Database
- Lombok
- Validation
- MapStructure( Mapper)
- ADICIONAR O SWAGGER para documentar.

NECESSÁRIO INSTALAÇÃO DO LOMBOK

INSERÇÃO DE INFORMAÇÕES INICIAIS NO APPLICATIONRUN

login padrão: user e senha gerada

Introdução:
 O projeto consiste na gestão de revenda de veículos utilizando o ecossistema Spring (Spring Boot e Spring Security) 
além de dependências utilitárias como Lombok e Validation. Tem como objetivo fazer o controle de revendas a partir de acesso
de usuários autorizados assim como também a manutenção dos mesmos e seus respectivos perfis e gestão de oportunidades de acordo com
usuário da revenda.

CONFIGURAR O SECURITYCONFIGURATION  - EM ANDAMENTO.

VARIAVEIS DE AMBIENTE:
DB_URL
DB_USER
DB_PASS


- AS TABELAS PERFIL, STATUS, CLIENTES E VEÍCULOS SÃO SOMENTE PARA CONSULTA DAS INFORMAÇÕES.
- O CADASTRO DO CLIENTE E DO VEICULO DA OPORTUNIDADES SÃO FEITAS EM TABELAS SEPARADAS POREM NO MESMO JSON DAS OPORTUNIDADES

DETALHAR PACOTES NA DESCRIÇÃO

- PONTOS DE MELHORIA: ADICIONAR CRIPTOGRAFIA DE SENHA
- PAGINAÇÃO EM OUTRAS TABELA ( SOMENTE EM UMA (REVENDA) PARA EXEMPLIFICAÇÃO DE FUNCIONAMENTO)
- SEPARAÇÃO DE MICROSERVIÇOS PARA CADA ENTIDADE
