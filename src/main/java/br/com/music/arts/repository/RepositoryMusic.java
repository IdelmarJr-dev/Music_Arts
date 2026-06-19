package br.com.music.arts.repository;

import br.com.music.arts.model.Artista;
import br.com.music.arts.model.Musica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RepositoryMusic extends JpaRepository<Artista, Long> {
    Optional<Artista> findByNomeContainingIgnoreCase(String nome);
    // Adaptada para uso do H2, O H2 é um banco de dados embutido (embedded), muito utilizado em ambiente de desenvolvimento por ser leve e rodar dentro da JVM.
    /*
    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nome ILIKE %:nome%")
    List<Musica> buscaMusicasPorArtista(String nome);
     */
    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE UPPER(a.nome) LIKE UPPER(CONCAT('%', :nome, '%'))")
    List<Musica> buscaMusicasPorArtista(@Param("nome") String nome);


}
