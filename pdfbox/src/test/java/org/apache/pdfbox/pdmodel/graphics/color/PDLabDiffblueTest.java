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
import java.awt.image.WritableRaster;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDLabDiffblueTest {
  /**
   * Test {@link PDLab#PDLab()}.
   *
   * <p>Method under test: {@link PDLab#PDLab()}
   */
  @Test
  @DisplayName("Test new PDLab()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLab.<init>()"})
  void testNewPDLab() {
    // Arrange and Act
    PDLab actualPdLab = new PDLab();

    // Assert
    assertTrue(actualPdLab.getCOSObject() instanceof COSArray);
    assertEquals("Lab", actualPdLab.getName());
    assertEquals(1.0f, actualPdLab.wpX);
    assertEquals(1.0f, actualPdLab.wpY);
    assertEquals(1.0f, actualPdLab.wpZ);
    assertEquals(3, actualPdLab.getNumberOfComponents());
  }

  /**
   * Test {@link PDLab#PDLab(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@code
   *       null}.
   *   <li>Then return Name is {@code Lab}.
   * </ul>
   *
   * <p>Method under test: {@link PDLab#PDLab(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDLab(COSArray); given COSDictionary getCOSArray(COSName) return 'null'; then return Name is 'Lab'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLab.<init>(COSArray)"})
  void testNewPDLab_givenCOSDictionaryGetCOSArrayReturnNull_thenReturnNameIsLab() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);

    COSArray lab = mock(COSArray.class);
    when(lab.getObject(anyInt())).thenReturn(cosDictionary);

    // Act
    PDLab actualPdLab = new PDLab(lab);

    // Assert
    verify(lab).getObject(1);
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    assertEquals("Lab", actualPdLab.getName());
    assertEquals(1.0f, actualPdLab.wpX);
    assertEquals(1.0f, actualPdLab.wpY);
    assertEquals(1.0f, actualPdLab.wpZ);
    assertEquals(3, actualPdLab.getNumberOfComponents());
    assertSame(lab, actualPdLab.getCOSObject());
  }

  /**
   * Test {@link PDLab#PDLab(COSArray)}.
   *
   * <ul>
   *   <li>Then return {@link PDCIEDictionaryBasedColorSpace#dictionary} UpdateState
   *       OriginDocumentState is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLab#PDLab(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDLab(COSArray); then return dictionary UpdateState OriginDocumentState is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLab.<init>(COSArray)"})
  void testNewPDLab_thenReturnDictionaryUpdateStateOriginDocumentStateIsNull() {
    // Arrange
    COSArray lab = mock(COSArray.class);
    when(lab.getObject(anyInt())).thenReturn(new COSDictionary());

    // Act
    PDLab actualPdLab = new PDLab(lab);

    // Assert
    verify(lab).getObject(1);
    COSDictionary cosDictionary = actualPdLab.dictionary;
    COSUpdateState updateState = cosDictionary.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cosDictionary.getKey());
    assertEquals(0, cosDictionary.size());
    COSIncrement toIncrementResult = cosDictionary.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cosDictionary.isDirect());
    assertFalse(cosDictionary.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 0.0f}, actualPdLab.getInitialColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDLab#getName()}.
   *
   * <p>Method under test: {@link PDLab#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDLab.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("Lab", new PDLab().getName());
  }

  /**
   * Test {@link PDLab#toRawImage(WritableRaster)} with {@code raster}.
   *
   * <p>Method under test: {@link PDLab#toRawImage(WritableRaster)}
   */
  @Test
  @DisplayName("Test toRawImage(WritableRaster) with 'raster'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage PDLab.toRawImage(WritableRaster)"})
  void testToRawImageWithRaster() {
    // Arrange, Act and Assert
    assertNull(new PDLab().toRawImage(null));
  }

  /**
   * Test {@link PDLab#toRGB(float[])}.
   *
   * <p>Method under test: {@link PDLab#toRGB(float[])}
   */
  @Test
  @DisplayName("Test toRGB(float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDLab.toRGB(float[])"})
  void testToRGB() {
    // Arrange and Act
    float[] actualToRGBResult = new PDLab().toRGB(new float[] {10.0f, -100.0f, 10.0f, -100.0f});

    // Assert
    assertArrayEquals(new float[] {0.0f, 0.1589685f, 0.050019074f}, actualToRGBResult, 0.0f);
  }

  /**
   * Test {@link PDLab#getNumberOfComponents()}.
   *
   * <p>Method under test: {@link PDLab#getNumberOfComponents()}
   */
  @Test
  @DisplayName("Test getNumberOfComponents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDLab.getNumberOfComponents()"})
  void testGetNumberOfComponents() {
    // Arrange, Act and Assert
    assertEquals(3, new PDLab().getNumberOfComponents());
  }

  /**
   * Test {@link PDLab#getDefaultDecode(int)}.
   *
   * <p>Method under test: {@link PDLab#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDLab.getDefaultDecode(int)"})
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new float[] {0.0f, 100.0f, -100.0f, 100.0f, -100.0f, 100.0f},
        new PDLab().getDefaultDecode(1),
        0.0f);
  }

  /**
   * Test {@link PDLab#getInitialColor()}.
   *
   * <p>Method under test: {@link PDLab#getInitialColor()}
   */
  @Test
  @DisplayName("Test getInitialColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColor PDLab.getInitialColor()"})
  void testGetInitialColor() {
    // Arrange
    PDLab pdLab = new PDLab();

    // Act
    PDColor actualInitialColor = pdLab.getInitialColor();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertFalse(actualInitialColor.isPattern());
    assertSame(pdLab, actualInitialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, actualInitialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDLab#getARange()}.
   *
   * <p>Method under test: {@link PDLab#getARange()}
   */
  @Test
  @DisplayName("Test getARange()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRange PDLab.getARange()"})
  void testGetARange() {
    // Arrange and Act
    PDRange actualARange = new PDLab().getARange();

    // Assert
    COSArray cOSArray = actualARange.getCOSArray();
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
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(-100.0f, actualARange.getMin());
    assertEquals(100.0f, actualARange.getMax());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
    assertSame(cOSArray, actualARange.getCOSObject());
  }

  /**
   * Test {@link PDLab#getBRange()}.
   *
   * <p>Method under test: {@link PDLab#getBRange()}
   */
  @Test
  @DisplayName("Test getBRange()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRange PDLab.getBRange()"})
  void testGetBRange() {
    // Arrange and Act
    PDRange actualBRange = new PDLab().getBRange();

    // Assert
    COSArray cOSArray = actualBRange.getCOSArray();
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
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(-100.0f, actualBRange.getMin());
    assertEquals(100.0f, actualBRange.getMax());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
    assertSame(cOSArray, actualBRange.getCOSObject());
  }

  /**
   * Test {@link PDLab#setARange(PDRange)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDLab#PDLab()} ARange Min is minus one hundred.
   * </ul>
   *
   * <p>Method under test: {@link PDLab#setARange(PDRange)}
   */
  @Test
  @DisplayName("Test setARange(PDRange); when 'null'; then PDLab() ARange Min is minus one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLab.setARange(PDRange)"})
  void testSetARange_whenNull_thenPDLabARangeMinIsMinusOneHundred() {
    // Arrange
    PDLab pdLab = new PDLab();

    // Act
    pdLab.setARange(null);

    // Assert that nothing has changed
    PDRange aRange = pdLab.getARange();
    List<? extends COSBase> toListResult = aRange.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertEquals(-100.0f, aRange.getMin());
    assertEquals(100.0f, aRange.getMax());
  }

  /**
   * Test {@link PDLab#setARange(PDRange)}.
   *
   * <ul>
   *   <li>When {@link PDRange#PDRange()}.
   *   <li>Then {@link PDLab#PDLab()} ARange Min is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDLab#setARange(PDRange)}
   */
  @Test
  @DisplayName("Test setARange(PDRange); when PDRange(); then PDLab() ARange Min is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLab.setARange(PDRange)"})
  void testSetARange_whenPDRange_thenPDLabARangeMinIsZero() {
    // Arrange
    PDLab pdLab = new PDLab();

    // Act
    pdLab.setARange(new PDRange());

    // Assert
    PDRange aRange = pdLab.getARange();
    List<? extends COSBase> toListResult = aRange.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertEquals(0.0f, aRange.getMin());
    assertEquals(1.0f, aRange.getMax());
  }

  /**
   * Test {@link PDLab#setBRange(PDRange)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDLab#PDLab()} BRange Min is minus one hundred.
   * </ul>
   *
   * <p>Method under test: {@link PDLab#setBRange(PDRange)}
   */
  @Test
  @DisplayName("Test setBRange(PDRange); when 'null'; then PDLab() BRange Min is minus one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLab.setBRange(PDRange)"})
  void testSetBRange_whenNull_thenPDLabBRangeMinIsMinusOneHundred() {
    // Arrange
    PDLab pdLab = new PDLab();

    // Act
    pdLab.setBRange(null);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = pdLab.getARange().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    PDRange bRange = pdLab.getBRange();
    assertEquals(-100.0f, bRange.getMin());
    assertEquals(100.0f, bRange.getMax());
    assertEquals(toListResult.get(0), getResult);
    assertEquals(toListResult.get(1), getResult2);
  }

  /**
   * Test {@link PDLab#setBRange(PDRange)}.
   *
   * <ul>
   *   <li>When {@link PDRange#PDRange()}.
   *   <li>Then {@link PDLab#PDLab()} BRange Min is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDLab#setBRange(PDRange)}
   */
  @Test
  @DisplayName("Test setBRange(PDRange); when PDRange(); then PDLab() BRange Min is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLab.setBRange(PDRange)"})
  void testSetBRange_whenPDRange_thenPDLabBRangeMinIsZero() {
    // Arrange
    PDLab pdLab = new PDLab();

    // Act
    pdLab.setBRange(new PDRange());

    // Assert
    List<? extends COSBase> toListResult = pdLab.getARange().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    PDRange bRange = pdLab.getBRange();
    assertEquals(0.0f, bRange.getMin());
    assertEquals(1.0f, bRange.getMax());
  }
}
