================================================================================

                              S H A R K   H U B

              Plataforma de Gestao de Investidores e Startups

         Trabalho Final - Fundamentos de Programacao (4611C-6) - PUCRS

================================================================================

AUTORES
--------------------------------------------------------------------------------
  Otavio Machado    - Matricula: 26108750
  Lorenzo Debiasi   - Matricula: 26103916


SUMARIO
--------------------------------------------------------------------------------
  1. Sobre o projeto
  2. Funcionalidades
  3. Funcionalidade inovadora - IPU
  4. Arquitetura e classes
  5. Estrutura de arquivos
  6. Como executar
  7. Guia do menu
  8. Exemplo de execucao
  9. Regras de negocio e validacoes
 10. Conceitos de programacao aplicados
 11. Decisoes de projeto
 12. Fontes utilizadas
 13. Licoes aprendidas
 14. Dificuldades encontradas e como superamos
 15. Uso de IA
 16. Licenca


================================================================================
 1. SOBRE O PROJETO
================================================================================

O Shark Hub e uma aplicacao de console, escrita em Java, que simula o universo
do venture capital: investidores aportam capital em startups, que por sua vez
apresentam pitches e captam investimentos. A partir desses dados, o sistema
calcula automaticamente metricas de mercado - valuation, ranking e o nosso
Indice de Potencial de Unicornizacao (IPU).

O projeto foi construido inteiramente com os conceitos vistos na disciplina de
Fundamentos de Programacao: classes, encapsulamento, vetores de objetos,
selecao, repeticao, modularizacao e manipulacao de Strings.

Toda a informacao do sistema e armazenada em VETORES DE OBJETOS - sao quatro
vetores no Main: investidores, startups, pitches e investimentos.


================================================================================
 2. FUNCIONALIDADES
================================================================================

   1  - Cadastrar Investidor ....... cadastro com validacao de e-mail unico
   2  - Cadastrar Startup .......... vinculada a um investidor responsavel
   3  - Adicionar Pitch ............ notas de inovacao e mercado (0 a 10)
   4  - Adicionar Investimento ..... valor e percentual de participacao
   5  - Consultar Startup .......... DOSSIE completo: dados + pitches +
                                     investimentos + total captado
   6  - Consultar Investidores ..... lista todos os investidores
   7  - Consultar Investimentos .... lista todos os investimentos
   8  - Calcular Valuation ......... total captado por uma startup
   9  - Ranking de Startups ........ ordenado pelo IPU (bubble sort)
   10 - Indice de Unicornizacao .... (*) FUNCIONALIDADE INOVADORA
   11 - Listar Pitches ............. lista todos os pitches e suas medias
   12 - Simulador de Crescimento ... DESAFIO EXTRA: projecao de 5 anos

Todas as funcionalidades estao implementadas e testadas.


================================================================================
 3. FUNCIONALIDADE INOVADORA - IPU (Indice de Potencial de Unicornizacao)
================================================================================

O IPU e a "alma" do Shark Hub: uma pontuacao que o sistema calcula sozinho para
cada startup, combinando os tres fatores que mais pesam para uma startup virar
um unicornio (avaliacao acima de US$ 1 bilhao):

    IPU = (media das notas dos pitches) x 25
        + (total captado em investimentos) / 10000
        + (tempo de existencia em anos)    x 10

POR QUE ESSA FORMULA?

  - Media dos pitches (x 25): mede a qualidade percebida (inovacao + mercado).
    Como a nota vai de 0 a 10, o peso 25 leva a faixa para 0 a 250.

  - Total captado (/ 10000): mede a confianca do mercado em dinheiro real.
    Dividimos por 10 mil para grandes aportes nao "esmagarem" os outros fatores.

  - Tempo de existencia (x 10): mede maturidade/sobrevivencia - startups que
    duram acumulam pontos.

CLASSIFICACAO AUTOMATICA

    Pontuacao (IPU)      Classificacao
    ----------------     ----------------------
    ate 100              Startup Inicial
    101 a 250            Startup Promissora
    251 a 500            Startup em Crescimento
    acima de 500         Potencial Unicornio

A opcao 10 ainda exibe os indicadores que o trabalho exige:
  - Startup mais promissora (maior IPU)
  - Startup com maior volume de investimentos
  - Investidor com maior valor investido
  - Ranking completo das startups
  - Classificacao individual de cada startup

EXEMPLO REAL DO SISTEMA:
  Uma startup com media de pitches 8.5, total captado R$ 500000 e 6 anos de
  existencia resulta em:
      8.5 x 25 + 500000 / 10000 + 6 x 10 = 212.5 + 50 + 60 = 322.5
  Classificacao: Startup em Crescimento.


================================================================================
 4. ARQUITETURA E CLASSES
================================================================================

O sistema usa relacionamentos entre objetos (associacao):

    Startup ........ tem 1 Investidor responsavel
    Pitch .......... pertence a 1 Startup
    Investimento ... pertence a 1 Startup
    Valuation ...... avalia 1 Startup (soma os investimentos dela)

