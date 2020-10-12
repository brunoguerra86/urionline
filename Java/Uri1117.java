import java.util.Scanner;

public class Uri1117 {
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);

        float nota,media=0;
        int qtdeNotas=0;

        while (qtdeNotas < 2){
            nota = teclado.nextFloat();

            if (nota < 0 || nota > 10)
                System.out.println("nota invalida");
            else{
                media += nota;
                qtdeNotas++;
            }
        } 
        System.out.printf("media = %.2f\n", media / qtdeNotas);
    }
}