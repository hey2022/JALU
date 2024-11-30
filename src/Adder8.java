import java.util.Arrays;

class Adder8 {
    public Bit8 sum;
    public boolean carry;

    public Adder8() {
        sum = new Bit8();
    }

    public void add(Bit8 a, Bit8 b, boolean carry) {
        Adder4 fourBitAdder1 = new Adder4();
        Adder4 fourBitAdder2 = new Adder4();
        fourBitAdder1.add(new Bit4(Arrays.copyOfRange(a.bits(), 4, 8)),
                new Bit4(Arrays.copyOfRange(b.bits(), 4, 8)), carry);
        fourBitAdder2.add(new Bit4(Arrays.copyOfRange(a.bits(), 0, 4)),
                new Bit4(Arrays.copyOfRange(b.bits(), 0, 4)), fourBitAdder1.carry);
        sum = new Bit8();
        System.arraycopy(fourBitAdder1.sum.bits(), 0, sum.bits(), 4, 4);
        System.arraycopy(fourBitAdder2.sum.bits(), 0, sum.bits(), 0, 4);
        this.carry = fourBitAdder2.carry;
    }
}
