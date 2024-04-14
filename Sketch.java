import processing.core.PApplet;

public class Sketch extends PApplet {

  public void settings() {
    size(600, 600);
  }

  public void setup() {
    background(0, 255, 255);
  }

/*
 * Variable to check if the remote controls and lamps have been drawn.
 * If this hasDrawn check is not present, the lamp colours repeatedly changes forever and causes severe eye pain
 */
  boolean hasDrawn = false;
  public void draw() {
      // Draw the remote controls and lamps in lines only once
      if (!hasDrawn) {
          realDraw();
          hasDrawn = true;
      }
  }

  public void realDraw() {
      for (int i = 40; i < height; i += 140) {
          for (int x = 40; x < width; x += 140) {
              drawRemoteControl(x, i);
              drawLamp(x + 100, i);
          }
      }
  }
  /**
   * Draws a lamp
   *
   * @param x - the X value of top left corner of where the lamp will the drawn
   * @param y - the Y value of top left corner of where the lamp will the drawn
   *
   * @author: Austin L
   */
  public void drawLamp(int x, int y) {
    int[] lampColour = randomColour();
    // Draw the lamp body
    fill(lampColour[0], lampColour[1], lampColour[2]);
    rect(x, y, 40, 50); // Adjust the height to 50

    // Draw the lamp base
    fill(0);
    rect(x + 10, y + 50, 20, 20); // Adjust the y-coordinate to y + 50 and the height to 20
}

  /**
   * Draws a remote control
   *
   * @param topLeftX - the X value of top left corner of where the remote control will the drawn
   * @param topLeftY - the Y value of top left corner of where the remote control will the drawn
   *
   * @author: Austin L
   */
  public void drawRemoteControl(int topLeftX, int topLeftY) {
    // Creates rectangle (remote control)
    stroke(255);
    fill(255, 0, 0);
    rect(topLeftX, topLeftY, 100, 100);

    // Creates antenna (remote control antenna)
    stroke(255);
    fill(255, 0, 0); // Set fill color to red
    rect(topLeftX + 40, topLeftY - 30, 20, 30);

    // Creates circle (remote control button)
    stroke(255);
    fill(255, 0, 0);
    ellipse(topLeftX + 50, topLeftY + 50, 40, 40);
}

  /**
   * Description: creates a random colour
   *
   * @return int[] - an array of 3 integers representing the RGB values of the colour
   *
   * @author: Austin L
   */
  public int[] randomColour() {
    int[] colour = new int[3];
    for (int i = 0; i < 3; i++) {
      colour[i] = (int) random(0, 255);
    }
    return colour;
  }
}