/**
 * 
 */
package spacecolonies;

/**
 * @author Goodwin Lu
 * @version 11/16/2018
 */
public class SpaceColonyDataExceptionTest {
    /**
     * test the exception.
     */
    public void testException() {
        try {
            throw (new SpaceColonyDataException("Something happened"));
        }
        catch (SpaceColonyDataException e) {
            e.printStackTrace();
        }
    }
}
