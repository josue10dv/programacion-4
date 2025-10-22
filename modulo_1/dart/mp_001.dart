void main() {
  print("Tema: Sistema de reservaciones hoteleras");
  print("=======================================");
  print("Ejemplos de variables en Dart");
  final String hotelName = "Hotel La Caldera";
  String guestName = "Michelle Torres";
  print("Bienvenido a $hotelName, $guestName.");
  // Nuevo nombre de invitado
  guestName = "Erick Toapanta";
  print("Bienvenido a $hotelName, $guestName.");

  print("=======================================");
  print("Ejemplos de mapas en Dart");
  Map<String, String> hotelServices = {
    "service1": "Servicio a la habitación",
    "service2": "Lavandería",
    "service3": "Spa",
    "service4": "Gimnasio",
  };
  print("Servicios disponibles en $hotelName:");
  print("1. ${hotelServices["service1"]}");
  print("2. ${hotelServices["service2"]}");
  print("3. ${hotelServices["service3"]}");
  print("4. ${hotelServices["service4"]}");

  print("=======================================");
  print("Ejemplos de mapas iterables en Dart");
  Map<int, String> roomTypes = {
    101: "Habitación Sencilla",
    102: "Habitación Doble",
    201: "Suite Junior",
    202: "Suite Ejecutiva",
  };
  print("Tipos de habitaciones disponibles:");
  roomTypes.forEach((key, value) {
    print("Habitación $key: $value");
  });

  print("=======================================");
  print("Ejemplos de operaciones aritméticas en Dart");
  final double roomRate = 150.0;
  final int nights = 3;
  final double extraCharges = 50.0;
  final double discount = 20.0;
  final double totalCost = (roomRate * nights) + extraCharges - discount;
  print("Tarifa por noche: \$$roomRate");
  print("Número de noches: $nights");
  print("Cargos adicionales: \$$extraCharges");
  print("Descuento aplicado: \$$discount");
  print("Total a pagar: \$$totalCost");

  print("=======================================");
  print("Ejemplos de condicionales en Dart");
  String guestType = "VIP";
  if (guestType == "VIP") {
    print(
      "Bienvenido, estimado huésped VIP. Disfrute de sus beneficios exclusivos.",
    );
  } else if (guestType == "Regular") {
    print("Bienvenido, huésped regular. Gracias por elegirnos nuevamente.");
  } else {
    print("Bienvenido, nuevo huésped. Esperamos que disfrute su estadía.");
  }

  print("=======================================");
  print("Ejemplos de ciclos en Dart");
  List<int> guestNumbersInRooms = [4, 7, 9, 1, 1, 2, 1, 5];
  int totalGuests = 0;
  for (int guests in guestNumbersInRooms) {
    totalGuests += guests;
  }
  print("(For) Número total de huéspedes en el hotel: $totalGuests");
  List<String> roomStatuses = [
    "Ocupada",
    "Limpieza",
    "Mantenimiento",
    "Ocupada",
    "Disponible",
  ];
  bool isAvailable = false;
  int index = 0;
  while (index < roomStatuses.length) {
    if (roomStatuses[index] == "Disponible") {
      isAvailable = true;
      break;
    }
    index++;
  }
  if (isAvailable) {
    print("(While) ¡Hay habitaciones disponibles!");
  } else {
    print("(While) No hay habitaciones disponibles en este momento.");
  }

  print("=======================================");
  print("Ejemplos de funciones en Dart");
  double total = calculateTotalCost(
    roomRate,
    nights,
    extraCharges: extraCharges,
    discount: discount,
  );
  print("Costo total calculado usando función: \$$total");

  print("=======================================");
  print("Ejemplos de clases en Dart");
  final Reservation reservation = Reservation(
    guestName: guestName,
    roomNumber: 202,
    nights: nights,
  );
  print(reservation);
}

/**
 * Ejemplos de funciones en Dart
 */
double calculateTotalCost(
  double roomRate,
  int nights, {
  double extraCharges = 0.0,
  double discount = 0.0,
}) {
  return (roomRate * nights) + extraCharges - discount;
}

/**
 * Ejemplos de clases en Dart
 */
class Reservation {
  String guestName;
  int roomNumber;
  int nights;

  Reservation({
    required this.guestName,
    required this.roomNumber,
    required this.nights,
  });

  @override
  String toString() {
    return "Reserva de $guestName en la habitación $roomNumber por $nights noches.";
  }
}
