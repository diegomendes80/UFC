#include <vector>
#include <iostream>
using namespace std;

#define SIZE_V 10

void maxHeapify(int v[], int n, int i){
    int m = i;
    int e = 2*i + 1;
    int d = 2*i + 2;

    if(e < n && v[e] > v[m]) m = e; //se o filho da esquerda estiver no intervalo de ordenação (< n) e for maior que o pai, troca o indidce

    if(d < n && v[d] > v[m]) m = d; //mesma coisa pro filho da direita

    if(m != i){
        swap(v[i], v[m]);

        maxHeapify(v, n, m); //chama recursivamente até toda a sub-arvore estar ordenada
    }

}

void heap_sort(int v[], int n){
    
    //criando a heap:
    for(int i= (n/2)-1; i >= 0; i--){
        maxHeapify(v, n, i);
    }

    //organizando o vetor mandando o maior da vez pro final:

    for(int i=n-1; i > 0; i--){
        swap(v[0], v[i]);

        maxHeapify(v, i, 0);
    }

    //imprime o vetor organizado: 

    for(int i=0; i < n; i++){
        cout << v[i] << ", ";
    }
}





int main(){
    int v[] = {10, 2, 3, 15, 21, 6, 7, 9, 1, 4};

    heap_sort(v, 10);

}