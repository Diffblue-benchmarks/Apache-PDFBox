package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.interactive.action.OpenMode;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionEmbeddedGoTo;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDNamedDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitDestination;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDAnnotationLinkDiffblueTest {
  /**
   * Method under test: {@link PDAnnotationLink#getAction()}
   */
  @Test
  void testGetAction() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationLink()).getAction());
  }

  /**
   * Method under test: {@link PDAnnotationLink#setAction(PDAction)}
   */
  @Test
  void testSetAction() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setAction(new PDActionEmbeddedGoTo());

    // Assert
    PDAction action = pdAnnotationLink.getAction();
    assertTrue(action instanceof PDActionEmbeddedGoTo);
    assertEquals("Action", action.getType());
    assertEquals("GoToE", action.getSubType());
    assertNull(action.getNext());
    assertNull(((PDActionEmbeddedGoTo) action).getFile());
    assertNull(((PDActionEmbeddedGoTo) action).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) action).getDestination());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) action).getOpenInNewWindow());
  }

  /**
   * Method under test:
   * {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  void testSetBorderStyle() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setBorderStyle(new PDBorderStyleDictionary());

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationLink.getBorderStyle();
    PDLineDashPattern dashStyle = borderStyle.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1.0f, borderStyle.getWidth());
    COSDictionary cOSObject2 = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderStyle.getStyle());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  void testSetBorderStyle2() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setBorderStyle(null);

    // Assert
    assertNull(pdAnnotationLink.getBorderStyle());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  void testSetBorderStyle3() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdAnnotationLink.setBorderStyle(new PDBorderStyleDictionary(dict));

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationLink.getBorderStyle();
    PDLineDashPattern dashStyle = borderStyle.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1.0f, borderStyle.getWidth());
    COSDictionary cOSObject2 = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderStyle.getStyle());
    assertSame(dict, borderStyle.getCOSObject());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  void testSetBorderStyle4() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationLink.setBorderStyle(new PDBorderStyleDictionary(dict));

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationLink.getBorderStyle();
    PDLineDashPattern dashStyle = borderStyle.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1.0f, borderStyle.getWidth());
    COSDictionary cOSObject2 = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderStyle.getStyle());
    assertSame(dict, borderStyle.getCOSObject());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationLink#getBorderStyle()}
   */
  @Test
  void testGetBorderStyle() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationLink()).getBorderStyle());
  }

  /**
   * Method under test: {@link PDAnnotationLink#setDestination(PDDestination)}
   */
  @Test
  void testSetDestination() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setDestination(new PDNamedDestination("Dest"));

    // Assert
    PDDestination destination = pdAnnotationLink.getDestination();
    assertTrue(destination instanceof PDNamedDestination);
    assertEquals("Dest", ((PDNamedDestination) destination).getNamedDestination());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLink#setDestination(PDDestination)}
   */
  @Test
  void testSetDestination2() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setDestination(new PDNamedDestination());

    // Assert
    assertNull(pdAnnotationLink.getDestination());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLink#setDestination(PDDestination)}
   */
  @Test
  void testSetDestination3() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setDestination(new PDPageFitDestination());

    // Assert
    PDDestination destination = pdAnnotationLink.getDestination();
    assertTrue(destination instanceof PDPageFitDestination);
    assertNull(((PDPageFitDestination) destination).getPage());
    assertEquals(-1, ((PDPageFitDestination) destination).getPageNumber());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLink#setDestination(PDDestination)}
   */
  @Test
  void testSetDestination4() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setDestination(null);

    // Assert
    assertNull(pdAnnotationLink.getDestination());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLink#getHighlightMode()}
   */
  @Test
  void testGetHighlightMode() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_INVERT, (new PDAnnotationLink()).getHighlightMode());
  }

  /**
   * Method under test: {@link PDAnnotationLink#setHighlightMode(String)}
   */
  @Test
  void testSetHighlightMode() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setHighlightMode("Mode");

    // Assert
    assertEquals("Mode", pdAnnotationLink.getHighlightMode());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLink#setHighlightMode(String)}
   */
  @Test
  void testSetHighlightMode2() {
    // Arrange
    COSDictionary field = new COSDictionary();
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink(field);

    // Act
    pdAnnotationLink.setHighlightMode("Mode");

    // Assert
    assertEquals("Mode", pdAnnotationLink.getHighlightMode());
    assertSame(field, pdAnnotationLink.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotationLink#setPreviousURI(PDActionURI)}
   */
  @Test
  void testSetPreviousURI() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setPreviousURI(new PDActionURI());

    // Assert
    PDActionURI previousURI = pdAnnotationLink.getPreviousURI();
    assertEquals("Action", previousURI.getType());
    assertEquals("URI", previousURI.getSubType());
    assertNull(previousURI.getURI());
    assertNull(previousURI.getNext());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLink#setPreviousURI(PDActionURI)}
   */
  @Test
  void testSetPreviousURI2() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setPreviousURI(null);

    // Assert
    assertNull(pdAnnotationLink.getPreviousURI());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLink#setPreviousURI(PDActionURI)}
   */
  @Test
  void testSetPreviousURI3() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    COSDictionary a = new COSDictionary();
    a.setDirect(true);

    // Act
    pdAnnotationLink.setPreviousURI(new PDActionURI(a));

    // Assert
    PDActionURI previousURI = pdAnnotationLink.getPreviousURI();
    assertNull(previousURI.getSubType());
    assertNull(previousURI.getType());
    assertNull(previousURI.getURI());
    assertNull(previousURI.getNext());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(a, previousURI.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotationLink#setPreviousURI(PDActionURI)}
   */
  @Test
  void testSetPreviousURI4() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationLink.setPreviousURI(new PDActionURI(a));

    // Assert
    PDActionURI previousURI = pdAnnotationLink.getPreviousURI();
    assertNull(previousURI.getSubType());
    assertNull(previousURI.getType());
    assertNull(previousURI.getURI());
    assertNull(previousURI.getNext());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(a, previousURI.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotationLink#getPreviousURI()}
   */
  @Test
  void testGetPreviousURI() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationLink()).getPreviousURI());
  }

  /**
   * Method under test: {@link PDAnnotationLink#setQuadPoints(float[])}
   */
  @Test
  void testSetQuadPoints() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setQuadPoints(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, pdAnnotationLink.getQuadPoints(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationLink#getQuadPoints()}
   */
  @Test
  void testGetQuadPoints() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationLink()).getQuadPoints());
  }

  /**
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  void testConstructAppearances() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    assertNull(pdAnnotationLink.getAppearance());
    assertNull(pdAnnotationLink.getNormalAppearanceStream());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  void testConstructAppearances2() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
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
    PDRectangle bBox = normalAppearanceStream.getBBox();
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
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox2.getUpperRightX());
    assertEquals(2383.937f, bBox3.getUpperRightX());
    assertEquals(2383.937f, bBox4.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(2383.937f, bBox2.getWidth());
    assertEquals(2383.937f, bBox3.getWidth());
    assertEquals(2383.937f, bBox4.getWidth());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox2.getHeight());
    assertEquals(3370.3938f, bBox3.getHeight());
    assertEquals(3370.3938f, bBox4.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertEquals(3370.3938f, bBox2.getUpperRightY());
    assertEquals(3370.3938f, bBox3.getUpperRightY());
    assertEquals(3370.3938f, bBox4.getUpperRightY());
    COSDictionary cOSObject4 = pdAnnotationLink.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
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
    assertEquals(70, contentsForStreamParsing.available());
    assertEquals(70, contentsForStreamParsing2.available());
    assertEquals(70, contentsForStreamParsing3.available());
    assertEquals(70, contentsForStreamParsing4.available());
    assertEquals(70, contentsForRandomAccess.available());
    assertEquals(70, contentsForRandomAccess2.available());
    assertEquals(70, contentsForRandomAccess3.available());
    assertEquals(70, contentsForRandomAccess4.available());
    assertEquals(70, stream.getLength());
    assertEquals(70, stream2.getLength());
    assertEquals(70, stream3.getLength());
    assertEquals(70, stream4.getLength());
    assertEquals(70, contentStream.getLength());
    assertEquals(70, contentStream2.getLength());
    assertEquals(70, contentStream3.getLength());
    assertEquals(70, contentStream4.getLength());
    assertEquals(70L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
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
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    COSArray expectedCOSObject3 = bBox3.getCOSArray();
    assertSame(expectedCOSObject3, bBox3.getCOSObject());
    COSArray expectedCOSObject4 = bBox4.getCOSArray();
    assertSame(expectedCOSObject4, bBox4.getCOSObject());
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
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  void testConstructAppearances3() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(PDRectangle.LETTER);

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
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
    PDRectangle bBox = normalAppearanceStream.getBBox();
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
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSDictionary cOSObject4 = pdAnnotationLink.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(56, contentsForStreamParsing.available());
    assertEquals(56, contentsForStreamParsing2.available());
    assertEquals(56, contentsForStreamParsing3.available());
    assertEquals(56, contentsForStreamParsing4.available());
    assertEquals(56, contentsForRandomAccess.available());
    assertEquals(56, contentsForRandomAccess2.available());
    assertEquals(56, contentsForRandomAccess3.available());
    assertEquals(56, contentsForRandomAccess4.available());
    assertEquals(56, stream.getLength());
    assertEquals(56, stream2.getLength());
    assertEquals(56, stream3.getLength());
    assertEquals(56, stream4.getLength());
    assertEquals(56, contentStream.getLength());
    assertEquals(56, contentStream2.getLength());
    assertEquals(56, contentStream3.getLength());
    assertEquals(56, contentStream4.getLength());
    assertEquals(56L, cOSObject.getLength());
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(612.0f, bBox.getUpperRightX());
    assertEquals(612.0f, bBox2.getUpperRightX());
    assertEquals(612.0f, bBox3.getUpperRightX());
    assertEquals(612.0f, bBox4.getUpperRightX());
    assertEquals(612.0f, bBox.getWidth());
    assertEquals(612.0f, bBox2.getWidth());
    assertEquals(612.0f, bBox3.getWidth());
    assertEquals(612.0f, bBox4.getWidth());
    assertEquals(792.0f, bBox.getHeight());
    assertEquals(792.0f, bBox2.getHeight());
    assertEquals(792.0f, bBox3.getHeight());
    assertEquals(792.0f, bBox4.getHeight());
    assertEquals(792.0f, bBox.getUpperRightY());
    assertEquals(792.0f, bBox2.getUpperRightY());
    assertEquals(792.0f, bBox3.getUpperRightY());
    assertEquals(792.0f, bBox4.getUpperRightY());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
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
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    COSArray expectedCOSObject3 = bBox3.getCOSArray();
    assertSame(expectedCOSObject3, bBox3.getCOSObject());
    COSArray expectedCOSObject4 = bBox4.getCOSArray();
    assertSame(expectedCOSObject4, bBox4.getCOSObject());
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
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  void testConstructAppearances4() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
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
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    assertEquals(-2.14748365E9f, matrix.getTranslateY());
    assertEquals(0, cOSObject2.size());
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getHeight());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getHeight());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(0.0f, bBox3.getWidth());
    assertEquals(0.0f, bBox4.getWidth());
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
    assertEquals(104, contentsForStreamParsing.available());
    assertEquals(104, contentsForStreamParsing2.available());
    assertEquals(104, contentsForStreamParsing3.available());
    assertEquals(104, contentsForStreamParsing4.available());
    assertEquals(104, contentsForRandomAccess.available());
    assertEquals(104, contentsForRandomAccess2.available());
    assertEquals(104, contentsForRandomAccess3.available());
    assertEquals(104, contentsForRandomAccess4.available());
    assertEquals(104, stream.getLength());
    assertEquals(104, stream2.getLength());
    assertEquals(104, stream3.getLength());
    assertEquals(104, stream4.getLength());
    assertEquals(104, contentStream.getLength());
    assertEquals(104, contentStream2.getLength());
    assertEquals(104, contentStream3.getLength());
    assertEquals(104, contentStream4.getLength());
    assertEquals(104L, cOSObject.getLength());
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox2.getUpperRightX());
    assertEquals(2.14748365E9f, bBox3.getUpperRightX());
    assertEquals(2.14748365E9f, bBox4.getUpperRightX());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
    assertEquals(2.14748365E9f, bBox2.getUpperRightY());
    assertEquals(2.14748365E9f, bBox3.getUpperRightY());
    assertEquals(2.14748365E9f, bBox4.getUpperRightY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSDictionary cOSObject4 = pdAnnotationLink.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
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
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
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
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    COSArray expectedCOSObject3 = bBox3.getCOSArray();
    assertSame(expectedCOSObject3, bBox3.getCOSObject());
    COSArray expectedCOSObject4 = bBox4.getCOSArray();
    assertSame(expectedCOSObject4, bBox4.getCOSObject());
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
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-2.14748365E9f, -2.14748365E9f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  void testConstructAppearances5() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(new PDRectangle(-9.223372E18f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
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
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(-2.14748365E9f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(-2.14748365E9f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(-2.14748365E9f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(-2.14748365E9f, bBox4.getLowerLeftX());
    assertEquals(-2.14748365E9f, bBox.getUpperRightX());
    assertEquals(-2.14748365E9f, bBox2.getUpperRightX());
    assertEquals(-2.14748365E9f, bBox3.getUpperRightX());
    assertEquals(-2.14748365E9f, bBox4.getUpperRightX());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getHeight());
    assertEquals(0.0f, bBox2.getHeight());
    assertEquals(0.0f, bBox3.getHeight());
    assertEquals(0.0f, bBox4.getHeight());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(0.0f, bBox3.getWidth());
    assertEquals(0.0f, bBox4.getWidth());
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
    assertEquals(108, contentsForStreamParsing.available());
    assertEquals(108, contentsForStreamParsing2.available());
    assertEquals(108, contentsForStreamParsing3.available());
    assertEquals(108, contentsForStreamParsing4.available());
    assertEquals(108, contentsForRandomAccess.available());
    assertEquals(108, contentsForRandomAccess2.available());
    assertEquals(108, contentsForRandomAccess3.available());
    assertEquals(108, contentsForRandomAccess4.available());
    assertEquals(108, stream.getLength());
    assertEquals(108, stream2.getLength());
    assertEquals(108, stream3.getLength());
    assertEquals(108, stream4.getLength());
    assertEquals(108, contentStream.getLength());
    assertEquals(108, contentStream2.getLength());
    assertEquals(108, contentStream3.getLength());
    assertEquals(108, contentStream4.getLength());
    assertEquals(108L, cOSObject.getLength());
    assertEquals(2.14748365E9f, bBox.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
    assertEquals(2.14748365E9f, bBox2.getUpperRightY());
    assertEquals(2.14748365E9f, bBox3.getUpperRightY());
    assertEquals(2.14748365E9f, bBox4.getUpperRightY());
    assertEquals(2.14748365E9f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSDictionary cOSObject4 = pdAnnotationLink.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
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
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
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
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    COSArray expectedCOSObject3 = bBox3.getCOSArray();
    assertSame(expectedCOSObject3, bBox3.getCOSObject());
    COSArray expectedCOSObject4 = bBox4.getCOSArray();
    assertSame(expectedCOSObject4, bBox4.getCOSObject());
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
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{2.14748365E9f, -2.14748365E9f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  void testConstructAppearances6() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setAppearance(new PDAppearanceDictionary());
    pdAnnotationLink.setRectangle(PDRectangle.LETTER);

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
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
    PDRectangle bBox = normalAppearanceStream.getBBox();
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
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSDictionary cOSObject4 = pdAnnotationLink.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(56, contentsForStreamParsing.available());
    assertEquals(56, contentsForStreamParsing2.available());
    assertEquals(56, contentsForStreamParsing3.available());
    assertEquals(56, contentsForStreamParsing4.available());
    assertEquals(56, contentsForRandomAccess.available());
    assertEquals(56, contentsForRandomAccess2.available());
    assertEquals(56, contentsForRandomAccess3.available());
    assertEquals(56, contentsForRandomAccess4.available());
    assertEquals(56, stream.getLength());
    assertEquals(56, stream2.getLength());
    assertEquals(56, stream3.getLength());
    assertEquals(56, stream4.getLength());
    assertEquals(56, contentStream.getLength());
    assertEquals(56, contentStream2.getLength());
    assertEquals(56, contentStream3.getLength());
    assertEquals(56, contentStream4.getLength());
    assertEquals(56L, cOSObject.getLength());
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(612.0f, bBox.getUpperRightX());
    assertEquals(612.0f, bBox2.getUpperRightX());
    assertEquals(612.0f, bBox3.getUpperRightX());
    assertEquals(612.0f, bBox4.getUpperRightX());
    assertEquals(612.0f, bBox.getWidth());
    assertEquals(612.0f, bBox2.getWidth());
    assertEquals(612.0f, bBox3.getWidth());
    assertEquals(612.0f, bBox4.getWidth());
    assertEquals(792.0f, bBox.getHeight());
    assertEquals(792.0f, bBox2.getHeight());
    assertEquals(792.0f, bBox3.getHeight());
    assertEquals(792.0f, bBox4.getHeight());
    assertEquals(792.0f, bBox.getUpperRightY());
    assertEquals(792.0f, bBox2.getUpperRightY());
    assertEquals(792.0f, bBox3.getUpperRightY());
    assertEquals(792.0f, bBox4.getUpperRightY());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
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
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    COSArray expectedCOSObject3 = bBox3.getCOSArray();
    assertSame(expectedCOSObject3, bBox3.getCOSObject());
    COSArray expectedCOSObject4 = bBox4.getCOSArray();
    assertSame(expectedCOSObject4, bBox4.getCOSObject());
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
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances7() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument());

    // Assert
    assertNull(pdAnnotationLink.getAppearance());
    assertNull(pdAnnotationLink.getNormalAppearanceStream());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances8() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(pdAnnotationLink.getAppearance());
    assertNull(pdAnnotationLink.getNormalAppearanceStream());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances9() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(PDRectangle.A0);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
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
    PDRectangle bBox = normalAppearanceStream.getBBox();
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
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox2.getUpperRightX());
    assertEquals(2383.937f, bBox3.getUpperRightX());
    assertEquals(2383.937f, bBox4.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(2383.937f, bBox2.getWidth());
    assertEquals(2383.937f, bBox3.getWidth());
    assertEquals(2383.937f, bBox4.getWidth());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox2.getHeight());
    assertEquals(3370.3938f, bBox3.getHeight());
    assertEquals(3370.3938f, bBox4.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertEquals(3370.3938f, bBox2.getUpperRightY());
    assertEquals(3370.3938f, bBox3.getUpperRightY());
    assertEquals(3370.3938f, bBox4.getUpperRightY());
    COSDictionary cOSObject4 = pdAnnotationLink.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
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
    assertEquals(70, contentsForStreamParsing.available());
    assertEquals(70, contentsForStreamParsing2.available());
    assertEquals(70, contentsForStreamParsing3.available());
    assertEquals(70, contentsForStreamParsing4.available());
    assertEquals(70, contentsForRandomAccess.available());
    assertEquals(70, contentsForRandomAccess2.available());
    assertEquals(70, contentsForRandomAccess3.available());
    assertEquals(70, contentsForRandomAccess4.available());
    assertEquals(70, stream.getLength());
    assertEquals(70, stream2.getLength());
    assertEquals(70, stream3.getLength());
    assertEquals(70, stream4.getLength());
    assertEquals(70, contentStream.getLength());
    assertEquals(70, contentStream2.getLength());
    assertEquals(70, contentStream3.getLength());
    assertEquals(70, contentStream4.getLength());
    assertEquals(70L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
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
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    COSArray expectedCOSObject3 = bBox3.getCOSArray();
    assertSame(expectedCOSObject3, bBox3.getCOSObject());
    COSArray expectedCOSObject4 = bBox4.getCOSArray();
    assertSame(expectedCOSObject4, bBox4.getCOSObject());
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
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances10() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
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
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    assertEquals(-2.14748365E9f, matrix.getTranslateY());
    assertEquals(0, cOSObject2.size());
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getHeight());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getHeight());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(0.0f, bBox3.getWidth());
    assertEquals(0.0f, bBox4.getWidth());
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
    assertEquals(104, contentsForStreamParsing.available());
    assertEquals(104, contentsForStreamParsing2.available());
    assertEquals(104, contentsForStreamParsing3.available());
    assertEquals(104, contentsForStreamParsing4.available());
    assertEquals(104, contentsForRandomAccess.available());
    assertEquals(104, contentsForRandomAccess2.available());
    assertEquals(104, contentsForRandomAccess3.available());
    assertEquals(104, contentsForRandomAccess4.available());
    assertEquals(104, stream.getLength());
    assertEquals(104, stream2.getLength());
    assertEquals(104, stream3.getLength());
    assertEquals(104, stream4.getLength());
    assertEquals(104, contentStream.getLength());
    assertEquals(104, contentStream2.getLength());
    assertEquals(104, contentStream3.getLength());
    assertEquals(104, contentStream4.getLength());
    assertEquals(104L, cOSObject.getLength());
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox2.getUpperRightX());
    assertEquals(2.14748365E9f, bBox3.getUpperRightX());
    assertEquals(2.14748365E9f, bBox4.getUpperRightX());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
    assertEquals(2.14748365E9f, bBox2.getUpperRightY());
    assertEquals(2.14748365E9f, bBox3.getUpperRightY());
    assertEquals(2.14748365E9f, bBox4.getUpperRightY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSDictionary cOSObject4 = pdAnnotationLink.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
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
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
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
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    COSArray expectedCOSObject3 = bBox3.getCOSArray();
    assertSame(expectedCOSObject3, bBox3.getCOSObject());
    COSArray expectedCOSObject4 = bBox4.getCOSArray();
    assertSame(expectedCOSObject4, bBox4.getCOSObject());
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
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-2.14748365E9f, -2.14748365E9f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances11() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(PDRectangle.A0);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
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
    PDRectangle bBox = normalAppearanceStream.getBBox();
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
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox2.getUpperRightX());
    assertEquals(2383.937f, bBox3.getUpperRightX());
    assertEquals(2383.937f, bBox4.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(2383.937f, bBox2.getWidth());
    assertEquals(2383.937f, bBox3.getWidth());
    assertEquals(2383.937f, bBox4.getWidth());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox2.getHeight());
    assertEquals(3370.3938f, bBox3.getHeight());
    assertEquals(3370.3938f, bBox4.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertEquals(3370.3938f, bBox2.getUpperRightY());
    assertEquals(3370.3938f, bBox3.getUpperRightY());
    assertEquals(3370.3938f, bBox4.getUpperRightY());
    COSDictionary cOSObject4 = pdAnnotationLink.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
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
    assertEquals(70, contentsForStreamParsing.available());
    assertEquals(70, contentsForStreamParsing2.available());
    assertEquals(70, contentsForStreamParsing3.available());
    assertEquals(70, contentsForStreamParsing4.available());
    assertEquals(70, contentsForRandomAccess.available());
    assertEquals(70, contentsForRandomAccess2.available());
    assertEquals(70, contentsForRandomAccess3.available());
    assertEquals(70, contentsForRandomAccess4.available());
    assertEquals(70, stream.getLength());
    assertEquals(70, stream2.getLength());
    assertEquals(70, stream3.getLength());
    assertEquals(70, stream4.getLength());
    assertEquals(70, contentStream.getLength());
    assertEquals(70, contentStream2.getLength());
    assertEquals(70, contentStream3.getLength());
    assertEquals(70, contentStream4.getLength());
    assertEquals(70L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
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
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    COSArray expectedCOSObject3 = bBox3.getCOSArray();
    assertSame(expectedCOSObject3, bBox3.getCOSObject());
    COSArray expectedCOSObject4 = bBox4.getCOSArray();
    assertSame(expectedCOSObject4, bBox4.getCOSObject());
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
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances12() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(PDRectangle.A0);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(1L)));

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDStream stream = normalAppearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    PDStream stream3 = appearanceStream2.getStream();
    assertNull(stream3.getDecodeParms());
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
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
    assertEquals(0, stream.getLength());
    assertEquals(0, stream2.getLength());
    assertEquals(0, stream3.getLength());
    assertEquals(0, stream4.getLength());
    assertEquals(0, contentStream.getLength());
    assertEquals(0, contentStream2.getLength());
    assertEquals(0, contentStream3.getLength());
    assertEquals(0, contentStream4.getLength());
    PDRectangle bBox = normalAppearanceStream.getBBox();
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
    assertEquals(0L, cOSObject.getLength());
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
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox2.getUpperRightX());
    assertEquals(2383.937f, bBox3.getUpperRightX());
    assertEquals(2383.937f, bBox4.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(2383.937f, bBox2.getWidth());
    assertEquals(2383.937f, bBox3.getWidth());
    assertEquals(2383.937f, bBox4.getWidth());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox2.getHeight());
    assertEquals(3370.3938f, bBox3.getHeight());
    assertEquals(3370.3938f, bBox4.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertEquals(3370.3938f, bBox2.getUpperRightY());
    assertEquals(3370.3938f, bBox3.getUpperRightY());
    assertEquals(3370.3938f, bBox4.getUpperRightY());
    COSDictionary cOSObject4 = pdAnnotationLink.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(cOSObject2.getValues().isEmpty());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    COSArray expectedCOSObject3 = bBox3.getCOSArray();
    assertSame(expectedCOSObject3, bBox3.getCOSObject());
    COSArray expectedCOSObject4 = bBox4.getCOSArray();
    assertSame(expectedCOSObject4, bBox4.getCOSObject());
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
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances13() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(new PDRectangle(-9.223372E18f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
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
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(-2.14748365E9f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(-2.14748365E9f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(-2.14748365E9f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(-2.14748365E9f, bBox4.getLowerLeftX());
    assertEquals(-2.14748365E9f, bBox.getUpperRightX());
    assertEquals(-2.14748365E9f, bBox2.getUpperRightX());
    assertEquals(-2.14748365E9f, bBox3.getUpperRightX());
    assertEquals(-2.14748365E9f, bBox4.getUpperRightX());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getHeight());
    assertEquals(0.0f, bBox2.getHeight());
    assertEquals(0.0f, bBox3.getHeight());
    assertEquals(0.0f, bBox4.getHeight());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(0.0f, bBox3.getWidth());
    assertEquals(0.0f, bBox4.getWidth());
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
    assertEquals(108, contentsForStreamParsing.available());
    assertEquals(108, contentsForStreamParsing2.available());
    assertEquals(108, contentsForStreamParsing3.available());
    assertEquals(108, contentsForStreamParsing4.available());
    assertEquals(108, contentsForRandomAccess.available());
    assertEquals(108, contentsForRandomAccess2.available());
    assertEquals(108, contentsForRandomAccess3.available());
    assertEquals(108, contentsForRandomAccess4.available());
    assertEquals(108, stream.getLength());
    assertEquals(108, stream2.getLength());
    assertEquals(108, stream3.getLength());
    assertEquals(108, stream4.getLength());
    assertEquals(108, contentStream.getLength());
    assertEquals(108, contentStream2.getLength());
    assertEquals(108, contentStream3.getLength());
    assertEquals(108, contentStream4.getLength());
    assertEquals(108L, cOSObject.getLength());
    assertEquals(2.14748365E9f, bBox.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
    assertEquals(2.14748365E9f, bBox2.getUpperRightY());
    assertEquals(2.14748365E9f, bBox3.getUpperRightY());
    assertEquals(2.14748365E9f, bBox4.getUpperRightY());
    assertEquals(2.14748365E9f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSDictionary cOSObject4 = pdAnnotationLink.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
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
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
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
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    COSArray expectedCOSObject3 = bBox3.getCOSArray();
    assertSame(expectedCOSObject3, bBox3.getCOSObject());
    COSArray expectedCOSObject4 = bBox4.getCOSArray();
    assertSame(expectedCOSObject4, bBox4.getCOSObject());
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
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{2.14748365E9f, -2.14748365E9f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances14() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setAppearance(new PDAppearanceDictionary());
    pdAnnotationLink.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    PDResources resources = normalAppearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
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
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    assertEquals(-2.14748365E9f, matrix.getTranslateY());
    assertEquals(0, cOSObject2.size());
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox3.getHeight());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox4.getHeight());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(0.0f, bBox3.getWidth());
    assertEquals(0.0f, bBox4.getWidth());
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
    assertEquals(104, contentsForStreamParsing.available());
    assertEquals(104, contentsForStreamParsing2.available());
    assertEquals(104, contentsForStreamParsing3.available());
    assertEquals(104, contentsForStreamParsing4.available());
    assertEquals(104, contentsForRandomAccess.available());
    assertEquals(104, contentsForRandomAccess2.available());
    assertEquals(104, contentsForRandomAccess3.available());
    assertEquals(104, contentsForRandomAccess4.available());
    assertEquals(104, stream.getLength());
    assertEquals(104, stream2.getLength());
    assertEquals(104, stream3.getLength());
    assertEquals(104, stream4.getLength());
    assertEquals(104, contentStream.getLength());
    assertEquals(104, contentStream2.getLength());
    assertEquals(104, contentStream3.getLength());
    assertEquals(104, contentStream4.getLength());
    assertEquals(104L, cOSObject.getLength());
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox4.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox2.getUpperRightX());
    assertEquals(2.14748365E9f, bBox3.getUpperRightX());
    assertEquals(2.14748365E9f, bBox4.getUpperRightX());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
    assertEquals(2.14748365E9f, bBox2.getUpperRightY());
    assertEquals(2.14748365E9f, bBox3.getUpperRightY());
    assertEquals(2.14748365E9f, bBox4.getUpperRightY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSDictionary cOSObject4 = pdAnnotationLink.getCOSObject();
    assertEquals(4, cOSObject4.getValues().size());
    assertEquals(4, cOSObject4.size());
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
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
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
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.hasData());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertEquals(matrix, appearanceStream.getMatrix());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSObject2, resources3.getCOSObject());
    assertSame(cOSObject2, resources4.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    COSArray expectedCOSObject3 = bBox3.getCOSArray();
    assertSame(expectedCOSObject3, bBox3.getCOSObject());
    COSArray expectedCOSObject4 = bBox4.getCOSArray();
    assertSame(expectedCOSObject4, bBox4.getCOSObject());
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
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[]{-2.14748365E9f, -2.14748365E9f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }
}
