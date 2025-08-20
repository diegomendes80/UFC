
#include <iostream>
#include <fstream>
#include <cfloat>
#include <stack>
#include <string>
#include <sstream>
#include <vector>
using namespace std;


//G = (v, a) vertices e arestas
//não direcionado = vai e volta
//direcionado = so vai ou so volta
//ordem = numero de vertices
//grau de um vertice = numero de arestas que saem de um vertice. Grau de entrada e grau de saida
class grafo{

   int Nvertices; // número de vértices
    int Narestas; // número de arestas
    vector<vector<int>> TadjL;
    vector<vector<int>> adjL;
    vector<int> vertices;
    

    public:

   
    grafo(string lista){

        ifstream arq(lista);
        if (!arq.is_open()) {
             cerr << "Erro ao abrir o arquivo: " << lista << endl;
            exit(1);
        }
        arq >> Nvertices;
        
        TadjL.resize(Nvertices);

      
        for(int i=0; i < Nvertices; i++){
            
            int grau;
            arq >> grau; 
        
            for(int j=0; j < grau; j++){
                int y;
                arq >> y;

                TadjL[y].push_back(i);

            }

        
        }

        
        arq.close();

    }

    

    void print(){
        for(int i=0; i < Nvertices; i++){
            cout << i << " | ";
            for(int j=0; j < TadjL[i].size(); j++){
                cout << TadjL[i][j] << ' ';
            }

            cout << endl;
        }
    }




};

int main(){
    grafo g("../../grafo2.txt");

   g.print();
  
}