import java.util.Arrays;

/**
 * The Adder8 class simulates an 8-bit ripple-carry adder.
 * It adds two 8-bit binary numbers and an initial carry-in, producing an 8-bit sum and a carry-out.
 */
public class Adder8 {
    /**
     * The 8-bit sum of the two input binary numbers.
     * The sum is stored in a {@link Bit8} object, representing the individual bits of the result.
     */
    public Bit8 sum;

    /**
     * The carry-out of the 8-bit addition.
     * This indicates whether there was an overflow from the most significant bit.
     */
    public boolean carry;

    /**
     * Initializes a new 8-bit adder with a default sum.
     */
    public Adder8() {
        sum = new Bit8();
    }

    /**
     * Adds two 8-bit binary numbers along with a carry-in.
     *
     * @param a     the first 8-bit binary number, represented as a {@link Bit8} object.
     * @param b     the second 8-bit binary number, represented as a {@link Bit8} object.
     * @param carry the carry-in for the addition, which is applied to the least significant 4 bits.
     */
    public void add(Bit8 a, Bit8 b, boolean carry) {
        Adder4 fourBitAdder1 = new Adder4(); // Handles the least significant 4 bits.
        Adder4 fourBitAdder2 = new Adder4(); // Handles the most significant 4 bits.

        // Add the least significant 4 bits of a and b, with the initial carry-in.
        fourBitAdder1.add(
            new Bit4(Arrays.copyOfRange(a.bits(), 4, 8)),
            new Bit4(Arrays.copyOfRange(b.bits(), 4, 8)),
            carry
        );

        // Add the most significant 4 bits of a and b, with the carry-out from the first 4-bit addition.
        fourBitAdder2.add(
            new Bit4(Arrays.copyOfRange(a.bits(), 0, 4)),
            new Bit4(Arrays.copyOfRange(b.bits(), 0, 4)),
            fourBitAdder1.carry
        );

        // Combine the results into the 8-bit sum.
        sum = new Bit8();
        System.arraycopy(fourBitAdder1.sum.bits(), 0, sum.bits(), 4, 4);
        System.arraycopy(fourBitAdder2.sum.bits(), 0, sum.bits(), 0, 4);

        // Store the final carry-out from the most significant 4-bit addition.
        this.carry = fourBitAdder2.carry;
    }
}
