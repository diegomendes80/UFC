
##### 30/10/24, Quarta-Feira

### Origem da Linguagem:

- Primeira versão em 1996, pela Sun Microsystems através do projeto Green
- 17 milhões de usuários em 2024, só superada pelo Python
- Vai além da linguagem. Java é uma **infraestrutura de programação** (multiplataforma)
- **Características:**
	-<span style="color:green">Simplicidade</span>
	-<span style="color:green">Robustez</span>
	-<span style="color:green">Segurança</span>
	-<span style="color:green">Portabilidade</span>
	-<span style="color:red">Verbosidade</span>
	-<span style="color:red">Desempenho</span>

#### Versões do Java:
1. J2ME => Dispositivos móveis e embarcados
2. J2S3 => Aplicações convencionais
3. J2EE => Web 


## Estrutura de uma classe no Java

```

	class Conta {
		//atributos:
		int numero; 
		float saldo; 
		
		//métodos:
		public void sacar(float valor){
			this.saldo -= valor;
		}
	}

	//o nome da classe principal deve ser, por convenção, o mesmo do arquivo
	class HelloWorld {
		public static void main(String s[]){
			//instanciando um objeto de Conta:
			Conta conta1 = new Conta();
		}
		
	}

```

#### <span style="color:red">Cuidado!</span>
````
//Fazer isso vai fazer o objeto1 apontar pro objeto2, então tudo que for alterado em objeto2 acarretará no outro;
objeto1 = objeto2;
```
