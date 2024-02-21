public class Car implements Cloneable {
  private Engine engine;
  private String model;
  private String color;
  private int mileage;
  private int year;

  public Car() { //please don't remove this constructor!
  }

  public Engine getEngine(){
    return engine;
  }
  public void setEngine(Engine engine){
    this.engine = engine;
  }

  public String getModel(){
    return model;
  }
  public void setModel(String model){
    this.model = model;
  }

  public String getColor(){
    return color;
  }
  public void setColor(String color){
    this.color = color;
  }

  public int getMileage(){
    return mileage;
  }
  public void setMileage(int mileage){
    this.mileage = mileage;
  }

  public int getYear(){
    return year;
  }
  public void setYear(int year){
    this.year = year;
  }

  @Override
  public Car clone(){
    try{
      Car clonedCar = (Car) super.clone();
      clonedCar.setModel(this.model);
      clonedCar.setColor(this.color);
      clonedCar.setMileage(this.mileage);
      clonedCar.setYear(this.year);
      clonedCar.setEngine(engine.clone());
      return clonedCar;
    } catch(CloneNotSupportedException e){
      throw new RuntimeException("Can't create a car", e);
    }
  }

  //write your code here
}
