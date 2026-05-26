import java.util.*;

public class Bioskop {
    public static void main(String[] args) {
        Map<String, Film> jadwal = new HashMap<>();
        jadwal.put("F01", new Film("Ya Apa", 45000));
        jadwal.put("F02", new Film("Ya itu", 40000));
        jadwal.put("F03", new Film("Ya ituah", 35000));

        Set<String> kursiPenonton = new HashSet<>();
        List<Pesanan> riwayatTransaksi = new ArrayList<>();

        pesanFilm("Iman", "F01", "A1", jadwal, kursiPenonton, riwayatTransaksi);
        pesanFilm("Gio", "F02", "B4", jadwal, kursiPenonton, riwayatTransaksi);
        pesanFilm("Zaii", "F01", "C2", jadwal, kursiPenonton, riwayatTransaksi);
        pesanFilm("Intan", "F01", "A1", jadwal, kursiPenonton, riwayatTransaksi);

        for (Pesanan p : riwayatTransaksi) {
            p.cetakDetail();
        }
    }

    public static void pesanFilm(String nama, String kodeFilm, String kursi, Map<String, Film> jadwal, Set<String> kursiTerpesan, List<Pesanan> riwayat) {
        if (!jadwal.containsKey(kodeFilm)) {
            System.out.println("Kode film " + kodeFilm + " tidak valid.");
            return;
        }

        Film filmDipilih = jadwal.get(kodeFilm);

        if (!kursiTerpesan.add(kursi)) {
            System.out.println("Kursi " + kursi + " sudah dipesan untuk film " + filmDipilih.judul + ".");
            return;
        }

        Pesanan pesananBaru = new Pesanan(nama, filmDipilih, kursi);
        riwayat.add(pesananBaru);
        System.out.println("Berhasil memesan kursi " + kursi + " untuk film " + filmDipilih.judul + ".");
    }
}