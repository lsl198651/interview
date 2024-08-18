package programmercarl;
public class ListNode {
	// 结点的值
	int val;

	// 下一个结点
	ListNode next;

	// 节点的构造函数(无参)
	public ListNode() {
	}

	// 节点的构造函数(有一个参数)
	public ListNode(int val) {
		this.val = val;
	}

	// 节点的构造函数(有两个参数)
	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
// TODO 反转链表
	public void reverseListNode(ListNode head) {
	//	反转链表
	// 也可以使用递归反转一个链表
	ListNode pre = null;
	ListNode cur = head;

		while (cur != null) {
		ListNode next = cur.next;
		cur.next = pre;
		pre = cur;
		cur = next;
		}
	}

//	TODO 反转一部分链表
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if(left==right){
			return head;
		}

		ListNode leftNode=null;
		ListNode rightNode=null;
		ListNode temp=null;
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode pre = dummyNode;

		for(int i=0;i<left-1;i++){
			pre = pre.next;
		}
		leftNode = pre.next;
		rightNode=leftNode;
		for(int i=0;i<right-left;i++){
			rightNode = rightNode.next;
		}
		ListNode curr = rightNode.next;
		// 注意：切断链接
		pre.next = null;
		rightNode.next = null;

		reverseListNode(leftNode);

		// 第 5 步：接回到原来的链表中
		pre.next = rightNode;
		leftNode.next = curr;
		return dummyNode.next;


	}

}

/*
求二又树中相距最远的两个节点之间的距离
二叉树结构定义为:
struct Node{
	Node *left;
	Node* right;
	int data;
	};

定义:空二叉树的高度为-1，只有根节点的二叉树高度为0，根节点在0层，深度为0
问题:求二叉树中相距最远的两个节点之间的距离*/
