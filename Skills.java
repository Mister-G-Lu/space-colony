/**
 * 
 */
package spacecolonies;

/**
 * @author Goodwin Lu
 * @version 10.26.2018.
 */
public class Skills {
    private int agriculture;
    private int medicine;
    private int technology;


    /**
     * constructor. Skills are between 1 and 5.
     * 
     * @param ag
     *            agriculture;
     * @param med
     *            medicine;
     * @param tech
     *            technology;
     */
    public Skills(int ag, int med, int tech) {
        agriculture = ag;
        medicine = med;
        technology = tech;
    }


    /**
     * see if skills are lower
     * 
     * @param other
     *            the other skills
     * @return if skills are lower/equal
     */
    public boolean isBelow(Skills other) {
        return (agriculture <= other.agriculture && medicine <= other.medicine
            && technology <= other.technology);
    }


    /**
     * see if two skills are equal
     * 
     * @param obj
     *            the other skill
     * @return true/false
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
        return (agriculture == ((Skills)obj).getAgriculture()
            && medicine == ((Skills)obj).getMedicine()
            && technology == ((Skills)obj).getTechnology());
    }


    /**
     * get ag
     * 
     * @return ag
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * get med
     * 
     * @return med
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * get tech
     * 
     * @return tech
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * set ag
     * 
     * @param ag
     *            agriculture
     */
    public void setAgriculture(int ag) {
        agriculture = ag;
    }


    /**
     * set med
     * 
     * @param m
     *            medicine
     */
    public void setMedicine(int m) {
        medicine = m;
    }


    /**
     * set tech
     * 
     * @param t
     *            technology
     */
    public void setTechnology(int t) {
        technology = t;
    }


    /**
     * get the string
     * 
     * @return A:? M:? T:?
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("A:");
        sb.append(agriculture);
        sb.append(" M:");
        sb.append(medicine);
        sb.append(" T:");
        sb.append(technology);
        return sb.toString();
    }
}
