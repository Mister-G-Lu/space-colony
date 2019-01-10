/**
 * 
 */
package spacecolonies;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * @author Goodwin Lu
 * @version 11/8/2018
 */

@SuppressWarnings("unused")
public class ColonyReaderTest extends student.TestCase {
    private ColonyReader cr;
    private ColonyReader wrong;
    private ColonyReader shorttest;


    /**
     * setup
     * 
     * @throws SpaceColonyDataException
     *             if wrong arguments
     * @throws ParseException
     *             if unable to parse
     * @throws FileNotFoundException
     *             if file wasn't found
     */
    public void setUp()
        throws ParseException,
        SpaceColonyDataException,
        FileNotFoundException {

        cr = new ColonyReader("input.txt", "planets.txt");
        try {
            shorttest = new ColonyReader("inputShort.txt", "planets1.txt");
        }
        catch (Exception e) {
            System.out.println("Caught error");
        }
        /*
         * try {
         * wrong = new ColonyReader("input.txt", "planetsWrongNumber.txt");
         * }
         * catch (ParseException e) {
         * System.out.println("Caught parse exception.");
         * }
         */

    }


    /**
     * test all methods.
     */
    public void testAll() {
        /*
         * for (Planet i : shorttest.getPlanets()) {
         * if (i != null) {
         * System.out.println("Planet in shorttest " +
         * i.toString());
         * }
         * }
         */
        assertTrue(cr.isInSkillRange(3, 3, 3));
        assertFalse(cr.isInSkillRange(7, 8, 3));
        assertTrue(cr.getPlanets().length > 0);
        /*
         * for (Planet i : cr.getPlanets()) {
         * if (i != null) {
         * System.out.println("Planet in cr " + i.toString());
         * }
         * }
         */
    }
}
