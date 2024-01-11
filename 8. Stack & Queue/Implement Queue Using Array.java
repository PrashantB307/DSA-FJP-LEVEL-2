

//   https://practice.geeksforgeeks.org/problems/implement-queue-using-array/1

//   https://www.codingninjas.com/studio/problems/implement-queue-using-arrays_8390825


class MyQueue {

    int front, rear;
	int arr[] = new int[100005];

    MyQueue()
	{
		front=0;
		rear=0;
	}
	
	void push(int x)
	{
	   arr[front] = x;
	   front++;
	} 

	int pop()
	{
	    
	    if(front == rear){
	        return -1;
	    }
	    
		int val = arr[rear];
		rear++;
		return val;
	} 
}

