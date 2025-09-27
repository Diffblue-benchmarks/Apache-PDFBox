package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDStructureElementDiffblueTest {
  /**
   * Test {@link PDStructureElement#PDStructureElement(COSDictionary)}.
   *
   * <p>Method under test: {@link PDStructureElement#PDStructureElement(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDStructureElement(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.<init>(COSDictionary)"})
  void testNewPDStructureElement() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, new PDStructureElement(dic).getCOSObject());
  }

  /**
   * Test {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}.
   *
   * <p>Method under test: {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}
   */
  @Test
  @DisplayName("Test new PDStructureElement(String, PDStructureNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.<init>(String, PDStructureNode)"})
  void testNewPDStructureElement2() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    dic.setKey(key);

    // Act
    PDStructureElement actualPdStructureElement =
        new PDStructureElement(null, new PDStructureTreeRoot(dic));

    // Assert
    PDStructureNode parent = actualPdStructureElement.getParent();
    assertTrue(parent instanceof PDStructureElement);
    assertSame(key, parent.getCOSObject().getKey());
  }

  /**
   * Test {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return Parent ActualText is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}
   */
  @Test
  @DisplayName(
      "Test new PDStructureElement(String, PDStructureNode); given 'true'; then return Parent ActualText is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.<init>(String, PDStructureNode)"})
  void testNewPDStructureElement_givenTrue_thenReturnParentActualTextIsNull() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setDirect(true);

    // Act
    PDStructureElement actualPdStructureElement =
        new PDStructureElement(null, new PDStructureTreeRoot(dic));

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
    COSDictionary cOSObject = actualPdStructureElement.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(dic, parent.getCOSObject());
  }

  /**
   * Test {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return StandardStructureType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}
   */
  @Test
  @DisplayName(
      "Test new PDStructureElement(String, PDStructureNode); when 'null'; then return StandardStructureType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.<init>(String, PDStructureNode)"})
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
   *
   * <ul>
   *   <li>When {@code Structure Type}.
   *   <li>Then Parent return {@link PDStructureTreeRoot}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#PDStructureElement(String, PDStructureNode)}
   */
  @Test
  @DisplayName(
      "Test new PDStructureElement(String, PDStructureNode); when 'Structure Type'; then Parent return PDStructureTreeRoot")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.<init>(String, PDStructureNode)"})
  void testNewPDStructureElement_whenStructureType_thenParentReturnPDStructureTreeRoot() {
    // Arrange and Act
    PDStructureElement actualPdStructureElement =
        new PDStructureElement("Structure Type", new PDStructureTreeRoot());

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
    COSDictionary cOSObject = actualPdStructureElement.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(((PDStructureTreeRoot) parent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) parent).getRoleMap().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#getStructureType()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getStructureType()}
   */
  @Test
  @DisplayName("Test getStructureType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDStructureElement.getStructureType()"})
  void testGetStructureType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStructureElement(new COSDictionary()).getStructureType());
  }

  /**
   * Test {@link PDStructureElement#getStructureType()}.
   *
   * <ul>
   *   <li>Then return {@code Structure Type}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getStructureType()}
   */
  @Test
  @DisplayName("Test getStructureType(); then return 'Structure Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDStructureElement.getStructureType()"})
  void testGetStructureType_thenReturnStructureType() {
    // Arrange
    PDStructureElement pdStructureElement =
        new PDStructureElement("Structure Type", new PDStructureTreeRoot());

    // Act and Assert
    assertEquals("Structure Type", pdStructureElement.getStructureType());
  }

  /**
   * Test {@link PDStructureElement#setStructureType(String)}.
   *
   * <p>Method under test: {@link PDStructureElement#setStructureType(String)}
   */
  @Test
  @DisplayName("Test setStructureType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setStructureType(String)"})
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
   *
   * <p>Method under test: {@link PDStructureElement#setStructureType(String)}
   */
  @Test
  @DisplayName("Test setStructureType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setStructureType(String)"})
  void testSetStructureType2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setStructureType(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#setStructureType(String)}.
   *
   * <p>Method under test: {@link PDStructureElement#setStructureType(String)}
   */
  @Test
  @DisplayName("Test setStructureType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setStructureType(String)"})
  void testSetStructureType3() {
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
   *
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getParent()}
   */
  @Test
  @DisplayName(
      "Test getParent(); given PDStructureElement(COSDictionary) with dic is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStructureNode PDStructureElement.getParent()"})
  void testGetParent_givenPDStructureElementWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStructureElement(new COSDictionary()).getParent());
  }

  /**
   * Test {@link PDStructureElement#getParent()}.
   *
   * <ul>
   *   <li>Then return ActualText is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getParent()}
   */
  @Test
  @DisplayName("Test getParent(); then return ActualText is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStructureNode PDStructureElement.getParent()"})
  void testGetParent_thenReturnActualTextIsNull() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    PDStructureElement pdStructureElement =
        new PDStructureElement("Structure Type", new PDStructureTreeRoot(dic));

    // Act
    PDStructureNode actualParent = pdStructureElement.getParent();

    // Assert
    assertTrue(actualParent instanceof PDStructureElement);
    assertNull(((PDStructureElement) actualParent).getActualText());
    assertNull(((PDStructureElement) actualParent).getAlternateDescription());
    assertNull(((PDStructureElement) actualParent).getElementIdentifier());
    assertNull(((PDStructureElement) actualParent).getExpandedForm());
    assertNull(((PDStructureElement) actualParent).getLanguage());
    assertNull(((PDStructureElement) actualParent).getStandardStructureType());
    assertNull(((PDStructureElement) actualParent).getStructureType());
    assertNull(((PDStructureElement) actualParent).getTitle());
    assertNull(actualParent.getType());
    assertNull(((PDStructureElement) actualParent).getPage());
    assertEquals(0, ((PDStructureElement) actualParent).getRevisionNumber());
    assertSame(dic, actualParent.getCOSObject());
  }

  /**
   * Test {@link PDStructureElement#getParent()}.
   *
   * <ul>
   *   <li>Then return COSObject Key is {@link COSObjectKey#COSObjectKey(long, int)} with num is one
   *       and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getParent()}
   */
  @Test
  @DisplayName(
      "Test getParent(); then return COSObject Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStructureNode PDStructureElement.getParent()"})
  void testGetParent_thenReturnCOSObjectKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    dic.setKey(key);
    PDStructureElement pdStructureElement =
        new PDStructureElement("Structure Type", new PDStructureTreeRoot(dic));

    // Act
    PDStructureNode actualParent = pdStructureElement.getParent();

    // Assert
    assertTrue(actualParent instanceof PDStructureElement);
    assertSame(key, actualParent.getCOSObject().getKey());
  }

  /**
   * Test {@link PDStructureElement#getParent()}.
   *
   * <ul>
   *   <li>Then return {@link PDStructureTreeRoot}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getParent()}
   */
  @Test
  @DisplayName("Test getParent(); then return PDStructureTreeRoot")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStructureNode PDStructureElement.getParent()"})
  void testGetParent_thenReturnPDStructureTreeRoot() {
    // Arrange
    PDStructureElement pdStructureElement =
        new PDStructureElement("Structure Type", new PDStructureTreeRoot());

    // Act
    PDStructureNode actualParent = pdStructureElement.getParent();

    // Assert
    assertTrue(actualParent instanceof PDStructureTreeRoot);
    assertEquals("StructTreeRoot", actualParent.getType());
    assertNull(((PDStructureTreeRoot) actualParent).getK());
    assertNull(((PDStructureTreeRoot) actualParent).getIDTree());
    assertNull(((PDStructureTreeRoot) actualParent).getParentTree());
    assertEquals(-1, ((PDStructureTreeRoot) actualParent).getParentTreeNextKey());
    COSDictionary cOSObject = actualParent.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((PDStructureTreeRoot) actualParent).getClassMap().isEmpty());
    assertTrue(((PDStructureTreeRoot) actualParent).getRoleMap().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#setParent(PDStructureNode)}.
   *
   * <p>Method under test: {@link PDStructureElement#setParent(PDStructureNode)}
   */
  @Test
  @DisplayName("Test setParent(PDStructureNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setParent(PDStructureNode)"})
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
   *
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#setParent(PDStructureNode)}
   */
  @Test
  @DisplayName(
      "Test setParent(PDStructureNode); then PDStructureElement(COSDictionary) with dic is COSDictionary() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setParent(PDStructureNode)"})
  void testSetParent_thenPDStructureElementWithDicIsCOSDictionaryCOSObjectSizeIsZero() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setParent(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#getElementIdentifier()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getElementIdentifier()}
   */
  @Test
  @DisplayName("Test getElementIdentifier(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDStructureElement.getElementIdentifier()"})
  void testGetElementIdentifier_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStructureElement(new COSDictionary()).getElementIdentifier());
  }

  /**
   * Test {@link PDStructureElement#setElementIdentifier(String)}.
   *
   * <p>Method under test: {@link PDStructureElement#setElementIdentifier(String)}
   */
  @Test
  @DisplayName("Test setElementIdentifier(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setElementIdentifier(String)"})
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
   * Test {@link PDStructureElement#setElementIdentifier(String)}.
   *
   * <p>Method under test: {@link PDStructureElement#setElementIdentifier(String)}
   */
  @Test
  @DisplayName("Test setElementIdentifier(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setElementIdentifier(String)"})
  void testSetElementIdentifier2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setElementIdentifier(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#getPage()}.
   *
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getPage()}
   */
  @Test
  @DisplayName(
      "Test getPage(); given PDStructureElement(COSDictionary) with dic is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDStructureElement.getPage()"})
  void testGetPage_givenPDStructureElementWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStructureElement(new COSDictionary()).getPage());
  }

  /**
   * Test {@link PDStructureElement#setPage(PDPage)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()} Page is {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#setPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test setPage(PDPage); then PDStructureElement(COSDictionary) with dic is COSDictionary() Page is PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setPage(PDPage)"})
  void testSetPage_thenPDStructureElementWithDicIsCOSDictionaryPageIsPDPage() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    PDPage page = new PDPage();

    // Act
    pdStructureElement.setPage(page);

    // Assert
    assertEquals(page, pdStructureElement.getPage());
  }

  /**
   * Test {@link PDStructureElement#setPage(PDPage)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()} Page is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#setPage(PDPage)}
   */
  @Test
  @DisplayName(
      "Test setPage(PDPage); when 'null'; then PDStructureElement(COSDictionary) with dic is COSDictionary() Page is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setPage(PDPage)"})
  void testSetPage_whenNull_thenPDStructureElementWithDicIsCOSDictionaryPageIsNull() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setPage(null);

    // Assert that nothing has changed
    assertNull(pdStructureElement.getPage());
  }

  /**
   * Test {@link PDStructureElement#getAttributes()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  @DisplayName("Test getAttributes(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Revisions PDStructureElement.getAttributes()"})
  void testGetAttributes_thenReturnSizeIsOne() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act and Assert
    assertEquals(1, pdStructureElement.getAttributes().size());
  }

  /**
   * Test {@link PDStructureElement#getAttributes()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  @DisplayName("Test getAttributes(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Revisions PDStructureElement.getAttributes()"})
  void testGetAttributes_thenReturnSizeIsTwo() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    // Act and Assert
    assertEquals(2, pdStructureElement.getAttributes().size());
  }

  /**
   * Test {@link PDStructureElement#getAttributes()}.
   *
   * <ul>
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getAttributes()}
   */
  @Test
  @DisplayName("Test getAttributes(); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Revisions PDStructureElement.getAttributes()"})
  void testGetAttributes_thenReturnSizeIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDStructureElement(new COSDictionary()).getAttributes().size());
  }

  /**
   * Test {@link PDStructureElement#setAttributes(Revisions)}.
   *
   * <p>Method under test: {@link PDStructureElement#setAttributes(Revisions)}
   */
  @Test
  @DisplayName("Test setAttributes(Revisions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setAttributes(Revisions)"})
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
   *
   * <p>Method under test: {@link PDStructureElement#setAttributes(Revisions)}
   */
  @Test
  @DisplayName("Test setAttributes(Revisions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setAttributes(Revisions)"})
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
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#setAttributes(Revisions)}
   */
  @Test
  @DisplayName(
      "Test setAttributes(Revisions); given minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setAttributes(Revisions)"})
  void testSetAttributes_givenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    Revisions<PDAttributeObject> attributes = new Revisions<>();
    attributes.addObject(new PDDefaultAttributeObject(), -1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdStructureElement.setAttributes(attributes));
  }

  /**
   * Test {@link PDStructureElement#setAttributes(Revisions)}.
   *
   * <ul>
   *   <li>When {@link Revisions} (default constructor) addObject {@link
   *       PDDefaultAttributeObject#PDDefaultAttributeObject()} and ten.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#setAttributes(Revisions)}
   */
  @Test
  @DisplayName(
      "Test setAttributes(Revisions); when Revisions (default constructor) addObject PDDefaultAttributeObject() and ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setAttributes(Revisions)"})
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
   *
   * <p>Method under test: {@link PDStructureElement#addAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test addAttribute(PDAttributeObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.addAttribute(PDAttributeObject)"})
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
   *
   * <p>Method under test: {@link PDStructureElement#addAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test addAttribute(PDAttributeObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.addAttribute(PDAttributeObject)"})
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
   *
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()} Attributes size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#addAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName(
      "Test addAttribute(PDAttributeObject); then PDStructureElement(COSDictionary) with dic is COSDictionary() Attributes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.addAttribute(PDAttributeObject)"})
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
   *
   * <p>Method under test: {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeAttribute(PDAttributeObject)"})
  void testRemoveAttribute() {
    // Arrange
    PDStructureElement pdStructureElement =
        new PDStructureElement("Structure Type", new PDStructureTreeRoot());
    pdStructureElement.addAttribute(new PDDefaultAttributeObject());

    PDDefaultAttributeObject attributeObject = mock(PDDefaultAttributeObject.class);
    doNothing().when(attributeObject).setStructureElement(Mockito.<PDStructureElement>any());
    when(attributeObject.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdStructureElement.removeAttribute(attributeObject);

    // Assert
    verify(attributeObject).getCOSObject();
    verify(attributeObject).setStructureElement(isNull());
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getInt(int)} return one.
   *   <li>Then calls {@link COSArray#getInt(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName(
      "Test removeAttribute(PDAttributeObject); given COSArray getInt(int) return one; then calls getInt(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeAttribute(PDAttributeObject)"})
  void testRemoveAttribute_givenCOSArrayGetIntReturnOne_thenCallsGetInt() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getInt(anyInt())).thenReturn(1);
    when(cosArray.size()).thenReturn(2);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);

    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.removeAttribute(new PDDefaultAttributeObject());

    // Assert
    verify(cosArray).getInt(1);
    verify(cosArray).remove(isA(COSBase.class));
    verify(cosArray).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getInt(int)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName(
      "Test removeAttribute(PDAttributeObject); given COSArray getInt(int) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeAttribute(PDAttributeObject)"})
  void testRemoveAttribute_givenCOSArrayGetIntThrowIllegalArgumentException() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getInt(anyInt())).thenThrow(new IllegalArgumentException());
    when(cosArray.size()).thenReturn(2);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);

    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pdStructureElement.removeAttribute(new PDDefaultAttributeObject()));
    verify(cosArray).getInt(1);
    verify(cosArray).remove(isA(COSBase.class));
    verify(cosArray).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@code null}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName(
      "Test removeAttribute(PDAttributeObject); given COSArray getObject(int) return 'null'; then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeAttribute(PDAttributeObject)"})
  void testRemoveAttribute_givenCOSArrayGetObjectReturnNull_thenCallsGetObject() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getInt(anyInt())).thenReturn(0);
    when(cosArray.getObject(anyInt())).thenReturn(null);
    when(cosArray.size()).thenReturn(2);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);

    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.removeAttribute(new PDDefaultAttributeObject());

    // Assert
    verify(cosArray).getInt(1);
    verify(cosArray).getObject(0);
    verify(cosArray).remove(isA(COSBase.class));
    verify(cosArray).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(dic).setItem(isA(COSName.class), (COSBase) isNull());
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#remove(COSBase)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName(
      "Test removeAttribute(PDAttributeObject); given COSArray remove(COSBase) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeAttribute(PDAttributeObject)"})
  void testRemoveAttribute_givenCOSArrayRemoveThrowIllegalArgumentException() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.remove(Mockito.<COSBase>any())).thenThrow(new IllegalArgumentException());

    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pdStructureElement.removeAttribute(new PDDefaultAttributeObject()));
    verify(cosArray).remove(isA(COSBase.class));
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#size()} return three.
   *   <li>Then calls {@link COSArray#size()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName(
      "Test removeAttribute(PDAttributeObject); given COSArray size() return three; then calls size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeAttribute(PDAttributeObject)"})
  void testRemoveAttribute_givenCOSArraySizeReturnThree_thenCallsSize() {
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
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName(
      "Test removeAttribute(PDAttributeObject); given COSDictionary getDictionaryObject(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeAttribute(PDAttributeObject)"})
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
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName(
      "Test removeAttribute(PDAttributeObject); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeAttribute(PDAttributeObject)"})
  void testRemoveAttribute_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosObject);
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    // Act
    pdStructureElement.removeAttribute(new PDDefaultAttributeObject());

    // Assert
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE} Direct is {@code false}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName(
      "Test removeAttribute(PDAttributeObject); given FALSE Direct is 'false'; then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeAttribute(PDAttributeObject)"})
  void testRemoveAttribute_givenFalseDirectIsFalse_thenCallsGetObject() {
    // Arrange
    COSBoolean cosBoolean = COSBoolean.FALSE;
    cosBoolean.setDirect(false);

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getInt(anyInt())).thenReturn(0);
    when(cosArray.getObject(anyInt())).thenReturn(cosBoolean);
    when(cosArray.size()).thenReturn(2);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);

    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement pdStructureElement = new PDStructureElement(dic);

    PDDefaultAttributeObject attributeObject = mock(PDDefaultAttributeObject.class);
    doNothing().when(attributeObject).setStructureElement(Mockito.<PDStructureElement>any());
    when(attributeObject.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdStructureElement.removeAttribute(attributeObject);

    // Assert
    verify(cosArray).getInt(1);
    verify(cosArray).getObject(0);
    verify(cosArray).remove(isA(COSBase.class));
    verify(cosArray).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(dic).setItem(isA(COSName.class), isA(COSBase.class));
    verify(attributeObject).getCOSObject();
    verify(attributeObject).setStructureElement(isNull());
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test removeAttribute(PDAttributeObject); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeAttribute(PDAttributeObject)"})
  void testRemoveAttribute_givenIllegalArgumentException() {
    // Arrange
    PDStructureElement pdStructureElement =
        new PDStructureElement("Structure Type", new PDStructureTreeRoot());

    PDDefaultAttributeObject attributeObject = mock(PDDefaultAttributeObject.class);
    when(attributeObject.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdStructureElement.removeAttribute(attributeObject));
    verify(attributeObject).getCOSObject();
  }

  /**
   * Test {@link PDStructureElement#removeAttribute(PDAttributeObject)}.
   *
   * <ul>
   *   <li>Then calls {@link PDDefaultAttributeObject#setStructureElement(PDStructureElement)}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeAttribute(PDAttributeObject)}
   */
  @Test
  @DisplayName(
      "Test removeAttribute(PDAttributeObject); then calls setStructureElement(PDStructureElement)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeAttribute(PDAttributeObject)"})
  void testRemoveAttribute_thenCallsSetStructureElement() {
    // Arrange
    PDStructureElement pdStructureElement =
        new PDStructureElement("Structure Type", new PDStructureTreeRoot());

    PDDefaultAttributeObject attributeObject = mock(PDDefaultAttributeObject.class);
    doNothing().when(attributeObject).setStructureElement(Mockito.<PDStructureElement>any());
    when(attributeObject.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdStructureElement.removeAttribute(attributeObject);

    // Assert
    verify(attributeObject).getCOSObject();
    verify(attributeObject).setStructureElement(isNull());
  }

  /**
   * Test {@link PDStructureElement#attributeChanged(PDAttributeObject)}.
   *
   * <p>Method under test: {@link PDStructureElement#attributeChanged(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test attributeChanged(PDAttributeObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.attributeChanged(PDAttributeObject)"})
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
   *
   * <p>Method under test: {@link PDStructureElement#attributeChanged(PDAttributeObject)}
   */
  @Test
  @DisplayName("Test attributeChanged(PDAttributeObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.attributeChanged(PDAttributeObject)"})
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
   *
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#attributeChanged(PDAttributeObject)}
   */
  @Test
  @DisplayName(
      "Test attributeChanged(PDAttributeObject); given PDStructureElement(COSDictionary) with dic is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.attributeChanged(PDAttributeObject)"})
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
   * Test {@link PDStructureElement#getClassNames()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getClassNames()}
   */
  @Test
  @DisplayName("Test getClassNames(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Revisions PDStructureElement.getClassNames()"})
  void testGetClassNames_thenReturnSizeIsOne() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addClassName("Class Name");

    // Act and Assert
    assertEquals(1, pdStructureElement.getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#getClassNames()}.
   *
   * <ul>
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getClassNames()}
   */
  @Test
  @DisplayName("Test getClassNames(); then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Revisions PDStructureElement.getClassNames()"})
  void testGetClassNames_thenReturnSizeIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDStructureElement(new COSDictionary()).getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#setClassNames(Revisions)}.
   *
   * <p>Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  @DisplayName("Test setClassNames(Revisions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setClassNames(Revisions)"})
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
   *
   * <p>Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  @DisplayName("Test setClassNames(Revisions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setClassNames(Revisions)"})
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
   *
   * <p>Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  @DisplayName("Test setClassNames(Revisions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setClassNames(Revisions)"})
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
   *
   * <p>Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  @DisplayName("Test setClassNames(Revisions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setClassNames(Revisions)"})
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
   *
   * <p>Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  @DisplayName("Test setClassNames(Revisions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setClassNames(Revisions)"})
  void testSetClassNames5() {
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
   * Test {@link PDStructureElement#setClassNames(Revisions)}.
   *
   * <ul>
   *   <li>Given minus one hundred.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#setClassNames(Revisions)}
   */
  @Test
  @DisplayName(
      "Test setClassNames(Revisions); given minus one hundred; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setClassNames(Revisions)"})
  void testSetClassNames_givenMinusOneHundred_thenThrowIllegalArgumentException() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    Revisions<String> classNames = new Revisions<>();
    classNames.addObject("Object", -100);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdStructureElement.setClassNames(classNames));
  }

  /**
   * Test {@link PDStructureElement#addClassName(String)}.
   *
   * <p>Method under test: {@link PDStructureElement#addClassName(String)}
   */
  @Test
  @DisplayName("Test addClassName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.addClassName(String)"})
  void testAddClassName() {
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
   *
   * <p>Method under test: {@link PDStructureElement#addClassName(String)}
   */
  @Test
  @DisplayName("Test addClassName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.addClassName(String)"})
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
   *
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#addClassName(String)}
   */
  @Test
  @DisplayName(
      "Test addClassName(String); then PDStructureElement(COSDictionary) with dic is COSDictionary() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.addClassName(String)"})
  void testAddClassName_thenPDStructureElementWithDicIsCOSDictionaryCOSObjectSizeIsZero() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.addClassName(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertEquals(0, pdStructureElement.getClassNames().size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#addClassName(String)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()} ClassNames size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#addClassName(String)}
   */
  @Test
  @DisplayName(
      "Test addClassName(String); then PDStructureElement(COSDictionary) with dic is COSDictionary() ClassNames size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.addClassName(String)"})
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
   *
   * <p>Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  @DisplayName("Test removeClassName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeClassName(String)"})
  void testRemoveClassName() {
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
   *
   * <p>Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  @DisplayName("Test removeClassName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeClassName(String)"})
  void testRemoveClassName2() {
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
   *
   * <p>Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  @DisplayName("Test removeClassName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeClassName(String)"})
  void testRemoveClassName3() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.addClassName(PDStructureElement.TYPE);

    // Act
    pdStructureElement.removeClassName("Class Name");

    // Assert that nothing has changed
    assertEquals(1, pdStructureElement.getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#removeClassName(String)}.
   *
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  @DisplayName(
      "Test removeClassName(String); given PDStructureElement(COSDictionary) with dic is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeClassName(String)"})
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
   *
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeClassName(String)}
   */
  @Test
  @DisplayName(
      "Test removeClassName(String); given PDStructureElement(COSDictionary) with dic is COSDictionary(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeClassName(String)"})
  void testRemoveClassName_givenPDStructureElementWithDicIsCOSDictionary_whenNull() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.removeClassName(null);

    // Assert that nothing has changed
    assertEquals(0, pdStructureElement.getClassNames().size());
  }

  /**
   * Test {@link PDStructureElement#getRevisionNumber()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getRevisionNumber()}
   */
  @Test
  @DisplayName("Test getRevisionNumber(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDStructureElement.getRevisionNumber()"})
  void testGetRevisionNumber_thenReturnOne() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.incrementRevisionNumber();

    // Act and Assert
    assertEquals(1, pdStructureElement.getRevisionNumber());
  }

  /**
   * Test {@link PDStructureElement#getRevisionNumber()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getRevisionNumber()}
   */
  @Test
  @DisplayName("Test getRevisionNumber(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDStructureElement.getRevisionNumber()"})
  void testGetRevisionNumber_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDStructureElement(new COSDictionary()).getRevisionNumber());
  }

  /**
   * Test {@link PDStructureElement#setRevisionNumber(int)}.
   *
   * <p>Method under test: {@link PDStructureElement#setRevisionNumber(int)}
   */
  @Test
  @DisplayName("Test setRevisionNumber(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setRevisionNumber(int)"})
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
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#setRevisionNumber(int)}
   */
  @Test
  @DisplayName("Test setRevisionNumber(int); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setRevisionNumber(int)"})
  void testSetRevisionNumber_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDStructureElement(new COSDictionary()).setRevisionNumber(-1));
  }

  /**
   * Test {@link PDStructureElement#incrementRevisionNumber()}.
   *
   * <p>Method under test: {@link PDStructureElement#incrementRevisionNumber()}
   */
  @Test
  @DisplayName("Test incrementRevisionNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.incrementRevisionNumber()"})
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
   *
   * <p>Method under test: {@link PDStructureElement#incrementRevisionNumber()}
   */
  @Test
  @DisplayName("Test incrementRevisionNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.incrementRevisionNumber()"})
  void testIncrementRevisionNumber2() {
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
   *
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getTitle()}
   */
  @Test
  @DisplayName(
      "Test getTitle(); given PDStructureElement(COSDictionary) with dic is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDStructureElement.getTitle()"})
  void testGetTitle_givenPDStructureElementWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStructureElement(new COSDictionary()).getTitle());
  }

  /**
   * Test {@link PDStructureElement#setTitle(String)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#setTitle(String)}
   */
  @Test
  @DisplayName(
      "Test setTitle(String); then PDStructureElement(COSDictionary) with dic is COSDictionary() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setTitle(String)"})
  void testSetTitle_thenPDStructureElementWithDicIsCOSDictionaryCOSObjectSizeIsZero() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setTitle(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#setTitle(String)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()} Title is {@code Dr}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#setTitle(String)}
   */
  @Test
  @DisplayName(
      "Test setTitle(String); then PDStructureElement(COSDictionary) with dic is COSDictionary() Title is 'Dr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setTitle(String)"})
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
   *
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getLanguage()}
   */
  @Test
  @DisplayName(
      "Test getLanguage(); given PDStructureElement(COSDictionary) with dic is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDStructureElement.getLanguage()"})
  void testGetLanguage_givenPDStructureElementWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStructureElement(new COSDictionary()).getLanguage());
  }

  /**
   * Test {@link PDStructureElement#setLanguage(String)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#setLanguage(String)}
   */
  @Test
  @DisplayName(
      "Test setLanguage(String); then PDStructureElement(COSDictionary) with dic is COSDictionary() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setLanguage(String)"})
  void testSetLanguage_thenPDStructureElementWithDicIsCOSDictionaryCOSObjectSizeIsZero() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setLanguage(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#setLanguage(String)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()} Language is {@code en}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#setLanguage(String)}
   */
  @Test
  @DisplayName(
      "Test setLanguage(String); then PDStructureElement(COSDictionary) with dic is COSDictionary() Language is 'en'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setLanguage(String)"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getAlternateDescription()}
   */
  @Test
  @DisplayName("Test getAlternateDescription(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDStructureElement.getAlternateDescription()"})
  void testGetAlternateDescription_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStructureElement(new COSDictionary()).getAlternateDescription());
  }

  /**
   * Test {@link PDStructureElement#setAlternateDescription(String)}.
   *
   * <p>Method under test: {@link PDStructureElement#setAlternateDescription(String)}
   */
  @Test
  @DisplayName("Test setAlternateDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setAlternateDescription(String)"})
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
   * Test {@link PDStructureElement#setAlternateDescription(String)}.
   *
   * <p>Method under test: {@link PDStructureElement#setAlternateDescription(String)}
   */
  @Test
  @DisplayName("Test setAlternateDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setAlternateDescription(String)"})
  void testSetAlternateDescription2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setAlternateDescription(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#getExpandedForm()}.
   *
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getExpandedForm()}
   */
  @Test
  @DisplayName(
      "Test getExpandedForm(); given PDStructureElement(COSDictionary) with dic is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDStructureElement.getExpandedForm()"})
  void testGetExpandedForm_givenPDStructureElementWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStructureElement(new COSDictionary()).getExpandedForm());
  }

  /**
   * Test {@link PDStructureElement#setExpandedForm(String)}.
   *
   * <p>Method under test: {@link PDStructureElement#setExpandedForm(String)}
   */
  @Test
  @DisplayName("Test setExpandedForm(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setExpandedForm(String)"})
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
   * Test {@link PDStructureElement#setExpandedForm(String)}.
   *
   * <p>Method under test: {@link PDStructureElement#setExpandedForm(String)}
   */
  @Test
  @DisplayName("Test setExpandedForm(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setExpandedForm(String)"})
  void testSetExpandedForm2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setExpandedForm(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#getActualText()}.
   *
   * <ul>
   *   <li>Given {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getActualText()}
   */
  @Test
  @DisplayName(
      "Test getActualText(); given PDStructureElement(COSDictionary) with dic is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDStructureElement.getActualText()"})
  void testGetActualText_givenPDStructureElementWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStructureElement(new COSDictionary()).getActualText());
  }

  /**
   * Test {@link PDStructureElement#setActualText(String)}.
   *
   * <p>Method under test: {@link PDStructureElement#setActualText(String)}
   */
  @Test
  @DisplayName("Test setActualText(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setActualText(String)"})
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
   * Test {@link PDStructureElement#setActualText(String)}.
   *
   * <p>Method under test: {@link PDStructureElement#setActualText(String)}
   */
  @Test
  @DisplayName("Test setActualText(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.setActualText(String)"})
  void testSetActualText2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.setActualText(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#getStandardStructureType()}.
   *
   * <p>Method under test: {@link PDStructureElement#getStandardStructureType()}
   */
  @Test
  @DisplayName("Test getStandardStructureType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDStructureElement.getStandardStructureType()"})
  void testGetStandardStructureType() {
    // Arrange
    PDStructureElement pdStructureElement =
        new PDStructureElement("Structure Type", new PDStructureTreeRoot());

    // Act and Assert
    assertEquals("Structure Type", pdStructureElement.getStandardStructureType());
  }

  /**
   * Test {@link PDStructureElement#getStandardStructureType()}.
   *
   * <p>Method under test: {@link PDStructureElement#getStandardStructureType()}
   */
  @Test
  @DisplayName("Test getStandardStructureType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDStructureElement.getStandardStructureType()"})
  void testGetStandardStructureType2() {
    // Arrange
    PDStructureElement pdStructureElement =
        new PDStructureElement("Structure Type", new PDStructureElement(new COSDictionary()));

    // Act and Assert
    assertEquals("Structure Type", pdStructureElement.getStandardStructureType());
  }

  /**
   * Test {@link PDStructureElement#getStandardStructureType()}.
   *
   * <p>Method under test: {@link PDStructureElement#getStandardStructureType()}
   */
  @Test
  @DisplayName("Test getStandardStructureType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDStructureElement.getStandardStructureType()"})
  void testGetStandardStructureType3() {
    // Arrange
    PDStructureElement parent = new PDStructureElement("StructTreeRoot", new PDStructureTreeRoot());
    PDStructureElement pdStructureElement = new PDStructureElement("Structure Type", parent);

    // Act and Assert
    assertEquals("Structure Type", pdStructureElement.getStandardStructureType());
  }

  /**
   * Test {@link PDStructureElement#getStandardStructureType()}.
   *
   * <p>Method under test: {@link PDStructureElement#getStandardStructureType()}
   */
  @Test
  @DisplayName("Test getStandardStructureType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDStructureElement.getStandardStructureType()"})
  void testGetStandardStructureType4() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDStructureElement pdStructureElement =
        new PDStructureElement("Structure Type", new PDStructureElement(dic));

    // Act and Assert
    assertEquals("Structure Type", pdStructureElement.getStandardStructureType());
  }

  /**
   * Test {@link PDStructureElement#getStandardStructureType()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#getStandardStructureType()}
   */
  @Test
  @DisplayName("Test getStandardStructureType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDStructureElement.getStandardStructureType()"})
  void testGetStandardStructureType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStructureElement(new COSDictionary()).getStandardStructureType());
  }

  /**
   * Test {@link PDStructureElement#appendKid(PDMarkedContent)} with {@code markedContent}.
   *
   * <p>Method under test: {@link PDStructureElement#appendKid(PDMarkedContent)}
   */
  @Test
  @DisplayName("Test appendKid(PDMarkedContent) with 'markedContent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.appendKid(PDMarkedContent)"})
  void testAppendKidWithMarkedContent() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    PDMarkedContent markedContent = new PDMarkedContent(COSName.A, new COSDictionary());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdStructureElement.appendKid(markedContent));
  }

  /**
   * Test {@link PDStructureElement#appendKid(PDMarkedContentReference)} with {@code
   * markedContentReference}.
   *
   * <p>Method under test: {@link PDStructureElement#appendKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDMarkedContentReference) with 'markedContentReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.appendKid(PDMarkedContentReference)"})
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
   * Test {@link PDStructureElement#appendKid(PDMarkedContentReference)} with {@code
   * markedContentReference}.
   *
   * <p>Method under test: {@link PDStructureElement#appendKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDMarkedContentReference) with 'markedContentReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.appendKid(PDMarkedContentReference)"})
  void testAppendKidWithMarkedContentReference2() {
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
   * Test {@link PDStructureElement#appendKid(PDMarkedContentReference)} with {@code
   * markedContentReference}.
   *
   * <p>Method under test: {@link PDStructureElement#appendKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDMarkedContentReference) with 'markedContentReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.appendKid(PDMarkedContentReference)"})
  void testAppendKidWithMarkedContentReference3() {
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
   * Test {@link PDStructureElement#appendKid(PDMarkedContentReference)} with {@code
   * markedContentReference}.
   *
   * <p>Method under test: {@link PDStructureElement#appendKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDMarkedContentReference) with 'markedContentReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.appendKid(PDMarkedContentReference)"})
  void testAppendKidWithMarkedContentReference4() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.appendKid((PDMarkedContentReference) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#appendKid(PDMarkedContent)} with {@code markedContent}.
   *
   * <ul>
   *   <li>When {@link PDMarkedContent#PDMarkedContent(COSName, COSDictionary)} with tag is {@link
   *       COSName#A} and properties is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#appendKid(PDMarkedContent)}
   */
  @Test
  @DisplayName(
      "Test appendKid(PDMarkedContent) with 'markedContent'; when PDMarkedContent(COSName, COSDictionary) with tag is A and properties is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.appendKid(PDMarkedContent)"})
  void testAppendKidWithMarkedContent_whenPDMarkedContentWithTagIsAAndPropertiesIsNull() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    PDMarkedContent markedContent = new PDMarkedContent(COSName.A, null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdStructureElement.appendKid(markedContent));
  }

  /**
   * Test {@link PDStructureElement#appendKid(int)} with {@code mcid}.
   *
   * <p>Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  @DisplayName("Test appendKid(int) with 'mcid'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.appendKid(int)"})
  void testAppendKidWithMcid() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.appendKid(1);

    // Assert
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(3, kids.size());
    assertEquals(1, ((Integer) kids.get(2)).intValue());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#appendKid(int)} with {@code mcid}.
   *
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()} Kids size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  @DisplayName(
      "Test appendKid(int) with 'mcid'; then PDStructureElement(COSDictionary) with dic is COSDictionary() Kids size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.appendKid(int)"})
  void testAppendKidWithMcid_thenPDStructureElementWithDicIsCOSDictionaryKidsSizeIsOne() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.appendKid(1);

    // Assert
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    assertEquals(1, ((Integer) kids.get(0)).intValue());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#appendKid(int)} with {@code mcid}.
   *
   * <ul>
   *   <li>Then {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()} Kids size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  @DisplayName(
      "Test appendKid(int) with 'mcid'; then PDStructureElement(COSDictionary) with dic is COSDictionary() Kids size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.appendKid(int)"})
  void testAppendKidWithMcid_thenPDStructureElementWithDicIsCOSDictionaryKidsSizeIsTwo() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.appendKid(1);

    // Assert
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(2, kids.size());
    assertEquals(1, ((Integer) kids.get(1)).intValue());
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#appendKid(int)} with {@code mcid}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#appendKid(int)}
   */
  @Test
  @DisplayName(
      "Test appendKid(int) with 'mcid'; when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.appendKid(int)"})
  void testAppendKidWithMcid_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDStructureElement(new COSDictionary()).appendKid(-1));
  }

  /**
   * Test {@link PDStructureElement#appendKid(PDObjectReference)} with {@code objectReference}.
   *
   * <p>Method under test: {@link PDStructureElement#appendKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDObjectReference) with 'objectReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.appendKid(PDObjectReference)"})
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
   * Test {@link PDStructureElement#appendKid(PDObjectReference)} with {@code objectReference}.
   *
   * <p>Method under test: {@link PDStructureElement#appendKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDObjectReference) with 'objectReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.appendKid(PDObjectReference)"})
  void testAppendKidWithObjectReference2() {
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
   * Test {@link PDStructureElement#appendKid(PDObjectReference)} with {@code objectReference}.
   *
   * <p>Method under test: {@link PDStructureElement#appendKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDObjectReference) with 'objectReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.appendKid(PDObjectReference)"})
  void testAppendKidWithObjectReference3() {
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
   * Test {@link PDStructureElement#appendKid(PDObjectReference)} with {@code objectReference}.
   *
   * <p>Method under test: {@link PDStructureElement#appendKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test appendKid(PDObjectReference) with 'objectReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.appendKid(PDObjectReference)"})
  void testAppendKidWithObjectReference4() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.appendKid((PDObjectReference) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with {@code COSInteger},
   * {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(COSInteger, Object)"})
  void testInsertBeforeWithCOSIntegerObject() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with {@code COSInteger},
   * {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(COSInteger, Object)"})
  void testInsertBeforeWithCOSIntegerObject2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    assertEquals(1, ((Integer) kids.get(0)).intValue());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with {@code COSInteger},
   * {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(COSInteger, Object)"})
  void testInsertBeforeWithCOSIntegerObject3() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    assertTrue(kids.get(0) instanceof PDMarkedContentReference);
  }

  /**
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with {@code COSInteger},
   * {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(COSInteger, Object)"})
  void testInsertBeforeWithCOSIntegerObject4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    when(objectable.getCOSObject()).thenReturn(cosObject);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(COSInteger.ONE, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with {@code COSInteger},
   * {@code Object}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'; given COSObjectable getCOSObject() return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(COSInteger, Object)"})
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with {@code COSInteger},
   * {@code Object}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'; given COSObjectable getCOSObject() return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(COSInteger, Object)"})
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
   * Test {@link PDStructureElement#insertBefore(COSInteger, Object)} with {@code COSInteger},
   * {@code Object}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(COSInteger, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(COSInteger, Object) with 'COSInteger', 'Object'; given COSObjectable getCOSObject() return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(COSInteger, Object)"})
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
   * Test {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)} with {@code
   * PDMarkedContentReference}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDMarkedContentReference, Object)"})
  void testInsertBeforeWithPDMarkedContentReferenceObject() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)} with {@code
   * PDMarkedContentReference}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDMarkedContentReference, Object)"})
  void testInsertBeforeWithPDMarkedContentReferenceObject2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), "Ref Kid");

    // Assert that nothing has changed
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    assertEquals(1, ((Integer) kids.get(0)).intValue());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)} with {@code
   * PDMarkedContentReference}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDMarkedContentReference, Object)"})
  void testInsertBeforeWithPDMarkedContentReferenceObject3() {
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
   * Test {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)} with {@code
   * PDMarkedContentReference}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDMarkedContentReference, Object)"})
  void testInsertBeforeWithPDMarkedContentReferenceObject4() {
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
   * Test {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)} with {@code
   * PDMarkedContentReference}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDMarkedContentReference, Object)"})
  void testInsertBeforeWithPDMarkedContentReferenceObject5() {
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
   * Test {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)} with {@code
   * PDMarkedContentReference}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDMarkedContentReference, Object)"})
  void testInsertBeforeWithPDMarkedContentReferenceObject6() {
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
   * Test {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)} with {@code
   * PDMarkedContentReference}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDMarkedContentReference, Object)"})
  void testInsertBeforeWithPDMarkedContentReferenceObject7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    when(objectable.getCOSObject()).thenReturn(cosObject);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDMarkedContentReference(), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)} with {@code
   * PDMarkedContentReference}, {@code Object}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDMarkedContentReference, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(PDMarkedContentReference, Object) with 'PDMarkedContentReference', 'Object'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDMarkedContentReference, Object)"})
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with {@code
   * PDObjectReference}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDObjectReference, Object)"})
  void testInsertBeforeWithPDObjectReferenceObject() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with {@code
   * PDObjectReference}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDObjectReference, Object)"})
  void testInsertBeforeWithPDObjectReferenceObject2() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(1);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), "Ref Kid");

    // Assert that nothing has changed
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    assertEquals(1, ((Integer) kids.get(0)).intValue());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with {@code
   * PDObjectReference}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDObjectReference, Object)"})
  void testInsertBeforeWithPDObjectReferenceObject3() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with {@code
   * PDObjectReference}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDObjectReference, Object)"})
  void testInsertBeforeWithPDObjectReferenceObject4() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with {@code
   * PDObjectReference}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDObjectReference, Object)"})
  void testInsertBeforeWithPDObjectReferenceObject5() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with {@code
   * PDObjectReference}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDObjectReference, Object)"})
  void testInsertBeforeWithPDObjectReferenceObject6() {
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
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with {@code
   * PDObjectReference}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDObjectReference, Object)"})
  void testInsertBeforeWithPDObjectReferenceObject7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    when(objectable.getCOSObject()).thenReturn(cosObject);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.insertBefore(new PDObjectReference(), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureElement.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureElement#insertBefore(PDObjectReference, Object)} with {@code
   * PDObjectReference}, {@code Object}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#insertBefore(PDObjectReference, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(PDObjectReference, Object) with 'PDObjectReference', 'Object'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.insertBefore(PDObjectReference, Object)"})
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
   * Test {@link PDStructureElement#removeKid(COSInteger)} with {@code markedContentIdentifier}.
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(COSInteger)"})
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
   * Test {@link PDStructureElement#removeKid(COSInteger)} with {@code markedContentIdentifier}.
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(COSInteger)"})
  void testRemoveKidWithMarkedContentIdentifier2() {
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
   * Test {@link PDStructureElement#removeKid(COSInteger)} with {@code markedContentIdentifier}.
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(COSInteger)"})
  void testRemoveKidWithMarkedContentIdentifier3() {
    // Arrange
    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(new PDMarkedContentReference());

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    assertTrue(kids.get(0) instanceof PDMarkedContentReference);
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with {@code markedContentIdentifier}.
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(COSInteger)"})
  void testRemoveKidWithMarkedContentIdentifier4() {
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
   * Test {@link PDStructureElement#removeKid(COSInteger)} with {@code markedContentIdentifier}.
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(COSInteger)"})
  void testRemoveKidWithMarkedContentIdentifier5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendKid(2);
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdStructureElement.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    List<Object> kids = pdStructureElement.getKids();
    assertEquals(1, kids.size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Integer) kids.get(0)).intValue());
  }

  /**
   * Test {@link PDStructureElement#removeKid(COSInteger)} with {@code markedContentIdentifier}.
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(COSInteger)"})
  void testRemoveKidWithMarkedContentIdentifier6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSArray());

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
   * Test {@link PDStructureElement#removeKid(COSInteger)} with {@code markedContentIdentifier}.
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName("Test removeKid(COSInteger) with 'markedContentIdentifier'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(COSInteger)"})
  void testRemoveKidWithMarkedContentIdentifier7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    when(objectable.getCOSObject()).thenReturn(cosObject);

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
   * Test {@link PDStructureElement#removeKid(COSInteger)} with {@code markedContentIdentifier}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSInteger) with 'markedContentIdentifier'; given COSObjectable getCOSObject() return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(COSInteger)"})
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
   * Test {@link PDStructureElement#removeKid(COSInteger)} with {@code markedContentIdentifier}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(COSInteger)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSInteger) with 'markedContentIdentifier'; given COSObjectable getCOSObject() return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(COSInteger)"})
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with {@code
   * markedContentReference}.
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(PDMarkedContentReference)"})
  void testRemoveKidWithMarkedContentReference() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with {@code
   * markedContentReference}.
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(PDMarkedContentReference)"})
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
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with {@code
   * markedContentReference}.
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDMarkedContentReference) with 'markedContentReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(PDMarkedContentReference)"})
  void testRemoveKidWithMarkedContentReference3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    when(objectable.getCOSObject()).thenReturn(cosObject);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with {@code
   * markedContentReference}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName(
      "Test removeKid(PDMarkedContentReference) with 'markedContentReference'; given COSObjectable getCOSObject() return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(PDMarkedContentReference)"})
  void testRemoveKidWithMarkedContentReference_givenCOSObjectableGetCOSObjectReturnA() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with {@code
   * markedContentReference}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName(
      "Test removeKid(PDMarkedContentReference) with 'markedContentReference'; given COSObjectable getCOSObject() return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(PDMarkedContentReference)"})
  void testRemoveKidWithMarkedContentReference_givenCOSObjectableGetCOSObjectReturnOne() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSFloat.ONE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDMarkedContentReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Test {@link PDStructureElement#removeKid(PDMarkedContentReference)} with {@code
   * markedContentReference}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(PDMarkedContentReference)}
   */
  @Test
  @DisplayName(
      "Test removeKid(PDMarkedContentReference) with 'markedContentReference'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(PDMarkedContentReference)"})
  void testRemoveKidWithMarkedContentReference_whenNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid((PDMarkedContentReference) null);

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with {@code objectReference}.
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(PDObjectReference)"})
  void testRemoveKidWithObjectReference() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    when(objectable.getCOSObject()).thenReturn(cosObject);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with {@code objectReference}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName(
      "Test removeKid(PDObjectReference) with 'objectReference'; given COSObjectable getCOSObject() return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(PDObjectReference)"})
  void testRemoveKidWithObjectReference_givenCOSObjectableGetCOSObjectReturnA() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with {@code objectReference}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName(
      "Test removeKid(PDObjectReference) with 'objectReference'; given COSObjectable getCOSObject() return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(PDObjectReference)"})
  void testRemoveKidWithObjectReference_givenCOSObjectableGetCOSObjectReturnFalse() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with {@code objectReference}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName(
      "Test removeKid(PDObjectReference) with 'objectReference'; given COSObjectable getCOSObject() return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(PDObjectReference)"})
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
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with {@code objectReference}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName(
      "Test removeKid(PDObjectReference) with 'objectReference'; given COSObjectable getCOSObject() return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(PDObjectReference)"})
  void testRemoveKidWithObjectReference_givenCOSObjectableGetCOSObjectReturnOne() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSFloat.ONE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid(new PDObjectReference());

    // Assert
    verify(objectable).getCOSObject();
  }

  /**
   * Test {@link PDStructureElement#removeKid(PDObjectReference)} with {@code objectReference}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureElement#removeKid(PDObjectReference)}
   */
  @Test
  @DisplayName("Test removeKid(PDObjectReference) with 'objectReference'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureElement.removeKid(PDObjectReference)"})
  void testRemoveKidWithObjectReference_whenNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement pdStructureElement = new PDStructureElement(new COSDictionary());
    pdStructureElement.appendObjectableKid(objectable);

    // Act
    pdStructureElement.removeKid((PDObjectReference) null);

    // Assert
    verify(objectable).getCOSObject();
  }
}
