package spacecolonies;

/**
 * @author Goodwin Lu
 * @version 10/29/2018
 * 
 *          Planet class, with name, minskills, population array, size, and
 *          capacity
 */
public class Planet implements Comparable<Planet> {
    private String name;
    private Skills minSkills;
    private Person[] population;
    private int populationSize;
    private final int capacity;


    /**
     * constructor. Sets popsize to zero.
     * 
     * @param planetName
     *            name
     * @param planetAgri
     *            ag
     * @param planetMedi
     *            med
     * @param planetTech
     *            tech
     * @param planetCap
     *            capacity
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {
        name = planetName;
        minSkills = new Skills(planetAgri, planetMedi, planetTech);
        capacity = planetCap;
        population = new Person[capacity];
        populationSize = 0;
    }


    /**
     * set the name
     * 
     * @param n
     *            the new name
     */
    public void setName(String n) {
        name = n;
    }


    /**
     * get capacity
     * 
     * @return
     *         capacity
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * get population array
     * 
     * @return
     *         pop array
     */
    public Person[] getPopulation() {
        return population;
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
     * get skill
     * 
     * @return
     *         skill
     */
    public Skills getSkill() {
        return minSkills;
    }


    /**
     * get pop
     * 
     * @return
     *         population
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * place left
     * 
     * @return
     *         how many places left
     */
    public int getAvailability() {
        return capacity - populationSize;
    }


    /**
     * see if capacity is reached
     * 
     * @return
     *         true/false
     */
    public boolean isFull() {
        return capacity == populationSize;
    }


    /**
     * add new person
     * 
     * @param newbie
     *            the person
     * @return
     *         if added
     */
    public boolean addPerson(Person newbie) {
        if (!isFull() && isQualified(newbie)) {
            population[populationSize] = newbie;
            populationSize++;
            return true;
        }
        return false;
    }


    /**
     * see if qualified
     * 
     * @param p
     *            the person
     * @return
     *         true/false
     */
    public boolean isQualified(Person p) {
        return minSkills.isBelow(p.getSkills());
    }


    /**
     * string version
     * 
     * @return
     *         String version of the planet (Name, population, capacity,
     *         requires A >=, M>=, T>=)
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + ", population " + populationSize + " (cap: " + capacity
            + "), Requires: A >= " + minSkills.getAgriculture() + ", M >= "
            + minSkills.getMedicine() + ", T >= " + minSkills.getTechnology());
        return sb.toString();
    }


    /**
     * = method
     * 
     * @return
     *         true/false
     * @param obj
     *            the other planet
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null || obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        return (name.equals(((Planet)obj).getName()) && minSkills.equals(
            ((Planet)obj).getSkill()) && getPopulationSize() == ((Planet)obj)
                .getPopulationSize());
    }


    /**
     * compare availability
     * 
     * @param other
     *            the other planet
     * @return
     *         -1 if less available/0 if same/1 if more available
     */
    @Override
    public int compareTo(Planet other) {
        if (getAvailability() < other.getAvailability()) {
            return -1;
        }
        if (getAvailability() == other.getAvailability()) {
            return 0;
        }
        return 1;
    }
}
