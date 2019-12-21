package com.java.common;

public class PingPong {

    public static void main(String ...args) {

        Thread t1 = new Thread(new PrintThread("PING"));
        Thread t2 = new Thread(new PrintThread("PONG"));

        t1.start();
        t2.start();

    }

    public static class PrintThread implements Runnable{
        private String message;
        public static Object lock = new Object();

        PrintThread(String _message) {
            this.message = _message;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    System.out.println(this.message);
                    try {
                        this.notify();
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
