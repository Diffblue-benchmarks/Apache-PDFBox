package org.apache.pdfbox.pdfwriter.compress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.PDEncryption;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class COSWriterCompressionPoolDiffblueTest {
  /**
   * Test
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}.
   * <p>
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  @DisplayName("Test new COSWriterCompressionPool(PDDocument, CompressParameters)")
  void testNewCOSWriterCompressionPool() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(document,
        CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    List<COSObjectKey> objectStreamObjects = actualCosWriterCompressionPool.getObjectStreamObjects();
    assertEquals(2, objectStreamObjects.size());
    COSObjectKey getResult = objectStreamObjects.get(1);
    assertEquals(196608L, getResult.getInternalHash());
    assertEquals(3L, getResult.getNumber());
    assertEquals(3L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
  }

  /**
   * Test
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}.
   * <p>
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  @DisplayName("Test new COSWriterCompressionPool(PDDocument, CompressParameters)")
  void testNewCOSWriterCompressionPool2() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.save(new ByteArrayOutputStream(1), CompressParameters.DEFAULT_COMPRESSION);
    document.addPage(new PDPage());

    // Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(document,
        CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    List<COSObjectKey> objectStreamObjects = actualCosWriterCompressionPool.getObjectStreamObjects();
    assertEquals(2, objectStreamObjects.size());
    COSObjectKey getResult = objectStreamObjects.get(1);
    assertEquals(327680L, getResult.getInternalHash());
    assertEquals(5L, getResult.getNumber());
    assertEquals(5L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
  }

  /**
   * Test
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}.
   * <ul>
   *   <li>Given {@link PDEncryption#PDEncryption()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  @DisplayName("Test new COSWriterCompressionPool(PDDocument, CompressParameters); given PDEncryption()")
  void testNewCOSWriterCompressionPool_givenPDEncryption() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.setEncryptionDictionary(new PDEncryption());
    document.addPage(new PDPage());

    // Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(document,
        CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    List<COSObjectKey> objectStreamObjects = actualCosWriterCompressionPool.getObjectStreamObjects();
    assertEquals(2, objectStreamObjects.size());
    COSObjectKey getResult = objectStreamObjects.get(1);
    assertEquals(196608L, getResult.getInternalHash());
    assertEquals(3L, getResult.getNumber());
    assertEquals(3L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
  }

  /**
   * Test
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}.
   * <ul>
   *   <li>Then return HighestXRefObjectNumber is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  @DisplayName("Test new COSWriterCompressionPool(PDDocument, CompressParameters); then return HighestXRefObjectNumber is zero")
  void testNewCOSWriterCompressionPool_thenReturnHighestXRefObjectNumberIsZero() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(doc),
        CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    assertEquals(0L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
    assertTrue(actualCosWriterCompressionPool.getObjectStreamObjects().isEmpty());
    assertTrue(actualCosWriterCompressionPool.getTopLevelObjects().isEmpty());
  }

  /**
   * Test
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}.
   * <ul>
   *   <li>Then return ObjectStreamObjects size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  @DisplayName("Test new COSWriterCompressionPool(PDDocument, CompressParameters); then return ObjectStreamObjects size is one")
  void testNewCOSWriterCompressionPool_thenReturnObjectStreamObjectsSizeIsOne() throws IOException {
    // Arrange and Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    List<COSObjectKey> objectStreamObjects = actualCosWriterCompressionPool.getObjectStreamObjects();
    assertEquals(1, objectStreamObjects.size());
    List<COSObjectKey> topLevelObjects = actualCosWriterCompressionPool.getTopLevelObjects();
    assertEquals(1, topLevelObjects.size());
    COSObjectKey getResult = objectStreamObjects.get(0);
    assertEquals(131072L, getResult.getInternalHash());
    COSObjectKey getResult2 = topLevelObjects.get(0);
    assertEquals(1L, getResult2.getNumber());
    assertEquals(2L, getResult.getNumber());
    assertEquals(2L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
    assertEquals(65536L, getResult2.getInternalHash());
  }

  /**
   * Test
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}.
   * <ul>
   *   <li>Then return ObjectStreamObjects size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  @DisplayName("Test new COSWriterCompressionPool(PDDocument, CompressParameters); then return ObjectStreamObjects size is one")
  void testNewCOSWriterCompressionPool_thenReturnObjectStreamObjectsSizeIsOne2() throws IOException {
    // Arrange and Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(), null);

    // Assert
    List<COSObjectKey> objectStreamObjects = actualCosWriterCompressionPool.getObjectStreamObjects();
    assertEquals(1, objectStreamObjects.size());
    List<COSObjectKey> topLevelObjects = actualCosWriterCompressionPool.getTopLevelObjects();
    assertEquals(1, topLevelObjects.size());
    COSObjectKey getResult = objectStreamObjects.get(0);
    assertEquals(131072L, getResult.getInternalHash());
    COSObjectKey getResult2 = topLevelObjects.get(0);
    assertEquals(1L, getResult2.getNumber());
    assertEquals(2L, getResult.getNumber());
    assertEquals(2L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
    assertEquals(65536L, getResult2.getInternalHash());
  }

  /**
   * Test
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}.
   * <ul>
   *   <li>Then return ObjectStreamObjects size is six.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  @DisplayName("Test new COSWriterCompressionPool(PDDocument, CompressParameters); then return ObjectStreamObjects size is six")
  void testNewCOSWriterCompressionPool_thenReturnObjectStreamObjectsSizeIsSix() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addSignature(new PDSignature());
    document.addPage(new PDPage());

    // Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(document,
        CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    List<COSObjectKey> objectStreamObjects = actualCosWriterCompressionPool.getObjectStreamObjects();
    assertEquals(6, objectStreamObjects.size());
    COSObjectKey getResult = objectStreamObjects.get(3);
    assertEquals(-1, getResult.getStreamIndex());
    COSObjectKey getResult2 = objectStreamObjects.get(4);
    assertEquals(-1, getResult2.getStreamIndex());
    COSObjectKey getResult3 = objectStreamObjects.get(5);
    assertEquals(-1, getResult3.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(0, getResult2.getGeneration());
    assertEquals(0, getResult3.getGeneration());
    List<COSObjectKey> topLevelObjects = actualCosWriterCompressionPool.getTopLevelObjects();
    assertEquals(2, topLevelObjects.size());
    assertEquals(327680L, getResult.getInternalHash());
    assertEquals(393216L, getResult2.getInternalHash());
    COSObjectKey getResult4 = topLevelObjects.get(1);
    assertEquals(458752L, getResult4.getInternalHash());
    assertEquals(524288L, getResult3.getInternalHash());
    assertEquals(5L, getResult.getNumber());
    assertEquals(6L, getResult2.getNumber());
    assertEquals(7L, getResult4.getNumber());
    assertEquals(8L, getResult3.getNumber());
    assertEquals(8L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
  }

  /**
   * Test
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}.
   * <ul>
   *   <li>Then return ObjectStreamObjects size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  @DisplayName("Test new COSWriterCompressionPool(PDDocument, CompressParameters); then return ObjectStreamObjects size is three")
  void testNewCOSWriterCompressionPool_thenReturnObjectStreamObjectsSizeIsThree() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(document,
        CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    List<COSObjectKey> objectStreamObjects = actualCosWriterCompressionPool.getObjectStreamObjects();
    assertEquals(3, objectStreamObjects.size());
    COSObjectKey getResult = objectStreamObjects.get(2);
    assertEquals(-1, getResult.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(262144L, getResult.getInternalHash());
    assertEquals(4L, getResult.getNumber());
    assertEquals(4L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSWriterCompressionPool#getObjectStreamObjects()}
   *   <li>{@link COSWriterCompressionPool#getTopLevelObjects()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws IOException {
    // Arrange
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);

    // Act
    List<COSObjectKey> actualObjectStreamObjects = cosWriterCompressionPool.getObjectStreamObjects();
    List<COSObjectKey> actualTopLevelObjects = cosWriterCompressionPool.getTopLevelObjects();

    // Assert
    assertEquals(1, actualObjectStreamObjects.size());
    COSObjectKey getResult = actualObjectStreamObjects.get(0);
    assertEquals(-1, getResult.getStreamIndex());
    assertEquals(1, actualTopLevelObjects.size());
    COSObjectKey getResult2 = actualTopLevelObjects.get(0);
    assertEquals(-1, getResult2.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(0, getResult2.getGeneration());
    assertEquals(131072L, getResult.getInternalHash());
    assertEquals(1L, getResult2.getNumber());
    assertEquals(2L, getResult.getNumber());
    assertEquals(65536L, getResult2.getInternalHash());
  }

  /**
   * Test {@link COSWriterCompressionPool#contains(COSBase)}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase); when A")
  void testContains_whenA() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        (new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION)).contains(COSName.A));
  }

  /**
   * Test {@link COSWriterCompressionPool#contains(COSBase)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSName#A} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase); when COSObject(COSBase, COSObjectKey) with object is A and objectKey is COSObjectKey(long, int)")
  void testContains_whenCOSObjectWithObjectIsAAndObjectKeyIsCOSObjectKey() throws IOException {
    // Arrange
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);

    // Act and Assert
    assertFalse(cosWriterCompressionPool.contains(new COSObject(COSName.A, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Test {@link COSWriterCompressionPool#contains(COSBase)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSObject#COSObject(COSBase, COSObjectKey)} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase); when COSObject(COSBase, COSObjectKey) with object is COSObject(COSBase, COSObjectKey) and objectKey is COSObjectKey(long, int)")
  void testContains_whenCOSObjectWithObjectIsCOSObjectAndObjectKeyIsCOSObjectKey() throws IOException {
    // Arrange
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237));

    // Act and Assert
    assertFalse(cosWriterCompressionPool.contains(new COSObject(object, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Test {@link COSWriterCompressionPool#contains(COSBase)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSBoolean#FALSE} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase); when COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  void testContains_whenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() throws IOException {
    // Arrange
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);

    // Act and Assert
    assertFalse(cosWriterCompressionPool.contains(new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Test {@link COSWriterCompressionPool#contains(COSBase)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSFloat#ONE} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase); when COSObject(COSBase, COSObjectKey) with object is ONE and objectKey is COSObjectKey(long, int)")
  void testContains_whenCOSObjectWithObjectIsOneAndObjectKeyIsCOSObjectKey() throws IOException {
    // Arrange
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);

    // Act and Assert
    assertFalse(cosWriterCompressionPool.contains(new COSObject(COSFloat.ONE, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Test {@link COSWriterCompressionPool#contains(COSBase)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSInteger#ONE} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase); when COSObject(COSBase, COSObjectKey) with object is ONE and objectKey is COSObjectKey(long, int)")
  void testContains_whenCOSObjectWithObjectIsOneAndObjectKeyIsCOSObjectKey2() throws IOException {
    // Arrange
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);

    // Act and Assert
    assertFalse(cosWriterCompressionPool.contains(new COSObject(COSInteger.ONE, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Test {@link COSWriterCompressionPool#contains(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase); when FALSE")
  void testContains_whenFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION))
        .contains(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSWriterCompressionPool#contains(COSBase)}.
   * <ul>
   *   <li>When {@link COSFloat#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase); when ONE")
  void testContains_whenOne() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION))
        .contains(COSFloat.ONE));
    assertFalse((new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION))
        .contains(COSInteger.ONE));
  }

  /**
   * Test {@link COSWriterCompressionPool#contains(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#TRUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  @DisplayName("Test contains(COSBase); when TRUE")
  void testContains_whenTrue() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION))
        .contains(COSBoolean.TRUE));
  }

  /**
   * Test {@link COSWriterCompressionPool#getKey(COSBase)}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  @DisplayName("Test getKey(COSBase); when A")
  void testGetKey_whenA() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION)).getKey(COSName.A));
  }

  /**
   * Test {@link COSWriterCompressionPool#getKey(COSBase)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSName#A} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  @DisplayName("Test getKey(COSBase); when COSObject(COSBase, COSObjectKey) with object is A and objectKey is COSObjectKey(long, int)")
  void testGetKey_whenCOSObjectWithObjectIsAAndObjectKeyIsCOSObjectKey() throws IOException {
    // Arrange
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);

    // Act and Assert
    assertNull(cosWriterCompressionPool.getKey(new COSObject(COSName.A, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Test {@link COSWriterCompressionPool#getKey(COSBase)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSObject#COSObject(COSBase, COSObjectKey)} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  @DisplayName("Test getKey(COSBase); when COSObject(COSBase, COSObjectKey) with object is COSObject(COSBase, COSObjectKey) and objectKey is COSObjectKey(long, int)")
  void testGetKey_whenCOSObjectWithObjectIsCOSObjectAndObjectKeyIsCOSObjectKey() throws IOException {
    // Arrange
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237));

    // Act and Assert
    assertNull(cosWriterCompressionPool.getKey(new COSObject(object, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Test {@link COSWriterCompressionPool#getKey(COSBase)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSBoolean#FALSE} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  @DisplayName("Test getKey(COSBase); when COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  void testGetKey_whenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() throws IOException {
    // Arrange
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);

    // Act and Assert
    assertNull(cosWriterCompressionPool.getKey(new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Test {@link COSWriterCompressionPool#getKey(COSBase)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSFloat#ONE} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  @DisplayName("Test getKey(COSBase); when COSObject(COSBase, COSObjectKey) with object is ONE and objectKey is COSObjectKey(long, int)")
  void testGetKey_whenCOSObjectWithObjectIsOneAndObjectKeyIsCOSObjectKey() throws IOException {
    // Arrange
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);

    // Act and Assert
    assertNull(cosWriterCompressionPool.getKey(new COSObject(COSFloat.ONE, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Test {@link COSWriterCompressionPool#getKey(COSBase)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSInteger#ONE} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  @DisplayName("Test getKey(COSBase); when COSObject(COSBase, COSObjectKey) with object is ONE and objectKey is COSObjectKey(long, int)")
  void testGetKey_whenCOSObjectWithObjectIsOneAndObjectKeyIsCOSObjectKey2() throws IOException {
    // Arrange
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);

    // Act and Assert
    assertNull(cosWriterCompressionPool.getKey(new COSObject(COSInteger.ONE, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Test {@link COSWriterCompressionPool#getKey(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  @DisplayName("Test getKey(COSBase); when FALSE")
  void testGetKey_whenFalse() throws IOException {
    // Arrange, Act and Assert
    assertNull((new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION))
        .getKey(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSWriterCompressionPool#getKey(COSBase)}.
   * <ul>
   *   <li>When {@link COSFloat#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  @DisplayName("Test getKey(COSBase); when ONE")
  void testGetKey_whenOne() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION)).getKey(COSFloat.ONE));
    assertNull((new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION))
        .getKey(COSInteger.ONE));
  }

  /**
   * Test {@link COSWriterCompressionPool#getKey(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#TRUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  @DisplayName("Test getKey(COSBase); when TRUE")
  void testGetKey_whenTrue() throws IOException {
    // Arrange, Act and Assert
    assertNull((new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION))
        .getKey(COSBoolean.TRUE));
  }

  /**
   * Test {@link COSWriterCompressionPool#getObject(COSObjectKey)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#getObject(COSObjectKey)}
   */
  @Test
  @DisplayName("Test getObject(COSObjectKey); when COSObjectKey(long, int) with num is one and gen is one; then return 'null'")
  void testGetObject_whenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnNull() throws IOException {
    // Arrange
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);

    // Act and Assert
    assertNull(cosWriterCompressionPool.getObject(new COSObjectKey(1L, 1)));
  }

  /**
   * Test {@link COSWriterCompressionPool#getObject(COSObjectKey)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#getObject(COSObjectKey)}
   */
  @Test
  @DisplayName("Test getObject(COSObjectKey); when 'null'; then return 'null'")
  void testGetObject_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION)).getObject(null));
  }

  /**
   * Test {@link COSWriterCompressionPool#getHighestXRefObjectNumber()}.
   * <p>
   * Method under test:
   * {@link COSWriterCompressionPool#getHighestXRefObjectNumber()}
   */
  @Test
  @DisplayName("Test getHighestXRefObjectNumber()")
  void testGetHighestXRefObjectNumber() throws IOException {
    // Arrange, Act and Assert
    assertEquals(2L, (new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION))
        .getHighestXRefObjectNumber());
  }

  /**
   * Test {@link COSWriterCompressionPool#createObjectStreams()}.
   * <ul>
   *   <li>Then return first PreparedKeys size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#createObjectStreams()}
   */
  @Test
  @DisplayName("Test createObjectStreams(); then return first PreparedKeys size is one")
  void testCreateObjectStreams_thenReturnFirstPreparedKeysSizeIsOne() throws IOException {
    // Arrange and Act
    List<COSWriterObjectStream> actualCreateObjectStreamsResult = (new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION)).createObjectStreams();

    // Assert
    assertEquals(1, actualCreateObjectStreamsResult.size());
    List<COSObjectKey> preparedKeys = actualCreateObjectStreamsResult.get(0).getPreparedKeys();
    assertEquals(1, preparedKeys.size());
    COSObjectKey getResult = preparedKeys.get(0);
    assertEquals(-1, getResult.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(131072L, getResult.getInternalHash());
    assertEquals(2L, getResult.getNumber());
  }

  /**
   * Test {@link COSWriterCompressionPool#createObjectStreams()}.
   * <ul>
   *   <li>Then return first PreparedKeys size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriterCompressionPool#createObjectStreams()}
   */
  @Test
  @DisplayName("Test createObjectStreams(); then return first PreparedKeys size is two")
  void testCreateObjectStreams_thenReturnFirstPreparedKeysSizeIsTwo() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    List<COSWriterObjectStream> actualCreateObjectStreamsResult = (new COSWriterCompressionPool(document,
        CompressParameters.DEFAULT_COMPRESSION)).createObjectStreams();

    // Assert
    assertEquals(1, actualCreateObjectStreamsResult.size());
    List<COSObjectKey> preparedKeys = actualCreateObjectStreamsResult.get(0).getPreparedKeys();
    assertEquals(2, preparedKeys.size());
    COSObjectKey getResult = preparedKeys.get(1);
    assertEquals(-1, getResult.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(196608L, getResult.getInternalHash());
    assertEquals(3L, getResult.getNumber());
  }
}
