package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDTristimulusDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDTristimulus#PDTristimulus(COSArray)}
   *   <li>{@link PDTristimulus#getCOSObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    COSArray array = new COSArray();

    // Act
    COSBase actualCOSObject = (new PDTristimulus(array)).getCOSObject();

    // Assert
    assertTrue(actualCOSObject instanceof COSArray);
    assertSame(array, actualCOSObject);
  }

  /**
   * Test {@link PDTristimulus#PDTristimulus()}.
   * <p>
   * Method under test: {@link PDTristimulus#PDTristimulus()}
   */
  @Test
  @DisplayName("Test new PDTristimulus()")
  void testNewPDTristimulus() {
    // Arrange and Act
    PDTristimulus actualPdTristimulus = new PDTristimulus();

    // Assert
    COSBase cOSObject = actualPdTristimulus.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualPdTristimulus.getX());
    assertEquals(0.0f, actualPdTristimulus.getY());
    assertEquals(0.0f, actualPdTristimulus.getZ());
    assertFalse(getResult.isDirect());
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
  }

  /**
   * Test {@link PDTristimulus#PDTristimulus(float[])}.
   * <ul>
   *   <li>Then return COSObject toList size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTristimulus#PDTristimulus(float[])}
   */
  @Test
  @DisplayName("Test new PDTristimulus(float[]); then return COSObject toList size is three")
  void testNewPDTristimulus_thenReturnCOSObjectToListSizeIsThree() {
    // Arrange and Act
    PDTristimulus actualPdTristimulus = new PDTristimulus(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSBase cOSObject = actualPdTristimulus.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(0.5f, actualPdTristimulus.getY());
    assertEquals(10.0f, actualPdTristimulus.getX());
    assertEquals(10.0f, actualPdTristimulus.getZ());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertEquals(getResult, getResult3);
  }

  /**
   * Test {@link PDTristimulus#PDTristimulus(float[])}.
   * <ul>
   *   <li>When empty array of {@code float}.</li>
   *   <li>Then return COSObject toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTristimulus#PDTristimulus(float[])}
   */
  @Test
  @DisplayName("Test new PDTristimulus(float[]); when empty array of float; then return COSObject toList Empty")
  void testNewPDTristimulus_whenEmptyArrayOfFloat_thenReturnCOSObjectToListEmpty() {
    // Arrange, Act and Assert
    COSBase cOSObject = (new PDTristimulus(new float[]{})).getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertTrue(((COSArray) cOSObject).toList().isEmpty());
  }

  /**
   * Test {@link PDTristimulus#getX()}.
   * <ul>
   *   <li>Given {@link PDTristimulus#PDTristimulus()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTristimulus#getX()}
   */
  @Test
  @DisplayName("Test getX(); given PDTristimulus(); then return zero")
  void testGetX_givenPDTristimulus_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTristimulus()).getX());
  }

  /**
   * Test {@link PDTristimulus#setX(float)}.
   * <ul>
   *   <li>Given {@link PDTristimulus#PDTristimulus()}.</li>
   *   <li>Then {@link PDTristimulus#PDTristimulus()} COSObject
   * {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTristimulus#setX(float)}
   */
  @Test
  @DisplayName("Test setX(float); given PDTristimulus(); then PDTristimulus() COSObject COSArray")
  void testSetX_givenPDTristimulus_thenPDTristimulusCOSObjectCOSArray() {
    // Arrange
    PDTristimulus pdTristimulus = new PDTristimulus();

    // Act
    pdTristimulus.setX(10.0f);

    // Assert
    COSBase cOSObject = pdTristimulus.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(10.0f, pdTristimulus.getX());
    assertFalse(getResult.isDirect());
    assertSame(getResult, toListResult.get(2));
  }

  /**
   * Test {@link PDTristimulus#getY()}.
   * <ul>
   *   <li>Given {@link PDTristimulus#PDTristimulus()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTristimulus#getY()}
   */
  @Test
  @DisplayName("Test getY(); given PDTristimulus(); then return zero")
  void testGetY_givenPDTristimulus_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTristimulus()).getY());
  }

  /**
   * Test {@link PDTristimulus#setY(float)}.
   * <ul>
   *   <li>Given {@link PDTristimulus#PDTristimulus()}.</li>
   *   <li>Then {@link PDTristimulus#PDTristimulus()} COSObject
   * {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTristimulus#setY(float)}
   */
  @Test
  @DisplayName("Test setY(float); given PDTristimulus(); then PDTristimulus() COSObject COSArray")
  void testSetY_givenPDTristimulus_thenPDTristimulusCOSObjectCOSArray() {
    // Arrange
    PDTristimulus pdTristimulus = new PDTristimulus();

    // Act
    pdTristimulus.setY(10.0f);

    // Assert
    COSBase cOSObject = pdTristimulus.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(10.0f, pdTristimulus.getY());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDTristimulus#getZ()}.
   * <ul>
   *   <li>Given {@link PDTristimulus#PDTristimulus()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTristimulus#getZ()}
   */
  @Test
  @DisplayName("Test getZ(); given PDTristimulus(); then return zero")
  void testGetZ_givenPDTristimulus_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTristimulus()).getZ());
  }

  /**
   * Test {@link PDTristimulus#setZ(float)}.
   * <ul>
   *   <li>Given {@link PDTristimulus#PDTristimulus()}.</li>
   *   <li>Then {@link PDTristimulus#PDTristimulus()} COSObject
   * {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTristimulus#setZ(float)}
   */
  @Test
  @DisplayName("Test setZ(float); given PDTristimulus(); then PDTristimulus() COSObject COSArray")
  void testSetZ_givenPDTristimulus_thenPDTristimulusCOSObjectCOSArray() {
    // Arrange
    PDTristimulus pdTristimulus = new PDTristimulus();

    // Act
    pdTristimulus.setZ(10.0f);

    // Assert
    COSBase cOSObject = pdTristimulus.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(10.0f, pdTristimulus.getZ());
    assertFalse(getResult.isDirect());
  }
}
