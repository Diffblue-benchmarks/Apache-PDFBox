package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import java.io.IOException;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.Element;

class FDFAnnotationPolylineDiffblueTest {
  /**
   * Test {@link FDFAnnotationPolyline#FDFAnnotationPolyline(COSDictionary)}.
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#FDFAnnotationPolyline(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationPolyline(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolyline.<init>(COSDictionary)"})
  void testNewFDFAnnotationPolyline() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new FDFAnnotationPolyline(a).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}.
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationPolyline()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolyline.<init>()"})
  void testNewFDFAnnotationPolyline2() throws IOException {
    // Arrange and Act
    FDFAnnotationPolyline actualFdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Assert
    assertEquals("", actualFdfAnnotationPolyline.getRichContents());
    assertEquals("None", actualFdfAnnotationPolyline.getEndPointEndingStyle());
    assertEquals("None", actualFdfAnnotationPolyline.getStartPointEndingStyle());
    assertNull(actualFdfAnnotationPolyline.getVertices());
    assertNull(actualFdfAnnotationPolyline.getColor());
    assertNull(actualFdfAnnotationPolyline.getInteriorColor());
    assertNull(actualFdfAnnotationPolyline.getPage());
    assertNull(actualFdfAnnotationPolyline.getContents());
    assertNull(actualFdfAnnotationPolyline.getDate());
    assertNull(actualFdfAnnotationPolyline.getIntent());
    assertNull(actualFdfAnnotationPolyline.getName());
    assertNull(actualFdfAnnotationPolyline.getSubject());
    assertNull(actualFdfAnnotationPolyline.getTitle());
    assertNull(actualFdfAnnotationPolyline.getCreationDate());
    assertNull(actualFdfAnnotationPolyline.getRectangle());
    assertNull(actualFdfAnnotationPolyline.getBorderEffect());
    assertNull(actualFdfAnnotationPolyline.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationPolyline.getOpacity());
    assertFalse(actualFdfAnnotationPolyline.isHidden());
    assertFalse(actualFdfAnnotationPolyline.isInvisible());
    assertFalse(actualFdfAnnotationPolyline.isLocked());
    assertFalse(actualFdfAnnotationPolyline.isLockedContents());
    assertFalse(actualFdfAnnotationPolyline.isNoRotate());
    assertFalse(actualFdfAnnotationPolyline.isNoView());
    assertFalse(actualFdfAnnotationPolyline.isNoZoom());
    assertFalse(actualFdfAnnotationPolyline.isPrinted());
    assertFalse(actualFdfAnnotationPolyline.isReadOnly());
    assertFalse(actualFdfAnnotationPolyline.isToggleNoView());
  }

  /**
   * Test {@link FDFAnnotationPolyline#FDFAnnotationPolyline(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#FDFAnnotationPolyline(Element)}
   */
  @Test
  @DisplayName(
      "Test new FDFAnnotationPolyline(Element); when IIOMetadataNode(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolyline.<init>(Element)"})
  void testNewFDFAnnotationPolyline_whenIIOMetadataNode_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new FDFAnnotationPolyline(new IIOMetadataNode()));
  }

  /**
   * Test {@link FDFAnnotationPolyline#setVertices(float[])}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationPolyline#FDFAnnotationPolyline()} COSObject Values size is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#setVertices(float[])}
   */
  @Test
  @DisplayName(
      "Test setVertices(float[]); then FDFAnnotationPolyline() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolyline.setVertices(float[])"})
  void testSetVertices_thenFDFAnnotationPolylineCOSObjectValuesSizeIsThree() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setVertices(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationPolyline.getVertices(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationPolyline#getVertices()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#getVertices()}
   */
  @Test
  @DisplayName("Test getVertices(); given FDFAnnotationPolyline(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] FDFAnnotationPolyline.getVertices()"})
  void testGetVertices_givenFDFAnnotationPolyline_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationPolyline().getVertices());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getVertices()}.
   *
   * <ul>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#getVertices()}
   */
  @Test
  @DisplayName("Test getVertices(); then return array of float with ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] FDFAnnotationPolyline.getVertices()"})
  void testGetVertices_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    fdfAnnotationPolyline.setVertices(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationPolyline.getVertices(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}.
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolyline.setStartPointEndingStyle(String)"})
  void testSetStartPointEndingStyle() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setStartPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}.
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolyline.setStartPointEndingStyle(String)"})
  void testSetStartPointEndingStyle2() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setStartPointEndingStyle(null);

    // Assert
    assertEquals("None", fdfAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}.
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolyline.setStartPointEndingStyle(String)"})
  void testSetStartPointEndingStyle3() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setStartPointEndingStyle(",|;");

    // Assert
    assertEquals(",|;", fdfAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline()} EndPointEndingStyle is {@code
   *       None}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setStartPointEndingStyle(String); given FDFAnnotationPolyline() EndPointEndingStyle is 'None'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolyline.setStartPointEndingStyle(String)"})
  void testSetStartPointEndingStyle_givenFDFAnnotationPolylineEndPointEndingStyleIsNone() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    fdfAnnotationPolyline.setEndPointEndingStyle("None");

    // Act
    fdfAnnotationPolyline.setStartPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getStartPointEndingStyle()}.
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#getStartPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getStartPointEndingStyle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationPolyline.getStartPointEndingStyle()"})
  void testGetStartPointEndingStyle() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    fdfAnnotationPolyline.setStartPointEndingStyle("None");

    // Act and Assert
    assertEquals("None", fdfAnnotationPolyline.getStartPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getStartPointEndingStyle()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}.
   *   <li>Then return {@code None}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#getStartPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getStartPointEndingStyle(); given FDFAnnotationPolyline(); then return 'None'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationPolyline.getStartPointEndingStyle()"})
  void testGetStartPointEndingStyle_givenFDFAnnotationPolyline_thenReturnNone() {
    // Arrange, Act and Assert
    assertEquals("None", new FDFAnnotationPolyline().getStartPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}.
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setEndPointEndingStyle(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolyline.setEndPointEndingStyle(String)"})
  void testSetEndPointEndingStyle() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setEndPointEndingStyle(",|;");

    // Assert
    assertEquals(",|;", fdfAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline()} StartPointEndingStyle is
   *       {@code None}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setEndPointEndingStyle(String); given FDFAnnotationPolyline() StartPointEndingStyle is 'None'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolyline.setEndPointEndingStyle(String)"})
  void testSetEndPointEndingStyle_givenFDFAnnotationPolylineStartPointEndingStyleIsNone() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    fdfAnnotationPolyline.setStartPointEndingStyle("None");

    // Act
    fdfAnnotationPolyline.setEndPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationPolyline#FDFAnnotationPolyline()} EndPointEndingStyle is {@code
   *       None}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setEndPointEndingStyle(String); then FDFAnnotationPolyline() EndPointEndingStyle is 'None'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolyline.setEndPointEndingStyle(String)"})
  void testSetEndPointEndingStyle_thenFDFAnnotationPolylineEndPointEndingStyleIsNone() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setEndPointEndingStyle(null);

    // Assert
    assertEquals("None", fdfAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationPolyline#FDFAnnotationPolyline()} EndPointEndingStyle is {@code
   *       Style}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setEndPointEndingStyle(String); then FDFAnnotationPolyline() EndPointEndingStyle is 'Style'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolyline.setEndPointEndingStyle(String)"})
  void testSetEndPointEndingStyle_thenFDFAnnotationPolylineEndPointEndingStyleIsStyle() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setEndPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getEndPointEndingStyle()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline()} StartPointEndingStyle is
   *       {@code None}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#getEndPointEndingStyle()}
   */
  @Test
  @DisplayName(
      "Test getEndPointEndingStyle(); given FDFAnnotationPolyline() StartPointEndingStyle is 'None'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationPolyline.getEndPointEndingStyle()"})
  void testGetEndPointEndingStyle_givenFDFAnnotationPolylineStartPointEndingStyleIsNone() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    fdfAnnotationPolyline.setStartPointEndingStyle("None");

    // Act and Assert
    assertEquals("None", fdfAnnotationPolyline.getEndPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getEndPointEndingStyle()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}.
   *   <li>Then return {@code None}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#getEndPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getEndPointEndingStyle(); given FDFAnnotationPolyline(); then return 'None'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationPolyline.getEndPointEndingStyle()"})
  void testGetEndPointEndingStyle_givenFDFAnnotationPolyline_thenReturnNone() {
    // Arrange, Act and Assert
    assertEquals("None", new FDFAnnotationPolyline().getEndPointEndingStyle());
  }

  /**
   * Test {@link FDFAnnotationPolyline#setInteriorColor(Color)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSBase)} does nothing.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#setInteriorColor(Color)}
   */
  @Test
  @DisplayName(
      "Test setInteriorColor(Color); given COSDictionary setItem(COSName, COSBase) does nothing; then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationPolyline.setInteriorColor(Color)"})
  void testSetInteriorColor_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary a = mock(COSDictionary.class);
    doNothing().when(a).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    // Act
    new FDFAnnotationPolyline(a).setInteriorColor(null);

    // Assert
    verify(a).setItem(isA(COSName.class), (COSBase) isNull());
  }

  /**
   * Test {@link FDFAnnotationPolyline#getInteriorColor()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationPolyline#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); given FDFAnnotationPolyline(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color FDFAnnotationPolyline.getInteriorColor()"})
  void testGetInteriorColor_givenFDFAnnotationPolyline_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationPolyline().getInteriorColor());
  }
}