Resumo de cada classe:

  Investidor    -> id, nome, email
  Startup       -> id, nome, areaAtuacao, data, investidor
                   metodo calcularExistencia() -> anos de existencia
  Pitch         -> id, titulo, notaInovacao, notaMercado, startup
                   metodo calcularMediaPitch() -> media das duas notas
  Investimento  -> id, valor, percentualParticipacao, startup
  Valuation     -> startup, valorCaptado
                   metodo calcularTotalCaptado(...) -> total captado pela startup
  Main          -> menu, fluxo do programa e regras (IPU, ranking, valuation)

Leitura rapida: uma Startup tem UM Investidor responsavel; um Pitch e um
Investimento pertencem a UMA Startup; a Valuation calcula o total captado por
uma startup especifica.


================================================================================
 5. ESTRUTURA DE ARQUIVOS
================================================================================

    Main.java          Menu, fluxo do programa e regras de negocio
                       (IPU, ranking, valuation)
    Investidor.java    Quem investe
    Startup.java       A empresa (calcula seu tempo de existencia pela data)
    Pitch.java         Apresentacao da startup (calcula a media das notas)
    Investimento.java  Aporte de capital em uma startup
    Valuation.java     Calcula o total captado por uma startup
    README.TXT         Este arquivo


================================================================================
 6. COMO EXECUTAR
================================================================================

NO BlueJ:
  1. Abra o projeto (Project > Open Project) e selecione a pasta do trabalho.
  2. Clique em "Compile" para compilar todas as classes.
  3. Clique com o botao direito na classe Main e escolha:
         void main(String[] args)
  4. Confirme na janela e use o terminal do BlueJ para interagir com o menu.

PELO TERMINAL (alternativa):
  1. javac *.java       (compila tudo)
  2. java Main          (executa)

Pre-requisito: Java JDK 8 ou superior.


================================================================================
 7. GUIA DO MENU
================================================================================

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

Ordem sugerida de uso: cadastre investidores (1) -> cadastre startups (2) ->
adicione pitches (3) e investimentos (4) -> explore as metricas (5, 8, 9, 10).
O programa so encerra na opcao 0.


================================================================================
 8. EXEMPLO DE EXECUCAO
================================================================================

    Digite o ID do investidor: 10
    Digite o nome do investidor: Ana Silva
    Digite o email do investidor: ana@email.com
    Investidor cadastrado com sucesso!

    ===== Dossie da Startup =====
    ID: 100
    Nome: TechAI
    Area de Atuacao: Inteligencia Artificial
    Data de fundacao: 10/03/2020
    Tempo de existencia: 6 ano(s)
    Investidor responsavel: Ana Silva

    --- Pitches ---
    - Pitch IA | Media: 8.5

    --- Investimentos ---
    - R$ 500000.0 (20.0%)

    Total captado: R$ 500000.0
    =============================

    --- Indice de Potencial de Unicornizacao (IPU) ---
    Startup mais promissora: TechAI (IPU: 322.5)
    Startup com maior volume de investimentos: TechAI (Total: R$ 500000.0)
    Investidor com maior valor investido: Ana Silva (Total: R$ 500000.0)
    TechAI | IPU: 322.5 | Classificacao: Startup em Crescimento


================================================================================
 9. REGRAS DE NEGOCIO E VALIDACOES
================================================================================

  - E-mail unico: dois investidores nao podem ter o mesmo e-mail.
  - Startup exige investidor: nao da para cadastrar startup sem ao menos um
    investidor cadastrado.
  - Notas dos pitches devem estar entre 0 e 10.
  - Valor do investimento deve ser maior que zero.
  - Percentual de participacao deve estar entre 0 e 100.
  - Buscas por ID evitam associar pitch/investimento a startup errada.
  - Listas vazias e IDs inexistentes sao tratados sem quebrar o programa.


================================================================================
 10. CONCEITOS DE PROGRAMACAO APLICADOS
================================================================================

  Variaveis e operadores ....... calculo do IPU, valuation, simulador
  Entrada de dados e casting ... lerInteiro / lerDouble (tratam o buffer do
                                 Scanner)
  Selecao (if / switch) ........ menu principal, validacoes, classificarIPU
  Repeticao (for/while/do) ..... percorrer vetores, menu, validacao de e-mail
  Modularizacao (metodos) ...... buscarStartupPorId, calcularIPU, emailJaExiste
  Classe String e metodos ...... equals, substring, charAt (extracao do ano)
  Orientacao a Objetos ......... 6 classes com construtor, getters/setters e
                                 toString
  Vetores (arrays) ............. 4 vetores de objetos + vetores auxiliares no
                                 ranking
  Array de objetos ............. investidores[], startups[], pitches[],
                                 investimentos[]
  Algoritmo de ordenacao ....... bubble sort no ranking de startups


================================================================================
 11. DECISOES DE PROJETO
