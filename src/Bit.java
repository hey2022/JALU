/**
 * The Bit class is an abstract base class representing a fixed-length binary number.
 * It provides utility methods to manage and convert the binary representation.
 * Subclasses must define the bit length by implementing the {@link #getBitLength()} method.
 */
public abstract class Bit {
    /**
     * The internal array storing the binary representation as boolean values.
     * Each index represents a bit, where `true` is 1 and `false` is 0.
     */
    private boolean[] bits;

    /**
     * Default constructor.
     * Initializes the bit array to all zeros with the length specified by {@link #getBitLength()}.
     */
    public Bit() {
        this.bits = new boolean[getBitLength()];
    }

    /**
     * Constructor that initializes the bit array using a provided boolean array.
     *
     * @param bits the boolean array representing the binary number.
     * @throws IllegalArgumentException if the length of the array is not equal to {@link #getBitLength()}.
     */
    public Bit(boolean[] bits) {
        setBits(bits);
    }

    /**
     * Constructor that initializes the bit array using a binary string.
     *
     * @param string the string representation of the binary number (e.g., "1010").
     * @throws IllegalArgumentException if the length of the string is not equal to {@link #getBitLength()}.
     */
    public Bit(String string) {
        setString(string);
    }

    /**
     * Constructor that initializes the bit array using an integer value.
     * The integer is converted to a binary representation.
     *
     * @param number the integer value to be represented as binary.
     */
    public Bit(int number) {
        setInt(number);
    }

    /**
     * Returns the fixed bit length for this binary representation.
     * This method must be implemented by subclasses.
     *
     * @return the bit length as an integer.
     */
    public abstract int getBitLength();

    /**
     * Sets the bit array using a provided boolean array.
     *
     * @param number the boolean array to set.
     * @throws IllegalArgumentException if the array length is not equal to {@link #getBitLength()}.
     */
    public void setBits(boolean[] number) {
        if (number.length != getBitLength()) {
            throw new IllegalArgumentException("Array length must be equal to bit length");
        }
        this.bits = number;
    }

    /**
     * Returns the bit array representing the binary number.
     *
     * @return the boolean array of bits.
     */
    public boolean[] bits() {
        return this.bits;
    }

    /**
     * Sets the bit array using an integer value.
     * The integer is converted to binary, with the most significant bit at index 0.
     *
     * @param number the integer value to be represented as binary.
     */
    public void setInt(int number) {
        this.bits = new boolean[getBitLength()];
        for (int i = 0; i < getBitLength(); i++) {
            this.bits[i] = (number & (1 << (getBitLength() - i - 1))) != 0;
        }
    }

    /**
     * Converts the bit array to an integer value.
     * Interprets the binary representation as an unsigned integer.
     *
     * @return the integer representation of the binary number.
     */
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

    /**
     * Sets the bit array using a binary string.
     *
     * @param string the string representation of the binary number (e.g., "1010").
     * @throws IllegalArgumentException if the string length is not equal to {@link #getBitLength()}.
     */
    public void setString(String string) {
        if (string.length() != getBitLength()) {
            throw new IllegalArgumentException("String length must be equal to bit length");
        }
        this.bits = new boolean[getBitLength()];
        for (int i = 0; i < getBitLength(); i++) {
            this.bits[i] = string.charAt(i) == '1';
        }
    }

    /**
     * Converts the bit array to a binary string representation.
     *
     * @return the string representation of the binary number.
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < getBitLength(); i++) {
            result += bits[i] ? "1" : "0";
        }
        return result;
    }

    /**
     * Returns the value of the bit at a specified index.
     *
     * @param index the index of the bit to retrieve.
     * @return the boolean value of the bit at the specified index.
     */
    public boolean getBit(int index) {
        return this.bits[index];
    }

    /**
     * Sets the value of the bit at a specified index.
     *
     * @param index the index of the bit to set.
     * @param value the value to set (true for 1, false for 0).
     */
    public void setBit(int index, boolean value) {
        this.bits[index] = value;
    }
}
