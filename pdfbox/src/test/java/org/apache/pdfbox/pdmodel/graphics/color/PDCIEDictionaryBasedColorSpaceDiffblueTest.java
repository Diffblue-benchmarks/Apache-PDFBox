package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDCIEDictionaryBasedColorSpaceDiffblueTest {
  /**
   * Test {@link PDCIEDictionaryBasedColorSpace#isWhitePoint()}.
   *
   * <p>Method under test: {@link PDCIEDictionaryBasedColorSpace#isWhitePoint()}
   */
  @Test
  @DisplayName("Test isWhitePoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDCIEDictionaryBasedColorSpace.isWhitePoint()"})
  void testIsWhitePoint() {
    // Arrange, Act and Assert
    assertTrue(new PDCalGray().isWhitePoint());
  }

  /**
   * Test {@link PDCIEDictionaryBasedColorSpace#convXYZtoRGB(float, float, float)}.
   *
   * <ul>
   *   <li>When {@code -1.0E-5}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIEDictionaryBasedColorSpace#convXYZtoRGB(float, float, float)}
   */
  @Test
  @DisplayName("Test convXYZtoRGB(float, float, float); when '-1.0E-5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDCIEDictionaryBasedColorSpace.convXYZtoRGB(float, float, float)"})
  void testConvXYZtoRGB_when10e5() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 0.0f}, new PDCalGray().convXYZtoRGB(-1.0E-5f, 0.0f, 0.0f), 0.0f);
  }

  /**
   * Test {@link PDCIEDictionaryBasedColorSpace#convXYZtoRGB(float, float, float)}.
   *
   * <ul>
   *   <li>When ten.
   * </ul>
   *
   * <p>Method under test: {@link PDCIEDictionaryBasedColorSpace#convXYZtoRGB(float, float, float)}
   */
  @Test
  @DisplayName("Test convXYZtoRGB(float, float, float); when ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDCIEDictionaryBasedColorSpace.convXYZtoRGB(float, float, float)"})
  void testConvXYZtoRGB_whenTen() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 0.0f}, new PDCalGray().convXYZtoRGB(10.0f, 10.0f, 10.0f), 0.0f);
  }

  /**
   * Test {@link PDCIEDictionaryBasedColorSpace#convXYZtoRGB(float, float, float)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link PDCIEDictionaryBasedColorSpace#convXYZtoRGB(float, float, float)}
   */
  @Test
  @DisplayName("Test convXYZtoRGB(float, float, float); when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDCIEDictionaryBasedColorSpace.convXYZtoRGB(float, float, float)"})
  void testConvXYZtoRGB_whenZero() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 0.0f}, new PDCalGray().convXYZtoRGB(0.0f, 0.0f, -1.0E-5f), 0.0f);
  }

  /**
   * Test {@link PDCIEDictionaryBasedColorSpace#convXYZtoRGB(float, float, float)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link PDCIEDictionaryBasedColorSpace#convXYZtoRGB(float, float, float)}
   */
  @Test
  @DisplayName("Test convXYZtoRGB(float, float, float); when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDCIEDictionaryBasedColorSpace.convXYZtoRGB(float, float, float)"})
  void testConvXYZtoRGB_whenZero2() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 0.0f}, new PDCalGray().convXYZtoRGB(0.0f, -1.0E-5f, 0.0f), 0.0f);
  }

  /**
   * Test {@link PDCIEDictionaryBasedColorSpace#getWhitepoint()}.
   *
   * <p>Method under test: {@link PDCIEDictionaryBasedColorSpace#getWhitepoint()}
   */
  @Test
  @DisplayName("Test getWhitepoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTristimulus PDCIEDictionaryBasedColorSpace.getWhitepoint()"})
  void testGetWhitepoint() {
    // Arrange and Act
    PDTristimulus actualWhitepoint = new PDCalGray().getWhitepoint();

    // Assert
    COSBase cOSObject = actualWhitepoint.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(1.0f, actualWhitepoint.getX());
    assertEquals(1.0f, actualWhitepoint.getY());
    assertEquals(1.0f, actualWhitepoint.getZ());
    assertFalse(getResult.isDirect());
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
  }

  /**
   * Test {@link PDCIEDictionaryBasedColorSpace#getBlackPoint()}.
   *
   * <p>Method under test: {@link PDCIEDictionaryBasedColorSpace#getBlackPoint()}
   */
  @Test
  @DisplayName("Test getBlackPoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTristimulus PDCIEDictionaryBasedColorSpace.getBlackPoint()"})
  void testGetBlackPoint() {
    // Arrange and Act
    PDTristimulus actualBlackPoint = new PDCalGray().getBlackPoint();

    // Assert
    COSBase cOSObject = actualBlackPoint.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualBlackPoint.getX());
    assertEquals(0.0f, actualBlackPoint.getY());
    assertEquals(0.0f, actualBlackPoint.getZ());
    assertFalse(getResult.isDirect());
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
  }

  /**
   * Test {@link PDCIEDictionaryBasedColorSpace#setWhitePoint(PDTristimulus)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIEDictionaryBasedColorSpace#setWhitePoint(PDTristimulus)}
   */
  @Test
  @DisplayName(
      "Test setWhitePoint(PDTristimulus); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCIEDictionaryBasedColorSpace.setWhitePoint(PDTristimulus)"})
  void testSetWhitePoint_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDCalGray().setWhitePoint(null));
  }

  /**
   * Test {@link PDCIEDictionaryBasedColorSpace#setWhitePoint(PDTristimulus)}.
   *
   * <ul>
   *   <li>When {@link PDTristimulus#PDTristimulus()}.
   *   <li>Then {@link PDCalGray#PDCalGray()} Whitepoint X is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDCIEDictionaryBasedColorSpace#setWhitePoint(PDTristimulus)}
   */
  @Test
  @DisplayName(
      "Test setWhitePoint(PDTristimulus); when PDTristimulus(); then PDCalGray() Whitepoint X is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCIEDictionaryBasedColorSpace.setWhitePoint(PDTristimulus)"})
  void testSetWhitePoint_whenPDTristimulus_thenPDCalGrayWhitepointXIsZero() {
    // Arrange
    PDCalGray pdCalGray = new PDCalGray();

    // Act
    pdCalGray.setWhitePoint(new PDTristimulus());

    // Assert
    PDTristimulus whitepoint = pdCalGray.getWhitepoint();
    assertEquals(0.0f, whitepoint.getX());
    assertEquals(0.0f, whitepoint.getY());
    assertEquals(0.0f, whitepoint.getZ());
    assertEquals(0.0f, pdCalGray.wpX);
    assertEquals(0.0f, pdCalGray.wpY);
    assertEquals(0.0f, pdCalGray.wpZ);
    COSDictionary cosDictionary = pdCalGray.dictionary;
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link PDCIEDictionaryBasedColorSpace#setBlackPoint(PDTristimulus)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDCalGray#PDCalGray()} BlackPoint COSObject {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIEDictionaryBasedColorSpace#setBlackPoint(PDTristimulus)}
   */
  @Test
  @DisplayName(
      "Test setBlackPoint(PDTristimulus); when 'null'; then PDCalGray() BlackPoint COSObject COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCIEDictionaryBasedColorSpace.setBlackPoint(PDTristimulus)"})
  void testSetBlackPoint_whenNull_thenPDCalGrayBlackPointCOSObjectCOSArray() {
    // Arrange
    PDCalGray pdCalGray = new PDCalGray();

    // Act
    pdCalGray.setBlackPoint(null);

    // Assert that nothing has changed
    assertTrue(pdCalGray.getBlackPoint().getCOSObject() instanceof COSArray);
    COSDictionary cosDictionary = pdCalGray.dictionary;
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
  }

  /**
   * Test {@link PDCIEDictionaryBasedColorSpace#setBlackPoint(PDTristimulus)}.
   *
   * <ul>
   *   <li>When {@link PDTristimulus#PDTristimulus()}.
   *   <li>Then {@link PDCalGray#PDCalGray()} {@link PDCIEDictionaryBasedColorSpace#dictionary}
   *       Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDCIEDictionaryBasedColorSpace#setBlackPoint(PDTristimulus)}
   */
  @Test
  @DisplayName(
      "Test setBlackPoint(PDTristimulus); when PDTristimulus(); then PDCalGray() dictionary Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCIEDictionaryBasedColorSpace.setBlackPoint(PDTristimulus)"})
  void testSetBlackPoint_whenPDTristimulus_thenPDCalGrayDictionaryValuesSizeIsOne() {
    // Arrange
    PDCalGray pdCalGray = new PDCalGray();

    // Act
    pdCalGray.setBlackPoint(new PDTristimulus());

    // Assert
    COSDictionary cosDictionary = pdCalGray.dictionary;
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
  }
}
