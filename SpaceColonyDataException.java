/**
 * 
 */
package spacecolonies;

/**
 * @author Goodwin Lu
 * @version 10/31/2018
 *          Throws an exception in standard format. Used in ColonyReader when
 *          planets are wrong, or when skills are off
 */
@SuppressWarnings("serial")
public class SpaceColonyDataException extends Exception {
    /**
     * constructor
     * 
     * @param string
     *            error message
     */
    public SpaceColonyDataException(String string) {
        super(string);
    }
}
