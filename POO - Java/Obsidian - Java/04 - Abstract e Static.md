
### Métodos e parâmetro Static
* **Parâmetro Static** é um valor que fica fixo para toda a classe e todos os objetos que forem gerados dela. 

	`Public class Jogador{
		private static int MAX_LIVES = 5;
	}`

	Dessa maneira, MAX_LIVES é o mesmo para todos os objetos que forem gerados de Jogador.

* **Método Static** é um método que não depende de um objeto individual para ser usado.  Assim, ele pode ser acessado usando a referência da própria classe.

	`Public class Math{
		``public static int soma(int A, int B){
			`return A + B`;
		}`
	}`

	Assim, o método soma pode ser acessado por qualquer classe sem precisar instanciar um objeto (Math.soma). 
		OBS: um método static só pode usar dentro dele atributos statics


### Classes e métodos Abstract

* **Classe Absctract** é uma classe em que não será preciso instanciar objetos dela. Basicamente, ela só vai servir para ser herdada por outras classes. Ela pode ter tanto atributos quanto métodos normais ou métodos abstracts.

* **Método Abstract** é aquele que só é definido em uma classe abstract, e ele serve como um guia do que as classes filhas devem ter. Na classe abstract você só faz a definição, e a implementação fica a cargo de cada classe filha

	`Public abstract class Animal{
		`int age;`
		`String name;`

		`public abstract void fazBarulho();` //só define

		public String getName(){
			return name;
		}
	}`

	`public class Dog extends Animal{
		`@Override` //implementa o método abstrato
		`public void fazBarulho(){
			`Println("Auau");`
		}`
	
	}`


### Interface
Uma interface é semelhante à uma classe abstrata. A principal diferenças
é que podemos "herdar" mais de uma interface, diferente da classe. Além disso, uma interface podem ter **métodos estáticos**, **métodos padrão (`default`)**, e **métodos abstratos**. Todos os atributos de uma interface são statics e finals.

`public interface Classificação{
	`public void classificar();`
}`

`public class Filme implements Classificação{
	`int curtidas`;
	`int nota`
	`public void classificar(){
		`if(curtidas > 100){
			`nota = 10;`
		}`
	}
	`
}`