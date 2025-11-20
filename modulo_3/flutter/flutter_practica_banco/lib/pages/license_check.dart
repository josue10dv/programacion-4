import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class DriverLicensePage extends StatefulWidget {
  const DriverLicensePage({super.key});

  @override
  State<DriverLicensePage> createState() => _DriverLicensePageState();
}

class _DriverLicensePageState extends State<DriverLicensePage> {
  String loanType = 'Personal';
  String ageText = '';
  String resultText = '';

  void validateDriverLicense() {
    final age = double.tryParse(ageText.replaceAll(',', '.')) ?? 0.0;

    if (age <= 0) {
      setState(() {
        resultText = 'Ingrese una edad válida';
      });
      return;
    }

    if (age < 18 || age > 70) {
      resultText = 'No puede solicitar una licencia de conducir';
    } else {
      resultText = 'Puede solicitar una licencia de conducir';
    }
    setState(() {
      resultText = resultText;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Simulador de licencia de conducir'),
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
              'Validación de edad para acceder a licencia de conducir',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            TextField(
              decoration: const InputDecoration(
                labelText: 'Edad',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (value) {
                ageText = value;
              },
            ),

            const SizedBox(height: 16),
            ElevatedButton(
              onPressed: validateDriverLicense,
              child: const Text('Validar licencia'),
            ),

            const SizedBox(height: 16),
            Text(resultText),
          ],
        ),
      ),
    );
  }
}
