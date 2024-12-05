/**
 * The Bit8 class represents an 8-bit binary number.
 * It extends the abstract {@link Bit} class and provides a fixed bit length of 8.
 * The class supports initialization using various formats, including boolean arrays, strings, and integers.
 */
public class Bit8 extends Bit {
    /**
     * Default constructor.
     * Initializes the 8-bit binary number to all zeros.
     */
    public Bit8() {
        super();
    }

    /**
     * Constructor that initializes the 8-bit binary number using a boolean array.
     *
     * @param bits the boolean array representing the binary number.
     * @throws IllegalArgumentException if the length of the array is not 8.
     */
    public Bit8(boolean[] bits) {
        super(bits);
    }

    /**
     * Constructor that initializes the 8-bit binary number using a binary string.
     *
     * @param string the string representation of the binary number (e.g., "10101010").
     * @throws IllegalArgumentException if the length of the string is not 8.
     */
    public Bit8(String string) {
        super(string);
    }

    /**
     * Constructor that initializes the 8-bit binary number using an integer value.
     * The integer is converted to an 8-bit binary representation.
     *
     * @param value the integer value to be represented as an 8-bit binary number.
     */
    public Bit8(int value) {
        super(value);
    }

    /**
     * Returns the fixed bit length for this binary number.
     *
     * @return the integer 8, representing the bit length of the binary number.
     */
    @Override
    public int getBitLength() {
        return 8;
    }
}
