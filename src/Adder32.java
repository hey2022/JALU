import java.util.Arrays;

/**
 * The Adder32 class simulates a 32-bit ripple-carry adder.
 * It adds two 32-bit binary numbers and an initial carry-in, producing a 32-bit sum and a carry-out.
 */
public class Adder32 {
    /**
     * The 32-bit sum of the two input binary numbers.
     * The sum is stored in a {@link Bit32} object, representing the individual bits of the result.
     */
    public Bit32 sum;

    /**
     * The carry-out of the 32-bit addition.
     * This indicates whether there was an overflow from the most significant bit.
     */
    public boolean carry;

    /**
     * Initializes a new 32-bit adder with a default sum.
     */
    public Adder32() {
        sum = new Bit32();
    }

    /**
     * Adds two 32-bit binary numbers along with a carry-in.
     *
     * @param a     the first 32-bit binary number, represented as a {@link Bit32} object.
     * @param b     the second 32-bit binary number, represented as a {@link Bit32} object.
     * @param carry the carry-in for the addition, which is applied to the least significant 8 bits.
     */
    public void add(Bit32 a, Bit32 b, boolean carry) {
        Adder8 eightBitAdder1 = new Adder8(); // Handles bits 24-31 (least significant byte).
        Adder8 eightBitAdder2 = new Adder8(); // Handles bits 16-23.
        Adder8 eightBitAdder3 = new Adder8(); // Handles bits 8-15.
        Adder8 eightBitAdder4 = new Adder8(); // Handles bits 0-7 (most significant byte).

        // Add the least significant 8 bits of a and b, with the initial carry-in.
        eightBitAdder1.add(
            new Bit8(Arrays.copyOfRange(a.bits(), 24, 32)),
            new Bit8(Arrays.copyOfRange(b.bits(), 24, 32)),
            carry
        );

        // Add the next 8 bits of a and b, with the carry-out from the previous addition.
        eightBitAdder2.add(
            new Bit8(Arrays.copyOfRange(a.bits(), 16, 24)),
            new Bit8(Arrays.copyOfRange(b.bits(), 16, 24)),
            eightBitAdder1.carry
        );

        // Add the next 8 bits of a and b, with the carry-out from the previous addition.
        eightBitAdder3.add(
            new Bit8(Arrays.copyOfRange(a.bits(), 8, 16)),
            new Bit8(Arrays.copyOfRange(b.bits(), 8, 16)),
            eightBitAdder2.carry
        );

        // Add the most significant 8 bits of a and b, with the carry-out from the previous addition.
        eightBitAdder4.add(
            new Bit8(Arrays.copyOfRange(a.bits(), 0, 8)),
            new Bit8(Arrays.copyOfRange(b.bits(), 0, 8)),
            eightBitAdder3.carry
        );

        // Combine the results into the 32-bit sum.
        sum = new Bit32();
        System.arraycopy(eightBitAdder1.sum.bits(), 0, sum.bits(), 24, 8);
        System.arraycopy(eightBitAdder2.sum.bits(), 0, sum.bits(), 16, 8);
        System.arraycopy(eightBitAdder3.sum.bits(), 0, sum.bits(), 8, 8);
        System.arraycopy(eightBitAdder4.sum.bits(), 0, sum.bits(), 0, 8);

        // Store the final carry-out from the most significant 8-bit addition.
        this.carry = eightBitAdder4.carry;
    }
}
