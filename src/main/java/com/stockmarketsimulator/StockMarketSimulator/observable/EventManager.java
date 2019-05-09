/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observable;

import entities.Investment;
import entities.Share;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fernandoms
 */
public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();
    
    // create a list of events
    public EventManager(String... operations){
        for (String operation : operations){
        this.listeners.put(operation, new ArrayList<>());
        }   
    }
    
    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, Object share) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, share);
        }
    }
    
}
