#include <vector>
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




class Sort{

    public:
    Node* raiz = nullptr;
    

    vector<int> heapSort(vector<int>& v){
      
        // vector<int> aux;;
        Node*temp;
        queue<Node*> f;
        f.push(raiz);
        int c =0;

        while(!v.empty()){
            temp = f.front();
            if(c == 0) {
                temp->valor = v[c];
                temp->esquerda = nullptr;
                f.push(temp->esquerda);
                temp->direita = nullptr;
                f.push(temp->direita);
                continue;
                c++;
           
            }

           if(v[c] > temp->valor){
                int aux = temp->valor;

                temp->valor = v[c];

                if(aux < v[c+1]){
                    temp->esquerda->valor = aux;
                    f.pop();
                    tem
                }
                else{
                    temp->direita->valor = aux;
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
    vector<int> t = sort.heapSort(u);
    
    sort.imprimir(t);

}