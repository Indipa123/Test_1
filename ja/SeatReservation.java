import java.util.Scanner;


public class SeatReservation {
    public static void main(String[]args){

        char[][]seats = new char[5][8];
        Scanner scanner = new Scanner(System.in);


        // Initialize seat array with '-'

        for (int i=0; i<5; i++){
            for(int j=0; j<8; j++){
                seats[i][j] = '-';
            }
        }

        while (true) {
            System.out.println("Current seating arrangement:");

            for (int i=0; i<5; i++){

                for (int j=0; j<8; j++){
                    System.out.print(seats[i][j] + " ");
                }

                System.out.println();

            }


        System.out.print("Enter seat number(row and colomn, e.g., 1 3):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if(row<0 || row>=5 || col<0 || col>=8){
            System.out.println("Invalid seat number.Try again.");
            continue;
        }

        if(seats[row][col] == 'X'){
            System.out.println("Seat already reserved.OK.");
        }else{
            seats[row][col] = 'X';
            System.out.println("Seat successfully reserved.");
        }
    }
}
}