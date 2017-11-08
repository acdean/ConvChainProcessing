//package ConvChain;

//import java.util.Arrays;
//import java.util.function.BiPredicate;

class Pattern {
  public boolean[][] data;

  private int getSize() {
    return data.length;
  }

  private void setValue(boolean value) {
    for (int j = 0; j < getSize(); j++) {
      for (int i = 0; i < getSize(); i++) {
        data[i][j] = value;
      }
    }
  }

  //public Pattern(int size, BiPredicate<Integer, Integer> f) {
  //  data = new boolean[size][size];
  //  for (int j = 0; j < getSize(); j++) {
  //    for (int i = 0; i < getSize(); i++) {
  //      data[i][j] = f.test(i, j);
  //    }
  //  }
  //}

  public Pattern(int size, boolean value) {
    data = new boolean[size][size];
    for (int j = 0; j < size; j++) {
      for (int i = 0; i < size; i++) {
        data[i][j] = value;
      }
    }
  }

  public Pattern(boolean[][] field, int x, int y, int size) {
    //this(size, (i, j) -> false);
    // replaced with
    this(size, false);
    //Set((i, j) ->
    //  field[(x + i + field.length) % field.length]
    //  [(y + j + field[0].length) % field[0].length]);
    // replaced with:
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        int i1 = (x + i + field.length) % field.length;
        int i2 = (y + j + field[0].length) % field[0].length;
        data[i][j] = (field[i1][i2]);
      }
    }
  }

  public Pattern getRotated() {
    //return new Pattern(getSize(), (x, y) -> data[getSize() - 1 - y][x]);
    // replaced with
    Pattern rotated = new Pattern(getSize(), false);
    for (int x = 0; x < getSize(); x++) {
      for (int y = 0; y < getSize(); y++) {
        rotated.data[x][y] = data[getSize() - 1 - y][x];
      }
    }
    return rotated;
  }

  public Pattern getReflected() {
    //return new Pattern(getSize(), (x, y) -> data[getSize() - 1 - x][y]);
    // replaced with
    Pattern reflected = new Pattern(getSize(), false);
    for (int x = 0; x < getSize(); x++) {
      for (int y = 0; y < getSize(); y++) {
        reflected.data[x][y] = data[getSize() - 1 - x][y];
      }
    }
    return reflected;
  }

  public int getIndex() {
    int result = 0;
    for (boolean[] row : data) {
      for (boolean datum : row) {
        result <<= 1;
        result += datum ? 1 : 0;
      }
    }
    return result;
  }
}