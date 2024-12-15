public class Jogador {
    String nome;
    int gols;
    int redCards;

    public Jogador(String nome){
        this.nome = nome;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public void show(){
        System.out.println("\nJogador: " + this.nome);
        if (this.gols != 0) {
            System.out.println("Gols: " + this.gols);
        } else {
            System.out.println("Sem gols");
        }

        if (this.redCards != 0) {
            System.out.println("Cartões vermelhos: " + this.redCards);
        } else {
            System.out.println("Sem cartões vermelhos.");
        }


    }
}
