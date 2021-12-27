/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.strands.interviews.eventsystem;

import com.strands.interviews.eventsystem.events.SimpleEvent;
import com.strands.interviews.eventsystem.events.SubEvent;
import com.strands.interviews.eventsystem.impl.DefaultEventManager;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author yuenm
 */
public class jUnitTest3 {

    private EventManager eventManager = new DefaultEventManager();

    /*
     * Expected test result = true
     * When registering super class, program will register its subclass
     * As a result publishing subclass event doesn't result error
     */
    @Test
    public void testPublishSubClass() {
        EventListenerMock eventListenerMock = new EventListenerMock(new Class[]{SubEvent.class});
        eventManager.registerListener("task1.key", eventListenerMock);
        eventManager.publishEvent(new SimpleEvent(this));
        assertTrue(eventListenerMock.isCalled());
    }
}
