package List;
/**
 * List generics
 * @author pablo
 *
 */
public class List <T>{	
	protected Node<T> _head = null;
	protected Node<T> _tail = null;
	protected int length = 0; 

	/**
	 * Adds data to the front
	 * @param Data
	 */
	public void add(T pData)
	{
		Node<T> node = new Node<T>(pData);
		if (_head == null)
			_tail = node;
		
		else
			node.setNext(_head);
		_head = node;
		this.length ++;
	}
	/**
	 * Adds data to the end
	 * @param Data
	 */
	public void append(T pData)
	{
		Node<T> node = new Node<T>(pData);
		if (_head == null)
			_head = node;
		
		else
			_tail.setNext(node);
		_tail = node;
		this.length ++;
		
	}
	/**
	 * Prints all the list
	 */
	
	

	
	public void print()
	{
		Node<T> ele = _head;
		while (ele != null)
		{
			System.out.println(ele.getData());
			ele = ele.getNext();
			
		}
	}
	/**
	 * Nos dice si existe un dato o no en la lista
	 * @param dato
	 * @return boolean
	 */
	public boolean find(String dato)
	{
		if (_head != null) {
			Node<T> ele = _head;
			while (ele != null)
			{
				if (ele.compareTo(dato)==0)
					return true;
				ele = ele.getNext();
			}

		
		}
		return false;
	}
	
	public T get(int x)
	{
		if (this.length !=0 && x < this.length)
		{
			Node<T> ele = _head;
			for (int i = 0; i < x; i++)
				ele = ele.getNext();
			return ele.getData();
		}
		return null;
		
	}	
	
	public boolean set(int i, T pData)
	{
		if (i>=this.length)
			return false;
		Node<T> ele = _head;
		for (int x = 0; x < i; x++)
			ele = ele.getNext();
		ele.setData(pData);
		
		return true;
	}
	public int getLength()
	{
		return this.length;
		
	}
	@Override
	public String toString() 
	{
		return "List [" + _head +  ", lenght="
				+ length + "]";
	}
	public void remove(int i) {
		if (i<length)
		{
			Node<T> ele = _head;
			if (i == 0)
				_head = ele.getNext();
			else
			{			
				for (int x = 0; x < i-1; x++)
					ele = ele.getNext();
				if (i == length-1)
					ele.setNext(null);
				else
					ele.setNext(ele.getNext().getNext());
			}
			
		length --;
		}
		
	}
	public Node<T> getNode(int x) 
		{
			if (this.length !=0 && x < this.length)
			{
				Node<T> ele = _head;
				for (int i = 0; i < x; i++)
					ele = ele.getNext();
				return ele;
			}
			return null;
			
		}	
	

}
