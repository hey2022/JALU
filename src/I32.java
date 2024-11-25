public class I32 {
    public boolean[] number = new boolean[32];

    public I32(boolean[] number) {
        setNumber(number);
    }

    public I32(int number) {
        setNumber(number);
    }

    public void setNumber(boolean[] number) {
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = new boolean[32];
        for (int i = 0; i < 32; i++) {
            this.number[i] = (number & (1 << i)) != 0;
        }
    }
}
