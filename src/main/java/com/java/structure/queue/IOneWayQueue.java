package com.java.structure.queue;

/**
 * 单向对列
 */
public interface IOneWayQueue<T> {

    /**
     * 向队列中添加数据
     *
     * @param t
     * @return
     */
    T addQueue(T t);

    /**
     * 从队列中获取数据
     *
     * @return
     */
    T getQueue();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    Boolean isEmpty();

    /**
     * 判断队列是否已满
     *
     * @return
     */
    Boolean isFull();

    /**
     * 获取队列的头数据
     *
     * @return
     */
    T getHeadQueue();

    /**
     * 获取队列头
     *
     * @return
     */
    Integer getFront();

    /**
     * 获取队列尾
     *
     * @return
     */
    Integer getRear();

    /**
     * 获取队列中数据的实际数量
     *
     * @return
     */
    Integer getItem();
}
