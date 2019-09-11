public class Fibonacci1_1_19
{
    public static void main(String[] args)
    {
        long[] values = new long[100];
        values[0] = 0;
        values[1] = 1;
        System.out.println(0 + " " + values[0]);
        System.out.println(1 + " " + values[1]);

        for (int i = 2; i < 100; i++) {
            values[i] = values[i - 2] + values[i - 1];
            System.out.println(i + " " + values[i]);
        }
    }
}
