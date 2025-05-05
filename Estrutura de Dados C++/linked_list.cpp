#include <iostream>


using namespace std;

int main(){
    struct Node {
        int valor;
        Node* proximo;
    };

    Node* lista = nullptr; // Lista inicialmente vazia
    
  //  lista = new Node{10, nullptr}; // Nó com valor 10 e próximo igual a null

    Node* segundo = new Node{20, nullptr};  // Cria o segundo nó
    Node* primeiro = new Node{10, segundo}; // Cria o primeiro apontando para o segundo

    Node* lista = primeiro;



    
}