public class Main {
    public static void main(String[] args) {
        ALU alu = new ALU();
        int int1 = 123456789;
        int int2 = 12345;
        Bit32 a = new Bit32(int1);
        Bit32 b = new Bit32(int2);
        alu.execute(Opcode.Add, a, b);
        System.out.printf("Addition: %d + %d\n", int1, int2);
        System.out.println(alu.sum.toString());
        System.out.println(alu.sum.toInt());
        System.out.println(int1+int2);
        alu.execute(Opcode.Sub, a, b);
        System.out.printf("Subtraction: %d - %d\n", int1, int2);
        System.out.println(alu.sum.toString());
        System.out.println(alu.sum.toInt());
        System.out.println(int1-int2);
    }
}
