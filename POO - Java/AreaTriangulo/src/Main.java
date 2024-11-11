import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();

        double b = scanner.nextDouble();

        double c = scanner.nextDouble();

        if(a < 1 || b < 1 || c < 1) System.exit(1);

        double s = (a+b+c)/2.0;
        double area = Math.sqrt((s*(s-a)*(s-b)*(s-c)));

        System.out.println(area);



    }
}