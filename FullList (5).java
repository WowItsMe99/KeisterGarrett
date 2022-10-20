public class FullList<E>
{
   private class Node
   {
      E element;
      Node next;
      Node prev;
            
      public Node(E element)
      {::/;
         this.element = element;
      }
   }
   
   private Node head;
   private Node tail;
   private int size = 0;
   
   public FullList()
   {
      head = null;
      tail = null;
   }
   
   /* TODO: This method should add the element to the beginning of 
            of the list and increase the size of the list by one. The 
            head and tail variables should be set correctly. */
   public void addBeginning(E element)
   {
      Node NewNode = new Node(element);//creates new node  
          //set the new node as head and tail
      if(head == null)
      {
         tail = NewNode;
      }
      else
      {
         head.prev = NewNode;
      }
      NewNode.next = head;
      head = NewNode;
      size++;
   }
   /* TODO: This method should insert the element at the given index.
            The size of the should increase by one.  The head and tail
            variables should be set correctly. */
   public void addMiddle(int index, E element)
   {   
   Node NewNode = new Node(element);
   
      if (index == 0)
      {
         addBeginning(element);
      }
      else 
      {
         Node current = head;//points current to head
         
         for(int i = 0; i < index/*-1*/; i++)
         {
         current = current.next;
         }
         
         
         //Added between current and prev
         NewNode.next = current;
         NewNode.prev = current.prev;
         current.prev.next = NewNode;
         current.prev = NewNode;
         size++;
      }
   }  
   /* TODO: This method should add the element to the end of 
            of the list and increase the size of the list by one.
            The head and tail variables should be set correctly. */   
   public void addEnd(E element)
   {
      Node NewNode = new Node(element);
    
      if(head == null)
      {
         head = NewNode;
      }
      else 
      {
         tail.next = NewNode;
         NewNode.prev = tail;
      }
   
      tail = NewNode;
      size++;
   }
   private Node getNode(int index)
   {
      if(index < 0 || index > size - 1)
      {
         throw new IndexOutOfBoundsException();
      }
      
      Node node = head;
      for(int i = 0; i < index; i++)
      {
         node = node.next;
      }
      
      return node;
   }

   public E get(int index)
   {
      return getNode(index).element;
   }
      
   public int size()
   {
      return size;
   }
   
   public boolean isHeadNull()
   {
      return head == null;
   }
   
   public boolean isTailNull()
   {
      return tail == null;
   }
}
