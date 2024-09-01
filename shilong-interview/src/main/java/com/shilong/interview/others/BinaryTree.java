package com.shilong.interview.others;
class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

public class BinaryTree {
	Node root;

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		// Constructing the binary tree
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);

		System.out.println("The diameter of the binary tree is: " + tree.getDiameter());
	}

	// Function to compute the height and diameter of the tree
	HeightAndDiameter computeHeightAndDiameter(Node node) {
		if (node == null) {
			return new HeightAndDiameter(-1, 0);
		}

		// Recursively get the height and diameter of left and right subtrees
		HeightAndDiameter leftResult = computeHeightAndDiameter(node.left);
		HeightAndDiameter rightResult = computeHeightAndDiameter(node.right);

		// Current node height is max height of left or right subtree + 1
		int currentHeight = Math.max(leftResult.height, rightResult.height) + 1;

		// Diameter of the tree is the maximum of:
		// 1. Diameter of the left subtree
		// 2. Diameter of the right subtree
		// 3. Height of the left subtree + height of the right subtree + 2 (passing through the current node)
		int currentDiameter = Math.max(leftResult.diameter,
				Math.max(rightResult.diameter, leftResult.height + rightResult.height + 2));

		return new HeightAndDiameter(currentHeight, currentDiameter);
	}

	// Function to get the diameter of the tree
	int getDiameter() {
		return computeHeightAndDiameter(root).diameter;
	}

	// Class to store height and diameter together
	class HeightAndDiameter {
		int height;
		int diameter;

		HeightAndDiameter(int h, int d) {
			height = h;
			diameter = d;
		}
	}
}

