package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDObjectReferenceDiffblueTest {
  /**
   * Test {@link PDObjectReference#PDObjectReference(COSDictionary)}.
   * <p>
   * Method under test: {@link PDObjectReference#PDObjectReference(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDObjectReference(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDObjectReference.<init>(COSDictionary)"})
  void testNewPDObjectReference() {
    // Arrange
    COSDictionary theDictionary = new COSDictionary();

    // Act and Assert
    assertSame(theDictionary, (new PDObjectReference(theDictionary)).getCOSObject());
  }

  /**
   * Test {@link PDObjectReference#PDObjectReference()}.
   * <p>
   * Method under test: {@link PDObjectReference#PDObjectReference()}
   */
  @Test
  @DisplayName("Test new PDObjectReference()")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDObjectReference#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDObjectReference.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDObjectReference()).getCOSObject();

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
   * Test {@link PDObjectReference#setReferencedObject(PDAnnotation)} with {@code annotation}.
   * <p>
   * Method under test: {@link PDObjectReference#setReferencedObject(PDAnnotation)}
   */
  @Test
  @DisplayName("Test setReferencedObject(PDAnnotation) with 'annotation'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDObjectReference#setReferencedObject(PDAnnotation)}
   */
  @Test
  @DisplayName("Test setReferencedObject(PDAnnotation) with 'annotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDObjectReference.setReferencedObject(PDAnnotation)"})
  void testSetReferencedObjectWithAnnotation2() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference(new COSDictionary());

    // Act
    pdObjectReference.setReferencedObject((PDAnnotation) null);

    // Assert that nothing has changed
    assertNull(pdObjectReference.getReferencedObject());
  }

  /**
   * Test {@link PDObjectReference#setReferencedObject(PDXObject)} with {@code xobject}.
   * <p>
   * Method under test: {@link PDObjectReference#setReferencedObject(PDXObject)}
   */
  @Test
  @DisplayName("Test setReferencedObject(PDXObject) with 'xobject'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDObjectReference#setReferencedObject(PDXObject)}
   */
  @Test
  @DisplayName("Test setReferencedObject(PDXObject) with 'xobject'; given COSStream()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDObjectReference#setReferencedObject(PDXObject)}
   */
  @Test
  @DisplayName("Test setReferencedObject(PDXObject) with 'xobject'; given COSStream() Direct is 'true'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then {@link PDObjectReference#PDObjectReference()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDObjectReference#setReferencedObject(PDXObject)}
   */
  @Test
  @DisplayName("Test setReferencedObject(PDXObject) with 'xobject'; then PDObjectReference() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDObjectReference.setReferencedObject(PDXObject)"})
  void testSetReferencedObjectWithXobject_thenPDObjectReferenceCOSObjectValuesSizeIsOne() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(null);

    // Act
    pdObjectReference.setReferencedObject(xobject);

    // Assert that nothing has changed
    verify(xobject).getCOSObject();
    COSDictionary cOSObject = pdObjectReference.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDObjectReference#getPage()}.
   * <ul>
   *   <li>Given {@link PDObjectReference#PDObjectReference()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDObjectReference#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given PDObjectReference(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPage PDObjectReference.getPage()"})
  void testGetPage_givenPDObjectReference_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDObjectReference()).getPage());
  }

  /**
   * Test {@link PDObjectReference#setPage(PDPage)}.
   * <ul>
   *   <li>Given {@link PDObjectReference#PDObjectReference()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDObjectReference#PDObjectReference()} Page is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDObjectReference#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); given PDObjectReference(); when 'null'; then PDObjectReference() Page is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDObjectReference.setPage(PDPage)"})
  void testSetPage_givenPDObjectReference_whenNull_thenPDObjectReferencePageIsNull() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();

    // Act
    pdObjectReference.setPage(null);

    // Assert that nothing has changed
    assertNull(pdObjectReference.getPage());
  }

  /**
   * Test {@link PDObjectReference#setPage(PDPage)}.
   * <ul>
   *   <li>Given {@link PDObjectReference#PDObjectReference()}.</li>
   *   <li>When {@link PDPage#PDPage()}.</li>
   *   <li>Then {@link PDObjectReference#PDObjectReference()} Page is {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDObjectReference#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); given PDObjectReference(); when PDPage(); then PDObjectReference() Page is PDPage()")
  @Tag("MaintainedByDiffblue")
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
}
