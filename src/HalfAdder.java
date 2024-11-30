class HalfAdder {
  public boolean sum;
  public boolean carry;

  public void add(boolean a, boolean b) {
    this.sum = a ^ b;
    this.carry = a && b;
  }
}
