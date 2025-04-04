package oops.SingleTon;

public class singletonExample {

    //1. private constructor
    private singletonExample() {
        System.out.println("private constructor called");
    }

    //2. private static object
    private static singletonExample obj = null;

    //3. public static method
    public static singletonExample getInstance() {
        if (obj == null) {
            obj = new singletonExample();
        }
        return obj;
    }

    public void print(String message)
    {
        System.out.println("Message : " + message);
    }

}
