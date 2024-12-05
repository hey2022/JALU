/**
 * The FullAdder class simulates the behavior of a full-adder circuit.
 * A full-adder is a digital circuit that computes the sum and carry of three binary inputs:
 * two significant bits and a carry-in bit.
 */
public class FullAdder {
    /**
     * The sum of the three binary inputs. It is computed using two half-adders.
     */
    public boolean sum;

    /**
     * The carry output of the three binary inputs. It is computed based on the carry outputs
     * of two half-adders.
     */
    public boolean carry;

    /**
     * Computes the sum and carry of three binary inputs.
     *
     * @param a the first binary input.
     * @param b the second binary input.
     * @param c the carry-in binary input.
     */
    public void add(boolean a, boolean b, boolean c) {
        HalfAdder halfAdder1 = new HalfAdder();
        HalfAdder halfAdder2 = new HalfAdder();

        // First half-adder processes the first two inputs.
        halfAdder1.add(a, b);

        // Second half-adder processes the sum of the first half-adder and the carry-in.
        halfAdder2.add(halfAdder1.sum, c);

        // The final sum is the sum output of the second half-adder.
        this.sum = halfAdder2.sum;

        // The final carry is the OR of the carry outputs from both half-adders.
        this.carry = halfAdder1.carry || halfAdder2.carry;
    }
}
