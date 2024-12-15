public class Main {
    public static void main(String[] args) {

        Ator atorPrincipal = new Ator("Leonardo DiCaprio", 1);
        Ator atrizPrincipal = new Ator("Meryl Streep", 3);
        Ator atorCoadjuvante = new Ator("Brad Pitt", 2);
        Ator atrizCoadjuvante = new Ator("Emma Stone", 1);

        Filme lagoaAzul = new Filme("Lagoa Azul 2",atorPrincipal, atrizPrincipal, atorCoadjuvante, atrizCoadjuvante);

        lagoaAzul.exibeCast();

    }
}