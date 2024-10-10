package wheatGame;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This class represents the view for the farm game. It will be the user interface where the user can interact, and play
 * the farm game. It is responsible for initializing the gui components consisting of buttons, a canvas, a pane, labels,
 * audio, images, and image views all which play a part in interacting with the game. Additionally, the class will consist
 * of various event handlers so each interaction between the user and the game itself will trigger a certain action based
 * on what the user chooses to do. The class interacts with the farm class, and indirectly interacts with the wheat class
 * through association to keep track of the game state in terms of memory, and functionality. The farm class handles
 * the majority of the games memory in terms of purchasing, baking, or selling, whereas the view (this class) handles most
 * of the action functionalities. The class sets up each gui component through methods like 'relocate' and 'setStyle' to
 * later the look of each component individually. It will also have instance variables, and helper methods to contribute
 * to the game itself.
 * 
 * @author BRENDAN DILEO 
 */

public class FarmGame extends Application {

    // Instance Variables for view components and model

    /**
     * 'farmModel' of type Farm, represents the games model and creates an instance of the farm class.
     */
    private Farm farmModel;
    /**
     * 'plantWheatButton' of type button, represents a button that allows the user to plant a piece of wheat.
     */
    private Button plantWheatButton;
    /**
     * 'harvestWheatButton' of type button, represents a button which allows the user to harvest a piece of wheat.
     */
    private Button harvestWheatButton;
    /**
     * 'canvas' of type Canvas, represents the canvas where the components for the game will be drawn onto.
     */
    private Canvas canvas;
    /**
     * 'gc' of type GraphicsContext, represents the graphics context that allows for items and components to be drawn
     * onto the canvas.
     */
    private GraphicsContext gc;
    /**
     * 'wheatImageOne', 'wheatImageTwo', 'wheatImageThree' of type Image, represent images of wheat each of which
     * represent a different level/stage in the wheat's grow cycle.
     */
    private Image wheatImageOne, wheatImageTwo, wheatImageThree;
    /**
     * 'mediaPlayer' of type MediaPlayer, represents the media player that allows for the sounds and audio to be played
     * when the game is running.
     */
    private MediaPlayer mediaPlayer;
    /**
     * 'backgroundSound' of type Media, represents the audio that will be playing in the background when the game is running.
     */
    private Media backgroundSound;
    /**
     * 'wheatSound' of type Media, represents the sound that will be played when a piece of wheat is harvested.
     */
    private Media wheatSound;
    /**
     * 'moneySound' of type Media, represents the sound that will be played when the user sells a piece of wheat, or buys
     * an item.
     */
    private Media moneySound;
    /**
     * 'plantSound' of type Media, represents the sound that will be played when a piece of wheat is planted.
     */
    private Media plantSound;
    /**
     * 'clickCount' of type int, represents a counter for the number of times the user has clicked the piece of wheat.
     */
    private int clickCount;
    /**
     * 'clickCountLabel' of type Label, represents a visual representation label showing the user the number of times they
     * have clicked the piece of wheat.
     */
    private Label clickCountLabel;
    /**
     * 'moneyMade' of type Label, represents the visual representation label of the amount of money the user has/has made.
     */
    private Label moneyMade;
    /**
     * 'wheatHarvested' of type Label, represents the visual representation label of the amount of wheat the user has harvested.
     */
    private Label wheatHarvested;
    /**
     * 'shopLabel' of type Label, represents the visual representation for text identifying that this area is where the
     * shop is.
     */
    private Label shopLabel;
    /**
     * 'sellButton' of type Button, represents a button which allows the user to sell a piece of wheat.
     */
    private Button sellButton;
    /**
     * 'breadSliceImg' of type ImageView, represents a slice of bread image that will be displayed in the shop.
     */
    private ImageView breadSliceImg;
    /**
     * 'buyBreadSlice' of type Button, represents a button that will allow the user to buy a slice of bread.
     */
    private Button buyBreadSlice;
    /**
     * 'bakeBreadSlice' of type Button, represents a button that will allow the user to bake a slice of bread.
     */
    private Button bakeBreadSlice;
    /**
     * 'breadSliceToLoaf' of type Button, represents a button that will allow the user to form a loaf of bread from the
     * slices of bread they have.
     */
    private Button breadSliceToLoaf;
    /**
     * 'breadLoafImg' of type ImageView, represents an image of a loaf of bread that will be displayed in the shop.
     */
    private ImageView breadLoafImg;
    /**
     * 'buyBreadLoaf' of type Button, represents a button that will let the user buy a loaf of bread with their money.
     */
    private Button buyBreadLoaf;
    /**
     * 'bakeBreadLoaf' of type Button, represents a button that will allow the user to bake a loaf of bread from wheat.
     */
    private Button bakeBreadLoaf;
    /**
     * 'infoLabel' of type Label, represents a visual label giving the user some insight on where to find info on the game.
     */
    private Label infoLabel;
    /**
     * 'buyNBakeInfoLabel' of type Label, represents a visual label that will provide the user some instructions on how
     * the game will work and how to play.
     */
    private Label buyNBakeInfoLabel;
    /**
     * 'breadSliceMade' of type Label, represents a label that shows the user how many slices of bread they have/have made.
     */
    private Label breadSliceMade;
    /**
     * 'breadLoafMade' of type Label, represents a label that shows the user how many loafs of bread they have/have made.
     */
    private Label breadLoafMade;
    /**
     * 'cakeImg' of type ImageView, represents an image of a cake that will be displayed in the shop.
     */
    private ImageView cakeImg;
    /**
     * 'buyCake' of type Button, represents a button that will allow the user to buy a cake with their money.
     */
    private Button buyCake;
    /**
     * 'bakeCake' of type Button, represents a button that will allow the user to bake a cake with their wheat.
     */
    private Button bakeCake;
    /**
     * 'bakeSound' of type Media, represents the sound that will be played when a user has baked an item.
     */
    private Media bakeSound;
    /**
     * 'cakeMade' of type Label, represents a label that shows the user how many cakes they have/have made.
     */
    private Label cakeMade;
    /**
     * 'currentGrowthStage' of type int, represents the starting growth stage for all the wheat plants with the intention
     * they will grow with clicks.
     */
    private int currentGrowthStage = 1;
    /**
     * 'harvestStatus' of type boolean, represents the starting status/flag for all the wheat plants as they cannot yet
     * be harvested.
     */
    private boolean harvestStatus = false;
    /**
     * 'backgroundImage' of type Image, represents the background image for the game part of the canvas.
     */
    private Image backgroundImage;
    /**
     * 'cowImageView' of type ImageView, represents a cow image for the game part of the canvas with an intention of
     * animating the cow.
     */
    private ImageView cowImageView;

