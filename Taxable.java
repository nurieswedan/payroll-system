public interface Taxable {
    double TAX_RATE = 0.15; // implicitly public static final

    double calculateTax();
}
