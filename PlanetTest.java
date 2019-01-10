/**
 * 
 */
package spacecolonies;

/**
 * @author Goodwin Lu
 * @version 10/29/2018
 */
public class PlanetTest extends student.TestCase {
    private Planet lowQ;
    private Planet midQ;
    private Planet highQ;
    private Planet empty;
    private Planet empty2;

    private Person john;
    private Person doctor;


    /**
     * setup
     */
    public void setUp() {
        lowQ = new Planet("LowQ Planet", 1, 1, 1, 100);
        midQ = new Planet("LowQ Planet", 6, 6, 6, 100);
        highQ = new Planet("HighQ Planet", 10, 10, 10, 1);

        empty = new Planet("HighQ Planet", 10, 10, 10, 1);
        empty2 = new Planet("HighQ Planet", 10, 10, 10, 5);
        john = new Person("John", 3, 3, 3, "LowQ Planet");
        doctor = new Person("Dr D", 15, 15, 15, "HighQ Planet");
    }


    /**
     * test all methods.
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testAll() {
        assertTrue(empty.equals(empty2));
        assertFalse(lowQ.equals(empty));
        assertFalse(lowQ.equals("NotAPlanet"));
        assertEquals(lowQ.getAvailability(), 100);
        assertEquals(highQ.getAvailability(), 1);
        assertTrue(lowQ.addPerson(john));
        lowQ.toString();
        assertFalse(highQ.addPerson(john));
        assertTrue(lowQ.addPerson(doctor));
        assertEquals(lowQ.compareTo(lowQ), 0);
        assertTrue(highQ.addPerson(doctor));
        assertFalse(highQ.addPerson(doctor));
        assertTrue(lowQ.equals(lowQ));
        assertFalse(lowQ.equals(midQ));
        assertFalse(lowQ.equals(highQ));
        midQ.addPerson(doctor);
        assertEquals(lowQ.compareTo(midQ), -1);
        assertEquals(midQ.compareTo(highQ), 1);
        assertFalse(lowQ.isFull());
        assertTrue(lowQ.isQualified(doctor));
    }
}
