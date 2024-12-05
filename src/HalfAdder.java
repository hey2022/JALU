/**
 * The HalfAdder class simulates the behavior of a basic half-adder circuit.
 * A half-adder is a digital circuit that computes the sum and carry of two binary inputs.
 */
public class HalfAdder {
    /**
     * The sum of the two binary inputs. It is computed as the XOR of the inputs.
     */
    public boolean sum;

    /**
     * The carry output of the two binary inputs. It is computed as the AND of the inputs.
     */
    public boolean carry;

    /**
     * Computes the sum and carry of two binary inputs.
     *
     * @param a the first binary input.
     * @param b the second binary input.
     */
    public void add(boolean a, boolean b) {
        this.sum = a ^ b;
        this.carry = a && b;
    }
}
