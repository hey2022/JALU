/**
 * Enum representing the possible opcodes for the Arithmetic Logic Unit (ALU) operations.
 * Each value corresponds to a specific operation that the ALU can perform on 32-bit binary numbers.
 *
 * <p>Operations include basic arithmetic, bitwise operations, shifts, and rotations:</p>
 * <ul>
 *     <li>{@link #Add}: Addition of two operands.</li>
 *     <li>{@link #Sub}: Subtraction of two operands (using two's complement for the second operand).</li>
 *     <li>{@link #Increment}: Increment a number by 1.</li>
 *     <li>{@link #Decrement}: Decrement a number by 1.</li>
 *     <li>{@link #TwoComplement}: Compute the two's complement of a number.</li>
 *     <li>{@link #OneComplement}: Compute the one's complement (bitwise NOT) of a number.</li>
 *     <li>{@link #And}: Perform a bitwise AND operation between two operands.</li>
 *     <li>{@link #Or}: Perform a bitwise OR operation between two operands.</li>
 *     <li>{@link #Xor}: Perform a bitwise XOR operation between two operands.</li>
 *     <li>{@link #LeftShift}: Perform a left shift operation on a number.</li>
 *     <li>{@link #RightShift}: Perform a right shift operation on a number.</li>
 *     <li>{@link #LeftRotate}: Perform a left rotate operation on a number.</li>
 *     <li>{@link #RightRotate}: Perform a right rotate operation on a number.</li>
 * </ul>
 */
public enum Opcode {
    /**
     * Addition operation.
     */
    Add,

    /**
     * Subtraction operation (using two's complement for the second operand).
     */
    Sub,

    /**
     * Increment operation (add 1).
     */
    Increment,

    /**
     * Decrement operation (subtract 1).
     */
    Decrement,

    /**
     * Two's complement operation (invert bits and add 1).
     */
    TwoComplement,

    /**
     * One's complement operation (invert bits).
     */
    OneComplement,

    /**
     * Bitwise AND operation.
     */
    And,

    /**
     * Bitwise OR operation.
     */
    Or,

    /**
     * Bitwise XOR operation.
     */
    Xor,

    /**
     * Left shift operation.
     */
    LeftShift,

    /**
     * Right shift operation.
     */
    RightShift,

    /**
     * Left rotate operation (rotate bits to the left).
     */
    LeftRotate,

    /**
     * Right rotate operation (rotate bits to the right).
     */
    RightRotate,
}
