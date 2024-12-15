

public class Filme {
    String nome;
    Ator atorPrincipal;
    Ator atrizPrincipal;
    Ator atorCoadjuvante;
    Ator atrizCoadjuvante;


    public Filme(String nome, Ator atorp, Ator atrizp, Ator atorc, Ator atrizc){
        this.nome = nome;
        this.atorPrincipal = atorp;
        this.atrizPrincipal = atrizp;
        this.atorCoadjuvante = atorc;
        this.atrizCoadjuvante = atrizc;
    }

    public String getNome() {
        return nome;
    }

    public Ator getAtorPrincipal() {
        return atorPrincipal;
    }

    public Ator getAtrizPrincipal() {
        return atrizPrincipal;
    }

    public Ator getAtorCoadjuvante() {
        return atorCoadjuvante;
    }

    public Ator getAtrizCoadjuvante() {
        return atrizCoadjuvante;
    }

    public void exibeCast(){
        System.out.println(this.getNome());
        System.out.println("Ator principal: " + this.getAtorPrincipal().getNome() + "| Oscars: "  + this.getAtorPrincipal().getQtdOscars());
        System.out.println("Atriz principal:" + this.getAtrizCoadjuvante().getNome() + "| Oscars: "  + this.getAtrizPrincipal().getQtdOscars());
        System.out.println("Ator coadjuvante: " + this.getAtorCoadjuvante().getNome() + "| Oscars: "  + this.getAtorCoadjuvante().getQtdOscars());
        System.out.println("Atriz coadjuvante: " + this.getAtrizCoadjuvante().getNome() + "| Oscars: "  + this.getAtrizCoadjuvante().getQtdOscars());

        int totalOscars = atorPrincipal.getQtdOscars() + atrizPrincipal.getQtdOscars() + atorCoadjuvante.getQtdOscars() + atrizCoadjuvante.getQtdOscars();

        System.out.println("\nTotal de Oscars do elenco: " + totalOscars);
    }
}
