package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.junit.jupiter.api.Test;

class PDObjectReferenceDiffblueTest {
  /**
   * Method under test: {@link PDObjectReference#getCOSObject()}
   */
  @Test
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
   * Method under test: {@link PDObjectReference#setReferencedObject(PDXObject)}
   */
  @Test
  void testSetReferencedObject() {
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
   * Method under test: {@link PDObjectReference#setReferencedObject(PDXObject)}
   */
  @Test
  void testSetReferencedObject2() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(null);

    // Act
    pdObjectReference.setReferencedObject(xobject);

    // Assert
    verify(xobject).getCOSObject();
    COSDictionary cOSObject = pdObjectReference.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDObjectReference#setReferencedObject(PDXObject)}
   */
  @Test
  void testSetReferencedObject3() {
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
   * Method under test: {@link PDObjectReference#setReferencedObject(PDXObject)}
   */
  @Test
  void testSetReferencedObject4() {
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
   * Method under test:
   * {@link PDObjectReference#setReferencedObject(PDAnnotation)}
   */
  @Test
  void testSetReferencedObject5() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    pdObjectReference.setReferencedObject(annotation);

    // Assert
    COSObjectable referencedObject = pdObjectReference.getReferencedObject();
    assertTrue(referencedObject instanceof PDAnnotationCaret);
    COSDictionary cOSObject = pdObjectReference.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(annotation, referencedObject);
  }

  /**
   * Method under test: {@link PDObjectReference#getPage()}
   */
  @Test
  void testGetPage() {
    // Arrange, Act and Assert
    assertNull((new PDObjectReference()).getPage());
  }

  /**
   * Method under test: {@link PDObjectReference#setPage(PDPage)}
   */
  @Test
  void testSetPage() {
    // Arrange
    PDObjectReference pdObjectReference = new PDObjectReference();

    // Act
    pdObjectReference.setPage(null);

    // Assert
    assertNull(pdObjectReference.getPage());
    COSDictionary cOSObject = pdObjectReference.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDObjectReference#PDObjectReference(COSDictionary)}
   */
  @Test
  void testNewPDObjectReference() {
    // Arrange
    COSDictionary theDictionary = new COSDictionary();

    // Act and Assert
    assertSame(theDictionary, (new PDObjectReference(theDictionary)).getCOSObject());
  }

  /**
   * Method under test: {@link PDObjectReference#PDObjectReference()}
   */
  @Test
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
}
