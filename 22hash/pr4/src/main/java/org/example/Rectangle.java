public class Rectangle {
  private Integer width;
  private Integer length;
  private String color;

  public Rectangle(Integer width, Integer length, String color) {
    this.width = width;
    this.length = length;
    this.color = color;
  }

  public Integer getWidth() {
    return width;
  }

  public Integer getLength() {
    return length;
  }

  public String getColor() {
    return color;
  }

  @Override
  public boolean equals(Object rectangle){
    if (rectangle == this) {
      return true;
    }
    if (rectangle == null || !(rectangle.getClass().equals(Rectangle.class))) {
      return false;
    }
    Rectangle current = (Rectangle) rectangle;
    if (current.hashCode() == this.hashCode()) {
      return true;
    }
    return current.width == this.width
            && current.length == this.length
            && this.color.equals(current.color);
  }

  @Override
  public int hashCode(){
    int result = 17;
    result = 31 * result + (width != null ? width : 0);
    result = 31 * result + (length != null ? length : 0);
    result = 31 * result + (color != null ? color.hashCode() : 0);
    return result;
  }
}
