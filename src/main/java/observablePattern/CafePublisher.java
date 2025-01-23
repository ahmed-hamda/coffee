package observablePattern;

import java.util.ArrayList;
import java.util.List;

public class CafePublisher {

    private List<souscripteur> souscripteur = new ArrayList<>();
    private List<String> notifications = new ArrayList<>();
    private static final CafePublisher instance = new CafePublisher();

    public static CafePublisher getInstance() {
        return instance;
    }
    public void addObserver(souscripteur s) {
        if (!souscripteur.contains(s)) { 
            souscripteur.add(s);
        }
    }
    
    public List<souscripteur> getObservers() {
        return souscripteur; 
    }

    
    public void removeObserver(souscripteur s) {
        souscripteur.remove(s);
    }

    public void notifyObservers(String message) {
        for (souscripteur s : souscripteur) {
            String notification =s.update(message);
            notifications.add(notification); 

        }
    }
    public List<String> getNotifications() {
    	List<String> tempNotifications = new ArrayList<>(notifications);
        notifications.clear(); 
        return tempNotifications;
    }
}
