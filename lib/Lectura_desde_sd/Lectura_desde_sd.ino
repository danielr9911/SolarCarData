#include <SPI.h>
#include <SD.h>

File myFile;

void setup() {
  Serial.begin(38400);
  //Serial.print("Initializing SD card...");

  if (!SD.begin(4)) {
    Serial.println("initialization failed!");
    return;
  }
  //Serial.println("initialization done.");
  // re-open the file for reading:
  myFile = SD.open("datos.txt");
  if (myFile) {
    //Serial.println("test.txt:");

    // read from the file until there's nothing else in it:
    while (myFile.available()) {
      Serial.write(myFile.read());
      delay(2);
    }
    // close the file:
    myFile.close();
  } else {
    // if the file didn't open, print an error:
    Serial.println("error opening datos.txt");
  }
}

void loop() {
  // nothing happens after setup
}

