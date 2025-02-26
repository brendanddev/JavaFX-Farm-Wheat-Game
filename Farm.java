package wheatGame;

/**
 * This class represents the main logic for the farm game, managing interactions between the user, the view class, and game state. 
 * It tracks wheat, money, and baked goods, with methods for planting, harvesting, selling wheat, and baking bread and cakes. 
 * It also checks if wheat is ready to harvest based on its growth stages.
 * @author BRENDAN DILEO
 */
public class Farm {
    private Wheat[] wheat;
    private int numOfWheat;
    private double money;
    private int wheatPerHarvest;
    private int numOfBreadSlice;
    private int numOfBreadLoaf;
    private int numOfCake;

    /**
     * This constructor initializes a farm instance with a new array of 100,000,000 wheat objects, setting default values 
     * for wheat, money, and wheat per harvest.
     */
    public Farm() {
       this.wheat = new Wheat[100_000_000];
       for (int i = 0; i < wheat.length; i++) {
           this.wheat[i] = new Wheat();
       }
        numOfWheat = 0;
        money = 0;
        wheatPerHarvest = 1;
    }

    public int getNumOfWheat() {
        return numOfWheat;
    }

    public double getMoney() {
        return money;
    }

    public int getNumOfBreadSlice() {
        return numOfBreadSlice;
    }

    public int getNumOfBreadLoaf() {
        return numOfBreadLoaf;
    }

    public int getNumOfCake() {
        return numOfCake;
    }

    public void sellWheat(int wheatAmount) {
        if (numOfWheat >= wheatAmount) {
            money = money + wheatAmount;
            numOfWheat = numOfWheat - wheatAmount;
        }
    }
    
    public void plantWheat() {
        if (numOfWheat > 0) {
            numOfWheat--;
            wheatPerHarvest++;
        }
    }

    public void harvestWheat() {
        for (int i = 0; i < numOfWheat; i++) {
            Wheat currentWheat = wheat[i];
            if (currentWheat.isHarvestFlag()) {
                currentWheat.setHarvestFlag(false);
            }
        }
        numOfWheat = numOfWheat + wheatPerHarvest;
    }

    public void buyBreadSlice(int breadSliceAmount) {
        int breadSliceCost = 5;
        if (money >= breadSliceCost) {
            money = money - breadSliceCost;
            numOfBreadSlice++;
        }
    }

    public void bakeBreadSlice(int breadSliceAmount) {
        int breadSliceWheatCost = 5;
        if (numOfWheat >= breadSliceWheatCost) {
            numOfWheat = numOfWheat - breadSliceWheatCost;
            numOfBreadSlice++;
        }
    }

    public void breadSliceToLoaf() {
        int loafSliceCost = 8;
        if (numOfBreadSlice >= loafSliceCost) {
            numOfBreadSlice = numOfBreadSlice - loafSliceCost;
            numOfBreadLoaf++;
        }
    }

    public void buyBreadLoaf(int loafAmount) {
        int breadLoafCost = 8;
        if (money >= breadLoafCost) {
            money = money - breadLoafCost;
            numOfBreadLoaf++;
        }
    }

    public void bakeBreadLoaf(int loafAmount) {
        int breadLoafWheatCost = 8;
        if (numOfWheat >= breadLoafWheatCost) {
            numOfWheat = numOfWheat - breadLoafWheatCost;
            numOfBreadLoaf++;
        }
    }

    public void buyCake(int cakeAmount) {
        int cakeCost = 10;
        if (money >= cakeCost) {
            money = money - cakeCost;
            numOfCake++;
        }
    }

    public void bakeCake(int cakeAmount) {
        int cakeWheatCost = 10;
        if (numOfWheat >= cakeWheatCost) {
            numOfWheat = numOfWheat - cakeWheatCost;
            numOfCake++;
        }
    }
    
    public boolean checkHarvest() {
        boolean readyToHarvest = false;
        for (int i = 0; i < numOfWheat; i++) {
            Wheat currentWheat = wheat[i];
            if (currentWheat.getGrowthLevel() == 3 && !currentWheat.isHarvestFlag()) {
                currentWheat.setHarvestFlag(true);
                readyToHarvest = true;
            }
        }
        return readyToHarvest;
    }
}
