package oops.SingleTon;

public class singletonExThrdSafe {
    private singletonExThrdSafe(){
        System.out.println("Private constructor");
    }
    
    //2. volatile variable for thread safety (volatile is used when variable is shared between multiple threads)
    // When a variable is declared as volatile, the Java Virtual Machine (JVM) ensures that:
    //Changes made by one thread to a volatile variable are always visible to other threads.
    //  The JVM does not optimize access to volatile variables, which means that it will not cache the value of the variable or reorder access to it.

    private static volatile singletonExThrdSafe instance;  // default value is null
    private static Object lockObj = new Object();

    public static singletonExThrdSafe getInstance(){
        singletonExThrdSafe singletonEx = instance;
        if(singletonEx == null){
            synchronized(lockObj){
                singletonEx = instance;
                if(singletonEx == null){
                    instance = singletonEx = new singletonExThrdSafe();
                }
            }
        }
        return singletonEx;
    }

    public void print(String message)
    {
        System.out.println("Message : " + message);
    }
}
