import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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

        for (String peminjaman : daftarPeminjaman) {
            System.out.println(peminjaman);
        }
    }
}
