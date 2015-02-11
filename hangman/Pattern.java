package hangman;

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
    public boolean isPreferedOver(Pattern other, int thisWordGroupSize, int otherWordGroupSize) {
        if(bitSum < other.bitSum)
            return true;
        if(bitSum > other.bitSum)
            return false;
        return thisWordGroupSize > otherWordGroupSize;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Pattern)obj).bin == bin;
    }

    @Override
    public int hashCode() {
        return bitSum;
    }

    @Override
    public String toString() {
        return String.valueOf(bin);
    }
}
