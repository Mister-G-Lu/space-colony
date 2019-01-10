
package spacecolonies;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * @author Goodwin Lu
 * @version 11/1/2018
 */
public class ProjectRunner {
    /**
     * main method
     * 
     * @param args
     *            the input
     * @throws SpaceColonyDataException
     *             see the class
     * @throws ParseException
     *             see the class
     * @throws FileNotFoundException
     *             if file wasn't found
     */
    @SuppressWarnings("unused")
    public static void main(String[] args)
        throws ParseException,
        SpaceColonyDataException,
        FileNotFoundException {
        if (args.length == 2) {
            ColonyReader cr = new ColonyReader(args[0], args[1]);
        }
        else {
            ColonyReader cr = new ColonyReader("input.txt", "planets.txt");
        }

    }
}
