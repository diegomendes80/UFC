public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ProdutoNormal p1 = new ProdutoNormal("teste2", "aaa2", "bbb2", 1513, 250.50,"10/01/2027");
        ProdutoPerecivel p2 = new ProdutoPerecivel("teste", "aaa", "bbb", 1512, 15.00,"10/01/2026");


        System.out.println(p1.calculaPrecoPromocional());
        System.out.println(p2.calculaPrecoPromocional());

    }
}