package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.interactive.action.OpenMode;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionEmbeddedGoTo;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDCircleAppearanceHandler;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDNamedDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitDestination;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDAnnotationLinkDiffblueTest {
  /**
   * Test {@link PDAnnotationLink#PDAnnotationLink()}.
   * <p>
   * Method under test: {@link PDAnnotationLink#PDAnnotationLink()}
   */
  @Test
  @DisplayName("Test new PDAnnotationLink()")
  void testNewPDAnnotationLink() throws IOException {
    // Arrange and Act
    PDAnnotationLink actualPdAnnotationLink = new PDAnnotationLink();

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationLink.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(actualPdAnnotationLink.getQuadPoints());
    assertNull(actualPdAnnotationLink.getAnnotationName());
    assertNull(actualPdAnnotationLink.getContents());
    assertNull(actualPdAnnotationLink.getModifiedDate());
    COSDictionary cOSObject = actualPdAnnotationLink.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdAnnotationLink.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(actualPdAnnotationLink.getPage());
    assertNull(actualPdAnnotationLink.getRectangle());
    assertNull(actualPdAnnotationLink.getOptionalContent());
    assertNull(actualPdAnnotationLink.getColor());
    assertNull(actualPdAnnotationLink.getAction());
    assertNull(actualPdAnnotationLink.getPreviousURI());
    assertNull(actualPdAnnotationLink.getAppearance());
    assertNull(actualPdAnnotationLink.getNormalAppearanceStream());
    assertNull(actualPdAnnotationLink.getBorderStyle());
    assertNull(actualPdAnnotationLink.getDestination());
    assertEquals(-1, actualPdAnnotationLink.getStructParent());
    assertEquals(0, actualPdAnnotationLink.getAnnotationFlags());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdAnnotationLink.isHidden());
    assertFalse(actualPdAnnotationLink.isInvisible());
    assertFalse(actualPdAnnotationLink.isLocked());
    assertFalse(actualPdAnnotationLink.isLockedContents());
    assertFalse(actualPdAnnotationLink.isNoRotate());
    assertFalse(actualPdAnnotationLink.isNoView());
    assertFalse(actualPdAnnotationLink.isNoZoom());
    assertFalse(actualPdAnnotationLink.isPrinted());
    assertFalse(actualPdAnnotationLink.isReadOnly());
    assertFalse(actualPdAnnotationLink.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_INVERT, actualPdAnnotationLink.getHighlightMode());
    assertEquals(PDAnnotationLink.SUB_TYPE, actualPdAnnotationLink.getSubtype());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationLink#PDAnnotationLink(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#PDAnnotationLink(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationLink(COSDictionary); when COSDictionary(); then COSDictionary() size is one")
  void testNewPDAnnotationLink_whenCOSDictionary_thenCOSDictionarySizeIsOne() {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationLink actualPdAnnotationLink = new PDAnnotationLink(field);

    // Assert
    assertEquals(1, field.size());
    List<? extends COSBase> toListResult = actualPdAnnotationLink.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(field, actualPdAnnotationLink.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationLink#PDAnnotationLink(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link COSStream#COSStream()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#PDAnnotationLink(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationLink(COSDictionary); when COSStream(); then COSStream() size is two")
  void testNewPDAnnotationLink_whenCOSStream_thenCOSStreamSizeIsTwo() {
    // Arrange
    COSStream field = new COSStream();

    // Act
    PDAnnotationLink actualPdAnnotationLink = new PDAnnotationLink(field);

    // Assert
    assertEquals(2, field.size());
    List<? extends COSBase> toListResult = actualPdAnnotationLink.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(field, actualPdAnnotationLink.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationLink#getAction()}.
   * <p>
   * Method under test: {@link PDAnnotationLink#getAction()}
   */
  @Test
  @DisplayName("Test getAction()")
  void testGetAction() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationLink()).getAction());
  }

  /**
   * Test {@link PDAnnotationLink#setAction(PDAction)}.
   * <ul>
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} Action
   * {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#setAction(PDAction)}
   */
  @Test
  @DisplayName("Test setAction(PDAction); then PDAnnotationLink() Action PDActionEmbeddedGoTo")
  void testSetAction_thenPDAnnotationLinkActionPDActionEmbeddedGoTo() throws IOException {
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
   * Test {@link PDAnnotationLink#setAction(PDAction)}.
   * <ul>
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink(COSDictionary)} with field
   * is {@link COSDictionary#COSDictionary()} Action is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#setAction(PDAction)}
   */
  @Test
  @DisplayName("Test setAction(PDAction); then PDAnnotationLink(COSDictionary) with field is COSDictionary() Action is 'null'")
  void testSetAction_thenPDAnnotationLinkWithFieldIsCOSDictionaryActionIsNull() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink(new COSDictionary());

    // Act
    pdAnnotationLink.setAction(null);

    // Assert
    assertNull(pdAnnotationLink.getAction());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}.
   * <p>
   * Method under test:
   * {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test setBorderStyle(PDBorderStyleDictionary)")
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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult2 = ((COSArray) getResult).toList();
    assertEquals(1, toListResult2.size());
    assertTrue(toListResult2.get(0) instanceof COSFloat);
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1.0f, borderStyle.getWidth());
    COSDictionary cOSObject2 = pdAnnotationLink.getCOSObject();
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderStyle.getStyle());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test setBorderStyle(PDBorderStyleDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetBorderStyle_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationLink.setBorderStyle(new PDBorderStyleDictionary(dict));

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationLink.getBorderStyle();
    COSBase cOSObject = borderStyle.getDashStyle().getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertSame(dict, borderStyle.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test setBorderStyle(PDBorderStyleDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  void testSetBorderStyle_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdAnnotationLink.setBorderStyle(new PDBorderStyleDictionary(dict));

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationLink.getBorderStyle();
    COSBase cOSObject = borderStyle.getDashStyle().getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertSame(dict, borderStyle.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} COSObject Values size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationLink#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test setBorderStyle(PDBorderStyleDictionary); when 'null'; then PDAnnotationLink() COSObject Values size is two")
  void testSetBorderStyle_whenNull_thenPDAnnotationLinkCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setBorderStyle(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#getBorderStyle()}.
   * <p>
   * Method under test: {@link PDAnnotationLink#getBorderStyle()}
   */
  @Test
  @DisplayName("Test getBorderStyle()")
  void testGetBorderStyle() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationLink()).getBorderStyle());
  }

  /**
   * Test {@link PDAnnotationLink#setDestination(PDDestination)}.
   * <ul>
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} Destination
   * {@link PDNamedDestination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#setDestination(PDDestination)}
   */
  @Test
  @DisplayName("Test setDestination(PDDestination); then PDAnnotationLink() Destination PDNamedDestination")
  void testSetDestination_thenPDAnnotationLinkDestinationPDNamedDestination() throws IOException {
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
   * Test {@link PDAnnotationLink#setDestination(PDDestination)}.
   * <ul>
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} Destination
   * {@link PDPageFitDestination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#setDestination(PDDestination)}
   */
  @Test
  @DisplayName("Test setDestination(PDDestination); then PDAnnotationLink() Destination PDPageFitDestination")
  void testSetDestination_thenPDAnnotationLinkDestinationPDPageFitDestination() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setDestination(new PDPageFitDestination());

    // Assert
    PDDestination destination = pdAnnotationLink.getDestination();
    assertTrue(destination instanceof PDPageFitDestination);
    assertNull(((PDPageFitDestination) destination).getPage());
    assertEquals(-1, ((PDPageFitDestination) destination).getPageNumber());
  }

  /**
   * Test {@link PDAnnotationLink#setDestination(PDDestination)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} Destination is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#setDestination(PDDestination)}
   */
  @Test
  @DisplayName("Test setDestination(PDDestination); when 'null'; then PDAnnotationLink() Destination is 'null'")
  void testSetDestination_whenNull_thenPDAnnotationLinkDestinationIsNull() throws IOException {
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
   * Test {@link PDAnnotationLink#setDestination(PDDestination)}.
   * <ul>
   *   <li>When {@link PDNamedDestination#PDNamedDestination()}.</li>
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} Destination is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#setDestination(PDDestination)}
   */
  @Test
  @DisplayName("Test setDestination(PDDestination); when PDNamedDestination(); then PDAnnotationLink() Destination is 'null'")
  void testSetDestination_whenPDNamedDestination_thenPDAnnotationLinkDestinationIsNull() throws IOException {
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
   * Test {@link PDAnnotationLink#getHighlightMode()}.
   * <p>
   * Method under test: {@link PDAnnotationLink#getHighlightMode()}
   */
  @Test
  @DisplayName("Test getHighlightMode()")
  void testGetHighlightMode() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_INVERT, (new PDAnnotationLink()).getHighlightMode());
  }

  /**
   * Test {@link PDAnnotationLink#setHighlightMode(String)}.
   * <p>
   * Method under test: {@link PDAnnotationLink#setHighlightMode(String)}
   */
  @Test
  @DisplayName("Test setHighlightMode(String)")
  void testSetHighlightMode() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink(new COSDictionary());

    // Act
    pdAnnotationLink.setHighlightMode("Mode");

    // Assert
    assertEquals("Mode", pdAnnotationLink.getHighlightMode());
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#setHighlightMode(String)}.
   * <ul>
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} HighlightMode is
   * {@code Mode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#setHighlightMode(String)}
   */
  @Test
  @DisplayName("Test setHighlightMode(String); then PDAnnotationLink() HighlightMode is 'Mode'")
  void testSetHighlightMode_thenPDAnnotationLinkHighlightModeIsMode() {
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
   * Test {@link PDAnnotationLink#setPreviousURI(PDActionURI)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#setPreviousURI(PDActionURI)}
   */
  @Test
  @DisplayName("Test setPreviousURI(PDActionURI); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetPreviousURI_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
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
    assertSame(a, previousURI.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationLink#setPreviousURI(PDActionURI)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#setPreviousURI(PDActionURI)}
   */
  @Test
  @DisplayName("Test setPreviousURI(PDActionURI); given 'true'; when COSDictionary() Direct is 'true'")
  void testSetPreviousURI_givenTrue_whenCOSDictionaryDirectIsTrue() {
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
    assertSame(a, previousURI.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationLink#setPreviousURI(PDActionURI)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} COSObject Values size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#setPreviousURI(PDActionURI)}
   */
  @Test
  @DisplayName("Test setPreviousURI(PDActionURI); when 'null'; then PDAnnotationLink() COSObject Values size is two")
  void testSetPreviousURI_whenNull_thenPDAnnotationLinkCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.setPreviousURI(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#setPreviousURI(PDActionURI)}.
   * <ul>
   *   <li>When {@link PDActionURI#PDActionURI()}.</li>
   *   <li>Then {@link PDAnnotationLink#PDAnnotationLink()} PreviousURI Type is
   * {@code Action}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#setPreviousURI(PDActionURI)}
   */
  @Test
  @DisplayName("Test setPreviousURI(PDActionURI); when PDActionURI(); then PDAnnotationLink() PreviousURI Type is 'Action'")
  void testSetPreviousURI_whenPDActionURI_thenPDAnnotationLinkPreviousURITypeIsAction() {
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
   * Test {@link PDAnnotationLink#getPreviousURI()}.
   * <p>
   * Method under test: {@link PDAnnotationLink#getPreviousURI()}
   */
  @Test
  @DisplayName("Test getPreviousURI()")
  void testGetPreviousURI() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationLink()).getPreviousURI());
  }

  /**
   * Test {@link PDAnnotationLink#setQuadPoints(float[])}.
   * <p>
   * Method under test: {@link PDAnnotationLink#setQuadPoints(float[])}
   */
  @Test
  @DisplayName("Test setQuadPoints(float[])")
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
   * Test {@link PDAnnotationLink#getQuadPoints()}.
   * <p>
   * Method under test: {@link PDAnnotationLink#getQuadPoints()}
   */
  @Test
  @DisplayName("Test getQuadPoints()")
  void testGetQuadPoints() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationLink()).getQuadPoints());
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(2383.937f, bBox.getUpperRightX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(2383.937f, bBox2.getUpperRightX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(2383.937f, bBox3.getUpperRightX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(2383.937f, bBox4.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(2383.937f, bBox2.getWidth());
    assertEquals(2383.937f, bBox3.getWidth());
    assertEquals(2383.937f, bBox4.getWidth());
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox2.getHeight());
    assertEquals(3370.3938f, bBox3.getHeight());
    assertEquals(3370.3938f, bBox4.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertEquals(3370.3938f, bBox2.getUpperRightY());
    assertEquals(3370.3938f, bBox3.getUpperRightY());
    assertEquals(3370.3938f, bBox4.getUpperRightY());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(70, contentsForStreamParsing.available());
    assertEquals(70, contentsForStreamParsing2.available());
    assertEquals(70, contentsForStreamParsing3.available());
    assertEquals(70, contentsForStreamParsing4.available());
    assertEquals(70, contentsForRandomAccess.available());
    assertEquals(70, contentsForRandomAccess2.available());
    assertEquals(70, contentsForRandomAccess3.available());
    assertEquals(70, contentsForRandomAccess4.available());
    assertEquals(70, normalAppearanceStream.getStream().getLength());
    assertEquals(70, appearanceStream.getStream().getLength());
    assertEquals(70, appearanceStream2.getStream().getLength());
    assertEquals(70, appearanceStream3.getStream().getLength());
    assertEquals(70, normalAppearanceStream.getContentStream().getLength());
    assertEquals(70, appearanceStream.getContentStream().getLength());
    assertEquals(70, appearanceStream2.getContentStream().getLength());
    assertEquals(70, appearanceStream3.getContentStream().getLength());
    assertEquals(70L, normalAppearanceStream.getCOSObject().getLength());
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances2() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(PDRectangle.LETTER);

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    COSDictionary cOSObject = pdAnnotationLink.getAppearance().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    COSDictionary cOSObject2 = pdAnnotationLink.getCOSObject();
    assertEquals(4, cOSObject2.getValues().size());
    assertEquals(4, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances3() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-2.14748365E9f, floatArray[0]);
    assertEquals(104, contentsForStreamParsing.available());
    assertEquals(104, contentsForStreamParsing2.available());
    assertEquals(104, contentsForStreamParsing3.available());
    assertEquals(104, contentsForStreamParsing4.available());
    assertEquals(104, contentsForRandomAccess.available());
    assertEquals(104, contentsForRandomAccess2.available());
    assertEquals(104, contentsForRandomAccess3.available());
    assertEquals(104, contentsForRandomAccess4.available());
    assertEquals(104, normalAppearanceStream.getStream().getLength());
    assertEquals(104, appearanceStream.getStream().getLength());
    assertEquals(104, appearanceStream2.getStream().getLength());
    assertEquals(104, appearanceStream3.getStream().getLength());
    assertEquals(104, normalAppearanceStream.getContentStream().getLength());
    assertEquals(104, appearanceStream.getContentStream().getLength());
    assertEquals(104, appearanceStream2.getContentStream().getLength());
    assertEquals(104, appearanceStream3.getContentStream().getLength());
    assertEquals(104L, normalAppearanceStream.getCOSObject().getLength());
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(2.14748365E9f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(2.14748365E9f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(2.14748365E9f, bBox4.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox2.getUpperRightX());
    assertEquals(2.14748365E9f, bBox3.getUpperRightX());
    assertEquals(2.14748365E9f, bBox4.getUpperRightX());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances4() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(new PDRectangle(-9.223372E18f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(108, contentsForStreamParsing.available());
    assertEquals(108, contentsForStreamParsing2.available());
    assertEquals(108, contentsForStreamParsing3.available());
    assertEquals(108, contentsForStreamParsing4.available());
    assertEquals(108, contentsForRandomAccess.available());
    assertEquals(108, contentsForRandomAccess2.available());
    assertEquals(108, contentsForRandomAccess3.available());
    assertEquals(108, contentsForRandomAccess4.available());
    assertEquals(108, normalAppearanceStream.getStream().getLength());
    assertEquals(108, appearanceStream.getStream().getLength());
    assertEquals(108, appearanceStream2.getStream().getLength());
    assertEquals(108, appearanceStream3.getStream().getLength());
    assertEquals(108, normalAppearanceStream.getContentStream().getLength());
    assertEquals(108, appearanceStream.getContentStream().getLength());
    assertEquals(108, appearanceStream2.getContentStream().getLength());
    assertEquals(108, appearanceStream3.getContentStream().getLength());
    assertEquals(108L, normalAppearanceStream.getCOSObject().getLength());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(2.14748365E9f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(2.14748365E9f, floatArray[0]);
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances5() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setAppearance(new PDAppearanceDictionary(new COSDictionary()));
    pdAnnotationLink.setRectangle(PDRectangle.LETTER);

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(56, normalAppearanceStream.getStream().getLength());
    assertEquals(56, appearanceStream.getStream().getLength());
    assertEquals(56, appearanceStream2.getStream().getLength());
    assertEquals(56, appearanceStream3.getStream().getLength());
    assertEquals(56, normalAppearanceStream.getContentStream().getLength());
    assertEquals(56, appearanceStream.getContentStream().getLength());
    assertEquals(56, appearanceStream2.getContentStream().getLength());
    assertEquals(56, appearanceStream3.getContentStream().getLength());
    assertEquals(56L, normalAppearanceStream.getCOSObject().getLength());
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(612.0f, bBox.getUpperRightX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(612.0f, bBox2.getUpperRightX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(612.0f, bBox3.getUpperRightX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
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
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances6() throws IOException {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));
    PDAppearanceDictionary appearance = new PDAppearanceDictionary(dictionary);

    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setAppearance(appearance);
    pdAnnotationLink.setRectangle(PDRectangle.LETTER);

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance2 = pdAnnotationLink.getAppearance();
    PDAppearanceStream appearanceStream = appearance2.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance2.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance2.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(56, normalAppearanceStream.getStream().getLength());
    assertEquals(56, appearanceStream.getStream().getLength());
    assertEquals(56, appearanceStream2.getStream().getLength());
    assertEquals(56, appearanceStream3.getStream().getLength());
    assertEquals(56, normalAppearanceStream.getContentStream().getLength());
    assertEquals(56, appearanceStream.getContentStream().getLength());
    assertEquals(56, appearanceStream2.getContentStream().getLength());
    assertEquals(56, appearanceStream3.getContentStream().getLength());
    assertEquals(56L, normalAppearanceStream.getCOSObject().getLength());
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(612.0f, bBox.getUpperRightX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(612.0f, bBox2.getUpperRightX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(612.0f, bBox3.getUpperRightX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
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
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances7() {
    // Arrange
    PDAnnotationCircle annotation = new PDAnnotationCircle();
    annotation.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument());

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    assertEquals(-0.0f, floatArray[1]);
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
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox2.getUpperRightX());
    assertEquals(2383.937f, bBox3.getUpperRightX());
    assertEquals(2383.937f, bBox4.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(2383.937f, bBox2.getWidth());
    assertEquals(2383.937f, bBox3.getWidth());
    assertEquals(2383.937f, bBox4.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox2.getHeight());
    assertEquals(3370.3938f, bBox3.getHeight());
    assertEquals(3370.3938f, bBox4.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertEquals(3370.3938f, bBox2.getUpperRightY());
    assertEquals(3370.3938f, bBox3.getUpperRightY());
    assertEquals(3370.3938f, bBox4.getUpperRightY());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(70, contentsForStreamParsing.available());
    assertEquals(70, contentsForStreamParsing2.available());
    assertEquals(70, contentsForStreamParsing3.available());
    assertEquals(70, contentsForStreamParsing4.available());
    assertEquals(70, contentsForRandomAccess.available());
    assertEquals(70, contentsForRandomAccess2.available());
    assertEquals(70, contentsForRandomAccess3.available());
    assertEquals(70, contentsForRandomAccess4.available());
    assertEquals(70, normalAppearanceStream.getStream().getLength());
    assertEquals(70, appearanceStream.getStream().getLength());
    assertEquals(70, appearanceStream2.getStream().getLength());
    assertEquals(70, appearanceStream3.getStream().getLength());
    assertEquals(70, normalAppearanceStream.getContentStream().getLength());
    assertEquals(70, appearanceStream.getContentStream().getLength());
    assertEquals(70, appearanceStream2.getContentStream().getLength());
    assertEquals(70, appearanceStream3.getContentStream().getLength());
    assertEquals(70L, normalAppearanceStream.getCOSObject().getLength());
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument2() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument());

    // Assert
    COSDictionary cOSObject = pdAnnotationLink.getAppearance().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    COSDictionary cOSObject2 = pdAnnotationLink.getCOSObject();
    assertEquals(4, cOSObject2.getValues().size());
    assertEquals(4, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument3() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(new PDRectangle(-9.223372E18f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument());

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(108, contentsForStreamParsing.available());
    assertEquals(108, contentsForStreamParsing2.available());
    assertEquals(108, contentsForStreamParsing3.available());
    assertEquals(108, contentsForStreamParsing4.available());
    assertEquals(108, contentsForRandomAccess.available());
    assertEquals(108, contentsForRandomAccess2.available());
    assertEquals(108, contentsForRandomAccess3.available());
    assertEquals(108, contentsForRandomAccess4.available());
    assertEquals(108, normalAppearanceStream.getStream().getLength());
    assertEquals(108, appearanceStream.getStream().getLength());
    assertEquals(108, appearanceStream2.getStream().getLength());
    assertEquals(108, appearanceStream3.getStream().getLength());
    assertEquals(108, normalAppearanceStream.getContentStream().getLength());
    assertEquals(108, appearanceStream.getContentStream().getLength());
    assertEquals(108, appearanceStream2.getContentStream().getLength());
    assertEquals(108, appearanceStream3.getContentStream().getLength());
    assertEquals(108L, normalAppearanceStream.getCOSObject().getLength());
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(2.14748365E9f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(2.14748365E9f, floatArray[0]);
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n-2147483648 2147483648 m\n-2147483648 2147483648".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument4() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setAppearance(new PDAppearanceDictionary());
    pdAnnotationLink.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument());

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-2.14748365E9f, floatArray[0]);
    assertEquals(104, contentsForStreamParsing.available());
    assertEquals(104, contentsForStreamParsing2.available());
    assertEquals(104, contentsForStreamParsing3.available());
    assertEquals(104, contentsForStreamParsing4.available());
    assertEquals(104, contentsForRandomAccess.available());
    assertEquals(104, contentsForRandomAccess2.available());
    assertEquals(104, contentsForRandomAccess3.available());
    assertEquals(104, contentsForRandomAccess4.available());
    assertEquals(104, normalAppearanceStream.getStream().getLength());
    assertEquals(104, appearanceStream.getStream().getLength());
    assertEquals(104, appearanceStream2.getStream().getLength());
    assertEquals(104, appearanceStream3.getStream().getLength());
    assertEquals(104, normalAppearanceStream.getContentStream().getLength());
    assertEquals(104, appearanceStream.getContentStream().getLength());
    assertEquals(104, appearanceStream2.getContentStream().getLength());
    assertEquals(104, appearanceStream3.getContentStream().getLength());
    assertEquals(104L, normalAppearanceStream.getCOSObject().getLength());
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(2.14748365E9f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(2.14748365E9f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(2.14748365E9f, bBox4.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox2.getUpperRightX());
    assertEquals(2.14748365E9f, bBox3.getUpperRightX());
    assertEquals(2.14748365E9f, bBox4.getUpperRightX());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument5() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setAppearance(new PDAppearanceDictionary(new COSDictionary()));
    pdAnnotationLink.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument());

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-2.14748365E9f, floatArray[0]);
    assertEquals(104, contentsForStreamParsing.available());
    assertEquals(104, contentsForStreamParsing2.available());
    assertEquals(104, contentsForStreamParsing3.available());
    assertEquals(104, contentsForStreamParsing4.available());
    assertEquals(104, contentsForRandomAccess.available());
    assertEquals(104, contentsForRandomAccess2.available());
    assertEquals(104, contentsForRandomAccess3.available());
    assertEquals(104, contentsForRandomAccess4.available());
    assertEquals(104, normalAppearanceStream.getStream().getLength());
    assertEquals(104, appearanceStream.getStream().getLength());
    assertEquals(104, appearanceStream2.getStream().getLength());
    assertEquals(104, appearanceStream3.getStream().getLength());
    assertEquals(104, normalAppearanceStream.getContentStream().getLength());
    assertEquals(104, appearanceStream.getContentStream().getLength());
    assertEquals(104, appearanceStream2.getContentStream().getLength());
    assertEquals(104, appearanceStream3.getContentStream().getLength());
    assertEquals(104L, normalAppearanceStream.getCOSObject().getLength());
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(2.14748365E9f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(2.14748365E9f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(2.14748365E9f, bBox4.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox2.getUpperRightX());
    assertEquals(2.14748365E9f, bBox3.getUpperRightX());
    assertEquals(2.14748365E9f, bBox4.getUpperRightX());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument6() throws IOException {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));
    PDAppearanceDictionary appearance = new PDAppearanceDictionary(dictionary);

    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setAppearance(appearance);
    pdAnnotationLink.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument());

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance2 = pdAnnotationLink.getAppearance();
    PDAppearanceStream appearanceStream = appearance2.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance2.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance2.getRolloverAppearance().getAppearanceStream();
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
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-2.14748365E9f, floatArray[0]);
    assertEquals(104, contentsForStreamParsing.available());
    assertEquals(104, contentsForStreamParsing2.available());
    assertEquals(104, contentsForStreamParsing3.available());
    assertEquals(104, contentsForStreamParsing4.available());
    assertEquals(104, contentsForRandomAccess.available());
    assertEquals(104, contentsForRandomAccess2.available());
    assertEquals(104, contentsForRandomAccess3.available());
    assertEquals(104, contentsForRandomAccess4.available());
    assertEquals(104, normalAppearanceStream.getStream().getLength());
    assertEquals(104, appearanceStream.getStream().getLength());
    assertEquals(104, appearanceStream2.getStream().getLength());
    assertEquals(104, appearanceStream3.getStream().getLength());
    assertEquals(104, normalAppearanceStream.getContentStream().getLength());
    assertEquals(104, appearanceStream.getContentStream().getLength());
    assertEquals(104, appearanceStream2.getContentStream().getLength());
    assertEquals(104, appearanceStream3.getContentStream().getLength());
    assertEquals(104L, normalAppearanceStream.getCOSObject().getLength());
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(2.14748365E9f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(2.14748365E9f, bBox3.getLowerLeftX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
    assertEquals(2.14748365E9f, bBox4.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox2.getUpperRightX());
    assertEquals(2.14748365E9f, bBox3.getUpperRightX());
    assertEquals(2.14748365E9f, bBox4.getUpperRightX());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n2147483648 2147483648 m\n2147483648 2147483648 l".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument7() {
    // Arrange
    PDAnnotationCircle annotation = new PDAnnotationCircle();
    annotation.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument());

    // Assert
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link PDAnnotationCircle#PDAnnotationCircle()} Rectangle is
   * {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given PDAnnotationCircle() Rectangle is A0")
  void testConstructAppearancesWithPDDocument_givenPDAnnotationCircleRectangleIsA0() {
    // Arrange
    PDAnnotationCircle annotation = new PDAnnotationCircle();
    annotation.setRectangle(PDRectangle.A0);
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument());

    // Assert
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link PDAnnotationLink#PDAnnotationLink()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given PDAnnotationLink()")
  void testConstructAppearancesWithPDDocument_givenPDAnnotationLink() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.constructAppearances(new PDDocument());

    // Assert
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; when 'null'")
  void testConstructAppearancesWithPDDocument_whenNull() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationLink.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    Matrix matrix = normalAppearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    assertEquals(-0.0f, floatArray[1]);
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
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox2.getUpperRightX());
    assertEquals(2383.937f, bBox3.getUpperRightX());
    assertEquals(2383.937f, bBox4.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(2383.937f, bBox2.getWidth());
    assertEquals(2383.937f, bBox3.getWidth());
    assertEquals(2383.937f, bBox4.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox2.getHeight());
    assertEquals(3370.3938f, bBox3.getHeight());
    assertEquals(3370.3938f, bBox4.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertEquals(3370.3938f, bBox2.getUpperRightY());
    assertEquals(3370.3938f, bBox3.getUpperRightY());
    assertEquals(3370.3938f, bBox4.getUpperRightY());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    byte[] byteArray2 = new byte[51];
    assertEquals(51, appearanceStream.getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(51, appearanceStream2.getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(51, appearanceStream3.getContents().read(byteArray4));
    assertEquals(70, contentsForStreamParsing.available());
    assertEquals(70, contentsForStreamParsing2.available());
    assertEquals(70, contentsForStreamParsing3.available());
    assertEquals(70, contentsForStreamParsing4.available());
    assertEquals(70, contentsForRandomAccess.available());
    assertEquals(70, contentsForRandomAccess2.available());
    assertEquals(70, contentsForRandomAccess3.available());
    assertEquals(70, contentsForRandomAccess4.available());
    assertEquals(70, normalAppearanceStream.getStream().getLength());
    assertEquals(70, appearanceStream.getStream().getLength());
    assertEquals(70, appearanceStream2.getStream().getLength());
    assertEquals(70, appearanceStream3.getStream().getLength());
    assertEquals(70, normalAppearanceStream.getContentStream().getLength());
    assertEquals(70, appearanceStream.getContentStream().getLength());
    assertEquals(70, appearanceStream2.getContentStream().getLength());
    assertEquals(70, appearanceStream3.getContentStream().getLength());
    assertEquals(70L, normalAppearanceStream.getCOSObject().getLength());
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n0.5 0.5 m\n2383.437 0.5 l\n2383.437 3369.8938 l\n0".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances()}.
   * <ul>
   *   <li>Given {@link PDAnnotationCircle#PDAnnotationCircle()} Rectangle is
   * {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDAnnotationCircle() Rectangle is A0")
  void testConstructAppearances_givenPDAnnotationCircleRectangleIsA0() {
    // Arrange
    PDAnnotationCircle annotation = new PDAnnotationCircle();
    annotation.setRectangle(PDRectangle.A0);
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances()}.
   * <ul>
   *   <li>Given {@link PDAnnotationLink#PDAnnotationLink()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDAnnotationLink()")
  void testConstructAppearances_givenPDAnnotationLink() {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    COSDictionary cOSObject = pdAnnotationLink.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLink#constructAppearances()}.
   * <ul>
   *   <li>Given {@link PDAnnotationLink#PDAnnotationLink()} Appearance is
   * {@link PDAppearanceDictionary#PDAppearanceDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationLink#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDAnnotationLink() Appearance is PDAppearanceDictionary()")
  void testConstructAppearances_givenPDAnnotationLinkAppearanceIsPDAppearanceDictionary() throws IOException {
    // Arrange
    PDAnnotationLink pdAnnotationLink = new PDAnnotationLink();
    pdAnnotationLink.setAppearance(new PDAppearanceDictionary());
    pdAnnotationLink.setRectangle(PDRectangle.LETTER);

    // Act
    pdAnnotationLink.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationLink.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing = normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadBuffer);
    PDAppearanceDictionary appearance = pdAnnotationLink.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing2 = appearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing2 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    RandomAccessRead contentsForStreamParsing3 = appearanceStream2.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing3 instanceof RandomAccessReadBuffer);
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
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
    assertEquals(56, normalAppearanceStream.getStream().getLength());
    assertEquals(56, appearanceStream.getStream().getLength());
    assertEquals(56, appearanceStream2.getStream().getLength());
    assertEquals(56, appearanceStream3.getStream().getLength());
    assertEquals(56, normalAppearanceStream.getContentStream().getLength());
    assertEquals(56, appearanceStream.getContentStream().getLength());
    assertEquals(56, appearanceStream2.getContentStream().getLength());
    assertEquals(56, appearanceStream3.getContentStream().getLength());
    assertEquals(56L, normalAppearanceStream.getCOSObject().getLength());
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(612.0f, bBox.getUpperRightX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(612.0f, bBox2.getUpperRightX());
    PDRectangle bBox3 = appearanceStream2.getBBox();
    assertEquals(612.0f, bBox3.getUpperRightX());
    PDRectangle bBox4 = appearanceStream3.getBBox();
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
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray2);
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray3);
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray4);
    assertArrayEquals("0 G\n0.5 0.5 m\n611.5 0.5 l\n611.5 791.5 l\n0.5 791.5 l".getBytes("UTF-8"), byteArray);
  }
}
