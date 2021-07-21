import java.util.Scanner;

/**
 * Faça um programa que leia um valor N. Este N será o tamanho de um vetor X[N]. A seguir, leia cada um dos valores de X, encontre o menor elemento deste vetor e a sua posição dentro do vetor, mostrando esta informação.
 *
 * Entrada
 * A primeira linha de entrada contem um único inteiro N (1 < N < 1000), indicando o número de elementos que deverão ser lidos em seguida para o vetor X[N] de inteiros. A segunda linha contém cada um dos N valores, separados por um espaço. Vale lembrar que nenhuma entrada haverá números repetidos.
 *
 * Saída
 * A primeira linha apresenta a mensagem “Menor valor:” seguida de um espaço e do menor valor lido na entrada. A segunda linha apresenta a mensagem “Posicao:” seguido de um espaço e da posição do vetor na qual se encontra o menor valor lido, lembrando que o vetor inicia na posição zero.
 */

public class Uri1180 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int posicao = 0;
        int menorValor = 1000;
        int numeroElementos = Integer.parseInt( teclado.nextLine() );

        String texto = teclado.nextLine();
        texto = texto.trim();
        String[] textoSeparado = texto.split("\\s");

        if(texto.length() == 0 ){
            menorValor = 0;
        }
        else {
            for (int i = 0; i < textoSeparado.length; i++) {
                try {
                    if (Integer.parseInt(textoSeparado[i]) < menorValor) {
                        menorValor = Integer.parseInt(textoSeparado[i]);
                        posicao = i;
                    }
                }catch (NumberFormatException ex) {

                }
            }
        }
        System.out.println("Menor valor: " + menorValor);
        System.out.println("Posicao: " + posicao);
    }
}