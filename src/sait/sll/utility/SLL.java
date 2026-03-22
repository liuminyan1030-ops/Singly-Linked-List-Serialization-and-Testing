package sait.sll.utility;

import java.io.Serializable;

public class SLL implements LinkedListADT, Serializable {

	private static final long serialVersionUID = 4207147896437339801L;
	private SLLNode head;
	private SLLNode tail;
	private int size;

	@Override
	public boolean isEmpty() {

		return size == 0;
	}

	@Override
	public void clear() {
		head = tail = null;
		size = 0;

	}

	@Override
	public void append(Object data) {
		SLLNode newNode = new SLLNode(data);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			tail.setNode(newNode);
			tail = newNode;
		}
		size++;

	}

	@Override
	public void prepend(Object data) {
		SLLNode newNode = new SLLNode(data);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			newNode.setNode(head);
			head = newNode;
		}
		size++;

	}

	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		if (index == 0) {
			prepend(data);
		} else if (index == size) {
			append(data);
		} else {
			SLLNode newNode = new SLLNode(data);
			SLLNode currentNode = head;
			int currentIndex = 0;
			while (currentIndex < index - 1) {
				currentNode = currentNode.getNode();
				currentIndex++;

			}
			newNode.setNode(currentNode.getNode());
			currentNode.setNode(newNode);
			size++;
		}
		
	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		SLLNode currentNode = head;
		int currentIndex = 0;
		while (currentIndex < index) {
			currentNode = currentNode.getNode();
			currentIndex++;
		}
		currentNode.setElement(data);

	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		if (size == 1) {
			head = tail = null;
		} else if (index == 0) {
			head = head.getNode();
		} else if (index == size - 1) {
			SLLNode currentNode = head;
			int currentIndex = 0;
			while (currentIndex < index-1) {
				currentNode = currentNode.getNode();
				currentIndex++;
			}
			currentNode.setNode(null);
			tail = currentNode;
		} else {
			SLLNode currentNode = head;
			int currentIndex = 0;
			while (currentIndex < index-1) {
				currentNode = currentNode.getNode();
				currentIndex++;
			}
			currentNode.setNode(currentNode.getNode().getNode());
		}
		size--;

	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		SLLNode currentNode = head;
		int currentIndex = 0;
		while (currentIndex < index) {
			currentNode = currentNode.getNode();
			currentIndex++;
		}
		return currentNode.getElement();
	}

	@Override
	public int indexOf(Object data) {
		SLLNode currentNode = head;
		int index = 0;
		while (currentNode != null) {
			if ((data == null && currentNode.getElement() == null)
					|| (data != null && data.equals(currentNode.getElement()))) {
				return index;
			}
			currentNode = currentNode.getNode();
			index++;
		}

		return -1;
	}

	@Override
	public boolean contains(Object data) {

		return indexOf(data) != -1;
	}

}
