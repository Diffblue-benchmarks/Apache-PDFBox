package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.Map;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.apache.pdfbox.pdmodel.PDDestinationNameTreeNode;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDPageLabels;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSDictionaryDiffblueTest {
  /**
   * Test {@link COSDictionary#COSDictionary()}.
   *
   * <p>Method under test: {@link COSDictionary#COSDictionary()}
   */
  @Test
  @DisplayName("Test new COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.<init>()"})
  void testNewCOSDictionary() {
    // Arrange and Act
    COSDictionary actualCosDictionary = new COSDictionary();

    // Assert
    COSUpdateState updateState = actualCosDictionary.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCosDictionary.getKey());
    assertEquals(0, actualCosDictionary.size());
    COSIncrement toIncrementResult = actualCosDictionary.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCosDictionary.isDirect());
    assertFalse(actualCosDictionary.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCosDictionary.getValues().isEmpty());
    assertTrue(actualCosDictionary.items.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDictionary#COSDictionary(COSDictionary)}.
   *
   * <ul>
   *   <li>Then return UpdateState OriginDocumentState is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#COSDictionary(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new COSDictionary(COSDictionary); then return UpdateState OriginDocumentState is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.<init>(COSDictionary)"})
  void testNewCOSDictionary_thenReturnUpdateStateOriginDocumentStateIsNull() {
    // Arrange and Act
    COSDictionary actualCosDictionary = new COSDictionary(new COSDictionary());

    // Assert
    COSUpdateState updateState = actualCosDictionary.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCosDictionary.getKey());
    assertEquals(0, actualCosDictionary.size());
    COSIncrement toIncrementResult = actualCosDictionary.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCosDictionary.isDirect());
    assertFalse(actualCosDictionary.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCosDictionary.getValues().isEmpty());
    assertTrue(actualCosDictionary.items.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDictionary#COSDictionary(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#COSDictionary(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new COSDictionary(COSDictionary); when COSStream(); then return Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.<init>(COSDictionary)"})
  void testNewCOSDictionary_whenCOSStream_thenReturnValuesSizeIsOne() {
    // Arrange and Act
    COSDictionary actualCosDictionary = new COSDictionary(new COSStream());

    // Assert
    assertEquals(1, actualCosDictionary.getValues().size());
    assertEquals(1, actualCosDictionary.items.size());
    assertEquals(1, actualCosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#containsValue(Object)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@code Value}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#containsValue(Object)}
   */
  @Test
  @DisplayName(
      "Test containsValue(Object); given COSDictionary(); when 'Value'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.containsValue(Object)"})
  void testContainsValue_givenCOSDictionary_whenValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new COSDictionary().containsValue("Value"));
  }

  /**
   * Test {@link COSDictionary#containsValue(Object)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#containsValue(Object)}
   */
  @Test
  @DisplayName(
      "Test containsValue(Object); when COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.containsValue(Object)"})
  void testContainsValue_whenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    boolean actualContainsValueResult = cosDictionary.containsValue(cosObject);

    // Assert
    assertFalse(actualContainsValueResult);
  }

  /**
   * Test {@link COSDictionary#getKeyForValue(Object)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@code Value}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getKeyForValue(Object)}
   */
  @Test
  @DisplayName(
      "Test getKeyForValue(Object); given COSDictionary(); when 'Value'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName COSDictionary.getKeyForValue(Object)"})
  void testGetKeyForValue_givenCOSDictionary_whenValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getKeyForValue("Value"));
  }

  /**
   * Test {@link COSDictionary#getKeyForValue(Object)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@link COSInteger#ONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getKeyForValue(Object)}
   */
  @Test
  @DisplayName("Test getKeyForValue(Object); given COSStream(); when ONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName COSDictionary.getKeyForValue(Object)"})
  void testGetKeyForValue_givenCOSStream_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new COSStream().getKeyForValue(COSInteger.ONE));
  }

  /**
   * Test {@link COSDictionary#getKeyForValue(Object)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@link COSInteger#OUT_OF_RANGE_MIN}.
   *   <li>Then return {@link COSName#LENGTH}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getKeyForValue(Object)}
   */
  @Test
  @DisplayName(
      "Test getKeyForValue(Object); given COSStream(); when OUT_OF_RANGE_MIN; then return LENGTH")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName COSDictionary.getKeyForValue(Object)"})
  void testGetKeyForValue_givenCOSStream_whenOut_of_range_min_thenReturnLength() {
    // Arrange, Act and Assert
    assertSame(COSName.LENGTH, new COSStream().getKeyForValue(COSInteger.OUT_OF_RANGE_MIN));
  }

  /**
   * Test {@link COSDictionary#getKeyForValue(Object)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@code Value}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getKeyForValue(Object)}
   */
  @Test
  @DisplayName("Test getKeyForValue(Object); given COSStream(); when 'Value'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName COSDictionary.getKeyForValue(Object)"})
  void testGetKeyForValue_givenCOSStream_whenValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new COSStream().getKeyForValue("Value"));
  }

  /**
   * Test {@link COSDictionary#size()}.
   *
   * <p>Method under test: {@link COSDictionary#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new COSDictionary().size());
  }

  /**
   * Test {@link COSDictionary#getDictionaryObject(COSName, COSName)} with {@code COSName}, {@code
   * COSName}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getDictionaryObject(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getDictionaryObject(COSName, COSName) with 'COSName', 'COSName'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getDictionaryObject(COSName, COSName)"})
  void testGetDictionaryObjectWithCOSNameCOSName_whenA() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getDictionaryObject(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getDictionaryObject(COSName, COSName)} with {@code COSName}, {@code
   * COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getDictionaryObject(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getDictionaryObject(COSName, COSName) with 'COSName', 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getDictionaryObject(COSName, COSName)"})
  void testGetDictionaryObjectWithCOSNameCOSName_whenNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getDictionaryObject(COSName.A, null));
  }

  /**
   * Test {@link COSDictionary#getDictionaryObject(COSName, COSName)} with {@code COSName}, {@code
   * COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getDictionaryObject(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getDictionaryObject(COSName, COSName) with 'COSName', 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getDictionaryObject(COSName, COSName)"})
  void testGetDictionaryObjectWithCOSNameCOSName_whenNull2() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getDictionaryObject(null, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getDictionaryObject(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getDictionaryObject(COSName)}
   */
  @Test
  @DisplayName("Test getDictionaryObject(COSName) with 'COSName'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getDictionaryObject(COSName)"})
  void testGetDictionaryObjectWithCOSName_whenA() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getDictionaryObject(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getDictionaryObject(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getDictionaryObject(COSName)}
   */
  @Test
  @DisplayName("Test getDictionaryObject(COSName) with 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getDictionaryObject(COSName)"})
  void testGetDictionaryObjectWithCOSName_whenNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getDictionaryObject((COSName) null));
  }

  /**
   * Test {@link COSDictionary#getDictionaryObject(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getDictionaryObject(String)}
   */
  @Test
  @DisplayName("Test getDictionaryObject(String) with 'String'; given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getDictionaryObject(String)"})
  void testGetDictionaryObjectWithString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getDictionaryObject("Key"));
  }

  /**
   * Test {@link COSDictionary#getDictionaryObject(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getDictionaryObject(String)}
   */
  @Test
  @DisplayName(
      "Test getDictionaryObject(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getDictionaryObject(String)"})
  void testGetDictionaryObjectWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary(new COSDictionary()).getDictionaryObject("Key"));
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName}, {@code COSBase}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSBase)"})
  void testSetItemWithCOSNameCOSBase_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSDictionary value = new COSDictionary();
    value.setKey(new COSObjectKey(1L, 1));

    // Act
    cosDictionary.setItem(COSName.A, (COSBase) value);

    // Assert that nothing has changed
    assertEquals(0, value.size());
    assertTrue(value.getValues().isEmpty());
    assertTrue(value.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName}, {@code COSBase}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSBase)"})
  void testSetItemWithCOSNameCOSBase_givenCOSObjectKeyWithNumIsOneAndGenIsOne2() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSDictionary value = new COSDictionary();
    value.setKey(new COSObjectKey(1L, 1));

    // Act
    cosDictionary.setItem((COSName) null, (COSBase) value);

    // Assert that nothing has changed
    assertEquals(0, value.size());
    assertTrue(value.getValues().isEmpty());
    assertTrue(value.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName}, {@code COSBase}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; when COSArray(); then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSBase)"})
  void testSetItemWithCOSNameCOSBase_whenCOSArray_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem(COSName.A, (COSBase) new COSArray());

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName}, {@code COSBase}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; when COSDictionary(); then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSBase)"})
  void testSetItemWithCOSNameCOSBase_whenCOSDictionary_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSDictionary value = new COSDictionary();

    // Act
    cosDictionary.setItem(COSName.A, (COSBase) value);

    // Assert that nothing has changed
    assertEquals(0, value.size());
    assertTrue(value.getValues().isEmpty());
    assertTrue(value.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName}, {@code COSBase}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSBase)"})
  void testSetItemWithCOSNameCOSBase_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObject value = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    cosDictionary.setItem(COSName.A, (COSBase) value);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName}, {@code COSBase}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items} {@code null} is
   *       {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; when FALSE; then COSDictionary() items 'null' is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSBase)"})
  void testSetItemWithCOSNameCOSBase_whenFalse_thenCOSDictionaryItemsNullIsFalse() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem((COSName) null, COSBoolean.FALSE);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, cosDictionary.size());
    assertSame(COSBoolean.FALSE, cosNameCosBaseMap.get(null));
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName}, {@code COSBase}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; when FALSE; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSBase)"})
  void testSetItemWithCOSNameCOSBase_whenFalse_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem(COSName.A, COSBoolean.FALSE);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName}, {@code COSBase}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; when 'null'; then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSBase)"})
  void testSetItemWithCOSNameCOSBase_whenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem(COSName.A, (COSBase) null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName}, {@code COSBase}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; when 'null'; then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSBase)"})
  void testSetItemWithCOSNameCOSBase_whenNull_thenCOSDictionarySizeIsZero2() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem((COSName) null, (COSBase) null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with {@code COSName}, {@code
   * COSObjectable}.
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSObjectable)"})
  void testSetItemWithCOSNameCOSObjectable() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem(COSName.A, new PDDestinationNameTreeNode(new COSDictionary()));

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with {@code COSName}, {@code
   * COSObjectable}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'; given COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSObjectable)"})
  void testSetItemWithCOSNameCOSObjectable_givenCOSArray() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(new COSArray());

    // Act
    cosDictionary.setItem(COSName.A, value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with {@code COSName}, {@code
   * COSObjectable}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'; given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSObjectable)"})
  void testSetItemWithCOSNameCOSObjectable_givenFalse() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSDictionary dic = new COSDictionary(new COSDictionary());
    dic.setDirect(false);
    dic.setKey(new COSObjectKey(1L, 1));

    // Act
    cosDictionary.setItem(COSName.A, new PDDestinationNameTreeNode(dic));

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with {@code COSName}, {@code
   * COSObjectable}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE} Direct is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'; given FALSE Direct is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSObjectable)"})
  void testSetItemWithCOSNameCOSObjectable_givenFalseDirectIsFalse() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSBoolean cosBoolean = COSBoolean.FALSE;
    cosBoolean.setDirect(false);
    cosBoolean.setKey(null);

    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(cosBoolean);

    // Act
    cosDictionary.setItem(COSName.A, value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with {@code COSName}, {@code
   * COSObjectable}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSObjectable)"})
  void testSetItemWithCOSNameCOSObjectable_givenNull() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(null);

    // Act
    cosDictionary.setItem((COSName) null, value);

    // Assert that nothing has changed
    verify(value).getCOSObject();
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with {@code COSName}, {@code
   * COSObjectable}.
   *
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items} {@code null}
   *       {@link COSBoolean}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'; then COSDictionary() items 'null' COSBoolean")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSObjectable)"})
  void testSetItemWithCOSNameCOSObjectable_thenCOSDictionaryItemsNullCOSBoolean() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSBoolean cosBoolean = COSBoolean.FALSE;
    cosBoolean.setDirect(false);
    cosBoolean.setKey(null);

    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(cosBoolean);

    // Act
    cosDictionary.setItem((COSName) null, value);

    // Assert
    verify(value).getCOSObject();
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSBoolean);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSBoolean) getResult).getValue());
    assertFalse(((COSBoolean) getResult).getValueAsObject());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with {@code COSName}, {@code
   * COSObjectable}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'; when FALSE; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSObjectable)"})
  void testSetItemWithCOSNameCOSObjectable_whenFalse_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem(COSName.A, (COSObjectable) COSBoolean.FALSE);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with {@code COSName}, {@code
   * COSObjectable}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'; when 'null'; then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSObjectable)"})
  void testSetItemWithCOSNameCOSObjectable_whenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem(COSName.A, (COSObjectable) null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with {@code COSName}, {@code
   * COSObjectable}.
   *
   * <ul>
   *   <li>When {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode(COSDictionary)} with dic
   *       is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'; when PDDestinationNameTreeNode(COSDictionary) with dic is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSObjectable)"})
  void testSetItemWithCOSNameCOSObjectable_whenPDDestinationNameTreeNodeWithDicIsNull() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem(COSName.A, new PDDestinationNameTreeNode(null));

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with {@code COSName}, {@code
   * COSObjectable}.
   *
   * <ul>
   *   <li>When {@link PDPageLabels#PDPageLabels(PDDocument)} with document is {@link
   *       PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'; when PDPageLabels(PDDocument) with document is PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(COSName, COSObjectable)"})
  void testSetItemWithCOSNameCOSObjectable_whenPDPageLabelsWithDocumentIsPDDocument() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem(COSName.A, new PDPageLabels(new PDDocument()));

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSBase)} with {@code String}, {@code COSBase}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(String, COSBase)}
   */
  @Test
  @DisplayName(
      "Test setItem(String, COSBase) with 'String', 'COSBase'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(String, COSBase)"})
  void testSetItemWithStringCOSBase_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSDictionary value = new COSDictionary();
    value.setKey(new COSObjectKey(1L, 1));

    // Act
    cosDictionary.setItem("Key", (COSBase) value);

    // Assert that nothing has changed
    assertEquals(0, value.size());
    assertTrue(value.getValues().isEmpty());
    assertTrue(value.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSBase)} with {@code String}, {@code COSBase}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(String, COSBase)}
   */
  @Test
  @DisplayName(
      "Test setItem(String, COSBase) with 'String', 'COSBase'; when COSArray(); then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(String, COSBase)"})
  void testSetItemWithStringCOSBase_whenCOSArray_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem("Key", (COSBase) new COSArray());

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSBase)} with {@code String}, {@code COSBase}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(String, COSBase)}
   */
  @Test
  @DisplayName(
      "Test setItem(String, COSBase) with 'String', 'COSBase'; when COSDictionary(); then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(String, COSBase)"})
  void testSetItemWithStringCOSBase_whenCOSDictionary_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSDictionary value = new COSDictionary();

    // Act
    cosDictionary.setItem("Key", (COSBase) value);

    // Assert that nothing has changed
    assertEquals(0, value.size());
    assertTrue(value.getValues().isEmpty());
    assertTrue(value.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSBase)} with {@code String}, {@code COSBase}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(String, COSBase)}
   */
  @Test
  @DisplayName(
      "Test setItem(String, COSBase) with 'String', 'COSBase'; when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(String, COSBase)"})
  void testSetItemWithStringCOSBase_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObject value = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    cosDictionary.setItem("Key", (COSBase) value);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSBase)} with {@code String}, {@code COSBase}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(String, COSBase)}
   */
  @Test
  @DisplayName(
      "Test setItem(String, COSBase) with 'String', 'COSBase'; when FALSE; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(String, COSBase)"})
  void testSetItemWithStringCOSBase_whenFalse_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem("Key", COSBoolean.FALSE);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSBase)} with {@code String}, {@code COSBase}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(String, COSBase)}
   */
  @Test
  @DisplayName(
      "Test setItem(String, COSBase) with 'String', 'COSBase'; when 'null'; then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(String, COSBase)"})
  void testSetItemWithStringCOSBase_whenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem("Key", (COSBase) null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSObjectable)} with {@code String}, {@code
   * COSObjectable}.
   *
   * <p>Method under test: {@link COSDictionary#setItem(String, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(String, COSObjectable) with 'String', 'COSObjectable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(String, COSObjectable)"})
  void testSetItemWithStringCOSObjectable() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem("Key", new PDDestinationNameTreeNode(new COSDictionary()));

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSObjectable)} with {@code String}, {@code
   * COSObjectable}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(String, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test setItem(String, COSObjectable) with 'String', 'COSObjectable'; given COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(String, COSObjectable)"})
  void testSetItemWithStringCOSObjectable_givenCOSArray() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(new COSArray());

    // Act
    cosDictionary.setItem("Key", value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSObjectable)} with {@code String}, {@code
   * COSObjectable}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(String, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(String, COSObjectable) with 'String', 'COSObjectable'; given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(String, COSObjectable)"})
  void testSetItemWithStringCOSObjectable_givenFalse() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSDictionary dic = new COSDictionary(new COSDictionary());
    dic.setDirect(false);
    dic.setKey(new COSObjectKey(1L, 1));

    // Act
    cosDictionary.setItem("Key", new PDDestinationNameTreeNode(dic));

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSObjectable)} with {@code String}, {@code
   * COSObjectable}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE} Direct is {@code false}.
   *   <li>Then calls {@link COSObjectable#getCOSObject()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(String, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test setItem(String, COSObjectable) with 'String', 'COSObjectable'; given FALSE Direct is 'false'; then calls getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(String, COSObjectable)"})
  void testSetItemWithStringCOSObjectable_givenFalseDirectIsFalse_thenCallsGetCOSObject() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSBoolean cosBoolean = COSBoolean.FALSE;
    cosBoolean.setDirect(false);
    cosBoolean.setKey(null);

    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(cosBoolean);

    // Act
    cosDictionary.setItem("Key", value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSObjectable)} with {@code String}, {@code COSObjectable}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@code COSArray{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(String, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test setItem(String, COSObjectable) with 'String', 'COSObjectable'; given 'null'; when 'COSArray{'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(String, COSObjectable)"})
  void testSetItemWithStringCOSObjectable_givenNull_whenCOSArray() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(null);

    // Act
    cosDictionary.setItem("COSArray{", value);

    // Assert that nothing has changed
    verify(value).getCOSObject();
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSObjectable)} with {@code String}, {@code
   * COSObjectable}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(String, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test setItem(String, COSObjectable) with 'String', 'COSObjectable'; when FALSE; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(String, COSObjectable)"})
  void testSetItemWithStringCOSObjectable_whenFalse_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem("Key", (COSObjectable) COSBoolean.FALSE);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSObjectable)} with {@code String}, {@code
   * COSObjectable}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(String, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test setItem(String, COSObjectable) with 'String', 'COSObjectable'; when 'null'; then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(String, COSObjectable)"})
  void testSetItemWithStringCOSObjectable_whenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem("Key", (COSObjectable) null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSObjectable)} with {@code String}, {@code
   * COSObjectable}.
   *
   * <ul>
   *   <li>When {@link PDDestinationNameTreeNode#PDDestinationNameTreeNode(COSDictionary)} with dic
   *       is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setItem(String, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test setItem(String, COSObjectable) with 'String', 'COSObjectable'; when PDDestinationNameTreeNode(COSDictionary) with dic is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setItem(String, COSObjectable)"})
  void testSetItemWithStringCOSObjectable_whenPDDestinationNameTreeNodeWithDicIsNull() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem("Key", new PDDestinationNameTreeNode(null));

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setName(COSName, String)} with {@code COSName}, {@code String}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items} {@code null}
   *       {@link COSName}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setName(COSName, String)}
   */
  @Test
  @DisplayName(
      "Test setName(COSName, String) with 'COSName', 'String'; when '42'; then COSDictionary() items 'null' COSName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setName(COSName, String)"})
  void testSetNameWithCOSNameString_when42_thenCOSDictionaryItemsNullCOSName() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setName((COSName) null, "42");

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSName);
    assertEquals("42", ((COSName) getResult).getName());
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link COSDictionary#setName(COSName, String)} with {@code COSName}, {@code String}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setName(COSName, String)}
   */
  @Test
  @DisplayName(
      "Test setName(COSName, String) with 'COSName', 'String'; when '42'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setName(COSName, String)"})
  void testSetNameWithCOSNameString_when42_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setName(COSName.A, "42");

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setName(COSName, String)} with {@code COSName}, {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setName(COSName, String)}
   */
  @Test
  @DisplayName(
      "Test setName(COSName, String) with 'COSName', 'String'; when 'null'; then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setName(COSName, String)"})
  void testSetNameWithCOSNameString_whenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setName(COSName.A, null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setName(COSName, String)} with {@code COSName}, {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setName(COSName, String)}
   */
  @Test
  @DisplayName(
      "Test setName(COSName, String) with 'COSName', 'String'; when 'null'; then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setName(COSName, String)"})
  void testSetNameWithCOSNameString_whenNull_thenCOSDictionarySizeIsZero2() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setName((COSName) null, null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setName(COSName, String)} with {@code COSName}, {@code String}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setName(COSName, String)}
   */
  @Test
  @DisplayName(
      "Test setName(COSName, String) with 'COSName', 'String'; when 'Value'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setName(COSName, String)"})
  void testSetNameWithCOSNameString_whenValue_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setName(COSName.A, "Value");

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setName(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setName(String, String)}
   */
  @Test
  @DisplayName(
      "Test setName(String, String) with 'String', 'String'; given COSDictionary(); then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setName(String, String)"})
  void testSetNameWithStringString_givenCOSDictionary_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setName("Key", "42");

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setName(String, String)} with {@code String}, {@code String}.
   * <ul>
   *   <li>When {@code COSArray{}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setName(String, String)}
   */
  @Test
  @DisplayName(
      "Test setName(String, String) with 'String', 'String'; when 'COSArray{'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setName(String, String)"})
  void testSetNameWithStringString_whenCOSArray_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setName("COSArray{", "42");

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setName(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setName(String, String)}
   */
  @Test
  @DisplayName(
      "Test setName(String, String) with 'String', 'String'; when 'null'; then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setName(String, String)"})
  void testSetNameWithStringString_whenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setName("Key", null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setBoolean(COSName, boolean)} with {@code COSName}, {@code boolean}.
   *
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setBoolean(COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test setBoolean(COSName, boolean) with 'COSName', 'boolean'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setBoolean(COSName, boolean)"})
  void testSetBooleanWithCOSNameBoolean_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setBoolean(COSName.A, true);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setBoolean(COSName, boolean)} with {@code COSName}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setBoolean(COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test setBoolean(COSName, boolean) with 'COSName', 'boolean'; when 'false'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setBoolean(COSName, boolean)"})
  void testSetBooleanWithCOSNameBoolean_whenFalse_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setBoolean(COSName.A, false);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setBoolean(String, boolean)} with {@code String}, {@code boolean}.
   *
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test setBoolean(String, boolean) with 'String', 'boolean'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setBoolean(String, boolean)"})
  void testSetBooleanWithStringBoolean_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setBoolean("Key", true);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setBoolean(String, boolean)} with {@code String}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test setBoolean(String, boolean) with 'String', 'boolean'; when 'false'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setBoolean(String, boolean)"})
  void testSetBooleanWithStringBoolean_whenFalse_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setBoolean("Key", false);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setDate(COSName, Calendar)} with {@code COSName}, {@code Calendar}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setDate(COSName, Calendar)}
   */
  @Test
  @DisplayName(
      "Test setDate(COSName, Calendar) with 'COSName', 'Calendar'; given COSDictionary(); then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setDate(COSName, Calendar)"})
  void testSetDateWithCOSNameCalendar_givenCOSDictionary_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setDate(COSName.A, null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setDate(COSName, Calendar)} with {@code COSName}, {@code Calendar}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setDate(COSName, Calendar)}
   */
  @Test
  @DisplayName(
      "Test setDate(COSName, Calendar) with 'COSName', 'Calendar'; given COSDictionary(); then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setDate(COSName, Calendar)"})
  void testSetDateWithCOSNameCalendar_givenCOSDictionary_thenCOSDictionarySizeIsZero2() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setDate((COSName) null, null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setDate(COSName, Calendar)} with {@code COSName}, {@code Calendar}.
   *
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items} {@code null}
   *       {@link COSString}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setDate(COSName, Calendar)}
   */
  @Test
  @DisplayName(
      "Test setDate(COSName, Calendar) with 'COSName', 'Calendar'; then COSDictionary() items 'null' COSString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setDate(COSName, Calendar)"})
  void testSetDateWithCOSNameCalendar_thenCOSDictionaryItemsNullCOSString() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setDate((COSName) null, new GregorianCalendar(1, 1, 1));

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSString);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult).getForceHexForm());
  }

  /**
   * Test {@link COSDictionary#setDate(COSName, Calendar)} with {@code COSName}, {@code Calendar}.
   *
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setDate(COSName, Calendar)}
   */
  @Test
  @DisplayName(
      "Test setDate(COSName, Calendar) with 'COSName', 'Calendar'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setDate(COSName, Calendar)"})
  void testSetDateWithCOSNameCalendar_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setDate(COSName.A, new GregorianCalendar(1, 1, 1));

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setDate(String, Calendar)} with {@code String}, {@code Calendar}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setDate(String, Calendar)}
   */
  @Test
  @DisplayName(
      "Test setDate(String, Calendar) with 'String', 'Calendar'; given COSDictionary(); then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setDate(String, Calendar)"})
  void testSetDateWithStringCalendar_givenCOSDictionary_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setDate("Key", null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setDate(String, Calendar)} with {@code String}, {@code Calendar}.
   *
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setDate(String, Calendar)}
   */
  @Test
  @DisplayName(
      "Test setDate(String, Calendar) with 'String', 'Calendar'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setDate(String, Calendar)"})
  void testSetDateWithStringCalendar_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setDate("Key", new GregorianCalendar(1, 1, 1));

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedDate(COSName, COSName, Calendar)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setEmbeddedDate(COSName, COSName, Calendar)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedDate(COSName, COSName, Calendar); given COSDictionary(); then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setEmbeddedDate(COSName, COSName, Calendar)"})
  void testSetEmbeddedDate_givenCOSDictionary_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedDate(COSName.A, COSName.A, new GregorianCalendar(1, 1, 1));

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedDate(COSName, COSName, Calendar)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@code null}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setEmbeddedDate(COSName, COSName, Calendar)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedDate(COSName, COSName, Calendar); given COSDictionary(); when 'null'; then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setEmbeddedDate(COSName, COSName, Calendar)"})
  void testSetEmbeddedDate_givenCOSDictionary_whenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedDate(COSName.A, COSName.A, null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedDate(COSName, COSName, Calendar)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items} {@code null}
   *       {@link COSDictionary}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setEmbeddedDate(COSName, COSName, Calendar)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedDate(COSName, COSName, Calendar); when 'null'; then COSDictionary() items 'null' COSDictionary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setEmbeddedDate(COSName, COSName, Calendar)"})
  void testSetEmbeddedDate_whenNull_thenCOSDictionaryItemsNullCOSDictionary() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedDate(null, COSName.A, new GregorianCalendar(1, 1, 1));

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertEquals(1, ((COSDictionary) getResult).getValues().size());
    assertEquals(1, ((COSDictionary) getResult).items.size());
    assertEquals(1, ((COSDictionary) getResult).size());
    COSIncrement toIncrementResult = ((COSDictionary) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(((COSDictionary) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDictionary#setString(COSName, String)} with {@code COSName}, {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setString(COSName, String)}
   */
  @Test
  @DisplayName(
      "Test setString(COSName, String) with 'COSName', 'String'; given COSDictionary(); then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setString(COSName, String)"})
  void testSetStringWithCOSNameString_givenCOSDictionary_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setString(COSName.A, null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setString(COSName, String)} with {@code COSName}, {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setString(COSName, String)}
   */
  @Test
  @DisplayName(
      "Test setString(COSName, String) with 'COSName', 'String'; given COSDictionary(); then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setString(COSName, String)"})
  void testSetStringWithCOSNameString_givenCOSDictionary_thenCOSDictionarySizeIsZero2() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setString((COSName) null, null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setString(COSName, String)} with {@code COSName}, {@code String}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items} {@code null}
   *       {@link COSString}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setString(COSName, String)}
   */
  @Test
  @DisplayName(
      "Test setString(COSName, String) with 'COSName', 'String'; when '42'; then COSDictionary() items 'null' COSString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setString(COSName, String)"})
  void testSetStringWithCOSNameString_when42_thenCOSDictionaryItemsNullCOSString() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setString((COSName) null, "42");

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSString);
    assertEquals("3432", ((COSString) getResult).toHexString());
    assertEquals("42", ((COSString) getResult).getASCII());
    assertEquals("42", ((COSString) getResult).getString());
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertArrayEquals(new byte[] {'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link COSDictionary#setString(COSName, String)} with {@code COSName}, {@code String}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setString(COSName, String)}
   */
  @Test
  @DisplayName(
      "Test setString(COSName, String) with 'COSName', 'String'; when '42'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setString(COSName, String)"})
  void testSetStringWithCOSNameString_when42_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setString(COSName.A, "42");

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setString(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setString(String, String)}
   */
  @Test
  @DisplayName(
      "Test setString(String, String) with 'String', 'String'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setString(String, String)"})
  void testSetStringWithStringString_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setString("Key", "42");

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setString(String, String)} with {@code String}, {@code String}.
   * <ul>
   *   <li>When {@code COSArray{}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setString(String, String)}
   */
  @Test
  @DisplayName(
      "Test setString(String, String) with 'String', 'String'; when 'COSArray{'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setString(String, String)"})
  void testSetStringWithStringString_whenCOSArray_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setString("COSArray{", "42");

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setString(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setString(String, String)}
   */
  @Test
  @DisplayName(
      "Test setString(String, String) with 'String', 'String'; when 'null'; then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setString(String, String)"})
  void testSetStringWithStringString_whenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setString("Key", null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedString(COSName, COSName, String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@code 42}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setEmbeddedString(COSName, COSName, String)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedString(COSName, COSName, String); given COSDictionary(); when '42'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setEmbeddedString(COSName, COSName, String)"})
  void testSetEmbeddedString_givenCOSDictionary_when42_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedString(COSName.A, COSName.A, "42");

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedString(COSName, COSName, String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@code null}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setEmbeddedString(COSName, COSName, String)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedString(COSName, COSName, String); given COSDictionary(); when 'null'; then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setEmbeddedString(COSName, COSName, String)"})
  void testSetEmbeddedString_givenCOSDictionary_whenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedString(COSName.A, COSName.A, null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedString(COSName, COSName, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items} {@code null}
   *       {@link COSDictionary}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setEmbeddedString(COSName, COSName, String)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedString(COSName, COSName, String); when 'null'; then COSDictionary() items 'null' COSDictionary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setEmbeddedString(COSName, COSName, String)"})
  void testSetEmbeddedString_whenNull_thenCOSDictionaryItemsNullCOSDictionary() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedString(null, COSName.A, "42");

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertEquals(1, ((COSDictionary) getResult).getValues().size());
    assertEquals(1, ((COSDictionary) getResult).items.size());
    assertEquals(1, ((COSDictionary) getResult).size());
    COSIncrement toIncrementResult = ((COSDictionary) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(((COSDictionary) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDictionary#setInt(COSName, int)} with {@code COSName}, {@code int}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setInt(COSName, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(COSName, int) with 'COSName', 'int'; given COSDictionary(); then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setInt(COSName, int)"})
  void testSetIntWithCOSNameInt_givenCOSDictionary_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setInt(COSName.A, 42);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setInt(COSName, int)} with {@code COSName}, {@code int}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setInt(COSName, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(COSName, int) with 'COSName', 'int'; when MIN_VALUE; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setInt(COSName, int)"})
  void testSetIntWithCOSNameInt_whenMin_value_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setInt(COSName.A, Integer.MIN_VALUE);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setInt(String, int)} with {@code String}, {@code int}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(String, int) with 'String', 'int'; given COSDictionary(); then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setInt(String, int)"})
  void testSetIntWithStringInt_givenCOSDictionary_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setInt("Key", 42);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setInt(String, int)} with {@code String}, {@code int}.
   *
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(String, int) with 'String', 'int'; then COSDictionary(COSDictionary) with dict is COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setInt(String, int)"})
  void testSetIntWithStringInt_thenCOSDictionaryWithDictIsCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary(new COSDictionary());

    // Act
    cosDictionary.setInt("Key", 42);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setInt(String, int)} with {@code String}, {@code int}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(String, int) with 'String', 'int'; when MIN_VALUE; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setInt(String, int)"})
  void testSetIntWithStringInt_whenMin_value_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setInt("Key", Integer.MIN_VALUE);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setLong(COSName, long)} with {@code COSName}, {@code long}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setLong(COSName, long)}
   */
  @Test
  @DisplayName(
      "Test setLong(COSName, long) with 'COSName', 'long'; when forty-two; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setLong(COSName, long)"})
  void testSetLongWithCOSNameLong_whenFortyTwo_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setLong(COSName.A, 42L);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setLong(COSName, long)} with {@code COSName}, {@code long}.
   *
   * <ul>
   *   <li>When minus one hundred one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setLong(COSName, long)}
   */
  @Test
  @DisplayName("Test setLong(COSName, long) with 'COSName', 'long'; when minus one hundred one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setLong(COSName, long)"})
  void testSetLongWithCOSNameLong_whenMinusOneHundredOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setLong(COSName.A, -101L);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setLong(COSName, long)} with {@code COSName}, {@code long}.
   *
   * <ul>
   *   <li>When two hundred fifty-seven.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setLong(COSName, long)}
   */
  @Test
  @DisplayName("Test setLong(COSName, long) with 'COSName', 'long'; when two hundred fifty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setLong(COSName, long)"})
  void testSetLongWithCOSNameLong_whenTwoHundredFiftySeven() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setLong(COSName.A, 257L);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setLong(String, long)} with {@code String}, {@code long}.
   * <ul>
   *   <li>When {@code COSArray{}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test setLong(String, long) with 'String', 'long'; when 'COSArray{'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setLong(String, long)"})
  void testSetLongWithStringLong_whenCOSArray_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setLong("COSArray{", 42L);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setLong(String, long)} with {@code String}, {@code long}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test setLong(String, long) with 'String', 'long'; when 'Key'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setLong(String, long)"})
  void testSetLongWithStringLong_whenKey_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setLong("Key", 42L);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setLong(String, long)} with {@code String}, {@code long}.
   *
   * <ul>
   *   <li>When minus one hundred one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setLong(String, long)}
   */
  @Test
  @DisplayName("Test setLong(String, long) with 'String', 'long'; when minus one hundred one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setLong(String, long)"})
  void testSetLongWithStringLong_whenMinusOneHundredOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setLong("Key", -101L);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setLong(String, long)} with {@code String}, {@code long}.
   *
   * <ul>
   *   <li>When two hundred fifty-seven.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setLong(String, long)}
   */
  @Test
  @DisplayName("Test setLong(String, long) with 'String', 'long'; when two hundred fifty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setLong(String, long)"})
  void testSetLongWithStringLong_whenTwoHundredFiftySeven() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setLong("Key", 257L);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedInt(COSName, COSName, int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setEmbeddedInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedInt(COSName, COSName, int); given COSDictionary(); then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setEmbeddedInt(COSName, COSName, int)"})
  void testSetEmbeddedInt_givenCOSDictionary_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedInt(COSName.A, COSName.A, 42);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedInt(COSName, COSName, int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setEmbeddedInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedInt(COSName, COSName, int); when MIN_VALUE; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setEmbeddedInt(COSName, COSName, int)"})
  void testSetEmbeddedInt_whenMin_value_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedInt(COSName.A, COSName.A, Integer.MIN_VALUE);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedInt(COSName, COSName, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items} {@code null}
   *       {@link COSDictionary}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setEmbeddedInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName(
      "Test setEmbeddedInt(COSName, COSName, int); when 'null'; then COSDictionary() items 'null' COSDictionary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setEmbeddedInt(COSName, COSName, int)"})
  void testSetEmbeddedInt_whenNull_thenCOSDictionaryItemsNullCOSDictionary() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedInt(null, COSName.A, 42);

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertEquals(1, ((COSDictionary) getResult).getValues().size());
    assertEquals(1, ((COSDictionary) getResult).items.size());
    assertEquals(1, ((COSDictionary) getResult).size());
    COSIncrement toIncrementResult = ((COSDictionary) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(((COSDictionary) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDictionary#setFloat(COSName, float)} with {@code COSName}, {@code float}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setFloat(COSName, float)}
   */
  @Test
  @DisplayName(
      "Test setFloat(COSName, float) with 'COSName', 'float'; given COSDictionary(); then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setFloat(COSName, float)"})
  void testSetFloatWithCOSNameFloat_givenCOSDictionary_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setFloat(COSName.A, 10.0f);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setFloat(COSName, float)} with {@code COSName}, {@code float}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items} {@code null}
   *       {@link COSFloat}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setFloat(COSName, float)}
   */
  @Test
  @DisplayName(
      "Test setFloat(COSName, float) with 'COSName', 'float'; when 'null'; then COSDictionary() items 'null' COSFloat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setFloat(COSName, float)"})
  void testSetFloatWithCOSNameFloat_whenNull_thenCOSDictionaryItemsNullCOSFloat() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setFloat((COSName) null, 10.0f);

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link COSDictionary#setFloat(String, float)} with {@code String}, {@code float}.
   *
   * <p>Method under test: {@link COSDictionary#setFloat(String, float)}
   */
  @Test
  @DisplayName("Test setFloat(String, float) with 'String', 'float'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setFloat(String, float)"})
  void testSetFloatWithStringFloat() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary(new COSDictionary());

    // Act
    cosDictionary.setFloat("Key", 10.0f);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setFloat(String, float)} with {@code String}, {@code float}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setFloat(String, float)}
   */
  @Test
  @DisplayName(
      "Test setFloat(String, float) with 'String', 'float'; given COSDictionary(); then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setFloat(String, float)"})
  void testSetFloatWithStringFloat_givenCOSDictionary_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setFloat("Key", 10.0f);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setFlag(COSName, int, boolean)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link COSName#A}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setFlag(COSName, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFlag(COSName, int, boolean); given COSDictionary(); when A; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setFlag(COSName, int, boolean)"})
  void testSetFlag_givenCOSDictionary_whenA_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setFlag(COSName.A, 1, true);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setFlag(COSName, int, boolean)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@code false}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setFlag(COSName, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFlag(COSName, int, boolean); given COSDictionary(); when 'false'; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setFlag(COSName, int, boolean)"})
  void testSetFlag_givenCOSDictionary_whenFalse_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setFlag(COSName.A, 1, false);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setFlag(COSName, int, boolean)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#setFlag(COSName, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test setFlag(COSName, int, boolean); given COSDictionary(); when MIN_VALUE; then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.setFlag(COSName, int, boolean)"})
  void testSetFlag_givenCOSDictionary_whenMin_value_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setFlag(COSName.A, Integer.MIN_VALUE, true);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#getCOSName(COSName, COSName)} with {@code key}, {@code defaultValue}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getCOSName(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getCOSName(COSName, COSName) with 'key', 'defaultValue'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName COSDictionary.getCOSName(COSName, COSName)"})
  void testGetCOSNameWithKeyDefaultValue_whenA() {
    // Arrange, Act and Assert
    assertSame(COSName.A, new COSDictionary().getCOSName(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSName(COSName, COSName)} with {@code key}, {@code defaultValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getCOSName(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getCOSName(COSName, COSName) with 'key', 'defaultValue'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName COSDictionary.getCOSName(COSName, COSName)"})
  void testGetCOSNameWithKeyDefaultValue_whenNull() {
    // Arrange, Act and Assert
    assertSame(COSName.A, new COSDictionary().getCOSName(null, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSName(COSName)} with {@code key}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getCOSName(COSName)}
   */
  @Test
  @DisplayName("Test getCOSName(COSName) with 'key'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName COSDictionary.getCOSName(COSName)"})
  void testGetCOSNameWithKey_whenA() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getCOSName(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSName(COSName)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getCOSName(COSName)}
   */
  @Test
  @DisplayName("Test getCOSName(COSName) with 'key'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName COSDictionary.getCOSName(COSName)"})
  void testGetCOSNameWithKey_whenNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getCOSName(null));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(COSName, String)} with {@code COSName}, {@code
   * String}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getNameAsString(COSName, String)}
   */
  @Test
  @DisplayName("Test getNameAsString(COSName, String) with 'COSName', 'String'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getNameAsString(COSName, String)"})
  void testGetNameAsStringWithCOSNameString_whenA() {
    // Arrange, Act and Assert
    assertEquals("42", new COSDictionary().getNameAsString(COSName.A, "42"));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(COSName, String)} with {@code COSName}, {@code
   * String}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getNameAsString(COSName, String)}
   */
  @Test
  @DisplayName("Test getNameAsString(COSName, String) with 'COSName', 'String'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getNameAsString(COSName, String)"})
  void testGetNameAsStringWithCOSNameString_whenNull() {
    // Arrange, Act and Assert
    assertEquals("42", new COSDictionary().getNameAsString((COSName) null, "42"));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getNameAsString(COSName)}
   */
  @Test
  @DisplayName("Test getNameAsString(COSName) with 'COSName'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getNameAsString(COSName)"})
  void testGetNameAsStringWithCOSName_whenA() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getNameAsString(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getNameAsString(COSName)}
   */
  @Test
  @DisplayName("Test getNameAsString(COSName) with 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getNameAsString(COSName)"})
  void testGetNameAsStringWithCOSName_whenNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getNameAsString((COSName) null));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getNameAsString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getNameAsString(String, String) with 'String', 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getNameAsString(String, String)"})
  void testGetNameAsStringWithStringString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("42", new COSDictionary(new COSDictionary()).getNameAsString("Key", "42"));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getNameAsString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getNameAsString(String, String) with 'String', 'String'; given COSDictionary(); when 'Key'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getNameAsString(String, String)"})
  void testGetNameAsStringWithStringString_givenCOSDictionary_whenKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", new COSDictionary().getNameAsString("Key", "42"));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getNameAsString(String)}
   */
  @Test
  @DisplayName("Test getNameAsString(String) with 'String'; given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getNameAsString(String)"})
  void testGetNameAsStringWithString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getNameAsString("Key"));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getNameAsString(String)}
   */
  @Test
  @DisplayName(
      "Test getNameAsString(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getNameAsString(String)"})
  void testGetNameAsStringWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary(new COSDictionary()).getNameAsString("Key"));
  }

  /**
   * Test {@link COSDictionary#getString(COSName, String)} with {@code COSName}, {@code String}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getString(COSName, String)}
   */
  @Test
  @DisplayName("Test getString(COSName, String) with 'COSName', 'String'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getString(COSName, String)"})
  void testGetStringWithCOSNameString_whenA() {
    // Arrange, Act and Assert
    assertEquals("42", new COSDictionary().getString(COSName.A, "42"));
  }

  /**
   * Test {@link COSDictionary#getString(COSName, String)} with {@code COSName}, {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getString(COSName, String)}
   */
  @Test
  @DisplayName("Test getString(COSName, String) with 'COSName', 'String'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getString(COSName, String)"})
  void testGetStringWithCOSNameString_whenNull() {
    // Arrange, Act and Assert
    assertEquals("42", new COSDictionary().getString((COSName) null, "42"));
  }

  /**
   * Test {@link COSDictionary#getString(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getString(COSName)}
   */
  @Test
  @DisplayName("Test getString(COSName) with 'COSName'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getString(COSName)"})
  void testGetStringWithCOSName_whenA() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getString(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getString(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getString(COSName)}
   */
  @Test
  @DisplayName("Test getString(COSName) with 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getString(COSName)"})
  void testGetStringWithCOSName_whenNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getString((COSName) null));
  }

  /**
   * Test {@link COSDictionary#getString(String, String)} with {@code String}, {@code String}.
   * <ul>
   *   <li>When {@code COSDictionary{}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getString(String, String) with 'String', 'String'; when 'COSDictionary{'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getString(String, String)"})
  void testGetStringWithStringString_whenCOSDictionary_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", new COSDictionary().getString("COSDictionary{", "42"));
  }

  /**
   * Test {@link COSDictionary#getString(String, String)} with {@code String}, {@code String}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getString(String, String)}
   */
  @Test
  @DisplayName(
      "Test getString(String, String) with 'String', 'String'; when 'Key'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getString(String, String)"})
  void testGetStringWithStringString_whenKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", new COSDictionary().getString("Key", "42"));
  }

  /**
   * Test {@link COSDictionary#getString(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getString(String)}
   */
  @Test
  @DisplayName("Test getString(String) with 'String'; given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getString(String)"})
  void testGetStringWithString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getString("Key"));
  }

  /**
   * Test {@link COSDictionary#getString(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getString(String)}
   */
  @Test
  @DisplayName(
      "Test getString(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getString(String)"})
  void testGetStringWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary(new COSDictionary()).getString("Key"));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedString(COSName, COSName, String)} with {@code embedded},
   * {@code key}, {@code defaultValue}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getEmbeddedString(COSName, COSName, String)}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedString(COSName, COSName, String) with 'embedded', 'key', 'defaultValue'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getEmbeddedString(COSName, COSName, String)"})
  void testGetEmbeddedStringWithEmbeddedKeyDefaultValue_whenA() {
    // Arrange, Act and Assert
    assertEquals("42", new COSDictionary().getEmbeddedString(COSName.A, COSName.A, "42"));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedString(COSName, COSName, String)} with {@code embedded},
   * {@code key}, {@code defaultValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getEmbeddedString(COSName, COSName, String)}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedString(COSName, COSName, String) with 'embedded', 'key', 'defaultValue'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getEmbeddedString(COSName, COSName, String)"})
  void testGetEmbeddedStringWithEmbeddedKeyDefaultValue_whenNull() {
    // Arrange, Act and Assert
    assertEquals("42", new COSDictionary().getEmbeddedString(null, COSName.A, "42"));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedString(COSName, COSName)} with {@code embedded}, {@code
   * key}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getEmbeddedString(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getEmbeddedString(COSName, COSName) with 'embedded', 'key'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getEmbeddedString(COSName, COSName)"})
  void testGetEmbeddedStringWithEmbeddedKey_whenA() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getEmbeddedString(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedString(COSName, COSName)} with {@code embedded}, {@code
   * key}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getEmbeddedString(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getEmbeddedString(COSName, COSName) with 'embedded', 'key'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSDictionary.getEmbeddedString(COSName, COSName)"})
  void testGetEmbeddedStringWithEmbeddedKey_whenNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getEmbeddedString(null, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getDate(COSName, Calendar)} with {@code COSName}, {@code Calendar}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getDate(COSName, Calendar)}
   */
  @Test
  @DisplayName("Test getDate(COSName, Calendar) with 'COSName', 'Calendar'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar COSDictionary.getDate(COSName, Calendar)"})
  void testGetDateWithCOSNameCalendar_whenA() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    GregorianCalendar defaultValue = new GregorianCalendar(1, 1, 1);

    // Act
    Calendar actualDate = cosDictionary.getDate(COSName.A, defaultValue);

    // Assert
    assertSame(defaultValue, actualDate);
  }

  /**
   * Test {@link COSDictionary#getDate(COSName, Calendar)} with {@code COSName}, {@code Calendar}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getDate(COSName, Calendar)}
   */
  @Test
  @DisplayName("Test getDate(COSName, Calendar) with 'COSName', 'Calendar'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar COSDictionary.getDate(COSName, Calendar)"})
  void testGetDateWithCOSNameCalendar_whenNull() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    GregorianCalendar defaultValue = new GregorianCalendar(1, 1, 1);

    // Act
    Calendar actualDate = cosDictionary.getDate((COSName) null, defaultValue);

    // Assert
    assertSame(defaultValue, actualDate);
  }

  /**
   * Test {@link COSDictionary#getDate(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getDate(COSName)}
   */
  @Test
  @DisplayName("Test getDate(COSName) with 'COSName'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar COSDictionary.getDate(COSName)"})
  void testGetDateWithCOSName_whenA() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getDate(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getDate(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getDate(COSName)}
   */
  @Test
  @DisplayName("Test getDate(COSName) with 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar COSDictionary.getDate(COSName)"})
  void testGetDateWithCOSName_whenNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getDate((COSName) null));
  }

  /**
   * Test {@link COSDictionary#getDate(String, Calendar)} with {@code String}, {@code Calendar}.
   * <ul>
   *   <li>When {@code COSDictionary{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDate(String, Calendar)}
   */
  @Test
  @DisplayName("Test getDate(String, Calendar) with 'String', 'Calendar'; when 'COSDictionary{'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar COSDictionary.getDate(String, Calendar)"})
  void testGetDateWithStringCalendar_whenCOSDictionary() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    GregorianCalendar defaultValue = new GregorianCalendar(1, 1, 1);

    // Act
    Calendar actualDate = cosDictionary.getDate("COSDictionary{", defaultValue);

    // Assert
    assertSame(defaultValue, actualDate);
  }

  /**
   * Test {@link COSDictionary#getDate(String, Calendar)} with {@code String}, {@code Calendar}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getDate(String, Calendar)}
   */
  @Test
  @DisplayName("Test getDate(String, Calendar) with 'String', 'Calendar'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar COSDictionary.getDate(String, Calendar)"})
  void testGetDateWithStringCalendar_whenKey() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    GregorianCalendar defaultValue = new GregorianCalendar(1, 1, 1);

    // Act
    Calendar actualDate = cosDictionary.getDate("Key", defaultValue);

    // Assert
    assertSame(defaultValue, actualDate);
  }

  /**
   * Test {@link COSDictionary#getDate(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getDate(String)}
   */
  @Test
  @DisplayName("Test getDate(String) with 'String'; given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar COSDictionary.getDate(String)"})
  void testGetDateWithString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getDate("Key"));
  }

  /**
   * Test {@link COSDictionary#getDate(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getDate(String)}
   */
  @Test
  @DisplayName(
      "Test getDate(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar COSDictionary.getDate(String)"})
  void testGetDateWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary(new COSDictionary()).getDate("Key"));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedDate(COSName, COSName, Calendar)} with {@code embedded},
   * {@code key}, {@code defaultValue}.
   *
   * <p>Method under test: {@link COSDictionary#getEmbeddedDate(COSName, COSName, Calendar)}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedDate(COSName, COSName, Calendar) with 'embedded', 'key', 'defaultValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar COSDictionary.getEmbeddedDate(COSName, COSName, Calendar)"})
  void testGetEmbeddedDateWithEmbeddedKeyDefaultValue() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    GregorianCalendar defaultValue = new GregorianCalendar(1, 1, 1);

    // Act
    Calendar actualEmbeddedDate = cosDictionary.getEmbeddedDate(COSName.A, COSName.A, defaultValue);

    // Assert
    assertSame(defaultValue, actualEmbeddedDate);
  }

  /**
   * Test {@link COSDictionary#getEmbeddedDate(COSName, COSName, Calendar)} with {@code embedded},
   * {@code key}, {@code defaultValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getEmbeddedDate(COSName, COSName, Calendar)}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedDate(COSName, COSName, Calendar) with 'embedded', 'key', 'defaultValue'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar COSDictionary.getEmbeddedDate(COSName, COSName, Calendar)"})
  void testGetEmbeddedDateWithEmbeddedKeyDefaultValue_whenNull() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    GregorianCalendar defaultValue = new GregorianCalendar(1, 1, 1);

    // Act
    Calendar actualEmbeddedDate = cosDictionary.getEmbeddedDate(null, COSName.A, defaultValue);

    // Assert
    assertSame(defaultValue, actualEmbeddedDate);
  }

  /**
   * Test {@link COSDictionary#getEmbeddedDate(COSName, COSName)} with {@code embedded}, {@code
   * key}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getEmbeddedDate(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getEmbeddedDate(COSName, COSName) with 'embedded', 'key'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar COSDictionary.getEmbeddedDate(COSName, COSName)"})
  void testGetEmbeddedDateWithEmbeddedKey_whenA() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getEmbeddedDate(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedDate(COSName, COSName)} with {@code embedded}, {@code
   * key}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getEmbeddedDate(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getEmbeddedDate(COSName, COSName) with 'embedded', 'key'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar COSDictionary.getEmbeddedDate(COSName, COSName)"})
  void testGetEmbeddedDateWithEmbeddedKey_whenNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getEmbeddedDate(null, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSObject(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getCOSObject(COSName)}
   */
  @Test
  @DisplayName("Test getCOSObject(COSName) with 'COSName'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObject COSDictionary.getCOSObject(COSName)"})
  void testGetCOSObjectWithCOSName_whenA() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getCOSObject(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSObject(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getCOSObject(COSName)}
   */
  @Test
  @DisplayName("Test getCOSObject(COSName) with 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObject COSDictionary.getCOSObject(COSName)"})
  void testGetCOSObjectWithCOSName_whenNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getCOSObject(null));
  }

  /**
   * Test {@link COSDictionary#getCOSDictionary(COSName, COSName)} with {@code firstKey}, {@code
   * secondKey}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getCOSDictionary(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getCOSDictionary(COSName, COSName) with 'firstKey', 'secondKey'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSDictionary.getCOSDictionary(COSName, COSName)"})
  void testGetCOSDictionaryWithFirstKeySecondKey_whenA() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getCOSDictionary(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSDictionary(COSName, COSName)} with {@code firstKey}, {@code
   * secondKey}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getCOSDictionary(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getCOSDictionary(COSName, COSName) with 'firstKey', 'secondKey'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSDictionary.getCOSDictionary(COSName, COSName)"})
  void testGetCOSDictionaryWithFirstKeySecondKey_whenNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getCOSDictionary(COSName.A, null));
  }

  /**
   * Test {@link COSDictionary#getCOSDictionary(COSName, COSName)} with {@code firstKey}, {@code
   * secondKey}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getCOSDictionary(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getCOSDictionary(COSName, COSName) with 'firstKey', 'secondKey'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSDictionary.getCOSDictionary(COSName, COSName)"})
  void testGetCOSDictionaryWithFirstKeySecondKey_whenNull2() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getCOSDictionary(null, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSDictionary(COSName)} with {@code key}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getCOSDictionary(COSName)}
   */
  @Test
  @DisplayName("Test getCOSDictionary(COSName) with 'key'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSDictionary.getCOSDictionary(COSName)"})
  void testGetCOSDictionaryWithKey_whenA() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getCOSDictionary(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSDictionary(COSName)} with {@code key}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getCOSDictionary(COSName)}
   */
  @Test
  @DisplayName("Test getCOSDictionary(COSName) with 'key'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSDictionary.getCOSDictionary(COSName)"})
  void testGetCOSDictionaryWithKey_whenNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getCOSDictionary(null));
  }

  /**
   * Test {@link COSDictionary#getCOSStream(COSName)}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getCOSStream(COSName)}
   */
  @Test
  @DisplayName("Test getCOSStream(COSName); when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream COSDictionary.getCOSStream(COSName)"})
  void testGetCOSStream_whenA() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getCOSStream(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSStream(COSName)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getCOSStream(COSName)}
   */
  @Test
  @DisplayName("Test getCOSStream(COSName); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream COSDictionary.getCOSStream(COSName)"})
  void testGetCOSStream_whenNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getCOSStream(null));
  }

  /**
   * Test {@link COSDictionary#getCOSArray(COSName)}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getCOSArray(COSName)}
   */
  @Test
  @DisplayName("Test getCOSArray(COSName); when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSDictionary.getCOSArray(COSName)"})
  void testGetCOSArray_whenA() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getCOSArray(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSArray(COSName)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getCOSArray(COSName)}
   */
  @Test
  @DisplayName("Test getCOSArray(COSName); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSDictionary.getCOSArray(COSName)"})
  void testGetCOSArray_whenNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getCOSArray(null));
  }

  /**
   * Test {@link COSDictionary#getBoolean(COSName, boolean)} with {@code COSName}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getBoolean(COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(COSName, boolean) with 'COSName', 'boolean'; when A; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.getBoolean(COSName, boolean)"})
  void testGetBooleanWithCOSNameBoolean_whenA_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new COSDictionary().getBoolean(COSName.A, true));
  }

  /**
   * Test {@link COSDictionary#getBoolean(COSName, boolean)} with {@code COSName}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getBoolean(COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(COSName, boolean) with 'COSName', 'boolean'; when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.getBoolean(COSName, boolean)"})
  void testGetBooleanWithCOSNameBoolean_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new COSDictionary().getBoolean(COSName.A, false));
  }

  /**
   * Test {@link COSDictionary#getBoolean(COSName, boolean)} with {@code COSName}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getBoolean(COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(COSName, boolean) with 'COSName', 'boolean'; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.getBoolean(COSName, boolean)"})
  void testGetBooleanWithCOSNameBoolean_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new COSDictionary().getBoolean((COSName) null, true));
  }

  /**
   * Test {@link COSDictionary#getBoolean(COSName, COSName, boolean)} with {@code COSName}, {@code
   * COSName}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getBoolean(COSName, COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(COSName, COSName, boolean) with 'COSName', 'COSName', 'boolean'; when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.getBoolean(COSName, COSName, boolean)"})
  void testGetBooleanWithCOSNameCOSNameBoolean_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new COSDictionary().getBoolean(COSName.A, COSName.A, false));
  }

  /**
   * Test {@link COSDictionary#getBoolean(COSName, COSName, boolean)} with {@code COSName}, {@code
   * COSName}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getBoolean(COSName, COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(COSName, COSName, boolean) with 'COSName', 'COSName', 'boolean'; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.getBoolean(COSName, COSName, boolean)"})
  void testGetBooleanWithCOSNameCOSNameBoolean_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new COSDictionary().getBoolean(COSName.A, null, true));
  }

  /**
   * Test {@link COSDictionary#getBoolean(COSName, COSName, boolean)} with {@code COSName}, {@code
   * COSName}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getBoolean(COSName, COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(COSName, COSName, boolean) with 'COSName', 'COSName', 'boolean'; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.getBoolean(COSName, COSName, boolean)"})
  void testGetBooleanWithCOSNameCOSNameBoolean_whenNull_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(new COSDictionary().getBoolean(null, COSName.A, true));
  }

  /**
   * Test {@link COSDictionary#getBoolean(COSName, COSName, boolean)} with {@code COSName}, {@code
   * COSName}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getBoolean(COSName, COSName, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(COSName, COSName, boolean) with 'COSName', 'COSName', 'boolean'; when 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.getBoolean(COSName, COSName, boolean)"})
  void testGetBooleanWithCOSNameCOSNameBoolean_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new COSDictionary().getBoolean(COSName.A, COSName.A, true));
  }

  /**
   * Test {@link COSDictionary#getBoolean(String, boolean)} with {@code String}, {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String, boolean) with 'String', 'boolean'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.getBoolean(String, boolean)"})
  void testGetBooleanWithStringBoolean_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertTrue(new COSDictionary(new COSDictionary()).getBoolean("Key", true));
  }

  /**
   * Test {@link COSDictionary#getBoolean(String, boolean)} with {@code String}, {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String, boolean) with 'String', 'boolean'; given COSDictionary(); when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.getBoolean(String, boolean)"})
  void testGetBooleanWithStringBoolean_givenCOSDictionary_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new COSDictionary().getBoolean("Key", false));
  }

  /**
   * Test {@link COSDictionary#getBoolean(String, boolean)} with {@code String}, {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@code Key}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test getBoolean(String, boolean) with 'String', 'boolean'; given COSDictionary(); when 'Key'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.getBoolean(String, boolean)"})
  void testGetBooleanWithStringBoolean_givenCOSDictionary_whenKey_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new COSDictionary().getBoolean("Key", true));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedInt(COSName, COSName, int)} with {@code
   * embeddedDictionary}, {@code key}, {@code defaultValue}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getEmbeddedInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedInt(COSName, COSName, int) with 'embeddedDictionary', 'key', 'defaultValue'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getEmbeddedInt(COSName, COSName, int)"})
  void testGetEmbeddedIntWithEmbeddedDictionaryKeyDefaultValue_whenA() {
    // Arrange, Act and Assert
    assertEquals(42, new COSDictionary().getEmbeddedInt(COSName.A, COSName.A, 42));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedInt(COSName, COSName, int)} with {@code
   * embeddedDictionary}, {@code key}, {@code defaultValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getEmbeddedInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedInt(COSName, COSName, int) with 'embeddedDictionary', 'key', 'defaultValue'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getEmbeddedInt(COSName, COSName, int)"})
  void testGetEmbeddedIntWithEmbeddedDictionaryKeyDefaultValue_whenNull() {
    // Arrange, Act and Assert
    assertEquals(42, new COSDictionary().getEmbeddedInt(null, COSName.A, 42));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedInt(COSName, COSName)} with {@code embeddedDictionary},
   * {@code key}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getEmbeddedInt(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getEmbeddedInt(COSName, COSName) with 'embeddedDictionary', 'key'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getEmbeddedInt(COSName, COSName)"})
  void testGetEmbeddedIntWithEmbeddedDictionaryKey_whenA() {
    // Arrange, Act and Assert
    assertEquals(-1, new COSDictionary().getEmbeddedInt(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedInt(COSName, COSName)} with {@code embeddedDictionary},
   * {@code key}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getEmbeddedInt(COSName, COSName)}
   */
  @Test
  @DisplayName(
      "Test getEmbeddedInt(COSName, COSName) with 'embeddedDictionary', 'key'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getEmbeddedInt(COSName, COSName)"})
  void testGetEmbeddedIntWithEmbeddedDictionaryKey_whenNull() {
    // Arrange, Act and Assert
    assertEquals(-1, new COSDictionary().getEmbeddedInt(null, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, COSName, int)} with {@code COSName}, {@code COSName},
   * {@code int}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName("Test getInt(COSName, COSName, int) with 'COSName', 'COSName', 'int'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getInt(COSName, COSName, int)"})
  void testGetIntWithCOSNameCOSNameInt_whenA() {
    // Arrange, Act and Assert
    assertEquals(42, new COSDictionary().getInt(COSName.A, COSName.A, 42));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, COSName, int)} with {@code COSName}, {@code COSName},
   * {@code int}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName("Test getInt(COSName, COSName, int) with 'COSName', 'COSName', 'int'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getInt(COSName, COSName, int)"})
  void testGetIntWithCOSNameCOSNameInt_whenNull() {
    // Arrange, Act and Assert
    assertEquals(42, new COSDictionary().getInt(COSName.A, null, 42));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, COSName, int)} with {@code COSName}, {@code COSName},
   * {@code int}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName("Test getInt(COSName, COSName, int) with 'COSName', 'COSName', 'int'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getInt(COSName, COSName, int)"})
  void testGetIntWithCOSNameCOSNameInt_whenNull2() {
    // Arrange, Act and Assert
    assertEquals(42, new COSDictionary().getInt(null, COSName.A, 42));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, COSName)} with {@code COSName}, {@code COSName}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getInt(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getInt(COSName, COSName) with 'COSName', 'COSName'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getInt(COSName, COSName)"})
  void testGetIntWithCOSNameCOSName_whenA() {
    // Arrange, Act and Assert
    assertEquals(-1, new COSDictionary().getInt(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, COSName)} with {@code COSName}, {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getInt(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getInt(COSName, COSName) with 'COSName', 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getInt(COSName, COSName)"})
  void testGetIntWithCOSNameCOSName_whenNull() {
    // Arrange, Act and Assert
    assertEquals(-1, new COSDictionary().getInt(COSName.A, null));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, COSName)} with {@code COSName}, {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getInt(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getInt(COSName, COSName) with 'COSName', 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getInt(COSName, COSName)"})
  void testGetIntWithCOSNameCOSName_whenNull2() {
    // Arrange, Act and Assert
    assertEquals(-1, new COSDictionary().getInt(null, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, int)} with {@code COSName}, {@code int}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getInt(COSName, int)}
   */
  @Test
  @DisplayName("Test getInt(COSName, int) with 'COSName', 'int'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getInt(COSName, int)"})
  void testGetIntWithCOSNameInt_whenA() {
    // Arrange, Act and Assert
    assertEquals(42, new COSDictionary().getInt(COSName.A, 42));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, int)} with {@code COSName}, {@code int}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getInt(COSName, int)}
   */
  @Test
  @DisplayName("Test getInt(COSName, int) with 'COSName', 'int'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getInt(COSName, int)"})
  void testGetIntWithCOSNameInt_whenNull() {
    // Arrange, Act and Assert
    assertEquals(42, new COSDictionary().getInt((COSName) null, 42));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getInt(COSName)}
   */
  @Test
  @DisplayName("Test getInt(COSName) with 'COSName'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getInt(COSName)"})
  void testGetIntWithCOSName_whenA() {
    // Arrange, Act and Assert
    assertEquals(-1, new COSDictionary().getInt(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getInt(COSName)}
   */
  @Test
  @DisplayName("Test getInt(COSName) with 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getInt(COSName)"})
  void testGetIntWithCOSName_whenNull() {
    // Arrange, Act and Assert
    assertEquals(-1, new COSDictionary().getInt((COSName) null));
  }

  /**
   * Test {@link COSDictionary#getInt(String, int)} with {@code String}, {@code int}.
   * <ul>
   *   <li>When {@code COSArray{}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(String, int) with 'String', 'int'; when 'COSArray{'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getInt(String, int)"})
  void testGetIntWithStringInt_whenCOSArray_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, new COSDictionary().getInt("COSArray{", 42));
  }

  /**
   * Test {@link COSDictionary#getInt(String, int)} with {@code String}, {@code int}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getInt(String, int)}
   */
  @Test
  @DisplayName("Test getInt(String, int) with 'String', 'int'; when 'Key'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getInt(String, int)"})
  void testGetIntWithStringInt_whenKey_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, new COSDictionary().getInt("Key", 42));
  }

  /**
   * Test {@link COSDictionary#getInt(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getInt(String)"})
  void testGetIntWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1, new COSDictionary(new COSDictionary()).getInt("Key"));
  }

  /**
   * Test {@link COSDictionary#getInt(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@code Key}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getInt(String)}
   */
  @Test
  @DisplayName(
      "Test getInt(String) with 'String'; given COSDictionary(); when 'Key'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSDictionary.getInt(String)"})
  void testGetIntWithString_givenCOSDictionary_whenKey_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new COSDictionary().getInt("Key"));
  }

  /**
   * Test {@link COSDictionary#getLong(COSName, long)} with {@code COSName}, {@code long}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getLong(COSName, long)}
   */
  @Test
  @DisplayName("Test getLong(COSName, long) with 'COSName', 'long'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long COSDictionary.getLong(COSName, long)"})
  void testGetLongWithCOSNameLong_whenA() {
    // Arrange, Act and Assert
    assertEquals(42L, new COSDictionary().getLong(COSName.A, 42L));
  }

  /**
   * Test {@link COSDictionary#getLong(COSName, long)} with {@code COSName}, {@code long}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getLong(COSName, long)}
   */
  @Test
  @DisplayName("Test getLong(COSName, long) with 'COSName', 'long'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long COSDictionary.getLong(COSName, long)"})
  void testGetLongWithCOSNameLong_whenNull() {
    // Arrange, Act and Assert
    assertEquals(42L, new COSDictionary().getLong((COSName) null, 42L));
  }

  /**
   * Test {@link COSDictionary#getLong(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getLong(COSName)}
   */
  @Test
  @DisplayName("Test getLong(COSName) with 'COSName'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long COSDictionary.getLong(COSName)"})
  void testGetLongWithCOSName_whenA() {
    // Arrange, Act and Assert
    assertEquals(-1L, new COSDictionary().getLong(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getLong(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getLong(COSName)}
   */
  @Test
  @DisplayName("Test getLong(COSName) with 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long COSDictionary.getLong(COSName)"})
  void testGetLongWithCOSName_whenNull() {
    // Arrange, Act and Assert
    assertEquals(-1L, new COSDictionary().getLong((COSName) null));
  }

  /**
   * Test {@link COSDictionary#getLong(String, long)} with {@code String}, {@code long}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getLong(String, long)}
   */
  @Test
  @DisplayName("Test getLong(String, long) with 'String', 'long'; given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long COSDictionary.getLong(String, long)"})
  void testGetLongWithStringLong_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(42L, new COSDictionary().getLong("Key", 42L));
  }

  /**
   * Test {@link COSDictionary#getLong(String, long)} with {@code String}, {@code long}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getLong(String, long)}
   */
  @Test
  @DisplayName(
      "Test getLong(String, long) with 'String', 'long'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long COSDictionary.getLong(String, long)"})
  void testGetLongWithStringLong_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(42L, new COSDictionary(new COSDictionary()).getLong("Key", 42L));
  }

  /**
   * Test {@link COSDictionary#getLong(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getLong(String)}
   */
  @Test
  @DisplayName("Test getLong(String) with 'String'; given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long COSDictionary.getLong(String)"})
  void testGetLongWithString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1L, new COSDictionary().getLong("Key"));
  }

  /**
   * Test {@link COSDictionary#getLong(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getLong(String)}
   */
  @Test
  @DisplayName(
      "Test getLong(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long COSDictionary.getLong(String)"})
  void testGetLongWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1L, new COSDictionary(new COSDictionary()).getLong("Key"));
  }

  /**
   * Test {@link COSDictionary#getFloat(COSName, float)} with {@code COSName}, {@code float}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getFloat(COSName, float)}
   */
  @Test
  @DisplayName("Test getFloat(COSName, float) with 'COSName', 'float'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float COSDictionary.getFloat(COSName, float)"})
  void testGetFloatWithCOSNameFloat_whenA() {
    // Arrange, Act and Assert
    assertEquals(10.0f, new COSDictionary().getFloat(COSName.A, 10.0f));
  }

  /**
   * Test {@link COSDictionary#getFloat(COSName, float)} with {@code COSName}, {@code float}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getFloat(COSName, float)}
   */
  @Test
  @DisplayName("Test getFloat(COSName, float) with 'COSName', 'float'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float COSDictionary.getFloat(COSName, float)"})
  void testGetFloatWithCOSNameFloat_whenNull() {
    // Arrange, Act and Assert
    assertEquals(10.0f, new COSDictionary().getFloat((COSName) null, 10.0f));
  }

  /**
   * Test {@link COSDictionary#getFloat(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getFloat(COSName)}
   */
  @Test
  @DisplayName("Test getFloat(COSName) with 'COSName'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float COSDictionary.getFloat(COSName)"})
  void testGetFloatWithCOSName_whenA() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, new COSDictionary().getFloat(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getFloat(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getFloat(COSName)}
   */
  @Test
  @DisplayName("Test getFloat(COSName) with 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float COSDictionary.getFloat(COSName)"})
  void testGetFloatWithCOSName_whenNull() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, new COSDictionary().getFloat((COSName) null));
  }

  /**
   * Test {@link COSDictionary#getFloat(String, float)} with {@code String}, {@code float}.
   * <ul>
   *   <li>When {@code COSArray{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getFloat(String, float)}
   */
  @Test
  @DisplayName("Test getFloat(String, float) with 'String', 'float'; when 'COSArray{'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float COSDictionary.getFloat(String, float)"})
  void testGetFloatWithStringFloat_whenCOSArray() {
    // Arrange, Act and Assert
    assertEquals(10.0f, new COSDictionary().getFloat("COSArray{", 10.0f));
  }

  /**
   * Test {@link COSDictionary#getFloat(String, float)} with {@code String}, {@code float}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getFloat(String, float)}
   */
  @Test
  @DisplayName("Test getFloat(String, float) with 'String', 'float'; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float COSDictionary.getFloat(String, float)"})
  void testGetFloatWithStringFloat_whenKey() {
    // Arrange, Act and Assert
    assertEquals(10.0f, new COSDictionary().getFloat("Key", 10.0f));
  }

  /**
   * Test {@link COSDictionary#getFloat(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getFloat(String)}
   */
  @Test
  @DisplayName("Test getFloat(String) with 'String'; given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float COSDictionary.getFloat(String)"})
  void testGetFloatWithString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, new COSDictionary().getFloat("Key"));
  }

  /**
   * Test {@link COSDictionary#getFloat(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getFloat(String)}
   */
  @Test
  @DisplayName(
      "Test getFloat(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float COSDictionary.getFloat(String)"})
  void testGetFloatWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, new COSDictionary(new COSDictionary()).getFloat("Key"));
  }

  /**
   * Test {@link COSDictionary#getFlag(COSName, int)}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getFlag(COSName, int)}
   */
  @Test
  @DisplayName("Test getFlag(COSName, int); when A; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.getFlag(COSName, int)"})
  void testGetFlag_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new COSDictionary().getFlag(COSName.A, 1));
  }

  /**
   * Test {@link COSDictionary#getFlag(COSName, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getFlag(COSName, int)}
   */
  @Test
  @DisplayName("Test getFlag(COSName, int); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.getFlag(COSName, int)"})
  void testGetFlag_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new COSDictionary().getFlag(null, 1));
  }

  /**
   * Test {@link COSDictionary#getFlag(COSName, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getFlag(COSName, int)}
   */
  @Test
  @DisplayName("Test getFlag(COSName, int); when zero; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.getFlag(COSName, int)"})
  void testGetFlag_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new COSDictionary().getFlag(COSName.A, 0));
  }

  /**
   * Test {@link COSDictionary#getItem(COSName, COSName)} with {@code COSName}, {@code COSName}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getItem(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getItem(COSName, COSName) with 'COSName', 'COSName'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getItem(COSName, COSName)"})
  void testGetItemWithCOSNameCOSName_whenA() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getItem(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getItem(COSName, COSName)} with {@code COSName}, {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getItem(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getItem(COSName, COSName) with 'COSName', 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getItem(COSName, COSName)"})
  void testGetItemWithCOSNameCOSName_whenNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getItem(COSName.A, null));
  }

  /**
   * Test {@link COSDictionary#getItem(COSName, COSName)} with {@code COSName}, {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getItem(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getItem(COSName, COSName) with 'COSName', 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getItem(COSName, COSName)"})
  void testGetItemWithCOSNameCOSName_whenNull2() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getItem(null, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getItem(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getItem(COSName)}
   */
  @Test
  @DisplayName("Test getItem(COSName) with 'COSName'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getItem(COSName)"})
  void testGetItemWithCOSName_whenA() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getItem(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getItem(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getItem(COSName)}
   */
  @Test
  @DisplayName("Test getItem(COSName) with 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getItem(COSName)"})
  void testGetItemWithCOSName_whenNull() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getItem((COSName) null));
  }

  /**
   * Test {@link COSDictionary#getItem(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getItem(String)}
   */
  @Test
  @DisplayName("Test getItem(String) with 'String'; given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getItem(String)"})
  void testGetItemWithString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getItem("Key"));
  }

  /**
   * Test {@link COSDictionary#getItem(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getItem(String)}
   */
  @Test
  @DisplayName(
      "Test getItem(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getItem(String)"})
  void testGetItemWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary(new COSDictionary()).getItem("Key"));
  }

  /**
   * Test {@link COSDictionary#keySet()}.
   *
   * <p>Method under test: {@link COSDictionary#keySet()}
   */
  @Test
  @DisplayName("Test keySet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set COSDictionary.keySet()"})
  void testKeySet() {
    // Arrange, Act and Assert
    assertTrue(new COSDictionary().keySet().isEmpty());
  }

  /**
   * Test {@link COSDictionary#entrySet()}.
   *
   * <p>Method under test: {@link COSDictionary#entrySet()}
   */
  @Test
  @DisplayName("Test entrySet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set COSDictionary.entrySet()"})
  void testEntrySet() {
    // Arrange, Act and Assert
    assertTrue(new COSDictionary().entrySet().isEmpty());
  }

  /**
   * Test {@link COSDictionary#getValues()}.
   *
   * <p>Method under test: {@link COSDictionary#getValues()}
   */
  @Test
  @DisplayName("Test getValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection COSDictionary.getValues()"})
  void testGetValues() {
    // Arrange, Act and Assert
    assertTrue(new COSDictionary().getValues().isEmpty());
  }

  /**
   * Test {@link COSDictionary#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link COSWriter#visitFromDictionary(COSDictionary)}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); then calls visitFromDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.accept(ICOSVisitor)"})
  void testAccept_thenCallsVisitFromDictionary() throws IOException {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromDictionary(Mockito.<COSDictionary>any());

    // Act
    cosDictionary.accept(visitor);

    // Assert
    verify(visitor).visitFromDictionary(isA(COSDictionary.class));
  }

  /**
   * Test {@link COSDictionary#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>When {@link COSWriter} {@link COSWriter#visitFromStream(COSStream)} does nothing.
   *   <li>Then calls {@link COSWriter#visitFromStream(COSStream)}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(ICOSVisitor); when COSWriter visitFromStream(COSStream) does nothing; then calls visitFromStream(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.accept(ICOSVisitor)"})
  void testAccept_whenCOSWriterVisitFromStreamDoesNothing_thenCallsVisitFromStream()
      throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromStream(Mockito.<COSStream>any());

    // Act
    cosStream.accept(visitor);

    // Assert
    verify(visitor).visitFromStream(isA(COSStream.class));
  }

  /**
   * Test {@link COSDictionary#addAll(COSDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#addAll(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test addAll(COSDictionary); given COSDictionary(); when COSDictionary(); then COSDictionary() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.addAll(COSDictionary)"})
  void testAddAll_givenCOSDictionary_whenCOSDictionary_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSDictionary dict = new COSDictionary();

    // Act
    cosDictionary.addAll(dict);

    // Assert that nothing has changed
    assertEquals(0, dict.size());
    assertTrue(dict.getValues().isEmpty());
    assertTrue(dict.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#addAll(COSDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#addAll(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test addAll(COSDictionary); given COSDictionary(); when COSStream(); then COSDictionary() Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.addAll(COSDictionary)"})
  void testAddAll_givenCOSDictionary_whenCOSStream_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSStream dict = new COSStream();

    // Act
    cosDictionary.addAll(dict);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, dict.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#containsKey(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#containsKey(COSName)}
   */
  @Test
  @DisplayName("Test containsKey(COSName) with 'COSName'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.containsKey(COSName)"})
  void testContainsKeyWithCOSName_whenA() {
    // Arrange, Act and Assert
    assertFalse(new COSDictionary().containsKey(COSName.A));
  }

  /**
   * Test {@link COSDictionary#containsKey(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#containsKey(COSName)}
   */
  @Test
  @DisplayName("Test containsKey(COSName) with 'COSName'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.containsKey(COSName)"})
  void testContainsKeyWithCOSName_whenNull() {
    // Arrange, Act and Assert
    assertFalse(new COSDictionary().containsKey((COSName) null));
  }

  /**
   * Test {@link COSDictionary#containsKey(String)} with {@code String}.
   * <ul>
   *   <li>When {@code COSArray{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#containsKey(String)}
   */
  @Test
  @DisplayName("Test containsKey(String) with 'String'; when 'COSArray{'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.containsKey(String)"})
  void testContainsKeyWithString_whenCOSArray() {
    // Arrange, Act and Assert
    assertFalse(new COSDictionary().containsKey("COSArray{"));
  }

  /**
   * Test {@link COSDictionary#containsKey(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#containsKey(String)}
   */
  @Test
  @DisplayName("Test containsKey(String) with 'String'; when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDictionary.containsKey(String)"})
  void testContainsKeyWithString_whenName() {
    // Arrange, Act and Assert
    assertFalse(new COSDictionary().containsKey("Name"));
  }

  /**
   * Test {@link COSDictionary#getObjectFromPath(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getObjectFromPath(String)}
   */
  @Test
  @DisplayName("Test getObjectFromPath(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getObjectFromPath(String)"})
  void testGetObjectFromPath_whenEmptyString() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getObjectFromPath(""));
  }

  /**
   * Test {@link COSDictionary#getObjectFromPath(String)}.
   *
   * <ul>
   *   <li>When {@code foo/bar}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getObjectFromPath(String)}
   */
  @Test
  @DisplayName("Test getObjectFromPath(String); when 'foo/bar'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getObjectFromPath(String)"})
  void testGetObjectFromPath_whenFooBar() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getObjectFromPath("foo/bar"));
  }

  /**
   * Test {@link COSDictionary#getObjectFromPath(String)}.
   *
   * <ul>
   *   <li>When {@code Obj Path}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getObjectFromPath(String)}
   */
  @Test
  @DisplayName("Test getObjectFromPath(String); when 'Obj Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSDictionary.getObjectFromPath(String)"})
  void testGetObjectFromPath_whenObjPath() {
    // Arrange, Act and Assert
    assertNull(new COSDictionary().getObjectFromPath("Obj Path"));
  }

  /**
   * Test {@link COSDictionary#asUnmodifiableDictionary()}.
   *
   * <p>Method under test: {@link COSDictionary#asUnmodifiableDictionary()}
   */
  @Test
  @DisplayName("Test asUnmodifiableDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSDictionary.asUnmodifiableDictionary()"})
  void testAsUnmodifiableDictionary() {
    // Arrange and Act
    COSDictionary actualAsUnmodifiableDictionaryResult =
        new COSDictionary().asUnmodifiableDictionary();

    // Assert
    assertTrue(actualAsUnmodifiableDictionaryResult instanceof UnmodifiableCOSDictionary);
    COSUpdateState updateState = actualAsUnmodifiableDictionaryResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualAsUnmodifiableDictionaryResult.getKey());
    assertEquals(0, actualAsUnmodifiableDictionaryResult.size());
    COSIncrement toIncrementResult = actualAsUnmodifiableDictionaryResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualAsUnmodifiableDictionaryResult.isDirect());
    assertFalse(actualAsUnmodifiableDictionaryResult.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(actualAsUnmodifiableDictionaryResult.getValues().isEmpty());
    assertTrue(((UnmodifiableCOSDictionary) actualAsUnmodifiableDictionaryResult).items.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSDictionary#toString()}
   *   <li>{@link COSDictionary#getUpdateState()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "COSUpdateState COSDictionary.getUpdateState()",
    "String COSDictionary.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    String actualToStringResult = cosDictionary.toString();
    COSUpdateState actualUpdateState = cosDictionary.getUpdateState();

    // Assert
    assertEquals("COSDictionary{}", actualToStringResult);
    assertNull(actualUpdateState.getOriginDocumentState());
    COSIncrement toIncrementResult = actualUpdateState.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualUpdateState.isAcceptingUpdates());
    assertFalse(actualUpdateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDictionary#getIndirectObjectKeys(Collection)}.
   *
   * <p>Method under test: {@link COSDictionary#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary(new COSDictionary());
    COSObjectKey key = new COSObjectKey(1L, 1);
    cosDictionary.setKey(key);
    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();

    // Act
    cosDictionary.getIndirectObjectKeys(indirectObjects);

    // Assert
    assertEquals(1, indirectObjects.size());
    assertSame(key, indirectObjects.get(0));
    assertSame(key, cosDictionary.getKey());
  }

  /**
   * Test {@link COSDictionary#getIndirectObjectKeys(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName(
      "Test getIndirectObjectKeys(Collection); given COSDictionary(); when ArrayList(); then ArrayList() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys_givenCOSDictionary_whenArrayList_thenArrayListEmpty() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();

    // Act
    cosDictionary.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    assertTrue(indirectObjects.isEmpty());
  }

  /**
   * Test {@link COSDictionary#getIndirectObjectKeys(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName(
      "Test getIndirectObjectKeys(Collection); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary(new COSDictionary());
    COSObjectKey key = new COSObjectKey(1L, 1);
    cosDictionary.setKey(key);

    LinkedHashSet<COSObjectKey> indirectObjects = new LinkedHashSet<>();
    indirectObjects.add(new COSObjectKey(1L, 1));

    // Act
    cosDictionary.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    assertEquals(1, indirectObjects.size());
    assertSame(key, cosDictionary.getKey());
  }

  /**
   * Test {@link COSDictionary#getIndirectObjectKeys(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName(
      "Test getIndirectObjectKeys(Collection); given COSObjectKey(long, int) with num is one and gen is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys_givenCOSObjectKeyWithNumIsOneAndGenIsZero() {
    // Arrange
    COSStream cosStream = new COSStream();

    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();
    indirectObjects.add(new COSObjectKey(1L, 0));

    // Act
    cosStream.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    assertEquals(1, indirectObjects.size());
    COSObjectKey getResult = indirectObjects.get(0);
    assertEquals(0, getResult.getGeneration());
    assertEquals(65536L, getResult.getInternalHash());
  }

  /**
   * Test {@link COSDictionary#getIndirectObjectKeys(Collection)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link LinkedHashSet#LinkedHashSet()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName(
      "Test getIndirectObjectKeys(Collection); given 'null'; then LinkedHashSet() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys_givenNull_thenLinkedHashSetSizeIsTwo() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary(new COSDictionary());
    COSObjectKey key = new COSObjectKey(1L, 1);
    cosDictionary.setKey(key);

    LinkedHashSet<COSObjectKey> indirectObjects = new LinkedHashSet<>();
    indirectObjects.add(null);

    // Act
    cosDictionary.getIndirectObjectKeys(indirectObjects);

    // Assert
    assertEquals(2, indirectObjects.size());
    assertSame(key, cosDictionary.getKey());
  }

  /**
   * Test {@link COSDictionary#getIndirectObjectKeys(Collection)}.
   *
   * <ul>
   *   <li>Then {@link LinkedHashSet#LinkedHashSet()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection); then LinkedHashSet() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys_thenLinkedHashSetSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary(new COSDictionary());
    cosDictionary.setKey(null);

    LinkedHashSet<COSObjectKey> indirectObjects = new LinkedHashSet<>();
    indirectObjects.add(null);

    // Act
    cosDictionary.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    assertEquals(1, indirectObjects.size());
  }

  /**
   * Test {@link COSDictionary#getIndirectObjectKeys(Collection)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDictionary#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection); when 'null'; then 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDictionary.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys_whenNull_thenNull() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary(new COSDictionary());
    cosDictionary.setKey(null);

    // Act
    cosDictionary.getIndirectObjectKeys(null);

    // Assert that nothing has changed
    assertNull(null);
    assertNull(cosDictionary.getKey());
  }
}
