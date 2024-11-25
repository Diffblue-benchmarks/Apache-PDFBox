package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
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
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDDictionaryWrapper;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDStructureElementDiffblueTest {
  /**
   * Test {@link PDStructureElement#PDStructureElement(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#PDStructureElement(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDStructureElement(COSDictionary)")
  void testNewPDStructureElement() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, (new PDStructureElement(dic)).getCOSObject());
  }

  /**
   * Test {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then Parent return {@link PDStructureElement}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}
   */
  @Test
  @DisplayName("Test new PDStructureElement(String, PDStructureNode); given 'true'; then Parent return PDStructureElement")
  void testNewPDStructureElement_givenTrue_thenParentReturnPDStructureElement() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setDirect(true);

    // Act
    PDStructureElement actualPdStructureElement = new PDStructureElement(null, new PDStructureTreeRoot(dic));

    // Assert
    PDStructureNode parent = actualPdStructureElement.getParent();
    assertTrue(parent instanceof PDStructureElement);
    assertNull(((PDStructureElement) parent).getActualText());
    assertNull(((PDStructureElement) parent).getAlternateDescription());
    assertNull(((PDStructureElement) parent).getElementIdentifier());
    assertNull(((PDStructureElement) parent).getExpandedForm());
    assertNull(((PDStructureElement) parent).getLanguage());
    assertNull(((PDStructureElement) parent).getStandardStructureType());
    assertNull(((PDStructureElement) parent).getStructureType());
    assertNull(((PDStructureElement) parent).getTitle());
    assertNull(parent.getType());
    assertNull(((PDStructureElement) parent).getPage());
    assertNull(((PDStructureElement) parent).getParent());
    assertEquals(0, ((PDStructureElement) parent).getRevisionNumber());
    assertEquals(0, ((PDStructureElement) parent).getAttributes().size());
    assertEquals(0, ((PDStructureElement) parent).getClassNames().size());
    COSDictionary cOSObject = actualPdStructureElement.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(dic, parent.getCOSObject());
  }

  /**
   * Test {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return StandardStructureType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}
   */
  @Test
  @DisplayName("Test new PDStructureElement(String, PDStructureNode); when 'null'; then return StandardStructureType is 'null'")
  void testNewPDStructureElement_whenNull_thenReturnStandardStructureTypeIsNull() {
    // Arrange and Act
    PDStructureElement actualPdStructureElement = new PDStructureElement(null, null);

    // Assert
    assertNull(actualPdStructureElement.getStandardStructureType());
    assertNull(actualPdStructureElement.getStructureType());
    assertNull(actualPdStructureElement.getParent());
    COSDictionary cOSObject = actualPdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}.
   * <ul>
   *   <li>When {@code Structure Type}.</li>
   *   <li>Then Parent return {@link PDStructureTreeRoot}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}
   */
  @Test
  @DisplayName("Test new PDStructureElement(String, PDStructureNode); when 'Structure Type'; then Parent return PDStructureTreeRoot")
  void testNewPDStructureElement_whenStructureType_thenParentReturnPDStructureTreeRoot() {
    // Arrange and Act
    PDStructureElement actualPdStructureElement = new PDStructureElement("Structure Type", new PDStructureTreeRoot());

    // Assert
    PDStructureNode parent = actualPdStructureElement.getParent();
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", parent.getType());
    assertEquals("Structure Type", actualPdStructureElement.getStandardStructureType());
    assertEquals("Structure Type", actualPdStructureElement.getStructureType());
    assertNull(((PDStructureTreeRoot) parent).getK());
    assertNull(((PDStructureTreeRoot) parent).getIDTree());
    assertNull(((PDStructureTreeRoot) parent).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) parent).getParentTreeNextKey());
    COSDictionary cOSObject = parent.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSDictionary cOSObject2 = actualPdStructureElement.getCOSObject();
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    assertFalse(cOSObject.isDirect());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#getStructureType()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getStructureType()}
   */
  @Test
  @DisplayName("Test getStructureType(); given PDStructureElement(COSDictionary) with dic is COSDictionary()")
  void testGetStructureType_givenPDStructureElementWithDicIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getStructureType());
  }

  /**
   * Test {@link PDStructureElement#getStructureType()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getStructureType()}
   */
  @Test
  @DisplayName("Test getStructureType(); given PDStructureElement(COSDictionary) with dic is COSStream(); then return 'null'")
  void testGetStructureType_givenPDStructureElementWithDicIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSStream())).getStructureType());
  }

  /**
   * Test {@link PDStructureElement#getStructureType()}.
   * <ul>
   *   <li>Then return {@code Structure Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getStructureType()}
   */
  @Test
  @DisplayName("Test getStructureType(); then return 'Structure Type'")
  void testGetStructureType_thenReturnStructureType() {
    // Arrange, Act and Assert
    assertEquals("Structure Type",
        (new PDStructureElement("Structure Type", new PDStructureTreeRoot())).getStructureType());
  }

  /**
   * Test {@link PDStructureElement#setStructureType(String)}.
   * <p>
   * Method under test: {@link PDStructureElement#setStructureType(String)}
   */
  @Test
  @DisplayName("Test setStructureType(String)")
  void testSetStructureType() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setStructureType("Structure Type");

    // Assert
    assertEquals("Structure Type", pdStructureElement.getStandardStructureType());
    assertEquals("Structure Type", pdStructureElement.getStructureType());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#setStructureType(String)}.
   * <p>
   * Method under test: {@link PDStructureElement#setStructureType(String)}
   */
  @Test
  @DisplayName("Test setStructureType(String)")
  void testSetStructureType2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setStructureType("42");

    // Assert
    assertEquals("42", pdStructureElement.getStandardStructureType());
    assertEquals("42", pdStructureElement.getStructureType());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#getParent()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getParent()}
   */
  @Test
  @DisplayName("Test getParent(); given PDStructureElement(COSDictionary) with dic is COSDictionary(); then return 'null'")
  void testGetParent_givenPDStructureElementWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getParent());
  }

  /**
   * Test {@link PDStructureElement#getParent()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getParent()}
   */
  @Test
  @DisplayName("Test getParent(); given PDStructureElement(COSDictionary) with dic is COSStream(); then return 'null'")
  void testGetParent_givenPDStructureElementWithDicIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSStream())).getParent());
  }

  /**
   * Test {@link PDStructureElement#getParent()}.
   * <ul>
   *   <li>Then return {@link PDStructureTreeRoot}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getParent()}
   */
  @Test
  @DisplayName("Test getParent(); then return PDStructureTreeRoot")
  void testGetParent_thenReturnPDStructureTreeRoot() {
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
   * Test {@link PDStructureElement#setParent(PDStructureNode)}.
   * <p>
   * Method under test: {@link PDStructureElement#setParent(PDStructureNode)}
   */
  @Test
  @DisplayName("Test setParent(PDStructureNode)")
  void testSetParent() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

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
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(parent.getKids().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#setParent(PDStructureNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()} Parent is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#setParent(PDStructureNode)}
   */
  @Test
  @DisplayName("Test setParent(PDStructureNode); when 'null'; then PDStructureElement(COSDictionary) with dic is COSDictionary() Parent is 'null'")
  void testSetParent_whenNull_thenPDStructureElementWithDicIsCOSDictionaryParentIsNull() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setParent(null);

    // Assert
    assertNull(pdStructureElement.getParent());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#getElementIdentifier()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getElementIdentifier()}
   */
  @Test
  @DisplayName("Test getElementIdentifier(); given PDStructureElement(COSDictionary) with dic is COSDictionary()")
  void testGetElementIdentifier_givenPDStructureElementWithDicIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getElementIdentifier());
  }

  /**
   * Test {@link PDStructureElement#getElementIdentifier()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getElementIdentifier()}
   */
  @Test
  @DisplayName("Test getElementIdentifier(); given PDStructureElement(COSDictionary) with dic is COSStream()")
  void testGetElementIdentifier_givenPDStructureElementWithDicIsCOSStream() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSStream())).getElementIdentifier());
  }

  /**
   * Test {@link PDStructureElement#setElementIdentifier(String)}.
   * <p>
   * Method under test: {@link PDStructureElement#setElementIdentifier(String)}
   */
  @Test
  @DisplayName("Test setElementIdentifier(String)")
  void testSetElementIdentifier() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setElementIdentifier("42");

    // Assert
    assertEquals("42", pdStructureElement.getElementIdentifier());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#getPage()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given PDStructureElement(COSDictionary) with dic is COSDictionary(); then return 'null'")
  void testGetPage_givenPDStructureElementWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getPage());
  }

  /**
   * Test {@link PDStructureElement#getPage()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given PDStructureElement(COSDictionary) with dic is COSStream(); then return 'null'")
  void testGetPage_givenPDStructureElementWithDicIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSStream())).getPage());
  }

  /**
   * Test {@link PDStructureElement#setPage(PDPage)}.
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()} COSObject Values size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); then PDStructureElement(COSDictionary) with dic is COSDictionary() COSObject Values size is one")
  void testSetPage_thenPDStructureElementWithDicIsCOSDictionaryCOSObjectValuesSizeIsOne() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    PDPage page = new PDPage();

    // Act
    pdStructureElement.setPage(page);

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(page, pdStructureElement.getPage());
  }

  /**
   * Test {@link PDStructureElement#setPage(PDPage)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()} Page is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); when 'null'; then PDStructureElement(COSDictionary) with dic is COSDictionary() Page is 'null'")
  void testSetPage_whenNull_thenPDStructureElementWithDicIsCOSDictionaryPageIsNull() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setPage(null);

    // Assert
    assertNull(pdStructureElement.getPage());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#getAttributes()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  @DisplayName("Test getAttributes(); given PDStructureElement(COSDictionary) with dic is COSDictionary()")
  void testGetAttributes_givenPDStructureElementWithDicIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDStructureElement(new COSDictionary())).getAttributes().size());
  }

  /**
   * Test {@link PDStructureElement#getAttributes()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  @DisplayName("Test getAttributes(); given PDStructureElement(COSDictionary) with dic is COSStream(); then return size is zero")
  void testGetAttributes_givenPDStructureElementWithDicIsCOSStream_thenReturnSizeIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDStructureElement(new COSStream())).getAttributes().size());
  }

  /**
   * Test {@link PDStructureElement#getAttributes()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  @DisplayName("Test getAttributes(); then return size is one")
  void testGetAttributes_thenReturnSizeIsOne() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act and Assert
    assertEquals(1, pdStructureElement.getAttributes().size());
  }

  /**
   * Test {@link PDStructureElement#getAttributes()}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  @DisplayName("Test getAttributes(); then return size is two")
  void testGetAttributes_thenReturnSizeIsTwo() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act and Assert
    assertEquals(2, pdStructureElement.getAttributes().size());
  }

  /**
   * Test {@link PDStructureElement#setAttributes(Revisions)}.
   * <p>
   * Method under test: {@link PDStructureElement#setAttributes(Revisions)}
   */
  @Test
  @DisplayName("Test setAttributes(Revisions)")
  void testSetAttributes() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setAttributes(new Revisions<>());

    // Assert
    assertEquals(0, pdStructureElement.getAttributes().size());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#setAttributes(Revisions)}.
   * <p>
   * Method under test: {@link PDStructureElement#setAttributes(Revisions)}
   */
  @Test
  @DisplayName("Test setAttributes(Revisions)")
  void testSetAttributes2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    Revisions<PDAttributeObject> attributes = new Revisions<>();
    attributes.addObject(new PDDefaultAttributeObject(), 0);

    // Act
    pdStructureElement.setAttributes(attributes);

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdStructureElement.getAttributes().size());
  }

  /**
   * Test {@link PDStructureElement#setAttributes(Revisions)}.
   * <ul>
   *   <li>Given minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#setAttributes(Revisions)}
   */
  @Test
  @DisplayName("Test setAttributes(Revisions); given minus one; then throw IllegalArgumentException")
  void testSetAttributes_givenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    Revisions<PDAttributeObject> attributes = new Revisions<>();
    attributes.addObject(new PDDefaultAttributeObject(), -1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdStructureElement.setAttributes(attributes));
  }

  /**
   * Test {@link PDStructureElement#setAttributes(Revisions)}.
   * <ul>
   *   <li>When {@link Revisions} (default constructor) addObject
   * {@link PDDefaultAttributeObject#PDDefaultAttributeObject()} and ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#setAttributes(Revisions)}
   */
  @Test
  @DisplayName("Test setAttributes(Revisions); when Revisions (default constructor) addObject PDDefaultAttributeObject() and ten")
  void testSetAttributes_whenRevisionsAddObjectPDDefaultAttributeObjectAndTen() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    Revisions<PDAttributeObject> attributes = new Revisions<>();
    attributes.addObject(new PDDefaultAttributeObject(), 10);

    // Act
    pdStructureElement.setAttributes(attributes);

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdStructureElement.getAttributes().size());
  }

  /**
   * Test {@link PDStructureElement#addAttribute(PDAttributeObject)}.
   * <p>
   * Method under test: {@link PDStructureElement#addAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test addAttribute(PDAttributeObject)")
  void testAddAttribute() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, pdStructureElement.getAttributes().size());
  }

  /**
   * Test {@link PDStructureElement#addAttribute(PDAttributeObject)}.
   * <p>
   * Method under test: {@link PDStructureElement#addAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test addAttribute(PDAttributeObject)")
  void testAddAttribute2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.incrementRevisionNumber();
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(2, pdStructureElement.getAttributes().size());
  }

  /**
   * Test {@link PDStructureElement#addAttribute(PDAttributeObject)}.
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()} Attributes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#addAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test addAttribute(PDAttributeObject); then PDStructureElement(COSDictionary) with dic is COSDictionary() Attributes size is one")
  void testAddAttribute_thenPDStructureElementWithDicIsCOSDictionaryAttributesSizeIsOne() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdStructureElement.getAttributes().size());
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject)")
  void testRemoveAttribute() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.removeAttribute(new PDDefaultAttributeObject());

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject)")
  void testRemoveAttribute2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement("Structure Type", new PDStructureTreeRoot());
    PDAttributeObject attributeObject = mock(PDAttributeObject.class);
    doNothing().when(attributeObject).setStructureElement(Mockito.<PDStructureElement>any());
    when(attributeObject.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdStructureElement.removeAttribute(attributeObject);

    // Assert that nothing has changed
    verify(attributeObject).getCOSObject();
    verify(attributeObject).setStructureElement(isNull());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject)")
  void testRemoveAttribute3() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement("Structure Type", new PDStructureTreeRoot());
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());
    PDAttributeObject attributeObject = mock(PDAttributeObject.class);
    doNothing().when(attributeObject).setStructureElement(Mockito.<PDStructureElement>any());
    when(attributeObject.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdStructureElement.removeAttribute(attributeObject);

    // Assert
    verify(attributeObject).getCOSObject();
    verify(attributeObject).setStructureElement(isNull());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject)")
  void testRemoveAttribute4() {
    // Arrange
    PDAttributeObject attributeObject = mock(PDAttributeObject.class);
    doNothing().when(attributeObject).setStructureElement(Mockito.<PDStructureElement>any());
    when(attributeObject.getCOSObject()).thenReturn(null);

    PDStructureElement pdStructureElement = new PDStructureElement("Structure Type", new PDStructureTreeRoot());
    pdStructureElement.addAttribute(attributeObject);
    PDAttributeObject attributeObject2 = mock(PDAttributeObject.class);
    doNothing().when(attributeObject2).setStructureElement(Mockito.<PDStructureElement>any());
    when(attributeObject2.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdStructureElement.removeAttribute(attributeObject2);

    // Assert
    verify(attributeObject).getCOSObject();
    verify(attributeObject2).getCOSObject();
    verify(attributeObject).setStructureElement(isA(PDStructureElement.class));
    verify(attributeObject2).setStructureElement(isNull());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getInt(int)} return one.</li>
   *   <li>Then calls {@link COSArray#getInt(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject); given COSArray getInt(int) return one; then calls getInt(int)")
  void testRemoveAttribute_givenCOSArrayGetIntReturnOne_thenCallsGetInt() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getInt(anyInt())).thenReturn(1);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray.size()).thenReturn(2);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.removeAttribute(new PDDefaultAttributeObject());

    // Assert
    verify(cosArray).getInt(eq(1));
    verify(cosArray).remove(isA(COSBase.class));
    verify(cosArray).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getInt(int)} return one.</li>
   *   <li>Then calls {@link COSArray#getInt(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject); given COSArray getInt(int) return one; then calls getInt(int)")
  void testRemoveAttribute_givenCOSArrayGetIntReturnOne_thenCallsGetInt2() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getInt(anyInt())).thenReturn(1);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray.size()).thenReturn(2);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement pdStructureElement = new PDStructureElement(dic);
    PDAttributeObject attributeObject = mock(PDAttributeObject.class);
    doNothing().when(attributeObject).setStructureElement(Mockito.<PDStructureElement>any());
    when(attributeObject.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdStructureElement.removeAttribute(attributeObject);

    // Assert that nothing has changed
    verify(cosArray).getInt(eq(1));
    verify(cosArray).remove(isA(COSBase.class));
    verify(cosArray).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(attributeObject).getCOSObject();
    verify(attributeObject).setStructureElement(isNull());
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getInt(int)} return zero.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject); given COSArray getInt(int) return zero; then calls getObject(int)")
  void testRemoveAttribute_givenCOSArrayGetIntReturnZero_thenCallsGetObject() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getInt(anyInt())).thenReturn(0);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray.size()).thenReturn(2);
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.removeAttribute(new PDDefaultAttributeObject());

    // Assert
    verify(cosArray).getInt(eq(1));
    verify(cosArray).getObject(eq(0));
    verify(cosArray).remove(isA(COSBase.class));
    verify(cosArray).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(dic).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#size()} return three.</li>
   *   <li>Then calls {@link COSArray#remove(COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject); given COSArray size() return three; then calls remove(COSBase)")
  void testRemoveAttribute_givenCOSArraySizeReturnThree_thenCallsRemove() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray.size()).thenReturn(3);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.removeAttribute(new PDDefaultAttributeObject());

    // Assert
    verify(cosArray).remove(isA(COSBase.class));
    verify(cosArray).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject); given COSDictionary() Direct is 'true'")
  void testRemoveAttribute_givenCOSDictionaryDirectIsTrue() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    cosDictionary.setDirect(true);
    PDAttributeObject attributeObject = mock(PDAttributeObject.class);
    doNothing().when(attributeObject).setStructureElement(Mockito.<PDStructureElement>any());
    when(attributeObject.getCOSObject()).thenReturn(cosDictionary);

    PDStructureElement pdStructureElement = new PDStructureElement("Structure Type", new PDStructureTreeRoot());
    pdStructureElement.addAttribute(attributeObject);
    PDAttributeObject attributeObject2 = mock(PDAttributeObject.class);
    doNothing().when(attributeObject2).setStructureElement(Mockito.<PDStructureElement>any());
    when(attributeObject2.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdStructureElement.removeAttribute(attributeObject2);

    // Assert
    verify(attributeObject).getCOSObject();
    verify(attributeObject2).getCOSObject();
    verify(attributeObject).setStructureElement(isA(PDStructureElement.class));
    verify(attributeObject2).setStructureElement(isNull());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject); given COSDictionary getDictionaryObject(COSName) return COSArray()")
  void testRemoveAttribute_givenCOSDictionaryGetDictionaryObjectReturnCOSArray() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.removeAttribute(new PDDefaultAttributeObject());

    // Assert
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject); given COSDictionary getDictionaryObject(COSName) return FALSE")
  void testRemoveAttribute_givenCOSDictionaryGetDictionaryObjectReturnFalse() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.removeAttribute(new PDDefaultAttributeObject());

    // Assert
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testRemoveAttribute_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    cosDictionary.setKey(new COSObjectKey(1L, 1));
    PDAttributeObject attributeObject = mock(PDAttributeObject.class);
    doNothing().when(attributeObject).setStructureElement(Mockito.<PDStructureElement>any());
    when(attributeObject.getCOSObject()).thenReturn(cosDictionary);

    PDStructureElement pdStructureElement = new PDStructureElement("Structure Type", new PDStructureTreeRoot());
    pdStructureElement.addAttribute(attributeObject);
    PDAttributeObject attributeObject2 = mock(PDAttributeObject.class);
    doNothing().when(attributeObject2).setStructureElement(Mockito.<PDStructureElement>any());
    when(attributeObject2.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdStructureElement.removeAttribute(attributeObject2);

    // Assert
    verify(attributeObject).getCOSObject();
    verify(attributeObject2).getCOSObject();
    verify(attributeObject).setStructureElement(isA(PDStructureElement.class));
    verify(attributeObject2).setStructureElement(isNull());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject); given COSObjectKey(long, int) with num is one and gen is one")
  void testRemoveAttribute_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.removeAttribute(new PDDefaultAttributeObject());

    // Assert
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <ul>
   *   <li>Given {@link PDAttributeObject}
   * {@link PDDictionaryWrapper#getCOSObject()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject); given PDAttributeObject getCOSObject() return 'null'")
  void testRemoveAttribute_givenPDAttributeObjectGetCOSObjectReturnNull() {
    // Arrange
    PDAttributeObject attributeObject = mock(PDAttributeObject.class);
    doNothing().when(attributeObject).setStructureElement(Mockito.<PDStructureElement>any());
    when(attributeObject.getCOSObject()).thenReturn(null);

    PDStructureElement pdStructureElement = new PDStructureElement("Structure Type", new PDStructureTreeRoot());
    pdStructureElement.addAttribute(attributeObject);
    PDAttributeObject attributeObject2 = mock(PDAttributeObject.class);
    doNothing().when(attributeObject2).setStructureElement(Mockito.<PDStructureElement>any());
    when(attributeObject2.getCOSObject()).thenReturn(null);

    // Act
    pdStructureElement.removeAttribute(attributeObject2);

    // Assert
    verify(attributeObject).getCOSObject();
    verify(attributeObject2).getCOSObject();
    verify(attributeObject).setStructureElement(isA(PDStructureElement.class));
    verify(attributeObject2).setStructureElement(isNull());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()} COSObject {@link COSStream}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject); then PDStructureElement(COSDictionary) with dic is COSStream() COSObject COSStream")
  void testRemoveAttribute_thenPDStructureElementWithDicIsCOSStreamCOSObjectCOSStream() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSStream());

    // Act
    pdStructureElement.removeAttribute(new PDDefaultAttributeObject());

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject); then throw IllegalArgumentException")
  void testRemoveAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getInt(anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    when(cosArray.size()).thenReturn(2);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdStructureElement.removeAttribute(new PDDefaultAttributeObject()));
    verify(cosArray).getInt(eq(1));
    verify(cosArray).remove(isA(COSBase.class));
    verify(cosArray).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDStructureElement#attributeChanged(PDAttributeObject)}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#attributeChanged(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test attributeChanged(PDAttributeObject)")
  void testAttributeChanged() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act
    pdStructureElement.attributeChanged(new PDDefaultAttributeObject());

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#attributeChanged(PDAttributeObject)}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#attributeChanged(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test attributeChanged(PDAttributeObject)")
  void testAttributeChanged2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.incrementRevisionNumber();

    // Act
    pdStructureElement.attributeChanged(new PDDefaultAttributeObject());

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#attributeChanged(PDAttributeObject)}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#attributeChanged(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test attributeChanged(PDAttributeObject); given PDStructureElement(COSDictionary) with dic is COSDictionary()")
  void testAttributeChanged_givenPDStructureElementWithDicIsCOSDictionary() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.attributeChanged(new PDDefaultAttributeObject());

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#attributeChanged(PDAttributeObject)}.
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()} COSObject {@link COSStream}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#attributeChanged(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test attributeChanged(PDAttributeObject); then PDStructureElement(COSDictionary) with dic is COSStream() COSObject COSStream")
  void testAttributeChanged_thenPDStructureElementWithDicIsCOSStreamCOSObjectCOSStream() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSStream());

    // Act
    pdStructureElement.attributeChanged(new PDDefaultAttributeObject());

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#getClassNames()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getClassNames()}
   */
  @Test
  @DisplayName("Test getClassNames(); given PDStructureElement(COSDictionary) with dic is COSDictionary()")
  void testGetClassNames_givenPDStructureElementWithDicIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDStructureElement(new COSDictionary())).getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#getClassNames()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()}.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getClassNames()}
   */
  @Test
  @DisplayName("Test getClassNames(); given PDStructureElement(COSDictionary) with dic is COSStream(); then return size is zero")
  void testGetClassNames_givenPDStructureElementWithDicIsCOSStream_thenReturnSizeIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDStructureElement(new COSStream())).getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#getClassNames()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getClassNames()}
   */
  @Test
  @DisplayName("Test getClassNames(); then return size is one")
  void testGetClassNames_thenReturnSizeIsOne() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addClassName("Class Name");

    // Act and Assert
    assertEquals(1, pdStructureElement.getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#setClassNames(Revisions)}.
   * <p>
   * Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  @DisplayName("Test setClassNames(Revisions)")
  void testSetClassNames() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setClassNames(new Revisions<>());

    // Assert
    assertEquals(0, pdStructureElement.getClassNames().size());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#setClassNames(Revisions)}.
   * <p>
   * Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  @DisplayName("Test setClassNames(Revisions)")
  void testSetClassNames2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setClassNames(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertEquals(0, pdStructureElement.getClassNames().size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#setClassNames(Revisions)}.
   * <p>
   * Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  @DisplayName("Test setClassNames(Revisions)")
  void testSetClassNames3() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    Revisions<String> classNames = new Revisions<>();
    classNames.addObject("Object", 10);

    // Act
    pdStructureElement.setClassNames(classNames);

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdStructureElement.getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#setClassNames(Revisions)}.
   * <p>
   * Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  @DisplayName("Test setClassNames(Revisions)")
  void testSetClassNames4() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    Revisions<String> classNames = new Revisions<>();
    classNames.addObject("{", 2);
    classNames.addObject("Object", 10);

    // Act
    pdStructureElement.setClassNames(classNames);

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, pdStructureElement.getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#setClassNames(Revisions)}.
   * <ul>
   *   <li>Given minus one hundred.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  @DisplayName("Test setClassNames(Revisions); given minus one hundred; then throw IllegalArgumentException")
  void testSetClassNames_givenMinusOneHundred_thenThrowIllegalArgumentException() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    Revisions<String> classNames = new Revisions<>();
    classNames.addObject("Object", -100);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdStructureElement.setClassNames(classNames));
  }

  /**
   * Test {@link PDStructureElement#setClassNames(Revisions)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link Revisions} (default constructor) addObject {@code Object} and
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  @DisplayName("Test setClassNames(Revisions); given zero; when Revisions (default constructor) addObject 'Object' and zero")
  void testSetClassNames_givenZero_whenRevisionsAddObjectObjectAndZero() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    Revisions<String> classNames = new Revisions<>();
    classNames.addObject("Object", 0);

    // Act
    pdStructureElement.setClassNames(classNames);

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdStructureElement.getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#addClassName(String)}.
   * <p>
   * Method under test: {@link PDStructureElement#addClassName(String)}
   */
  @Test
  @DisplayName("Test addClassName(String)")
  void testAddClassName() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary(new COSDictionary()));

    // Act
    pdStructureElement.addClassName("Class Name");

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdStructureElement.getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#addClassName(String)}.
   * <p>
   * Method under test: {@link PDStructureElement#addClassName(String)}
   */
  @Test
  @DisplayName("Test addClassName(String)")
  void testAddClassName2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.incrementRevisionNumber();

    // Act
    pdStructureElement.addClassName("Class Name");

    // Assert
    assertEquals(1, pdStructureElement.getClassNames().size());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#addClassName(String)}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#addClassName(String)}
   */
  @Test
  @DisplayName("Test addClassName(String); given PDStructureElement(COSDictionary) with dic is COSDictionary()")
  void testAddClassName_givenPDStructureElementWithDicIsCOSDictionary() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.addClassName("Class Name");

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdStructureElement.getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#addClassName(String)}.
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()} ClassNames size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#addClassName(String)}
   */
  @Test
  @DisplayName("Test addClassName(String); then PDStructureElement(COSDictionary) with dic is COSDictionary() ClassNames size is two")
  void testAddClassName_thenPDStructureElementWithDicIsCOSDictionaryClassNamesSizeIsTwo() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addClassName("Class Name");

    // Act
    pdStructureElement.addClassName("Class Name");

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, pdStructureElement.getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#removeClassName(String)}.
   * <p>
   * Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  @DisplayName("Test removeClassName(String)")
  void testRemoveClassName() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary(new COSDictionary()));

    // Act
    pdStructureElement.removeClassName("Class Name");

    // Assert that nothing has changed
    assertEquals(0, pdStructureElement.getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#removeClassName(String)}.
   * <p>
   * Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  @DisplayName("Test removeClassName(String)")
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
   * Test {@link PDStructureElement#removeClassName(String)}.
   * <p>
   * Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  @DisplayName("Test removeClassName(String)")
  void testRemoveClassName3() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addClassName(PDStructureElement.TYPE);
    pdStructureElement.addClassName("Class Name");

    // Act
    pdStructureElement.removeClassName("Class Name");

    // Assert
    assertEquals(1, pdStructureElement.getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#removeClassName(String)}.
   * <p>
   * Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  @DisplayName("Test removeClassName(String)")
  void testRemoveClassName4() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addClassName(PDStructureElement.TYPE);

    // Act
    pdStructureElement.removeClassName("Class Name");

    // Assert
    assertEquals(1, pdStructureElement.getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#removeClassName(String)}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  @DisplayName("Test removeClassName(String); given PDStructureElement(COSDictionary) with dic is COSDictionary()")
  void testRemoveClassName_givenPDStructureElementWithDicIsCOSDictionary() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.removeClassName("Class Name");

    // Assert that nothing has changed
    assertEquals(0, pdStructureElement.getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#removeClassName(String)}.
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()} ClassNames size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  @DisplayName("Test removeClassName(String); then PDStructureElement(COSDictionary) with dic is COSStream() ClassNames size is zero")
  void testRemoveClassName_thenPDStructureElementWithDicIsCOSStreamClassNamesSizeIsZero() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSStream());

    // Act
    pdStructureElement.removeClassName("Class Name");

    // Assert that nothing has changed
    assertEquals(0, pdStructureElement.getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#getRevisionNumber()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getRevisionNumber()}
   */
  @Test
  @DisplayName("Test getRevisionNumber(); given PDStructureElement(COSDictionary) with dic is COSDictionary()")
  void testGetRevisionNumber_givenPDStructureElementWithDicIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDStructureElement(new COSDictionary())).getRevisionNumber());
  }

  /**
   * Test {@link PDStructureElement#getRevisionNumber()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getRevisionNumber()}
   */
  @Test
  @DisplayName("Test getRevisionNumber(); given PDStructureElement(COSDictionary) with dic is COSStream(); then return zero")
  void testGetRevisionNumber_givenPDStructureElementWithDicIsCOSStream_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDStructureElement(new COSStream())).getRevisionNumber());
  }

  /**
   * Test {@link PDStructureElement#getRevisionNumber()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getRevisionNumber()}
   */
  @Test
  @DisplayName("Test getRevisionNumber(); then return one")
  void testGetRevisionNumber_thenReturnOne() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.incrementRevisionNumber();

    // Act and Assert
    assertEquals(1, pdStructureElement.getRevisionNumber());
  }

  /**
   * Test {@link PDStructureElement#setRevisionNumber(int)}.
   * <p>
   * Method under test: {@link PDStructureElement#setRevisionNumber(int)}
   */
  @Test
  @DisplayName("Test setRevisionNumber(int)")
  void testSetRevisionNumber() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setRevisionNumber(10);

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(10, pdStructureElement.getRevisionNumber());
  }

  /**
   * Test {@link PDStructureElement#setRevisionNumber(int)}.
   * <ul>
   *   <li>When minus one hundred.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#setRevisionNumber(int)}
   */
  @Test
  @DisplayName("Test setRevisionNumber(int); when minus one hundred; then throw IllegalArgumentException")
  void testSetRevisionNumber_whenMinusOneHundred_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDStructureElement(new COSDictionary())).setRevisionNumber(-100));
  }

  /**
   * Test {@link PDStructureElement#incrementRevisionNumber()}.
   * <p>
   * Method under test: {@link PDStructureElement#incrementRevisionNumber()}
   */
  @Test
  @DisplayName("Test incrementRevisionNumber()")
  void testIncrementRevisionNumber() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.incrementRevisionNumber();

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdStructureElement.getRevisionNumber());
  }

  /**
   * Test {@link PDStructureElement#incrementRevisionNumber()}.
   * <p>
   * Method under test: {@link PDStructureElement#incrementRevisionNumber()}
   */
  @Test
  @DisplayName("Test incrementRevisionNumber()")
  void testIncrementRevisionNumber2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSStream());

    // Act
    pdStructureElement.incrementRevisionNumber();

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(1, pdStructureElement.getRevisionNumber());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#incrementRevisionNumber()}.
   * <p>
   * Method under test: {@link PDStructureElement#incrementRevisionNumber()}
   */
  @Test
  @DisplayName("Test incrementRevisionNumber()")
  void testIncrementRevisionNumber3() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.incrementRevisionNumber();

    // Act
    pdStructureElement.incrementRevisionNumber();

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, pdStructureElement.getRevisionNumber());
  }

  /**
   * Test {@link PDStructureElement#getTitle()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); given PDStructureElement(COSDictionary) with dic is COSDictionary(); then return 'null'")
  void testGetTitle_givenPDStructureElementWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getTitle());
  }

  /**
   * Test {@link PDStructureElement#getTitle()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); given PDStructureElement(COSDictionary) with dic is COSStream(); then return 'null'")
  void testGetTitle_givenPDStructureElementWithDicIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSStream())).getTitle());
  }

  /**
   * Test {@link PDStructureElement#setTitle(String)}.
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()} Title is {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#setTitle(String)}
   */
  @Test
  @DisplayName("Test setTitle(String); then PDStructureElement(COSDictionary) with dic is COSDictionary() Title is 'Dr'")
  void testSetTitle_thenPDStructureElementWithDicIsCOSDictionaryTitleIsDr() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setTitle("Dr");

    // Assert
    assertEquals("Dr", pdStructureElement.getTitle());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#getLanguage()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage(); given PDStructureElement(COSDictionary) with dic is COSDictionary(); then return 'null'")
  void testGetLanguage_givenPDStructureElementWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getLanguage());
  }

  /**
   * Test {@link PDStructureElement#getLanguage()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getLanguage()}
   */
  @Test
  @DisplayName("Test getLanguage(); given PDStructureElement(COSDictionary) with dic is COSStream(); then return 'null'")
  void testGetLanguage_givenPDStructureElementWithDicIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSStream())).getLanguage());
  }

  /**
   * Test {@link PDStructureElement#setLanguage(String)}.
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()} Language is {@code en}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#setLanguage(String)}
   */
  @Test
  @DisplayName("Test setLanguage(String); then PDStructureElement(COSDictionary) with dic is COSDictionary() Language is 'en'")
  void testSetLanguage_thenPDStructureElementWithDicIsCOSDictionaryLanguageIsEn() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setLanguage("en");

    // Assert
    assertEquals("en", pdStructureElement.getLanguage());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#getAlternateDescription()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getAlternateDescription()}
   */
  @Test
  @DisplayName("Test getAlternateDescription(); given PDStructureElement(COSDictionary) with dic is COSDictionary()")
  void testGetAlternateDescription_givenPDStructureElementWithDicIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getAlternateDescription());
  }

  /**
   * Test {@link PDStructureElement#getAlternateDescription()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getAlternateDescription()}
   */
  @Test
  @DisplayName("Test getAlternateDescription(); given PDStructureElement(COSDictionary) with dic is COSStream()")
  void testGetAlternateDescription_givenPDStructureElementWithDicIsCOSStream() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSStream())).getAlternateDescription());
  }

  /**
   * Test {@link PDStructureElement#setAlternateDescription(String)}.
   * <p>
   * Method under test: {@link PDStructureElement#setAlternateDescription(String)}
   */
  @Test
  @DisplayName("Test setAlternateDescription(String)")
  void testSetAlternateDescription() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setAlternateDescription("Alternate Description");

    // Assert
    assertEquals("Alternate Description", pdStructureElement.getAlternateDescription());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#getExpandedForm()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getExpandedForm()}
   */
  @Test
  @DisplayName("Test getExpandedForm(); given PDStructureElement(COSDictionary) with dic is COSDictionary(); then return 'null'")
  void testGetExpandedForm_givenPDStructureElementWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getExpandedForm());
  }

  /**
   * Test {@link PDStructureElement#getExpandedForm()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getExpandedForm()}
   */
  @Test
  @DisplayName("Test getExpandedForm(); given PDStructureElement(COSDictionary) with dic is COSStream(); then return 'null'")
  void testGetExpandedForm_givenPDStructureElementWithDicIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSStream())).getExpandedForm());
  }

  /**
   * Test {@link PDStructureElement#setExpandedForm(String)}.
   * <p>
   * Method under test: {@link PDStructureElement#setExpandedForm(String)}
   */
  @Test
  @DisplayName("Test setExpandedForm(String)")
  void testSetExpandedForm() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setExpandedForm("Expanded Form");

    // Assert
    assertEquals("Expanded Form", pdStructureElement.getExpandedForm());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#getActualText()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getActualText()}
   */
  @Test
  @DisplayName("Test getActualText(); given PDStructureElement(COSDictionary) with dic is COSDictionary(); then return 'null'")
  void testGetActualText_givenPDStructureElementWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getActualText());
  }

  /**
   * Test {@link PDStructureElement#getActualText()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getActualText()}
   */
  @Test
  @DisplayName("Test getActualText(); given PDStructureElement(COSDictionary) with dic is COSStream(); then return 'null'")
  void testGetActualText_givenPDStructureElementWithDicIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSStream())).getActualText());
  }

  /**
   * Test {@link PDStructureElement#setActualText(String)}.
   * <p>
   * Method under test: {@link PDStructureElement#setActualText(String)}
   */
  @Test
  @DisplayName("Test setActualText(String)")
  void testSetActualText() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setActualText("Actual Text");

    // Assert
    assertEquals("Actual Text", pdStructureElement.getActualText());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#getStandardStructureType()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getStandardStructureType()}
   */
  @Test
  @DisplayName("Test getStandardStructureType(); given PDStructureElement(COSDictionary) with dic is COSDictionary()")
  void testGetStandardStructureType_givenPDStructureElementWithDicIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSDictionary())).getStandardStructureType());
  }

  /**
   * Test {@link PDStructureElement#getStandardStructureType()}.
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getStandardStructureType()}
   */
  @Test
  @DisplayName("Test getStandardStructureType(); given PDStructureElement(COSDictionary) with dic is COSStream()")
  void testGetStandardStructureType_givenPDStructureElementWithDicIsCOSStream() {
    // Arrange, Act and Assert
    assertNull((new PDStructureElement(new COSStream())).getStandardStructureType());
  }

  /**
   * Test {@link PDStructureElement#getStandardStructureType()}.
   * <ul>
   *   <li>Then return {@code Structure Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#getStandardStructureType()}
   */
  @Test
  @DisplayName("Test getStandardStructureType(); then return 'Structure Type'")
  void testGetStandardStructureType_thenReturnStructureType() {
    // Arrange, Act and Assert
    assertEquals("Structure Type",
        (new PDStructureElement("Structure Type", new PDStructureTreeRoot())).getStandardStructureType());
  }

  /**
   * Test {@link PDStructureElement#appendKid(PDMarkedContent)} with
   * {@code markedContent}.
   * <p>
   * Method under test: {@link PDStructureElement#appendKid(PDMarkedContent)}
   */
  @Test
  @DisplayName("Test appendKid(PDMarkedContent) with 'markedContent'")
  void testAppendKidWithMarkedContent() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdStructureElement.appendKid(new PDMarkedContent(COSName.A, new COSDictionary())));
  }

  /**
   * Test {@link PDStructureElement#appendKid(PDMarkedContent)} with
   * {@code markedContent}.
   * <p>
   * Method under test: {@link PDStructureElement#appendKid(PDMarkedContent)}
   */
  @Test
  @DisplayName("Test appendKid(PDMarkedContent) with 'markedContent'")
  void testAppendKidWithMarkedContent2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdStructureElement.appendKid(new PDMarkedContent(COSName.A, new COSStream())));
  }

  /**
   * Test {@link PDStructureElement#appendKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#appendKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDMarkedContentReference) with 'markedContentReference'")
  void testAppendKidWithMarkedContentReference() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Assert
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDMarkedContentReference);
    assertNull(((PDMarkedContentReference) getResult).getPage());
    assertEquals(-1, ((PDMarkedContentReference) getResult).getMCID());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#appendKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#appendKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDMarkedContentReference) with 'markedContentReference'")
  void testAppendKidWithMarkedContentReference2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSStream());

    // Act
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDMarkedContentReference);
    assertNull(((PDMarkedContentReference) getResult).getPage());
    assertEquals(-1, ((PDMarkedContentReference) getResult).getMCID());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#appendKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#appendKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDMarkedContentReference) with 'markedContentReference'")
  void testAppendKidWithMarkedContentReference3() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
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
  }

  /**
   * Test {@link PDStructureElement#appendKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#appendKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDMarkedContentReference) with 'markedContentReference'")
  void testAppendKidWithMarkedContentReference4() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Assert
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(3, kids.size());
    Object getResult = kids.get(2);
    assertTrue(getResult instanceof PDMarkedContentReference);
    assertNull(((PDMarkedContentReference) getResult).getPage());
    assertEquals(-1, ((PDMarkedContentReference) getResult).getMCID());
  }

  /**
   * Test {@link PDStructureElement#appendKid(PDMarkedContent)} with
   * {@code markedContent}.
   * <ul>
   *   <li>When {@link PDMarkedContent#PDMarkedContent(COSName, COSDictionary)} with
   * tag is {@link COSName#A} and properties is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#appendKid(PDMarkedContent)}
   */
  @Test
  @DisplayName("Test appendKid(PDMarkedContent) with 'markedContent'; when PDMarkedContent(COSName, COSDictionary) with tag is A and properties is 'null'")
  void testAppendKidWithMarkedContent_whenPDMarkedContentWithTagIsAAndPropertiesIsNull() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdStructureElement.appendKid(new PDMarkedContent(COSName.A, null)));
  }

  /**
   * Test {@link PDStructureElement#appendKid(int)} with {@code mcid}.
   * <p>
   * Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  @DisplayName("Test appendKid(int) with 'mcid'")
  void testAppendKidWithMcid() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.appendKid(1);

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(3, pdStructureElement.getKids().size());
  }

  /**
   * Test {@link PDStructureElement#appendKid(int)} with {@code mcid}.
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()} Kids size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  @DisplayName("Test appendKid(int) with 'mcid'; then PDStructureElement(COSDictionary) with dic is COSDictionary() Kids size is one")
  void testAppendKidWithMcid_thenPDStructureElementWithDicIsCOSDictionaryKidsSizeIsOne() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.appendKid(1);

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, pdStructureElement.getKids().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#appendKid(int)} with {@code mcid}.
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSDictionary#COSDictionary()} Kids size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  @DisplayName("Test appendKid(int) with 'mcid'; then PDStructureElement(COSDictionary) with dic is COSDictionary() Kids size is two")
  void testAppendKidWithMcid_thenPDStructureElementWithDicIsCOSDictionaryKidsSizeIsTwo() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.appendKid(1);

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, pdStructureElement.getKids().size());
  }

  /**
   * Test {@link PDStructureElement#appendKid(int)} with {@code mcid}.
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with
   * dic is {@link COSStream#COSStream()} COSObject {@link COSStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  @DisplayName("Test appendKid(int) with 'mcid'; then PDStructureElement(COSDictionary) with dic is COSStream() COSObject COSStream")
  void testAppendKidWithMcid_thenPDStructureElementWithDicIsCOSStreamCOSObjectCOSStream() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSStream());

    // Act
    pdStructureElement.appendKid(1);

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(1, pdStructureElement.getKids().size());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#appendKid(int)} with {@code mcid}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  @DisplayName("Test appendKid(int) with 'mcid'; when minus one; then throw IllegalArgumentException")
  void testAppendKidWithMcid_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDStructureElement(new COSDictionary())).appendKid(-1));
  }

  /**
   * Test {@link PDStructureElement#appendKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#appendKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDObjectReference) with 'objectReference'")
  void testAppendKidWithObjectReference() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.appendKid(new PDObjectReference());

    // Assert
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDObjectReference);
    assertNull(((PDObjectReference) getResult).getPage());
    assertNull(((PDObjectReference) getResult).getReferencedObject());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#appendKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#appendKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDObjectReference) with 'objectReference'")
  void testAppendKidWithObjectReference2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSStream());

    // Act
    pdStructureElement.appendKid(new PDObjectReference());

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDObjectReference);
    assertNull(((PDObjectReference) getResult).getPage());
    assertNull(((PDObjectReference) getResult).getReferencedObject());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#appendKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#appendKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDObjectReference) with 'objectReference'")
  void testAppendKidWithObjectReference3() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
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
  }

  /**
   * Test {@link PDStructureElement#appendKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#appendKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDObjectReference) with 'objectReference'")
  void testAppendKidWithObjectReference4() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.appendKid(new PDObjectReference());

    // Assert
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(3, kids.size());
    Object getResult = kids.get(2);
    assertTrue(getResult instanceof PDObjectReference);
    assertNull(((PDObjectReference) getResult).getPage());
    assertNull(((PDObjectReference) getResult).getReferencedObject());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'")
  void testInsertBeforeWithCOSIntegerObject() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'")
  void testInsertBeforeWithCOSIntegerObject2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSStream());

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'")
  void testInsertBeforeWithCOSIntegerObject3() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    assertEquals(1, pdStructureElement.getKids().size());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'")
  void testInsertBeforeWithCOSIntegerObject4() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    assertEquals(1, pdStructureElement.getKids().size());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'")
  void testInsertBeforeWithCOSIntegerObject5() {
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'")
  void testInsertBeforeWithCOSIntegerObject6() {
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'")
  void testInsertBeforeWithCOSIntegerObject7() throws IOException {
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'")
  void testInsertBeforeWithCOSIntegerObject8() {
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'")
  void testInsertBeforeWithCOSIntegerObject9() {
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'; given COSObjectable getCOSObject() return A")
  void testInsertBeforeWithCOSIntegerObject_givenCOSObjectableGetCOSObjectReturnA() {
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'; given COSObjectable getCOSObject() return FALSE")
  void testInsertBeforeWithCOSIntegerObject_givenCOSObjectableGetCOSObjectReturnFalse() {
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSFloat#ONE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'; given COSObjectable getCOSObject() return ONE")
  void testInsertBeforeWithCOSIntegerObject_givenCOSObjectableGetCOSObjectReturnOne() {
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'; when FALSE")
  void testInsertBeforeWithCOSIntegerObject_whenFalse() {
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'; when 'null'")
  void testInsertBeforeWithCOSIntegerObject_whenNull() {
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'; when 'null'")
  void testInsertBeforeWithCOSIntegerObject_whenNull2() {
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <ul>
   *   <li>When {@link COSFloat#ONE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'; when ONE")
  void testInsertBeforeWithCOSIntegerObject_whenOne() {
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <ul>
   *   <li>When {@link PDDictionaryWrapper#PDDictionaryWrapper()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'; when PDDictionaryWrapper()")
  void testInsertBeforeWithCOSIntegerObject_whenPDDictionaryWrapper() {
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <ul>
   *   <li>When {@link COSInteger#TWO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'; when TWO")
  void testInsertBeforeWithCOSIntegerObject_whenTwo() {
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with
   * {@code COSInteger}, {@code Object}.
   * <ul>
   *   <li>When {@link COSFloat#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'; when ZERO")
  void testInsertBeforeWithCOSIntegerObject_whenZero() {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  void testInsertBeforeWithPDMarkedContentReferenceObject() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  void testInsertBeforeWithPDMarkedContentReferenceObject2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSStream());

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  void testInsertBeforeWithPDMarkedContentReferenceObject3() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), "Ref Kid");

    // Assert that nothing has changed
    assertEquals(1, pdStructureElement.getKids().size());
  }

  /**
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  void testInsertBeforeWithPDMarkedContentReferenceObject4() {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  void testInsertBeforeWithPDMarkedContentReferenceObject5() {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  void testInsertBeforeWithPDMarkedContentReferenceObject6() {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  void testInsertBeforeWithPDMarkedContentReferenceObject7() {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  void testInsertBeforeWithPDMarkedContentReferenceObject8() {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  void testInsertBeforeWithPDMarkedContentReferenceObject9() {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  void testInsertBeforeWithPDMarkedContentReferenceObject10() throws IOException {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  void testInsertBeforeWithPDMarkedContentReferenceObject11() {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  void testInsertBeforeWithPDMarkedContentReferenceObject12() {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'; when FALSE")
  void testInsertBeforeWithPDMarkedContentReferenceObject_whenFalse() {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'; when 'null'")
  void testInsertBeforeWithPDMarkedContentReferenceObject_whenNull() {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'; when 'null'")
  void testInsertBeforeWithPDMarkedContentReferenceObject_whenNull2() {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <ul>
   *   <li>When {@link COSFloat#ONE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'; when ONE")
  void testInsertBeforeWithPDMarkedContentReferenceObject_whenOne() {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <ul>
   *   <li>When {@link PDDictionaryWrapper#PDDictionaryWrapper()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'; when PDDictionaryWrapper()")
  void testInsertBeforeWithPDMarkedContentReferenceObject_whenPDDictionaryWrapper() {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <ul>
   *   <li>When {@link COSInteger#TWO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'; when TWO")
  void testInsertBeforeWithPDMarkedContentReferenceObject_whenTwo() {
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
   * Test
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   * with {@code PDMarkedContentReference}, {@code Object}.
   * <ul>
   *   <li>When {@link COSFloat#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'; when ZERO")
  void testInsertBeforeWithPDMarkedContentReferenceObject_whenZero() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  void testInsertBeforeWithPDObjectReferenceObject() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  void testInsertBeforeWithPDObjectReferenceObject2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSStream());

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  void testInsertBeforeWithPDObjectReferenceObject3() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), "Ref Kid");

    // Assert that nothing has changed
    assertEquals(1, pdStructureElement.getKids().size());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  void testInsertBeforeWithPDObjectReferenceObject4() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  void testInsertBeforeWithPDObjectReferenceObject5() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  void testInsertBeforeWithPDObjectReferenceObject6() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  void testInsertBeforeWithPDObjectReferenceObject7() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  void testInsertBeforeWithPDObjectReferenceObject8() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  void testInsertBeforeWithPDObjectReferenceObject9() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  void testInsertBeforeWithPDObjectReferenceObject10() throws IOException {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  void testInsertBeforeWithPDObjectReferenceObject11() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  void testInsertBeforeWithPDObjectReferenceObject12() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'; when FALSE")
  void testInsertBeforeWithPDObjectReferenceObject_whenFalse() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'; when 'null'")
  void testInsertBeforeWithPDObjectReferenceObject_whenNull() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'; when 'null'")
  void testInsertBeforeWithPDObjectReferenceObject_whenNull2() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <ul>
   *   <li>When {@link COSFloat#ONE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'; when ONE")
  void testInsertBeforeWithPDObjectReferenceObject_whenOne() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <ul>
   *   <li>When {@link PDDictionaryWrapper#PDDictionaryWrapper()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'; when PDDictionaryWrapper()")
  void testInsertBeforeWithPDObjectReferenceObject_whenPDDictionaryWrapper() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <ul>
   *   <li>When {@link COSInteger#TWO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'; when TWO")
  void testInsertBeforeWithPDObjectReferenceObject_whenTwo() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with
   * {@code PDObjectReference}, {@code Object}.
   * <ul>
   *   <li>When {@link COSFloat#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'; when ZERO")
  void testInsertBeforeWithPDObjectReferenceObject_whenZero() {
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
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSStream());

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier3() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier4() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, pdStructureElement.getKids().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, pdStructureElement.getKids().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSArray());

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier8() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier9() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSString.parseHex("0123456789ABCDEF"));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier10() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, pdStructureElement.getKids().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier11() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(1);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier12() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier13() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSInteger.ONE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, pdStructureElement.getKids().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier14() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, pdStructureElement.getKids().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier15() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSName.A, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, pdStructureElement.getKids().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  void testRemoveKidWithMarkedContentIdentifier16() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSArray object = new COSArray();
    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, pdStructureElement.getKids().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'; given COSObjectable getCOSObject() return A")
  void testRemoveKidWithMarkedContentIdentifier_givenCOSObjectableGetCOSObjectReturnA() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSFloat#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'; given COSObjectable getCOSObject() return ONE")
  void testRemoveKidWithMarkedContentIdentifier_givenCOSObjectableGetCOSObjectReturnOne() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSFloat.ONE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'; given COSObjectable getCOSObject() return ONE")
  void testRemoveKidWithMarkedContentIdentifier_givenCOSObjectableGetCOSObjectReturnOne2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, pdStructureElement.getKids().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with
   * {@code markedContentIdentifier}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'; when 'null'")
  void testRemoveKidWithMarkedContentIdentifier_whenNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid((COSInteger) null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  void testRemoveKidWithMarkedContentReference() {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  void testRemoveKidWithMarkedContentReference2() {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  void testRemoveKidWithMarkedContentReference3() {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  void testRemoveKidWithMarkedContentReference4() throws IOException {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  void testRemoveKidWithMarkedContentReference5() {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  void testRemoveKidWithMarkedContentReference6() {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  void testRemoveKidWithMarkedContentReference7() {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  void testRemoveKidWithMarkedContentReference8() {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  void testRemoveKidWithMarkedContentReference9() {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  void testRemoveKidWithMarkedContentReference10() {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  void testRemoveKidWithMarkedContentReference11() {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  void testRemoveKidWithMarkedContentReference12() {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  void testRemoveKidWithMarkedContentReference13() {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  void testRemoveKidWithMarkedContentReference14() {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'; given COSObjectable getCOSObject() return A")
  void testRemoveKidWithMarkedContentReference_givenCOSObjectableGetCOSObjectReturnA() {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSFloat#ONE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'; given COSObjectable getCOSObject() return ONE")
  void testRemoveKidWithMarkedContentReference_givenCOSObjectableGetCOSObjectReturnOne() {
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with
   * {@code markedContentReference}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'; when 'null'")
  void testRemoveKidWithMarkedContentReference_whenNull() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'")
  void testRemoveKidWithObjectReference() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'")
  void testRemoveKidWithObjectReference2() throws IOException {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'")
  void testRemoveKidWithObjectReference3() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'")
  void testRemoveKidWithObjectReference4() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'")
  void testRemoveKidWithObjectReference5() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'")
  void testRemoveKidWithObjectReference6() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'")
  void testRemoveKidWithObjectReference7() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'")
  void testRemoveKidWithObjectReference8() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'")
  void testRemoveKidWithObjectReference9() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'")
  void testRemoveKidWithObjectReference10() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'")
  void testRemoveKidWithObjectReference11() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'")
  void testRemoveKidWithObjectReference12() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'; given COSObjectable getCOSObject() return A")
  void testRemoveKidWithObjectReference_givenCOSObjectableGetCOSObjectReturnA() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'; given COSObjectable getCOSObject() return FALSE")
  void testRemoveKidWithObjectReference_givenCOSObjectableGetCOSObjectReturnFalse() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'; given COSObjectable getCOSObject() return FALSE")
  void testRemoveKidWithObjectReference_givenCOSObjectableGetCOSObjectReturnFalse2() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return
   * {@link COSFloat#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'; given COSObjectable getCOSObject() return ONE")
  void testRemoveKidWithObjectReference_givenCOSObjectableGetCOSObjectReturnOne() {
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with
   * {@code objectReference}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'; when 'null'")
  void testRemoveKidWithObjectReference_whenNull() {
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
}
