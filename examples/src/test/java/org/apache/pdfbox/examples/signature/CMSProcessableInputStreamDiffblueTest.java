package org.apache.pdfbox.examples.signature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.cms.CMSException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CMSProcessableInputStreamDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CMSProcessableInputStream#CMSProcessableInputStream(ASN1ObjectIdentifier,
   *       InputStream)}
   *   <li>{@link CMSProcessableInputStream#getContent()}
   *   <li>{@link CMSProcessableInputStream#getContentType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CMSProcessableInputStream.<init>(ASN1ObjectIdentifier, InputStream)",
    "Object CMSProcessableInputStream.getContent()",
    "ASN1ObjectIdentifier CMSProcessableInputStream.getContentType()"
  })
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    ASN1ObjectIdentifier type = ECNamedCurveTable.getOID("foo");
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    CMSProcessableInputStream actualCmsProcessableInputStream =
        new CMSProcessableInputStream(type, is);
    Object actualContent = actualCmsProcessableInputStream.getContent();

    // Assert
    assertNull(actualCmsProcessableInputStream.getContentType());
    assertSame(is, actualContent);
  }

  /**
   * Test {@link CMSProcessableInputStream#CMSProcessableInputStream(InputStream)}.
   *
   * <p>Method under test: {@link CMSProcessableInputStream#CMSProcessableInputStream(InputStream)}
   */
  @Test
  @DisplayName("Test new CMSProcessableInputStream(InputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CMSProcessableInputStream.<init>(InputStream)"})
  void testNewCMSProcessableInputStream() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    CMSProcessableInputStream actualCmsProcessableInputStream = new CMSProcessableInputStream(is);

    // Assert
    ASN1ObjectIdentifier contentType = actualCmsProcessableInputStream.getContentType();
    assertEquals("1.2.840.113549.1.7.1", contentType.getId());
    assertSame(is, actualCmsProcessableInputStream.getContent());
    assertArrayEquals(
        new byte[] {6, '\t', '*', -122, 'H', -122, -9, '\r', 1, 7, 1}, contentType.getEncoded());
  }

  /**
   * Test {@link CMSProcessableInputStream#CMSProcessableInputStream(InputStream)}.
   *
   * <p>Method under test: {@link CMSProcessableInputStream#CMSProcessableInputStream(InputStream)}
   */
  @Test
  @DisplayName("Test new CMSProcessableInputStream(InputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CMSProcessableInputStream.<init>(InputStream)"})
  void testNewCMSProcessableInputStream2() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8"));

    // Act
    CMSProcessableInputStream actualCmsProcessableInputStream = new CMSProcessableInputStream(is);

    // Assert
    ASN1ObjectIdentifier contentType = actualCmsProcessableInputStream.getContentType();
    assertEquals("1.2.840.113549.1.7.1", contentType.getId());
    assertSame(is, actualCmsProcessableInputStream.getContent());
    assertArrayEquals(
        new byte[] {6, '\t', '*', -122, 'H', -122, -9, '\r', 1, 7, 1}, contentType.getEncoded());
  }

  /**
   * Test {@link CMSProcessableInputStream#write(OutputStream)}.
   *
   * <p>Method under test: {@link CMSProcessableInputStream#write(OutputStream)}
   */
  @Test
  @DisplayName("Test write(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CMSProcessableInputStream.write(OutputStream)"})
  void testWrite() throws IOException, CMSException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    CMSProcessableInputStream cmsProcessableInputStream = new CMSProcessableInputStream(is);
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    // Act
    cmsProcessableInputStream.write(out);

    // Assert
    assertSame(is, cmsProcessableInputStream.getContent());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, out.toByteArray());
  }

  /**
   * Test {@link CMSProcessableInputStream#write(OutputStream)}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#transferTo(OutputStream)} throw
   *       {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CMSProcessableInputStream#write(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test write(OutputStream); given DataInputStream transferTo(OutputStream) throw IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CMSProcessableInputStream.write(OutputStream)"})
  void testWrite_givenDataInputStreamTransferToThrowIOException_thenThrowIOException()
      throws IOException, CMSException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.transferTo(Mockito.<OutputStream>any())).thenThrow(new IOException());
    CMSProcessableInputStream cmsProcessableInputStream = new CMSProcessableInputStream(is);

    // Act and Assert
    assertThrows(
        IOException.class, () -> cmsProcessableInputStream.write(new ByteArrayOutputStream()));
    verify(is).transferTo(isA(OutputStream.class));
  }
}
