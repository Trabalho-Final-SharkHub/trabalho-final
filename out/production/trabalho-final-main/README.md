# 🦈 Shark Hub

Sistema de gerenciamento de investidores e startups desenvolvido em Java.
Trabalho final da disciplina de Programação.

## 📋 Sobre o projeto

O Shark Hub é uma aplicação de console que permite cadastrar e consultar
investidores e startups, registrar pitches e investimentos, além de calcular
métricas como *valuation*, ranking de startups e o **Índice de Potencial de
Unicornização (IPU)** — uma funcionalidade inovadora que avalia e classifica
automaticamente o potencial de cada startup.

Todos os dados são mantidos em **vetores de objetos** (investidores, startups,
pitches e investimentos), conforme exigido pelo trabalho.

## ✨ Funcionalidades

- [x] Cadastrar investidor (com validação de e-mail único)
- [x] Cadastrar startup (vinculada a um investidor responsável)
- [x] Adicionar pitch (com notas de inovação e mercado)
- [x] Adicionar investimento (valor e percentual de participação)
- [x] Consultar startup (dossiê completo: dados, pitches, investimentos e total captado)
- [x] Consultar investidores cadastrados
- [x] Consultar investimentos
- [x] Calcular valuation (total captado por uma startup)
- [x] Exibir ranking de startups (ordenado pelo IPU)
- [x] Exibir Índice de Unicornização (IPU) — funcionalidade inovadora
- [x] Listar pitches
- [x] Simulador de crescimento em 5 anos (desafio extra)

## ⭐ Funcionalidade Inovadora — IPU (Índice de Potencial de Unicornização)

O IPU é uma pontuação calculada automaticamente para cada startup a partir dos
dados reais do sistema:

```
IPU = (média das notas dos pitches) * 25
    + (total captado em investimentos) / 10000
    + (tempo de existência em anos)    * 10
```

Com base na pontuação, cada startup é classificada em:

| Pontuação        | Classificação            |
|------------------|--------------------------|
| até 100          | Startup Inicial          |
| 101 a 250        | Startup Promissora       |
| 251 a 500        | Startup em Crescimento   |
| acima de 500     | Potencial Unicórnio      |

A opção 10 do menu mostra ainda a startup mais promissora, a de maior volume de
investimentos, o investidor com maior valor investido, o ranking e a
classificação de todas as startups.

## 🛠️ Tecnologias

- Java (JDK 8 ou superior)

## 📁 Estrutura do projeto

```
trabalho-final-main/
├── Main.java          # Menu principal, fluxo do programa e regras de negócio
├── Investidor.java    # Classe que representa um investidor
├── Startup.java       # Classe que representa uma startup (calcula tempo de existência)
├── Pitch.java         # Classe que representa um pitch (calcula média das notas)
├── Investimento.java  # Classe que representa um investimento em uma startup
└── Valuation.java     # Classe que calcula o total captado por uma startup
```

## ▶️ Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/Trabalho-Final-SharkHub/trabalho-final.git
   cd trabalho-final
   ```

2. Compile os arquivos:
   ```bash
   javac *.java
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
10) Exibir Indice de Unicornizacao (IPU)
---------- Cases Extras ----------
11) Listar Pitches
12) Simulador de Crescimento (5 anos)
==================================
```

## 👥 Autores

- Otavio Machado — Matrícula: _(preencher)_

> Caso o trabalho seja em dupla/trio, adicione aqui o nome e a matrícula dos
> demais integrantes.

## 📚 Fontes utilizadas

- Materiais e slides da disciplina de Programação.
- Documentação oficial do Java (Oracle): https://docs.oracle.com/javase/
- Anotações de aula sobre vetores de objetos, classes, encapsulamento e
  estruturas de repetição.

## 🎓 Lições aprendidas

- Como modelar um problema do mundo real usando **classes** e relacionamentos
  entre objetos (uma startup tem um investidor; um pitch e um investimento
  pertencem a uma startup).
- A importância de **encapsular** os atributos com getters/setters.
- Como percorrer **vetores de objetos** filtrando os elementos que pertencem a
  uma entidade específica — um padrão que se repete em quase todas as consultas.
- Como implementar uma **ordenação simples** (bubble sort) para o ranking.

## 🧗 Dificuldades encontradas e como foram superadas

- **Bug do `Scanner`**: depois de `nextInt()`/`nextDouble()`, o "Enter" ficava no
  buffer e o `nextLine()` seguinte lia uma string vazia (ex.: título do pitch
  vinha em branco). *Solução:* criei os métodos `lerInteiro` e `lerDouble`, que
  leem sempre com `nextLine()` e convertem o texto, evitando lixo no buffer.
- **Validação de e-mail repetido**: a verificação original retornava cedo demais,
  comparando só com o primeiro investidor. *Solução:* criei `emailJaExiste`, que
  percorre **todos** os investidores antes de decidir, usando `.equals(...)`.
- **Associação errada do pitch/investimento à startup**: o código usava o ID
  digitado como índice do vetor. *Solução:* criei `buscarStartupPorId`, que
  encontra a startup correta pelo ID.
- **Erros de compilação**: havia código duplicado fora da classe em `Pitch.java`
  e uma chave `}` a mais em `Valuation.java`. Foram removidos.

## 🤖 Uso de IA

- **Ferramentas utilizadas:** Claude Code (assistente de programação em IA).
- **Objetivo do uso:** entender o que ainda faltava no projeto, identificar os
  bugs existentes e me orientar sobre a lógica a implementar em cada
  funcionalidade. A IA atuou como um guia — **o código foi escrito e revisado
  por mim**, com base nas explicações.
- **Principais prompts utilizados:**
  - "Veja o GitHub, atualize o projeto e termine o trabalho."
  - "Quais bugs existem no código atual e como corrigi-los?"
  - "Como implementar o cálculo do IPU e o ranking de startups?"
- **Principais respostas obtidas:**
  - Explicação do bug do `Scanner` e a solução com leitura via `nextLine()`.
  - Orientação para criar métodos de busca por ID e reutilizá-los nas opções
    do menu.
  - Sugestão de fórmula para o IPU combinando média dos pitches, total captado
    e tempo de existência da startup.
- **Reflexão:** a IA acelerou bastante a identificação dos problemas e me ajudou
  a organizar o raciocínio. Aprendi, na prática, o motivo do bug do buffer do
  `Scanner` e a importância de reutilizar métodos (buscas) em vez de repetir
  código. Da próxima vez, escreveria os testes manuais (cadastro de listas
  vazias, IDs inexistentes, e-mail repetido) antes mesmo de implementar, para
  validar cada parte mais cedo.

## 📄 Licença

Projeto acadêmico desenvolvido para fins educacionais.
