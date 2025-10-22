package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.function.PDFunction;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDSeparationDiffblueTest {
  /**
   * Test {@link PDSeparation#PDSeparation()}.
   * <p>
   * Method under test: {@link PDSeparation#PDSeparation()}
   */
  @Test
  @DisplayName("Test new PDSeparation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeparation.<init>()"})
  void testNewPDSeparation() {
    // Arrange and Act
    PDSeparation actualPdSeparation = new PDSeparation();

    // Assert
    COSBase cOSObject = actualPdSeparation.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertEquals("", actualPdSeparation.getColorantName());
    assertEquals("Separation", actualPdSeparation.getName());
    PDColor initialColor = actualPdSeparation.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(actualPdSeparation.getAlternateColorSpace());
    assertEquals(1, actualPdSeparation.getNumberOfComponents());
    assertEquals(4, ((COSArray) cOSObject).toList().size());
    assertFalse(initialColor.isPattern());
    assertSame(actualPdSeparation, initialColor.getColorSpace());
    assertArrayEquals(new float[]{1.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDSeparation#getName()}.
   * <p>
   * Method under test: {@link PDSeparation#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDSeparation.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("Separation", (new PDSeparation()).getName());
  }

  /**
   * Test {@link PDSeparation#getDefaultDecode(int)}.
   * <p>
   * Method under test: {@link PDSeparation#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDSeparation.getDefaultDecode(int)"})
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 1.0f}, (new PDSeparation()).getDefaultDecode(1), 0.0f);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDSeparation#getAlternateColorSpace()}
   *   <li>{@link PDSeparation#getInitialColor()}
   *   <li>{@link PDSeparation#getNumberOfComponents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace PDSeparation.getAlternateColorSpace()", "PDColor PDSeparation.getInitialColor()",
      "int PDSeparation.getNumberOfComponents()", "String PDSeparation.toString()"})
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

  /**
   * Test {@link PDSeparation#getColorantName()}.
   * <p>
   * Method under test: {@link PDSeparation#getColorantName()}
   */
  @Test
  @DisplayName("Test getColorantName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDSeparation.getColorantName()"})
  void testGetColorantName() {
    // Arrange, Act and Assert
    assertEquals("", (new PDSeparation()).getColorantName());
  }

  /**
   * Test {@link PDSeparation#setColorantName(String)}.
   * <p>
   * Method under test: {@link PDSeparation#setColorantName(String)}
   */
  @Test
  @DisplayName("Test setColorantName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeparation.setColorantName(String)"})
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
   * Test {@link PDSeparation#setTintTransform(PDFunction)}.
   * <p>
   * Method under test: {@link PDSeparation#setTintTransform(PDFunction)}
   */
  @Test
  @DisplayName("Test setTintTransform(PDFunction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSeparation.setTintTransform(PDFunction)"})
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
}
