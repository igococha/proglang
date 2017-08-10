class Table {
  String id; int value; Table tail;
  Table (String i, int v, Table t) { id = i; value = v; tail = t; }
}

class IntAndTable {
  int i; Table t;
  IntAndTable (int ii, Table tt) { i = ii; t = tt; }
}

