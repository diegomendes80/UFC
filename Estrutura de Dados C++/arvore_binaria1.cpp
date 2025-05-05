#include <iostream>
#include <cstddef>
#include <queue>
#include <stack>

using namespace std;


struct Node{
    int valor;
    Node* esquerda;
    Node* direita;

};

class Arvore{
    Node* raiz;

    Arvore(){
        raiz = NULL;
    }

    ~Arvore(){
        deletarArvore(raiz);
        raiz = NULL;
    }

    void deletarArvore(Node* node){
        if(node == NULL) return;

        deletarArvore(node->esquerda); 
        deletarArvore(node->direita);
        
        delete node;
    }


    Node* obterRaiz(){
        return raiz;
    }

    bool isEmpty(){
        return raiz == NULL;
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

    void push(int valor){
        if(isFull()) return;

        Node* novo = new Node{valor, NULL, NULL};

        if (raiz == NULL) {
            raiz = novo;
            return;
        }


        queue<Node*> fila;
        fila.push(raiz); //coloca logo a raiz na fila pra ela poder entrar no while

        while(!fila.empty()){

            //pega o elemento da frente. No inciio é a raiz mas conforme o laço vai avançando  
            //vai adicionando os elementos mais abaixo da arvore
            Node* atual = fila.front(); 
            fila.pop();

            if(atual->esquerda == NULL){
                atual->esquerda = atual;
                return;
            }
            else{
                fila.push(atual->esquerda);
            }

            if(atual->direita == NULL){
                atual->direita = atual;
                return;
            }
            else{
                fila.push(atual->direita);
            }


        }

    }

    void pop(int valor){
        /** pra remover temos 3 casos:
            1) O nó a ser removido nao tem filhos (Nó folha): nesse caso, apenas removemos ele e setamos o ponteiro 
            do pai dele que apontava pra ele como null;

            2) O nó a ser removido tem um filhos: removemos ele, porém temos que fazer o pai desse elemento virar pai
            do filho dele

            3) O nó tem 2 filhos: temos que trocar o valor do que queremos remover por um sucessor. Nesse caso vou pegar o
            ultimo elemento da arvore pra ser o sucessor
            */
        
        if(isEmpty()) return;

        if (raiz == NULL) return;

        //caso 1: não tem filhos
        if (raiz->esquerda == NULL && raiz->direita == NULL) {
            if (raiz->valor == valor) {
                delete raiz;
                raiz = NULL;
            }
            return;
        }

        Node* alvo = NULL;
        Node* paiDoAlvo = NULL;
        Node* ultimo = NULL;
        Node* paiDoUltimo = NULL;


        queue<Node*> fila;
        fila.push(raiz);

        while(!fila.empty()){
            Node* atual = fila.front();
            fila.pop();

            //primeiro buscamos o alvo a ser removido:
            //quando encontra o alvo salva ele e o pai dele.
            //mesmo que o elemento nao  seja o alvo, salvamos o pai dele e ele e adicionamos na fila

            if (atual->esquerda) {
                if (atual->esquerda->valor == valor) {
                    alvo = atual->esquerda;
                    paiDoAlvo = atual;
                }

                paiDoUltimo = atual;
                ultimo = atual->esquerda;
                fila.push(atual->esquerda);
            }

            if (atual->direita) {
                if (atual->direita->valor == valor) {
                    alvo = atual->direita;
                    paiDoAlvo = atual;
                }
                
                paiDoUltimo = atual;
                ultimo = atual->direita;
                fila.push(atual->direita);
            }
           
           

        }

        if (alvo == NULL) return; // valor não encontrado

        //agora tratamos o caso 1:
        if(alvo->esquerda == NULL && alvo->direita == NULL){
            if(paiDoAlvo->esquerda == alvo){
                paiDoAlvo->esquerda = NULL;
            
            }
            else{
                paiDoAlvo->direita = NULL;
            }

            delete alvo;
        }

        //caso 2: nó tem 1 filho
        else if(alvo->esquerda != NULL || alvo->direita != NULL){
            Node* filho = (alvo->esquerda != NULL) ? alvo->esquerda : alvo->direita;

            if(paiDoAlvo->esquerda == alvo){
                paiDoAlvo->esquerda = filho;
            
            }
            else{
                paiDoAlvo->direita = filho;
            }


            delete alvo;
        }

        //caso 3: 2 filhos

        else{
            alvo->valor = ultimo->valor;

            // Remove o último nó
            if (paiDoUltimo->esquerda == ultimo){
                paiDoUltimo->esquerda = NULL;

            }
            else{
            paiDoUltimo->direita = NULL;
            
            }

            delete ultimo;
        }
    
    }


    bool search(int valor){
        
        Node* atual;

        queue<Node*> fila;
        fila.push(raiz);

        while(!fila.empty()){
            atual = fila.front();
            fila.pop();

            if(atual->valor == valor) return true;

            if(atual->esquerda){
                fila.push(atual->esquerda);
            }

            if(atual->direita){
                fila.push(atual->direita);
            }
        }

        return false;
    }

    void preOrdem(Node* node){
        //vai da raiz e percorre toda a esquerda, depois toda a direita

        stack<Node*> fila;
        fila.push(node); //esse node geralmente é a raiz

        Node* atual;

        while(!fila.empty()){
            atual = fila.top();
            fila.pop();

            cout << atual->valor << endl;

            if(atual->direita) fila.push(atual->direita);
            if(atual->esquerda) fila.push(atual->esquerda);


        }
    }

    void emOrdem(Node* node){
        stack<Node*> pilha;
        Node* atual = node;

        while(!pilha.empty() || node != NULL){
            
            while(atual != NULL){
                pilha.push(atual);
                atual = atual->esquerda;
            }

            // Processa o nó
            atual = pilha.top();
            pilha.pop();
            cout << atual->valor << endl;

            // Vai para a subárvore direita
            atual = atual->direita;
        }
    }

    void posOrdem(Node* node){
        if (node == NULL) return;

        stack<Node*> pilha1, pilha2;
    
        pilha1.push(node);

        //pilha2 é usada pra inverter a ordem de pilha 1. pilha 1 é uma pre-ordem

        while(!pilha1.empty()){
            Node* atual = pilha1.top();
            pilha1.pop();

            pilha2.push(atual);

            if(atual->esquerda) pilha1.push(atual->esquerda);
            if(atual->direita) pilha1.push(atual->direita);
        }

        while(!pilha2.empty()){
            Node* atual = pilha2.top();

            cout << atual->valor << endl;

            pilha2.pop();
        }
    }



};