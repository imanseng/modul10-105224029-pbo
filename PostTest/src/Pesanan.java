class Pesanan {
    String namaPemesan;
    Film film;
    String nomorKursi;

    public Pesanan(String namaPemesan, Film film, String nomorKursi) {
        this.namaPemesan = namaPemesan;
        this.film = film;
        this.nomorKursi = nomorKursi;
    }

    public void cetakDetail() {
        System.out.println("Nama: " + namaPemesan + " | Film: " + film.judul + " | Kursi: " + nomorKursi + " | Harga: Rp " + film.harga);
    }
}