import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private int totalVagas;
    Professor professor;
    ArrayList<Aluno> matriculados = new ArrayList<>();
    ArrayList<Aluno> listaEspera = new ArrayList<>();

    public Disciplina(String nome, int vagas, Professor professor){
        this.nome = nome;
        this.totalVagas = vagas;
        this.professor = professor;
    }

    public Disciplina(String nome, int vagas, Professor professor, ArrayList<Aluno> listaInscritos ){
        if(listaInscritos.size() > vagas){

            throw  new RuntimeException("ParametroInvalidoException");
        }
        else{
            this.nome = nome;
            this.totalVagas = vagas;
            this.professor = professor;

            for (Aluno aluno : listaInscritos) {
                if (totalVagas > 0) {
                    this.matriculados.add(aluno);
                    totalVagas--;
                }
                else{
                    this.listaEspera.add(aluno);
                }
            }

        }

    }

    public Aluno consultarAluno(int matricula){
        for(int i=0; i<matriculados.size(); i++){
            if(matriculados.get(i).getMatricula() == matricula){
                System.out.println("Aluno Matriculado!");
                return matriculados.get(i);
            }
        }

        for(int i=0; i<listaEspera.size(); i++){
            if(listaEspera.get(i).getMatricula() == matricula){
                System.out.println("Na lista de espera!");
                return listaEspera.get(i);
            }
        }


        throw  new RuntimeException("AlunoNaoMatriculadoException");

    }

    public void matricularAluno(Aluno aluno){
        try{
            consultarAluno(aluno.getMatricula());
            throw new RuntimeException("AlunoJaMatriculadoException");
        }
        catch(RuntimeException e){
            if (totalVagas > 0) {
                System.out.println("Aluno matriculado!");
                matriculados.add(aluno);
                totalVagas--;
            } else {
                System.out.println("Aluno na lista de espera!");
                listaEspera.add(aluno);
            }
        }
    }

    public void cancelarMatricula(int matricula){
       try{
           Aluno aluno = consultarAluno(matricula);

           if(matriculados.contains(aluno)){
               System.out.println("Aluno removido da turma!");
               matriculados.remove(aluno);
               matriculados.add(listaEspera.getFirst());
               listaEspera.removeFirst();


           }
           else if(listaEspera.contains(aluno)){
               listaEspera.remove(aluno);
               System.out.println("Aluno removido da lista de espera");
           }
       }catch (RuntimeException e){
           System.out.println(e);
       }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Disciplina: ").append(nome).append("\n");
        sb.append("Professor: ").append(professor.getTitulo()).append(" ").append(professor.getNome()).append("\n");
        sb.append("Número de alunos matriculados: ").append(matriculados.size()).append("\n\n");

        for (Aluno aluno : matriculados) {
            sb.append(aluno.getMatricula()).append(" - ").append(aluno.getNome()).append("\n");
        }

        sb.append("\nLista de Espera:\n");
        for (Aluno aluno : listaEspera) {
            sb.append(aluno.getMatricula()).append(" - ").append(aluno.getNome()).append("\n");
        }

        return sb.toString();
    }
}
