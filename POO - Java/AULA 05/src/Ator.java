public class Ator{
    String nome;
    private int qtdOscars;

    public Ator(String nome){
        this.nome = nome;
        this.qtdOscars = 0;
    }

    public void setOscar(int qtd){
        this.qtdOscars = qtd;
    }

    public void show(){
        System.out.println("Ator: " + this.nome + "\n" + "Número de Oscars: " + this.qtdOscars);
    }

}
