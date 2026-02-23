#include <vector>
#include <iostream>
using namespace std;

// //Dado um vetor ordenado de inteiros distintos A[1,...,n] , você quer saber se existe um
//  índice i para o qual A[i] = i. Apresente um algoritmo que execute em O(log n) para resolver esse
//  problema.

void busca(vector<int> vec, int inicio, int fim){
    if(inicio == fim) return;

    int meio = (inicio + fim) / 2;

    if(vec[meio] == meio){
        cout << meio << endl;
        return;
    }

    else if(vec[meio] > meio){
        busca(vec, inicio, meio - 1);
    }
    else{
        busca(vec, meio + 1, fim);
    }

}


int main(){

    vector<int> v = {1, 1, 3, 5 };

    busca(v, 0, v.size()-1);

}