package org.apache.pdfbox.examples.signature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CMSProcessableInputStreamDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CMSProcessableInputStream#CMSProcessableInputStream(ASN1ObjectIdentifier, InputStream)}
   *   <li>{@link CMSProcessableInputStream#getContent()}
   *   <li>{@link CMSProcessableInputStream#getContentType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    ASN1ObjectIdentifier type = ECNamedCurveTable.getOID("foo");
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    CMSProcessableInputStream actualCmsProcessableInputStream = new CMSProcessableInputStream(type, is);
    Object actualContent = actualCmsProcessableInputStream.getContent();

    // Assert
    assertNull(actualCmsProcessableInputStream.getContentType());
    assertSame(is, actualContent);
  }

  /**
   * Method under test: {@link CMSProcessableInputStream#write(OutputStream)}
   */
  @Test
  void testWrite() throws IOException, CMSException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    CMSProcessableInputStream cmsProcessableInputStream = new CMSProcessableInputStream(is);
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    cmsProcessableInputStream.write(out);

    // Assert that nothing has changed
    assertSame(is, cmsProcessableInputStream.getContent());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, out.toByteArray());
  }

  /**
   * Method under test: {@link CMSProcessableInputStream#write(OutputStream)}
   */
  @Test
  void testWrite2() throws IOException, CMSException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);
    doNothing().when(is).close();
    CMSProcessableInputStream cmsProcessableInputStream = new CMSProcessableInputStream(is);
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    cmsProcessableInputStream.write(out);

    // Assert that nothing has changed
    verify(is).close();
    verify(is).transferTo(isA(OutputStream.class));
    assertEquals(0, out.toByteArray().length);
  }

  /**
   * Method under test:
   * {@link CMSProcessableInputStream#CMSProcessableInputStream(InputStream)}
   */
  @Test
  void testNewCMSProcessableInputStream() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    CMSProcessableInputStream actualCmsProcessableInputStream = new CMSProcessableInputStream(is);

    // Assert
    ASN1ObjectIdentifier contentType = actualCmsProcessableInputStream.getContentType();
    assertEquals("1.2.840.113549.1.7.1", contentType.getId());
    assertSame(is, actualCmsProcessableInputStream.getContent());
    assertArrayEquals(new byte[]{6, '\t', '*', -122, 'H', -122, -9, '\r', 1, 7, 1}, contentType.getEncoded());
  }

  /**
   * Method under test:
   * {@link CMSProcessableInputStream#CMSProcessableInputStream(InputStream)}
   */
  @Test
  void testNewCMSProcessableInputStream2() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8"));

    // Act
    CMSProcessableInputStream actualCmsProcessableInputStream = new CMSProcessableInputStream(is);

    // Assert
    ASN1ObjectIdentifier contentType = actualCmsProcessableInputStream.getContentType();
    assertEquals("1.2.840.113549.1.7.1", contentType.getId());
    assertSame(is, actualCmsProcessableInputStream.getContent());
    assertArrayEquals(new byte[]{6, '\t', '*', -122, 'H', -122, -9, '\r', 1, 7, 1}, contentType.getEncoded());
  }

  /**
   * Method under test:
   * {@link CMSProcessableInputStream#CMSProcessableInputStream(InputStream)}
   */
  @Test
  void testNewCMSProcessableInputStream3() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);

    // Act
    CMSProcessableInputStream actualCmsProcessableInputStream = new CMSProcessableInputStream(is);

    // Assert
    ASN1ObjectIdentifier contentType = actualCmsProcessableInputStream.getContentType();
    assertEquals("1.2.840.113549.1.7.1", contentType.getId());
    assertSame(is, actualCmsProcessableInputStream.getContent());
    assertArrayEquals(new byte[]{6, '\t', '*', -122, 'H', -122, -9, '\r', 1, 7, 1}, contentType.getEncoded());
  }
}
