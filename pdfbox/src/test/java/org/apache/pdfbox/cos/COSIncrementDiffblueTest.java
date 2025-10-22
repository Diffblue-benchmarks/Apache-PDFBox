package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSIncrementDiffblueTest {
  /**
   * Test {@link COSIncrement#COSIncrement(COSUpdateInfo)}.
   * <p>
   * Method under test: {@link COSIncrement#COSIncrement(COSUpdateInfo)}
   */
  @Test
  @DisplayName("Test new COSIncrement(COSUpdateInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSIncrement.<init>(COSUpdateInfo)"})
  void testNewCOSIncrement() {
    // Arrange and Act
    COSIncrement actualCosIncrement = new COSIncrement(new COSArray());

    // Assert
    assertFalse(actualCosIncrement.iterator().hasNext());
    assertTrue(actualCosIncrement.getObjects().isEmpty());
  }

  /**
   * Test {@link COSIncrement#contains(COSBase)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is {@code 1237} and gen is {@code 1237}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase); when COSObjectKey(long, int) with num is '1237' and gen is '1237'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSIncrement.contains(COSBase)"})
  void testContains_whenCOSObjectKeyWithNumIs1237AndGenIs1237() {
    // Arrange
    COSIncrement cosIncrement = new COSIncrement(new COSArray());

    // Act and Assert
    assertFalse(cosIncrement.contains(new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Test {@link COSIncrement#contains(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase); when FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSIncrement.contains(COSBase)"})
  void testContains_whenFalse() {
    // Arrange, Act and Assert
    assertFalse((new COSIncrement(new COSArray())).contains(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSIncrement#exclude(COSBase[])}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#exclude(COSBase[])}
   */
  @Test
  @DisplayName("Test exclude(COSBase[]); when FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSIncrement COSIncrement.exclude(COSBase[])"})
  void testExclude_whenFalse() {
    // Arrange
    COSIncrement cosIncrement = new COSIncrement(new COSArray());

    // Act and Assert
    assertSame(cosIncrement, cosIncrement.exclude(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSIncrement#exclude(COSBase[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#exclude(COSBase[])}
   */
  @Test
  @DisplayName("Test exclude(COSBase[]); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSIncrement COSIncrement.exclude(COSBase[])"})
  void testExclude_whenNull() {
    // Arrange
    COSIncrement cosIncrement = new COSIncrement(new COSArray());

    // Act and Assert
    assertSame(cosIncrement, cosIncrement.exclude(null));
  }

  /**
   * Test {@link COSIncrement#getObjects()}.
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#getObjects()}
   */
  @Test
  @DisplayName("Test getObjects(); given COSArray with floats is ten and '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set COSIncrement.getObjects()"})
  void testGetObjects_givenCOSArrayWithFloatsIsTenAnd05() {
    // Arrange, Act and Assert
    assertTrue((new COSIncrement(COSArray.of(10.0f, 0.5f, 10.0f, 0.5f))).getObjects().isEmpty());
  }

  /**
   * Test {@link COSIncrement#getObjects()}.
   * <ul>
   *   <li>Given {@link COSIncrement#COSIncrement(COSUpdateInfo)} with incrementOrigin is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#getObjects()}
   */
  @Test
  @DisplayName("Test getObjects(); given COSIncrement(COSUpdateInfo) with incrementOrigin is COSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set COSIncrement.getObjects()"})
  void testGetObjects_givenCOSIncrementWithIncrementOriginIsCOSArray() {
    // Arrange, Act and Assert
    assertTrue((new COSIncrement(new COSArray())).getObjects().isEmpty());
  }

  /**
   * Test {@link COSIncrement#getObjects()}.
   * <ul>
   *   <li>Given {@link COSIncrement#COSIncrement(COSUpdateInfo)} with incrementOrigin is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#getObjects()}
   */
  @Test
  @DisplayName("Test getObjects(); given COSIncrement(COSUpdateInfo) with incrementOrigin is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set COSIncrement.getObjects()"})
  void testGetObjects_givenCOSIncrementWithIncrementOriginIsCOSDictionary() {
    // Arrange, Act and Assert
    assertTrue((new COSIncrement(new COSDictionary())).getObjects().isEmpty());
  }

  /**
   * Test {@link COSIncrement#getObjects()}.
   * <ul>
   *   <li>Given {@link COSIncrement#COSIncrement(COSUpdateInfo)} with incrementOrigin is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#getObjects()}
   */
  @Test
  @DisplayName("Test getObjects(); given COSIncrement(COSUpdateInfo) with incrementOrigin is COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set COSIncrement.getObjects()"})
  void testGetObjects_givenCOSIncrementWithIncrementOriginIsCOSStream() {
    // Arrange, Act and Assert
    assertTrue((new COSIncrement(new COSStream())).getObjects().isEmpty());
  }

  /**
   * Test {@link COSIncrement#getObjects()}.
   * <ul>
   *   <li>Given {@link COSIncrement#COSIncrement(COSUpdateInfo)} with incrementOrigin is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#getObjects()}
   */
  @Test
  @DisplayName("Test getObjects(); given COSIncrement(COSUpdateInfo) with incrementOrigin is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set COSIncrement.getObjects()"})
  void testGetObjects_givenCOSIncrementWithIncrementOriginIsNull() {
    // Arrange, Act and Assert
    assertTrue((new COSIncrement(null)).getObjects().isEmpty());
  }

  /**
   * Test {@link COSIncrement#getObjects()}.
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link COSDictionary#COSDictionary()} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#getObjects()}
   */
  @Test
  @DisplayName("Test getObjects(); given COSObject(COSBase, COSObjectKey) with object is COSDictionary() and objectKey is COSObjectKey(long, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set COSIncrement.getObjects()"})
  void testGetObjects_givenCOSObjectWithObjectIsCOSDictionaryAndObjectKeyIsCOSObjectKey() {
    // Arrange
    COSDictionary object = new COSDictionary();

    // Act and Assert
    assertTrue((new COSIncrement(new COSObject(object, new COSObjectKey(1L, 1)))).getObjects().isEmpty());
  }

  /**
   * Test {@link COSIncrement#getObjects()}.
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link COSObject#COSObject(COSBase, COSObjectKey)} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#getObjects()}
   */
  @Test
  @DisplayName("Test getObjects(); given COSObject(COSBase, COSObjectKey) with object is COSObject(COSBase, COSObjectKey) and objectKey is COSObjectKey(long, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set COSIncrement.getObjects()"})
  void testGetObjects_givenCOSObjectWithObjectIsCOSObjectAndObjectKeyIsCOSObjectKey() {
    // Arrange
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act and Assert
    assertTrue((new COSIncrement(new COSObject(object, new COSObjectKey(1L, 1)))).getObjects().isEmpty());
  }

  /**
   * Test {@link COSIncrement#getObjects()}.
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#getObjects()}
   */
  @Test
  @DisplayName("Test getObjects(); given COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set COSIncrement.getObjects()"})
  void testGetObjects_givenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() {
    // Arrange, Act and Assert
    assertTrue((new COSIncrement(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)))).getObjects().isEmpty());
  }

  /**
   * Test {@link COSIncrement#iterator()}.
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given COSArray with floats is ten and '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Iterator COSIncrement.iterator()"})
  void testIterator_givenCOSArrayWithFloatsIsTenAnd05() {
    // Arrange, Act and Assert
    assertFalse((new COSIncrement(COSArray.of(10.0f, 0.5f, 10.0f, 0.5f))).iterator().hasNext());
  }

  /**
   * Test {@link COSIncrement#iterator()}.
   * <ul>
   *   <li>Given {@link COSIncrement#COSIncrement(COSUpdateInfo)} with incrementOrigin is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given COSIncrement(COSUpdateInfo) with incrementOrigin is COSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Iterator COSIncrement.iterator()"})
  void testIterator_givenCOSIncrementWithIncrementOriginIsCOSArray() {
    // Arrange, Act and Assert
    assertFalse((new COSIncrement(new COSArray())).iterator().hasNext());
  }

  /**
   * Test {@link COSIncrement#iterator()}.
   * <ul>
   *   <li>Given {@link COSIncrement#COSIncrement(COSUpdateInfo)} with incrementOrigin is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given COSIncrement(COSUpdateInfo) with incrementOrigin is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Iterator COSIncrement.iterator()"})
  void testIterator_givenCOSIncrementWithIncrementOriginIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new COSIncrement(new COSDictionary())).iterator().hasNext());
  }

  /**
   * Test {@link COSIncrement#iterator()}.
   * <ul>
   *   <li>Given {@link COSIncrement#COSIncrement(COSUpdateInfo)} with incrementOrigin is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given COSIncrement(COSUpdateInfo) with incrementOrigin is COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Iterator COSIncrement.iterator()"})
  void testIterator_givenCOSIncrementWithIncrementOriginIsCOSStream() {
    // Arrange, Act and Assert
    assertFalse((new COSIncrement(new COSStream())).iterator().hasNext());
  }

  /**
   * Test {@link COSIncrement#iterator()}.
   * <ul>
   *   <li>Given {@link COSIncrement#COSIncrement(COSUpdateInfo)} with incrementOrigin is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given COSIncrement(COSUpdateInfo) with incrementOrigin is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Iterator COSIncrement.iterator()"})
  void testIterator_givenCOSIncrementWithIncrementOriginIsNull() {
    // Arrange, Act and Assert
    assertFalse((new COSIncrement(null)).iterator().hasNext());
  }

  /**
   * Test {@link COSIncrement#iterator()}.
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link COSDictionary#COSDictionary()} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given COSObject(COSBase, COSObjectKey) with object is COSDictionary() and objectKey is COSObjectKey(long, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Iterator COSIncrement.iterator()"})
  void testIterator_givenCOSObjectWithObjectIsCOSDictionaryAndObjectKeyIsCOSObjectKey() {
    // Arrange
    COSDictionary object = new COSDictionary();

    // Act and Assert
    assertFalse((new COSIncrement(new COSObject(object, new COSObjectKey(1L, 1)))).iterator().hasNext());
  }

  /**
   * Test {@link COSIncrement#iterator()}.
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link COSObject#COSObject(COSBase, COSObjectKey)} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given COSObject(COSBase, COSObjectKey) with object is COSObject(COSBase, COSObjectKey) and objectKey is COSObjectKey(long, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Iterator COSIncrement.iterator()"})
  void testIterator_givenCOSObjectWithObjectIsCOSObjectAndObjectKeyIsCOSObjectKey() {
    // Arrange
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act and Assert
    assertFalse((new COSIncrement(new COSObject(object, new COSObjectKey(1L, 1)))).iterator().hasNext());
  }

  /**
   * Test {@link COSIncrement#iterator()}.
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSIncrement#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Iterator COSIncrement.iterator()"})
  void testIterator_givenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() {
    // Arrange, Act and Assert
    assertFalse((new COSIncrement(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)))).iterator().hasNext());
  }
}
