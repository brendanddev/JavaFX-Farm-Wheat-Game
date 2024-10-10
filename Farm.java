package wheatGame;

/**
 * This class represents the primary/main model class for the farm game. It consists of the majority of the game's logic,
 * and provides information/data to the view class, and in turn the user too. This class will consist of multiple instance
 * variables, and methods encapsulating the majority of the games functionality and logic. It will handle interactions
 * between the user, and the view class through the methods and modifys some of the games state. The instance variables
 * consist of an array of wheat objects, which is associated with the wheat class, and variables for the number of wheat,
 * money, number of bread slices, loafs, and cakes the user has. It will also have a variable for the number of wheat
 * given per harvest, as the user can harvest more wheat depending on if they have planted any wheat. The methods in this
 * class will consist of some basic getter methods, as well as methods for selling their wheat, harvesting wheat, planting
 * wheat, and baking or buying cakes, slices of bread, and loafs of bread. Additionally, the class will have a method to
 * check whether or not the wheat object is ready to harvest, with the use of the harvest flag's and growth levels from
 * the wheat class.
 *
 *
 * @author BRENDAN DILEO
 */
public class Farm {
    // Instance Variables:

    /**
     * 'wheat' is an array of type Wheat, which represents all the wheat objects on the farm.
     */
    private Wheat[] wheat;
    /**
     * 'numOfWheat' of type int, represents the number of wheat objects that the user will have. This can be incremented
     * when the user harvests wheat.
     */
    private int numOfWheat;
    /**
     * 'money' of type double, will represent the amount of money that the user will have. This will be incremented when
     * the user sells an item.
     */
    private double money;
    /**
     * 'wheatPerHarvest' of type int, will represent the number of wheat objects that the user will get from harvesting
     * a wheat object. Each time the user plants a wheat object, they will gain a certain number of wheat per harvest.
     */
    private int wheatPerHarvest;
    /**
     * 'numOfBreadSlice' of type int, is the number of slices of bread the user will have. This can be incremented when
     * the user chooses to bake, or buy slices of bread.
     */
    private int numOfBreadSlice;
    /**
     * 'numOfBreadLoaf' of type int, is the number of loafs of bread the user will have. This can be incremented when the
     * user chooses to bake, buy, or form a loaf of bread.
     */
    private int numOfBreadLoaf;
    /**
     * 'numOfCake' of type int, is the number of cakes the user will have. This can be incremented when the user chooses
     * to bake, or buy cakes.
     */
    private int numOfCake;

    /**
     * This constructor will create an instance of the farm class when called upon. It will take no parameters, but will
     * create a new array of wheat objects with a length of 100,000,000 representing the maximum number of wheat objects
     * the user can have. The new array is created using the 'this' keyword so that the initial wheat instance variable
     * is encapsulated, and not directly accessed from outside the class. The new wheat array uses a loop to copy the
     * wheat objects from the instance variable array, into the new array of wheat objects. As a default, the number of
     * wheat the user will have is set to 0, their money is set to 0, and the wheat they get per harvest is set to 1.
     */
    public Farm() {
        // Creates a new wheat array for encapsulation and privacy leak purposes.
       this.wheat = new Wheat[100_000_000];
       for (int i = 0; i < wheat.length; i++) {
           this.wheat[i] = new Wheat();
       }
       // Default values for the constructor.
        numOfWheat = 0;
        money = 0;
        wheatPerHarvest = 1;
    }

    /**
     * This method is used to retrieve (get) the number of wheat the user will have, so the number of wheat is accessed
     * indirectly from outside the class.
     *
     * @return numOfWheat, which is the number of wheat the user will have/has.
     */
    public int getNumOfWheat() {
        return numOfWheat;
    }

    /**
     * This method is used to retrieve (get) the amount of money the user will have, this allows indirect access of the
     * money variable from outside of the class.
     *
     * @return money, which is the amount of money the user will have/has.
     */
    public double getMoney() {
        return money;
    }

    /**
     * This method is used to retrieve (get) the number of slices of bread the user will have. It allows for indirect
     * access of the number of bread slices variable from outside of the class.
     *
     * @return numOfBreadSlice, which is the number of slices of bread the user has/will have.
     */
    public int getNumOfBreadSlice() {
        return numOfBreadSlice;
    }

    /**
     * This method gets the number of loafs of bread the user will have. It will allow for indirect access of the number
     * of loafs of bread the user will have/has from outside of the class.
     *
     * @return numOfBreadLoaf, the number of loafs of bread the user will have/has.
     */
    public int getNumOfBreadLoaf() {
        return numOfBreadLoaf;
    }

