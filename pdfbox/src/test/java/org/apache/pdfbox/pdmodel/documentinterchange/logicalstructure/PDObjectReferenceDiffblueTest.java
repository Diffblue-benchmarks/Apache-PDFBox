package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

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
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationUnknown;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDObjectReferenceDiffblueTest {
  /**
   * Test {@link PDObjectReference#PDObjectReference(COSDictionary)}.
   *
   * <p>Method under test: {@link PDObjectReference#PDObjectReference(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDObjectReference(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectReference.<init>(COSDictionary)"})
  void testNewPDObjectReference() {
    // Arrange
    COSDictionary theDictionary = new COSDictionary();

    // Act and Assert
    assertSame(theDictionary, new PDObjectReference(theDictionary).getCOSObject());
  }

  /**
   * Test {@link PDObjectReference#PDObjectReference()}.
   *
   * <p>Method under test: {@link PDObjectReference#PDObjectReference()}
   */
  @Test
  @DisplayName("Test new PDObjectReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectReference.<init>()"})
  void testNewPDObjectReference2() {
    // Arrange and Act
    PDObjectReference actualPdObjectReference = new PDObjectReference();

    // Assert
    COSDictionary cOSObject = actualPdObjectReference.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdObjectReference.getPage());
    assertNull(actualPdObjectReference.getReferencedObject());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDObjectReference#getCOSObject()}.
   *
   * <p>Method under test: {@link PDObjectReference#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDObjectReference.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDObjectReference().getCOSObject();

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
   * Test {@link PDObjectReference#getReferencedObject()}.
   *
   * <ul>
   *   <li>Given {@link PDObjectReference#PDObjectReference(COSDictionary)} with theDictionary is
   *       {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectReference#getReferencedObject()}
   */
  @Test
  @DisplayName(
      "Test getReferencedObject(); given PDObjectReference(COSDictionary) with theDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectable PDObjectReference.getReferencedObject()"})
  void testGetReferencedObject_givenPDObjectReferenceWithTheDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDObjectReference(new COSDictionary()).getReferencedObject());
  }

  /**
   * Test {@link PDObjectReference#getReferencedObject()}.
   *
   * <ul>
   *   <li>Given {@link PDObjectReference#PDObjectReference()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectReference#getReferencedObject()}
   */
  @Test
  @DisplayName("Test getReferencedObject(); given PDObjectReference(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectable PDObjectReference.getReferencedObject()"})
  void testGetReferencedObject_givenPDObjectReference_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDObjectReference().getReferencedObject());
  }

  /**
   * Test {@link PDObjectReference#setReferencedObject(PDAnnotation)} with {@code annotation}.
   *
   * <p>Method under test: {@link PDObjectReference#setReferencedObject(PDAnnotation)}
   */
  @Test
  @DisplayName("Test setReferencedObject(PDAnnotation) with 'annotation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectReference.setReferencedObject(PDAnnotation)"})
  void testSetReferencedObjectWithAnnotation() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    pdObjectReference.setReferencedObject(annotation);

    // Assert
    COSObjectable referencedObject = pdObjectReference.getReferencedObject();
    assertTrue(referencedObject instanceof PDAnnotationCaret);
    assertEquals(annotation, referencedObject);
  }

  /**
   * Test {@link PDObjectReference#setReferencedObject(PDAnnotation)} with {@code annotation}.
   *
   * <p>Method under test: {@link PDObjectReference#setReferencedObject(PDAnnotation)}
   */
  @Test
  @DisplayName("Test setReferencedObject(PDAnnotation) with 'annotation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectReference.setReferencedObject(PDAnnotation)"})
  void testSetReferencedObjectWithAnnotation2() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();

    // Act
    pdObjectReference.setReferencedObject((PDAnnotation) null);

    // Assert that nothing has changed
    assertNull(pdObjectReference.getReferencedObject());
  }

  /**
   * Test {@link PDObjectReference#setReferencedObject(PDAnnotation)} with {@code annotation}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectReference#setReferencedObject(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test setReferencedObject(PDAnnotation) with 'annotation'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectReference.setReferencedObject(PDAnnotation)"})
  void testSetReferencedObjectWithAnnotation_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();

    COSDictionary field = new COSDictionary();
    field.setKey(new COSObjectKey(1L, 1));
    PDAnnotationCaret annotation = new PDAnnotationCaret(field);

    // Act
    pdObjectReference.setReferencedObject(annotation);

    // Assert
    COSObjectable referencedObject = pdObjectReference.getReferencedObject();
    assertTrue(referencedObject instanceof PDAnnotationUnknown);
    assertEquals(annotation, referencedObject);
  }

  /**
   * Test {@link PDObjectReference#setReferencedObject(PDAnnotation)} with {@code annotation}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectReference#setReferencedObject(PDAnnotation)}
   */
  @Test
  @DisplayName(
      "Test setReferencedObject(PDAnnotation) with 'annotation'; given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectReference.setReferencedObject(PDAnnotation)"})
  void testSetReferencedObjectWithAnnotation_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();

    COSDictionary field = new COSDictionary();
    field.setDirect(true);
    PDAnnotationCaret annotation = new PDAnnotationCaret(field);

    // Act
    pdObjectReference.setReferencedObject(annotation);

    // Assert
    COSObjectable referencedObject = pdObjectReference.getReferencedObject();
    assertTrue(referencedObject instanceof PDAnnotationUnknown);
    assertEquals(annotation, referencedObject);
  }

  /**
   * Test {@link PDObjectReference#setReferencedObject(PDXObject)} with {@code xobject}.
   *
   * <p>Method under test: {@link PDObjectReference#setReferencedObject(PDXObject)}
   */
  @Test
  @DisplayName("Test setReferencedObject(PDXObject) with 'xobject'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectReference.setReferencedObject(PDXObject)"})
  void testSetReferencedObjectWithXobject() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();

    COSStream cosStream = new COSStream();
    cosStream.setKey(new COSObjectKey(1L, 1));

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);

    // Act
    pdObjectReference.setReferencedObject(xobject);

    // Assert
    verify(xobject).getCOSObject();
    COSDictionary cOSObject = pdObjectReference.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDObjectReference#setReferencedObject(PDXObject)} with {@code xobject}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectReference#setReferencedObject(PDXObject)}
   */
  @Test
  @DisplayName("Test setReferencedObject(PDXObject) with 'xobject'; given COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectReference.setReferencedObject(PDXObject)"})
  void testSetReferencedObjectWithXobject_givenCOSStream() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(new COSStream());

    // Act
    pdObjectReference.setReferencedObject(xobject);

    // Assert
    verify(xobject).getCOSObject();
    COSDictionary cOSObject = pdObjectReference.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDObjectReference#setReferencedObject(PDXObject)} with {@code xobject}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectReference#setReferencedObject(PDXObject)}
   */
  @Test
  @DisplayName(
      "Test setReferencedObject(PDXObject) with 'xobject'; given COSStream() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectReference.setReferencedObject(PDXObject)"})
  void testSetReferencedObjectWithXobject_givenCOSStreamDirectIsTrue() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();

    COSStream cosStream = new COSStream();
    cosStream.setDirect(true);

    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);

    // Act
    pdObjectReference.setReferencedObject(xobject);

    // Assert
    verify(xobject).getCOSObject();
    COSDictionary cOSObject = pdObjectReference.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDObjectReference#setReferencedObject(PDXObject)} with {@code xobject}.
   *
   * <ul>
   *   <li>Then {@link PDObjectReference#PDObjectReference()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectReference#setReferencedObject(PDXObject)}
   */
  @Test
  @DisplayName(
      "Test setReferencedObject(PDXObject) with 'xobject'; then PDObjectReference() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectReference.setReferencedObject(PDXObject)"})
  void testSetReferencedObjectWithXobject_thenPDObjectReferenceCOSObjectValuesSizeIsOne() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();

    // Act
    pdObjectReference.setReferencedObject((PDXObject) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdObjectReference.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDObjectReference#getPage()}.
   *
   * <ul>
   *   <li>Given {@link PDObjectReference#PDObjectReference(COSDictionary)} with theDictionary is
   *       {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectReference#getPage()}
   */
  @Test
  @DisplayName(
      "Test getPage(); given PDObjectReference(COSDictionary) with theDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDObjectReference.getPage()"})
  void testGetPage_givenPDObjectReferenceWithTheDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDObjectReference(new COSDictionary()).getPage());
  }

  /**
   * Test {@link PDObjectReference#getPage()}.
   *
   * <ul>
   *   <li>Given {@link PDObjectReference#PDObjectReference()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectReference#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given PDObjectReference(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDObjectReference.getPage()"})
  void testGetPage_givenPDObjectReference_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDObjectReference().getPage());
  }

  /**
   * Test {@link PDObjectReference#setPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectReference#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectReference.setPage(PDPage)"})
  void testSetPage_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(1L, 1));
    PDPage page = new PDPage(pageDictionary);

    // Act
    pdObjectReference.setPage(page);

    // Assert
    COSDictionary cOSObject = pdObjectReference.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(page, pdObjectReference.getPage());
  }

  /**
   * Test {@link PDObjectReference#setPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDObjectReference#PDObjectReference()}.
   *   <li>When {@link PDPage#PDPage()}.
   *   <li>Then {@link PDObjectReference#PDObjectReference()} Page is {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectReference#setPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test setPage(PDPage); given PDObjectReference(); when PDPage(); then PDObjectReference() Page is PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectReference.setPage(PDPage)"})
  void testSetPage_givenPDObjectReference_whenPDPage_thenPDObjectReferencePageIsPDPage() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();
    PDPage page = new PDPage();

    // Act
    pdObjectReference.setPage(page);

    // Assert
    assertEquals(page, pdObjectReference.getPage());
  }

  /**
   * Test {@link PDObjectReference#setPage(PDPage)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectReference#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectReference.setPage(PDPage)"})
  void testSetPage_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();

    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setDirect(true);
    PDPage page = new PDPage(pageDictionary);

    // Act
    pdObjectReference.setPage(page);

    // Assert
    COSDictionary cOSObject = pdObjectReference.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(page, pdObjectReference.getPage());
  }

  /**
   * Test {@link PDObjectReference#setPage(PDPage)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDObjectReference#PDObjectReference()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectReference#setPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test setPage(PDPage); when 'null'; then PDObjectReference() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectReference.setPage(PDPage)"})
  void testSetPage_whenNull_thenPDObjectReferenceCOSObjectValuesSizeIsOne() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();

    // Act
    pdObjectReference.setPage(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdObjectReference.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }
}
