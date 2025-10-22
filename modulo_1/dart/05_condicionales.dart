void main() {
  int a = 5;
  if (a > 2) {
    print("a > 2 es true");
  }
  if (a < 2) {
    print("a < 2 es true");
  }
  if (a == 2) {
    print("a == 2 es true");
  }

  if (a > 2) {
    print("a > 2 es true");
  } else {
    print("a <= 2 es true");
  }

  if (a == 2) {
    print("a == 2 es true");
  } else {
    print("a != 2 es true");
  }

  int b = 2;
  if (b > 2) {
    print("b > 2 es true");
  } else if (b == 2) {
    print("b == 2 es true");
  } else {
    print("b < 2 es true");
  }

  int age = 18;
  String ageDescription = (age >= 18) ? "adult" : "child";
  print(ageDescription);
}
