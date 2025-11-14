package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class FDFAnnotationCaretDiffblueTest {
  /**
   * Test {@link FDFAnnotationCaret#FDFAnnotationCaret(COSDictionary)}.
   *
   * <p>Method under test: {@link FDFAnnotationCaret#FDFAnnotationCaret(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFAnnotationCaret(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationCaret.<init>(COSDictionary)"})
  void testNewFDFAnnotationCaret() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new FDFAnnotationCaret(a).getCOSObject());
  }

  /**
   * Test {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *
   * <p>Method under test: {@link FDFAnnotationCaret#FDFAnnotationCaret()}
   */
  @Test
  @DisplayName("Test new FDFAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationCaret.<init>()"})
  void testNewFDFAnnotationCaret2() throws IOException {
    // Arrange and Act
    FDFAnnotationCaret actualFdfAnnotationCaret = new FDFAnnotationCaret();

    // Assert
    assertEquals("", actualFdfAnnotationCaret.getRichContents());
    assertNull(actualFdfAnnotationCaret.getColor());
    assertNull(actualFdfAnnotationCaret.getPage());
    assertNull(actualFdfAnnotationCaret.getContents());
    assertNull(actualFdfAnnotationCaret.getDate());
    assertNull(actualFdfAnnotationCaret.getIntent());
    assertNull(actualFdfAnnotationCaret.getName());
    assertNull(actualFdfAnnotationCaret.getSubject());
    assertNull(actualFdfAnnotationCaret.getTitle());
    assertNull(actualFdfAnnotationCaret.getSymbol());
    assertNull(actualFdfAnnotationCaret.getCreationDate());
    assertNull(actualFdfAnnotationCaret.getRectangle());
    assertNull(actualFdfAnnotationCaret.getFringe());
    assertNull(actualFdfAnnotationCaret.getBorderEffect());
    assertNull(actualFdfAnnotationCaret.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationCaret.getOpacity());
    assertFalse(actualFdfAnnotationCaret.isHidden());
    assertFalse(actualFdfAnnotationCaret.isInvisible());
    assertFalse(actualFdfAnnotationCaret.isLocked());
    assertFalse(actualFdfAnnotationCaret.isLockedContents());
    assertFalse(actualFdfAnnotationCaret.isNoRotate());
    assertFalse(actualFdfAnnotationCaret.isNoView());
    assertFalse(actualFdfAnnotationCaret.isNoZoom());
    assertFalse(actualFdfAnnotationCaret.isPrinted());
    assertFalse(actualFdfAnnotationCaret.isReadOnly());
    assertFalse(actualFdfAnnotationCaret.isToggleNoView());
  }

  /**
   * Test {@link FDFAnnotationCaret#FDFAnnotationCaret(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationCaret#FDFAnnotationCaret(Element)}
   */
  @Test
  @DisplayName(
      "Test new FDFAnnotationCaret(Element); when IIOMetadataNode(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationCaret.<init>(Element)"})
  void testNewFDFAnnotationCaret_whenIIOMetadataNode_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new FDFAnnotationCaret(new IIOMetadataNode()));
  }

  /**
   * Test {@link FDFAnnotationCaret#setFringe(PDRectangle)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} COSObject toIncrement Objects size
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationCaret#setFringe(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setFringe(PDRectangle); then FDFAnnotationCaret() COSObject toIncrement Objects size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationCaret.setFringe(PDRectangle)"})
  void testSetFringe_thenFDFAnnotationCaretCOSObjectToIncrementObjectsSizeIsOne() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setFringe(PDRectangle.LETTER);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertEquals(1, toIncrementResult.getObjects().size());
    Iterator<COSBase> iteratorResult = toIncrementResult.iterator();
    COSBase actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(cOSObject, actualNextResult);
    PDRectangle fringe = fdfAnnotationCaret.getFringe();
    assertEquals(792.0f, fringe.getHeight());
    assertEquals(612.0f, fringe.getUpperRightX());
    assertEquals(792.0f, fringe.getUpperRightY());
    assertEquals(612.0f, fringe.getWidth());
  }

  /**
   * Test {@link FDFAnnotationCaret#setFringe(PDRectangle)}.
   *
   * <ul>
   *   <li>When {@link PDRectangle#A0}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Fringe UpperRightX is {@code
   *       2383.937}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationCaret#setFringe(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setFringe(PDRectangle); when A0; then FDFAnnotationCaret() Fringe UpperRightX is '2383.937'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationCaret.setFringe(PDRectangle)"})
  void testSetFringe_whenA0_thenFDFAnnotationCaretFringeUpperRightXIs2383937() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setFringe(PDRectangle.A0);

    // Assert
    PDRectangle fringe = fdfAnnotationCaret.getFringe();
    assertEquals(2383.937f, fringe.getUpperRightX());
    assertEquals(2383.937f, fringe.getWidth());
    assertEquals(3370.3938f, fringe.getHeight());
    assertEquals(3370.3938f, fringe.getUpperRightY());
  }

  /**
   * Test {@link FDFAnnotationCaret#setFringe(PDRectangle)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} COSObject toIncrement Objects Empty.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationCaret#setFringe(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setFringe(PDRectangle); when 'null'; then FDFAnnotationCaret() COSObject toIncrement Objects Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationCaret.setFringe(PDRectangle)"})
  void testSetFringe_whenNull_thenFDFAnnotationCaretCOSObjectToIncrementObjectsEmpty() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setFringe(null);

    // Assert that nothing has changed
    COSIncrement toIncrementResult = fdfAnnotationCaret.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFAnnotationCaret#getFringe()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationCaret#getFringe()}
   */
  @Test
  @DisplayName(
      "Test getFringe(); given FDFAnnotationCaret(COSDictionary) with a is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle FDFAnnotationCaret.getFringe()"})
  void testGetFringe_givenFDFAnnotationCaretWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret(new COSDictionary()).getFringe());
  }

  /**
   * Test {@link FDFAnnotationCaret#getFringe()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationCaret#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); given FDFAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle FDFAnnotationCaret.getFringe()"})
  void testGetFringe_givenFDFAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret().getFringe());
  }

  /**
   * Test {@link FDFAnnotationCaret#getFringe()}.
   *
   * <ul>
   *   <li>Then return COSArray toList third Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationCaret#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); then return COSArray toList third Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle FDFAnnotationCaret.getFringe()"})
  void testGetFringe_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setFringe(PDRectangle.A0);

    // Act
    PDRectangle actualFringe = fdfAnnotationCaret.getFringe();

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
   * Test {@link FDFAnnotationCaret#getFringe()}.
   *
   * <ul>
   *   <li>Then return Height is zero.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationCaret#getFringe()}
   */
  @Test
  @DisplayName("Test getFringe(); then return Height is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle FDFAnnotationCaret.getFringe()"})
  void testGetFringe_thenReturnHeightIsZero() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    PDRectangle fringe =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    fdfAnnotationCaret.setFringe(fringe);

    // Act
    PDRectangle actualFringe = fdfAnnotationCaret.getFringe();

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

  /**
   * Test {@link FDFAnnotationCaret#setSymbol(String)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Symbol is {@code None}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationCaret#setSymbol(String)}
   */
  @Test
  @DisplayName(
      "Test setSymbol(String); given FDFAnnotationCaret(); then FDFAnnotationCaret() Symbol is 'None'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationCaret.setSymbol(String)"})
  void testSetSymbol_givenFDFAnnotationCaret_thenFDFAnnotationCaretSymbolIsNone() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setSymbol("Symbol");

    // Assert
    assertEquals("None", fdfAnnotationCaret.getSymbol());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotationCaret#setSymbol(String)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Symbol is {@link
   *       FDFIconFit#SCALE_TYPE_PROPORTIONAL}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationCaret#setSymbol(String)}
   */
  @Test
  @DisplayName(
      "Test setSymbol(String); then FDFAnnotationCaret() Symbol is SCALE_TYPE_PROPORTIONAL")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotationCaret.setSymbol(String)"})
  void testSetSymbol_thenFDFAnnotationCaretSymbolIsScale_type_proportional() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setSymbol("paragraph");

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(FDFIconFit.SCALE_TYPE_PROPORTIONAL, fdfAnnotationCaret.getSymbol());
  }

  /**
   * Test {@link FDFAnnotationCaret#getSymbol()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Symbol is {@code Symbol}.
   *   <li>Then return {@code None}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationCaret#getSymbol()}
   */
  @Test
  @DisplayName(
      "Test getSymbol(); given FDFAnnotationCaret() Symbol is 'Symbol'; then return 'None'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationCaret.getSymbol()"})
  void testGetSymbol_givenFDFAnnotationCaretSymbolIsSymbol_thenReturnNone() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setSymbol("Symbol");

    // Act and Assert
    assertEquals("None", fdfAnnotationCaret.getSymbol());
  }

  /**
   * Test {@link FDFAnnotationCaret#getSymbol()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationCaret#getSymbol()}
   */
  @Test
  @DisplayName(
      "Test getSymbol(); given FDFAnnotationCaret(COSDictionary) with a is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationCaret.getSymbol()"})
  void testGetSymbol_givenFDFAnnotationCaretWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret(new COSDictionary()).getSymbol());
  }

  /**
   * Test {@link FDFAnnotationCaret#getSymbol()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationCaret#getSymbol()}
   */
  @Test
  @DisplayName("Test getSymbol(); given FDFAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationCaret.getSymbol()"})
  void testGetSymbol_givenFDFAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret().getSymbol());
  }

  /**
   * Test {@link FDFAnnotationCaret#getSymbol()}.
   *
   * <ul>
   *   <li>Then return {@link FDFIconFit#SCALE_TYPE_PROPORTIONAL}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotationCaret#getSymbol()}
   */
  @Test
  @DisplayName("Test getSymbol(); then return SCALE_TYPE_PROPORTIONAL")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotationCaret.getSymbol()"})
  void testGetSymbol_thenReturnScale_type_proportional() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setSymbol("paragraph");

    // Act and Assert
    assertEquals(FDFIconFit.SCALE_TYPE_PROPORTIONAL, fdfAnnotationCaret.getSymbol());
  }
}
