package org.apache.pdfbox.pdmodel.interactive.pagenavigation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDThreadBeadDiffblueTest {
  /**
   * Test {@link PDThreadBead#PDThreadBead(COSDictionary)}.
   * <p>
   * Method under test: {@link PDThreadBead#PDThreadBead(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDThreadBead(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDThreadBead.<init>(COSDictionary)"})
  void testNewPDThreadBead() {
    // Arrange
    COSDictionary b = new COSDictionary();

    // Act
    PDThreadBead actualPdThreadBead = new PDThreadBead(b);

    // Assert
    assertNull(actualPdThreadBead.getNextBead().getCOSObject());
    assertNull(actualPdThreadBead.getPreviousBead().getCOSObject());
    assertSame(b, actualPdThreadBead.getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#PDThreadBead()}.
   * <p>
   * Method under test: {@link PDThreadBead#PDThreadBead()}
   */
  @Test
  @DisplayName("Test new PDThreadBead()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDThreadBead.<init>()"})
  void testNewPDThreadBead2() {
    // Arrange and Act
    PDThreadBead actualPdThreadBead = new PDThreadBead();

    // Assert
    COSDictionary cOSObject = actualPdThreadBead.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualPdThreadBead.getPage());
    PDThreadBead nextBead = actualPdThreadBead.getNextBead();
    assertNull(nextBead.getPage());
    PDThreadBead previousBead = actualPdThreadBead.getPreviousBead();
    assertNull(previousBead.getPage());
    assertNull(actualPdThreadBead.getRectangle());
    assertNull(nextBead.getRectangle());
    assertNull(previousBead.getRectangle());
    assertNull(actualPdThreadBead.getThread());
    assertNull(nextBead.getThread());
    assertNull(previousBead.getThread());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertSame(cOSObject, nextBead.getCOSObject());
    assertSame(cOSObject, previousBead.getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#getCOSObject()}.
   * <p>
   * Method under test: {@link PDThreadBead#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDThreadBead.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDThreadBead()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(3, actualCOSObject.getValues().size());
    assertEquals(3, actualCOSObject.size());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
  }

  /**
   * Test {@link PDThreadBead#getThread()}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getThread()}
   */
  @Test
  @DisplayName("Test getThread(); given PDThreadBead(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDThread PDThreadBead.getThread()"})
  void testGetThread_givenPDThreadBead_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDThreadBead()).getThread());
  }

  /**
   * Test {@link PDThreadBead#getThread()}.
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getThread()}
   */
  @Test
  @DisplayName("Test getThread(); then return COSObject is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDThread PDThreadBead.getThread()"})
  void testGetThread_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDictionary t = new COSDictionary();
    t.setKey(new COSObjectKey(1L, 1));
    PDThread thread = new PDThread(t);

    PDThreadBead pdThreadBead = new PDThreadBead();
    pdThreadBead.setThread(thread);

    // Act and Assert
    assertSame(t, pdThreadBead.getThread().getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#getThread()}.
   * <ul>
   *   <li>Then return COSObject UpdateState OriginDocumentState is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getThread()}
   */
  @Test
  @DisplayName("Test getThread(); then return COSObject UpdateState OriginDocumentState is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDThread PDThreadBead.getThread()"})
  void testGetThread_thenReturnCOSObjectUpdateStateOriginDocumentStateIsNull() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    pdThreadBead.setThread(new PDThread());

    // Act
    PDThread actualThread = pdThreadBead.getThread();

    // Assert
    COSDictionary cOSObject = actualThread.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualThread.getThreadInfo());
    assertNull(actualThread.getFirstBead());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDThreadBead#setThread(PDThread)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setThread(PDThread)}
   */
  @Test
  @DisplayName("Test setThread(PDThread); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDThreadBead.setThread(PDThread)"})
  void testSetThread_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();

    COSDictionary t = new COSDictionary();
    t.setKey(new COSObjectKey(1L, 1));

    // Act
    pdThreadBead.setThread(new PDThread(t));

    // Assert
    assertSame(t, pdThreadBead.getThread().getCOSObject());
    PDThreadBead nextBead = pdThreadBead.getNextBead();
    assertSame(t, nextBead.getThread().getCOSObject());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    assertSame(t, nextBead2.getThread().getCOSObject());
    assertSame(t, nextBead2.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead = pdThreadBead.getPreviousBead();
    PDThreadBead nextBead3 = previousBead.getNextBead();
    assertSame(t, nextBead3.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead3.getThread().getCOSObject());
    PDThreadBead previousBead2 = nextBead.getPreviousBead();
    assertSame(t, previousBead2.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead3 = previousBead.getPreviousBead();
    assertSame(t, previousBead3.getNextBead().getThread().getCOSObject());
    assertSame(t, previousBead.getThread().getCOSObject());
    assertSame(t, previousBead2.getThread().getCOSObject());
    assertSame(t, nextBead2.getPreviousBead().getThread().getCOSObject());
    assertSame(t, nextBead3.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead3.getThread().getCOSObject());
    assertSame(t, previousBead2.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead3.getPreviousBead().getThread().getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#setThread(PDThread)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setThread(PDThread)}
   */
  @Test
  @DisplayName("Test setThread(PDThread); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDThreadBead.setThread(PDThread)"})
  void testSetThread_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();

    COSDictionary t = new COSDictionary();
    t.setDirect(true);

    // Act
    pdThreadBead.setThread(new PDThread(t));

    // Assert
    assertSame(t, pdThreadBead.getThread().getCOSObject());
    PDThreadBead nextBead = pdThreadBead.getNextBead();
    assertSame(t, nextBead.getThread().getCOSObject());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    assertSame(t, nextBead2.getThread().getCOSObject());
    assertSame(t, nextBead2.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead = pdThreadBead.getPreviousBead();
    PDThreadBead nextBead3 = previousBead.getNextBead();
    assertSame(t, nextBead3.getNextBead().getThread().getCOSObject());
    assertSame(t, nextBead3.getThread().getCOSObject());
    PDThreadBead previousBead2 = nextBead.getPreviousBead();
    assertSame(t, previousBead2.getNextBead().getThread().getCOSObject());
    PDThreadBead previousBead3 = previousBead.getPreviousBead();
    assertSame(t, previousBead3.getNextBead().getThread().getCOSObject());
    assertSame(t, previousBead.getThread().getCOSObject());
    assertSame(t, previousBead2.getThread().getCOSObject());
    assertSame(t, nextBead2.getPreviousBead().getThread().getCOSObject());
    assertSame(t, nextBead3.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead3.getThread().getCOSObject());
    assertSame(t, previousBead2.getPreviousBead().getThread().getCOSObject());
    assertSame(t, previousBead3.getPreviousBead().getThread().getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#getNextBead()}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead(COSDictionary)} with b is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getNextBead()}
   */
  @Test
  @DisplayName("Test getNextBead(); given PDThreadBead(COSDictionary) with b is COSDictionary(); then return COSObject is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDThreadBead PDThreadBead.getNextBead()"})
  void testGetNextBead_givenPDThreadBeadWithBIsCOSDictionary_thenReturnCOSObjectIsNull() {
    // Arrange, Act and Assert
    assertNull((new PDThreadBead(new COSDictionary())).getNextBead().getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#getNextBead()}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>Then return COSObject Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getNextBead()}
   */
  @Test
  @DisplayName("Test getNextBead(); given PDThreadBead(); then return COSObject Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDThreadBead PDThreadBead.getNextBead()"})
  void testGetNextBead_givenPDThreadBead_thenReturnCOSObjectKeyIsNull() {
    // Arrange and Act
    PDThreadBead actualNextBead = (new PDThreadBead()).getNextBead();

    // Assert
    COSDictionary cOSObject = actualNextBead.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualNextBead.getPage());
    PDThreadBead previousBead = actualNextBead.getPreviousBead();
    assertNull(previousBead.getPage());
    assertNull(actualNextBead.getRectangle());
    assertNull(previousBead.getRectangle());
    assertNull(actualNextBead.getThread());
    assertNull(previousBead.getThread());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertSame(cOSObject, previousBead.getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#setNextBead(PDThreadBead)}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} COSObject Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setNextBead(PDThreadBead)}
   */
  @Test
  @DisplayName("Test setNextBead(PDThreadBead); given PDThreadBead(); then PDThreadBead() COSObject Values size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDThreadBead.setNextBead(PDThreadBead)"})
  void testSetNextBead_givenPDThreadBead_thenPDThreadBeadCOSObjectValuesSizeIsThree() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    PDThreadBead next = new PDThreadBead();

    // Act
    pdThreadBead.setNextBead(next);

    // Assert that nothing has changed
    COSDictionary cOSObject = next.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(cOSObject, next.getNextBead().getCOSObject());
    PDThreadBead previousBead = next.getPreviousBead();
    assertSame(cOSObject, previousBead.getNextBead().getCOSObject());
    PDThreadBead previousBead2 = previousBead.getPreviousBead();
    assertSame(cOSObject, previousBead2.getNextBead().getCOSObject());
    PDThreadBead previousBead3 = previousBead2.getPreviousBead();
    assertSame(cOSObject, previousBead3.getNextBead().getCOSObject());
    PDThreadBead previousBead4 = previousBead3.getPreviousBead();
    assertSame(cOSObject, previousBead4.getNextBead().getCOSObject());
    assertSame(cOSObject, previousBead4.getPreviousBead().getNextBead().getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#setNextBead(PDThreadBead)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} NextBead COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setNextBead(PDThreadBead)}
   */
  @Test
  @DisplayName("Test setNextBead(PDThreadBead); when 'null'; then PDThreadBead() NextBead COSObject is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDThreadBead.setNextBead(PDThreadBead)"})
  void testSetNextBead_whenNull_thenPDThreadBeadNextBeadCOSObjectIsNull() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();

    // Act
    pdThreadBead.setNextBead(null);

    // Assert
    assertNull(pdThreadBead.getNextBead().getCOSObject());
    PDThreadBead previousBead = pdThreadBead.getPreviousBead();
    assertNull(previousBead.getNextBead().getCOSObject());
    PDThreadBead previousBead2 = previousBead.getPreviousBead();
    assertNull(previousBead2.getNextBead().getCOSObject());
    PDThreadBead previousBead3 = previousBead2.getPreviousBead();
    assertNull(previousBead3.getNextBead().getCOSObject());
    PDThreadBead previousBead4 = previousBead3.getPreviousBead();
    assertNull(previousBead4.getNextBead().getCOSObject());
    PDThreadBead previousBead5 = previousBead4.getPreviousBead();
    assertNull(previousBead5.getNextBead().getCOSObject());
    PDThreadBead previousBead6 = previousBead5.getPreviousBead();
    assertNull(previousBead6.getNextBead().getCOSObject());
    PDThreadBead previousBead7 = previousBead6.getPreviousBead();
    assertNull(previousBead7.getPage());
    assertNull(previousBead7.getRectangle());
    assertNull(previousBead7.getThread());
    COSDictionary cOSObject = pdThreadBead.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(cOSObject, previousBead7.getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#getPreviousBead()}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>Then return COSObject Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getPreviousBead()}
   */
  @Test
  @DisplayName("Test getPreviousBead(); given PDThreadBead(); then return COSObject Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDThreadBead PDThreadBead.getPreviousBead()"})
  void testGetPreviousBead_givenPDThreadBead_thenReturnCOSObjectKeyIsNull() {
    // Arrange and Act
    PDThreadBead actualPreviousBead = (new PDThreadBead()).getPreviousBead();

    // Assert
    COSDictionary cOSObject = actualPreviousBead.getCOSObject();
    assertNull(cOSObject.getKey());
    PDThreadBead nextBead = actualPreviousBead.getNextBead();
    assertNull(nextBead.getPage());
    assertNull(actualPreviousBead.getPage());
    assertNull(nextBead.getRectangle());
    assertNull(actualPreviousBead.getRectangle());
    assertNull(nextBead.getThread());
    assertNull(actualPreviousBead.getThread());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertSame(cOSObject, nextBead.getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#getPreviousBead()}.
   * <ul>
   *   <li>Then return COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getPreviousBead()}
   */
  @Test
  @DisplayName("Test getPreviousBead(); then return COSObject is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDThreadBead PDThreadBead.getPreviousBead()"})
  void testGetPreviousBead_thenReturnCOSObjectIsNull() {
    // Arrange, Act and Assert
    assertNull((new PDThreadBead(new COSDictionary())).getPreviousBead().getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#setPreviousBead(PDThreadBead)}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} COSObject Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setPreviousBead(PDThreadBead)}
   */
  @Test
  @DisplayName("Test setPreviousBead(PDThreadBead); given PDThreadBead(); then PDThreadBead() COSObject Values size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDThreadBead.setPreviousBead(PDThreadBead)"})
  void testSetPreviousBead_givenPDThreadBead_thenPDThreadBeadCOSObjectValuesSizeIsThree() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    PDThreadBead previous = new PDThreadBead();

    // Act
    pdThreadBead.setPreviousBead(previous);

    // Assert that nothing has changed
    COSDictionary cOSObject = previous.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(cOSObject, previous.getPreviousBead().getCOSObject());
    PDThreadBead nextBead = previous.getNextBead();
    assertSame(cOSObject, nextBead.getPreviousBead().getCOSObject());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    assertSame(cOSObject, nextBead2.getPreviousBead().getCOSObject());
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    assertSame(cOSObject, nextBead3.getPreviousBead().getCOSObject());
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    assertSame(cOSObject, nextBead4.getPreviousBead().getCOSObject());
    PDThreadBead nextBead5 = nextBead4.getNextBead();
    assertSame(cOSObject, nextBead5.getPreviousBead().getCOSObject());
    assertSame(cOSObject, nextBead5.getNextBead().getPreviousBead().getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#setPreviousBead(PDThreadBead)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} PreviousBead COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setPreviousBead(PDThreadBead)}
   */
  @Test
  @DisplayName("Test setPreviousBead(PDThreadBead); when 'null'; then PDThreadBead() PreviousBead COSObject is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDThreadBead.setPreviousBead(PDThreadBead)"})
  void testSetPreviousBead_whenNull_thenPDThreadBeadPreviousBeadCOSObjectIsNull() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();

    // Act
    pdThreadBead.setPreviousBead(null);

    // Assert
    assertNull(pdThreadBead.getPreviousBead().getCOSObject());
    PDThreadBead nextBead = pdThreadBead.getNextBead();
    assertNull(nextBead.getPreviousBead().getCOSObject());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    assertNull(nextBead2.getPreviousBead().getCOSObject());
    PDThreadBead nextBead3 = nextBead2.getNextBead();
    assertNull(nextBead3.getPreviousBead().getCOSObject());
    PDThreadBead nextBead4 = nextBead3.getNextBead();
    assertNull(nextBead4.getPreviousBead().getCOSObject());
    PDThreadBead nextBead5 = nextBead4.getNextBead();
    assertNull(nextBead5.getPreviousBead().getCOSObject());
    PDThreadBead nextBead6 = nextBead5.getNextBead();
    assertNull(nextBead6.getPreviousBead().getCOSObject());
    PDThreadBead nextBead7 = nextBead6.getNextBead();
    assertNull(nextBead7.getPreviousBead().getCOSObject());
    PDThreadBead nextBead8 = nextBead7.getNextBead();
    assertNull(nextBead8.getPage());
    assertNull(nextBead8.getRectangle());
    assertNull(nextBead8.getThread());
    COSDictionary cOSObject = pdThreadBead.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(cOSObject, nextBead8.getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#appendBead(PDThreadBead)}.
   * <p>
   * Method under test: {@link PDThreadBead#appendBead(PDThreadBead)}
   */
  @Test
  @DisplayName("Test appendBead(PDThreadBead)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDThreadBead.appendBead(PDThreadBead)"})
  void testAppendBead() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    PDThreadBead append = new PDThreadBead();

    // Act
    pdThreadBead.appendBead(append);

    // Assert
    PDThreadBead nextBead = append.getNextBead();
    COSDictionary cOSObject = nextBead.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    PDThreadBead nextBead2 = nextBead.getNextBead();
    COSDictionary cOSObject2 = nextBead2.getNextBead().getCOSObject();
    assertSame(cOSObject2, cOSObject2);
    PDThreadBead previousBead = append.getPreviousBead();
    PDThreadBead nextBead3 = previousBead.getNextBead();
    assertSame(cOSObject2, nextBead3.getNextBead().getCOSObject());
    PDThreadBead previousBead2 = nextBead.getPreviousBead();
    assertSame(cOSObject2, previousBead2.getNextBead().getCOSObject());
    PDThreadBead previousBead3 = previousBead.getPreviousBead();
    assertSame(cOSObject2, previousBead3.getNextBead().getCOSObject());
    assertSame(cOSObject2, previousBead.getCOSObject());
    assertSame(cOSObject2, nextBead2.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, nextBead3.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead2.getPreviousBead().getCOSObject());
    assertSame(cOSObject2, previousBead3.getPreviousBead().getCOSObject());
  }

  /**
   * Test {@link PDThreadBead#getPage()}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()} Page is {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given PDThreadBead() Page is PDPage(); then return PDPage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPage PDThreadBead.getPage()"})
  void testGetPage_givenPDThreadBeadPageIsPDPage_thenReturnPDPage() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    PDPage page = new PDPage();
    pdThreadBead.setPage(page);

    // Act and Assert
    assertEquals(page, pdThreadBead.getPage());
  }

  /**
   * Test {@link PDThreadBead#getPage()}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getPage()}
   */
  @Test
  @DisplayName("Test getPage(); given PDThreadBead(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPage PDThreadBead.getPage()"})
  void testGetPage_givenPDThreadBead_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDThreadBead()).getPage());
  }

  /**
   * Test {@link PDThreadBead#setPage(PDPage)}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} Page is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); given PDThreadBead(); when 'null'; then PDThreadBead() Page is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDThreadBead.setPage(PDPage)"})
  void testSetPage_givenPDThreadBead_whenNull_thenPDThreadBeadPageIsNull() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();

    // Act
    pdThreadBead.setPage(null);

    // Assert that nothing has changed
    assertNull(pdThreadBead.getPage());
  }

  /**
   * Test {@link PDThreadBead#setPage(PDPage)}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>When {@link PDPage#PDPage()}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} Page is {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setPage(PDPage)}
   */
  @Test
  @DisplayName("Test setPage(PDPage); given PDThreadBead(); when PDPage(); then PDThreadBead() Page is PDPage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDThreadBead.setPage(PDPage)"})
  void testSetPage_givenPDThreadBead_whenPDPage_thenPDThreadBeadPageIsPDPage() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    PDPage page = new PDPage();

    // Act
    pdThreadBead.setPage(page);

    // Assert
    assertEquals(page, pdThreadBead.getPage());
  }

  /**
   * Test {@link PDThreadBead#getRectangle()}.
   * <ul>
   *   <li>Given {@link PDThreadBead#PDThreadBead()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); given PDThreadBead(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDThreadBead.getRectangle()"})
  void testGetRectangle_givenPDThreadBead_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDThreadBead()).getRectangle());
  }

  /**
   * Test {@link PDThreadBead#getRectangle()}.
   * <ul>
   *   <li>Then return COSArray toList third Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return COSArray toList third Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDThreadBead.getRectangle()"})
  void testGetRectangle_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    pdThreadBead.setRectangle(PDRectangle.A0);

    // Act
    PDRectangle actualRectangle = pdThreadBead.getRectangle();

    // Assert
    List<? extends COSBase> toListResult = actualRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(0.0f, actualRectangle.getLowerLeftX());
    assertEquals(0.0f, actualRectangle.getLowerLeftY());
    assertEquals(2383.937f, actualRectangle.getUpperRightX());
    assertEquals(2383.937f, actualRectangle.getWidth());
    assertEquals(3370.3938f, actualRectangle.getHeight());
    assertEquals(3370.3938f, actualRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
  }

  /**
   * Test {@link PDThreadBead#getRectangle()}.
   * <ul>
   *   <li>Then return Height is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return Height is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDThreadBead.getRectangle()"})
  void testGetRectangle_thenReturnHeightIsZero() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();
    pdThreadBead.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualRectangle = pdThreadBead.getRectangle();

    // Assert
    List<? extends COSBase> toListResult = actualRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(0.0f, actualRectangle.getHeight());
    assertEquals(0.0f, actualRectangle.getWidth());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftX());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftY());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightX());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightY());
    COSBase getResult3 = toListResult.get(0);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }

  /**
   * Test {@link PDThreadBead#setRectangle(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} Rectangle UpperRightX is {@code 2383.937}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setRectangle(PDRectangle)}
   */
  @Test
  @DisplayName("Test setRectangle(PDRectangle); when A0; then PDThreadBead() Rectangle UpperRightX is '2383.937'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDThreadBead.setRectangle(PDRectangle)"})
  void testSetRectangle_whenA0_thenPDThreadBeadRectangleUpperRightXIs2383937() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();

    // Act
    pdThreadBead.setRectangle(PDRectangle.A0);

    // Assert
    PDRectangle rectangle = pdThreadBead.getRectangle();
    assertEquals(2383.937f, rectangle.getUpperRightX());
    PDRectangle rectangle2 = pdThreadBead.getNextBead().getRectangle();
    assertEquals(2383.937f, rectangle2.getUpperRightX());
    PDRectangle rectangle3 = pdThreadBead.getPreviousBead().getRectangle();
    assertEquals(2383.937f, rectangle3.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    assertEquals(2383.937f, rectangle2.getWidth());
    assertEquals(2383.937f, rectangle3.getWidth());
    assertEquals(3370.3938f, rectangle.getHeight());
    assertEquals(3370.3938f, rectangle2.getHeight());
    assertEquals(3370.3938f, rectangle3.getHeight());
    assertEquals(3370.3938f, rectangle.getUpperRightY());
    assertEquals(3370.3938f, rectangle2.getUpperRightY());
    assertEquals(3370.3938f, rectangle3.getUpperRightY());
  }

  /**
   * Test {@link PDThreadBead#setRectangle(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#A1}.</li>
   *   <li>Then {@link PDThreadBead#PDThreadBead()} Rectangle UpperRightX is {@code 1683.7795}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDThreadBead#setRectangle(PDRectangle)}
   */
  @Test
  @DisplayName("Test setRectangle(PDRectangle); when A1; then PDThreadBead() Rectangle UpperRightX is '1683.7795'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDThreadBead.setRectangle(PDRectangle)"})
  void testSetRectangle_whenA1_thenPDThreadBeadRectangleUpperRightXIs16837795() {
    // Arrange
    PDThreadBead pdThreadBead = new PDThreadBead();

    // Act
    pdThreadBead.setRectangle(PDRectangle.A1);

    // Assert
    PDRectangle rectangle = pdThreadBead.getRectangle();
    assertEquals(1683.7795f, rectangle.getUpperRightX());
    PDRectangle rectangle2 = pdThreadBead.getNextBead().getRectangle();
    assertEquals(1683.7795f, rectangle2.getUpperRightX());
    PDRectangle rectangle3 = pdThreadBead.getPreviousBead().getRectangle();
    assertEquals(1683.7795f, rectangle3.getUpperRightX());
    assertEquals(1683.7795f, rectangle.getWidth());
    assertEquals(1683.7795f, rectangle2.getWidth());
    assertEquals(1683.7795f, rectangle3.getWidth());
    assertEquals(2383.937f, rectangle.getHeight());
    assertEquals(2383.937f, rectangle2.getHeight());
    assertEquals(2383.937f, rectangle3.getHeight());
    assertEquals(2383.937f, rectangle.getUpperRightY());
    assertEquals(2383.937f, rectangle2.getUpperRightY());
    assertEquals(2383.937f, rectangle3.getUpperRightY());
  }
}
