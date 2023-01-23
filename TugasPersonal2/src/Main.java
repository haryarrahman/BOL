import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean runAnswer(String answer) {
        String[] answerRun = {"y","Y","t","T"};
        boolean contains = Arrays.stream(answerRun).anyMatch(answer::equals);

        return contains;
    }
    public static String doubleToInt(double num) {
        return new DecimalFormat("#").format(num);
    }

    public static String aritmatika(int a, int n, int beda) {
        return String.valueOf(a + ( (n - 1) * beda));
    }

    public static String geometri(int a, int n, int beda) {
        return doubleToInt(a * Math.pow(beda, n - 1));
    }

    public static int faktorial(int a, int n) {
        return a*n;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean programRunning = true;
        int banyakAngka, beda, hasilFaktorial = 1;
        String rerun = "y", deretAritmatika = "", deretGeometri = "", deretFaktorial = "";


        while (programRunning) {
            System.out.println("\nBelajar Deret Aritmatika, Geometri dan Menghitung Faktorial");

            // 4a.
            do {
                System.out.print("\nMasukkan banyak angka yang ingin dicetak (minimal 2, maksimal 10): ");
                banyakAngka = input.nextInt();
            } while (banyakAngka < 2 || banyakAngka > 10);

            // 4b.
            do {
                System.out.print("Masukkan beda masing-masing angka (minimal 2, maksimal 9): ");
                beda = input.nextInt();
            } while (beda < 2 || beda > 9);

            // 4c.
            for (int i = 1; i <= banyakAngka; i++) {
                String symbolFaktorial = banyakAngka == i ? " = " : " * ";
                int countDown = banyakAngka - ( i-1 );

                deretAritmatika += aritmatika(1, i, beda) + " ";
                deretGeometri += geometri(1, i, beda) + " ";
                deretFaktorial +=  faktorial(1, countDown) + symbolFaktorial;
                hasilFaktorial *= countDown;
            }

            System.out.println("\nDeret Aritmatika :\n" + deretAritmatika);
            System.out.println("Deret Geometri: \n" + deretGeometri);
            System.out.println("Faktorial dari " + banyakAngka + " :\n" + deretFaktorial + " " + hasilFaktorial);

            // break scanner nextInt();
            input.nextLine();

            // 4d.
            do {
                System.out.print("\nApakah anda ingin mengulang [y/t] : ");
                rerun = input.nextLine();

                // reset variable
                banyakAngka = 0; beda = 0; hasilFaktorial = 1;
                deretAritmatika = ""; deretGeometri = ""; deretFaktorial = "";

                if (!runAnswer(rerun)){
                    System.out.println("Tolong masukkan [y/t]!!");
                }
            } while(!runAnswer(rerun));

            // Soal 5
            if (rerun.contains("t") || rerun.contains("T")) programRunning = false;
        }
    }
}