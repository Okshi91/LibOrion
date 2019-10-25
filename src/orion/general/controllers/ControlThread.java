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
package orion.general.controllers;

import java.util.ArrayList;

/**
 *
 * @author Orion
 */
public class ControlThread {

    private ArrayList<Controllable> registeredToControl;
    private double ticks;
    private boolean tickUpdate;
    private boolean activeIntent;
    private boolean activeReal;

    public ControlThread() {
        registeredToControl = new ArrayList<>();
        activeIntent = true;
        ticks = 30.0;
        controlLoop();
    }

    public ControlThread(int tick) {
        registeredToControl = new ArrayList<>();
        activeIntent = true;
        ticks = tick;
        controlLoop();
    }

    private void tickLimited() {
        registeredToControl.forEach((target) -> {
            target.tickLimited();
        });
    }

    private void tick() {
        registeredToControl.forEach((target) -> {
            target.tick();
        });
    }

    private void controlLoop() {
        activeReal = true;
        new Thread(() -> {
            double delta = 0;
            long timer = System.nanoTime();
            double ns = 1000000000 / ticks;
            while (activeIntent) {
                long now = System.nanoTime();
                delta += (now - timer) / ns;
                timer = now;
                while (delta > 1) {
                    tickLimited();
                    delta--;
                }
                tick();
                if (tickUpdate) {
                    ns = 1000000000 / ticks;
                    tickUpdate = false;
                }
            }
            activeReal = false;
        }).start();
    }

    public void registerControllable(Controllable target) {
        registeredToControl.add(target);
    }

    public void stop() {
        activeIntent = false;
    }
    
    public void start() {
        if (activeReal){
            return;
        }
        controlLoop();
    }
    
    public void changeTickRate(double newTickRate){
        ticks = newTickRate;
        tickUpdate = true;
    }
}