================================================================================

  - Tempo de existencia sem bibliotecas de data: a data e uma String
    ("dd/mm/aaaa"). Extraimos os 4 ultimos caracteres com substring e
    convertemos o ano digito por digito com charAt, sem usar split, parseInt
    ou java.time - tudo dentro do conteudo da disciplina.

  - Total captado na classe Valuation: centralizamos a soma dos investimentos
    de uma startup em Valuation.calcularTotalCaptado, mantendo a
    responsabilidade num lugar so.

  - Comparacao por ID: ao filtrar pitches/investimentos de uma startup,
    comparamos pelo ID (getId()), que e mais seguro do que comparar objetos.

  - Leitura robusta do teclado: lerInteiro/lerDouble sempre consomem o "Enter"
    que sobra no buffer, evitando o classico bug de campos vindo vazios.


================================================================================
 12. FONTES UTILIZADAS
================================================================================

  - Materiais, slides e exercicios da disciplina Fundamentos de Programacao
    (PUCRS).
  - Documentacao oficial do Java (Oracle): https://docs.oracle.com/javase/
  - Anotacoes de aula sobre vetores de objetos, encapsulamento, Strings e
    estruturas de repeticao.


================================================================================
 13. LICOES APRENDIDAS
================================================================================

  - Como modelar um problema real com classes e relacionamentos entre objetos.
  - A importancia do encapsulamento (atributos privados + getters/setters).
  - O padrao de percorrer um vetor de objetos filtrando os que pertencem a uma
    entidade - usado em praticamente todas as consultas e no IPU.
  - Como implementar uma ordenacao simples (bubble sort) e entende-la de verdade.
  - Como dividir um problema grande (o IPU) em metodos menores e testaveis.


================================================================================
 14. DIFICULDADES ENCONTRADAS E COMO SUPERAMOS
================================================================================

  - Bug do Scanner: o "Enter" ficava no buffer apos nextInt()/nextDouble(),
    fazendo o titulo do pitch vir vazio.
    SOLUCAO: criamos lerInteiro/lerDouble, que leem o numero e em seguida fazem
    nextLine() para limpar o buffer.

  - Validacao de e-mail: a verificacao retornava cedo demais, checando so o
    primeiro investidor.
    SOLUCAO: criamos emailJaExiste, que percorre TODOS os investidores antes de
    decidir, usando .equals().

  - Pitch/investimento na startup errada: o codigo usava o ID como indice do
    vetor.
    SOLUCAO: criamos buscarStartupPorId, que encontra a startup correta pelo ID.

  - Erros de compilacao: codigo duplicado fora da classe em Pitch.java e uma
    chave "}" a mais em Valuation.java.
    SOLUCAO: removemos o codigo duplicado e a chave extra.

  - Calcular o ano sem bibliotecas: extracao com substring + conversao charAt
    digito por digito.


================================================================================
 15. USO DE IA
================================================================================

FERRAMENTA UTILIZADA:
  Claude Code (assistente de programacao baseado em IA).

OBJETIVO DO USO:
  Entender o que faltava no projeto, identificar os bugs existentes e nos
  orientar sobre a logica de cada funcionalidade. A IA atuou como um GUIA - o
  codigo foi escrito, revisado e testado por nos, sempre respeitando os limites
  do conteudo da disciplina (sem try/catch, sem operador ternario, sem
  String.format e sem bibliotecas de data).

PRINCIPAIS PROMPTS UTILIZADOS:
  - "Veja o GitHub, atualize o projeto e termine o trabalho."
  - "Quais bugs existem no codigo atual e como corrigi-los?"
  - "Como implementar o calculo do IPU e o ranking de startups?"
  - "Nao podemos usar try, split, parseInt, operador ternario nem String.format
     - ajuste o codigo."

PRINCIPAIS RESPOSTAS OBTIDAS:
  - Explicacao do bug do Scanner e a solucao com leitura via nextLine().
  - Orientacao para criar metodos de busca por ID e reutiliza-los no menu.
  - Sugestao de formula para o IPU combinando media dos pitches, total captado
    e tempo de existencia.
  - Reescrita de trechos para ficarem 100% dentro do conteudo de aula.

REFLEXAO:
  A IA acelerou a identificacao dos problemas e nos ajudou a organizar o
  raciocinio. Aprendemos, na pratica, o motivo do bug do buffer do Scanner e a
  importancia de reutilizar metodos em vez de repetir codigo. Tambem percebemos
  o valor de delimitar as ferramentas permitidas - pedir a IA para reescrever
  usando so o que vimos em aula reforcou nosso aprendizado. Numa proxima vez,
  escreveriamos os testes manuais (listas vazias, IDs inexistentes, e-mail
  repetido) ANTES de implementar, para validar cada parte mais cedo.


================================================================================
 16. LICENCA
================================================================================

Projeto academico desenvolvido para fins educacionais - disciplina de
Fundamentos de Programacao, PUCRS.

================================================================================
            Shark Hub - "Que comece o feeding frenzy dos investimentos."
================================================================================
