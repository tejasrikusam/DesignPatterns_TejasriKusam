package designpatterns.pattern1;
import java.util.ArrayList;
import java.util.List;

interface Subject {
  void register(Observer obj);
  void unregister(Observer obj);
  void notifyObservers();
}

class View implements Subject {
  private List<Observer> observers;
  private String location;
  
  public View() {
    this.observers = new ArrayList<Observer>();
  }
  
  public void register(Observer obj) {
    observers.add(obj);
  }

  public void unregister(Observer obj) {
      observers.remove(obj);
  }

  public void notifyObservers() {
    for(Observer obj : observers) {
      obj.update(location);
    }
  }

  public void locationChanged() {
    this.location = getLocation();
    notifyObservers();
  }
  
  public String getLocation() {
    return "Yplace";
  }
}


interface Observer {
  public void update(String location);
}


class ViewGallery implements Observer {
  private String location;
  
  public void update(String location) {
    this.location = location;
    showLocation();
  }

  public void showLocation() {
    System.out.println("Notification to Viewer - Current Location: " + location);
  }
}

class User implements Observer {
  private String location;
  
  public void update(String location) {
    this.location = location;
    showLocation();
  }

  public void showLocation() {
    System.out.println("Notification at User - Current Location: " + location);
  }
}

class MainCenter implements Observer {
  private String location;
  
  public void update(String location) {
    this.location = location;
    showLocation();
  }

  public void showLocation() {
    System.out.println("Notification at ISRO Main - Current Location: " + location);
  }
}

public class Observerdesign {

  public static void main(String[] args) {
     View topic = new View();
    
    Observer obj1 = new ViewGallery();
    Observer obj2 = new User();
    Observer obj3 = new MainCenter();
    
    topic.register(obj1);
    topic.register(obj2);
    topic.register(obj3);
    
    topic.locationChanged();
    
    topic.unregister(obj3);
    
    System.out.println();
    topic.locationChanged();
    
  }
}