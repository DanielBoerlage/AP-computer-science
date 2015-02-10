package hangman;

public class Pattern {

    private int bits;

    public Pattern(int bits) {
        this.bits = bits;
    }

    public void setBit(boolean bit, int depth) {
        bits = ((bits >> depth) & (bit ? 1 : 0)) << depth;
    }

    public int hashCode() {
        return bits;
    }

    public String toString() {
        return String.valueOf(bits);
    }
}
