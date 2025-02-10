package com.example.projeto_finalpoo.model;


import java.util.List;

public class Serie extends Midia{
    private int qtdTemporadas;
    List<String> showrunners;

    public Serie(String titulo, String genero, String anoLancamento, int qtdTemporadas, List<String> showrunners) {
        super(titulo, genero, anoLancamento);
        this.qtdTemporadas = qtdTemporadas;
        this.showrunners = showrunners;
    }

    public List<String> getShowrunners() {
        return showrunners;
    }

    public int getQtdTemporadas() {
        return qtdTemporadas;
    }


}
