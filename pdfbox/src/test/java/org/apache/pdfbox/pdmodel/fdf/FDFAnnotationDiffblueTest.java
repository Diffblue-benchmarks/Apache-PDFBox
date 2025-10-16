package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderEffectDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FDFAnnotationDiffblueTest {
  /**
   * Test {@link FDFAnnotation#create(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#create(COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSDictionary); when COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FDFAnnotation FDFAnnotation.create(COSDictionary)"})
  void testCreate_whenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(FDFAnnotation.create(new COSDictionary()));
  }

  /**
   * Test {@link FDFAnnotation#create(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#create(COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSDictionary); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FDFAnnotation FDFAnnotation.create(COSDictionary)"})
  void testCreate_whenNull() {
    // Arrange, Act and Assert
    assertNull(FDFAnnotation.create(null));
  }

  /**
   * Test {@link FDFAnnotation#getCOSObject()}.
   *
   * <p>Method under test: {@link FDFAnnotation#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary FDFAnnotation.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    COSDictionary actualCOSObject = fdfAnnotationCaret.getCOSObject();

    // Assert
    assertSame(fdfAnnotationCaret.annot, actualCOSObject);
  }

  /**
   * Test {@link FDFAnnotation#getPage()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Page is one.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getPage()}
   */
  @Test
  @DisplayName(
      "Test getPage(); given FDFAnnotationCaret() Page is one; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer FDFAnnotation.getPage()"})
  void testGetPage_givenFDFAnnotationCaretPageIsOne_thenReturnIntValueIsOne() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setPage(1);

    // Act and Assert
    assertEquals(1, fdfAnnotationCaret.getPage().intValue());
  }

  /**
   * Test {@link FDFAnnotation#getPage()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given FDFAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer FDFAnnotation.getPage()"})
  void testGetPage_givenFDFAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret().getPage());
  }

  /**
   * Test {@link FDFAnnotation#setPage(int)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Page intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setPage(int)}
   */
  @Test
  @DisplayName(
      "Test setPage(int); given FDFAnnotationCaret(); then FDFAnnotationCaret() Page intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setPage(int)"})
  void testSetPage_givenFDFAnnotationCaret_thenFDFAnnotationCaretPageIntValueIsOne() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setPage(1);

    // Assert
    assertEquals(1, fdfAnnotationCaret.getPage().intValue());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#setPage(int)}.
   *
   * <ul>
   *   <li>When {@code -1901805651}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Page intValue is {@code
   *       -1901805651}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setPage(int)}
   */
  @Test
  @DisplayName(
      "Test setPage(int); when '-1901805651'; then FDFAnnotationCaret() Page intValue is '-1901805651'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setPage(int)"})
  void testSetPage_when1901805651_thenFDFAnnotationCaretPageIntValueIs1901805651() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setPage(-1901805651);

    // Assert
    assertEquals(-1901805651, fdfAnnotationCaret.getPage().intValue());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#getColor()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getColor()}
   */
  @Test
  @DisplayName("Test getColor(); given FDFAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Color FDFAnnotation.getColor()"})
  void testGetColor_givenFDFAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret().getColor());
  }

  /**
   * Test {@link FDFAnnotation#setColor(Color)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSBase)} does nothing.
   *   <li>When {@code null}.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setColor(Color)}
   */
  @Test
  @DisplayName(
      "Test setColor(Color); given COSDictionary setItem(COSName, COSBase) does nothing; when 'null'; then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setColor(Color)"})
  void testSetColor_givenCOSDictionarySetItemDoesNothing_whenNull_thenCallsSetItem() {
    // Arrange
    COSDictionary a = mock(COSDictionary.class);
    doNothing().when(a).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    // Act
    new FDFAnnotationCaret(a).setColor(null);

    // Assert
    verify(a).setItem(isA(COSName.class), (COSBase) isNull());
  }

  /**
   * Test {@link FDFAnnotation#getDate()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Date is {@code 2020-03-01}.
   *   <li>Then return {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getDate()}
   */
  @Test
  @DisplayName(
      "Test getDate(); given FDFAnnotationCaret() Date is '2020-03-01'; then return '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getDate()"})
  void testGetDate_givenFDFAnnotationCaretDateIs20200301_thenReturn20200301() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setDate("2020-03-01");

    // Act and Assert
    assertEquals("2020-03-01", fdfAnnotationCaret.getDate());
  }

  /**
   * Test {@link FDFAnnotation#getDate()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Date is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getDate()}
   */
  @Test
  @DisplayName(
      "Test getDate(); given FDFAnnotationCaret() Date is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getDate()"})
  void testGetDate_givenFDFAnnotationCaretDateIsEmptyString_thenReturnEmptyString() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setDate("");

    // Act and Assert
    assertEquals("", fdfAnnotationCaret.getDate());
  }

  /**
   * Test {@link FDFAnnotation#getDate()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getDate()}
   */
  @Test
  @DisplayName("Test getDate(); given FDFAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getDate()"})
  void testGetDate_givenFDFAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret().getDate());
  }

  /**
   * Test {@link FDFAnnotation#setDate(String)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Date is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setDate(String)}
   */
  @Test
  @DisplayName(
      "Test setDate(String); given FDFAnnotationCaret(); then FDFAnnotationCaret() Date is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setDate(String)"})
  void testSetDate_givenFDFAnnotationCaret_thenFDFAnnotationCaretDateIs20200301() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setDate("2020-03-01");

    // Assert
    assertEquals("2020-03-01", fdfAnnotationCaret.getDate());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#setDate(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setDate(String)}
   */
  @Test
  @DisplayName(
      "Test setDate(String); when 'null'; then FDFAnnotationCaret() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setDate(String)"})
  void testSetDate_whenNull_thenFDFAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setDate(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#isInvisible()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isInvisible()}
   */
  @Test
  @DisplayName(
      "Test isInvisible(); given FDFAnnotationCaret() Invisible is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isInvisible()"})
  void testIsInvisible_givenFDFAnnotationCaretInvisibleIsTrue_thenReturnTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isInvisible());
  }

  /**
   * Test {@link FDFAnnotation#isInvisible()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isInvisible()}
   */
  @Test
  @DisplayName("Test isInvisible(); given FDFAnnotationCaret(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isInvisible()"})
  void testIsInvisible_givenFDFAnnotationCaret_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FDFAnnotationCaret().isInvisible());
  }

  /**
   * Test {@link FDFAnnotation#setInvisible(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Hidden is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setInvisible(boolean)}
   */
  @Test
  @DisplayName("Test setInvisible(boolean); given FDFAnnotationCaret() Hidden is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setInvisible(boolean)"})
  void testSetInvisible_givenFDFAnnotationCaretHiddenIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setHidden(true);

    // Act
    fdfAnnotationCaret.setInvisible(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isInvisible());
  }

  /**
   * Test {@link FDFAnnotation#setInvisible(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} ToggleNoView is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setInvisible(boolean)}
   */
  @Test
  @DisplayName("Test setInvisible(boolean); given FDFAnnotationCaret() ToggleNoView is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setInvisible(boolean)"})
  void testSetInvisible_givenFDFAnnotationCaretToggleNoViewIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setInvisible(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isInvisible());
  }

  /**
   * Test {@link FDFAnnotation#setInvisible(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setInvisible(boolean)}
   */
  @Test
  @DisplayName(
      "Test setInvisible(boolean); given FDFAnnotationCaret(); then FDFAnnotationCaret() Invisible")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setInvisible(boolean)"})
  void testSetInvisible_givenFDFAnnotationCaret_thenFDFAnnotationCaretInvisible() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setInvisible(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isInvisible());
  }

  /**
   * Test {@link FDFAnnotation#setInvisible(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setInvisible(boolean)}
   */
  @Test
  @DisplayName("Test setInvisible(boolean); when 'false'; then not FDFAnnotationCaret() Invisible")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setInvisible(boolean)"})
  void testSetInvisible_whenFalse_thenNotFDFAnnotationCaretInvisible() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setInvisible(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isInvisible());
  }

  /**
   * Test {@link FDFAnnotation#isHidden()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Hidden is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isHidden()}
   */
  @Test
  @DisplayName("Test isHidden(); given FDFAnnotationCaret() Hidden is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isHidden()"})
  void testIsHidden_givenFDFAnnotationCaretHiddenIsTrue_thenReturnTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setHidden(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isHidden());
  }

  /**
   * Test {@link FDFAnnotation#isHidden()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isHidden()}
   */
  @Test
  @DisplayName(
      "Test isHidden(); given FDFAnnotationCaret() Invisible is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isHidden()"})
  void testIsHidden_givenFDFAnnotationCaretInvisibleIsTrue_thenReturnFalse() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isHidden());
  }

  /**
   * Test {@link FDFAnnotation#isHidden()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isHidden()}
   */
  @Test
  @DisplayName("Test isHidden(); given FDFAnnotationCaret(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isHidden()"})
  void testIsHidden_givenFDFAnnotationCaret_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FDFAnnotationCaret().isHidden());
  }

  /**
   * Test {@link FDFAnnotation#setHidden(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setHidden(boolean)}
   */
  @Test
  @DisplayName("Test setHidden(boolean); given FDFAnnotationCaret() Invisible is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setHidden(boolean)"})
  void testSetHidden_givenFDFAnnotationCaretInvisibleIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setHidden(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isHidden());
  }

  /**
   * Test {@link FDFAnnotation#setHidden(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} NoRotate is {@code true}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Hidden.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setHidden(boolean)}
   */
  @Test
  @DisplayName(
      "Test setHidden(boolean); given FDFAnnotationCaret() NoRotate is 'true'; then FDFAnnotationCaret() Hidden")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setHidden(boolean)"})
  void testSetHidden_givenFDFAnnotationCaretNoRotateIsTrue_thenFDFAnnotationCaretHidden() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setNoRotate(true);
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setHidden(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isHidden());
  }

  /**
   * Test {@link FDFAnnotation#setHidden(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} ToggleNoView is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setHidden(boolean)}
   */
  @Test
  @DisplayName("Test setHidden(boolean); given FDFAnnotationCaret() ToggleNoView is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setHidden(boolean)"})
  void testSetHidden_givenFDFAnnotationCaretToggleNoViewIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setHidden(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isHidden());
  }

  /**
   * Test {@link FDFAnnotation#setHidden(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>When {@code false}.
   *   <li>Then not {@link FDFAnnotationCaret#FDFAnnotationCaret()} Hidden.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setHidden(boolean)}
   */
  @Test
  @DisplayName(
      "Test setHidden(boolean); given FDFAnnotationCaret(); when 'false'; then not FDFAnnotationCaret() Hidden")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setHidden(boolean)"})
  void testSetHidden_givenFDFAnnotationCaret_whenFalse_thenNotFDFAnnotationCaretHidden() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setHidden(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isHidden());
  }

  /**
   * Test {@link FDFAnnotation#setHidden(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>When {@code true}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Hidden.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setHidden(boolean)}
   */
  @Test
  @DisplayName(
      "Test setHidden(boolean); given FDFAnnotationCaret(); when 'true'; then FDFAnnotationCaret() Hidden")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setHidden(boolean)"})
  void testSetHidden_givenFDFAnnotationCaret_whenTrue_thenFDFAnnotationCaretHidden() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setHidden(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isHidden());
  }

  /**
   * Test {@link FDFAnnotation#isPrinted()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isPrinted()}
   */
  @Test
  @DisplayName(
      "Test isPrinted(); given FDFAnnotationCaret() Invisible is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isPrinted()"})
  void testIsPrinted_givenFDFAnnotationCaretInvisibleIsTrue_thenReturnFalse() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isPrinted());
  }

  /**
   * Test {@link FDFAnnotation#isPrinted()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Printed is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isPrinted()}
   */
  @Test
  @DisplayName("Test isPrinted(); given FDFAnnotationCaret() Printed is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isPrinted()"})
  void testIsPrinted_givenFDFAnnotationCaretPrintedIsTrue_thenReturnTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setPrinted(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isPrinted());
  }

  /**
   * Test {@link FDFAnnotation#isPrinted()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isPrinted()}
   */
  @Test
  @DisplayName("Test isPrinted(); given FDFAnnotationCaret(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isPrinted()"})
  void testIsPrinted_givenFDFAnnotationCaret_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FDFAnnotationCaret().isPrinted());
  }

  /**
   * Test {@link FDFAnnotation#setPrinted(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setPrinted(boolean)}
   */
  @Test
  @DisplayName("Test setPrinted(boolean); given FDFAnnotationCaret() Invisible is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setPrinted(boolean)"})
  void testSetPrinted_givenFDFAnnotationCaretInvisibleIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setPrinted(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isPrinted());
  }

  /**
   * Test {@link FDFAnnotation#setPrinted(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} ToggleNoView is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setPrinted(boolean)}
   */
  @Test
  @DisplayName("Test setPrinted(boolean); given FDFAnnotationCaret() ToggleNoView is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setPrinted(boolean)"})
  void testSetPrinted_givenFDFAnnotationCaretToggleNoViewIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setPrinted(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isPrinted());
  }

  /**
   * Test {@link FDFAnnotation#setPrinted(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>When {@code true}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Printed.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setPrinted(boolean)}
   */
  @Test
  @DisplayName(
      "Test setPrinted(boolean); given FDFAnnotationCaret(); when 'true'; then FDFAnnotationCaret() Printed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setPrinted(boolean)"})
  void testSetPrinted_givenFDFAnnotationCaret_whenTrue_thenFDFAnnotationCaretPrinted() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setPrinted(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isPrinted());
  }

  /**
   * Test {@link FDFAnnotation#setPrinted(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link FDFAnnotationCaret#FDFAnnotationCaret()} Printed.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setPrinted(boolean)}
   */
  @Test
  @DisplayName("Test setPrinted(boolean); when 'false'; then not FDFAnnotationCaret() Printed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setPrinted(boolean)"})
  void testSetPrinted_whenFalse_thenNotFDFAnnotationCaretPrinted() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setPrinted(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isPrinted());
  }

  /**
   * Test {@link FDFAnnotation#isNoZoom()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isNoZoom()}
   */
  @Test
  @DisplayName(
      "Test isNoZoom(); given FDFAnnotationCaret() Invisible is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isNoZoom()"})
  void testIsNoZoom_givenFDFAnnotationCaretInvisibleIsTrue_thenReturnFalse() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isNoZoom());
  }

  /**
   * Test {@link FDFAnnotation#isNoZoom()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} NoZoom is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isNoZoom()}
   */
  @Test
  @DisplayName("Test isNoZoom(); given FDFAnnotationCaret() NoZoom is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isNoZoom()"})
  void testIsNoZoom_givenFDFAnnotationCaretNoZoomIsTrue_thenReturnTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setNoZoom(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isNoZoom());
  }

  /**
   * Test {@link FDFAnnotation#isNoZoom()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isNoZoom()}
   */
  @Test
  @DisplayName("Test isNoZoom(); given FDFAnnotationCaret(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isNoZoom()"})
  void testIsNoZoom_givenFDFAnnotationCaret_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FDFAnnotationCaret().isNoZoom());
  }

  /**
   * Test {@link FDFAnnotation#setNoZoom(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setNoZoom(boolean)}
   */
  @Test
  @DisplayName("Test setNoZoom(boolean); given FDFAnnotationCaret() Invisible is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setNoZoom(boolean)"})
  void testSetNoZoom_givenFDFAnnotationCaretInvisibleIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setNoZoom(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoZoom());
  }

  /**
   * Test {@link FDFAnnotation#setNoZoom(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} ToggleNoView is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setNoZoom(boolean)}
   */
  @Test
  @DisplayName("Test setNoZoom(boolean); given FDFAnnotationCaret() ToggleNoView is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setNoZoom(boolean)"})
  void testSetNoZoom_givenFDFAnnotationCaretToggleNoViewIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setNoZoom(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoZoom());
  }

  /**
   * Test {@link FDFAnnotation#setNoZoom(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>When {@code false}.
   *   <li>Then not {@link FDFAnnotationCaret#FDFAnnotationCaret()} NoZoom.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setNoZoom(boolean)}
   */
  @Test
  @DisplayName(
      "Test setNoZoom(boolean); given FDFAnnotationCaret(); when 'false'; then not FDFAnnotationCaret() NoZoom")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setNoZoom(boolean)"})
  void testSetNoZoom_givenFDFAnnotationCaret_whenFalse_thenNotFDFAnnotationCaretNoZoom() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setNoZoom(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isNoZoom());
  }

  /**
   * Test {@link FDFAnnotation#setNoZoom(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>When {@code true}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} NoZoom.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setNoZoom(boolean)}
   */
  @Test
  @DisplayName(
      "Test setNoZoom(boolean); given FDFAnnotationCaret(); when 'true'; then FDFAnnotationCaret() NoZoom")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setNoZoom(boolean)"})
  void testSetNoZoom_givenFDFAnnotationCaret_whenTrue_thenFDFAnnotationCaretNoZoom() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setNoZoom(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoZoom());
  }

  /**
   * Test {@link FDFAnnotation#isNoRotate()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isNoRotate()}
   */
  @Test
  @DisplayName(
      "Test isNoRotate(); given FDFAnnotationCaret() Invisible is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isNoRotate()"})
  void testIsNoRotate_givenFDFAnnotationCaretInvisibleIsTrue_thenReturnFalse() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isNoRotate());
  }

  /**
   * Test {@link FDFAnnotation#isNoRotate()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} NoRotate is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isNoRotate()}
   */
  @Test
  @DisplayName(
      "Test isNoRotate(); given FDFAnnotationCaret() NoRotate is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isNoRotate()"})
  void testIsNoRotate_givenFDFAnnotationCaretNoRotateIsTrue_thenReturnTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setNoRotate(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isNoRotate());
  }

  /**
   * Test {@link FDFAnnotation#isNoRotate()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isNoRotate()}
   */
  @Test
  @DisplayName("Test isNoRotate(); given FDFAnnotationCaret(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isNoRotate()"})
  void testIsNoRotate_givenFDFAnnotationCaret_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FDFAnnotationCaret().isNoRotate());
  }

  /**
   * Test {@link FDFAnnotation#setNoRotate(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setNoRotate(boolean)}
   */
  @Test
  @DisplayName("Test setNoRotate(boolean); given FDFAnnotationCaret() Invisible is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setNoRotate(boolean)"})
  void testSetNoRotate_givenFDFAnnotationCaretInvisibleIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setNoRotate(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoRotate());
  }

  /**
   * Test {@link FDFAnnotation#setNoRotate(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} ToggleNoView is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setNoRotate(boolean)}
   */
  @Test
  @DisplayName("Test setNoRotate(boolean); given FDFAnnotationCaret() ToggleNoView is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setNoRotate(boolean)"})
  void testSetNoRotate_givenFDFAnnotationCaretToggleNoViewIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setNoRotate(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoRotate());
  }

  /**
   * Test {@link FDFAnnotation#setNoRotate(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>When {@code true}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} NoRotate.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setNoRotate(boolean)}
   */
  @Test
  @DisplayName(
      "Test setNoRotate(boolean); given FDFAnnotationCaret(); when 'true'; then FDFAnnotationCaret() NoRotate")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setNoRotate(boolean)"})
  void testSetNoRotate_givenFDFAnnotationCaret_whenTrue_thenFDFAnnotationCaretNoRotate() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setNoRotate(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoRotate());
  }

  /**
   * Test {@link FDFAnnotation#setNoRotate(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link FDFAnnotationCaret#FDFAnnotationCaret()} NoRotate.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setNoRotate(boolean)}
   */
  @Test
  @DisplayName("Test setNoRotate(boolean); when 'false'; then not FDFAnnotationCaret() NoRotate")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setNoRotate(boolean)"})
  void testSetNoRotate_whenFalse_thenNotFDFAnnotationCaretNoRotate() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setNoRotate(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isNoRotate());
  }

  /**
   * Test {@link FDFAnnotation#isNoView()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isNoView()}
   */
  @Test
  @DisplayName(
      "Test isNoView(); given FDFAnnotationCaret() Invisible is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isNoView()"})
  void testIsNoView_givenFDFAnnotationCaretInvisibleIsTrue_thenReturnFalse() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isNoView());
  }

  /**
   * Test {@link FDFAnnotation#isNoView()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} NoView is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isNoView()}
   */
  @Test
  @DisplayName("Test isNoView(); given FDFAnnotationCaret() NoView is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isNoView()"})
  void testIsNoView_givenFDFAnnotationCaretNoViewIsTrue_thenReturnTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setNoView(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isNoView());
  }

  /**
   * Test {@link FDFAnnotation#isNoView()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isNoView()}
   */
  @Test
  @DisplayName("Test isNoView(); given FDFAnnotationCaret(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isNoView()"})
  void testIsNoView_givenFDFAnnotationCaret_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FDFAnnotationCaret().isNoView());
  }

  /**
   * Test {@link FDFAnnotation#setNoView(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setNoView(boolean)}
   */
  @Test
  @DisplayName("Test setNoView(boolean); given FDFAnnotationCaret() Invisible is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setNoView(boolean)"})
  void testSetNoView_givenFDFAnnotationCaretInvisibleIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setNoView(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoView());
  }

  /**
   * Test {@link FDFAnnotation#setNoView(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} NoZoom is {@code true}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} NoView.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setNoView(boolean)}
   */
  @Test
  @DisplayName(
      "Test setNoView(boolean); given FDFAnnotationCaret() NoZoom is 'true'; then FDFAnnotationCaret() NoView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setNoView(boolean)"})
  void testSetNoView_givenFDFAnnotationCaretNoZoomIsTrue_thenFDFAnnotationCaretNoView() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setNoZoom(true);
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setNoView(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoView());
  }

  /**
   * Test {@link FDFAnnotation#setNoView(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} ToggleNoView is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setNoView(boolean)}
   */
  @Test
  @DisplayName("Test setNoView(boolean); given FDFAnnotationCaret() ToggleNoView is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setNoView(boolean)"})
  void testSetNoView_givenFDFAnnotationCaretToggleNoViewIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setNoView(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoView());
  }

  /**
   * Test {@link FDFAnnotation#setNoView(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>When {@code false}.
   *   <li>Then not {@link FDFAnnotationCaret#FDFAnnotationCaret()} NoView.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setNoView(boolean)}
   */
  @Test
  @DisplayName(
      "Test setNoView(boolean); given FDFAnnotationCaret(); when 'false'; then not FDFAnnotationCaret() NoView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setNoView(boolean)"})
  void testSetNoView_givenFDFAnnotationCaret_whenFalse_thenNotFDFAnnotationCaretNoView() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setNoView(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isNoView());
  }

  /**
   * Test {@link FDFAnnotation#setNoView(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>When {@code true}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} NoView.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setNoView(boolean)}
   */
  @Test
  @DisplayName(
      "Test setNoView(boolean); given FDFAnnotationCaret(); when 'true'; then FDFAnnotationCaret() NoView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setNoView(boolean)"})
  void testSetNoView_givenFDFAnnotationCaret_whenTrue_thenFDFAnnotationCaretNoView() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setNoView(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoView());
  }

  /**
   * Test {@link FDFAnnotation#isReadOnly()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isReadOnly()}
   */
  @Test
  @DisplayName(
      "Test isReadOnly(); given FDFAnnotationCaret() Invisible is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isReadOnly()"})
  void testIsReadOnly_givenFDFAnnotationCaretInvisibleIsTrue_thenReturnFalse() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isReadOnly());
  }

  /**
   * Test {@link FDFAnnotation#isReadOnly()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} ReadOnly is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isReadOnly()}
   */
  @Test
  @DisplayName(
      "Test isReadOnly(); given FDFAnnotationCaret() ReadOnly is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isReadOnly()"})
  void testIsReadOnly_givenFDFAnnotationCaretReadOnlyIsTrue_thenReturnTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setReadOnly(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isReadOnly());
  }

  /**
   * Test {@link FDFAnnotation#isReadOnly()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly(); given FDFAnnotationCaret(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isReadOnly()"})
  void testIsReadOnly_givenFDFAnnotationCaret_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FDFAnnotationCaret().isReadOnly());
  }

  /**
   * Test {@link FDFAnnotation#setReadOnly(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test setReadOnly(boolean); given FDFAnnotationCaret() Invisible is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setReadOnly(boolean)"})
  void testSetReadOnly_givenFDFAnnotationCaretInvisibleIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setReadOnly(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isReadOnly());
  }

  /**
   * Test {@link FDFAnnotation#setReadOnly(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} ToggleNoView is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test setReadOnly(boolean); given FDFAnnotationCaret() ToggleNoView is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setReadOnly(boolean)"})
  void testSetReadOnly_givenFDFAnnotationCaretToggleNoViewIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setReadOnly(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isReadOnly());
  }

  /**
   * Test {@link FDFAnnotation#setReadOnly(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>When {@code true}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} ReadOnly.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setReadOnly(boolean)}
   */
  @Test
  @DisplayName(
      "Test setReadOnly(boolean); given FDFAnnotationCaret(); when 'true'; then FDFAnnotationCaret() ReadOnly")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setReadOnly(boolean)"})
  void testSetReadOnly_givenFDFAnnotationCaret_whenTrue_thenFDFAnnotationCaretReadOnly() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setReadOnly(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isReadOnly());
  }

  /**
   * Test {@link FDFAnnotation#setReadOnly(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link FDFAnnotationCaret#FDFAnnotationCaret()} ReadOnly.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test setReadOnly(boolean); when 'false'; then not FDFAnnotationCaret() ReadOnly")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setReadOnly(boolean)"})
  void testSetReadOnly_whenFalse_thenNotFDFAnnotationCaretReadOnly() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setReadOnly(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isReadOnly());
  }

  /**
   * Test {@link FDFAnnotation#isLocked()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isLocked()}
   */
  @Test
  @DisplayName(
      "Test isLocked(); given FDFAnnotationCaret() Invisible is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isLocked()"})
  void testIsLocked_givenFDFAnnotationCaretInvisibleIsTrue_thenReturnFalse() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isLocked());
  }

  /**
   * Test {@link FDFAnnotation#isLocked()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Locked is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isLocked()}
   */
  @Test
  @DisplayName("Test isLocked(); given FDFAnnotationCaret() Locked is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isLocked()"})
  void testIsLocked_givenFDFAnnotationCaretLockedIsTrue_thenReturnTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setLocked(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isLocked());
  }

  /**
   * Test {@link FDFAnnotation#isLocked()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isLocked()}
   */
  @Test
  @DisplayName("Test isLocked(); given FDFAnnotationCaret(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isLocked()"})
  void testIsLocked_givenFDFAnnotationCaret_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FDFAnnotationCaret().isLocked());
  }

  /**
   * Test {@link FDFAnnotation#setLocked(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setLocked(boolean)}
   */
  @Test
  @DisplayName("Test setLocked(boolean); given FDFAnnotationCaret() Invisible is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setLocked(boolean)"})
  void testSetLocked_givenFDFAnnotationCaretInvisibleIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setLocked(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isLocked());
  }

  /**
   * Test {@link FDFAnnotation#setLocked(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Printed is {@code true}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Locked.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setLocked(boolean)}
   */
  @Test
  @DisplayName(
      "Test setLocked(boolean); given FDFAnnotationCaret() Printed is 'true'; then FDFAnnotationCaret() Locked")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setLocked(boolean)"})
  void testSetLocked_givenFDFAnnotationCaretPrintedIsTrue_thenFDFAnnotationCaretLocked() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setPrinted(true);
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setLocked(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isLocked());
  }

  /**
   * Test {@link FDFAnnotation#setLocked(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} ToggleNoView is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setLocked(boolean)}
   */
  @Test
  @DisplayName("Test setLocked(boolean); given FDFAnnotationCaret() ToggleNoView is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setLocked(boolean)"})
  void testSetLocked_givenFDFAnnotationCaretToggleNoViewIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setLocked(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isLocked());
  }

  /**
   * Test {@link FDFAnnotation#setLocked(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>When {@code false}.
   *   <li>Then not {@link FDFAnnotationCaret#FDFAnnotationCaret()} Locked.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setLocked(boolean)}
   */
  @Test
  @DisplayName(
      "Test setLocked(boolean); given FDFAnnotationCaret(); when 'false'; then not FDFAnnotationCaret() Locked")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setLocked(boolean)"})
  void testSetLocked_givenFDFAnnotationCaret_whenFalse_thenNotFDFAnnotationCaretLocked() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setLocked(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isLocked());
  }

  /**
   * Test {@link FDFAnnotation#setLocked(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>When {@code true}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Locked.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setLocked(boolean)}
   */
  @Test
  @DisplayName(
      "Test setLocked(boolean); given FDFAnnotationCaret(); when 'true'; then FDFAnnotationCaret() Locked")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setLocked(boolean)"})
  void testSetLocked_givenFDFAnnotationCaret_whenTrue_thenFDFAnnotationCaretLocked() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setLocked(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isLocked());
  }

  /**
   * Test {@link FDFAnnotation#isToggleNoView()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isToggleNoView()}
   */
  @Test
  @DisplayName(
      "Test isToggleNoView(); given FDFAnnotationCaret() Invisible is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isToggleNoView()"})
  void testIsToggleNoView_givenFDFAnnotationCaretInvisibleIsTrue_thenReturnFalse() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isToggleNoView());
  }

  /**
   * Test {@link FDFAnnotation#isToggleNoView()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} ToggleNoView is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isToggleNoView()}
   */
  @Test
  @DisplayName(
      "Test isToggleNoView(); given FDFAnnotationCaret() ToggleNoView is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isToggleNoView()"})
  void testIsToggleNoView_givenFDFAnnotationCaretToggleNoViewIsTrue_thenReturnTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isToggleNoView());
  }

  /**
   * Test {@link FDFAnnotation#isToggleNoView()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isToggleNoView()}
   */
  @Test
  @DisplayName("Test isToggleNoView(); given FDFAnnotationCaret(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isToggleNoView()"})
  void testIsToggleNoView_givenFDFAnnotationCaret_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FDFAnnotationCaret().isToggleNoView());
  }

  /**
   * Test {@link FDFAnnotation#setToggleNoView(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setToggleNoView(boolean)}
   */
  @Test
  @DisplayName("Test setToggleNoView(boolean); given FDFAnnotationCaret() Invisible is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setToggleNoView(boolean)"})
  void testSetToggleNoView_givenFDFAnnotationCaretInvisibleIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setToggleNoView(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isToggleNoView());
  }

  /**
   * Test {@link FDFAnnotation#setToggleNoView(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} ToggleNoView.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setToggleNoView(boolean)}
   */
  @Test
  @DisplayName(
      "Test setToggleNoView(boolean); given FDFAnnotationCaret(); then FDFAnnotationCaret() ToggleNoView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setToggleNoView(boolean)"})
  void testSetToggleNoView_givenFDFAnnotationCaret_thenFDFAnnotationCaretToggleNoView() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setToggleNoView(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isToggleNoView());
  }

  /**
   * Test {@link FDFAnnotation#setToggleNoView(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link FDFAnnotationCaret#FDFAnnotationCaret()} ToggleNoView.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setToggleNoView(boolean)}
   */
  @Test
  @DisplayName(
      "Test setToggleNoView(boolean); when 'false'; then not FDFAnnotationCaret() ToggleNoView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setToggleNoView(boolean)"})
  void testSetToggleNoView_whenFalse_thenNotFDFAnnotationCaretToggleNoView() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setToggleNoView(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isToggleNoView());
  }

  /**
   * Test {@link FDFAnnotation#isLockedContents()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isLockedContents()}
   */
  @Test
  @DisplayName(
      "Test isLockedContents(); given FDFAnnotationCaret() Invisible is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isLockedContents()"})
  void testIsLockedContents_givenFDFAnnotationCaretInvisibleIsTrue_thenReturnFalse() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isLockedContents());
  }

  /**
   * Test {@link FDFAnnotation#isLockedContents()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} LockedContents is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isLockedContents()}
   */
  @Test
  @DisplayName(
      "Test isLockedContents(); given FDFAnnotationCaret() LockedContents is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isLockedContents()"})
  void testIsLockedContents_givenFDFAnnotationCaretLockedContentsIsTrue_thenReturnTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setLockedContents(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isLockedContents());
  }

  /**
   * Test {@link FDFAnnotation#isLockedContents()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#isLockedContents()}
   */
  @Test
  @DisplayName("Test isLockedContents(); given FDFAnnotationCaret(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FDFAnnotation.isLockedContents()"})
  void testIsLockedContents_givenFDFAnnotationCaret_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FDFAnnotationCaret().isLockedContents());
  }

  /**
   * Test {@link FDFAnnotation#setLockedContents(boolean)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Invisible is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setLockedContents(boolean)}
   */
  @Test
  @DisplayName("Test setLockedContents(boolean); given FDFAnnotationCaret() Invisible is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setLockedContents(boolean)"})
  void testSetLockedContents_givenFDFAnnotationCaretInvisibleIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setLockedContents(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isLockedContents());
  }

  /**
   * Test {@link FDFAnnotation#setLockedContents(boolean)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} LockedContents.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setLockedContents(boolean)}
   */
  @Test
  @DisplayName("Test setLockedContents(boolean); then FDFAnnotationCaret() LockedContents")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setLockedContents(boolean)"})
  void testSetLockedContents_thenFDFAnnotationCaretLockedContents() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setLockedContents(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isLockedContents());
  }

  /**
   * Test {@link FDFAnnotation#setLockedContents(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link FDFAnnotationCaret#FDFAnnotationCaret()} LockedContents.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setLockedContents(boolean)}
   */
  @Test
  @DisplayName(
      "Test setLockedContents(boolean); when 'false'; then not FDFAnnotationCaret() LockedContents")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setLockedContents(boolean)"})
  void testSetLockedContents_whenFalse_thenNotFDFAnnotationCaretLockedContents() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setLockedContents(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isLockedContents());
  }

  /**
   * Test {@link FDFAnnotation#setName(String)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>When {@code Name}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setName(String)}
   */
  @Test
  @DisplayName(
      "Test setName(String); given FDFAnnotationCaret(); when 'Name'; then FDFAnnotationCaret() Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setName(String)"})
  void testSetName_givenFDFAnnotationCaret_whenName_thenFDFAnnotationCaretNameIsName() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setName("Name");

    // Assert
    assertEquals("Name", fdfAnnotationCaret.getName());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#setName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setName(String)}
   */
  @Test
  @DisplayName(
      "Test setName(String); when 'null'; then FDFAnnotationCaret() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setName(String)"})
  void testSetName_whenNull_thenFDFAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setName(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#getName()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Name is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given FDFAnnotationCaret() Name is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getName()"})
  void testGetName_givenFDFAnnotationCaretNameIsEmptyString_thenReturnEmptyString() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setName("");

    // Act and Assert
    assertEquals("", fdfAnnotationCaret.getName());
  }

  /**
   * Test {@link FDFAnnotation#getName()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Name is {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getName()}
   */
  @Test
  @DisplayName("Test getName(); given FDFAnnotationCaret() Name is 'Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getName()"})
  void testGetName_givenFDFAnnotationCaretNameIsName_thenReturnName() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setName("Name");

    // Act and Assert
    assertEquals("Name", fdfAnnotationCaret.getName());
  }

  /**
   * Test {@link FDFAnnotation#getName()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getName()}
   */
  @Test
  @DisplayName("Test getName(); given FDFAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getName()"})
  void testGetName_givenFDFAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret().getName());
  }

  /**
   * Test {@link FDFAnnotation#setRectangle(PDRectangle)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} COSObject toIncrement Objects size
   *       is one.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setRectangle(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setRectangle(PDRectangle); then FDFAnnotationCaret() COSObject toIncrement Objects size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setRectangle(PDRectangle)"})
  void testSetRectangle_thenFDFAnnotationCaretCOSObjectToIncrementObjectsSizeIsOne() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setRectangle(PDRectangle.LETTER);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertEquals(1, toIncrementResult.getObjects().size());
    Iterator<COSBase> iteratorResult = toIncrementResult.iterator();
    COSBase actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(cOSObject, actualNextResult);
    PDRectangle rectangle = fdfAnnotationCaret.getRectangle();
    assertEquals(792.0f, rectangle.getHeight());
    assertEquals(612.0f, rectangle.getUpperRightX());
    assertEquals(792.0f, rectangle.getUpperRightY());
    assertEquals(612.0f, rectangle.getWidth());
  }

  /**
   * Test {@link FDFAnnotation#setRectangle(PDRectangle)}.
   *
   * <ul>
   *   <li>When {@link PDRectangle#A0}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Rectangle UpperRightX is {@code
   *       2383.937}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setRectangle(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setRectangle(PDRectangle); when A0; then FDFAnnotationCaret() Rectangle UpperRightX is '2383.937'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setRectangle(PDRectangle)"})
  void testSetRectangle_whenA0_thenFDFAnnotationCaretRectangleUpperRightXIs2383937() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setRectangle(PDRectangle.A0);

    // Assert
    PDRectangle rectangle = fdfAnnotationCaret.getRectangle();
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    assertEquals(3370.3938f, rectangle.getHeight());
    assertEquals(3370.3938f, rectangle.getUpperRightY());
  }

  /**
   * Test {@link FDFAnnotation#setRectangle(PDRectangle)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} COSObject toIncrement Objects Empty.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setRectangle(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setRectangle(PDRectangle); when 'null'; then FDFAnnotationCaret() COSObject toIncrement Objects Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setRectangle(PDRectangle)"})
  void testSetRectangle_whenNull_thenFDFAnnotationCaretCOSObjectToIncrementObjectsEmpty() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setRectangle(null);

    // Assert that nothing has changed
    COSIncrement toIncrementResult = fdfAnnotationCaret.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFAnnotation#getRectangle()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); given FDFAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle FDFAnnotation.getRectangle()"})
  void testGetRectangle_givenFDFAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret().getRectangle());
  }

  /**
   * Test {@link FDFAnnotation#getRectangle()}.
   *
   * <ul>
   *   <li>Then return COSArray toList third Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return COSArray toList third Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle FDFAnnotation.getRectangle()"})
  void testGetRectangle_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setRectangle(PDRectangle.A0);

    // Act
    PDRectangle actualRectangle = fdfAnnotationCaret.getRectangle();

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
   * Test {@link FDFAnnotation#getRectangle()}.
   *
   * <ul>
   *   <li>Then return Height is zero.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return Height is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle FDFAnnotation.getRectangle()"})
  void testGetRectangle_thenReturnHeightIsZero() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    PDRectangle rectangle =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    fdfAnnotationCaret.setRectangle(rectangle);

    // Act
    PDRectangle actualRectangle = fdfAnnotationCaret.getRectangle();

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
   * Test {@link FDFAnnotation#setContents(String)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Contents is {@code Not all who
   *       wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setContents(String)}
   */
  @Test
  @DisplayName(
      "Test setContents(String); then FDFAnnotationCaret() Contents is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setContents(String)"})
  void testSetContents_thenFDFAnnotationCaretContentsIsNotAllWhoWanderAreLost() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setContents("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", fdfAnnotationCaret.getContents());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#setContents(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setContents(String)}
   */
  @Test
  @DisplayName(
      "Test setContents(String); when 'null'; then FDFAnnotationCaret() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setContents(String)"})
  void testSetContents_whenNull_thenFDFAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setContents(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#getContents()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); given FDFAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getContents()"})
  void testGetContents_givenFDFAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret().getContents());
  }

  /**
   * Test {@link FDFAnnotation#getContents()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getContents()"})
  void testGetContents_thenReturnEmptyString() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setContents("");

    // Act and Assert
    assertEquals("", fdfAnnotationCaret.getContents());
  }

  /**
   * Test {@link FDFAnnotation#getContents()}.
   *
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getContents()"})
  void testGetContents_thenReturnNotAllWhoWanderAreLost() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setContents("Not all who wander are lost");

    // Act and Assert
    assertEquals("Not all who wander are lost", fdfAnnotationCaret.getContents());
  }

  /**
   * Test {@link FDFAnnotation#setTitle(String)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>When {@code Dr}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Title is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setTitle(String)}
   */
  @Test
  @DisplayName(
      "Test setTitle(String); given FDFAnnotationCaret(); when 'Dr'; then FDFAnnotationCaret() Title is 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setTitle(String)"})
  void testSetTitle_givenFDFAnnotationCaret_whenDr_thenFDFAnnotationCaretTitleIsDr() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setTitle("Dr");

    // Assert
    assertEquals("Dr", fdfAnnotationCaret.getTitle());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#setTitle(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setTitle(String)}
   */
  @Test
  @DisplayName(
      "Test setTitle(String); when 'null'; then FDFAnnotationCaret() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setTitle(String)"})
  void testSetTitle_whenNull_thenFDFAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setTitle(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#getTitle()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Title is {@code Dr}.
   *   <li>Then return {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); given FDFAnnotationCaret() Title is 'Dr'; then return 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getTitle()"})
  void testGetTitle_givenFDFAnnotationCaretTitleIsDr_thenReturnDr() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setTitle("Dr");

    // Act and Assert
    assertEquals("Dr", fdfAnnotationCaret.getTitle());
  }

  /**
   * Test {@link FDFAnnotation#getTitle()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Title is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getTitle()}
   */
  @Test
  @DisplayName(
      "Test getTitle(); given FDFAnnotationCaret() Title is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getTitle()"})
  void testGetTitle_givenFDFAnnotationCaretTitleIsEmptyString_thenReturnEmptyString() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setTitle("");

    // Act and Assert
    assertEquals("", fdfAnnotationCaret.getTitle());
  }

  /**
   * Test {@link FDFAnnotation#getTitle()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); given FDFAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getTitle()"})
  void testGetTitle_givenFDFAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret().getTitle());
  }

  /**
   * Test {@link FDFAnnotation#getCreationDate()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getCreationDate()}
   */
  @Test
  @DisplayName("Test getCreationDate(); given FDFAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar FDFAnnotation.getCreationDate()"})
  void testGetCreationDate_givenFDFAnnotationCaret_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret().getCreationDate());
  }

  /**
   * Test {@link FDFAnnotation#getCreationDate()}.
   *
   * <ul>
   *   <li>Given {@link GregorianCalendar#GregorianCalendar(int, int, int)} with one and one and one
   *       add two and {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getCreationDate()}
   */
  @Test
  @DisplayName(
      "Test getCreationDate(); given GregorianCalendar(int, int, int) with one and one and one add two and MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar FDFAnnotation.getCreationDate()"})
  void testGetCreationDate_givenGregorianCalendarWithOneAndOneAndOneAddTwoAndMin_value()
      throws IOException {
    // Arrange
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);
    date.add(2, Integer.MIN_VALUE);

    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setCreationDate(date);

    // Act and Assert
    assertNull(fdfAnnotationCaret.getCreationDate());
  }

  /**
   * Test {@link FDFAnnotation#getCreationDate()}.
   *
   * <ul>
   *   <li>Then return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getCreationDate()}
   */
  @Test
  @DisplayName("Test getCreationDate(); then return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar FDFAnnotation.getCreationDate()"})
  void testGetCreationDate_thenReturnGregorianCalendar() throws IOException {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setCreationDate(new GregorianCalendar(1, 1, 1));

    // Act
    Calendar actualCreationDate = fdfAnnotationCaret.getCreationDate();

    // Assert
    assertTrue(actualCreationDate instanceof GregorianCalendar);
    assertEquals("gregory", actualCreationDate.getCalendarType());
    assertEquals(1, actualCreationDate.getFirstDayOfWeek());
    assertEquals(1, actualCreationDate.getMinimalDaysInFirstWeek());
    assertEquals(1, actualCreationDate.getWeekYear());
    assertEquals(53, actualCreationDate.getWeeksInWeekYear());
    assertFalse(actualCreationDate.isLenient());
    assertTrue(actualCreationDate.isWeekDateSupported());
  }

  /**
   * Test {@link FDFAnnotation#setCreationDate(Calendar)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} CreationDate {@link
   *       GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setCreationDate(Calendar)}
   */
  @Test
  @DisplayName(
      "Test setCreationDate(Calendar); then FDFAnnotationCaret() CreationDate GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setCreationDate(Calendar)"})
  void testSetCreationDate_thenFDFAnnotationCaretCreationDateGregorianCalendar()
      throws IOException {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setCreationDate(new GregorianCalendar(1, 1, 1));

    // Assert
    Calendar creationDate = fdfAnnotationCaret.getCreationDate();
    assertTrue(creationDate instanceof GregorianCalendar);
    assertEquals("gregory", creationDate.getCalendarType());
    assertEquals(1, creationDate.getFirstDayOfWeek());
    assertEquals(1, creationDate.getMinimalDaysInFirstWeek());
    assertEquals(1, creationDate.getWeekYear());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(53, creationDate.getWeeksInWeekYear());
    assertFalse(creationDate.isLenient());
    assertTrue(creationDate.isWeekDateSupported());
  }

  /**
   * Test {@link FDFAnnotation#setCreationDate(Calendar)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setCreationDate(Calendar)}
   */
  @Test
  @DisplayName(
      "Test setCreationDate(Calendar); when 'null'; then FDFAnnotationCaret() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setCreationDate(Calendar)"})
  void testSetCreationDate_whenNull_thenFDFAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setCreationDate(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#setOpacity(float)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Opacity is ten.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setOpacity(float)}
   */
  @Test
  @DisplayName(
      "Test setOpacity(float); given FDFAnnotationCaret(); then FDFAnnotationCaret() Opacity is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setOpacity(float)"})
  void testSetOpacity_givenFDFAnnotationCaret_thenFDFAnnotationCaretOpacityIsTen() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setOpacity(10.0f);

    // Assert
    assertEquals(10.0f, fdfAnnotationCaret.getOpacity());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#getOpacity()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Opacity is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getOpacity()}
   */
  @Test
  @DisplayName("Test getOpacity(); given FDFAnnotationCaret() Opacity is one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float FDFAnnotation.getOpacity()"})
  void testGetOpacity_givenFDFAnnotationCaretOpacityIsOne_thenReturnOne() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setOpacity(1.0f);

    // Act and Assert
    assertEquals(1.0f, fdfAnnotationCaret.getOpacity());
  }

  /**
   * Test {@link FDFAnnotation#getOpacity()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getOpacity()}
   */
  @Test
  @DisplayName("Test getOpacity(); given FDFAnnotationCaret(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float FDFAnnotation.getOpacity()"})
  void testGetOpacity_givenFDFAnnotationCaret_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new FDFAnnotationCaret().getOpacity());
  }

  /**
   * Test {@link FDFAnnotation#setSubject(String)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Subject is {@code Hello from the
   *       Dreaming Spires}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setSubject(String)}
   */
  @Test
  @DisplayName(
      "Test setSubject(String); then FDFAnnotationCaret() Subject is 'Hello from the Dreaming Spires'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setSubject(String)"})
  void testSetSubject_thenFDFAnnotationCaretSubjectIsHelloFromTheDreamingSpires() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setSubject("Hello from the Dreaming Spires");

    // Assert
    assertEquals("Hello from the Dreaming Spires", fdfAnnotationCaret.getSubject());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#setSubject(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setSubject(String)}
   */
  @Test
  @DisplayName(
      "Test setSubject(String); when 'null'; then FDFAnnotationCaret() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setSubject(String)"})
  void testSetSubject_whenNull_thenFDFAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setSubject(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#getSubject()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Subject is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getSubject()}
   */
  @Test
  @DisplayName(
      "Test getSubject(); given FDFAnnotationCaret() Subject is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getSubject()"})
  void testGetSubject_givenFDFAnnotationCaretSubjectIsEmptyString_thenReturnEmptyString() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setSubject("");

    // Act and Assert
    assertEquals("", fdfAnnotationCaret.getSubject());
  }

  /**
   * Test {@link FDFAnnotation#getSubject()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getSubject()}
   */
  @Test
  @DisplayName("Test getSubject(); given FDFAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getSubject()"})
  void testGetSubject_givenFDFAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret().getSubject());
  }

  /**
   * Test {@link FDFAnnotation#getSubject()}.
   *
   * <ul>
   *   <li>Then return {@code Hello from the Dreaming Spires}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getSubject()}
   */
  @Test
  @DisplayName("Test getSubject(); then return 'Hello from the Dreaming Spires'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getSubject()"})
  void testGetSubject_thenReturnHelloFromTheDreamingSpires() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertEquals("Hello from the Dreaming Spires", fdfAnnotationCaret.getSubject());
  }

  /**
   * Test {@link FDFAnnotation#setIntent(String)}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>When {@code 42}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Intent is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setIntent(String)}
   */
  @Test
  @DisplayName(
      "Test setIntent(String); given FDFAnnotationCaret(); when '42'; then FDFAnnotationCaret() Intent is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setIntent(String)"})
  void testSetIntent_givenFDFAnnotationCaret_when42_thenFDFAnnotationCaretIntentIs42() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setIntent("42");

    // Assert
    assertEquals("42", fdfAnnotationCaret.getIntent());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#setIntent(String)}.
   *
   * <ul>
   *   <li>When {@code Intent}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} Intent is {@code Intent}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setIntent(String)}
   */
  @Test
  @DisplayName(
      "Test setIntent(String); when 'Intent'; then FDFAnnotationCaret() Intent is 'Intent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setIntent(String)"})
  void testSetIntent_whenIntent_thenFDFAnnotationCaretIntentIsIntent() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setIntent("Intent");

    // Assert
    assertEquals("Intent", fdfAnnotationCaret.getIntent());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#setIntent(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setIntent(String)}
   */
  @Test
  @DisplayName(
      "Test setIntent(String); when 'null'; then FDFAnnotationCaret() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setIntent(String)"})
  void testSetIntent_whenNull_thenFDFAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setIntent(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#getIntent()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} Intent is {@code Intent}.
   *   <li>Then return {@code Intent}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getIntent()}
   */
  @Test
  @DisplayName(
      "Test getIntent(); given FDFAnnotationCaret() Intent is 'Intent'; then return 'Intent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getIntent()"})
  void testGetIntent_givenFDFAnnotationCaretIntentIsIntent_thenReturnIntent() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setIntent("Intent");

    // Act and Assert
    assertEquals("Intent", fdfAnnotationCaret.getIntent());
  }

  /**
   * Test {@link FDFAnnotation#getIntent()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getIntent()}
   */
  @Test
  @DisplayName("Test getIntent(); given FDFAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getIntent()"})
  void testGetIntent_givenFDFAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret().getIntent());
  }

  /**
   * Test {@link FDFAnnotation#getRichContents()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} RichContents is empty string.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getRichContents()}
   */
  @Test
  @DisplayName("Test getRichContents(); given FDFAnnotationCaret() RichContents is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getRichContents()"})
  void testGetRichContents_givenFDFAnnotationCaretRichContentsIsEmptyString() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setRichContents("");

    // Act and Assert
    assertEquals("", fdfAnnotationCaret.getRichContents());
  }

  /**
   * Test {@link FDFAnnotation#getRichContents()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()} RichContents is {@code Rc}.
   *   <li>Then return {@code Rc}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getRichContents()}
   */
  @Test
  @DisplayName(
      "Test getRichContents(); given FDFAnnotationCaret() RichContents is 'Rc'; then return 'Rc'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getRichContents()"})
  void testGetRichContents_givenFDFAnnotationCaretRichContentsIsRc_thenReturnRc() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setRichContents("Rc");

    // Act and Assert
    assertEquals("Rc", fdfAnnotationCaret.getRichContents());
  }

  /**
   * Test {@link FDFAnnotation#getRichContents()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getRichContents()}
   */
  @Test
  @DisplayName("Test getRichContents(); given FDFAnnotationCaret(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getRichContents()"})
  void testGetRichContents_givenFDFAnnotationCaret_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new FDFAnnotationCaret().getRichContents());
  }

  /**
   * Test {@link FDFAnnotation#setRichContents(String)}.
   *
   * <ul>
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} RichContents is {@code Rc}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setRichContents(String)}
   */
  @Test
  @DisplayName("Test setRichContents(String); then FDFAnnotationCaret() RichContents is 'Rc'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setRichContents(String)"})
  void testSetRichContents_thenFDFAnnotationCaretRichContentsIsRc() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setRichContents("Rc");

    // Assert
    assertEquals("Rc", fdfAnnotationCaret.getRichContents());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#setBorderStyle(PDBorderStyleDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName(
      "Test setBorderStyle(PDBorderStyleDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setBorderStyle(PDBorderStyleDictionary)"})
  void testSetBorderStyle_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    fdfAnnotationCaret.setBorderStyle(new PDBorderStyleDictionary(dict));

    // Assert
    PDBorderStyleDictionary borderStyle = fdfAnnotationCaret.getBorderStyle();
    PDLineDashPattern dashStyle = borderStyle.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertSame(dict, borderStyle.getCOSObject());
    assertArrayEquals(new float[] {3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotation#setBorderStyle(PDBorderStyleDictionary)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName(
      "Test setBorderStyle(PDBorderStyleDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setBorderStyle(PDBorderStyleDictionary)"})
  void testSetBorderStyle_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    fdfAnnotationCaret.setBorderStyle(new PDBorderStyleDictionary(dict));

    // Assert
    PDBorderStyleDictionary borderStyle = fdfAnnotationCaret.getBorderStyle();
    PDLineDashPattern dashStyle = borderStyle.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertSame(dict, borderStyle.getCOSObject());
    assertArrayEquals(new float[] {3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotation#setBorderStyle(PDBorderStyleDictionary)}.
   *
   * <ul>
   *   <li>When {@link PDBorderStyleDictionary#PDBorderStyleDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test setBorderStyle(PDBorderStyleDictionary); when PDBorderStyleDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setBorderStyle(PDBorderStyleDictionary)"})
  void testSetBorderStyle_whenPDBorderStyleDictionary() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setBorderStyle(new PDBorderStyleDictionary());

    // Assert
    PDLineDashPattern dashStyle = fdfAnnotationCaret.getBorderStyle().getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertArrayEquals(new float[] {3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotation#getBorderStyle()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getBorderStyle()}
   */
  @Test
  @DisplayName("Test getBorderStyle(); given FDFAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDBorderStyleDictionary FDFAnnotation.getBorderStyle()"})
  void testGetBorderStyle_givenFDFAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret().getBorderStyle());
  }

  /**
   * Test {@link FDFAnnotation#getBorderStyle()}.
   *
   * <ul>
   *   <li>Then DashStyle COSObject return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getBorderStyle()}
   */
  @Test
  @DisplayName("Test getBorderStyle(); then DashStyle COSObject return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDBorderStyleDictionary FDFAnnotation.getBorderStyle()"})
  void testGetBorderStyle_thenDashStyleCOSObjectReturnCOSArray() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setBorderStyle(new PDBorderStyleDictionary());

    // Act
    PDBorderStyleDictionary actualBorderStyle = fdfAnnotationCaret.getBorderStyle();

    // Assert
    PDLineDashPattern dashStyle = actualBorderStyle.getDashStyle();
    assertTrue(dashStyle.getCOSObject() instanceof COSArray);
    COSDictionary cOSObject = actualBorderStyle.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1.0f, actualBorderStyle.getWidth());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertEquals(FDFIconFit.SCALE_OPTION_ONLY_WHEN_ICON_IS_SMALLER, actualBorderStyle.getStyle());
    assertArrayEquals(new float[] {3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link FDFAnnotation#setBorderEffect(PDBorderEffectDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName(
      "Test setBorderEffect(PDBorderEffectDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    fdfAnnotationCaret.setBorderEffect(new PDBorderEffectDictionary(dict));

    // Assert
    PDBorderEffectDictionary borderEffect = fdfAnnotationCaret.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(FDFIconFit.SCALE_OPTION_ONLY_WHEN_ICON_IS_SMALLER, borderEffect.getStyle());
    assertSame(dict, borderEffect.getCOSObject());
  }

  /**
   * Test {@link FDFAnnotation#setBorderEffect(PDBorderEffectDictionary)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName(
      "Test setBorderEffect(PDBorderEffectDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    fdfAnnotationCaret.setBorderEffect(new PDBorderEffectDictionary(dict));

    // Assert
    PDBorderEffectDictionary borderEffect = fdfAnnotationCaret.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(FDFIconFit.SCALE_OPTION_ONLY_WHEN_ICON_IS_SMALLER, borderEffect.getStyle());
    assertSame(dict, borderEffect.getCOSObject());
  }

  /**
   * Test {@link FDFAnnotation#setBorderEffect(PDBorderEffectDictionary)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FDFAnnotationCaret#FDFAnnotationCaret()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName(
      "Test setBorderEffect(PDBorderEffectDictionary); when 'null'; then FDFAnnotationCaret() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_whenNull_thenFDFAnnotationCaretCOSObjectValuesSizeIsTwo() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setBorderEffect(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link FDFAnnotation#setBorderEffect(PDBorderEffectDictionary)}.
   *
   * <ul>
   *   <li>When {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName("Test setBorderEffect(PDBorderEffectDictionary); when PDBorderEffectDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFAnnotation.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_whenPDBorderEffectDictionary() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setBorderEffect(new PDBorderEffectDictionary());

    // Assert
    PDBorderEffectDictionary borderEffect = fdfAnnotationCaret.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(FDFIconFit.SCALE_OPTION_ONLY_WHEN_ICON_IS_SMALLER, borderEffect.getStyle());
  }

  /**
   * Test {@link FDFAnnotation#getBorderEffect()}.
   *
   * <ul>
   *   <li>Given {@link FDFAnnotationCaret#FDFAnnotationCaret()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getBorderEffect()}
   */
  @Test
  @DisplayName("Test getBorderEffect(); given FDFAnnotationCaret(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDBorderEffectDictionary FDFAnnotation.getBorderEffect()"})
  void testGetBorderEffect_givenFDFAnnotationCaret_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FDFAnnotationCaret().getBorderEffect());
  }

  /**
   * Test {@link FDFAnnotation#getBorderEffect()}.
   *
   * <ul>
   *   <li>Then return COSObject UpdateState OriginDocumentState is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getBorderEffect()}
   */
  @Test
  @DisplayName(
      "Test getBorderEffect(); then return COSObject UpdateState OriginDocumentState is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDBorderEffectDictionary FDFAnnotation.getBorderEffect()"})
  void testGetBorderEffect_thenReturnCOSObjectUpdateStateOriginDocumentStateIsNull() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setBorderEffect(new PDBorderEffectDictionary());

    // Act
    PDBorderEffectDictionary actualBorderEffect = fdfAnnotationCaret.getBorderEffect();

    // Assert
    COSDictionary cOSObject = actualBorderEffect.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    assertEquals(0.0f, actualBorderEffect.getIntensity());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(FDFIconFit.SCALE_OPTION_ONLY_WHEN_ICON_IS_SMALLER, actualBorderEffect.getStyle());
  }

  /**
   * Test {@link FDFAnnotation#getStringOrStream(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getStringOrStream(COSBase)}
   */
  @Test
  @DisplayName("Test getStringOrStream(COSBase); when COSStream(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getStringOrStream(COSBase)"})
  void testGetStringOrStream_whenCOSStream_thenReturnEmptyString() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act and Assert
    assertEquals("", fdfAnnotationCaret.getStringOrStream(new COSStream()));
  }

  /**
   * Test {@link FDFAnnotation#getStringOrStream(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getStringOrStream(COSBase)}
   */
  @Test
  @DisplayName("Test getStringOrStream(COSBase); when FALSE; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getStringOrStream(COSBase)"})
  void testGetStringOrStream_whenFalse_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new FDFAnnotationCaret().getStringOrStream(COSBoolean.FALSE));
  }

  /**
   * Test {@link FDFAnnotation#getStringOrStream(COSBase)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getStringOrStream(COSBase)}
   */
  @Test
  @DisplayName("Test getStringOrStream(COSBase); when 'null'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getStringOrStream(COSBase)"})
  void testGetStringOrStream_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new FDFAnnotationCaret().getStringOrStream(null));
  }

  /**
   * Test {@link FDFAnnotation#getStringOrStream(COSBase)}.
   *
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.
   *   <li>Then return {@code #Eg›«Íï}.
   * </ul>
   *
   * <p>Method under test: {@link FDFAnnotation#getStringOrStream(COSBase)}
   */
  @Test
  @DisplayName(
      "Test getStringOrStream(COSBase); when parseHex '0123456789ABCDEF'; then return '#Eg›«Íï'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FDFAnnotation.getStringOrStream(COSBase)"})
  void testGetStringOrStream_whenParseHex0123456789abcdef_thenReturnEg() throws IOException {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act and Assert
    assertEquals(
        "\u0001#Eg›«Íï",
        fdfAnnotationCaret.getStringOrStream(COSString.parseHex("0123456789ABCDEF")));
  }
}
