package task_1_3_33;

public class Main {
    public static void main(String[] args) {
        Degue<String> arr = new Degue<String>(12);
        System.out.println(arr.getSize());
        System.out.println(arr.isEmpty());
        arr = new Degue(10);
        System.out.println(arr.getSize());
        arr.ouputArray();
        arr.pushLeft("FirstPoint");
        arr.pushRight("LastPoint");
        arr.ouputArray();
        System.out.println(arr.popLeft());
        System.out.println(arr.popRight());
        arr.ouputArray();
    }
}