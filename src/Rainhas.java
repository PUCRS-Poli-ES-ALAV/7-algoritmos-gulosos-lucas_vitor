
public class Rainhas {
    public static void main(String[] args) throws Exception {
        int[][] tabuleiro = new int[7][7];

    }

    public static int[][] nextAvailable(int[][] tabuleiro, int nroRainha){
        if(getPosition(tabuleiro, nroRainha-1)!=null){

        } else { //rainha 1
            if(getPosition(tabuleiro, nroRainha)==null)
                tabuleiro[0][0] = nroRainha;
            else {
                int[] position = getPosition(tabuleiro, nroRainha);

                if(position[1]<tabuleiro[0].length-1){ // se ainda tem coluna disponivel na linha
                    tabuleiro[position[0]][position[1]+1] = nroRainha;
                }
                else if(position[1]>=tabuleiro[0].length-1 && position[0]<tabuleiro.length-1){ //se chegou na ultima coluna pula pra linha de baixo
                    tabuleiro[position[0]+1][0] = nroRainha;
                } 
                else if(position[1]>=tabuleiro[0].length-1 && position[0]>=tabuleiro.length-1){ //fim da linha
                    System.out.println("No available position for queen: " + nroRainha);
                    return null;
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
}
