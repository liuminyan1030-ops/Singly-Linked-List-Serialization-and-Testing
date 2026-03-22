package sait.sll.utility;

import java.io.Serializable;

public class SLLNode implements Serializable {
	
	private static final long serialVersionUID = 1057359804564330521L;
	private Object element;
	private SLLNode node;

	public SLLNode(Object element, SLLNode node) {
		this.element = element;
		this.node = node;
	}

	public SLLNode(Object element) {
		this.element = element;
	}

	public Object getElement() {
		return element;
	}

	public SLLNode getNode() {
		return node;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public void setNode(SLLNode node) {
		this.node = node;
	}

}
