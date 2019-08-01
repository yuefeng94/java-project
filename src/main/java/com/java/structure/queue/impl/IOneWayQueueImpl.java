package com.java.structure.queue.impl;

import com.java.structure.queue.IOneWayQueue;

/**
 * 实现思路：
 * 初始时 front = rear = 0;
 * 向队列添加数据时，rear++，
 * 向队列获取数据时，front++,
 * 临界点：当front or rear (等于队列最大长度) and (队列未存满 or 队列非空)时，
 * front or rear 需要重新从0开始（实现循环队列）
 * <p>
 * 队列中新增一个数据时，队尾的指针rear 会向上移动，也就是向下标大的方向。移除数据项时，队头指针 front 向上移动。
 * 那么这样设计好像和现实情况相反，比如排队买电影票，队头的买完票就离开了，然后队伍整体向前移动。
 * 在计算机中也可以在队列中删除一个数之后，队列整体向前移动，但是这样做效率很差。我们选择的做法是移动队头和队尾的指针
 *
 * @param <T>
 */
public class IOneWayQueueImpl<T> implements IOneWayQueue<T> {
    private Integer rear = 0; // 队尾
    private Integer front = 0; // 队头
    private T[] data; // 队列数据
    public static final Integer DEFAULT_LENGTH = 16;
    private Integer length; // 队列大小
    private Integer item = 0; // 记录队列中元素个数

    public IOneWayQueueImpl() {
        this(DEFAULT_LENGTH);
    }

    public IOneWayQueueImpl(Integer length) {
        if (length <= 0) {
            throw new RuntimeException("length must gt 0");
        }
        this.length = length;
        this.data = (T[]) new Object[this.length];
    }

    @Override
    public T addQueue(T t) {
        if (isFull()) {
            throw new RuntimeException("queue is full");
        }
        this.data[this.rear] = t;
        /**
         * 若队尾到数组末端，且数组还未装满数据时，
         * 将队尾置为-1，实现循环队列
         */
        if (this.rear == this.length - 1) {
            this.rear = -1;
        }
        item++;
        rear++;
        return t;
    }

    @Override
    public T getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        T t = this.data[this.front];
        this.data[this.front] = null; // 清空数据
        if (this.front == this.length - 1) {
            this.front = -1;
        }
        front++;
        item--;
        return t;
    }

    @Override
    public Boolean isEmpty() {
        return this.item == 0;
    }

    @Override
    public Boolean isFull() {
        return this.item == this.length;
    }

    @Override
    public T getHeadQueue() {
        return this.data[front];
    }

    @Override
    public Integer getFront() {
        return this.front;
    }

    @Override
    public Integer getRear() {
        return this.rear;
    }

    @Override
    public Integer getItem() {
        return this.item;
    }
}
