package br.com.music.arts.principal;

import br.com.music.arts.model.Artista;
import br.com.music.arts.model.Musica;
import br.com.music.arts.model.TipoArtista;
import br.com.music.arts.repository.RepositoryMusic;
import br.com.music.arts.services.ConsultaGemini;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MainArts {
    private Musica music = new Musica();
    private Artista artista = new Artista();
    private Scanner scanner = new Scanner(System.in);
    private final RepositoryMusic repository;


    public MainArts(RepositoryMusic repository) {
        this.repository = repository;
    }

    public void Start () {
        var opcao = -1;
        while (opcao != 6) {

            System.out.print("""
                    Digite uma opção:
                    1 - Cadastrar artistas
                    2 - Cadastrar músicas
                    3 - Listar músicas
                    4 - Bucar músicas por artistas
                    5 - Pesquisar dados sobre um artista
                    6 - Sair
                    """);
            String entrada = scanner.nextLine();

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                continue;
            }
            switch (opcao){
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicas();
                    break;
                case 5:
                    pesquisar();
                    break;
                case 6:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");

            }
        }
    }

    private void cadastrarArtista() {
        System.out.println("Digite o nome do artista: ");
        var nome =  scanner.nextLine();
        if (nome.length() <= 20) {
            artista.setNome(nome);
            System.out.println("Digite a composição do artista: solo, dupla ou banda");
            var tipArtists = scanner.nextLine();
            artista.setTipo(TipoArtista.valueOf(tipArtists.toUpperCase()));
            repository.save(artista);
            System.out.println("Artista cadastrado com sucesso!");

        } else {
            System.out.println("O nome da Artista deve ter no maximo 20 caracteres.");
        }

    }

    private void cadastrarMusicas() {
        System.out.println("Digite o nome do artista: ");
        var nome = scanner.nextLine();
        if (nome.length() <= 20) {
            Optional<Artista> artista = repository.findByNomeContainingIgnoreCase(nome);
            if (artista.isPresent()) {
                System.out.println("Informe o título da música: ");
                var nomeMusica = scanner.nextLine();
                music.setNome(nomeMusica);
                music.setArtista(artista.get());
                artista.get().getMusicas().add(music);
                repository.save(artista.get());
                System.out.println("Musica cadastrada com sucesso!");

            } else {
                System.out.println("Artista não encontrado");
            }
        } else {
            System.out.println("O nome da musica deve ter no maximo 20 caracteres.");
        }
    }

    private void pesquisar() {
        System.out.println("Digite o nome de um Artista para a pesquisa: ");
        var nome = scanner.nextLine();
        if (nome.length() <= 20) {
            var descriptor = ConsultaGemini.obterTraducao(nome);
            System.out.println(descriptor.trim());
        } else {
            System.out.println("O nome da musica deve ter no maximo 20 caracteres.");
        }
    }

    private void buscarMusicas() {
        System.out.println("Digite o nome do artista: ");
        var nome = scanner.nextLine();
        if (nome.length() <= 20) {
            List<Musica> musicas = repository.buscaMusicasPorArtista(nome);
            musicas.forEach(System.out::println);
        } else {
            System.out.println("O nome da musica deve ter no maximo 20 caracteres.");
        }

    }

    private void listarMusicas() {
        System.out.println("Lista de músicas: ");
        List<Artista> artistaList = repository.findAll();
        artistaList.forEach(a -> a.getMusicas().forEach(System.out::println));

    }



}
