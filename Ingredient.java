public class Ingredient{
  private final String name;
  private final String type;
  private final double costperunit;

  public Ingredient(String n, String t, double c){
    this.name = n;
    this.type = t;
    this.costperunit = c;
  }

  public Ingredient(){
    this.name = "default name";
    this.type = "default type";
    this.costperunit = 0;
  }


  public String getName(){
    return this.name;
  }

  public String getType(){
    return this.type;
  }

  public double getCost(){
    return this.costperunit;
  }

  public String toString() {
    return this.name + " | " + this.type + " | " + this.costperunit;
  }
}
