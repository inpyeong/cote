import java.util.concurrent.Semaphore;

class Foo {

    private Semaphore secondSem;
    private Semaphore thirdSem;

    public Foo() {
        secondSem = new Semaphore(0);
        thirdSem = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        secondSem.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondSem.acquire();
        printSecond.run();
        thirdSem.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdSem.acquire();
        printThird.run();
    }
}
