#include <iostream>
using namespace std;

#define TAMANHO 10

class Stack {
public:
    int v[TAMANHO];
    int top1 = -1;
    int top2 = TAMANHO;

    void push1(int x) {
        if (top1 + 1 == top2)return;
        
        top1++;
        v[top1] = x;
    }

    void push2(int x) {
       if (top1 + 1 == top2)return;
        top2--;
        v[top2] = x;
    }

    int pop1() {
        if (top1 == -1) {
            cout << " 1 vazia" << endl;
            return -1;
        }
        return v[top1--];
    }

    int pop2() {
        if (top2 == TAMANHO) {
            cout << "2 vazia" << endl;
            return -1;
        }
        return v[top2++];
    }


    void showStacks() {
        cout << "Pilha 1: ";
        for (int i = 0; i <= top1; i++) {
            cout << v[i] << " ";
        }
        cout << endl;

        cout << "Pilha 2: ";
        for (int i = TAMANHO - 1; i >= top2; i--) {
            cout << v[i] << " ";
        }
        cout << endl;
    }
};

int main() {
    Stack s;

    s.push1(10);
    s.push1(20);
    s.push1(30);

    s.push2(90);
    s.push2(80);
    s.push2(70);

    s.showStacks();

    s.pop1();
    s.pop2();

    s.showStacks();
}
