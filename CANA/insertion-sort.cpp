#include <vector>
#include <iostream>
using namespace std;

//troca indice i de lugar com j
void troca(vector<int>& v, int i, int j) {
    int temp = v[i];
    v[i] = v[j];
    v[j] = temp;
}


void insertion_sort(vector<int>& v, int tamanho){
    int n = v[tamanho-1]; //pega o valor que deve ser inserido na parte ordenada
    int comparacao = tamanho -2; // indice do ultimo elemento da parte ordenada
   
    while(comparacao >= 0 && v[comparacao] > n){
        troca(v, comparacao+1, comparacao);
        comparacao--;
    }
    
}

int main()
{
 
    vector<int> v = {10, 2, 3, 15, 21, 6, 7, 9, 1, 4};

    for(int i=1; i < v.size(); i++){
        insertion_sort(v, i+1);
    }

    for(int i=0; i < v.size(); i++){
        cout << v[i] << ", ";
    }

}
