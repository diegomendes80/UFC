#include <iostream>
#include <queue>
#include <stack>
#include <string>
using namespace std;

/* Escreva uma implementacao de um deque, que e uma estrutura de dados com duas extremidades, que
 permite inserir e remover elementos em ambas as extremidades. Sua implementacao deve ter as operacoes
 Insert e Delete executando em tempo O(1). Sua implementacao deve ser feita usando um vetor de no maximo
 50 inteiros.*/
#define TAMANHO 50

class Deque{

    public:

    int deque[TAMANHO];
    int size;
    int firtsPosition;
    int lastPosition;
    
    Deque(){
        size = 0;
        firtsPosition = (TAMANHO)/2;
        lastPosition = firtsPosition-1;
    }

    bool isEmpty(){
        return size == 0;
    }

    bool isFull(){
        return size == TAMANHO;
    }

    void push_front(int v){
        if(isFull() || firtsPosition == 0) return;
        else{
            firtsPosition--;
            deque[firtsPosition] = v;
            size++;
            
        }
    }

    void push_back(int v){
        if(isFull() || lastPosition == (TAMANHO-1)) return;
        else{
            lastPosition++;
            deque[lastPosition] = v;
            size++;
            
        }
    }

    int pop_front(){
        if(!isEmpty())
        return deque[firtsPosition];
    }

    int pop_back(){
        if(!isEmpty())
        return deque[lastPosition];
    }


    void show(){
        for(int i = firtsPosition; i <= lastPosition; i++){
            cout << deque[i] << ' ';
        }
        cout << endl;
    }


} ;


int main(){
    Deque d;

    d.push_front(5);
    d.push_front(4);
    d.push_front(3);
    d.push_front(2);
    d.push_front(1);

    d.push_back(6);
    d.push_back(7);
    d.push_back(8);
    d.push_back(9);
    d.push_back(10);

    d.show();
}