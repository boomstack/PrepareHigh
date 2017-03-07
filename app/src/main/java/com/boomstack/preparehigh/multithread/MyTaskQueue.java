package com.boomstack.preparehigh.multithread;

import com.boomstack.preparehigh.HolaPrint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangkangfei on 17/3/7.
 */

public class MyTaskQueue<Task> {
    private Task[] taskQueue;
    private final int maxSize;
    private ReentrantLock lock;
    private Condition fullCondition;
    private Condition emptyCondition;
    private int head;
    private int tail;
    private int count;

    public MyTaskQueue(int size) {
        maxSize = size;
        taskQueue = (Task[]) new Object[maxSize];
        lock = new ReentrantLock();
        fullCondition = lock.newCondition();
        emptyCondition = lock.newCondition();
    }


    private int getCapacity() {
        return taskQueue.length;
    }

    /**
     * 入队
     */
    public void put(Task task) {
        lock.lock();
        try {
            while (count == maxSize) {
                HolaPrint.pr("queue is full now, you cannot put");
                fullCondition.await();
            }
            tail++;
            taskQueue[tail] = task;
            //到达数组末尾，循环
            if (tail == maxSize - 1) {
                tail = 0;
            }
            count++;
            emptyCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 取任务
     */
    public Task take() {
        lock.lock();
        try {
            while (count == 0) {
                HolaPrint.pr("queue is empty now, you cannot take");
                emptyCondition.await();
            }
            Task t = taskQueue[head];
            head++;
            if (head == maxSize - 1) {
                head = 0;
            }
            count--;
            fullCondition.signalAll();
            return t;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

}
