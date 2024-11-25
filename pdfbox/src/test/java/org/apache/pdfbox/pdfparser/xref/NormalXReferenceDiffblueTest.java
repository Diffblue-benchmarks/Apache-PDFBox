package org.apache.pdfbox.pdfparser.xref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NormalXReferenceDiffblueTest {
  /**
   * Test {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}.
   * <p>
   * Method under test:
   * {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test new NormalXReference(long, COSObjectKey, COSBase)")
  void testNewNormalXReference() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act and Assert
    assertSame(object, (new NormalXReference(1L, key, object)).getObject());
  }

  /**
   * Test {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return Object is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test new NormalXReference(long, COSObjectKey, COSBase); when COSStream(); then return Object is COSStream()")
  void testNewNormalXReference_whenCOSStream_thenReturnObjectIsCOSStream() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSStream object = new COSStream();

    // Act and Assert
    assertSame(object, (new NormalXReference(1L, key, object)).getObject());
  }

  /**
   * Test {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then return Object is {@link COSBoolean#FALSE}
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test new NormalXReference(long, COSObjectKey, COSBase); when FALSE; then return Object is FALSE FALSE")
  void testNewNormalXReference_whenFalse_thenReturnObjectIsFalseFalse() {
    // Arrange
    COSBoolean object = COSBoolean.FALSE;

    // Act and Assert
    COSBoolean expectedObject = object.FALSE;
    assertSame(expectedObject, (new NormalXReference(1L, new COSObjectKey(1L, 1), object)).getObject());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NormalXReference#getByteOffset()}
   *   <li>{@link NormalXReference#getObject()}
   *   <li>{@link NormalXReference#getReferencedKey()}
   *   <li>{@link NormalXReference#isObjectStream()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    NormalXReference normalXReference = new NormalXReference(1L, key, COSBoolean.FALSE);

    // Act
    long actualByteOffset = normalXReference.getByteOffset();
    COSBase actualObject = normalXReference.getObject();
    COSObjectKey actualReferencedKey = normalXReference.getReferencedKey();

    // Assert
    assertEquals(1L, actualByteOffset);
    assertFalse(normalXReference.isObjectStream());
    assertSame(key, actualReferencedKey);
    assertSame(((COSBoolean) actualObject).FALSE, actualObject);
  }

  /**
   * Test {@link NormalXReference#getSecondColumnValue()}.
   * <p>
   * Method under test: {@link NormalXReference#getSecondColumnValue()}
   */
  @Test
  @DisplayName("Test getSecondColumnValue()")
  void testGetSecondColumnValue() {
    // Arrange, Act and Assert
    assertEquals(1L, (new NormalXReference(1L, new COSObjectKey(1L, 1), COSBoolean.FALSE)).getSecondColumnValue());
  }

  /**
   * Test {@link NormalXReference#getThirdColumnValue()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NormalXReference#getThirdColumnValue()}
   */
  @Test
  @DisplayName("Test getThirdColumnValue(); given COSObjectKey(long, int) with num is one and gen is one; then return one")
  void testGetThirdColumnValue_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1L, (new NormalXReference(1L, new COSObjectKey(1L, 1), COSBoolean.FALSE)).getThirdColumnValue());
  }

  /**
   * Test {@link NormalXReference#toString()}.
   * <p>
   * Method under test: {@link NormalXReference#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("NormalReference{ key=1 1 R, type=1, byteOffset=1 }",
        (new NormalXReference(1L, new COSObjectKey(1L, 1), COSBoolean.FALSE)).toString());
  }
}
