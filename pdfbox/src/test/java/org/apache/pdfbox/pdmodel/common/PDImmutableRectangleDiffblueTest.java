package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.junit.jupiter.api.Test;

class PDImmutableRectangleDiffblueTest {
  /**
   * Method under test: {@link PDImmutableRectangle#setUpperRightY(float)}
   */
  @Test
  void testSetUpperRightY() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDImmutableRectangle(10.0f, 10.0f)).setUpperRightY(10.0f));
  }

  /**
   * Method under test: {@link PDImmutableRectangle#setUpperRightX(float)}
   */
  @Test
  void testSetUpperRightX() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDImmutableRectangle(10.0f, 10.0f)).setUpperRightX(10.0f));
  }

  /**
   * Method under test: {@link PDImmutableRectangle#setLowerLeftY(float)}
   */
  @Test
  void testSetLowerLeftY() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDImmutableRectangle(10.0f, 10.0f)).setLowerLeftY(10.0f));
  }

  /**
   * Method under test:
   * {@link PDImmutableRectangle#PDImmutableRectangle(float, float)}
   */
  @Test
  void testNewPDImmutableRectangle() {
    // Arrange and Act
    PDImmutableRectangle actualPdImmutableRectangle = new PDImmutableRectangle(10.0f, 10.0f);

    // Assert
    COSArray cOSArray = actualPdImmutableRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertEquals(getResult, getResult2);
    assertEquals(getResult3, getResult4);
    assertSame(cOSArray, actualPdImmutableRectangle.getCOSObject());
  }

  /**
   * Method under test: {@link PDImmutableRectangle#setLowerLeftX(float)}
   */
  @Test
  void testSetLowerLeftX() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDImmutableRectangle(10.0f, 10.0f)).setLowerLeftX(10.0f));
  }
}
