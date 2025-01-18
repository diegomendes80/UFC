public class ProdutoNormal extends Produto{
    protected String acondicionamento;

    public ProdutoNormal(String nome, String descricao, String fabricante, int codigo, double preco, String acondicionamento) {
        super(nome, descricao, fabricante, codigo, preco);
        this.acondicionamento = acondicionamento;
    }

    @Override

    public double calculaPrecoPromocional(){
        return  this.getPreco() * 0.7;
    }
}
