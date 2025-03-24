#include <iostream>

using namespace std;



//p chega apontando para x e fazemos apontar pra y
void valor_alocando_memoria(int* p){
    //o p aqui é uma cópia do ponteiro que é passado como argumento. Ou seja, ao modificar p, não estamos modificando o ponteiro original
    p = new int;
    *p = 10;

}


//aqui só altera o valor na posição de memoria x
void valor_modificando_memoria(int* p){
    *p = 8;
}

//Faz a mesma coisa do primeiro, mas pega p por referencia. p chega apontando para x e fazemos apontar pra y
void referencia(int*& p){
    //Já que p é passado por referência, ao modificar p, estamos modificando o ponteiro original
    p = new int;    
    *p = 9;
}


//essa função altera o vetor dentro e fora da função, pois quando passamos um vetor como argumento, estamos passando o endereço de memória do primeiro elemento do vetor
void alteraVetor(int* vetor, int tam) {
    for(int i=0; i<tam; i++) {
        vetor[i] = i;
    }
}

int main() {

    //declaração básica - alocação estática:

    int vetor[5]; //vetor de inteiros com 5 posições
    int vetor2[5] = {1, 2, 3, 4, 5}; //vetor de inteiros com 5 posições e valores iniciais
    int vetor3[] = {1, 2, 3, 4, 5}; //vetor de inteiros com 5 posições e valores iniciais   

    for(int i=0; i<5; i++) {
        cout << vetor2[i] << " ";
    }

    //Alocação dinâmica:

    int num_elem;
    cout << endl;
    cin >> num_elem;

    int* c = new int[num_elem]; //alocação dinâmica de um vetor de inteiros com num_elem posições

    for(int i=0; i<num_elem; i++) {
        c[i] = i;
    }

    for(int i=0; i<num_elem; i++) {
        cout << c[i] << " ";
    }


    delete[] c; //libera a memória alocada para o vetor c


    //--------------------------------------------

    //vetores, tanto esaticos como dinÂmicos, são ponteiros


    cout << endl << "Usando passagem de ponteiros em funcoes: " << endl;

    int* x = new int;
    *x = 5;

    valor_alocando_memoria(x);
    cout << *x << endl; //o valor impresso continuará sendo 5, pois a função valor_alocando_memoria não altera o valor de x


    valor_modificando_memoria(x);
    cout << *x << endl; //o valor impresso será 8, pois a função valor_modificando_memoria altera o valor de x

    referencia(x);
    cout << *x << endl; //o valor impresso será 9, pois a função referencia altera o valor de x


    delete x;

    int tam;
    cin >> tam;
    int* vetor_teste = new int[tam];
    alteraVetor(vetor_teste, tam);

    for(int i=0; i<tam; i++) {
        cout << vetor_teste[i] << " ";
    }

}

