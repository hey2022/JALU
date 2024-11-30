class FullAdder {
    boolean sum;
    boolean carry;

    public void add(boolean a, boolean b, boolean c) {
        HalfAdder halfAdder1 = new HalfAdder();
        HalfAdder halfAdder2 = new HalfAdder();
        halfAdder1.add(a, b);
        halfAdder2.add(halfAdder1.sum, c);
        this.sum = halfAdder2.sum;
        this.carry = halfAdder1.carry || halfAdder2.carry;
    }
}
