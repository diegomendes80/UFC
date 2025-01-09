public class Apartamento extends Imovel{
    private int andar;
    private String edificio;
    private boolean possuiElevador;


    public Apartamento(int codigo, double areat, String finalidade, double valor, int andar, String edificio, boolean elevador ) {
        super(codigo, areat, finalidade, valor);
        this.andar = andar;
        this.edificio = edificio;
        this.possuiElevador  = elevador;
    }


    public int getAndar() {
        return andar;
    }


    @Override
    public void exibeInformacoes(){
        System.out.println();
        System.out.println("Apartamento, Código: " + this.getCodigo());
        System.out.println("Edificio: " + this.getEdificio() + ", Andar: " + this.getAndar());
        System.out.println("Área total: " + this.getAreaTotal());
        System.out.println("Finalidade: " + this.getFinalidade());
        System.out.println("Valor estimado: " + this.getValor());
        System.out.println("Possui elevador? " + this.isPossuiElevador());
        System.out.println();

    }

    public String getEdificio() {
        return edificio;
    }

    public boolean isPossuiElevador() {
        return possuiElevador;
    }
}