    // **** Instance Helper Methods and Event Handlers ****

    // *** Although this method incorporates some logic, I was unable to move it into the farm class given the use of event
    // handlers for the image. ***

    /**
     * This method is used to allow the user to click the piece of wheat on the game side of the canvas. The method uses
     * an event handler for when the user clicks the mouse, for every click within the specified range, the code inside
     * of the method will be executed. Given x and y coordinates of the images, and where the user chooses to click, the
     * number of clicks assigned to the 'clickCount' variable will be incremented for every click, and the label
     * 'clickCountLabel' will be updated to reflect every click. If the user clicks inside of the valid range (the width
     * and height of the image), the method will check if the wheat is at the growth level/stage of 3, and if the harvest
     * status for the wheat is true. If they are, the instance variable 'harvestStatus' will be reassigned to true, and
     * the if statement will return. The next if statement checks if the user has clicked the image 5 times, and if the
     * current growth stage/level is less than 3. If it is the background is redrawn, and the nested if statements check
     * for the current level of growth. If the current level is 1, the second image is drawn and the growth stage is set
     * to 2, to simulate for every 5 clicks, the plant grows. If the growth level is 2, the third image is drawn, and the
     * growth stage is set to 3, meaning the wheat is at its oldest stage and can now be harvested. It will then come
     * backup to the initial if statement, and check if the stage is less than 3, and if its not, the user must harvest
     * the wheat before continuing to click the wheat for it to grow. The purpose of this method is to simulate the
     * wheat growing for every 5 clicks, and so the user can harvest the wheat once its fully grown. In order for the
     * wheat to be reset back to the first growth stage, the user is forced to harvest it, to then restart the cycle.
     *
     */
    private void clickWheat() {
        // Creates an event handler for mouse interactions (clicks) on the canvas.
        canvas.setOnMouseClicked(event -> {
            // Tracks the users click position on the x coordinate.
            double clickXPos = event.getX();
            // Tracks the users click position on the y coordinate.
            double clickYPos = event.getY();
            // Left corner x coordinate for the image.
            int imageX = 150;
            // left corner y coordinate for the image.
            int imageY = 150;
            // Gets the initial width of the first wheat image using the 'getWidth' method.
            double imageWidth = wheatImageOne.getWidth();
            // Gets the initial height of the first wheat image using the 'getHeight' method.
            double imageHeight = wheatImageOne.getHeight();

            // This if statement checks if the user clicks within the given width and height range of the image, this is
            // to ensure the user cannot just click anywhere to change the wheat.
            if (clickXPos >= imageX && clickXPos <= imageX + imageWidth &&
                    clickYPos >= imageY && clickYPos <= imageY + imageHeight) {
                // For every click within the given width and height range, the 'clickCount' variable is incremented
                // representing each click the user makes.
                clickCount++;
                // The label 'clickCountLabel' is updated to reflect each click the user makes so they can see their total
                // number of clicks.
                clickCountLabel.setText("Clicks: " + clickCount);

                // This if statement checks if the wheats current growth is at a level of 3, and if the harvest staus is
                // true which means it is ready to be harvested.
                if (currentGrowthStage == 3 && farmModel.checkHarvest()) {
                    // If it is, the variable 'harvestStatus' is set to true to show that the wheat is ready to be
                    // harvested, and the user needs to harvest in order to continue.
                    harvestStatus = true;
                    // The return statement is used to exit the mouse event handler so the user is forced to harvest the
                    // wheat before they can keep clicking to make the wheat grow.
                    return;
                }

                // This if statement checks to see if the user has 5 or more times, as the modulus operator checks if the
                // click count is a multiple of 5, so it is changed every 5 clicks. It also checks if the wheats current
                // growth stage is less than 3, meaning it can be clicked more to grow.
                if (clickCount % 5 == 0 && currentGrowthStage < 3) {
                    // The background image is redrawn every time.
                    gc.drawImage(backgroundImage, 0, 0, 600, 500);
                    // Inner if statement checks if the wheats growth stage is 1.
                    if (currentGrowthStage == 1) {
                        // If it is, it draws the next image to simulate the wheat growing every 5 clicks.
                        gc.drawImage(wheatImageTwo, 160, 150);
                        // The wheats growth stage is set to 2 to show it has grown.
                        currentGrowthStage = 2;
                    // The else if checks if the wheat if the wheats growth stage is at 2.
                    } else if (currentGrowthStage == 2) {
                        // If it is, the third wheat image is drawn to show it has grown.
                        gc.drawImage(wheatImageThree, 160, 150);
                        // The wheats growth stage is then set to 3 showing its grown.
                        currentGrowthStage = 3;
                    }
                }
            }
        });
    }

