package designpatterns.pattern1;

interface DatabaseExecuter {
	  public void executeDatabase(String query) throws Exception;
	}

	class DatabaseExecuterImpl implements DatabaseExecuter {

	  public void executeDatabase(String query) throws Exception {
	    System.out.println("Query: " + query);
}

}

class DatabaseExecuterProxy implements DatabaseExecuter {
boolean ifAdmin;
DatabaseExecuterImpl dbExecuter;

public DatabaseExecuterProxy(String name, String passwd) {
if(name == "AdminSatellite" && passwd == "INDIAN ISRO") {
ifAdmin = true;
}
dbExecuter = new DatabaseExecuterImpl();
}

public void executeDatabase(String query) throws Exception {
if(ifAdmin) {
dbExecuter.executeDatabase(query);
} else {
if(query.equals("DELETE")) {
  throw new Exception("DELETE not allowed for non-admin user");
} else {
  dbExecuter.executeDatabase(query);
}
}
}
}

public class proxyDesign {

public static void main(String[] args) throws Exception {
DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "ISRO-pride");
nonAdminExecuter.executeDatabase("DELETE");

DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "ISRO-pride");
nonAdminExecuterDELETE.executeDatabase("DELETE");


DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("AdminSatellite", "INDIAN ISRO");
adminExecuter.executeDatabase("DELETE");

}

}
