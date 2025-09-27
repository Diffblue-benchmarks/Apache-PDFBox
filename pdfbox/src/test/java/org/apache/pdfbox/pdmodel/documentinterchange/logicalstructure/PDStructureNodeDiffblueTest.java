package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDestinationNameTreeNode;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDStructureNodeDiffblueTest {
  /**
   * Test {@link PDStructureNode#create(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return {@link PDStructureElement}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#create(COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSDictionary); when COSDictionary(); then return PDStructureElement")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStructureNode PDStructureNode.create(COSDictionary)"})
  void testCreate_whenCOSDictionary_thenReturnPDStructureElement() {
    // Arrange
    COSDictionary node = new COSDictionary();

    // Act
    PDStructureNode actualCreateResult = PDStructureNode.create(node);

    // Assert
    assertTrue(actualCreateResult instanceof PDStructureElement);
    assertNull(((PDStructureElement) actualCreateResult).getActualText());
    assertNull(((PDStructureElement) actualCreateResult).getAlternateDescription());
    assertNull(((PDStructureElement) actualCreateResult).getElementIdentifier());
    assertNull(((PDStructureElement) actualCreateResult).getExpandedForm());
    assertNull(((PDStructureElement) actualCreateResult).getLanguage());
    assertNull(((PDStructureElement) actualCreateResult).getStandardStructureType());
    assertNull(((PDStructureElement) actualCreateResult).getStructureType());
    assertNull(((PDStructureElement) actualCreateResult).getTitle());
    assertNull(actualCreateResult.getType());
    assertNull(((PDStructureElement) actualCreateResult).getPage());
    assertNull(((PDStructureElement) actualCreateResult).getParent());
    assertEquals(0, ((PDStructureElement) actualCreateResult).getRevisionNumber());
    assertTrue(actualCreateResult.getKids().isEmpty());
    assertSame(node, actualCreateResult.getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#getCOSObject()}.
   *
   * <p>Method under test: {@link PDStructureNode#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDStructureNode.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDStructureTreeRoot().getCOSObject();

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
   * Test {@link PDStructureNode#getType()}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#getType()}
   */
  @Test
  @DisplayName(
      "Test getType(); given PDStructureTreeRoot(COSDictionary) with dic is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDStructureNode.getType()"})
  void testGetType_givenPDStructureTreeRootWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStructureTreeRoot(new COSDictionary()).getType());
  }

  /**
   * Test {@link PDStructureNode#getType()}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.
   *   <li>Then return {@code StructTreeRoot}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#getType()}
   */
  @Test
  @DisplayName("Test getType(); given PDStructureTreeRoot(); then return 'StructTreeRoot'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDStructureNode.getType()"})
  void testGetType_givenPDStructureTreeRoot_thenReturnStructTreeRoot() {
    // Arrange, Act and Assert
    assertEquals("StructTreeRoot", new PDStructureTreeRoot().getType());
  }

  /**
   * Test {@link PDStructureNode#getKids()}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); given PDStructureTreeRoot(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStructureNode.getKids()"})
  void testGetKids_givenPDStructureTreeRoot_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDStructureTreeRoot().getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#getKids()}.
   *
   * <ul>
   *   <li>Then first Parent K toList first return {@link COSBoolean}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); then first Parent K toList first return COSBoolean")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStructureNode.getKids()"})
  void testGetKids_thenFirstParentKToListFirstReturnCOSBoolean() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    List<Object> actualKids = pdStructureTreeRoot.getKids();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, actualKids.size());
    Object getResult = actualKids.get(0);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    COSBase k = ((PDStructureTreeRoot) parent).getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSBoolean);
    assertTrue(getResult instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertNull(getResult2.getKey());
    assertFalse(getResult2.isDirect());
    assertFalse(((COSBoolean) getResult2).getValue());
    assertFalse(((COSBoolean) getResult2).getValueAsObject());
    assertSame(dic, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#getKids()}.
   *
   * <ul>
   *   <li>Then return first Parent K toList first is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); then return first Parent K toList first is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStructureNode.getKids()"})
  void testGetKids_thenReturnFirstParentKToListFirstIsCOSDictionary() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    List<Object> actualKids = pdStructureTreeRoot.getKids();

    // Assert
    assertEquals(2, actualKids.size());
    Object getResult = actualKids.get(0);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    COSBase k = ((PDStructureTreeRoot) parent).getK();
    assertTrue(k instanceof COSArray);
    assertTrue(getResult instanceof PDStructureElement);
    Object getResult2 = actualKids.get(1);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    assertSame(dic, toListResult.get(0));
    assertSame(k, ((PDStructureTreeRoot) parent2).getK());
  }

  /**
   * Test {@link PDStructureNode#getKids()}.
   *
   * <ul>
   *   <li>Then return first StandardStructureType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); then return first StandardStructureType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStructureNode.getKids()"})
  void testGetKids_thenReturnFirstStandardStructureTypeIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    List<Object> actualKids = pdStructureTreeRoot.getKids();

    // Assert
    assertEquals(1, actualKids.size());
    Object getResult = actualKids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult).getType());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
  }

  /**
   * Test {@link PDStructureNode#getKids()}.
   *
   * <ul>
   *   <li>Then return first StandardStructureType is {@code Structure Type}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); then return first StandardStructureType is 'Structure Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStructureNode.getKids()"})
  void testGetKids_thenReturnFirstStandardStructureTypeIsStructureType() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    PDStructureElement structureElement =
        new PDStructureElement("Structure Type", new PDStructureTreeRoot());
    pdStructureTreeRoot.appendKid(structureElement);

    // Act
    List<Object> actualKids = pdStructureTreeRoot.getKids();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(1, actualKids.size());
    Object getResult = actualKids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertEquals("Structure Type", ((PDStructureElement) getResult).getStandardStructureType());
    assertEquals("Structure Type", ((PDStructureElement) getResult).getStructureType());
    COSDictionary cOSObject = ((PDStructureElement) getResult).getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDStructureElement.TYPE, ((PDStructureElement) getResult).getType());
  }

  /**
   * Test {@link PDStructureNode#getKids()}.
   *
   * <ul>
   *   <li>Then second Parent K return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); then second Parent K return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStructureNode.getKids()"})
  void testGetKids_thenSecondParentKReturnCOSArray() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    List<Object> actualKids = pdStructureTreeRoot.getKids();

    // Assert
    verify(objectable).getCOSObject();
    assertEquals(2, actualKids.size());
    Object getResult = actualKids.get(1);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    COSBase k = ((PDStructureTreeRoot) parent).getK();
    assertTrue(k instanceof COSArray);
    assertTrue(getResult instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    COSDictionary cOSObject = parent.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(1, ((Integer) actualKids.get(0)).intValue());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((COSArray) k).toList().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSDictionary dic = new COSDictionary(new COSDictionary());
    dic.setDirect(false);
    dic.setKey(null);
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode(dic);

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids2 = pdStructureTreeRoot.getKids();
    assertEquals(1, kids2.size());
    Object getResult = kids2.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    assertSame(dic, toListResult.get(0));
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first toHexString is
   *       {@code 3432}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); given '42'; then PDStructureTreeRoot() K toList first toHexString is '3432'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_given42_thenPDStructureTreeRootKToListFirstToHexStringIs3432() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add("42");
    kids.add(2);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    assertEquals("3432", ((COSString) getResult).toHexString());
    assertEquals("42", ((COSString) getResult).getASCII());
    assertEquals("42", ((COSString) getResult).getString());
    assertArrayEquals(new byte[] {'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first is {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); given COSArray(); then PDStructureTreeRoot() K toList first is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_givenCOSArray_thenPDStructureTreeRootKToListFirstIsCOSArray() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    COSArray cosArray = new COSArray();
    kids.add(cosArray);
    kids.add(2);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    List<Object> kids2 = pdStructureTreeRoot.getKids();
    assertEquals(1, kids2.size());
    assertEquals(2, ((Integer) kids2.get(0)).intValue());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertSame(cosArray, toListResult.get(0));
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); given COSDictionary(); then PDStructureTreeRoot() Kids size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_givenCOSDictionary_thenPDStructureTreeRootKidsSizeIsTwo() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    COSDictionary cosDictionary = new COSDictionary();
    kids.add(cosDictionary);
    kids.add(2);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids2 = pdStructureTreeRoot.getKids();
    assertEquals(2, kids2.size());
    Object getResult = kids2.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertEquals(2, ((Integer) kids2.get(1)).intValue());
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    assertSame(cosDictionary, toListResult.get(0));
    assertSame(cosDictionary, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setDirect(false);
    cosArray.setKey(new COSObjectKey(1L, 1));
    COSArrayList<Object> kids = new COSArrayList<>(new ArrayList<>(), cosArray);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((COSArray) k).toList().isEmpty());
    assertSame(cosArray, k);
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given {@code Kids}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first toHexString is
   *       {@code 4B696473}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); given 'Kids'; then PDStructureTreeRoot() K toList first toHexString is '4B696473'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_givenKids_thenPDStructureTreeRootKToListFirstToHexStringIs4b696473()
      throws UnsupportedEncodingException {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add("Kids");

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    assertEquals("4B696473", ((COSString) getResult).toHexString());
    assertEquals("Kids", ((COSString) getResult).getASCII());
    assertEquals("Kids", ((COSString) getResult).getString());
    assertArrayEquals("Kids".getBytes("UTF-8"), ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first {@link COSFloat}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given ten; then PDStructureTreeRoot() K toList first COSFloat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_givenTen_thenPDStructureTreeRootKToListFirstCOSFloat() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(10.0d);
    kids.add(2);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    List<Object> kids2 = pdStructureTreeRoot.getKids();
    assertEquals(1, kids2.size());
    assertEquals(2, ((Integer) kids2.get(0)).intValue());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first {@link COSFloat}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given ten; then PDStructureTreeRoot() K toList first COSFloat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_givenTen_thenPDStructureTreeRootKToListFirstCOSFloat2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(10.0f);
    kids.add(2);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    List<Object> kids2 = pdStructureTreeRoot.getKids();
    assertEquals(1, kids2.size());
    assertEquals(2, ((Integer) kids2.get(0)).intValue());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); given two; when ArrayList() add two; then PDStructureTreeRoot() Kids is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_givenTwo_whenArrayListAddTwo_thenPDStructureTreeRootKidsIsArrayList() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(2);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(kids, pdStructureTreeRoot.getKids());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then PDStructureTreeRoot() K is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_thenPDStructureTreeRootKIsCOSArray() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    ArrayList<Object> actualList = new ArrayList<>();
    COSArray cosArray = new COSArray();

    COSArrayList<Object> kids = new COSArrayList<>(actualList, cosArray);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((COSArray) k).toList().isEmpty());
    assertSame(cosArray, k);
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first {@link COSObject}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then PDStructureTreeRoot() K toList first COSObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_thenPDStructureTreeRootKToListFirstCOSObject() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSDictionary dic = new COSDictionary(new COSDictionary());
    dic.setDirect(false);
    COSObjectKey key = new COSObjectKey(1L, 1);
    dic.setKey(key);
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode(dic);

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(pdDestinationNameTreeNode);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSObject);
    COSUpdateState updateState = ((COSObject) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = ((COSObject) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(((COSObject) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertSame(dic, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first intValue is minus one
   *       hundred.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); then PDStructureTreeRoot() Kids first intValue is minus one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_thenPDStructureTreeRootKidsFirstIntValueIsMinusOneHundred() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(-100L);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    List<Object> kids2 = pdStructureTreeRoot.getKids();
    assertEquals(1, kids2.size());
    assertEquals(-100, ((Integer) kids2.get(0)).intValue());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first intValue is minus one
   *       hundred one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); then PDStructureTreeRoot() Kids first intValue is minus one hundred one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_thenPDStructureTreeRootKidsFirstIntValueIsMinusOneHundredOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(-101L);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    List<Object> kids2 = pdStructureTreeRoot.getKids();
    assertEquals(1, kids2.size());
    assertEquals(-101, ((Integer) kids2.get(0)).intValue());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first intValue is two hundred
   *       fifty-seven.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); then PDStructureTreeRoot() Kids first intValue is two hundred fifty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_thenPDStructureTreeRootKidsFirstIntValueIsTwoHundredFiftySeven() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(257L);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    List<Object> kids2 = pdStructureTreeRoot.getKids();
    assertEquals(1, kids2.size());
    assertEquals(257, ((Integer) kids2.get(0)).intValue());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first intValue is two hundred
   *       fifty-six.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); then PDStructureTreeRoot() Kids first intValue is two hundred fifty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_thenPDStructureTreeRootKidsFirstIntValueIsTwoHundredFiftySix() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(256L);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    List<Object> kids2 = pdStructureTreeRoot.getKids();
    assertEquals(1, kids2.size());
    assertEquals(256, ((Integer) kids2.get(0)).intValue());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first {@link COSNull}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); when ArrayList() add 'null'; then PDStructureTreeRoot() K toList first COSNull")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_whenArrayListAddNull_thenPDStructureTreeRootKToListFirstCOSNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(null);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSNull);
    assertNull(getResult.getKey());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); when ArrayList(); then PDStructureTreeRoot() Kids Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_whenArrayList_thenPDStructureTreeRootKidsEmpty() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setKids(new ArrayList<>());

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((COSArray) k).toList().isEmpty());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray(List)} with cosObjectables is {@link ArrayList#ArrayList()}
   *       Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); when COSArray(List) with cosObjectables is ArrayList() Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_whenCOSArrayWithCosObjectablesIsArrayListKeyIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setDirect(false);
    cosArray.setKey(null);
    COSArrayList<Object> kids = new COSArrayList<>(new ArrayList<>(), cosArray);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((COSArray) k).toList().isEmpty());
    assertSame(cosArray, k);
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName(
      "Test setKids(List); when 'null'; then PDStructureTreeRoot() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_whenNull_thenPDStructureTreeRootCOSObjectValuesSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.setKids(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test appendKid(COSBase) with 'object'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendKid(COSBase)"})
  void testAppendKidWithObject_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSDictionary object = new COSDictionary();
    object.setKey(new COSObjectKey(1L, 1));

    // Act
    pdStructureTreeRoot.appendKid(object);

    // Assert
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult).getParent());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertSame(object, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test appendKid(COSBase) with 'object'; then PDStructureTreeRoot() K toList size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendKid(COSBase)"})
  void testAppendKidWithObject_thenPDStructureTreeRootKToListSizeIsThree() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.appendKid(COSBoolean.FALSE);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertSame(COSBoolean.FALSE, toListResult.get(2));
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test appendKid(COSBase) with 'object'; then PDStructureTreeRoot() K toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendKid(COSBase)"})
  void testAppendKidWithObject_thenPDStructureTreeRootKToListSizeIsTwo() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.appendKid(COSBoolean.FALSE);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertSame(dic, getResult2);
    assertSame(getResult2, ((PDStructureElement) getResult).getCOSObject());
    assertSame(COSBoolean.FALSE, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName("Test appendKid(COSBase) with 'object'; when COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendKid(COSBase)"})
  void testAppendKidWithObject_whenCOSDictionary() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary object = new COSDictionary();

    // Act
    pdStructureTreeRoot.appendKid(object);

    // Assert
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult).getParent());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertSame(object, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test appendKid(COSBase) with 'object'; when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendKid(COSBase)"})
  void testAppendKidWithObject_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    pdStructureTreeRoot.appendKid(object);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test appendKid(COSBase) with 'object'; when FALSE; then PDStructureTreeRoot() K is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendKid(COSBase)"})
  void testAppendKidWithObject_whenFalse_thenPDStructureTreeRootKIsFalse() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.appendKid(COSBoolean.FALSE);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertSame(COSBoolean.FALSE, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test appendKid(COSBase) with 'object'; when 'null'; then PDStructureTreeRoot() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendKid(COSBase)"})
  void testAppendKidWithObject_whenNull_thenPDStructureTreeRootCOSObjectValuesSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.appendKid((COSBase) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#appendKid(PDStructureElement)} with {@code structureElement}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendKid(PDStructureElement)}
   */
  @Test
  @DisplayName(
      "Test appendKid(PDStructureElement) with 'structureElement'; given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendKid(PDStructureElement)"})
  void testAppendKidWithStructureElement_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    COSDictionary dic = new COSDictionary();
    dic.setDirect(true);
    PDStructureElement structureElement = new PDStructureElement(dic);

    // Act
    pdStructureTreeRoot.appendKid(structureElement);

    // Assert
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(3, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    assertTrue(kids.get(2) instanceof PDStructureElement);
    PDStructureNode parent = structureElement.getParent();
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertEquals(3, parent.getKids().size());
  }

  /**
   * Test {@link PDStructureNode#appendKid(PDStructureElement)} with {@code structureElement}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendKid(PDStructureElement)}
   */
  @Test
  @DisplayName(
      "Test appendKid(PDStructureElement) with 'structureElement'; then PDStructureTreeRoot() Kids size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendKid(PDStructureElement)"})
  void testAppendKidWithStructureElement_thenPDStructureTreeRootKidsSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    PDStructureElement structureElement = new PDStructureElement(dic);

    // Act
    pdStructureTreeRoot.appendKid(structureElement);

    // Assert
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    PDStructureNode parent = structureElement.getParent();
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertEquals(1, parent.getKids().size());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
  }

  /**
   * Test {@link PDStructureNode#appendKid(PDStructureElement)} with {@code structureElement}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendKid(PDStructureElement)}
   */
  @Test
  @DisplayName(
      "Test appendKid(PDStructureElement) with 'structureElement'; then PDStructureTreeRoot() Kids size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendKid(PDStructureElement)"})
  void testAppendKidWithStructureElement_thenPDStructureTreeRootKidsSizeIsOne2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDStructureElement structureElement = new PDStructureElement(dic);

    // Act
    pdStructureTreeRoot.appendKid(structureElement);

    // Assert
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    PDStructureNode parent = structureElement.getParent();
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertEquals(1, parent.getKids().size());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
  }

  /**
   * Test {@link PDStructureNode#appendKid(PDStructureElement)} with {@code structureElement}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendKid(PDStructureElement)}
   */
  @Test
  @DisplayName(
      "Test appendKid(PDStructureElement) with 'structureElement'; then PDStructureTreeRoot() Kids size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendKid(PDStructureElement)"})
  void testAppendKidWithStructureElement_thenPDStructureTreeRootKidsSizeIsThree() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureTreeRoot.appendKid(structureElement);

    // Assert
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(3, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    assertTrue(kids.get(2) instanceof PDStructureElement);
    PDStructureNode parent = structureElement.getParent();
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertEquals(3, parent.getKids().size());
  }

  /**
   * Test {@link PDStructureNode#appendKid(PDStructureElement)} with {@code structureElement}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendKid(PDStructureElement)}
   */
  @Test
  @DisplayName(
      "Test appendKid(PDStructureElement) with 'structureElement'; then PDStructureTreeRoot() Kids size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendKid(PDStructureElement)"})
  void testAppendKidWithStructureElement_thenPDStructureTreeRootKidsSizeIsTwo() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureTreeRoot.appendKid(structureElement);

    // Assert
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    assertTrue(kids.get(1) instanceof PDStructureElement);
    PDStructureNode parent = structureElement.getParent();
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertEquals(2, parent.getKids().size());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code
   * Object}.
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, "Ref Kid");

    // Assert that nothing has changed
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code
   * Object}.
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult2 = toListResult.get(2);
    assertSame(dic, getResult2);
    assertSame(getResult2, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code
   * Object}.
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(1);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(2, kids2.size());
    Object getResult2 = kids2.get(1);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult3 = toListResult.get(2);
    assertSame(getResult3, ((PDStructureElement) getResult).getCOSObject());
    assertSame(getResult3, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(COSBoolean.FALSE, toListResult.get(0));
    assertSame(COSInteger.ONE, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code
   * Object}.
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSInteger.THREE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, COSInteger.ONE);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(3, kids.size());
    Object getResult = kids.get(2);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(3, kids2.size());
    Object getResult2 = kids2.get(2);
    assertTrue(getResult2 instanceof PDStructureElement);
    PDStructureNode parent2 = ((PDStructureElement) getResult2).getParent();
    List<Object> kids3 = parent2.getKids();
    assertEquals(3, kids3.size());
    Object getResult3 = kids3.get(2);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertTrue(parent2 instanceof PDStructureTreeRoot);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code
   * Object}.
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    COSObject newKid = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    pdStructureTreeRoot.insertBefore(newKid, COSInteger.ONE);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(1);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(2, kids2.size());
    Object getResult2 = kids2.get(1);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(4, toListResult.size());
    assertSame(newKid, toListResult.get(1));
    COSBase getResult3 = toListResult.get(3);
    assertSame(getResult3, ((PDStructureElement) getResult).getCOSObject());
    assertSame(getResult3, ((PDStructureElement) getResult2).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code
   * Object}.
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject6() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSString.parseHex("0123456789ABCDEF"));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, COSInteger.ONE);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(1);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(2, kids2.size());
    Object getResult2 = kids2.get(1);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult3 = toListResult.get(3);
    assertSame(getResult3, ((PDStructureElement) getResult).getCOSObject());
    assertSame(getResult3, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(COSBoolean.FALSE, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code
   * Object}.
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(COSInteger.ONE, new COSObjectKey(1L, 1));
    when(objectable.getCOSObject()).thenReturn(cosObject);

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, COSInteger.ONE);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(4, toListResult.size());
    assertSame(cosObject, toListResult.get(2));
    assertSame(toListResult.get(3), ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; given COSObjectable getCOSObject() return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject_givenCOSObjectableGetCOSObjectReturnA() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSName.A);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, COSInteger.ONE);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(1);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(2, kids2.size());
    Object getResult2 = kids2.get(1);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult3 = toListResult.get(3);
    assertSame(getResult3, ((PDStructureElement) getResult).getCOSObject());
    assertSame(getResult3, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(COSBoolean.FALSE, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList second is {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; then PDStructureTreeRoot() K toList second is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject_thenPDStructureTreeRootKToListSecondIsCOSArray() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    COSArray newKid = new COSArray();

    // Act
    pdStructureTreeRoot.insertBefore(newKid, COSInteger.ONE);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(1);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(2, kids2.size());
    Object getResult2 = kids2.get(1);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(4, toListResult.size());
    assertSame(newKid, toListResult.get(1));
    COSBase getResult3 = toListResult.get(3);
    assertSame(getResult3, ((PDStructureElement) getResult).getCOSObject());
    assertSame(getResult3, ((PDStructureElement) getResult2).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList second is {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; then PDStructureTreeRoot() K toList second is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject_thenPDStructureTreeRootKToListSecondIsFalse() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, COSInteger.ONE);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(1);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(2, kids2.size());
    Object getResult2 = kids2.get(1);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult3 = toListResult.get(3);
    assertSame(getResult3, ((PDStructureElement) getResult).getCOSObject());
    assertSame(getResult3, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(COSBoolean.FALSE, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList third is {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; then PDStructureTreeRoot() K toList third is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject_thenPDStructureTreeRootKToListThirdIsFalse() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    assertTrue(kids.get(1) instanceof PDStructureElement);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(4, toListResult.size());
    assertSame(COSBoolean.FALSE, toListResult.get(2));
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; then PDStructureTreeRoot() Kids Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject_thenPDStructureTreeRootKidsEmpty() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids second intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; then PDStructureTreeRoot() Kids second intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject_thenPDStructureTreeRootKidsSecondIntValueIsOne() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.insertBefore(new COSDictionary(), COSInteger.ONE);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(3, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    assertTrue(kids.get(2) instanceof PDStructureElement);
    assertEquals(1, ((Integer) kids.get(1)).intValue());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code
   * Object}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; when 'null'; then PDStructureTreeRoot() Kids Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject_whenNull_thenPDStructureTreeRootKidsEmpty() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.insertBefore((COSBase) null, null);

    // Assert that nothing has changed
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code
   * Object}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; when 'null'; then PDStructureTreeRoot() Kids Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject_whenNull_thenPDStructureTreeRootKidsEmpty2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, null);

    // Assert that nothing has changed
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with {@code
   * PDStructureElement}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(PDStructureElement, Object)"})
  void testInsertBeforeWithPDStructureElementObject() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(new COSDictionary()), "Ref Kid");

    // Assert that nothing has changed
    assertEquals(1, pdStructureTreeRoot.getKids().size());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with {@code
   * PDStructureElement}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(PDStructureElement, Object)"})
  void testInsertBeforeWithPDStructureElementObject2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(null), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    assertEquals(1, pdStructureTreeRoot.getKids().size());
    assertEquals(2, ((COSArray) k).toList().size());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with {@code
   * PDStructureElement}, {@code Object}.
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(PDStructureElement, Object)"})
  void testInsertBeforeWithPDStructureElementObject3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(new COSDictionary()), COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    assertTrue(kids.get(1) instanceof PDStructureElement);
    assertEquals(3, ((COSArray) k).toList().size());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with {@code
   * PDStructureElement}, {@code Object}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'; then PDStructureTreeRoot() Kids Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(PDStructureElement, Object)"})
  void testInsertBeforeWithPDStructureElementObject_thenPDStructureTreeRootKidsEmpty() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(new COSDictionary()), "Ref Kid");

    // Assert that nothing has changed
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with {@code
   * PDStructureElement}, {@code Object}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(PDStructureElement, Object)"})
  void testInsertBeforeWithPDStructureElementObject_whenNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.insertBefore((PDStructureElement) null, null);

    // Assert that nothing has changed
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with {@code
   * PDStructureElement}, {@code Object}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertBefore(PDStructureElement, Object)"})
  void testInsertBeforeWithPDStructureElementObject_whenNull2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(new COSDictionary()), null);

    // Assert that nothing has changed
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; given COSDictionary() Direct is 'true'; when FALSE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_givenCOSDictionaryDirectIsTrue_whenFalse_thenReturnTrue() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setDirect(true);
    PDStructureElement structureElement = new PDStructureElement(dic);

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertTrue(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSName#A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return A; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_givenCOSObjectableGetCOSObjectReturnA_thenReturnTrue() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSName.A);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertTrue(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSName#AA}.
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return AA; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_givenCOSObjectableGetCOSObjectReturnAa_whenA() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.AA);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.removeKid(COSName.A);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertTrue(((PDStructureElement) getResult).getParent() instanceof PDStructureTreeRoot);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_givenCOSObjectableGetCOSObjectReturnCOSArray() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    dic.setKey(key);
    PDStructureElement structureElement = new PDStructureElement(dic);

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSArray());

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    // Act
    pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    COSIncrement toIncrementResult = ((COSDictionary) k).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(key, k.getKey());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSBoolean#FALSE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return FALSE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_givenCOSObjectableGetCOSObjectReturnFalse_thenReturnTrue() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertTrue(actualRemoveKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_givenCOSObjectableGetCOSObjectReturnNull() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    dic.setKey(key);
    PDStructureElement structureElement = new PDStructureElement(dic);

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(null);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    // Act
    pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, k);
    assertSame(key, k.getKey());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; given PDStructureTreeRoot(); then PDStructureTreeRoot() K is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_givenPDStructureTreeRoot_thenPDStructureTreeRootKIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert
    assertNull(pdStructureTreeRoot.getK());
    COSIncrement toIncrementResult = pdStructureTreeRoot.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualRemoveKidResult);
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>Then not {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toIncrement iterator
   *       hasNext.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; then not PDStructureTreeRoot() K toIncrement iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_thenNotPDStructureTreeRootKToIncrementIteratorHasNext() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    dic.setKey(key);
    PDStructureElement structureElement = new PDStructureElement(dic);

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    // Act
    pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    COSIncrement toIncrementResult = pdStructureTreeRoot.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = ((COSDictionary) k).toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertSame(key, k.getKey());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first ActualText is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; then PDStructureTreeRoot() Kids first ActualText is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_thenPDStructureTreeRootKidsFirstActualTextIsNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertTrue(((PDStructureElement) getResult).getParent() instanceof PDStructureTreeRoot);
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first intValue is three.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; then PDStructureTreeRoot() Kids first intValue is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_thenPDStructureTreeRootKidsFirstIntValueIsThree() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.THREE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    assertEquals(3, ((Integer) kids.get(0)).intValue());
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; when A; then PDStructureTreeRoot() K COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_whenA_thenPDStructureTreeRootKCOSArray() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.removeKid(COSName.A);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertTrue(((PDStructureElement) getResult).getParent() instanceof PDStructureTreeRoot);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSDictionary}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; when FALSE; then PDStructureTreeRoot() K COSDictionary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_whenFalse_thenPDStructureTreeRootKCOSDictionary() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert that nothing has changed
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, k);
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; when FALSE; then PDStructureTreeRoot() Kids size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_whenFalse_thenPDStructureTreeRootKidsSizeIsTwo() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.removeKid(COSBoolean.FALSE);

    // Assert that nothing has changed
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertTrue(((PDStructureElement) getResult).getParent() instanceof PDStructureTreeRoot);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; when 'null'; then PDStructureTreeRoot() K is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_whenNull_thenPDStructureTreeRootKIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid((COSBase) null);

    // Assert
    assertNull(pdStructureTreeRoot.getK());
    COSIncrement toIncrementResult = pdStructureTreeRoot.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualRemoveKidResult);
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>When {@link COSFloat#ONE}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; when ONE; then PDStructureTreeRoot() K COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_whenOne_thenPDStructureTreeRootKCOSArray() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.removeKid(COSFloat.ONE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertTrue(((PDStructureElement) getResult).getParent() instanceof PDStructureTreeRoot);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>When {@link COSInteger#ONE}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeKid(COSBase) with 'object'; when ONE; then PDStructureTreeRoot() K COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_whenOne_thenPDStructureTreeRootKCOSArray2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.removeKid(COSInteger.ONE);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertTrue(((PDStructureElement) getResult).getParent() instanceof PDStructureTreeRoot);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; when parseHex '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_whenParseHex0123456789abcdef() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.removeKid(COSString.parseHex("0123456789ABCDEF"));

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertTrue(((PDStructureElement) getResult).getParent() instanceof PDStructureTreeRoot);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    boolean actualRemoveKidResult =
        pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    boolean actualRemoveKidResult =
        pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    when(objectable.getCOSObject()).thenReturn(cosObject);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult =
        pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName(
      "Test removeKid(PDStructureElement) with 'structureElement'; given COSObjectable getCOSObject() return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement_givenCOSObjectableGetCOSObjectReturnA() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult =
        pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName(
      "Test removeKid(PDStructureElement) with 'structureElement'; given COSObjectable getCOSObject() return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement_givenCOSObjectableGetCOSObjectReturnFalse() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult =
        pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName(
      "Test removeKid(PDStructureElement) with 'structureElement'; given COSObjectable getCOSObject() return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement_givenCOSObjectableGetCOSObjectReturnOne() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult =
        pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName(
      "Test removeKid(PDStructureElement) with 'structureElement'; given PDStructureTreeRoot(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement_givenPDStructureTreeRoot_thenReturnFalse() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    boolean actualRemoveKidResult =
        pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName(
      "Test removeKid(PDStructureElement) with 'structureElement'; given PDStructureTreeRoot(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement_givenPDStructureTreeRoot_whenNull() {
    // Arrange, Act and Assert
    assertFalse(new PDStructureTreeRoot().removeKid((PDStructureElement) null));
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   *
   * <ul>
   *   <li>When {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName(
      "Test removeKid(PDStructureElement) with 'structureElement'; when PDStructureElement(COSDictionary) with dic is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement_whenPDStructureElementWithDicIsNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(null));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    dic.setKey(key);
    PDStructureElement structureElement = new PDStructureElement(dic);

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    COSIncrement toIncrementResult = pdStructureTreeRoot.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = ((COSDictionary) k).toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertSame(key, k.getKey());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSInteger.ONE);

    // Act
    pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertTrue(((PDStructureElement) getResult).getParent() instanceof PDStructureTreeRoot);
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test removeObjectableKid(COSObjectable); given A; when COSObjectable getCOSObject() return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenA_whenCOSObjectableGetCOSObjectReturnA() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSName.A);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertFalse(actualRemoveObjectableKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenCOSDictionaryDirectIsTrue() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setDirect(true);
    PDStructureElement structureElement = new PDStructureElement(dic);

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test removeObjectableKid(COSObjectable); given COSObjectable getCOSObject() return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenCOSObjectableGetCOSObjectReturnA() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSName.A);

    // Act
    pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSName#AA}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test removeObjectableKid(COSObjectable); given COSObjectable getCOSObject() return AA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenCOSObjectableGetCOSObjectReturnAa() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.AA);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSName.A);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertFalse(actualRemoveObjectableKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test removeObjectableKid(COSObjectable); given COSObjectable getCOSObject() return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenCOSObjectableGetCOSObjectReturnCOSArray() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    dic.setKey(key);
    PDStructureElement structureElement = new PDStructureElement(dic);

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSArray());

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    COSIncrement toIncrementResult = ((COSDictionary) k).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(key, k.getKey());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test removeObjectableKid(COSObjectable); given COSObjectable getCOSObject() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenCOSObjectableGetCOSObjectReturnNull() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    dic.setKey(key);
    PDStructureElement structureElement = new PDStructureElement(dic);

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(null);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(structureElement);

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    assertFalse(actualRemoveObjectableKidResult);
    assertSame(dic, k);
    assertSame(key, k.getKey());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test removeObjectableKid(COSObjectable); given FALSE; then PDStructureTreeRoot() K Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenFalse_thenPDStructureTreeRootKKeyIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    assertNull(k.getKey());
    assertFalse(actualRemoveObjectableKidResult);
    assertSame(dic, k);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test removeObjectableKid(COSObjectable); given FALSE; then PDStructureTreeRoot() Kids size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenFalse_thenPDStructureTreeRootKidsSizeIsTwo() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertFalse(actualRemoveObjectableKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test removeObjectableKid(COSObjectable); given ONE; when COSObjectable getCOSObject() return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenOne_whenCOSObjectableGetCOSObjectReturnOne() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSFloat.ONE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertFalse(actualRemoveObjectableKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test removeObjectableKid(COSObjectable); given ONE; when COSObjectable getCOSObject() return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenOne_whenCOSObjectableGetCOSObjectReturnOne2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSInteger.ONE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertFalse(actualRemoveObjectableKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()} appendKid {@link
   *       COSBoolean#FALSE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test removeObjectableKid(COSObjectable); given PDStructureTreeRoot() appendKid FALSE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenPDStructureTreeRootAppendKidFalse_thenReturnTrue() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(COSBoolean.FALSE);

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    assertNull(pdStructureTreeRoot.getK());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Given parseHex {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given parseHex '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenParseHex0123456789abcdef() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSString.parseHex("0123456789ABCDEF"));

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertFalse(actualRemoveObjectableKidResult);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test removeObjectableKid(COSObjectable); then PDStructureTreeRoot() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_thenPDStructureTreeRootCOSObjectValuesSizeIsTwo() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.THREE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSInteger.ONE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test removeObjectableKid(COSObjectable); then PDStructureTreeRoot() K is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_thenPDStructureTreeRootKIsCOSDictionary() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_thenThrowIllegalArgumentException() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdStructureTreeRoot.removeObjectableKid(objectable));
    verify(objectable).getCOSObject();
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test removeObjectableKid(COSObjectable); when 'null'; then PDStructureTreeRoot() K is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_whenNull_thenPDStructureTreeRootKIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(null);

    // Assert
    assertNull(pdStructureTreeRoot.getK());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>When {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode(COSDictionary)} with dic
   *       is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test removeObjectableKid(COSObjectable); when PDDestinationNameTreeNode(COSDictionary) with dic is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_whenPDDestinationNameTreeNodeWithDicIsCOSDictionary() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    boolean actualRemoveObjectableKidResult =
        pdStructureTreeRoot.removeObjectableKid(new PDDestinationNameTreeNode(new COSDictionary()));

    // Assert
    assertNull(pdStructureTreeRoot.getK());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>When {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode(COSDictionary)} with dic
   *       is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test removeObjectableKid(COSObjectable); when PDDestinationNameTreeNode(COSDictionary) with dic is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_whenPDDestinationNameTreeNodeWithDicIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    boolean actualRemoveObjectableKidResult =
        pdStructureTreeRoot.removeObjectableKid(new PDDestinationNameTreeNode(null));

    // Assert
    assertNull(pdStructureTreeRoot.getK());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   *
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()} appendKid {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName(
      "Test insertObjectableBefore(COSObjectable, Object); given PDStructureTreeRoot() appendKid FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_givenPDStructureTreeRootAppendKidFalse() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(COSBoolean.FALSE);

    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setDirect(false);
    cosArray.setKey(null);

    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(cosArray);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert
    verify(newKid).getCOSObject();
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName(
      "Test insertObjectableBefore(COSObjectable, Object); then PDStructureTreeRoot() Kids size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_thenPDStructureTreeRootKidsSizeIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setDirect(false);
    cosArray.setKey(null);

    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(cosArray);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(newKid).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName(
      "Test insertObjectableBefore(COSObjectable, Object); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_thenThrowIllegalArgumentException() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid"));
    verify(newKid).getCOSObject();
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName(
      "Test insertObjectableBefore(COSObjectable, Object); when FALSE; then PDStructureTreeRoot() K toList size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_whenFalse_thenPDStructureTreeRootKToListSizeIsThree() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setDirect(false);
    cosArray.setKey(null);

    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(cosArray);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, COSBoolean.FALSE);

    // Assert
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(k instanceof COSArray);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult3 = kids.get(0);
    assertTrue(getResult3 instanceof PDStructureElement);
    assertSame(cosArray, getResult);
    assertSame(dic, getResult2);
    assertSame(dic, ((PDStructureElement) getResult3).getCOSObject());
    assertSame(COSBoolean.FALSE, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#createObject(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return {@link PDStructureElement}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  @DisplayName("Test createObject(COSBase); when COSDictionary(); then return PDStructureElement")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDStructureNode.createObject(COSBase)"})
  void testCreateObject_whenCOSDictionary_thenReturnPDStructureElement() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary kid = new COSDictionary();

    // Act
    Object actualCreateObjectResult = pdStructureTreeRoot.createObject(kid);

    // Assert
    assertTrue(actualCreateObjectResult instanceof PDStructureElement);
    assertNull(((PDStructureElement) actualCreateObjectResult).getActualText());
    assertNull(((PDStructureElement) actualCreateObjectResult).getAlternateDescription());
    assertNull(((PDStructureElement) actualCreateObjectResult).getElementIdentifier());
    assertNull(((PDStructureElement) actualCreateObjectResult).getExpandedForm());
    assertNull(((PDStructureElement) actualCreateObjectResult).getLanguage());
    assertNull(((PDStructureElement) actualCreateObjectResult).getStandardStructureType());
    assertNull(((PDStructureElement) actualCreateObjectResult).getStructureType());
    assertNull(((PDStructureElement) actualCreateObjectResult).getTitle());
    assertNull(((PDStructureElement) actualCreateObjectResult).getType());
    assertNull(((PDStructureElement) actualCreateObjectResult).getPage());
    assertNull(((PDStructureElement) actualCreateObjectResult).getParent());
    assertEquals(0, ((PDStructureElement) actualCreateObjectResult).getRevisionNumber());
    assertTrue(((PDStructureElement) actualCreateObjectResult).getKids().isEmpty());
    assertSame(kid, ((PDStructureElement) actualCreateObjectResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#createObject(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  @DisplayName(
      "Test createObject(COSBase); when COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDStructureNode.createObject(COSBase)"})
  void testCreateObject_whenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSObject kid = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    Object actualCreateObjectResult = pdStructureTreeRoot.createObject(kid);

    // Assert
    assertNull(actualCreateObjectResult);
  }

  /**
   * Test {@link PDStructureNode#createObject(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  @DisplayName("Test createObject(COSBase); when FALSE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDStructureNode.createObject(COSBase)"})
  void testCreateObject_whenFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStructureTreeRoot().createObject(COSBoolean.FALSE));
  }

  /**
   * Test {@link PDStructureNode#createObject(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSInteger#ONE}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  @DisplayName("Test createObject(COSBase); when ONE; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDStructureNode.createObject(COSBase)"})
  void testCreateObject_whenOne_thenReturnIntValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, ((Integer) new PDStructureTreeRoot().createObject(COSInteger.ONE)).intValue());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   *
   * <p>Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSDictionary dic = new COSDictionary(new COSDictionary());
    dic.setDirect(false);
    dic.setKey(new COSObjectKey(1L, 1));

    // Act
    pdStructureTreeRoot.appendObjectableKid(new PDDestinationNameTreeNode(dic));

    // Assert
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSBoolean}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() K COSBoolean")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid_thenPDStructureTreeRootKCOSBoolean() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSBoolean cosBoolean = COSBoolean.FALSE;
    cosBoolean.setDirect(false);
    cosBoolean.setKey(null);

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(cosBoolean);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSBoolean);
    assertNull(k.getKey());
    assertFalse(k.isDirect());
    assertFalse(((COSBoolean) k).getValue());
    assertFalse(((COSBoolean) k).getValueAsObject());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() K toList size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid_thenPDStructureTreeRootKToListSizeIsThree() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    COSBoolean cosBoolean = COSBoolean.FALSE;
    cosBoolean.setDirect(false);
    cosBoolean.setKey(null);

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(cosBoolean);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSBoolean);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSBoolean) getResult).getValue());
    assertFalse(((COSBoolean) getResult).getValueAsObject());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() K toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid_thenPDStructureTreeRootKToListSizeIsTwo() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    COSBoolean cosBoolean = COSBoolean.FALSE;
    cosBoolean.setDirect(false);
    cosBoolean.setKey(null);

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(cosBoolean);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSBoolean);
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult2 = kids.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertSame(dic, getResult);
    assertSame(getResult, ((PDStructureElement) getResult2).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first ActualText is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() Kids first ActualText is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid_thenPDStructureTreeRootKidsFirstActualTextIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();

    // Act
    pdStructureTreeRoot.appendObjectableKid(new PDDestinationNameTreeNode(dic));

    // Assert
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    assertNull(((PDStructureElement) getResult).getActualText());
    assertNull(((PDStructureElement) getResult).getAlternateDescription());
    assertNull(((PDStructureElement) getResult).getElementIdentifier());
    assertNull(((PDStructureElement) getResult).getExpandedForm());
    assertNull(((PDStructureElement) getResult).getLanguage());
    assertNull(((PDStructureElement) getResult).getStandardStructureType());
    assertNull(((PDStructureElement) getResult).getStructureType());
    assertNull(((PDStructureElement) getResult).getTitle());
    assertNull(((PDStructureElement) getResult).getType());
    assertNull(((PDStructureElement) getResult).getPage());
    assertNull(((PDStructureElement) getResult).getParent());
    assertEquals(0, ((PDStructureElement) getResult).getRevisionNumber());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid_thenThrowIllegalArgumentException() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdStructureTreeRoot.appendObjectableKid(objectable));
    verify(objectable).getCOSObject();
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test appendObjectableKid(COSObjectable); when 'null'; then PDStructureTreeRoot() Kids Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid_whenNull_thenPDStructureTreeRootKidsEmpty() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.appendObjectableKid(null);

    // Assert that nothing has changed
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   *
   * <ul>
   *   <li>When {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode(COSDictionary)} with dic
   *       is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test appendObjectableKid(COSObjectable); when PDDestinationNameTreeNode(COSDictionary) with dic is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid_whenPDDestinationNameTreeNodeWithDicIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.appendObjectableKid(new PDDestinationNameTreeNode(null));

    // Assert that nothing has changed
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }
}
