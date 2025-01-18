public abstract class Produto {
    protected  String nome;
    protected String descricao;
    protected String fabricante;
    protected  int codigo;
    protected double preco;

    public Produto(String nome, String descricao, String fabricante, int codigo, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.fabricante = fabricante;
        this.codigo = codigo;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public abstract double calculaPrecoPromocional();

}
