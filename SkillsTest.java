/**
 * 
 */
package spacecolonies;

/**
 * @author Goodwin Lu
 * @version 10/29/2018
 */
public class SkillsTest extends student.TestCase {
    private Skills skills;
    private Skills almostSkills;
    private Skills notQuite;
    private Skills empty;


    /**
     * setup methods
     */
    public void setUp() {
        skills = new Skills(1, 2, 3);
        almostSkills = new Skills(1, 2, 1);
        notQuite = new Skills(0, 0, 3);
        empty = null;
    }


    /**
     * test all methods
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testAll() {
        assertFalse(skills.equals(empty));
        assertFalse(skills.equals("NotASkill"));
        assertTrue(skills.equals(skills));
        assertEquals(skills.getAgriculture(), 1);
        assertEquals(skills.getMedicine(), 2);
        assertEquals(skills.getTechnology(), 3);
        assertEquals(skills.toString(), "A:1 M:2 T:3");
        Skills skillslow = new Skills(0, 1, 2);
        assertTrue(skillslow.isBelow(skills));
        assertFalse(skillslow.equals(skills));
        assertTrue(notQuite.isBelow(skills));
        assertFalse(notQuite.isBelow(almostSkills));
        assertFalse(notQuite.equals(skills));
        assertFalse(skills.equals(almostSkills));
        assertTrue(almostSkills.isBelow(skills));
    }
}
