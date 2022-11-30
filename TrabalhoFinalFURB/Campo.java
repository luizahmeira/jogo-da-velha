public class Campo {
    private char simbolo;
//ÚNICO OBJETO QUE VAMOS CRIAR NO JOGO DA VELHA

    public Campo(){
        this.simbolo = ' ';  //iniciando a variavel
    }

    public char getSimbolo(){ //publico e vai retornar um char do simbolo que se encontrar na casa
        return this.simbolo;
    }
    
    public void setSimbolo(char simbolo){ //publico nao retorna nada, e vai setar um simbolo no campo
        if(this.simbolo == ' '){
            this.simbolo = simbolo;
        } 
        else{
            System.out.println("O CAMPO SELECIONADO JÁ ESTÁ SENDO UTILIZADO ");
        }
    }

}
