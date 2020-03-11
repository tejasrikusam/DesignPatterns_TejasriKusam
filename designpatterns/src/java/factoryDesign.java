package designpatterns.pattern1;

abstract class Rocket1{
	  public abstract int getPayload();
	  
	  public String toString() {
	    return "Payload: " + this.getPayload();
}
}

class PSLV extends Rocket1 {
int payload;

PSLV(int payload) {
this.payload =payload;
}

@Override
public int getPayload() {
return this.payload;
}
}

class GSLV extends Rocket1 {
int payload;

GSLV(int payload) {
this.payload = payload;
}

@Override
public int getPayload() {
return this.payload;
}
}

class payloadDesign{
public static Rocket1 getInstance(String type, int payload) {
if(type == "PSLV") {
	return new PSLV(payload);
} 
else if(type == "GSLV") {
	return new GSLV(payload);
}
return null;
}
}

public class factoryDesign {

public static void main(String[] args) {
System.out.println("PSLV--Payload in kg"); 
Rocket1 PSLV = payloadDesign.getInstance("PSLV", 1750);
System.out.println(PSLV);
System.out.println("GSLV--Payload in kg");
Rocket1 GSLV = payloadDesign.getInstance("GSLV", 8000);
System.out.println(GSLV);
}

}