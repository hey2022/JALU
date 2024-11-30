public class Bit8 extends Bit {
    public Bit8() {
        super();
    }

    public Bit8(boolean[] bits) {
        super(bits);
    }

    public Bit8(String string) {
        super(string);
    }

    public Bit8(int value) {
        super(value);
    }

    @Override
    public int getBitLength() {
        return 8;
    }
}
