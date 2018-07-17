package leo.yang;

public class CircularBuffer
{
   private int setSize;
   private int head = 0;  
   private int rear = 0;  
   private int length = 0;  
   private int[] buffer;    

//   constructor
   public CircularBuffer(int size) 
   {
       setSize = size;
       head = 0;
       rear = 0;
       length = 0;
       buffer = new int[setSize];
   }
//   f to find size of Buffer
   public int getSize()
   {
       return length;
   }
//   f to clear Buffer
   public void clear()
   {
       head = 0;
       rear = 0;
       length = 0;
       buffer = new int[setSize];
   }
//   check if Buffer Is empty
   public boolean isEmpty() 
   {
       return length == 0;
   }
//	 check if Buffer is full
   public boolean isFull() 
   {
       return length == setSize;
   } 
//	  add element
   public void add(int x) 
   {
       if (!isFull() ) 
       {
           length++;
           rear = (rear + 1) % setSize;
           buffer[rear] = x;
       }
       else
           System.out.println("Overflow");
   }
//	 remove element
   public int delete() 
   {
       if (!isEmpty() ) 
       {
           length--;
           head = (head + 1) % setSize;
           return buffer[head];
       }
       else 
       {
           System.out.println("UnderFlow");
           return -1;
       }
   }       

   public void display() 
   {
       System.out.print("\nBuffer : ");
       //ArrayPlayground.print(buffer);  
       for (int i = 0; i < length; i++) {
    	   System.out.print(buffer[(head+i+1)%length] + ", ");
       }
   }
}