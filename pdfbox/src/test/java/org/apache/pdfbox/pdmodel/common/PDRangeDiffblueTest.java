package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.junit.jupiter.api.Test;

class PDRangeDiffblueTest {
  /**
   * Method under test: {@link PDRange#getMin()}
   */
  @Test
  void testGetMin() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDRange()).getMin());
  }

  /**
   * Method under test: {@link PDRange#setMin(float)}
   */
  @Test
  void testSetMin() {
    // Arrange
    PDRange pdRange = new PDRange();

    // Act
    pdRange.setMin(10.0f);

    // Assert
    assertEquals(10.0f, pdRange.getMin());
  }

  /**
   * Method under test: {@link PDRange#setMin(float)}
   */
  @Test
  void testSetMin2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray range = new COSArray();
    range.add(object);
    PDRange pdRange = new PDRange(range);

    // Act
    pdRange.setMin(10.0f);

    // Assert
    verify(object).getCOSObject();
    COSArray cOSArray = pdRange.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(10.0f, pdRange.getMin());
    assertSame(range, cOSArray);
  }

  /**
   * Method under test: {@link PDRange#getMax()}
   */
  @Test
  void testGetMax() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDRange()).getMax());
  }

  /**
   * Method under test: {@link PDRange#setMax(float)}
   */
  @Test
  void testSetMax() {
    // Arrange
    PDRange pdRange = new PDRange();

    // Act
    pdRange.setMax(10.0f);

    // Assert
    assertEquals(10.0f, pdRange.getMax());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDRange#PDRange(COSArray)}
   *   <li>{@link PDRange#getCOSArray()}
   *   <li>{@link PDRange#getCOSObject()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSArray range = new COSArray();

    // Act
    PDRange actualPdRange = new PDRange(range);
    COSArray actualCOSArray = actualPdRange.getCOSArray();
    COSBase actualCOSObject = actualPdRange.getCOSObject();

    // Assert
    assertTrue(actualCOSArray.toList().isEmpty());
    assertSame(range, actualCOSArray);
    assertSame(range, actualCOSObject);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDRange#PDRange(COSArray, int)}
   *   <li>{@link PDRange#getCOSArray()}
   *   <li>{@link PDRange#getCOSObject()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    COSArray range = new COSArray();

    // Act
    PDRange actualPdRange = new PDRange(range, 1);
    COSArray actualCOSArray = actualPdRange.getCOSArray();
    COSBase actualCOSObject = actualPdRange.getCOSObject();

    // Assert
    assertTrue(actualCOSArray.toList().isEmpty());
    assertSame(range, actualCOSArray);
    assertSame(range, actualCOSObject);
  }
}
