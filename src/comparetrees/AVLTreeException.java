package comparetrees;
/**
 * Reports an exception in an AVL Tree
 * @author William Duncan
 * @since 99-99-9999
 */

public class AVLTreeException extends Exception 
{

    /**
     * Creates a new instance of <code>AVLTreeException</code> without detail
     * message.
     */
    public AVLTreeException() { }

    /**
     * Constructs an instance of <code>AVLTreeException</code> with the
     * specified detail message.
     * @param msg the detail message.
     */
    public AVLTreeException(String msg) 
    {
        super(msg);
    }
}
