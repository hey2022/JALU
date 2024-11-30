public class Bit32 extends Bit {
    public Bit32() {
        super();
    }

    public Bit32(boolean[] bits) {
        super(bits);
    }

    public Bit32(String string) {
        super(string);
    }

    public Bit32(int number) {
        super(number);
    }

    @Override
    public int getBitLength() {
        return 32;
    }
}
