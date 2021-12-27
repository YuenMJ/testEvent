/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.strands.interviews.eventsystem;

import com.strands.interviews.eventsystem.events.SubEvent;
import com.strands.interviews.eventsystem.impl.DefaultEventManager;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author yuenm
 */
public class jUnitTest2 {

    private EventManager eventManager = new DefaultEventManager();

    /*
     * Expected test result = True
     * testWildCard is to test publish random event to call
     * special listener 
     */
    @Test
    public void testWildCard() {
        EventListenerMock eventListenerMock = new EventListenerMock(new Class[]{});
        eventManager.registerListener("task1.key", eventListenerMock);
        eventManager.publishEvent(new SubEvent(this));
        assertTrue(eventListenerMock.isCalled());
    }

    @Test
    public void testNormalCondition() {
        EventListenerMock eventListenerMock = new EventListenerMock(new Class[]{SubEvent.class});
        eventManager.registerListener("task1.key", eventListenerMock);
        eventManager.publishEvent(new SubEvent(this));
        assertTrue(eventListenerMock.isCalled());
    }
}
