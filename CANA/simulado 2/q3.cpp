#include <vector>
#include <iostream>
using namespace std;

int minimo(int a, int b){
    return (a < b) ? a : b;
}

// Função recursiva com índices
int kthSmallest(const vector<int>& x, int startX, int n,
                const vector<int>& y, int startY, int m, int k) {
    // Casos base
    if (n == 0) return y[startY + k - 1];
    if (m == 0) return x[startX + k - 1];
    if (k == 1) return minimo(x[startX], y[startY]);

    int i = minimo(k / 2, n);
    int j = k - i;

    if (x[startX + i - 1] < y[startY + j - 1]) {
        return kthSmallest(x, startX + i, n - i, y, startY, m, k - i);
    } else if (x[startX + i - 1] > y[startY + j - 1]) {
        return kthSmallest(x, startX, n, y, startY + j, m - j, k - j);
    } else {
        return x[startX + i - 1];
    }
}

int main() {
    vector<int> X = {1, 3, 5, 7};
    vector<int> Y = {2, 4, 6, 8};
    int k = 5;

    cout << "O " << k << "-esimo menor elemento é: "
         << kthSmallest(X, 0, X.size(), Y, 0, Y.size(), k) << endl;

    return 0;
}
