package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDMetadataDiffblueTest {
  /**
   * Test {@link PDMetadata#PDMetadata(COSStream)}.
   * <p>
   * Method under test: {@link PDMetadata#PDMetadata(COSStream)}
   */
  @Test
  @DisplayName("Test new PDMetadata(COSStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMetadata.<init>(COSStream)"})
  void testNewPDMetadata() {
    // Arrange
    COSStream str = new COSStream();

    // Act and Assert
    assertSame(str, (new PDMetadata(str)).getCOSObject());
  }

  /**
   * Test {@link PDMetadata#PDMetadata(PDDocument, InputStream)}.
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8} read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMetadata#PDMetadata(PDDocument, InputStream)}
   */
  @Test
  @DisplayName("Test new PDMetadata(PDDocument, InputStream); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMetadata.<init>(PDDocument, InputStream)"})
  void testNewPDMetadata_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    ByteArrayInputStream str = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDMetadata actualPdMetadata = new PDMetadata(doc, str);

    // Assert
    assertEquals(-1, str.read(new byte[]{}));
    assertEquals(8, actualPdMetadata.getLength());
    assertEquals(8L, actualPdMetadata.getCOSObject().getLength());
  }

  /**
   * Test {@link PDMetadata#PDMetadata(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMetadata#PDMetadata(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDMetadata(PDDocument); when PDDocument(); then return DecodeParms is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMetadata.<init>(PDDocument)"})
  void testNewPDMetadata_whenPDDocument_thenReturnDecodeParmsIsNull() throws IOException {
    // Arrange and Act
    PDMetadata actualPdMetadata = new PDMetadata(new PDDocument());

    // Assert
    assertNull(actualPdMetadata.getDecodeParms());
    assertNull(actualPdMetadata.getFileDecodeParams());
    assertNull(actualPdMetadata.getMetadata());
    assertNull(actualPdMetadata.getFile());
    assertEquals(-1, actualPdMetadata.getDecodedStreamLength());
    assertEquals(0, actualPdMetadata.getLength());
    List<String> fileFilters = actualPdMetadata.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, actualPdMetadata.getFilters());
  }

  /**
   * Test {@link PDMetadata#exportXMPMetadata()}.
   * <p>
   * Method under test: {@link PDMetadata#exportXMPMetadata()}
   */
  @Test
  @DisplayName("Test exportXMPMetadata()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InputStream PDMetadata.exportXMPMetadata()"})
  void testExportXMPMetadata() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, (new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).exportXMPMetadata()
        .read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDMetadata#exportXMPMetadata()}.
   * <ul>
   *   <li>Then return read is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMetadata#exportXMPMetadata()}
   */
  @Test
  @DisplayName("Test exportXMPMetadata(); then return read is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InputStream PDMetadata.exportXMPMetadata()"})
  void testExportXMPMetadata_thenReturnReadIsEight() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    PDMetadata pdMetadata = new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    pdMetadata.setFilters(new ArrayList<>());

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, pdMetadata.exportXMPMetadata().read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDMetadata#importXMPMetadata(byte[])}.
   * <p>
   * Method under test: {@link PDMetadata#importXMPMetadata(byte[])}
   */
  @Test
  @DisplayName("Test importXMPMetadata(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMetadata.importXMPMetadata(byte[])"})
  void testImportXMPMetadata() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDMetadata pdMetadata = new PDMetadata(doc, new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));

    // Act
    pdMetadata.importXMPMetadata("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertEquals(8, pdMetadata.getLength());
    COSStream cOSObject = pdMetadata.getCOSObject();
    assertEquals(8L, cOSObject.getLength());
    assertTrue(cOSObject.hasData());
  }

  /**
   * Test {@link PDMetadata#importXMPMetadata(byte[])}.
   * <ul>
   *   <li>Then {@link PDMetadata#PDMetadata(COSStream)} with str is {@link COSStream#COSStream()} Length is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMetadata#importXMPMetadata(byte[])}
   */
  @Test
  @DisplayName("Test importXMPMetadata(byte[]); then PDMetadata(COSStream) with str is COSStream() Length is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMetadata.importXMPMetadata(byte[])"})
  void testImportXMPMetadata_thenPDMetadataWithStrIsCOSStreamLengthIsEight() throws IOException {
    // Arrange
    PDMetadata pdMetadata = new PDMetadata(new COSStream());

    // Act
    pdMetadata.importXMPMetadata("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8, pdMetadata.getLength());
    COSStream cOSObject = pdMetadata.getCOSObject();
    assertEquals(8L, cOSObject.getLength());
    assertTrue(cOSObject.hasData());
  }

  /**
   * Test {@link PDMetadata#importXMPMetadata(byte[])}.
   * <ul>
   *   <li>Then {@link PDMetadata#PDMetadata(COSStream)} with str is {@link COSStream#COSStream()} Length is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMetadata#importXMPMetadata(byte[])}
   */
  @Test
  @DisplayName("Test importXMPMetadata(byte[]); then PDMetadata(COSStream) with str is COSStream() Length is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMetadata.importXMPMetadata(byte[])"})
  void testImportXMPMetadata_thenPDMetadataWithStrIsCOSStreamLengthIsEight2() throws IOException {
    // Arrange
    PDMetadata pdMetadata = new PDMetadata(new COSStream());
    pdMetadata.setFilters(new ArrayList<>());

    // Act
    pdMetadata.importXMPMetadata("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8, pdMetadata.getLength());
    COSStream cOSObject = pdMetadata.getCOSObject();
    assertEquals(8L, cOSObject.getLength());
    assertTrue(cOSObject.hasData());
  }
}
