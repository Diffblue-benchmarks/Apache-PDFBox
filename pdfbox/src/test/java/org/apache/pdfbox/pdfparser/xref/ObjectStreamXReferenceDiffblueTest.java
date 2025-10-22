package org.apache.pdfbox.pdfparser.xref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ObjectStreamXReferenceDiffblueTest {
  /**
   * Test {@link ObjectStreamXReference#ObjectStreamXReference(int, COSObjectKey, COSBase, COSObjectKey)}.
   * <p>
   * Method under test: {@link ObjectStreamXReference#ObjectStreamXReference(int, COSObjectKey, COSBase, COSObjectKey)}
   */
  @Test
  @DisplayName("Test new ObjectStreamXReference(int, COSObjectKey, COSBase, COSObjectKey)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ObjectStreamXReference.<init>(int, COSObjectKey, COSBase, COSObjectKey)"})
  void testNewObjectStreamXReference() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSBoolean object = COSBoolean.FALSE;
    COSObjectKey parentKey = new COSObjectKey(1L, 1);

    // Act
    ObjectStreamXReference actualObjectStreamXReference = new ObjectStreamXReference(1, key, object, parentKey);

    // Assert
    assertEquals(1, actualObjectStreamXReference.getObjectStreamIndex());
    assertEquals(1L, actualObjectStreamXReference.getSecondColumnValue());
    assertEquals(1L, actualObjectStreamXReference.getThirdColumnValue());
    assertEquals(2L, actualObjectStreamXReference.getFirstColumnValue());
    assertEquals(XReferenceType.OBJECT_STREAM_ENTRY, actualObjectStreamXReference.getType());
    assertSame(parentKey, actualObjectStreamXReference.getParentKey());
    assertSame(key, actualObjectStreamXReference.getReferencedKey());
    COSBoolean expectedObject = object.FALSE;
    assertSame(expectedObject, actualObjectStreamXReference.getObject());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ObjectStreamXReference#toString()}
   *   <li>{@link ObjectStreamXReference#getObject()}
   *   <li>{@link ObjectStreamXReference#getObjectStreamIndex()}
   *   <li>{@link ObjectStreamXReference#getParentKey()}
   *   <li>{@link ObjectStreamXReference#getReferencedKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase ObjectStreamXReference.getObject()", "int ObjectStreamXReference.getObjectStreamIndex()",
      "COSObjectKey ObjectStreamXReference.getParentKey()", "COSObjectKey ObjectStreamXReference.getReferencedKey()",
      "String ObjectStreamXReference.toString()"})
  void testGettersAndSetters() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSObjectKey parentKey = new COSObjectKey(1L, 1);

    ObjectStreamXReference objectStreamXReference = new ObjectStreamXReference(1, key, COSBoolean.FALSE, parentKey);

    // Act
    String actualToStringResult = objectStreamXReference.toString();
    COSBase actualObject = objectStreamXReference.getObject();
    int actualObjectStreamIndex = objectStreamXReference.getObjectStreamIndex();
    COSObjectKey actualParentKey = objectStreamXReference.getParentKey();

    // Assert
    assertEquals("ObjectStreamEntry{ key=1 1 R, type=2, objectStreamIndex=1, parent=1 1 R }", actualToStringResult);
    assertEquals(1, actualObjectStreamIndex);
    assertSame(parentKey, actualParentKey);
    assertSame(key, objectStreamXReference.getReferencedKey());
    assertSame(((COSBoolean) actualObject).FALSE, actualObject);
  }

  /**
   * Test {@link ObjectStreamXReference#getSecondColumnValue()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectStreamXReference#getSecondColumnValue()}
   */
  @Test
  @DisplayName("Test getSecondColumnValue(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long ObjectStreamXReference.getSecondColumnValue()"})
  void testGetSecondColumnValue_thenReturnOne() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act and Assert
    assertEquals(1L,
        (new ObjectStreamXReference(1, key, COSBoolean.FALSE, new COSObjectKey(1L, 1))).getSecondColumnValue());
  }

  /**
   * Test {@link ObjectStreamXReference#getThirdColumnValue()}.
   * <p>
   * Method under test: {@link ObjectStreamXReference#getThirdColumnValue()}
   */
  @Test
  @DisplayName("Test getThirdColumnValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long ObjectStreamXReference.getThirdColumnValue()"})
  void testGetThirdColumnValue() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act and Assert
    assertEquals(1L,
        (new ObjectStreamXReference(1, key, COSBoolean.FALSE, new COSObjectKey(1L, 1))).getThirdColumnValue());
  }
}
