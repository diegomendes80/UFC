#include <iostream>


using namespace std;


/*Dados inteiros N e k < N, o Problema de Josephus consiste no seguinte: N homens estao em um crculo e
 comecam a se matar de k em k. Ou seja, comecando do homem numero 1, k 1 homens vivos sao pulados e o
 proximo e morto, e assim sucessivamente, ate que reste apenas k 1 homens vivos. Por exemplo, para k = 2,
 se N = 23456, os sobreviventes sao respectivamente os homens numero 1, 3, 1, 3 e 5. Faca um algoritmo
 usando uma lista circular que, recebendo como entrada inteiros N e k, retorne os sobreviventes.*/


struct Node{
    int v;
    Node* prox;
};


class Josephus{

    
    public:

    Node* fim;
    Node* inicio;
    int size=0;

    Josephus(){
        fim = nullptr;
        inicio = fim;
    }

     bool isEmpty(){
        if(fim == nullptr && inicio == nullptr) return true;
        else return false;
    }

     void push(int v){

        if(isEmpty()){
            Node* node = new Node;
            node->v = v;
            node->prox = node;

            inicio = node;
            fim = node;

        }

        else{
            Node* node = new Node;
            node->v = v;

            fim->prox = node;
            node->prox = inicio;
            fim = node;
        }

        size++;
    }

    void play(int k){

    
        Node* anterior = fim;
        Node* atual = inicio;

        while(size > k){
            for(int i=0; i < k; i++){
                anterior = atual;
                atual = atual->prox;
            }

            if(atual == inicio) inicio = atual->prox;
            if(atual == fim){
              fim = anterior;
              
            } 

            anterior->prox = atual->prox;
            delete atual;
            size--;

            atual = anterior->prox;
            
            
        }
        
        // fim->prox = inicio; 
    }

    void imprimirLista(){
        Node* temp = inicio;
        do {
            cout << temp->v << ", ";
            temp = temp->prox;
        } while (temp != inicio);
            cout << endl;
        }

};


int main(){
   Josephus j;
    for (int i = 1; i <= 7; i++) j.push(i);

    cout << "Inicial: ";
    j.imprimirLista();
    
    j.play(3);

    cout << "Sobreviventes: ";
    j.imprimirLista();
}