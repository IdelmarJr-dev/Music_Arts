package br.com.music.arts.services;

import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// tipo post
public class ConsultaGemini {

    public static String obterTraducao(String texto) {
        // 1. Cole aqui a chave do seu último print
        Dotenv dotenv = Dotenv.load();

        String apiKey = dotenv.get("GEMINI_API_KEY");

        // 2. URL da API gratuita do AI Studio
        String url = "https://generativelanguage.googleapis.com/v1/models/gemini-2.5-flash:generateContent?key=" + apiKey;
        String json = """
                {
                  "contents": [{
                    "role": "user",
                    "parts":[{"text": "você é uma ferramenta profissional de música, me fale sobre o artista ou se for musica me 
                    diga a duração e o ano de lançamento(em caso de musica dê a resposta formatada dessa forma: duração: 0:00, ano de lançamento: 31/08/1999): %s"}]
                  }]
                }
                """.formatted(texto);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            int start = responseBody.indexOf("\"text\": \"");
            if (start == -1) return "Tradução não encontrada";

            start += 9;
            int end = responseBody.indexOf("\"", start);

            return responseBody.substring(start, end);
        } catch (Exception e) {
            return "Erro ao traduzir: " + e.getMessage();
        }
    }
}