
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
    vector<vector<int>> adjM;
    vector<vector<int>> adjL;
    vector<int> vertices;
    

    public:

    //recebe uma lista e retorna a matriz
    grafo(string lista){

        ifstream arq(lista);
        arq >> Nvertices;
        
       
        adjM.resize(Nvertices, vector<int>(Nvertices, 0));
        vertices.resize(Nvertices);

         for (int j = 0; j < Nvertices; j++) {
            vertices[j] = j;
        }

        for(int i=0; i < Nvertices; i++){
            
            int grau;
            arq >> grau; 
        
            for(int j=0; j < grau; j++){
                int y;
                arq >> y;

                //coloca a adjajência logo pros dois
                adjM[i][y] = 1;
                adjM[y][i] = 1;

            }

        
        }

        
        arq.close();

    }

    //recebe matriz e retorna lista
    grafo(vector<vector<int>> matriz){
        Nvertices = matriz.size();
        adjL.resize(Nvertices);

        for(int i=0; i< Nvertices; i++){
            
            for(int j=0; j < Nvertices; j++){
                if(matriz[i][j] != 0){
                    adjL[i].push_back(j);
                }
            }
        }
    }

 


    void printADJL(){
        for(int i=0; i < Nvertices; i++){
            cout << i << " | ";
            for(int j=0; j < adjL[i].size(); j++){
                cout << adjL[i][j] << ' ';
            }

            cout << endl;
        }
    }

    vector<vector<int>> getAdjM(){
      return adjM;  
    } 



};

int main(){
    grafo g("../grafo.txt");

   // g.printADJM();
    
    grafo g2(g.getAdjM());

    g2.printADJL();
}