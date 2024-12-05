/**
 * The Bit32 class represents a 32-bit binary number.
 * It extends the abstract {@link Bit} class and provides a fixed bit length of 32.
 * The class supports initialization using various formats, including boolean arrays, strings, and integers.
 */
public class Bit32 extends Bit {
    /**
     * Default constructor.
     * Initializes the 32-bit binary number to all zeros.
     */
    public Bit32() {
        super();
    }

    /**
     * Constructor that initializes the 32-bit binary number using a boolean array.
     *
     * @param bits the boolean array representing the binary number.
     * @throws IllegalArgumentException if the length of the array is not 32.
     */
    public Bit32(boolean[] bits) {
        super(bits);
    }

    /**
     * Constructor that initializes the 32-bit binary number using a binary string.
     *
     * @param string the string representation of the binary number (e.g., "10101010101010101010101010101010").
     * @throws IllegalArgumentException if the length of the string is not 32.
     */
    public Bit32(String string) {
        super(string);
    }

    /**
     * Constructor that initializes the 32-bit binary number using an integer value.
     * The integer is converted to a binary representation.
     *
     * @param number the integer value to be represented as a 32-bit binary number.
     */
    public Bit32(int number) {
        super(number);
    }

    /**
     * Returns the fixed bit length for this binary number.
     *
     * @return the integer 32, representing the bit length of the binary number.
     */
    @Override
    public int getBitLength() {
        return 32;
    }
}
