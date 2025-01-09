import java.util.ArrayList;
import java.util.List;

public class Imobiliaria {

    List<Imovel> imoveis = new ArrayList<>();


    public void incluirImovel(Imovel imovel){
         imoveis.add(imovel);
    }

    public void removerImovel(int codigo){
        for(Imovel imovel : imoveis){
            if(imovel.getCodigo() == codigo){
                imoveis.remove(imovel);
            }
        }
    }

    public void consultarImovel(int codigo){
        for(Imovel imovel : imoveis){
            if(imovel.getCodigo() == codigo){
                imovel.exibeInformacoes();
            }
        }
    }


    public void listarAlugueis(){
        for(Imovel imovel : imoveis){
            if(imovel.getFinalidade() == "Aluguel"){
                imovel.exibeInformacoes();
            }
        }
    }

    public void listarTipoImovel(String tipo){

        for(Imovel imovel : imoveis){
            if(imovel.getClass().getSimpleName().equalsIgnoreCase(tipo)){
                imovel.exibeInformacoes();
            }
        }


    }


}
