public class CasaCondominio extends Imovel{
    private double valorCondominio;


    public CasaCondominio(int codigo, double areat, String finalidade, double valor, double valorCondominio) {
        super(codigo, areat, finalidade, valor);
        this.valorCondominio = valor;

    }

    public double getValorCondominio() {
        return valorCondominio;
    }

    @Override
    public void exibeInformacoes(){
        System.out.println();
        System.out.println("Casa em Condomínio, Código: " + this.getCodigo());
        System.out.println("Área total: " + this.getAreaTotal());
        System.out.println("Finalidade: " + this.getFinalidade());
        System.out.println("Valor estimado: " + this.getValor());
        System.out.println("Valor Condomínio: " +  this.getValorCondominio());
        System.out.println();
    }
}
