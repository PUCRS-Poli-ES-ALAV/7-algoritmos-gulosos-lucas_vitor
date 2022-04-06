package src;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    static int ite = 0;
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> listaDisponiveis = new ArrayList<Integer>(Arrays.asList(100,25,10,5,1));
        System.out.println(contaTroco(listaDisponiveis, 334, new ArrayList<>()));
        System.out.println("Iterações: " + ite);
    }

    public static ArrayList<Integer> contaTroco(ArrayList<Integer> listaDisponiveis, int valor, ArrayList<Integer> troco){
        ite++;
        if(valor==0) return troco;

        while(listaDisponiveis.get(0) <= valor) {
            troco.add(listaDisponiveis.get(0));
            valor-=listaDisponiveis.get(0);
        }

        if(listaDisponiveis.size() != 0) listaDisponiveis.remove(0);
        return contaTroco(listaDisponiveis, valor, troco);
    }
}
