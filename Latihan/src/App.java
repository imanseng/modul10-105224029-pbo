import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Map<String, Buku> daftarBuku = new HashMap<>();

        daftarBuku.put("1234", new Buku("1234", "Pemrograman Java"));
        daftarBuku.put("5678", new Buku("5678", "Pemrograman C++"));
        daftarBuku.put("9012", new Buku("9012", "Pemrograman Python"));

        Set<Anggota> daftarAnggota = new HashSet<>();
        daftarAnggota.add(new Anggota("1234", "Budi", "Dosen"));
        daftarAnggota.add(new Anggota("1234", "Siti", "Dosen"));
        daftarAnggota.add(new Anggota("2832", "Andi", "Mahasiswa"));
        daftarAnggota.add(new Anggota("3938", "Toni", "Mahasiswa"));

        LinkedList<String> daftarPeminjaman = new LinkedList<>();
        for (Anggota anggota : daftarAnggota) {
            if (anggota.tipe.equals("Dosen")) {
            daftarPeminjaman.addFirst(anggota.idAnggota + "#" + daftarBuku.get("1234").isbn);
            } else if (anggota.tipe.equals("Mahasiswa")) {
            daftarPeminjaman.addLast(anggota.idAnggota + "#" + daftarBuku.get("5678").isbn);
            }
        }

        List<Buku> bukuSedangDipinjam = new ArrayList<>();
        while (!daftarPeminjaman.isEmpty()) {
            String dataPeminjaman = daftarPeminjaman.removeFirst();
            String[] bagian = dataPeminjaman.split("#");
            String idAnggota = bagian[0];
            String isbn = bagian[1];
            boolean isAnggotaValid = false;
            String namaAnggota = "";
            for (Anggota anggota : daftarAnggota) {
                if (anggota.idAnggota.equals(idAnggota)) {
                    isAnggotaValid = true;
                    namaAnggota = anggota.nama;
                    break;
                }
            }

            boolean isBukuValid = daftarBuku.containsKey(isbn);
            boolean isSedangDipinjam = false;

            for (Buku b : bukuSedangDipinjam) {
                if (b.isbn.equals(isbn)) {
                    isSedangDipinjam = true;
                    break;
                }
            }

            if (!isAnggotaValid) {
                System.out.println("Gagal Anggota dengan ID (" + idAnggota + ") tidak terdaftar.");
            } else if (!isBukuValid) {
                System.out.println("Gagal Buku dengan ISBN (" + isbn + ") tidak ditemukan di katalog.");
            } else if (isSedangDipinjam) {
                System.out.println("Gagal Buku " + daftarBuku.get(isbn).judul + " sedang dipinjam oleh orang lain.");
            } else {
                Buku bukuDipinjam = daftarBuku.get(isbn);
                bukuSedangDipinjam.add(bukuDipinjam);
                System.out.println(namaAnggota + " meminjam buku '" + bukuDipinjam.judul + "'.");
            }
        }
    }
}
