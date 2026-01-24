package org.apache.pdfbox.examples.pdmodel;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionEmbeddedGoTo;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionGoTo;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDNamedDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PrintBookmarksDiffblueTest {
  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   *
   * <p>Method under test: {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName("Test printBookmark(PDDocument, PDOutlineNode, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintBookmarks.printBookmark(PDDocument, PDOutlineNode, String)"})
  void testPrintBookmark() throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();

    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    PDOutlineItem pdOutlineItem = mock(PDOutlineItem.class);
    when(pdOutlineItem.getTitle()).thenReturn("Dr");
    when(pdOutlineItem.getAction()).thenReturn(new PDActionEmbeddedGoTo());
    when(pdOutlineItem.getDestination()).thenReturn(new PDPageFitDestination(new COSArray()));
    when(pdOutlineItem.getNextSibling()).thenReturn(new PDOutlineItem());
    when(pdOutlineItem.getFirstChild()).thenReturn(new PDOutlineItem());

    PDOutlineNode bookmark = mock(PDOutlineNode.class);
    when(bookmark.getFirstChild()).thenReturn(pdOutlineItem);
    doNothing().when(bookmark).addLast(Mockito.<PDOutlineItem>any());
    bookmark.addLast(new PDOutlineItem());

    // Act
    printBookmarks.printBookmark(document, bookmark, "Indentation");

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(pdOutlineItem, atLeast(1)).getAction();
    verify(pdOutlineItem, atLeast(1)).getDestination();
    verify(pdOutlineItem).getNextSibling();
    verify(pdOutlineItem).getTitle();
    verify(bookmark).addLast(isA(PDOutlineItem.class));
    verify(pdOutlineItem).getFirstChild();
    verify(bookmark).getFirstChild();
  }

  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionGoTo} {@link PDActionGoTo#getDestination()} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName(
      "Test printBookmark(PDDocument, PDOutlineNode, String); given PDActionGoTo getDestination() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintBookmarks.printBookmark(PDDocument, PDOutlineNode, String)"})
  void testPrintBookmark_givenPDActionGoToGetDestinationThrowIOException() throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();

    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    PDActionGoTo pdActionGoTo = mock(PDActionGoTo.class);
    when(pdActionGoTo.getDestination()).thenThrow(new IOException());

    PDPageFitDestination pdPageFitDestination = mock(PDPageFitDestination.class);
    when(pdPageFitDestination.retrievePageNumber()).thenReturn(10);

    PDOutlineItem pdOutlineItem = mock(PDOutlineItem.class);
    when(pdOutlineItem.getAction()).thenReturn(pdActionGoTo);
    when(pdOutlineItem.getDestination()).thenReturn(pdPageFitDestination);

    PDOutlineNode bookmark = mock(PDOutlineNode.class);
    when(bookmark.getFirstChild()).thenReturn(pdOutlineItem);
    doNothing().when(bookmark).addLast(Mockito.<PDOutlineItem>any());
    bookmark.addLast(new PDOutlineItem());

    // Act and Assert
    assertThrows(
        IOException.class, () -> printBookmarks.printBookmark(document, bookmark, "Indentation"));
    verify(document).addPage(isA(PDPage.class));
    verify(pdActionGoTo).getDestination();
    verify(pdPageFitDestination).retrievePageNumber();
    verify(pdOutlineItem, atLeast(1)).getAction();
    verify(pdOutlineItem, atLeast(1)).getDestination();
    verify(bookmark).addLast(isA(PDOutlineItem.class));
    verify(bookmark).getFirstChild();
  }

  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem} {@link PDOutlineItem#getDestination()} return {@code null}.
   *   <li>Then calls {@link PDDocument#addPage(PDPage)}.
   * </ul>
   *
   * <p>Method under test: {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName(
      "Test printBookmark(PDDocument, PDOutlineNode, String); given PDOutlineItem getDestination() return 'null'; then calls addPage(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintBookmarks.printBookmark(PDDocument, PDOutlineNode, String)"})
  void testPrintBookmark_givenPDOutlineItemGetDestinationReturnNull_thenCallsAddPage()
      throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();

    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    PDOutlineItem pdOutlineItem = mock(PDOutlineItem.class);
    when(pdOutlineItem.getTitle()).thenReturn("Dr");
    when(pdOutlineItem.getAction()).thenReturn(new PDActionEmbeddedGoTo());
    when(pdOutlineItem.getDestination()).thenReturn(null);
    when(pdOutlineItem.getNextSibling()).thenReturn(new PDOutlineItem());
    when(pdOutlineItem.getFirstChild()).thenReturn(new PDOutlineItem());

    PDOutlineNode bookmark = mock(PDOutlineNode.class);
    when(bookmark.getFirstChild()).thenReturn(pdOutlineItem);
    doNothing().when(bookmark).addLast(Mockito.<PDOutlineItem>any());
    bookmark.addLast(new PDOutlineItem());

    // Act
    printBookmarks.printBookmark(document, bookmark, "Indentation");

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(pdOutlineItem, atLeast(1)).getAction();
    verify(pdOutlineItem, atLeast(1)).getDestination();
    verify(pdOutlineItem).getNextSibling();
    verify(pdOutlineItem).getTitle();
    verify(bookmark).addLast(isA(PDOutlineItem.class));
    verify(pdOutlineItem).getFirstChild();
    verify(bookmark).getFirstChild();
  }

  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem} {@link PDOutlineItem#getDestination()} return {@link
   *       PDDestination}.
   * </ul>
   *
   * <p>Method under test: {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName(
      "Test printBookmark(PDDocument, PDOutlineNode, String); given PDOutlineItem getDestination() return PDDestination")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintBookmarks.printBookmark(PDDocument, PDOutlineNode, String)"})
  void testPrintBookmark_givenPDOutlineItemGetDestinationReturnPDDestination() throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();

    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    PDPageFitDestination pdPageFitDestination = mock(PDPageFitDestination.class);
    when(pdPageFitDestination.retrievePageNumber()).thenReturn(10);

    PDActionGoTo pdActionGoTo = mock(PDActionGoTo.class);
    when(pdActionGoTo.getDestination()).thenReturn(pdPageFitDestination);

    PDPageFitDestination pdPageFitDestination2 = mock(PDPageFitDestination.class);
    when(pdPageFitDestination2.retrievePageNumber()).thenReturn(10);

    PDOutlineItem pdOutlineItem = mock(PDOutlineItem.class);
    when(pdOutlineItem.getTitle()).thenReturn("Dr");
    when(pdOutlineItem.getAction()).thenReturn(new PDActionEmbeddedGoTo());
    when(pdOutlineItem.getDestination()).thenReturn(mock(PDDestination.class));
    when(pdOutlineItem.getNextSibling()).thenReturn(new PDOutlineItem());
    when(pdOutlineItem.getFirstChild()).thenReturn(new PDOutlineItem());

    PDOutlineItem pdOutlineItem2 = mock(PDOutlineItem.class);
    when(pdOutlineItem2.getTitle()).thenReturn("Dr");
    when(pdOutlineItem2.getAction()).thenReturn(pdActionGoTo);
    when(pdOutlineItem2.getDestination()).thenReturn(pdPageFitDestination2);
    when(pdOutlineItem2.getNextSibling()).thenReturn(new PDOutlineItem());
    when(pdOutlineItem2.getFirstChild()).thenReturn(pdOutlineItem);

    PDOutlineNode bookmark = mock(PDOutlineNode.class);
    when(bookmark.getFirstChild()).thenReturn(pdOutlineItem2);
    doNothing().when(bookmark).addLast(Mockito.<PDOutlineItem>any());
    bookmark.addLast(new PDOutlineItem());

    // Act
    printBookmarks.printBookmark(document, bookmark, "Indentation");

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(pdActionGoTo, atLeast(1)).getDestination();
    verify(pdPageFitDestination).retrievePageNumber();
    verify(pdPageFitDestination2).retrievePageNumber();
    verify(pdOutlineItem2, atLeast(1)).getAction();
    verify(pdOutlineItem, atLeast(1)).getAction();
    verify(pdOutlineItem2, atLeast(1)).getDestination();
    verify(pdOutlineItem, atLeast(1)).getDestination();
    verify(pdOutlineItem2).getNextSibling();
    verify(pdOutlineItem).getNextSibling();
    verify(pdOutlineItem2).getTitle();
    verify(pdOutlineItem).getTitle();
    verify(bookmark).addLast(isA(PDOutlineItem.class));
    verify(pdOutlineItem2).getFirstChild();
    verify(pdOutlineItem).getFirstChild();
    verify(bookmark).getFirstChild();
  }

  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem} {@link PDOutlineItem#getDestination()} return {@link
   *       PDPageFitDestination#PDPageFitDestination()}.
   * </ul>
   *
   * <p>Method under test: {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName(
      "Test printBookmark(PDDocument, PDOutlineNode, String); given PDOutlineItem getDestination() return PDPageFitDestination()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintBookmarks.printBookmark(PDDocument, PDOutlineNode, String)"})
  void testPrintBookmark_givenPDOutlineItemGetDestinationReturnPDPageFitDestination()
      throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();

    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    PDOutlineItem pdOutlineItem = mock(PDOutlineItem.class);
    when(pdOutlineItem.getTitle()).thenReturn("Dr");
    when(pdOutlineItem.getAction()).thenReturn(new PDActionEmbeddedGoTo());
    when(pdOutlineItem.getDestination()).thenReturn(new PDPageFitDestination());
    when(pdOutlineItem.getNextSibling()).thenReturn(new PDOutlineItem());
    when(pdOutlineItem.getFirstChild()).thenReturn(new PDOutlineItem());

    PDOutlineNode bookmark = mock(PDOutlineNode.class);
    when(bookmark.getFirstChild()).thenReturn(pdOutlineItem);
    doNothing().when(bookmark).addLast(Mockito.<PDOutlineItem>any());
    bookmark.addLast(new PDOutlineItem());

    // Act
    printBookmarks.printBookmark(document, bookmark, "Indentation");

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(pdOutlineItem, atLeast(1)).getAction();
    verify(pdOutlineItem, atLeast(1)).getDestination();
    verify(pdOutlineItem).getNextSibling();
    verify(pdOutlineItem).getTitle();
    verify(bookmark).addLast(isA(PDOutlineItem.class));
    verify(pdOutlineItem).getFirstChild();
    verify(bookmark).getFirstChild();
  }

  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem} {@link PDOutlineItem#getDestination()} return {@link
   *       PDPageFitDestination#PDPageFitDestination()}.
   * </ul>
   *
   * <p>Method under test: {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName(
      "Test printBookmark(PDDocument, PDOutlineNode, String); given PDOutlineItem getDestination() return PDPageFitDestination()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintBookmarks.printBookmark(PDDocument, PDOutlineNode, String)"})
  void testPrintBookmark_givenPDOutlineItemGetDestinationReturnPDPageFitDestination2()
      throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();

    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    PDPageFitDestination pdPageFitDestination = mock(PDPageFitDestination.class);
    when(pdPageFitDestination.retrievePageNumber()).thenReturn(10);

    PDActionGoTo pdActionGoTo = mock(PDActionGoTo.class);
    when(pdActionGoTo.getDestination()).thenReturn(pdPageFitDestination);

    PDPageFitDestination pdPageFitDestination2 = mock(PDPageFitDestination.class);
    when(pdPageFitDestination2.retrievePageNumber()).thenReturn(10);

    PDOutlineItem pdOutlineItem = mock(PDOutlineItem.class);
    when(pdOutlineItem.getTitle()).thenReturn("Dr");
    when(pdOutlineItem.getAction()).thenReturn(new PDActionEmbeddedGoTo());
    when(pdOutlineItem.getDestination()).thenReturn(new PDPageFitDestination());
    when(pdOutlineItem.getNextSibling()).thenReturn(new PDOutlineItem());
    when(pdOutlineItem.getFirstChild()).thenReturn(new PDOutlineItem());

    PDOutlineItem pdOutlineItem2 = mock(PDOutlineItem.class);
    when(pdOutlineItem2.getTitle()).thenReturn("Dr");
    when(pdOutlineItem2.getAction()).thenReturn(pdActionGoTo);
    when(pdOutlineItem2.getDestination()).thenReturn(pdPageFitDestination2);
    when(pdOutlineItem2.getNextSibling()).thenReturn(new PDOutlineItem());
    when(pdOutlineItem2.getFirstChild()).thenReturn(pdOutlineItem);

    PDOutlineNode bookmark = mock(PDOutlineNode.class);
    when(bookmark.getFirstChild()).thenReturn(pdOutlineItem2);
    doNothing().when(bookmark).addLast(Mockito.<PDOutlineItem>any());
    bookmark.addLast(new PDOutlineItem());

    // Act
    printBookmarks.printBookmark(document, bookmark, "Indentation");

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(pdActionGoTo, atLeast(1)).getDestination();
    verify(pdPageFitDestination).retrievePageNumber();
    verify(pdPageFitDestination2).retrievePageNumber();
    verify(pdOutlineItem2, atLeast(1)).getAction();
    verify(pdOutlineItem, atLeast(1)).getAction();
    verify(pdOutlineItem2, atLeast(1)).getDestination();
    verify(pdOutlineItem, atLeast(1)).getDestination();
    verify(pdOutlineItem2).getNextSibling();
    verify(pdOutlineItem).getNextSibling();
    verify(pdOutlineItem2).getTitle();
    verify(pdOutlineItem).getTitle();
    verify(bookmark).addLast(isA(PDOutlineItem.class));
    verify(pdOutlineItem2).getFirstChild();
    verify(pdOutlineItem).getFirstChild();
    verify(bookmark).getFirstChild();
  }

  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem} {@link PDOutlineItem#getDestination()} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName(
      "Test printBookmark(PDDocument, PDOutlineNode, String); given PDOutlineItem getDestination() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintBookmarks.printBookmark(PDDocument, PDOutlineNode, String)"})
  void testPrintBookmark_givenPDOutlineItemGetDestinationThrowIOException() throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();
    PDDocument document = new PDDocument();

    PDOutlineItem pdOutlineItem = mock(PDOutlineItem.class);
    when(pdOutlineItem.getDestination()).thenThrow(new IOException());

    PDOutlineNode bookmark = mock(PDOutlineNode.class);
    when(bookmark.getFirstChild()).thenReturn(pdOutlineItem);
    doNothing().when(bookmark).addLast(Mockito.<PDOutlineItem>any());
    bookmark.addLast(new PDOutlineItem());

    // Act and Assert
    assertThrows(
        IOException.class, () -> printBookmarks.printBookmark(document, bookmark, "Indentation"));
    verify(pdOutlineItem).getDestination();
    verify(bookmark).addLast(isA(PDOutlineItem.class));
    verify(bookmark).getFirstChild();
  }

  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()} Page is {@link
   *       PDPage#PDPage()}.
   *   <li>Then calls {@link PDActionGoTo#getDestination()}.
   * </ul>
   *
   * <p>Method under test: {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName(
      "Test printBookmark(PDDocument, PDOutlineNode, String); given PDPageFitDestination() Page is PDPage(); then calls getDestination()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintBookmarks.printBookmark(PDDocument, PDOutlineNode, String)"})
  void testPrintBookmark_givenPDPageFitDestinationPageIsPDPage_thenCallsGetDestination()
      throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();

    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    PDPageFitDestination pdPageFitDestination = mock(PDPageFitDestination.class);
    when(pdPageFitDestination.retrievePageNumber()).thenReturn(10);

    PDActionGoTo pdActionGoTo = mock(PDActionGoTo.class);
    when(pdActionGoTo.getDestination()).thenReturn(pdPageFitDestination);

    PDPageFitDestination pdPageFitDestination2 = mock(PDPageFitDestination.class);
    when(pdPageFitDestination2.retrievePageNumber()).thenReturn(10);

    PDPageFitDestination pdPageFitDestination3 = new PDPageFitDestination();
    pdPageFitDestination3.setPage(new PDPage());

    PDOutlineItem pdOutlineItem = mock(PDOutlineItem.class);
    when(pdOutlineItem.getTitle()).thenReturn("Dr");
    when(pdOutlineItem.getAction()).thenReturn(new PDActionEmbeddedGoTo());
    when(pdOutlineItem.getDestination()).thenReturn(pdPageFitDestination3);
    when(pdOutlineItem.getNextSibling()).thenReturn(new PDOutlineItem());
    when(pdOutlineItem.getFirstChild()).thenReturn(new PDOutlineItem());

    PDOutlineItem pdOutlineItem2 = mock(PDOutlineItem.class);
    when(pdOutlineItem2.getTitle()).thenReturn("Dr");
    when(pdOutlineItem2.getAction()).thenReturn(pdActionGoTo);
    when(pdOutlineItem2.getDestination()).thenReturn(pdPageFitDestination2);
    when(pdOutlineItem2.getNextSibling()).thenReturn(new PDOutlineItem());
    when(pdOutlineItem2.getFirstChild()).thenReturn(pdOutlineItem);

    PDOutlineNode bookmark = mock(PDOutlineNode.class);
    when(bookmark.getFirstChild()).thenReturn(pdOutlineItem2);
    doNothing().when(bookmark).addLast(Mockito.<PDOutlineItem>any());
    bookmark.addLast(new PDOutlineItem());

    // Act
    printBookmarks.printBookmark(document, bookmark, "Indentation");

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(pdActionGoTo, atLeast(1)).getDestination();
    verify(pdPageFitDestination).retrievePageNumber();
    verify(pdPageFitDestination2).retrievePageNumber();
    verify(pdOutlineItem2, atLeast(1)).getAction();
    verify(pdOutlineItem, atLeast(1)).getAction();
    verify(pdOutlineItem2, atLeast(1)).getDestination();
    verify(pdOutlineItem, atLeast(1)).getDestination();
    verify(pdOutlineItem2).getNextSibling();
    verify(pdOutlineItem).getNextSibling();
    verify(pdOutlineItem2).getTitle();
    verify(pdOutlineItem).getTitle();
    verify(bookmark).addLast(isA(PDOutlineItem.class));
    verify(pdOutlineItem2).getFirstChild();
    verify(pdOutlineItem).getFirstChild();
    verify(bookmark).getFirstChild();
  }

  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   *
   * <ul>
   *   <li>Given {@link PDPageFitDestination#PDPageFitDestination()} PageNumber is ten.
   * </ul>
   *
   * <p>Method under test: {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName(
      "Test printBookmark(PDDocument, PDOutlineNode, String); given PDPageFitDestination() PageNumber is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintBookmarks.printBookmark(PDDocument, PDOutlineNode, String)"})
  void testPrintBookmark_givenPDPageFitDestinationPageNumberIsTen() throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();

    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    PDPageFitDestination pdPageFitDestination = mock(PDPageFitDestination.class);
    when(pdPageFitDestination.retrievePageNumber()).thenReturn(10);

    PDActionGoTo pdActionGoTo = mock(PDActionGoTo.class);
    when(pdActionGoTo.getDestination()).thenReturn(pdPageFitDestination);

    PDPageFitDestination pdPageFitDestination2 = mock(PDPageFitDestination.class);
    when(pdPageFitDestination2.retrievePageNumber()).thenReturn(10);

    PDPageFitDestination pdPageFitDestination3 = new PDPageFitDestination();
    pdPageFitDestination3.setPageNumber(10);

    PDOutlineItem pdOutlineItem = mock(PDOutlineItem.class);
    when(pdOutlineItem.getTitle()).thenReturn("Dr");
    when(pdOutlineItem.getAction()).thenReturn(new PDActionEmbeddedGoTo());
    when(pdOutlineItem.getDestination()).thenReturn(pdPageFitDestination3);
    when(pdOutlineItem.getNextSibling()).thenReturn(new PDOutlineItem());
    when(pdOutlineItem.getFirstChild()).thenReturn(new PDOutlineItem());

    PDOutlineItem pdOutlineItem2 = mock(PDOutlineItem.class);
    when(pdOutlineItem2.getTitle()).thenReturn("Dr");
    when(pdOutlineItem2.getAction()).thenReturn(pdActionGoTo);
    when(pdOutlineItem2.getDestination()).thenReturn(pdPageFitDestination2);
    when(pdOutlineItem2.getNextSibling()).thenReturn(new PDOutlineItem());
    when(pdOutlineItem2.getFirstChild()).thenReturn(pdOutlineItem);

    PDOutlineNode bookmark = mock(PDOutlineNode.class);
    when(bookmark.getFirstChild()).thenReturn(pdOutlineItem2);
    doNothing().when(bookmark).addLast(Mockito.<PDOutlineItem>any());
    bookmark.addLast(new PDOutlineItem());

    // Act
    printBookmarks.printBookmark(document, bookmark, "Indentation");

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(pdActionGoTo, atLeast(1)).getDestination();
    verify(pdPageFitDestination).retrievePageNumber();
    verify(pdPageFitDestination2).retrievePageNumber();
    verify(pdOutlineItem2, atLeast(1)).getAction();
    verify(pdOutlineItem, atLeast(1)).getAction();
    verify(pdOutlineItem2, atLeast(1)).getDestination();
    verify(pdOutlineItem, atLeast(1)).getDestination();
    verify(pdOutlineItem2).getNextSibling();
    verify(pdOutlineItem).getNextSibling();
    verify(pdOutlineItem2).getTitle();
    verify(pdOutlineItem).getTitle();
    verify(bookmark).addLast(isA(PDOutlineItem.class));
    verify(pdOutlineItem2).getFirstChild();
    verify(pdOutlineItem).getFirstChild();
    verify(bookmark).getFirstChild();
  }

  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   *
   * <ul>
   *   <li>Then calls {@link PDPageFitDestination#retrievePageNumber()}.
   * </ul>
   *
   * <p>Method under test: {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName(
      "Test printBookmark(PDDocument, PDOutlineNode, String); then calls retrievePageNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintBookmarks.printBookmark(PDDocument, PDOutlineNode, String)"})
  void testPrintBookmark_thenCallsRetrievePageNumber() throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();

    PDDocument document = mock(PDDocument.class);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    PDPageFitDestination pdPageFitDestination = mock(PDPageFitDestination.class);
    when(pdPageFitDestination.retrievePageNumber()).thenReturn(10);

    PDOutlineItem pdOutlineItem = mock(PDOutlineItem.class);
    when(pdOutlineItem.getTitle()).thenReturn("Dr");
    when(pdOutlineItem.getAction()).thenReturn(new PDActionEmbeddedGoTo());
    when(pdOutlineItem.getDestination()).thenReturn(pdPageFitDestination);
    when(pdOutlineItem.getNextSibling()).thenReturn(new PDOutlineItem());
    when(pdOutlineItem.getFirstChild()).thenReturn(new PDOutlineItem());

    PDOutlineNode bookmark = mock(PDOutlineNode.class);
    when(bookmark.getFirstChild()).thenReturn(pdOutlineItem);
    doNothing().when(bookmark).addLast(Mockito.<PDOutlineItem>any());
    bookmark.addLast(new PDOutlineItem());

    // Act
    printBookmarks.printBookmark(document, bookmark, "Indentation");

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(pdPageFitDestination).retrievePageNumber();
    verify(pdOutlineItem, atLeast(1)).getAction();
    verify(pdOutlineItem, atLeast(1)).getDestination();
    verify(pdOutlineItem).getNextSibling();
    verify(pdOutlineItem).getTitle();
    verify(bookmark).addLast(isA(PDOutlineItem.class));
    verify(pdOutlineItem).getFirstChild();
    verify(bookmark).getFirstChild();
  }

  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then calls {@link PDOutlineItem#getNextSibling()}.
   * </ul>
   *
   * <p>Method under test: {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName(
      "Test printBookmark(PDDocument, PDOutlineNode, String); when PDDocument() addPage PDPage(); then calls getNextSibling()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintBookmarks.printBookmark(PDDocument, PDOutlineNode, String)"})
  void testPrintBookmark_whenPDDocumentAddPagePDPage_thenCallsGetNextSibling() throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    PDOutlineItem pdOutlineItem = mock(PDOutlineItem.class);
    when(pdOutlineItem.getTitle()).thenReturn("Dr");
    when(pdOutlineItem.getAction()).thenReturn(new PDActionEmbeddedGoTo());
    when(pdOutlineItem.getDestination()).thenReturn(new PDNamedDestination());
    when(pdOutlineItem.getNextSibling()).thenReturn(new PDOutlineItem());
    when(pdOutlineItem.getFirstChild()).thenReturn(new PDOutlineItem());

    PDOutlineNode bookmark = mock(PDOutlineNode.class);
    when(bookmark.getFirstChild()).thenReturn(pdOutlineItem);
    doNothing().when(bookmark).addLast(Mockito.<PDOutlineItem>any());
    bookmark.addLast(new PDOutlineItem());

    // Act
    printBookmarks.printBookmark(document, bookmark, "Indentation");

    // Assert
    verify(pdOutlineItem, atLeast(1)).getAction();
    verify(pdOutlineItem, atLeast(1)).getDestination();
    verify(pdOutlineItem).getNextSibling();
    verify(pdOutlineItem).getTitle();
    verify(bookmark).addLast(isA(PDOutlineItem.class));
    verify(pdOutlineItem).getFirstChild();
    verify(bookmark).getFirstChild();
  }

  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   *
   * <ul>
   *   <li>When {@link PDDocumentOutline#PDDocumentOutline()} addLast {@link
   *       PDOutlineItem#PDOutlineItem()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName(
      "Test printBookmark(PDDocument, PDOutlineNode, String); when PDDocumentOutline() addLast PDOutlineItem(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintBookmarks.printBookmark(PDDocument, PDOutlineNode, String)"})
  void testPrintBookmark_whenPDDocumentOutlineAddLastPDOutlineItem_thenDoesNotThrow()
      throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();
    PDDocument document = new PDDocument();

    PDDocumentOutline bookmark = new PDDocumentOutline();
    bookmark.addLast(new PDOutlineItem());

    // Act and Assert
    assertDoesNotThrow(() -> printBookmarks.printBookmark(document, bookmark, "Indentation"));
  }

  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   *
   * <ul>
   *   <li>When {@link PDDocumentOutline#PDDocumentOutline()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName(
      "Test printBookmark(PDDocument, PDOutlineNode, String); when PDDocumentOutline(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintBookmarks.printBookmark(PDDocument, PDOutlineNode, String)"})
  void testPrintBookmark_whenPDDocumentOutline_thenDoesNotThrow() throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();
    PDDocument document = new PDDocument();

    // Act and Assert
    assertDoesNotThrow(
        () -> printBookmarks.printBookmark(document, new PDDocumentOutline(), "Indentation"));
  }

  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then calls {@link PDOutlineItem#getNextSibling()}.
   * </ul>
   *
   * <p>Method under test: {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName(
      "Test printBookmark(PDDocument, PDOutlineNode, String); when PDDocument(); then calls getNextSibling()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintBookmarks.printBookmark(PDDocument, PDOutlineNode, String)"})
  void testPrintBookmark_whenPDDocument_thenCallsGetNextSibling() throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();
    PDDocument document = new PDDocument();

    PDOutlineItem pdOutlineItem = mock(PDOutlineItem.class);
    when(pdOutlineItem.getTitle()).thenReturn("Dr");
    when(pdOutlineItem.getAction()).thenReturn(new PDActionEmbeddedGoTo());
    when(pdOutlineItem.getDestination()).thenReturn(new PDNamedDestination());
    when(pdOutlineItem.getNextSibling()).thenReturn(new PDOutlineItem());
    when(pdOutlineItem.getFirstChild()).thenReturn(new PDOutlineItem());

    PDOutlineNode bookmark = mock(PDOutlineNode.class);
    when(bookmark.getFirstChild()).thenReturn(pdOutlineItem);
    doNothing().when(bookmark).addLast(Mockito.<PDOutlineItem>any());
    bookmark.addLast(new PDOutlineItem());

    // Act
    printBookmarks.printBookmark(document, bookmark, "Indentation");

    // Assert
    verify(pdOutlineItem, atLeast(1)).getAction();
    verify(pdOutlineItem, atLeast(1)).getDestination();
    verify(pdOutlineItem).getNextSibling();
    verify(pdOutlineItem).getTitle();
    verify(bookmark).addLast(isA(PDOutlineItem.class));
    verify(pdOutlineItem).getFirstChild();
    verify(bookmark).getFirstChild();
  }

  /**
   * Test {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}.
   *
   * <ul>
   *   <li>When {@link PDOutlineNode} {@link PDOutlineNode#getFirstChild()} return {@link
   *       PDOutlineItem#PDOutlineItem()}.
   * </ul>
   *
   * <p>Method under test: {@link PrintBookmarks#printBookmark(PDDocument, PDOutlineNode, String)}
   */
  @Test
  @DisplayName(
      "Test printBookmark(PDDocument, PDOutlineNode, String); when PDOutlineNode getFirstChild() return PDOutlineItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintBookmarks.printBookmark(PDDocument, PDOutlineNode, String)"})
  void testPrintBookmark_whenPDOutlineNodeGetFirstChildReturnPDOutlineItem() throws IOException {
    // Arrange
    PrintBookmarks printBookmarks = new PrintBookmarks();
    PDDocument document = new PDDocument();

    PDOutlineNode bookmark = mock(PDOutlineNode.class);
    when(bookmark.getFirstChild()).thenReturn(new PDOutlineItem());
    doNothing().when(bookmark).addLast(Mockito.<PDOutlineItem>any());
    bookmark.addLast(new PDOutlineItem());

    // Act
    printBookmarks.printBookmark(document, bookmark, "Indentation");

    // Assert
    verify(bookmark).addLast(isA(PDOutlineItem.class));
    verify(bookmark).getFirstChild();
  }
}
