#include <iostream>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
using namespace std;

void printArray(const int* arr, int size);
void sortArray(int* arr, int size);
void total(const int* arr, int size);
void minAndMax(const int* arr, int size);
void forkAndExecute(void (*task)(int*, int), int* arr, int size);

int main() {
    int myArray[] = {4, 3, 5, 2, 1};
    int size = sizeof(myArray) / sizeof(myArray[0]);

    // Each child gets a copy of the array to avoid shared memory issues
    forkAndExecute(printArray, myArray, size);
    forkAndExecute(sortArray, myArray, size);
    forkAndExecute(total, myArray, size);
    forkAndExecute(minAndMax, myArray, size);

    // Wait for all child processes to finish
    while (wait(NULL) > 0);

    return 0;
}

// Function to print the array
void printArray(const int* arr, int size) {
    cout << "Members of the array: ";
    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

// Function to sort the array
void sortArray(int* arr, int size) {
    // Create a local copy of the array to avoid modifying the original array
    int* tempArr = new int[size];
    for (int i = 0; i < size; i++) {
        tempArr[i] = arr[i];
    }

    for (int i = 0; i < size; i++) {
        int min = tempArr[i];
        int minIndex = i;
        for (int j = i + 1; j < size; j++) {
            if (tempArr[j] < min) {
                min = tempArr[j];
                minIndex = j;
            }
        }
        swap(tempArr[i], tempArr[minIndex]);
    }

    cout << "The array is sorted: ";
    printArray(tempArr, size);
    delete[] tempArr;
}

// Function to calculate the total of the array
void total(const int* arr, int size) {
    int sum = 0;
    for (int i = 0; i < size; i++) {
        sum += arr[i];
    }
    cout << "Sum of the array: " << sum << endl;
}

// Function to find the minimum and maximum of the array
void minAndMax(const int* arr, int size) {
    int min = arr[0];
    int max = arr[0];
    for (int i = 1; i < size; i++) {
        if (arr[i] < min) {
            min = arr[i];
        }
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    cout << "Minimum of the array: " << min << endl;
    cout << "Maximum of the array: " << max << endl;
}

// Function to fork a child process and execute a given task
void forkAndExecute(void (*task)(int*, int), int* arr, int size) {
    pid_t pid = fork();
    if (pid == -1) {
        cerr << "Fork failed!" << endl;
        exit(1);
    } else if (pid == 0) {
        // Create a local copy of the array in the child process
        int* localArray = new int[size];
        for (int i = 0; i < size; i++) {
            localArray[i] = arr[i];
        }

        task(localArray, size);
        delete[] localArray;
        exit(0);
    }
}

