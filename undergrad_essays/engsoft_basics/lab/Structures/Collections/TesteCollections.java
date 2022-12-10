/**
 * Collections - PMR2300
 * Departamento de Engenharia Mecatronica e de Sistemas Mecanicos
 * Escola Politecnica, Universidade de Sao Paulo
 * Autor: Fabio Gagliardi Cozman
 */

import java.util.*;

public class TesteCollections {
    public static void main(String args[]) {
        int i;
        long start;
        int SIZE = Integer.parseInt(args[0]);
        
        System.out.println("Teste para " + SIZE);
        
        // Inicialmente crie um array 
        // contendo números aleatórios de 32 bits (com sinal).
        Integer numbers[] = new Integer[SIZE];
        Random random = new Random();
        for (i=0; i<numbers.length; i++) 
            numbers[i] = new Integer( random.nextInt() );
        Random randomIndex = new Random();            
            
        // Inicie teste: coloque os números em
        // uma lista ligada.
        System.out.println("Inicie lista ligada...");
        List l = new LinkedList();
        for (i=0; i<numbers.length; i++)
            l.add(numbers[i]);
        System.out.println("Busca na lista ligada...");
        start = System.currentTimeMillis();
        for (i=0; i<SIZE; i++) {
            int index = randomIndex.nextInt(SIZE);
            l.contains(numbers[index]);
        }
        System.out.println("Tempo: " + (System.currentTimeMillis() - start));
        System.out.println("Fim de teste com lista ligada.");

        // Inicie teste: coloque os números em
        // uma lista sequencial.
        System.out.println("Inicie lista sequencial...");
        List a = new ArrayList();
        for (i=0; i<numbers.length; i++)
            a.add(numbers[i]);
        System.out.println("Busca na lista sequencial...");
        start = System.currentTimeMillis();        
        for (i=0; i<SIZE; i++) {
            int index = randomIndex.nextInt(SIZE);
            a.contains(numbers[index]);
        }
        System.out.println("Tempo: " + (System.currentTimeMillis() - start));        
        System.out.println("Fim de teste com lista sequencial.");

        // Inicie teste: coloque os números em
        // uma lista sequencial.
        System.out.println("Inicie lista sequencial...");
        List ab = new ArrayList();
        for (i=0; i<numbers.length; i++)
            ab.add(numbers[i]);
        System.out.println("Ordene a lista");
        Collections.sort(ab);
        System.out.println("Busca binaria na lista sequencial...");
        start = System.currentTimeMillis();        
        for (i=0; i<SIZE; i++) {
            int index = randomIndex.nextInt(SIZE);
            Collections.binarySearch(ab, numbers[index]);
        }
        System.out.println("Tempo: " + (System.currentTimeMillis() - start));
        System.out.println("Fim de teste com lista sequencial.");

        // Inicie teste: coloque os números em
        // uma TreeMap.
        System.out.println("Inicie arvore...");
        Set t = new TreeSet();
        for (i=0; i<numbers.length; i++)
            t.add(numbers[i]);
        System.out.println("Busca na arvore...");
        start = System.currentTimeMillis();        
        for (i=0; i<SIZE; i++) {
            int index = randomIndex.nextInt(SIZE);
            t.contains(numbers[index]);
        }
        System.out.println("Tempo: " + (System.currentTimeMillis() - start));        
        System.out.println("Fim de teste com arvore.");
    
        // Inicie teste: coloque os números em
        // um HashMap.
        System.out.println("Inicie hashtable...");
        Set h = new HashSet();
        for (i=0; i<numbers.length; i++)
            h.add(numbers[i]);
        System.out.println("Busca na hashtable...");
        start = System.currentTimeMillis();        
        for (i=0; i<SIZE; i++) {
            int index = randomIndex.nextInt(SIZE);
            h.contains(numbers[index]);
        }
        System.out.println("Tempo: " + (System.currentTimeMillis() - start));        
        System.out.println("Fim de teste com hashtable.");
    }
}
        