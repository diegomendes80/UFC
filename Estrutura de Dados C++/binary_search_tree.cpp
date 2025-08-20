#include <vector>
#include <iostream>
using namespace std;


struct Node{
    int valor;
    Node* direita;
    Node* esquerda;
    Node* pai;

};


class Binary_Tree{

    
    
    public:
    
    Node* raiz;
    Binary_Tree(){
        raiz = nullptr;
    }

  void push(int v){
    Node* n = new Node;
    n->valor = v;
    n->esquerda = nullptr;
    n->direita = nullptr;
    n->pai = nullptr; 

    if (raiz == nullptr) {
        raiz = n;
        return;
    }

    Node* temp = raiz;
    while (true) {
        if (v < temp->valor) {
            if (temp->esquerda == nullptr) {
                temp->esquerda = n;
                n->pai = temp; 
                break;
            }
            temp = temp->esquerda;
        }
        else {
            if (temp->direita == nullptr) {
                temp->direita = n;
                n->pai = temp; 
                break;
            }
            temp = temp->direita;
        }
    }
}

    bool find(int v){
        if(raiz == nullptr) return false;

        Node* temp = raiz;

        while(true){
            if(v == temp->valor) return true;

            else if(v > temp->valor){
                if(temp->direita == nullptr) return false;
                else {
                    temp = temp->direita;
                }
            }

            else{
                if(temp->esquerda == nullptr) return false;
                else {
                    temp = temp->esquerda;
                }
            }
        }
    }

    Node* min(Node* p){
        

        while(p->esquerda != nullptr){
            p = p->esquerda;
        }

        return p;
    }

    Node* max(Node* p){

        while(p->direita != nullptr){
            p = p->direita;
        }
        
        return p;
    }

    void deleteTree(Node* p){
        if(p == nullptr) return;

        deleteTree(p->esquerda);
        deleteTree(p->direita);

        delete p;
    }

    Node* sucessor(Node* p){
        if(max(p) == p) return nullptr;


        else{
            if(p->direita != nullptr) return min(p->direita);

            else{
                Node* sucessor;
                Node* atual = raiz;

                while(atual != nullptr){
                    if(p->valor < atual->valor){
                        sucessor = atual;
                        atual = atual->esquerda;
                    }

                    else if(p->valor > atual->valor){
                        atual = atual->direita;
                    }

                    else{
                        return sucessor;
                    }
                }
            }
        }

    }

    Node* predecessor(Node* p){
      
            if(p->esquerda != nullptr) return max(p->esquerda);

            else{
                Node* atual = raiz;
                Node* predecessor;
               
                while(atual != nullptr){
                    if(p->valor > atual->valor){
                        predecessor = atual;
                        atual = atual->direita;
                    }

                    else if(p->valor < atual->valor){
                        atual = atual->esquerda;
                    }

                    else{
                        return predecessor;
                    }
                }
            }

         return nullptr;
        
    }

    //troca p por q na arvore
    void swicth(Node* p, Node* q){
        if(p == nullptr) return;

        if(p->pai == nullptr){
            raiz = q;
        }

        else if(p == p->pai->esquerda){
            p->pai->esquerda = q;
        }

        else if(p == p->pai->direita){
            p->pai->direita = q;
        }

        if(q != nullptr){
            q->pai = p->pai;
        }

    }

    void pop(Node* p){
        if (p == nullptr)return;
        
        if(p->esquerda == nullptr){
            swicth(p, p->direita);
        }

        else if(p->direita == nullptr){
            swicth(p, p->esquerda);
        }

        else{
            Node* suc = sucessor(p);
            if(suc->pai != p){
                swicth(suc, suc->direita);
                suc->direita = p->direita;
                suc->direita->pai = suc;
            }
        }

    }

};


int main(){
    Binary_Tree b;
    b.push(7);
    b.push(5);
    b.push(3);
    b.push(4);
   

    cout << b.find(4) << endl;
    cout << b.min(b.raiz) <<endl;
    cout << b.max(b.raiz) <<endl;
}