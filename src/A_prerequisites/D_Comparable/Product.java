package A_prerequisites.D_Comparable;

public class Product implements Comparable<Product> {
    private int id;
    private double price;
    private String name;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "id=" + id + "\t price=" + price + "\t name=" + name;
    }

    /**
     * Compares Products based on price, 
     * then (if the prices are equal) by name alphabetically, 
     * and then (if the names are also equal) by id.
     */
    @Override
    public int compareTo(Product other) {
        int priceComparison = Double.compare(this.price, other.price);
        if (priceComparison != 0) { // the prices are not equal
            return priceComparison;
        }

        // if the prices are equal...
        
        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison != 0) { // the names are not equal
            return nameComparison;
        }

        // if the names are also equal

        int idComparison = Integer.compare(this.id, other.id);
        return idComparison;
    }
}