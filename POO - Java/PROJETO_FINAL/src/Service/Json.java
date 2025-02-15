package Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Midia;


import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Json {

    String caminhoFilmes = System.getProperty("user.dir") + "/src/Service/todosFilmes.json";
    String caminhoSeries = System.getProperty("user.dir") + "/src/Service/todasSeries.json";
    Gson gson = new Gson();
    Type listType = new TypeToken<List<Midia>>() {}.getType(); //avisa pro json que ele sera convertido em um list
    List<Midia> filmes = JSONtoLIST(caminhoFilmes);
    List<Midia> series = JSONtoLIST(caminhoSeries);

    //carrega os elementos do json na lista java
    private List<Midia> JSONtoLIST(String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            List<Midia> lista = gson.fromJson(reader, listType);
            return lista != null ? lista : new ArrayList<>();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //converte de uma lista pro arquivo json
    private void LISTtoJSON(List<Midia> lista, String caminhoArquivo) {
        Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            gsonPretty.toJson(lista, writer); // Salva a lista no arquivo com formatação
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void salvaMidia(Midia midia, String lista){
        AtomicReference<Boolean> jaExiste = new AtomicReference<>(false);

        if(lista.equals("Filmes")){

            filmes.forEach(e -> {
                if(e.getTitulo().equals(midia.getTitulo())) {
                    jaExiste.set(true);
                }
            });

            if(!jaExiste.get()){
                filmes.add(midia);
                //atualiza o arquivo JSON com a nova midia
                LISTtoJSON(filmes, caminhoFilmes);
            }
        }
        else if(lista.equals("Séries")){
            series.forEach(e -> {
                if(e.getTitulo().equals(midia.getTitulo())) jaExiste.set(true);
            });

            if(!jaExiste.get()){
                series.add(midia);
                //atualiza o arquivo JSON com a nova midia
                LISTtoJSON(series, caminhoSeries);

            }
            }


    }

    public void atualizaMidia(Midia midia, String lista){
        if(lista.equals("Filmes")){
            for (int i = 0; i < filmes.size(); i++) {
                if (filmes.get(i).getTitulo().equals(midia.getTitulo())) {
                    // Atualiza o objeto na lista
                    filmes.set(i, midia);
                    // Salva a lista atualizada no arquivo JSON
                    LISTtoJSON(filmes, caminhoFilmes);
                    break;
                }
            }
        } else if (lista.equals("Séries")) {
            for (int i = 0; i < series.size(); i++) {
                if (series.get(i).getTitulo().equals(midia.getTitulo())) {
                    // Atualiza o objeto na lista
                    series.set(i, midia);
                    // Salva a lista atualizada no arquivo JSON
                    LISTtoJSON(series, caminhoSeries);
                    break;
                }
            }
        }
    }

}


