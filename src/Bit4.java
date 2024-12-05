/**
 * The Bit4 class represents a 4-bit binary number.
 * It extends the abstract {@link Bit} class and provides a fixed bit length of 4.
 * The class supports initialization using various formats, including boolean arrays, strings, and integers.
 */
public class Bit4 extends Bit {
    /**
     * Default constructor.
     * Initializes the 4-bit binary number to all zeros.
     */
    public Bit4() {
        super();
    }

    /**
     * Constructor that initializes the 4-bit binary number using a boolean array.
     *
     * @param bits the boolean array representing the binary number.
     * @throws IllegalArgumentException if the length of the array is not 4.
     */
    public Bit4(boolean[] bits) {
        super(bits);
    }

    /**
     * Constructor that initializes the 4-bit binary number using a binary string.
     *
     * @param string the string representation of the binary number (e.g., "1010").
     * @throws IllegalArgumentException if the length of the string is not 4.
     */
    public Bit4(String string) {
        super(string);
    }

    /**
     * Constructor that initializes the 4-bit binary number using an integer value.
     * The integer is converted to a 4-bit binary representation.
     *
     * @param number the integer value to be represented as a 4-bit binary number.
     */
    public Bit4(int number) {
        super(number);
    }

    /**
     * Returns the fixed bit length for this binary number.
     *
     * @return the integer 4, representing the bit length of the binary number.
     */
    @Override
    public int getBitLength() {
        return 4;
    }
}
