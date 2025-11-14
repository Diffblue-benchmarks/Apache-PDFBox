package org.apache.pdfbox.pdfwriter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdfparser.COSParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ContentStreamWriterDiffblueTest {
  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName(
      "Test writeToken(COSBase) with 'base'; given FALSE; when COSArray() add FALSE; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_givenFalse_whenCOSArrayAddFalse_thenDoesNotThrow()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    COSArray base = new COSArray();
    base.add(COSBoolean.FALSE);

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeToken(base));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenA() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> new ContentStreamWriter(new ByteArrayOutputStream()).writeToken(COSName.A));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSName#AA}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when AA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenAa() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new ContentStreamWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L))
                .writeToken(COSName.AA));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSName#ABSOLUTE_COLORIMETRIC}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when ABSOLUTE_COLORIMETRIC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenAbsolute_colorimetric() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new ContentStreamWriter(new ByteArrayOutputStream())
                .writeToken(COSName.ABSOLUTE_COLORIMETRIC));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSName#ADBE_PKCS7_DETACHED}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when ADBE_PKCS7_DETACHED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenAdbe_pkcs7_detached() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new ContentStreamWriter(new ByteArrayOutputStream())
                .writeToken(COSName.ADBE_PKCS7_DETACHED));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSName#ADBE_X509_RSA_SHA1}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when ADBE_X509_RSA_SHA1")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenAdbe_x509_rsa_sha1() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new ContentStreamWriter(new ByteArrayOutputStream())
                .writeToken(COSName.ADBE_X509_RSA_SHA1));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenCOSArray() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeToken(new COSArray()));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName(
      "Test writeToken(COSBase) with 'base'; when COSArray(List) with cosObjectables is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenCOSArrayWithCosObjectablesIsArrayList() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter =
        new ContentStreamWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L));

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeToken(new COSArray(new ArrayList<>())));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenCOSDictionary() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeToken(new COSDictionary()));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSFloat#COSFloat(float)} with aFloat is {@code -3.4028235E38}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName(
      "Test writeToken(COSBase) with 'base'; when COSFloat(float) with aFloat is '-3.4028235E38'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenCOSFloatWithAFloatIs34028235e38() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeToken(new COSFloat(-3.4028235E38f)));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSFloat#COSFloat(float)} with aFloat is ten.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when COSFloat(float) with aFloat is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenCOSFloatWithAFloatIsTen() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeToken(new COSFloat(10.0f)));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSString#COSString(String)} with {@code Text}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when COSString(String) with 'Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenCOSStringWithText() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeToken(new COSString("Text")));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSString#COSString(String, boolean)} with {@code Text} and forceHex is
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName(
      "Test writeToken(COSBase) with 'base'; when COSString(String, boolean) with 'Text' and forceHex is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenCOSStringWithTextAndForceHexIsTrue() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeToken(new COSString("Text", true)));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSString#COSString(String, boolean)} with {@code Text} and forceHex is
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName(
      "Test writeToken(COSBase) with 'base'; when COSString(String, boolean) with 'Text' and forceHex is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenCOSStringWithTextAndForceHexIsTrue2() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter =
        new ContentStreamWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L));

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeToken(new COSString("Text", true)));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenFalse() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> new ContentStreamWriter(new ByteArrayOutputStream()).writeToken(COSBoolean.FALSE));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when 'null'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenNull_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new ContentStreamWriter(new ByteArrayOutputStream()).writeToken((COSBase) null));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenOne() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> new ContentStreamWriter(new ByteArrayOutputStream()).writeToken(COSFloat.ONE));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenOne2() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> new ContentStreamWriter(new ByteArrayOutputStream()).writeToken(COSInteger.ONE));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when parseHex '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenParseHex0123456789abcdef() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    // Act and Assert
    assertDoesNotThrow(
        () -> contentStreamWriter.writeToken(COSString.parseHex("0123456789ABCDEF")));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSInteger#THREE}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when THREE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenThree() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new ContentStreamWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L))
                .writeToken(COSInteger.THREE));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#TRUE}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when TRUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenTrue() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> new ContentStreamWriter(new ByteArrayOutputStream()).writeToken(COSBoolean.TRUE));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#TRUE}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when TRUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenTrue2() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new ContentStreamWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L))
                .writeToken(COSBoolean.TRUE));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   *
   * <ul>
   *   <li>When {@link COSFloat#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when ZERO")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(COSBase)"})
  void testWriteTokenWithBase_whenZero() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new ContentStreamWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L))
                .writeToken(COSFloat.ZERO));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName("Test writeToken(Operator) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(COSName.ADBE_PKCS7_DETACHED);
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName("Test writeToken(Operator) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp2() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(COSName.ADBE_X509_RSA_SHA1);
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName("Test writeToken(Operator) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp3() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(COSString.parseHex("0123456789ABCDEF"));
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName("Test writeToken(Operator) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp4() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSFloat(10.0f));
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName("Test writeToken(Operator) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp5() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSString("BI"));
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName("Test writeToken(Operator) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp6() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(new COSString("BI", true));
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName("Test writeToken(Operator) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp7() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter =
        new ContentStreamWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L));

    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(cosName);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(mock(COSName.class));
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeToken(op));
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(cosName).writePDF(isA(OutputStream.class));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName("Test writeToken(Operator) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp8() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter =
        new ContentStreamWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L));

    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);
    cosNameSet.add(cosName);

    COSName cosName2 = mock(COSName.class);
    doNothing().when(cosName2).writePDF(Mockito.<OutputStream>any());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosName2);
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeToken(op));
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary).keySet();
    verify(cosName2).writePDF(isA(OutputStream.class));
    verify(cosName).writePDF(isA(OutputStream.class));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName("Test writeToken(Operator) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp9() throws IOException {
    // Arrange
    COSStandardOutputStream out =
        new COSStandardOutputStream(
            new COSStandardOutputStream(new ByteArrayOutputStream(), 1L), 1L);
    out.setOnNewLine(true);
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(out);

    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(cosName);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(mock(COSName.class));
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeToken(op));
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(cosName).writePDF(isA(OutputStream.class));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName("Test writeToken(Operator) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp10() throws IOException {
    // Arrange
    COSStandardOutputStream out =
        new COSStandardOutputStream(
            new COSStandardOutputStream(new ByteArrayOutputStream(), 1L), 1L);
    out.setOnNewLine(true);
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(out);

    Operator op = mock(Operator.class);

    COSName cosName = mock(COSName.class);
    doNothing().when(cosName).writePDF(Mockito.<OutputStream>any());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosName);

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSName cosName2 = mock(COSName.class);
    doThrow(new IOException()).when(cosName2).writePDF(Mockito.<OutputStream>any());
    cosNameSet.add(cosName2);
    when(cosDictionary.keySet()).thenReturn(cosNameSet);
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeToken(op));
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(cosDictionary).keySet();
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(cosName2).writePDF(isA(OutputStream.class));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then calls {@link Operator#getImageData()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given 'AXAXAXAX' Bytes is 'UTF-8'; then calls getImageData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenAxaxaxaxBytesIsUtf8_thenCallsGetImageData() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).keySet();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName("Test writeToken(Operator) with 'op'; given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenCOSDictionary() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(new COSDictionary());
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given COSDictionary getDictionaryObject(COSName) return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenCOSDictionaryGetDictionaryObjectReturnA() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given COSDictionary getDictionaryObject(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenCOSDictionaryGetDictionaryObjectReturnCOSArray()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given COSDictionary getDictionaryObject(COSName) return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenCOSDictionaryGetDictionaryObjectReturnFalse() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given COSDictionary getDictionaryObject(COSName) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenCOSDictionaryGetDictionaryObjectReturnNull() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(null);
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeToken(op));
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given COSDictionary getDictionaryObject(COSName) return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenCOSDictionaryGetDictionaryObjectReturnOne() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSFloat.ONE);
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSBoolean#TRUE}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given COSDictionary getDictionaryObject(COSName) return TRUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenCOSDictionaryGetDictionaryObjectReturnTrue() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.TRUE);
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Given {@link COSName} {@link COSName#writePDF(OutputStream)} does nothing.
   *   <li>Then calls {@link COSName#writePDF(OutputStream)}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given COSName writePDF(OutputStream) does nothing; then calls writePDF(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenCOSNameWritePDFDoesNothing_thenCallsWritePDF() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSName cosName = mock(COSName.class);
    doNothing().when(cosName).writePDF(Mockito.<OutputStream>any());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosName);
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(cosName).writePDF(isA(OutputStream.class));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Given {@link COSName} {@link COSName#writePDF(OutputStream)} does nothing.
   *   <li>Then calls {@link COSName#writePDF(OutputStream)}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given COSName writePDF(OutputStream) does nothing; then calls writePDF(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenCOSNameWritePDFDoesNothing_thenCallsWritePDF2()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    COSName cosName = mock(COSName.class);
    doNothing().when(cosName).writePDF(Mockito.<OutputStream>any());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(cosName);

    COSName cosName2 = mock(COSName.class);
    doNothing().when(cosName2).writePDF(Mockito.<OutputStream>any());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosName2);
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(cosName2).writePDF(isA(OutputStream.class));
    verify(cosName).writePDF(isA(OutputStream.class));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Given {@link COSName} {@link COSName#writePDF(OutputStream)} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given COSName writePDF(OutputStream) throw IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenCOSNameWritePDFThrowIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosName);
    when(cosDictionary.keySet()).thenReturn(cosNameSet);

    Operator op = mock(Operator.class);
    when(op.getImageParameters()).thenReturn(cosDictionary);
    when(op.getName()).thenReturn("BI");

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeToken(op));
    verify(op).getImageParameters();
    verify(op).getName();
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(cosName).writePDF(isA(OutputStream.class));
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName("Test writeToken(Operator) with 'op'; given COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenCOSStream() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    Operator op = mock(Operator.class);
    when(op.getImageData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(op.getImageParameters()).thenReturn(new COSStream());
    when(op.getName()).thenReturn("BI");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op).getImageData();
    verify(op).getImageParameters();
    verify(op).getName();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link Operator} {@link Operator#getName()} return {@code foo}.
   *   <li>Then calls {@link Operator#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given 'foo'; when Operator getName() return 'foo'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenFoo_whenOperatorGetNameReturnFoo_thenCallsGetName()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter =
        new ContentStreamWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L));

    Operator op = mock(Operator.class);
    when(op.getName()).thenReturn("foo");

    // Act
    contentStreamWriter.writeToken(op);

    // Assert
    verify(op, atLeast(1)).getName();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>When Operator is {@code Operator}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; when Operator is 'Operator'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_whenOperatorIsOperator_thenDoesNotThrow() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new ContentStreamWriter(new ByteArrayOutputStream())
                .writeToken(Operator.getOperator("Operator")));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName(
      "Test writeTokens(List) with 'List'; given '42'; when ArrayList() add '42'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_given42_whenArrayListAdd42_thenThrowIOException()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add("42");

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName(
      "Test writeTokens(List) with 'List'; given '42'; when ArrayList() add '42'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_given42_whenArrayListAdd42_thenThrowIOException2()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add("42");
    tokens.add("42");

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSName#A}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName(
      "Test writeTokens(List) with 'List'; given A; when ArrayList() add A; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenA_whenArrayListAddA_thenDoesNotThrow() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(COSName.A);

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link COSName#ABSOLUTE_COLORIMETRIC}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName("Test writeTokens(List) with 'List'; given ABSOLUTE_COLORIMETRIC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenAbsolute_colorimetric() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(COSName.ABSOLUTE_COLORIMETRIC);

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link COSName#ADBE_PKCS7_DETACHED}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName("Test writeTokens(List) with 'List'; given ADBE_PKCS7_DETACHED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenAdbe_pkcs7_detached() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(COSName.ADBE_PKCS7_DETACHED);

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link COSName#ADBE_X509_RSA_SHA1}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName("Test writeTokens(List) with 'List'; given ADBE_X509_RSA_SHA1")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenAdbe_x509_rsa_sha1() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(COSName.ADBE_X509_RSA_SHA1);

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName(
      "Test writeTokens(List) with 'List'; given COSArray() add FALSE; when ArrayList() add COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenCOSArrayAddFalse_whenArrayListAddCOSArray() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(cosArray);

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSArray#COSArray()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName(
      "Test writeTokens(List) with 'List'; given COSArray(); when ArrayList() add COSArray(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenCOSArray_whenArrayListAddCOSArray_thenDoesNotThrow()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(new COSArray());

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName(
      "Test writeTokens(List) with 'List'; given COSDictionary(); when ArrayList() add COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenCOSDictionary_whenArrayListAddCOSDictionary()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(new COSDictionary());

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName(
      "Test writeTokens(List) with 'List'; given COSDocument(); when ArrayList() add COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenCOSDocument_whenArrayListAddCOSDocument() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(new COSDocument());

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#COSFloat(float)} with aFloat is ten.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName("Test writeTokens(List) with 'List'; given COSFloat(float) with aFloat is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenCOSFloatWithAFloatIsTen() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(new COSFloat(10.0f));

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link COSString#COSString(String, boolean)} with {@code Text} and forceHex is
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName(
      "Test writeTokens(List) with 'List'; given COSString(String, boolean) with 'Text' and forceHex is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenCOSStringWithTextAndForceHexIsTrue() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(new COSString("Text", true));

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link COSString#COSString(String)} with {@code Text}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSString#COSString(String)} with {@code
   *       Text}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName(
      "Test writeTokens(List) with 'List'; given COSString(String) with 'Text'; when ArrayList() add COSString(String) with 'Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenCOSStringWithText_whenArrayListAddCOSStringWithText()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(new COSString("Text"));

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName(
      "Test writeTokens(List) with 'List'; given FALSE; when ArrayList() add FALSE; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenFalse_whenArrayListAddFalse_thenDoesNotThrow()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(COSBoolean.FALSE);

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#ONE}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName(
      "Test writeTokens(List) with 'List'; given ONE; when ArrayList() add ONE; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenOne_whenArrayListAddOne_thenDoesNotThrow() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(COSFloat.ONE);

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName(
      "Test writeTokens(List) with 'List'; given ONE; when ArrayList() add ONE; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenOne_whenArrayListAddOne_thenDoesNotThrow2() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(COSInteger.ONE);

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given Operator is {@code Operator}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName("Test writeTokens(List) with 'List'; given Operator is 'Operator'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenOperatorIsOperator() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(Operator.getOperator("Operator"));

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given parseHex {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName("Test writeTokens(List) with 'List'; given parseHex '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenParseHex0123456789abcdef() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(COSString.parseHex("0123456789ABCDEF"));

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#TRUE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#TRUE}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName(
      "Test writeTokens(List) with 'List'; given TRUE; when ArrayList() add TRUE; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenTrue_whenArrayListAddTrue_thenDoesNotThrow()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(COSBoolean.TRUE);

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName("Test writeTokens(List) with 'List'; when ArrayList(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_whenArrayList_thenDoesNotThrow() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    // Act and Assert
    assertDoesNotThrow(() -> contentStreamWriter.writeTokens(new ArrayList<>()));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(Object[])}
   */
  @Test
  @DisplayName("Test writeTokens(Object[]) with 'Object[]'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(Object[])"})
  void testWriteTokensWithObject_thenDoesNotThrow() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new ContentStreamWriter(new ByteArrayOutputStream()).writeTokens());
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is eighteen and gen is
   *       eighteen.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(Object[])}
   */
  @Test
  @DisplayName(
      "Test writeTokens(Object[]) with 'Object[]'; when COSObjectKey(long, int) with num is eighteen and gen is eighteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(Object[])"})
  void testWriteTokensWithObject_whenCOSObjectKeyWithNumIsEighteenAndGenIsEighteen()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    Operator operator = Operator.getOperator("BI");
    operator.setImageData(new byte[] {'A', 18, 'A', 18, 'A', 18, 'A', 18});
    operator.setImageParameters(new COSStream());
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(18L, 18));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            contentStreamWriter.writeTokens(
                operator,
                cosObject,
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI")));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(Object[])}
   */
  @Test
  @DisplayName(
      "Test writeTokens(Object[]) with 'Object[]'; when COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(Object[])"})
  void testWriteTokensWithObject_whenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    Operator operator = Operator.getOperator("BI");
    operator.setImageData(new byte[] {'A', 18, 'A', 18, 'A', 18, 'A', 18});
    operator.setImageParameters(new COSStream());
    COSObject cosObject =
        new COSObject(COSBoolean.FALSE, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            contentStreamWriter.writeTokens(
                operator,
                cosObject,
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI")));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When Operator is {@code BI} and {@link COSDocument#COSDocument()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(Object[])}
   */
  @Test
  @DisplayName(
      "Test writeTokens(Object[]) with 'Object[]'; when Operator is 'BI' and COSDocument(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(Object[])"})
  void testWriteTokensWithObject_whenOperatorIsBiAndCOSDocument_thenThrowIOException()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    Operator operator = Operator.getOperator("BI");
    operator.setImageData(new byte[] {'A', 18, 'A', 18, 'A', 18, 'A', 18});
    operator.setImageParameters(new COSStream());

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            contentStreamWriter.writeTokens(
                operator,
                new COSDocument(),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI"),
                Operator.getOperator("BI")));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code Tokens}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(Object[])}
   */
  @Test
  @DisplayName("Test writeTokens(Object[]) with 'Object[]'; when 'Tokens'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(Object[])"})
  void testWriteTokensWithObject_whenTokens_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new ContentStreamWriter(new ByteArrayOutputStream()).writeTokens("Tokens"));
  }
}
