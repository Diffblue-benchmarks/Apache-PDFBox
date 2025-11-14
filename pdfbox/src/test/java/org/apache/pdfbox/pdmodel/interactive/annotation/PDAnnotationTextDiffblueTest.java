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
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDCircleAppearanceHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationTextDiffblueTest {
  /**
   * Test {@link PDAnnotationText#PDAnnotationText()}.
   *
   * <p>Method under test: {@link PDAnnotationText#PDAnnotationText()}
   */
  @Test
  @DisplayName("Test new PDAnnotationText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.<init>()"})
  void testNewPDAnnotationText() throws IOException {
    // Arrange and Act
    PDAnnotationText actualPdAnnotationText = new PDAnnotationText();

    // Assert
    assertNull(actualPdAnnotationText.getAnnotationName());
    assertNull(actualPdAnnotationText.getContents());
    assertNull(actualPdAnnotationText.getModifiedDate());
    assertNull(actualPdAnnotationText.getIntent());
    assertNull(actualPdAnnotationText.getRichContents());
    assertNull(actualPdAnnotationText.getSubject());
    assertNull(actualPdAnnotationText.getTitlePopup());
    assertNull(actualPdAnnotationText.getState());
    assertNull(actualPdAnnotationText.getStateModel());
    assertNull(actualPdAnnotationText.getCreationDate());
    assertNull(actualPdAnnotationText.getAppearanceState());
    assertNull(actualPdAnnotationText.getPage());
    assertNull(actualPdAnnotationText.getRectangle());
    assertNull(actualPdAnnotationText.getOptionalContent());
    assertNull(actualPdAnnotationText.getColor());
    assertNull(actualPdAnnotationText.getInReplyTo());
    assertNull(actualPdAnnotationText.getPopup());
    assertNull(actualPdAnnotationText.getAppearance());
    assertNull(actualPdAnnotationText.getNormalAppearanceStream());
    assertNull(actualPdAnnotationText.getBorderStyle());
    assertNull(actualPdAnnotationText.getExternalData());
    assertEquals(-1, actualPdAnnotationText.getStructParent());
    assertEquals(0, actualPdAnnotationText.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationText.getConstantOpacity());
    assertFalse(actualPdAnnotationText.isHidden());
    assertFalse(actualPdAnnotationText.isInvisible());
    assertFalse(actualPdAnnotationText.isLocked());
    assertFalse(actualPdAnnotationText.isLockedContents());
    assertFalse(actualPdAnnotationText.isNoRotate());
    assertFalse(actualPdAnnotationText.isNoView());
    assertFalse(actualPdAnnotationText.isNoZoom());
    assertFalse(actualPdAnnotationText.isPrinted());
    assertFalse(actualPdAnnotationText.isReadOnly());
    assertFalse(actualPdAnnotationText.isToggleNoView());
    assertFalse(actualPdAnnotationText.getOpen());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationText.getReplyType());
    assertEquals(PDAnnotationText.NAME_NOTE, actualPdAnnotationText.getName());
    assertEquals(PDAnnotationText.SUB_TYPE, actualPdAnnotationText.getSubtype());
  }

  /**
   * Test {@link PDAnnotationText#PDAnnotationText(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationText#PDAnnotationText(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationText(COSDictionary); when COSDictionary(); then COSDictionary() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.<init>(COSDictionary)"})
  void testNewPDAnnotationText_whenCOSDictionary_thenCOSDictionarySizeIsOne() {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationText actualPdAnnotationText = new PDAnnotationText(field);

    // Assert
    assertEquals(1, field.size());
    List<? extends COSBase> toListResult = actualPdAnnotationText.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(field, actualPdAnnotationText.getCOSObject());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationText#PDAnnotationText(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then {@link COSStream#COSStream()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationText#PDAnnotationText(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationText(COSDictionary); when COSStream(); then COSStream() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.<init>(COSDictionary)"})
  void testNewPDAnnotationText_whenCOSStream_thenCOSStreamSizeIsTwo() {
    // Arrange
    COSStream field = new COSStream();

    // Act
    PDAnnotationText actualPdAnnotationText = new PDAnnotationText(field);

    // Assert
    assertEquals(2, field.size());
    List<? extends COSBase> toListResult = actualPdAnnotationText.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(field, actualPdAnnotationText.getCOSObject());
    COSBase expectedGetResult = toListResult.get(0);
    assertSame(expectedGetResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationText#setOpen(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link PDAnnotationText#PDAnnotationText()} Open.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationText#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'false'; then not PDAnnotationText() Open")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.setOpen(boolean)"})
  void testSetOpen_whenFalse_thenNotPDAnnotationTextOpen() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setOpen(false);

    // Assert
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdAnnotationText.getOpen());
  }

  /**
   * Test {@link PDAnnotationText#setOpen(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDAnnotationText#PDAnnotationText()} Open.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationText#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'true'; then PDAnnotationText() Open")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.setOpen(boolean)"})
  void testSetOpen_whenTrue_thenPDAnnotationTextOpen() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setOpen(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdAnnotationText.getOpen());
  }

  /**
   * Test {@link PDAnnotationText#getOpen()}.
   *
   * <p>Method under test: {@link PDAnnotationText#getOpen()}
   */
  @Test
  @DisplayName("Test getOpen()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotationText.getOpen()"})
  void testGetOpen() {
    // Arrange, Act and Assert
    assertFalse(new PDAnnotationText().getOpen());
  }

  /**
   * Test {@link PDAnnotationText#setName(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link PDAnnotationText#PDAnnotationText()} Name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationText#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when '42'; then PDAnnotationText() Name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.setName(String)"})
  void testSetName_when42_thenPDAnnotationTextNameIs42() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setName("42");

    // Assert
    assertEquals("42", pdAnnotationText.getName());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationText#setName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then {@link PDAnnotationText#PDAnnotationText()} Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationText#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when 'Name'; then PDAnnotationText() Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.setName(String)"})
  void testSetName_whenName_thenPDAnnotationTextNameIsName() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setName("Name");

    // Assert
    assertEquals("Name", pdAnnotationText.getName());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationText#setName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationText#PDAnnotationText()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationText#setName(String)}
   */
  @Test
  @DisplayName(
      "Test setName(String); when 'null'; then PDAnnotationText() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.setName(String)"})
  void testSetName_whenNull_thenPDAnnotationTextCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setName(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(PDAnnotationText.NAME_NOTE, pdAnnotationText.getName());
  }

  /**
   * Test {@link PDAnnotationText#getName()}.
   *
   * <p>Method under test: {@link PDAnnotationText#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationText.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationText.NAME_NOTE, new PDAnnotationText().getName());
  }

  /**
   * Test {@link PDAnnotationText#getState()}.
   *
   * <p>Method under test: {@link PDAnnotationText#getState()}
   */
  @Test
  @DisplayName("Test getState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationText.getState()"})
  void testGetState() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationText().getState());
  }

  /**
   * Test {@link PDAnnotationText#setState(String)}.
   *
   * <ul>
   *   <li>When {@code MD}.
   *   <li>Then {@link PDAnnotationText#PDAnnotationText()} State is {@code MD}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationText#setState(String)}
   */
  @Test
  @DisplayName("Test setState(String); when 'MD'; then PDAnnotationText() State is 'MD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.setState(String)"})
  void testSetState_whenMd_thenPDAnnotationTextStateIsMd() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setState("MD");

    // Assert
    assertEquals("MD", pdAnnotationText.getState());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationText#setState(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationText#PDAnnotationText()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationText#setState(String)}
   */
  @Test
  @DisplayName(
      "Test setState(String); when 'null'; then PDAnnotationText() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.setState(String)"})
  void testSetState_whenNull_thenPDAnnotationTextCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setState(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationText#getStateModel()}.
   *
   * <p>Method under test: {@link PDAnnotationText#getStateModel()}
   */
  @Test
  @DisplayName("Test getStateModel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationText.getStateModel()"})
  void testGetStateModel() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationText().getStateModel());
  }

  /**
   * Test {@link PDAnnotationText#setStateModel(String)}.
   *
   * <ul>
   *   <li>When {@code MD}.
   *   <li>Then {@link PDAnnotationText#PDAnnotationText()} StateModel is {@code MD}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationText#setStateModel(String)}
   */
  @Test
  @DisplayName("Test setStateModel(String); when 'MD'; then PDAnnotationText() StateModel is 'MD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.setStateModel(String)"})
  void testSetStateModel_whenMd_thenPDAnnotationTextStateModelIsMd() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setStateModel("MD");

    // Assert
    assertEquals("MD", pdAnnotationText.getStateModel());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationText#setStateModel(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationText#PDAnnotationText()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationText#setStateModel(String)}
   */
  @Test
  @DisplayName(
      "Test setStateModel(String); when 'null'; then PDAnnotationText() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.setStateModel(String)"})
  void testSetStateModel_whenNull_thenPDAnnotationTextCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setStateModel(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationText#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.constructAppearances()"})
  void testConstructAppearances() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();
    pdAnnotationText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationText.constructAppearances();

    // Assert
    COSDictionary cOSObject = pdAnnotationText.getAppearance().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    float[][] values = pdAnnotationText.getNormalAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationText#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.constructAppearances()"})
  void testConstructAppearances2() {
    // Arrange
    PDAnnotationCircle annotation = new PDAnnotationCircle();
    PDRectangle rectangle =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    annotation.setRectangle(rectangle);
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationText pdAnnotationText = new PDAnnotationText(new COSDictionary());
    pdAnnotationText.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationText.constructAppearances();

    // Assert that nothing has changed
    assertEquals(0, pdAnnotationText.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdAnnotationText.isNoRotate());
    assertFalse(pdAnnotationText.isNoZoom());
  }

  /**
   * Test {@link PDAnnotationText#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.constructAppearances()"})
  void testConstructAppearances3() throws IOException {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();
    pdAnnotationText.setRectangle(PDRectangle.A0);
    pdAnnotationText.setAppearance(new PDAppearanceDictionary(new COSDictionary()));

    // Act
    pdAnnotationText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationText.getNormalAppearanceStream();
    assertTrue(
        normalAppearanceStream.getContentsForStreamParsing() instanceof RandomAccessReadBuffer);
    assertTrue(
        normalAppearanceStream.getContentsForRandomAccess() instanceof RandomAccessReadBuffer);
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(1, normalAppearanceStream.getFormType());
    PDRectangle rectangle = pdAnnotationText.getRectangle();
    assertEquals(18.0f, rectangle.getUpperRightX());
    assertEquals(18.0f, rectangle.getWidth());
    assertEquals(20.0f, rectangle.getHeight());
    assertEquals(24, pdAnnotationText.getAnnotationFlags());
    assertEquals(3350.3938f, rectangle.getLowerLeftY());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    assertTrue(pdAnnotationText.isNoRotate());
    assertTrue(pdAnnotationText.isNoZoom());
    assertArrayEquals(
        "1 g\n4 M\n1 j\n0 J\n0.61 w\n1 1 16 18 re\n4.5 5.7143 m\n12".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationText#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.constructAppearances()"})
  void testConstructAppearances4() throws IOException {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));
    PDAppearanceDictionary appearance = new PDAppearanceDictionary(dictionary);

    PDAnnotationText pdAnnotationText = new PDAnnotationText();
    pdAnnotationText.setRectangle(PDRectangle.A0);
    pdAnnotationText.setAppearance(appearance);

    // Act
    pdAnnotationText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationText.getNormalAppearanceStream();
    assertTrue(
        normalAppearanceStream.getContentsForStreamParsing() instanceof RandomAccessReadBuffer);
    assertTrue(
        normalAppearanceStream.getContentsForRandomAccess() instanceof RandomAccessReadBuffer);
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(1, normalAppearanceStream.getFormType());
    PDRectangle rectangle = pdAnnotationText.getRectangle();
    assertEquals(18.0f, rectangle.getUpperRightX());
    assertEquals(18.0f, rectangle.getWidth());
    assertEquals(20.0f, rectangle.getHeight());
    assertEquals(24, pdAnnotationText.getAnnotationFlags());
    assertEquals(3350.3938f, rectangle.getLowerLeftY());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    assertTrue(pdAnnotationText.isNoRotate());
    assertTrue(pdAnnotationText.isNoZoom());
    assertArrayEquals(
        "1 g\n4 M\n1 j\n0 J\n0.61 w\n1 1 16 18 re\n4.5 5.7143 m\n12".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then array length is three.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenArrayLengthIsThree() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();
    pdAnnotationText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationText.constructAppearances(new PDDocument());

    // Assert
    float[][] values = pdAnnotationText.getNormalAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then array length is three.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; when 'null'; then array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_whenNull_thenArrayLengthIsThree() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();
    pdAnnotationText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationText.constructAppearances(null);

    // Assert
    float[][] values = pdAnnotationText.getNormalAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationText#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationCircle#PDAnnotationCircle()} Rectangle is {@link
   *       PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDAnnotationCircle() Rectangle is A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationText.constructAppearances()"})
  void testConstructAppearances_givenPDAnnotationCircleRectangleIsA0() {
    // Arrange
    PDAnnotationCircle annotation = new PDAnnotationCircle();
    annotation.setRectangle(PDRectangle.A0);
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationText pdAnnotationText = new PDAnnotationText(new COSDictionary());
    pdAnnotationText.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationText.constructAppearances();

    // Assert that nothing has changed
    assertEquals(0, pdAnnotationText.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdAnnotationText.isNoRotate());
    assertFalse(pdAnnotationText.isNoZoom());
  }
}