    /**
     * This helper method/event handler is responsible for allowing the user to harvest a piece of wheat. The parameter
     * the method takes will be 'event' of type ActionEvent, so when a certain button is pressed, the method is executed.
     * On execution, the method checks if the wheat's growth stage is 3, meaning it can be harvested, and if it is the
     * harvest wheat method from the farm class is called upon to harvest the wheat. The label for the number of wheat
     * harvested is updated, and checks that the user has more than 1 piece of wheat (which they always will after harvest)
     * to then play the corresponding sound for harvesting wheat. The wheat image is re-displayed to the initial one,
     * and the growth stage is set back to 1 to simulate this harvesting action.
     *
     * @param event, which is the ActionEvent executed when the user has pressed the corresponding button.
     */
    private void harvestWheat(ActionEvent event) {
        // Checks if wheat is ready to be harvested.
        if (currentGrowthStage == 3) {
            // Calls upon the harvest method in the farm class.
            farmModel.harvestWheat();
            // Updates the label for the number of wheat harvested,
            wheatHarvested.setText("Wheat Harvested: " + farmModel.getNumOfWheat());
            // Re draws the background image.
            gc.drawImage(backgroundImage, 0, 0, 600, 500);
            // Plays the harvest noise if the user has more than 0 pieces of wheat.
            if (farmModel.getNumOfWheat() > 0) {
                MediaPlayer mediaPlayerTwo = new MediaPlayer(wheatSound);
                mediaPlayerTwo.play();
            }
            // Re draws the first wheat image (Growth level 1)
            gc.drawImage(wheatImageOne, 150, 150);
            // Resets the wheat to the growth level/stage 1 so the cycle restarts.
            currentGrowthStage = 1;
        }
    }

    /**
     * This helper method/event handler is responsible for allowing the user to sell a piece of wheat which they have.
     * The parameter the method takes will be 'event' of type ActionEvent, so when a certain button is pressed, the
     * method is executed. On execution/when the method/event handler is called upon, the sell wheat method from the farm
     * class is called upon, passing '1' as an argument as the user can only sell one piece of wheat at a time. The if
     * statement checks if the user has more than 0 pieces of wheat, so the sound will only play when they have actually
     * sold a piece of wheat and not just when they press the button. The labels for the number of wheat the user has
     * harvested and the money they have made are updated to reflect the fact they have less wheat than they had before,
     * and more money than they had before.
     *
     * @param event, which is the ActionEvent executed when the user has pressed the corresponding button.
     */
    private void sellWheat(ActionEvent event) {
        // Calls upon the sell wheat method in the farm class.
        farmModel.sellWheat(1);
        // Checks if the user still has wheat that they could be selling.
        if (farmModel.getNumOfWheat() > 0) {
            MediaPlayer mediaPlayerTwo = new MediaPlayer(moneySound);
            mediaPlayerTwo.play();
        }
        // The number of wheat the user has harvested label is updated.
        wheatHarvested.setText("Wheat Harvested: " + farmModel.getNumOfWheat());
        // The amount of money the user has made label is updated.
        moneyMade.setText("Money: $" + farmModel.getMoney());
    }

    /**
     * This helper method/event handler is responsible for allowing the user to plant a piece when they have some. The
     * parameter the method takes will be 'event' of type ActionEvent, so when a certain button is pressed, the method
     * is executed. When the button is pressed and the method/event handler is called upon, the plant wheat method from
     * the farm class is called upon simulating the user planting the wheat. The if statement checks if the piece of wheat
     * was actually planted to play the sound, instead of the sound playing just when the button is pressed. Then the
     * label for the number of wheat harvested/the wheat the user has will be updated to reflect the fact they have 1 less
     * wheat after planting one.
     *
     * @param event, which is the ActionEvent executed when the user has pressed the corresponding button.
     */
    private void plantWheat(ActionEvent event) {
        // Calls upon the plant wheat method from the farm class.
        farmModel.plantWheat();
        // Checks to see if the user has wheat/is trying to plant 0 wheat so the sound isn't always played.
        if (farmModel.getNumOfWheat() > 0) {
            MediaPlayer mediaPlayerThree = new MediaPlayer(plantSound);
            mediaPlayerThree.play();
        }
        // Wheat harvested label is updated to reflect the fact the user has less wheat after planting.
        wheatHarvested.setText("Wheat Harvested: " + farmModel.getNumOfWheat());
    }

    /**
     * This helper method/event handler is responsible for allowing the user to buy a slice of bread. The parameter the
     * method takes will be 'event' of type ActionEvent, so when the corresponding button is pressed and the method/event
     * handler is called upon, the buy bread slice method from the farm class is called, and passes 1 as an argument
     * as the user can only buy one slice at a time. The if statement ensures that the sound when buying something is only
     * played when the user has enough money to buy the slice, and not just when the button is pressed. The labels for the
     * money the user has, and the slices of bread the user has are updated to reflect the fact the user now has less money
     * and now has more slices of bread.
     *
     * @param event, which is the ActionEvent executed when the user has pressed the corresponding button.
     */
    private void buyBreadSlice(ActionEvent event) {
        // Calls upon the buy bread slice method in the farm class.
        farmModel.buyBreadSlice(1);
        // Checks to make sure the user has $5 or more before playing the sound, this ensures the sound is not always
        // played.
        if (farmModel.getMoney() >= 5) {
            MediaPlayer mediaPlayerSix = new MediaPlayer(moneySound);
            mediaPlayerSix.play();
        }
        // The label showing the money the user has/has made is updated to reflect the money spent.
        moneyMade.setText("Money: $" + farmModel.getMoney());
        // The label showing the number of bread slices the user has is updated to reflect the increased number of bread
        // slices the user now has.
        breadSliceMade.setText("Bread: " + farmModel.getNumOfBreadSlice());
    }

