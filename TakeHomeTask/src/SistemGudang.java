import java.util.*;

class SistemGudang {
    private Map<String, Barang> databaseBarang;
    private Set<String> kategoriUnik;
    private List<String> riwayatAktivitas;

    public SistemGudang() {
        this.databaseBarang = new HashMap<>();
        this.kategoriUnik = new HashSet<>();
        this.riwayatAktivitas = new ArrayList<>();
    }

    public void tambahBarangBaru(String id, String nama, String kategori, int stok) {
        if (!databaseBarang.containsKey(id)) {
            Barang barangBaru = new Barang(id, nama, kategori, stok);
            databaseBarang.put(id, barangBaru);
            kategoriUnik.add(kategori);
            riwayatAktivitas.add("Barang Baru Dutambah: " + id + " - " + nama + " (" + kategori + ") sebanyak " + stok + " unit");
        } else {
            riwayatAktivitas.add("Gagal Daftar: ID " + id + " sudah terpakai.");
        }
    }

    public void tambahStok(String id, int jumlah) {
        Barang barang = databaseBarang.get(id);
        if (barang != null) {
            barang.setStok(barang.getStok() + jumlah);
            riwayatAktivitas.add("Barang Masuk: " + id + " ditambah " + jumlah + " unit");
        } else {
            riwayatAktivitas.add("Gagal Tambah Stok: ID " + id + " tidak ditemukan.");
        }
    }

    public void kurangiStok(String id, int jumlah) {
        Barang barang = databaseBarang.get(id);
        if (barang == null) {
            riwayatAktivitas.add("Gagal Kurang Stok: ID " + id + " tidak ditemukan.");
            System.out.println("Transaksi Gagal: ID " + id + " tidak ditemukan.");
            return;
        }

        if (barang.getStok() >= jumlah) {
            barang.setStok(barang.getStok() - jumlah);
            riwayatAktivitas.add("Barang Keluar: " + id + " dikurangi " + jumlah + " unit");
        } else {
            riwayatAktivitas.add("Gagal Kurang Stok: " + id + " stok tidak mencukupi (Sisa: " + barang.getStok() + ", Diminta: " + jumlah + ")");
            System.out.println("Transaksi Gagal: Stok " + id + " tidak mencukupi.");
        }
    }

    public void cetakLaporan() {
        System.out.println("DAFTAR KATEGORI UNIK");
        for (String kat : kategoriUnik) {
            System.out.println("- " + kat);
        }

        System.out.println("SISA STOK BARANG");
        for (Barang b : databaseBarang.values()) {
            System.out.println(b.getIdBarang() + " - " + b.getNamaBarang() + " (" + b.getKategori() + ") : " + b.getStok() + " unit");
        }

        System.out.println("RIWAYAT AKTIVITAS TRANSAKSI");
        for (String riwayat : riwayatAktivitas) {
            System.out.println("- " + riwayat);
        }
    }
}