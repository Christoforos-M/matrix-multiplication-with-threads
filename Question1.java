package com.mycompany.question1;

import java.util.Random;

public class Question1 {
    
    public static void main(String[] args) throws InterruptedException {
        int n = 256; //Γραμμες πινακα
        int m = 256; //Σειρες πινακα α και γραμμες ν
        int k = 8; // Αριθμος νηματων

        int[][] A = new int[n][m];
        int[] NI = new int[m];
        int[] apotelesma = new int[n];

        Random rand = new Random();
        
        // Γεμισμα πινακα Α
        System.out.println("Pinakas A");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = rand.nextInt(11);
            }
        }
        
        // Εκτυπωση πινακα Α
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        
        // Γεμισμα ν
        System.out.println("Pinakas n");
        for (int i = 0; i < m; i++) {
            NI[i] = rand.nextInt(11);
            System.out.println(NI[i]);
        }
        
        
        
        // Δημιουργια και χρηση νηματων
        Thread[] threads = new Thread[k];
        int rowsPerThread = n / k;
        
        long start = System.currentTimeMillis();
        
        for (int t = 0; t < k; t++) {
            int startRow = t * rowsPerThread;
            int endRow = (t + 1) * rowsPerThread;
            threads[t] = new Thread(new Worker(A, NI, apotelesma, startRow, endRow));
            threads[t].start();
        }

        // Περιμενουμε να τελειωσουν τα νηματα
        for (int t = 0; t < k; t++) {
            threads[t].join();
        }
        
        long end = System.currentTimeMillis();
        
        // Εκτυπωση πινακα αποτελεσματος
        System.out.println("Διάνυσμα αποτελέσματος A * v:");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", apotelesma[i]);
            System.out.println();
        }
        
        System.out.println("\nDuration: " + (end - start) + "msec");
    }

    // Πολλαπλασιασμος με χρηση των νηματων
    static class Worker implements Runnable {
        private final int[][] A;
        private final int[] NI;
        private final int[] result;
        private final int startRow, endRow;

        Worker(int[][] A, int[] NI, int[] result, int startRow, int endRow) {
            this.A = A;
            this.NI = NI;
            this.result = result;
            this.startRow = startRow;
            this.endRow = endRow;
        }

        @Override
        public void run() {
            for (int i = startRow; i < endRow; i++) {
                int sum = 0;
                for (int j = 0; j < NI.length; j++) {
                    sum += A[i][j] * NI[j];
                }
                result[i] = sum;
            }
        }
    }
}

