/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orion.number;

/**
 * An X and a Y co-ordinate
 * @author Orion
 */
public class Vector2I {

    /**
     * X and Y of this vector
     */
    private int x;
    private int y;
    
    /**
     * 
     * @param x The vector's X position
     * @param y The vector's Y position
     */
    public Vector2I(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * 
     * @param pos The vector's X and Y position, formatted [x, y] 
     */
    public Vector2I(int[] pos){
        this.x = pos[0];
        this.y = pos[1];
    }
    
    public double getLength() {
        return Math.sqrt((x * x + y * y));
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * 
     * @return the vector's current position, as an integer array [x, y]
     */
    public int[] getPos() {
        return new int[] {x, y};
    }
    /**
     * 
     * @param pos The vector's X and Y position, formatted [x, y] 
     */
    public void setPos(int[] pos) {
        this.x = pos[0];
        this.y = pos[1];
    }
    /**
     * 
     * @param input The vector to add to this one
     * @return the result vector
     */
    public Vector2I add(Vector2I input){
        return new Vector2I(this.getX() + input.getX(), this.getY() + input.getY());
    }
    /**
     * 
     * @param input The vector to check this one against
     * @return If the vector is equivalent
     */
    public boolean equals(Vector2I input) {
        return (this.getX() == input.getX() && this.getY() == input.getY());
    }
    /**
     * Rotate the vector 90 degrees clockwise around 0, 0
     */
    public void rotateCW(){
        int newX = y;
        int newY = x;
        x = newX;
        y = newY;
    }
    /**
     * Rotate the vector 90 degrees counterclockwise around 0, 0
     */
    public void rotateCCW(){
        int newX = -y;
        int newY = x;
        x = newX;
        y = newY;
    }
    /**
     * Shows the contents of the vector in a string
     * @return A string holding the X and Y position of the vector
     */
    @Override
    public String toString(){
        return ("{" + x + ", " + y + "}");
    }
}
