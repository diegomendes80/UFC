package model;

import java.util.ArrayList;
import java.util.List;

public class Midia {
    private String titulo;
    private String genero;
    private String anoLancamento;
    List<Avaliacao> avaliacoes = new ArrayList<>();

    public Midia(String titulo, String genero, String anoLancamento) {
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public double getMediaNotas(){
        List<Double> notas = new ArrayList<>();

        if(avaliacoes.size() == 0) return 0;

        for(int i=0; i < avaliacoes.size(); i++){
            notas.add(avaliacoes.get(i).getNota());
        }

        double somaNotas = 0;

        for(int i=0; i<notas.size(); i++){
            somaNotas += notas.get(i);
        }

        double media = somaNotas / avaliacoes.size();
        //arredonda pra duas casas decimais
        return Math.round(media * 10.0) / 10.0;
    }



    public void setAvaliacao(Avaliacao avaliacao){
        avaliacoes.add(avaliacao);
    }

    public List<Avaliacao> getAvaliacoes(){
        return avaliacoes;
    }



}

