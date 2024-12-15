public class Equipe {
    String nome;
    Jogador[] jogadores;
    Jogador artilheiro;
    int mediaGols;

    public Equipe(String nome, Jogador[] jogadores){
        this.nome = nome;
        this.jogadores = jogadores;
    }

    public String getArtilheiro(){
        artilheiro = this.jogadores[0];

        for(int i=0; i < this.jogadores.length; i++){
            if(jogadores[i].getGols() > artilheiro.getGols()){
                artilheiro = jogadores[i];
            }

        }

        return artilheiro.nome;
    }

    public int getMediaGols(){
        int somaGols = 0;

        for(int i=0; i < this.jogadores.length; i++){
            somaGols += this.jogadores[i].getGols();
        }

        return somaGols/this.jogadores.length;
    }

    public void listarEquipe(){
            System.out.println("\nEquipe: " + this.nome);

        for(int i=0; i < this.jogadores.length; i++){
            this.jogadores[i].show();
        }
    }

}
