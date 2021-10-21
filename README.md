# PandemicCombatAidSystem
Quando o mundo é atingido por uma pandemia sem remédio imediato, além das habilidades dos profissionais de saúde, é preciso ter um bom sistema de informações para ajudar nas tomadas de decisões, visando amenizar ao máximo seus impactos. Assim, ainda que não seja da área de saúde, você pode ajudar no combate. Para isso,  foi designado para desenvolver um sistema que irá coletar informações de todo país, organizá-las e prover informações com base nelas.
## ------------------------------TECNOLOGIAS------------------------
* Java 8
* Spring BOOT
* Sprint DATA
* Postgresql 9.4.X
* Maven
* JUnit
* Hibernate

## -------------------------------DATABASE------------------------

Como default o spring.datasource.username=postgres vem como "postgres" 

Dentro app/src/main/application.properties substitua spring.datasource.password=12345 para corresponder à sua senha do banco de dados.

## -------------------------------ENDPOINT-------------------------
# /hospital
GET /hospital: Retorna uma lista com todos os hospitais registrados.

GET /hospital/{hospital_id}: Retorna o hospital registrado com o id informado.

POST /hospital: Registra um novo hospital.
Body: name(String), address(String), cnpj(String), localization(String), occupancy(float), recursosHosp{name(String)}

PATCH /hospital/{hospital_id}: Atualiza a taxa de ocupação do hospital com o id informado.
Body: occupancy(float)

# /negotiation
GET /negotiation: Retorna uma lista com todas as negociações registradas

POST /negotiation: Registra uma nova negociação.

Body: id_first_hospital(long), id_second_hospital(long), resources_first_hospital{name(String), quantity(int)}, resources_second_hospital{name(String), quantity(int)}

# /report
GET /report: Retorna um relatório com:

Porcentagem de hospitais com taxa de ocupação acima de 90%

Porcentagem de hospitais com taxa de ocupação abaixo de 90%

Média de recursos por hospital

Histórico de negociações
