public class Main {
    public static void main(String[] args) {

        CasaComum casa1 = new CasaComum(1265, 20, "Aluguel", 900.00, false);

        CasaComum casa2 = new CasaComum(1391, 15, "Venda", 100000, true);

        CasaCondominio casa3 = new CasaCondominio(2121, 25, "Aluguel", 1200, 250);

        SalaComercial sala1 = new SalaComercial(1234, 50, "Aluguel", 20000, true);

        SalaComercial sala2 = new SalaComercial(5151, 50, "Aluguel", 18000, false);

        Apartamento ap1 = new Apartamento(1250, 35, "Venda", 200000, 3, "Jardim Violetas", true);

        Imobiliaria imobiliaria = new Imobiliaria();
        imobiliaria.incluirImovel(casa1);
        imobiliaria.incluirImovel(casa2);
        imobiliaria.incluirImovel(casa3);
        imobiliaria.incluirImovel(sala1);
        imobiliaria.incluirImovel(sala2);
        imobiliaria.incluirImovel(ap1);

        //imobiliaria.consultarImovel(1250);
        //imobiliaria.listarAlugueis();
        imobiliaria.listarTipoImovel("CasaComum");





    }
}