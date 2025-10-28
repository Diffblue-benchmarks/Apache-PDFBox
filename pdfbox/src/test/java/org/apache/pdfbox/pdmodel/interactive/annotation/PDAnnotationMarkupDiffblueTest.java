package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.junit.jupiter.api.Test;

class PDAnnotationMarkupDiffblueTest {
  /**
   * Method under test: {@link PDAnnotationMarkup#getTitlePopup()}
   */
  @Test
  void testGetTitlePopup() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationMarkup()).getTitlePopup());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#setTitlePopup(String)}
   */
  @Test
  void testSetTitlePopup() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setTitlePopup("foo");

    // Assert
    assertEquals("foo", pdAnnotationMarkup.getTitlePopup());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#getPopup()}
   */
  @Test
  void testGetPopup() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationMarkup()).getPopup());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#setPopup(PDAnnotationPopup)}
   */
  @Test
  void testSetPopup() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();
    PDAnnotationPopup popup = new PDAnnotationPopup();

    // Act
    pdAnnotationMarkup.setPopup(popup);

    // Assert
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(popup, pdAnnotationMarkup.getPopup());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#setPopup(PDAnnotationPopup)}
   */
  @Test
  void testSetPopup2() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setPopup(null);

    // Assert
    assertNull(pdAnnotationMarkup.getPopup());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#setPopup(PDAnnotationPopup)}
   */
  @Test
  void testSetPopup3() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    COSDictionary field = new COSDictionary();
    field.setDirect(true);
    PDAnnotationPopup popup = new PDAnnotationPopup(field);

    // Act
    pdAnnotationMarkup.setPopup(popup);

    // Assert
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(popup, pdAnnotationMarkup.getPopup());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#setPopup(PDAnnotationPopup)}
   */
  @Test
  void testSetPopup4() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    COSDictionary field = new COSDictionary();
    field.setKey(new COSObjectKey(1L, 1));
    PDAnnotationPopup popup = new PDAnnotationPopup(field);

    // Act
    pdAnnotationMarkup.setPopup(popup);

    // Assert
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(popup, pdAnnotationMarkup.getPopup());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#getConstantOpacity()}
   */
  @Test
  void testGetConstantOpacity() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDAnnotationMarkup()).getConstantOpacity());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#setConstantOpacity(float)}
   */
  @Test
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
   * Method under test: {@link PDAnnotationMarkup#getRichContents()}
   */
  @Test
  void testGetRichContents() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationMarkup()).getRichContents());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#setRichContents(String)}
   */
  @Test
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
   * Method under test: {@link PDAnnotationMarkup#getCreationDate()}
   */
  @Test
  void testGetCreationDate() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationMarkup()).getCreationDate());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#setCreationDate(Calendar)}
   */
  @Test
  void testSetCreationDate() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setCreationDate(new GregorianCalendar(1, 1, 1));

    // Assert
    Calendar creationDate = pdAnnotationMarkup.getCreationDate();
    assertTrue(creationDate instanceof GregorianCalendar);
    assertEquals("gregory", creationDate.getCalendarType());
    assertEquals(0, creationDate.getTimeZone().getDSTSavings());
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
   * Method under test: {@link PDAnnotationMarkup#setCreationDate(Calendar)}
   */
  @Test
  void testSetCreationDate2() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup(dict);

    // Act
    pdAnnotationMarkup.setCreationDate(new GregorianCalendar(1, 1, 1));

    // Assert
    Calendar creationDate = pdAnnotationMarkup.getCreationDate();
    assertTrue(creationDate instanceof GregorianCalendar);
    assertEquals("gregory", creationDate.getCalendarType());
    assertEquals(0, creationDate.getTimeZone().getDSTSavings());
    assertEquals(1, creationDate.getFirstDayOfWeek());
    assertEquals(1, creationDate.getMinimalDaysInFirstWeek());
    assertEquals(1, creationDate.getWeekYear());
    assertEquals(53, creationDate.getWeeksInWeekYear());
    assertFalse(creationDate.isLenient());
    assertTrue(creationDate.isWeekDateSupported());
    assertSame(dict, pdAnnotationMarkup.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#setCreationDate(Calendar)}
   */
  @Test
  void testSetCreationDate3() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setCreationDate(null);

    // Assert
    assertNull(pdAnnotationMarkup.getCreationDate());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#getInReplyTo()}
   */
  @Test
  void testGetInReplyTo() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationMarkup()).getInReplyTo());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#setInReplyTo(PDAnnotation)}
   */
  @Test
  void testSetInReplyTo() throws IOException {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();
    PDAnnotationCaret irt = new PDAnnotationCaret();

    // Act
    pdAnnotationMarkup.setInReplyTo(irt);

    // Assert
    PDAnnotation inReplyTo = pdAnnotationMarkup.getInReplyTo();
    assertTrue(inReplyTo instanceof PDAnnotationCaret);
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(irt, inReplyTo);
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#getSubject()}
   */
  @Test
  void testGetSubject() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationMarkup()).getSubject());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#setSubject(String)}
   */
  @Test
  void testSetSubject() {
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
   * Method under test: {@link PDAnnotationMarkup#getReplyType()}
   */
  @Test
  void testGetReplyType() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationMarkup.RT_REPLY, (new PDAnnotationMarkup()).getReplyType());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#setReplyType(String)}
   */
  @Test
  void testSetReplyType() {
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
   * Method under test: {@link PDAnnotationMarkup#setReplyType(String)}
   */
  @Test
  void testSetReplyType2() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup(dict);

    // Act
    pdAnnotationMarkup.setReplyType("Rt");

    // Assert
    assertEquals("Rt", pdAnnotationMarkup.getReplyType());
    assertSame(dict, pdAnnotationMarkup.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#getIntent()}
   */
  @Test
  void testGetIntent() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationMarkup()).getIntent());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#setIntent(String)}
   */
  @Test
  void testSetIntent() {
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
   * Method under test: {@link PDAnnotationMarkup#setIntent(String)}
   */
  @Test
  void testSetIntent2() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup(dict);

    // Act
    pdAnnotationMarkup.setIntent("It");

    // Assert
    assertEquals("It", pdAnnotationMarkup.getIntent());
    assertSame(dict, pdAnnotationMarkup.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#getExternalData()}
   */
  @Test
  void testGetExternalData() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationMarkup()).getExternalData());
  }

  /**
   * Method under test:
   * {@link PDAnnotationMarkup#setExternalData(PDExternalDataDictionary)}
   */
  @Test
  void testSetExternalData() {
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
   * Method under test:
   * {@link PDAnnotationMarkup#setExternalData(PDExternalDataDictionary)}
   */
  @Test
  void testSetExternalData2() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setExternalData(null);

    // Assert
    assertNull(pdAnnotationMarkup.getExternalData());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDAnnotationMarkup#setExternalData(PDExternalDataDictionary)}
   */
  @Test
  void testSetExternalData3() {
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
   * Method under test:
   * {@link PDAnnotationMarkup#setExternalData(PDExternalDataDictionary)}
   */
  @Test
  void testSetExternalData4() {
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
   * Method under test:
   * {@link PDAnnotationMarkup#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  void testSetBorderStyle() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setBorderStyle(new PDBorderStyleDictionary());

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationMarkup.getBorderStyle();
    PDLineDashPattern dashStyle = borderStyle.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1.0f, borderStyle.getWidth());
    COSDictionary cOSObject2 = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject2.getValues().size());
    assertEquals(2, cOSObject2.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderStyle.getStyle());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAnnotationMarkup#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  void testSetBorderStyle2() {
    // Arrange
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup();

    // Act
    pdAnnotationMarkup.setBorderStyle(null);

    // Assert
    assertNull(pdAnnotationMarkup.getBorderStyle());
    COSDictionary cOSObject = pdAnnotationMarkup.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDAnnotationMarkup#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  void testSetBorderStyle3() {
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
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1.0f, borderStyle.getWidth());
    COSDictionary cOSObject2 = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject2.getValues().size());
    assertEquals(2, cOSObject2.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderStyle.getStyle());
    assertSame(dict, borderStyle.getCOSObject());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAnnotationMarkup#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  void testSetBorderStyle4() {
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
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1.0f, borderStyle.getWidth());
    COSDictionary cOSObject2 = pdAnnotationMarkup.getCOSObject();
    assertEquals(2, cOSObject2.getValues().size());
    assertEquals(2, cOSObject2.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderStyle.getStyle());
    assertSame(dict, borderStyle.getCOSObject());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAnnotationMarkup#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  void testSetBorderStyle5() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAnnotationMarkup pdAnnotationMarkup = new PDAnnotationMarkup(dict);

    COSDictionary dict2 = new COSDictionary();
    dict2.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationMarkup.setBorderStyle(new PDBorderStyleDictionary(dict2));

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationMarkup.getBorderStyle();
    PDLineDashPattern dashStyle = borderStyle.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1.0f, borderStyle.getWidth());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderStyle.getStyle());
    assertSame(dict, pdAnnotationMarkup.getCOSObject());
    assertSame(dict2, borderStyle.getCOSObject());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationMarkup#getBorderStyle()}
   */
  @Test
  void testGetBorderStyle() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationMarkup()).getBorderStyle());
  }
}
