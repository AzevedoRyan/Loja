package loja;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Loja {

    public static void main(String[] args) throws FileNotFoundException {

        Vendedor vd2[] = new Vendedor[10];

        lerDados(vd2);
        

        int opcao;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Menu\n" + "1 - Sálarios\n" + "2 - Porcentagem categoria\n" + "3 - Sair\n");
            opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    System.out.printf("\n%13s %13s\n","nome","salário final");

                    for (int i = 0; i < vd2.length; i++) {

                        System.out.printf("%13s %13.2f\n ", vd2[i].vendedor, vd2[i].calcSalFinal());

                    }

                    break;
                case 2:
                    
                    int catDig;
                    System.out.println("Digite a categoria:");
                    catDig = scan.nextInt();
                    if(catDig==1||catDig ==2||catDig==3){
                        double perc = calcPorcentagem(vd2, catDig);
                        System.out.printf("Perc de categoria %d: %.1f\n",catDig,perc);
                    }else{
                        System.out.println("categoria iválida");
                    }
                    break;
                case 3:
                    System.out.println("Encerrar");
                    break;
                default:
                    System.out.println("Valor inválito");
                    opcao = 3;
                    break;

            }

        } while (opcao != 3);

    }// fecha o main    

    public static double calcPorcentagem(Vendedor vd[], int categoria) {
        double somaCat = 0, somaTotal = 0;
        double perc;
        for (int i = 0; i < vd.length; i++) {
            somaTotal = somaTotal + vd[i].valorVendas;
            if (categoria == vd[i].categoria) {
                somaCat = somaCat + vd[i].valorVendas;
            }

        }
        perc = somaCat / somaTotal * 100;
        return perc;

    }

    //métodos com comandos para ler os dados no arquivo, 
    //armazenar no vetor e exibir na tela
    public static void lerDados(Vendedor vd[]) throws FileNotFoundException {

        File arq = new File("dados.txt");
        Scanner scanArq = new Scanner(arq);

        System.out.printf("%10s %10s %10s\n", scanArq.next(), scanArq.next(),
                scanArq.next());
        for (int i = 0; i < 10; i++) {
            vd[i] = new Vendedor(scanArq.next(), scanArq.nextInt(),
                    scanArq.nextDouble());
            System.out.printf("%10s %10d %10.2f\n", vd[i].vendedor,
                    vd[i].categoria, vd[i].valorVendas);
        }
    }
}
