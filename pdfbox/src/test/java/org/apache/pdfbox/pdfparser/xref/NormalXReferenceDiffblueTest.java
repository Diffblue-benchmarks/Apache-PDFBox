package org.apache.pdfbox.pdfparser.xref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NormalXReferenceDiffblueTest {
  /**
   * Test {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}.
   *
   * <p>Method under test: {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test new NormalXReference(long, COSObjectKey, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NormalXReference.<init>(long, COSObjectKey, COSBase)"})
  void testNewNormalXReference() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    NormalXReference actualNormalXReference = new NormalXReference(1L, key, object);

    // Assert
    assertSame(object, actualNormalXReference.getObject());
  }

  /**
   * Test {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return Object is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName(
      "Test new NormalXReference(long, COSObjectKey, COSBase); when COSStream(); then return Object is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NormalXReference.<init>(long, COSObjectKey, COSBase)"})
  void testNewNormalXReference_whenCOSStream_thenReturnObjectIsCOSStream() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSStream object = new COSStream();

    // Act
    NormalXReference actualNormalXReference = new NormalXReference(1L, key, object);

    // Assert
    assertSame(object, actualNormalXReference.getObject());
  }

  /**
   * Test {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then return Object is {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName(
      "Test new NormalXReference(long, COSObjectKey, COSBase); when FALSE; then return Object is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NormalXReference.<init>(long, COSObjectKey, COSBase)"})
  void testNewNormalXReference_whenFalse_thenReturnObjectIsFalse() {
    // Arrange and Act
    NormalXReference actualNormalXReference =
        new NormalXReference(1L, new COSObjectKey(1L, 1), COSBoolean.FALSE);

    // Assert
    assertSame(COSBoolean.FALSE, actualNormalXReference.getObject());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NormalXReference#getByteOffset()}
   *   <li>{@link NormalXReference#getObject()}
   *   <li>{@link NormalXReference#getReferencedKey()}
   *   <li>{@link NormalXReference#isObjectStream()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long NormalXReference.getByteOffset()",
    "COSBase NormalXReference.getObject()",
    "COSObjectKey NormalXReference.getReferencedKey()",
    "boolean NormalXReference.isObjectStream()"
  })
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
   *
   * <p>Method under test: {@link NormalXReference#getSecondColumnValue()}
   */
  @Test
  @DisplayName("Test getSecondColumnValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NormalXReference.getSecondColumnValue()"})
  void testGetSecondColumnValue() {
    // Arrange
    NormalXReference normalXReference =
        new NormalXReference(1L, new COSObjectKey(1L, 1), COSBoolean.FALSE);

    // Act and Assert
    assertEquals(1L, normalXReference.getSecondColumnValue());
  }

  /**
   * Test {@link NormalXReference#getThirdColumnValue()}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link NormalXReference#getThirdColumnValue()}
   */
  @Test
  @DisplayName(
      "Test getThirdColumnValue(); given COSObjectKey(long, int) with num is one and gen is one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NormalXReference.getThirdColumnValue()"})
  void testGetThirdColumnValue_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnOne() {
    // Arrange
    NormalXReference normalXReference =
        new NormalXReference(1L, new COSObjectKey(1L, 1), COSBoolean.FALSE);

    // Act and Assert
    assertEquals(1L, normalXReference.getThirdColumnValue());
  }

  /**
   * Test {@link NormalXReference#toString()}.
   *
   * <p>Method under test: {@link NormalXReference#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String NormalXReference.toString()"})
  void testToString() {
    // Arrange
    NormalXReference normalXReference =
        new NormalXReference(1L, new COSObjectKey(1L, 1), COSBoolean.FALSE);

    // Act and Assert
    assertEquals("NormalReference{ key=1 1 R, type=1, byteOffset=1 }", normalXReference.toString());
  }
}
