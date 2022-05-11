package com.zzf.stack;

public class stackmain {

    public static void main(String[] args) {
        QueueWithStack queueWithStack = new QueueWithStack();
        queueWithStack.push(1);
        queueWithStack.push(2);
        queueWithStack.push(3);
        System.out.println(queueWithStack.pop());
        System.out.println(queueWithStack.peek());
        queueWithStack.push(5);
        queueWithStack.push(6);
        System.out.println(queueWithStack.pop());
        System.out.println(queueWithStack.peek());
        System.out.println(queueWithStack.pop());
        System.out.println(queueWithStack.peek());
        System.out.println(queueWithStack.pop());
        System.out.println(queueWithStack.peek());

    }
}
