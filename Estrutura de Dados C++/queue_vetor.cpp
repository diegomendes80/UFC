#include <iostream>
#include <stack>

using namespace std;
typedef int tipo;
const int MAX_ITENS = 100;

class Fila{
    private:
    int first;
    int last;
    tipo* vetor;

    public:
    
    Fila(){
        first = 0;
        last = 0;
        vetor = new tipo[MAX_ITENS];
    }

    ~Fila(){
        delete[] vetor;
    }

    bool isFull(){
        return last - first == MAX_ITENS;
    }

    bool isEmpty(){
        return first == last;
    }

    void inserir(tipo valor){
        
       if(!this->isFull()){
            vetor[last % MAX_ITENS] = valor;
            last++;
       }
    }

    tipo remover(){
        if(!this->isEmpty()){
            first++;
            return vetor[(first-1) % MAX_ITENS];
        }

    }




};