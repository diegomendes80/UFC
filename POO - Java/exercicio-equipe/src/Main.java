public class Main {
    public static void main(String[] args) {
        Jogador[] jogadoresGrupo1 = new Jogador[5];

        jogadoresGrupo1[0] = new Jogador("Jogador 1");
        jogadoresGrupo1[0].setGols(3);
        jogadoresGrupo1[0].setRedCards(1);

        jogadoresGrupo1[1] = new Jogador("Jogador 2");
        jogadoresGrupo1[1].setGols(5);
        jogadoresGrupo1[1].setRedCards(0);

        jogadoresGrupo1[2] = new Jogador("Jogador 3");
        jogadoresGrupo1[2].setGols(2);
        jogadoresGrupo1[2].setRedCards(2);

        jogadoresGrupo1[3] = new Jogador("Jogador 4");
        jogadoresGrupo1[3].setGols(0);
        jogadoresGrupo1[3].setRedCards(1);

        jogadoresGrupo1[4] = new Jogador("Jogador 5");
        jogadoresGrupo1[4].setGols(4);
        jogadoresGrupo1[4].setRedCards(0);

        // Criando o segundo array com 5 jogadores diferentes
        Jogador[] jogadoresGrupo2 = new Jogador[5];

        jogadoresGrupo2[0] = new Jogador("Jogador 6");
        jogadoresGrupo2[0].setGols(1);
        jogadoresGrupo2[0].setRedCards(3);

        jogadoresGrupo2[1] = new Jogador("Jogador 7");
        jogadoresGrupo2[1].setGols(0);
        jogadoresGrupo2[1].setRedCards(0);

        jogadoresGrupo2[2] = new Jogador("Jogador 8");
        jogadoresGrupo2[2].setGols(6);
        jogadoresGrupo2[2].setRedCards(0);

        jogadoresGrupo2[3] = new Jogador("Jogador 9");
        jogadoresGrupo2[3].setGols(2);
        jogadoresGrupo2[3].setRedCards(1);

        jogadoresGrupo2[4] = new Jogador("Jogador 10");
        jogadoresGrupo2[4].setGols(0);
        jogadoresGrupo2[4].setRedCards(4);


        Equipe equipe1 = new Equipe("Fortaleza", jogadoresGrupo1);
        Equipe equipe2 = new Equipe("Ceará", jogadoresGrupo2);

        equipe1.listarEquipe();
        equipe2.listarEquipe();

    }

}