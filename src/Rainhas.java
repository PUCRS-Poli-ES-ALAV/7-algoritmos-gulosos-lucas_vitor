import java.util.Scanner;

public class Rainhas {
    public static void main(String[] args) throws Exception {
        int[][] tabuleiro = new int[7][7];
        int[] rainhas = {1,2,3,4,5,6};

        System.out.println(tabuleiro[1]);
        testing(tabuleiro, rainhas);
    }

    public static int[][] moveToNextAvailable(int[][] tabuleiro, int nroRainha) throws Exception{
        if(getPosition(tabuleiro, nroRainha-1)!=null && nroRainha>1){ //testa se existe rainha anterior
            if(getPosition(tabuleiro, nroRainha)==null){ //colocar rainha no tabuleiro
                int[] positionRainhaAnterior = getPosition(tabuleiro, nroRainha-1);
                
                for (int i=positionRainhaAnterior[0]; i<tabuleiro.length; i++)
                    for (int j=0; j<tabuleiro[0].length; j++){
                        
                    }

            }

        } else { //se for a rainha 1
            if(getPosition(tabuleiro, nroRainha)==null) //colocar rainha 1 no tabuleiro
                tabuleiro[0][0] = nroRainha;
            else { //rainha 1 ja ta no tabuleiro
                int[] position = getPosition(tabuleiro, nroRainha); //position[linha, coluna]

                if(position[1]<tabuleiro[0].length-1){ // se ainda tem coluna disponivel na linha
                    tabuleiro[position[0]][position[1]+1] = nroRainha;
                    tabuleiro[position[0]][position[1]] = 0;
                }
                else if(position[1]>=tabuleiro[0].length-1 && position[0]<tabuleiro.length-1){ //se chegou na ultima coluna pula pra linha de baixo
                    tabuleiro[position[0]+1][0] = nroRainha;
                    tabuleiro[position[0]][position[1]] = 0;
                } 
                else if(position[1]>=tabuleiro[0].length-1 && position[0]>=tabuleiro.length-1){ //fim da linha
                    throw new Exception("No available position for queen #" + nroRainha);
                } 
            }
        }
        return tabuleiro;
    }

    public static int[] getPosition(int[][] tabuleiro, int nroRainha){
        int[] position = new int[2];
        for (int i=0; i<tabuleiro.length; i++)
            for (int j=0; j<tabuleiro[0].length; j++)
                if(tabuleiro[i][j] == nroRainha){
                    position[0] = i; position[1] = j;
                    return position;
                }
        return null;
    }

    public static void printTabuleiro(int[][] tabuleiro){
        for (int i=0; i<tabuleiro.length; i++){
            for (int j=0; j<tabuleiro[0].length; j++){
                System.out.print(tabuleiro[i][j] + "  ");
            }
            System.out.print("\n");
        }
    }

    public static void testing(int [][] tabuleiro, int[] rainhas) throws Exception{
        printTabuleiro(tabuleiro);
        Scanner in = new Scanner(System.in);
        boolean falg = true;
        while(falg){
            System.out.println();
            tabuleiro = moveToNextAvailable(tabuleiro, rainhas[0]);
            printTabuleiro(tabuleiro);
            if(in.nextLine().equalsIgnoreCase("exit")) falg=false;
        }
        in.close();
    }
}
