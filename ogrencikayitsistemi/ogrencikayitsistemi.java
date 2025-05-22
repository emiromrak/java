import java.io.*;
import java.util.*;

class Ogrenci {
    String adi;
    String soyadi;
    int sinif;
    char cinsiyet;
    int numara;

    Ogrenci(String adi, String soyadi, int sinif, char cinsiyet, int numara) {
        this.adi = adi;
        this.soyadi = soyadi;
        this.sinif = sinif;
        this.cinsiyet = cinsiyet;
        this.numara = numara;
    }

    @Override
    public String toString() {
        return adi + " " + soyadi + " " + sinif + " " + cinsiyet + " " + numara;
    }
}

public class ogrencikayitsistemi {

    public static final String DOSYA_ADI = "Ogrenciler.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[1] Bilgi Gir");
            System.out.println("[2] Öğrenci Arama");
            System.out.println("[3] Öğrenci Silme");
            System.out.println("[4] Çıkış");
            System.out.print("Secim Yapınız: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // newline karakterini temizleme

            switch (secim) {
                case 1:
                    bilgiGir(scanner);
                    break;
                case 2:
                    ogrenciArama(scanner);
                    break;
                case 3:
                    ogrenciSil(scanner);
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim. Tekrar deneyin.");
            }
        }
    }

    public static void bilgiGir(Scanner scanner) {
        System.out.print("Öğrenci Numarası: ");
        int numara = scanner.nextInt();
        scanner.nextLine();

        if (ogrenciVarMi(numara)) {
            System.out.println("Bu numaraya sahip bir öğrenci zaten var!");
            return;
        }

        System.out.print("Öğrenci Adı: ");
        String adi = scanner.nextLine();
        System.out.print("Öğrenci Soyadı: ");
        String soyadi = scanner.nextLine();
        System.out.print("Öğrenci Sınıfı: ");
        int sinif = scanner.nextInt();
        System.out.print("Öğrenci Cinsiyeti (E/K): ");
        char cinsiyet = scanner.next().charAt(0);

        Ogrenci ogrenci = new Ogrenci(adi, soyadi, sinif, cinsiyet, numara);
        ogrenciEkle(ogrenci);
    }

    public static boolean ogrenciVarMi(int numara) {
        List<Ogrenci> ogrenciler = ogrencileriOku();
        for (Ogrenci ogrenci : ogrenciler) {
            if (ogrenci.numara == numara) {
                return true;
            }
        }
        return false;
    }

    public static void ogrenciEkle(Ogrenci ogrenci) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DOSYA_ADI, true))) {
            writer.write(ogrenci.toString());
            writer.newLine();
            System.out.println("Öğrenci başarıyla eklendi.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Ogrenci> ogrencileriOku() {
        List<Ogrenci> ogrenciler = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DOSYA_ADI))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                String[] parcalar = satir.split(" ");
                if (parcalar.length == 5) {
                    String adi = parcalar[0];
                    String soyadi = parcalar[1];
                    int sinif = Integer.parseInt(parcalar[2]);
                    char cinsiyet = parcalar[3].charAt(0);
                    int numara = Integer.parseInt(parcalar[4]);
                    ogrenciler.add(new Ogrenci(adi, soyadi, sinif, cinsiyet, numara));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ogrenciler;
    }

    public static void ogrenciArama(Scanner scanner) {
        System.out.println("[1] Öğrenci Numarasına Göre Ara");
        System.out.println("[2] Öğrenci Adına Göre Ara");
        System.out.print("Seçim Yapınız: ");
        int secim = scanner.nextInt();
        scanner.nextLine();

        switch (secim) {
            case 1:
                System.out.print("Öğrenci Numarası: ");
                int numara = scanner.nextInt();
                ogrenciAraNumarayaGore(numara);
                break;
            case 2:
                System.out.print("Öğrenci Adı: ");
                String adi = scanner.nextLine();
                ogrenciAraAdaGore(adi);
                break;
            default:
                System.out.println("Geçersiz seçim.");
        }
    }

    public static void ogrenciAraNumarayaGore(int numara) {
        List<Ogrenci> ogrenciler = ogrencileriOku();
        for (Ogrenci ogrenci : ogrenciler) {
            if (ogrenci.numara == numara) {
                System.out.println("Öğrenci Bulundu: " + ogrenci);
                return;
            }
        }
        System.out.println("Öğrenci bulunamadı.");
    }

    public static void ogrenciAraAdaGore(String adi) {
        List<Ogrenci> ogrenciler = ogrencileriOku();
        for (Ogrenci ogrenci : ogrenciler) {
            if (ogrenci.adi.equalsIgnoreCase(adi)) {
                System.out.println("Öğrenci Bulundu: " + ogrenci);
                return;
            }
        }
        System.out.println("Öğrenci bulunamadı.");
    }

    public static void ogrenciSil(Scanner scanner) {
        System.out.print("Silinecek Öğrencinin Numarası: ");
        int numara = scanner.nextInt();

        List<Ogrenci> ogrenciler = ogrencileriOku();
        boolean silindi = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DOSYA_ADI))) {
            for (Ogrenci ogrenci : ogrenciler) {
                if (ogrenci.numara == numara) {
                    silindi = true;
                } else {
                    writer.write(ogrenci.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (silindi) {
            System.out.println("Öğrenci başarıyla silindi.");
        } else {
            System.out.println("Bu numaraya sahip bir öğrenci bulunamadı.");
        }
    }
}



  
    

