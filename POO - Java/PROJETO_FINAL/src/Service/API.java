package Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;

public class API {
    private static final String ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNTY4N2Q4MzY2NGFjM2E0MmVhYTE3NTg4YmMxZTNhZSIsIm5iZiI6MTczODg1Mzg0Ni43LCJzdWIiOiI2N2E0Y2RkNmRmMzM2ZjM4YWI4NWJmMTAiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.vMUzOdwEUnPajIGJqtthksIx4_cTN_5UykVgZpgLgRM";

    public static String[] buscarFilme(String titulo) {
        try {
            // Codifica o título do filme para a URL
            String tituloFormatado = URLEncoder.encode(titulo, "UTF-8");
            String urlString = "https://api.themoviedb.org/3/search/movie?query=" + tituloFormatado + "&language=pt-BR";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Configurações da requisição
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);
            conn.setRequestProperty("Accept", "application/json");

            // Lê a resposta da API
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Converte para JSON
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray resultados = jsonResponse.getJSONArray("results");

            if (resultados.length() > 0) {
                JSONObject filme = resultados.getJSONObject(0);
                String nome = filme.getString("title");
                String capa = "https://image.tmdb.org/t/p/w500" + filme.optString("poster_path", "");
                String anoLancamento = filme.optString("release_date", "0000").substring(0, 4);
                int idFilme = filme.getInt("id");

                // Busca informações adicionais
                String genero = buscarGenero(idFilme);
                String diretor = buscarDiretor(idFilme);
                String duracao = buscarDuracao(idFilme);

                // Retorna os valores como um array de Strings
                return new String[]{nome, anoLancamento, genero, capa, diretor, duracao};
            } else {
                System.out.println("Nenhum filme encontrado.");
                return new String[]{"Nenhum filme encontrado", "", "", "", "", ""};
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new String[]{"Erro ao buscar filme", "", "", "", "", ""};
        }
    }

    // Busca um único gênero do filme pelo ID
    public static String buscarGenero(int idFilme) {
        try {
            String urlString = "https://api.themoviedb.org/3/movie/" + idFilme + "?language=pt-BR";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);
            conn.setRequestProperty("Accept", "application/json");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray generosArray = jsonResponse.getJSONArray("genres");

            // Retorna apenas o primeiro gênero, ou "Desconhecido" se a lista estiver vazia
            return generosArray.length() > 0 ? generosArray.getJSONObject(0).getString("name") : "Desconhecido";
        } catch (Exception e) {
            e.printStackTrace();
            return "Desconhecido";
        }
    }

    // Busca o diretor do filme pelo ID
    public static String buscarDiretor(int idFilme) {
        try {
            String urlString = "https://api.themoviedb.org/3/movie/" + idFilme + "/credits?language=pt-BR";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);
            conn.setRequestProperty("Accept", "application/json");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray crew = jsonResponse.getJSONArray("crew");

            // Procura o primeiro diretor na equipe de produção
            for (int i = 0; i < crew.length(); i++) {
                JSONObject pessoa = crew.getJSONObject(i);
                if (pessoa.getString("job").equals("Director")) {
                    return pessoa.getString("name");
                }
            }
            return "Desconhecido";
        } catch (Exception e) {
            e.printStackTrace();
            return "Desconhecido";
        }
    }

    // Busca a duração do filme pelo ID
    public static String buscarDuracao(int idFilme) {
        try {
            String urlString = "https://api.themoviedb.org/3/movie/" + idFilme + "?language=pt-BR";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);
            conn.setRequestProperty("Accept", "application/json");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            int runtime = jsonResponse.optInt("runtime", 0);

            return runtime > 0 ? runtime + " min" : "Desconhecido";
        } catch (Exception e) {
            e.printStackTrace();
            return "Desconhecido";
        }
    }
}
