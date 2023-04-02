package vector11;

import util.Generator;

import java.util.concurrent.TimeUnit;

public class Main11 {
    public static void main(String[] args) {
        float[] generated = Generator.generateFloatArray();
        float[] a = generated, b = generated, c = generated;

        long startTime = System.nanoTime();
        for (int i = 0; i < a.length; i++) {
            c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
        }
        long endTime = System.nanoTime();
        long diff = endTime - startTime;
        long millis = TimeUnit.NANOSECONDS.toMillis(diff);
        long nanos = diff - TimeUnit.MILLISECONDS.toNanos(millis);
        System.out.printf("ellapsed time ms: %d  ns : %d \n", millis, nanos);
    }
}
