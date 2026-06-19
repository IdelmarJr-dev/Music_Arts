package br.com.music.arts;

import br.com.music.arts.principal.MainArts;
import br.com.music.arts.repository.RepositoryMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtsApplication implements CommandLineRunner {
	@Autowired
	private RepositoryMusic repository;

	public static void main(String[] args) {
		SpringApplication.run(ArtsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MainArts mainArts = new MainArts(repository);
		mainArts.Start();
	}
}