    /**
     * This method retrieves (gets) the number of cakes the user will have. It allows for indirect access of the number
     * of cakes the user will have from outside of the class without direct access to the instance variable itself.
     *
     * @return numOfCake, the number of cakes the user has/will have.
     */
    public int getNumOfCake() {
        return numOfCake;
    }

    /**
     * This method is responsible for handling the logic behind the user selling the wheat they have. It takes a parameter
     * as the amount of wheat they intend to sell, and checks if the number of wheat they have is equal to or greater
     * than that number. If it is, the users money is incremented, and the number of wheat they have is decremented.
     *
     * @param wheatAmount, the number of wheat the user is selling.
     */
    public void sellWheat(int wheatAmount) {
        // The if statement checks the condition of is the number of wheat the user has equal to or greater than the
        // number of wheat the user is selling.
        if (numOfWheat >= wheatAmount) {
            // If the statement evaluates to true, their money is incremented by the number of wheat they have sold to
            // simulate the selling logic.
            money = money + wheatAmount;
            // The number of wheat they have is decremented by the number of wheat they have sold, to simulate the selling
            // logic.
            numOfWheat = numOfWheat - wheatAmount;
        }
    }

    /**
     * The purpose of this method is to simulate the user actually planting the wheat. It checks if the user has more
     * than 0 pieces of wheat, and if they do, the number of wheat they have is decremented by 1, and the number of wheat
     * they now get per harvest is incremented by 1. This method allows the user to continuously plant wheat as long as
     * they have 1 or more pieces of wheat. This simulates the action of planting the wheat, for the purpose of gaining
     * more wheat per harvest.
     */
    public void plantWheat() {
        // This if statement checks if the number of wheat the user has is greater than 0, as they cannot plant 0 pieces
        // of wheat.
        if (numOfWheat > 0) {
            // If the condition evaluates to true, the number of wheat the user has is decremented by 1.
            numOfWheat--;
            // The number of wheat they now gain per harvest is incremented by 1.
            wheatPerHarvest++;
        }
    }

    /**
     * This method is responsible for simulating the action of harvesting the wheat that will be on the users screen.
     * It will use a for loop to iterate through each value from 'i' to the number of wheat the user has, and in each
     * iteration, the current index of the number of wheat is assigned to a new wheat object from the wheat array.
     * The if statement then checks if the piece of wheat is ready for harvest, and if it is the wheat objects is then
     * set to false, to simulate this action of harvesting the wheat, so the wheat object cannot be continuously harvested.
     * The number of wheat the user has is then incremented by the number of wheat the user gets per harvest.
     */
    public void harvestWheat() {
        // For loop responsible for iterating through 0 - the number of wheat the user has.
        for (int i = 0; i < numOfWheat; i++) {
            // At each iteration, a variable 'currentWheat' is assigned to the index of a wheat object in the wheat array.
            Wheat currentWheat = wheat[i];
            // Checks if the wheat object is ready to harvest or not.
            if (currentWheat.isHarvestFlag()) {
                // If it is ready, it is re-assigned to false, meaning the wheat has been harvested.
                currentWheat.setHarvestFlag(false);
            }
        }
        // The number of wheat is incremented by the wheat that has been harvested.
        numOfWheat = numOfWheat + wheatPerHarvest;
    }

    /**
     * This method is responsible for simulating the interaction between the user and the game allowing the user to
     * purchase a slice of bread if they have enough money. The method takes a single parameter as type int for the
     * number of slices the user will be purchasing. Inside the method the cost of a single bread slice is initialized
     * to 5, and an if statement checks if the users money is greater than, or equal to the cost per slice. If they have
     * enough money, the amount of money they have is decremented by the cost of the bread slice, and the number of bread
     * slices the user has is incremented by 1.
     *
     * @param breadSliceAmount, the number of slices of bread the user will be purchasing.
     */
    public void buyBreadSlice(int breadSliceAmount) {
        // Cost to buy a slice of bread with money.
        int breadSliceCost = 5;
        // Checks if the users money is more than or equal to the cost to buy a slice.
        if (money >= breadSliceCost) {
            // If it is, the users money is decremented by the slice cost.
            money = money - breadSliceCost;
            // The number of slices the user has is incremented by 1.
            numOfBreadSlice++;
        }
    }

