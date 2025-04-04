package oops.SingleTon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Program {
                                // lazy loading failing in multi-threaded environment
    // public static void printFirstMessage(){
    //     singletonExample obj1 = singletonExample.getInstance();
    //     obj1.print("singletonExample from first Object");
    // }

    // public static void printSecondMessage(){
    //     singletonExample obj2 = singletonExample.getInstance();
    //     obj2.print("singletonExample from second Object");
    // }

    // public static void printThirdMessage(){
    //     singletonExample obj3 = singletonExample.getInstance();
    //     obj3.print("singletonExample from third Object");
    // }
   
    //               Thread safe in multi-threaded environment
    public static void printFirstMessage(){
        singletonExThrdSafe obj1 = singletonExThrdSafe.getInstance();
        obj1.print("singletonExample from first Object");
    }

    public static void printSecondMessage(){
        singletonExThrdSafe obj2 = singletonExThrdSafe.getInstance();
        obj2.print("singletonExample from second Object");
    }

    public static void printThirdMessage(){
        singletonExThrdSafe obj3 = singletonExThrdSafe.getInstance();
        obj3.print("singletonExample from third Object");
    }


    public static void main(String[] args) {
        // to fail the lazy-loading in multi-threaded environment

        //executer service, runnable method
        // ExecutorService executorService = Executors.newCachedThreadPool();
        // Runnable createFirstObj = () -> printFirstMessage();
        // executorService.execute(createFirstObj);

        // Runnable createSecondObj = () -> printSecondMessage();
        // executorService.execute(createSecondObj);

        // executorService.execute(()-> printThirdMessage());
        
        
        //thread safe
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable createFirstObj = () -> printFirstMessage();
        executorService.execute(createFirstObj);

        Runnable createSecondObj = () -> printSecondMessage();
        executorService.execute(createSecondObj);

        executorService.execute(()-> printThirdMessage());
    }
}
