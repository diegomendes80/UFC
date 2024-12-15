public class Estado {
    String nome;
    Municipio[] municipios;
    int populacao;
    int area;

    public Estado(String nome, Municipio[] municipios) {
        this.nome = nome;
        this.municipios = municipios;
    }

    public int getPopulacao(){
        for(int i=0; i < municipios.length; i++){
            this.populacao += municipios[i].getPopulacao();
        }

        return this.populacao;
    }

    public int getArea(){
        for(int i=0; i < municipios.length; i++){
            this.populacao += municipios[i].getArea();
        }

        return this.area;
    }

    public int getDensidadeDemografica(){
        return populacao/area;
    }

    public void listMunicipiosPPib(int valor){
        for(int i=0; i < municipios.length; i++){
            if(municipios[i].getPibPerCapita() > valor){
                System.out.println("\nMunicípio: " + municipios[i].getNome());
                System.out.println("Renda per capita: " + municipios[i].getPibPerCapita());
            }
        }
    }

    public void listMunicipiosPartido(String partido){
        for(int i=0; i < municipios.length; i++){
            if(municipios[i].getPrefeitoAtual().partido == partido){
                System.out.println("\nMunicípio: " + municipios[i].getNome());
                System.out.println("Prefeito: " + municipios[i].getPrefeitoAtual().getNome());
                System.out.println("Partido: " + municipios[i].getPrefeitoAtual().getPartido());
            }
        }
    }


}