    /**
     * The purpose of this method is to simulate the action of the user baking a slice of bread. This method will take
     * a single integer parameter 'breadSliceAmount' as the number of slices of bread the user will be baking from the
     * wheat they have harvested. Inside the method, the variable 'breadSliceWheatCost' is initialized to 5, representing
     * the number of wheat it will cost to bake a slice of bread. An if statement is then used to check the condition
     * is the number of wheat the user has greater than, or equal to the wheat cost to bake a slice. If this condition
     * evaluates to true, the number of wheat the user has is decremented by the cost of baking the slice, and the number
     * of slices of bread the user now has is incremented by 1.
     *
     * @param breadSliceAmount, the number of slices the user will be baking.
     */
    public void bakeBreadSlice(int breadSliceAmount) {
        // Cost to bake a slice of bread from wheat.
        int breadSliceWheatCost = 5;
        // Checks if the number of wheat the user has is more than or equal to the required number of wheat to bake the
        // slice.
        if (numOfWheat >= breadSliceWheatCost) {
            // If it is, the number of wheat the user has is decremented by the wheat required to bake the slice.
            numOfWheat = numOfWheat - breadSliceWheatCost;
            // The number of slices the user has is incremented by 1.
            numOfBreadSlice++;
        }
    }

    /**
     * This method is responsible for simulating the user interaction of converting/making a loaf of bread from slices of
     * bread. The method will take no parameters, but inside the body a variable 'loafSliceCost' of type int is initialized
     * to 8, representing the number of slices needed to form a loaf of bread. The if statement inside the method checks
     * if the number of slices of bread the user has is greater than or equal to the cost to form a loaf with slices. If
     * the condition evaluates to true, meaning the user has enough slices, the number of bread slices the user now has
     * will be decremented by the cost to form the loaf of bread from slices. Following this the number of loafs the user
     * has will be incremented by 1, simulating the user forming the loafs from their slices.
     */
    public void breadSliceToLoaf() {
        // The cost to form a loaf of bread from slices of bread.
        int loafSliceCost = 8;
        // Checks if the number of bread slices the user has is more than or equal to the required number of slices to
        // form a loaf of bread.
        if (numOfBreadSlice >= loafSliceCost) {
            // If it is, the number of slices is decremented by the cost to make the loaf.
            numOfBreadSlice = numOfBreadSlice - loafSliceCost;
            // The number of loafs the user has is incremented by 1.
            numOfBreadLoaf++;
        }
    }

    /**
     * The method 'buyBreadLoaf' is similar to the 'buyBreadSlice' method, as it is responsible for simulating the
     * interaction of the user spending their money to buy a loaf of bread. The method takes a singular integer parameter
     * 'loafAmount' as the number of loafs of bread the user will be purchasing with their money. Inside the method a
     * variable 'breadLoafCost' is initialized to 8, which represents the amount of money required to buy a loaf of bread.
     * The method then has an if statement to check the condition is the amount of money the user has, greater than or
     * equal to the cost to buy a loaf of bread. If the condition evaluates to true, meaning the user has enough money,
     * the amount of money the user has is decremented by the cost to buy a loaf of bread ($8), and the number of loafs
     * of bread the user has is incremented by 1.
     *
     * @param loafAmount, the number of loafs of bread the user is buying with money.
     */
    public void buyBreadLoaf(int loafAmount) {
        // The cost to buy a loaf of bread with money.
        int breadLoafCost = 8;
        // Checks if the amount of money the user has is more than or equal to the cost to buy a loaf of bread.
        if (money >= breadLoafCost) {
            // If it is, the amount of money the user has is decremented by the cost to buy a loaf.
            money = money - breadLoafCost;
            // The number of loafs the user now has is incremented by 1.
            numOfBreadLoaf++;
        }
    }

    /**
     * The method 'bakeBreadLoaf' is responsible for simulating the interaction when the user wants to bake bread from
     * the wheat they have. The method will take a single integer parameter 'loafAmount' as the number of loafs they
     * will be baking. The method initializes a variable 'breadLoafWheatCost' as the number of wheat it requires to bake
     * a loaf of bread. An if statement is then used to check the condition of is the number of wheat the user has
     * greater than or equal to the cost of wheat required to bake a loaf of bread. If the condition evaluates to true,
     * the number of wheat the user now has is decremented by the wheat cost to bake the loaf of bread, and the number of
     * loafs of bread the user now has is incremented by 1.
     *
     * @param loafAmount, the number of loafs of bread the user is baking from wheat.
     */
    public void bakeBreadLoaf(int loafAmount) {
        // The cost to bake a loaf of bread from wheat.
        int breadLoafWheatCost = 8;
        // Checks if the number of wheat the user has is more than or equal to the amount of wheat it costs to bake a
        // loaf of bread.
        if (numOfWheat >= breadLoafWheatCost) {
            // If it is, the amount of wheat the user has is decremented by the required wheat to bake a loaf of bread.
            numOfWheat = numOfWheat - breadLoafWheatCost;
            // The number of loafs the user has is incremented by 1.
            numOfBreadLoaf++;
        }
    }

