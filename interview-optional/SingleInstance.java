package com.strands.spf;

/**
 * <p>
 * Single instance in a multi threading environment
 * </p>
 *
 * @author strands
 *
 */
public class SingleInstance {

    private static SingleInstance instance;
    private static int staticNum = 0;
    private int nonStaticNum = 0;

    public SingleInstance() {
    }

    public SingleInstance getInstance() {
        if (instance == null) {
            instance = new SingleInstance();
        }
        return instance;
    }

    public void addStaticAndNonStaticNum() {
        staticNum++;
        nonStaticNum++;
    }

    public void printBothNum() {
        System.out.println("Static Num      : " + staticNum);
        System.out.println("Non Static Num  : " + nonStaticNum);
    }

    public static void main(String[] args) {
        SingleInstance A = new SingleInstance().getInstance();
        A.addStaticAndNonStaticNum();
        A.printBothNum();
        SingleInstance B = new SingleInstance().getInstance();
        B.addStaticAndNonStaticNum();
        B.printBothNum();
        SingleInstance C = new SingleInstance().getInstance();
        C.addStaticAndNonStaticNum();
        C.printBothNum();

    }

}
