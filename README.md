# Playground de Desafios de Programação (Java)

Este repositório é dedicado ao treino, estudo e resolução de desafios de programação (code challenges) e algoritmos em **Java**. 

Aqui são implementadas soluções para problemas de plataformas conhecidas como LeetCode, HackerRank, Beecrowd, entre outras.

## 🚀 Estrutura do Projeto

O projeto é estruturado utilizando **Maven** para gerenciamento de dependências e **JUnit 5** para a automação de testes das soluções:

* `src/main/java/playground/challenges/`: Contém os arquivos de código com as resoluções dos desafios.
* `src/test/java/playground/challenges/`: Contém as classes de testes unitários para validar a lógica das soluções contra diferentes casos de teste.
* `pom.xml`: Gerenciador de dependências Maven.
* `challenges.md`: Um arquivo de controle para catalogar os desafios resolvidos, em progresso ou pendentes.

## 🛠️ Como Utilizar

### Requisitos

* Java JDK 17 ou superior (configurado com Java 21)
* Maven 3.x instalado ou configurado no ambiente

### Executando os Testes

Para validar se as suas soluções estão corretas e passam em todos os testes configurados, execute o seguinte comando no terminal:

```bash
mvn test
```

### Criando um Novo Desafio

1. Crie a classe do desafio no diretório `src/main/java/playground/challenges/`.
2. Crie a classe de teste correspondente no diretório `src/test/java/playground/challenges/`.
3. Adicione o novo desafio na tabela do arquivo [challenges.md](file:///o:/JavaProjects/playground/challenges.md) para controle.