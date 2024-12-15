public class Municipio {
    String nome;
    int populacao;
    int area;
    int pib;
    Prefeito prefeitoAtual;

    public Municipio(String nome, int populacao, int area, int pib, Prefeito prefeitoAtual) {
        this.nome = nome;
        this.populacao = populacao;
        this.area = area;
        this.pib = pib;
        this.prefeitoAtual = prefeitoAtual;
    }

    public int getDensidadeDemografica(){
        return populacao/area;
    }

    public int getPibPerCapita(){
        return pib/populacao;
    }

    public String getNome() {
        return nome;
    }

    public int getPopulacao() {
        return populacao;
    }

    public int getArea() {
        return area;
    }

    public int getPib() {
        return pib;
    }

    public Prefeito getPrefeitoAtual() {
        return prefeitoAtual;
    }
}
