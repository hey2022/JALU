  public boolean sum;
  public boolean carry;
public class HalfAdder {

  public void add(boolean a, boolean b) {
    this.sum = a ^ b;
    this.carry = a && b;
  }
}
