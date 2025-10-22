package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDCalGrayDiffblueTest {
  /**
   * Test {@link PDCalGray#PDCalGray()}.
   * <p>
   * Method under test: {@link PDCalGray#PDCalGray()}
   */
  @Test
  @DisplayName("Test new PDCalGray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCalGray.<init>()"})
  void testNewPDCalGray() {
    // Arrange and Act
    PDCalGray actualPdCalGray = new PDCalGray();

    // Assert
    assertTrue(actualPdCalGray.getCOSObject() instanceof COSArray);
    assertEquals("CalGray", actualPdCalGray.getName());
    assertEquals(1, actualPdCalGray.getNumberOfComponents());
    assertEquals(1.0f, actualPdCalGray.getGamma());
    assertEquals(1.0f, actualPdCalGray.wpX);
    assertEquals(1.0f, actualPdCalGray.wpY);
    assertEquals(1.0f, actualPdCalGray.wpZ);
  }

  /**
   * Test {@link PDCalGray#PDCalGray(COSArray)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Name is {@code CalGray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCalGray#PDCalGray(COSArray)}
   */
  @Test
  @DisplayName("Test new PDCalGray(COSArray); given COSDictionary(); then return Name is 'CalGray'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCalGray.<init>(COSArray)"})
  void testNewPDCalGray_givenCOSDictionary_thenReturnNameIsCalGray() {
    // Arrange
    COSArray array = mock(COSArray.class);
    when(array.getObject(anyInt())).thenReturn(new COSDictionary());

    // Act
    PDCalGray actualPdCalGray = new PDCalGray(array);

    // Assert
    verify(array).getObject(eq(1));
    assertEquals("CalGray", actualPdCalGray.getName());
    assertEquals(1, actualPdCalGray.getNumberOfComponents());
    assertEquals(1.0f, actualPdCalGray.getGamma());
    assertEquals(1.0f, actualPdCalGray.wpX);
    assertEquals(1.0f, actualPdCalGray.wpY);
    assertEquals(1.0f, actualPdCalGray.wpZ);
    assertSame(array, actualPdCalGray.getCOSObject());
  }

  /**
   * Test {@link PDCalGray#getName()}.
   * <p>
   * Method under test: {@link PDCalGray#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDCalGray.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("CalGray", (new PDCalGray()).getName());
  }

  /**
   * Test {@link PDCalGray#getDefaultDecode(int)}.
   * <p>
   * Method under test: {@link PDCalGray#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDCalGray.getDefaultDecode(int)"})
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 1.0f}, (new PDCalGray()).getDefaultDecode(1), 0.0f);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDCalGray#getInitialColor()}
   *   <li>{@link PDCalGray#getNumberOfComponents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColor PDCalGray.getInitialColor()", "int PDCalGray.getNumberOfComponents()"})
  void testGettersAndSetters() {
    // Arrange
    PDCalGray pdCalGray = new PDCalGray();

    // Act
    PDColor actualInitialColor = pdCalGray.getInitialColor();
    int actualNumberOfComponents = pdCalGray.getNumberOfComponents();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertEquals(1, actualNumberOfComponents);
    assertFalse(actualInitialColor.isPattern());
    assertSame(pdCalGray, actualInitialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualInitialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDCalGray#toRGB(float[])}.
   * <p>
   * Method under test: {@link PDCalGray#toRGB(float[])}
   */
  @Test
  @DisplayName("Test toRGB(float[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDCalGray.toRGB(float[])"})
  void testToRGB() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, (new PDCalGray()).toRGB(new float[]{10.0f, 0.0f, 10.0f, 0.0f}),
        0.0f);
  }

  /**
   * Test {@link PDCalGray#getGamma()}.
   * <p>
   * Method under test: {@link PDCalGray#getGamma()}
   */
  @Test
  @DisplayName("Test getGamma()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDCalGray.getGamma()"})
  void testGetGamma() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDCalGray()).getGamma());
  }

  /**
   * Test {@link PDCalGray#setGamma(float)}.
   * <p>
   * Method under test: {@link PDCalGray#setGamma(float)}
   */
  @Test
  @DisplayName("Test setGamma(float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCalGray.setGamma(float)"})
  void testSetGamma() {
    // Arrange
    PDCalGray pdCalGray = new PDCalGray();

    // Act
    pdCalGray.setGamma(10.0f);

    // Assert
    COSDictionary cosDictionary = pdCalGray.dictionary;
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
    assertEquals(10.0f, pdCalGray.getGamma());
  }
}
