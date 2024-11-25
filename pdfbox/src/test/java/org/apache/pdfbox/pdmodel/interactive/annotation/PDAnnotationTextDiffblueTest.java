package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDCircleAppearanceHandler;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDAnnotationTextDiffblueTest {
  /**
   * Test {@link PDAnnotationText#PDAnnotationText()}.
   * <p>
   * Method under test: {@link PDAnnotationText#PDAnnotationText()}
   */
  @Test
  @DisplayName("Test new PDAnnotationText()")
  void testNewPDAnnotationText() throws IOException {
    // Arrange and Act
    PDAnnotationText actualPdAnnotationText = new PDAnnotationText();

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationText.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
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
    COSDictionary cOSObject = actualPdAnnotationText.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdAnnotationText.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cOSObject.getKey());
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
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
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
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationText.getReplyType());
    assertEquals(PDAnnotationText.NAME_NOTE, actualPdAnnotationText.getName());
    assertEquals(PDAnnotationText.SUB_TYPE, actualPdAnnotationText.getSubtype());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationText#PDAnnotationText(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#PDAnnotationText(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationText(COSDictionary); when COSDictionary(); then COSDictionary() size is one")
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
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationText#PDAnnotationText(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link COSStream#COSStream()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#PDAnnotationText(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationText(COSDictionary); when COSStream(); then COSStream() size is two")
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
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationText#setOpen(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDAnnotationText#PDAnnotationText()} Open.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'false'; then not PDAnnotationText() Open")
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
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDAnnotationText#PDAnnotationText()} Open.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#setOpen(boolean)}
   */
  @Test
  @DisplayName("Test setOpen(boolean); when 'true'; then PDAnnotationText() Open")
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
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} addAll
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#getOpen()}
   */
  @Test
  @DisplayName("Test getOpen(); given COSDictionary() addAll COSDictionary()")
  void testGetOpen_givenCOSDictionaryAddAllCOSDictionary() {
    // Arrange
    COSDictionary field = new COSDictionary();
    field.addAll(new COSDictionary());

    // Act and Assert
    assertFalse((new PDAnnotationText(field)).getOpen());
  }

  /**
   * Test {@link PDAnnotationText#getOpen()}.
   * <ul>
   *   <li>Given {@link PDAnnotationText#PDAnnotationText()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#getOpen()}
   */
  @Test
  @DisplayName("Test getOpen(); given PDAnnotationText()")
  void testGetOpen_givenPDAnnotationText() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationText()).getOpen());
  }

  /**
   * Test {@link PDAnnotationText#setName(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then {@link PDAnnotationText#PDAnnotationText()} Name is
   * {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when 'Name'; then PDAnnotationText() Name is 'Name'")
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
   * <ul>
   *   <li>When {@code Open}.</li>
   *   <li>Then {@link PDAnnotationText#PDAnnotationText()} Name is
   * {@code Open}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when 'Open'; then PDAnnotationText() Name is 'Open'")
  void testSetName_whenOpen_thenPDAnnotationTextNameIsOpen() {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();

    // Act
    pdAnnotationText.setName("Open");

    // Assert
    assertEquals("Open", pdAnnotationText.getName());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationText#getName()}.
   * <p>
   * Method under test: {@link PDAnnotationText#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationText.NAME_NOTE, (new PDAnnotationText()).getName());
  }

  /**
   * Test {@link PDAnnotationText#getState()}.
   * <p>
   * Method under test: {@link PDAnnotationText#getState()}
   */
  @Test
  @DisplayName("Test getState()")
  void testGetState() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationText()).getState());
  }

  /**
   * Test {@link PDAnnotationText#setState(String)}.
   * <p>
   * Method under test: {@link PDAnnotationText#setState(String)}
   */
  @Test
  @DisplayName("Test setState(String)")
  void testSetState() {
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
   * Test {@link PDAnnotationText#getStateModel()}.
   * <p>
   * Method under test: {@link PDAnnotationText#getStateModel()}
   */
  @Test
  @DisplayName("Test getStateModel()")
  void testGetStateModel() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationText()).getStateModel());
  }

  /**
   * Test {@link PDAnnotationText#setStateModel(String)}.
   * <p>
   * Method under test: {@link PDAnnotationText#setStateModel(String)}
   */
  @Test
  @DisplayName("Test setStateModel(String)")
  void testSetStateModel() {
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
   * Test {@link PDAnnotationText#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances() throws IOException {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();
    pdAnnotationText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationText.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    COSArray cOSArray = bBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationText.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    PDStream stream = normalAppearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream stream3 = appearanceStream2.getStream();
    assertNull(stream3.getDecodeParms());
    PDStream stream4 = appearanceStream3.getStream();
    assertNull(stream4.getDecodeParms());
    PDStream contentStream = normalAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream2.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    PDStream contentStream4 = appearanceStream3.getContentStream();
    assertNull(contentStream4.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(contentStream4.getFileDecodeParams());
    COSStream cOSObject = normalAppearanceStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = appearance.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(resources.getResourceCache());
    PDResources resources2 = appearanceStream.getResources();
    assertNull(resources2.getResourceCache());
    PDResources resources3 = appearanceStream2.getResources();
    assertNull(resources3.getResourceCache());
    PDResources resources4 = appearanceStream3.getResources();
    assertNull(resources4.getResourceCache());
    assertNull(stream.getMetadata());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(contentStream4.getMetadata());
    assertNull(stream.getFile());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(contentStream4.getFile());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, contentStream4.getDecodedStreamLength());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox3.getLowerLeftY());
    assertEquals(0.0f, bBox4.getLowerLeftY());
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(0L, contentsForStreamParsing2.getPosition());
    assertEquals(0L, contentsForStreamParsing3.getPosition());
    assertEquals(0L, contentsForStreamParsing4.getPosition());
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForRandomAccess2.getPosition());
    assertEquals(0L, contentsForRandomAccess3.getPosition());
    assertEquals(0L, contentsForRandomAccess4.getPosition());
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(150, contentsForStreamParsing.available());
    assertEquals(150, contentsForStreamParsing2.available());
    assertEquals(150, contentsForStreamParsing3.available());
    assertEquals(150, contentsForStreamParsing4.available());
    assertEquals(150, contentsForRandomAccess.available());
    assertEquals(150, contentsForRandomAccess2.available());
    assertEquals(150, contentsForRandomAccess3.available());
    assertEquals(150, contentsForRandomAccess4.available());
    assertEquals(150, stream.getLength());
    assertEquals(150, stream2.getLength());
    assertEquals(150, stream3.getLength());
    assertEquals(150, stream4.getLength());
    assertEquals(150, contentStream.getLength());
    assertEquals(150, contentStream2.getLength());
    assertEquals(150, contentStream3.getLength());
    assertEquals(150, contentStream4.getLength());
    assertEquals(150L, cOSObject.getLength());
    assertEquals(18.0f, bBox.getUpperRightX());
    assertEquals(18.0f, bBox2.getUpperRightX());
    assertEquals(18.0f, bBox3.getUpperRightX());
    assertEquals(18.0f, bBox4.getUpperRightX());
    PDRectangle rectangle = pdAnnotationText.getRectangle();
    assertEquals(18.0f, rectangle.getUpperRightX());
    assertEquals(18.0f, bBox.getWidth());
    assertEquals(18.0f, bBox2.getWidth());
    assertEquals(18.0f, bBox3.getWidth());
    assertEquals(18.0f, bBox4.getWidth());
    assertEquals(18.0f, rectangle.getWidth());
    assertEquals(20.0f, bBox.getHeight());
    assertEquals(20.0f, bBox2.getHeight());
    assertEquals(20.0f, bBox3.getHeight());
    assertEquals(20.0f, bBox4.getHeight());
    assertEquals(20.0f, rectangle.getHeight());
    assertEquals(20.0f, bBox.getUpperRightY());
    assertEquals(20.0f, bBox2.getUpperRightY());
    assertEquals(20.0f, bBox3.getUpperRightY());
    assertEquals(20.0f, bBox4.getUpperRightY());
    assertEquals(24, pdAnnotationText.getAnnotationFlags());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(3350.3938f, rectangle.getLowerLeftY());
    COSDictionary cOSObject4 = pdAnnotationText.getCOSObject();
    assertEquals(5, cOSObject4.getValues().size());
    assertEquals(5, cOSObject4.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject4.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    COSIncrement toIncrementResult4 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult4.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(contentsForStreamParsing.isClosed());
    assertFalse(contentsForStreamParsing2.isClosed());
    assertFalse(contentsForStreamParsing3.isClosed());
    assertFalse(contentsForStreamParsing4.isClosed());
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForRandomAccess2.isClosed());
    assertFalse(contentsForRandomAccess3.isClosed());
    assertFalse(contentsForRandomAccess4.isClosed());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(cOSObject2.getValues().isEmpty());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(toIncrementResult4.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(pdAnnotationText.isNoRotate());
    assertTrue(pdAnnotationText.isNoZoom());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    COSArray cOSArray2 = bBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    COSArray cOSArray3 = bBox3.getCOSArray();
    assertEquals(toListResult, cOSArray3.toList());
    COSArray cOSArray4 = bBox4.getCOSArray();
    assertEquals(toListResult, cOSArray4.toList());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    assertSame(cOSArray, bBox.getCOSObject());
    assertSame(cOSArray2, bBox2.getCOSObject());
    assertSame(cOSArray3, bBox3.getCOSObject());
    assertSame(cOSArray4, bBox4.getCOSObject());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream3.getFileFilters());
    assertSame(fileFilters, stream4.getFileFilters());
    assertSame(fileFilters, contentStream2.getFileFilters());
    assertSame(fileFilters, contentStream3.getFileFilters());
    assertSame(fileFilters, contentStream4.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, stream3.getFilters());
    assertSame(fileFilters, stream4.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(fileFilters, contentStream2.getFilters());
    assertSame(fileFilters, contentStream3.getFilters());
    assertSame(fileFilters, contentStream4.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, stream2.getCOSObject());
    assertSame(cOSObject, stream3.getCOSObject());
    assertSame(cOSObject, stream4.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, contentStream2.getCOSObject());
    assertSame(cOSObject, contentStream3.getCOSObject());
    assertSame(cOSObject, contentStream4.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, appearanceStream3.getCOSObject());
    assertSame(cOSObject, downAppearance.getCOSObject());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources3.getColorSpaceNames());
    assertSame(colorSpaceNames, resources4.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources3.getExtGStateNames());
    assertSame(colorSpaceNames, resources4.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources3.getFontNames());
    assertSame(colorSpaceNames, resources4.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources3.getPatternNames());
    assertSame(colorSpaceNames, resources4.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources3.getPropertiesNames());
    assertSame(colorSpaceNames, resources4.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources3.getShadingNames());
    assertSame(colorSpaceNames, resources4.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(colorSpaceNames, resources3.getXObjectNames());
    assertSame(colorSpaceNames, resources4.getXObjectNames());
    assertArrayEquals("1 g\n4 M\n1 j\n0 J\n0.61 w\n1 1 16 18 re\n4.5 5.7143 m\n12".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("1 g\n4 M\n1 j\n0 J\n0.61 w\n1 1 16 18 re\n4.5 5.7143 m\n12".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("1 g\n4 M\n1 j\n0 J\n0.61 w\n1 1 16 18 re\n4.5 5.7143 m\n12".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("1 g\n4 M\n1 j\n0 J\n0.61 w\n1 1 16 18 re\n4.5 5.7143 m\n12".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationText#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances2() {
    // Arrange
    PDAnnotationCircle annotation = new PDAnnotationCircle();
    annotation.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationText pdAnnotationText = new PDAnnotationText();
    pdAnnotationText.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationText.constructAppearances();

    // Assert
    assertEquals(0, pdAnnotationText.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(pdAnnotationText.isNoRotate());
    assertFalse(pdAnnotationText.isNoZoom());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDAnnotationText#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument() throws IOException {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();
    pdAnnotationText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationText.constructAppearances(new PDDocument());

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationText.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    COSArray cOSArray = bBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationText.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    PDStream stream = normalAppearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream stream3 = appearanceStream2.getStream();
    assertNull(stream3.getDecodeParms());
    PDStream stream4 = appearanceStream3.getStream();
    assertNull(stream4.getDecodeParms());
    PDStream contentStream = normalAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream2.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    PDStream contentStream4 = appearanceStream3.getContentStream();
    assertNull(contentStream4.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(contentStream4.getFileDecodeParams());
    COSStream cOSObject = normalAppearanceStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = appearance.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(resources.getResourceCache());
    PDResources resources2 = appearanceStream.getResources();
    assertNull(resources2.getResourceCache());
    PDResources resources3 = appearanceStream2.getResources();
    assertNull(resources3.getResourceCache());
    PDResources resources4 = appearanceStream3.getResources();
    assertNull(resources4.getResourceCache());
    assertNull(stream.getMetadata());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(contentStream4.getMetadata());
    assertNull(stream.getFile());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(contentStream4.getFile());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, contentStream4.getDecodedStreamLength());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox3.getLowerLeftY());
    assertEquals(0.0f, bBox4.getLowerLeftY());
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(0L, contentsForStreamParsing2.getPosition());
    assertEquals(0L, contentsForStreamParsing3.getPosition());
    assertEquals(0L, contentsForStreamParsing4.getPosition());
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForRandomAccess2.getPosition());
    assertEquals(0L, contentsForRandomAccess3.getPosition());
    assertEquals(0L, contentsForRandomAccess4.getPosition());
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(150, contentsForStreamParsing.available());
    assertEquals(150, contentsForStreamParsing2.available());
    assertEquals(150, contentsForStreamParsing3.available());
    assertEquals(150, contentsForStreamParsing4.available());
    assertEquals(150, contentsForRandomAccess.available());
    assertEquals(150, contentsForRandomAccess2.available());
    assertEquals(150, contentsForRandomAccess3.available());
    assertEquals(150, contentsForRandomAccess4.available());
    assertEquals(150, stream.getLength());
    assertEquals(150, stream2.getLength());
    assertEquals(150, stream3.getLength());
    assertEquals(150, stream4.getLength());
    assertEquals(150, contentStream.getLength());
    assertEquals(150, contentStream2.getLength());
    assertEquals(150, contentStream3.getLength());
    assertEquals(150, contentStream4.getLength());
    assertEquals(150L, cOSObject.getLength());
    assertEquals(18.0f, bBox.getUpperRightX());
    assertEquals(18.0f, bBox2.getUpperRightX());
    assertEquals(18.0f, bBox3.getUpperRightX());
    assertEquals(18.0f, bBox4.getUpperRightX());
    PDRectangle rectangle = pdAnnotationText.getRectangle();
    assertEquals(18.0f, rectangle.getUpperRightX());
    assertEquals(18.0f, bBox.getWidth());
    assertEquals(18.0f, bBox2.getWidth());
    assertEquals(18.0f, bBox3.getWidth());
    assertEquals(18.0f, bBox4.getWidth());
    assertEquals(18.0f, rectangle.getWidth());
    assertEquals(20.0f, bBox.getHeight());
    assertEquals(20.0f, bBox2.getHeight());
    assertEquals(20.0f, bBox3.getHeight());
    assertEquals(20.0f, bBox4.getHeight());
    assertEquals(20.0f, rectangle.getHeight());
    assertEquals(20.0f, bBox.getUpperRightY());
    assertEquals(20.0f, bBox2.getUpperRightY());
    assertEquals(20.0f, bBox3.getUpperRightY());
    assertEquals(20.0f, bBox4.getUpperRightY());
    assertEquals(24, pdAnnotationText.getAnnotationFlags());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(3350.3938f, rectangle.getLowerLeftY());
    COSDictionary cOSObject4 = pdAnnotationText.getCOSObject();
    assertEquals(5, cOSObject4.getValues().size());
    assertEquals(5, cOSObject4.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject4.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    COSIncrement toIncrementResult4 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult4.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(contentsForStreamParsing.isClosed());
    assertFalse(contentsForStreamParsing2.isClosed());
    assertFalse(contentsForStreamParsing3.isClosed());
    assertFalse(contentsForStreamParsing4.isClosed());
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForRandomAccess2.isClosed());
    assertFalse(contentsForRandomAccess3.isClosed());
    assertFalse(contentsForRandomAccess4.isClosed());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(cOSObject2.getValues().isEmpty());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(toIncrementResult4.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(pdAnnotationText.isNoRotate());
    assertTrue(pdAnnotationText.isNoZoom());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    COSArray cOSArray2 = bBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    COSArray cOSArray3 = bBox3.getCOSArray();
    assertEquals(toListResult, cOSArray3.toList());
    COSArray cOSArray4 = bBox4.getCOSArray();
    assertEquals(toListResult, cOSArray4.toList());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    assertSame(cOSArray, bBox.getCOSObject());
    assertSame(cOSArray2, bBox2.getCOSObject());
    assertSame(cOSArray3, bBox3.getCOSObject());
    assertSame(cOSArray4, bBox4.getCOSObject());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream3.getFileFilters());
    assertSame(fileFilters, stream4.getFileFilters());
    assertSame(fileFilters, contentStream2.getFileFilters());
    assertSame(fileFilters, contentStream3.getFileFilters());
    assertSame(fileFilters, contentStream4.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, stream3.getFilters());
    assertSame(fileFilters, stream4.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(fileFilters, contentStream2.getFilters());
    assertSame(fileFilters, contentStream3.getFilters());
    assertSame(fileFilters, contentStream4.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, stream2.getCOSObject());
    assertSame(cOSObject, stream3.getCOSObject());
    assertSame(cOSObject, stream4.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, contentStream2.getCOSObject());
    assertSame(cOSObject, contentStream3.getCOSObject());
    assertSame(cOSObject, contentStream4.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, appearanceStream3.getCOSObject());
    assertSame(cOSObject, downAppearance.getCOSObject());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources3.getColorSpaceNames());
    assertSame(colorSpaceNames, resources4.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources3.getExtGStateNames());
    assertSame(colorSpaceNames, resources4.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources3.getFontNames());
    assertSame(colorSpaceNames, resources4.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources3.getPatternNames());
    assertSame(colorSpaceNames, resources4.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources3.getPropertiesNames());
    assertSame(colorSpaceNames, resources4.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources3.getShadingNames());
    assertSame(colorSpaceNames, resources4.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(colorSpaceNames, resources3.getXObjectNames());
    assertSame(colorSpaceNames, resources4.getXObjectNames());
    assertArrayEquals("1 g\n4 M\n1 j\n0 J\n0.61 w\n1 1 16 18 re\n4.5 5.7143 m\n12".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("1 g\n4 M\n1 j\n0 J\n0.61 w\n1 1 16 18 re\n4.5 5.7143 m\n12".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("1 g\n4 M\n1 j\n0 J\n0.61 w\n1 1 16 18 re\n4.5 5.7143 m\n12".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("1 g\n4 M\n1 j\n0 J\n0.61 w\n1 1 16 18 re\n4.5 5.7143 m\n12".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationText#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument2() {
    // Arrange
    PDAnnotationCircle annotation = new PDAnnotationCircle();
    annotation.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationText pdAnnotationText = new PDAnnotationText();
    pdAnnotationText.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationText.constructAppearances(new PDDocument());

    // Assert
    assertEquals(0, pdAnnotationText.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(pdAnnotationText.isNoRotate());
    assertFalse(pdAnnotationText.isNoZoom());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDAnnotationText#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link PDAnnotationCircle#PDAnnotationCircle()} Rectangle is
   * {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given PDAnnotationCircle() Rectangle is A0")
  void testConstructAppearancesWithPDDocument_givenPDAnnotationCircleRectangleIsA0() {
    // Arrange
    PDAnnotationCircle annotation = new PDAnnotationCircle();
    annotation.setRectangle(PDRectangle.A0);
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationText pdAnnotationText = new PDAnnotationText();
    pdAnnotationText.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationText.constructAppearances(new PDDocument());

    // Assert
    assertEquals(0, pdAnnotationText.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(pdAnnotationText.isNoRotate());
    assertFalse(pdAnnotationText.isNoZoom());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDAnnotationText#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; when 'null'")
  void testConstructAppearancesWithPDDocument_whenNull() throws IOException {
    // Arrange
    PDAnnotationText pdAnnotationText = new PDAnnotationText();
    pdAnnotationText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationText.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    COSArray cOSArray = bBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationText.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
    RandomAccessRead contentsForStreamParsing4 = appearanceStream3.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing4 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess2 = appearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess2 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess3 = appearanceStream2.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess3 instanceof RandomAccessReadBuffer);
    RandomAccessRead contentsForRandomAccess4 = appearanceStream3.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess4 instanceof RandomAccessReadBuffer);
    PDStream stream = normalAppearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream stream3 = appearanceStream2.getStream();
    assertNull(stream3.getDecodeParms());
    PDStream stream4 = appearanceStream3.getStream();
    assertNull(stream4.getDecodeParms());
    PDStream contentStream = normalAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream2.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    PDStream contentStream4 = appearanceStream3.getContentStream();
    assertNull(contentStream4.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(contentStream4.getFileDecodeParams());
    COSStream cOSObject = normalAppearanceStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = appearance.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(resources.getResourceCache());
    PDResources resources2 = appearanceStream.getResources();
    assertNull(resources2.getResourceCache());
    PDResources resources3 = appearanceStream2.getResources();
    assertNull(resources3.getResourceCache());
    PDResources resources4 = appearanceStream3.getResources();
    assertNull(resources4.getResourceCache());
    assertNull(stream.getMetadata());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(contentStream4.getMetadata());
    assertNull(stream.getFile());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(contentStream4.getFile());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, contentStream4.getDecodedStreamLength());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox3.getLowerLeftY());
    assertEquals(0.0f, bBox4.getLowerLeftY());
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0L, contentsForStreamParsing.getPosition());
    assertEquals(0L, contentsForStreamParsing2.getPosition());
    assertEquals(0L, contentsForStreamParsing3.getPosition());
    assertEquals(0L, contentsForStreamParsing4.getPosition());
    assertEquals(0L, contentsForRandomAccess.getPosition());
    assertEquals(0L, contentsForRandomAccess2.getPosition());
    assertEquals(0L, contentsForRandomAccess3.getPosition());
    assertEquals(0L, contentsForRandomAccess4.getPosition());
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(150, contentsForStreamParsing.available());
    assertEquals(150, contentsForStreamParsing2.available());
    assertEquals(150, contentsForStreamParsing3.available());
    assertEquals(150, contentsForStreamParsing4.available());
    assertEquals(150, contentsForRandomAccess.available());
    assertEquals(150, contentsForRandomAccess2.available());
    assertEquals(150, contentsForRandomAccess3.available());
    assertEquals(150, contentsForRandomAccess4.available());
    assertEquals(150, stream.getLength());
    assertEquals(150, stream2.getLength());
    assertEquals(150, stream3.getLength());
    assertEquals(150, stream4.getLength());
    assertEquals(150, contentStream.getLength());
    assertEquals(150, contentStream2.getLength());
    assertEquals(150, contentStream3.getLength());
    assertEquals(150, contentStream4.getLength());
    assertEquals(150L, cOSObject.getLength());
    assertEquals(18.0f, bBox.getUpperRightX());
    assertEquals(18.0f, bBox2.getUpperRightX());
    assertEquals(18.0f, bBox3.getUpperRightX());
    assertEquals(18.0f, bBox4.getUpperRightX());
    PDRectangle rectangle = pdAnnotationText.getRectangle();
    assertEquals(18.0f, rectangle.getUpperRightX());
    assertEquals(18.0f, bBox.getWidth());
    assertEquals(18.0f, bBox2.getWidth());
    assertEquals(18.0f, bBox3.getWidth());
    assertEquals(18.0f, bBox4.getWidth());
    assertEquals(18.0f, rectangle.getWidth());
    assertEquals(20.0f, bBox.getHeight());
    assertEquals(20.0f, bBox2.getHeight());
    assertEquals(20.0f, bBox3.getHeight());
    assertEquals(20.0f, bBox4.getHeight());
    assertEquals(20.0f, rectangle.getHeight());
    assertEquals(20.0f, bBox.getUpperRightY());
    assertEquals(20.0f, bBox2.getUpperRightY());
    assertEquals(20.0f, bBox3.getUpperRightY());
    assertEquals(20.0f, bBox4.getUpperRightY());
    assertEquals(24, pdAnnotationText.getAnnotationFlags());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(3350.3938f, rectangle.getLowerLeftY());
    COSDictionary cOSObject4 = pdAnnotationText.getCOSObject();
    assertEquals(5, cOSObject4.getValues().size());
    assertEquals(5, cOSObject4.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject4.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    COSIncrement toIncrementResult4 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult4.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(contentsForStreamParsing.isClosed());
    assertFalse(contentsForStreamParsing2.isClosed());
    assertFalse(contentsForStreamParsing3.isClosed());
    assertFalse(contentsForStreamParsing4.isClosed());
    assertFalse(contentsForRandomAccess.isClosed());
    assertFalse(contentsForRandomAccess2.isClosed());
    assertFalse(contentsForRandomAccess3.isClosed());
    assertFalse(contentsForRandomAccess4.isClosed());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(cOSObject2.getValues().isEmpty());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(toIncrementResult4.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(pdAnnotationText.isNoRotate());
    assertTrue(pdAnnotationText.isNoZoom());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    COSArray cOSArray2 = bBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    COSArray cOSArray3 = bBox3.getCOSArray();
    assertEquals(toListResult, cOSArray3.toList());
    COSArray cOSArray4 = bBox4.getCOSArray();
    assertEquals(toListResult, cOSArray4.toList());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    assertSame(cOSArray, bBox.getCOSObject());
    assertSame(cOSArray2, bBox2.getCOSObject());
    assertSame(cOSArray3, bBox3.getCOSObject());
    assertSame(cOSArray4, bBox4.getCOSObject());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream2.getFileFilters());
    assertSame(fileFilters, stream3.getFileFilters());
    assertSame(fileFilters, stream4.getFileFilters());
    assertSame(fileFilters, contentStream2.getFileFilters());
    assertSame(fileFilters, contentStream3.getFileFilters());
    assertSame(fileFilters, contentStream4.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, stream2.getFilters());
    assertSame(fileFilters, stream3.getFilters());
    assertSame(fileFilters, stream4.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(fileFilters, contentStream2.getFilters());
    assertSame(fileFilters, contentStream3.getFilters());
    assertSame(fileFilters, contentStream4.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, stream2.getCOSObject());
    assertSame(cOSObject, stream3.getCOSObject());
    assertSame(cOSObject, stream4.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, contentStream2.getCOSObject());
    assertSame(cOSObject, contentStream3.getCOSObject());
    assertSame(cOSObject, contentStream4.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, appearanceStream3.getCOSObject());
    assertSame(cOSObject, downAppearance.getCOSObject());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources3.getColorSpaceNames());
    assertSame(colorSpaceNames, resources4.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources3.getExtGStateNames());
    assertSame(colorSpaceNames, resources4.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources3.getFontNames());
    assertSame(colorSpaceNames, resources4.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources3.getPatternNames());
    assertSame(colorSpaceNames, resources4.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources3.getPropertiesNames());
    assertSame(colorSpaceNames, resources4.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources3.getShadingNames());
    assertSame(colorSpaceNames, resources4.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(colorSpaceNames, resources3.getXObjectNames());
    assertSame(colorSpaceNames, resources4.getXObjectNames());
    assertArrayEquals("1 g\n4 M\n1 j\n0 J\n0.61 w\n1 1 16 18 re\n4.5 5.7143 m\n12".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("1 g\n4 M\n1 j\n0 J\n0.61 w\n1 1 16 18 re\n4.5 5.7143 m\n12".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("1 g\n4 M\n1 j\n0 J\n0.61 w\n1 1 16 18 re\n4.5 5.7143 m\n12".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("1 g\n4 M\n1 j\n0 J\n0.61 w\n1 1 16 18 re\n4.5 5.7143 m\n12".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationText#constructAppearances()}.
   * <ul>
   *   <li>Given {@link PDAnnotationCircle#PDAnnotationCircle()} Rectangle is
   * {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDAnnotationCircle() Rectangle is A0")
  void testConstructAppearances_givenPDAnnotationCircleRectangleIsA0() {
    // Arrange
    PDAnnotationCircle annotation = new PDAnnotationCircle();
    annotation.setRectangle(PDRectangle.A0);
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationText pdAnnotationText = new PDAnnotationText();
    pdAnnotationText.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationText.constructAppearances();

    // Assert
    assertEquals(0, pdAnnotationText.getAnnotationFlags());
    COSDictionary cOSObject = pdAnnotationText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(pdAnnotationText.isNoRotate());
    assertFalse(pdAnnotationText.isNoZoom());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
