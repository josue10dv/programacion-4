void main() {
  final Hero wolverine = Hero(name: "Logan", power: "Regeneracion");
  print(wolverine);
  print(wolverine.name);
  print(wolverine.power);
  print(wolverine.toString());
  final Calculator calc = Calculator(a: 3.45, b: 5.63);
  print("Suma: ${calc.add()}");
  print("Resta: ${calc.substract()}");
  print("Multiplicacion: ${calc.multiply()}");
  print("Division: ${calc.divide()}");
}

class Hero {
  String name;
  String power;

  Hero({required this.name, this.power = "Sin Poder"});

  @override
  String toString() {
    return "Heroe: $name, Poder: $power";
  }
}

final class Calculator {
  double a = 0;
  double b = 0;

  Calculator({required this.a, required this.b});

  double add() {
    return this.a + this.b;
  }

  double substract() {
    return this.a - this.b;
  }

  double multiply() {
    return this.a * this.b;
  }

  double divide() {
    return this.a / this.b;
  }
}
