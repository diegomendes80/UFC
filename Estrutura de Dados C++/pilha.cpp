#include <iostream>
#include <stack>

using namespace std;

int main() {
    //pilha é uma estrutura de dados do tipo LIFO (Last In First Out). ultima a entrar é a primeira a sair

    stack<int> pilha1;
    pilha1.push(3);
    pilha1.push(5);
    pilha1.push(7); //7 tá no topo da pilha

    pilha1.pop(); //remove o 7. 5 é o novo topo da pilha

}