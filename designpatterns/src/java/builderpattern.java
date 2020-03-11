package designpatterns.pattern1;

class Rocket{
	  private int stages;
	  private String launch;
	  private int launches;
	  
	  public int getStages() {
	    return this.stages;
	  }
	  
	  public String getLaunch() {
	    return this.launch;
	  }
	  
	  public int getLaunches() {
	    return this.launches;
	  }
	  
	  private Rocket(SatelliteVehicles builder) {
	    this.stages = builder.stages;
	    this.launch = builder.launch;
	    this.launches = builder.launches;
	  }
public static class SatelliteVehicles {
	    public int stages;
		private String launch;
	    private int launches;
	    public SatelliteVehicles(int number_of_stages,String recent_launch, int total_launches) {
	      this.stages=number_of_stages;
	      this.launch = recent_launch;
	      this.launches = total_launches;
	    }
	    
	    public SatelliteVehicles setLaunches(int total_launches) {
	      this.launches = total_launches;
	      return this;
	    }
	    
	    public Rocket build() {
	      return new Rocket(this);
	    }
	  }
	}

	public class builderpattern{
	  
	  public static void main(String[] args) {
	    Rocket PSLVI = new Rocket.SatelliteVehicles(4,"PSLV-C40/Cartosat-2:", 50).setLaunches(50).build();
	    Rocket GSLVI = new Rocket.SatelliteVehicles(3,"GSLV-Mk III-M1/Chandrayaan 2:", 13).build();
  System.out.println(PSLVI.getStages());
  System.out.println(PSLVI.getLaunch());
  System.out.println(PSLVI.getLaunches());
  System.out.println(GSLVI.getStages());
  System.out.println(GSLVI.getLaunch());
  System.out.println(GSLVI.getLaunches());
}
}

