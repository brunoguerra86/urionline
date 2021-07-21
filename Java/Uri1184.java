    import java.util.Locale;
    import java.util.Scanner;

    /**
     * Leia um caractere maiúsculo, que indica uma operação que deve ser realizada e uma matriz M[12][12]. Em seguida, calcule e mostre a soma ou a média considerando somente aqueles elementos que estão abaixo da diagonal principal da matriz, conforme ilustrado abaixo (área verde).
     *
     * Entrada
     * A primeira linha de entrada contem um único caractere Maiúsculo O ('S' ou 'M'), indicando a operação (Soma ou Média) que deverá ser realizada com os elementos da matriz. Seguem os 144 valores de ponto flutuante que compõem a matriz.
     *
     * Saída
     * Imprima o resultado solicitado (a soma ou média), com 1 casa após o ponto decimal.
     */

    public class Uri1184 {
        public static void main(String[] args) {
            Locale.setDefault(Locale.US); //Substitui separador de decimal de vírgula por ponto

            Scanner teclado = new Scanner(System.in);

            //S - SOMA ou M - MÉDIA
            String operacao = teclado.nextLine();

            float[][] matriz = new float[12][12];
            float soma = 0;
            int qtdItens = 0;

            for(int linha = 0; linha < 12; linha++){
                for(int coluna = 0; coluna < 12; coluna++){

                    matriz[linha][coluna] = Float.parseFloat( teclado.nextLine() );

                    if( linha > coluna ) {
                        soma += matriz[linha][coluna];
                        qtdItens++;
                    }
                }
            }

            if( operacao.equals("S"))  { //SOMA
                System.out.printf("%.1f", soma);
            }
            else { //MEDIA
                System.out.printf("%.1f", soma / qtdItens );
            }
        }
    }