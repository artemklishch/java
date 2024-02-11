import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class MatrixDiagonalTest {
  private final MatrixDiagonal matrixDiagonal = new MatrixDiagonal();
  private static final int[][] TEST_MATRIX = {
    {-2, 31, 6, 7},
    {15, -42, 1, 0},
    {9, -7, 12, 19},
    {55, 34, 1, -10}
  };

  private static final int[][] SINGLE_ELEMENT_MATRIX = {
    {-5}
  };

  private static final int[] MATRIX_EXPECTED_DIAGONAL = {-2, -42, 12, -10};
  private static final int[] SINGLE_ELEMENT_EXPECTED_DIAGONAL = {-5};

  private static final int[] COUNTER_MATRIX_EXPECTED_DIAGONAL = {7, 1, -7, 55};
  private static final int[] COUNTER_SINGLE_ELEMENT_EXPECTED_DIAGONAL = {-5};

  @Test
  public void getMatrixDiagonal() {
    int[] actualResult = matrixDiagonal.getDiagonal(TEST_MATRIX);
    Assert.assertArrayEquals(String.format("Test failed with input params %s. Your result = %s\n",
      Arrays.deepToString(TEST_MATRIX), Arrays.toString(actualResult)),
      MATRIX_EXPECTED_DIAGONAL, actualResult);
  }

  @Test
  public void getSingleElementMatrixDiagonal() {
    int[] actualResult = matrixDiagonal.getDiagonal(SINGLE_ELEMENT_MATRIX);
    Assert.assertArrayEquals(String.format("Test failed with input params %s. Your result = %s\n",
      Arrays.deepToString(SINGLE_ELEMENT_MATRIX), Arrays.toString(actualResult)),
      SINGLE_ELEMENT_EXPECTED_DIAGONAL, actualResult);
  }

  @Test
  public void getCounterMatrixDiagonal() {
    int[] actualResult = matrixDiagonal.getCounterDiagonal(TEST_MATRIX);
    Assert.assertArrayEquals(String.format("Test failed with input params %s. Your result = %s\n",
      Arrays.deepToString(TEST_MATRIX), Arrays.toString(actualResult)),
      COUNTER_MATRIX_EXPECTED_DIAGONAL, actualResult);
  }

  @Test
  public void getCounterSingleElementMatrixDiagonal() {
    int[] actualResult = matrixDiagonal.getCounterDiagonal(SINGLE_ELEMENT_MATRIX);
    Assert.assertArrayEquals(String.format("Test failed with input params %s. Your result = %s\n",
      Arrays.deepToString(SINGLE_ELEMENT_MATRIX), Arrays.toString(actualResult)),
      COUNTER_SINGLE_ELEMENT_EXPECTED_DIAGONAL, actualResult);
  }
}
