import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class RevealCards {
  public static int[] deckRevealedIncreasing(int[] deck) {
    Arrays.sort(deck);
    
    Queue<Integer> indices = new LinkedList<>();
    for (int i = 0; i < deck.length; i++) {
      indices.add(i);
    }
    
    int[] result = new int[deck.length];
    
    for (int card : deck) {
      result[indices.poll()] = card;
      if (!indices.isEmpty()) {
        indices.add(indices.poll());
      }
    }
    
    return result;
  }
}