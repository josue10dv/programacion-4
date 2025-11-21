import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class HospitalizationCostPage extends StatefulWidget {
  const HospitalizationCostPage({super.key});

  @override
  State<HospitalizationCostPage> createState() =>
      _HospitalizationCostPageState();
}

class _HospitalizationCostPageState extends State<HospitalizationCostPage> {
  String roomType = 'General';
  String insuranceType = 'Público';
  String hospitalDaysText = '';
  String dailyCostText = '';
  String resultText = '';

  void calculateCost() {
    final dailyCost =
        double.tryParse(dailyCostText.replaceAll(',', '.')) ?? 0.0;
    final hospitalDays =
        double.tryParse(hospitalDaysText.replaceAll(',', '.')) ?? 0.0;
    if (dailyCost <= 0 || hospitalDays <= 0) {
      setState(() {
        resultText =
            'Ingrese un costo diario y días de hospitalización válidos';
      });
      return;
    }

    double multiplicator = 1.0;

    if (roomType == 'General') {
      multiplicator = 1.0;
    } else if (roomType == 'Semi-privada') {
      multiplicator = 1.4;
    } else if (roomType == 'Privada') {
      multiplicator = 2.0;
    }

    double discount = 0.0;

    if (insuranceType == 'Público') {
      discount = 30.0;
    } else if (insuranceType == 'Privado') {
      discount = 50.0;
    } else if (insuranceType == 'Sin seguro') {
      discount = 0.0;
    }

    final initialCost = dailyCost * hospitalDays * multiplicator;
    final discountAmount = initialCost * discount / 100;
    final finalCost = initialCost - discountAmount;

    setState(() {
      resultText =
          'Multiplicador de costo para $roomType: $multiplicator \n'
          'Costo inicial: \$${initialCost.toStringAsFixed(2)}\n'
          'Descuento: ${discount.toStringAsFixed(0)} %\n'
          'Costo final: \$${finalCost.toStringAsFixed(2)}';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Costo de hospitalización'),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => context.go('/'),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            const Text(
              'Costo de hospitalización según días de estancia, tipo de habitación y seguro',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            DropdownButton<String>(
              value: roomType,
              isExpanded: true,
              items: const [
                DropdownMenuItem(
                  value: 'General',
                  child: Text('Habitación General'),
                ),
                DropdownMenuItem(
                  value: 'Semi-privada',
                  child: Text('Habitación Semi-privada'),
                ),
                DropdownMenuItem(
                  value: 'Privada',
                  child: Text('Habitación Privada'),
                ),
              ],
              onChanged: (value) {
                if (value == null) return;
                setState(() {
                  roomType = value;
                });
              },
            ),

            const SizedBox(height: 16),

            DropdownButton<String>(
              value: insuranceType,
              isExpanded: true,
              items: const [
                DropdownMenuItem(
                  value: 'Público',
                  child: Text('Seguro Público'),
                ),
                DropdownMenuItem(
                  value: 'Privado',
                  child: Text('Seguro Privado'),
                ),
                DropdownMenuItem(
                  value: 'Sin seguro',
                  child: Text('Sin Seguro'),
                ),
              ],
              onChanged: (value) {
                if (value == null) return;
                setState(() {
                  insuranceType = value;
                });
              },
            ),

            const SizedBox(height: 16),
            TextField(
              decoration: const InputDecoration(
                labelText: 'Costo base de la hospitalización (\$)',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (value) {
                dailyCostText = value;
              },
            ),

            const SizedBox(height: 16),
            TextField(
              decoration: const InputDecoration(
                labelText: 'Días de hospitalización (\$)',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (value) {
                hospitalDaysText = value;
              },
            ),

            const SizedBox(height: 16),
            ElevatedButton(
              onPressed: calculateCost,
              child: const Text('Calcular'),
            ),

            const SizedBox(height: 16),
            Text(resultText),
          ],
        ),
      ),
    );
  }
}
