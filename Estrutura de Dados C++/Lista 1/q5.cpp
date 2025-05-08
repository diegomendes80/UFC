/* Escreva um algoritmo nao-recursivo de tempo O(n) que inverta uma lista simplesmente ligada de n
 elementos, sem criar mais memoria.*/

 #include <iostream>
#include <stack>
#include <string>
#include <cmath>
#include <vector>

using namespace std;


struct Node{
    int v;
    Node* prox;
};

class Lista{

    public:

    Node* fim;
    Node* inicio;

    Lista(){
        fim = nullptr;
        inicio = fim;


    }

    bool isEmpty(){
        if(fim == nullptr && inicio == nullptr) return true;
        else return false;
    }

    bool isFull(){
        try{
            Node* temp = new Node;
            delete temp;
            return false;
        }catch(bad_alloc exception){
            return true;
        }
    }

    void push(int v){
        if(isFull()) return;

        else if(isEmpty()){
            Node* node = new Node;
            node->v = v;
            node->prox = nullptr;

            inicio = node;
            fim = node;
        }

        else{
            Node* node = new Node;
            node->v = v;
            node->prox = nullptr;

            fim->prox = node;
            fim = node;
        }
    }

    void imprimirLista(){
        Node* temp = inicio;

        while(temp != nullptr){
            cout << temp->v <<", ";
            temp = temp->prox; 
        }

        cout << endl;
    }

    void inverter(){
        Node* anterior = nullptr;
        Node* atual = inicio;
        Node* proximo = nullptr;

        while(atual != nullptr){
            proximo = atual->prox;
            atual->prox = anterior;
            anterior = atual;
            atual = proximo;

        }

        fim = inicio;
        inicio = anterior;
    }

        
    

};




int main(){
    Lista l;

    l.push(1);
    l.push(2);
    l.push(3);
    l.push(4);
    l.push(5);

    l.imprimirLista();
    l.inverter();
    l.imprimirLista();
   

}