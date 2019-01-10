/**
 * 
 */
package spacecolonies;

/**
 * @author Goodwin Lu
 * @version 11/7/2018
 */
public class PersonTest extends student.TestCase {
    private Person john;
    private Person doctor;
    private Person idk;
    private Person almostjohn;


    /**
     * setup
     */
    public void setUp() {
        john = new Person("John", 3, 3, 3, "LowQ Planet");
        doctor = new Person("Dr D", 15, 15, 15, "HighQ Planet");
        idk = new Person("IDK", 6, 6, 6, "");
        almostjohn = new Person("John", 3, 3, 3, "MedQ");
    }


    /**
     * test all methods.
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testAll() {
        assertEquals(john.getName(), "John");
        john.getSkills();
        assertFalse(doctor.equals(john));
        boolean x = doctor.equals(new Object());
        assertFalse(x);
        assertNotNull(john);
        assertFalse(john.equals("NotAPerson"));
        assertFalse(john.equals(doctor));
        assertTrue(john.equals(john));
        assertFalse(john.equals(almostjohn));
        assertEquals(john.toString(), "John A:3 M:3 T:3 Wants: LowQ Planet");
        assertEquals(idk.toString(), "No-Planet IDK A:6 M:6 T:6");
        john.setName("NewJohn");
        john.setPlanetName("HighQ Planet");
        john.setSkills(new Skills(20, 20, 20));
        assertEquals(john.getPlanetName(), "HighQ Planet");
    }
}
