public class ALU {
    public Bit32 sum;
    public boolean carry;
    public boolean zero;

    public void execute(final Opcode opcode, final Bit32 a) {
        execute(opcode, a, new Bit32(0), false);
    }

    public void execute(final Opcode opcode, final Bit32 a, final Bit32 b) {
        execute(opcode, a, b, false);
    }

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

    private void add(final Bit32 a, final Bit32 b, final boolean carry) {
        final Adder32 adder = new Adder32();
        adder.add(a, b, carry);
        this.sum = adder.sum;
        this.carry = adder.carry;
    }

    private void sub(final Bit32 a, final Bit32 b) {
        oneComplement(b);
        add(a,sum,true);
    }

    private void increment(final Bit32 a) {
        add(a,new Bit32(1),false);
    }

    private void decrement(final Bit32 a) {
        sub(a,new Bit32(1));
    }

    private void twoComplement(final Bit32 a) {
        oneComplement(a);
        increment(sum);
    }

    private void oneComplement(final Bit32 a) {
        for (int i = 0; i < 32; i++) {
            sum.setBit(i, !a.getBit(i));
        }
    }

    private void and(final Bit32 a, final Bit32 b) {
        for (int i=0; i<32; i++) {
            sum.setBit(i, a.getBit(i) && b.getBit(i));
        }
    }

    private void or(final Bit32 a, final Bit32 b) {
        for (int i=0; i<32; i++) {
            sum.setBit(i, a.getBit(i) || b.getBit(i));
        }
    }

    private void xor(final Bit32 a, final Bit32 b) {
        for (int i=0; i<32; i++) {
            sum.setBit(i, a.getBit(i) ^ b.getBit(i));
        }
    }

    private void leftShift(final Bit32 a) {
        for (int i = 0; i < 32; i++) {
            sum.setBit(i, a.getBit(i+1));
        }
    }

    private void rightShift(final Bit32 a) {
        for (int i = 31; i > 0; i--) {
            sum.setBit(i, a.getBit(i-1));
        }
    }

    private void leftRotate(final Bit32 a) {
        for (int i = 0; i < 31; i++) {
            sum.setBit(i, a.getBit(i+1));
        }
        sum.setBit(31, a.getBit(0));
    }

    private void rightRotate(final Bit32 a) {
        for (int i = 31; i > 0; i--) {
            sum.setBit(i, a.getBit(i-1));
        }
        sum.setBit(0, a.getBit(31));
    }

}
