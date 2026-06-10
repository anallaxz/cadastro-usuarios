# Atividade Java POO

Este é um projeto simples em Java que demonstra conceitos básicos de Programação Orientada a Objetos (POO), incluindo herança, encapsulamento e relações entre objetos.

O sistema simula um ambiente onde "Donos" podem se cadastrar, gerenciar uma lista de "Clientes" e enviar notificações para eles. Cada Dono é independente e só pode interagir com os clientes que ele mesmo cadastrou.

## Funcionalidades

- **Herança**: As classes `Dono` e `Cliente` herdam da classe base `Usuario`.
- **Encapsulamento**: Os dados de cada classe são privados e acessados por métodos públicos.
- **Relacionamento de Objetos**: Um objeto `Dono` possui uma lista de objetos `Cliente`.
- **Sistema de Notificações**: Donos podem enviar mensagens para seus clientes, e os clientes podem visualizar as notificações recebidas.
- **Isolamento de Dados**: O sistema demonstra que cada instância de `Dono` gerencia seus próprios clientes e notificações de forma isolada.

## Estrutura de Pastas

O projeto segue uma estrutura padrão baseada em pacotes Java:

```
atividade-java/
└── src/
    └── br/com/anhanguera/
        ├── app/
        │   └── App.java           (Ponto de entrada principal da aplicação)
        ├── model/                 (Classes de Domínio/Modelo)
        │   ├── Cliente.java       (Representa um cliente. Recebe e armazena notificações.)
        │   ├── Dono.java          (Representa um dono. Gerencia clientes e envia notificações.)
        │   └── Usuario.java       (Classe base com dados de autenticação.)
        └── service/               (Classes de Serviço/Lógica de Negócios)
            └── AuthService.java   (Gerencia registro e login de usuários. Atualmente não usado no App.java principal)
```

- **`model`**:
    - `Usuario`: Classe base que contém `username` e `password`.
    - `Dono`: Herda de `Usuario`. Pode cadastrar uma lista de `Cliente`s e enviar notificações para eles.
    - `Cliente`: Herda de `Usuario`. Possui uma lista para armazenar notificações recebidas de seu `Dono`.
- **`app`**: Contém a classe `App` com o método `main`, que executa um cenário de demonstração com múltiplos donos e clientes.

## Como Compilar

Para compilar o projeto manualmente via terminal:

1.  Abra o terminal e navegue até o diretório `src`:
    ```bash
    cd caminho/para/atividade-java/src
    ```
2.  Compile todos os arquivos `.java`, especificando o diretório de saída (`out`):
    ```bash
    javac -d ../out br/com/anhanguera/app/*.java br/com/anhanguera/model/*.java br/com/anhanguera/service/*.java
    ```
    *Isso compilará os arquivos e colocará os `.class` (bytecode) em uma pasta `out`.*

> **Nota:** Usando uma IDE como IntelliJ IDEA, Eclipse ou VS Code com as extensões Java, basta clicar no botão "Run" (Executar) na classe `App.java`, e a IDE gerenciará a compilação e execução automaticamente.

## Como Executar

Após compilar o projeto, você pode executar a classe principal:

1.  No terminal, navegue até a pasta onde os arquivos compilados (`.class`) foram gerados (`out`):
    ```bash
    cd ../out
    ```
2.  Execute a classe principal informando o nome completo (com o pacote):
    ```bash
    java br.com.anhanguera.app.App
    ```

### Saída Esperada

A execução do programa demonstrará os seguintes cenários:
1.  O "Dono 1" (`chefe`) cadastra seus próprios clientes (`clienteA`, `clienteB`).
2.  O "Dono 2" (`gerente`) cadastra seus próprios clientes (`clienteC`, `clienteD`).
3.  O "Dono 1" envia uma notificação, que é recebida apenas pelos seus clientes.
4.  O "Dono 2" envia outra notificação, que é recebida apenas pelos clientes dele.
5.  Ao final, os clientes verificam suas caixas de entrada, mostrando que receberam apenas as mensagens de seus respectivos donos, provando o isolamento dos dados.