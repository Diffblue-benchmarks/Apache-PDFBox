package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDColorDiffblueTest {
  /**
   * Test {@link PDColor#PDColor(COSName, PDColorSpace)}.
   * <p>
   * Method under test: {@link PDColor#PDColor(COSName, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDColor(COSName, PDColorSpace)")
  void testNewPDColor() {
    // Arrange
    COSName patternName = COSName.A;
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(patternName, colorSpace);

    // Assert
    assertTrue(actualPdColor.isPattern());
    COSName expectedPatternName = patternName.A;
    assertSame(expectedPatternName, actualPdColor.getPatternName());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#PDColor(float[], COSName, PDColorSpace)}.
   * <p>
   * Method under test: {@link PDColor#PDColor(float[], COSName, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDColor(float[], COSName, PDColorSpace)")
  void testNewPDColor2() {
    // Arrange
    PDPattern colorSpace = new PDPattern(new PDResources(), PDDeviceGray.INSTANCE);

    // Act and Assert
    assertSame(colorSpace, (new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, COSName.A, colorSpace)).getColorSpace());
  }

  /**
   * Test {@link PDColor#PDColor(COSArray, PDColorSpace)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then return PatternName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColor#PDColor(COSArray, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDColor(COSArray, PDColorSpace); given FALSE; when COSArray() add FALSE; then return PatternName is 'null'")
  void testNewPDColor_givenFalse_whenCOSArrayAddFalse_thenReturnPatternNameIsNull() {
    // Arrange
    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(array, colorSpace);

    // Assert
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#PDColor(float[], COSName, PDColorSpace)}.
   * <ul>
   *   <li>Then return second element is {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColor#PDColor(float[], COSName, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDColor(float[], COSName, PDColorSpace); then return second element is '0.5'")
  void testNewPDColor_thenReturnSecondElementIs05() {
    // Arrange
    PDPattern colorSpace = new PDPattern(new PDResources());

    // Act
    PDColor actualPdColor = new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, COSName.A, colorSpace);

    // Assert
    float[] components = actualPdColor.getComponents();
    assertEquals(0.5f, components[1]);
    assertEquals(0.5f, components[3]);
    assertEquals(10.0f, components[2]);
    assertEquals(4, components.length);
    assertSame(colorSpace, actualPdColor.getColorSpace());
  }

  /**
   * Test {@link PDColor#PDColor(COSArray, PDColorSpace)}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then return PatternName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColor#PDColor(COSArray, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDColor(COSArray, PDColorSpace); when COSArray(); then return PatternName is 'null'")
  void testNewPDColor_whenCOSArray_thenReturnPatternNameIsNull() {
    // Arrange
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(new COSArray(), colorSpace);

    // Assert
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#PDColor(float[], COSName, PDColorSpace)}.
   * <ul>
   *   <li>When {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColor#PDColor(float[], COSName, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDColor(float[], COSName, PDColorSpace); when INSTANCE; then return array length is one")
  void testNewPDColor_whenInstance_thenReturnArrayLengthIsOne() {
    // Arrange
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualPdColor = new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, COSName.A, colorSpace);

    // Assert
    assertEquals(1, actualPdColor.getComponents().length);
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPdColor.getColorSpace());
  }

  /**
   * Test {@link PDColor#PDColor(float[], PDColorSpace)}.
   * <ul>
   *   <li>When {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>Then return ColorSpace is {@link PDDeviceGray#INSTANCE}
   * {@link PDDeviceGray#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColor#PDColor(float[], PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDColor(float[], PDColorSpace); when INSTANCE; then return ColorSpace is INSTANCE INSTANCE")
  void testNewPDColor_whenInstance_thenReturnColorSpaceIsInstanceInstance() {
    // Arrange
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act and Assert
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, (new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, colorSpace)).getColorSpace());
  }

  /**
   * Test {@link PDColor#PDColor(float[], PDColorSpace)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ColorSpace is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColor#PDColor(float[], PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDColor(float[], PDColorSpace); when 'null'; then return ColorSpace is 'null'")
  void testNewPDColor_whenNull_thenReturnColorSpaceIsNull() {
    // Arrange and Act
    PDColor actualPdColor = new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, null);

    // Assert
    assertNull(actualPdColor.getColorSpace());
    float[] components = actualPdColor.getComponents();
    assertEquals(0.5f, components[1]);
    assertEquals(0.5f, components[3]);
    assertEquals(10.0f, components[2]);
    assertEquals(4, components.length);
  }

  /**
   * Test {@link PDColor#PDColor(float[], PDColorSpace)}.
   * <ul>
   *   <li>When {@link PDCalGray#PDCalGray()}.</li>
   *   <li>Then return ColorSpace is {@link PDCalGray#PDCalGray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColor#PDColor(float[], PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDColor(float[], PDColorSpace); when PDCalGray(); then return ColorSpace is PDCalGray()")
  void testNewPDColor_whenPDCalGray_thenReturnColorSpaceIsPDCalGray() {
    // Arrange
    PDCalGray colorSpace = new PDCalGray();

    // Act and Assert
    assertSame(colorSpace, (new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, colorSpace)).getColorSpace());
  }

  /**
   * Test {@link PDColor#getComponents()}.
   * <ul>
   *   <li>Given {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is
   * {@link COSArray#COSArray()} and colorSpace is
   * {@link PDDeviceGray#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColor#getComponents()}
   */
  @Test
  @DisplayName("Test getComponents(); given PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is INSTANCE")
  void testGetComponents_givenPDColorWithArrayIsCOSArrayAndColorSpaceIsInstance() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f}, (new PDColor(new COSArray(), PDDeviceGray.INSTANCE)).getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#getComponents()}.
   * <ul>
   *   <li>Given {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is
   * {@link COSArray#COSArray()} and colorSpace is
   * {@link PDCalGray#PDCalGray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColor#getComponents()}
   */
  @Test
  @DisplayName("Test getComponents(); given PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is PDCalGray()")
  void testGetComponents_givenPDColorWithArrayIsCOSArrayAndColorSpaceIsPDCalGray() {
    // Arrange
    COSArray array = new COSArray();

    // Act and Assert
    assertArrayEquals(new float[]{0.0f}, (new PDColor(array, new PDCalGray())).getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#isPattern()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColor#isPattern()}
   */
  @Test
  @DisplayName("Test isPattern(); then return 'false'")
  void testIsPattern_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDColor(new COSArray(), PDDeviceGray.INSTANCE)).isPattern());
  }

  /**
   * Test {@link PDColor#isPattern()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColor#isPattern()}
   */
  @Test
  @DisplayName("Test isPattern(); then return 'true'")
  void testIsPattern_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PDColor(COSName.A, PDDeviceGray.INSTANCE)).isPattern());
  }

  /**
   * Test {@link PDColor#toRGB()}.
   * <ul>
   *   <li>Then return {@code 167772150}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColor#toRGB()}
   */
  @Test
  @DisplayName("Test toRGB(); then return '167772150'")
  void testToRGB_thenReturn167772150() throws IOException {
    // Arrange, Act and Assert
    assertEquals(167772150, (new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, PDDeviceGray.INSTANCE)).toRGB());
  }

  /**
   * Test {@link PDColor#toCOSArray()}.
   * <ul>
   *   <li>Then return toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColor#toCOSArray()}
   */
  @Test
  @DisplayName("Test toCOSArray(); then return toList Empty")
  void testToCOSArray_thenReturnToListEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDColor(new COSArray(), PDDeviceGray.INSTANCE)).toCOSArray().toList().isEmpty());
  }

  /**
   * Test {@link PDColor#toCOSArray()}.
   * <ul>
   *   <li>Then return toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColor#toCOSArray()}
   */
  @Test
  @DisplayName("Test toCOSArray(); then return toList size is four")
  void testToCOSArray_thenReturnToListSizeIsFour() {
    // Arrange, Act and Assert
    List<? extends COSBase> toListResult = (new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, PDDeviceGray.INSTANCE))
        .toCOSArray()
        .toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult2.getKey());
    assertFalse(getResult2.isDirect());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
  }

  /**
   * Test {@link PDColor#toCOSArray()}.
   * <ul>
   *   <li>Then return toList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDColor#toCOSArray()}
   */
  @Test
  @DisplayName("Test toCOSArray(); then return toList size is one")
  void testToCOSArray_thenReturnToListSizeIsOne() {
    // Arrange, Act and Assert
    List<? extends COSBase> toListResult = (new PDColor(COSName.A, PDDeviceGray.INSTANCE)).toCOSArray().toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertEquals("A", ((COSName) getResult).getName());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDColor#toString()}
   *   <li>{@link PDColor#getColorSpace()}
   *   <li>{@link PDColor#getPatternName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    PDColor pdColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    String actualToStringResult = pdColor.toString();
    PDColorSpace actualColorSpace = pdColor.getColorSpace();

    // Assert
    assertEquals("PDColor{components=[], patternName=null, colorSpace=DeviceGray}", actualToStringResult);
    assertNull(pdColor.getPatternName());
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }
}
