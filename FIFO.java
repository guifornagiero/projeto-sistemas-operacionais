import java.util.Arrays;

public class FIFO {
    private int[] pagesList;
    private final int pagesNum;
    private int pageFaults;
    private int hits;
    private int[] currentQueue;
    private int lastPositionIndex;

    public FIFO(int pagesNum, String pagesList) {
        this.pagesNum = pagesNum;
        this.pagesList = createPagesList(pagesList);
        this.pageFaults = 0;
        this.hits = 0;
        this.currentQueue = createCurrentQueue();
        this.lastPositionIndex = 0;
    }

    public void execute() {
        for (int page : pagesList) {
            if (!contains(currentQueue, page)) {
                pageFaults++;
                currentQueue[lastPositionIndex] = page;

                System.out.println("Page: " + page + "\n");
                for (int j = 0; j < currentQueue.length; j++) {
                    if (j == lastPositionIndex)
                        System.out.printf("[%d] <- (miss)\n", currentQueue[j]);
                    else
                        System.out.printf("[%d]\n", currentQueue[j]);
                }
                lastPositionIndex = (lastPositionIndex + 1) % pagesNum;
                System.out.println("\n");
            } else {
                hits++;

                System.out.println("Page: " + page + "\n");
                for (int j = 0; j < currentQueue.length; j++) {
                    if (currentQueue[j] == page) 
                        System.out.printf("[%d] <- (hit)\n", currentQueue[j]);
                    else
                        System.out.printf("[%d]\n", currentQueue[j]);
                }
                System.out.println("\n");
            }
        }

        System.out.printf("Hit Rate: %d/%d\n", hits, pagesList.length);
        System.out.printf("Miss Rate: %d/%d\n", pageFaults, pagesList.length);
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
