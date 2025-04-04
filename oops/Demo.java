package oops;

public class Demo implements IDemo1, IDemo2{
    @Override
    public void print() {
        IDemo1.super.print();
        IDemo2.super.print();
        System.out.println("Demo");
    }

    
}
