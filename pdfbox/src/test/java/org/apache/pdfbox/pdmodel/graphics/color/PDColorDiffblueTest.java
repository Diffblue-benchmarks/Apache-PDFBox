package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDColorDiffblueTest {
  /**
   * Test {@link PDColor#PDColor(COSName, PDColorSpace)}.
   *
   * <p>Method under test: {@link PDColor#PDColor(COSName, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDColor(COSName, PDColorSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDColor.<init>(COSName, PDColorSpace)"})
  void testNewPDColor() {
    // Arrange and Act
    PDColor actualPdColor = new PDColor(COSName.A, PDDeviceGray.INSTANCE);

    // Assert
    assertTrue(actualPdColor.isPattern());
    assertSame(COSName.A, actualPdColor.getPatternName());
    assertSame(PDDeviceGray.INSTANCE, actualPdColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#PDColor(float[], COSName, PDColorSpace)}.
   *
   * <p>Method under test: {@link PDColor#PDColor(float[], COSName, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDColor(float[], COSName, PDColorSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDColor.<init>(float[], COSName, PDColorSpace)"})
  void testNewPDColor2() {
    // Arrange
    PDPattern colorSpace = new PDPattern(new PDResources(), PDDeviceGray.INSTANCE);

    // Act
    PDColor actualPdColor =
        new PDColor(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, COSName.A, colorSpace);

    // Assert
    assertSame(colorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#PDColor(COSArray, PDColorSpace)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then return PatternName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#PDColor(COSArray, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test new PDColor(COSArray, PDColorSpace); given FALSE; when COSArray() add FALSE; then return PatternName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDColor.<init>(COSArray, PDColorSpace)"})
  void testNewPDColor_givenFalse_whenCOSArrayAddFalse_thenReturnPatternNameIsNull() {
    // Arrange
    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    PDColor actualPdColor = new PDColor(array, PDDeviceGray.INSTANCE);

    // Assert
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    assertSame(PDDeviceGray.INSTANCE, actualPdColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#PDColor(float[], COSName, PDColorSpace)}.
   *
   * <ul>
   *   <li>Then return ColorSpace is {@link PDPattern#PDPattern(PDResources)} with resources is
   *       {@link PDResources#PDResources()}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#PDColor(float[], COSName, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test new PDColor(float[], COSName, PDColorSpace); then return ColorSpace is PDPattern(PDResources) with resources is PDResources()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDColor.<init>(float[], COSName, PDColorSpace)"})
  void testNewPDColor_thenReturnColorSpaceIsPDPatternWithResourcesIsPDResources() {
    // Arrange
    PDPattern colorSpace = new PDPattern(new PDResources());

    // Act
    PDColor actualPdColor =
        new PDColor(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, COSName.A, colorSpace);

    // Assert
    assertSame(colorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#PDColor(COSArray, PDColorSpace)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then return PatternName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#PDColor(COSArray, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test new PDColor(COSArray, PDColorSpace); when COSArray(); then return PatternName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDColor.<init>(COSArray, PDColorSpace)"})
  void testNewPDColor_whenCOSArray_thenReturnPatternNameIsNull() {
    // Arrange and Act
    PDColor actualPdColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Assert
    assertNull(actualPdColor.getPatternName());
    assertFalse(actualPdColor.isPattern());
    assertSame(PDDeviceGray.INSTANCE, actualPdColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#PDColor(float[], COSName, PDColorSpace)}.
   *
   * <ul>
   *   <li>When {@link PDDeviceGray#INSTANCE}.
   *   <li>Then return ColorSpace is {@link PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#PDColor(float[], COSName, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test new PDColor(float[], COSName, PDColorSpace); when INSTANCE; then return ColorSpace is INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDColor.<init>(float[], COSName, PDColorSpace)"})
  void testNewPDColor_whenInstance_thenReturnColorSpaceIsInstance() {
    // Arrange and Act
    PDColor actualPdColor =
        new PDColor(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, COSName.A, PDDeviceGray.INSTANCE);

    // Assert
    assertSame(PDDeviceGray.INSTANCE, actualPdColor.getColorSpace());
    assertArrayEquals(new float[] {10.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#PDColor(float[], PDColorSpace)}.
   *
   * <ul>
   *   <li>When {@link PDDeviceGray#INSTANCE}.
   *   <li>Then return ColorSpace is {@link PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#PDColor(float[], PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test new PDColor(float[], PDColorSpace); when INSTANCE; then return ColorSpace is INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDColor.<init>(float[], PDColorSpace)"})
  void testNewPDColor_whenInstance_thenReturnColorSpaceIsInstance2() {
    // Arrange and Act
    PDColor actualPdColor =
        new PDColor(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, PDDeviceGray.INSTANCE);

    // Assert
    assertSame(PDDeviceGray.INSTANCE, actualPdColor.getColorSpace());
    assertArrayEquals(new float[] {10.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#PDColor(float[], PDColorSpace)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return PatternName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#PDColor(float[], PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test new PDColor(float[], PDColorSpace); when 'null'; then return PatternName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDColor.<init>(float[], PDColorSpace)"})
  void testNewPDColor_whenNull_thenReturnPatternNameIsNull() {
    // Arrange and Act
    PDColor actualPdColor = new PDColor(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, null);

    // Assert
    assertNull(actualPdColor.getPatternName());
    assertNull(actualPdColor.getColorSpace());
    assertFalse(actualPdColor.isPattern());
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#PDColor(float[], PDColorSpace)}.
   *
   * <ul>
   *   <li>When {@link PDCalGray#PDCalGray()}.
   *   <li>Then return ColorSpace is {@link PDCalGray#PDCalGray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#PDColor(float[], PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test new PDColor(float[], PDColorSpace); when PDCalGray(); then return ColorSpace is PDCalGray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDColor.<init>(float[], PDColorSpace)"})
  void testNewPDColor_whenPDCalGray_thenReturnColorSpaceIsPDCalGray() {
    // Arrange
    PDCalGray colorSpace = new PDCalGray();

    // Act
    PDColor actualPdColor = new PDColor(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, colorSpace);

    // Assert
    assertSame(colorSpace, actualPdColor.getColorSpace());
    assertArrayEquals(new float[] {10.0f}, actualPdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#getComponents()}.
   *
   * <ul>
   *   <li>Given {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link
   *       COSArray#COSArray()} and colorSpace is {@link PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#getComponents()}
   */
  @Test
  @DisplayName(
      "Test getComponents(); given PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDColor.getComponents()"})
  void testGetComponents_givenPDColorWithArrayIsCOSArrayAndColorSpaceIsInstance() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new float[] {0.0f},
        new PDColor(new COSArray(), PDDeviceGray.INSTANCE).getComponents(),
        0.0f);
  }

  /**
   * Test {@link PDColor#getComponents()}.
   *
   * <ul>
   *   <li>Given {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link
   *       COSArray#COSArray()} and colorSpace is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#getComponents()}
   */
  @Test
  @DisplayName(
      "Test getComponents(); given PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDColor.getComponents()"})
  void testGetComponents_givenPDColorWithArrayIsCOSArrayAndColorSpaceIsNull() {
    // Arrange
    PDColor pdColor = new PDColor(new COSArray(), null);

    // Act and Assert
    assertArrayEquals(new float[] {}, pdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#getComponents()}.
   *
   * <ul>
   *   <li>Given {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link
   *       COSArray#COSArray()} and colorSpace is {@link PDCalGray#PDCalGray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#getComponents()}
   */
  @Test
  @DisplayName(
      "Test getComponents(); given PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is PDCalGray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDColor.getComponents()"})
  void testGetComponents_givenPDColorWithArrayIsCOSArrayAndColorSpaceIsPDCalGray() {
    // Arrange
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDCalGray());

    // Act and Assert
    assertArrayEquals(new float[] {0.0f}, pdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#getComponents()}.
   *
   * <ul>
   *   <li>Given {@link PDPattern#PDPattern(PDResources)} with resources is {@link
   *       PDResources#PDResources()}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#getComponents()}
   */
  @Test
  @DisplayName("Test getComponents(); given PDPattern(PDResources) with resources is PDResources()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDColor.getComponents()"})
  void testGetComponents_givenPDPatternWithResourcesIsPDResources() {
    // Arrange
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDPattern(new PDResources()));

    // Act and Assert
    assertArrayEquals(new float[] {}, pdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#isPattern()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#isPattern()}
   */
  @Test
  @DisplayName("Test isPattern(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDColor.isPattern()"})
  void testIsPattern_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDColor(new COSArray(), PDDeviceGray.INSTANCE).isPattern());
  }

  /**
   * Test {@link PDColor#isPattern()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#isPattern()}
   */
  @Test
  @DisplayName("Test isPattern(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDColor.isPattern()"})
  void testIsPattern_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PDColor(COSName.A, PDDeviceGray.INSTANCE).isPattern());
  }

  /**
   * Test {@link PDColor#toCOSArray()}.
   *
   * <ul>
   *   <li>Then return toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#toCOSArray()}
   */
  @Test
  @DisplayName("Test toCOSArray(); then return toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDColor.toCOSArray()"})
  void testToCOSArray_thenReturnToListEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDColor(new COSArray(), PDDeviceGray.INSTANCE).toCOSArray().toList().isEmpty());
  }

  /**
   * Test {@link PDColor#toCOSArray()}.
   *
   * <ul>
   *   <li>Then return toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#toCOSArray()}
   */
  @Test
  @DisplayName("Test toCOSArray(); then return toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDColor.toCOSArray()"})
  void testToCOSArray_thenReturnToListSizeIsFour() {
    // Arrange
    PDColor pdColor = new PDColor(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, PDDeviceGray.INSTANCE);

    // Act and Assert
    List<? extends COSBase> toListResult = pdColor.toCOSArray().toList();
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
   *
   * <ul>
   *   <li>Then return toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#toCOSArray()}
   */
  @Test
  @DisplayName("Test toCOSArray(); then return toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDColor.toCOSArray()"})
  void testToCOSArray_thenReturnToListSizeIsOne() {
    // Arrange, Act and Assert
    List<? extends COSBase> toListResult =
        new PDColor(COSName.A, PDDeviceGray.INSTANCE).toCOSArray().toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertEquals("A", ((COSName) getResult).getName());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDColor#toString()}
   *   <li>{@link PDColor#getColorSpace()}
   *   <li>{@link PDColor#getPatternName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDColorSpace PDColor.getColorSpace()",
    "COSName PDColor.getPatternName()",
    "String PDColor.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    PDColor pdColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    String actualToStringResult = pdColor.toString();
    PDColorSpace actualColorSpace = pdColor.getColorSpace();

    // Assert
    assertEquals(
        "PDColor{components=[], patternName=null, colorSpace=DeviceGray}", actualToStringResult);
    assertNull(pdColor.getPatternName());
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }
}
