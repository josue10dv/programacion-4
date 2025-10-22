void main() {
  print("Tipos de variables en Dart");
  final String pokemon = "Ditto";
  print(pokemon);
  String myName = "Erick";
  myName = "Josue";
  print(myName);
  const String element = "Fuego";
  print("Elemento: $element");
  bool active = false;
  active = true;
  print("Es activo: $active");
  int hp = 1000;
  print("Caballos de fuerza $hp");
  List<String> abilities = ["impostor", "correlon"];
  print("Habilidades $abilities");
  final sprites = <String> ["image_1.jpg","image_2.jpg"];
  print("Imagenes $sprites");
  print("Impresion en varias lineas");
  print("""
    $pokemon
    $hp
    $sprites
    $abilities
  """);
}
