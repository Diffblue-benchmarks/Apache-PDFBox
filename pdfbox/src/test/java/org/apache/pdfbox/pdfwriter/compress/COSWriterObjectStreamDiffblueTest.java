package org.apache.pdfbox.pdfwriter.compress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSWriterObjectStreamDiffblueTest {
  /**
   * Test {@link COSWriterObjectStream#COSWriterObjectStream(COSWriterCompressionPool)}.
   *
   * <p>Method under test: {@link
   * COSWriterObjectStream#COSWriterObjectStream(COSWriterCompressionPool)}
   */
  @Test
  @DisplayName("Test new COSWriterObjectStream(COSWriterCompressionPool)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriterObjectStream.<init>(COSWriterCompressionPool)"})
  void testNewCOSWriterObjectStream() throws IOException {
    // Arrange, Act and Assert
    assertTrue(
        new COSWriterObjectStream(
                new COSWriterCompressionPool(
                    new PDDocument(), CompressParameters.DEFAULT_COMPRESSION))
            .getPreparedKeys()
            .isEmpty());
  }

  /**
   * Test {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}.
   *
   * <p>Method under test: {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test prepareStreamObject(COSObjectKey, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriterObjectStream.prepareStreamObject(COSObjectKey, COSBase)"})
  void testPrepareStreamObject() throws IOException {
    // Arrange
    COSWriterObjectStream cosWriterObjectStream =
        new COSWriterObjectStream(
            new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION));

    // Act
    cosWriterObjectStream.prepareStreamObject(null, COSBoolean.FALSE);

    // Assert that nothing has changed
    assertTrue(cosWriterObjectStream.getPreparedKeys().isEmpty());
  }

  /**
   * Test {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}.
   *
   * <p>Method under test: {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test prepareStreamObject(COSObjectKey, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriterObjectStream.prepareStreamObject(COSObjectKey, COSBase)"})
  void testPrepareStreamObject2() throws IOException {
    // Arrange
    COSWriterObjectStream cosWriterObjectStream =
        new COSWriterObjectStream(
            new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION));

    // Act
    cosWriterObjectStream.prepareStreamObject(new COSObjectKey(1L, 1), null);

    // Assert that nothing has changed
    assertTrue(cosWriterObjectStream.getPreparedKeys().isEmpty());
  }

  /**
   * Test {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test prepareStreamObject(COSObjectKey, COSBase); when 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriterObjectStream.prepareStreamObject(COSObjectKey, COSBase)"})
  void testPrepareStreamObject_whenA() throws IOException {
    // Arrange
    COSWriterObjectStream cosWriterObjectStream =
        new COSWriterObjectStream(
            new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION));
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObjectKey key2 = new COSObjectKey(1L, 1);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser parser = new COSParser(source);

    COSObject object = new COSObject(key2, parser);

    // Act
    cosWriterObjectStream.prepareStreamObject(key, object);

    // Assert
    List<COSObjectKey> preparedKeys = cosWriterObjectStream.getPreparedKeys();
    assertEquals(1, preparedKeys.size());
    assertSame(key, preparedKeys.get(0));
  }

  /**
   * Test {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSObjectKey, ICOSParser)} with key is {@link
   *       COSObjectKey#COSObjectKey(long, int)} and parser is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName(
      "Test prepareStreamObject(COSObjectKey, COSBase); when COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriterObjectStream.prepareStreamObject(COSObjectKey, COSBase)"})
  void testPrepareStreamObject_whenCOSObjectWithKeyIsCOSObjectKeyAndParserIsNull()
      throws IOException {
    // Arrange
    COSWriterObjectStream cosWriterObjectStream =
        new COSWriterObjectStream(
            new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION));
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(new COSObjectKey(1L, 1), null);

    // Act
    cosWriterObjectStream.prepareStreamObject(key, object);

    // Assert
    List<COSObjectKey> preparedKeys = cosWriterObjectStream.getPreparedKeys();
    assertEquals(1, preparedKeys.size());
    assertSame(key, preparedKeys.get(0));
  }

  /**
   * Test {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName(
      "Test prepareStreamObject(COSObjectKey, COSBase); when COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriterObjectStream.prepareStreamObject(COSObjectKey, COSBase)"})
  void testPrepareStreamObject_whenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey()
      throws IOException {
    // Arrange
    COSWriterObjectStream cosWriterObjectStream =
        new COSWriterObjectStream(
            new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION));
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    cosWriterObjectStream.prepareStreamObject(key, object);

    // Assert
    List<COSObjectKey> preparedKeys = cosWriterObjectStream.getPreparedKeys();
    assertEquals(1, preparedKeys.size());
    assertSame(key, preparedKeys.get(0));
  }

  /**
   * Test {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName(
      "Test prepareStreamObject(COSObjectKey, COSBase); when COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriterObjectStream.prepareStreamObject(COSObjectKey, COSBase)"})
  void testPrepareStreamObject_whenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange
    COSWriterObjectStream cosWriterObjectStream =
        new COSWriterObjectStream(
            new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION));
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObjectKey key2 = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(key2, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act
    cosWriterObjectStream.prepareStreamObject(key, object);

    // Assert
    List<COSObjectKey> preparedKeys = cosWriterObjectStream.getPreparedKeys();
    assertEquals(1, preparedKeys.size());
    assertSame(key, preparedKeys.get(0));
  }

  /**
   * Test {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}
   */
  @Test
  @DisplayName("Test prepareStreamObject(COSObjectKey, COSBase); when FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSWriterObjectStream.prepareStreamObject(COSObjectKey, COSBase)"})
  void testPrepareStreamObject_whenFalse() throws IOException {
    // Arrange
    COSWriterObjectStream cosWriterObjectStream =
        new COSWriterObjectStream(
            new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION));
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    cosWriterObjectStream.prepareStreamObject(key, COSBoolean.FALSE);

    // Assert
    List<COSObjectKey> preparedKeys = cosWriterObjectStream.getPreparedKeys();
    assertEquals(1, preparedKeys.size());
    assertSame(key, preparedKeys.get(0));
  }

  /**
   * Test {@link COSWriterObjectStream#getPreparedKeys()}.
   *
   * <p>Method under test: {@link COSWriterObjectStream#getPreparedKeys()}
   */
  @Test
  @DisplayName("Test getPreparedKeys()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSWriterObjectStream.getPreparedKeys()"})
  void testGetPreparedKeys() throws IOException {
    // Arrange, Act and Assert
    assertTrue(
        new COSWriterObjectStream(
                new COSWriterCompressionPool(
                    new PDDocument(), CompressParameters.DEFAULT_COMPRESSION))
            .getPreparedKeys()
            .isEmpty());
  }

  /**
   * Test {@link COSWriterObjectStream#writeObjectsToStream(COSStream)}.
   *
   * <ul>
   *   <li>Then {@link COSStream#COSStream(RandomAccessStreamCache)} with streamCache is {@link
   *       ScratchFile#ScratchFile(MemoryUsageSetting)} size is five.
   * </ul>
   *
   * <p>Method under test: {@link COSWriterObjectStream#writeObjectsToStream(COSStream)}
   */
  @Test
  @DisplayName(
      "Test writeObjectsToStream(COSStream); then COSStream(RandomAccessStreamCache) with streamCache is ScratchFile(MemoryUsageSetting) size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream COSWriterObjectStream.writeObjectsToStream(COSStream)"})
  void testWriteObjectsToStream_thenCOSStreamWithStreamCacheIsScratchFileSizeIsFive()
      throws IOException {
    // Arrange
    COSWriterObjectStream cosWriterObjectStream =
        new COSWriterObjectStream(
            new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION));
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-100L);
    ScratchFile streamCache = new ScratchFile(memUsageSetting);
    COSStream stream = new COSStream(streamCache);

    // Act
    COSStream actualWriteObjectsToStreamResult = cosWriterObjectStream.writeObjectsToStream(stream);

    // Assert
    assertEquals(5, stream.size());
    assertEquals(8L, stream.getLength());
    assertTrue(stream.hasData());
    assertSame(stream, actualWriteObjectsToStreamResult);
  }

  /**
   * Test {@link COSWriterObjectStream#writeObjectsToStream(COSStream)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then {@link COSStream#COSStream()} size is five.
   * </ul>
   *
   * <p>Method under test: {@link COSWriterObjectStream#writeObjectsToStream(COSStream)}
   */
  @Test
  @DisplayName(
      "Test writeObjectsToStream(COSStream); when COSStream(); then COSStream() size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream COSWriterObjectStream.writeObjectsToStream(COSStream)"})
  void testWriteObjectsToStream_whenCOSStream_thenCOSStreamSizeIsFive() throws IOException {
    // Arrange
    COSWriterObjectStream cosWriterObjectStream =
        new COSWriterObjectStream(
            new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION));
    COSStream stream = new COSStream();

    // Act
    COSStream actualWriteObjectsToStreamResult = cosWriterObjectStream.writeObjectsToStream(stream);

    // Assert
    assertEquals(5, stream.size());
    assertEquals(8L, stream.getLength());
    assertTrue(stream.hasData());
    assertSame(stream, actualWriteObjectsToStreamResult);
  }
}
