#include <TinyGPS++.h>
#include <SoftwareSerial.h>
#include <SPI.h>
#include <MFRC522.h>
#include <ESP8266WiFi.h>
#include <FirebaseESP8266.h>

FirebaseData fbdo;
#define SS_PIN 15
#define RST_PIN 16
MFRC522 mfrc522(SS_PIN, RST_PIN);   // Create MFRC522 instance.

#define FIREBASE_HOST "assettracking-97875-default-rtdb.firebaseio.com" //Without http:// or https:// schemes
#define FIREBASE_AUTH "FOTUyx7n1F1qWrbKETgcpmUkgfba8zwXTGqeiqiA"
//#define WIFI_SSID "SOFTWARICA IOT EXPO 2021"
//#define WIFI_PASSWORD "coventry"
#define WIFI_SSID "aashikmajhi_2.4"
#define WIFI_PASSWORD "CLB35AF030"

TinyGPSPlus gps;  // The TinyGPS++ object
SoftwareSerial ss(4, 5);
float latitude , longitude;
String lat_str , lng_str;

void setup()
{
  Serial.begin(115200);   // Initiate a serial communication
  ss.begin(9600);
  SPI.begin();      // Initiate  SPI bus
  mfrc522.PCD_Init();   // Initiate MFRC522
  Serial.println("Approximate your card to the reader...");
  Serial.println();

  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Connecting to Wi-Fi");
  while (WiFi.status() != WL_CONNECTED)
  {
    Serial.print(".");
    delay(300);
  }
  Serial.println();
  Serial.print("Connected with IP: ");
  Serial.println(WiFi.localIP());
  Serial.println();

  Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
  Firebase.reconnectWiFi(true);


}
void loop()
{

  while (ss.available() > 0) //while data is available
    if (gps.encode(ss.read())) //read gps data
    {
      if (gps.location.isValid()) //check whether gps location is valid
      {
        latitude = gps.location.lat();
        lat_str = String(latitude , 6); // latitude location is stored in a string
        Serial.print("Lat");
        Serial.println(lat_str);
        Firebase.pushString(fbdo, "/GPS/latitude", lat_str);

        longitude = gps.location.lng();
        lng_str = String(longitude , 6); //longitude location is stored in a string
        Serial.print("Long");
        Serial.println(lng_str);
        Firebase.pushString(fbdo, "/GPS/longitude", lng_str);
      }
      delay(45000);
    }

  // Look for new cards
  if ( ! mfrc522.PICC_IsNewCardPresent())
  {
    return;
  }
  // Select one of the cards
  if ( ! mfrc522.PICC_ReadCardSerial())
  {
    return;
  }
  //Show UID on serial monitor
  Serial.print("UID tag :");
  String content = "";
  byte letter;
  for (byte i = 0; i < mfrc522.uid.size; i++)
  {
    Serial.print(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " ");
    Serial.print(mfrc522.uid.uidByte[i], HEX);
    content.concat(String(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " "));
    content.concat(String(mfrc522.uid.uidByte[i], HEX));
  }
  Serial.println();
//  Serial.print("Message : ");
  content.toUpperCase();
  if (content.substring(1) == "A9 E3 D7 73") //change here the UID of the card/cards that you want to give access
  {
    Firebase.pushString(fbdo, "/Stethoscope","Checked in to Operation Theatre-1");
    Serial.println("Stethoscope");
    Serial.println();
    delay(3000);
  }

  else   {
    Serial.println("Sphygmomanometer");
    Firebase.pushString(fbdo, "/Sphygmomanometer","Checked in to Operation Theatre-1");
    delay(3000);
  }
}
