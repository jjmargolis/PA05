public class Ingredient{
  private final String name;
  private final String type;
  private final double costperunit;

  public Ingredient(String n, String t, double c){
    this.name = n;
    this.type = t;
    this.costperunit = c;
  }

  public getName(){
    return this.name;
  }

  public getType(){
    return this.type;
  }

  public getCost(){
    return this.costperunit;
  }
}
