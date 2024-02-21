import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RectangleTest {
  private static final Integer WIDTH_FIRST = 300;
  private static final Integer LENGTH_FIRST = 400;
  private static final String COLOR_FIRST = "red";

  private static final Integer WIDTH_SECOND = 300;
  private static final Integer LENGTH_SECOND = 400;
  private static final String COLOR_SECOND = new String("red");
  private static final Integer DIFFERENT_LENGTH = 100;
  private static final Integer DIFFERENT_WIDTH = 100;
  private static final String DIFFERENT_COLOR = "black";
  private static String solution;

  @BeforeClass
  public static void init() {
    solution = Solution.getStringWithSolution();
  }

  @Test
  public void equalsCheckObjectsUsage() {
    String objectsUsageRegex = "(Objects.equals)";
    Assert.assertEquals("You should not use 'Objects.equals()' method\n",
      false, Pattern.compile(removeUnneededSymbols(objectsUsageRegex))
        .matcher(removeUnneededSymbols(solution)).find());
  }

  @Test
  public void hashCodeCheckObjectsUsage() {
    String objectsUsageRegex = "(Objects.hashCode)";
    Assert.assertEquals("You should not use 'Objects.hashCode()' method\n",
      false, Pattern.compile(removeUnneededSymbols(objectsUsageRegex))
        .matcher(removeUnneededSymbols(solution)).find());
  }

  @Test
  public void hashCodeCheckObjectsHashUsage() {
    String objectsUsageRegex = "(Objects.hash)";
    Assert.assertEquals("You should not use 'Objects.hash()' method\n",
      false, Pattern.compile(removeUnneededSymbols(objectsUsageRegex))
        .matcher(removeUnneededSymbols(solution)).find());
  }

  @Test
  public void equalsOfRectangleOk() {
    Rectangle firstRectangle = new Rectangle(WIDTH_FIRST, LENGTH_FIRST, COLOR_FIRST);
    Rectangle secondRectangle = new Rectangle(WIDTH_SECOND, LENGTH_SECOND, COLOR_SECOND);

    Assert.assertEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode()
        + " and equals " + firstRectangle.equals(secondRectangle) + "\n",
      firstRectangle, secondRectangle);
  }

  @Test
  public void hashcodeOfRectanglesOK() {
    Rectangle firstRectangle = new Rectangle(WIDTH_FIRST, LENGTH_FIRST, COLOR_FIRST);
    Rectangle secondRectangle = new Rectangle(WIDTH_SECOND, LENGTH_SECOND, COLOR_SECOND);

    Assert.assertEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode() + "\n",
      firstRectangle.hashCode(), secondRectangle.hashCode());
  }

  @Test
  public void equalsOfRectangleWithNullValues() {
    Rectangle firstRectangle = new Rectangle(null, null, null);
    Rectangle secondRectangle = new Rectangle(null, null, null);

    Assert.assertEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode()
        + " and equals " + firstRectangle.equals(secondRectangle) + "\n",
      firstRectangle, secondRectangle);
  }

  @Test
  public void hashcodeOfRectangleWithNullValues() {
    Rectangle firstRectangle = new Rectangle(null, null, null);
    Rectangle secondRectangle = new Rectangle(null, null, null);

    Assert.assertEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode() + "\n",
      firstRectangle.hashCode(), secondRectangle.hashCode());
  }

  @Test
  public void equalsOfRectangleWithSubclassNotOK() {
    class Square extends Rectangle {
      public Square(Integer width, Integer length, String color) {
        super(width, length, color);
      }
    }

    Rectangle rectangle = new Rectangle(WIDTH_FIRST, LENGTH_FIRST, COLOR_FIRST);
    Rectangle square = new Square(WIDTH_SECOND, LENGTH_SECOND, COLOR_SECOND);

    Assert.assertNotEquals("Test failed with first hash "
      + rectangle.hashCode()
      + " and second hash " + square.hashCode()
      + " and equals " + rectangle.equals(square) + "\n", rectangle, square);
  }

  @Test
  public void equalsOfRectangleLengthNotOk() {
    Rectangle firstRectangle = new Rectangle(WIDTH_FIRST, LENGTH_FIRST, COLOR_FIRST);
    Rectangle secondRectangle = new Rectangle(WIDTH_FIRST, DIFFERENT_LENGTH, COLOR_SECOND);

    Assert.assertNotEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode()
        + " and equals " + firstRectangle.equals(secondRectangle) + "\n",
      firstRectangle, secondRectangle);
  }

  @Test
  public void equalsOfRectangleWidthNotOk() {
    Rectangle firstRectangle = new Rectangle(WIDTH_FIRST, LENGTH_FIRST, COLOR_FIRST);
    Rectangle secondRectangle = new Rectangle(DIFFERENT_WIDTH, LENGTH_SECOND, COLOR_SECOND);

    Assert.assertNotEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode()
        + " and equals " + firstRectangle.equals(secondRectangle) + "\n",
      firstRectangle, secondRectangle);
  }

  @Test
  public void equalsOfRectangleColorNotOk() {
    Rectangle firstRectangle = new Rectangle(WIDTH_FIRST, LENGTH_FIRST, COLOR_FIRST);
    Rectangle secondRectangle = new Rectangle(WIDTH_FIRST, LENGTH_SECOND, DIFFERENT_COLOR);

    Assert.assertNotEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode()
        + " and equals " + firstRectangle.equals(secondRectangle) + "\n",
      firstRectangle, secondRectangle);
  }


  @Test
  public void equalsWithDifferentClassNotOk() {
    Rectangle firstRectangle = new Rectangle(WIDTH_FIRST, LENGTH_FIRST, COLOR_FIRST);
    String notARectangle = "Rectangle";

    Assert.assertNotEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + notARectangle.hashCode()
        + " and equals " + firstRectangle.equals(notARectangle) + "\n",
      firstRectangle, notARectangle);
  }

  @Test
  public void hashcodeWithDifferentClassNotOk() {
    Rectangle firstRectangle = new Rectangle(WIDTH_FIRST, LENGTH_FIRST, COLOR_FIRST);
    String notARectangle = "Rectangle";

    Assert.assertNotEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + notARectangle.hashCode() + "\n",
      firstRectangle.hashCode(), notARectangle.hashCode());
  }


  @Test
  public void equalsWithFirstNullFieldOk() {
    Rectangle firstRectangle = new Rectangle(null, LENGTH_FIRST, COLOR_FIRST);
    Rectangle secondRectangle = new Rectangle(null, LENGTH_SECOND, COLOR_SECOND);

    Assert.assertEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode()
        + " and equals " + firstRectangle.equals(secondRectangle) + "\n",
      firstRectangle, secondRectangle);
  }


  @Test
  public void hashcodeOfRectangleFirstNullFieldOK() {
    Rectangle firstRectangle = new Rectangle(null, LENGTH_FIRST, COLOR_FIRST);
    Rectangle secondRectangle = new Rectangle(null, LENGTH_SECOND, COLOR_SECOND);

    Assert.assertEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode() + "\n",
      firstRectangle.hashCode(), secondRectangle.hashCode());
  }

  @Test
  public void equalsWithSecondFieldNullOk() {
    Rectangle firstRectangle = new Rectangle(WIDTH_FIRST, null, COLOR_FIRST);
    Rectangle secondRectangle = new Rectangle(WIDTH_FIRST, null, COLOR_SECOND);

    Assert.assertEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode()
        + " and equals " + firstRectangle.equals(secondRectangle) + "\n",
      firstRectangle, secondRectangle);
  }


  @Test
  public void hashcodeOfRectangleSecondNullFieldOK() {
    Rectangle firstRectangle = new Rectangle(WIDTH_FIRST, null, COLOR_FIRST);
    Rectangle secondRectangle = new Rectangle(WIDTH_FIRST, null, COLOR_SECOND);

    Assert.assertEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode() + "\n",
      firstRectangle.hashCode(), secondRectangle.hashCode());
  }

  @Test
  public void equalsWithThirdFieldNullOk() {
    Rectangle firstRectangle = new Rectangle(WIDTH_FIRST, LENGTH_FIRST, null);
    Rectangle secondRectangle = new Rectangle(WIDTH_SECOND, LENGTH_SECOND, null);

    Assert.assertEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode()
        + " and equals " + firstRectangle.equals(secondRectangle) + "\n",
      firstRectangle, secondRectangle);
  }


  @Test
  public void hashcodeOfRectangleThirdNullFieldOK() {
    Rectangle firstRectangle = new Rectangle(WIDTH_FIRST, LENGTH_FIRST, null);
    Rectangle secondRectangle = new Rectangle(WIDTH_SECOND, LENGTH_SECOND, null);

    Assert.assertEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode() + "\n",
      firstRectangle.hashCode(), secondRectangle.hashCode());
  }

  @Test
  public void equalsWithFirstAndThirdFieldsNullOk() {
    Rectangle firstRectangle = new Rectangle(null, LENGTH_FIRST, null);
    Rectangle secondRectangle = new Rectangle(null, LENGTH_SECOND, null);

    Assert.assertEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode()
        + " and equals " + firstRectangle.equals(secondRectangle) + "\n",
      firstRectangle, secondRectangle);
  }


  @Test
  public void hashcodeOfRectangleFirstAndThirdNullFieldsOK() {
    Rectangle firstRectangle = new Rectangle(null, LENGTH_FIRST, null);
    Rectangle secondRectangle = new Rectangle(null, LENGTH_SECOND, null);

    Assert.assertEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode() + "\n",
      firstRectangle.hashCode(), secondRectangle.hashCode());
  }

  @Test
  public void equalsOfRectangleWithNullRectangle() {
    Rectangle firstRectangle = new Rectangle(WIDTH_FIRST, LENGTH_FIRST, COLOR_FIRST);
    Rectangle secondRectangle = null;

    Assert.assertNotEquals("If passed rectangle is null we should return false\n",
      firstRectangle, secondRectangle);
  }

  @Test
  public void equalsOfRectangleFirstNullFieldInOneOfRectanglesNotOK() {
    Rectangle firstRectangle = new Rectangle(null, LENGTH_FIRST, COLOR_FIRST);
    Rectangle secondRectangle = new Rectangle(WIDTH_SECOND, LENGTH_SECOND, COLOR_SECOND);

    Assert.assertNotEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode() + "\n",
      firstRectangle, secondRectangle);

    Assert.assertNotEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode() + "\n",
      secondRectangle, firstRectangle);
  }

  @Test
  public void equalsOfRectangleSecondNullFieldInOneOfRectanglesNotOK() {
    Rectangle firstRectangle = new Rectangle(WIDTH_FIRST, null, COLOR_FIRST);
    Rectangle secondRectangle = new Rectangle(WIDTH_SECOND, LENGTH_SECOND, COLOR_SECOND);

    Assert.assertNotEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode() + "\n",
      firstRectangle, secondRectangle);

    Assert.assertNotEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode() + "\n",
      secondRectangle, firstRectangle);
  }

  @Test
  public void equalsOfRectangleThirdNullFieldInOneOfRectanglesNotOK() {
    Rectangle firstRectangle = new Rectangle(WIDTH_FIRST, LENGTH_FIRST, null);
    Rectangle secondRectangle = new Rectangle(WIDTH_SECOND, LENGTH_SECOND, COLOR_SECOND);

    Assert.assertNotEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode() + "\n",
      firstRectangle, secondRectangle);

    Assert.assertNotEquals("Test failed with first hash "
        + firstRectangle.hashCode()
        + " and second hash " + secondRectangle.hashCode() + "\n",
      secondRectangle, firstRectangle);
  }

  private String removeUnneededSymbols(String input) {
    return input.replaceAll(" ", "")
      .replaceAll("\n", "");
  }
}
