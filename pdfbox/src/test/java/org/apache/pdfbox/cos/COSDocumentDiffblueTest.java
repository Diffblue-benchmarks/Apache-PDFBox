package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSDocumentDiffblueTest {
  /**
   * Test {@link COSDocument#COSDocument()}.
   * <p>
   * Method under test: {@link COSDocument#COSDocument()}
   */
  @Test
  @DisplayName("Test new COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSDocument.<init>()"})
  void testNewCOSDocument() {
    // Arrange and Act
    COSDocument actualCosDocument = new COSDocument();

    // Assert
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#createCOSStream()}.
   * <p>
   * Method under test: {@link COSDocument#createCOSStream()}
   */
  @Test
  @DisplayName("Test createCOSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSStream COSDocument.createCOSStream()"})
  void testCreateCOSStream() {
    // Arrange and Act
    COSStream actualCreateCOSStreamResult = (new COSDocument()).createCOSStream();

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(0L, actualCreateCOSStreamResult.getLength());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.items.size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.hasData());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDocument#getLinearizedDictionary()}.
   * <p>
   * Method under test: {@link COSDocument#getLinearizedDictionary()}
   */
  @Test
  @DisplayName("Test getLinearizedDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary COSDocument.getLinearizedDictionary()"})
  void testGetLinearizedDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDocument()).getLinearizedDictionary());
  }

  /**
   * Test {@link COSDocument#getObjectsByType(COSName)} with {@code type}.
   * <p>
   * Method under test: {@link COSDocument#getObjectsByType(COSName)}
   */
  @Test
  @DisplayName("Test getObjectsByType(COSName) with 'type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List COSDocument.getObjectsByType(COSName)"})
  void testGetObjectsByTypeWithType() {
    // Arrange, Act and Assert
    assertTrue((new COSDocument()).getObjectsByType(COSName.A).isEmpty());
  }

  /**
   * Test {@link COSDocument#getObjectsByType(COSName, COSName)} with {@code type1}, {@code type2}.
   * <p>
   * Method under test: {@link COSDocument#getObjectsByType(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getObjectsByType(COSName, COSName) with 'type1', 'type2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List COSDocument.getObjectsByType(COSName, COSName)"})
  void testGetObjectsByTypeWithType1Type2() {
    // Arrange, Act and Assert
    assertTrue((new COSDocument()).getObjectsByType(COSName.A, COSName.A).isEmpty());
  }

  /**
   * Test {@link COSDocument#isEncrypted()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#isEncrypted()}
   */
  @Test
  @DisplayName("Test isEncrypted(); given COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSDocument.isEncrypted()"})
  void testIsEncrypted_givenCOSDocument() {
    // Arrange, Act and Assert
    assertFalse((new COSDocument()).isEncrypted());
  }

  /**
   * Test {@link COSDocument#isEncrypted()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#isEncrypted()}
   */
  @Test
  @DisplayName("Test isEncrypted(); given COSDocument() Trailer is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean COSDocument.isEncrypted()"})
  void testIsEncrypted_givenCOSDocumentTrailerIsCOSDictionary() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSDictionary());

    // Act and Assert
    assertFalse(cosDocument.isEncrypted());
  }

  /**
   * Test {@link COSDocument#getEncryptionDictionary()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#getEncryptionDictionary()}
   */
  @Test
  @DisplayName("Test getEncryptionDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary COSDocument.getEncryptionDictionary()"})
  void testGetEncryptionDictionary_thenReturnNull() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSDictionary());

    // Act and Assert
    assertNull(cosDocument.getEncryptionDictionary());
  }

  /**
   * Test {@link COSDocument#setEncryptionDictionary(COSDictionary)}.
   * <p>
   * Method under test: {@link COSDocument#setEncryptionDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test setEncryptionDictionary(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSDocument.setEncryptionDictionary(COSDictionary)"})
  void testSetEncryptionDictionary() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    COSDictionary encDictionary = new COSDictionary();

    // Act
    cosDocument.setEncryptionDictionary(encDictionary);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    COSDocumentState originDocumentState = encDictionary.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertTrue(cosDocument.isEncrypted());
    assertSame(encDictionary, cosDocument.getEncryptionDictionary());
    assertSame(originDocumentState, cosDocument.getDocumentState());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setEncryptionDictionary(COSDictionary)}.
   * <p>
   * Method under test: {@link COSDocument#setEncryptionDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test setEncryptionDictionary(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSDocument.setEncryptionDictionary(COSDictionary)"})
  void testSetEncryptionDictionary2() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    COSStream encDictionary = new COSStream();

    // Act
    cosDocument.setEncryptionDictionary(encDictionary);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    COSDocumentState originDocumentState = encDictionary.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertTrue(cosDocument.isEncrypted());
    assertSame(encDictionary, cosDocument.getEncryptionDictionary());
    assertSame(originDocumentState, cosDocument.getDocumentState());
    assertSame(originDocumentState, trailer.getUpdateState().getOriginDocumentState());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setEncryptionDictionary(COSDictionary)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#setEncryptionDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test setEncryptionDictionary(COSDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSDocument.setEncryptionDictionary(COSDictionary)"})
  void testSetEncryptionDictionary_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);

    COSDictionary encDictionary = new COSDictionary();
    encDictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    cosDocument.setEncryptionDictionary(encDictionary);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    COSDocumentState originDocumentState = encDictionary.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertTrue(cosDocument.isEncrypted());
    assertSame(encDictionary, cosDocument.getEncryptionDictionary());
    assertSame(originDocumentState, cosDocument.getDocumentState());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setEncryptionDictionary(COSDictionary)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#setEncryptionDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test setEncryptionDictionary(COSDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSDocument.setEncryptionDictionary(COSDictionary)"})
  void testSetEncryptionDictionary_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);

    COSDictionary encDictionary = new COSDictionary();
    encDictionary.setDirect(true);

    // Act
    cosDocument.setEncryptionDictionary(encDictionary);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    COSDocumentState originDocumentState = encDictionary.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertTrue(cosDocument.isEncrypted());
    assertSame(encDictionary, cosDocument.getEncryptionDictionary());
    assertSame(originDocumentState, cosDocument.getDocumentState());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setEncryptionDictionary(COSDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDocument#COSDocument()} Trailer size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#setEncryptionDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test setEncryptionDictionary(COSDictionary); when 'null'; then COSDocument() Trailer size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSDocument.setEncryptionDictionary(COSDictionary)"})
  void testSetEncryptionDictionary_whenNull_thenCOSDocumentTrailerSizeIsZero() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSDictionary());

    // Act
    cosDocument.setEncryptionDictionary(null);

    // Assert that nothing has changed
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(0, trailer.size());
    assertFalse(cosDocument.isEncrypted());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(trailer.items.isEmpty());
  }

  /**
   * Test {@link COSDocument#getDocumentID()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#getDocumentID()}
   */
  @Test
  @DisplayName("Test getDocumentID(); given COSDocument() Trailer is COSDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray COSDocument.getDocumentID()"})
  void testGetDocumentID_givenCOSDocumentTrailerIsCOSDictionary_thenReturnNull() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSDictionary());

    // Act and Assert
    assertNull(cosDocument.getDocumentID());
  }

  /**
   * Test {@link COSDocument#setDocumentID(COSArray)}.
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument()} DocumentID is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#setDocumentID(COSArray)}
   */
  @Test
  @DisplayName("Test setDocumentID(COSArray); then COSDocument() DocumentID is COSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSDocument.setDocumentID(COSArray)"})
  void testSetDocumentID_thenCOSDocumentDocumentIDIsCOSArray() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    COSArray id = new COSArray();

    // Act
    cosDocument.setDocumentID(id);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    assertSame(id, cosDocument.getDocumentID());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setDocumentID(COSArray)}.
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument()} DocumentID is {@link COSArray} with floats is ten and {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#setDocumentID(COSArray)}
   */
  @Test
  @DisplayName("Test setDocumentID(COSArray); then COSDocument() DocumentID is COSArray with floats is ten and '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSDocument.setDocumentID(COSArray)"})
  void testSetDocumentID_thenCOSDocumentDocumentIDIsCOSArrayWithFloatsIsTenAnd05() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    COSArray id = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    cosDocument.setDocumentID(id);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    assertSame(id, cosDocument.getDocumentID());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setDocumentID(COSArray)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDocument#COSDocument()} Trailer size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#setDocumentID(COSArray)}
   */
  @Test
  @DisplayName("Test setDocumentID(COSArray); when 'null'; then COSDocument() Trailer size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSDocument.setDocumentID(COSArray)"})
  void testSetDocumentID_whenNull_thenCOSDocumentTrailerSizeIsZero() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSDictionary());

    // Act
    cosDocument.setDocumentID(null);

    // Assert that nothing has changed
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(0, trailer.size());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(trailer.items.isEmpty());
  }

  /**
   * Test {@link COSDocument#setTrailer(COSDictionary)}.
   * <p>
   * Method under test: {@link COSDocument#setTrailer(COSDictionary)}
   */
  @Test
  @DisplayName("Test setTrailer(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSDocument.setTrailer(COSDictionary)"})
  void testSetTrailer() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();

    // Act
    cosDocument.setTrailer(newTrailer);

    // Assert
    assertNull(cosDocument.getDocumentID());
    assertNull(cosDocument.getEncryptionDictionary());
    COSDocumentState originDocumentState = newTrailer.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertSame(newTrailer, cosDocument.getTrailer());
    assertSame(originDocumentState, cosDocument.getDocumentState());
  }

  /**
   * Test {@link COSDocument#setTrailer(COSDictionary)}.
   * <ul>
   *   <li>Then not {@link COSStream#COSStream()} UpdateState OriginDocumentState AcceptingUpdates.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#setTrailer(COSDictionary)}
   */
  @Test
  @DisplayName("Test setTrailer(COSDictionary); then not COSStream() UpdateState OriginDocumentState AcceptingUpdates")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSDocument.setTrailer(COSDictionary)"})
  void testSetTrailer_thenNotCOSStreamUpdateStateOriginDocumentStateAcceptingUpdates() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSStream newTrailer = new COSStream();

    // Act
    cosDocument.setTrailer(newTrailer);

    // Assert
    assertNull(cosDocument.getDocumentID());
    assertNull(cosDocument.getEncryptionDictionary());
    COSDocumentState originDocumentState = newTrailer.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertSame(newTrailer, cosDocument.getTrailer());
    assertSame(originDocumentState, cosDocument.getDocumentState());
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument()} Trailer Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); then COSDocument() Trailer Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept_thenCOSDocumentTrailerValuesSizeIsOne() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);

    // Act
    cosDocument.accept(new COSWriter(new ByteArrayOutputStream(1)));

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#close()}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()}.</li>
   *   <li>Then {@link COSDocument#COSDocument()} Closed.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#close()}
   */
  @Test
  @DisplayName("Test close(); given COSDocument(); then COSDocument() Closed")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void COSDocument.close()"})
  void testClose_givenCOSDocument_thenCOSDocumentClosed() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act
    cosDocument.close();

    // Assert
    assertTrue(cosDocument.isClosed());
  }

  /**
   * Test {@link COSDocument#getObjectFromPool(COSObjectKey)}.
   * <ul>
   *   <li>Then return Object is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#getObjectFromPool(COSObjectKey)}
   */
  @Test
  @DisplayName("Test getObjectFromPool(COSObjectKey); then return Object is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObject COSDocument.getObjectFromPool(COSObjectKey)"})
  void testGetObjectFromPool_thenReturnObjectIsNull() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    COSObject actualObjectFromPool = cosDocument.getObjectFromPool(key);

    // Assert
    assertNull(actualObjectFromPool.getObject());
    COSUpdateState updateState = actualObjectFromPool.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = actualObjectFromPool.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualObjectFromPool.isDirect());
    assertFalse(actualObjectFromPool.isDereferenced());
    assertFalse(actualObjectFromPool.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualObjectFromPool.isObjectNull());
    assertSame(key, actualObjectFromPool.getKey());
  }

  /**
   * Test {@link COSDocument#getObjectFromPool(COSObjectKey)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDocument#getObjectFromPool(COSObjectKey)}
   */
  @Test
  @DisplayName("Test getObjectFromPool(COSObjectKey); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObject COSDocument.getObjectFromPool(COSObjectKey)"})
  void testGetObjectFromPool_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new COSDocument()).getObjectFromPool(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSDocument#setHighestXRefObjectNumber(long)}
   *   <li>{@link COSDocument#setIsXRefStream(boolean)}
   *   <li>{@link COSDocument#setStartXref(long)}
   *   <li>{@link COSDocument#setVersion(float)}
   *   <li>{@link COSDocument#setDecrypted()}
   *   <li>{@link COSDocument#setHasHybridXRef()}
   *   <li>{@link COSDocument#getDocumentState()}
   *   <li>{@link COSDocument#getHighestXRefObjectNumber()}
   *   <li>{@link COSDocument#getStartXref()}
   *   <li>{@link COSDocument#getTrailer()}
   *   <li>{@link COSDocument#getVersion()}
   *   <li>{@link COSDocument#getXrefTable()}
   *   <li>{@link COSDocument#hasHybridXRef()}
   *   <li>{@link COSDocument#isClosed()}
   *   <li>{@link COSDocument#isDecrypted()}
   *   <li>{@link COSDocument#isXRefStream()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDocumentState COSDocument.getDocumentState()", "long COSDocument.getHighestXRefObjectNumber()",
      "long COSDocument.getStartXref()", "COSDictionary COSDocument.getTrailer()", "float COSDocument.getVersion()",
      "Map COSDocument.getXrefTable()", "boolean COSDocument.hasHybridXRef()", "boolean COSDocument.isClosed()",
      "boolean COSDocument.isDecrypted()", "boolean COSDocument.isXRefStream()", "void COSDocument.setDecrypted()",
      "void COSDocument.setHasHybridXRef()", "void COSDocument.setHighestXRefObjectNumber(long)",
      "void COSDocument.setIsXRefStream(boolean)", "void COSDocument.setStartXref(long)",
      "void COSDocument.setVersion(float)"})
  void testGettersAndSetters() {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act
    cosDocument.setHighestXRefObjectNumber(1L);
    cosDocument.setIsXRefStream(true);
    cosDocument.setStartXref(42L);
    cosDocument.setVersion(10.0f);
    cosDocument.setDecrypted();
    cosDocument.setHasHybridXRef();
    COSDocumentState actualDocumentState = cosDocument.getDocumentState();
    long actualHighestXRefObjectNumber = cosDocument.getHighestXRefObjectNumber();
    long actualStartXref = cosDocument.getStartXref();
    COSDictionary actualTrailer = cosDocument.getTrailer();
    float actualVersion = cosDocument.getVersion();
    Map<COSObjectKey, Long> actualXrefTable = cosDocument.getXrefTable();
    boolean actualHasHybridXRefResult = cosDocument.hasHybridXRef();
    boolean actualIsClosedResult = cosDocument.isClosed();
    boolean actualIsDecryptedResult = cosDocument.isDecrypted();
    boolean actualIsXRefStreamResult = cosDocument.isXRefStream();

    // Assert
    assertNull(actualTrailer);
    assertEquals(10.0f, actualVersion);
    assertEquals(1L, actualHighestXRefObjectNumber);
    assertEquals(42L, actualStartXref);
    assertFalse(actualIsClosedResult);
    assertFalse(actualDocumentState.isAcceptingUpdates());
    assertTrue(actualXrefTable.isEmpty());
    assertTrue(actualHasHybridXRefResult);
    assertTrue(actualIsDecryptedResult);
    assertTrue(actualIsXRefStreamResult);
  }
}
