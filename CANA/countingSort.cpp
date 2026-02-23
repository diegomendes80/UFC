#include <iostream>
using namespace std;

void countingSort(int A[], int n, int k) {
    int C[k];     // contador
    int B[n];     // saída

    // Inicializa contador
    for(int i = 0; i < k; i++)
        C[i] = 0;

    // Conta ocorrências
    for(int j = 0; j < n; j++)
        C[A[j]]++;

    // Soma acumulada
    for(int i = 1; i < k; i++)
        C[i] += C[i - 1];

    // Monta o vetor ordenado (de trás pra frente)
    for(int j = n - 1; j >= 0; j--) {
        B[C[A[j]] - 1] = A[j];
        C[A[j]]--;
    }

    // Copia resultado para A
    for(int i = 0; i < n; i++)
        A[i] = B[i];
}

int main() {
    int A[] = {4, 2, 2, 8, 3, 3, 1};
    int n = sizeof(A) / sizeof(A[0]);
    int k = 9;  // valores de 0 a 8

    countingSort(A, n, k);

    cout << "Sorted array: ";
    for(int i = 0; i < n; i++)
        cout << A[i] << " ";
}
