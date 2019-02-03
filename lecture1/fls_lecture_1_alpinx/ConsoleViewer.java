package fls_lecture_1_alpinx;

public  class ConsoleViewer{
    //print result to console
    public static void print(int[] array){
        for (var element:array) {
            System.out.print(Integer.toString(element) + ' ');
        }
        System.out.println();
    }
    public static <T> void print(T text)
    {
       System.out.println(text);
    }
}
