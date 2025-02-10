package com.example.projeto_finalpoo.model;



public class Filme extends Midia {
    private String duracaoMinutos;
    private String diretor;


    public Filme(String titulo, String genero, String anoLancamento, String duracaoMinutos, String diretor) {
        super(titulo, genero, anoLancamento);
        this.duracaoMinutos = duracaoMinutos;
        this.diretor = diretor;
    }

    public String getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public String getDiretor() {
        return diretor;
    }

    @Override
    public void exibirDetalhes(){
        System.out.println("Filme: " + this.getTitulo());
        System.out.println("Gênero: " + this.getGenero());
        System.out.println("Duração: " + this.getDuracaoMinutos());
        System.out.println("Diretor: " + this.getDiretor());
        System.out.println("Ano Lançamento: " + this.getAnoLancamento());
    }
}
