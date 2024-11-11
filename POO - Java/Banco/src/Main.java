public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        System.out.println(cliente.depositar(500));
        System.out.println(cliente.sacar(300));

    }
}

class User{
    String nome;
    String cpf;
    String cargo;
}

class Cliente extends User{
    Conta conta = new Conta();

    public void alterarCpf(String cpf){
        this.cpf = cpf;
    }

    public int sacar(int valorSacar){

        conta.saldo -= valorSacar;
        return conta.saldo;
    }


    public int depositar(int valorDepositar){
        conta.saldo += valorDepositar;
        return conta.saldo;
    }
}

class Conta{
    int tipoConta;
    int agencia;
    int saldo=0;

}

