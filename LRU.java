import java.util.Arrays;

public class LRU {
    private int[] pagesList;
    private final int pagesNum;
    private int pageFaults;
    private int hits;
    private int[] currentQueue;
    private int lastPositionIndex;

    public LRU(int pagesNum, String pagesList) {
        this.pagesNum = pagesNum;
        this.pagesList = createPagesList(pagesList);
        this.pageFaults = 0;
        this.hits = 0;
        this.currentQueue = createCurrentQueue();
        this.lastPositionIndex = 0;
    }

    public void execute() {
        for (int i = 0; i < pagesList.length; i++) {
            int page = pagesList[i];

            if (!contains(currentQueue, page)) {
                int itemToBeRemoved = 0;
                int itemToBeRemovedStepsQtd = 0;

                for (int j = 0; j < currentQueue.length; j++) {
                    int previousOccurrence = getPreviousOccurrence(i, currentQueue[j]);

                    if (previousOccurrence > itemToBeRemovedStepsQtd) {
                        itemToBeRemovedStepsQtd = previousOccurrence;
                        itemToBeRemoved = j;
                    }
                }

                pageFaults++;
                currentQueue[itemToBeRemoved] = page;

                System.out.println("Page: " + page + "\n");
                for (int j = 0; j < currentQueue.length; j++) {
                    if (j == itemToBeRemoved)
                        System.out.printf("[%d] <- (miss)\n", currentQueue[j]);
                    else
                        System.out.printf("[%d]\n", currentQueue[j]);
                }
                lastPositionIndex = (lastPositionIndex + 1) % pagesNum;
                System.out.println();
            } else {
                hits++;

                System.out.println("Page: " + page + "\n");
                for (int j = 0; j < currentQueue.length; j++) {
                    if (currentQueue[j] == page)
                        System.out.printf("[%d] <- (hit)\n", currentQueue[j]);
                    else
                        System.out.printf("[%d]\n", currentQueue[j]);
                }
                lastPositionIndex = (lastPositionIndex + 1) % pagesNum;
                System.out.println();
            }
        }

        System.out.printf("Hit Rate: %d/%d\n", hits, pagesList.length);
        System.out.printf("Miss Rate: %d/%d\n", pageFaults, pagesList.length);
    }

    private int getPreviousOccurrence(int positionPageList, int currentQueueItem) {
        int previous = 0;
        for (int i = positionPageList; i >= 0; i--) {
            if (pagesList[i] == currentQueueItem) {
                previous = positionPageList - i;
                break;
            }
        }
        return (previous == 0) ? Integer.MAX_VALUE : previous;
    }

    private int[] createPagesList(String pagesString) {
        String[] pages = pagesString.split(",");
        int[] pagesList = new int[pages.length];

        for (int i = 0; i < pages.length; i++) {
            pagesList[i] = Integer.parseInt(pages[i].trim());
        }

        return pagesList;
    }

    private int[] createCurrentQueue() {
        int[] currentQueue = new int[pagesNum];
        Arrays.fill(currentQueue, -1);
        return currentQueue;
    }

    private boolean contains(int[] nums, int value) {
        for (int num : nums) {
            if (num == value)
                return true;
        }
        return false;
    }
}
