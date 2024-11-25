package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFCloneUtilityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDFCloneUtility#PDFCloneUtility(PDDocument)}
   *   <li>{@link PDFCloneUtility#getDestination()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    PDDocument dest = new PDDocument();

    // Act and Assert
    assertSame(dest, (new PDFCloneUtility(dest)).getDestination());
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   * <p>
   * Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase)")
  void testCloneForNewDocument() throws IOException {
    // Arrange and Act
    COSBase actualCloneForNewDocumentResult = (new PDFCloneUtility(new PDDocument()))
        .cloneForNewDocument(COSBoolean.FALSE);

    // Assert
    assertSame(((COSBoolean) actualCloneForNewDocumentResult).FALSE, actualCloneForNewDocumentResult);
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName("Test cloneMerge(COSObjectable, COSObjectable); given COSArray(); when COSObjectable getCOSObject() return COSArray()")
  void testCloneMerge_givenCOSArray_whenCOSObjectableGetCOSObjectReturnCOSArray() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());
    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(new COSArray());
    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert that nothing has changed
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName("Test cloneMerge(COSObjectable, COSObjectable); given COSDictionary()")
  void testCloneMerge_givenCOSDictionary() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());
    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(new COSDictionary());
    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert that nothing has changed
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName("Test cloneMerge(COSObjectable, COSObjectable); given COSObjectKey(long, int) with num is one and gen is one")
  void testCloneMerge_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());
    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert that nothing has changed
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName("Test cloneMerge(COSObjectable, COSObjectable); given COSObjectKey(long, int) with num is one and gen is one")
  void testCloneMerge_givenCOSObjectKeyWithNumIsOneAndGenIsOne2() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());
    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert that nothing has changed
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   * <ul>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName("Test cloneMerge(COSObjectable, COSObjectable); when COSObjectable getCOSObject() return FALSE")
  void testCloneMerge_whenCOSObjectableGetCOSObjectReturnFalse() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());
    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert that nothing has changed
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }
}
