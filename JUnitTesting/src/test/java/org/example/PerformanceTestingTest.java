package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class PerformanceTestingTest {
    PerformanceTesting pt = new PerformanceTesting();
    @Test
    @Timeout(4)
    void testPerformance() throws InterruptedException{
        pt.longRunningTask();
    }
}