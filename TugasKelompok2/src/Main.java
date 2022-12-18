import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean runAnswer(String answer) {
        String[] answerRun = {"y","Y","t","T"};
        boolean contains = Arrays.stream(answerRun).anyMatch(answer::equals);

        return contains;
    }

    public static void main(String[] args) {
        String nama = "";
        String nim = "";
        int jmlBil = 0;

        String rerun = "y";
        boolean programRunning = true;

        Scanner scan = new Scanner(System.in);

        while (programRunning) {

            // Soal 1
            do {
                System.out.print("Masukkan Nama Anda [1..25] : ");
                nama = scan.nextLine();
                if (nama.length() == 0 || nama.length() > 25) {
                    System.out.println("Nama Tidak boleh kosong & tidak boleh lebih dari 25 karakter!!!\n");
                }
            } while (nama.length() == 0 || nama.length() > 25);

            // Soal 2
            do {
                System.out.print("Masukkan Nim Anda [harus 10 karakter] : ");
                nim = scan.nextLine();
                if (nim.length() != 10) {
                    System.out.println("Nim harus terdiri dari 10 karakter!!!\n");
                }
            } while (nim.length() != 10);

            System.out.println("\nRegistrasi Sukses..");
            System.out.println("Selamat datang " + nama + " [NIM : " + nim +"].. ^^u" );
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            System.out.println("\nMari belajar macam-macam Bilangan deret..");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");

            // Soal 3
            do {
                System.out.print("Masukkan Bilangan 5 sampai 20 : ");
                jmlBil = scan.nextInt();
                scan.nextLine();
                if (jmlBil < 5 || jmlBil >20) {
                    System.out.println("Bilangan minimal harus 5 dan maksimal 20!!!\n");
                }
            } while (jmlBil < 5 || jmlBil >20);

            System.out.println("Deret Bilangan  ");
            System.out.println("###############\n");

            int currentGanjil = 1, currentGenap = 2, totalGanjil = 0, totalGenap = 0;
            int pastFibbonaci = 1, currentFibonacci = 1, totalFibonacci = 0;

            String deretGanjil = "", deretGenap = "", deretFibbonaci ="";

            for (int i = 0; i < jmlBil; i++) {
                deretGenap += currentGenap + " ";
                totalGenap += currentGenap;
                currentGenap += 2;

                deretGanjil += currentGanjil + " ";
                totalGanjil += currentGanjil;
                currentGanjil += 2;

                deretFibbonaci += pastFibbonaci + " ";
                totalFibonacci = pastFibbonaci + currentFibonacci;
                pastFibbonaci = currentFibonacci;
                currentFibonacci = totalFibonacci;
            }

            // Soal 4
            System.out.println(jmlBil + " Bilangan Genap : \n" + deretGenap);
            System.out.println("Hasil Penjumlahan : " + totalGenap);
            System.out.println(" ");

            System.out.println(jmlBil +" Bilangan Ganjil : \n" + deretGanjil);
            System.out.println("Hasil Penjumlahan : " + totalGanjil);
            System.out.println(" ");

            System.out.println(jmlBil +" Bilangan Fibbonacci : \n" + deretFibbonaci);
            System.out.println("Hasil Penjumlahan : " + totalFibonacci);
            System.out.println(" ");

            do {
                System.out.print("Apakah anda ingin mengulang [y/t] : ");
                rerun = scan.nextLine();

                if (!runAnswer(rerun)){
                    System.out.println("Tolong masukkan [y/t]!!\n");
                }
            } while(!runAnswer(rerun));

            // Soal 5
            if (rerun.contains("t") || rerun.contains("T")) programRunning = false;
        }
    }
}
