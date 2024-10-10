package wheatGame;

/**
 * This class represents the secondary model class in the farm game. It makes up the wheat object, where each wheat object
 * consists of a level of growth (growthLevel), and whether or not it is ready to be harvested (harvestFlag). The class
 * will contribute to the other model class (farm class). This class is used for encapsulating the wheat object, and
 * will be associated with the farm class, and farm game class.
 *
 * @author BRENDAN DILEO
 */
public class Wheat {
    // INSTANCE VARIABLES:
    /**
     * 'growthLevel' as type int, represents the growth level of the plant. Each integer represents a different level of
     * growth to later determine if it is ready to harvest.
     */
    private int growthLevel;
    /**
     * 'harvestFlag' of type boolean, is a boolean flag which will determine if the wheat can be harvested or not
     * depending on the growth level. The flag will be determined by the growth level of the wheat.
     */
    private boolean harvestFlag;

    /**
     * Constructor for the wheat object. It will take no parameters, and when an instance of the wheat object is created,
     * the growth level is set to 0, and the harvest flag is set to false as default. Both of the variables are set using
     * the 'this' keyword when an instance is created.
     */
    public Wheat() {
        this.growthLevel = 0;
        this.harvestFlag = false;
    }

    /**
     * This method retrieves (gets) the current growth level of the wheat object where the growth level represents the
     * level / stage of growth of the wheat object.
     *
     * @return growthLevel, which is the growth level of the given wheat object.
     */
    public int getGrowthLevel() {
        return growthLevel;
    }

    /**
     * This method determines (gets) the current state of the wheat object, where the current flag/state is dependent on
     * the boolean flag variable.
     *
     * @return harvestFlag, which is a boolean flag determining if the wheat can be harvested or not.
     */
    public boolean isHarvestFlag() {
        return harvestFlag;
    }

    /**
     * This method allows for the boolean flag 'harvestFlag' to be initialized (set) to a certain boolean value. It will
     * allow direct manipulation of the state of the wheat object, if it can be harvested or not.
     *
     * @param harvestFlag, the boolean flag/value that is passed to the method to set the flag/state of the wheat object.
     */
    public void setHarvestFlag(boolean harvestFlag) {
        this.harvestFlag = harvestFlag;
    }
}
