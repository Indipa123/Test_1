#include <iostream>
using namespace std;

class Car {
public:
    // Attributes (Properties)
    string brand;
    string model;
    int year;
    int speed;
    bool isEngineOn;

    // Method to start the engine
    void startEngine() {
        if (!isEngineOn) {
            isEngineOn = true;
            cout << brand << " " << model << " engine started." << endl;
        } else {
            cout << "Engine is already running!" << endl;
        }
    }

    // Method to stop the engine
    void stopEngine() {
        if (isEngineOn) {
            isEngineOn = false;
            speed = 0; // Reset speed to 0
            cout << brand << " " << model << " engine stopped." << endl;
        } else {
            cout << "Engine is already off!" << endl;
        }
    }

    // Method to accelerate
    void accelerate(int increase) {
        if (isEngineOn) {
            speed += increase;
            cout << brand << " " << model << " accelerated to " << speed << " km/h." << endl;
        } else {
            cout << "Start the engine first!" << endl;
        }
    }

    // Method to brake
    void brake(int decrease) {
        if (speed > 0) {
            speed -= decrease;
            if (speed < 0) speed = 0; // Prevent negative speed
            cout << brand << " " << model << " slowed down to " << speed << " km/h." << endl;
        } else {
            cout << "The car is already stopped!" << endl;
        }
    }

    // Method to display car details
    void displayInfo() {
        cout << "Car Details: " << endl;
        cout << "Brand: " << brand << ", Year: " << year << endl;
        cout << "Current Speed: " << speed << " km/h, Engine: " << (isEngineOn ? "On" : "Off") << endl;
    }
};


int main() {
    // Create a Car object
    Car myCar;

    // Manually assigning values to attributes
    myCar.brand = "Toyota";
    myCar.year = 2022;
    myCar.speed = 0;
    myCar.isEngineOn = false;

    // Using methods
    myCar.displayInfo();
    myCar.startEngine();
    myCar.accelerate(30);
    myCar.brake(10);
    myCar.stopEngine();

    return 0;
}
