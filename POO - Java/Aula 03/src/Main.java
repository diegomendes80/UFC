import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matricula = 0, maiorMatricula=0;
        float nota1, nota2, media=0, maiorMedia=0;


        while(true){
            System.out.println("P/ cadastrar um novo aluno digite a matrícula. P/ sair digite -1");
            matricula = scanner.nextInt();

            if(matricula == -1){
                System.out.println("\n");
                break;
            }
            else{

                nota1 = scanner.nextFloat();
                nota2 = scanner.nextFloat();
                media = (float) ((nota1 + nota2)/2.0);

                if(media > maiorMedia){
                    maiorMedia = media;
                    maiorMatricula = matricula;
                }

            }

        }

        System.out.println("A maior média: " + maiorMedia + "\nMatricula: " + maiorMatricula);


    }
}