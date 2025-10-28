package org.apache.pdfbox.pdmodel.graphics;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class PDLineDashPatternDiffblueTest {
  /**
   * Method under test: {@link PDLineDashPattern#getDashArray()}
   */
  @Test
  void testGetDashArray() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDLineDashPattern()).getDashArray().length);
  }

  /**
   * Method under test: {@link PDLineDashPattern#getDashArray()}
   */
  @Test
  void testGetDashArray2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    // Act
    float[] actualDashArray = (new PDLineDashPattern(array, 1)).getDashArray();

    // Assert
    verify(object).getCOSObject();
    assertArrayEquals(new float[]{0.0f}, actualDashArray, 0.0f);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDLineDashPattern#toString()}
   *   <li>{@link PDLineDashPattern#getPhase()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDLineDashPattern pdLineDashPattern = new PDLineDashPattern();

    // Act
    String actualToStringResult = pdLineDashPattern.toString();

    // Assert
    assertEquals("PDLineDashPattern{array=[], phase=0}", actualToStringResult);
    assertEquals(0, pdLineDashPattern.getPhase());
  }
}
