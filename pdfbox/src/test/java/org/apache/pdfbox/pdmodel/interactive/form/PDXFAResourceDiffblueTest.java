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
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class PDXFAResourceDiffblueTest {
  /**
   * Method under test: {@link PDXFAResource#getBytes()}
   */
  @Test
  void testGetBytes() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new PDXFAResource(COSBoolean.FALSE)).getBytes().length);
    assertEquals(0, (new PDXFAResource(new COSArray())).getBytes().length);
  }

  /**
   * Method under test: {@link PDXFAResource#getBytes()}
   */
  @Test
  void testGetBytes2() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray xfaBase = new COSArray();
    xfaBase.add(object);

    // Act
    byte[] actualBytes = (new PDXFAResource(xfaBase)).getBytes();

    // Assert
    verify(object).getCOSObject();
    assertEquals(0, actualBytes.length);
  }

  /**
   * Method under test: {@link PDXFAResource#getBytes()}
   */
  @Test
  void testGetBytes3() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray xfaBase = new COSArray();
    xfaBase.add(COSBoolean.FALSE);
    xfaBase.add(object);

    // Act
    byte[] actualBytes = (new PDXFAResource(xfaBase)).getBytes();

    // Assert
    verify(object).getCOSObject();
    assertEquals(0, actualBytes.length);
  }

  /**
   * Method under test: {@link PDXFAResource#getBytes()}
   */
  @Test
  void testGetBytes4() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    COSArray xfaBase = new COSArray();
    xfaBase.add(COSBoolean.FALSE);
    xfaBase.add(object);

    // Act
    byte[] actualBytes = (new PDXFAResource(xfaBase)).getBytes();

    // Assert
    verify(object).getCOSObject();
    assertEquals(0, actualBytes.length);
  }

  /**
   * Method under test: {@link PDXFAResource#getDocument()}
   */
  @Test
  void testGetDocument() throws IOException {
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

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDXFAResource#PDXFAResource(COSBase)}
   *   <li>{@link PDXFAResource#getCOSObject()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    COSBase actualCOSObject = (new PDXFAResource(COSBoolean.FALSE)).getCOSObject();

    // Assert
    assertSame(((COSBoolean) actualCOSObject).FALSE, actualCOSObject);
  }
}
