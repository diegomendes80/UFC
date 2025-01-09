public class SalaComercial extends Imovel{

    private boolean possuiBanheiroPrivativo;

    public SalaComercial(int codigo, double areat, String finalidade, double valor, boolean banheiro) {
        super(codigo, areat, finalidade, valor);
        this.possuiBanheiroPrivativo = banheiro;

    }

    public boolean isPossuiBanheiroPrivativo() {
        return possuiBanheiroPrivativo;
    }

    @Override
    public void exibeInformacoes(){
        System.out.println();
        System.out.println("Sala comercial, Código: " + this.getCodigo());
        System.out.println("Área total: " + this.getAreaTotal());
        System.out.println("Finalidade: " + this.getFinalidade());
        System.out.println("Valor estimado: " + this.getValor());
        System.out.println("Possui banheiro privativo? " + this.isPossuiBanheiroPrivativo());
        System.out.println();
    }
}
