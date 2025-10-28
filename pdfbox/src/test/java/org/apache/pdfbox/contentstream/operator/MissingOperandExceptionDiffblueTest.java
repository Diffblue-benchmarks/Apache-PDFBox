package org.apache.pdfbox.contentstream.operator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class MissingOperandExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link MissingOperandException#MissingOperandException(Operator, List)}
   */
  @Test
  void testNewMissingOperandException() {
    // Arrange
    Operator operator = Operator.getOperator("Operator");

    // Act
    MissingOperandException actualMissingOperandException = new MissingOperandException(operator, new ArrayList<>());

    // Assert
    assertNull(actualMissingOperandException.getCause());
    assertEquals(0, actualMissingOperandException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link MissingOperandException#MissingOperandException(Operator, List)}
   */
  @Test
  void testNewMissingOperandException2() {
    // Arrange
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);

    // Act
    MissingOperandException actualMissingOperandException = new MissingOperandException(operator, operands);

    // Assert
    assertNull(actualMissingOperandException.getCause());
    assertEquals(0, actualMissingOperandException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link MissingOperandException#MissingOperandException(Operator, List)}
   */
  @Test
  void testNewMissingOperandException3() {
    // Arrange
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);
    operands.add(COSBoolean.FALSE);

    // Act
    MissingOperandException actualMissingOperandException = new MissingOperandException(operator, operands);

    // Assert
    assertNull(actualMissingOperandException.getCause());
    assertEquals(0, actualMissingOperandException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link MissingOperandException#MissingOperandException(Operator, List)}
   */
  @Test
  void testNewMissingOperandException4() throws IOException {
    // Arrange
    Operator operator = Operator.getOperator("Operator");
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(cosDocument);

    // Act
    MissingOperandException actualMissingOperandException = new MissingOperandException(operator, operands);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualMissingOperandException.getCause());
    assertEquals(0, actualMissingOperandException.getSuppressed().length);
  }
}
