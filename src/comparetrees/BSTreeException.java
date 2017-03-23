package comparetrees;
/**
/**
 * Reports an exception in a binary search tree
 * @author Duncan
 * @since 99-99-9999
 */
public class BSTreeException extends Exception 
{
    /**
     * Creates a new instance of <code>BSTreeException</code> without detail
     * message.
     */
    public BSTreeException() { }

    /**
     * Constructs an instance of <code>BSTreeException</code> with the specified
     * detail message.
     * @param msg the detail message.
     */
    public BSTreeException(String msg) 
    {
        super(msg);
    }
}
