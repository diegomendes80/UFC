#include <iostream>
#include <cstddef>

using namespace std;

typedef int tipo;

struct Node{
    tipo value;
    Node* next;
};

class PilhaDinamica{
    private:

    Node* top;

    public:

    PilhaDinamica(){
        top = NULL;
    }

    ~PilhaDinamica(){

    }

    bool isEmpty(){
        return top == NULL;
    }

    bool isFull(){
        Node* NewNode;

        try{
            NewNode = new Node;
            delete NewNode;
            return false;
        }catch(bad_alloc exception){
            return true;
        }
    }

    void push(tipo v){
        if(!isFull()){
            Node* NewNode = new Node{v, top}; //adiciona uma nova struct que é um novo nó e seta o valor como v e aponta pro top antigo
            top = NewNode; //agora esse novo nó passa a ser o topo. Caso adicione outro elemento ele irá apontar pra esse nó aqui

        }
    }

    tipo pop(tipo v){
        if(!isEmpty()){
            Node* TempNode; 
            TempNode = top; 
            tipo item = top->value;
            top = top->next;

            delete TempNode;

            return item;
        }
    }

};