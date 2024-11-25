package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class XrefEntriesDiffblueTest {
  /**
   * Test {@link XrefEntries#XrefEntries(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return XrefEntryCount is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link XrefEntries#XrefEntries(PDDocument)}
   */
  @Test
  @DisplayName("Test new XrefEntries(PDDocument); when PDDocument(); then return XrefEntryCount is zero")
  void testNewXrefEntries_whenPDDocument_thenReturnXrefEntryCountIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new XrefEntries(new PDDocument())).getXrefEntryCount());
  }

  /**
   * Test {@link XrefEntries#getXrefEntryCount()}.
   * <p>
   * Method under test: {@link XrefEntries#getXrefEntryCount()}
   */
  @Test
  @DisplayName("Test getXrefEntryCount()")
  void testGetXrefEntryCount() {
    // Arrange, Act and Assert
    assertEquals(0, (new XrefEntries(new PDDocument())).getXrefEntryCount());
  }

  /**
   * Test {@link XrefEntries#indexOf(XrefEntry)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link XrefEntries#indexOf(XrefEntry)}
   */
  @Test
  @DisplayName("Test indexOf(XrefEntry); when COSObjectKey(long, int) with num is one and gen is one; then return zero")
  void testIndexOf_whenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnZero() {
    // Arrange
    XrefEntries xrefEntries = new XrefEntries(new PDDocument());
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertEquals(0, xrefEntries.indexOf(new XrefEntry(1, key, 1L, new COSObject(object, new COSObjectKey(1L, 1)))));
  }

  /**
   * Test {@link XrefEntries#toString()}.
   * <p>
   * Method under test: {@link XrefEntries#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(XrefEntries.PATH, (new XrefEntries(new PDDocument())).toString());
  }
}
