# Atividade Somativa 1

## Introdução

Olá estudante,

Chegou o momento da Atividade Somativa da nossa disciplina. Você usará como base o que já desenvolveu nas semanas 2 e 3. Nesta fase do nosso projeto, você terá a oportunidade de mergulhar no mundo dos **grafos**, uma estrutura de dados que permite modelar relações complexas de um jeito eficiente.

Em Java, usamos o **HashMap** para representar grafos. Por isso, você criará um grafo usando esta estrutura. Neste grafo, cada nó representa um livro, enquanto as arestas simbolizam diferentes tipos de relações, como livros recomendados ou similaridade entre obras.

Esta tarefa não só reforça habilidades fundamentais em estruturas de dados e algoritmos, mas também lhe ajuda a entender como funcionam os sistemas de recomendação em plataformas digitais.

## O que você deve desenvolver?

1. *Criação do grafo:* implemente um grafo em que cada livro é um nó, e as relações entre eles são representadas por arestas.

    * Dica: use `HashMap<Livro, Set<Livro>>` para representar o seu grafo, em que Livro é uma classe que você criou e que possui atributos, métodos e construtores próprios para representar um livro qualquer.

2. **Seleção de livros:** escolha pelo menos 10 livros diferentes para incluir no seu grafo. Isso ajudará a visualizar melhor as relações e a eficácia do sistema de recomendação. Cada livro precisa ter pelo menos dois outros livros como recomendação.

3. **Aplicação prática:** use o grafo para desenvolver um sistema de sugestão de livros, em que os usuários recebem recomendações baseadas em suas leituras anteriores ou interesses.

## O que você deve entregar?

Precisaremos do código-fonte do seu projeto dentro de uma pasta zipada. Isso significa que precisaremos de todos os arquivos com final .java que você criou. Os arquivos com final .class **não devem** ser incluídos.
