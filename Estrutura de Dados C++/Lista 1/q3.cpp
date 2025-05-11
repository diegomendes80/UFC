#include <vector>
#include <iostream>
using namespace std;

/*Reescreva os algoritmos InsertionSort e HeapSort de modo que receba como entrada um vetor A e ndices
 p <r e ordene o subvetor A[p,...,r].
 
        ----- AINDA NÃO FIZ COM O HEAPSORT --------
 */

class Sort{

    public:

    

    vector<int> insertionSort(vector<int>& v, int p, int r){
        int aux;

        for(int i=0; i <= r; i++){

          for(int j=i+1; j > p; j--){
            //se aux for menor que 
            if(v[j] < v[j-1]){
                aux = v[j-1];
                v[j-1] = v[j];
                v[j] = aux;
            }

          }
        }

        return v;
    }


    void imprimir(vector<int> v){
        for(int n : v){
            cout << n << ' ';
        }

        cout << endl;
    }
};


int main(){
    Sort sort;
    vector<int> u;
    u.push_back(2);
    u.push_back(5);
    u.push_back(1);
    u.push_back(9);
    u.push_back(7);
    vector<int> t = sort.insertionSort(u, 0, 2);
    
    sort.imprimir(t);

}