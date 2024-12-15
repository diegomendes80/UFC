public class Ator {
    private String nome;
    private int qtdOscars;

    public String getNome() {
        return nome;
    }

    public int getQtdOscars() {
        return qtdOscars;
    }

    public Ator(String nome){
        this.nome = nome;
    }

    public Ator(String nome, int qtdOscars){
        this.nome = nome;
        this.qtdOscars = qtdOscars;
    }
}
