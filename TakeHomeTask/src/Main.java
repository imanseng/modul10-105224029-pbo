public class Main {
    public static void main(String[] args) {
        SistemGudang gudang = new SistemGudang();

        gudang.tambahBarangBaru("B01", "HP", "Elektronik", 10);
        gudang.tambahBarangBaru("B02", "Meja", "Furnitur", 5);
        gudang.tambahBarangBaru("B03", "Kipas", "Elektronik", 25);

        gudang.tambahStok("B01", 5);

        gudang.kurangiStok("B03", 10);

        gudang.kurangiStok("B02", 12);

        gudang.cetakLaporan();
    }
}
