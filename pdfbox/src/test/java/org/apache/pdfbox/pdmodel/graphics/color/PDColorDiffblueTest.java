package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return array of {@code float} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#getComponents()}
   */
  @Test
  @DisplayName(
      "Test getComponents(); given ArrayList() add '42'; then return array of float with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDColor.getComponents()"})
  void testGetComponents_givenArrayListAdd42_thenReturnArrayOfFloatWithZeroAndZero() {
    // Arrange
    ArrayList<String> names = new ArrayList<>();
    names.add("42");
    names.add("foo");

    PDDeviceN colorSpace = new PDDeviceN();
    colorSpace.setColorantNames(names);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    // Act and Assert
    assertArrayEquals(new float[] {0.0f, 0.0f}, pdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#getComponents()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return array of {@code float} with zero.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#getComponents()}
   */
  @Test
  @DisplayName(
      "Test getComponents(); given ArrayList() add 'foo'; then return array of float with zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDColor.getComponents()"})
  void testGetComponents_givenArrayListAddFoo_thenReturnArrayOfFloatWithZero() {
    // Arrange
    ArrayList<String> names = new ArrayList<>();
    names.add("foo");

    PDDeviceN colorSpace = new PDDeviceN();
    colorSpace.setColorantNames(names);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    // Act and Assert
    assertArrayEquals(new float[] {0.0f}, pdColor.getComponents(), 0.0f);
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
   *   <li>Given {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link
   *       COSArray#COSArray()} and colorSpace is {@link PDCalRGB#PDCalRGB()}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#getComponents()}
   */
  @Test
  @DisplayName(
      "Test getComponents(); given PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is PDCalRGB()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDColor.getComponents()"})
  void testGetComponents_givenPDColorWithArrayIsCOSArrayAndColorSpaceIsPDCalRGB() {
    // Arrange
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDCalRGB());

    // Act and Assert
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, pdColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDColor#getComponents()}.
   *
   * <ul>
   *   <li>Given {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link
   *       COSArray#COSArray()} and colorSpace is {@link PDIndexed#PDIndexed()}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#getComponents()}
   */
  @Test
  @DisplayName(
      "Test getComponents(); given PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is PDIndexed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDColor.getComponents()"})
  void testGetComponents_givenPDColorWithArrayIsCOSArrayAndColorSpaceIsPDIndexed() {
    // Arrange
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDIndexed());

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
   * Test {@link PDColor#getComponents()}.
   *
   * <ul>
   *   <li>Then return empty array of {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#getComponents()}
   */
  @Test
  @DisplayName("Test getComponents(); then return empty array of float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDColor.getComponents()"})
  void testGetComponents_thenReturnEmptyArrayOfFloat() {
    // Arrange
    PDDeviceN colorSpace = new PDDeviceN();
    colorSpace.setColorantNames(new ArrayList<>());
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
   * Test {@link PDColor#toRGB()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#get(int)} return {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#toRGB()}
   */
  @Test
  @DisplayName("Test toRGB(); given COSArray get(int) return FALSE; then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDColor.toRGB()"})
  void testToRGB_givenCOSArrayGetReturnFalse_thenCallsGetObject() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    new COSDocument(streamCacheCreateFunction);

    COSArray array = mock(COSArray.class);
    when(array.isEmpty()).thenReturn(true);
    when(array.size()).thenReturn(3);
    when(array.get(anyInt())).thenReturn(COSBoolean.FALSE);
    doNothing().when(array).add(Mockito.<COSObjectable>any());
    array.add(mock(COSObjectable.class));

    COSArray array2 = mock(COSArray.class);
    when(array2.getObject(anyInt())).thenReturn(new COSDictionary());
    PDCalGray colorSpace = new PDCalGray(array2);

    PDColor pdColor = new PDColor(array, colorSpace);

    // Act
    int actualToRGBResult = pdColor.toRGB();

    // Assert
    verify(array).add(isA(COSObjectable.class));
    verify(array, atLeast(1)).get(anyInt());
    verify(array2).getObject(1);
    verify(array).isEmpty();
    verify(array).size();
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualToRGBResult);
  }

  /**
   * Test {@link PDColor#toRGB()}.
   *
   * <ul>
   *   <li>Given {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link COSArray} and
   *       colorSpace is {@link PDDeviceGray#INSTANCE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#toRGB()}
   */
  @Test
  @DisplayName(
      "Test toRGB(); given PDColor(COSArray, PDColorSpace) with array is COSArray and colorSpace is INSTANCE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDColor.toRGB()"})
  void testToRGB_givenPDColorWithArrayIsCOSArrayAndColorSpaceIsInstance_thenReturnZero()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    new COSDocument(streamCacheCreateFunction);

    StreamCacheCreateFunction streamCacheCreateFunction2 = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction2.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction2);

    COSArray array = mock(COSArray.class);
    when(array.isEmpty()).thenReturn(true);
    when(array.size()).thenReturn(3);
    when(array.get(anyInt())).thenReturn(cosDocument);
    doNothing().when(array).add(Mockito.<COSObjectable>any());
    array.add(mock(COSObjectable.class));

    // Act
    int actualToRGBResult = new PDColor(array, PDDeviceGray.INSTANCE).toRGB();

    // Assert
    verify(array).add(isA(COSObjectable.class));
    verify(array, atLeast(1)).get(anyInt());
    verify(array).isEmpty();
    verify(array).size();
    verify(streamCacheCreateFunction2).create();
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualToRGBResult);
  }

  /**
   * Test {@link PDColor#toRGB()}.
   *
   * <ul>
   *   <li>Given {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link COSArray} and
   *       colorSpace is {@link PDCalRGB#PDCalRGB()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDColor#toRGB()}
   */
  @Test
  @DisplayName(
      "Test toRGB(); given PDColor(COSArray, PDColorSpace) with array is COSArray and colorSpace is PDCalRGB(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDColor.toRGB()"})
  void testToRGB_givenPDColorWithArrayIsCOSArrayAndColorSpaceIsPDCalRGB_thenReturnZero()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    new COSDocument(streamCacheCreateFunction);

    StreamCacheCreateFunction streamCacheCreateFunction2 = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction2.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction2);

    COSArray array = mock(COSArray.class);
    when(array.isEmpty()).thenReturn(true);
    when(array.size()).thenReturn(3);
    when(array.get(anyInt())).thenReturn(cosDocument);
    doNothing().when(array).add(Mockito.<COSObjectable>any());
    array.add(mock(COSObjectable.class));
    PDColor pdColor = new PDColor(array, new PDCalRGB());

    // Act
    int actualToRGBResult = pdColor.toRGB();

    // Assert
    verify(array).add(isA(COSObjectable.class));
    verify(array, atLeast(1)).get(anyInt());
    verify(array).isEmpty();
    verify(array).size();
    verify(streamCacheCreateFunction2).create();
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualToRGBResult);
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
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertFalse(getResult2.isDirect());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
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
