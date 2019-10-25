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
package orion.general.graphics;

import java.util.ArrayList;
import java.util.LinkedList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import orion.number.Vector2;

/**
 *
 * @author Orion
 */
public class SpriteSheet {

    private Image image;
    private final int size;
    private LinkedList<Texture> toAssign;
    private LinkedList<Vector2> assignPos;

    public SpriteSheet(Image ss, int size) {
        assignPos = new LinkedList<>();
        toAssign = new LinkedList<>();
        this.image = ss;
        System.out.println(image.getWidth());
        System.out.println(image.getHeight());
        this.size = size;
    }

    public SpriteSheet(String path, int size) {
        assignPos = new LinkedList<>();
        toAssign = new LinkedList<>();
        image = new Image(path, true);
        image.progressProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                if (arg2.doubleValue() == 1.0){
                    updateAllUnassigned();
                }
            }
        });
        this.size = size;
    }

    public Image requestTile(int col, int row, Texture tex) {
        if (image.getPixelReader() != null) {
            WritableImage wImg = new WritableImage(image.getPixelReader(), row * size, col * size, size, size);
            return wImg;
        }
        toAssign.add(tex);
        assignPos.add(new Vector2(col, row));
        return image;
    }
    
    private void updateAllUnassigned(){
        for(int i = 0; i < toAssign.size(); i++){
            Vector2 pos = assignPos.pop();
            toAssign.pop().image = new WritableImage(image.getPixelReader(), (int)pos.getY() * size, (int)pos.getX() * size, size, size);
        }
    }
}
