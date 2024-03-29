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
 * An X and a Y co-ordinate
 * @author Orion
 */
public class Vector2 {

    /**
     * X and Y of this vector
     */
    private double x;
    private double y;
    
    /**
     * 
     * @param x The vector's X position
     * @param y The vector's Y position
     */
    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * 
     * @param pos The vector's X and Y position, formatted [x, y] 
     */
    public Vector2(double[] pos){
        this.x = pos[0];
        this.y = pos[1];
    }
    
    public double getLength() {
        return Math.sqrt((x * x + y * y));
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }
    /**
     * Set the position of this vector
     * @return the vector's current position, as an doubleeger array [x, y]
     */
    public double[] getPos() {
        return new double[] {x, y};
    }
    /**
     * Set the position of this vector
     * @param pos The vector's X and Y position, formatted [x, y] 
     */
    public void setPos(double[] pos) {
        this.x = pos[0];
        this.y = pos[1];
    }
    /**
     * Set the position of this vector
     * @param x The value to set X to
     * @param y The value to set Y to
     */
    public void setPos(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Transform without changing this vector's value, usually used for checking a transform before committing to it
     * @param input The vector to transform this one by externally
     * @return the result vector
     */
    public Vector2 transformExternal(Vector2 input){
        return new Vector2(this.getX() + input.getX(), this.getY() + input.getY());
    }
    /**
     * Transform without changing this vector's value, usually used for checking a transform before committing to it
     * @param input The value pair to transform this vector by, as [x, y]
     * @return the result vector
     */
    public Vector2 transformExternal(double[] input){
        return new Vector2(this.x + input[0], this.y + input[1]);
    }
    /**
     * Transform without changing this vector's value, usually used for checking a transform before committing to it
     * @param x Transform along the X axis
     * @param y Transform along the Y axis
     * @return the result vector
     */
    public Vector2 transformExternal(double x, double y){
        return new Vector2(this.x + x, this.y + y);
    }
    /**
     * Transform this vector
     * @param input The vector to transform this one by
     */
    public void transform(Vector2 input){
        x += input.getX();
        y += input.getY();
    }
    /**
     * Transform this vector
     * @param input The value pair to transform this vector by, as [x, y]
     */
    public void transform(double[] input){
        x += input[0];
        y += input[1];
    }
    /**
     * Transform this vector
     * @param x Transform along the X axis
     * @param y Transform along the Y axis
     */
    public void transform(double x, double y){
        this.x += x;
        this.y += y;
    }
    /**
     * Compare this vector with another vector
     * @param input The vector to check this one against
     * @return If the vector is equivalent
     */
    public boolean equals(Vector2 input) {
        return (this.getX() == input.getX() && this.getY() == input.getY());
    }
    /**
     * Rotate the vector by angle theta around 0, 0
     * @param theta the angle to rotate by
     */
    public void rotate(double theta){
        double newX = x * Math.cos(theta) - y * Math.sin(theta);
        double newY = x * Math.sin(theta) + y * Math.cos(theta);
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
