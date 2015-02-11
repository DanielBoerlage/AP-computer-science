package hangman;

// THIS CLASS IS DANGEROUS AF
// INSTANTIATE WITH CAUTION
public class Pattern {

    public int bin;
    public int bitSum;

    public Pattern() {
        bin = 0;
        bitSum = 0;
    }

    public Pattern(int bin) {
        this.bin = bin;
        bitSum = 0;
        for(int i = 0; i < 30; i++) {
            bitSum += bin & 1;
            bin >>= 1;
        }
    }

    // basically always prefer the word group that shows the player the least number of chars (bitsum)
    // but if they are the same choose the one that results in the larger word group
    public int isPreferedOver(Pattern other, int thisWordGroupSize, int otherWordGroupSize) {
        if(bitSum < other.bitSum)
            return 1;
        if(bitSum > other.bitSum)
            return -1;
        if(thisWordGroupSize > otherWordGroupSize)
            return 1;
        if(thisWordGroupSize < otherWordGroupSize)
            return -1;
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Pattern)obj).bin == bin;
    }

    // maybe remove ?
    @Override
    public int hashCode() {
        return bin;
    }

    @Override
    public String toString() {
        return String.valueOf(bin);
    }
}
