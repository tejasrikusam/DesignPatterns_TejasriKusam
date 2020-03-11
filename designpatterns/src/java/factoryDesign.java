package designpatterns.pattern1;

abstract class Rocket1{
	  public abstract int getPayload();
	  
	  public String toString() {
	    return "load: " + this.getPayload();
}
}

class GSAT extends Rocket1 {
int payload;

GSAT(int payload) {
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
	return new GSAT(payload);
} 
else if(type == "GSLV") {
	return new GSLV(payload);
}
return null;
}
}

public class factoryDesign {

public static void main(String[] args) {
System.out.println("gsat--Payload"); 
Rocket1 gsat = payloadDesign.getInstance("gsat", 2000);
System.out.println(gsat);
System.out.println("GSLV--Payload in kg");
Rocket1 GSLV = payloadDesign.getInstance("GSLV", 22000);
System.out.println(GSLV);
}

}