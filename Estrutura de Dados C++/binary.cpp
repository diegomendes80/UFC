#include <iostream>
#include <stack>
#include <string>
#include <cmath>

using namespace std;


class Convert{

    public:
    
     void decimalToBinary(int v){

        int quociente = v;
        string result;
        stack<char> s;

        while(quociente != 0){
            int resto = quociente%2; //0 ou 1
            quociente = quociente/2 >= 1 ? quociente/2 : 0;

            s.push(('0' + resto));

        }

        while(!s.empty()){
            cout << s.top();
            s.pop();
        }
    }

    int binaryToDecimal(string b){
        int result = 0;
        int count = 0;
        stack<char> s;
        

        //inverte a ordem dos bits
        for(int i=0; i < b.size(); i++){
            s.push(b[i]);
        }

        while(!s.empty()){
            if(s.top() == '1') result += pow(2, count);
            s.pop();
            count++;
        }

        return result;

    }
};



int main(){

    Convert convert;

    convert.decimalToBinary(379);
    cout << endl << convert.binaryToDecimal("101111010");
}