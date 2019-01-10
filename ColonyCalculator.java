/**
 * 
 */
package spacecolonies;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Goodwin Lu
 * @version 10/31/2018
 *          getPlanetforPerson, accept, and reject methods.
 */
public class ColonyCalculator {
    /**
     * number of planets.
     */
    public static final int NUM_PLANETS = 3;
    /**
     * minimum skill level.
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * maximum skill level.
     */
    public static final int MAX_SKILL_LEVEL = 5;
    private ArrayQueue<Person> applicantQueue;
    private ArrayList<Person> rejectBus;
    private static Planet[] planets = new Planet[NUM_PLANETS + 1];


    /**
     * constructor.
     * 
     * @param person
     *            the array queue
     * @param planet
     *            array of planets
     */
    public ColonyCalculator(ArrayQueue<Person> person, Planet[] planet) {
        if (person == null) {
            throw (new IllegalArgumentException("Tried to have a null person"));
        }
        applicantQueue = person;
        planets = planet;
        rejectBus = new ArrayList<Person>();
    }


    /**
     * get the queue
     * 
     * @return
     *         application queue
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;
    }


    /**
     * get the planet (null if nextPerson is null or doesn't qualify for
     * anything).
     * 
     * When they have no preference, try to match most availability
     * (and qualified), if tied, go to highest numbered planet.
     * 
     * When they have preference, see if name matches, if they are qualified,
     * and if the planet isn't full
     * 
     * @param nextPerson
     *            the person
     * @return
     *         planet that best suits them
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson == null || applicantQueue.isEmpty()) {
            System.out.println("Person was null, or queue was empty");
            return null;
        }

        String plan = nextPerson.getPlanetName();
        System.out.println(nextPerson.getName() + " pref was " + nextPerson
            .getPlanetName());
        try {
            // attempt to access the index of the person's planet
            if (plan.length() > 0) {
                char s = plan.charAt(plan.length() - 1);
                System.out.println("S was " + s);
                if ((s == '1' || s == '2' || s == '3')) {
                    System.out.println("Accessing index of person's planet");
                    int x = s - '0';
                    System.out.println("X was " + x);
                    if (x <= NUM_PLANETS && planetByNumber(x).isQualified(
                        nextPerson) && !planetByNumber(x).isFull()) {
                        System.out.println("Returning person's index at " + x);
                        return planets[x];
                    }
                }
            }
        }
        catch (NumberFormatException e) {
            // do nothing.
            System.out.println("Caught NFE");
        }
        // person did not have a preference.
        System.out.println(nextPerson.getName()
            + " didn't have pref, or didnt qualify for wanted");
        ArrayList<Planet> copyPlanets = new ArrayList<Planet>();
        // System.out.println("Planets.length = " + planets.length);
        for (int i = 0; i < planets.length; i++) {
            // copy the array.
            if (planets[i] != null) {
                copyPlanets.add(planets[i]);
            }
        }
        // sort the array by most availability
        Collections.sort(copyPlanets);
        copyPlanets.add(0, null);
        boolean qualified = false;
        Planet highest = copyPlanets.get(1);
        for (int i = 0; i < NUM_PLANETS + 1; i++) {

            Planet curr = copyPlanets.get(i);
            // ensure the person is qualified and planet not full
            if (curr != null && curr.isQualified(nextPerson) && !curr.isFull()
                && curr.compareTo(highest) >= 0) {
                System.out.println("Changing planet from " + highest.toString()
                    + " to " + curr.toString());
                qualified = true;
                highest = curr;
            }
        }
        if (qualified) {
            return highest;
        }
        else {
            return null;
        }
    }


    /**
     * try to accept the next Person
     * 
     * @return
     *         if they were accepted (false when gotten planet is null, when AQ
     *         is empty, or when they don't qualify at all)
     */
    public boolean accept() {
        if (!applicantQueue.isEmpty()) {
            Person p = applicantQueue.getFront();
            Planet send = getPlanetForPerson(p);
            if (send == null) {
                return false;
            }
            send.addPerson(p);
            applicantQueue.dequeue();
            return true;
        }
        return false;
    }


    /**
     * reject the person by putting them inside rejectBus
     */
    public void reject() {
        if (!applicantQueue.isEmpty()) {
            Person p = applicantQueue.getFront();
            applicantQueue.dequeue();
            // System.out.println("person was " + p.toString());
            rejectBus.add(p);
        }
    }


    /**
     * get planet by number (from planets array)
     * 
     * @param planet
     *            the planet desired
     * @return
     *         the planet
     */
    public Planet planetByNumber(int planet) {
        return (planet >= 1 && planet <= 3) ? planets[planet] : null;
    }


    /**
     * get the index of a planet
     * 
     * @param planet
     *            planet name
     * @return
     *         the index if found, else, 0
     */
    public int getPlanetIndex(String planet) {
        for (int i = 0; i < planets.length; i++) {
            if (planets[i] != null && planets[i].getName().equals(planet)) {
                return i;
            }
        }
        return 0;
    }


    /**
     * get the array
     * 
     * @return
     *         planets[]
     */
    public static Planet[] getPlanets() {
        return planets;
    }
}
