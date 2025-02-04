import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Professor prof1 = new Professor("Sasaki", "Doutor", 7550);
        Professor prof2 = new Professor("Jonathan", "Doutor", 9960);

        Aluno a1 = new Aluno("Diego", 565585);
        Aluno a2 = new Aluno("João", 5655282);
        Aluno a3 = new Aluno("Pedro", 565583);
        Aluno a5 = new Aluno("José", 565782);
        Aluno a6 = new Aluno("Juliana", 567821);
        Aluno a7 = new Aluno("Rebeca", 565681);
        Aluno a8 = new Aluno("Maria", 565853);

        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos.add(a1);
        alunos.add(a2);
        alunos.add(a3);
        alunos.add(a5);


        Disciplina disciplina1 = new Disciplina("Física 2", 10, prof1);
        Disciplina disciplina2 = new Disciplina("Cálculo 2", 5, prof2, alunos);

        disciplina2.matricularAluno(a6);
        disciplina2.matricularAluno(a7);
        disciplina2.matricularAluno(a8);

        disciplina2.cancelarMatricula(565585);

        System.out.println(disciplina2.toString());

    }
}