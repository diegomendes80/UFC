#include <SPI.h>
#include <Adafruit_SPIFlash.h>

#define FLASH_CS 5  // Pino Chip Select (ajuste conforme a ligação)

Adafruit_FlashTransport_SPI flashTransport(FLASH_CS, SPI);
Adafruit_SPIFlash flash(&flashTransport);

void setup() {
  Serial.begin(9600);
  while (!Serial);

  Serial.println("Inicializando memória Flash W25Qxx...");
  if (!flash.begin()) {
    Serial.println("Falha ao detectar o chip Flash!");
    while (1);
  }
  Serial.println("Memória Flash inicializada com sucesso!");

  // Escrevendo um dado de teste
  const char texto[] = "Teste de escrita na memória Flash.";
  flash.eraseBlock(0);                 // Apaga o bloco 0 antes da escrita
  flash.writeBuffer(0, (void*)texto, sizeof(texto)); // Grava o texto no endereço 0
  Serial.println("Texto gravado na memória!");

  // Lendo o dado gravado
  char leitura[50];
  flash.readBuffer(0, leitura, sizeof(leitura)); // Lê o conteúdo do mesmo endereço
  Serial.print("Leitura da memória: ");
  Serial.println(leitura);
}

void loop() {
  // Nada a fazer no loop, o teste ocorre apenas uma vez
}
