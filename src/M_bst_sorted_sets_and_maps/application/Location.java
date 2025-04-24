package M_bst_sorted_sets_and_maps.application;

// a location within a file
public record Location(int lineNumber, int columnNumber) {
    @Override
    public String toString() {
        return "(" + lineNumber + ", " + columnNumber + ")";
    }
}
