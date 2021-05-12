package lesson5;

public class Lesson5 {
    private static final int size = 10000000;
    private static final int h = size / 2;

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }
    public static float[] counter(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }

    public static void firstMethod() {

        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;
        long a = System.currentTimeMillis();
        counter(arr);
        System.out.println("Первый метод отработал: " + (System.currentTimeMillis() - a) + " миллисекунд");
    }

    public static void secondMethod() {

        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        new Thread(){
            @Override
            public void run(){
                float[] a1 = counter(arr1);
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                float[] a2 = counter(arr2);
            }
        }.start();
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println("Второй метод отработал: " + (System.currentTimeMillis() - a) + " миллисекунд");
    }



}
