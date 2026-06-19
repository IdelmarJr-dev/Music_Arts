package br.com.music.arts.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 20, message = "O nome não pode exceder 20 caracteres")
    @Column(unique = true, length =  20, nullable = false)
    private String nome;
    private String dadosMusic;
    @ManyToOne
    private Artista artista;


    public Musica() {
    }

    public Musica(String nome) {
        this.nome = nome.toUpperCase();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDadosMusic() {
        return dadosMusic;
    }

    public void setDadosMusic(String dadosMusic) {
        this.dadosMusic = dadosMusic;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Titulo: " + getNome() + "Dados da Musica: ";
    }
}
