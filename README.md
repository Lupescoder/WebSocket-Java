# Spring Boot WebSocket Chat - HiChat

Este repositório contém um código em Java usando Spring Boot para implementar um simples WebSocket que permite a criação de um chat em tempo real. Ele pode ser usado em conjunto com o repositório "hichat" para fornecer uma experiência de chat interativa.

## Pré-requisitos

Antes de começar, verifique se você tem os seguintes requisitos instalados:

- Java Development Kit (JDK) 8 ou superior
- Maven
- Git

## Instalação e execução

Siga os passos abaixo para clonar o repositório, compilar e executar o aplicativo:

1. Clone o repositório usando o Git:

git clone https://github.com/seu-usuario/este-repositorio.git

2. Acesse o diretório do projeto;

3. Compile o projeto usando o Maven;
4. Execute o aplicativo Spring Boot;


Após executar esses passos, o WebSocket estará ativo e pronto para aceitar conexões de clientes para o chat.

## Uso do HiChat

O repositório "hichat" contém um cliente simples para interagir com o WebSocket deste projeto. Siga as instruções fornecidas no README.md do repositório "hichat" para obter mais informações sobre como usá-lo.

## Como funciona o WebSocket

O WebSocket é uma tecnologia que permite a comunicação bidirecional entre um cliente e um servidor em tempo real. No contexto deste projeto, ele é utilizado para criar um chat em que várias pessoas podem enviar e receber mensagens instantaneamente.

O servidor Spring Boot WebSocket lida com a conexão do cliente e gerencia os eventos de mensagem. Quando um cliente envia uma mensagem, o servidor a recebe e a retransmite para todos os outros clientes conectados.

