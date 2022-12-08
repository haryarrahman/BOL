import java.util.Scanner;
import java.text.DecimalFormat;

public class RestoranBungar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double hargaNasgor = 9999.99,
                hargaAyam = 12345.67,
                hargaSteak = 21108.40,
                hargaKwetiaw = 13579.13,
                hargaKambing = 98765.43;

        System.out.println("Selamat siang...");
        System.out.print("Pesan untuk berapa orang : ");
        int jumlahOrang = input.nextInt();
        input.nextLine();

        System.out.print("Pesan atas nama          : ");
        input.nextLine();

        System.out.println("\n");
        System.out.println("Menu Spesial hari ini");
        System.out.println("=====================");
        System.out.println("1. Nasi Goreng Spesial          @ Rp. " + hargaNasgor);
        System.out.println("2. Ayam Bakar Spesial           @ Rp. " + hargaAyam);
        System.out.println("3. Steak Sirloin Spesial        @ Rp. " + hargaSteak);
        System.out.println("4. Kwetiaw Siram Spesial        @ Rp. " + hargaKwetiaw);
        System.out.println("5. Kambing Guling Spesial       @ Rp. " + hargaKambing);

        System.out.println("\n");
        System.out.println("Pesanan Anda [atas pesanan 0-10 po]");
        System.out.print("1. Nasi Goreng Spesial      = ");
        int totalNasgor = input.nextInt();
        System.out.print("2. Ayam Bakar Spesial       = ");
        int totalAyamBakar = input.nextInt();
        System.out.print("3.Steak Sirloin Spesial     = ");
        int totalSteak = input.nextInt();
        System.out.print("4.Kwetiaw Siram Spesial     = ");
        int totalKwetiaw = input.nextInt();
        System.out.print("5.Kambing Guling Spesial    = ");
        int totalKambing = input.nextInt();

        System.out.println("\n");
        System.out.println("Selamat menikmati makanan anda...");
        System.out.println("Pembelian : ");

        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Nasi Goreng Spesial       "+totalNasgor+ " porsi * Rp. "+ hargaNasgor +" = Rp.       "+df.format(totalNasgor* hargaNasgor));
        System.out.println("Ayam Bakar Spesial        "+totalAyamBakar+ " porsi * Rp." + hargaAyam+ " = Rp.       "+df.format(totalAyamBakar* hargaAyam) );
        System.out.println("Steak Sirloin Spesial     "+totalSteak+ " porsi * Rp." + hargaSteak + " = Rp.       "+df.format(totalSteak * hargaSteak));
        System.out.println("Kwetiaw Siram Spesial     "+totalKwetiaw+ " porsi * Rp."+ hargaKwetiaw +" = Rp.       "+df.format(totalKwetiaw * hargaKwetiaw));
        System.out.println("Kambing Guling Spesial    "+totalKambing+ " porsi * Rp."+ hargaKambing +" = Rp.       "+df.format(totalKambing * hargaNasgor)+" +");
        System.out.println("=========================================================================");

        double total = (totalNasgor * hargaNasgor) + (totalAyamBakar * hargaAyam) + (totalSteak * hargaSteak) + (totalKwetiaw * hargaKwetiaw) + (totalKambing * hargaNasgor),
                disc = total * 10/100,
                totalHarga = total - disc;

        System.out.println("Total Pembelian                                 = Rp.       " +df.format(total));
        System.out.println("\n");
        System.out.println("DIsc 10% <Masa Promosi>                         = Rp.       " +df.format(total * 10/100) +" -");
        System.out.println("==========================================================================");
        System.out.println("Total Pembelian setelah disc 10%                = Rp.       " +df.format(total - disc));
        System.out.println("Pembelian per orang                             = Rp.       " +df.format(totalHarga / jumlahOrang));
        System.out.println("\n");
        System.out.println("                   Terima kasih atas kunjungan anda...");
        System.out.println("                   ...tekan ENTER untuk keluar...");
    }
}