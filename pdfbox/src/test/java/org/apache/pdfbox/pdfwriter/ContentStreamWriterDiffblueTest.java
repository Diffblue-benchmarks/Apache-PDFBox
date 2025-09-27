package org.apache.pdfbox.pdfwriter;

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
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ContentStreamWriterDiffblueTest {
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
  void testWriteTokenWithOp2() throws IOException {
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
  void testWriteTokenWithOp3() throws IOException {
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
  void testWriteTokenWithOp4() throws IOException {
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#keySet()} return {@link
   *       HashSet#HashSet()}.
   *   <li>Then calls {@link Operator#getImageData()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given COSDictionary keySet() return HashSet(); then calls getImageData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenCOSDictionaryKeySetReturnHashSet_thenCallsGetImageData()
      throws IOException {
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

    COSName cosName = mock(COSName.class);
    doNothing().when(cosName).writePDF(Mockito.<OutputStream>any());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(cosName);

    COSString cosString = mock(COSString.class);
    when(cosString.getForceHexForm()).thenReturn(true);
    when(cosString.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);
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
    verify(cosString).getBytes();
    verify(cosString).getForceHexForm();
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
   *   <li>Given {@link COSString} {@link COSString#getForceHexForm()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given COSString getForceHexForm() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenCOSStringGetForceHexFormReturnFalse() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter =
        new ContentStreamWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L));

    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);
    cosNameSet.add(cosName);

    COSString cosString = mock(COSString.class);
    when(cosString.getForceHexForm()).thenReturn(false);
    when(cosString.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);
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
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(cosString).getBytes();
    verify(cosString).getForceHexForm();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Given {@link COSString} {@link COSString#getForceHexForm()} return {@code true}.
   *   <li>Then calls {@link COSString#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given COSString getForceHexForm() return 'true'; then calls getBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenCOSStringGetForceHexFormReturnTrue_thenCallsGetBytes()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);

    COSString cosString = mock(COSString.class);
    when(cosString.getForceHexForm()).thenReturn(true);
    when(cosString.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);
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
    verify(cosString).getBytes();
    verify(cosString).getForceHexForm();
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
   *   <li>Given {@link HashSet#HashSet()} add {@link COSName#ADBE_PKCS7_DETACHED}.
   *   <li>Then calls {@link COSString#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given HashSet() add ADBE_PKCS7_DETACHED; then calls getBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenHashSetAddAdbe_pkcs7_detached_thenCallsGetBytes()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.ADBE_PKCS7_DETACHED);

    COSString cosString = mock(COSString.class);
    when(cosString.getForceHexForm()).thenReturn(true);
    when(cosString.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);
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
    verify(cosString).getBytes();
    verify(cosString).getForceHexForm();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link COSName#ADBE_X509_RSA_SHA1}.
   *   <li>Then calls {@link COSString#getBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName(
      "Test writeToken(Operator) with 'op'; given HashSet() add ADBE_X509_RSA_SHA1; then calls getBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_givenHashSetAddAdbe_x509_rsa_sha1_thenCallsGetBytes()
      throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.ADBE_X509_RSA_SHA1);

    COSString cosString = mock(COSString.class);
    when(cosString.getForceHexForm()).thenReturn(true);
    when(cosString.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosString);
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
    verify(cosString).getBytes();
    verify(cosString).getForceHexForm();
  }

  /**
   * Test {@link ContentStreamWriter#writeToken(Operator)} with {@code op}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeToken(Operator)}
   */
  @Test
  @DisplayName("Test writeToken(Operator) with 'op'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeToken(Operator)"})
  void testWriteTokenWithOp_thenThrowIOException() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter =
        new ContentStreamWriter(new COSStandardOutputStream(new ByteArrayOutputStream(), 1L));

    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(cosName);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(mock(COSString.class));
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
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName(
      "Test writeTokens(List) with 'List'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ContentStreamWriter.writeTokens(List)"})
  void testWriteTokensWithList_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream());

    ArrayList<Object> tokens = new ArrayList<>();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    tokens.add(cosObject);

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeTokens(tokens));
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