    /**
     * This helper method/event handler is responsible for allowing the user to bake a slice of bread from the wheat they
     * have. The parameter the method takes will be 'event' of type ActionEvent, so when the corresponding button is pressed
     * and the method/event handler is called upon, the bake bread slice method from the farm class is called, and passes
     * 1 as an argument as the user can only bake one slice at a time. The if statement inside the method checks to see
     * if the user has 5 or more pieces of wheat, the purpose for this is so the sound for baking is only played when the
     * user has actually baked an item, and not just when the button is pressed. The labels for the slices of bread the
     * user has, and the number of wheat they have harvested/have will be updated to reflect the fact the user will now
     * have more slices of bread, and less wheat.
     *
     * @param event, which is the ActionEvent executed when the user has pressed the corresponding button.
     */
    private void bakeBreadSlice(ActionEvent event) {
        // Calls upon the bake bread slice from the farm class.
        farmModel.bakeBreadSlice(1);
        // Checks to make sure the user has enough wheat to bake a slice before playing the sound so the sound is not
        // played just when the button is pressed.
        if (farmModel.getNumOfWheat() >= 5) {
            MediaPlayer mediaPlayerSix = new MediaPlayer(bakeSound);
            mediaPlayerSix.play();
        }
        // Label for the number of slices of bread the user has is updated to reflect the fact they now have more slices
        // of bread.
        breadSliceMade.setText("Bread: " + farmModel.getNumOfBreadSlice());
        // Label for the number of wheat the user has harvested/the user has is updated to reflect that they have less
        // wheat.
        wheatHarvested.setText("Wheat Harvested: " + farmModel.getNumOfWheat());
    }

    /**
     * This helper method/event handler is responsible for allowing the user to form a loaf of bread from slices of bread
     * they have. The parameter the method takes will be 'event' of type ActionEvent, so when the corresponding button is
     * pressed and the method/event handler is called upon, the convert slices to loaf method from the farm class is called,
     * simulating this 'conversion'. The labels for the number of bread slices the user has, and the number of loafs of
     * bread the user has are updated to reflect the fact they have less bread slices, and more loafs.
     *
     * @param event, which is the ActionEvent executed when the user has pressed the corresponding button.
     */
    private void convertSlicesToLoaf(ActionEvent event) {
        // Calls upon the method from the farm class to convert the slices into bread.
        farmModel.breadSliceToLoaf();
        // Updates the label for the number of bread slices the user has reflecting that they have less bread slices.
        breadSliceMade.setText("Bread: " + farmModel.getNumOfBreadSlice());
        // Updates the label for the number of loafs of bread the user has reflecting that they have more loafs.
        breadLoafMade.setText("Loaf: " + farmModel.getNumOfBreadLoaf());
    }

    /**
     * This helper method/event handler is responsible for allowing the user to buy a loaf of bread from the money they
     * have. The parameter the method takes will be 'event' of type ActionEvent, so when the corresponding button is pressed
     * and the method/event handler is called upon, the buy bread loaf method from the farm class is called passing 1 as
     * an argument as the user can only buy one loaf of bread at a time. The if statement makes sure that the user has
     * enough money to purchase the bread before playing the money sound. Then the labels for the amount of money the user
     * has and the number of loafs of bread the user has are updated in order to reflect the fact they have less money,
     * and more loafs after purchasing to simulate this interaction.
     *
     * @param event, which is the ActionEvent executed when the user has pressed the corresponding button.
     */
    private void buyBreadLoaf(ActionEvent event) {
        // Calls upon the buy bread loaf method from the farm class passing 1 as an argument.
        farmModel.buyBreadLoaf(1);
        // Checks to see if the user has enough money to buy the loaf before playing the sound.
        if (farmModel.getMoney() >= 8) {
            MediaPlayer mediaPlayerSix = new MediaPlayer(moneySound);
            mediaPlayerSix.play();
        }
        // The lable for the amount of money the user has is updated to reflect their purchase.
        moneyMade.setText("Money: $" + farmModel.getMoney());
        // The label for the amount of loafs of bread the user has is updated to reflect their purchase as they now have
        // more loafs of bread.
        breadLoafMade.setText("Loaf: " + farmModel.getNumOfBreadLoaf());
    }

    /**
     * This helper method/event handler is responsible for allowing the user to bake a loaf of bread from the wheat they
     * have. The parameter the method takes will be 'event' of type ActionEvent, so when the corresponding button is pressed
     * and the method/event handler is called upon, the bake bread loaf method from the farm class is called passing 1 as
     * argument as the user can only bake 1 loaf of bread at a time. The if statement following the method call ensures
     * that the user has enough wheat to bake the loaf of bread, before playing the baking sound. The labels for the number
     * of loafs of bread the user has, and the number of wheat the user has are then updated to reflect they now have more
     * loafs, and less wheat to simulate the interaction of baking the bread.
     *
     * @param event, which is the ActionEvent executed when the user has pressed the corresponding button.
     */
    private void bakeBreadLoaf(ActionEvent event) {
        // Calls upon the bake bread loaf method from the farm class passing 1 as an argument.
        farmModel.bakeBreadLoaf(1);
        // Checks to make sure the user has enough wheat to bake a loaf of bread before playing the sound.
        if (farmModel.getNumOfWheat() >= 8) {
            MediaPlayer mediaPlayerFive = new MediaPlayer(bakeSound);
            mediaPlayerFive.play();
        }
        // The label for the number of loafs of bread the user has is updated to reflect the fact they just baked a loaf
        // of bread.
        breadLoafMade.setText("Loaf: " + farmModel.getNumOfBreadLoaf());
        // The label for the number of wheat the user has is updated to reflect that they now have less wheat after baking.
        wheatHarvested.setText("Wheat Harvested: " + farmModel.getNumOfWheat());
    }

    /**
     * This helper method/event handler is responsible for allowing the user to buy a cake  from the money they have. The
     * parameter the method takes will be 'event' of type ActionEvent, so when the corresponding button is pressed and
     * the method/event handler is called upon, the buy cake method from the farm class is called passing 1 as an argument
     * as the user can only buy 1 cake at a time. The if statement ensures that the user has enough money before playing
     * the money sound, and then both the money and cake labels are updated to reflect the fact the user has spent money,
     * and bought a cake to simulate that interaction.
     *
     * @param event, which is the ActionEvent executed when the user has pressed the corresponding button.
     */
    private void buyCake(ActionEvent event) {
        // The buy cake method from the farm class is called upon passing 1 as an argument.
        farmModel.buyCake(1);
        // Checks to make sure the user has enough money to buy the cake using the 'getMoney' method from the farm class
        // before playing the sound.
        if (farmModel.getMoney() >= 10) {
            MediaPlayer mediaPlayerSeven = new MediaPlayer(moneySound);
            mediaPlayerSeven.play();
        }
        // The label for the amount of money the user has is updated to reflect their purchase as they will have less money.
        moneyMade.setText("Money: $" + farmModel.getMoney());
        // The label for the number of cakes the user has is updated to reflect the fact they bought a cake and now have
        // more cakes.
        cakeMade.setText("Cake: " + farmModel.getNumOfCake());
    }

