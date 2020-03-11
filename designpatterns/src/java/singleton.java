package designpatterns.pattern1;

public class singleton {
private static singleton si;
public singleton() {}
public static singleton getInstance() {
	if (si==null) {
		si=new singleton();
	}
	return si;
}

}