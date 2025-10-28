package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;

class FDFParserDiffblueTest {
  /**
   * Method under test: {@link FDFParser#FDFParser(RandomAccessRead)}
   */
  @Test
  void testNewFDFParser() throws IOException {
    // Arrange and Act
    FDFParser actualFdfParser = new FDFParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    RandomAccessRead randomAccessRead = actualFdfParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    COSDocument cosDocument = actualFdfParser.document;
    assertNull(cosDocument.getLinearizedDictionary());
    assertNull(cosDocument.getTrailer());
    assertNull(cosDocument.getKey());
    assertNull(actualFdfParser.getAccessPermission());
    assertNull(actualFdfParser.getEncryption());
    assertNull(actualFdfParser.getSecurityHandler());
    assertEquals(0L, cosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, cosDocument.getStartXref());
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(1.4f, cosDocument.getVersion());
    assertEquals(8, randomAccessRead.available());
    assertFalse(cosDocument.isDirect());
    assertFalse(cosDocument.hasHybridXRef());
    assertFalse(cosDocument.isClosed());
    assertFalse(cosDocument.isDecrypted());
    assertFalse(cosDocument.isEncrypted());
    assertFalse(cosDocument.isXRefStream());
    assertFalse(cosDocument.getDocumentState().isAcceptingUpdates());
    assertFalse(randomAccessRead.isClosed());
    assertFalse(actualFdfParser.isDigit());
    assertFalse(actualFdfParser.isEOF());
    assertFalse(actualFdfParser.isSpace());
    assertFalse(actualFdfParser.isWhitespace());
    BruteForceParser bruteForceParser = actualFdfParser.getBruteForceParser();
    assertFalse(bruteForceParser.bfSearchTriggered());
    assertFalse(actualFdfParser.initialParseDone);
    assertTrue(cosDocument.getXrefTable().isEmpty());
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(actualFdfParser.isLenient());
  }
}
