package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSInputStream;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDXFAResourceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDXFAResource#PDXFAResource(COSBase)}
   *   <li>{@link PDXFAResource#getCOSObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDXFAResource.<init>(COSBase)", "COSBase PDXFAResource.getCOSObject()"})
  void testGettersAndSetters() {
    // Arrange and Act
    COSBase actualCOSObject = new PDXFAResource(COSBoolean.FALSE).getCOSObject();

    // Assert
    assertSame(((COSBoolean) actualCOSObject).FALSE, actualCOSObject);
  }

  /**
   * Test {@link PDXFAResource#getBytes()}.
   *
   * <ul>
   *   <li>Given {@link COSObjectable} {@link COSObjectable#getCOSObject()} return {@link
   *       COSBoolean#FALSE}.
   *   <li>Then calls {@link COSObjectable#getCOSObject()}.
   * </ul>
   *
   * <p>Method under test: {@link PDXFAResource#getBytes()}
   */
  @Test
  @DisplayName(
      "Test getBytes(); given COSObjectable getCOSObject() return FALSE; then calls getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDXFAResource.getBytes()"})
  void testGetBytes_givenCOSObjectableGetCOSObjectReturnFalse_thenCallsGetCOSObject()
      throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray xfaBase = new COSArray();
    xfaBase.add(COSBoolean.FALSE);
    xfaBase.add(object);
    xfaBase.add(2, COSBoolean.FALSE);

    // Act
    byte[] actualBytes = new PDXFAResource(xfaBase).getBytes();

    // Assert
    verify(object).getCOSObject();
    assertArrayEquals(new byte[] {}, actualBytes);
  }

  /**
   * Test {@link PDXFAResource#getBytes()}.
   *
   * <ul>
   *   <li>Given {@link PDXFAResource#PDXFAResource(COSBase)} with xfaBase is {@link
   *       COSArray#COSArray()}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link PDXFAResource#getBytes()}
   */
  @Test
  @DisplayName(
      "Test getBytes(); given PDXFAResource(COSBase) with xfaBase is COSArray(); then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDXFAResource.getBytes()"})
  void testGetBytes_givenPDXFAResourceWithXfaBaseIsCOSArray_thenReturnEmptyArrayOfByte()
      throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new PDXFAResource(new COSArray()).getBytes());
  }

  /**
   * Test {@link PDXFAResource#getBytes()}.
   *
   * <ul>
   *   <li>Given {@link PDXFAResource#PDXFAResource(COSBase)} with xfaBase is {@link
   *       COSBoolean#FALSE}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link PDXFAResource#getBytes()}
   */
  @Test
  @DisplayName(
      "Test getBytes(); given PDXFAResource(COSBase) with xfaBase is FALSE; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDXFAResource.getBytes()"})
  void testGetBytes_givenPDXFAResourceWithXfaBaseIsFalse_thenReturnEmptyArrayOfByte()
      throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new PDXFAResource(COSBoolean.FALSE).getBytes());
  }

  /**
   * Test {@link PDXFAResource#getDocument()}.
   *
   * <ul>
   *   <li>Given {@link COSInputStream} {@link COSInputStream#readAllBytes()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link COSInputStream#close()}.
   * </ul>
   *
   * <p>Method under test: {@link PDXFAResource#getDocument()}
   */
  @Test
  @DisplayName(
      "Test getDocument(); given COSInputStream readAllBytes() throw IOException(); then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.w3c.dom.Document PDXFAResource.getDocument()"})
  void testGetDocument_givenCOSInputStreamReadAllBytesThrowIOException_thenCallsClose()
      throws IOException {
    // Arrange
    COSInputStream cosInputStream = mock(COSInputStream.class);
    when(cosInputStream.readAllBytes()).thenThrow(new IOException());
    doThrow(new IOException()).when(cosInputStream).close();

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.createInputStream()).thenReturn(cosInputStream);

    COSStream cosStream2 = mock(COSStream.class);
    when(cosStream2.getCOSObject()).thenReturn(cosStream);

    COSArray xfaBase = mock(COSArray.class);
    when(xfaBase.getObject(anyInt())).thenReturn(cosStream2);
    when(xfaBase.size()).thenReturn(3);

    // Act and Assert
    assertThrows(IOException.class, () -> new PDXFAResource(xfaBase).getDocument());
    verify(cosInputStream).close();
    verify(cosInputStream).readAllBytes();
    verify(xfaBase).getObject(1);
    verify(xfaBase).size();
    verify(cosStream2).getCOSObject();
    verify(cosStream).createInputStream();
  }

  /**
   * Test {@link PDXFAResource#getDocument()}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#getCOSObject()} return {@link
   *       COSStream#COSStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDXFAResource#getDocument()}
   */
  @Test
  @DisplayName(
      "Test getDocument(); given COSStream getCOSObject() return COSStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.w3c.dom.Document PDXFAResource.getDocument()"})
  void testGetDocument_givenCOSStreamGetCOSObjectReturnCOSStream_thenThrowIOException()
      throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.getCOSObject()).thenReturn(new COSStream());

    COSArray xfaBase = mock(COSArray.class);
    when(xfaBase.getObject(anyInt())).thenReturn(cosStream);
    when(xfaBase.size()).thenReturn(3);

    // Act and Assert
    assertThrows(IOException.class, () -> new PDXFAResource(xfaBase).getDocument());
    verify(xfaBase).getObject(1);
    verify(xfaBase).size();
    verify(cosStream).getCOSObject();
  }
}
