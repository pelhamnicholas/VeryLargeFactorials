// ObjectList.java
public class DLL {
    private DLLNode list;
    

    /**
     * Constructs an empty list
     */
    public DLL() {
        list = null;
    }

    /**
     * Returns the first node in the list
     */
    public DLLNode getFirstNode() {
        return list;
    }
    
    /**
     * Returns the last node in the list
     * @return
     */
    public DLLNode getLastNode() {
    	if (list == null)
    		return null;
    	DLLNode p = list;
    	while (p.getNext() != null)
    		p = p.getNext();
    	return p;
    }
    

    /**
     * Adds the given element to the beginning of the list
     * @param o - the element to be inserted at the beginning of the list
     */
    public void addFirst(Object o) {
        DLLNode p = new DLLNode(o, list, null);
        list = p;
    }

    /** 
	 * Appends the given element to the end of the list
     * @param o - the element to be appended to the end of the list
     */
    public void addLast(Object o) {
        DLLNode p = new DLLNode(o, null, getLastNode());        
        if (list == null)
            list = p;
        else {
            DLLNode q = list;
            while (q.getNext() != null)
                q = q.getNext();
            q.setNext(p);
        }
    }
    
    /**
     * Removes and returns the first element from the list
     */
    public Object removeFirst() {
        if (list == null) {
            System.out.println("removeFirst Runtime Error: Illegal Operation");
            System.exit(1);
        }
        DLLNode p = list;
        list = p.getNext();
        list.getNext().setBack(list);
        return p.getInfo();
    }
    

    /**
     * Removes and returns the last element from the list
     */
    public Object removeLast() {
        if (list == null) {
            System.out.println("removeLast Runtime Error: Illegal Operation");
            System.exit(1);
        }
        DLLNode p = list;
        DLLNode q = null;
        while (p.getNext() != null) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            list = null;
        else
            q.setNext(null);
        return p.getInfo();
    }

    /**
     * Inserts a node after the node referenced by p
     * @param p - reference to node after which the new node will be added
     * @param q - reference to node that will be inserted into the list
     */
    public void insertAfter(DLLNode p, Object o) {
        if (p == null) {
            System.out.println("insertAfter Runtime Error: Illegal Operation");
            System.exit(1);
        }
        DLLNode q = new DLLNode(o, p.getNext(), p);
        p.getNext().setBack(q);
        p.setNext(q);
    }
    

    /**
     * Inserts a node into its correct location within an ordered list
     * @param o - The element to be inserted into the list
     */
    public void insert(Object o) {
        DLLNode p = list;
        DLLNode q = null;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) > 0) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(o);
        else
            insertAfter(q, o);
    }

    /**
     * Returns true if this list contains no elements
     */
    public boolean isEmpty() {
        return list == null;
    }
    

    /**
     * Removes all elements from the list
     */
    public void clear() {
        list = null;
    }


    /**
     * Returns the number of elements in the list
     */
    public int size() {
        int count = 0;
        DLLNode p = list;
        while (p != null) {
            ++count;
            p = p.getNext();
        }
        return count;
    }
}
