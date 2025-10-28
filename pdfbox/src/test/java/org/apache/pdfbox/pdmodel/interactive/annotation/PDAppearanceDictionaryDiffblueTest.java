package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;

class PDAppearanceDictionaryDiffblueTest {
  /**
   * Method under test: {@link PDAppearanceDictionary#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDAppearanceDictionary()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDAppearanceDictionary#getNormalAppearance()}
   */
  @Test
  void testGetNormalAppearance() {
    // Arrange and Act
    PDAppearanceEntry actualNormalAppearance = (new PDAppearanceDictionary()).getNormalAppearance();

    // Assert
    COSDictionary cOSObject = actualNormalAppearance.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualNormalAppearance.isStream());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(actualNormalAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualNormalAppearance.isSubDictionary());
  }

  /**
   * Method under test: {@link PDAppearanceDictionary#getNormalAppearance()}
   */
  @Test
  void testGetNormalAppearance2() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceDictionary(new COSDictionary())).getNormalAppearance());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}
   */
  @Test
  void testSetNormalAppearance() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSDictionary entry = new COSDictionary();

    // Act
    pdAppearanceDictionary.setNormalAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    PDAppearanceEntry normalAppearance = pdAppearanceDictionary.getNormalAppearance();
    assertTrue(normalAppearance.getSubDictionary().isEmpty());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertSame(entry, downAppearance.getCOSObject());
    assertSame(entry, normalAppearance.getCOSObject());
    assertSame(entry, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}
   */
  @Test
  void testSetNormalAppearance2() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    // Act
    pdAppearanceDictionary.setNormalAppearance(new PDAppearanceEntry(null));

    // Assert
    assertNull(pdAppearanceDictionary.getDownAppearance());
    assertNull(pdAppearanceDictionary.getNormalAppearance());
    assertNull(pdAppearanceDictionary.getRolloverAppearance());
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}
   */
  @Test
  void testSetNormalAppearance3() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    // Act
    pdAppearanceDictionary.setNormalAppearance((PDAppearanceEntry) null);

    // Assert
    assertNull(pdAppearanceDictionary.getDownAppearance());
    assertNull(pdAppearanceDictionary.getNormalAppearance());
    assertNull(pdAppearanceDictionary.getRolloverAppearance());
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}
   */
  @Test
  void testSetNormalAppearance4() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSDictionary entry = new COSDictionary();
    entry.setDirect(true);

    // Act
    pdAppearanceDictionary.setNormalAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    PDAppearanceEntry normalAppearance = pdAppearanceDictionary.getNormalAppearance();
    assertTrue(normalAppearance.getSubDictionary().isEmpty());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertSame(entry, downAppearance.getCOSObject());
    assertSame(entry, normalAppearance.getCOSObject());
    assertSame(entry, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}
   */
  @Test
  void testSetNormalAppearance5() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSDictionary entry = new COSDictionary();
    entry.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAppearanceDictionary.setNormalAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    PDAppearanceEntry normalAppearance = pdAppearanceDictionary.getNormalAppearance();
    assertTrue(normalAppearance.getSubDictionary().isEmpty());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertSame(entry, downAppearance.getCOSObject());
    assertSame(entry, normalAppearance.getCOSObject());
    assertSame(entry, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceStream)}
   */
  @Test
  void testSetNormalAppearance6() throws IOException {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSStream stream = new COSStream();

    // Act
    pdAppearanceDictionary.setNormalAppearance(new PDAppearanceStream(stream));

    // Assert
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDAppearanceEntry normalAppearance = pdAppearanceDictionary.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    PDStream stream3 = appearanceStream2.getStream();
    assertNull(stream3.getDecodeParms());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
    PDStream stream4 = appearanceStream3.getStream();
    assertNull(stream4.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream2.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream3.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(appearanceStream.getResources());
    assertNull(appearanceStream2.getResources());
    assertNull(appearanceStream3.getResources());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(appearanceStream2.getBBox());
    assertNull(appearanceStream3.getBBox());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    assertEquals(0, stream2.getLength());
    assertEquals(0, stream3.getLength());
    assertEquals(0, stream4.getLength());
    assertEquals(0, contentStream.getLength());
    assertEquals(0, contentStream2.getLength());
    assertEquals(0, contentStream3.getLength());
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, stream3.getCOSObject());
    assertSame(stream, stream4.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, contentStream2.getCOSObject());
    assertSame(stream, contentStream3.getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, appearanceStream2.getCOSObject());
    assertSame(stream, appearanceStream3.getCOSObject());
    assertSame(stream, downAppearance.getCOSObject());
    assertSame(stream, normalAppearance.getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceStream)}
   */
  @Test
  void testSetNormalAppearance7() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    // Act
    pdAppearanceDictionary.setNormalAppearance((PDAppearanceStream) null);

    // Assert
    assertNull(pdAppearanceDictionary.getDownAppearance());
    assertNull(pdAppearanceDictionary.getNormalAppearance());
    assertNull(pdAppearanceDictionary.getRolloverAppearance());
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceStream)}
   */
  @Test
  void testSetNormalAppearance8() throws IOException {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSStream stream = new COSStream();
    stream.setDirect(true);

    // Act
    pdAppearanceDictionary.setNormalAppearance(new PDAppearanceStream(stream));

    // Assert
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDAppearanceEntry normalAppearance = pdAppearanceDictionary.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    PDStream stream3 = appearanceStream2.getStream();
    assertNull(stream3.getDecodeParms());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
    PDStream stream4 = appearanceStream3.getStream();
    assertNull(stream4.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream2.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream3.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(appearanceStream.getResources());
    assertNull(appearanceStream2.getResources());
    assertNull(appearanceStream3.getResources());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(appearanceStream2.getBBox());
    assertNull(appearanceStream3.getBBox());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    assertEquals(0, stream2.getLength());
    assertEquals(0, stream3.getLength());
    assertEquals(0, stream4.getLength());
    assertEquals(0, contentStream.getLength());
    assertEquals(0, contentStream2.getLength());
    assertEquals(0, contentStream3.getLength());
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, stream3.getCOSObject());
    assertSame(stream, stream4.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, contentStream2.getCOSObject());
    assertSame(stream, contentStream3.getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, appearanceStream2.getCOSObject());
    assertSame(stream, appearanceStream3.getCOSObject());
    assertSame(stream, downAppearance.getCOSObject());
    assertSame(stream, normalAppearance.getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceStream)}
   */
  @Test
  void testSetNormalAppearance9() throws IOException {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSStream stream = new COSStream();
    stream.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAppearanceDictionary.setNormalAppearance(new PDAppearanceStream(stream));

    // Assert
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDAppearanceEntry normalAppearance = pdAppearanceDictionary.getNormalAppearance();
    PDAppearanceStream appearanceStream2 = normalAppearance.getAppearanceStream();
    PDStream stream3 = appearanceStream2.getStream();
    assertNull(stream3.getDecodeParms());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    PDAppearanceStream appearanceStream3 = rolloverAppearance.getAppearanceStream();
    PDStream stream4 = appearanceStream3.getStream();
    assertNull(stream4.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream2.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream3.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(appearanceStream.getResources());
    assertNull(appearanceStream2.getResources());
    assertNull(appearanceStream3.getResources());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(appearanceStream2.getBBox());
    assertNull(appearanceStream3.getBBox());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    assertEquals(0, stream2.getLength());
    assertEquals(0, stream3.getLength());
    assertEquals(0, stream4.getLength());
    assertEquals(0, contentStream.getLength());
    assertEquals(0, contentStream2.getLength());
    assertEquals(0, contentStream3.getLength());
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, stream3.getCOSObject());
    assertSame(stream, stream4.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, contentStream2.getCOSObject());
    assertSame(stream, contentStream3.getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, appearanceStream2.getCOSObject());
    assertSame(stream, appearanceStream3.getCOSObject());
    assertSame(stream, downAppearance.getCOSObject());
    assertSame(stream, normalAppearance.getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDAppearanceDictionary#getRolloverAppearance()}
   */
  @Test
  void testGetRolloverAppearance() {
    // Arrange and Act
    PDAppearanceEntry actualRolloverAppearance = (new PDAppearanceDictionary()).getRolloverAppearance();

    // Assert
    COSDictionary cOSObject = actualRolloverAppearance.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualRolloverAppearance.isStream());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(actualRolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualRolloverAppearance.isSubDictionary());
  }

  /**
   * Method under test: {@link PDAppearanceDictionary#getRolloverAppearance()}
   */
  @Test
  void testGetRolloverAppearance2() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceDictionary(new COSDictionary())).getRolloverAppearance());
  }

  /**
   * Method under test: {@link PDAppearanceDictionary#getRolloverAppearance()}
   */
  @Test
  void testGetRolloverAppearance3() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSDictionary entry = new COSDictionary();
    pdAppearanceDictionary.setRolloverAppearance(new PDAppearanceEntry(entry));

    // Act
    PDAppearanceEntry actualRolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();

    // Assert
    assertFalse(actualRolloverAppearance.isStream());
    assertTrue(actualRolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(actualRolloverAppearance.isSubDictionary());
    assertSame(entry, actualRolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDAppearanceDictionary#getRolloverAppearance()}
   */
  @Test
  void testGetRolloverAppearance4() {
    // Arrange
    COSDictionary entry = new COSDictionary();
    entry.setKey(new COSObjectKey(1L, 1));
    PDAppearanceEntry entry2 = new PDAppearanceEntry(entry);

    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    pdAppearanceDictionary.setRolloverAppearance(entry2);

    // Act
    PDAppearanceEntry actualRolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();

    // Assert
    assertFalse(actualRolloverAppearance.isStream());
    assertTrue(actualRolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(actualRolloverAppearance.isSubDictionary());
    assertSame(entry, actualRolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceEntry)}
   */
  @Test
  void testSetRolloverAppearance() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSDictionary entry = new COSDictionary();

    // Act
    pdAppearanceDictionary.setRolloverAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertSame(entry, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceEntry)}
   */
  @Test
  void testSetRolloverAppearance2() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    // Act
    pdAppearanceDictionary.setRolloverAppearance(new PDAppearanceEntry(null));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdAppearanceDictionary.getRolloverAppearance().getSubDictionary().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceEntry)}
   */
  @Test
  void testSetRolloverAppearance3() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    // Act
    pdAppearanceDictionary.setRolloverAppearance((PDAppearanceEntry) null);

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdAppearanceDictionary.getRolloverAppearance().getSubDictionary().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceEntry)}
   */
  @Test
  void testSetRolloverAppearance4() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSDictionary entry = new COSDictionary();
    entry.setDirect(true);

    // Act
    pdAppearanceDictionary.setRolloverAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertSame(entry, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceEntry)}
   */
  @Test
  void testSetRolloverAppearance5() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSDictionary entry = new COSDictionary();
    entry.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAppearanceDictionary.setRolloverAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertSame(entry, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceStream)}
   */
  @Test
  void testSetRolloverAppearance6() throws IOException {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSStream stream = new COSStream();

    // Act
    pdAppearanceDictionary.setRolloverAppearance(new PDAppearanceStream(stream));

    // Assert
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    PDAppearanceStream appearanceStream = rolloverAppearance.getAppearanceStream();
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(appearanceStream.getResources());
    assertNull(stream2.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(stream2.getFile());
    assertNull(contentStream.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(0, stream2.getLength());
    assertEquals(0, contentStream.getLength());
    assertEquals(1, appearanceStream.getFormType());
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isStream());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceStream)}
   */
  @Test
  void testSetRolloverAppearance7() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    // Act
    pdAppearanceDictionary.setRolloverAppearance((PDAppearanceStream) null);

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertFalse(rolloverAppearance.isStream());
    assertTrue(rolloverAppearance.isSubDictionary());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceStream)}
   */
  @Test
  void testSetRolloverAppearance8() throws IOException {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSStream stream = new COSStream();
    stream.setDirect(true);

    // Act
    pdAppearanceDictionary.setRolloverAppearance(new PDAppearanceStream(stream));

    // Assert
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    PDAppearanceStream appearanceStream = rolloverAppearance.getAppearanceStream();
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(appearanceStream.getResources());
    assertNull(stream2.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(stream2.getFile());
    assertNull(contentStream.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(0, stream2.getLength());
    assertEquals(0, contentStream.getLength());
    assertEquals(1, appearanceStream.getFormType());
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isStream());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceStream)}
   */
  @Test
  void testSetRolloverAppearance9() throws IOException {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSStream stream = new COSStream();
    stream.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAppearanceDictionary.setRolloverAppearance(new PDAppearanceStream(stream));

    // Assert
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    PDAppearanceStream appearanceStream = rolloverAppearance.getAppearanceStream();
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(appearanceStream.getResources());
    assertNull(stream2.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(stream2.getFile());
    assertNull(contentStream.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(0, stream2.getLength());
    assertEquals(0, contentStream.getLength());
    assertEquals(1, appearanceStream.getFormType());
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isStream());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDAppearanceDictionary#getDownAppearance()}
   */
  @Test
  void testGetDownAppearance() {
    // Arrange and Act
    PDAppearanceEntry actualDownAppearance = (new PDAppearanceDictionary()).getDownAppearance();

    // Assert
    COSDictionary cOSObject = actualDownAppearance.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualDownAppearance.isStream());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(actualDownAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualDownAppearance.isSubDictionary());
  }

  /**
   * Method under test: {@link PDAppearanceDictionary#getDownAppearance()}
   */
  @Test
  void testGetDownAppearance2() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceDictionary(new COSDictionary())).getDownAppearance());
  }

  /**
   * Method under test: {@link PDAppearanceDictionary#getDownAppearance()}
   */
  @Test
  void testGetDownAppearance3() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSDictionary entry = new COSDictionary();
    pdAppearanceDictionary.setDownAppearance(new PDAppearanceEntry(entry));

    // Act
    PDAppearanceEntry actualDownAppearance = pdAppearanceDictionary.getDownAppearance();

    // Assert
    assertFalse(actualDownAppearance.isStream());
    assertTrue(actualDownAppearance.getSubDictionary().isEmpty());
    assertTrue(actualDownAppearance.isSubDictionary());
    assertSame(entry, actualDownAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDAppearanceDictionary#getDownAppearance()}
   */
  @Test
  void testGetDownAppearance4() {
    // Arrange
    COSDictionary entry = new COSDictionary();
    entry.setKey(new COSObjectKey(1L, 1));
    PDAppearanceEntry entry2 = new PDAppearanceEntry(entry);

    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    pdAppearanceDictionary.setDownAppearance(entry2);

    // Act
    PDAppearanceEntry actualDownAppearance = pdAppearanceDictionary.getDownAppearance();

    // Assert
    assertFalse(actualDownAppearance.isStream());
    assertTrue(actualDownAppearance.getSubDictionary().isEmpty());
    assertTrue(actualDownAppearance.isSubDictionary());
    assertSame(entry, actualDownAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceEntry)}
   */
  @Test
  void testSetDownAppearance() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSDictionary entry = new COSDictionary();

    // Act
    pdAppearanceDictionary.setDownAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getNormalAppearance().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSDictionary cOSObject2 = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject2.getValues().size());
    assertEquals(2, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(entry, downAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceEntry)}
   */
  @Test
  void testSetDownAppearance2() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    // Act
    pdAppearanceDictionary.setDownAppearance(new PDAppearanceEntry(null));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdAppearanceDictionary.getDownAppearance().getSubDictionary().isEmpty());
    assertTrue(pdAppearanceDictionary.getRolloverAppearance().getSubDictionary().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceEntry)}
   */
  @Test
  void testSetDownAppearance3() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    // Act
    pdAppearanceDictionary.setDownAppearance((PDAppearanceEntry) null);

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdAppearanceDictionary.getDownAppearance().getSubDictionary().isEmpty());
    assertTrue(pdAppearanceDictionary.getRolloverAppearance().getSubDictionary().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceEntry)}
   */
  @Test
  void testSetDownAppearance4() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSDictionary entry = new COSDictionary();
    entry.setDirect(true);

    // Act
    pdAppearanceDictionary.setDownAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getNormalAppearance().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSDictionary cOSObject2 = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject2.getValues().size());
    assertEquals(2, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(entry, downAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceEntry)}
   */
  @Test
  void testSetDownAppearance5() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSDictionary entry = new COSDictionary();
    entry.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAppearanceDictionary.setDownAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getNormalAppearance().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSDictionary cOSObject2 = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject2.getValues().size());
    assertEquals(2, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(entry, downAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceStream)}
   */
  @Test
  void testSetDownAppearance6() throws IOException {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSStream stream = new COSStream();

    // Act
    pdAppearanceDictionary.setDownAppearance(new PDAppearanceStream(stream));

    // Assert
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    COSDictionary cOSObject = pdAppearanceDictionary.getNormalAppearance().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(appearanceStream.getResources());
    assertNull(stream2.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(stream2.getFile());
    assertNull(contentStream.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(0, cOSObject.size());
    assertEquals(0, stream2.getLength());
    assertEquals(0, contentStream.getLength());
    assertEquals(1, appearanceStream.getFormType());
    COSDictionary cOSObject2 = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject2.getValues().size());
    assertEquals(2, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(downAppearance.isSubDictionary());
    assertTrue(cOSObject.getValues().isEmpty());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(downAppearance.isStream());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, downAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceStream)}
   */
  @Test
  void testSetDownAppearance7() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    // Act
    pdAppearanceDictionary.setDownAppearance((PDAppearanceStream) null);

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    assertFalse(downAppearance.isStream());
    assertTrue(pdAppearanceDictionary.getRolloverAppearance().getSubDictionary().isEmpty());
    assertTrue(downAppearance.isSubDictionary());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceStream)}
   */
  @Test
  void testSetDownAppearance8() throws IOException {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSStream stream = new COSStream();
    stream.setDirect(true);

    // Act
    pdAppearanceDictionary.setDownAppearance(new PDAppearanceStream(stream));

    // Assert
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    COSDictionary cOSObject = pdAppearanceDictionary.getNormalAppearance().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(appearanceStream.getResources());
    assertNull(stream2.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(stream2.getFile());
    assertNull(contentStream.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(0, cOSObject.size());
    assertEquals(0, stream2.getLength());
    assertEquals(0, contentStream.getLength());
    assertEquals(1, appearanceStream.getFormType());
    COSDictionary cOSObject2 = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject2.getValues().size());
    assertEquals(2, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(downAppearance.isSubDictionary());
    assertTrue(cOSObject.getValues().isEmpty());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(downAppearance.isStream());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, downAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceStream)}
   */
  @Test
  void testSetDownAppearance9() throws IOException {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSStream stream = new COSStream();
    stream.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAppearanceDictionary.setDownAppearance(new PDAppearanceStream(stream));

    // Assert
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDStream stream2 = appearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    COSDictionary cOSObject = pdAppearanceDictionary.getNormalAppearance().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(appearanceStream.getResources());
    assertNull(stream2.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(stream2.getFile());
    assertNull(contentStream.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(0, cOSObject.size());
    assertEquals(0, stream2.getLength());
    assertEquals(0, contentStream.getLength());
    assertEquals(1, appearanceStream.getFormType());
    COSDictionary cOSObject2 = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject2.getValues().size());
    assertEquals(2, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(downAppearance.isSubDictionary());
    assertTrue(cOSObject.getValues().isEmpty());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(downAppearance.isStream());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, downAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceDictionary#PDAppearanceDictionary(COSDictionary)}
   */
  @Test
  void testNewPDAppearanceDictionary() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDAppearanceDictionary(dictionary)).getCOSObject());
  }

  /**
   * Method under test: {@link PDAppearanceDictionary#PDAppearanceDictionary()}
   */
  @Test
  void testNewPDAppearanceDictionary2() {
    // Arrange and Act
    PDAppearanceDictionary actualPdAppearanceDictionary = new PDAppearanceDictionary();

    // Assert
    COSDictionary cOSObject = actualPdAppearanceDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    PDAppearanceEntry downAppearance = actualPdAppearanceDictionary.getDownAppearance();
    COSDictionary cOSObject2 = downAppearance.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertEquals(0, cOSObject2.size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(downAppearance.isStream());
    PDAppearanceEntry normalAppearance = actualPdAppearanceDictionary.getNormalAppearance();
    assertFalse(normalAppearance.isStream());
    PDAppearanceEntry rolloverAppearance = actualPdAppearanceDictionary.getRolloverAppearance();
    assertFalse(rolloverAppearance.isStream());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    assertTrue(normalAppearance.getSubDictionary().isEmpty());
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(downAppearance.isSubDictionary());
    assertTrue(normalAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isSubDictionary());
    assertSame(cOSObject2, normalAppearance.getCOSObject());
    assertSame(cOSObject2, rolloverAppearance.getCOSObject());
  }
}
