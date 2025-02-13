public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String[] filme = API.buscarFilme("Interestelar");

        for(String s : filme){
            System.out.println(s);
        }

    }
}