package org.apache.pdfbox.pdfwriter.compress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSObjectPoolDiffblueTest {
  /**
   * Test {@link COSObjectPool#COSObjectPool(long)}.
   * <p>
   * Method under test: {@link COSObjectPool#COSObjectPool(long)}
   */
  @Test
  @DisplayName("Test new COSObjectPool(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSObjectPool.<init>(long)"})
  void testNewCOSObjectPool() {
    // Arrange, Act and Assert
    assertEquals(1L, (new COSObjectPool(1L)).getHighestXRefObjectNumber());
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   * <p>
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test put(COSObjectKey, COSBase)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test put(COSObjectKey, COSBase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut2() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1237L, 1237), COSBoolean.FALSE);
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(key, COSBoolean.FALSE);

    // Assert
    assertEquals(1237L, cosObjectPool.getHighestXRefObjectNumber());
    assertSame(key, actualPutResult);
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   * <p>
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test put(COSObjectKey, COSBase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut3() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1237L, 1237), COSBoolean.TRUE);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(new COSObjectKey(1237L, 1237, 1), COSBoolean.FALSE);

    // Assert
    assertEquals(-1, actualPutResult.getStreamIndex());
    assertEquals(0, actualPutResult.getGeneration());
    assertEquals(1238L, actualPutResult.getNumber());
    assertEquals(1238L, cosObjectPool.getHighestXRefObjectNumber());
    assertEquals(81133568L, actualPutResult.getInternalHash());
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   * <ul>
   *   <li>Given {@link COSObjectPool#COSObjectPool(long)} with highestXRefObjectNumber is one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test put(COSObjectKey, COSBase); given COSObjectPool(long) with highestXRefObjectNumber is one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut_givenCOSObjectPoolWithHighestXRefObjectNumberIsOne_thenReturnNull() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);

    // Act and Assert
    assertNull(cosObjectPool.put(new COSObjectKey(1L, 1), null));
    assertEquals(1L, cosObjectPool.getHighestXRefObjectNumber());
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   * <ul>
   *   <li>Then return InternalHash is {@code 131072}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test put(COSObjectKey, COSBase); then return InternalHash is '131072'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut_thenReturnInternalHashIs131072() {
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
   * <ul>
   *   <li>Then return Number is {@code 1238}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test put(COSObjectKey, COSBase); then return Number is '1238'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut_thenReturnNumberIs1238() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1237L, 1237), COSBoolean.FALSE);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(null, COSBoolean.FALSE);

    // Assert
    assertEquals(-1, actualPutResult.getStreamIndex());
    assertEquals(0, actualPutResult.getGeneration());
    assertEquals(1238L, actualPutResult.getNumber());
    assertEquals(1238L, cosObjectPool.getHighestXRefObjectNumber());
    assertEquals(81133568L, actualPutResult.getInternalHash());
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is {@code 1237} and gen is {@code 1237}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test put(COSObjectKey, COSBase); when COSObjectKey(long, int) with num is '1237' and gen is '1237'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut_whenCOSObjectKeyWithNumIs1237AndGenIs1237() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(key,
        new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237)));

    // Assert
    assertEquals(1L, cosObjectPool.getHighestXRefObjectNumber());
    assertSame(key, actualPutResult);
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int, int)} with num is {@code 1237} and gen is {@code 1237} and index is one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test put(COSObjectKey, COSBase); when COSObjectKey(long, int, int) with num is '1237' and gen is '1237' and index is one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut_whenCOSObjectKeyWithNumIs1237AndGenIs1237AndIndexIsOne_thenReturnNull() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1237L, 1237), COSBoolean.FALSE);

    // Act and Assert
    assertNull(cosObjectPool.put(new COSObjectKey(1237L, 1237, 1), COSBoolean.FALSE));
    assertEquals(1237L, cosObjectPool.getHighestXRefObjectNumber());
  }

  /**
   * Test {@link COSObjectPool#put(COSObjectKey, COSBase)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is {@code 1237} and gen is {@code 1237}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test put(COSObjectKey, COSBase); when COSObjectKey(long, int) with num is '1237' and gen is '1237'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObjectKey COSObjectPool.put(COSObjectKey, COSBase)"})
  void testPut_whenCOSObjectKeyWithNumIs1237AndGenIs12372() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1237L, 1237), COSBoolean.FALSE);
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(key,
        new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237)));

    // Assert
    assertEquals(1237L, cosObjectPool.getHighestXRefObjectNumber());
    assertSame(key, actualPutResult);
  }

  /**
   * Test {@link COSObjectPool#getKey(COSBase)}.
   * <ul>
   *   <li>Given {@link COSObjectPool#COSObjectPool(long)} with highestXRefObjectNumber is one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#getKey(COSBase)}
   */
  @Test
  @DisplayName("Test getKey(COSBase); given COSObjectPool(long) with highestXRefObjectNumber is one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObjectKey COSObjectPool.getKey(COSBase)"})
  void testGetKey_givenCOSObjectPoolWithHighestXRefObjectNumberIsOne_thenReturnNull() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);

    // Act and Assert
    assertNull(cosObjectPool.getKey(new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Test {@link COSObjectPool#getKey(COSBase)}.
   * <ul>
   *   <li>Then return {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#getKey(COSBase)}
   */
  @Test
  @DisplayName("Test getKey(COSBase); then return COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObjectKey COSObjectPool.getKey(COSBase)"})
  void testGetKey_thenReturnCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    COSObjectKey key = new COSObjectKey(1L, 1);

    cosObjectPool.put(key, COSBoolean.FALSE);

    // Act and Assert
    assertSame(key, cosObjectPool.getKey(new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Test {@link COSObjectPool#getKey(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#getKey(COSBase)}
   */
  @Test
  @DisplayName("Test getKey(COSBase); when FALSE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObjectKey COSObjectPool.getKey(COSBase)"})
  void testGetKey_whenFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new COSObjectPool(1L)).getKey(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSObjectPool#contains(COSObjectKey)} with {@code key}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#contains(COSObjectKey)}
   */
  @Test
  @DisplayName("Test contains(COSObjectKey) with 'key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSObjectPool.contains(COSObjectKey)"})
  void testContainsWithKey_thenReturnFalse() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);

    // Act and Assert
    assertFalse(cosObjectPool.contains(new COSObjectKey(1L, 1)));
  }

  /**
   * Test {@link COSObjectPool#contains(COSObjectKey)} with {@code key}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#contains(COSObjectKey)}
   */
  @Test
  @DisplayName("Test contains(COSObjectKey) with 'key'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSObjectPool.contains(COSObjectKey)"})
  void testContainsWithKey_thenReturnTrue() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1L, 1), COSBoolean.FALSE);
    cosObjectPool.put(new COSObjectKey(5L, 5), COSBoolean.FALSE);

    // Act and Assert
    assertTrue(cosObjectPool.contains(new COSObjectKey(1L, 1)));
  }

  /**
   * Test {@link COSObjectPool#contains(COSObjectKey)} with {@code key}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#contains(COSObjectKey)}
   */
  @Test
  @DisplayName("Test contains(COSObjectKey) with 'key'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSObjectPool.contains(COSObjectKey)"})
  void testContainsWithKey_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new COSObjectPool(1L)).contains((COSObjectKey) null));
  }

  /**
   * Test {@link COSObjectPool#contains(COSBase)} with {@code object}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase) with 'object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSObjectPool.contains(COSBase)"})
  void testContainsWithObject_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new COSObjectPool(1L)).contains(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSObjectPool#contains(COSBase)} with {@code object}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase) with 'object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSObjectPool.contains(COSBase)"})
  void testContainsWithObject_thenReturnFalse2() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);

    // Act and Assert
    assertFalse(cosObjectPool.contains(new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Test {@link COSObjectPool#contains(COSBase)} with {@code object}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase) with 'object'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSObjectPool.contains(COSBase)"})
  void testContainsWithObject_thenReturnTrue() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1237L, 1237), COSBoolean.FALSE);

    // Act and Assert
    assertTrue(cosObjectPool.contains(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSObjectPool#contains(COSBase)} with {@code object}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase) with 'object'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSObjectPool.contains(COSBase)"})
  void testContainsWithObject_thenReturnTrue2() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1237L, 1237), COSBoolean.FALSE);

    // Act and Assert
    assertTrue(cosObjectPool.contains(new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Test {@link COSObjectPool#getObject(COSObjectKey)}.
   * <p>
   * Method under test: {@link COSObjectPool#getObject(COSObjectKey)}
   */
  @Test
  @DisplayName("Test getObject(COSObjectKey)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase COSObjectPool.getObject(COSObjectKey)"})
  void testGetObject() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(65537L, 0), COSBoolean.FALSE);

    // Act and Assert
    assertNull(cosObjectPool.getObject(new COSObjectKey(1L, 1)));
  }

  /**
   * Test {@link COSObjectPool#getObject(COSObjectKey)}.
   * <ul>
   *   <li>Given {@link COSObjectPool#COSObjectPool(long)} with highestXRefObjectNumber is one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#getObject(COSObjectKey)}
   */
  @Test
  @DisplayName("Test getObject(COSObjectKey); given COSObjectPool(long) with highestXRefObjectNumber is one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase COSObjectPool.getObject(COSObjectKey)"})
  void testGetObject_givenCOSObjectPoolWithHighestXRefObjectNumberIsOne_thenReturnNull() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);

    // Act and Assert
    assertNull(cosObjectPool.getObject(new COSObjectKey(1L, 1)));
  }

  /**
   * Test {@link COSObjectPool#getObject(COSObjectKey)}.
   * <ul>
   *   <li>Given {@link COSObjectPool#COSObjectPool(long)} with highestXRefObjectNumber is one.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#getObject(COSObjectKey)}
   */
  @Test
  @DisplayName("Test getObject(COSObjectKey); given COSObjectPool(long) with highestXRefObjectNumber is one; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase COSObjectPool.getObject(COSObjectKey)"})
  void testGetObject_givenCOSObjectPoolWithHighestXRefObjectNumberIsOne_whenNull() {
    // Arrange, Act and Assert
    assertNull((new COSObjectPool(1L)).getObject(null));
  }

  /**
   * Test {@link COSObjectPool#getObject(COSObjectKey)}.
   * <ul>
   *   <li>Then return {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObjectPool#getObject(COSObjectKey)}
   */
  @Test
  @DisplayName("Test getObject(COSObjectKey); then return FALSE")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link COSObjectPool#getHighestXRefObjectNumber()}
   */
  @Test
  @DisplayName("Test getHighestXRefObjectNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long COSObjectPool.getHighestXRefObjectNumber()"})
  void testGetHighestXRefObjectNumber() {
    // Arrange, Act and Assert
    assertEquals(1L, (new COSObjectPool(1L)).getHighestXRefObjectNumber());
  }
}
