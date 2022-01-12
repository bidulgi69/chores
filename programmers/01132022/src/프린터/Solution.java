package 프린터;

import java.util.*;

class Document {
    private final int identifier;
    private final int priority;
    private boolean printed;

    public Document(int identifier, int priority) {
        this.identifier = identifier;
        this.priority = priority;
        this.printed = false;
    }

    public int getPriority() {
        return this.priority;
    }

    public boolean isPrinted() {
        return this.printed;
    }

    public void printedOut() {
        this.printed = true;
    }

    @Override
    public int hashCode() {
        return identifier;
    }

    @Override
    public String toString() {
        return String.format(
                "%d/%d\n",
                identifier,
                priority
        );
    }
}

public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        //  우선순위 별 문서 개수 확인
        int[] accumulated = new int[10];
        LinkedList<Document> docs = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            docs.add(new Document(i, priorities[i]));
            accumulated[priorities[i]]++;
        }

        int docIndex = 0, topPriority = find(accumulated);
        while (true) {
            Document doc = docs.get(docIndex++);
            if (!doc.isPrinted()) {
                if (topPriority <= doc.getPriority()) {
                    if (doc.hashCode() == location) break;
                    int leftDocuments = accumulated[topPriority] - 1;
                    accumulated[topPriority] = leftDocuments;
                    doc.printedOut();
                    answer += 1;
                    if (leftDocuments == 0) //  find next max priority
                        topPriority = find(accumulated);
                }
            }
            if (docIndex == priorities.length) docIndex = 0;
        }
        return answer + 1;
    }

    private int find(int[] accumulated) {
        for (int i = accumulated.length - 1; i >= 0; i--)
            if (accumulated[i] != 0) return i;
        return -1;  //  NOT FOUND
    }
}