    /**
     * The 'buyCake' method is responsible for simulating the interaction of the user purchasing a cake with the money
     * they have. The method takes a single integer parameter as 'cakeAmount' representing the number of cakes the user
     * will be buying. Inside the method a new variable 'cakeCost' is declared and initialized to 10, which represents
     * the amount of money it will cost to buy a cake. An if statement is then used to make sure the amount of money the
     * user has is greater than or equal to the cost of the cake. If the user has enough money to buy the cake, the users
     * money is then decremented by the cost to buy the cake ($10), and the number of cakes the user now has is incremented
     * by 1.
     *
     * @param cakeAmount, the number of cakes the user will be buying with their money.
     */
    public void buyCake(int cakeAmount) {
        // The cost to buy a cake with money.
        int cakeCost = 10;
        // Checks if the money the user has is more than or equal to the cost to buy a cake with money.
        if (money >= cakeCost) {
            // If it is, the money the user has is decremented by the amount of money required to buy a cake.
            money = money - cakeCost;
            // The number of cakes the user now has is incremented by 1.
            numOfCake++;
        }
    }

    /**
     * This method 'bakeCake' is responsible for simulating the interaction of the user baking a cake from the wheat that
     * they have harvested. The method will take a single integer parameter 'cakeAmount' representing the number of
     * cakes that the user will be baking from wheat. Inside the method a new variable 'cakeWheatCost' is initialized to
     * 10 representing the number of wheat it will take to bake the cake. An if statement then checks the condition of
     * is the number of wheat the user has, greater than or equal to the wheat required to bake the cake. If the user has
     * enough wheat, the number of wheat they now have is decremented by the number of wheat it takes to bake the cake (10),
     * and the number of cakes the user now has is incremented by 1.
     *
     * @param cakeAmount, the number of cakes the user will be baking from the wheat they have.
     */
    public void bakeCake(int cakeAmount) {
        // The cost to bake a cake from wheat.
        int cakeWheatCost = 10;
        // Checks if the user has enough or more than enough wheat to bake the cake.
        if (numOfWheat >= cakeWheatCost) {
            // If they do, the number of wheat the user has is decremented by the amount of wheat required to bake the
            // cake.
            numOfWheat = numOfWheat - cakeWheatCost;
            // The number of cakes the user now has is incremented by 1.
            numOfCake++;
        }
    }

    /**
     * This method is responsible for actually checking whether the wheat is ready for harvest or not with help from the
     * wheat class. Inside the method a variable 'readyToHarvest' of type boolean is initially set to false representing
     * that the wheat is not ready for harvest yet. A for loop is then used to iterate through the loop as long as 'i'
     * is less than the number of wheat the user has. For every iteration, a new variable of type wheat is assigned to
     * the index of 'i' in the wheat array. An if statement is then used to check if the wheat's growth level is equal to
     * 3, and if the wheat's harvest flag is false, meaning the wheat is ready to be harvested, but has not yet been
     * harvested. If this condition evaluates to true, the wheat at the current index saved into 'currentWheat' is set to
     * harvestable/true using the wheat classes 'setHarvestFlag' method. Following this the 'readyToHarvest' variable is
     * then assigned to true, meaning that this wheat crop can be harvested if it has not already been harvested. The
     * method will return the value of 'readyToHarvest', as if the wheat is ready to be harvested, it is assigned to true,
     * and if not it remains false until the wheat can be harvested.
     *
     * @return readyToHarvest, a variable representing if the wheat can be harvested yet or not.
     */
    public boolean checkHarvest() {
        // A variable 'readyToHarvest' is initialized to false.
        boolean readyToHarvest = false;
        // For loop iterates through from 0 - the number of wheat the user has.
        for (int i = 0; i < numOfWheat; i++) {
            // A variable 'currentWheat' of type wheat is assigned to the current index of the wheat array controlled by
            // 'i'.
            Wheat currentWheat = wheat[i];
            // Checks if the wheat is ready to grow, but has not yet been harvested.
            if (currentWheat.getGrowthLevel() == 3 && !currentWheat.isHarvestFlag()) {
                // Changes the wheat's harvest status to true meaning it can now be harvested.
                currentWheat.setHarvestFlag(true);
                // 'readyToHarvest' is assigned to true so the wheat can be harvested.
                readyToHarvest = true;
            }
        }
        // The value of 'readyToHarvest' is returned.
        return readyToHarvest;
    }
}
