package wheatGame;

public class Wheat {
    
    private int growthLevel;
    private boolean harvestFlag;
    
    public Wheat() {
        this.growthLevel = 0;
        this.harvestFlag = false;
    }

    public int getGrowthLevel() {
        return growthLevel;
    }

    public boolean isHarvestFlag() {
        return harvestFlag;
    }

    public void setHarvestFlag(boolean harvestFlag) {
        this.harvestFlag = harvestFlag;
    }
}
