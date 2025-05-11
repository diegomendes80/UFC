#include <iostream>
#include <queue>
#include <stack>
#include <string>
using namespace std;

/*Escreva um algoritmo que receba uma expressao em notacao polonesa reversa e a converta para a notacao
 bem parentizada, usando uma pilha ou uma la. Faca o mesmo da notacao polonesa para a notacao bem
 parentizada.*/


class P{


    public:

   string polonToExp(const string& s) {
        stack<string> st;

        for (char ch : s) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                string b = st.top(); st.pop();
                string a = st.top(); st.pop();
                string expr = "(" + a + ch + b + ")";
                st.push(expr);
            } else {
                st.push(string(1, ch));  // converte char para string
            }
        }

        return st.top();
    }


    string expToPolon(string s){
           
        // string e;
        stack<string> st;
       
       for(char c : s){
            if(c == ')'){
                string b = st.top(); st.pop();
                string op = st.top(); st.pop();
                string a = st.top(); st.pop();

                string exp = a+b+op;
                st.push(exp);
            }

            else if(c != '(') st.push(string(1, c));
       }


       return st.top();
    }


};


int main(){
    P p;
    string c = "ab*cd*+";

    string r = p.polonToExp(c);
    cout << r << endl;

    string s = p.expToPolon(r);
    cout << s << endl;
}