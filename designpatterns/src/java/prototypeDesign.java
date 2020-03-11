package designpatterns.pattern1;

import java.util.ArrayList;
import java.util.List;

class Branches implements Cloneable {
  private List<String> branchList;
  
  public Branches() {
    this.branchList = new ArrayList<String>();
  }
  
  public Branches(List<String> list) {
    this.branchList = list;
  }
  
  public void insertData() {
    branchList.add("Biology");
    branchList.add("Anatomy");
    branchList.add("Ornithology");
    branchList.add("psychology");
    branchList.add("pathology");
  }
  
  public List<String> getbranchList() {
    return this.branchList;
  }
  
  @Override
  public Object clone() throws CloneNotSupportedException {
    List<String> l = new ArrayList<String>();
    
    for(String s : this.getbranchList()) {
      l.add(s);
    }
    
    return new Branches(l);
  }
}

public class prototypeDesign {

  public static void main(String[] args) throws CloneNotSupportedException {
    Branches a = new Branches();
    a.insertData();
    
    Branches b = (Branches) a.clone();
    List<String> list = b.getbranchList();
    list.add("Condensed Matter Physics");
    System.out.println("Branches before adding a new branch---");
    System.out.println(a.getbranchList());
    System.out.println("Branches after adding a new branch---");
    System.out.println(list);
    System.out.println("Branches after removing branch---");
    b.getbranchList().remove("Biology");
    System.out.println(list);
    System.out.println("Branch List");
    System.out.println(a.getbranchList());
  }

}
