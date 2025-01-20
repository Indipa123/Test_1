#include <iostream>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <vector>
#include <algorithm>

using namespace std;







bool isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i * i <= n; ++i) {
        if (n % i == 0) return false;
    }
    return true;
}


void displayArray(int arr[], int size) {
    cout << "Array elements: ";
    for (int i = 0; i < size; ++i) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main() {
    int arr[10];
    int size = 10;

    
    cout << "Enter 10 integers: ";
    for (int i = 0; i < size; ++i) {
        cin >> arr[i];
    }

    pid_t pid;
    for (int i = 0; i < 8; ++i) {
        pid = fork();

        if (pid < 0) {
            cerr << "Fork failed!" << endl;
            return 1;
        } else if (pid == 0) 
            if (i == 0) { 
                cout << "Parent process (PID: " << getpid() << "): ";
                displayArray(arr, size);
            } else if (i == 1) { 
                int sum = 0;
                for (int j = 0; j < size; ++j) {
                    sum += arr[j];
                }
                cout << "1st child process: Sum of all numbers = " << sum << endl;
            } else if (i == 2) { 
                int sum = 0;
                for (int j = 0; j < size; ++j) {
                    if (arr[j] % 2 == 0) sum += arr[j];
                }
                cout << "2nd child process: Sum of even numbers = " << sum << endl;
            } else if (i == 3) { 
                int sum = 0;
                for (int j = 0; j < size; ++j) {
                    if (arr[j] % 2 != 0) sum += arr[j];
                }
                cout << "3rd child process: Sum of odd numbers = " << sum << endl;
            } else if (i == 4) { 
                int sum = 0;
                for (int j = 0; j < size; ++j) {
                    if (isPrime(arr[j])) sum += arr[j];
                }
                cout << "4th child process: Sum of prime numbers = " << sum << endl;
            } else if (i == 5) { 
                vector<int> sorted(arr, arr + size);
                sort(sorted.begin(), sorted.end());
                cout << "5th child process: Array in ascending order: ";
                for (int num : sorted) cout << num << " ";
                cout << endl;
            } else if (i == 6) { 
                int maxNum = arr[0];
                for (int j = 1; j < size; ++j) {
                    if (arr[j] > maxNum) maxNum = arr[j];
                }
                cout << "6th child process: Maximum number = " << maxNum << endl;
            } else if (i == 7) { 
                int search;
                cout << "Enter a number to search: ";
                cin >> search;
                bool found = false;
                for (int j = 0; j < size; ++j) {
                    if (arr[j] == search) {
                        found = true;
                        break;
                    }
                }
                cout << "7th child process: Number " << (found ? "found" : "not found") << " in the array." << endl;
            }
            exit(0);
        }
    }

    
    for (int i = 0; i < 8; ++i) {
        wait(NULL);
    }

    return 0;
}