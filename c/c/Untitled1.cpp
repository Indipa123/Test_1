#include <iostream>

using namespace std;

string subString(string str, int first, int lenth);
int getInt(string str);
int getStringLength(string str);
int getPower(int base, int power);
int getMonthDays(int n);

int main() {
    string nic;
                                  
    cout << "Enter your NIC number: ";
    cin >> nic; 
    
    // Getting birth year
    string year = subString(nic, 0, 4);
    
    // Getting gender
    int number = getInt(subString(nic, 4, 3));
    string gender;
    
    if(number < 500) {
      gender = "Male";
    } else {
      gender = "Female";
      number -= 500;
    }
    
    // Getting month
    string months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    int days;
    string month;
    
    for(int i = 1; i <=12; i++) {
      if(getMonthDays(i) == number) {
        month = months[i-1];
        days = getMonthDays(i);
        break;
      } else if(getMonthDays(i) < number) {
        number -= getMonthDays(i);
      } else {
        month = months[i-1];
        days = number;
        break;
      }
    }
    
    cout << endl;
    cout << "You born on " << days << " " << month << ", " << year << "." << endl;
    cout << "You are a " << gender << "." << endl;
    
    return 0;
}

string subString(string str, int first, int lenth) {
  string sub = "";
  
  for(int i = first; i < first+lenth; i++) {
    sub += str[i];
  }
  
  return sub;
}

int getInt(string str) {
  int number = 0;
  int length = getStringLength(str);
  int place = getPower(10, length-1);
  
  for(int i = 0; i < length; i++) {
    number += (str[i] - '0') * place;
    place /= 10;
  }
  
  return number;
}

int getStringLength(string str) {
  int i;
  for(i = 0; str[i] != '\0'; i++) {
  }
  return i;
}

int getPower(int base, int power) {
  int result = 1;
  for(int i = 1; i <= power; i++) {
    result *= base;
  }
  return result;
}

int getMonthDays(int n) {
  switch(n) {
    case 4:
    case 6:
    case 9:
    case 11:
      return 30;
    
    case 2:
      return 29;
    
    default:
      return 31;
  }
}

