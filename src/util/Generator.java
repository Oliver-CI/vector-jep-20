package util;

public class Generator {

    public static float[] generateFloatArray(){
        int size = 100_000;
        float[] floats = new float[size];
        for (int i = 0; i < size; i++) {
            floats[i] = i;
        }
        return floats;
    }
}
