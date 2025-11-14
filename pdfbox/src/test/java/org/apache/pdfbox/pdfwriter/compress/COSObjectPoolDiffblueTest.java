package org.apache.pdfbox.pdfwriter.compress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdfparser.COSParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSObjectPoolDiffblueTest {
  /**
   * Test {@link COSObjectPool#COSObjectPool(long)}.
   *
   * <p>Method under test: {@link COSObjectPool#COSObjectPool(long)}
   */
  @Test
  @DisplayName("Test new COSObjectPool(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSObjectPool.<init>(long)"})
  void testNewCOSObjectPool() {
    // Arrange, Act and Assert
    assertEquals(1L, new COSObjectPool(1L).getHighestXRefObjectNumber());
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   *
   * <p>Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test put(COSObjectKey, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(key, COSBoolean.FALSE);

    // Assert
    assertEquals(1L, cosObjectPool.getHighestXRefObjectNumber());
    assertSame(key, actualPutResult);
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   *
   * <p>Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test put(COSObjectKey, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut2() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(5L, 5), COSBoolean.FALSE);
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(key, COSBoolean.FALSE);

    // Assert
    assertEquals(5L, cosObjectPool.getHighestXRefObjectNumber());
    assertSame(key, actualPutResult);
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   *
   * <p>Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test put(COSObjectKey, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut3() throws IOException {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1L, 1), COSBoolean.FALSE);
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObjectKey key2 = new COSObjectKey(5L, 5);
    COSObject object = new COSObject(key2, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(key, object);

    // Assert
    assertEquals(-1, actualPutResult.getStreamIndex());
    assertEquals(0, actualPutResult.getGeneration());
    assertEquals(131072L, actualPutResult.getInternalHash());
    assertEquals(2L, actualPutResult.getNumber());
    assertEquals(2L, cosObjectPool.getHighestXRefObjectNumber());
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   *
   * <ul>
   *   <li>Then return InternalHash is {@code 393216}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test put(COSObjectKey, COSBase); then return InternalHash is '393216'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut_thenReturnInternalHashIs393216() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(5L, 5), COSBoolean.FALSE);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(null, COSBoolean.FALSE);

    // Assert
    assertEquals(-1, actualPutResult.getStreamIndex());
    assertEquals(0, actualPutResult.getGeneration());
    assertEquals(393216L, actualPutResult.getInternalHash());
    assertEquals(6L, actualPutResult.getNumber());
    assertEquals(6L, cosObjectPool.getHighestXRefObjectNumber());
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int, int)} with num is five and gen is five
   *       and index is one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName(
      "Test put(COSObjectKey, COSBase); when COSObjectKey(long, int, int) with num is five and gen is five and index is one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut_whenCOSObjectKeyWithNumIsFiveAndGenIsFiveAndIndexIsOne_thenReturnNull() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(5L, 5), COSBoolean.FALSE);

    // Act and Assert
    assertNull(cosObjectPool.put(new COSObjectKey(5L, 5, 1), COSBoolean.FALSE));
    assertEquals(5L, cosObjectPool.getHighestXRefObjectNumber());
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSObjectKey, ICOSParser)} with key is {@link
   *       COSObjectKey#COSObjectKey(long, int)} and parser is {@link
   *       COSParser#COSParser(RandomAccessRead)}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName(
      "Test put(COSObjectKey, COSBase); when COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is COSParser(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut_whenCOSObjectWithKeyIsCOSObjectKeyAndParserIsCOSParser() throws IOException {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObjectKey key2 = new COSObjectKey(5L, 5);
    COSObject object = new COSObject(key2, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(key, object);

    // Assert
    assertEquals(1L, cosObjectPool.getHighestXRefObjectNumber());
    assertSame(key, actualPutResult);
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName(
      "Test put(COSObjectKey, COSBase); when COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut_whenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(5L, 5));

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(key, object);

    // Assert
    assertEquals(1L, cosObjectPool.getHighestXRefObjectNumber());
    assertSame(key, actualPutResult);
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName(
      "Test put(COSObjectKey, COSBase); when COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut_whenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey2() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(5L, 5), COSBoolean.FALSE);
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(5L, 5));

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(key, object);

    // Assert
    assertEquals(5L, cosObjectPool.getHighestXRefObjectNumber());
    assertSame(key, actualPutResult);
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return InternalHash is {@code 131072}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test put(COSObjectKey, COSBase); when 'null'; then return InternalHash is '131072'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut_whenNull_thenReturnInternalHashIs131072() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(null, COSBoolean.FALSE);

    // Assert
    assertEquals(-1, actualPutResult.getStreamIndex());
    assertEquals(0, actualPutResult.getGeneration());
    assertEquals(131072L, actualPutResult.getInternalHash());
    assertEquals(2L, actualPutResult.getNumber());
    assertEquals(2L, cosObjectPool.getHighestXRefObjectNumber());
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test put(COSObjectKey, COSBase); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut_whenNull_thenReturnNull() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);

    // Act and Assert
    assertNull(cosObjectPool.put(new COSObjectKey(1L, 1), null));
    assertEquals(1L, cosObjectPool.getHighestXRefObjectNumber());
  }

  /**
   * Test {@link COSObjectPool#getKey(COSBase)}.
   *
   * <ul>
   *   <li>Then return {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#getKey(COSBase)}
   */
  @Test
  @DisplayName(
      "Test getKey(COSBase); then return COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectKey COSObjectPool.getKey(COSBase)"})
  void testGetKey_thenReturnCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    COSObjectKey key = new COSObjectKey(1L, 1);
    cosObjectPool.put(key, COSBoolean.FALSE);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    COSObjectKey actualKey = cosObjectPool.getKey(object);

    // Assert
    assertSame(key, actualKey);
  }

  /**
   * Test {@link COSObjectPool#getKey(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSObjectKey, ICOSParser)} with key is {@link
   *       COSObjectKey#COSObjectKey(long, int)} and parser is {@link
   *       COSParser#COSParser(RandomAccessRead)}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#getKey(COSBase)}
   */
  @Test
  @DisplayName(
      "Test getKey(COSBase); when COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is COSParser(RandomAccessRead); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectKey COSObjectPool.getKey(COSBase)"})
  void testGetKey_whenCOSObjectWithKeyIsCOSObjectKeyAndParserIsCOSParser_thenReturnNull()
      throws IOException {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act
    COSObjectKey actualKey = cosObjectPool.getKey(object);

    // Assert
    assertNull(actualKey);
  }

  /**
   * Test {@link COSObjectPool#getKey(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#getKey(COSBase)}
   */
  @Test
  @DisplayName(
      "Test getKey(COSBase); when COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectKey COSObjectPool.getKey(COSBase)"})
  void testGetKey_whenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    COSObjectKey actualKey = cosObjectPool.getKey(object);

    // Assert
    assertNull(actualKey);
  }

  /**
   * Test {@link COSObjectPool#getKey(COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#getKey(COSBase)}
   */
  @Test
  @DisplayName("Test getKey(COSBase); when FALSE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectKey COSObjectPool.getKey(COSBase)"})
  void testGetKey_whenFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new COSObjectPool(1L).getKey(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSObjectPool#contains(COSObjectKey)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link COSObjectPool#COSObjectPool(long)} with highestXRefObjectNumber is one.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#contains(COSObjectKey)}
   */
  @Test
  @DisplayName(
      "Test contains(COSObjectKey) with 'key'; given COSObjectPool(long) with highestXRefObjectNumber is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSObjectPool.contains(COSObjectKey)"})
  void testContainsWithKey_givenCOSObjectPoolWithHighestXRefObjectNumberIsOne() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);

    // Act
    boolean actualContainsResult = cosObjectPool.contains(new COSObjectKey(1L, 1));

    // Assert
    assertFalse(actualContainsResult);
  }

  /**
   * Test {@link COSObjectPool#contains(COSObjectKey)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#contains(COSObjectKey)}
   */
  @Test
  @DisplayName("Test contains(COSObjectKey) with 'key'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSObjectPool.contains(COSObjectKey)"})
  void testContainsWithKey_thenReturnFalse() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(5L, 5), COSBoolean.FALSE);

    // Act
    boolean actualContainsResult = cosObjectPool.contains(new COSObjectKey(1L, 1));

    // Assert
    assertFalse(actualContainsResult);
  }

  /**
   * Test {@link COSObjectPool#contains(COSObjectKey)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#contains(COSObjectKey)}
   */
  @Test
  @DisplayName("Test contains(COSObjectKey) with 'key'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSObjectPool.contains(COSObjectKey)"})
  void testContainsWithKey_thenReturnTrue() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(5L, 5), COSBoolean.FALSE);

    // Act
    boolean actualContainsResult = cosObjectPool.contains(new COSObjectKey(5L, 5, 1));

    // Assert
    assertTrue(actualContainsResult);
  }

  /**
   * Test {@link COSObjectPool#contains(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>Given {@link COSObjectPool#COSObjectPool(long)} with highestXRefObjectNumber is one.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#contains(COSBase)}
   */
  @Test
  @DisplayName(
      "Test contains(COSBase) with 'object'; given COSObjectPool(long) with highestXRefObjectNumber is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSObjectPool.contains(COSBase)"})
  void testContainsWithObject_givenCOSObjectPoolWithHighestXRefObjectNumberIsOne() {
    // Arrange, Act and Assert
    assertFalse(new COSObjectPool(1L).contains(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSObjectPool#contains(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSObjectKey, ICOSParser)} with key is {@link
   *       COSObjectKey#COSObjectKey(long, int)} and parser is {@link
   *       COSParser#COSParser(RandomAccessRead)}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#contains(COSBase)}
   */
  @Test
  @DisplayName(
      "Test contains(COSBase) with 'object'; when COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is COSParser(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSObjectPool.contains(COSBase)"})
  void testContainsWithObject_whenCOSObjectWithKeyIsCOSObjectKeyAndParserIsCOSParser()
      throws IOException {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1L, 1), COSBoolean.FALSE);
    COSObjectKey key = new COSObjectKey(1237L, 1237);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act
    boolean actualContainsResult = cosObjectPool.contains(object);

    // Assert
    assertFalse(actualContainsResult);
  }

  /**
   * Test {@link COSObjectPool#contains(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#contains(COSBase)}
   */
  @Test
  @DisplayName(
      "Test contains(COSBase) with 'object'; when COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSObjectPool.contains(COSBase)"})
  void testContainsWithObject_whenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1L, 1), COSBoolean.FALSE);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237));

    // Act
    boolean actualContainsResult = cosObjectPool.contains(object);

    // Assert
    assertTrue(actualContainsResult);
  }

  /**
   * Test {@link COSObjectPool#contains(COSBase)} with {@code object}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase) with 'object'; when FALSE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSObjectPool.contains(COSBase)"})
  void testContainsWithObject_whenFalse_thenReturnTrue() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1L, 1), COSBoolean.FALSE);

    // Act and Assert
    assertTrue(cosObjectPool.contains(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSObjectPool#getObject(COSObjectKey)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectPool#COSObjectPool(long)} with highestXRefObjectNumber is one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#getObject(COSObjectKey)}
   */
  @Test
  @DisplayName(
      "Test getObject(COSObjectKey); given COSObjectPool(long) with highestXRefObjectNumber is one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSObjectPool.getObject(COSObjectKey)"})
  void testGetObject_givenCOSObjectPoolWithHighestXRefObjectNumberIsOne_thenReturnNull() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);

    // Act
    COSBase actualObject = cosObjectPool.getObject(new COSObjectKey(1L, 1));

    // Assert
    assertNull(actualObject);
  }

  /**
   * Test {@link COSObjectPool#getObject(COSObjectKey)}.
   *
   * <ul>
   *   <li>Then return {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSObjectPool#getObject(COSObjectKey)}
   */
  @Test
  @DisplayName("Test getObject(COSObjectKey); then return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSObjectPool.getObject(COSObjectKey)"})
  void testGetObject_thenReturnFalse() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1L, 1), COSBoolean.FALSE);

    // Act
    COSBase actualObject = cosObjectPool.getObject(new COSObjectKey(1L, 1));

    // Assert
    assertSame(((COSBoolean) actualObject).FALSE, actualObject);
  }

  /**
   * Test {@link COSObjectPool#getHighestXRefObjectNumber()}.
   *
   * <p>Method under test: {@link COSObjectPool#getHighestXRefObjectNumber()}
   */
  @Test
  @DisplayName("Test getHighestXRefObjectNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long COSObjectPool.getHighestXRefObjectNumber()"})
  void testGetHighestXRefObjectNumber() {
    // Arrange, Act and Assert
    assertEquals(1L, new COSObjectPool(1L).getHighestXRefObjectNumber());
  }
}
