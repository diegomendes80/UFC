#include <iostream>
#include <stack>

using namespace std;

//implementando a pilha com vetor

typedef int tipo;
const int MAX_ITENS = 100;

class Pilha{
    private:
    int tamanho;
    tipo* vetor;


    public: 
    Pilha(){
        tamanho = 0;
        vetor = new tipo[MAX_ITENS];
    }

    ~Pilha(){
        delete[] vetor;
    }

    bool isFull(){
        return tamanho == MAX_ITENS;
    }

    bool isEmpty(){
        return tamanho == 0;
    }

    void push(tipo item){
        if(!isFull()){
            vetor[tamanho] = item;
            tamanho++;

        }
    }

    void pop(){
        if(!isEmpty()){
            vetor[tamanho-1] = NULL;
            tamanho--;
        }
    }

    void print(){
        cout << endl;
        for(int i = 0; i < tamanho; i++){
            cout << vetor[i] << " ";
        }
        cout << endl;

    }

    int getLength(){
        return tamanho;
    }
};


int main(){
    Pilha p;
    p.push(1);
    p.push(2);
    p.push(3);
    p.push(4);
    p.push(5);
    p.print();
    p.pop();
    p.print();
    cout << p.getLength() << endl;
    return 0;
}