    /**
     * This helper method/event handler is responsible for allowing the user to bake a cake from the wheat they have. The
     * parameter the method takes will be 'event' of type ActionEvent, so when the corresponding button is pressed and
     * the method/event handler is called upon, the bake cake method from the farm class is called passing 1 as an argument
     * as the user can only bake one cake at a time. The if statement ensures the sound is only played when the user has
     * enough wheat to bake the cake, and not just when the button is pressed. The labels for the number of cakes the user
     * has and the number of wheat they have harvested/have are updated to reflect the fact they just baked a cake and
     * will have more cake, and less wheat.
     *
     * @param event, which is the ActionEvent executed when the user has pressed the corresponding button.
     */
    private void bakeCake(ActionEvent event) {
        // The bake cake method from the farm class is called upon passing 1 as an argument.
        farmModel.bakeCake(1);
        // The if statement checks to ensure the user has enough wheat before playing the sound using the 'getNumOfWheat'
        // method from the farm class.
        if (farmModel.getNumOfWheat() >= 10) {
            MediaPlayer mediaPlayerFour = new MediaPlayer(bakeSound);
            mediaPlayerFour.play();
        }
        // The label for the number of cakes the user has is updated to reflect the fact they just baked a cake and now
        // have more cakes.
        cakeMade.setText("Cake: " + farmModel.getNumOfCake());
        // The label for the number of wheat the user has/have harvested is updated to reflect the fact they have just
        // baked a cake and now have less wheat.
        wheatHarvested.setText("Wheat Harvested: " + farmModel.getNumOfWheat());
    }

    // Animation inspiration from 'BroCode' on YouTube. Link: 'https://www.youtube.com/watch?v=UdGiuDDi7Rg'
    /**
     * This method is responsible for animating the movement of a cow image along the x-axis of the canvas. After some
     * research of my own, I came across the timeline animation, and translate transitions. I experimented a bit with
     * timelines, and could not get it to work the way I wanted to. So instead I focused on the translate transitions,
     * which I understood a lot better, and seemed a little easier. After some YouTube videos, I managed to move the cow
     * image across the screen repeatedly. The method takes a single parameter of type pane as 'root', this is so the
     * transition will have access to the pane, without interfering with the images and the image updating which is a
     * problem I faced with the timeline animations. Inside the method, a instance of the translate transition class is
     * created as 'translateCow'. The cow image is also added to the pane through the 'getChildren' method so it shows
     * on the pane. The method then sets the node for the cow image through the 'setNode' method, which means that this
     * is the image that will be transitioned/animated. The duration of the transition is set to 7000 milliseconds, so it
     * does not play too fast, as a cow is typically relatively slower. The cycle count is set to infinite as the transition
     * will repeat until the farm game is closed. The starting y coordinate of the cow is set using the 'setFromY' method,
     * and the starting x coordinate is set using the 'setFromX' coordinate. The 'setByX' method sets the coordinate along
     * the x-axis where the cow will move to along the screen, which is another issue I faced when trying to use the
     * timeline animations. The 'setAutoReverse' method is used to that once the cow hits the 'ending point' it will reverse
     * the trail it initially followed, simulating the cow moving back and forth. The transition is then played by calling
     * the 'play' method which will execute the transition.
     *
     * @param root, which is the root pane where the cow transition will occur.
     */
    private void animateCow(Pane root) {
        // Creates instance of translate transition class and assigns to variable 'translateCow'.
        TranslateTransition translateCow = new TranslateTransition();
        // Adds the 'cowImageView' to the pane root so the cow appears on the pane.
        root.getChildren().add(cowImageView);
        // Specifies the node the transition will be happening to 'cowImageView'.
        translateCow.setNode(cowImageView);
        // Sets the duration of the transition to 7000 milliseconds.
        translateCow.setDuration(Duration.millis(7000));
        // Sets the transition cycle count to indefinite, so the transition happens infinitely while the farm game is
        // running.
        translateCow.setCycleCount(TranslateTransition.INDEFINITE);
        // Sets the starting y coordinate for the cow to 410.
        translateCow.setFromY(410);
        // Sets the starting x coordinate for the cow to 300 so it dosent go beyond the game screen.
        translateCow.setFromX(300);
        // Sets the ending x coordinate in terms of the 'trail' the cow will follow to -300, so the cow will move -300
        // to the left. Initially I was moving it to 10, which gave me the problem of it barely moving, so this is why I
        // set it to -300.
        translateCow.setByX(-300);
        // Makes the cow transition reverse automatically so once it hits the ending x coordinate, it will go in reverse
        // to simulate the cow moving.
        translateCow.setAutoReverse(true);
        // Plays the transition cow animation.
        translateCow.play();
    }

