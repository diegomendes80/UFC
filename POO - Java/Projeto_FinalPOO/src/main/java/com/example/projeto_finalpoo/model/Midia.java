package com.example.projeto_finalpoo.model;


import java.util.List;

public abstract class Midia {
    private String titulo;
    private String genero;
    private String anoLancamento;
    List<Avaliacao> avaliacoes;

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

    public double getMediaNotas(List<Double> notas){
        int somaNotas = 0;
        for(int i=0; i<notas.size(); i++){
            somaNotas += notas.get(i);
        }

        return somaNotas/notas.size();
    }

    public void exibirDetalhes(){}

    public void setAvaliacao(Avaliacao avaliacao){
        avaliacoes.add(avaliacao);
    }

    public List<Avaliacao> getAvaliacoes(){
        return avaliacoes;
    }



}

