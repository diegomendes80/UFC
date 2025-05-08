#include <iostream>
#include <stack>
#include <string>
#include <cmath>
#include <vector>

using namespace std;


// Considere vetores que satisfazem a propriedade: o subvetor dos ndices mpares esta ordenado crescente
// mente e o dos ndices pares esta ordenado decrescentemente. Exemplo: A=[1 50 2 40 3 30 4 20 5 10]. Faca
// um algoritmo de tempo O(logn) que receba um vetor desse tipo e um inteiro x, e informe se x esta no vetor,
// retornando sua posicao, se for o caso.


class Solution{

    public:
    void find(vector<int> v, int x){
        vector<int> pares, impares;
        bool achou = false;

        //separando em dois vetores pra facilitar
        // for(int i=0; i < v.size(); i++){
        //    i%2 == 0 ? pares.push_back(v[i]) : impares.push_back(v[i]);
        // }

        //impares => crescente pares => decrescente
        int inicio = 0, fim = v.size() - 1;
        int meio;

        while(inicio <= fim){
             meio = (inicio+fim) / 2;
            int atual = impares[meio];

            if(atual == x){
                achou = true;
                break;
            }

            else if(x > atual){
                inicio = meio + 1;

            }

            else{
                fim = meio - 1;
            }


        }
        
        if(achou){
            cout << "achou, no " << meio+1 <<" dos vetores impares" << endl;
            return;

        }


        inicio = 0, fim = pares.size() - 1;
    
        //pares vem em ordem decrescente
        while(inicio <= fim){
             meio = (inicio+fim) / 2;
            int atual = pares[meio];

            if(atual == x){
                achou = true;
                break;
            }

            else if(x > atual){
                fim = meio - 1;
                
            }
            
            else{
                inicio = meio + 1;
            }


        }
            
        if(achou){
            cout << "achou, no " << meio+1 <<" dos vetores pares" << endl;
            return;

        }

        cout << "Numero nao encontrado" << endl;
        
    }

};



int main(){

    Solution s; 

    vector<int> v1;
    v1.push_back(10);
    v1.push_back(1);
    v1.push_back(8);
    v1.push_back(3);
    v1.push_back(6);
    v1.push_back(5);
    v1.push_back(4);
    v1.push_back(7);
    v1.push_back(2);
    v1.push_back(9);
    
    s.find(v1, 4);
    s.find(v1, 6);
    s.find(v1, 3);
    s.find(v1, 71);

}