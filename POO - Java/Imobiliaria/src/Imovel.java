public class Imovel {
    protected int codigo;
    protected double areaTotal;
    protected String descricao;
    protected String finalidade;
    protected double valor;


    public Imovel(int codigo, double areat, String finalidade, double valor){
        this.codigo = codigo;
        this.areaTotal = areat;
        this.finalidade = finalidade;
        this.valor = valor;
    }

    public void exibeInformacoes(){

    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public double getValor() {
        return valor;
    }
}
