public class Engine implements Cloneable {
  private String type;
  private int power;
  private int weight;
  private String producer;
  private int year;

  public Engine() { //please don't remove this constructor!
  }

  public String getType(){
    return type;
  }
  public void setType(String type){
    this.type = type;
  }

  public int getPower(){
    return power;
  }
  public void setPower(int power){
    this.power = power;
  }

  public int getWeight(){
    return weight;
  }
  public void setWeight(int weight){
    this.weight = weight;
  }

  public String getProducer(){
    return producer;
  }
  public void setProducer(String producer){
    this.producer = producer;
  }

  public int getYear(){
    return year;
  }
  public void setYear(int year){
    this.year = year;
  }

  @Override
  public Engine clone(){
    try{
      Engine clonedEngine = (Engine) super.clone();
      clonedEngine.setType(this.type);
      clonedEngine.setPower(this.power);
      clonedEngine.setWeight(this.weight);
      clonedEngine.setProducer(this.producer);
      clonedEngine.setYear(this.year);
      return clonedEngine;
    } catch(CloneNotSupportedException e){
      throw new RuntimeException("Can't clone engine", e);
    }
  }

  //write your code here
}
