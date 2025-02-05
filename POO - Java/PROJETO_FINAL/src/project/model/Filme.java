package project.model;

public class Filme extends Midia {
    private int duracaoMinutos;
    private String diretor;


    public Filme(String titulo, String genero, int anoLancamento, int duracaoMinutos, String diretor) {
        super(titulo, genero, anoLancamento);
        this.duracaoMinutos = duracaoMinutos;
        this.diretor = diretor;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public String getDiretor() {
        return diretor;
    }

    @Override
    public void exibirDetalhes(){
        System.out.println("Filme: " + this.getTitulo());
        System.out.println("Gênero: " + this.getGenero());
        System.out.println("Duração: " + this.getDuracaoMinutos() + "min");
        System.out.println("Diretor: " + this.getDiretor());
        System.out.println("Ano Lançamento: " + this.getAnoLancamento());
    }
}
