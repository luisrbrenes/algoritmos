package List;

public class Node <T> implements Comparable<T>{
	
	private T data = null;
	private Node<T> next = null;//next item

	public Node(T pData) {
		data = pData;
	}
	/**
	 * adds next node
	 * @param Next Node
	 */
	public void setNext(Node<T> pNext)
	{
		next = pNext;
	}
	public T getData()
	{
		return data;
	}
	public Node<T> getNext()
	{
		return next;
	}
	@Override
	/**
	 * Returs 0 if value is different from the used
	 * @param o
	 * @return
	 */
	public int compareTo(T o) {
		return -1;
	}
	public void setData(T pData) {
		this.data = pData;
	}
	public int compareTo(String o) {
		return this.data.toString().compareTo(o);

	}
	public String toString() {
		return data + ", " + next ;
	}
		
}
