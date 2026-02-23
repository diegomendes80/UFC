#include <vector>
#include <iostream>
using namespace std;

int buscaBinaria(vector<int> vetor, int inicio, int fim, int v){

    if(fim == inicio) return -1;

    int meio = (inicio + fim) / 2;

    if(vetor[meio] == v) return meio;

    else if(vetor[meio] < v) return buscaBinaria(vetor, meio+1, fim, v);
    else  return buscaBinaria(vetor, inicio, meio-1,  v);

}


int main(){
    vector<int> vetor = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

    int valorProcurado = 11;

    int resultado = buscaBinaria(vetor, 0, vetor.size(), valorProcurado);

    cout << resultado << endl;
    

}