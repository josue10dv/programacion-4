void main() {
  int n = 10;
  int tabla = 3;
  int i = 0;
  while (i <= n) {
    i++;
    int resultado = tabla * i;
    print("$tabla x $i = $resultado");
  }
  i = 1;
  do {
    print("El valor de i es: $i");
    i++;
  } while (i < n);
}
