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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
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
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDDictionaryWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDStructureNodeDiffblueTest {
  /**
   * Test {@link PDStructureNode#create(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@link PDStructureElement}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#create(COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSDictionary); when COSDictionary(); then return PDStructureElement")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDStructureNode#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDStructureNode.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDStructureTreeRoot()).getCOSObject();

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
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot(COSDictionary)} with dic is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#getType()}
   */
  @Test
  @DisplayName("Test getType(); given PDStructureTreeRoot(COSDictionary) with dic is COSDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDStructureNode.getType()"})
  void testGetType_givenPDStructureTreeRootWithDicIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureTreeRoot(new COSDictionary())).getType());
  }

  /**
   * Test {@link PDStructureNode#getType()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then return {@code StructTreeRoot}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#getType()}
   */
  @Test
  @DisplayName("Test getType(); given PDStructureTreeRoot(); then return 'StructTreeRoot'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDStructureNode.getType()"})
  void testGetType_givenPDStructureTreeRoot_thenReturnStructTreeRoot() {
    // Arrange, Act and Assert
    assertEquals("StructTreeRoot", (new PDStructureTreeRoot()).getType());
  }

  /**
   * Test {@link PDStructureNode#getKids()}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); given PDStructureTreeRoot(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDStructureNode.getKids()"})
  void testGetKids_givenPDStructureTreeRoot_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDStructureTreeRoot()).getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#getKids()}.
   * <ul>
   *   <li>Then return first Parent K toList first is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); then return first Parent K toList first is COSDictionary()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then return first StandardStructureType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); then return first StandardStructureType is 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then return first StandardStructureType is {@code Structure Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); then return first StandardStructureType is 'Structure Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDStructureNode.getKids()"})
  void testGetKids_thenReturnFirstStandardStructureTypeIsStructureType() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement("Structure Type", new PDStructureTreeRoot()));

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
   * <ul>
   *   <li>Then second Parent K return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#getKids()}
   */
  @Test
  @DisplayName("Test getKids(); then second Parent K return COSArray")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    kids.add(cosObject);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertSame(cosObject, toListResult.get(0));
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first toHexString is {@code 3432}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given '42'; then PDStructureTreeRoot() K toList first toHexString is '3432'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_given42_thenPDStructureTreeRootKToListFirstToHexStringIs3432() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add("42");

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    assertEquals("3432", ((COSString) getResult).toHexString());
    assertEquals("42", ((COSString) getResult).getASCII());
    assertEquals("42", ((COSString) getResult).getString());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given '42'; when ArrayList() add '42'; then PDStructureTreeRoot() K toList size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_given42_whenArrayListAdd42_thenPDStructureTreeRootKToListSizeIsTwo() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add("42");
    kids.add("42");

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSString);
    assertEquals(getResult, getResult2);
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given COSArray(); then PDStructureTreeRoot() K toList first is COSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_givenCOSArray_thenPDStructureTreeRootKToListFirstIsCOSArray() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    COSArray cosArray = new COSArray();
    kids.add(cosArray);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
    assertSame(cosArray, toListResult.get(0));
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link Long#MAX_VALUE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first intValue is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given MAX_VALUE; then PDStructureTreeRoot() Kids first intValue is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_givenMax_value_thenPDStructureTreeRootKidsFirstIntValueIsMinusOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(Long.MAX_VALUE);

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
    assertEquals(-1, ((Integer) kids2.get(0)).intValue());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link Integer#MIN_VALUE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given MIN_VALUE; when ArrayList() add MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_givenMin_value_whenArrayListAddMin_value() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(Integer.MIN_VALUE);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(kids, pdStructureTreeRoot.getKids());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given minus one hundred.</li>
   *   <li>When {@link ArrayList#ArrayList()} add minus one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given minus one hundred; when ArrayList() add minus one hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_givenMinusOneHundred_whenArrayListAddMinusOneHundred() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(-100);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
    assertEquals(kids, pdStructureTreeRoot.getKids());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given one; then PDStructureTreeRoot() Kids first intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_givenOne_thenPDStructureTreeRootKidsFirstIntValueIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(1L);

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
    assertEquals(1, ((Integer) kids2.get(0)).intValue());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given {@link PDDictionaryWrapper#PDDictionaryWrapper()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link PDDictionaryWrapper#PDDictionaryWrapper()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given PDDictionaryWrapper(); when ArrayList() add PDDictionaryWrapper()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_givenPDDictionaryWrapper_whenArrayListAddPDDictionaryWrapper() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(new PDDictionaryWrapper());

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids2 = pdStructureTreeRoot.getKids();
    assertEquals(1, kids2.size());
    Object getResult = kids2.get(0);
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
    assertEquals(1, ((COSArray) k).toList().size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first {@link COSFloat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given ten; then PDStructureTreeRoot() K toList first COSFloat")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_givenTen_thenPDStructureTreeRootKToListFirstCOSFloat() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(10.0d);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first {@link COSFloat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); given ten; then PDStructureTreeRoot() K toList first COSFloat")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_givenTen_thenPDStructureTreeRootKToListFirstCOSFloat2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    kids.add(10.0f);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); then PDStructureTreeRoot() K toList first is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_thenPDStructureTreeRootKToListFirstIsCOSDictionary() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    ArrayList<Object> kids = new ArrayList<>();
    COSDictionary cosDictionary = new COSDictionary();
    kids.add(cosDictionary);

    // Act
    pdStructureTreeRoot.setKids(kids);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids2 = pdStructureTreeRoot.getKids();
    assertEquals(1, kids2.size());
    Object getResult = kids2.get(0);
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
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(1, toListResult.size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertSame(cosDictionary, toListResult.get(0));
    assertSame(cosDictionary, ((PDStructureElement) getResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#setKids(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#setKids(List)}
   */
  @Test
  @DisplayName("Test setKids(List); when ArrayList(); then PDStructureTreeRoot() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.setKids(List)"})
  void testSetKids_whenArrayList_thenPDStructureTreeRootCOSObjectValuesSizeIsTwo() {
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
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName("Test appendKid(COSBase) with 'object'; then PDStructureTreeRoot() K toList size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.appendKid(COSBase)"})
  void testAppendKidWithObject_thenPDStructureTreeRootKToListSizeIsThree() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    COSBoolean object = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.appendKid(object);

    // Assert
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertSame(object.FALSE, toListResult.get(2));
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName("Test appendKid(COSBase) with 'object'; then PDStructureTreeRoot() K toList size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.appendKid(COSBase)"})
  void testAppendKidWithObject_thenPDStructureTreeRootKToListSizeIsTwo() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSBoolean object = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.appendKid(object);

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
    assertSame(object.FALSE, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first ActualText is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName("Test appendKid(COSBase) with 'object'; then PDStructureTreeRoot() Kids first ActualText is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.appendKid(COSBase)"})
  void testAppendKidWithObject_thenPDStructureTreeRootKidsFirstActualTextIsNull() {
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
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName("Test appendKid(COSBase) with 'object'; when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.appendKid(COSBase)"})
  void testAppendKidWithObject_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act
    pdStructureTreeRoot.appendKid(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is {@link COSBoolean#FALSE} {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName("Test appendKid(COSBase) with 'object'; when FALSE; then PDStructureTreeRoot() K is FALSE FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.appendKid(COSBase)"})
  void testAppendKidWithObject_whenFalse_thenPDStructureTreeRootKIsFalseFalse() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSBoolean object = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.appendKid(object);

    // Assert
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSBoolean expectedK = object.FALSE;
    assertSame(expectedK, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#appendKid(COSBase)} with {@code object}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(COSBase)}
   */
  @Test
  @DisplayName("Test appendKid(COSBase) with 'object'; when 'null'; then PDStructureTreeRoot() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test appendKid(PDStructureElement) with 'structureElement'; then PDStructureTreeRoot() Kids size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test appendKid(PDStructureElement) with 'structureElement'; then PDStructureTreeRoot() Kids size is three")
  @Tag("MaintainedByDiffblue")
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
    PDStructureNode parent = structureElement.getParent();
    assertTrue(((PDStructureTreeRoot) parent).getK() instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(3, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    assertTrue(kids.get(1) instanceof PDStructureElement);
    assertTrue(kids.get(2) instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertEquals(3, parent.getKids().size());
  }

  /**
   * Test {@link PDStructureNode#appendKid(PDStructureElement)} with {@code structureElement}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test appendKid(PDStructureElement) with 'structureElement'; then PDStructureTreeRoot() Kids size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.appendKid(PDStructureElement)"})
  void testAppendKidWithStructureElement_thenPDStructureTreeRootKidsSizeIsTwo() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());

    // Act
    pdStructureTreeRoot.appendKid(structureElement);

    // Assert
    PDStructureNode parent = structureElement.getParent();
    assertTrue(((PDStructureTreeRoot) parent).getK() instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    assertTrue(kids.get(1) instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertEquals(2, parent.getKids().size());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code Object}.
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSBoolean cosBoolean = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.insertBefore(COSBoolean.FALSE, cosBoolean);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(cosBoolean.FALSE, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code Object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first {@link COSBoolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; then PDStructureTreeRoot() K toList first COSBoolean")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject_thenPDStructureTreeRootKToListFirstCOSBoolean() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.insertBefore((COSBase) null, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    assertSame(dic, getResult);
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code Object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; then PDStructureTreeRoot() K toList first is COSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject_thenPDStructureTreeRootKToListFirstIsCOSArray() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSArray newKid = new COSArray();
    COSBoolean cosBoolean = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.insertBefore(newKid, cosBoolean);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    Object getResult = kids.get(0);
    assertTrue(getResult instanceof PDStructureElement);
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertSame(newKid, toListResult.get(0));
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(cosBoolean.FALSE, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code Object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; then PDStructureTreeRoot() K toList size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject_thenPDStructureTreeRootKToListSizeIsTwo() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSBoolean newKid = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.insertBefore(newKid, null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    assertSame(dic, getResult);
    assertSame(newKid.FALSE, toListResult.get(0));
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code Object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; then PDStructureTreeRoot() Kids size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject_thenPDStructureTreeRootKidsSizeIsOne() {
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
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    List<Object> kids2 = parent.getKids();
    assertEquals(1, kids2.size());
    Object getResult2 = kids2.get(0);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(COSBase, Object)} with {@code COSBase}, {@code Object}.
   * <ul>
   *   <li>When {@link COSInteger#ONE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(COSBase, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(COSBase, Object) with 'COSBase', 'Object'; when ONE; then PDStructureTreeRoot() Kids size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertBefore(COSBase, Object)"})
  void testInsertBeforeWithCOSBaseObject_whenOne_thenPDStructureTreeRootKidsSizeIsTwo() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSBoolean newKid = COSBoolean.FALSE;
    COSInteger cosInteger = COSInteger.ONE;

    // Act
    pdStructureTreeRoot.insertBefore(newKid, cosInteger);

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
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, ((PDStructureElement) getResult2).getCOSObject());
    assertSame(newKid.FALSE, toListResult.get(0));
    assertSame(cosInteger.ONE, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with {@code PDStructureElement}, {@code Object}.
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertBefore(PDStructureElement, Object)"})
  void testInsertBeforeWithPDStructureElementObject() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(new COSDictionary()), "Ref Kid");

    // Assert that nothing has changed
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with {@code PDStructureElement}, {@code Object}.
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertBefore(PDStructureElement, Object)"})
  void testInsertBeforeWithPDStructureElementObject2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSBoolean cosBoolean = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(new COSDictionary()), cosBoolean);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(2, kids.size());
    Object getResult = kids.get(1);
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
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertTrue(((PDStructureElement) getResult).getKids().isEmpty());
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(cosBoolean.FALSE, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with {@code PDStructureElement}, {@code Object}.
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertBefore(PDStructureElement, Object)"})
  void testInsertBeforeWithPDStructureElementObject3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(new COSDictionary()), COSInteger.ONE);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(3, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    assertTrue(kids.get(2) instanceof PDStructureElement);
    assertEquals(1, ((Integer) kids.get(1)).intValue());
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with {@code PDStructureElement}, {@code Object}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'; then PDStructureTreeRoot() Kids Empty")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with {@code PDStructureElement}, {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertBefore(PDStructureElement, Object)"})
  void testInsertBeforeWithPDStructureElementObject_whenNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.insertBefore((PDStructureElement) null, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    assertSame(dic, getResult);
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with {@code PDStructureElement}, {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertBefore(PDStructureElement, Object)"})
  void testInsertBeforeWithPDStructureElementObject_whenNull2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(new COSDictionary()), null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    assertSame(dic, getResult);
  }

  /**
   * Test {@link PDStructureNode#insertBefore(PDStructureElement, Object)} with {@code PDStructureElement}, {@code Object}.
   * <ul>
   *   <li>When {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertBefore(PDStructureElement, Object)}
   */
  @Test
  @DisplayName("Test insertBefore(PDStructureElement, Object) with 'PDStructureElement', 'Object'; when PDStructureElement(COSDictionary) with dic is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertBefore(PDStructureElement, Object)"})
  void testInsertBeforeWithPDStructureElementObject_whenPDStructureElementWithDicIsNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.insertBefore(new PDStructureElement(null), "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    assertSame(dic, getResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(COSBase)} with {@code object}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject() {
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
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; given COSDictionary() Direct is 'true'; when FALSE; then return 'true'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link COSName#A}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return A; then return 'true'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link COSName#AA}.</li>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return AA; when A")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return COSArray()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link COSBoolean#FALSE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return FALSE; then return 'true'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; given COSObjectable getCOSObject() return 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; given PDStructureTreeRoot(); then PDStructureTreeRoot() K is 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first ActualText is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; then PDStructureTreeRoot() Kids first ActualText is 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids first intValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; then PDStructureTreeRoot() Kids first intValue is three")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; when A; then PDStructureTreeRoot() K COSArray")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; when FALSE; then PDStructureTreeRoot() K COSDictionary")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; when FALSE; then PDStructureTreeRoot() Kids size is two")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; when 'null'; then PDStructureTreeRoot() K COSArray")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(COSBase)"})
  void testRemoveKidWithObject_whenNull_thenPDStructureTreeRootKCOSArray() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));

    // Act
    pdStructureTreeRoot.removeKid((COSBase) null);

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
   * <ul>
   *   <li>When {@link COSFloat#ONE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; when ONE; then PDStructureTreeRoot() K COSArray")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link COSInteger#ONE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; when ONE; then PDStructureTreeRoot() K COSArray")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(COSBase)}
   */
  @Test
  @DisplayName("Test removeKid(COSBase) with 'object'; when parseHex '0123456789ABCDEF'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act and Assert
    assertFalse(pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary())));
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement2() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    // Act and Assert
    assertFalse(pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary())));
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement4() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSString.parseHex("0123456789ABCDEF"));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement5() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement6() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement7() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement8() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSInteger.ONE, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement9() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSName.A, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement10() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement11() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSInteger.ONE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement12() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSName.A, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'; given COSObjectable getCOSObject() return A")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement_givenCOSObjectableGetCOSObjectReturnA() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'; given COSObjectable getCOSObject() return FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement_givenCOSObjectableGetCOSObjectReturnFalse() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'; given COSObjectable getCOSObject() return ONE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement_givenCOSObjectableGetCOSObjectReturnOne() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary()));

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'; given PDStructureTreeRoot(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement_givenPDStructureTreeRoot_thenReturnFalse() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act and Assert
    assertFalse(pdStructureTreeRoot.removeKid(new PDStructureElement(new COSDictionary())));
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeKid(PDStructureElement)"})
  void testRemoveKidWithStructureElement_whenNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Act
    boolean actualRemoveKidResult = pdStructureTreeRoot.removeKid((PDStructureElement) null);

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualRemoveKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeKid(PDStructureElement)} with {@code structureElement}.
   * <ul>
   *   <li>When {@link PDStructureElement#PDStructureElement(COSDictionary)} with dic is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeKid(PDStructureElement)}
   */
  @Test
  @DisplayName("Test removeKid(PDStructureElement) with 'structureElement'; when PDStructureElement(COSDictionary) with dic is 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSName#A}.</li>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given A; when COSObjectable getCOSObject() return A")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenA_whenCOSObjectableGetCOSObjectReturnA() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSName.A);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given COSObjectable getCOSObject() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenCOSObjectableGetCOSObjectReturnNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(null);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    assertNull(pdStructureTreeRoot.getK());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given FALSE; then PDStructureTreeRoot() K is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenFalse_thenPDStructureTreeRootKIsNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable2);

    // Assert
    verify(objectable).getCOSObject();
    verify(objectable2).getCOSObject();
    assertNull(pdStructureTreeRoot.getK());
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given 'null'; when COSObjectable getCOSObject() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenNull_whenCOSObjectableGetCOSObjectReturnNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(null);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.</li>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link COSFloat#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given ONE; when COSObjectable getCOSObject() return ONE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenOne_whenCOSObjectableGetCOSObjectReturnOne() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSFloat.ONE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.</li>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given ONE; when COSObjectable getCOSObject() return ONE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenOne_whenCOSObjectableGetCOSObjectReturnOne2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSInteger.ONE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given PDStructureTreeRoot(); then PDStructureTreeRoot() K is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenPDStructureTreeRoot_thenPDStructureTreeRootKIsNull() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
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
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given parseHex {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given parseHex '0123456789ABCDEF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenParseHex0123456789abcdef() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSString.parseHex("0123456789ABCDEF"));

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSBoolean#TRUE}.</li>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link COSBoolean#TRUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given TRUE; when COSObjectable getCOSObject() return TRUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenTrue_whenCOSObjectableGetCOSObjectReturnTrue() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSBoolean.TRUE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@link COSBoolean#TRUE}.</li>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link COSBoolean#TRUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); given TRUE; when COSObjectable getCOSObject() return TRUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_givenTrue_whenCOSObjectableGetCOSObjectReturnTrue2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSBoolean.TRUE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); then PDStructureTreeRoot() K COSDictionary")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_thenPDStructureTreeRootKCOSDictionary() {
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
    assertFalse(actualRemoveObjectableKidResult);
    assertSame(dic, k);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); then PDStructureTreeRoot() K Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_thenPDStructureTreeRootKKeyIsNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.TRUE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSBoolean);
    assertNull(k.getKey());
    assertTrue(((COSBoolean) k).getValue());
    assertTrue(((COSBoolean) k).getValueAsObject());
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); then PDStructureTreeRoot() K toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_thenPDStructureTreeRootKToListEmpty() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSArray cosArray = new COSArray();
    when(objectable.getCOSObject()).thenReturn(cosArray);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    assertTrue(((COSArray) k).toList().isEmpty());
    assertTrue(actualRemoveObjectableKidResult);
    assertSame(cosArray, k);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); then PDStructureTreeRoot() K toList size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_thenPDStructureTreeRootKToListSizeIsTwo() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable objectable2 = mock(COSObjectable.class);
    when(objectable2.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendObjectableKid(objectable2);
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable objectable3 = mock(COSObjectable.class);
    when(objectable3.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectableKidResult = pdStructureTreeRoot.removeObjectableKid(objectable3);

    // Assert
    verify(objectable2).getCOSObject();
    verify(objectable).getCOSObject();
    verify(objectable3).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    COSDictionary cOSObject = pdStructureTreeRoot.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((COSArray) k).toList().size());
    assertEquals(2, cOSObject.size());
    assertTrue(actualRemoveObjectableKidResult);
  }

  /**
   * Test {@link PDStructureNode#removeObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#removeObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test removeObjectableKid(COSObjectable); then PDStructureTreeRoot() Kids size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStructureNode.removeObjectableKid(COSObjectable)"})
  void testRemoveObjectableKid_thenPDStructureTreeRootKidsSizeIsOne() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    pdStructureTreeRoot.appendObjectableKid(objectable);
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
    PDStructureNode parent = ((PDStructureElement) getResult).getParent();
    assertTrue(parent instanceof PDStructureTreeRoot);
    assertSame(dic, ((PDStructureElement) getResult).getCOSObject());
    assertSame(dic, pdStructureTreeRoot.getK());
    assertSame(dic, ((PDStructureTreeRoot) parent).getK());
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <p>
   * Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSBoolean);
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); given 'null'; when COSObjectable getCOSObject() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_givenNull_whenCOSObjectableGetCOSObjectReturnNull() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(null);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSBoolean);
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Given {@link PDStructureTreeRoot#PDStructureTreeRoot()}.</li>
   *   <li>Then calls {@link COSObjectable#getCOSObject()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); given PDStructureTreeRoot(); then calls getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_givenPDStructureTreeRoot_thenCallsGetCOSObject() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(newKid).getCOSObject();
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSBoolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); then PDStructureTreeRoot() K COSBoolean")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_thenPDStructureTreeRootKCOSBoolean() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSBoolean);
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); then PDStructureTreeRoot() K COSDictionary")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_thenPDStructureTreeRootKCOSDictionary() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(newKid).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    assertSame(dic, k);
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSInteger}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); then PDStructureTreeRoot() K COSInteger")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_thenPDStructureTreeRootKCOSInteger() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSInteger);
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); then PDStructureTreeRoot() K COSName")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_thenPDStructureTreeRootKCOSName() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSName.A);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSName);
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSObject}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); then PDStructureTreeRoot() K COSObject")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_thenPDStructureTreeRootKCOSObject() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(objectable.getCOSObject()).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSObject);
    assertSame(object, k);
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); then PDStructureTreeRoot() K COSString")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_thenPDStructureTreeRootKCOSString() throws IOException {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    COSString parseHexResult = COSString.parseHex("0123456789ABCDEF");
    when(objectable.getCOSObject()).thenReturn(parseHexResult);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, "Ref Kid");

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSString);
    assertSame(parseHexResult, k);
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList first is {@link COSBoolean#FALSE} {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); then PDStructureTreeRoot() K toList first is FALSE FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_thenPDStructureTreeRootKToListFirstIsFalseFalse() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSBoolean cosBoolean = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, cosBoolean);

    // Assert
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBoolean cosBoolean2 = cosBoolean.FALSE;
    assertSame(cosBoolean2, toListResult.get(0));
    assertSame(cosBoolean2, toListResult.get(1));
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); when FALSE; then PDStructureTreeRoot() K toList size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_whenFalse_thenPDStructureTreeRootKToListSizeIsThree() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSBoolean cosBoolean = COSBoolean.FALSE;

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, cosBoolean);

    // Assert
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSDictionary);
    assertSame(dic, getResult);
    COSBoolean cosBoolean2 = cosBoolean.FALSE;
    assertSame(cosBoolean2, toListResult.get(1));
    assertSame(cosBoolean2, toListResult.get(2));
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSBoolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); when 'null'; then PDStructureTreeRoot() K COSBoolean")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_whenNull_thenPDStructureTreeRootKCOSBoolean() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, null);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSBoolean);
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>When {@link PDDictionaryWrapper#PDDictionaryWrapper()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); when PDDictionaryWrapper()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_whenPDDictionaryWrapper() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, new PDDictionaryWrapper());

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    assertTrue(pdStructureTreeRoot.getK() instanceof COSBoolean);
  }

  /**
   * Test {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}.
   * <ul>
   *   <li>When {@link COSInteger#THREE}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is {@link COSInteger#THREE} {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#insertObjectableBefore(COSObjectable, Object)}
   */
  @Test
  @DisplayName("Test insertObjectableBefore(COSObjectable, Object); when THREE; then PDStructureTreeRoot() K is THREE ONE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.insertObjectableBefore(COSObjectable, Object)"})
  void testInsertObjectableBefore_whenThree_thenPDStructureTreeRootKIsThreeOne() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSInteger.ONE);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendObjectableKid(objectable);
    COSObjectable newKid = mock(COSObjectable.class);
    when(newKid.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSInteger cosInteger = COSInteger.THREE;

    // Act
    pdStructureTreeRoot.insertObjectableBefore(newKid, cosInteger);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    verify(newKid).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSInteger);
    assertSame(cosInteger.ONE, k);
  }

  /**
   * Test {@link PDStructureNode#createObject(COSBase)}.
   * <p>
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  @DisplayName("Test createObject(COSBase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object PDStructureNode.createObject(COSBase)"})
  void testCreateObject() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary object = new COSDictionary();

    // Act
    Object actualCreateObjectResult = pdStructureTreeRoot.createObject(new COSObject(object, new COSObjectKey(1L, 1)));

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
    assertSame(object, ((PDStructureElement) actualCreateObjectResult).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#createObject(COSBase)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@link PDStructureElement}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  @DisplayName("Test createObject(COSBase); when COSDictionary(); then return PDStructureElement")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  @DisplayName("Test createObject(COSBase); when COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object PDStructureNode.createObject(COSBase)"})
  void testCreateObject_whenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    // Act and Assert
    assertNull(pdStructureTreeRoot.createObject(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link PDStructureNode#createObject(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  @DisplayName("Test createObject(COSBase); when FALSE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object PDStructureNode.createObject(COSBase)"})
  void testCreateObject_whenFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDStructureTreeRoot()).createObject(COSBoolean.FALSE));
  }

  /**
   * Test {@link PDStructureNode#createObject(COSBase)}.
   * <ul>
   *   <li>When {@link COSInteger#ONE}.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#createObject(COSBase)}
   */
  @Test
  @DisplayName("Test createObject(COSBase); when ONE; then return intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object PDStructureNode.createObject(COSBase)"})
  void testCreateObject_whenOne_thenReturnIntValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, ((Integer) (new PDStructureTreeRoot()).createObject(COSInteger.ONE)).intValue());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    COSObjectKey key = new COSObjectKey(2L, 2);

    dic.setKey(key);
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(structureElement);
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSDictionary);
    assertSame(key, getResult.getKey());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} Kids Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); given 'null'; then PDStructureTreeRoot() Kids Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid_givenNull_thenPDStructureTreeRootKidsEmpty() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(null);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert that nothing has changed
    verify(objectable).getCOSObject();
    assertTrue(pdStructureTreeRoot.getKids().isEmpty());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() K COSDictionary")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid_thenPDStructureTreeRootKCOSDictionary() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();

    COSDictionary cosDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(2L, 2);

    cosDictionary.setKey(key);
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSDictionary);
    assertSame(key, k.getKey());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() K is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid_thenPDStructureTreeRootKIsCOSDictionary() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSObjectable objectable = mock(COSObjectable.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(objectable.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(1, kids.size());
    assertTrue(kids.get(0) instanceof PDStructureElement);
    assertSame(cosDictionary, pdStructureTreeRoot.getK());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList second {@link COSBoolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() K toList second COSBoolean")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid_thenPDStructureTreeRootKToListSecondCOSBoolean() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSDictionary dic = new COSDictionary();
    pdStructureTreeRoot.appendKid(new PDStructureElement(dic));
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

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
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList third {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() K toList third COSArray")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid_thenPDStructureTreeRootKToListThirdCOSArray() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    COSObjectable objectable = mock(COSObjectable.class);
    COSArray cosArray = new COSArray();
    when(objectable.getCOSObject()).thenReturn(cosArray);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSArray);
    assertTrue(k instanceof COSArray);
    assertTrue(((COSArray) getResult).toList().isEmpty());
    assertSame(cosArray, getResult);
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList third {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() K toList third COSDictionary")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid_thenPDStructureTreeRootKToListThirdCOSDictionary() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    COSObjectable objectable = mock(COSObjectable.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(objectable.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSDictionary);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(3, kids.size());
    Object getResult2 = kids.get(2);
    assertTrue(getResult2 instanceof PDStructureElement);
    assertSame(cosDictionary, getResult);
    assertSame(getResult, ((PDStructureElement) getResult2).getCOSObject());
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then {@link PDStructureTreeRoot#PDStructureTreeRoot()} K toList third {@link COSObject}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then PDStructureTreeRoot() K toList third COSObject")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid_thenPDStructureTreeRootKToListThirdCOSObject() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));
    pdStructureTreeRoot.appendKid(new PDStructureElement(new COSDictionary()));

    COSDictionary cosDictionary = new COSDictionary();
    cosDictionary.setKey(new COSObjectKey(2L, 2));
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdStructureTreeRoot.appendObjectableKid(objectable);

    // Assert
    verify(objectable).getCOSObject();
    COSBase k = pdStructureTreeRoot.getK();
    assertTrue(k instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) k).toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(2) instanceof COSObject);
    List<Object> kids = pdStructureTreeRoot.getKids();
    assertEquals(3, kids.size());
    assertTrue(kids.get(2) instanceof PDStructureElement);
  }

  /**
   * Test {@link PDStructureNode#appendObjectableKid(COSObjectable)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStructureNode#appendObjectableKid(COSObjectable)}
   */
  @Test
  @DisplayName("Test appendObjectableKid(COSObjectable); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStructureNode.appendObjectableKid(COSObjectable)"})
  void testAppendObjectableKid_thenThrowIllegalArgumentException() {
    // Arrange
    PDStructureTreeRoot pdStructureTreeRoot = new PDStructureTreeRoot();
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdStructureTreeRoot.appendObjectableKid(objectable));
    verify(objectable).getCOSObject();
  }
}
