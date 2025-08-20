#include <iostream>
#include <vector>
#include <fstream>
#include <queue>
#include <functional>
#include <cfloat>

using namespace std;

#define M 3

struct Node{
    int valor[M]; //vetor que guarda as chaves M-1 chaves
    Node* filho[M+1]; //vetor que guarda os filhos M filhos
    bool folha;
    int n; //numero de chaves do no

    Node(bool f){folha = f; n=0;}

};

class ArvoreB {

    Node* raiz;


    public:

    ArvoreB(){
        raiz=nullptr;
    }

    void divideFilho(Node* pai, int i, Node* y){
        Node* z = new Node(y->folha);
        z->n = M / 2; // metade das chaves vai pra z (ex: se M=3, z->n = 1)

         for (int j = 0; j < M / 2; j++){
            z->valor[j] = y->valor[j + (M / 2) + 1];

        }

        if (!y->folha) {
            for (int j = 0; j < M / 2 + 1; j++)
                z->filho[j] = y->filho[j + (M / 2) + 1];
        }

        y->n = M / 2; // y agora tem só a metade inicial

          // Move os filhos do pai para abrir espaço
        for (int j = pai->n; j >= i + 1; j--)
            pai->filho[j + 1] = pai->filho[j];

        pai->filho[i + 1] = z;

        // Move as chaves do pai para abrir espaço
        for (int j = pai->n - 1; j >= i; j--)
            pai->valor[j + 1] = pai->valor[j];

        pai->valor[i] = y->valor[M / 2]; // valor do meio vai pro pai
        pai->n++;
    }

    void inserirNaoCheio(Node* x, int k) {
        int i = x->n - 1;

        if (x->folha) {
            // Move as chaves para abrir espaço
            while (i >= 0 && k < x->valor[i]) {
                x->valor[i + 1] = x->valor[i];
                i--;
            }
            x->valor[i + 1] = k;
            x->n++;
        } else {
            while (i >= 0 && k < x->valor[i])
                i--;

            i++; // achamos o filho certo

            if (x->filho[i]->n == M - 1) {
                divideFilho(x, i, x->filho[i]);

                if (k > x->valor[i])
                    i++;
            }

            inserirNaoCheio(x->filho[i], k);
        }

    }

    void insert(int v){
        if(raiz==nullptr){
            raiz = new Node(true);
            raiz->valor[0] = v;
            raiz->n = 1;
            return;
        }

        else if(raiz->n == M-1){
            Node* novaRaiz = new Node(false);

            novaRaiz->filho[0] = raiz;

            divideFilho(novaRaiz, 0, raiz);
            raiz = novaRaiz;
           

        }

         inserirNaoCheio(raiz, v);
    }


};