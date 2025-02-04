public class Professor  {
    private String nome;
    private String titulo;
    private double salario;

    public Professor(String nome, String titulo, double salario){
        this.nome = nome;
        this.titulo = titulo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getSalario() {
        return salario;
    }
}
