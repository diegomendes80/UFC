#include <vector>
#include <iostream>
using namespace std;

class Sort{

    public:

    

    vector<int> insertionSort(vector<int>& v){
        int aux;

        for(int i=0; i < v.size(); i++){

          for(int j=i+1; j > 0; j--){
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
    u.push_back(6);
    u.push_back(7);
    vector<int> t = sort.insertionSort(u);
    
    sort.imprimir(t);

}