package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationMarkupDiffblueTest {
  /**
   * Test {@link PDAnnotationMarkup#PDAnnotationMarkup()}.
   *
   * <p>Method under test: {@link PDAnnotationMarkup#PDAnnotationMarkup()}
   */
  @Test
  @DisplayName("Test new PDAnnotationMarkup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.<init>()"})
  void testNewPDAnnotationMarkup() throws IOException {
    // Arrange and Act
    PDAnnotationMarkup actualPdAnnotationMarkup = new PDAnnotationMarkup();

    // Assert
    assertNull(actualPdAnnotationMarkup.getAnnotationName());
    assertNull(actualPdAnnotationMarkup.getContents());
    assertNull(actualPdAnnotationMarkup.getModifiedDate());
    assertNull(actualPdAnnotationMarkup.getSubtype());
    assertNull(actualPdAnnotationMarkup.getIntent());
    assertNull(actualPdAnnotationMarkup.getRichContents());
    assertNull(actualPdAnnotationMarkup.getSubject());
    assertNull(actualPdAnnotationMarkup.getTitlePopup());
    assertNull(actualPdAnnotationMarkup.getCreationDate());
    assertNull(actualPdAnnotationMarkup.getAppearanceState());
    assertNull(actualPdAnnotationMarkup.getPage());
    assertNull(actualPdAnnotationMarkup.getRectangle());
    assertNull(actualPdAnnotationMarkup.getOptionalContent());
    assertNull(actualPdAnnotationMarkup.getColor());
    assertNull(actualPdAnnotationMarkup.getInReplyTo());
    assertNull(actualPdAnnotationMarkup.getPopup());
    assertNull(actualPdAnnotationMarkup.getAppearance());
    assertNull(actualPdAnnotationMarkup.getNormalAppearanceStream());
    assertNull(actualPdAnnotationMarkup.getBorderStyle());
    assertNull(actualPdAnnotationMarkup.getExternalData());
    assertEquals(-1, actualPdAnnotationMarkup.getStructParent());
    assertEquals(0, actualPdAnnotationMarkup.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationMarkup.getConstantOpacity());
    assertFalse(actualPdAnnotationMarkup.isHidden());
    assertFalse(actualPdAnnotationMarkup.isInvisible());
    assertFalse(actualPdAnnotationMarkup.isLocked());
    assertFalse(actualPdAnnotationMarkup.isLockedContents());
    assertFalse(actualPdAnnotationMarkup.isNoRotate());
    assertFalse(actualPdAnnotationMarkup.isNoView());
    assertFalse(actualPdAnnotationMarkup.isNoZoom());
    assertFalse(actualPdAnnotationMarkup.isPrinted());
    assertFalse(actualPdAnnotationMarkup.isReadOnly());
    assertFalse(actualPdAnnotationMarkup.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationMarkup.getReplyType());
  }

  /**
   * Test {@link PDAnnotationMarkup#PDAnnotationMarkup(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#PDAnnotationMarkup(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationMarkup(COSDictionary); when COSDictionary(); then COSDictionary() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.<init>(COSDictionary)"})
  void testNewPDAnnotationMarkup_whenCOSDictionary_thenCOSDictionarySizeIsOne() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDAnnotationMarkup actualPdAnnotationMarkup = new PDAnnotationMarkup(dict);

    // Assert
    assertEquals(1, dict.size());
    List<? extends COSBase> toListResult = actualPdAnnotationMarkup.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(dict, actualPdAnnotationMarkup.getCOSObject());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationMarkup#PDAnnotationMarkup(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then {@link COSStream#COSStream()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#PDAnnotationMarkup(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationMarkup(COSDictionary); when COSStream(); then COSStream() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.<init>(COSDictionary)"})
  void testNewPDAnnotationMarkup_whenCOSStream_thenCOSStreamSizeIsTwo() {
    // Arrange
    COSStream dict = new COSStream();

    // Act
    PDAnnotationMarkup actualPdAnnotationMarkup = new PDAnnotationMarkup(dict);

    // Assert
    assertEquals(2, dict.size());
    List<? extends COSBase> toListResult = actualPdAnnotationMarkup.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(dict, actualPdAnnotationMarkup.getCOSObject());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationMarkup#getTitlePopup()}.
   *
   * <p>Method under test: {@link PDAnnotationMarkup#getTitlePopup()}
   */
  @Test
  @DisplayName("Test getTitlePopup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationMarkup.getTitlePopup()"})
  void testGetTitlePopup() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationMarkup().getTitlePopup());
  }

  /**
   * Test {@link PDAnnotationMarkup#setTitlePopup(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setTitlePopup(String)}
   */
  @Test
  @DisplayName(
      "Test setTitlePopup(String); when 'null'; then PDAnnotationMarkup() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setTitlePopup(String)"})
  void testSetTitlePopup_whenNull_thenPDAnnotationMarkupCOSObjectValuesSizeIsOne() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setTitlePopup(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationMarkup#setTitlePopup(String)}.
   *
   * <ul>
   *   <li>When {@code Title Popup}.
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup()} TitlePopup is {@code Title Popup}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setTitlePopup(String)}
   */
  @Test
  @DisplayName(
      "Test setTitlePopup(String); when 'Title Popup'; then PDAnnotationMarkup() TitlePopup is 'Title Popup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setTitlePopup(String)"})
  void testSetTitlePopup_whenTitlePopup_thenPDAnnotationMarkupTitlePopupIsTitlePopup() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setTitlePopup("Title Popup");

    // Assert
    assertEquals("Title Popup", pdAnnotationMarkup.getTitlePopup());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationMarkup#getPopup()}.
   *
   * <p>Method under test: {@link PDAnnotationMarkup#getPopup()}
   */
  @Test
  @DisplayName("Test getPopup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotationPopup PDAnnotationMarkup.getPopup()"})
  void testGetPopup() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationMarkup().getPopup());
  }

  /**
   * Test {@link PDAnnotationMarkup#setPopup(PDAnnotationPopup)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setPopup(PDAnnotationPopup)}
   */
  @Test
  @DisplayName(
      "Test setPopup(PDAnnotationPopup); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setPopup(PDAnnotationPopup)"})
  void testSetPopup_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    COSDictionary field = new COSDictionary();
    field.setKey(new COSObjectKey(1L, 1));
    PDAnnotationPopup popup = new PDAnnotationPopup(field);

    // Act
    pdAnnotationMarkup.setPopup(popup);

    // Assert
    assertEquals(popup, pdAnnotationMarkup.getPopup());
  }

  /**
   * Test {@link PDAnnotationMarkup#setPopup(PDAnnotationPopup)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setPopup(PDAnnotationPopup)}
   */
  @Test
  @DisplayName(
      "Test setPopup(PDAnnotationPopup); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setPopup(PDAnnotationPopup)"})
  void testSetPopup_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    COSDictionary field = new COSDictionary();
    field.setDirect(true);
    PDAnnotationPopup popup = new PDAnnotationPopup(field);

    // Act
    pdAnnotationMarkup.setPopup(popup);

    // Assert
    assertEquals(popup, pdAnnotationMarkup.getPopup());
  }

  /**
   * Test {@link PDAnnotationMarkup#setPopup(PDAnnotationPopup)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup()} Popup is {@link
   *       PDAnnotationPopup#PDAnnotationPopup()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setPopup(PDAnnotationPopup)}
   */
  @Test
  @DisplayName(
      "Test setPopup(PDAnnotationPopup); then PDAnnotationMarkup() Popup is PDAnnotationPopup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setPopup(PDAnnotationPopup)"})
  void testSetPopup_thenPDAnnotationMarkupPopupIsPDAnnotationPopup() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();
    PDAnnotationPopup popup = new PDAnnotationPopup();

    // Act
    pdAnnotationMarkup.setPopup(popup);

    // Assert
    assertEquals(popup, pdAnnotationMarkup.getPopup());
  }

  /**
   * Test {@link PDAnnotationMarkup#setPopup(PDAnnotationPopup)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup()} Popup is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setPopup(PDAnnotationPopup)}
   */
  @Test
  @DisplayName(
      "Test setPopup(PDAnnotationPopup); when 'null'; then PDAnnotationMarkup() Popup is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setPopup(PDAnnotationPopup)"})
  void testSetPopup_whenNull_thenPDAnnotationMarkupPopupIsNull() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setPopup(null);

    // Assert that nothing has changed
    assertNull(pdAnnotationMarkup.getPopup());
  }

  /**
   * Test {@link PDAnnotationMarkup#getConstantOpacity()}.
   *
   * <p>Method under test: {@link PDAnnotationMarkup#getConstantOpacity()}
   */
  @Test
  @DisplayName("Test getConstantOpacity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDAnnotationMarkup.getConstantOpacity()"})
  void testGetConstantOpacity() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new PDAnnotationMarkup().getConstantOpacity());
  }

  /**
   * Test {@link PDAnnotationMarkup#setConstantOpacity(float)}.
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setConstantOpacity(float)}
   */
  @Test
  @DisplayName("Test setConstantOpacity(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setConstantOpacity(float)"})
  void testSetConstantOpacity() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setConstantOpacity(10.0f);

    // Assert
    assertEquals(10.0f, pdAnnotationMarkup.getConstantOpacity());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationMarkup#getRichContents()}.
   *
   * <p>Method under test: {@link PDAnnotationMarkup#getRichContents()}
   */
  @Test
  @DisplayName("Test getRichContents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationMarkup.getRichContents()"})
  void testGetRichContents() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationMarkup().getRichContents());
  }

  /**
   * Test {@link PDAnnotationMarkup#setRichContents(String)}.
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setRichContents(String)}
   */
  @Test
  @DisplayName("Test setRichContents(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setRichContents(String)"})
  void testSetRichContents() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setRichContents("Rc");

    // Assert
    assertEquals("Rc", pdAnnotationMarkup.getRichContents());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationMarkup#getCreationDate()}.
   *
   * <p>Method under test: {@link PDAnnotationMarkup#getCreationDate()}
   */
  @Test
  @DisplayName("Test getCreationDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar PDAnnotationMarkup.getCreationDate()"})
  void testGetCreationDate() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationMarkup().getCreationDate());
  }

  /**
   * Test {@link PDAnnotationMarkup#setCreationDate(Calendar)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup()} CreationDate {@link
   *       GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setCreationDate(Calendar)}
   */
  @Test
  @DisplayName(
      "Test setCreationDate(Calendar); then PDAnnotationMarkup() CreationDate GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setCreationDate(Calendar)"})
  void testSetCreationDate_thenPDAnnotationMarkupCreationDateGregorianCalendar() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setCreationDate(new GregorianCalendar(1, 1, 1));

    // Assert
    Calendar creationDate = pdAnnotationMarkup.getCreationDate();
    assertTrue(creationDate instanceof GregorianCalendar);
    assertEquals("gregory", creationDate.getCalendarType());
    assertEquals(1, creationDate.getFirstDayOfWeek());
    assertEquals(1, creationDate.getMinimalDaysInFirstWeek());
    assertEquals(1, creationDate.getWeekYear());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(53, creationDate.getWeeksInWeekYear());
    assertFalse(creationDate.isLenient());
    assertTrue(creationDate.isWeekDateSupported());
  }

  /**
   * Test {@link PDAnnotationMarkup#setCreationDate(Calendar)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setCreationDate(Calendar)}
   */
  @Test
  @DisplayName(
      "Test setCreationDate(Calendar); when 'null'; then PDAnnotationMarkup() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setCreationDate(Calendar)"})
  void testSetCreationDate_whenNull_thenPDAnnotationMarkupCOSObjectValuesSizeIsOne() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setCreationDate(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationMarkup#getInReplyTo()}.
   *
   * <p>Method under test: {@link PDAnnotationMarkup#getInReplyTo()}
   */
  @Test
  @DisplayName("Test getInReplyTo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAnnotationMarkup.getInReplyTo()"})
  void testGetInReplyTo() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationMarkup().getInReplyTo());
  }

  /**
   * Test {@link PDAnnotationMarkup#setInReplyTo(PDAnnotation)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup()} InReplyTo {@link PDAnnotationCaret}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setInReplyTo(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test setInReplyTo(PDAnnotation); then PDAnnotationMarkup() InReplyTo PDAnnotationCaret")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setInReplyTo(PDAnnotation)"})
  void testSetInReplyTo_thenPDAnnotationMarkupInReplyToPDAnnotationCaret() throws IOException {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();
    PDAnnotationCaret irt = new PDAnnotationCaret();

    // Act
    pdAnnotationMarkup.setInReplyTo(irt);

    // Assert
    PDAnnotation inReplyTo = pdAnnotationMarkup.getInReplyTo();
    assertTrue(inReplyTo instanceof PDAnnotationCaret);
    assertEquals(irt, inReplyTo);
  }

  /**
   * Test {@link PDAnnotationMarkup#setInReplyTo(PDAnnotation)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup()} InReplyTo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setInReplyTo(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test setInReplyTo(PDAnnotation); when 'null'; then PDAnnotationMarkup() InReplyTo is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setInReplyTo(PDAnnotation)"})
  void testSetInReplyTo_whenNull_thenPDAnnotationMarkupInReplyToIsNull() throws IOException {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setInReplyTo(null);

    // Assert that nothing has changed
    assertNull(pdAnnotationMarkup.getInReplyTo());
  }

  /**
   * Test {@link PDAnnotationMarkup#getSubject()}.
   *
   * <p>Method under test: {@link PDAnnotationMarkup#getSubject()}
   */
  @Test
  @DisplayName("Test getSubject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationMarkup.getSubject()"})
  void testGetSubject() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationMarkup().getSubject());
  }

  /**
   * Test {@link PDAnnotationMarkup#setSubject(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setSubject(String)}
   */
  @Test
  @DisplayName(
      "Test setSubject(String); when 'null'; then PDAnnotationMarkup() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setSubject(String)"})
  void testSetSubject_whenNull_thenPDAnnotationMarkupCOSObjectValuesSizeIsOne() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setSubject(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationMarkup#setSubject(String)}.
   *
   * <ul>
   *   <li>When {@code Subj}.
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup()} Subject is {@code Subj}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setSubject(String)}
   */
  @Test
  @DisplayName("Test setSubject(String); when 'Subj'; then PDAnnotationMarkup() Subject is 'Subj'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setSubject(String)"})
  void testSetSubject_whenSubj_thenPDAnnotationMarkupSubjectIsSubj() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setSubject("Subj");

    // Assert
    assertEquals("Subj", pdAnnotationMarkup.getSubject());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationMarkup#getReplyType()}.
   *
   * <p>Method under test: {@link PDAnnotationMarkup#getReplyType()}
   */
  @Test
  @DisplayName("Test getReplyType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationMarkup.getReplyType()"})
  void testGetReplyType() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationMarkup.RT_REPLY, new PDAnnotationMarkup().getReplyType());
  }

  /**
   * Test {@link PDAnnotationMarkup#setReplyType(String)}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationMarkup#PDAnnotationMarkup()}.
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup()} ReplyType is {@code Rt}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setReplyType(String)}
   */
  @Test
  @DisplayName(
      "Test setReplyType(String); given PDAnnotationMarkup(); then PDAnnotationMarkup() ReplyType is 'Rt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setReplyType(String)"})
  void testSetReplyType_givenPDAnnotationMarkup_thenPDAnnotationMarkupReplyTypeIsRt() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setReplyType("Rt");

    // Assert
    assertEquals("Rt", pdAnnotationMarkup.getReplyType());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationMarkup#setReplyType(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()} ReplyType is {@code Rt}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setReplyType(String)}
   */
  @Test
  @DisplayName(
      "Test setReplyType(String); then PDAnnotationMarkup(COSDictionary) with dict is COSDictionary() ReplyType is 'Rt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setReplyType(String)"})
  void testSetReplyType_thenPDAnnotationMarkupWithDictIsCOSDictionaryReplyTypeIsRt() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup(new COSDictionary());

    // Act
    pdAnnotationMarkup.setReplyType("Rt");

    // Assert
    assertEquals("Rt", pdAnnotationMarkup.getReplyType());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationMarkup#setReplyType(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setReplyType(String)}
   */
  @Test
  @DisplayName(
      "Test setReplyType(String); when 'null'; then PDAnnotationMarkup() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setReplyType(String)"})
  void testSetReplyType_whenNull_thenPDAnnotationMarkupCOSObjectValuesSizeIsOne() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setReplyType(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(PDAnnotationMarkup.RT_REPLY, pdAnnotationMarkup.getReplyType());
  }

  /**
   * Test {@link PDAnnotationMarkup#getIntent()}.
   *
   * <p>Method under test: {@link PDAnnotationMarkup#getIntent()}
   */
  @Test
  @DisplayName("Test getIntent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationMarkup.getIntent()"})
  void testGetIntent() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationMarkup().getIntent());
  }

  /**
   * Test {@link PDAnnotationMarkup#setIntent(String)}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationMarkup#PDAnnotationMarkup()}.
   *   <li>When {@code It}.
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup()} Intent is {@code It}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setIntent(String)}
   */
  @Test
  @DisplayName(
      "Test setIntent(String); given PDAnnotationMarkup(); when 'It'; then PDAnnotationMarkup() Intent is 'It'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setIntent(String)"})
  void testSetIntent_givenPDAnnotationMarkup_whenIt_thenPDAnnotationMarkupIntentIsIt() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setIntent("It");

    // Assert
    assertEquals("It", pdAnnotationMarkup.getIntent());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationMarkup#setIntent(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()} Intent is {@code It}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setIntent(String)}
   */
  @Test
  @DisplayName(
      "Test setIntent(String); then PDAnnotationMarkup(COSDictionary) with dict is COSDictionary() Intent is 'It'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setIntent(String)"})
  void testSetIntent_thenPDAnnotationMarkupWithDictIsCOSDictionaryIntentIsIt() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup(new COSDictionary());

    // Act
    pdAnnotationMarkup.setIntent("It");

    // Assert
    assertEquals("It", pdAnnotationMarkup.getIntent());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationMarkup#setIntent(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setIntent(String)}
   */
  @Test
  @DisplayName(
      "Test setIntent(String); when 'null'; then PDAnnotationMarkup() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setIntent(String)"})
  void testSetIntent_whenNull_thenPDAnnotationMarkupCOSObjectValuesSizeIsOne() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setIntent(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationMarkup#getExternalData()}.
   *
   * <p>Method under test: {@link PDAnnotationMarkup#getExternalData()}
   */
  @Test
  @DisplayName("Test getExternalData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDExternalDataDictionary PDAnnotationMarkup.getExternalData()"})
  void testGetExternalData() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationMarkup().getExternalData());
  }

  /**
   * Test {@link PDAnnotationMarkup#setExternalData(PDExternalDataDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setExternalData(PDExternalDataDictionary)}
   */
  @Test
  @DisplayName(
      "Test setExternalData(PDExternalDataDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setExternalData(PDExternalDataDictionary)"})
  void testSetExternalData_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationMarkup.setExternalData(new PDExternalDataDictionary(dictionary));

    // Assert
    PDExternalDataDictionary externalData = pdAnnotationMarkup.getExternalData();
    assertEquals("ExData", externalData.getType());
    assertNull(externalData.getSubtype());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(dictionary, externalData.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationMarkup#setExternalData(PDExternalDataDictionary)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setExternalData(PDExternalDataDictionary)}
   */
  @Test
  @DisplayName(
      "Test setExternalData(PDExternalDataDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setExternalData(PDExternalDataDictionary)"})
  void testSetExternalData_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setDirect(true);

    // Act
    pdAnnotationMarkup.setExternalData(new PDExternalDataDictionary(dictionary));

    // Assert
    PDExternalDataDictionary externalData = pdAnnotationMarkup.getExternalData();
    assertEquals("ExData", externalData.getType());
    assertNull(externalData.getSubtype());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(dictionary, externalData.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationMarkup#setExternalData(PDExternalDataDictionary)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationMarkup#PDAnnotationMarkup()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setExternalData(PDExternalDataDictionary)}
   */
  @Test
  @DisplayName(
      "Test setExternalData(PDExternalDataDictionary); when 'null'; then PDAnnotationMarkup() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setExternalData(PDExternalDataDictionary)"})
  void testSetExternalData_whenNull_thenPDAnnotationMarkupCOSObjectValuesSizeIsOne() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setExternalData(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationMarkup#setExternalData(PDExternalDataDictionary)}.
   *
   * <ul>
   *   <li>When {@link PDExternalDataDictionary#PDExternalDataDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setExternalData(PDExternalDataDictionary)}
   */
  @Test
  @DisplayName("Test setExternalData(PDExternalDataDictionary); when PDExternalDataDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setExternalData(PDExternalDataDictionary)"})
  void testSetExternalData_whenPDExternalDataDictionary() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setExternalData(new PDExternalDataDictionary());

    // Assert
    PDExternalDataDictionary externalData = pdAnnotationMarkup.getExternalData();
    assertEquals("ExData", externalData.getType());
    assertNull(externalData.getSubtype());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationMarkup#setBorderStyle(PDBorderStyleDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName(
      "Test setBorderStyle(PDBorderStyleDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setBorderStyle(PDBorderStyleDictionary)"})
  void testSetBorderStyle_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationMarkup.setBorderStyle(new PDBorderStyleDictionary(dict));

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationMarkup.getBorderStyle();
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
   * Test {@link PDAnnotationMarkup#setBorderStyle(PDBorderStyleDictionary)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName(
      "Test setBorderStyle(PDBorderStyleDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setBorderStyle(PDBorderStyleDictionary)"})
  void testSetBorderStyle_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdAnnotationMarkup.setBorderStyle(new PDBorderStyleDictionary(dict));

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationMarkup.getBorderStyle();
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
   * Test {@link PDAnnotationMarkup#setBorderStyle(PDBorderStyleDictionary)}.
   *
   * <ul>
   *   <li>When {@link PDBorderStyleDictionary#PDBorderStyleDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationMarkup#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test setBorderStyle(PDBorderStyleDictionary); when PDBorderStyleDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationMarkup.setBorderStyle(PDBorderStyleDictionary)"})
  void testSetBorderStyle_whenPDBorderStyleDictionary() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setBorderStyle(new PDBorderStyleDictionary());

    // Assert
    PDLineDashPattern dashStyle = pdAnnotationMarkup.getBorderStyle().getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertArrayEquals(new float[] {3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationMarkup#getBorderStyle()}.
   *
   * <p>Method under test: {@link PDAnnotationMarkup#getBorderStyle()}
   */
  @Test
  @DisplayName("Test getBorderStyle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDBorderStyleDictionary PDAnnotationMarkup.getBorderStyle()"})
  void testGetBorderStyle() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationMarkup().getBorderStyle());
  }
}
