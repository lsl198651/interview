package com.shilong.interview.pdd0921;

import java.util.Objects;

public class CustomHashMap<K, V> {
	// 默认初始容量和负载因子
	private static final int DEFAULT_CAPACITY = 16;
	private static final float LOAD_FACTOR = 0.75f;

	// 哈希表数组
	private Node<K, V>[] table;
	private int size;        // 当前存储的键值对数量
	private int threshold;   // 扩容阈值

	// 节点类，存储键值对
	static class Node<K, V> {
		final int hash;
		final K key;
		V value;
		Node<K, V> next; // 指向下一个节点

		Node(int hash, K key, V value, Node<K, V> next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	// 构造函数
	public CustomHashMap() {
		table = new Node[DEFAULT_CAPACITY];
		threshold = (int) (DEFAULT_CAPACITY * LOAD_FACTOR);
	}

	// 计算哈希值
	private int hash(Object key) {
		return (key == null) ? 0 : key.hashCode() ^ (key.hashCode() >>> 16);
	}

	// 插入键值对
	public void put(K key, V value) {
		int hash = hash(key);
		int index = (table.length - 1) & hash; // 计算数组索引位置

		// 检查该索引处是否存在节点
		Node<K, V> head = table[index];
		for (Node<K, V> node = head; node != null; node = node.next) {
			if (node.hash == hash && Objects.equals(node.key, key)) {
				// 如果 key 已存在，则更新 value
				node.value = value;
				return;
			}
		}

		// 如果 key 不存在，创建新的节点并插入链表头部
		Node<K, V> newNode = new Node<>(hash, key, value, head);
		table[index] = newNode;
		size++;

		// 检查是否需要扩容
		if (size > threshold) {
			resize();
		}
	}

	// 扩容方法
	private void resize() {
		int newCapacity = table.length * 2;
		Node<K, V>[] newTable = new Node[newCapacity];
		threshold = (int) (newCapacity * LOAD_FACTOR);

		// 重新将原来的节点分配到新的哈希表中
		for (Node<K, V> node : table) {
			while (node != null) {
				Node<K, V> next = node.next;

				int newIndex = (newCapacity - 1) & node.hash; // 重新计算索引位置
				node.next = newTable[newIndex];
				newTable[newIndex] = node;

				node = next;
			}
		}
		table = newTable;
	}

	// 获取键对应的值
	public V get(K key) {
		int hash = hash(key);
		int index = (table.length - 1) & hash; // 计算数组索引位置

		// 遍历链表查找对应的节点
		Node<K, V> node = table[index];
		while (node != null) {
			if (node.hash == hash && Objects.equals(node.key, key)) {
				return node.value;
			}
			node = node.next;
		}
		return null; // 未找到返回null
	}

	// 删除键值对
	public V remove(K key) {
		int hash = hash(key);
		int index = (table.length - 1) & hash;

		Node<K, V> prev = null;
		Node<K, V> node = table[index];
		while (node != null) {
			if (node.hash == hash && Objects.equals(node.key, key)) {
				if (prev == null) {
					table[index] = node.next; // 删除头节点
				} else {
					prev.next = node.next; // 删除中间节点
				}
				size--;
				return node.value;
			}
			prev = node;
			node = node.next;
		}
		return null; // 未找到
	}

	// 获取HashMap中元素的数量
	public int size() {
		return size;
	}

	// 检查HashMap是否为空
	public boolean isEmpty() {
		return size == 0;
	}
}
