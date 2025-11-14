package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDCalGrayDiffblueTest {
  /**
   * Test {@link PDCalGray#PDCalGray()}.
   *
   * <p>Method under test: {@link PDCalGray#PDCalGray()}
   */
  @Test
  @DisplayName("Test new PDCalGray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@code
   *       null}.
   *   <li>Then return Name is {@code CalGray}.
   * </ul>
   *
   * <p>Method under test: {@link PDCalGray#PDCalGray(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDCalGray(COSArray); given COSDictionary getCOSArray(COSName) return 'null'; then return Name is 'CalGray'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCalGray.<init>(COSArray)"})
  void testNewPDCalGray_givenCOSDictionaryGetCOSArrayReturnNull_thenReturnNameIsCalGray() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);

    COSArray array = mock(COSArray.class);
    when(array.getObject(anyInt())).thenReturn(cosDictionary);

    // Act
    PDCalGray actualPdCalGray = new PDCalGray(array);

    // Assert
    verify(array).getObject(1);
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    assertEquals("CalGray", actualPdCalGray.getName());
    assertEquals(0.0f, actualPdCalGray.getGamma());
    assertEquals(1, actualPdCalGray.getNumberOfComponents());
    assertEquals(1.0f, actualPdCalGray.wpX);
    assertEquals(1.0f, actualPdCalGray.wpY);
    assertEquals(1.0f, actualPdCalGray.wpZ);
    assertSame(array, actualPdCalGray.getCOSObject());
  }

  /**
   * Test {@link PDCalGray#PDCalGray(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>Then {@link PDCIEDictionaryBasedColorSpace#dictionary} return {@link COSStream}.
   * </ul>
   *
   * <p>Method under test: {@link PDCalGray#PDCalGray(COSArray)}
   */
  @Test
  @DisplayName("Test new PDCalGray(COSArray); given COSStream(); then dictionary return COSStream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCalGray.<init>(COSArray)"})
  void testNewPDCalGray_givenCOSStream_thenDictionaryReturnCOSStream() {
    // Arrange
    COSArray array = mock(COSArray.class);
    when(array.getObject(anyInt())).thenReturn(new COSStream());

    // Act
    PDCalGray actualPdCalGray = new PDCalGray(array);

    // Assert
    verify(array).getObject(1);
    COSDictionary cosDictionary = actualPdCalGray.dictionary;
    assertTrue(cosDictionary instanceof COSStream);
    assertNull(((COSStream) cosDictionary).getFilters());
    assertEquals(0L, ((COSStream) cosDictionary).getLength());
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
    assertFalse(((COSStream) cosDictionary).hasData());
    assertArrayEquals(new float[] {0.0f}, actualPdCalGray.getInitialColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDCalGray#PDCalGray(COSArray)}.
   *
   * <ul>
   *   <li>Then return {@link PDCIEDictionaryBasedColorSpace#dictionary} UpdateState
   *       OriginDocumentState is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDCalGray#PDCalGray(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDCalGray(COSArray); then return dictionary UpdateState OriginDocumentState is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCalGray.<init>(COSArray)"})
  void testNewPDCalGray_thenReturnDictionaryUpdateStateOriginDocumentStateIsNull() {
    // Arrange
    COSArray array = mock(COSArray.class);
    when(array.getObject(anyInt())).thenReturn(new COSDictionary());

    // Act
    PDCalGray actualPdCalGray = new PDCalGray(array);

    // Assert
    verify(array).getObject(1);
    COSDictionary cosDictionary = actualPdCalGray.dictionary;
    COSUpdateState updateState = cosDictionary.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cosDictionary.getKey());
    assertEquals(0, cosDictionary.size());
    assertEquals(1.0f, actualPdCalGray.getGamma());
    COSIncrement toIncrementResult = cosDictionary.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cosDictionary.isDirect());
    assertFalse(cosDictionary.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertArrayEquals(new float[] {0.0f}, actualPdCalGray.getInitialColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDCalGray#getName()}.
   *
   * <p>Method under test: {@link PDCalGray#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDCalGray.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("CalGray", new PDCalGray().getName());
  }

  /**
   * Test {@link PDCalGray#getDefaultDecode(int)}.
   *
   * <p>Method under test: {@link PDCalGray#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDCalGray.getDefaultDecode(int)"})
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[] {0.0f, 1.0f}, new PDCalGray().getDefaultDecode(1), 0.0f);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDCalGray#getInitialColor()}
   *   <li>{@link PDCalGray#getNumberOfComponents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDColor PDCalGray.getInitialColor()",
    "int PDCalGray.getNumberOfComponents()"
  })
  void testGettersAndSetters() {
    // Arrange
    PDCalGray pdCalGray = new PDCalGray();

    // Act
    PDColor actualInitialColor = pdCalGray.getInitialColor();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertEquals(1, pdCalGray.getNumberOfComponents());
    assertFalse(actualInitialColor.isPattern());
    assertSame(pdCalGray, actualInitialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, actualInitialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDCalGray#toRGB(float[])}.
   *
   * <p>Method under test: {@link PDCalGray#toRGB(float[])}
   */
  @Test
  @DisplayName("Test toRGB(float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDCalGray.toRGB(float[])"})
  void testToRGB() {
    // Arrange and Act
    float[] actualToRGBResult = new PDCalGray().toRGB(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    // Assert
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, actualToRGBResult, 0.0f);
  }

  /**
   * Test {@link PDCalGray#getGamma()}.
   *
   * <p>Method under test: {@link PDCalGray#getGamma()}
   */
  @Test
  @DisplayName("Test getGamma()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCalGray.getGamma()"})
  void testGetGamma() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new PDCalGray().getGamma());
  }

  /**
   * Test {@link PDCalGray#setGamma(float)}.
   *
   * <p>Method under test: {@link PDCalGray#setGamma(float)}
   */
  @Test
  @DisplayName("Test setGamma(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
