public class Main {
    public static void main(String[] args) {


        Ator CBale = new Ator("Christian Bale");
        Ator HLeadger = new Ator("Heath Leadger");
        HLeadger.setOscar(1);

        Filme batmanDarkKnight = new Filme("Batman o Cavaleiro das trevas", CBale, HLeadger );

        HLeadger.show();
    }
}