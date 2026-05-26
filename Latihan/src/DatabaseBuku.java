import java.util.*;

class Buku {
    String isbn;
    String judul;

    public Buku(String isbn, String judul) {
        this.isbn = isbn;
        this.judul = judul;
    }
}

public class DatabaseBuku {
    public static void main(String[] args) {
        Map<String, Buku> daftarBuku = new HashMap<>();

        daftarBuku.put("1234", new Buku("1234", "Pemrograman Java"));
        daftarBuku.put("5678", new Buku("5678", "Pemrograman C++"));
        daftarBuku.put("9012", new Buku("9012", "Pemrograman Python"));
    }
}
