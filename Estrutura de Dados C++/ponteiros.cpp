#include <iostream>

using namespace std;

int main() {
    
    //primeira forma de declarar um ponteiro
    int alpha;
    int *pointer;

    pointer = &alpha; //pointer agora guarda o endereço de memória de alpha

    cout << pointer << endl;

    // ----------------------------------------------

    //segunda forma de declarar um ponteiro
    int *pointer2; 
    pointer2 = new int; // alocação dinâmica. pointer2 agora guarda o endereço de memória de um novo inteiro

    cout << pointer2 << endl;

    // ----------------------------------------------

    //Exemplos de operações com ponteiros
    bool* truth = new bool;
    *truth = true;  //atribui o valor true para o endereço de memória guardado por truth

    float* money = new float;
    *money = 100.50; //atribui o valor 100.50 para o endereço de memória guardado por money

    //acessa os valores guardados nos endereços de memória guardados por truth e money6
    cout << *truth << endl; 
    cout << *money << endl;

    *money = *money + 50.50; //soma 50.50 ao valor guardado no endereço de memória guardado por money
    cout << *money << endl;

    //nesse caso, fiz o ponteiro pointer apontar pro mesmo lugar que pointer2, mas para evitar vazamento de memória
    //devemos deletar o ponteiro pointer antes de fazer ele apontar para outro lugar
    delete pointer;
    pointer = pointer2;
    cout << pointer << endl;


}
