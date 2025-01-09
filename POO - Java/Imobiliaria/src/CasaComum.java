
public class CasaComum extends Imovel{
    private boolean esquina;


    public CasaComum(int codigo, double areat, String finalidade, double valor, boolean esquina) {
        super(codigo, areat, finalidade, valor);
        this.esquina = esquina;
    }

    public boolean isEsquina() {
        return esquina;
    }

    @Override
    public void exibeInformacoes(){
        System.out.println();
        System.out.println("Casa comum, Código: " + this.getCodigo());
        System.out.println("Área total: " + this.getAreaTotal());
        System.out.println("Finalidade: " + this.getFinalidade());
        System.out.println("Valor estimado: " + this.getValor());
        System.out.println("Casa de esquina? " + this.isEsquina());
        System.out.println();
    }
}
