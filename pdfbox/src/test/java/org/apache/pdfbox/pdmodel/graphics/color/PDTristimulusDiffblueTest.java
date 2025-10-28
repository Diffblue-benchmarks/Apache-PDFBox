package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class PDTristimulusDiffblueTest {
  /**
   * Method under test: {@link PDTristimulus#getX()}
   */
  @Test
  void testGetX() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTristimulus()).getX());
  }

  /**
   * Method under test: {@link PDTristimulus#setX(float)}
   */
  @Test
  void testSetX() {
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
   * Method under test: {@link PDTristimulus#setX(float)}
   */
  @Test
  void testSetX2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    PDTristimulus pdTristimulus = new PDTristimulus(array);

    // Act
    pdTristimulus.setX(10.0f);

    // Assert
    verify(object).getCOSObject();
    COSBase cOSObject = pdTristimulus.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(1, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertEquals(10.0f, pdTristimulus.getX());
    assertSame(array, cOSObject);
  }

  /**
   * Method under test: {@link PDTristimulus#getY()}
   */
  @Test
  void testGetY() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTristimulus()).getY());
  }

  /**
   * Method under test: {@link PDTristimulus#setY(float)}
   */
  @Test
  void testSetY() {
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
   * Method under test: {@link PDTristimulus#getZ()}
   */
  @Test
  void testGetZ() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTristimulus()).getZ());
  }

  /**
   * Method under test: {@link PDTristimulus#setZ(float)}
   */
  @Test
  void testSetZ() {
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

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDTristimulus#PDTristimulus(COSArray)}
   *   <li>{@link PDTristimulus#getCOSObject()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link PDTristimulus#PDTristimulus()}
   */
  @Test
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
   * Method under test: {@link PDTristimulus#PDTristimulus(float[])}
   */
  @Test
  void testNewPDTristimulus2() {
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
   * Method under test: {@link PDTristimulus#PDTristimulus(float[])}
   */
  @Test
  void testNewPDTristimulus3() {
    // Arrange, Act and Assert
    COSBase cOSObject = (new PDTristimulus(new float[]{})).getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertTrue(((COSArray) cOSObject).toList().isEmpty());
  }
}
