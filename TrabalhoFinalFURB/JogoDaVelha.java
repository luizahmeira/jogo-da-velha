import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        //colocar o meto random para sortear quem começa o jogo e sortear as jogadas do jogador O
        //private int sortear(int inicio, int fim) { return (int) ((Math.random()*fim)-inicio); }


        Campo[][] velha = new Campo[3][3]; //criando a matriz do tipo campo, chamada velha, que tem 3 linhas e 3 colunas
        char simboloAtual = 'X'; //VARIAVEL QUE VAI GUARDAR O SIMBOLO DA VEZ
        String vitoria = "";
        int partidas = 0;
        Scanner terminal = new Scanner(System.in);
        

        iniciarJogo(velha);

        for (partidas = 0; partidas < 10;) {
            //sempre que o jogo estiver rolando eu vou precisar chamar o desenharOjogo
            desenharOjogo(velha);
            vitoria = verificaVitoria(velha);
            if(!vitoria.equals("")){
                System.out.printf("Jogador %s venceu%n", vitoria);
                break;
            } else if(vitoria.equals("N")){
                System.out.printf("NINGUÉM VENCEU");
                break;
            }
            try{ //é onde vai acontecer o jogo
                if(verificaJogada(velha, jogar(terminal, simboloAtual),simboloAtual)){
                    partidas++;
                    if(simboloAtual == 'X'){  
                        simboloAtual = 'O';
                    } else {
                        simboloAtual = 'X';
                    }
                }
                if(partidas == 9){
                    System.out.println("PERDERAM OTÁRIOS");
                    break;
                }
            }
            catch(Exception e){
                System.out.println("ERRO");
            }
        }
        System.out.println("FIM DE JOGO");
        terminal.close();
    }
    
    public static void desenharOjogo(Campo[][] velha){ //os parametros nao tem relação com a matriz do main
        //limpartela();
        System.out.println("  ║ 0 ║ 1 ║ 2 ║ ");
        System.out.println("═════════════════"); 
        System.out.printf("0 ║ %c ║ %c ║ %c ║  %n", velha[0][0].getSimbolo(), velha[0][1].getSimbolo(), velha[0][2].getSimbolo());
        System.out.println("═════════════════");
        System.out.printf("1 ║ %c ║ %c ║ %c ║ %n", velha[1][0].getSimbolo(), velha[1][1].getSimbolo(), velha[1][2].getSimbolo());
        System.out.println("═════════════════"); 
        System.out.printf("2 ║ %c ║ %c ║ %c ║ %n", velha[2][0].getSimbolo(), velha[2][1].getSimbolo(), velha[2][2].getSimbolo());

    }

    public static void limparTela(){
        for (int i = 0; i < 200; i++) {
            System.out.println("");
        }
    }

    public static int[] jogar(Scanner terminal, char sa){ //sa == simboloAtual
        int[] p = new int[2];
        System.out.printf("%s %c%n", "Quem Joga: ", sa);
        System.out.print("Informe a LINHA que você deseja jogar: ");
        p[0] = terminal.nextInt();
        System.out.print("Informe a COLUNA que você deseja jogar: ");
        p[1] = terminal.nextInt();
        System.out.println(" ");
        System.out.println("===================================================");
        System.out.println(" ");

        return p;
    }

    public static Boolean verificaJogada(Campo[][] velha, int p[], char simboloAtual){ //o jogo da velha, o ponto que quero jogar e o simbolo atual
        if(velha[p[0]][p[1]].getSimbolo() == ' '){
            velha[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        } else {
            return false;
        }

    }

    public static void iniciarJogo(Campo[][] velha){
        for(int l=0; l<3; l++){
            for(int c=0; c<3; c++){
                velha[l][c] = new Campo();
            }
        }
    }

    public static String verificaVitoria(Campo[][]velha){
        String vencedor = "";

        if(velha[0][0].getSimbolo() == 'X' && velha[0][1].getSimbolo() == 'X' && velha[0][2].getSimbolo() == 'X'
        || velha[1][0].getSimbolo() == 'X' && velha[1][1].getSimbolo() == 'X' && velha[1][2].getSimbolo() == 'X'
        || velha[2][0].getSimbolo() == 'X' && velha[2][1].getSimbolo() == 'X' && velha[2][2].getSimbolo() == 'X'
        || velha[0][0].getSimbolo() == 'X' && velha[1][1].getSimbolo() == 'X' && velha[2][2].getSimbolo() == 'X'
        || velha[0][2].getSimbolo() == 'X' && velha[1][1].getSimbolo() == 'X' && velha[2][0].getSimbolo() == 'X'
        || velha[0][0].getSimbolo() == 'X' && velha[1][0].getSimbolo() == 'X' && velha[2][0].getSimbolo() == 'X'
        || velha[0][1].getSimbolo() == 'X' && velha[1][1].getSimbolo() == 'X' && velha[2][1].getSimbolo() == 'X'
        || velha[0][2].getSimbolo() == 'X' && velha[1][2].getSimbolo() == 'X' && velha[2][2].getSimbolo() == 'X'
        ){
            vencedor = "X";
        } else if(velha[0][0].getSimbolo() == 'O' && velha[0][1].getSimbolo() == 'O' && velha[0][2].getSimbolo() == 'O'
        || velha[1][0].getSimbolo() == 'O' && velha[1][1].getSimbolo() == 'O' && velha[1][2].getSimbolo() == 'O'
        || velha[2][0].getSimbolo() == 'O' && velha[2][1].getSimbolo() == 'O' && velha[2][2].getSimbolo() == 'O'
        || velha[0][0].getSimbolo() == 'O' && velha[1][1].getSimbolo() == 'O' && velha[2][2].getSimbolo() == 'O'
        || velha[0][2].getSimbolo() == 'O' && velha[1][1].getSimbolo() == 'O' && velha[2][0].getSimbolo() == 'O'
        || velha[0][0].getSimbolo() == 'O' && velha[1][0].getSimbolo() == 'O' && velha[2][0].getSimbolo() == 'O'
        || velha[0][1].getSimbolo() == 'O' && velha[1][1].getSimbolo() == 'O' && velha[2][1].getSimbolo() == 'O'
        || velha[0][2].getSimbolo() == 'O' && velha[1][2].getSimbolo() == 'O' && velha[2][2].getSimbolo() == 'O'){
            vencedor = "O";
        }

        return vencedor;
    }


    
   

}