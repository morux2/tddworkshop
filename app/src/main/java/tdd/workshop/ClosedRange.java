package tdd.workshop;

public class ClosedRange {
  int head;
  int tail;

  public ClosedRange(int head, int tail) {
    this.head = head;
    this.tail = tail;
    if (head > tail) {
      throw new HeadBiggerThanTailException();
    }
  }

  public String toString() {
    return String.format("[%d,%d]", head, tail);
  }

  public boolean containsInteger(int i) {
    return i >= head && i <= tail;
  }

  public boolean containsClosedRange(ClosedRange cr) {
    if (cr instanceof ClosedRange) {
      return this.head <= cr.head && this.tail >= cr.tail;
    } else {
      return false;
    }
  }

  @Override
  public boolean equals(Object o) {
    // null instance of object -> false
    if (o instanceof ClosedRange) {
      ClosedRange cr = (ClosedRange) o;
      return this.head == cr.head && this.tail == cr.tail;
    } else {
      return false;
    }
  }
}

class HeadBiggerThanTailException extends RuntimeException {}
