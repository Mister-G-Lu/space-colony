/**
 * 
 */
package spacecolonies;

/**
 * @author Goodwin Lu
 * @version 11/7/2018
 */
public class ColonyCalculatorTest extends student.TestCase {
    private ColonyCalculator realtest;

    private Person bob;
    private Person tesla;
    private Person aggie;
    private Person nopref;
    private Person herbert;
    private Person leo;
    private Planet[] imitator = new Planet[ColonyCalculator.NUM_PLANETS + 1];


    /**
     * setup.
     */
    public void setUp() {
        ArrayQueue<Person> aq4;

        aq4 = new ArrayQueue<Person>();

        tesla = new Person("Nikola Tesla", 3, 7, 5, "Planet2");
        bob = new Person("Bob Marley", 5, 3, 1, "Planet1");
        aggie = new Person("Ag", 7, 7, 7, "Planet1");
        nopref = new Person("NoClue", 8, 8, 8, "");
        leo = new Person("Loenard McCoy", 2, 3, 5, "Planet3");
        herbert = new Person("Herbert Deforge", 5, 5, 5, "Planet3");
        aq4.enqueue(bob);
        aq4.enqueue(tesla);
        aq4.enqueue(aggie);
        imitator[1] = new Planet("Aggies", 5, 2, 2, 10);
        imitator[2] = new Planet("Meddies", 2, 5, 2, 4);
        imitator[3] = new Planet("Techies", 2, 2, 5, 8);

        realtest = new ColonyCalculator(aq4, imitator);
    }


    /**
     * test accept methods.
     */
    public void testAccept() {
        assertFalse(realtest.accept());
        realtest.reject();
        assertTrue(!imitator[2].isFull() && imitator[2].isQualified(tesla));
        assertEquals(realtest.getQueue().getFront(), tesla);
        assertTrue(realtest.accept());
    }


    /**
     * test get methods
     */
    public void testGet() {
        assertEquals(realtest.getPlanetForPerson(leo), imitator[3]);
        assertEquals(realtest.getPlanetForPerson(herbert), imitator[3]);
        assertEquals(realtest.getPlanetForPerson(tesla), imitator[2]);
        assertNull(realtest.getPlanetForPerson(bob));
        assertEquals(realtest.getPlanetForPerson(aggie), imitator[1]);
        assertEquals(realtest.getPlanetForPerson(nopref), imitator[1]);
        assertNull(realtest.planetByNumber(0));
        assertNull(realtest.planetByNumber(4));
        assertNull(realtest.getPlanetForPerson(null));
        assertEquals(ColonyCalculator.getPlanets(), imitator);
    }


    /**
     * test reject.
     */
    public void testReject() {
        realtest.reject();
        System.out.println("CC Queue after rejecting: " + realtest.getQueue()
            .toString());
        realtest.reject();
        System.out.println("CC Queue after rejecting again: " + realtest
            .getQueue().toString());
        realtest.reject();
        realtest.reject();
        assertEquals(realtest.getQueue().toString(), "[]");
        assertFalse(realtest.accept());
    }
}
