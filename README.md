# projeto-sistemas-operacionais
Projeto de simulação de alocação de memória (troca de páginas) para a disciplina de Sistemas Operacionais - FEI 6 semestre

# Sobre
Escolhemos a tecnologia JAVA para implementar os algoritmos de troca de páginas.
O projeto possui os seguintes arquivos:
    1. Main.java (arquivo de entrada)
    2. FIFO.java (algoritmo de fila)
    3. OPT.java (algoritmo de Optimal Page Replacement)
    4. LRU.java (algoritmo de Last Recent Used Page Replacement)

# Como executar
Para executar o programa, é necessário seguir os seguintes passos:
    1. Clone dos arquivos com "git clone <repositorio>"
    2. javac Main.java
    3. java Main <núm. páginas> <lista de páginas> <algoritmo>

Algoritmos:
    1 - FIFO
    2 - OPT
    3 - LRU

Exemplo:
    javac Main.java
    java Main 5 1,3,5,4,2,4,3,2,1,0,5,3,5,0,4,3,5,4,3,2,1,3,4,5 3

# Grupo
Gianluca Mariano Sobreiro        - RA: 22.122.011-4
Guilherme Fornagiero de Carvalho - RA: 22.122.016-3
Paulo Vinícius Bessa de Brito    - RA: 22.122.005-6
Pedro Augusto Bento Rocha        - RA: 22.122.028-8