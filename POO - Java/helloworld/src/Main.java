public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");


        int[] numeros = {2, 6, 1, 7, 3};
        int maiorNumero=0;
        int menorNumero=0;

        for(int i=0; i< numeros.length; i++){
            if(i==0) maiorNumero = numeros[0];
            else if(numeros[i] > maiorNumero) maiorNumero = numeros[i];

        }

        System.out.println(maiorNumero);


    }




}

