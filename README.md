# 🎵 MusicArts: Gerenciador de Artistas e Músicas

Este projeto é uma implementação do desafio proposto pela **Alura**, focado em **persistência de dados** e **integração com APIs externas** utilizando Spring Boot. O objetivo foi construir uma aplicação robusta para gerenciamento de um catálogo musical, explorando desde a modelagem de entidades até a comunicação com inteligência artificial.

## 🔨 Sobre o Projeto
O foco central deste desafio foi a aplicação prática dos conceitos de *Spring Data JPA* e modelagem orientada a objetos em um cenário real.

**Principais pilares:**
* **Modelagem de Entidades:** Estruturação das classes `Artista` e `Musica`.
* **Enumerações:** Uso de `TipoArtista` para categorizar artistas (Solo, Dupla, Banda).
* **Relacionamentos:** Implementação de relacionamento `1:N` (um artista para múltiplas músicas).
* **Persistência e Consultas:** Utilização de *Derived Queries* e *JPQL* para manipulação eficiente de dados.
* **Integração com IA:** Consumo da API do Google Gemini (2.5 Flash) para enriquecimento de dados e informações sobre artistas.
* **Interface:** Menu interativo via console utilizando `CommandLineRunner`.

## 🚀 Funcionalidades
1. **Cadastrar Artista:** Registro de novos artistas no banco de dados.
2. **Cadastrar Música:** Adição de faixas vinculadas a um artista existente.
3. **Listar Músicas:** Exibição organizada de todo o acervo cadastrado.
4. **Buscar Músicas por Artista:** Filtro rápido pelo nome do artista.
5. **Pesquisar Dados de Artista:** Consulta inteligente via IA para obter biografias e curiosidades da carreira.

## 🛠 Tecnologias Utilizadas
* **Linguagem:** Java 21+
* **Framework:** Spring Boot (Data JPA, Starter Web)
* **Banco de Dados:** H2 Database (In-Memory)
* **API Externa:** Google Generative AI SDK (Gemini)
* **Gerenciamento de Dependências:** Gradle

## 📂 Estrutura do Projeto
* `Artista`: Entidade principal contendo atributos e lista de músicas.
* `Musica`: Entidade que representa a composição e sua relação com o artista.
* `ArtistaRepository`: Interface para abstração das consultas ao banco.
* `ConsultaGemini`: Classe de serviço responsável pela integração com a IA.
* `DotenvConfig`: Configuração para gerenciamento seguro de variáveis de ambiente.
* `MainArts`: Classe `CommandLineRunner` que centraliza o fluxo de interação com o usuário.

## ⚙️ Como Rodar o Projeto

1. **Pré-requisitos:**
   - Java 21 instalado na sua máquina.
   - Uma API Key do Google Gemini (você pode gerar [aqui](https://aistudio.google.com/)).

2. **Clonando o repositório:**
   ```bash
   git clone [https://github.com/IdelmarJr-dev/Music_Arts.git](https://github.com/IdelmarJr-dev/Music_Arts.git)
   cd Music_Arts
   
## 🔗 Referências

Este projeto foi desenvolvido como parte do treinamento de Java da Alura.

    https://github.com/alura-cursos/3355-java-desafio.git

Desenvolvido por [Idelmar Junior de Matos Cunha]

   
