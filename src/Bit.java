public abstract class Bit {
    private boolean[] bits;

    public Bit() {
        this.bits = new boolean[getBitLength()];
    }

    public Bit(boolean[] bits) {
        setBits(bits);
    }

    public Bit(String string) {
        setString(string);
    }

    public Bit(int number) {
        setInt(number);
    }

    public abstract int getBitLength();

    public void setBits(boolean[] number) {
        if (number.length != getBitLength()) {
            throw new IllegalArgumentException("Array length must be equal to bit length");
        }
        this.bits = number;
    }

    public boolean[] bits() {
        return this.bits;
    }

    public void setInt(int number) {
        this.bits = new boolean[getBitLength()];
        for (int i = 0; i < getBitLength(); i++) {
            this.bits[i] = (number & (1 << (getBitLength() - i - 1))) != 0;
        }
    }

    public int toInt() {
        int result = 0;
        for (int i = 0; i < getBitLength(); i++) {
            result <<= 1;
            if (this.bits[i]) {
                result += 1;
            }
        }
        return result;
    }

    public void setString(String string) {
        if (string.length() != getBitLength()) {
            throw new IllegalArgumentException("String length must be equal to bit length");
        }
        this.bits = new boolean[getBitLength()];
        for (int i = 0; i < getBitLength(); i++) {
            this.bits[i] = string.charAt(i) == '1';
        }
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < getBitLength(); i++) {
            result += bits[i] ? "1" : "0";
        }
        return result;
    }

    public boolean getBit(int index) {
        return this.bits[index];
    }

    public void setBit(int index, boolean value) {
        this.bits[index] = value;
    }
}
