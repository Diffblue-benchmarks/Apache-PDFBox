package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDXFAResourceDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDXFAResource#PDXFAResource(COSBase)}
   *   <li>{@link PDXFAResource#getCOSObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    COSBase actualCOSObject = (new PDXFAResource(COSBoolean.FALSE)).getCOSObject();

    // Assert
    assertSame(((COSBoolean) actualCOSObject).FALSE, actualCOSObject);
  }

  /**
   * Test {@link PDXFAResource#getBytes()}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDXFAResource#getBytes()}
   */
  @Test
  @DisplayName("Test getBytes(); given COSArray() add FALSE; then return array length is zero")
  void testGetBytes_givenCOSArrayAddFalse_thenReturnArrayLengthIsZero() throws IOException {
    // Arrange
    COSArray xfaBase = new COSArray();
    xfaBase.add(COSBoolean.FALSE);
    xfaBase.add(COSBoolean.FALSE);

    // Act and Assert
    assertEquals(0, (new PDXFAResource(xfaBase)).getBytes().length);
  }

  /**
   * Test {@link PDXFAResource#getBytes()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDXFAResource#getBytes()}
   */
  @Test
  @DisplayName("Test getBytes(); given COSObjectKey(long, int) with num is one and gen is one")
  void testGetBytes_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    COSArray xfaBase = new COSArray();
    xfaBase.add(COSBoolean.FALSE);
    xfaBase.add((COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act and Assert
    assertEquals(0, (new PDXFAResource(xfaBase)).getBytes().length);
  }

  /**
   * Test {@link PDXFAResource#getBytes()}.
   * <ul>
   *   <li>Given {@link PDXFAResource#PDXFAResource(COSBase)} with xfaBase is
   * {@link COSArray#COSArray()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDXFAResource#getBytes()}
   */
  @Test
  @DisplayName("Test getBytes(); given PDXFAResource(COSBase) with xfaBase is COSArray(); then return array length is zero")
  void testGetBytes_givenPDXFAResourceWithXfaBaseIsCOSArray_thenReturnArrayLengthIsZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new PDXFAResource(new COSArray())).getBytes().length);
  }

  /**
   * Test {@link PDXFAResource#getBytes()}.
   * <ul>
   *   <li>Given {@link PDXFAResource#PDXFAResource(COSBase)} with xfaBase is
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDXFAResource#getBytes()}
   */
  @Test
  @DisplayName("Test getBytes(); given PDXFAResource(COSBase) with xfaBase is FALSE; then return array length is zero")
  void testGetBytes_givenPDXFAResourceWithXfaBaseIsFalse_thenReturnArrayLengthIsZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new PDXFAResource(COSBoolean.FALSE)).getBytes().length);
  }

  /**
   * Test {@link PDXFAResource#getDocument()}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSBase#getCOSObject()} return
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDXFAResource#getDocument()}
   */
  @Test
  @DisplayName("Test getDocument(); given COSStream getCOSObject() return COSStream(); then throw IOException")
  void testGetDocument_givenCOSStreamGetCOSObjectReturnCOSStream_thenThrowIOException() throws IOException {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.getCOSObject()).thenReturn(new COSStream());
    COSArray xfaBase = mock(COSArray.class);
    when(xfaBase.getObject(anyInt())).thenReturn(cosStream);
    when(xfaBase.size()).thenReturn(3);

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDXFAResource(xfaBase)).getDocument());
    verify(xfaBase).getObject(eq(1));
    verify(xfaBase).size();
    verify(cosStream).getCOSObject();
  }
}
