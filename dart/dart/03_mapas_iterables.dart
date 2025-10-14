void main() {
  print("Mapas iterables");
  final numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
  print("Lista original: $numbers");
  print("Longitud de la lista: ${numbers.length}");
  print("Indice 4 de la lista: ${numbers[4]}");
  print("Primer elemento de la lista: ${numbers.first}");
  final revertedList = numbers.reversed;
  print("Reverso de la lista: $revertedList");
  print("List: ${numbers.toList()}");
  print("Set: ${numbers.toSet()}");
}
