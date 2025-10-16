package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationDiffblueTest {
  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSName#A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName(
      "Test createAnnotation(COSBase); given A; when COSArray() add A; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAnnotation.createAnnotation(COSBase)"})
  void testCreateAnnotation_givenA_whenCOSArrayAddA_thenThrowIOException() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add(COSName.A);

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName(
      "Test createAnnotation(COSBase); given COSDictionary(); when COSArray() add COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAnnotation.createAnnotation(COSBase)"})
  void testCreateAnnotation_givenCOSDictionary_whenCOSArrayAddCOSDictionary() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add((COSBase) new COSDictionary());

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); given COSStream(); when COSArray() add COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAnnotation.createAnnotation(COSBase)"})
  void testCreateAnnotation_givenCOSStream_whenCOSArrayAddCOSStream() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add((COSBase) new COSStream());

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName(
      "Test createAnnotation(COSBase); given FALSE; when COSArray() add FALSE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAnnotation.createAnnotation(COSBase)"})
  void testCreateAnnotation_givenFalse_whenCOSArrayAddFalse_thenThrowIOException()
      throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName(
      "Test createAnnotation(COSBase); given FALSE; when COSArray() add FALSE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAnnotation.createAnnotation(COSBase)"})
  void testCreateAnnotation_givenFalse_whenCOSArrayAddFalse_thenThrowIOException2()
      throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add(COSBoolean.FALSE);
    base.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName(
      "Test createAnnotation(COSBase); given ONE; when COSArray() add ONE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAnnotation.createAnnotation(COSBase)"})
  void testCreateAnnotation_givenOne_whenCOSArrayAddOne_thenThrowIOException() throws IOException {
    // Arrange
    COSArray base = new COSArray();
    base.add(COSInteger.ONE);

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); when A; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAnnotation.createAnnotation(COSBase)"})
  void testCreateAnnotation_whenA_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(COSName.A));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); when COSArray(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAnnotation.createAnnotation(COSBase)"})
  void testCreateAnnotation_whenCOSArray_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(new COSArray()));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return {@link PDAnnotationUnknown}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName(
      "Test createAnnotation(COSBase); when COSDictionary(); then return PDAnnotationUnknown")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAnnotation.createAnnotation(COSBase)"})
  void testCreateAnnotation_whenCOSDictionary_thenReturnPDAnnotationUnknown() throws IOException {
    // Arrange
    COSDictionary base = new COSDictionary();

    // Act
    PDAnnotation actualCreateAnnotationResult = PDAnnotation.createAnnotation(base);

    // Assert
    assertTrue(actualCreateAnnotationResult instanceof PDAnnotationUnknown);
    assertNull(actualCreateAnnotationResult.getAnnotationName());
    assertNull(actualCreateAnnotationResult.getContents());
    assertNull(actualCreateAnnotationResult.getModifiedDate());
    assertNull(actualCreateAnnotationResult.getSubtype());
    assertNull(actualCreateAnnotationResult.getAppearanceState());
    assertNull(actualCreateAnnotationResult.getPage());
    assertNull(actualCreateAnnotationResult.getRectangle());
    assertNull(actualCreateAnnotationResult.getOptionalContent());
    assertNull(actualCreateAnnotationResult.getColor());
    assertNull(actualCreateAnnotationResult.getAppearance());
    assertNull(actualCreateAnnotationResult.getNormalAppearanceStream());
    assertEquals(-1, actualCreateAnnotationResult.getStructParent());
    assertEquals(0, actualCreateAnnotationResult.getAnnotationFlags());
    assertEquals(1, base.size());
    assertFalse(actualCreateAnnotationResult.isHidden());
    assertFalse(actualCreateAnnotationResult.isInvisible());
    assertFalse(actualCreateAnnotationResult.isLocked());
    assertFalse(actualCreateAnnotationResult.isLockedContents());
    assertFalse(actualCreateAnnotationResult.isNoRotate());
    assertFalse(actualCreateAnnotationResult.isNoView());
    assertFalse(actualCreateAnnotationResult.isNoZoom());
    assertFalse(actualCreateAnnotationResult.isPrinted());
    assertFalse(actualCreateAnnotationResult.isReadOnly());
    assertFalse(actualCreateAnnotationResult.isToggleNoView());
    assertSame(base, actualCreateAnnotationResult.getCOSObject());
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName(
      "Test createAnnotation(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAnnotation.createAnnotation(COSBase)"})
  void testCreateAnnotation_whenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    COSObject base = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(base));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); when FALSE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAnnotation.createAnnotation(COSBase)"})
  void testCreateAnnotation_whenFalse_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(COSBoolean.FALSE));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSFloat#ONE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); when ONE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAnnotation.createAnnotation(COSBase)"})
  void testCreateAnnotation_whenOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(COSFloat.ONE));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSInteger#ONE}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName("Test createAnnotation(COSBase); when ONE; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAnnotation.createAnnotation(COSBase)"})
  void testCreateAnnotation_whenOne_thenThrowIOException2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDAnnotation.createAnnotation(COSInteger.ONE));
  }

  /**
   * Test {@link PDAnnotation#createAnnotation(COSBase)}.
   *
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#createAnnotation(COSBase)}
   */
  @Test
  @DisplayName(
      "Test createAnnotation(COSBase); when parseHex '0123456789ABCDEF'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAnnotation.createAnnotation(COSBase)"})
  void testCreateAnnotation_whenParseHex0123456789abcdef_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> PDAnnotation.createAnnotation(COSString.parseHex("0123456789ABCDEF")));
  }

  /**
   * Test {@link PDAnnotation#equals(Object)}, and {@link PDAnnotation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDAnnotation#equals(Object)}
   *   <li>{@link PDAnnotation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotation.equals(Object)", "int PDAnnotation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act and Assert
    assertEquals(pdAnnotationCaret, pdAnnotationCaret);
    int expectedHashCodeResult = pdAnnotationCaret.hashCode();
    assertEquals(expectedHashCodeResult, pdAnnotationCaret.hashCode());
  }

  /**
   * Test {@link PDAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotation.equals(Object)", "int PDAnnotation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act and Assert
    assertNotEquals(pdAnnotationCaret, new PDAnnotationCaret());
  }

  /**
   * Test {@link PDAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotation.equals(Object)", "int PDAnnotation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    PDAnnotationCircle pdAnnotationCircle = mock(PDAnnotationCircle.class);
    when(pdAnnotationCircle.getCOSObject()).thenReturn(new COSDictionary());

    // Act and Assert
    assertNotEquals(pdAnnotationCaret, pdAnnotationCircle);
  }

  /**
   * Test {@link PDAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotation.equals(Object)", "int PDAnnotation.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDAnnotationCaret(), null);
  }

  /**
   * Test {@link PDAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotation.equals(Object)", "int PDAnnotation.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDAnnotationCaret(), "Different type to PDAnnotation");
  }

  /**
   * Test {@link PDAnnotation#setSubtype(String)}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} Subtype is {@code Sub Type}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setSubtype(String)}
   */
  @Test
  @DisplayName(
      "Test setSubtype(String); given PDAnnotationCaret(); then PDAnnotationCaret() Subtype is 'Sub Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setSubtype(String)"})
  void testSetSubtype_givenPDAnnotationCaret_thenPDAnnotationCaretSubtypeIsSubType() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setSubtype("Sub Type");

    // Assert
    assertEquals("Sub Type", pdAnnotationCaret.getSubtype());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setSubtype(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret(COSDictionary)} with field is {@link
   *       COSDictionary#COSDictionary()} Subtype is {@code Sub Type}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setSubtype(String)}
   */
  @Test
  @DisplayName(
      "Test setSubtype(String); then PDAnnotationCaret(COSDictionary) with field is COSDictionary() Subtype is 'Sub Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setSubtype(String)"})
  void testSetSubtype_thenPDAnnotationCaretWithFieldIsCOSDictionarySubtypeIsSubType() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(new COSDictionary());

    // Act
    pdAnnotationCaret.setSubtype("Sub Type");

    // Assert
    assertEquals("Sub Type", pdAnnotationCaret.getSubtype());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setSubtype(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} Subtype is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setSubtype(String)}
   */
  @Test
  @DisplayName("Test setSubtype(String); when 'null'; then PDAnnotationCaret() Subtype is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setSubtype(String)"})
  void testSetSubtype_whenNull_thenPDAnnotationCaretSubtypeIsNull() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setSubtype(null);

    // Assert
    assertNull(pdAnnotationCaret.getSubtype());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#getSubtype()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret(COSDictionary)} with field is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getSubtype()}
   */
  @Test
  @DisplayName(
      "Test getSubtype(); given PDAnnotationCaret(COSDictionary) with field is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotation.getSubtype()"})
  void testGetSubtype_givenPDAnnotationCaretWithFieldIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationCaret(new COSDictionary()).getSubtype());
  }

  /**
   * Test {@link PDAnnotation#getSubtype()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.
   *   <li>Then return {@link PDAnnotationCaret#SUB_TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getSubtype()}
   */
  @Test
  @DisplayName("Test getSubtype(); given PDAnnotationCaret(); then return SUB_TYPE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotation.getSubtype()"})
  void testGetSubtype_givenPDAnnotationCaret_thenReturnSub_type() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationCaret.SUB_TYPE, new PDAnnotationCaret().getSubtype());
  }

  /**
   * Test {@link PDAnnotation#getRectangle()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); given PDAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDAnnotation.getRectangle()"})
  void testGetRectangle_givenPDAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationCaret().getRectangle());
  }

  /**
   * Test {@link PDAnnotation#getRectangle()}.
   *
   * <ul>
   *   <li>Then return COSArray toList third Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return COSArray toList third Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDAnnotation.getRectangle()"})
  void testGetRectangle_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setRectangle(PDRectangle.A0);

    // Act
    PDRectangle actualRectangle = pdAnnotationCaret.getRectangle();

    // Assert
    List<? extends COSBase> toListResult = actualRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(0.0f, actualRectangle.getLowerLeftX());
    assertEquals(0.0f, actualRectangle.getLowerLeftY());
    assertEquals(2383.937f, actualRectangle.getUpperRightX());
    assertEquals(2383.937f, actualRectangle.getWidth());
    assertEquals(3370.3938f, actualRectangle.getHeight());
    assertEquals(3370.3938f, actualRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
  }

  /**
   * Test {@link PDAnnotation#getRectangle()}.
   *
   * <ul>
   *   <li>Then return Height is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return Height is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDAnnotation.getRectangle()"})
  void testGetRectangle_thenReturnHeightIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    PDRectangle rectangle =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    pdAnnotationCaret.setRectangle(rectangle);

    // Act
    PDRectangle actualRectangle = pdAnnotationCaret.getRectangle();

    // Assert
    List<? extends COSBase> toListResult = actualRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(0.0f, actualRectangle.getHeight());
    assertEquals(0.0f, actualRectangle.getWidth());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftX());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftY());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightX());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightY());
    COSBase getResult3 = toListResult.get(0);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }

  /**
   * Test {@link PDAnnotation#setRectangle(PDRectangle)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} COSObject toIncrement Objects size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setRectangle(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setRectangle(PDRectangle); then PDAnnotationCaret() COSObject toIncrement Objects size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setRectangle(PDRectangle)"})
  void testSetRectangle_thenPDAnnotationCaretCOSObjectToIncrementObjectsSizeIsOne() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setRectangle(PDRectangle.LETTER);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertEquals(1, toIncrementResult.getObjects().size());
    Iterator<COSBase> iteratorResult = toIncrementResult.iterator();
    COSBase actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(cOSObject, actualNextResult);
    PDRectangle rectangle = pdAnnotationCaret.getRectangle();
    assertEquals(792.0f, rectangle.getHeight());
    assertEquals(612.0f, rectangle.getUpperRightX());
    assertEquals(792.0f, rectangle.getUpperRightY());
    assertEquals(612.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDAnnotation#getAnnotationFlags()}.
   *
   * <p>Method under test: {@link PDAnnotation#getAnnotationFlags()}
   */
  @Test
  @DisplayName("Test getAnnotationFlags()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDAnnotation.getAnnotationFlags()"})
  void testGetAnnotationFlags() {
    // Arrange, Act and Assert
    assertEquals(0, new PDAnnotationCaret().getAnnotationFlags());
  }

  /**
   * Test {@link PDAnnotation#setAnnotationFlags(int)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is {@code
   *       -1810807491}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setAnnotationFlags(int)}
   */
  @Test
  @DisplayName(
      "Test setAnnotationFlags(int); then PDAnnotationCaret() AnnotationFlags is '-1810807491'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setAnnotationFlags(int)"})
  void testSetAnnotationFlags_thenPDAnnotationCaretAnnotationFlagsIs1810807491() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAnnotationFlags(-1810807491);

    // Assert
    assertEquals(-1810807491, pdAnnotationCaret.getAnnotationFlags());
    assertTrue(pdAnnotationCaret.isNoRotate());
    assertTrue(pdAnnotationCaret.isNoView());
    assertTrue(pdAnnotationCaret.isNoZoom());
    assertTrue(pdAnnotationCaret.isToggleNoView());
  }

  /**
   * Test {@link PDAnnotation#setAnnotationFlags(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setAnnotationFlags(int)}
   */
  @Test
  @DisplayName(
      "Test setAnnotationFlags(int); when one; then PDAnnotationCaret() AnnotationFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setAnnotationFlags(int)"})
  void testSetAnnotationFlags_whenOne_thenPDAnnotationCaretAnnotationFlagsIsOne() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAnnotationFlags(1);

    // Assert
    assertEquals(1, pdAnnotationCaret.getAnnotationFlags());
    assertFalse(pdAnnotationCaret.isHidden());
    assertFalse(pdAnnotationCaret.isNoRotate());
    assertFalse(pdAnnotationCaret.isNoView());
    assertFalse(pdAnnotationCaret.isNoZoom());
    assertFalse(pdAnnotationCaret.isPrinted());
    assertFalse(pdAnnotationCaret.isToggleNoView());
  }

  /**
   * Test {@link PDAnnotation#setAnnotationFlags(int)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is seven.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setAnnotationFlags(int)}
   */
  @Test
  @DisplayName(
      "Test setAnnotationFlags(int); when seven; then PDAnnotationCaret() AnnotationFlags is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setAnnotationFlags(int)"})
  void testSetAnnotationFlags_whenSeven_thenPDAnnotationCaretAnnotationFlagsIsSeven() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAnnotationFlags(7);

    // Assert
    assertEquals(7, pdAnnotationCaret.getAnnotationFlags());
    assertFalse(pdAnnotationCaret.isNoRotate());
    assertFalse(pdAnnotationCaret.isNoView());
    assertFalse(pdAnnotationCaret.isNoZoom());
    assertFalse(pdAnnotationCaret.isToggleNoView());
    assertTrue(pdAnnotationCaret.isHidden());
    assertTrue(pdAnnotationCaret.isPrinted());
  }

  /**
   * Test {@link PDAnnotation#getCOSObject()}.
   *
   * <p>Method under test: {@link PDAnnotation#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDAnnotation.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDAnnotationCaret().getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(2, actualCOSObject.getValues().size());
    assertEquals(2, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDAnnotation#getAppearanceState()}.
   *
   * <p>Method under test: {@link PDAnnotation#getAppearanceState()}
   */
  @Test
  @DisplayName("Test getAppearanceState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDAnnotation.getAppearanceState()"})
  void testGetAppearanceState() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationCaret().getAppearanceState());
  }

  /**
   * Test {@link PDAnnotation#setAppearanceState(String)}.
   *
   * <p>Method under test: {@link PDAnnotation#setAppearanceState(String)}
   */
  @Test
  @DisplayName("Test setAppearanceState(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setAppearanceState(String)"})
  void testSetAppearanceState() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(new COSDictionary());

    // Act
    pdAnnotationCaret.setAppearanceState("As");

    // Assert
    COSName appearanceState = pdAnnotationCaret.getAppearanceState();
    assertEquals("As", appearanceState.getName());
    assertNull(appearanceState.getKey());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(appearanceState.isDirect());
    assertFalse(appearanceState.isEmpty());
  }

  /**
   * Test {@link PDAnnotation#setAppearanceState(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AppearanceState Name is {@code As}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setAppearanceState(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceState(String); then PDAnnotationCaret() AppearanceState Name is 'As'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setAppearanceState(String)"})
  void testSetAppearanceState_thenPDAnnotationCaretAppearanceStateNameIsAs() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAppearanceState("As");

    // Assert
    COSName appearanceState = pdAnnotationCaret.getAppearanceState();
    assertEquals("As", appearanceState.getName());
    assertNull(appearanceState.getKey());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(appearanceState.isDirect());
    assertFalse(appearanceState.isEmpty());
  }

  /**
   * Test {@link PDAnnotation#setAppearanceState(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setAppearanceState(String)}
   */
  @Test
  @DisplayName(
      "Test setAppearanceState(String); when 'null'; then PDAnnotationCaret() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setAppearanceState(String)"})
  void testSetAppearanceState_whenNull_thenPDAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAppearanceState(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#getAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getAppearance()}
   */
  @Test
  @DisplayName("Test getAppearance(); given PDAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceDictionary PDAnnotation.getAppearance()"})
  void testGetAppearance_givenPDAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationCaret().getAppearance());
  }

  /**
   * Test {@link PDAnnotation#getAppearance()}.
   *
   * <ul>
   *   <li>Then return COSObject Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getAppearance()}
   */
  @Test
  @DisplayName("Test getAppearance(); then return COSObject Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceDictionary PDAnnotation.getAppearance()"})
  void testGetAppearance_thenReturnCOSObjectKeyIsNull() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary());

    // Act
    PDAppearanceDictionary actualAppearance = pdAnnotationCaret.getAppearance();

    // Assert
    COSDictionary cOSObject = actualAppearance.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDAppearanceEntry downAppearance = actualAppearance.getDownAppearance();
    assertFalse(downAppearance.isStream());
    PDAppearanceEntry normalAppearance = actualAppearance.getNormalAppearance();
    assertFalse(normalAppearance.isStream());
    PDAppearanceEntry rolloverAppearance = actualAppearance.getRolloverAppearance();
    assertFalse(rolloverAppearance.isStream());
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    assertTrue(normalAppearance.getSubDictionary().isEmpty());
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(downAppearance.isSubDictionary());
    assertTrue(normalAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isSubDictionary());
  }

  /**
   * Test {@link PDAnnotation#getAppearance()}.
   *
   * <ul>
   *   <li>Then return DownAppearance is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getAppearance()}
   */
  @Test
  @DisplayName("Test getAppearance(); then return DownAppearance is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceDictionary PDAnnotation.getAppearance()"})
  void testGetAppearance_thenReturnDownAppearanceIsNull() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));
    PDAppearanceDictionary appearance = new PDAppearanceDictionary(dictionary);

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(appearance);

    // Act
    PDAppearanceDictionary actualAppearance = pdAnnotationCaret.getAppearance();

    // Assert
    assertNull(actualAppearance.getDownAppearance());
    assertNull(actualAppearance.getNormalAppearance());
    assertNull(actualAppearance.getRolloverAppearance());
    assertSame(dictionary, actualAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}
   */
  @Test
  @DisplayName(
      "Test setAppearance(PDAppearanceDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setAppearance(PDAppearanceDictionary)"})
  void testSetAppearance_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary(dictionary));

    // Assert
    PDAppearanceDictionary appearance = pdAnnotationCaret.getAppearance();
    assertNull(appearance.getDownAppearance());
    assertNull(appearance.getNormalAppearance());
    assertNull(appearance.getRolloverAppearance());
    assertSame(dictionary, appearance.getCOSObject());
  }

  /**
   * Test {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}
   */
  @Test
  @DisplayName(
      "Test setAppearance(PDAppearanceDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setAppearance(PDAppearanceDictionary)"})
  void testSetAppearance_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setDirect(true);

    // Act
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary(dictionary));

    // Assert
    PDAppearanceDictionary appearance = pdAnnotationCaret.getAppearance();
    assertNull(appearance.getDownAppearance());
    assertNull(appearance.getNormalAppearance());
    assertNull(appearance.getRolloverAppearance());
    assertSame(dictionary, appearance.getCOSObject());
  }

  /**
   * Test {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}.
   *
   * <ul>
   *   <li>Then not {@link PDAnnotationCaret#PDAnnotationCaret()} Appearance DownAppearance Stream.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}
   */
  @Test
  @DisplayName(
      "Test setAppearance(PDAppearanceDictionary); then not PDAnnotationCaret() Appearance DownAppearance Stream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setAppearance(PDAppearanceDictionary)"})
  void testSetAppearance_thenNotPDAnnotationCaretAppearanceDownAppearanceStream() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary());

    // Assert
    PDAppearanceDictionary appearance = pdAnnotationCaret.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    assertFalse(downAppearance.isStream());
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    assertFalse(normalAppearance.isStream());
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    assertFalse(rolloverAppearance.isStream());
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    assertTrue(normalAppearance.getSubDictionary().isEmpty());
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(downAppearance.isSubDictionary());
    assertTrue(normalAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isSubDictionary());
  }

  /**
   * Test {@link PDAnnotation#getNormalAppearanceStream()}.
   *
   * <p>Method under test: {@link PDAnnotation#getNormalAppearanceStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceStream PDAnnotation.getNormalAppearanceStream()"})
  void testGetNormalAppearanceStream() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary());

    // Act and Assert
    assertNull(pdAnnotationCaret.getNormalAppearanceStream());
  }

  /**
   * Test {@link PDAnnotation#getNormalAppearanceStream()}.
   *
   * <p>Method under test: {@link PDAnnotation#getNormalAppearanceStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceStream PDAnnotation.getNormalAppearanceStream()"})
  void testGetNormalAppearanceStream2() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(new PDAppearanceDictionary(new COSDictionary()));

    // Act and Assert
    assertNull(pdAnnotationCaret.getNormalAppearanceStream());
  }

  /**
   * Test {@link PDAnnotation#getNormalAppearanceStream()}.
   *
   * <p>Method under test: {@link PDAnnotation#getNormalAppearanceStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceStream PDAnnotation.getNormalAppearanceStream()"})
  void testGetNormalAppearanceStream3() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));
    PDAppearanceDictionary appearance = new PDAppearanceDictionary(dictionary);

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(appearance);

    // Act and Assert
    assertNull(pdAnnotationCaret.getNormalAppearanceStream());
  }

  /**
   * Test {@link PDAnnotation#getNormalAppearanceStream()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getNormalAppearanceStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceStream(); given PDAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceStream PDAnnotation.getNormalAppearanceStream()"})
  void testGetNormalAppearanceStream_givenPDAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationCaret().getNormalAppearanceStream());
  }

  /**
   * Test {@link PDAnnotation#getNormalAppearanceStream()}.
   *
   * <ul>
   *   <li>Then return Resources is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getNormalAppearanceStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceStream(); then return Resources is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceStream PDAnnotation.getNormalAppearanceStream()"})
  void testGetNormalAppearanceStream_thenReturnResourcesIsNull() {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    COSStream stream = new COSStream();
    appearance.setNormalAppearance(new PDAppearanceStream(stream));

    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setAppearance(appearance);

    // Act
    PDAppearanceStream actualNormalAppearanceStream = pdAnnotationCaret.getNormalAppearanceStream();

    // Assert
    assertNull(actualNormalAppearanceStream.getResources());
    assertNull(actualNormalAppearanceStream.getBBox());
    assertNull(actualNormalAppearanceStream.getOptionalContent());
    assertNull(actualNormalAppearanceStream.getGroup());
    assertEquals(-1, actualNormalAppearanceStream.getStructParents());
    assertEquals(1, actualNormalAppearanceStream.getFormType());
    assertSame(stream, actualNormalAppearanceStream.getCOSObject());
  }

  /**
   * Test {@link PDAnnotation#isInvisible()}.
   *
   * <p>Method under test: {@link PDAnnotation#isInvisible()}
   */
  @Test
  @DisplayName("Test isInvisible()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotation.isInvisible()"})
  void testIsInvisible() {
    // Arrange, Act and Assert
    assertFalse(new PDAnnotationCaret().isInvisible());
  }

  /**
   * Test {@link PDAnnotation#setInvisible(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setInvisible(boolean)}
   */
  @Test
  @DisplayName(
      "Test setInvisible(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setInvisible(boolean)"})
  void testSetInvisible_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setInvisible(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isInvisible());
  }

  /**
   * Test {@link PDAnnotation#setInvisible(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setInvisible(boolean)}
   */
  @Test
  @DisplayName(
      "Test setInvisible(boolean); when 'true'; then PDAnnotationCaret() AnnotationFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setInvisible(boolean)"})
  void testSetInvisible_whenTrue_thenPDAnnotationCaretAnnotationFlagsIsOne() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setInvisible(true);

    // Assert
    assertEquals(1, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isInvisible());
  }

  /**
   * Test {@link PDAnnotation#isHidden()}.
   *
   * <p>Method under test: {@link PDAnnotation#isHidden()}
   */
  @Test
  @DisplayName("Test isHidden()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotation.isHidden()"})
  void testIsHidden() {
    // Arrange, Act and Assert
    assertFalse(new PDAnnotationCaret().isHidden());
  }

  /**
   * Test {@link PDAnnotation#setHidden(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setHidden(boolean)}
   */
  @Test
  @DisplayName(
      "Test setHidden(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setHidden(boolean)"})
  void testSetHidden_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setHidden(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isHidden());
  }

  /**
   * Test {@link PDAnnotation#setHidden(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setHidden(boolean)}
   */
  @Test
  @DisplayName(
      "Test setHidden(boolean); when 'true'; then PDAnnotationCaret() AnnotationFlags is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setHidden(boolean)"})
  void testSetHidden_whenTrue_thenPDAnnotationCaretAnnotationFlagsIsTwo() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setHidden(true);

    // Assert
    assertEquals(2, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isHidden());
  }

  /**
   * Test {@link PDAnnotation#isPrinted()}.
   *
   * <p>Method under test: {@link PDAnnotation#isPrinted()}
   */
  @Test
  @DisplayName("Test isPrinted()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotation.isPrinted()"})
  void testIsPrinted() {
    // Arrange, Act and Assert
    assertFalse(new PDAnnotationCaret().isPrinted());
  }

  /**
   * Test {@link PDAnnotation#setPrinted(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setPrinted(boolean)}
   */
  @Test
  @DisplayName(
      "Test setPrinted(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setPrinted(boolean)"})
  void testSetPrinted_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setPrinted(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isPrinted());
  }

  /**
   * Test {@link PDAnnotation#setPrinted(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is four.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setPrinted(boolean)}
   */
  @Test
  @DisplayName(
      "Test setPrinted(boolean); when 'true'; then PDAnnotationCaret() AnnotationFlags is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setPrinted(boolean)"})
  void testSetPrinted_whenTrue_thenPDAnnotationCaretAnnotationFlagsIsFour() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setPrinted(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(4, pdAnnotationCaret.getAnnotationFlags());
    assertTrue(pdAnnotationCaret.isPrinted());
  }

  /**
   * Test {@link PDAnnotation#isNoZoom()}.
   *
   * <p>Method under test: {@link PDAnnotation#isNoZoom()}
   */
  @Test
  @DisplayName("Test isNoZoom()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotation.isNoZoom()"})
  void testIsNoZoom() {
    // Arrange, Act and Assert
    assertFalse(new PDAnnotationCaret().isNoZoom());
  }

  /**
   * Test {@link PDAnnotation#setNoZoom(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setNoZoom(boolean)}
   */
  @Test
  @DisplayName(
      "Test setNoZoom(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setNoZoom(boolean)"})
  void testSetNoZoom_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoZoom(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isNoZoom());
  }

  /**
   * Test {@link PDAnnotation#setNoZoom(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is eight.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setNoZoom(boolean)}
   */
  @Test
  @DisplayName(
      "Test setNoZoom(boolean); when 'true'; then PDAnnotationCaret() AnnotationFlags is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setNoZoom(boolean)"})
  void testSetNoZoom_whenTrue_thenPDAnnotationCaretAnnotationFlagsIsEight() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoZoom(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(8, pdAnnotationCaret.getAnnotationFlags());
    assertTrue(pdAnnotationCaret.isNoZoom());
  }

  /**
   * Test {@link PDAnnotation#isNoRotate()}.
   *
   * <p>Method under test: {@link PDAnnotation#isNoRotate()}
   */
  @Test
  @DisplayName("Test isNoRotate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotation.isNoRotate()"})
  void testIsNoRotate() {
    // Arrange, Act and Assert
    assertFalse(new PDAnnotationCaret().isNoRotate());
  }

  /**
   * Test {@link PDAnnotation#setNoRotate(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setNoRotate(boolean)}
   */
  @Test
  @DisplayName(
      "Test setNoRotate(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setNoRotate(boolean)"})
  void testSetNoRotate_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoRotate(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isNoRotate());
  }

  /**
   * Test {@link PDAnnotation#setNoRotate(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} NoRotate.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setNoRotate(boolean)}
   */
  @Test
  @DisplayName("Test setNoRotate(boolean); when 'true'; then PDAnnotationCaret() NoRotate")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setNoRotate(boolean)"})
  void testSetNoRotate_whenTrue_thenPDAnnotationCaretNoRotate() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoRotate(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isNoRotate());
    assertEquals(Short.SIZE, pdAnnotationCaret.getAnnotationFlags());
  }

  /**
   * Test {@link PDAnnotation#isNoView()}.
   *
   * <p>Method under test: {@link PDAnnotation#isNoView()}
   */
  @Test
  @DisplayName("Test isNoView()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotation.isNoView()"})
  void testIsNoView() {
    // Arrange, Act and Assert
    assertFalse(new PDAnnotationCaret().isNoView());
  }

  /**
   * Test {@link PDAnnotation#setNoView(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setNoView(boolean)}
   */
  @Test
  @DisplayName(
      "Test setNoView(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setNoView(boolean)"})
  void testSetNoView_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoView(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isNoView());
  }

  /**
   * Test {@link PDAnnotation#setNoView(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} NoView.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setNoView(boolean)}
   */
  @Test
  @DisplayName("Test setNoView(boolean); when 'true'; then PDAnnotationCaret() NoView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setNoView(boolean)"})
  void testSetNoView_whenTrue_thenPDAnnotationCaretNoView() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setNoView(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isNoView());
    assertEquals(Integer.SIZE, pdAnnotationCaret.getAnnotationFlags());
  }

  /**
   * Test {@link PDAnnotation#isReadOnly()}.
   *
   * <p>Method under test: {@link PDAnnotation#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotation.isReadOnly()"})
  void testIsReadOnly() {
    // Arrange, Act and Assert
    assertFalse(new PDAnnotationCaret().isReadOnly());
  }

  /**
   * Test {@link PDAnnotation#setReadOnly(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setReadOnly(boolean)}
   */
  @Test
  @DisplayName(
      "Test setReadOnly(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setReadOnly(boolean)"})
  void testSetReadOnly_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setReadOnly(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isReadOnly());
  }

  /**
   * Test {@link PDAnnotation#setReadOnly(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} ReadOnly.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test setReadOnly(boolean); when 'true'; then PDAnnotationCaret() ReadOnly")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setReadOnly(boolean)"})
  void testSetReadOnly_whenTrue_thenPDAnnotationCaretReadOnly() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setReadOnly(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isReadOnly());
    assertEquals(Double.SIZE, pdAnnotationCaret.getAnnotationFlags());
  }

  /**
   * Test {@link PDAnnotation#isLocked()}.
   *
   * <p>Method under test: {@link PDAnnotation#isLocked()}
   */
  @Test
  @DisplayName("Test isLocked()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotation.isLocked()"})
  void testIsLocked() {
    // Arrange, Act and Assert
    assertFalse(new PDAnnotationCaret().isLocked());
  }

  /**
   * Test {@link PDAnnotation#setLocked(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is one hundred
   *       twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setLocked(boolean)}
   */
  @Test
  @DisplayName(
      "Test setLocked(boolean); then PDAnnotationCaret() AnnotationFlags is one hundred twenty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setLocked(boolean)"})
  void testSetLocked_thenPDAnnotationCaretAnnotationFlagsIsOneHundredTwentyEight() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setLocked(true);

    // Assert
    assertEquals(128, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isLocked());
  }

  /**
   * Test {@link PDAnnotation#setLocked(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setLocked(boolean)}
   */
  @Test
  @DisplayName(
      "Test setLocked(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setLocked(boolean)"})
  void testSetLocked_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setLocked(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isLocked());
  }

  /**
   * Test {@link PDAnnotation#isToggleNoView()}.
   *
   * <p>Method under test: {@link PDAnnotation#isToggleNoView()}
   */
  @Test
  @DisplayName("Test isToggleNoView()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotation.isToggleNoView()"})
  void testIsToggleNoView() {
    // Arrange, Act and Assert
    assertFalse(new PDAnnotationCaret().isToggleNoView());
  }

  /**
   * Test {@link PDAnnotation#setToggleNoView(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is two hundred
   *       fifty-six.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setToggleNoView(boolean)}
   */
  @Test
  @DisplayName(
      "Test setToggleNoView(boolean); then PDAnnotationCaret() AnnotationFlags is two hundred fifty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setToggleNoView(boolean)"})
  void testSetToggleNoView_thenPDAnnotationCaretAnnotationFlagsIsTwoHundredFiftySix() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setToggleNoView(true);

    // Assert
    assertEquals(256, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationCaret.isToggleNoView());
  }

  /**
   * Test {@link PDAnnotation#setToggleNoView(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setToggleNoView(boolean)}
   */
  @Test
  @DisplayName(
      "Test setToggleNoView(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setToggleNoView(boolean)"})
  void testSetToggleNoView_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setToggleNoView(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isToggleNoView());
  }

  /**
   * Test {@link PDAnnotation#isLockedContents()}.
   *
   * <p>Method under test: {@link PDAnnotation#isLockedContents()}
   */
  @Test
  @DisplayName("Test isLockedContents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotation.isLockedContents()"})
  void testIsLockedContents() {
    // Arrange, Act and Assert
    assertFalse(new PDAnnotationCaret().isLockedContents());
  }

  /**
   * Test {@link PDAnnotation#setLockedContents(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is five hundred
   *       twelve.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setLockedContents(boolean)}
   */
  @Test
  @DisplayName(
      "Test setLockedContents(boolean); then PDAnnotationCaret() AnnotationFlags is five hundred twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setLockedContents(boolean)"})
  void testSetLockedContents_thenPDAnnotationCaretAnnotationFlagsIsFiveHundredTwelve() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setLockedContents(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(512, pdAnnotationCaret.getAnnotationFlags());
    assertTrue(pdAnnotationCaret.isLockedContents());
  }

  /**
   * Test {@link PDAnnotation#setLockedContents(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setLockedContents(boolean)}
   */
  @Test
  @DisplayName(
      "Test setLockedContents(boolean); when 'false'; then PDAnnotationCaret() AnnotationFlags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setLockedContents(boolean)"})
  void testSetLockedContents_whenFalse_thenPDAnnotationCaretAnnotationFlagsIsZero() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setLockedContents(false);

    // Assert
    assertEquals(0, pdAnnotationCaret.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationCaret.isLockedContents());
  }

  /**
   * Test {@link PDAnnotation#getContents()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()} Contents is {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDAnnotationCaret() Contents is '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotation.getContents()"})
  void testGetContents_givenPDAnnotationCaretContentsIs42_thenReturn42() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setContents("42");

    // Act and Assert
    assertEquals("42", pdAnnotationCaret.getContents());
  }

  /**
   * Test {@link PDAnnotation#getContents()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given PDAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotation.getContents()"})
  void testGetContents_givenPDAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationCaret().getContents());
  }

  /**
   * Test {@link PDAnnotation#getContents()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotation.getContents()"})
  void testGetContents_thenReturnEmptyString() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    pdAnnotationCaret.setContents("");

    // Act and Assert
    assertEquals("", pdAnnotationCaret.getContents());
  }

  /**
   * Test {@link PDAnnotation#setContents(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} Contents is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setContents(String)}
   */
  @Test
  @DisplayName("Test setContents(String); when '42'; then PDAnnotationCaret() Contents is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setContents(String)"})
  void testSetContents_when42_thenPDAnnotationCaretContentsIs42() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setContents("42");

    // Assert
    assertEquals("42", pdAnnotationCaret.getContents());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setContents(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setContents(String)}
   */
  @Test
  @DisplayName(
      "Test setContents(String); when 'null'; then PDAnnotationCaret() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setContents(String)"})
  void testSetContents_whenNull_thenPDAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setContents(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#getModifiedDate()}.
   *
   * <p>Method under test: {@link PDAnnotation#getModifiedDate()}
   */
  @Test
  @DisplayName("Test getModifiedDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotation.getModifiedDate()"})
  void testGetModifiedDate() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationCaret().getModifiedDate());
  }

  /**
   * Test {@link PDAnnotation#setModifiedDate(Calendar)} with {@code c}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setModifiedDate(Calendar)}
   */
  @Test
  @DisplayName(
      "Test setModifiedDate(Calendar) with 'c'; then PDAnnotationCaret() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setModifiedDate(Calendar)"})
  void testSetModifiedDateWithC_thenPDAnnotationCaretCOSObjectValuesSizeIsThree() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setModifiedDate(new GregorianCalendar(1, 1, 1));

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setModifiedDate(Calendar)} with {@code c}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setModifiedDate(Calendar)}
   */
  @Test
  @DisplayName(
      "Test setModifiedDate(Calendar) with 'c'; when 'null'; then PDAnnotationCaret() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setModifiedDate(Calendar)"})
  void testSetModifiedDateWithC_whenNull_thenPDAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setModifiedDate((Calendar) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setModifiedDate(String)} with {@code m}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} ModifiedDate is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setModifiedDate(String)}
   */
  @Test
  @DisplayName(
      "Test setModifiedDate(String) with 'm'; when 'foo'; then PDAnnotationCaret() ModifiedDate is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setModifiedDate(String)"})
  void testSetModifiedDateWithM_whenFoo_thenPDAnnotationCaretModifiedDateIsFoo() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setModifiedDate("foo");

    // Assert
    assertEquals("foo", pdAnnotationCaret.getModifiedDate());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setModifiedDate(String)} with {@code m}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setModifiedDate(String)}
   */
  @Test
  @DisplayName(
      "Test setModifiedDate(String) with 'm'; when 'null'; then PDAnnotationCaret() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setModifiedDate(String)"})
  void testSetModifiedDateWithM_whenNull_thenPDAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setModifiedDate((String) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#getAnnotationName()}.
   *
   * <p>Method under test: {@link PDAnnotation#getAnnotationName()}
   */
  @Test
  @DisplayName("Test getAnnotationName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotation.getAnnotationName()"})
  void testGetAnnotationName() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationCaret().getAnnotationName());
  }

  /**
   * Test {@link PDAnnotation#setAnnotationName(String)}.
   *
   * <ul>
   *   <li>When {@code Nm}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} AnnotationName is {@code Nm}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setAnnotationName(String)}
   */
  @Test
  @DisplayName(
      "Test setAnnotationName(String); when 'Nm'; then PDAnnotationCaret() AnnotationName is 'Nm'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setAnnotationName(String)"})
  void testSetAnnotationName_whenNm_thenPDAnnotationCaretAnnotationNameIsNm() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAnnotationName("Nm");

    // Assert
    assertEquals("Nm", pdAnnotationCaret.getAnnotationName());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setAnnotationName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setAnnotationName(String)}
   */
  @Test
  @DisplayName(
      "Test setAnnotationName(String); when 'null'; then PDAnnotationCaret() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setAnnotationName(String)"})
  void testSetAnnotationName_whenNull_thenPDAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setAnnotationName(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#getStructParent()}.
   *
   * <p>Method under test: {@link PDAnnotation#getStructParent()}
   */
  @Test
  @DisplayName("Test getStructParent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDAnnotation.getStructParent()"})
  void testGetStructParent() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDAnnotationCaret().getStructParent());
  }

  /**
   * Test {@link PDAnnotation#setStructParent(int)}.
   *
   * <ul>
   *   <li>When {@code -1810807491}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} StructParent is {@code -1810807491}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setStructParent(int)}
   */
  @Test
  @DisplayName(
      "Test setStructParent(int); when '-1810807491'; then PDAnnotationCaret() StructParent is '-1810807491'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setStructParent(int)"})
  void testSetStructParent_when1810807491_thenPDAnnotationCaretStructParentIs1810807491() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setStructParent(-1810807491);

    // Assert
    assertEquals(-1810807491, pdAnnotationCaret.getStructParent());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setStructParent(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} StructParent is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setStructParent(int)}
   */
  @Test
  @DisplayName("Test setStructParent(int); when one; then PDAnnotationCaret() StructParent is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setStructParent(int)"})
  void testSetStructParent_whenOne_thenPDAnnotationCaretStructParentIsOne() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setStructParent(1);

    // Assert
    assertEquals(1, pdAnnotationCaret.getStructParent());
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#getOptionalContent()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getOptionalContent()}
   */
  @Test
  @DisplayName("Test getOptionalContent(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList PDAnnotation.getOptionalContent()"})
  void testGetOptionalContent_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationCaret().getOptionalContent());
  }

  /**
   * Test {@link PDAnnotation#setOptionalContent(PDPropertyList)}.
   *
   * <p>Method under test: {@link PDAnnotation#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setOptionalContent(PDPropertyList)"})
  void testSetOptionalContent() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSDictionary cosDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    cosDictionary.setKey(key);

    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdAnnotationCaret.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    assertSame(key, pdAnnotationCaret.getOptionalContent().getCOSObject().getKey());
  }

  /**
   * Test {@link PDAnnotation#setOptionalContent(PDPropertyList)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList); given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setOptionalContent(PDPropertyList)"})
  void testSetOptionalContent_givenCOSDictionary() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    PDPropertyList oc = mock(PDPropertyList.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdAnnotationCaret.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(cosDictionary, pdAnnotationCaret.getOptionalContent().getCOSObject());
  }

  /**
   * Test {@link PDAnnotation#setOptionalContent(PDPropertyList)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList); given COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setOptionalContent(PDPropertyList)"})
  void testSetOptionalContent_givenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSDictionary cosDictionary = new COSDictionary();
    cosDictionary.setDirect(true);

    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdAnnotationCaret.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(cosDictionary, pdAnnotationCaret.getOptionalContent().getCOSObject());
  }

  /**
   * Test {@link PDAnnotation#setOptionalContent(PDPropertyList)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName(
      "Test setOptionalContent(PDPropertyList); when 'null'; then PDAnnotationCaret() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setOptionalContent(PDPropertyList)"})
  void testSetOptionalContent_whenNull_thenPDAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setOptionalContent(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setBorder(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setBorder(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setBorder(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setBorder(COSArray)"})
  void testSetBorder_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSArray borderArray = new COSArray(new ArrayList<>());
    borderArray.setDirect(false);
    borderArray.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationCaret.setBorder(borderArray);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    List<? extends COSBase> toListResult = pdAnnotationCaret.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertEquals(3, cOSObject.size());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(2));
  }

  /**
   * Test {@link PDAnnotation#setBorder(COSArray)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link COSArray#COSArray(List)} with cosObjectables is {@link ArrayList#ArrayList()}
   *       Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setBorder(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setBorder(COSArray); given 'null'; when COSArray(List) with cosObjectables is ArrayList() Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setBorder(COSArray)"})
  void testSetBorder_givenNull_whenCOSArrayWithCosObjectablesIsArrayListKeyIsNull() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSArray borderArray = new COSArray(new ArrayList<>());
    borderArray.setDirect(false);
    borderArray.setKey(null);

    // Act
    pdAnnotationCaret.setBorder(borderArray);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    List<? extends COSBase> toListResult = pdAnnotationCaret.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertEquals(3, cOSObject.size());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(2));
  }

  /**
   * Test {@link PDAnnotation#setBorder(COSArray)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setBorder(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setBorder(COSArray); when COSArray(); then PDAnnotationCaret() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setBorder(COSArray)"})
  void testSetBorder_whenCOSArray_thenPDAnnotationCaretCOSObjectValuesSizeIsThree() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setBorder(new COSArray());

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    List<? extends COSBase> toListResult = pdAnnotationCaret.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertEquals(3, cOSObject.size());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(2));
  }

  /**
   * Test {@link PDAnnotation#setBorder(COSArray)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} Border toList third {@link
   *       COSInteger}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setBorder(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setBorder(COSArray); when 'null'; then PDAnnotationCaret() Border toList third COSInteger")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setBorder(COSArray)"})
  void testSetBorder_whenNull_thenPDAnnotationCaretBorderToListThirdCOSInteger() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setBorder(null);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = pdAnnotationCaret.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(2) instanceof COSInteger);
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotation#setColor(PDColor)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} Color Pattern.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setColor(PDColor)}
   */
  @Test
  @DisplayName("Test setColor(PDColor); then PDAnnotationCaret() Color Pattern")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setColor(PDColor)"})
  void testSetColor_thenPDAnnotationCaretColorPattern() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setColor(new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Assert
    PDColor color = pdAnnotationCaret.getColor();
    assertTrue(color.isPattern());
    assertArrayEquals(new float[] {0.0f}, color.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotation#setColor(PDColor)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} Color PatternName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setColor(PDColor)}
   */
  @Test
  @DisplayName("Test setColor(PDColor); then PDAnnotationCaret() Color PatternName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setColor(PDColor)"})
  void testSetColor_thenPDAnnotationCaretColorPatternNameIsNull() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    PDColor color = pdAnnotationCaret.getColor();
    assertNull(color.getPatternName());
    assertNull(color.getColorSpace());
    assertFalse(color.isPattern());
    assertArrayEquals(new float[] {}, color.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotation#getColor()}.
   *
   * <p>Method under test: {@link PDAnnotation#getColor()}
   */
  @Test
  @DisplayName("Test getColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColor PDAnnotation.getColor()"})
  void testGetColor() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationCaret().getColor());
  }

  /**
   * Test {@link PDAnnotation#getColor(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getColor(COSName)}
   */
  @Test
  @DisplayName("Test getColor(COSName) with 'COSName'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColor PDAnnotation.getColor(COSName)"})
  void testGetColorWithCOSName_whenA() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationCaret().getColor(COSName.A));
  }

  /**
   * Test {@link PDAnnotation#getColor(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#getColor(COSName)}
   */
  @Test
  @DisplayName("Test getColor(COSName) with 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColor PDAnnotation.getColor(COSName)"})
  void testGetColorWithCOSName_whenNull() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationCaret().getColor(null));
  }

  /**
   * Test {@link PDAnnotation#setPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setPage(PDPage)"})
  void testSetPage_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(1L, 1));
    PDPage page = new PDPage(pageDictionary);

    // Act
    pdAnnotationCaret.setPage(page);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(page, pdAnnotationCaret.getPage());
  }

  /**
   * Test {@link PDAnnotation#setPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setPage(PDPage)"})
  void testSetPage_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setDirect(true);
    PDPage page = new PDPage(pageDictionary);

    // Act
    pdAnnotationCaret.setPage(page);

    // Assert
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(page, pdAnnotationCaret.getPage());
  }

  /**
   * Test {@link PDAnnotation#setPage(PDPage)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationCaret#PDAnnotationCaret()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#setPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test setPage(PDPage); when 'null'; then PDAnnotationCaret() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.setPage(PDPage)"})
  void testSetPage_whenNull_thenPDAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();

    // Act
    pdAnnotationCaret.setPage(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDAnnotation#getPage()}.
   *
   * <p>Method under test: {@link PDAnnotation#getPage()}
   */
  @Test
  @DisplayName("Test getPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDAnnotation.getPage()"})
  void testGetPage() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationCaret().getPage());
  }

  /**
   * Test {@link PDAnnotation#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    pdAnnotationCircle.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationCircle.constructAppearances(new PDDocument());

    // Assert
    PDRectangle rectangle = pdAnnotationCircle.getRectangle();
    assertEquals(-0.5f, rectangle.getLowerLeftX());
    assertEquals(-0.5f, rectangle.getLowerLeftY());
    PDRectangle rectDifference = pdAnnotationCircle.getRectDifference();
    assertEquals(0.0f, rectDifference.getHeight());
    assertEquals(0.0f, rectDifference.getWidth());
    assertEquals(0.5f, rectDifference.getLowerLeftX());
    assertEquals(0.5f, rectDifference.getLowerLeftY());
    assertEquals(0.5f, rectDifference.getUpperRightX());
    assertEquals(0.5f, rectDifference.getUpperRightY());
    assertEquals(2384.437f, rectangle.getUpperRightX());
    assertEquals(2384.937f, rectangle.getWidth());
    assertEquals(3370.8938f, rectangle.getUpperRightY());
    assertEquals(3371.3938f, rectangle.getHeight());
    byte[] byteArray = new byte[51];
    assertEquals(51, pdAnnotationCircle.getNormalAppearanceStream().getContents().read(byteArray));
    assertArrayEquals(
        "1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray);
    assertArrayEquals(
        new float[] {0.5f, 0.5f, 0.5f, 0.5f}, pdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotation#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotation#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument2() throws IOException {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    pdAnnotationFileAttachment.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFileAttachment.constructAppearances(new PDDocument());

    // Assert
    PDRectangle rectangle = pdAnnotationFileAttachment.getRectangle();
    assertEquals(18.0f, rectangle.getHeight());
    assertEquals(18.0f, rectangle.getUpperRightX());
    assertEquals(18.0f, rectangle.getWidth());
    assertEquals(3352.3938f, rectangle.getLowerLeftY());
    byte[] byteArray = new byte[51];
    assertEquals(
        51, pdAnnotationFileAttachment.getNormalAppearanceStream().getContents().read(byteArray));
    assertArrayEquals(
        "13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotation#constructAppearances()}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationCircle#PDAnnotationCircle()} Rectangle LowerLeftX is {@code
   *       -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); then PDAnnotationCircle() Rectangle LowerLeftX is '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.constructAppearances()"})
  void testConstructAppearances_thenPDAnnotationCircleRectangleLowerLeftXIs05() throws IOException {
    // Arrange
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    pdAnnotationCircle.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationCircle.constructAppearances();

    // Assert
    PDRectangle rectangle = pdAnnotationCircle.getRectangle();
    assertEquals(-0.5f, rectangle.getLowerLeftX());
    assertEquals(-0.5f, rectangle.getLowerLeftY());
    PDRectangle rectDifference = pdAnnotationCircle.getRectDifference();
    assertEquals(0.0f, rectDifference.getHeight());
    assertEquals(0.0f, rectDifference.getWidth());
    assertEquals(0.5f, rectDifference.getLowerLeftX());
    assertEquals(0.5f, rectDifference.getLowerLeftY());
    assertEquals(0.5f, rectDifference.getUpperRightX());
    assertEquals(0.5f, rectDifference.getUpperRightY());
    assertEquals(2384.437f, rectangle.getUpperRightX());
    assertEquals(2384.937f, rectangle.getWidth());
    assertEquals(3370.8938f, rectangle.getUpperRightY());
    assertEquals(3371.3938f, rectangle.getHeight());
    byte[] byteArray = new byte[51];
    assertEquals(51, pdAnnotationCircle.getNormalAppearanceStream().getContents().read(byteArray));
    assertArrayEquals(
        "1191.9685 3369.8938 m\n1853.8938 3369.8938 2383.437 ".getBytes("UTF-8"), byteArray);
    assertArrayEquals(
        new float[] {0.5f, 0.5f, 0.5f, 0.5f}, pdAnnotationCircle.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotation#constructAppearances()}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationFileAttachment#PDAnnotationFileAttachment()} Rectangle Height is
   *       eighteen.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotation#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); then PDAnnotationFileAttachment() Rectangle Height is eighteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotation.constructAppearances()"})
  void testConstructAppearances_thenPDAnnotationFileAttachmentRectangleHeightIsEighteen()
      throws IOException {
    // Arrange
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    pdAnnotationFileAttachment.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFileAttachment.constructAppearances();

    // Assert
    PDRectangle rectangle = pdAnnotationFileAttachment.getRectangle();
    assertEquals(18.0f, rectangle.getHeight());
    assertEquals(18.0f, rectangle.getUpperRightX());
    assertEquals(18.0f, rectangle.getWidth());
    assertEquals(3352.3938f, rectangle.getLowerLeftY());
    byte[] byteArray = new byte[51];
    assertEquals(
        51, pdAnnotationFileAttachment.getNormalAppearanceStream().getContents().read(byteArray));
    assertArrayEquals(
        "13.574 9.301 m\n8.926 13.949 l\n7.648 15.227 5.625 15".getBytes("UTF-8"), byteArray);
  }
}
