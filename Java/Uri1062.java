import java.util.*;

/**
 * Há uma famosa estação de trem na cidade PopPush. Esta cidade fica em um país incrivelmente acidentado e a estação foi
 * criada no último século. Infelizmente os fundos eram extremamente limitados naquela época. Foi possível construir
 * somente uma pista. Além disso, devido a problemas de espaço, foi feita uma pista apenas até a estação (veja figura
 * abaixo).
 *
 * A tradição local é que todos os comboios que chegam vindo da direção A continuam na direção B com os vagões
 * reorganizados, de alguma forma. Suponha que o trem que está chegando da direção A tem N <= 1000 vagões numerados
 * sempre em ordem crescente 1,2, ..., N. O primeiro que chega é o 1 e o último que chega é o N. Existe um chefe de
 * reorganizações de trens que quer saber se é possível reorganizar os vagões para que os mesmos saiam na direção B na
 * ordem a1, a2, an..
 *
 * O  chefe pode utilizar qualquer estratégia para obter a saída desejada. No caso do desenho ilustrado acima, por
 * exemplo, basta o chefe deixar todos os vagões entrarem na estação (do 1 ao 5) e depois retirar um a um: retira o 5,
 * retira o 4, retira o 3, retira o 2 e por último retira o 1.  Desta forma, se o chefe quer saber se a saída 5,4,3,2,1
 * é possível em B, a resposta seria Yes. Vagão que entra na estação só pode sair para a direção B e é possível incluir
 * quantos forem necessários para retirar o primeiro vagão desejado.
 *
 * Entrada
 * O arquivo de entrada consiste de um bloco de linhas, cada bloco, com exceção do último, descreve um trem e
 * possivelmente mais do que uma requisição de reorganização. Na primeira linha de cada bloco há um inteiro N que é a
 * quantidade de vagões. Em cada uma das próximas linhas de entrada haverá uma permutação dos valores 1,2, …, N. A
 * última linha de cada bloco contém apenas 0. Um bloco iniciando com zero (0) indica o final da entrada.
 *
 * Saída
 * O arquivo de saída contém a quantidade de linhas correspondente às linhas com permutações no arquivo de entrada.
 * Cada linha de saída deve ser Yes se for possível organizar os vagões da forma solicitada e No, caso contrário.
 * Há também uma linha em branco após cada bloco de entrada. No exemplo abaixo,  O primeiro caso de teste tem 3
 * permutações para 5 vagões. O ultimo zero dos testes de entrada não devem ser processados.
 */

public class Uri1062 {
    public static void main(String[] args) {
        //Setup
        Scanner teclado = new Scanner(System.in);

        int qtdVagoes = Integer.parseInt(teclado.nextLine());

        ArrayList<String> strSaida = new ArrayList<String>();
        LinkedList<Integer> desejado = new LinkedList<Integer>();
        Queue<Integer> estacaoOrigem = new LinkedList<Integer>();

        while(qtdVagoes != 0){

            //Ler Ordem Desejada
            String ordemDesejada = teclado.nextLine();

            if(!ordemDesejada.toString().equals("0")) {

                desejado = ObterLista(ordemDesejada);
                estacaoOrigem = ObterComboioOrigem(desejado.size());

                strSaida.add(validaOrdemDesejada(desejado, estacaoOrigem));
                continue;
            }
            strSaida.add("");
            qtdVagoes = Integer.parseInt(teclado.nextLine());
        }

        imprimeSaida(strSaida);

        // Encerramento
        teclado.close();
    }

    private static LinkedList<Integer> ObterLista(String ordemDesejada) {
        LinkedList<Integer> lista = new LinkedList<>();
        String[] arrayOrdemDesejada = ordemDesejada.split("\\s");

        for( String str : arrayOrdemDesejada )
            lista.add(Integer.parseInt(str));

        return lista;
    }

    private static Queue<Integer> ObterComboioOrigem(int size) {
        Queue<Integer> fila = new LinkedList<>();

        for(int i=1; i <= size; i++)
            fila.add(i);
        return fila;
    }

    private static void imprimeStatus(String s, LinkedList desejado, Queue estacaoOrigem, Deque<Integer> estacaoManobra, ArrayList<Integer> estacaoDestino) {
        System.out.println(s);
        System.out.println("desejado:" + desejado);
        System.out.println("origem  :" + estacaoOrigem);
        System.out.println("manobra :" + estacaoManobra);
        System.out.println("destino :" + estacaoDestino);
    }

    private static void imprimeSaida(ArrayList<String> strSaida) {
        for ( String s : strSaida)
            System.out.println(s);
    }

    //Se ordem desejada for possível retorna Yes senão No
    private static String validaOrdemDesejada( LinkedList desejado, Queue estacaoOrigem ){
        Deque<Integer> estacaoManobra = new ArrayDeque<Integer>();
        ArrayList<Integer> estacaoDestino = new ArrayList<Integer>();
        LinkedList<Integer> desejadoCopia = new LinkedList<Integer>();

        desejadoCopia = (LinkedList<Integer>) desejado.clone();

        //imprimeStatus("\n### 0 ###", desejado, estacaoOrigem, estacaoManobra, estacaoDestino);

        while (!estacaoOrigem.isEmpty() || !estacaoManobra.isEmpty()){

            if ( desejado.peekFirst() == estacaoOrigem.peek() ){
                desejado.pollFirst();
                estacaoDestino.add((Integer) estacaoOrigem.poll());
                //imprimeStatus("\n### 1 ###", desejado, estacaoOrigem, estacaoManobra, estacaoDestino);
                continue;
            }

            if ( desejado.peekFirst() == estacaoManobra.peekLast() ){
                desejado.pollFirst();
                estacaoDestino.add((Integer) estacaoManobra.pollLast());
                //imprimeStatus("\n### 2 ###", desejado, estacaoOrigem, estacaoManobra, estacaoDestino);
                continue;
            }

            if ( !estacaoOrigem.isEmpty() ){
                estacaoManobra.add((Integer) estacaoOrigem.poll());
                //imprimeStatus("\n### 3 ###", desejado, estacaoOrigem, estacaoManobra, estacaoDestino);
                continue;
            }
            break;
        }

        if( estacaoDestino.equals(desejadoCopia))
            return "Yes";
        else
            return "No";

    }
}
