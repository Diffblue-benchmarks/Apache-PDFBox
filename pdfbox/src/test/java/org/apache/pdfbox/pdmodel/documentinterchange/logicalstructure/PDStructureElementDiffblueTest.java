package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDDictionaryWrapper;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDLayoutAttributeObject;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDListAttributeObject;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDPrintFieldAttributeObject;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDTableAttributeObject;
import org.junit.jupiter.api.Test;

class PDStructureElementDiffblueTest {
  /**
   * Method under test: {@link PDStructureElement#getStructureType()}
   */
  @Test
  void testGetStructureType() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getStructureType());
    assertEquals("Structure Type",
        (new PDStructureElement("Structure Type", new PDStructureTreeRoot())).getStructureType());
  }

  /**
   * Method under test: {@link PDStructureElement#getStructureType()}
   */
  @Test
  void testGetStructureType2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    String actualStructureType = pdStructureElement.getStructureType();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualStructureType);
  }

  /**
   * Method under test: {@link PDStructureElement#setStructureType(String)}
   */
  @Test
  void testSetStructureType() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.setStructureType("Structure Type");

    // Assert
    assertEquals("Structure Type", pdStructureElement.getStandardStructureType());
    assertEquals("Structure Type", pdStructureElement.getStructureType());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setStructureType(String)}
   */
  @Test
  void testSetStructureType2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.setStructureType("Structure Type");

    // Assert
    verify(objectable).getCOSObject();
    assertEquals("Structure Type", pdStructureElement.getStandardStructureType());
    assertEquals("Structure Type", pdStructureElement.getStructureType());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setStructureType(String)}
   */
  @Test
  void testSetStructureType3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.setStructureType("org.apache.pdfbox.cos.COSArray");

    // Assert
    verify(objectable).getCOSObject();
    assertEquals("org.apache.pdfbox.cos.COSArray", pdStructureElement.getStandardStructureType());
    assertEquals("org.apache.pdfbox.cos.COSArray", pdStructureElement.getStructureType());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#getParent()}
   */
  @Test
  void testGetParent() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getParent());
  }

  /**
   * Method under test: {@link PDStructureElement#getParent()}
   */
  @Test
  void testGetParent2() {
    // Arrange and Act
    PDStructureNode actualParent = (new PDStructureElement("Structure Type", new PDStructureTreeRoot())).getParent();

    // Assert
    assertTrue(actualParent instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", actualParent.getType());
    assertNull(((PDStructureTreeRoot) actualParent).getK());
    COSDictionary cOSObject = actualParent.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDStructureTreeRoot) actualParent).getIDTree());
    assertNull(((PDStructureTreeRoot) actualParent).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) actualParent).getParentTreeNextKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualParent.getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) actualParent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) actualParent).getRoleMap().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureElement#getParent()}
   */
  @Test
  void testGetParent3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    PDStructureNode actualParent = pdStructureElement.getParent();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualParent);
  }

  /**
   * Method under test: {@link PDStructureElement#setParent(PDStructureNode)}
   */
  @Test
  void testSetParent() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.setParent(new PDStructureTreeRoot());

    // Assert
    PDStructureNode parent = pdStructureElement.getParent();
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertNull(((PDStructureTreeRoot) parent).getK());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertTrue(parent.getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setParent(PDStructureNode)}
   */
  @Test
  void testSetParent2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.setParent(new PDStructureTreeRoot());

    // Assert
    verify(objectable).getCOSObject();
    PDStructureNode parent = pdStructureElement.getParent();
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertNull(((PDStructureTreeRoot) parent).getK());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertTrue(parent.getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setParent(PDStructureNode)}
   */
  @Test
  void testSetParent3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.setParent(null);

    // Assert
    verify(objectable).getCOSObject();
    assertNull(pdStructureElement.getParent());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#getElementIdentifier()}
   */
  @Test
  void testGetElementIdentifier() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getElementIdentifier());
  }

  /**
   * Method under test: {@link PDStructureElement#getElementIdentifier()}
   */
  @Test
  void testGetElementIdentifier2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    String actualElementIdentifier = pdStructureElement.getElementIdentifier();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualElementIdentifier);
  }

  /**
   * Method under test: {@link PDStructureElement#setElementIdentifier(String)}
   */
  @Test
  void testSetElementIdentifier() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.setElementIdentifier("42");

    // Assert
    assertEquals("42", pdStructureElement.getElementIdentifier());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setElementIdentifier(String)}
   */
  @Test
  void testSetElementIdentifier2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.setElementIdentifier("42");

    // Assert
    verify(objectable).getCOSObject();
    assertEquals("42", pdStructureElement.getElementIdentifier());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#getPage()}
   */
  @Test
  void testGetPage() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getPage());
  }

  /**
   * Method under test: {@link PDStructureElement#getPage()}
   */
  @Test
  void testGetPage2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    PDPage actualPage = pdStructureElement.getPage();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualPage);
  }

  /**
   * Method under test: {@link PDStructureElement#setPage(PDPage)}
   */
  @Test
  void testSetPage() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    PDPage page = new PDPage();

    // Act
    pdStructureElement.setPage(page);

    // Assert
    assertEquals(page, pdStructureElement.getPage());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setPage(PDPage)}
   */
  @Test
  void testSetPage2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);
    PDPage page = new PDPage();

    // Act
    pdStructureElement.setPage(page);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(page, pdStructureElement.getPage());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setPage(PDPage)}
   */
  @Test
  void testSetPage3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.setPage(null);

    // Assert
    verify(objectable).getCOSObject();
    assertNull(pdStructureElement.getPage());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  void testGetAttributes() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDStructureElement(new COSDictionary())).getAttributes().size());
  }

  /**
   * Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  void testGetAttributes2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act and Assert
    assertEquals(1, pdStructureElement.getAttributes().size());
  }

  /**
   * Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  void testGetAttributes3() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act and Assert
    assertEquals(2, pdStructureElement.getAttributes().size());
  }

  /**
   * Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  void testGetAttributes4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act
    Revisions<PDAttributeObject> actualAttributes = pdStructureElement.getAttributes();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, actualAttributes.size());
  }

  /**
   * Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  void testGetAttributes5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);
    pdStructureElement.addAttribute(new PDUserAttributeObject());

    // Act
    Revisions<PDAttributeObject> actualAttributes = pdStructureElement.getAttributes();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, actualAttributes.size());
  }

  /**
   * Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  void testGetAttributes6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);
    pdStructureElement.addAttribute(new PDLayoutAttributeObject());

    // Act
    Revisions<PDAttributeObject> actualAttributes = pdStructureElement.getAttributes();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, actualAttributes.size());
  }

  /**
   * Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  void testGetAttributes7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);
    pdStructureElement.addAttribute(new PDListAttributeObject());

    // Act
    Revisions<PDAttributeObject> actualAttributes = pdStructureElement.getAttributes();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, actualAttributes.size());
  }

  /**
   * Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  void testGetAttributes8() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);
    pdStructureElement.addAttribute(new PDPrintFieldAttributeObject());

    // Act
    Revisions<PDAttributeObject> actualAttributes = pdStructureElement.getAttributes();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, actualAttributes.size());
  }

  /**
   * Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  void testGetAttributes9() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);
    pdStructureElement.addAttribute(new PDTableAttributeObject());

    // Act
    Revisions<PDAttributeObject> actualAttributes = pdStructureElement.getAttributes();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, actualAttributes.size());
  }

  /**
   * Method under test: {@link PDStructureElement#setAttributes(Revisions)}
   */
  @Test
  void testSetAttributes() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.setAttributes(new Revisions<>());

    // Assert
    assertEquals(0, pdStructureElement.getAttributes().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setAttributes(Revisions)}
   */
  @Test
  void testSetAttributes2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.setAttributes(new Revisions<>());

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(0, pdStructureElement.getAttributes().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setAttributes(Revisions)}
   */
  @Test
  void testSetAttributes3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    Revisions<PDAttributeObject> attributes = new Revisions<>();
    attributes.addObject(new PDDefaultAttributeObject(), 10);

    // Act
    pdStructureElement.setAttributes(attributes);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureElement.getAttributes().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#addAttribute(PDAttributeObject)}
   */
  @Test
  void testAddAttribute() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Assert
    assertEquals(1, pdStructureElement.getAttributes().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#addAttribute(PDAttributeObject)}
   */
  @Test
  void testAddAttribute2() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Assert
    assertEquals(2, pdStructureElement.getAttributes().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#addAttribute(PDAttributeObject)}
   */
  @Test
  void testAddAttribute3() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.incrementRevisionNumber();
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Assert
    assertEquals(2, pdStructureElement.getAttributes().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#addAttribute(PDAttributeObject)}
   */
  @Test
  void testAddAttribute4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(2, pdStructureElement.getAttributes().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  void testRemoveAttribute() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act
    pdStructureElement.removeAttribute(new PDDefaultAttributeObject());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#attributeChanged(PDAttributeObject)}
   */
  @Test
  void testAttributeChanged() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.attributeChanged(new PDDefaultAttributeObject());

    // Assert
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#attributeChanged(PDAttributeObject)}
   */
  @Test
  void testAttributeChanged2() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act
    pdStructureElement.attributeChanged(new PDDefaultAttributeObject());

    // Assert that nothing has changed
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#attributeChanged(PDAttributeObject)}
   */
  @Test
  void testAttributeChanged3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act
    pdStructureElement.attributeChanged(new PDDefaultAttributeObject());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#getClassNames()}
   */
  @Test
  void testGetClassNames() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDStructureElement(new COSDictionary())).getClassNames().size());
  }

  /**
   * Method under test: {@link PDStructureElement#getClassNames()}
   */
  @Test
  void testGetClassNames2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addClassName("Class Name");

    // Act and Assert
    assertEquals(1, pdStructureElement.getClassNames().size());
  }

  /**
   * Method under test: {@link PDStructureElement#getClassNames()}
   */
  @Test
  void testGetClassNames3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    Revisions<String> actualClassNames = pdStructureElement.getClassNames();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(0, actualClassNames.size());
  }

  /**
   * Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  void testSetClassNames() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.setClassNames(new Revisions<>());

    // Assert
    assertEquals(0, pdStructureElement.getClassNames().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  void testSetClassNames2() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.setClassNames(null);

    // Assert that nothing has changed
    assertEquals(0, pdStructureElement.getClassNames().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  void testSetClassNames3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.setClassNames(new Revisions<>());

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(0, pdStructureElement.getClassNames().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  void testSetClassNames4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    Revisions<String> classNames = new Revisions<>();
    classNames.addObject("Object", 10);

    // Act
    pdStructureElement.setClassNames(classNames);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureElement.getClassNames().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  void testSetClassNames5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    Revisions<String> classNames = new Revisions<>();
    classNames.addObject("{", 2);
    classNames.addObject("Object", 10);

    // Act
    pdStructureElement.setClassNames(classNames);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(2, pdStructureElement.getClassNames().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  void testSetClassNames6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    Revisions<String> classNames = new Revisions<>();
    classNames.addObject("{", 2);
    classNames.addObject("Object", -100);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdStructureElement.setClassNames(classNames));
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#addClassName(String)}
   */
  @Test
  void testAddClassName() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.addClassName("Class Name");

    // Assert
    assertEquals(1, pdStructureElement.getClassNames().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#addClassName(String)}
   */
  @Test
  void testAddClassName2() {
    // Arrange
    COSDictionary dic = new COSDictionary(new COSDictionary());
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.addClassName("Class Name");

    // Assert
    assertEquals(1, pdStructureElement.getClassNames().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#addClassName(String)}
   */
  @Test
  void testAddClassName3() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.addClassName("Class Name");

    // Act
    pdStructureElement.addClassName("Class Name");

    // Assert
    assertEquals(2, pdStructureElement.getClassNames().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#addClassName(String)}
   */
  @Test
  void testAddClassName4() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.incrementRevisionNumber();

    // Act
    pdStructureElement.addClassName("Class Name");

    // Assert
    assertEquals(1, pdStructureElement.getClassNames().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#addClassName(String)}
   */
  @Test
  void testAddClassName5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.addClassName("Class Name");

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureElement.getClassNames().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#addClassName(String)}
   */
  @Test
  void testAddClassName6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.addClassName(null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertEquals(0, pdStructureElement.getClassNames().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  void testRemoveClassName() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.removeClassName("Class Name");

    // Assert that nothing has changed
    assertEquals(0, pdStructureElement.getClassNames().size());
  }

  /**
   * Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  void testRemoveClassName2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addClassName("Class Name");

    // Act
    pdStructureElement.removeClassName("Class Name");

    // Assert
    assertEquals(0, pdStructureElement.getClassNames().size());
  }

  /**
   * Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  void testRemoveClassName3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeClassName("Class Name");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertEquals(0, pdStructureElement.getClassNames().size());
  }

  /**
   * Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  void testRemoveClassName4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addClassName(PDStructureElement.TYPE);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeClassName("Class Name");

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureElement.getClassNames().size());
  }

  /**
   * Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  void testRemoveClassName5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(null);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeClassName("Class Name");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertEquals(0, pdStructureElement.getClassNames().size());
  }

  /**
   * Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  void testRemoveClassName6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeClassName(null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertEquals(0, pdStructureElement.getClassNames().size());
  }

  /**
   * Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  void testRemoveClassName7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.incrementRevisionNumber();
    pdStructureElement.addClassName(PDStructureElement.TYPE);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeClassName("Class Name");

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureElement.getClassNames().size());
  }

  /**
   * Method under test: {@link PDStructureElement#getRevisionNumber()}
   */
  @Test
  void testGetRevisionNumber() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDStructureElement(new COSDictionary())).getRevisionNumber());
  }

  /**
   * Method under test: {@link PDStructureElement#getRevisionNumber()}
   */
  @Test
  void testGetRevisionNumber2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.incrementRevisionNumber();

    // Act and Assert
    assertEquals(1, pdStructureElement.getRevisionNumber());
  }

  /**
   * Method under test: {@link PDStructureElement#getRevisionNumber()}
   */
  @Test
  void testGetRevisionNumber3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    int actualRevisionNumber = pdStructureElement.getRevisionNumber();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(0, actualRevisionNumber);
  }

  /**
   * Method under test: {@link PDStructureElement#setRevisionNumber(int)}
   */
  @Test
  void testSetRevisionNumber() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.setRevisionNumber(10);

    // Assert
    assertEquals(10, pdStructureElement.getRevisionNumber());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setRevisionNumber(int)}
   */
  @Test
  void testSetRevisionNumber2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.setRevisionNumber(10);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(10, pdStructureElement.getRevisionNumber());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setRevisionNumber(int)}
   */
  @Test
  void testSetRevisionNumber3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdStructureElement.setRevisionNumber(-100));
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#incrementRevisionNumber()}
   */
  @Test
  void testIncrementRevisionNumber() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.incrementRevisionNumber();

    // Assert
    assertEquals(1, pdStructureElement.getRevisionNumber());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#incrementRevisionNumber()}
   */
  @Test
  void testIncrementRevisionNumber2() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.incrementRevisionNumber();

    // Act
    pdStructureElement.incrementRevisionNumber();

    // Assert
    assertEquals(2, pdStructureElement.getRevisionNumber());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#incrementRevisionNumber()}
   */
  @Test
  void testIncrementRevisionNumber3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.incrementRevisionNumber();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureElement.getRevisionNumber());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#getTitle()}
   */
  @Test
  void testGetTitle() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getTitle());
  }

  /**
   * Method under test: {@link PDStructureElement#getTitle()}
   */
  @Test
  void testGetTitle2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    String actualTitle = pdStructureElement.getTitle();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualTitle);
  }

  /**
   * Method under test: {@link PDStructureElement#setTitle(String)}
   */
  @Test
  void testSetTitle() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.setTitle("Dr");

    // Assert
    assertEquals("Dr", pdStructureElement.getTitle());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setTitle(String)}
   */
  @Test
  void testSetTitle2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.setTitle("Dr");

    // Assert
    verify(objectable).getCOSObject();
    assertEquals("Dr", pdStructureElement.getTitle());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#getLanguage()}
   */
  @Test
  void testGetLanguage() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getLanguage());
  }

  /**
   * Method under test: {@link PDStructureElement#getLanguage()}
   */
  @Test
  void testGetLanguage2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    String actualLanguage = pdStructureElement.getLanguage();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualLanguage);
  }

  /**
   * Method under test: {@link PDStructureElement#setLanguage(String)}
   */
  @Test
  void testSetLanguage() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.setLanguage("en");

    // Assert
    assertEquals("en", pdStructureElement.getLanguage());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setLanguage(String)}
   */
  @Test
  void testSetLanguage2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.setLanguage("en");

    // Assert
    verify(objectable).getCOSObject();
    assertEquals("en", pdStructureElement.getLanguage());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#getAlternateDescription()}
   */
  @Test
  void testGetAlternateDescription() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getAlternateDescription());
  }

  /**
   * Method under test: {@link PDStructureElement#getAlternateDescription()}
   */
  @Test
  void testGetAlternateDescription2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    String actualAlternateDescription = pdStructureElement.getAlternateDescription();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualAlternateDescription);
  }

  /**
   * Method under test: {@link PDStructureElement#setAlternateDescription(String)}
   */
  @Test
  void testSetAlternateDescription() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.setAlternateDescription("Alternate Description");

    // Assert
    assertEquals("Alternate Description", pdStructureElement.getAlternateDescription());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setAlternateDescription(String)}
   */
  @Test
  void testSetAlternateDescription2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.setAlternateDescription("Alternate Description");

    // Assert
    verify(objectable).getCOSObject();
    assertEquals("Alternate Description", pdStructureElement.getAlternateDescription());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#getExpandedForm()}
   */
  @Test
  void testGetExpandedForm() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getExpandedForm());
  }

  /**
   * Method under test: {@link PDStructureElement#getExpandedForm()}
   */
  @Test
  void testGetExpandedForm2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    String actualExpandedForm = pdStructureElement.getExpandedForm();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualExpandedForm);
  }

  /**
   * Method under test: {@link PDStructureElement#setExpandedForm(String)}
   */
  @Test
  void testSetExpandedForm() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.setExpandedForm("Expanded Form");

    // Assert
    assertEquals("Expanded Form", pdStructureElement.getExpandedForm());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setExpandedForm(String)}
   */
  @Test
  void testSetExpandedForm2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.setExpandedForm("Expanded Form");

    // Assert
    verify(objectable).getCOSObject();
    assertEquals("Expanded Form", pdStructureElement.getExpandedForm());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#getActualText()}
   */
  @Test
  void testGetActualText() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getActualText());
  }

  /**
   * Method under test: {@link PDStructureElement#getActualText()}
   */
  @Test
  void testGetActualText2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    String actualActualText = pdStructureElement.getActualText();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualActualText);
  }

  /**
   * Method under test: {@link PDStructureElement#setActualText(String)}
   */
  @Test
  void testSetActualText() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.setActualText("Actual Text");

    // Assert
    assertEquals("Actual Text", pdStructureElement.getActualText());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#setActualText(String)}
   */
  @Test
  void testSetActualText2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.setActualText("Actual Text");

    // Assert
    verify(objectable).getCOSObject();
    assertEquals("Actual Text", pdStructureElement.getActualText());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#getStandardStructureType()}
   */
  @Test
  void testGetStandardStructureType() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getStandardStructureType());
    assertEquals("Structure Type",
        (new PDStructureElement("Structure Type", new PDStructureTreeRoot())).getStandardStructureType());
  }

  /**
   * Method under test: {@link PDStructureElement#getStandardStructureType()}
   */
  @Test
  void testGetStandardStructureType2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    String actualStandardStructureType = pdStructureElement.getStandardStructureType();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualStandardStructureType);
  }

  /**
   * Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  void testAppendKid() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.appendKid(1);

    // Assert
    assertEquals(1, pdStructureElement.getKids().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  void testAppendKid2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDStructureElement(new COSDictionary())).appendKid(-1));
  }

  /**
   * Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  void testAppendKid3() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.appendKid(1);

    // Assert
    assertEquals(2, pdStructureElement.getKids().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  void testAppendKid4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.appendKid(1);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureElement.getKids().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  void testAppendKid5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.appendKid(1);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(2, pdStructureElement.getKids().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  void testAppendKid6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.appendKid(1);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureElement.getKids().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  void testAppendKid7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.appendKid(4);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureElement.getKids().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#appendKid(PDMarkedContentReference)}
   */
  @Test
  void testAppendKid8() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Assert
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDMarkedContentReference);
    assertNull(((PDMarkedContentReference) getResult).getPage());
    assertEquals(-1, ((PDMarkedContentReference) getResult).getMCID());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#appendKid(PDMarkedContentReference)}
   */
  @Test
  void testAppendKid9() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Assert
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(1);
    assertTrue(getResult instanceof PDMarkedContentReference);
    assertNull(((PDMarkedContentReference) getResult).getPage());
    assertEquals(-1, ((PDMarkedContentReference) getResult).getMCID());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#appendKid(PDMarkedContentReference)}
   */
  @Test
  void testAppendKid10() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDMarkedContentReference);
    assertNull(((PDMarkedContentReference) getResult).getPage());
    assertEquals(-1, ((PDMarkedContentReference) getResult).getMCID());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#appendKid(PDMarkedContentReference)}
   */
  @Test
  void testAppendKid11() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(1);
    assertTrue(getResult instanceof PDMarkedContentReference);
    assertNull(((PDMarkedContentReference) getResult).getPage());
    assertEquals(-1, ((PDMarkedContentReference) getResult).getMCID());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#appendKid(PDMarkedContentReference)}
   */
  @Test
  void testAppendKid12() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(2L, 2)));
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDMarkedContentReference);
    assertNull(((PDMarkedContentReference) getResult).getPage());
    assertEquals(-1, ((PDMarkedContentReference) getResult).getMCID());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#appendKid(PDMarkedContentReference)}
   */
  @Test
  void testAppendKid13() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.appendKid((PDMarkedContentReference) null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#appendKid(PDObjectReference)}
   */
  @Test
  void testAppendKid14() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.appendKid(new PDObjectReference());

    // Assert
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDObjectReference);
    assertNull(((PDObjectReference) getResult).getPage());
    assertNull(((PDObjectReference) getResult).getReferencedObject());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#appendKid(PDObjectReference)}
   */
  @Test
  void testAppendKid15() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.appendKid(new PDObjectReference());

    // Assert
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(1);
    assertTrue(getResult instanceof PDObjectReference);
    assertNull(((PDObjectReference) getResult).getPage());
    assertNull(((PDObjectReference) getResult).getReferencedObject());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#appendKid(PDObjectReference)}
   */
  @Test
  void testAppendKid16() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.appendKid(new PDObjectReference());

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDObjectReference);
    assertNull(((PDObjectReference) getResult).getPage());
    assertNull(((PDObjectReference) getResult).getReferencedObject());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#appendKid(PDObjectReference)}
   */
  @Test
  void testAppendKid17() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.appendKid(new PDObjectReference());

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(1);
    assertTrue(getResult instanceof PDObjectReference);
    assertNull(((PDObjectReference) getResult).getPage());
    assertNull(((PDObjectReference) getResult).getReferencedObject());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#appendKid(PDObjectReference)}
   */
  @Test
  void testAppendKid18() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(2L, 2)));
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.appendKid(new PDObjectReference());

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDObjectReference);
    assertNull(((PDObjectReference) getResult).getPage());
    assertNull(((PDObjectReference) getResult).getReferencedObject());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#appendKid(PDObjectReference)}
   */
  @Test
  void testAppendKid19() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.appendKid((PDObjectReference) null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#appendKid(PDMarkedContent)}
   */
  @Test
  void testAppendKid20() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdStructureElement.appendKid(new PDMarkedContent(COSName.A, new COSDictionary())));
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    assertEquals(1, pdStructureElement.getKids().size());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore3() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    assertEquals(1, pdStructureElement.getKids().size());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSFloat.ONE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore8() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore((COSInteger) null, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore9() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureElement.getKids().size());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore10() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore11() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, new PDDictionaryWrapper());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore12() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, new PDImmutableRectangle(10.0f, 10.0f));

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore13() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSString.parseHex("0123456789ABCDEF"));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore14() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(2, pdStructureElement.getKids().size());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore15() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, COSInteger.TWO);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(2, pdStructureElement.getKids().size());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore16() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSFloat.ONE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, COSFloat.ONE);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureElement.getKids().size());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore17() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSFloat.ONE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, COSFloat.ZERO);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  void testInsertBefore18() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore19() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore20() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), "Ref Kid");

    // Assert that nothing has changed
    assertEquals(1, pdStructureElement.getKids().size());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore21() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), "Ref Kid");

    // Assert that nothing has changed
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDMarkedContentReference);
    assertEquals(-1, ((PDMarkedContentReference) getResult).getMCID());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore22() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore23() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSFloat.ONE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore24() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore25() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore26() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore((PDMarkedContentReference) null, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore27() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDMarkedContentReference);
    assertNull(((PDMarkedContentReference) getResult).getPage());
    assertEquals(-1, ((PDMarkedContentReference) getResult).getMCID());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore28() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore29() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);
    PDMarkedContentReference markedContentReference = new PDMarkedContentReference();

    // Act
    pdStructureElement.insertBefore(markedContentReference, new PDDictionaryWrapper());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore30() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);
    PDMarkedContentReference markedContentReference = new PDMarkedContentReference();

    // Act
    pdStructureElement.insertBefore(markedContentReference, new PDImmutableRectangle(10.0f, 10.0f));

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore31() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSString.parseHex("0123456789ABCDEF"));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore32() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(1);
    assertTrue(getResult instanceof PDMarkedContentReference);
    assertNull(((PDMarkedContentReference) getResult).getPage());
    assertEquals(-1, ((PDMarkedContentReference) getResult).getMCID());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore33() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), COSInteger.TWO);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDMarkedContentReference);
    assertNull(((PDMarkedContentReference) getResult).getPage());
    assertEquals(-1, ((PDMarkedContentReference) getResult).getMCID());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore34() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSFloat.ONE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), COSFloat.ONE);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDMarkedContentReference);
    assertNull(((PDMarkedContentReference) getResult).getPage());
    assertEquals(-1, ((PDMarkedContentReference) getResult).getMCID());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore35() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSFloat.ONE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), COSFloat.ZERO);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  void testInsertBefore36() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore37() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore38() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), "Ref Kid");

    // Assert that nothing has changed
    assertEquals(1, pdStructureElement.getKids().size());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore39() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), "Ref Kid");

    // Assert that nothing has changed
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    assertTrue(kids.get(0) instanceof PDMarkedContentReference);
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore40() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore41() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSFloat.ONE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore42() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore43() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore44() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore((PDObjectReference) null, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore45() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDObjectReference);
    assertNull(((PDObjectReference) getResult).getPage());
    assertNull(((PDObjectReference) getResult).getReferencedObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore46() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore47() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);
    PDObjectReference objectReference = new PDObjectReference();

    // Act
    pdStructureElement.insertBefore(objectReference, new PDDictionaryWrapper());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore48() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);
    PDObjectReference objectReference = new PDObjectReference();

    // Act
    pdStructureElement.insertBefore(objectReference, new PDImmutableRectangle(10.0f, 10.0f));

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore49() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSString.parseHex("0123456789ABCDEF"));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore50() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(1);
    assertTrue(getResult instanceof PDObjectReference);
    assertNull(((PDObjectReference) getResult).getPage());
    assertNull(((PDObjectReference) getResult).getReferencedObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore51() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), COSInteger.TWO);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDObjectReference);
    assertNull(((PDObjectReference) getResult).getPage());
    assertNull(((PDObjectReference) getResult).getReferencedObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore52() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSFloat.ONE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), COSFloat.ONE);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDObjectReference);
    assertNull(((PDObjectReference) getResult).getPage());
    assertNull(((PDObjectReference) getResult).getReferencedObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore53() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSFloat.ONE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), COSFloat.ZERO);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  void testInsertBefore54() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  void testRemoveKid() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    assertTrue(pdStructureElement.getKids().isEmpty());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  void testRemoveKid2() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    assertTrue(pdStructureElement.getKids().isEmpty());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  void testRemoveKid3() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    assertEquals(1, pdStructureElement.getKids().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  void testRemoveKid4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  void testRemoveKid5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureElement.getKids().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  void testRemoveKid6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSFloat.ONE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  void testRemoveKid7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  void testRemoveKid8() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSArray());
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  void testRemoveKid9() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  void testRemoveKid10() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid((COSInteger) null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  void testRemoveKid11() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSString.parseHex("0123456789ABCDEF"));
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  void testRemoveKid12() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendKid(1);
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureElement.getKids().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  void testRemoveKid13() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureElement.getKids().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  void testRemoveKid14() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, pdStructureElement.getKids().size());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  void testRemoveKid15() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));
    COSDictionary dic = new COSDictionary();

    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
    assertSame(dic, pdStructureElement.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid16() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid17() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid18() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSFloat.ONE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid19() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid20() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid21() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid((PDMarkedContentReference) null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid22() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSString.parseHex("0123456789ABCDEF"));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid23() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid24() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid25() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid26() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSInteger.ONE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid27() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSName.A, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid28() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSArray object = new COSArray();
    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid29() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid30() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSInteger.ONE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid31() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSName.A, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  void testRemoveKid32() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSArray object = new COSArray();
    COSObject object2 = new COSObject(object, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object2, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid33() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid34() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid35() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSFloat.ONE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid36() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid37() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid38() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid((PDObjectReference) null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid39() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSString.parseHex("0123456789ABCDEF"));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid40() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid41() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid42() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid43() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSInteger.ONE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid44() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSName.A, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid45() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSArray object = new COSArray();
    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid46() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid47() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSInteger.ONE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid48() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSName.A, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  void testRemoveKid49() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSArray object = new COSArray();
    COSObject object2 = new COSObject(object, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object2, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
  }

  /**
   * Method under test:
   * {@link PDStructureElement#PDStructureElement(COSDictionary)}
   */
  @Test
  void testNewPDStructureElement() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, (new PDStructureElement(dic)).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}
   */
  @Test
  void testNewPDStructureElement2() {
    // Arrange and Act
    PDStructureElement actualPdStructureElement = new PDStructureElement("Structure Type", new PDStructureTreeRoot());

    // Assert
    PDStructureNode parent = actualPdStructureElement.getParent();
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("Structure Type", actualPdStructureElement.getStandardStructureType());
    assertEquals("Structure Type", actualPdStructureElement.getStructureType());
    assertNull(actualPdStructureElement.getActualText());
    assertNull(actualPdStructureElement.getAlternateDescription());
    assertNull(actualPdStructureElement.getElementIdentifier());
    assertNull(actualPdStructureElement.getExpandedForm());
    assertNull(actualPdStructureElement.getLanguage());
    assertNull(actualPdStructureElement.getTitle());
    assertNull(((PDStructureTreeRoot) parent).getK());
    COSDictionary cOSObject = actualPdStructureElement.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = parent.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(actualPdStructureElement.getPage());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    assertEquals(0, actualPdStructureElement.getRevisionNumber());
    assertEquals(0, actualPdStructureElement.getAttributes().size());
    assertEquals(0, actualPdStructureElement.getClassNames().size());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
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
    assertTrue(actualPdStructureElement.getKids().isEmpty());
    assertTrue(parent.getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertEquals(PDStructureElement.TYPE, actualPdStructureElement.getType());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}
   */
  @Test
  void testNewPDStructureElement3() {
    // Arrange and Act
    PDStructureElement actualPdStructureElement = new PDStructureElement(null, null);

    // Assert
    assertNull(actualPdStructureElement.getActualText());
    assertNull(actualPdStructureElement.getAlternateDescription());
    assertNull(actualPdStructureElement.getElementIdentifier());
    assertNull(actualPdStructureElement.getExpandedForm());
    assertNull(actualPdStructureElement.getLanguage());
    assertNull(actualPdStructureElement.getStandardStructureType());
    assertNull(actualPdStructureElement.getStructureType());
    assertNull(actualPdStructureElement.getTitle());
    COSDictionary cOSObject = actualPdStructureElement.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStructureElement.getPage());
    assertNull(actualPdStructureElement.getParent());
    assertEquals(0, actualPdStructureElement.getRevisionNumber());
    assertEquals(0, actualPdStructureElement.getAttributes().size());
    assertEquals(0, actualPdStructureElement.getClassNames().size());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualPdStructureElement.getKids().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDStructureElement.TYPE, actualPdStructureElement.getType());
  }

  /**
   * Method under test:
   * {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}
   */
  @Test
  void testNewPDStructureElement4() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setDirect(true);

    // Act
    PDStructureElement actualPdStructureElement = new PDStructureElement(null, new PDStructureTreeRoot(dic));

    // Assert
    PDStructureNode parent = actualPdStructureElement.getParent();
    assertTrue(parent instanceof PDStructureElement);
    assertNull(actualPdStructureElement.getActualText());
    assertNull(((PDStructureElement) parent).getActualText());
    assertNull(actualPdStructureElement.getAlternateDescription());
    assertNull(((PDStructureElement) parent).getAlternateDescription());
    assertNull(actualPdStructureElement.getElementIdentifier());
    assertNull(((PDStructureElement) parent).getElementIdentifier());
    assertNull(actualPdStructureElement.getExpandedForm());
    assertNull(((PDStructureElement) parent).getExpandedForm());
    assertNull(actualPdStructureElement.getLanguage());
    assertNull(((PDStructureElement) parent).getLanguage());
    assertNull(actualPdStructureElement.getStandardStructureType());
    assertNull(((PDStructureElement) parent).getStandardStructureType());
    assertNull(actualPdStructureElement.getStructureType());
    assertNull(((PDStructureElement) parent).getStructureType());
    assertNull(actualPdStructureElement.getTitle());
    assertNull(((PDStructureElement) parent).getTitle());
    assertNull(parent.getType());
    COSDictionary cOSObject = actualPdStructureElement.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdStructureElement.getPage());
    assertNull(((PDStructureElement) parent).getPage());
    assertNull(((PDStructureElement) parent).getParent());
    assertEquals(0, actualPdStructureElement.getRevisionNumber());
    assertEquals(0, ((PDStructureElement) parent).getRevisionNumber());
    assertEquals(0, actualPdStructureElement.getAttributes().size());
    assertEquals(0, ((PDStructureElement) parent).getAttributes().size());
    assertEquals(0, actualPdStructureElement.getClassNames().size());
    assertEquals(0, ((PDStructureElement) parent).getClassNames().size());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualPdStructureElement.getKids().isEmpty());
    assertTrue(parent.getKids().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDStructureElement.TYPE, actualPdStructureElement.getType());
    assertSame(dic, parent.getCOSObject());
  }
}
