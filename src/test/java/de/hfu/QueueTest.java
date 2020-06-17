package de.hfu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class QueueTest {

    private int[] testInput1;
    private int[] testInput2;
    private int[] expectedResult1;
    private int[] expectedResult2;
    private int[] expectedResult3;

    private Queue testQueue1;

    public QueueTest(int[] testInput1, int[] testInput2, int[] expectedResult1, int[] expectedResult2, int[] expectedResult3) {
        this.testInput1 = testInput1;
        this.testInput2 = testInput2;
        this.expectedResult1 = expectedResult1;
        this.expectedResult2 = expectedResult2;
        this.expectedResult3 = expectedResult3;
    }

    @Parameterized.Parameters
    public static Collection daten() {
        return Arrays.asList(new int[][][] {
                {{1, 2, 3}, {1, 4, 5, 4}, {1, 2, 3}, {1, 4, 4}, {1, 2, 3}}
        });
    }

    @Before
    public void createQueues() throws Exception {
        testQueue1 = new Queue(testInput1.length);
    }

    @Test(expected = IllegalArgumentException.class, timeout = 1000)
    public void testQueueEmpty() throws Exception {
        Queue q = new Queue(0);
    }

    @Test
    public void testQueue() throws Exception {
        Assert.assertArrayEquals(new int[testInput1.length], testQueue1.queue);
    }

    @Test
    public void testEnqueue() throws Exception {
        for (int i = 0; i < testInput1.length; i++) {
            testQueue1.enqueue(testInput1[i]);
        }
        Assert.assertArrayEquals(expectedResult1, testQueue1.queue);
    }

    @Test
    public void testEnqueueWithFullQueue() throws Exception {
        Queue q = new Queue(testInput2.length - 1);
        for (int i = 0; i < testInput2.length; i++) {
            q.enqueue(testInput2[i]);
        }
        Assert.assertArrayEquals(expectedResult2, q.queue);
    }

    @Test(expected = IllegalStateException.class, timeout = 1000)
    public void testDequeueOnEmptyQueue() throws Exception {
        Queue q = new Queue(1);
        q.dequeue();
    }

    @Test
    public void testDequeueReturnValue() throws Exception {
        for (int i = 0; i < testInput1.length; i++) {
            testQueue1.enqueue(testInput1[i]);
        }
        Assert.assertEquals(expectedResult3[0], testQueue1.dequeue());
    }

} 
