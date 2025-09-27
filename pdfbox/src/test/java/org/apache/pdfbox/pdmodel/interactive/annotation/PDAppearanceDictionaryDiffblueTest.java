package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAppearanceDictionaryDiffblueTest {
  /**
   * Test {@link PDAppearanceDictionary#PDAppearanceDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link PDAppearanceDictionary#PDAppearanceDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAppearanceDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.<init>(COSDictionary)"})
  void testNewPDAppearanceDictionary() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, new PDAppearanceDictionary(dictionary).getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#PDAppearanceDictionary()}.
   *
   * <p>Method under test: {@link PDAppearanceDictionary#PDAppearanceDictionary()}
   */
  @Test
  @DisplayName("Test new PDAppearanceDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.<init>()"})
  void testNewPDAppearanceDictionary2() {
    // Arrange and Act
    PDAppearanceDictionary actualPdAppearanceDictionary = new PDAppearanceDictionary();

    // Assert
    COSDictionary cOSObject = actualPdAppearanceDictionary.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    PDAppearanceEntry downAppearance = actualPdAppearanceDictionary.getDownAppearance();
    assertFalse(downAppearance.isStream());
    PDAppearanceEntry normalAppearance = actualPdAppearanceDictionary.getNormalAppearance();
    assertFalse(normalAppearance.isStream());
    PDAppearanceEntry rolloverAppearance = actualPdAppearanceDictionary.getRolloverAppearance();
    assertFalse(rolloverAppearance.isStream());
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    assertTrue(normalAppearance.getSubDictionary().isEmpty());
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(downAppearance.isSubDictionary());
    assertTrue(normalAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isSubDictionary());
  }

  /**
   * Test {@link PDAppearanceDictionary#getCOSObject()}.
   *
   * <p>Method under test: {@link PDAppearanceDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDAppearanceDictionary.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDAppearanceDictionary().getCOSObject();

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
   * Test {@link PDAppearanceDictionary#getNormalAppearance()}.
   *
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#getNormalAppearance()}
   */
  @Test
  @DisplayName("Test getNormalAppearance(); then return COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAppearanceDictionary.getNormalAppearance()"})
  void testGetNormalAppearance_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDictionary entry = new COSDictionary();
    entry.setKey(new COSObjectKey(1L, 1));
    PDAppearanceEntry entry2 = new PDAppearanceEntry(entry);

    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    pdAppearanceDictionary.setNormalAppearance(entry2);

    // Act and Assert
    assertSame(entry, pdAppearanceDictionary.getNormalAppearance().getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#getNormalAppearance()}.
   *
   * <ul>
   *   <li>Then return COSObject UpdateState OriginDocumentState is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#getNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test getNormalAppearance(); then return COSObject UpdateState OriginDocumentState is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAppearanceDictionary.getNormalAppearance()"})
  void testGetNormalAppearance_thenReturnCOSObjectUpdateStateOriginDocumentStateIsNull() {
    // Arrange and Act
    PDAppearanceEntry actualNormalAppearance = new PDAppearanceDictionary().getNormalAppearance();

    // Assert
    COSDictionary cOSObject = actualNormalAppearance.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualNormalAppearance.isStream());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(actualNormalAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualNormalAppearance.isSubDictionary());
  }

  /**
   * Test {@link PDAppearanceDictionary#getNormalAppearance()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#getNormalAppearance()}
   */
  @Test
  @DisplayName("Test getNormalAppearance(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAppearanceDictionary.getNormalAppearance()"})
  void testGetNormalAppearance_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceDictionary(new COSDictionary()).getNormalAppearance());
  }

  /**
   * Test {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceStream)} with {@code ap}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test setNormalAppearance(PDAppearanceStream) with 'ap'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setNormalAppearance(PDAppearanceStream)"})
  void testSetNormalAppearanceWithAp_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSStream stream = new COSStream();
    stream.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAppearanceDictionary.setNormalAppearance(new PDAppearanceStream(stream));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    assertFalse(downAppearance.isSubDictionary());
    PDAppearanceEntry normalAppearance = pdAppearanceDictionary.getNormalAppearance();
    assertFalse(normalAppearance.isSubDictionary());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertSame(stream, downAppearance.getCOSObject());
    assertSame(stream, normalAppearance.getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceStream)} with {@code ap}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test setNormalAppearance(PDAppearanceStream) with 'ap'; given 'true'; when COSStream() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setNormalAppearance(PDAppearanceStream)"})
  void testSetNormalAppearanceWithAp_givenTrue_whenCOSStreamDirectIsTrue() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSStream stream = new COSStream();
    stream.setDirect(true);

    // Act
    pdAppearanceDictionary.setNormalAppearance(new PDAppearanceStream(stream));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    assertFalse(downAppearance.isSubDictionary());
    PDAppearanceEntry normalAppearance = pdAppearanceDictionary.getNormalAppearance();
    assertFalse(normalAppearance.isSubDictionary());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertSame(stream, downAppearance.getCOSObject());
    assertSame(stream, normalAppearance.getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceStream)} with {@code ap}.
   *
   * <ul>
   *   <li>Then {@link PDAppearanceDictionary#PDAppearanceDictionary()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test setNormalAppearance(PDAppearanceStream) with 'ap'; then PDAppearanceDictionary() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setNormalAppearance(PDAppearanceStream)"})
  void testSetNormalAppearanceWithAp_thenPDAppearanceDictionaryCOSObjectValuesSizeIsOne() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSStream stream = new COSStream();

    // Act
    pdAppearanceDictionary.setNormalAppearance(new PDAppearanceStream(stream));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    assertFalse(downAppearance.isSubDictionary());
    PDAppearanceEntry normalAppearance = pdAppearanceDictionary.getNormalAppearance();
    assertFalse(normalAppearance.isSubDictionary());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(downAppearance.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertSame(stream, downAppearance.getCOSObject());
    assertSame(stream, normalAppearance.getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceStream)} with {@code ap}.
   *
   * <ul>
   *   <li>Then {@link PDAppearanceDictionary#PDAppearanceDictionary()} DownAppearance is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test setNormalAppearance(PDAppearanceStream) with 'ap'; then PDAppearanceDictionary() DownAppearance is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setNormalAppearance(PDAppearanceStream)"})
  void testSetNormalAppearanceWithAp_thenPDAppearanceDictionaryDownAppearanceIsNull() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    // Act
    pdAppearanceDictionary.setNormalAppearance((PDAppearanceStream) null);

    // Assert
    assertNull(pdAppearanceDictionary.getDownAppearance());
    assertNull(pdAppearanceDictionary.getNormalAppearance());
    assertNull(pdAppearanceDictionary.getRolloverAppearance());
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)} with {@code entry}.
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}
   */
  @Test
  @DisplayName("Test setNormalAppearance(PDAppearanceEntry) with 'entry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setNormalAppearance(PDAppearanceEntry)"})
  void testSetNormalAppearanceWithEntry() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSDictionary entry = new COSDictionary();

    // Act
    pdAppearanceDictionary.setNormalAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(entry, pdAppearanceDictionary.getDownAppearance().getCOSObject());
    assertSame(entry, pdAppearanceDictionary.getNormalAppearance().getCOSObject());
    assertSame(entry, pdAppearanceDictionary.getRolloverAppearance().getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)} with {@code entry}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}
   */
  @Test
  @DisplayName(
      "Test setNormalAppearance(PDAppearanceEntry) with 'entry'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setNormalAppearance(PDAppearanceEntry)"})
  void testSetNormalAppearanceWithEntry_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSDictionary entry = new COSDictionary();
    entry.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAppearanceDictionary.setNormalAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(entry, pdAppearanceDictionary.getDownAppearance().getCOSObject());
    assertSame(entry, pdAppearanceDictionary.getNormalAppearance().getCOSObject());
    assertSame(entry, pdAppearanceDictionary.getRolloverAppearance().getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)} with {@code entry}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}
   */
  @Test
  @DisplayName(
      "Test setNormalAppearance(PDAppearanceEntry) with 'entry'; given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setNormalAppearance(PDAppearanceEntry)"})
  void testSetNormalAppearanceWithEntry_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSDictionary entry = new COSDictionary();
    entry.setDirect(true);

    // Act
    pdAppearanceDictionary.setNormalAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(entry, pdAppearanceDictionary.getDownAppearance().getCOSObject());
    assertSame(entry, pdAppearanceDictionary.getNormalAppearance().getCOSObject());
    assertSame(entry, pdAppearanceDictionary.getRolloverAppearance().getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)} with {@code entry}.
   *
   * <ul>
   *   <li>Then {@link PDAppearanceDictionary#PDAppearanceDictionary()} DownAppearance is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}
   */
  @Test
  @DisplayName(
      "Test setNormalAppearance(PDAppearanceEntry) with 'entry'; then PDAppearanceDictionary() DownAppearance is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setNormalAppearance(PDAppearanceEntry)"})
  void testSetNormalAppearanceWithEntry_thenPDAppearanceDictionaryDownAppearanceIsNull() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    // Act
    pdAppearanceDictionary.setNormalAppearance((PDAppearanceEntry) null);

    // Assert
    assertNull(pdAppearanceDictionary.getDownAppearance());
    assertNull(pdAppearanceDictionary.getNormalAppearance());
    assertNull(pdAppearanceDictionary.getRolloverAppearance());
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAppearanceDictionary#getRolloverAppearance()}.
   *
   * <p>Method under test: {@link PDAppearanceDictionary#getRolloverAppearance()}
   */
  @Test
  @DisplayName("Test getRolloverAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAppearanceDictionary.getRolloverAppearance()"})
  void testGetRolloverAppearance() {
    // Arrange and Act
    PDAppearanceEntry actualRolloverAppearance =
        new PDAppearanceDictionary().getRolloverAppearance();

    // Assert
    COSDictionary cOSObject = actualRolloverAppearance.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualRolloverAppearance.isStream());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(actualRolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualRolloverAppearance.isSubDictionary());
  }

  /**
   * Test {@link PDAppearanceDictionary#getRolloverAppearance()}.
   *
   * <p>Method under test: {@link PDAppearanceDictionary#getRolloverAppearance()}
   */
  @Test
  @DisplayName("Test getRolloverAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAppearanceDictionary.getRolloverAppearance()"})
  void testGetRolloverAppearance2() {
    // Arrange
    COSDictionary entry = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    entry.setKey(key);
    PDAppearanceEntry entry2 = new PDAppearanceEntry(entry);

    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    pdAppearanceDictionary.setRolloverAppearance(entry2);

    // Act and Assert
    assertSame(key, pdAppearanceDictionary.getRolloverAppearance().getCOSObject().getKey());
  }

  /**
   * Test {@link PDAppearanceDictionary#getRolloverAppearance()}.
   *
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#getRolloverAppearance()}
   */
  @Test
  @DisplayName("Test getRolloverAppearance(); then return COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAppearanceDictionary.getRolloverAppearance()"})
  void testGetRolloverAppearance_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSDictionary entry = new COSDictionary();
    pdAppearanceDictionary.setRolloverAppearance(new PDAppearanceEntry(entry));

    // Act
    PDAppearanceEntry actualRolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();

    // Assert
    assertFalse(actualRolloverAppearance.isStream());
    assertTrue(actualRolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(actualRolloverAppearance.isSubDictionary());
    assertSame(entry, actualRolloverAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#getRolloverAppearance()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#getRolloverAppearance()}
   */
  @Test
  @DisplayName("Test getRolloverAppearance(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAppearanceDictionary.getRolloverAppearance()"})
  void testGetRolloverAppearance_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceDictionary(new COSDictionary()).getRolloverAppearance());
  }

  /**
   * Test {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceStream)} with {@code ap}.
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test setRolloverAppearance(PDAppearanceStream) with 'ap'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setRolloverAppearance(PDAppearanceStream)"})
  void testSetRolloverAppearanceWithAp() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSStream stream = new COSStream();

    // Act
    pdAppearanceDictionary.setRolloverAppearance(new PDAppearanceStream(stream));

    // Assert
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    PDAppearanceStream appearanceStream = rolloverAppearance.getAppearanceStream();
    assertNull(appearanceStream.getResources());
    assertNull(appearanceStream.getBBox());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(1, appearanceStream.getFormType());
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isStream());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceStream)} with {@code ap}.
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceStream)}
   */
  @Test
  @DisplayName("Test setRolloverAppearance(PDAppearanceStream) with 'ap'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setRolloverAppearance(PDAppearanceStream)"})
  void testSetRolloverAppearanceWithAp2() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    // Act
    pdAppearanceDictionary.setRolloverAppearance((PDAppearanceStream) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    assertFalse(rolloverAppearance.isStream());
    assertTrue(rolloverAppearance.isSubDictionary());
  }

  /**
   * Test {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceStream)} with {@code ap}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test setRolloverAppearance(PDAppearanceStream) with 'ap'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setRolloverAppearance(PDAppearanceStream)"})
  void testSetRolloverAppearanceWithAp_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSStream stream = new COSStream();
    stream.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAppearanceDictionary.setRolloverAppearance(new PDAppearanceStream(stream));

    // Assert
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    PDAppearanceStream appearanceStream = rolloverAppearance.getAppearanceStream();
    assertNull(appearanceStream.getResources());
    assertNull(appearanceStream.getBBox());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(1, appearanceStream.getFormType());
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isStream());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceStream)} with {@code ap}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test setRolloverAppearance(PDAppearanceStream) with 'ap'; given 'true'; when COSStream() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setRolloverAppearance(PDAppearanceStream)"})
  void testSetRolloverAppearanceWithAp_givenTrue_whenCOSStreamDirectIsTrue() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSStream stream = new COSStream();
    stream.setDirect(true);

    // Act
    pdAppearanceDictionary.setRolloverAppearance(new PDAppearanceStream(stream));

    // Assert
    PDAppearanceEntry rolloverAppearance = pdAppearanceDictionary.getRolloverAppearance();
    PDAppearanceStream appearanceStream = rolloverAppearance.getAppearanceStream();
    assertNull(appearanceStream.getResources());
    assertNull(appearanceStream.getBBox());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(1, appearanceStream.getFormType());
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isStream());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceEntry)} with {@code
   * entry}.
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceEntry)}
   */
  @Test
  @DisplayName("Test setRolloverAppearance(PDAppearanceEntry) with 'entry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setRolloverAppearance(PDAppearanceEntry)"})
  void testSetRolloverAppearanceWithEntry() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSDictionary entry = new COSDictionary();

    // Act
    pdAppearanceDictionary.setRolloverAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(entry, pdAppearanceDictionary.getRolloverAppearance().getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceEntry)} with {@code
   * entry}.
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceEntry)}
   */
  @Test
  @DisplayName("Test setRolloverAppearance(PDAppearanceEntry) with 'entry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setRolloverAppearance(PDAppearanceEntry)"})
  void testSetRolloverAppearanceWithEntry2() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    // Act
    pdAppearanceDictionary.setRolloverAppearance((PDAppearanceEntry) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceEntry)} with {@code
   * entry}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceEntry)}
   */
  @Test
  @DisplayName(
      "Test setRolloverAppearance(PDAppearanceEntry) with 'entry'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setRolloverAppearance(PDAppearanceEntry)"})
  void testSetRolloverAppearanceWithEntry_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSDictionary entry = new COSDictionary();
    entry.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAppearanceDictionary.setRolloverAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(entry, pdAppearanceDictionary.getRolloverAppearance().getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceEntry)} with {@code
   * entry}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setRolloverAppearance(PDAppearanceEntry)}
   */
  @Test
  @DisplayName(
      "Test setRolloverAppearance(PDAppearanceEntry) with 'entry'; given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setRolloverAppearance(PDAppearanceEntry)"})
  void testSetRolloverAppearanceWithEntry_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSDictionary entry = new COSDictionary();
    entry.setDirect(true);

    // Act
    pdAppearanceDictionary.setRolloverAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(entry, pdAppearanceDictionary.getRolloverAppearance().getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#getDownAppearance()}.
   *
   * <p>Method under test: {@link PDAppearanceDictionary#getDownAppearance()}
   */
  @Test
  @DisplayName("Test getDownAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAppearanceDictionary.getDownAppearance()"})
  void testGetDownAppearance() {
    // Arrange
    COSDictionary entry = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    entry.setKey(key);
    PDAppearanceEntry entry2 = new PDAppearanceEntry(entry);

    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    pdAppearanceDictionary.setDownAppearance(entry2);

    // Act and Assert
    assertSame(key, pdAppearanceDictionary.getDownAppearance().getCOSObject().getKey());
  }

  /**
   * Test {@link PDAppearanceDictionary#getDownAppearance()}.
   *
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#getDownAppearance()}
   */
  @Test
  @DisplayName("Test getDownAppearance(); then return COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAppearanceDictionary.getDownAppearance()"})
  void testGetDownAppearance_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSDictionary entry = new COSDictionary();
    pdAppearanceDictionary.setDownAppearance(new PDAppearanceEntry(entry));

    // Act
    PDAppearanceEntry actualDownAppearance = pdAppearanceDictionary.getDownAppearance();

    // Assert
    assertFalse(actualDownAppearance.isStream());
    assertTrue(actualDownAppearance.getSubDictionary().isEmpty());
    assertTrue(actualDownAppearance.isSubDictionary());
    assertSame(entry, actualDownAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#getDownAppearance()}.
   *
   * <ul>
   *   <li>Then return COSObject UpdateState OriginDocumentState is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#getDownAppearance()}
   */
  @Test
  @DisplayName(
      "Test getDownAppearance(); then return COSObject UpdateState OriginDocumentState is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAppearanceDictionary.getDownAppearance()"})
  void testGetDownAppearance_thenReturnCOSObjectUpdateStateOriginDocumentStateIsNull() {
    // Arrange and Act
    PDAppearanceEntry actualDownAppearance = new PDAppearanceDictionary().getDownAppearance();

    // Assert
    COSDictionary cOSObject = actualDownAppearance.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualDownAppearance.isStream());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(actualDownAppearance.getSubDictionary().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualDownAppearance.isSubDictionary());
  }

  /**
   * Test {@link PDAppearanceDictionary#getDownAppearance()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#getDownAppearance()}
   */
  @Test
  @DisplayName("Test getDownAppearance(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAppearanceDictionary.getDownAppearance()"})
  void testGetDownAppearance_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceDictionary(new COSDictionary()).getDownAppearance());
  }

  /**
   * Test {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceStream)} with {@code ap}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test setDownAppearance(PDAppearanceStream) with 'ap'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setDownAppearance(PDAppearanceStream)"})
  void testSetDownAppearanceWithAp_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSStream stream = new COSStream();
    stream.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAppearanceDictionary.setDownAppearance(new PDAppearanceStream(stream));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    assertFalse(downAppearance.isSubDictionary());
    assertTrue(downAppearance.isStream());
    assertSame(stream, downAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceStream)} with {@code ap}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test setDownAppearance(PDAppearanceStream) with 'ap'; given 'true'; when COSStream() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setDownAppearance(PDAppearanceStream)"})
  void testSetDownAppearanceWithAp_givenTrue_whenCOSStreamDirectIsTrue() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSStream stream = new COSStream();
    stream.setDirect(true);

    // Act
    pdAppearanceDictionary.setDownAppearance(new PDAppearanceStream(stream));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    assertFalse(downAppearance.isSubDictionary());
    assertTrue(downAppearance.isStream());
    assertSame(stream, downAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceStream)} with {@code ap}.
   *
   * <ul>
   *   <li>Then {@link PDAppearanceDictionary#PDAppearanceDictionary()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test setDownAppearance(PDAppearanceStream) with 'ap'; then PDAppearanceDictionary() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setDownAppearance(PDAppearanceStream)"})
  void testSetDownAppearanceWithAp_thenPDAppearanceDictionaryCOSObjectValuesSizeIsOne() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    // Act
    pdAppearanceDictionary.setDownAppearance((PDAppearanceStream) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    assertFalse(downAppearance.isStream());
    assertTrue(downAppearance.isSubDictionary());
  }

  /**
   * Test {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceStream)} with {@code ap}.
   *
   * <ul>
   *   <li>Then {@link PDAppearanceDictionary#PDAppearanceDictionary()} COSObject Values size is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceStream)}
   */
  @Test
  @DisplayName(
      "Test setDownAppearance(PDAppearanceStream) with 'ap'; then PDAppearanceDictionary() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setDownAppearance(PDAppearanceStream)"})
  void testSetDownAppearanceWithAp_thenPDAppearanceDictionaryCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSStream stream = new COSStream();

    // Act
    pdAppearanceDictionary.setDownAppearance(new PDAppearanceStream(stream));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    PDAppearanceEntry downAppearance = pdAppearanceDictionary.getDownAppearance();
    assertFalse(downAppearance.isSubDictionary());
    assertTrue(downAppearance.isStream());
    assertSame(stream, downAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceEntry)} with {@code entry}.
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceEntry)}
   */
  @Test
  @DisplayName("Test setDownAppearance(PDAppearanceEntry) with 'entry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setDownAppearance(PDAppearanceEntry)"})
  void testSetDownAppearanceWithEntry() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    COSDictionary entry = new COSDictionary();

    // Act
    pdAppearanceDictionary.setDownAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getNormalAppearance().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSDictionary cOSObject2 = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject2.getValues().size());
    assertEquals(2, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(entry, pdAppearanceDictionary.getDownAppearance().getCOSObject());
    assertSame(cOSObject, pdAppearanceDictionary.getRolloverAppearance().getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceEntry)} with {@code entry}.
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceEntry)}
   */
  @Test
  @DisplayName("Test setDownAppearance(PDAppearanceEntry) with 'entry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setDownAppearance(PDAppearanceEntry)"})
  void testSetDownAppearanceWithEntry2() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    // Act
    pdAppearanceDictionary.setDownAppearance((PDAppearanceEntry) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAppearanceDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceEntry)} with {@code entry}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceEntry)}
   */
  @Test
  @DisplayName(
      "Test setDownAppearance(PDAppearanceEntry) with 'entry'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setDownAppearance(PDAppearanceEntry)"})
  void testSetDownAppearanceWithEntry_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSDictionary entry = new COSDictionary();
    entry.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAppearanceDictionary.setDownAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getNormalAppearance().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSDictionary cOSObject2 = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject2.getValues().size());
    assertEquals(2, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(entry, pdAppearanceDictionary.getDownAppearance().getCOSObject());
    assertSame(cOSObject, pdAppearanceDictionary.getRolloverAppearance().getCOSObject());
  }

  /**
   * Test {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceEntry)} with {@code entry}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceDictionary#setDownAppearance(PDAppearanceEntry)}
   */
  @Test
  @DisplayName(
      "Test setDownAppearance(PDAppearanceEntry) with 'entry'; given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceDictionary.setDownAppearance(PDAppearanceEntry)"})
  void testSetDownAppearanceWithEntry_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();

    COSDictionary entry = new COSDictionary();
    entry.setDirect(true);

    // Act
    pdAppearanceDictionary.setDownAppearance(new PDAppearanceEntry(entry));

    // Assert
    COSDictionary cOSObject = pdAppearanceDictionary.getNormalAppearance().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSDictionary cOSObject2 = pdAppearanceDictionary.getCOSObject();
    assertEquals(2, cOSObject2.getValues().size());
    assertEquals(2, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(entry, pdAppearanceDictionary.getDownAppearance().getCOSObject());
    assertSame(cOSObject, pdAppearanceDictionary.getRolloverAppearance().getCOSObject());
  }
}
