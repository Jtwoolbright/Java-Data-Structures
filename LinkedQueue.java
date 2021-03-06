/*        Name: Josh Woolbright
 * Description: This is a simple queue made from a linked list.
 *              The queue is used for airplanes that are taking off
 *              in the Airport file.
 */
public class LinkedQueue<T> implements QueueInterface<T>
{
    private Node firstNode;
    private Node lastNode;

    public LinkedQueue()
    {
        firstNode = null;
        lastNode = null;
    }

    @Override
    public void enqueue(T newEntry)
    {
        Node newNode = new Node(newEntry, null);
        if (isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode);
        lastNode = newNode;
    }

    @Override
    public T dequeue()
    {
        if (isEmpty())
            throw new EmptyQueueException("Queue is Empty");
        T data = firstNode.data;
        firstNode = firstNode.next;
        return data;
    }

    @Override
    public T getFront()
    {
        if (isEmpty())
            throw new EmptyQueueException("Queue is Empty");
        return firstNode.getData();
    }

    @Override
    public boolean isEmpty()
    {
        return firstNode == null;
    }

    @Override
    public void clear()
    {
        firstNode = lastNode = null;
    }

    private class Node
    {
        private T data;
        private Node next;

        private Node(T data, Node next)
        {
            this.data = data;
            this.next = next;
        }

        private T getData()
        {
            return data;
        }

        private void setNextNode(Node next)
        {
            this.next = next;
        }
    }
}
