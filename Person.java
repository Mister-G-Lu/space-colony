/**
 * 
 */
package spacecolonies;

/**
 * @author Goodwin Lu
 * @version 10/26/2018
 */
public class Person {
    private String name;
    private Skills skills;
    private String planetPreference;


    /**
     * Person constructor (calls Skills constructor)
     * 
     * @param name
     *            String name
     * @param agri
     *            int ag
     * @param medi
     *            int med
     * @param tech
     *            int tech
     * @param planet
     *            String planet
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        skills = new Skills(agri, medi, tech);
        this.name = name;
        planetPreference = planet;
    }


    /**
     * get skill
     * 
     * @return
     *         skill
     */
    public Skills getSkills() {
        return skills;

    }


    /**
     * get name
     * 
     * @return
     *         name
     */
    public String getName() {
        return name;

    }


    /**
     * get planet name that the person wants
     * 
     * @return
     *         planet
     */
    public String getPlanetName() {
        return planetPreference;

    }


    /**
     * set skill
     * 
     * @param s
     *            the skill
     */
    public void setSkills(Skills s) {
        skills = s;

    }


    /**
     * set name
     * 
     * @param n
     *            the name
     */
    public void setName(String n) {
        name = n;

    }


    /**
     * set planet name
     * 
     * @param planet
     *            the planet name
     */
    public void setPlanetName(String planet) {
        planetPreference = planet;

    }


    /**
     * to string. ("No-planet" is before anything else)
     * 
     * @return
     *         string version
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (planetPreference.length() <= 0) {
            sb.append("No-Planet ");
        }
        sb.append(name);
        sb.append(" A:");
        sb.append(skills.getAgriculture());
        sb.append(" M:");
        sb.append(skills.getMedicine());
        sb.append(" T:");
        sb.append(skills.getTechnology());
        if (planetPreference.length() > 0) {
            sb.append(" Wants: ");
            sb.append(planetPreference);
        }
        return sb.toString();
    }


    /**
     * equals
     * 
     * @return
     *         true/false
     * @param obj
     *            the object
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        return name.equals(((Person)obj).getName()) && skills.equals(
            ((Person)obj).getSkills()) && planetPreference.equals(((Person)obj)
                .getPlanetName());
    }
}
