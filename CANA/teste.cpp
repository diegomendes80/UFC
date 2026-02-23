#include <iostream>
using namespace std;

int global = 30; // escopo global

int main() {
    int x = 10; // escopo de main

    {
        int y = 5; // escopo apenas deste bloco interno
        cout << x << " e " << y << endl;
    }

    // cout << y; // Erro: y não existe fora do bloco

    return 0;
}
