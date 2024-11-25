package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class COSObjectKeyDiffblueTest {
  /**
   * Test {@link COSObjectKey#COSObjectKey(long, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectKey#COSObjectKey(long, int)}
   */
  @Test
  @DisplayName("Test new COSObjectKey(long, int); when minus one; then throw IllegalArgumentException")
  void testNewCOSObjectKey_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new COSObjectKey(-1L, 0));

    assertThrows(IllegalArgumentException.class, () -> new COSObjectKey(-1L, 0, 1));
  }

  /**
   * Test {@link COSObjectKey#COSObjectKey(long, int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Generation is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectKey#COSObjectKey(long, int, int)}
   */
  @Test
  @DisplayName("Test new COSObjectKey(long, int, int); when one; then return Generation is one")
  void testNewCOSObjectKey_whenOne_thenReturnGenerationIsOne() {
    // Arrange and Act
    COSObjectKey actualCosObjectKey = new COSObjectKey(1L, 1, 1);

    // Assert
    assertEquals(1, actualCosObjectKey.getGeneration());
    assertEquals(1, actualCosObjectKey.getStreamIndex());
    assertEquals(1L, actualCosObjectKey.getNumber());
    assertEquals(65537L, actualCosObjectKey.getInternalHash());
  }

  /**
   * Test {@link COSObjectKey#COSObjectKey(long, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return StreamIndex is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectKey#COSObjectKey(long, int)}
   */
  @Test
  @DisplayName("Test new COSObjectKey(long, int); when one; then return StreamIndex is minus one")
  void testNewCOSObjectKey_whenOne_thenReturnStreamIndexIsMinusOne() {
    // Arrange and Act
    COSObjectKey actualCosObjectKey = new COSObjectKey(1L, 1);

    // Assert
    assertEquals(-1, actualCosObjectKey.getStreamIndex());
    assertEquals(1, actualCosObjectKey.getGeneration());
    assertEquals(1L, actualCosObjectKey.getNumber());
    assertEquals(65537L, actualCosObjectKey.getInternalHash());
  }

  /**
   * Test {@link COSObjectKey#COSObjectKey(long, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectKey#COSObjectKey(long, int)}
   */
  @Test
  @DisplayName("Test new COSObjectKey(long, int); when zero; then throw IllegalArgumentException")
  void testNewCOSObjectKey_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new COSObjectKey(0L, -1));

    assertThrows(IllegalArgumentException.class, () -> new COSObjectKey(0L, -1, 1));
  }

  /**
   * Test {@link COSObjectKey#computeInternalHash(long, int)}.
   * <ul>
   *   <li>When {@code 81985529216486895}.</li>
   *   <li>Then return {@code 5001117282205648231}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectKey#computeInternalHash(long, int)}
   */
  @Test
  @DisplayName("Test computeInternalHash(long, int); when '81985529216486895'; then return '5001117282205648231'")
  void testComputeInternalHash_when81985529216486895_thenReturn5001117282205648231() {
    // Arrange, Act and Assert
    assertEquals(5001117282205648231L, COSObjectKey.computeInternalHash(81985529216486895L, 19088743));
  }

  /**
   * Test {@link COSObjectKey#computeInternalHash(long, int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code 345447}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectKey#computeInternalHash(long, int)}
   */
  @Test
  @DisplayName("Test computeInternalHash(long, int); when five; then return '345447'")
  void testComputeInternalHash_whenFive_thenReturn345447() {
    // Arrange, Act and Assert
    assertEquals(345447L, COSObjectKey.computeInternalHash(5L, 19088743));
  }

  /**
   * Test {@link COSObjectKey#computeInternalHash(long, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code 83303}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectKey#computeInternalHash(long, int)}
   */
  @Test
  @DisplayName("Test computeInternalHash(long, int); when one; then return '83303'")
  void testComputeInternalHash_whenOne_thenReturn83303() {
    // Arrange, Act and Assert
    assertEquals(83303L, COSObjectKey.computeInternalHash(1L, 19088743));
  }

  /**
   * Test {@link COSObjectKey#computeInternalHash(long, int)}.
   * <ul>
   *   <li>When sixteen.</li>
   *   <li>Then return {@code 1066343}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectKey#computeInternalHash(long, int)}
   */
  @Test
  @DisplayName("Test computeInternalHash(long, int); when sixteen; then return '1066343'")
  void testComputeInternalHash_whenSixteen_thenReturn1066343() {
    // Arrange, Act and Assert
    assertEquals(1066343L, COSObjectKey.computeInternalHash(16L, 19088743));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSObjectKey#toString()}
   *   <li>{@link COSObjectKey#getInternalHash()}
   *   <li>{@link COSObjectKey#getStreamIndex()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    COSObjectKey cosObjectKey = new COSObjectKey(1L, 1);

    // Act
    String actualToStringResult = cosObjectKey.toString();
    long actualInternalHash = cosObjectKey.getInternalHash();

    // Assert
    assertEquals("1 1 R", actualToStringResult);
    assertEquals(-1, cosObjectKey.getStreamIndex());
    assertEquals(65537L, actualInternalHash);
  }

  /**
   * Test {@link COSObjectKey#equals(Object)}, and
   * {@link COSObjectKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSObjectKey#equals(Object)}
   *   <li>{@link COSObjectKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    COSObjectKey cosObjectKey = new COSObjectKey(1L, 1);
    COSObjectKey cosObjectKey2 = new COSObjectKey(1L, 1);

    // Act and Assert
    assertEquals(cosObjectKey, cosObjectKey2);
    int expectedHashCodeResult = cosObjectKey.hashCode();
    assertEquals(expectedHashCodeResult, cosObjectKey2.hashCode());
  }

  /**
   * Test {@link COSObjectKey#equals(Object)}, and
   * {@link COSObjectKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSObjectKey#equals(Object)}
   *   <li>{@link COSObjectKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    COSObjectKey cosObjectKey = new COSObjectKey(1L, 1);

    // Act and Assert
    assertEquals(cosObjectKey, cosObjectKey);
    int expectedHashCodeResult = cosObjectKey.hashCode();
    assertEquals(expectedHashCodeResult, cosObjectKey.hashCode());
  }

  /**
   * Test {@link COSObjectKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    COSObjectKey cosObjectKey = new COSObjectKey(65537L, 1);

    // Act and Assert
    assertNotEquals(cosObjectKey, new COSObjectKey(1L, 1));
  }

  /**
   * Test {@link COSObjectKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new COSObjectKey(1L, 1), null);
  }

  /**
   * Test {@link COSObjectKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new COSObjectKey(1L, 1), "Different type to COSObjectKey");
  }

  /**
   * Test {@link COSObjectKey#getGeneration()}.
   * <p>
   * Method under test: {@link COSObjectKey#getGeneration()}
   */
  @Test
  @DisplayName("Test getGeneration()")
  void testGetGeneration() {
    // Arrange, Act and Assert
    assertEquals(1, (new COSObjectKey(1L, 1)).getGeneration());
  }

  /**
   * Test {@link COSObjectKey#getNumber()}.
   * <p>
   * Method under test: {@link COSObjectKey#getNumber()}
   */
  @Test
  @DisplayName("Test getNumber()")
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1L, (new COSObjectKey(1L, 1)).getNumber());
  }

  /**
   * Test {@link COSObjectKey#compareTo(COSObjectKey)} with {@code COSObjectKey}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectKey#compareTo(COSObjectKey)}
   */
  @Test
  @DisplayName("Test compareTo(COSObjectKey) with 'COSObjectKey'; then return zero")
  void testCompareToWithCOSObjectKey_thenReturnZero() {
    // Arrange
    COSObjectKey cosObjectKey = new COSObjectKey(1L, 1);

    // Act and Assert
    assertEquals(0, cosObjectKey.compareTo(new COSObjectKey(1L, 1)));
  }
}
