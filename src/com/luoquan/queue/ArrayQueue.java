package com.luoquan.queue;

import java.util.Arrays;

/**
 * ArrayQueue
 * 使用环形数组实现队列
 * 头部获取数据
 * 尾部添加数据
 *
 * @author LuoQuan
 * @date 2020/5/5 17:37
 */
public class ArrayQueue {
    /**
     * 队列的最大容量
     */
    private int capacity;

    /**
     * 队列头
     */
    private int head;

    /**
     * 队列尾
     */
    private int rear;

    /**
     * 队列当前存储的元素个数
     */
    private int size;

    /**
     * 队列中的数据
     */
    private int[] data;

    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("队列容量不能小于或等于零");
        }
        this.capacity = capacity;
        data = new int[capacity];
        head = 0;
        rear = 0;
        size = 0;
    }

    /**
     * 判断队列是否已满
     *
     * @return 队列是否已满
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * 判断队列是否为空
     *
     * @return 队列是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取队列长度(有多少个元素)
     *
     * @return 队列的长度
     */
    public int size() {
        return size;
    }

    /**
     * 向队列中添加数据
     * 队列的特点:
     * 尾部(rear)添加数据
     *
     * @param element 待添加到队列中的数据
     * @return 判断数据是否已经成功添加到队列中(队列为满则添加不了数据)
     */
    public boolean add(int element) {
        //首先判断队列是否已满
        if (isFull()) {
            System.out.printf("队列已满,添加%d失败\n", element);
            return false;
        }

        if (rear == capacity) {
            rear = 0;
        }
        data[rear++] = element;
        size++;
        return true;
    }

    /**
     * 获取队列中的元素
     * 队列的特点:
     * 头部(head)获取数据
     *
     * @return 获取的数据
     * @throws Exception 队列为空则跑出异常
     */
    public int remove() throws Exception {
        //判断队列是否为空
        if (isEmpty()) {
            throw new Exception("队列已经为空了");
        }

        if (head == capacity) {
            head = 0;
            return data[head];
        }
        size--;
        return data[head++];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);

        int size = queue.size();
//        System.out.println("size:" + size);
        for (int i = 0; i < size; i++) {
            try {
                queue.remove();
//                System.out.println(queue.remove());
//                System.out.println(Arrays.toString(queue.data));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        System.out.printf("head=%d,real=%d,size=%d\n", queue.head, queue.rear, queue.size());

        System.out.printf("head=%d,rear=%d,size=%d,array=%s\n", queue.head, queue.rear, queue.size(),Arrays.toString(queue.data));
        queue.add(3);
        System.out.printf("head=%d,rear=%d,size=%d,array=%s\n", queue.head, queue.rear, queue.size(),Arrays.toString(queue.data));
        queue.add(4);
        System.out.printf("head=%d,rear=%d,size=%d,array=%s\n", queue.head, queue.rear, queue.size(),Arrays.toString(queue.data));
        queue.add(5);
        System.out.printf("head=%d,rear=%d,size=%d,array=%s\n", queue.head, queue.rear, queue.size(),Arrays.toString(queue.data));

        size = queue.size();
        for (int i = 0; i < size; i++) {
            try {
                System.out.println(queue.remove());
//                System.out.printf("head=%d,rear=%d,size=%d,array=%s\n", queue.head, queue.rear, queue.size(),Arrays.toString(queue.data));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
