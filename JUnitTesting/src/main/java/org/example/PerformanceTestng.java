package org.example;

import static java.lang.Thread.sleep;

class PerformanceTesting {

    public void longRunningTask() throws InterruptedException {
        sleep(40000);
        System.out.println("its a long running task");
    }
}
