package org.apache.pdfbox.contentstream.operator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class OperatorDiffblueTest {
  /**
   * Method under test: {@link Operator#getOperator(String)}
   */
  @Test
  void testGetOperator() throws UnsupportedEncodingException {
    // Arrange and Act
    Operator actualOperator = Operator.getOperator("Operator");

    // Assert
    assertEquals("Operator", actualOperator.getName());
    COSDictionary imageParameters = actualOperator.getImageParameters();
    COSUpdateState updateState = imageParameters.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(imageParameters.getKey());
    assertEquals(0, imageParameters.size());
    COSIncrement toIncrementResult = imageParameters.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(imageParameters.isDirect());
    assertFalse(imageParameters.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(imageParameters.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    byte[] expectedImageData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedImageData, actualOperator.getImageData());
  }

  /**
   * Method under test: {@link Operator#getOperator(String)}
   */
  @Test
  void testGetOperator2() {
    // Arrange and Act
    Operator actualOperator = Operator.getOperator(OperatorName.BEGIN_INLINE_IMAGE_DATA);

    // Assert
    assertNull(actualOperator.getImageData());
    assertNull(actualOperator.getImageParameters());
    assertEquals(OperatorName.BEGIN_INLINE_IMAGE_DATA, actualOperator.getName());
  }

  /**
   * Method under test: {@link Operator#getOperator(String)}
   */
  @Test
  void testGetOperator3() {
    // Arrange and Act
    Operator actualOperator = Operator.getOperator(OperatorName.BEGIN_INLINE_IMAGE);

    // Assert
    assertNull(actualOperator.getImageData());
    assertNull(actualOperator.getImageParameters());
    assertEquals(OperatorName.BEGIN_INLINE_IMAGE, actualOperator.getName());
  }

  /**
   * Method under test: {@link Operator#getOperator(String)}
   */
  @Test
  void testGetOperator4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Operator.getOperator("/"));
  }

  /**
   * Method under test: {@link Operator#getOperator(String)}
   */
  @Test
  void testGetOperator5() {
    // Arrange and Act
    Operator actualOperator = Operator.getOperator("IDID");

    // Assert
    assertEquals("IDID", actualOperator.getName());
    assertNull(actualOperator.getImageData());
    assertNull(actualOperator.getImageParameters());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Operator#setImageData(byte[])}
   *   <li>{@link Operator#setImageParameters(COSDictionary)}
   *   <li>{@link Operator#toString()}
   *   <li>{@link Operator#getImageData()}
   *   <li>{@link Operator#getImageParameters()}
   *   <li>{@link Operator#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    Operator operator = Operator.getOperator("Operator");
    byte[] imageDataArray = "AXAXAXAX".getBytes("UTF-8");

    // Act
    operator.setImageData(imageDataArray);
    COSDictionary params = new COSDictionary();
    operator.setImageParameters(params);
    String actualToStringResult = operator.toString();
    byte[] actualImageData = operator.getImageData();
    COSDictionary actualImageParameters = operator.getImageParameters();

    // Assert that nothing has changed
    assertEquals("Operator", operator.getName());
    assertEquals("PDFOperator{Operator}", actualToStringResult);
    assertSame(params, actualImageParameters);
    assertSame(imageDataArray, actualImageData);
  }
}
