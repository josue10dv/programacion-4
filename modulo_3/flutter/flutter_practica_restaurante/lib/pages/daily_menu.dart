import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class DailyMenuPage extends StatefulWidget {
  const DailyMenuPage({super.key});

  @override
  State<DailyMenuPage> createState() => _DailyMenuPageState();
}

class _DailyMenuPageState extends State<DailyMenuPage> {
  String clientType = 'Nuevo cliente';
  String prizeText = '';
  String quantityText = '';
  String resultText = '';

  void calculateTotal() {
    final double prize = double.tryParse(prizeText.replaceAll(',', '.')) ?? 0.0;
    final int quantity = int.tryParse(quantityText.replaceAll(',', '.')) ?? 0;

    if (prize <= 0 || quantity <= 0) {
      setState(() {
        resultText = 'Ingrese un precio válido';
      });
      return;
    }

    double discount = 0.0;

    if (clientType == 'Nuevo cliente') {
      discount = 0.0;
    } else if (clientType == 'Frecuente') {
      discount = 0.08;
    } else if (clientType == 'Corporativo') {
      discount = 0.12;
    }

    final double subtotal = prize * quantity;
    final double totalDiscount = subtotal * discount;
    final double total = subtotal - totalDiscount;

    setState(() {
      resultText =
          'Subtotal: \$${subtotal.toStringAsFixed(2)}\n'
          'Descuento: \$${totalDiscount.toStringAsFixed(2)}\n'
          'Total: \$${total.toStringAsFixed(2)}';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Menú diario'),
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
              'Cálculo de comisión en cajero',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            DropdownButton<String>(
              value: clientType,
              isExpanded: true,
              items: const [
                DropdownMenuItem(
                  value: 'Nuevo cliente',
                  child: Text('Cliente nuevo'),
                ),
                DropdownMenuItem(
                  value: 'Frecuente',
                  child: Text('Cliente frecuente'),
                ),
                DropdownMenuItem(
                  value: 'Corporativo',
                  child: Text('Cliente corporativo'),
                ),
              ],
              onChanged: (value) {
                if (value == null) return;
                setState(() {
                  clientType = value;
                });
              },
            ),

            const SizedBox(height: 16),

            TextField(
              decoration: const InputDecoration(
                labelText: 'Precio del plato (\$)',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (value) {
                prizeText = value;
              },
            ),

            const SizedBox(height: 16),

            TextField(
              decoration: const InputDecoration(
                labelText: 'Cantidad de platos',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (value) {
                quantityText = value;
              },
            ),

            const SizedBox(height: 16),
            ElevatedButton(
              onPressed: calculateTotal,
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
