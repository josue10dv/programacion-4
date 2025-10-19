void main() {
  print("Mapas");
  final Map <String, dynamic> pokemon = {
    "name": "Pikachu",
    "hp": 100,
    "isAlive": true,
    "abilities": <String> ["electrico"],
    "sprites": {
      1: "src/front.png",
      2: "src/back.png"
    }
  };
  print(pokemon);
  print(pokemon["name"]);
  print(pokemon["sprites"]);
  print(pokemon["isAlive"]);
}
