import java.util.Arrays;

public class Adder32 {
    public Bit32 sum;
    public boolean carry;

    public Adder32() {
        sum = new Bit32();
    }

    public void add(Bit32 a, Bit32 b, boolean carry) {
        Adder8 eightBitAdder1 = new Adder8();
        Adder8 eightBitAdder2 = new Adder8();
        Adder8 eightBitAdder3 = new Adder8();
        Adder8 eightBitAdder4 = new Adder8();
        eightBitAdder1.add(new Bit8(Arrays.copyOfRange(a.bits(), 24, 32)), new Bit8(Arrays.copyOfRange(b.bits(), 24, 32)), carry);
        eightBitAdder2.add(new Bit8(Arrays.copyOfRange(a.bits(), 16, 24)), new Bit8(Arrays.copyOfRange(b.bits(), 16, 24)), eightBitAdder1.carry);
        eightBitAdder3.add(new Bit8(Arrays.copyOfRange(a.bits(), 8, 16)), new Bit8(Arrays.copyOfRange(b.bits(), 8, 16)), eightBitAdder2.carry);
        eightBitAdder4.add(new Bit8(Arrays.copyOfRange(a.bits(), 0, 8)), new Bit8(Arrays.copyOfRange(b.bits(), 0, 8)), eightBitAdder3.carry);
        sum = new Bit32();
        System.arraycopy(eightBitAdder1.sum.bits(), 0, sum.bits(), 24, 8);
        System.arraycopy(eightBitAdder2.sum.bits(), 0, sum.bits(), 16, 8);
        System.arraycopy(eightBitAdder3.sum.bits(), 0, sum.bits(), 8, 8);
        System.arraycopy(eightBitAdder4.sum.bits(), 0, sum.bits(), 0, 8);
        this.carry = eightBitAdder4.carry;
    }
}
