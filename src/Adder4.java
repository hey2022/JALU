/**
 * The Adder4 class simulates a 4-bit ripple-carry adder.
 * It adds two 4-bit binary numbers and an initial carry-in, producing a 4-bit sum and a carry-out.
 */
public class Adder4 {
    /**
     * The 4-bit sum of the two input binary numbers.
     * The sum is stored in a {@link Bit4} object, representing the individual bits of the result.
     */
    public Bit4 sum;

    /**
     * The carry-out of the 4-bit addition.
     * This indicates whether there was an overflow from the most significant bit.
     */
    public boolean carry;

    /**
     * Initializes a new 4-bit adder with a default sum.
     */
    public Adder4() {
        sum = new Bit4();
    }

    /**
     * Adds two 4-bit binary numbers along with a carry-in.
     * The addition is performed bit by bit, starting from the least significant bit (LSB)
     * and propagating the carry to the most significant bit (MSB).
     *
     * @param a     the first 4-bit binary number, represented as a {@link Bit4} object.
     * @param b     the second 4-bit binary number, represented as a {@link Bit4} object.
     * @param carry the carry-in for the addition, which is applied to the least significant bit.
     */
    public void add(Bit4 a, Bit4 b, boolean carry) {
        FullAdder fullAdder = new FullAdder();

        // Add the least significant bits (bit 3)
        fullAdder.add(a.getBit(3), b.getBit(3), carry);
        sum.setBit(3, fullAdder.sum);

        // Add the next bit (bit 2)
        fullAdder.add(a.getBit(2), b.getBit(2), fullAdder.carry);
        sum.setBit(2, fullAdder.sum);

        // Add bit 1
        fullAdder.add(a.getBit(1), b.getBit(1), fullAdder.carry);
        sum.setBit(1, fullAdder.sum);

        // Add the most significant bits (bit 0)
        fullAdder.add(a.getBit(0), b.getBit(0), fullAdder.carry);
        sum.setBit(0, fullAdder.sum);

        // Store the final carry-out from the most significant bit.
        this.carry = fullAdder.carry;
    }
}
