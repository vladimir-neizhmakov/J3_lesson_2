package ru.gb.jtwo.chat.client;

public class HW4 {
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        HW4 w = new HW4();
        Thread t1 = new Thread(() -> {
            w.printA();
        });
        Thread t2 = new Thread(() -> {
            w.printB();
        });
        Thread t3 = new Thread(() -> {
            w.printC();
        });
        t1.start();
        t2.start();
        t3.start();
    }

    public void printA() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