    /**
     * The start method is where the main stage will be setup to show the farm game.
     *
     * @param stage The main stage of the game/application.
     * @throws Exception, for errors.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Creates variable 'root' which is an instance of the pane class creating a container like structure.
        Pane root = new Pane();
        // Size of the scene: 700x500
        Scene scene = new Scene(root, 700, 500);
        // Game title
        stage.setTitle("Farm Game");
        stage.setScene(scene);

        // **** CREATE MODEL ****

        // Initializes an instance of the farm class and assigns the instance to the 'farmModel' variable.
        farmModel = new Farm();

        // **** CREATE GUI COMPONENTS ****

        // Was forced to use the 'getClass().getClassLoader().getResource()' as my sounds were not working without it.

        // An instance of the media class for the background noise in the game is assigned to the 'backgroundSound' variable.
        backgroundSound = new Media(getClass().getClassLoader().getResource("sounds/FarmBackgroundSound.mp3").toString());
        // An instance of the media player class is created and initialized to the 'backgroundSound' file, this will play
        // the background noise when the 'play()' method is called.
        MediaPlayer mediaPlayer = new MediaPlayer(backgroundSound);
        // An instance of the media class for the harvest sound in the game is assigned to the 'wheatSound' variable.
        wheatSound = new Media(getClass().getClassLoader().getResource("sounds/wheatSnipSound.mp3").toString());
        // An instance of the media class for the money sound in the game is assigned to the 'moneySound' variable.
        moneySound = new Media(getClass().getClassLoader().getResource("sounds/moneySound.mp3").toString());
        // An instance of the media class for the planting sound in the game is assigned to the 'plantSound' variable.
        plantSound = new Media(getClass().getClassLoader().getResource("sounds/plantSound.mp3").toString());
        // An instance of the media class for the baking sound in the game is assigned to the 'bakeSound' variable.
        bakeSound = new Media(getClass().getClassLoader().getResource("sounds/bakeSound.mp3").toString());

        // An instance of the canvas class is created with a set width and height of 400x500.
        canvas = new Canvas(400, 500);
        // An instance of the image class is created using the 'farmCanvas' image as the background.
        backgroundImage = new Image("images/farmCanvas.png");

        // An instance of the button class is created for the plant wheat button.
        plantWheatButton = new Button("Plant Wheat");
        // An instance of the button class is created for the harvest wheat button.
        harvestWheatButton = new Button("Harvest Wheat");
        // An instance of the button class is created for the sell wheat button.
        sellButton = new Button("Sell wheat");

        // The 2D GraphicsContext allowing for drawing of components and more connected to the instance of the canvas
        // class is assigned to the 'gc' variable.
        gc = canvas.getGraphicsContext2D();

        // An instance of the image class is created with the first wheat image and assigned to the 'wheatImageOne' variable.
        wheatImageOne = new Image("images/wheat1.png");
        // An instance of the image class is created with the second wheat image and assigned to the 'wheatImageTwo' variable.
        wheatImageTwo = new Image("images/wheat2.png");
        // An instance of the image class is created with the third wheat image and assigned to the 'wheatImageThree' variable.
        wheatImageThree = new Image("images/wheat3.png");

        // An instance of the label class is created with the text of "Clicks: 0" as default representing the click counter
        // for the farm game and is saved into the 'clickCountLabel' variable.
        clickCountLabel = new Label("Clicks: 0");
        // An instance of the label class is created with the text of "Wheat Harvested:" followed by the 'getNumOfWheat'
        // method from the farm class representing the number of wheat the user has/has harvested. This is assigned to
        // the 'wheatHarvested' variable.
        wheatHarvested = new Label("Wheat Harvested: " + farmModel.getNumOfWheat());
        // An instance of the label class is created with the text of "Money: $" followed by the 'getMoney' method from
        // the farm class representing the number of money the user has. This is assigned to the 'moneyMade' variable.
        moneyMade = new Label("Money: $" + farmModel.getMoney());
        // An instance of the label class is created with text of "Welcome to the shop!' representing the shop portion of
        // the game, and is assigned to the 'shopLabel' variable.
        shopLabel = new Label("Welcome to the shop!");

        // An instance of the image view class is created with the bread slice image and assigned to the 'breadSliceImg'
        // variable. Uses image view class, so it can be displayed off the canvas.
        breadSliceImg = new ImageView("images/breadSlice.png");
        // An instance of the label class is created with the text of "Slice:" and uses the 'getNumOfBreadSlice' method
        // from the farm class to get the number of bread slices the user has, and is saved into the 'breadSliceMade' variable.
        breadSliceMade = new Label("Slice: " + farmModel.getNumOfBreadSlice());
        // An instance of the button class is created for the buy bread slice button and saved into the 'buyBreadSlice'
        // variable.
        buyBreadSlice = new Button("Buy Slice");
        // An instance of the button class is created for the bake bread slice button and saved into the 'bakeBreadSlice'
        // variable.
        bakeBreadSlice = new Button("Bake Slice");
        // An instance of the button class is created for converting a bread slice to a loaf button and saved into the
        // 'breadSliceToLoaf' variable.
        breadSliceToLoaf = new Button("Turn to loaf");

        // An instance of the image view class is created with the bread loaf image and assigned to the 'breadLoafImg'
        // variable. Uses image view class, so it can be displayed off the canvas.
        breadLoafImg = new ImageView("images/bread.png");
        // An instance of the button class is created for the buy bread loaf button and saved into the 'buyBreadLoaf'
        // variable.
        buyBreadLoaf = new Button("Buy Loaf");
        // An instance of the button class is created for the bake bread slice button and saved into the 'bakeBreadLoaf'
        // variable.
        bakeBreadLoaf = new Button("Bake Loaf");
        // An instance of the label class is created with the text of "Loaf:" and uses the 'getNumOfBreadLoaf' method
        // from the farm class to get the number of bread loafs the user has, and is saved into the 'breadLoafMade' variable.
        breadLoafMade = new Label("Loaf: " + farmModel.getNumOfBreadLoaf());

        // An instance of the image view class is created with the cake image and assigned to the 'cakeImg' variable.
        // Uses image view class, so it can be displayed off the canvas.
        cakeImg = new ImageView("images/cake.png");
        // An instance of the button class is created for the buy cake button and saved into the 'buyCake' variable.
        buyCake = new Button("Buy Cake");
        // An instance of the button class is created for the bake cake button and saved into the 'bakeCake' variable.
        bakeCake = new Button("Bake Cake");
        // An instance of the label class is created with the text of "Cake:" and uses the 'getNumOfCake' method from the
        // farm class to get the number of cakes the user has, and is saved into the 'cakeMade' variable.
        cakeMade = new Label("Cake: " + farmModel.getNumOfCake());

        // An instance of the label class is created with the text of "Info:" and is saved into the 'infoLabel' variable.
        infoLabel = new Label("Info");
        // An instance of the label class is created with text consisting of instructions for the game and is saved into
        // the 'buyNBakeInfoLabel' variable.
        buyNBakeInfoLabel = new Label("Harvest Wheat to bake goods, or sell to buy goods. \n" +
                "For every wheat harvested, you can plant a piece to \n make more wheat per harvest. \n" +
                "A slice of bread takes 5 wheat to make, or costs $5. \n" +
                "A loaf of bread takes 8 wheat to make, or costs $8. \n" +
                "You can also form a Loaf, using 8 slices of bread. \n" +
                "A cake takes 10 wheat to make, or costs $10.");

        // An instance of the image view class is created with the cow image and assigned to the 'cowImageView' variable.
        // Uses the image view class, so it can be animated.
        cowImageView = new ImageView("images/cow.png");

        // **** COMPONENTS ADDED TO THE ROOT ****
        // All the components inside the brackets are added to the root pane object so they can be displayed.
        root.getChildren().addAll(canvas, plantWheatButton, harvestWheatButton, clickCountLabel, moneyMade,
                wheatHarvested, shopLabel, sellButton, buyBreadLoaf, bakeBreadLoaf, buyCake, bakeCake,
                cakeMade, breadLoafMade, breadLoafImg, cakeImg, breadSliceImg, bakeBreadSlice, breadSliceMade,
                buyBreadSlice, buyNBakeInfoLabel, infoLabel, breadSliceToLoaf);

        // **** CONFIGURE COMPONENTS (COLORS, FONTS, SIZE, LOCATION) ****
        // The 'mediaPlayer' variable which holds the instance of the media player class with the background sound is set
        // to a cycle count of indefinite, so as long as the game is open and running, the background sound will continue
        // to play infinitely.
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        // The 'mediaPlayer' variable calls the "play' method to start playing the background sound.
        mediaPlayer.play();

        // The label 'infoLabel' is positioned at set x and y coordinates using the 'relocate' method.
        infoLabel.relocate(520, 260);
        // The 'setFont' method creates, and sets a new font for the text in the label 'infoLabel'.
        infoLabel.setFont(new Font("Times New Roman", 30));
        // The 'setStyle' method is used to manipulate the style of the label 'infoLabel' using css.
        infoLabel.setStyle("-fx-background-color:silver; -fx-text-fill: yellow; -fx-alignment: center; ");

        // The label 'buyNBakeInfoLabel' is positioned at set x and y coordinates using the 'relocate' method.
        buyNBakeInfoLabel.relocate(415, 300);

        // The 'setLayoutX' method from the ImageView class is used to specify the x coordinate of the 'breadSliceImg'
        // which is of type imageview.
        breadSliceImg.setLayoutX(620);
        // The 'setLayoutY' method from the ImageView class is used to specify the y coordinate of the 'breadSliceImg'
        // which is of type imageview.
        breadSliceImg.setLayoutY(130);
        // The label 'breadSliceMade' is positioned at set x and y coordinates using the 'relocate' method.
        breadSliceMade.relocate(630, 75);
        // The 'setFont' method creates, and sets a new font for the text in the label 'breadSliceMade'.
        breadSliceMade.setFont(new Font("Times New Roman", 15));
        // The button 'buyBreadSlice' is positioned at set x and y coordinates using the 'relocate' method.
        buyBreadSlice.relocate(620, 180);
        // The 'setFont' method creates, and sets a new font for the text in the button 'buyBreadSlice'.
        buyBreadSlice.setFont(new Font("Times New Roman", 13));
        // The button 'bakeBreadSlice' is positioned at set x and y coordinates using the 'relocate' method.
        bakeBreadSlice.relocate(620, 210);
        // The 'setFont' method creates, and sets a new font for the text in the button 'bakeBreadSlice'.
        bakeBreadSlice.setFont(new Font("Times New Roman", 13));
        // The button 'breadSliceToLoaf' is positioned at set x and y coordinates using the 'relocate' method.
        breadSliceToLoaf.relocate(615, 240);
        // The 'setFont' method creates, and sets a new font for the text in the button 'breadSliceToLoaf'.
        breadSliceToLoaf.setFont(new Font("Times New Roman", 13));

        // The 'setLayoutX' method from the ImageView class is used to specify the x coordinate of the 'breadLoafImg'
        // which is of type imageview.
        breadLoafImg.setLayoutX(520);
        // The 'setLayoutY' method from the ImageView class is used to specify the y coordinate of the 'breadLoafImg'
        // which is of type imageview.
        breadLoafImg.setLayoutY(130);
        // The button 'buyBreadLoaf' is positioned at set x and y coordinates using the 'relocate' method.
        buyBreadLoaf.relocate(520, 180);
        // The 'setFont' method creates, and sets a new font for the text in the button 'buyBreadLoaf'.
        buyBreadLoaf.setFont(new Font("Times New Roman", 13));
        // The button 'bakeBreadLoaf' is positioned at set x and y coordinates using the 'relocate' method.
        bakeBreadLoaf.relocate(520, 210);
        // The 'setFont' method creates, and sets a new font for the text in the button 'bakeBreadLoaf'.
        bakeBreadLoaf.setFont(new Font("Times New Roman", 13));

        // The 'setLayoutX' method from the ImageView class is used to specify the x coordinate of the 'cakeImg' which is
        // of type imageview.
        cakeImg.setLayoutX(420);
        // The 'setLayoutY' method from the ImageView class is used to specify the y coordinate of the 'cakeImg' which is
        // of type imageview.
        cakeImg.setLayoutY(130);
        // The button 'buyCake' is positioned at set x and y coordinates using the 'relocate' method.
        buyCake.relocate(410, 180);
        // The 'setFont' method creates, and sets a new font for the text in the button 'buyCake'.
        buyCake.setFont(new Font("Times New Roman", 13));
        // The button 'bakeCake' is positioned at set x and y coordinates using the 'relocate' method.
        bakeCake.relocate(410, 210);
        // The 'setFont' method creates, and sets a new font for the text in the button 'bakeCake'.
        bakeCake.setFont(new Font("Times New Roman", 13));

        // The button 'plantWheatButton' is positioned at set x and y coordinates using the 'relocate' method.
        plantWheatButton.relocate(540, 450);
        // The 'setFont' method creates, and sets a new font for the text in the button 'plantWheatButton'.
        plantWheatButton.setFont(new Font("Times New Roman", 15));

        // The button 'harvestWheatButton' is positioned at set x and y coordinates using the 'relocate' method.
        harvestWheatButton.relocate(420, 450);
        // The 'setFont' method creates, and sets a new font for the text in the button 'harvestWheatButton'.
        harvestWheatButton.setFont(new Font("Times New Roman", 15));

        // The label 'clickCountLabel' is positioned at set x and y coordinates using the 'relocate' method.
        clickCountLabel.relocate(500, 430);
        // The 'setFont' method creates, and sets a new font for the text in the label 'clickCountLabel'.
        clickCountLabel.setFont(new Font("Times New Roman", 15));

        // The label 'shopLabel' is positioned at set x and y coordinates using the 'relocate' method.
        shopLabel.relocate(420, 10);
        // The 'setFont' method creates, and sets a new font for the text in the label 'shopLabel'.
        shopLabel.setFont(new Font("Times New Roman", 30));
        // The 'setStyle' method is used to manipulate the style of the label 'shopLabel' using css.
        shopLabel.setStyle("-fx-background-color:yellow; -fx-text-fill: silver; -fx-alignment: center; ");

        // The label 'wheatHarvested' is positioned at set x and y coordinates using the 'relocate' method.
        wheatHarvested.relocate(440, 50);
        // The 'setFont' method creates, and sets a new font for the text in the label 'wheatHarvested'.
        wheatHarvested.setFont(new Font("Times New Roman", 15));

        // The label 'moneyMade' is positioned at set x and y coordinates using the 'relocate' method.
        moneyMade.relocate(580, 50);
        // The 'setFont' method creates, and sets a new font for the text in the label 'moneyMade'.
        moneyMade.setFont(new Font("Times New Roman", 15));

        // The label 'breadLoafMade' is positioned at set x and y coordinates using the 'relocate' method.
        breadLoafMade.relocate(540, 75);
        // The 'setFont' method creates, and sets a new font for the text in the label 'breadLoafMade'.
        breadLoafMade.setFont(new Font("Times New Roman", 15));

        // The label 'cakeMade' is positioned at set x and y coordinates using the 'relocate' method.
        cakeMade.relocate(440, 75);
        // The 'setFont' method creates, and sets a new font for the text in the label 'cakeMade'.
        cakeMade.setFont(new Font("Times New Roman", 15));

        // The button 'sellButton' is positioned at set x and y coordinates using the 'relocate' method.
        sellButton.relocate(510, 100);
        // The 'setFont' method creates, and sets a new font for the text in the button 'sellButton'.
        sellButton.setFont(new Font("Times New Roman", 15));

        // 'gc.drawImage' is called to draw the background onto the canvas.
        gc.drawImage(backgroundImage, 0, 0, 600, 500);
        // 'gc.drawImage' is called to draw the first wheat image onto the canvas.
        gc.drawImage(wheatImageOne, 150, 150);

        // **** EVENT HANDLERS AND FINAL SETUP ****
        // When the 'harvestWheatButton' button is pressed, it calls the 'harvestWheat' event handler/helper method.
        harvestWheatButton.setOnAction(this::harvestWheat);
        // When the 'sellButton' button is pressed, it calls the 'sellWheat' event handler/helper method.
        sellButton.setOnAction(this::sellWheat);
        // When the 'plantWheatButton' button is pressed, it calls the 'plantWheat' event handler/helper method.
        plantWheatButton.setOnAction(this::plantWheat);
        // When the 'buyBreadSlice' button is pressed, it calls the 'buyBreadSlice' event handler/helper method.
        buyBreadSlice.setOnAction(this::buyBreadSlice);
        // When the 'bakeBreadSlice' button is pressed, it calls the 'bakeBreadSlice' event handler/helper method.
        bakeBreadSlice.setOnAction(this::bakeBreadSlice);
        // When the 'breadSliceToLoaf' button is pressed, it calls the 'breadSliceToLoaf' event handler/helper method.
        breadSliceToLoaf.setOnAction(this::convertSlicesToLoaf);
        // When the 'buyBreadLoaf' button is pressed, it calls the 'buyBreadLoaf' event handler/helper method.
        buyBreadLoaf.setOnAction(this::buyBreadLoaf);
        // When the 'bakeBreadLoaf' button is pressed, it calls the 'bakeBreadLoaf' event handler/helper method
        bakeBreadLoaf.setOnAction(this::bakeBreadLoaf);
        // When the 'buyCake' button is pressed, it calls the 'buyCake' event handler/helper method
        buyCake.setOnAction(this::buyCake);
        // When the 'bakeCake' button is pressed, it calls the 'bakeCake' event handler/helper method
        bakeCake.setOnAction(this::bakeCake);
        // When the wheat is clicked, it calls the 'clickWheat' event handler/helper method.
        clickWheat();
        // Calls the 'animateCow' method responsible for the animation transition and passes root as an argument as the
        // cow will be appearing on the root/pane.
        animateCow(root);

        // **** SHOWS THE STAGE ****
        stage.show();
    }

    /**
     * Make no changes here. No changes have been made.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
