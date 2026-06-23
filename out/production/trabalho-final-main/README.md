````markdown
# 🦈 Shark Hub

Sistema de gerenciamento de investidores e startups desenvolvido em Java.
Trabalho final da disciplina de Programação.

## 📋 Sobre o projeto

O Shark Hub é uma aplicação de console que permite cadastrar e consultar
investidores e startups, registrar pitches e investimentos, além de calcular
métricas como valuation, ranking de startups e índice de "unicornização".

## ✨ Funcionalidades

- [x] Cadastrar investidor
- [x] Cadastrar startup (vinculada a um investidor)
- [x] Consultar startups cadastradas
- [x] Consultar investidores cadastrados
- [ ] Adicionar pitch
- [ ] Adicionar investimento
- [ ] Consultar investimentos
- [ ] Calcular valuation
- [ ] Exibir ranking de startups
- [ ] Exibir índice de unicornização

## 🛠️ Tecnologias

- Java (JDK 8 ou superior)

## 📁 Estrutura do projeto

```
trabalho-final-main/
├── Main.java         # Menu principal e fluxo do programa
├── Investidor.java   # Classe que representa um investidor
└── Startup.java      # Classe que representa uma startup
```

## ▶️ Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/trabalho-final-main.git
   cd trabalho-final-main
   ```

2. Compile os arquivos:
   ```bash
   javac Main.java Investidor.java Startup.java
   ```

3. Execute o programa:
   ```bash
   java Main
   ```

## 💻 Exemplo de uso

```
=========== Shark Hub ============
0) SAIR
1) Cadastrar Investidor
2) Cadastrar Startup
3) Adicionar Pitch
4) Adicionar Investimento
5) Consultar Startup
6) Consultar Investidores
7) Consultar Investimentos
8) Calcular Valuation
9) Exibir Ranking de Startups
10) Exibir Índice de Unicornização
==================================
```

## 👥 Autores

- Otavio Machado

## 📄 Licença

Projeto acadêmico desenvolvido para fins educacionais.
````