class Adder4 {
    public Bit4 sum;
    public boolean carry;

    public Adder4() {
        sum = new Bit4();
    }

    public void add(Bit4 a, Bit4 b, boolean carry) {
        FullAdder fullAdder = new FullAdder();
        fullAdder.add(a.getBit(3), b.getBit(3), carry);
        sum.setBit(3, fullAdder.sum);
        fullAdder.add(a.getBit(2), b.getBit(2), fullAdder.carry);
        sum.setBit(2, fullAdder.sum);
        fullAdder.add(a.getBit(1), b.getBit(1), fullAdder.carry);
        sum.setBit(1, fullAdder.sum);
        fullAdder.add(a.getBit(0), b.getBit(0), fullAdder.carry);
        sum.setBit(0, fullAdder.sum);
        this.carry = fullAdder.carry;
    }
}
