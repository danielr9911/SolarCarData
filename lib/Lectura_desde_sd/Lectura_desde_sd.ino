void setup() {
  // put your setup code here, to run once:
  Serial.begin(38400);
}

void loop() {
  // put your main code here, to run repeatedly:
  Serial.println("a 123 456 NE 789");
  delay(500);
  Serial.println("p 987 654 321");
  delay(500);
  Serial.println("m 123 456 789");
  delay(500);
  Serial.println("b 789 456 123");
  delay(500);
  Serial.println("g 345 678");
  delay(500);
  Serial.println("a 321 654 SO 987");
  delay(500);
  Serial.println("p 789 456 123");
  delay(500);
  Serial.println("m 321 654 987");
  delay(500);
  Serial.println("b 987 654 321");
  delay(500);
  Serial.println("g 543 876");
  delay(500);
}
