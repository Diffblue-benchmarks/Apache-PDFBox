package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.Element;

class FDFAnnotationSquareDiffblueTest {
  /**
   * Test {@link FDFAnnotationSquare#FDFAnnotationSquare(COSDictionary)}.
   *
   * <p>Method under test: {@link FDFAnnotationSquare#FDFAnnotationSquare(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationSquare(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationSquare.<init>(COSDictionary)"})
  void testNewFDFAnnotationSquare() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new FDFAnnotationSquare(a).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationSquare#FDFAnnotationSquare()}.
   *
   * <p>Method under test: {@link FDFAnnotationSquare#FDFAnnotationSquare()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationSquare()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationSquare.<init>()"})
  void testNewFDFAnnotationSquare2() throws IOException {
    // Arrange and Act
    FDFAnnotationSquare actualFdfAnnotationSquare = new FDFAnnotationSquare();

    // Assert
    assertEquals("", actualFdfAnnotationSquare.getRichContents());
    assertNull(actualFdfAnnotationSquare.getColor());
    assertNull(actualFdfAnnotationSquare.getInteriorColor());
    assertNull(actualFdfAnnotationSquare.getPage());
    assertNull(actualFdfAnnotationSquare.getContents());
    assertNull(actualFdfAnnotationSquare.getDate());
    assertNull(actualFdfAnnotationSquare.getIntent());
    assertNull(actualFdfAnnotationSquare.getName());
    assertNull(actualFdfAnnotationSquare.getSubject());
    assertNull(actualFdfAnnotationSquare.getTitle());
    assertNull(actualFdfAnnotationSquare.getCreationDate());
    assertNull(actualFdfAnnotationSquare.getRectangle());
    assertNull(actualFdfAnnotationSquare.getFringe());
    assertNull(actualFdfAnnotationSquare.getBorderEffect());
    assertNull(actualFdfAnnotationSquare.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationSquare.getOpacity());
    assertFalse(actualFdfAnnotationSquare.isHidden());
    assertFalse(actualFdfAnnotationSquare.isInvisible());
    assertFalse(actualFdfAnnotationSquare.isLocked());
    assertFalse(actualFdfAnnotationSquare.isLockedContents());
    assertFalse(actualFdfAnnotationSquare.isNoRotate());
    assertFalse(actualFdfAnnotationSquare.isNoView());
    assertFalse(actualFdfAnnotationSquare.isNoZoom());
    assertFalse(actualFdfAnnotationSquare.isPrinted());
    assertFalse(actualFdfAnnotationSquare.isReadOnly());
    assertFalse(actualFdfAnnotationSquare.isToggleNoView());
  }

  /**
   * Test {@link FDFAnnotationSquare#FDFAnnotationSquare(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationSquare#FDFAnnotationSquare(Element)}
   */
  @Test
  @DisplayName(
      "Test new FDFAnnotationSquare(Element); when IIOMetadataNode(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationSquare.<init>(Element)"})
  void testNewFDFAnnotationSquare_whenIIOMetadataNode_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new FDFAnnotationSquare(new IIOMetadataNode()));
  }

  /**
   * Test {@link FDFAnnotationSquare#setInteriorColor(Color)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSBase)} does nothing.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationSquare#setInteriorColor(Color)}
   */
  @Test
  @DisplayName(
      "Test setInteriorColor(Color); given COSDictionary setItem(COSName, COSBase) does nothing; then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationSquare.setInteriorColor(Color)"})
  void testSetInteriorColor_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary a = mock(COSDictionary.class);
    doNothing().when(a).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    // Act
    new FDFAnnotationSquare(a).setInteriorColor(null);

    // Assert
    verify(a).setItem(isA(COSName.class), (COSBase) isNull());
  }

  /**
   * Test {@link FDFAnnotationSquare#getInteriorColor()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationSquare#FDFAnnotationSquare()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationSquare#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor(); given FDFAnnotationSquare(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color FDFAnnotationSquare.getInteriorColor()"})
  void testGetInteriorColor_givenFDFAnnotationSquare_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationSquare().getInteriorColor());
  }

  /**
   * Test {@link FDFAnnotationSquare#setFringe(PDRectangle)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationSquare#FDFAnnotationSquare()} Fringe LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationSquare#setFringe(PDRectangle)}
   */
  @Test
  @DisplayName("Test setFringe(PDRectangle); then FDFAnnotationSquare() Fringe LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationSquare.setFringe(PDRectangle)"})
  void testSetFringe_thenFDFAnnotationSquareFringeLowerLeftXIsZero() {
    // Arrange
    FDFAnnotationSquare fdfAnnotationSquare = new FDFAnnotationSquare();

    // Act
    fdfAnnotationSquare.setFringe(PDRectangle.A0);

    // Assert
    PDRectangle fringe = fdfAnnotationSquare.getFringe();
    assertEquals(0.0f, fringe.getLowerLeftX());
    assertEquals(0.0f, fringe.getLowerLeftY());
    assertEquals(2383.937f, fringe.getUpperRightX());
    assertEquals(2383.937f, fringe.getWidth());
    COSDictionary cOSObject = fdfAnnotationSquare.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3370.3938f, fringe.getHeight());
    assertEquals(3370.3938f, fringe.getUpperRightY());
    COSArray expectedCOSObject = fringe.getCOSArray();
    assertSame(expectedCOSObject, fringe.getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationSquare#setFringe(PDRectangle)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationSquare#FDFAnnotationSquare()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationSquare#setFringe(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setFringe(PDRectangle); when 'null'; then FDFAnnotationSquare() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationSquare.setFringe(PDRectangle)"})
  void testSetFringe_whenNull_thenFDFAnnotationSquareCOSObjectValuesSizeIsTwo() {
    // Arrange
    FDFAnnotationSquare fdfAnnotationSquare = new FDFAnnotationSquare();

    // Act
    fdfAnnotationSquare.setFringe(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfAnnotationSquare.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationSquare#getFringe()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationSquare#FDFAnnotationSquare()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationSquare#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); given FDFAnnotationSquare(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle FDFAnnotationSquare.getFringe()"})
  void testGetFringe_givenFDFAnnotationSquare_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationSquare().getFringe());
  }

  /**
   * Test {@link FDFAnnotationSquare#getFringe()}.
   *
   * <ul>
   *   <li>Then return COSArray toList third Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationSquare#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); then return COSArray toList third Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle FDFAnnotationSquare.getFringe()"})
  void testGetFringe_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    FDFAnnotationSquare fdfAnnotationSquare = new FDFAnnotationSquare();
    fdfAnnotationSquare.setFringe(PDRectangle.A0);

    // Act
    PDRectangle actualFringe = fdfAnnotationSquare.getFringe();

    // Assert
    List<? extends COSBase> toListResult = actualFringe.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(0.0f, actualFringe.getLowerLeftX());
    assertEquals(0.0f, actualFringe.getLowerLeftY());
    assertEquals(2383.937f, actualFringe.getUpperRightX());
    assertEquals(2383.937f, actualFringe.getWidth());
    assertEquals(3370.3938f, actualFringe.getHeight());
    assertEquals(3370.3938f, actualFringe.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
  }

  /**
   * Test {@link FDFAnnotationSquare#getFringe()}.
   *
   * <ul>
   *   <li>Then return Height is zero.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationSquare#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); then return Height is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle FDFAnnotationSquare.getFringe()"})
  void testGetFringe_thenReturnHeightIsZero() {
    // Arrange
    FDFAnnotationSquare fdfAnnotationSquare = new FDFAnnotationSquare();
    PDRectangle fringe =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    fdfAnnotationSquare.setFringe(fringe);

    // Act
    PDRectangle actualFringe = fdfAnnotationSquare.getFringe();

    // Assert
    List<? extends COSBase> toListResult = actualFringe.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(0.0f, actualFringe.getHeight());
    assertEquals(0.0f, actualFringe.getWidth());
    assertEquals(2.14748365E9f, actualFringe.getLowerLeftX());
    assertEquals(2.14748365E9f, actualFringe.getLowerLeftY());
    assertEquals(2.14748365E9f, actualFringe.getUpperRightX());
    assertEquals(2.14748365E9f, actualFringe.getUpperRightY());
    COSBase getResult3 = toListResult.get(0);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }
}
