
# ms-notification

Micro serviço para envio de notificação por e-mail sobre consultas agendadas no serviço de consultar [ms-schedule](https://github.com/fiap-g4-adjt-schedule-management/ms-schedule).
O serviço de notificação utiliza a api do Java Mail Sender para enviar templates de e-mail em html, para cada mensagem enviada pelo serviço de consulta utilizando RabbitMQ para comunicação assincrona entre serviços.

## 🚀 Tecnologias Utilizadas
- Java 21
- Spring Boot
- RabbitMQ
- Lombok
- Java Mail Sender

## Estrutura de Pastas
```
src/main/java/com/fiap/msnotification

├── configuration      # Configuração dos beans para funcionamento do Rabbit; 
├── consumer           # Classe de instanciação do consumidor Rabbit e utilização do UseCase;
├── core               # Camada que encapsula as regras de negócio aplicando Clean Architecture
│   ├── controller     # Camada que implementa os controllers internos;
│   ├── domain         # Camada que encapsula Entidades;
│   ├── gateways       # Classa e interfaces de comunicação com as camadas externas;
│   ├── interfaces     # Interfaces publicas que iram implementar a logica de negócio externamente;
│   └── usecase        # Camada que implementa as regras de negócio;
├── datasource         # Camada que encapsula a comunicação com as fontes de dados externas(banco de dados e bibliotecas);
├── dto                # Classes de transferência de dados;
├── exception          # Exceções customizadas para aplicação;
├── mapper             # Classe de mapeamento entre DTOs, Entidades e Domains;
└── MsNotificationApplication.java
```
## 🛠️ Como Configurar
### Pré-requisitos
- Java 21 ou superior
- Maven

### Clone o repositório:
```bash
   git clone https://github.com/fiap-g4-adjt-schedule-management/ms-notification.git
```

### Instale as dependências:
```bash
 ./mvnw clean install
```

## 🧩 Variáveis de ambiente
Renomei o arquivo “.env.example” para ".env" e preencha-o da seguinte maneira:
```
RABBIT_HOST=localhost |nome do container do servidor rabbit
RABBIT_PORT=5672 |porta padrão do rabbit
RABBIT_USER=guest |exemplo utilizando usuário padrão
RABBIT_PASSWORD=guest |exemplo utilizando usuário padrão

EMAIL_HOST= #smtp.gmail.com |padrão google 
EMAIL_PORT= #587 |padrão google 
EMAIL_USER= #e-mail a ser utilizado
EMAIL_PASS= #senha do e-mail ou senha de aplicativo caso o e-mail possua autenticação em 2 fatores
```
## 💻 Como rodar o projeto
### Executar com Docker Compose
Navegue até o diretório do projeto
```bash
  cd ms-notification
```
Execute o docker-compose
```bash
  docker-compose up --build
```

## 🧩 Exemplo de payload - Criação de usuário
```json
{
  "title": "Sua consulta foi marcada!",
  "pacientName": "João da Silva",
  "doctorName": "Doctor 2",
  "date": "2025-10-05T14:30",
  "type": "SCHEDULED",
  "clientEmail": "paciente1@example.com",
  "clientPhone": "(11)90001-0001"
}
```

## 🧩 Configuração de e-mail

## 🧑‍💻 Autoria
- Desenvolvido por Mayara Bomfim, Webber Chagas, Matheus Braga e Raysse Cutrim.
- Projeto acadêmico da pós-graduação em Java pela FIAP.