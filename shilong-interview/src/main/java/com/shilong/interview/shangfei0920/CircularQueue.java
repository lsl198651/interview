package com.shilong.interview.shangfei0920;

public class CircularQueue {
	private int[] queue;
	private int head;
	private int tail;
	private int size;

	// 初始化队列
	public CircularQueue(int capacity) {
		queue = new int[capacity];
		head = 0;
		tail = 0;
		size = 0;
	}

	// 入队
	public void enqueue(int data) {
		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}
		queue[tail] = data;
		tail = (tail + 1) % queue.length;
		size++;
	}

	// 出队
	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1; // 返回 -1 表示队列为空
		}
		int data = queue[head];
		head = (head + 1) % queue.length;
		size--;
		return data;
	}

	// 检查队列是否满
	public boolean isFull() {
		return size == queue.length;
	}

	// 检查队列是否空
	public boolean isEmpty() {
		return size == 0;
	}
}

