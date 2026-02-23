#include <iostream>
#include <vector>
using namespace std;

// Função para mesclar duas partes do vetor
void merge(vector<int>& v, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;
    vector<int> L(n1), R(n2);

    for (int i = 0; i < n1; i++) L[i] = v[l + i];
    for (int j = 0; j < n2; j++) R[j] = v[m + 1 + j];

    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) v[k++] = L[i++];
        else v[k++] = R[j++];
    }

    while (i < n1) v[k++] = L[i++];
    while (j < n2) v[k++] = R[j++];
}

// Merge Sort recursivo
void mergeSort(vector<int>& v, int l, int r) {
    if (l < r) {
        int m = l + (r - l) / 2;
        mergeSort(v, l, m);
        mergeSort(v, m + 1, r);
        merge(v, l, m, r);
    }
}

int main() {
    vector<int> v = {5, 2, 9, 1, 6, 3};

    mergeSort(v, 0, v.size() - 1);

    cout << "Vetor ordenado: ";
    for (int num : v) cout << num << " ";
    cout << endl;

    return 0;
}
