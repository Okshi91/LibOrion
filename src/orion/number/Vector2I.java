/* 
 * Copyright (C) 2019 Orion.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package orion.number;

/**
 * An X and a Y integer co-ordinate
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
     * Set the position of this vector
     * @param x The value to set X to
     * @param y The value to set Y to
     */
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Transform without changing this vector's value, usually used for checking a transform before committing to it
     * @param input The vector to transform this one by externally
     * @return the result vector
     */
    public Vector2 transformExternal(Vector2I input){
        return new Vector2(this.getX() + input.getX(), this.getY() + input.getY());
    }
    /**
     * Transform without changing this vector's value, usually used for checking a transform before committing to it
     * @param input The value pair to transform this vector by, as [x, y]
     * @return the result vector
     */
    public Vector2 transformExternal(int[] input){
        return new Vector2(this.x + input[0], this.y + input[1]);
    }
    /**
     * Transform without changing this vector's value, usually used for checking a transform before committing to it
     * @param x Transform along the X axis
     * @param y Transform along the Y axis
     * @return the result vector
     */
    public Vector2 transformExternal(int x, int y){
        return new Vector2(this.x + x, this.y + y);
    }
    /**
     * Transform this vector
     * @param input The vector to transform this one by
     */
    public void transform(Vector2I input){
        x += input.getX();
        y += input.getY();
    }
    /**
     * Transform this vector
     * @param input The value pair to transform this vector by, as [x, y]
     */
    public void transform(int[] input){
        x += input[0];
        y += input[1];
    }
    /**
     * Transform this vector
     * @param x Transform along the X axis
     * @param y Transform along the Y axis
     */
    public void transform(int x, int y){
        this.x += x;
        this.y += y;
    }
    /**
     * Compare this vector with another vector
     * @param input The vector to check this one against
     * @return If the vector is equivalent
     */
    public boolean equals(Vector2I input) {
        return (this.getX() == input.getX() && this.getY() == input.getY());
    }
    /**
     * Rotate the vector 90 degrees around 0, 0 an amount of time equal to clicks
     * @param clicks how many times to rotate 90 degrees
     */
    public void rotate(int clicks){
        int newX = x * (int)Math.cos(90 * clicks) - y * (int)Math.sin(90 * clicks);
        int newY = x * (int)Math.sin(90 * clicks) + y * (int)Math.cos(90 * clicks);
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
