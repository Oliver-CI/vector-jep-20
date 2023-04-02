package vector20;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;
import util.Generator;

import java.util.concurrent.TimeUnit;

public class Main20 {

    static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;

    public static void main(String[] args) {
        float[] generated = Generator.generateFloatArray();
        float[] a = generated, b = generated, c = generated;


        int i = 0;
        int upperBound = SPECIES.loopBound(a.length);
        for (; i < upperBound; i += SPECIES.length()) {
            // FloatVector va, vb, vc;
            var va = FloatVector.fromArray(SPECIES, a, i);
            var vb = FloatVector.fromArray(SPECIES, b, i);
            var vc = va.mul(va)
                    .add(vb.mul(vb))
                    .neg();
            vc.intoArray(c, i);
        }
        long startTime = System.nanoTime();
        for (; i < a.length; i++) {
            c[i] = (a[i] * a[i] + b[i] * b[i]) * -1.0f;
        }
        long endTime = System.nanoTime();
        long diff = endTime - startTime;
        long millis = TimeUnit.NANOSECONDS.toMillis(diff);
        long nanos = diff - TimeUnit.MILLISECONDS.toNanos(millis);
        System.out.printf("ellapsed time ms: %d  ns : %d \n", millis, nanos);
    }
}