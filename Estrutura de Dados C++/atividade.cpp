#include <iostream>
#include <vector>
#include <fstream>
#include <queue>
#include <functional>
#include <cfloat>

using namespace std;

class Grafo {
public:
    int N; // número de vértices
    int M; // número de arestas
    vector<vector<int>> adjL;
    vector<vector<double>> peso;

    Grafo() {
        N = M = 0;
        ifstream arq("../grafo.txt");
        if (!arq) {
            cerr << "Erro ao abrir o arquivo.\n";
            return;
        }

        arq >> N;
        adjL.resize(N);
        peso.resize(N);

        int grau, y;
        for (int x = 0; x < N; x++) {
            arq >> grau;
            M += grau;
            for (int k = 0; k < grau; k++) {
                arq >> y;
                adjL[x].push_back(y);
                peso[x].push_back(1.0);

                adjL[y].push_back(x);
                peso[y].push_back(1.0);
            }
        }

        arq.close();
    }

    void dijkstra(int s) {
        if (N <= 0) return;

        vector<int> pai(N, -1);
        vector<int> ok(N, 0);
        vector<double> dist(N, DBL_MAX);
        dist[s] = 0;

        // priority_queue é usada para pegar sempre o próximo vértice
        // com a menor distância conhecida, de forma eficiente.
        // Sse fosse usado for com for  resultaria em um algoritmo muito mais lento (O(N^2)).
        // Com priority_queue, conseguimos fazer isso em O(log N).

        priority_queue<pair<double, int>, vector<pair<double, int>>, greater<>> pq;
        pq.push({0.0, s});

        while (!pq.empty()) {
            int x = pq.top().second;
            pq.pop();

            if (ok[x]) continue;
            ok[x] = 1;

            for (int j = 0; j < adjL[x].size(); j++) {
                int y = adjL[x][j];
                double p = peso[x][j];
                if (!ok[y] && dist[y] > dist[x] + p) {
                    dist[y] = dist[x] + p;
                    pai[y] = x;
                    pq.push({dist[y], y});
                }
            }
        }

        cout << "Vertices:  ";
        for (int i = 0; i < N; i++) cout << i << " ";
        cout << "\n";

        cout << "Distancia: ";
        for (int i = 0; i < N; i++) {
            if (dist[i] < DBL_MAX)
                cout << dist[i] << " ";
            else
                cout << "inf ";
        }
        cout << "\n";
    }
};

int main() {
    Grafo G;

    cout << "-----------------------------------------------------------\n";
    cout << "Algoritmo de Dijkstra (distancias do vertice 4 p/ demais): \n";
    cout << "-----------------------------------------------------------\n";
    G.dijkstra(4);

    return 0;
}
