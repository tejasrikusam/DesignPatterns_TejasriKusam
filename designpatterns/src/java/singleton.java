package designpatterns.pattern1;

public class singleton {
private static singleton singleinstance;
public singleton() {}
public static singleton getInstance() {
	if (singleinstance==null) {
		singleinstance=new singleton();
	}
	return singleinstance;
}

}