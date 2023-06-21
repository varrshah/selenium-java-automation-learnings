public class MethodsDemo {
    public static void main(String[] args)
    {

        MethodsDemo d = new MethodsDemo();
        String name = d.getData();
        System.out.println(name);
        MethodsDemo2 d1 = new MethodsDemo2();  //created a new class
        d1.getUserData();                     //calling a new method from a different class
        getData2();                           //can call the method directly if present in the same class
    }

    /* public void getData()  //since this method doesn't return anything we declare it as void
    {
        System.out.println("hello world");
    }  */

    public String getData()  //since this method returns a string its declared as a String
    {
        System.out.println("hello world");
        return "selenium project";
    }

    public static String getData2()  //adding the keyword static which allows us to call
                                     // the method directly with creating an object
    {
        System.out.println("hello world");
        return "selenium project";
    }
}
