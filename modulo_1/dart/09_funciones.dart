void main() {
  print(greetEveryone());
  print(sum(3, 5));
  print(sumTwoNumbers(4));
  print(sumTwoNumbers(4, 6));
  print(greetPerson(name: "Ramona"));
  print(greetPerson(name: "Michelle", message: "Holi uwu"));
}

String greetEveryone() => "Hello World";
int sum(int a, int b) => a + b;

int sumTwoNumbers(int a, [int b = 0]) {
  return a + b;
}

String greetPerson({required String name, String message = "Hola"}) {
  return "$message, $name!";
}


