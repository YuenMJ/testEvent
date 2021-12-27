/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.strands.interviews.eventsystem;

import com.strands.interviews.eventsystem.events.SimpleEvent;
import com.strands.interviews.eventsystem.events.SubEvent;
import com.strands.interviews.eventsystem.impl.DefaultEventManager;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author yuenm
 */
public class jUnitTest1 {

    private EventManager eventManager = new DefaultEventManager();

    /*
     * Test Simple Event Notification result = false
     * This is expected because the eventListenerMock doesn't have any listener
     * that register to handle SubEvent
     */
    @Test
    public void testSimpleEventNotification() {
        EventListenerMock eventListenerMock = new EventListenerMock(new Class[]{SimpleEvent.class});
        eventManager.registerListener("task1.key", eventListenerMock);
        eventManager.publishEvent(new SubEvent(this));
        assertTrue(eventListenerMock.isCalled());
    }

}
