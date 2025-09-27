package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFCloneUtilityDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDFCloneUtility#PDFCloneUtility(PDDocument)}
   *   <li>{@link PDFCloneUtility#getDestination()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFCloneUtility.<init>(PDDocument)",
    "PDDocument PDFCloneUtility.getDestination()"
  })
  void testGettersAndSetters() {
    // Arrange
    PDDocument dest = new PDDocument();

    // Act and Assert
    assertSame(dest, new PDFCloneUtility(dest).getDestination());
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237));

    // Act
    COSBase actualCloneForNewDocumentResult = pdfCloneUtility.cloneForNewDocument(cosObject);

    // Assert
    COSBoolean cosBoolean = ((COSBoolean) actualCloneForNewDocumentResult).FALSE;
    assertSame(cosBoolean, cosObject.getObject());
    assertSame(cosBoolean, actualCloneForNewDocumentResult);
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when A; then return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenA_thenReturnA() throws IOException {
    // Arrange and Act
    COSBase actualCloneForNewDocumentResult =
        new PDFCloneUtility(new PDDocument()).cloneForNewDocument(COSName.A);

    // Assert
    assertSame(((COSName) actualCloneForNewDocumentResult).A, actualCloneForNewDocumentResult);
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when COSArray(); then return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenCOSArray_thenReturnCOSArray() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    // Act
    COSBase actualCloneForNewDocumentResult = pdfCloneUtility.cloneForNewDocument(new COSArray());

    // Assert
    assertTrue(actualCloneForNewDocumentResult instanceof COSArray);
    assertTrue(((COSArray) actualCloneForNewDocumentResult).toList().isEmpty());
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return {@link COSDictionary}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when COSDictionary(); then return COSDictionary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenCOSDictionary_thenReturnCOSDictionary() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    // Act
    COSBase actualCloneForNewDocumentResult =
        pdfCloneUtility.cloneForNewDocument(new COSDictionary());

    // Assert
    assertTrue(actualCloneForNewDocumentResult instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) actualCloneForNewDocumentResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertEquals(0, ((COSDictionary) actualCloneForNewDocumentResult).size());
    COSIncrement toIncrementResult =
        ((COSDictionary) actualCloneForNewDocumentResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(((COSDictionary) actualCloneForNewDocumentResult).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(((COSDictionary) actualCloneForNewDocumentResult).getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then return {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when FALSE; then return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenFalse_thenReturnFalse() throws IOException {
    // Arrange and Act
    COSBase actualCloneForNewDocumentResult =
        new PDFCloneUtility(new PDDocument()).cloneForNewDocument(COSBoolean.FALSE);

    // Assert
    assertSame(
        ((COSBoolean) actualCloneForNewDocumentResult).FALSE, actualCloneForNewDocumentResult);
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDFCloneUtility(new PDDocument()).cloneForNewDocument(null));
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSInteger#ONE}.
   *   <li>Then return {@link COSInteger}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when ONE; then return COSInteger")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenOne_thenReturnCOSInteger() throws IOException {
    // Arrange and Act
    COSBase actualCloneForNewDocumentResult =
        new PDFCloneUtility(new PDDocument()).cloneForNewDocument(COSInteger.ONE);

    // Assert
    assertTrue(actualCloneForNewDocumentResult instanceof COSInteger);
    assertTrue(((COSInteger) actualCloneForNewDocumentResult).isValid());
    assertSame(((COSInteger) actualCloneForNewDocumentResult).ONE, actualCloneForNewDocumentResult);
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSFloat#ONE}.
   *   <li>Then return {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when ONE; then return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenOne_thenReturnOne() throws IOException {
    // Arrange and Act
    COSBase actualCloneForNewDocumentResult =
        new PDFCloneUtility(new PDDocument()).cloneForNewDocument(COSFloat.ONE);

    // Assert
    assertSame(((COSFloat) actualCloneForNewDocumentResult).ONE, actualCloneForNewDocumentResult);
  }

  /**
   * Test {@link PDFCloneUtility#cloneForNewDocument(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#TRUE}.
   *   <li>Then return {@link COSBoolean#TRUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneForNewDocument(COSBase)}
   */
  @Test
  @DisplayName("Test cloneForNewDocument(COSBase); when TRUE; then return TRUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFCloneUtility.cloneForNewDocument(COSBase)"})
  void testCloneForNewDocument_whenTrue_thenReturnTrue() throws IOException {
    // Arrange and Act
    COSBase actualCloneForNewDocumentResult =
        new PDFCloneUtility(new PDDocument()).cloneForNewDocument(COSBoolean.TRUE);

    // Assert
    assertSame(
        ((COSBoolean) actualCloneForNewDocumentResult).TRUE, actualCloneForNewDocumentResult);
  }

  /**
   * Test {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}.
   *
   * <p>Method under test: {@link PDFCloneUtility#cloneMerge(COSObjectable, COSObjectable)}
   */
  @Test
  @DisplayName("Test cloneMerge(COSObjectable, COSObjectable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFCloneUtility.cloneMerge(COSObjectable, COSObjectable)"})
  void testCloneMerge() throws IOException {
    // Arrange
    PDFCloneUtility pdfCloneUtility = new PDFCloneUtility(new PDDocument());

    COSObjectable base = mock(COSObjectable.class);
    when(base.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSObjectable target = mock(COSObjectable.class);
    when(target.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdfCloneUtility.cloneMerge(base, target);

    // Assert
    verify(base).getCOSObject();
    verify(target).getCOSObject();
  }
}
