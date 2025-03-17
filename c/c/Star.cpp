#include <iostream>
using namespace std;

void printDiamond(int n) {
    // Print upper half of the diamond
    for (int i = 1; i <= n; i++) {
        // Print leading spaces
        for (int j = i; j < n; j++) {
            cout << " ";
        }
        // Print stars
        for (int j = 1; j <= (2 * i - 1); j++) {
            cout << "*";
        }
        cout << endl;
    }

    // Print lower half of the diamond
    for (int i = n - 1; i >= 1; i--) {
        // Print leading spaces
        for (int j = n; j > i; j--) {
            cout << " ";
        }
        // Print stars
        for (int j = 1; j <= (2 * i - 1); j++) {
            cout << "*";
        }
        cout << endl;
    }
}

int main() {
    int n;
    cout << "Enter the number of rows for the diamond: ";
    cin >> n;

    printDiamond(n);

    return 0;
}

