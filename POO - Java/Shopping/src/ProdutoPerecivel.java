public class ProdutoPerecivel extends Produto{
    protected String dataValidade;

    public ProdutoPerecivel(String nome, String descricao, String fabricante, int codigo, double preco, String dataValidade) {
        super(nome, descricao, fabricante, codigo, preco);
        this.dataValidade = dataValidade;
    }

    @Override
    public double calculaPrecoPromocional(){
        return this.getPreco() * 0.15;
    }
}
