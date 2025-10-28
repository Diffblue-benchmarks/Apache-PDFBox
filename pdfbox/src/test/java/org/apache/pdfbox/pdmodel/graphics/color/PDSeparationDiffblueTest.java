package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.function.PDFunction;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.junit.jupiter.api.Test;

class PDSeparationDiffblueTest {
  /**
   * Method under test: {@link PDSeparation#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("Separation", (new PDSeparation()).getName());
  }

  /**
   * Method under test: {@link PDSeparation#getDefaultDecode(int)}
   */
  @Test
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 1.0f}, (new PDSeparation()).getDefaultDecode(1), 0.0f);
  }

  /**
   * Method under test: {@link PDSeparation#getColorantName()}
   */
  @Test
  void testGetColorantName() {
    // Arrange, Act and Assert
    assertEquals("", (new PDSeparation()).getColorantName());
  }

  /**
   * Method under test: {@link PDSeparation#setColorantName(String)}
   */
  @Test
  void testSetColorantName() {
    // Arrange
    PDSeparation pdSeparation = new PDSeparation();

    // Act
    pdSeparation.setColorantName("Name");

    // Assert
    COSBase cOSObject = pdSeparation.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("Name", ((COSName) getResult).getName());
    assertEquals("Name", pdSeparation.getColorantName());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Method under test: {@link PDSeparation#setTintTransform(PDFunction)}
   */
  @Test
  void testSetTintTransform() {
    // Arrange
    PDSeparation pdSeparation = new PDSeparation();

    // Act
    pdSeparation.setTintTransform(new PDFunctionType0(COSBoolean.FALSE));

    // Assert
    COSBase cOSObject = pdSeparation.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    assertNull(toListResult.get(3));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDSeparation#getAlternateColorSpace()}
   *   <li>{@link PDSeparation#getInitialColor()}
   *   <li>{@link PDSeparation#getNumberOfComponents()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDSeparation pdSeparation = new PDSeparation();

    // Act
    PDColorSpace actualAlternateColorSpace = pdSeparation.getAlternateColorSpace();
    PDColor actualInitialColor = pdSeparation.getInitialColor();
    int actualNumberOfComponents = pdSeparation.getNumberOfComponents();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertNull(actualAlternateColorSpace);
    assertEquals(1, actualNumberOfComponents);
    assertFalse(actualInitialColor.isPattern());
    assertSame(pdSeparation, actualInitialColor.getColorSpace());
    assertArrayEquals(new float[]{1.0f}, actualInitialColor.getComponents(), 0.0f);
  }
}
