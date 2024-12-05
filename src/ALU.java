/**
 * The ALU (Arithmetic Logic Unit) class performs various arithmetic and logical operations
 * on 32-bit binary numbers represented by the {@link Bit32} class. It supports operations such as
 * addition, subtraction, increment, decrement, bitwise operations (AND, OR, XOR), shifts, and rotations.
 * The result of the operation is stored in the {@code sum} field, and additional flags for carry
 * and zero are also updated where necessary.
 */
public class ALU {
    /**
     * The 32-bit result of the ALU operation.
     */
    public Bit32 sum;

    /**
     * The carry flag, which is set to true if the operation generates a carry out.
     */
    public boolean carry;

    /**
     * The zero flag, which is set to true if the result of the operation is zero.
     */
    public boolean zero;

    /**
     * Executes an ALU operation with one operand.
     * This method calls the {@link #execute(Opcode, Bit32, Bit32, boolean)} method with a zero value for the second operand and no carry.
     *
     * @param opcode the opcode that specifies the operation to be performed.
     * @param a the first operand (32-bit binary number).
     */
    public void execute(final Opcode opcode, final Bit32 a) {
        execute(opcode, a, new Bit32(0), false);
    }

    /**
     * Executes an ALU operation with two operands.
     * This method calls the {@link #execute(Opcode, Bit32, Bit32, boolean)} method with no carry.
     *
     * @param opcode the opcode that specifies the operation to be performed.
     * @param a the first operand (32-bit binary number).
     * @param b the second operand (32-bit binary number).
     */
    public void execute(final Opcode opcode, final Bit32 a, final Bit32 b) {
        execute(opcode, a, b, false);
    }

    /**
     * Executes an ALU operation with two operands and a carry-in value.
     *
     * @param opcode the opcode that specifies the operation to be performed.
     * @param a the first operand (32-bit binary number).
     * @param b the second operand (32-bit binary number).
     * @param carry the carry-in value for the operation.
     */
    public void execute(final Opcode opcode, final Bit32 a, final Bit32 b, final boolean carry) {
        switch (opcode) {
            case Add:
                add(a, b, carry);
                break;
            case Sub:
                sub(a, b);
                break;
            case Increment:
                increment(a);
                break;
            case Decrement:
                decrement(a);
                break;
            case TwoComplement:
                twoComplement(a);
                break;
            case OneComplement:
                oneComplement(a);
                break;
            case And:
                and(a, b);
                break;
            case Or:
                or(a, b);
                break;
            case Xor:
                xor(a, b);
                break;
            case LeftShift:
                leftShift(a);
                break;
            case RightShift:
                rightShift(a);
                break;
            case LeftRotate:
                leftRotate(a);
                break;
            case RightRotate:
                rightRotate(a);
                break;
            default:
                throw new IllegalArgumentException("Invalid opcode");
        }
    }

    /**
     * Adds two 32-bit binary numbers with a carry-in value.
     *
     * @param a the first operand (32-bit binary number).
     * @param b the second operand (32-bit binary number).
     * @param carry the carry-in value for the addition.
     */
    private void add(final Bit32 a, final Bit32 b, final boolean carry) {
        final Adder32 adder = new Adder32();
        adder.add(a, b, carry);
        this.sum = adder.sum;
        this.carry = adder.carry;
    }

    /**
     * Subtracts the second operand from the first operand by calculating the two's complement of the second operand,
     * and then adding it to the first operand.
     *
     * @param a the first operand (32-bit binary number).
     * @param b the second operand (32-bit binary number).
     */
    private void sub(final Bit32 a, final Bit32 b) {
        oneComplement(b);
        add(a, sum, true);
    }

    /**
     * Increments the given 32-bit binary number by 1.
     *
     * @param a the operand (32-bit binary number).
     */
    private void increment(final Bit32 a) {
        add(a, new Bit32(1), false);
    }

    /**
     * Decrements the given 32-bit binary number by 1.
     *
     * @param a the operand (32-bit binary number).
     */
    private void decrement(final Bit32 a) {
        sub(a, new Bit32(1));
    }

    /**
     * Computes the two's complement of a 32-bit binary number.
     *
     * @param a the operand (32-bit binary number).
     */
    private void twoComplement(final Bit32 a) {
        oneComplement(a);
        increment(sum);
    }

    /**
     * Computes the one's complement (bitwise NOT) of a 32-bit binary number.
     *
     * @param a the operand (32-bit binary number).
     */
    private void oneComplement(final Bit32 a) {
        for (int i = 0; i < 32; i++) {
            sum.setBit(i, !a.getBit(i));
        }
    }

    /**
     * Performs a bitwise AND operation on two 32-bit binary numbers.
     *
     * @param a the first operand (32-bit binary number).
     * @param b the second operand (32-bit binary number).
     */
    private void and(final Bit32 a, final Bit32 b) {
        for (int i = 0; i < 32; i++) {
            sum.setBit(i, a.getBit(i) && b.getBit(i));
        }
    }

    /**
     * Performs a bitwise OR operation on two 32-bit binary numbers.
     *
     * @param a the first operand (32-bit binary number).
     * @param b the second operand (32-bit binary number).
     */
    private void or(final Bit32 a, final Bit32 b) {
        for (int i = 0; i < 32; i++) {
            sum.setBit(i, a.getBit(i) || b.getBit(i));
        }
    }

    /**
     * Performs a bitwise XOR operation on two 32-bit binary numbers.
     *
     * @param a the first operand (32-bit binary number).
     * @param b the second operand (32-bit binary number).
     */
    private void xor(final Bit32 a, final Bit32 b) {
        for (int i = 0; i < 32; i++) {
            sum.setBit(i, a.getBit(i) ^ b.getBit(i));
        }
    }

    /**
     * Performs a left shift operation on a 32-bit binary number.
     * Each bit in the binary number is shifted left by one position.
     *
     * @param a the operand (32-bit binary number).
     */
    private void leftShift(final Bit32 a) {
        for (int i = 0; i < 31; i++) {
            sum.setBit(i, a.getBit(i + 1));
        }
        sum.setBit(31, false); // Set the last bit to 0 (as the left shift shifts in 0)
    }

    /**
     * Performs a right shift operation on a 32-bit binary number.
     * Each bit in the binary number is shifted right by one position.
     *
     * @param a the operand (32-bit binary number).
     */
    private void rightShift(final Bit32 a) {
        for (int i = 31; i > 0; i--) {
            sum.setBit(i, a.getBit(i - 1));
        }
        sum.setBit(0, false); // Set the first bit to 0 (as the right shift shifts in 0)
    }

    /**
     * Performs a left rotate operation on a 32-bit binary number.
     * The leftmost bit is shifted to the rightmost position, and all other bits are shifted left by one position.
     *
     * @param a the operand (32-bit binary number).
     */
    private void leftRotate(final Bit32 a) {
        for (int i = 0; i < 31; i++) {
            sum.setBit(i, a.getBit(i + 1));
        }
        sum.setBit(31, a.getBit(0)); // Rotate the leftmost bit to the rightmost position
    }

    /**
     * Performs a right rotate operation on a 32-bit binary number.
     * The rightmost bit is shifted to the leftmost position, and all other bits are shifted right by one position.
     *
     * @param a the operand (32-bit binary number).
     */
    private void rightRotate(final Bit32 a) {
        for (int i = 31; i > 0; i--) {
            sum.setBit(i, a.getBit(i - 1));
        }
        sum.setBit(0, a.getBit(31)); // Rotate the rightmost bit to the leftmost position
    }
}
